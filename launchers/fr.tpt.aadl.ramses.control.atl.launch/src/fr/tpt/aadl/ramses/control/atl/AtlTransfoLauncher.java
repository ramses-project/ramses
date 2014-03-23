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

package fr.tpt.aadl.ramses.control.atl ;

import java.util.List ;

import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.core.emf.EMFInjector ;
import org.eclipse.m2m.atl.core.emf.EMFModel ;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory ;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.PropertySet ;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.util.InstanceResourceFactoryImpl;
import org.osate.ba.aadlba.AadlBaPackage;

import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage;

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
  protected static final ExecEnvPool pool =  new ExecEnvPool();

  // Load the input file resource
  private static final EMFModelFactory factory = new EMFModelFactory() ;
  protected static EMFReferenceModel aadlbaMetamodel ;
  
  private static final String AADLBA_MM_URI =
			org.osate.ba.aadlba.AadlBaPackage.eNS_URI ;
  private static final String AADL2_MM_URI =
			org.osate.aadl2.Aadl2Package.eNS_URI ;
  private static final String AADLI_MM_URI =
			org.osate.aadl2.instance.InstancePackage.eNS_URI ;
  private static final String ATLHOOKS_MM_URI = AtlHooksPackage.eNS_URI ;
	
  private static final String ERROR_REPORTER_URI = 
			"http://fr.tpt.aadl.ramses.constraints.vilation.reporter";
  
  private static boolean initialized=false;
  
  public static void initTransformation()
  {
	  if(initialized)
		  return;
	  initialized = true;
	  EPackage.Registry.INSTANCE.put(AADL2_MM_URI,
				org.osate.aadl2.Aadl2Package.eINSTANCE) ;
		EPackage.Registry.INSTANCE.put(ATLHOOKS_MM_URI, AtlHooksPackage.eINSTANCE) ;
		EPackage.Registry.INSTANCE.put(AADLBA_MM_URI, AadlBaPackage.eINSTANCE) ;
		EPackage.Registry.INSTANCE.put(AADLI_MM_URI, InstancePackage.eINSTANCE) ;
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/emf/2002/Ecore",
				EcorePackage.eINSTANCE) ;
		EPackage.Registry.INSTANCE.put(org.eclipse.m2m.atl.emftvm.EmftvmPackage.eNS_URI,
				org.eclipse.m2m.atl.emftvm.EmftvmPackage.eINSTANCE) ;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("aaxl2", new InstanceResourceFactoryImpl()) ;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("ecore", new EcoreResourceFactoryImpl()) ;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("emftvm", new EMFTVMResourceFactoryImpl()) ;
		
		
		// Load metamodels
	    // Load aadl instance metamodel 
	    Metamodel aadlInstanceMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
	    aadlInstanceMetaModel.setResource(InstancePackage.eINSTANCE.eResource());
	    AtlTransfoLauncher.pool.registerMetaModel("AADLI", aadlInstanceMetaModel);

	    // Load aadl+BA metamodel
	    Metamodel aadlBaMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
	    aadlBaMetaModel.setResource(AadlBaPackage.eINSTANCE.eResource());
	    AtlTransfoLauncher.pool.registerMetaModel("AADLBA", aadlBaMetaModel);

	    // Load atlHooks metamodel
	    Metamodel atlHoolsMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
	    atlHoolsMetaModel.setResource(AtlHooksPackage.eINSTANCE.eResource());
	    AtlTransfoLauncher.pool.registerMetaModel("ATLHOOKS", atlHoolsMetaModel);

		
		
		EPackage.Registry.INSTANCE.put(ERROR_REPORTER_URI, 
				fr.tpt.aadl.ramses.constraintsreporter.reporterPackage.eINSTANCE);
		
		// Load metamodels
		// Load aadl instance metamodel 
		Metamodel constraintValidationMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
		constraintValidationMetamodel.setResource(
				fr.tpt.aadl.ramses.constraintsreporter.reporterPackage.eINSTANCE.eResource());
		AtlTransfoLauncher.pool.registerMetaModel("CV", constraintValidationMetamodel);
  }
  
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