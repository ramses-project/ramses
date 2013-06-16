package fr.tpt.aadl.ramses.generation.osek;

import java.util.Map;

import fr.tpt.aadl.ramses.transformation.atl.AadlToTargetSpecificAadl;

public class AadlOsekTransformation extends AadlToTargetSpecificAadl {

	
	public AadlOsekTransformation()
	{
		ATL_FILE_NAMES = new String[] 
				{
			"ACG/targets/shared/UninstanciateOverride",
 			"ACG/targets/shared/SubprogramCallsCommonRefinementSteps",
 			"ACG/targets/shared/PortsCommonRefinementSteps",
 			"ACG/targets/shared/DispatchCommonRefinementSteps",
 			"ACG/targets/shared/BehaviorAnnexCommonRefinementSteps",
			"ACG/targets/osek/ExpandThreadsPorts", 
			"ACG/targets/osek/ExpandThreadsDispatchProtocol",
			"ACG/targets/shared/PortsCommonRefinementSteps",
			"ACG/PeriodicDelayedCommunication/SharedRules"//,
			//"CreateThreadsBehavior" 
			};
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		throw new UnsupportedOperationException();
	}

}
