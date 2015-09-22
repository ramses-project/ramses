/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.launch;

import java.io.IOException ;
import java.util.List;

import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IWorkspaceRoot ;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.util.EcoreUtil ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv ;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.SubcomponentType ;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.ramses.control.atl.Aadl2AadlEMFTVMLauncher;
import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA ;

public class Wcet2AadlEMFTVMLauncher extends Aadl2AadlEMFTVMLauncher{
	
	AnalysisModel wcetModel;
	List<ComponentInstance> cpuList;
	/* Some how, this class has to implements AbstractAadlToAadl
	static
	{
	  _resourcesDirNames.add("Wcetanalysis") ;
	}
	*/
	public Wcet2AadlEMFTVMLauncher(AnalysisModel model,
	                               AadlModelInstantiatior modelInstantiator,
	                               PredefinedAadlModelManager predefinedResourcesManager,
	                               List<ComponentInstance> cpuList)
	{
		super(modelInstantiator, predefinedResourcesManager) ;
	    wcetModel = model;
		this.cpuList = cpuList;
	}
	
	public Resource doTransformation(ResourceSet rs, Resource inputResource, String outputDirPathName,
			String resourceSuffix,
			IProgressMonitor monitor)
			{
	  
	    if(rs.getResources().isEmpty())
	      synchronized(rs)
	      {
	        rs.getResources().addAll(inputResource.getResourceSet().getResources());
	      }
	  Resource wcetResource = wcetModel.eResource();
		if(wcetResource==null)
		{
		  URI uri = inputResource.getURI();
		  if(uri.isPlatform())
		  {
		    URI inputResourceURI = inputResource.getURI();
		    String UriName = inputResourceURI.toString();
		    URI reducedBAURI = URI.createURI(UriName.substring(0,UriName.lastIndexOf(".")-1)+"_reducerBA.xmi");
	      wcetResource = rs.createResource(rs.getURIConverter().normalize(reducedBAURI));
		  }
		  else
		  {
	      URI reducedBAURI = URI.createFileURI(outputDirPathName+"/reducerBA.xmi");
	      wcetResource = rs.createResource(rs.getURIConverter().normalize(reducedBAURI));
		  }

		}
		wcetResource.getContents().add(wcetModel);
		EcoreUtil2.resolveAll(rs);
		
		
		// Load models
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(wcetResource);
		ExecEnvPool pool = getRamsesExecEnv(AADLInspectorSchedulingAnalysis.PLUGIN_NAME);
		ExecEnv env = pool.getExecEnv();
		env.registerInputModel("WCET", inModel);
		
		
		super.initTransformationInputs(env, inputResource);
		
		getAtlHook().resetCpuToIgnore(cpuList);
		Resource res = super.doTransformation(env, inputResource,
				outputDirPathName, resourceSuffix, monitor);
		
		pool.returnExecEnv(env);
		env = null;
		return res;
	}
	
}
