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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.pluginsupport.PluginSupportUtil;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPackagesManager;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPropertiesManager;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksFactory;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage;
import fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess;

public class AtlTransfoLauncher
{

  private static File resourcesDir = null ;

  private static AtlTransfoLauncher launched = null ;

  private static final EMFInjector injector = new EMFInjector() ;
  private static final EMFExtractor extractor = new EMFExtractor() ;

  // Load the input file resource
  private static final EMFModelFactory factory = new EMFModelFactory() ;
  private static EMFReferenceModel aadlMetamodel ;
  private static EMFReferenceModel aadlbaMetamodel ;
  private static EMFReferenceModel aadliMetamodel ;
  private static EMFReferenceModel ATLHookMetamodel ;

  private List<File> transformationFilepath ;

  private static final String AADLBA_MM_URI =
        fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage.eNS_URI ;
  private static final String AADL2_MM_URI =
        org.osate.aadl2.Aadl2Package.eNS_URI ;
  private static final String AADLI_MM_URI =
        org.osate.aadl2.instance.InstancePackage.eNS_URI ;
  private static final String ATLHOOKS_MM_URI = AtlHooksPackage.eNS_URI ;

  /*
   * The parameters of the transformation: asm file, input and a-output path.
   */
  private static PredefinedPackagesManager predefinedPackagesManager ;
  private static PredefinedPropertiesManager predefinedPropertiesManager; 

  public AtlTransfoLauncher()
        throws Exception
  {
    launched = this ;
  }

  public static AtlTransfoLauncher getInstance()
  {
    return launched ;
  }

  public static File getTransformationDirName()
  {
    return AtlTransfoLauncher.resourcesDir ;
  }

