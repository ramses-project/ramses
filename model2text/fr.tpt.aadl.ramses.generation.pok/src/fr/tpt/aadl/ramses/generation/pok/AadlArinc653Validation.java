package fr.tpt.aadl.ramses.generation.pok;

import fr.tpt.aadl.ramses.control.atl.Aadl2ConstraintValidationEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class AadlArinc653Validation extends Aadl2ConstraintValidationEMFTVMLauncher {

	public AadlArinc653Validation(AadlModelInstantiatior modelInstantiator,
			                          PredefinedAadlModelManager predefinedResourcesManager)
  {
		super(modelInstantiator, predefinedResourcesManager);
		ATL_FILE_NAMES = new String[]
		        {"helpers/Services",
				"tools/PropertiesTools",
		        "ACG/Constraints/shared/Common",
				"ACG/Constraints/shared/ThreadInstances",
				"ACG/Constraints/shared/ProcessInstances",
				"ACG/Constraints/shared/ProcessorInstances",
				"ACG/Constraints/shared/VirtualProcessorInstances",
				"ACG/Constraints/shared/FeatureInstances",
				"ACG/Constraints/shared/Subprograms",
				"ACG/Constraints/arinc653/InterPartitionCommunications",
				"ACG/Constraints/arinc653/ArincProperties"
		        };
	}
}