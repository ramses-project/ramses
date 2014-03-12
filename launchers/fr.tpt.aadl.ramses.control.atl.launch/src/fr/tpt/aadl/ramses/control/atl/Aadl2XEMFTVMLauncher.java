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

package fr.tpt.aadl.ramses.control.atl ;

import java.io.File ;
import java.io.IOException ;
import java.io.InputStream ;
import java.net.URL ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Iterator ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.EPackage ;
import org.eclipse.emf.ecore.EcorePackage ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory ;
import org.eclipse.m2m.atl.emftvm.ExecEnv ;
import org.eclipse.m2m.atl.emftvm.Metamodel ;
import org.eclipse.m2m.atl.emftvm.Model ;
import org.eclipse.m2m.atl.emftvm.Module ;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl ;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl ;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException ;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver ;
import org.eclipse.m2m.atl.emftvm.util.TimingData ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.PropertySet ;
import org.osate.aadl2.instance.InstancePackage ;
import org.osate.aadl2.instance.util.InstanceResourceFactoryImpl ;
import org.osate.ba.aadlba.AadlBaPackage ;

import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksFactory ;
import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage ;
import fr.tpt.aadl.ramses.control.atl.hooks.HookAccess ;
import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;


public abstract class Aadl2XEMFTVMLauncher extends AtlTransfoLauncher
{
	protected AadlModelInstantiatior _modelInstantiator ;
  
	protected PredefinedAadlModelManager _predefinedResourcesManager ;

	protected ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

	protected static final String AADLBA_MM_URI =
			org.osate.ba.aadlba.AadlBaPackage.eNS_URI ;
	protected static final String AADL2_MM_URI =
			org.osate.aadl2.Aadl2Package.eNS_URI ;
	protected static final String AADLI_MM_URI =
			org.osate.aadl2.instance.InstancePackage.eNS_URI ;
	protected static final String ATLHOOKS_MM_URI = AtlHooksPackage.eNS_URI ;

	protected String outputPackageName = "";
	
	protected abstract void registerDefaultTransformationModules();
	
	private static Logger _LOGGER = Logger.getLogger(Aadl2XEMFTVMLauncher.class) ;
	
	ModuleResolver _moduleResolver = new ModuleResolver() {
		@Override
		public Module resolveModule(String module) throws ModuleNotFoundException {
			Resource moduleRes = new EMFTVMResourceImpl();
			try {
				String URLString = "file:" + module;
				if(false == URLString.endsWith(".emftvm"))
					URLString+=".emftvm";
				URL moduleURL = new URL(URLString) ;
				InputStream inputStream = moduleURL.openStream();
				try {
					moduleRes.load(inputStream, Collections.emptyMap());
				} finally {
					inputStream.close();
				}
				URI fileURI = URI.createFileURI(module +".emftvm");
				moduleRes.getContents().get(0).eResource().setURI(fileURI);
				return (Module) moduleRes.getContents().get(0);
			} catch (IOException e) {
				throw new ModuleNotFoundException(e);
			}
		}
	};
	
	public Aadl2XEMFTVMLauncher(AadlModelInstantiatior modelInstantiator,
	                            PredefinedAadlModelManager predefinedResourcesManager)
  {
    _modelInstantiator = modelInstantiator ;
    _predefinedResourcesManager = predefinedResourcesManager ;
    this.initTransformation() ;
  }
	
	public String getOutputPackageName() {
		return outputPackageName;
	}

	public void setOutputPackageName(String outputPackageName) {
		this.outputPackageName = outputPackageName;
	}

	protected void initTransformation()
	{
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
	}

	public Resource doTransformation(List<File> transformationFileList,
	                                 Resource inputResource,
			                             String outputDirPathName,
			                             String resourceSuffix) throws TransformationException
	{
		initTransformationInputs(transformationFileList, 
				inputResource);
		
		Resource outputResource = initTransformationOutput(inputResource, 
				outputDirPathName, resourceSuffix);
		
		registerDefaultTransformationModules(); // variable part of this template method.
		
		registerAdditionalTransformationsEMFTVM(transformationFileList, _moduleResolver);
		
		Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outputResource);
		env.registerInOutModel("OUT", outModel);
		
