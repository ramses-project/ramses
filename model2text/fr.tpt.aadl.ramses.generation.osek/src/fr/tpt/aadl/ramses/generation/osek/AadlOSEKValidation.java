package fr.tpt.aadl.ramses.generation.osek;

import java.util.ArrayList;

import fr.tpt.aadl.ramses.control.atl.Aadl2ConstraintValidationEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class AadlOSEKValidation extends Aadl2ConstraintValidationEMFTVMLauncher {

  public AadlOSEKValidation(AadlModelInstantiatior modelInstantiator,
                            PredefinedAadlModelManager predefinedResourcesManager)
  {
    super(modelInstantiator, predefinedResourcesManager) ;
	ATL_FILE_NAMES = new ArrayList<String>();
	ATL_FILE_NAMES.add("helpers/Services");
	ATL_FILE_NAMES.add("tools/PropertiesTools");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/Common");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/DataInstances");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/ProcessInstances");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/ConnectionInstances");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/ProcessorInstances");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/VirtualProcessorInstances");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/ThreadInstances");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/FeatureInstances");
	ATL_FILE_NAMES.add("ACG/Constraints/shared/Subprograms");
	ATL_FILE_NAMES.add("ACG/Constraints/nxtOSEK/OsekProperties");
  }
}