  private void initTransformation(File transformationDir)
        throws ATLCoreException
  {
    EPackage.Registry.INSTANCE.put(AADL2_MM_URI,
                                   org.osate.aadl2.Aadl2Package.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put(ATLHOOKS_MM_URI, AtlHooksPackage.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put(AADLBA_MM_URI, AadlBaPackage.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put(AADLI_MM_URI, InstancePackage.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put("http://www.eclipse.org/emf/2002/Ecore",
                                   EcorePackage.eINSTANCE) ;
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
          .put("aaxl2", new Aadl2ResourceFactoryImpl()) ;
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
          .put("ecore", new EcoreResourceFactoryImpl()) ;
    // Initialize the aadl metamodel
    aadlMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(aadlMetamodel, AADL2_MM_URI) ;
    aadlbaMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(aadlbaMetamodel, AADLBA_MM_URI) ;
    aadliMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(aadliMetamodel, AADLI_MM_URI) ;
    ATLHookMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(ATLHookMetamodel, ATLHOOKS_MM_URI) ;
  }
  
  public Resource generationEntryPoint(Resource inputResource,
		  File resourceFilePath,
		  List<File> atlFiles,
		  File generatedFilePath) throws GenerationException
  {
	  try {

		  this.setResourcesDirectory(resourceFilePath);

		  String workspaceURI = inputResource.getURI().toString();
		  if(workspaceURI.startsWith("platform:/resource"))
		    	workspaceURI = workspaceURI.substring(18);
		  
		  String aadlGeneratedFileName = inputResource.getURI().lastSegment();
		  aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
				  ".aaxl2", "_extended.aadl2");

		  Resource expandedResult = this.doGeneration(inputResource,
				  atlFiles, aadlGeneratedFileName);
		  
		  File outputModelDir =  new File(generatedFilePath.getAbsolutePath()+"/refined-models");
		  if(outputModelDir.exists()==false)
			  outputModelDir.mkdir();
		  StandAloneInstantiator instantiator = StandAloneInstantiator
				  .getInstantiator();
		  String outputFilePath=outputModelDir.getAbsolutePath()+"/"+aadlGeneratedFileName;
		  instantiator.serialize(expandedResult, outputFilePath);

		  File outputFile = new File(outputFilePath);
		  URI uri = URI.createFileURI(outputFile.getAbsolutePath().toString()) ;
		  SystemInstance si = (SystemInstance) inputResource.getContents().get(0);
		  Resource xtextResource = si.getSystemImplementation().eResource().getResourceSet().getResource(uri, true) ;
		  return xtextResource;
	  } catch (Exception e) {
		  e.printStackTrace();
		  throw new GenerationException(e.getMessage());
	  }
  }

  public Resource doGeneration(Resource inputResource,
                               List<File> transformationFileName,
                               String dataTargetfilepath)
        throws FileNotFoundException, IOException, ATLCoreException, Exception
  {
    
    if(AtlTransfoLauncher.resourcesDir == null)
      throw new Exception(
            "Illegal initialization of ATL transformation launcher: "
                  + "directory containing .asm files is undefined") ;

    this.transformationFilepath = transformationFileName ;


    return doTransformation(inputResource, dataTargetfilepath) ;

  }
  
  private Resource doTransformation(Resource inputResource,
		  String dataTargetfilepath)
        throws FileNotFoundException, IOException, ATLCoreException
  {
    boolean workingWithInstances =
          (inputResource.getContents().get(0) instanceof SystemInstance) ;
    
    List<Object> atlModules = new ArrayList<Object>() ;
    // Initialize the ATL launcher
    EMFVMLauncher launcher = new EMFVMLauncher() ;
    launcher.initialize(Collections.<String, Object> emptyMap()) ;
    // Create the ATL-EMF source and target models
    EMFModel sourceModel ;

    if(workingWithInstances)
    {
      sourceModel = (EMFModel) factory.newModel(aadliMetamodel) ;
    }
    else
    {
      sourceModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
    }

    injector.inject(sourceModel, inputResource) ;
    EMFModel targetModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
    ResourceSet rs =
          StandAloneInstantiator.getInstantiator().getAadlResourceSet() ;
    
    Resource outputResource =
          rs.createResource(URI.createURI(dataTargetfilepath)) ;
    
    injector.inject(targetModel, outputResource) ;
    // create ATLHook
    EMFModel atlHookModel = (EMFModel) factory.newModel(ATLHookMetamodel) ;
    URI fileURI =
          URI.createFileURI(AtlTransfoLauncher.resourcesDir.getAbsolutePath() +
                "/ATLHook.atlhooks") ;
    ResourceSet set = new ResourceSetImpl() ;
    Resource hookResource = set.createResource(fileURI) ;
    HookAccess atlHook = AtlHooksFactory.eINSTANCE.createHookAccess() ;
    hookResource.getContents().add(atlHook) ;
    hookResource.load(null) ;
    injector.inject(atlHookModel, hookResource) ;
    
    // Launch the ATL transformation
    if(workingWithInstances)
    {
      launcher.addInModel(sourceModel, "IN", "AADLI") ;
    }
    else
    {
      launcher.addInModel(sourceModel, "IN", "AADLBA") ;
    }

    launcher.addInModel(atlHookModel, "HOOKS", "ATLHOOKS") ;
    if(Platform.isRunning())
    {
    	registerContributedAadl(launcher);
    }
    else
    {
    	registerPredefinedPackagesInLauncher(launcher) ;
        registerPredefinedPropertiesInLauncher(launcher) ;
    }
    launcher.addOutModel(targetModel, "OUT", "AADLBA") ;

    if(workingWithInstances)
    {
      URL asmMainFile =
            new URL("file:" + resourcesDir.getAbsolutePath() +
                  "/Uninstanciate.asm") ;
      Object loadedMainModule = launcher.loadModule(asmMainFile.openStream()) ;
      atlModules.add(loadedMainModule) ;

      for(File f : transformationFilepath)
      {
        URL asmSuperImposeFile = new URL("file:" + f.toString()) ;
        Object loadedSuperImposeModule =
              launcher.loadModule(asmSuperImposeFile.openStream()) ;
        atlModules.add(loadedSuperImposeModule) ;
      }
    }
    else
    {
      URL asmSuperImposeFile =
            new URL("file:" + transformationFilepath.get(0).toString()) ;
      Object loadedSuperImposeModule =
            launcher.loadModule(asmSuperImposeFile.openStream()) ;
      atlModules.add(loadedSuperImposeModule) ;
    }
    

    URL moduleFile =
    	new URL("file:" + resourcesDir.getAbsolutePath() + "/PeriodicDelayedCommunication/EventDataPorts" + ".asm") ;
    Object loadedModule = launcher.loadModule(moduleFile.openStream()) ;
	atlModules.add(loadedModule) ;
    
    Map<String, Object> options = new HashMap<String, Object>() ;
    options.put("allowInterModelReferences", "true") ;
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

    launcher.launch(EMFVMLauncher.RUN_MODE, new NullProgressMonitor(), options,
                    atlModules.toArray()) ;

    // Save the resulting model
    if(System.getProperty("DEBUG")!=null)
    {
      String aadlGeneratedFileName = inputResource.getURI().path();
      if(aadlGeneratedFileName.startsWith("file:"))
    	aadlGeneratedFileName = aadlGeneratedFileName.substring("file:".length());
      else if (aadlGeneratedFileName.startsWith("platform:/resource"))
    	aadlGeneratedFileName = aadlGeneratedFileName.substring("platform:/resource".length());
	  aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
				  ".aaxl2", "_extended.aaxl2");
      if(targetModel.getResource() == null ||
          targetModel.getResource().getContents().isEmpty())
      {
        extractor.extract(sourceModel, aadlGeneratedFileName) ;
      }
      else
      {
        extractor.extract(targetModel, aadlGeneratedFileName) ;
      }
    }
    if(targetModel.getResource() == null ||
            targetModel.getResource().getContents().isEmpty())
    {
      return sourceModel.getResource() ;
    }
    else
    {
      return targetModel.getResource() ;
    }
  }

public DataSubcomponentType getRuntimeData(String dataName)
  {
    DataSubcomponentType result = null ;
    Resource aadlRuntime = predefinedPackagesManager.getRuntimeResource() ;

    for(EObject c : aadlRuntime.getContents())
    {
      if(c instanceof DataSubcomponentType)
      {
        result = (DataSubcomponentType) c ;

        if(result.getName() == dataName)
        {
          return result ;
        }
      }
    }

    return null ;
  }

  private void registerPredefinedPackagesInLauncher(EMFVMLauncher launcher)
  {
    for(int p = 0 ; p < predefinedPackagesManager.getPackagesCount() ; p++)
    {
      String name = predefinedPackagesManager.getPackageName(p) ;
      Resource r = predefinedPackagesManager.getPackageResource(name) ;
      EMFModel rModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
      injector.inject(rModel, r) ;
      launcher.addInModel(rModel, name.toUpperCase(), "AADLBA") ;
    }
  }

  
  private void registerPredefinedPropertiesInLauncher(EMFVMLauncher launcher)
  {
    for(int p = 0 ; p < predefinedPropertiesManager.getPropertiesCount() ; p++)
    {
      String name = predefinedPropertiesManager.getPropertySetName(p) ;
      Resource r = predefinedPropertiesManager.getPropertySetResource(name) ;
      EMFModel rModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
      injector.inject(rModel, r) ;
      launcher.addInModel(rModel, name.toUpperCase(), "AADLBA") ;
    }
  }
  
  private void registerContributedAadl(EMFVMLauncher launcher) {
	  List<URI> contributedResourceUriList = PluginSupportUtil.getContributedAadl();
	  ResourceSet resourceSet = new ResourceSetImpl();
	  for(URI contributedResourceUri : contributedResourceUriList)
	  {
		  
		  Resource resource = resourceSet.getResource(contributedResourceUri, true);
		  
		  EMFModel rModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
	      injector.inject(rModel, resource) ;
	      NamedElement elt=null;
	      if(resource.getContents().get(0) instanceof PropertySet)
	    	  elt = (PropertySet) resource.getContents().get(0);
	      else if (resource.getContents().get(0) instanceof AadlPackage)
	    	  elt = (AadlPackage) resource.getContents().get(0);
	      launcher.addInModel(rModel, elt.getName().toUpperCase(), "AADLBA") ;
		  
	  }
  }
  
  public void setResourcesDirectory(File resourcesDir)
                                              throws ATLCoreException, Exception
  {
    AtlTransfoLauncher.resourcesDir = resourcesDir ;
    if(!Platform.isRunning())
    {
    	predefinedPackagesManager =
    			new PredefinedPackagesManager(new File(resourcesDir
    					.getAbsolutePath() +
    					"/aadl_resources")) ;

    	if(!predefinedPackagesManager.allPackagesFound())
    		throw new Exception(
    				"Illegal initialization of ATL transformation launcher: " +
    						"some predefined packages not found: " +
    						predefinedPackagesManager.getPackagesNotFound()) ;

    	predefinedPropertiesManager = new PredefinedPropertiesManager();
    }
    this.initTransformation(resourcesDir) ;
  }
}