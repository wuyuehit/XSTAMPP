package xstampp.astpa.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import xstampp.astpa.Activator;
import xstampp.astpa.model.interfaces.ISeverityDataModel;
import xstampp.astpa.model.interfaces.ISeverityEntry;
import xstampp.astpa.model.interfaces.Severity;
import xstampp.model.IDataModel;
import xstampp.ui.common.contentassist.AutoCompleteField;
import xstampp.ui.common.contentassist.LinkProposal;
import xstampp.ui.common.grid.CellButton;

public class SeverityButton extends CellButton implements Listener, PaintListener {
  private ISeverityDataModel model;
  private ISeverityEntry entry;
  private Severity currentSeverity;
  private Control control;
  private static final Image hoveredImage = Activator
      .getImageDescriptor("/icons/buttons/dropDownCanvas.png").createImage();

  /**
   * 
   * @param entry
   * @param model
   * @param control
   *          the control which is updated every time the severity changes and used for placing the
   *          linking shell
   */
  public SeverityButton(ISeverityEntry entry, IDataModel model, Control control) {

    super(hoveredImage.getBounds(), hoveredImage);
    this.control = control;
    this.entry = entry;
    this.model = (ISeverityDataModel) model;
    setEntry(entry);
  }

  public void setEntry(ISeverityEntry entry) {
    if (entry != null) {
      this.entry = entry;
      currentSeverity = this.entry.getSeverity();
      setText(this.entry.getSeverity().toString());
      control.redraw();
    }
  }

  @Override
  public void onButtonDown(Point relativeMouse, Rectangle cellBounds) {
    LinkProposal[] proposals = new LinkProposal[4];
    for (int i = 0; i < Severity.values().length; i++) {
      proposals[i] = new LinkProposal();
      proposals[i].setDescription(Severity.values()[i].getDescription());
      proposals[i].setLabel(Severity.values()[i].toString());
      if (currentSeverity != null && currentSeverity.ordinal() == i) {
        proposals[i].setSelected(true);
      }
    }
    AutoCompleteField assist = new AutoCompleteField(proposals, control);
    assist.setPopupPosition(
        new Point(relativeMouse.x + cellBounds.x, relativeMouse.y + cellBounds.y));
    if (this.control.getDisplay() != null) {
      assist.setProposalListener(new IContentProposalListener() {

        @Override
        public void proposalAccepted(IContentProposal proposal) {
          Severity severity = Severity.valueOf(proposal.getLabel());
          if (severity != null) {
            currentSeverity = severity;
            model.setSeverity(entry, severity);
            setText(severity.toString());
            control.redraw();
          }
        }
      });
      assist.openPopup();
    } else {
      MessageDialog.openError(null, "Widget is disposed",
          "for some reason the Platform can't find a suficient display!");
    }
  }

  @Override
  public String getToolTip() {
    return "Press to edit the severity";
  }

  @Override
  public void handleEvent(Event e) {
    if(entry != null) {
      onButtonDown(new Point(e.x, e.y), new Rectangle(0, 0, e.width, e.height));
    }
  }

  @Override
  public void paintControl(PaintEvent e) {
    onPaint(e.gc, new Rectangle(e.x, e.y, e.width, e.height), entry != null);
  }
}
