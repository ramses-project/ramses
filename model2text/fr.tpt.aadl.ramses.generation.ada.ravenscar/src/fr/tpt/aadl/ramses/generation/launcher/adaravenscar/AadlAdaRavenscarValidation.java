/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.generation.launcher.adaravenscar;

import java.util.ArrayList;

import fr.tpt.aadl.ramses.control.atl.Aadl2ConstraintValidationEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class AadlAdaRavenscarValidation extends Aadl2ConstraintValidationEMFTVMLauncher {

	public AadlAdaRavenscarValidation(AadlModelInstantiatior modelInstantiator,
			PredefinedAadlModelManager predefinedResourcesManager)
	{
		super(modelInstantiator, predefinedResourcesManager);
		ATL_FILE_NAMES = new ArrayList<String>();
		ATL_FILE_NAMES.add("helpers/Services");
		ATL_FILE_NAMES.add("tools/PropertiesTools");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/Common");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/ProcessInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/ProcessorInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/VirtualProcessorInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/ThreadInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/FeatureInstances");
		ATL_FILE_NAMES.add("ACG/Constraints/shared/Subprograms");
	}

}
