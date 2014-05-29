package fr.tpt.aadl.ramses.generation.pok;

import java.util.ArrayList;

import fr.tpt.aadl.ramses.control.atl.Aadl2ConstraintValidationEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class AadlArinc653Validation extends Aadl2ConstraintValidationEMFTVMLauncher {

	public AadlArinc653Validation(AadlModelInstantiatior modelInstantiator,
			                          PredefinedAadlModelManager predefinedResourcesManager)
  {
		super(modelInstantiator, predefinedResourcesManager);
		ATL_FILE_NAMES = new ArrayList<String>();
		ATL_FILE_NAMES.add("helpers/Services");
		ATL_FILE_NAMES.add("tools/PropertiesTools");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/Common");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/ThreadInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/ProcessInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/ProcessorInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/VirtualProcessorInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/MemoryInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/FeatureInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/Subprograms");
		ATL_FILE_NAMES.add("ACG/Constraints/arinc653/InterPartitionCommunications");
		ATL_FILE_NAMES.add("ACG/Constraints/arinc653/ArincProperties");
		ATL_FILE_NAMES.add("ACG/Constraints/pok/PokProperties");
	}
}