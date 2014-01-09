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

package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import fr.tpt.aadl.ramses.control.support.PredefinedResourcesAccess;

/**
 * This class is registers statically the predefined resources needed for RAMSES.
 */

public class ContributedAadlRegistration implements PredefinedResourcesAccess { 

  private static String[] predefinedPackagesNames =
	  {"Base_Types.aadl", "RAVENSCAR_runtime.aadl2", "OJR_runtime.aadl2" ,
	  "ARINC653_runtime.aadl2", "OSEK_runtime.aadl2", "PeriodicDelayed_runtime.aadl2",
	  "PeriodicDelayedMutex_runtime.aadl2"
	  } ;
  
  private static String[] predefinedPropertiesNames =
      {"AADL_Project.aadl", "Communication_Properties.aadl", "Data_Model.aadl", "Deployment_Properties.aadl",
       "Memory_Properties.aadl", "Modeling_Properties.aadl", "Programming_Properties.aadl",
       "Thread_Properties.aadl", "Timing_Properties.aadl", "Generation_Properties.aadl2",
       "pok_properties.aadl2", "oseknxt_properties.aadl2",
       "osek_properties.aadl2"
            } ;
  
  /**
   * @see fr.tpt.aadl.ramses.control.support.PredefinedResourcesAccess#setPredefinedResourcesDir(File)
   */
  @Override
  public void setPredefinedResourcesDir(File resourceDir) {
	// Do nothing
  }

  /**
   * @see fr.tpt.aadl.ramses.control.support.PredefinedResourcesAccess#getPredefinedResourcesDir()
   */
  @Override
  public List<Resource> getPredefinedResources() {	  
	List<Resource> result = new ArrayList<Resource>();
	for(int p = 0 ; p < predefinedPackagesNames.length ; p++)
	{
	  String name = predefinedPackagesNames[p] ;
	  URI uri = URI.createPlatformResourceURI(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME
			  +"/"+name, true);
	  result.add(OsateResourceUtil.getResource(uri));
	}
    for(int p = 0 ; p < predefinedPropertiesNames.length ; p++)
	{
      String name = predefinedPropertiesNames[p] ;
  	  URI uri = URI.createPlatformResourceURI(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME
  			  +"/"+name, true);
  	  result.add(OsateResourceUtil.getResource(uri));
	}
    return result;
  }

}
