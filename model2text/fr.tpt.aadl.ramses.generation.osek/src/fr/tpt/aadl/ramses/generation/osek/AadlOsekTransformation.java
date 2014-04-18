package fr.tpt.aadl.ramses.generation.osek;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.ramses.control.atl.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class AadlOsekTransformation extends AadlToTargetSpecificAadl {

  private static Logger _LOGGER = Logger.getLogger(AadlOsekTransformation.class) ;
  
	public AadlOsekTransformation(AadlModelInstantiatior modelInstantiator,
	                              PredefinedAadlModelManager predefinedAadlModels,
	                              String module)
	{
	  super(modelInstantiator, predefinedAadlModels) ;
	  _atlFileNames = new ArrayList<String>();
	  _atlFileNames.add("ACG/targets/shared/UninstanciateOverride");
	  _atlFileNames.add("ACG/targets/shared/SubprogramCallsCommonRefinementSteps");
	  _atlFileNames.add("ACG/targets/shared/PortsCommonRefinementSteps");
	  _atlFileNames.add("ACG/targets/shared/DispatchCommonRefinementSteps");
	  _atlFileNames.add("ACG/targets/shared/BehaviorAnnexCommonRefinementSteps");
	  _atlFileNames.add("ACG/targets/osek/ExpandThreadsPorts");
	  _atlFileNames.add("ACG/targets/osek/BlackboardCommunications");
	  _atlFileNames.add("ACG/targets/osek/BufferCommunications");
	  _atlFileNames.add("ACG/targets/osek/ExpandThreadsDispatchProtocol");
	  _atlFileNames.add("ACG/PeriodicDelayedCommunication/SharedRules");
	  _atlFileNames.add(module);
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
	  String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
	}
	
}