package xstampp.astpa.model.linking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import xstampp.model.ObserverValue;

public class LinkController extends Observable {

  @XmlElement
  @XmlJavaTypeAdapter(Adapter.class)
  private Map<ObserverValue, List<Link>> linkMap;

  public LinkController() {
    this.linkMap = new HashMap<>();
  }

  public boolean addLink(ObserverValue linkType, UUID a, UUID b) {
    if (linkType != null) {
      if (!this.linkMap.containsKey(linkType)) {
        this.linkMap.put(linkType, new ArrayList<Link>());
      }
      Link o = new Link(a, b);
      if (this.linkMap.get(linkType).add(o)) {
        setChanged();
        notifyObservers(new UndoAddLinkingCallback(this, linkType, o));

        return true;
      }
    }
    return false;
  }

  /**
   * this method returns a list of all UUID links stored under the given {@link ObserverValue}. If
   * <b>null</b> is given as linkType than the returned list is filled with all linked ids.
   * 
   * @param linkType
   *          an {@link ObserverValue} for which links have been created in the
   *          {@link LinkController}
   * @param part
   *          the ID of the part for which all available links are returned
   * @return a {@link List} of {@link UUID}'s of all linked items, or an empty {@link List} if part
   *         is given as <b>null</b>
   */
  public List<UUID> getLinksFor(ObserverValue linkType, UUID part) {
    List<UUID> links = new ArrayList<>();
    if (linkType == null) {
      for (ObserverValue value : this.linkMap.keySet()) {
        links.addAll(getLinksFor(value, part));
      }
    } else if (this.linkMap.containsKey(linkType)) {
      for (Link link : this.linkMap.get(linkType)) {
        if (link.links(part)) {
          links.add(link.getLinkFor(part));
        }
      }
    }
    return links;
  }

  public Map<UUID, UUID> getLinksFor(ObserverValue linkType) {
    Map<UUID, UUID> links = new HashMap<>();
    if (this.linkMap.containsKey(linkType)) {
      for (Link link : this.linkMap.get(linkType)) {
        links.put(link.getLinkA(), link.getLinkB());
      }
    }
    return links;
  }

  /**
   * 
   * @param linkType the {@link ObserverValue} of the link
   * @param part the id of the element 
   * @return whether the {@link LinkController} contains a link for the given id or not
   */
  public boolean isLinked(ObserverValue linkType, UUID part) {
    if (this.linkMap.containsKey(linkType)) {
      for (Link link : this.linkMap.get(linkType)) {
        if (link.links(part)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean deleteLink(ObserverValue linkType, UUID a, UUID b) {
    if (this.linkMap.containsKey(linkType)) {
      Link o = new Link(a, b);
      if (this.linkMap.get(linkType).remove(o)) {
        setChanged();
        notifyObservers(new UndoRemoveLinkingCallback(this, linkType, o));
        return true;
      }
    }
    return false;
  }

  public void deleteAllFor(ObserverValue linkType, UUID part) {
    List<Link> links = new ArrayList<>();
    if (this.linkMap.containsKey(linkType)) {
      for (Link link : this.linkMap.get(linkType)) {
        if (link.links(part)) {
          links.add(link);
        }
      }
      deleteLinks(linkType, links);
    }
  }

  void deleteLinks(ObserverValue linkType, List<Link> links) {
    if (this.linkMap.containsKey(linkType)) {
      this.linkMap.get(linkType).removeAll(links);
    }
    setChanged();
    notifyObservers(new UndoRemoveLinkingCallback(this, linkType, links));
  }

  void addLinks(ObserverValue linkType, List<Link> links) {
    if (this.linkMap.containsKey(linkType)) {
      this.linkMap.get(linkType).addAll(links);
    }
    setChanged();
    notifyObservers(new UndoAddLinkingCallback(this, linkType, links));
  }
}
