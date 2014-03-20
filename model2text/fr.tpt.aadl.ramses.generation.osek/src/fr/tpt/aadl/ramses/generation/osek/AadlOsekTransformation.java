package fr.tpt.aadl.ramses.generation.osek;

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
	  _atlFileNames = new String[] 
				{
			"ACG/targets/shared/UninstanciateOverride",
 			"ACG/targets/shared/SubprogramCallsCommonRefinementSteps",
 			"ACG/targets/shared/PortsCommonRefinementSteps",
 			"ACG/targets/shared/DispatchCommonRefinementSteps",
 			"ACG/targets/shared/BehaviorAnnexCommonRefinementSteps",
 			"ACG/targets/osek/ExpandThreadsPorts", 
 			"ACG/targets/osek/BlackboardCommunications",
 			"ACG/targets/osek/BufferCommunications",
			"ACG/targets/osek/ExpandThreadsDispatchProtocol",
			"ACG/PeriodicDelayedCommunication/SharedRules",
			module
			};
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
	  String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
	}
}