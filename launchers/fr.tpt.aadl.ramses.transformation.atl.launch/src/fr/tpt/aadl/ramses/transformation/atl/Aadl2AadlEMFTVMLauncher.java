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
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.util.InstanceResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ba.aadlba.AadlBaPackage ;

import fr.tpt.aadl.ramses.control.support.InstantiationManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksFactory;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage;
import fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess;


public class Aadl2AadlEMFTVMLauncher extends AtlTransfoLauncher
{

	private static final String AADLBA_MM_URI =
			org.osate.ba.aadlba.AadlBaPackage.eNS_URI ;
	private static final String AADL2_MM_URI =
			org.osate.aadl2.Aadl2Package.eNS_URI ;
	private static final String AADLI_MM_URI =
			org.osate.aadl2.instance.InstancePackage.eNS_URI ;
	private static final String ATLHOOKS_MM_URI = AtlHooksPackage.eNS_URI ;

	private String outputPackageName = "";
	
	public String getOutputPackageName() {
		return outputPackageName;
	}

	public void setOutputPackageName(String outputPackageName) {
		this.outputPackageName = outputPackageName;
	}

	public static File getTransformationDirName()
	{
		return Aadl2AadlEMFTVMLauncher.resourcesDir ;
	}

	protected void initTransformation()
			throws ATLCoreException
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

