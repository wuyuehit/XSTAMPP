package xstampp.astpa.ui.linkingSupport;

import java.util.List;

import xstampp.astpa.model.DataModelController;
import xstampp.astpa.model.interfaces.ITableModel;
import xstampp.model.ObserverValue;

public class Step2ConstraintsLinkSupport extends LinkSupport<DataModelController> {

  public Step2ConstraintsLinkSupport(DataModelController dataInterface, ObserverValue type) {
    super(dataInterface, type);
  }

  @Override
  protected List<ITableModel> getModels() {
    return getDataInterface().getCausalFactorController().getSafetyConstraints();
  }

  @Override
  protected String getLiteral() {
    return "S2.";
  }

  @Override
  public String getTitle() {
    return "Causal Safety Constraint Links";
  }

}