		// Run transformation
		TimingData td = new TimingData();
		td.finishLoading();
		env.run(td);
		td.finish();

		// Save the resulting model
		if(System.getProperty("DEBUG")!=null)
		{
			if(outModel.getResource() == null ||
					! outModel.getResource().getContents().isEmpty())
			{
				outModel.getResource().setURI(outputResource.getURI());
				try
				{
				  outModel.getResource().save(null);
				}
				catch(IOException ex)
				{
				  String errMsg =  RamsesException.formatRethrowMessage("cannot save the output AADL model", ex) ;
	        _LOGGER.error(errMsg);
	        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
				}
			}
		}
		
		return outModel.getResource();		
	}

	
	protected abstract Resource initTransformationOutput(Resource inputResource,
                                                       String outputDirPathName,
                                                       String resourceSuffix);
	
	
	protected void registerPredefinedResourcesInLauncher(ExecEnv env,
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
			Model rModel = EmftvmFactory.eINSTANCE.createModel();
			rModel.setResource(r);
			env.registerInputModel(name.toUpperCase(), rModel);
		}
	}

	protected void initTransformationInputs(List<File> transformationFileList,
			                                    Resource inputResource)
	                                                throws TransformationException
	{
    ResourceSet rs = inputResource.getResourceSet();

    // Load metamodels
    // Load aadl instance metamodel 
    Metamodel aadlInstanceMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
    aadlInstanceMetaModel.setResource(rs.getResource(URI.createURI(AADLI_MM_URI), true));
    env.registerMetaModel("AADLI", aadlInstanceMetaModel);

    // Load aadl+BA metamodel
    Metamodel aadlBaMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
    aadlBaMetaModel.setResource(rs.getResource(URI.createURI(AADLBA_MM_URI), true));
    env.registerMetaModel("AADLBA", aadlBaMetaModel);

    // Load atlHooks metamodel
    Metamodel atlHoolsMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
    atlHoolsMetaModel.setResource(rs.getResource(URI.createURI(ATLHOOKS_MM_URI), true));
    env.registerMetaModel("ATLHOOKS", atlHoolsMetaModel);

    // Load models
    Model inModel = EmftvmFactory.eINSTANCE.createModel();
    inModel.setResource(inputResource);
    env.registerInputModel("IN", inModel);

    List<Resource> registeredReferences = new ArrayList<Resource>();
    registeredReferences.add(inputResource);
    Iterator<EObject> iter = inputResource.getAllContents();
    while(iter.hasNext())
    {
      EObject obj = iter.next();
      for(EObject ref: obj.eCrossReferences())
      {
        Resource r = ref.eResource();
        if(r!=null && !registeredReferences.contains(r))
        {
          registeredReferences.add(r);
          Model referencedModel = EmftvmFactory.eINSTANCE.createModel();
          referencedModel.setResource(r);
          env.registerInputModel(r.getURI().lastSegment(), referencedModel);
        }
      }
    }

    // create and load predefined resources
    registerPredefinedResourcesInLauncher(env, _predefinedResourcesManager.getPredefinedResources());

    // create and load ATLHook
    URI fileURI =
        URI.createFileURI(RamsesConfiguration.getAtlResourceDir().getAbsolutePath() +
            "/ATLHook.atlhooks") ;
    ResourceSet set = new ResourceSetImpl() ;
    Resource hookResource = set.createResource(fileURI) ;
    HookAccess atlHook = AtlHooksFactory.eINSTANCE.createHookAccess() ;
    atlHook.setOutputPackageName(outputPackageName);
    hookResource.getContents().add(atlHook) ;
    
    try
    {
      hookResource.load(null) ;
    }
    catch(IOException e)
    {
      String msg = "fail to load ATL hook \'" + hookResource.getURI() + '\'' ;
      throw new TransformationException(msg, e) ;
    }

    Model atlHookModel = EmftvmFactory.eINSTANCE.createModel();
    atlHookModel.setResource(hookResource);
    env.registerInputModel("HOOKS", atlHookModel);
	}

	public void registerAdditionalTransformationsEMFTVM(List<File> transformationFileList,
			                                                ModuleResolver mr)
	{
		
		for(File f : transformationFileList)
		{
		  env.loadModule(mr, f.getAbsolutePath());
		}
	}
}