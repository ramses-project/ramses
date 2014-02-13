package fr.tpt.aadl.ramses.generation.pok;

import org.eclipse.m2m.atl.core.ATLCoreException;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager;
import fr.tpt.aadl.ramses.transformation.atl.Aadl2ConstraintValidationEMFTVMLauncher;

public class AadlArinc653Validation extends Aadl2ConstraintValidationEMFTVMLauncher {

	public AadlArinc653Validation(AadlModelInstantiatior modelInstantiator,
			PredefinedAadlModelManager predefinedResourcesManager)
			throws ATLCoreException {
		super(modelInstantiator, predefinedResourcesManager);
		ATL_FILE_NAMES = new String[]
		        {"ACG/Constraints/shared/Common",
				"ACG/Constraints/shared/ProcessInstances",
				"ACG/Constraints/shared/ThreadInstances"
		        };
	}


}
