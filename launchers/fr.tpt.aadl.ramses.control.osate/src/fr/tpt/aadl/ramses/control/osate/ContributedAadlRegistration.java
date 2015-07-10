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

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties ;

import fr.tpt.aadl.ramses.control.support.instantiation.AbstractPredefinedAadlModelManager ;

/**
 * This class is registers statically the predefined resources needed for RAMSES.
 */

public class ContributedAadlRegistration extends AbstractPredefinedAadlModelManager
{ 

  /**
   * @see fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager#setPredefinedResourcesDir(File)
   */
  @Override
  public void parsePredefinedAadlModels()
  {
    // Nothing to do. Predefined AADL models are parsed by xtext. They are located in the
    // "plugin resources" directory.
  }

  /**
   * @see fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager#getPredefinedAadlResourceDir()
   */
  @Override
  public List<Resource> getPredefinedResources() {	  
	List<Resource> result = new ArrayList<Resource>();
	for(int p = 0 ; p < predefinedPackagesNames.length ; p++)
	{
	  String name = predefinedPackagesNames[p] ;
	  URI uri = URI.createPlatformResourceURI(PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME
			  +"/"+name, true);
	  result.add(OsateResourceUtil.getResource(uri));
	}
    for(int p = 0 ; p < predefinedPropertiesNames.length ; p++)
	{
      String name = predefinedPropertiesNames[p] ;
  	  URI uri = URI.createPlatformResourceURI(PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME
  			  +"/"+name, true);
  	  result.add(OsateResourceUtil.getResource(uri));
	}
    return result;
  }
}