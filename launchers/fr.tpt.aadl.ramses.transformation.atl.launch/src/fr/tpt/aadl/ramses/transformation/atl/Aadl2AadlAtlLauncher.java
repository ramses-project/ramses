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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceResourceFactoryImpl;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexResolver;

import fr.tpt.aadl.annex.behavior.AadlBaParserAction;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.ramses.control.support.InstantiationManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksFactory;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage;
import fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess;


public class Aadl2AadlAtlLauncher extends AtlTransfoLauncher
{

	private static final EMFExtractor extractor = new EMFExtractor() ;

	private static final EMFModelFactory factory = new EMFModelFactory() ;
	private static EMFReferenceModel aadlMetamodel ;
	private static EMFReferenceModel aadliMetamodel ;
	private static EMFReferenceModel ATLHookMetamodel ;

	private static final String AADLBA_MM_URI =
			fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage.eNS_URI ;
	private static final String AADL2_MM_URI =
			org.osate.aadl2.Aadl2Package.eNS_URI ;
	private static final String AADLI_MM_URI =
			org.osate.aadl2.instance.InstancePackage.eNS_URI ;
	private static final String ATLHOOKS_MM_URI = AtlHooksPackage.eNS_URI ;

	
	public static File getTransformationDirName()
	{
		return Aadl2AadlAtlLauncher.resourcesDir ;
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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("aaxl2", new InstanceResourceFactoryImpl()) ;
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

			Resource expandedResult = this.doGeneration(inputResource,
					transformationFileList, aadlGeneratedFileName);

			File outputModelDir =  new File(outputDir.getAbsolutePath()+"/refined-models");
			if(outputModelDir.exists()==false)
				outputModelDir.mkdir();
			InstantiationManager instantiator = RamsesConfiguration.getInstantiationManager();
			String outputFilePath=outputModelDir.getAbsolutePath()+"/"+aadlGeneratedFileName;
			File outputFile = new File(outputFilePath);

			instantiator.serialize(expandedResult, outputFilePath);

			URI uri;
			SystemInstance si = (SystemInstance) inputResource.getContents().get(0);
			if(Platform.isRunning())
			{
				String workspaceLocation = ResourcesPlugin.getWorkspace()
						.getRoot().getLocationURI().getPath();
				int outputPathHeaderIndex = workspaceLocation.length();

				String outputAbsolutePath = outputFile.getAbsolutePath().toString();
				String outputPlatformRelativePath = "";
				if(outputPathHeaderIndex>0)
					outputPlatformRelativePath = outputAbsolutePath.substring(outputPathHeaderIndex);
				IResource rootMember=null;
				while(ResourcesPlugin.getWorkspace().getRoot().findMember(outputPlatformRelativePath)==null
						&& outputPlatformRelativePath.contains("/"))
				{
					if(rootMember==null)
					{
						String rootMemberPath = outputPlatformRelativePath.substring(0,outputPlatformRelativePath.indexOf("/"));
						rootMember = ResourcesPlugin.getWorkspace().getRoot().findMember(rootMemberPath);
						if(rootMember!=null)
							rootMember.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
					}
					outputPlatformRelativePath=outputPlatformRelativePath.substring(outputPlatformRelativePath.indexOf("/")+1);
				}

				uri = URI.createPlatformResourceURI(outputPlatformRelativePath, true) ;

				ResourceSet rs = OsateResourceUtil.getResourceSet();
				Resource xtextResource = rs.getResource(uri, true);

				URI inputURI = si.getSystemImplementation().eResource().getURI();
				IPath path = new Path(inputURI.toString().substring(18));
				File inputDir = new File (workspaceLocation+path.toOSString());
				RamsesConfiguration.setInputDirectory(inputDir.getParentFile());
				return xtextResource;
			}
			else
			{
				uri = URI.createFileURI(outputFile.getAbsolutePath().toString()) ;
				RamsesConfiguration.setInputDirectory(new File(si.getSystemImplementation().eResource().getURI().toFileString()).getParentFile());
				Resource xtextResource = si.getSystemImplementation().eResource().getResourceSet().getResource(uri, true) ;
				xtextResource.load(null);
				ServiceRegistry sr = ServiceRegistryProvider.getServiceRegistry();
				ParseErrorReporter errReporter = ServiceRegistry.PARSE_ERR_REPORTER ;
				AnalysisErrorReporterManager errManager = ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER;
				Iterator<EObject> iter = xtextResource.getAllContents();
				while(iter.hasNext())
				{
					Collection<Object> dasList = EcoreUtil.getObjectsByType(iter.next().eContents(), Aadl2Package.eINSTANCE.getDefaultAnnexSubclause()); 
					for (Object o : dasList)
					{
						DefaultAnnexSubclause das = (DefaultAnnexSubclause) o;
						String annexName = das.getName();
						if(annexName.equalsIgnoreCase(AadlBaParserAction.ANNEX_NAME))
						{
							AnnexParser ap = sr.getParser(annexName);
							ICompositeNode node = NodeModelUtils.findActualNodeFor(das);
							String annexText = das.getSourceText();
							if(annexText.length() > 6)
							{
								annexText = annexText.substring(3, annexText.length() - 3) ;
							}
							AnnexSubclause as = ap.parseAnnexSubclause(annexName,
									annexText, 
									outputFile.getName(), 
									node.getStartLine(), 
									node.getOffset(), 
									errReporter);
							AnnexResolver ar = sr.getResolver(annexName) ;
							if(as != null && errReporter.getNumErrors() == 0)
							{
								as.setName(annexName) ;
								// replace default annex library with the new one.
								EList<AnnexSubclause> ael =
										((Classifier) das.eContainer()).getOwnedAnnexSubclauses() ;
								int idx = ael.indexOf(das) ;
								ael.add(idx, as) ;
								ael.remove(das) ;
								List<AnnexSubclause> annexElements = Collections.singletonList(as) ;
								ar.resolveAnnex(das.getName(), annexElements, errManager) ;
							}
						}
					}
				}
				return xtextResource;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenerationException(e.getMessage());
		}
			}

