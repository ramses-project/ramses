/**
 * AADL-RAMSES
 * 
 * Copyright Â© 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.control.atl ;

import java.util.List;

import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.m2m.atl.core.ATLCoreException ;
import org.eclipse.m2m.atl.core.emf.EMFInjector ;
import org.eclipse.m2m.atl.core.emf.EMFModel ;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory ;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel ;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.PropertySet ;

/**
 * This abstract class specifies the methods and resources of an ATL
 * model transformation launcher which produces AADL models.
 */
public abstract class AtlTransfoLauncher
{
  /**
   * injector is an object for injecting objects to the ATL runtime. 
   */
  protected static final EMFInjector injector = new EMFInjector() ;
//  private static final EMFExtractor extractor = new EMFExtractor() ;

  // Load the input file resource
  private static final EMFModelFactory factory = new EMFModelFactory() ;
  protected static EMFReferenceModel aadlbaMetamodel ;
  
  protected abstract void initTransformation() throws ATLCoreException;
  
  protected void registerPredefinedResourcesInLauncher(EMFVMLauncher launcher,
                                                       List<Resource> predefinedAadlModels)
  {
    for(Resource r: predefinedAadlModels)
    {
      String name;
      EObject obj = r.getContents().get(0);
      if(obj instanceof PropertySet)
    	  name = ((PropertySet)obj).getName() ;
      else
    	name = ((AadlPackage)obj).getName() ;
      EMFModel rModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
      injector.inject(rModel, r) ;
      launcher.addInModel(rModel, name.toUpperCase(), "AADLBA") ;
    }
  }
}