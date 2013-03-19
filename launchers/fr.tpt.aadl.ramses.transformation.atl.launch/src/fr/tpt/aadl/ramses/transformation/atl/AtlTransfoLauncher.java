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

/*
 * author: Etienne Borde
 *
 */

package fr.tpt.aadl.ramses.transformation.atl ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertySet;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;

public abstract class AtlTransfoLauncher
{

  protected static File resourcesDir = null ;

  protected static final EMFInjector injector = new EMFInjector() ;
//  private static final EMFExtractor extractor = new EMFExtractor() ;

  // Load the input file resource
  private static final EMFModelFactory factory = new EMFModelFactory() ;
  protected static EMFReferenceModel aadlbaMetamodel ;


  /*
   * The parameters of the transformation: asm file, input and a-output path.
   */ 

  public static File getTransformationDirName()
  {
    return AtlTransfoLauncher.resourcesDir ;
  }

  protected abstract void initTransformation() throws ATLCoreException;
  
  public abstract Resource generationEntryPoint(Resource inputResource,
		  File resourceFilePath,
		  List<File> atlFiles,
		  File generatedFilePath) throws GenerationException;

  public abstract Resource doGeneration(Resource inputResource,
                               List<File> transformationFileName,
                               String dataTargetfilepath)
        throws FileNotFoundException, IOException, ATLCoreException, Exception;
  
  
  
  protected abstract Resource doTransformation(List<File> transformationFilepath, Resource inputResource,
		  String dataTargetfilepath)
        throws FileNotFoundException, IOException, ATLCoreException;

  
  
  protected void registerPredefinedResourcesInLauncher(EMFVMLauncher launcher)
  {
    for(Resource r: RamsesConfiguration.getPredefinedResourcesManager()
    		.getPredefinedResources())
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
  
  protected void setPredefinedResourcesDirectory(File dir)
                                              throws ATLCoreException, Exception
  {
	if(resourcesDir==null)
		this.initTransformation() ;
    AtlTransfoLauncher.resourcesDir = dir ;
  }
  
  protected void registerDefaultTransformations(List<Object> atlModules, EMFVMLauncher launcher) throws IOException{

	    URL moduleFile =
	    	new URL("file:" + resourcesDir.getAbsolutePath() + "/PeriodicDelayedCommunication/factoring/EventDataPorts" + ".asm") ;
	    Object loadedModule = launcher.loadModule(moduleFile.openStream()) ;
	    atlModules.add(loadedModule) ;
	    /**** � decommenter modeles differents ****/
	    
	    //URL moduleFile_LowMFP =
	    //    	new URL("file:" + resourcesDir.getAbsolutePath() + "/PeriodicDelayedCommunication/factoring/EventDataPorts_LowMFP" + ".asm") ;
	    //Object loadedModule_LowMFP = launcher.loadModule(moduleFile_LowMFP.openStream()) ;
	    //atlModules.add(loadedModule_LowMFP) ;

	    
	    URL moduleFileCommon =
	        	new URL("file:" + resourcesDir.getAbsolutePath() + "/targets/shared/CommonRefinementSteps" + ".asm") ;
	    Object loadedmoduleCommon = launcher.loadModule(moduleFileCommon.openStream()) ;
	    
	    
	    atlModules.add(loadedmoduleCommon) ;
		

	    URL libraryFile ;
	    List<String> fileName = new ArrayList<String>() ;
	    fileName.add("/helpers/IOHelpers") ;
	    fileName.add("/helpers/AADLCopyHelpers") ;
	    fileName.add("/helpers/AADLICopyHelpers") ;
	    fileName.add("/tools/PropertiesTools") ;
	    fileName.add("/tools/PackagesTools") ;
	    fileName.add("/tools/FeaturesTools") ;
	    fileName.add("/tools/BehaviorAnnexTools") ;
	    fileName.add("/uninstanciate/Features") ;
	    fileName.add("/uninstanciate/Implementations") ;
	    fileName.add("/uninstanciate/NonInstanciated");
	    fileName.add("/uninstanciate/Properties") ;
	    fileName.add("/uninstanciate/Types") ;
	    fileName.add("/helpers/Services") ;
	    
	    for(String s : fileName)
	    {
	      libraryFile =
	            new URL("file:" + resourcesDir.getAbsolutePath() + s + ".asm") ;
	      Object loadedLibrary = launcher.loadModule(libraryFile.openStream()) ;
	      launcher.addLibrary(s, loadedLibrary) ;
	    }
	  
  }
}