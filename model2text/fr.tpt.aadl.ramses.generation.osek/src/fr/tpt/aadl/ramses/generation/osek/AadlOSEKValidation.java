package fr.tpt.aadl.ramses.generation.osek;

import org.eclipse.m2m.atl.core.ATLCoreException;

import fr.tpt.aadl.ramses.control.atl.Aadl2ConstraintValidationEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager;

public class AadlOSEKValidation extends Aadl2ConstraintValidationEMFTVMLauncher {

	public AadlOSEKValidation(AadlModelInstantiatior modelInstantiator,
			PredefinedAadlModelManager predefinedResourcesManager)
			throws ATLCoreException {
		super(modelInstantiator, predefinedResourcesManager);
		ATL_FILE_NAMES = new String[]
		        {"helpers/Services",
				"tools/PropertiesTools",
		        "ACG/Constraints/shared/Common",
				"ACG/Constraints/shared/ProcessInstances",
				"ACG/Constraints/shared/ProcessorInstances",
				"ACG/Constraints/shared/VirtualProcessorInstances",
				"ACG/Constraints/shared/ThreadInstances",
				"ACG/Constraints/shared/FeatureInstances",
				"ACG/Constraints/shared/Subprograms"
		        };
	}


}
