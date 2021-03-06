package xstampp.astpa.controlstructure.controller.commands;

import java.util.UUID;

import org.eclipse.draw2d.geometry.Point;

import xstampp.astpa.model.controlstructure.interfaces.IConnection;
import xstampp.astpa.model.interfaces.IControlStructureEditorDataModel;

/**
 * Move a link bendpoint. This class is declared final since it has a very specific functionality.
 * 
 * @author vainolo
 */
public final class ConnectionMoveBendpointCommand extends ControlStructureAbstractCommand {

  public ConnectionMoveBendpointCommand(UUID rootId, IControlStructureEditorDataModel model,
      String stepID) {
    super(rootId, model, stepID);
  }

  private Point oldLocation;
  private Point newLocation;
  private IConnection link;
  private int index;

  @Override
  public void execute() {
    getDataModel().getControlStructureController().changeBendPoint(link.getId(), oldLocation.x,
        oldLocation.y, newLocation.x, newLocation.y);
  }

  @Override
  public void undo() {
    getDataModel().getControlStructureController().changeBendPoint(link.getId(), newLocation.x,
        newLocation.y, oldLocation.x, oldLocation.y);
  }

  /**
   * Set the link where the bendpoint is located.
   * 
   * @param link
   *          the link where the bendpoint is located.
   */
  public void setLink(IConnection link) {
    this.link = link;
  }

  /**
   * Set the new location of the bendpoint.
   * 
   * @param newLocation
   *          the new location of the bendpoint.
   */
  public void setLocation(final Point newLocation) {
    this.newLocation = newLocation;
  }
  
  public void setIndex(int index) {
    this.index = index;
    this.oldLocation = link.getBendPoints().get(index);
  }
}