	public Resource doGeneration(Resource inputResource,
			List<File> transformationFileList,
			String outputDirPathName)
					throws FileNotFoundException, IOException, ATLCoreException, Exception
					{

		if(Aadl2AadlAtlLauncher.resourcesDir == null)
			throw new Exception(
					"Illegal initialization of ATL transformation launcher: "
							+ "directory containing .asm files is undefined") ;

		//this.transformationFilepath = transformationFileName ;


		return doTransformation(transformationFileList, inputResource, outputDirPathName) ;

					}

	protected Resource doTransformation(List<File> transformationFileList, Resource inputResource,
			String outputDirPathName)
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
		ResourceSet rs = inputResource.getResourceSet();


		Resource outputResource =
				rs.getResource(URI.createURI(outputDirPathName), false) ;

		injector.inject(targetModel, outputResource) ;
		// create ATLHook
		EMFModel atlHookModel = (EMFModel) factory.newModel(ATLHookMetamodel) ;
		URI fileURI =
				URI.createFileURI(Aadl2AadlAtlLauncher.resourcesDir.getAbsolutePath() +
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
		registerPredefinedResourcesInLauncher(launcher) ;

		launcher.addOutModel(targetModel, "OUT", "AADLBA") ;

		if(workingWithInstances)
		{
			URL asmMainFile =
					new URL("file:" + resourcesDir.getAbsolutePath() +
							"/Uninstanciate.asm") ;
			Object loadedMainModule = launcher.loadModule(asmMainFile.openStream()) ;
			atlModules.add(loadedMainModule) ;

			registerDefaultTransformations(atlModules, launcher);
			
			for(File f : transformationFileList)
			{
				URL asmSuperImposeFile = new URL("file:" + f.toString()+".asm") ;
				Object loadedSuperImposeModule =
						launcher.loadModule(asmSuperImposeFile.openStream()) ;
				atlModules.add(loadedSuperImposeModule) ;
			}
		}
		else
		{
			registerDefaultTransformations(atlModules, launcher);
			URL asmSuperImposeFile =
					new URL("file:" + transformationFileList.get(0).toString()) ;
			Object loadedSuperImposeModule =
					launcher.loadModule(asmSuperImposeFile.openStream()) ;
			atlModules.add(loadedSuperImposeModule) ;
		}
		

		Map<String, Object> options = new HashMap<String, Object>() ;
		options.put("allowInterModelReferences", "true") ;

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
		Aadl2AadlAtlLauncher.resourcesDir = dir ;
			}

	protected void registerDefaultTransformations(List<Object> atlModules, EMFVMLauncher launcher) throws IOException
	{  
		URL libraryFile ;
		List<String> fileName = new ArrayList<String>() ;
		fileName.add("/helpers/IOHelpers") ;
		fileName.add("/helpers/AADLCopyHelpers") ;
		fileName.add("/helpers/AADLICopyHelpers") ;
		fileName.add("/tools/PropertiesTools") ;
		fileName.add("/tools/PackagesTools") ;
		fileName.add("/tools/FeaturesTools") ;
		fileName.add("/tools/SubprogramsTools") ;
		fileName.add("/tools/BehaviorAnnexTools") ;
		fileName.add("/uninstanciate/Features") ;
		fileName.add("/uninstanciate/Implementations") ;
		fileName.add("/uninstanciate/NonInstanciated");
		fileName.add("/uninstanciate/Properties") ;
		fileName.add("/uninstanciate/Types") ;
		fileName.add("/helpers/Services") ;
		fileName.add("/BehaviorAnnexCopy/BehaviorAnnexServices") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorActionBlock") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorCondition") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorSpecification") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorTime") ;
		fileName.add("/BehaviorAnnexCopy/copyElementHolders") ;

		for(String s : fileName)
		{
			libraryFile =
					new URL("file:" + resourcesDir.getAbsolutePath() + s + ".asm") ;
			Object loadedLibrary = launcher.loadModule(libraryFile.openStream()) ;
			launcher.addLibrary(s, loadedLibrary) ;
		}

		URL moduleFile =
				new URL("file:" + resourcesDir.getAbsolutePath() + "/PeriodicDelayedCommunication/EventDataPorts" + ".asm") ;
		Object loadedModule = launcher.loadModule(moduleFile.openStream()) ;
		atlModules.add(loadedModule) ;
		
		
		//URL moduleFile_LowMFP =
		//    	new URL("file:" + resourcesDir.getAbsolutePath() + "/PeriodicDelayedCommunication/EventDataPorts_LowMFP" + ".asm") ;
		//Object loadedModule_LowMFP = launcher.loadModule(moduleFile_LowMFP.openStream()) ;
		//atlModules.add(loadedModule_LowMFP) ;

	}
}