package fr.tpt.aadl.ramses.generation.target.specific;

import java.util.ArrayList ;
import java.util.Map ;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.ramses.control.atl.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class WorkflowBasedTransformation extends AadlToTargetSpecificAadl
{

  private static Logger _LOGGER = Logger.getLogger(WorkflowBasedTransformation.class);
  
  public WorkflowBasedTransformation(AadlModelInstantiatior modelInstantiator,
                                     PredefinedAadlModelManager predefinedAadlModels)
  {
    super(modelInstantiator, predefinedAadlModels) ;
    _atlFileNames = new ArrayList<String>();
  }

  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException() ;
  }

}