	public Resource generationEntryPoint(Resource inputResource,
			File resourceDir,
			List<File> transformationFileList,
			File outputDir) throws GenerationException
			{
		try {
			if(!Platform.isRunning())
			{
				RamsesConfiguration.getPredefinedResourcesManager()
				.setPredefinedResourcesDir(resourceDir);

			}
			setPredefinedResourcesDirectory(resourceDir);
			String aadlGeneratedFileName = inputResource.getURI().lastSegment();
			aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
					".aaxl2", "_extended.aadl2");

			Aadl2Util.setUseTunedEqualsMethods (false);
			Resource expandedResult;
			try
			{
				expandedResult = this.doTransformation(transformationFileList,
					inputResource, aadlGeneratedFileName);
			}
			finally
			{
				Aadl2Util.setUseTunedEqualsMethods (false);
			}

			File outputModelDir =  new File(outputDir.getAbsolutePath()+"/refined-models");
			if(outputModelDir.exists()==false)
				outputModelDir.mkdir();
			InstantiationManager instantiator = RamsesConfiguration.getInstantiationManager();
			String outputFilePath=outputModelDir.getAbsolutePath()+"/"+aadlGeneratedFileName;
			File outputFile = new File(outputFilePath);

			instantiator.serialize(expandedResult, outputFilePath);
			return AadlToTargetSpecificAadl.extractAadlResource(inputResource, outputFile);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new GenerationException(e.getMessage());
		}
			}

	public Resource doTransformation(List<File> transformationFileList, Resource inputResource,
			String outputDirPathName)
					throws FileNotFoundException, IOException, ATLCoreException, GenerationException
	{
		if(Aadl2AadlEMFTVMLauncher.resourcesDir == null)
			throw new GenerationException(
					"Illegal initialization of ATL transformation launcher: "
							+ "directory containing .emftvm files is undefined") ;
		
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
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
				if(!registeredReferences.contains(r))
				{
					registeredReferences.add(r);
					Model referencedModel = EmftvmFactory.eINSTANCE.createModel();
					referencedModel.setResource(r);
					env.registerInputModel(r.getURI().lastSegment(), referencedModel);
				}
			}
		}
		
		// create and load predefined resources
		registerPredefinedResourcesInLauncher(env);
		
		// create and load ATLHook
		URI fileURI =
				URI.createFileURI(Aadl2AadlEMFTVMLauncher.resourcesDir.getAbsolutePath() +
						"/ATLHook.atlhooks") ;
		ResourceSet set = new ResourceSetImpl() ;
		Resource hookResource = set.createResource(fileURI) ;
		HookAccess atlHook = AtlHooksFactory.eINSTANCE.createHookAccess() ;
		atlHook.setOutputPackageName(outputPackageName);
		hookResource.getContents().add(atlHook) ;
		hookResource.load(null) ;

		Model atlHookModel = EmftvmFactory.eINSTANCE.createModel();
		atlHookModel.setResource(hookResource);
		env.registerInputModel("HOOKS", atlHookModel);
		

		
		String aadlGeneratedFileName = inputResource.getURI().path();
		if(aadlGeneratedFileName.startsWith("file:"))
			aadlGeneratedFileName = aadlGeneratedFileName.substring("file:".length());
		else if (aadlGeneratedFileName.startsWith("platform:/resource"))
			aadlGeneratedFileName = aadlGeneratedFileName.substring("platform:/resource".length());
		aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
				".aaxl2", "_extended.aaxl2");
		URI uri = URI.createURI(aadlGeneratedFileName);
		Resource outputResource = rs.getResource(uri, false);
		if(outputResource==null)
		  outputResource = rs.createResource(uri);
		else
		{
		  outputResource.delete(null);
		  outputResource = rs.createResource(uri);
		}

		Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outputResource);
		env.registerInOutModel("OUT", outModel);

		ModuleResolver mr = new ModuleResolver() {
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

		
		env.loadModule(mr, resourcesDir.getAbsolutePath()+"/Uninstanciate");
		registerDefaultTransformationsEMFTVM(env, mr);
		for(File f : transformationFileList)
		{
			try
			{
				env.loadModule(mr, f.getAbsolutePath());
			}
			catch(VMException e)
			{
				System.out.println("ERROR when loading "+f.getAbsolutePath());
				e.printStackTrace();
			}
		}
		
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
				outModel.getResource().setURI(URI.createFileURI(aadlGeneratedFileName));
				outModel.getResource().save(null);
			}
		}
		// Return model
		return outModel.getResource();		

	}

	private void registerDefaultTransformationsEMFTVM(ExecEnv env,
			ModuleResolver mr)
	{
		List<String> fileName = new ArrayList<String>() ;
		fileName.add("/helpers/IOHelpers") ;
		fileName.add("/helpers/AADLCopyHelpers") ;
		fileName.add("/helpers/AADLICopyHelpers") ;
		fileName.add("/helpers/BehaviorAnnexServices") ;
		fileName.add("/tools/PropertiesTools") ;
		fileName.add("/tools/PackagesTools") ;
		fileName.add("/tools/FeaturesTools") ;
		fileName.add("/uninstanciate/Features") ;
		fileName.add("/uninstanciate/Implementations") ;
		fileName.add("/uninstanciate/Properties") ;
		fileName.add("/uninstanciate/Types") ;
		fileName.add("/uninstanciate/Connections") ;
		fileName.add("/helpers/Services") ;
		fileName.add("/tools/BehaviorAnnexTools") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorActionBlock") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorCondition") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorSpecification") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorTime") ;
		fileName.add("/BehaviorAnnexCopy/copyElementHolders") ;
		
		for(String s : fileName)
		{
			env.loadModule(mr, resourcesDir.getAbsolutePath()+s);
		}
		
	}

	protected void registerPredefinedResourcesInLauncher(ExecEnv env)
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
			Model rModel = EmftvmFactory.eINSTANCE.createModel();
			rModel.setResource(r);
			env.registerInputModel(name.toUpperCase(), rModel);
		}
	}

	public void setPredefinedResourcesDirectory(File dir)
			throws ATLCoreException, Exception
	{
		if(resourcesDir==null)
			this.initTransformation() ;
		Aadl2AadlEMFTVMLauncher.resourcesDir = dir ;
	}

	@Override
	protected void registerDefaultTransformations(List<Object> atlModules,
			EMFVMLauncher launcher) throws IOException
	{
		// TODO Auto-generated method stub
		
	}
}