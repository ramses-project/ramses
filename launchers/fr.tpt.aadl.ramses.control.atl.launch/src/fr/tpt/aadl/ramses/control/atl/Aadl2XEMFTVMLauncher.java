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
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory ;
import org.eclipse.m2m.atl.emftvm.ExecEnv ;
import org.eclipse.m2m.atl.emftvm.Metamodel ;
import org.eclipse.m2m.atl.emftvm.Model ;
import org.eclipse.m2m.atl.emftvm.Module ;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl ;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException ;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver ;
import org.eclipse.m2m.atl.emftvm.util.StackFrame ;
import org.eclipse.m2m.atl.emftvm.util.TimingData ;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.PropertySet ;
import org.osate.aadl2.instance.InstancePackage ;
import org.osate.ba.aadlba.AadlBaPackage ;

import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksFactory ;
import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage ;
import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;


public abstract class Aadl2XEMFTVMLauncher extends AtlTransfoLauncher
{
	protected AadlModelInstantiatior _modelInstantiator ;
  
	protected PredefinedAadlModelManager _predefinedResourcesManager ;

	protected ExecEnv env;

	protected ResourceSet rs = new ResourceSetImpl();
	private HookAccessImpl atlHook;
 	private List<Module> moduleList = new ArrayList<Module>();
 	
	public HookAccessImpl getAtlHook()
	{
	  return atlHook;
	}

	protected String outputPackageName = "";
	
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
			} catch (IOException e)
			{
				String msg = "cannot resolve module \'" + module + '\'' ;
				_LOGGER.fatal(msg, e);
			  throw new ModuleNotFoundException(msg, e);
			}
		}
	};
	
	public Aadl2XEMFTVMLauncher(AadlModelInstantiatior modelInstantiator,
	                            PredefinedAadlModelManager predefinedResourcesManager)
  {
    _modelInstantiator = modelInstantiator ;
    _predefinedResourcesManager = predefinedResourcesManager ;
  }
	
	public String getOutputPackageName() {
		return outputPackageName;
	}

	public void setOutputPackageName(String outputPackageName) {
		this.outputPackageName = outputPackageName;
	}

	public Resource doTransformation(String transformationId,
	                                 Resource inputResource,
	                                 String outputDirPathName,
	                                 String resourceSuffix,
	                                 IProgressMonitor monitor)
	{
		env = AtlTransfoLauncher.getRamsesExecEnv(transformationId).getExecEnv();
		
		initTransformationInputs(inputResource);
		
		Resource res = doTransformation(inputResource, outputDirPathName, resourceSuffix, monitor);
		
		AtlTransfoLauncher.getRamsesExecEnv(transformationId).returnExecEnv(env);
		
		return res;

	}
	
	protected Resource doTransformation(Resource inputResource,
			String outputDirPathName, String resourceSuffix, final IProgressMonitor monitor) {
		
		Resource outputResource = initTransformationOutput(inputResource, 
				outputDirPathName, resourceSuffix);
		
		Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outputResource);
		env.registerInOutModel("OUT", outModel);
		
		// Run transformation
		TimingData td = new TimingData();
		td.finishLoading();
		
		if(null == env.getMonitor())
		{
		  VMMonitor vmMonitor = new VMMonitor()
	    {
	      @Override
	      public boolean isTerminated()
	      {
	        // TODO Auto-generated method stub
	        return false ;
	      }

	      @Override
	      public void enter(StackFrame frame)
	      {
	        // TODO Auto-generated method stub
	        
	      }

	      @Override
	      public void leave(StackFrame frame)
	      {
	        // TODO Auto-generated method stub
	        
	      }

	      @Override
	      public void step(StackFrame frame)
	      {
	        if(monitor.isCanceled())
	        {
	          String msg = "user has canceled during the analysis" ;
	          _LOGGER.trace(msg) ;
	          throw new OperationCanceledException(msg) ;
	        }
	      }

	      @Override
	      public void terminated()
	      {
	        // TODO Auto-generated method stub
	        
	      }

	      @Override
	      public void error(StackFrame frame, String msg, Exception e)
	      {
	        // TODO Auto-generated method stub
	        
	      }
	    };
	    
	    env.setMonitor(vmMonitor);
		}
		try
		{
		  env.run(td);
		  td.finish();
		}
		catch(Exception e)
		{
		  String msg = "EMFTVM transformation failed";
		  _LOGGER.fatal(msg, e);
		  ServiceProvider.SYS_ERR_REP.fatal(msg, e);
		}
		return outModel.getResource();
	}

	public Resource doTransformation(List<File> transformationFileList,
	                                 Resource inputResource,
			                             String outputDirPathName,
			                             String resourceSuffix,
			                             IProgressMonitor monitor)
	{
		
		
		if(env == null)
		  env = EmftvmFactory.eINSTANCE.createExecEnv();
		
		// Load metamodels
		  // Load aadl instance metamodel 
		  Metamodel aadlInstanceMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		  aadlInstanceMetaModel.setResource(InstancePackage.eINSTANCE.eResource());
		  env.registerMetaModel("AADLI", aadlInstanceMetaModel);

		  // Load aadl+BA metamodel
		  Metamodel aadlBaMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		  aadlBaMetaModel.setResource(AadlBaPackage.eINSTANCE.eResource());
		  env.registerMetaModel("AADLBA", aadlBaMetaModel);

		  // Load atlHooks metamodel
		  Metamodel atlHoolsMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		  atlHoolsMetaModel.setResource(AtlHooksPackage.eINSTANCE.eResource());
		  env.registerMetaModel("ATLHOOKS", atlHoolsMetaModel);
		  
		
		initTransformationInputs(inputResource);
		
		registerAdditionalTransformationsEMFTVM(transformationFileList, _moduleResolver);
		
		return doTransformation(inputResource, outputDirPathName, resourceSuffix, monitor);	
	}
	
	
	protected abstract Resource initTransformationOutput(Resource inputResource,
			String outputDirPathName, String resourceSuffix);

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

	protected void initTransformationInputs(Resource inputResource)
	{

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
          String id = r.getURI().lastSegment();
          id = id.substring(0, id.lastIndexOf('.')).toUpperCase();
          env.registerInputModel(id, referencedModel);
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
    atlHook = (HookAccessImpl) AtlHooksFactory.eINSTANCE.createHookAccess() ;
    atlHook.setOutputPackageName(outputPackageName);
    hookResource.getContents().add(atlHook) ;
    
    try
    {
      hookResource.load(null) ;
    }
    catch(IOException e)
    {
      String errMsg = "fail to load ATL hook \'" + hookResource.getURI() + '\'' ;
      _LOGGER.fatal(errMsg, e);
      throw new RuntimeException(errMsg, e);
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
		  moduleList.add(env.loadModule(mr, f.getAbsolutePath()));
		}
	}

  public List<Module> getModuleList()
  {
    return moduleList;
  }
  
}