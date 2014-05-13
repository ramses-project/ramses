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

import java.util.List ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory ;
import org.eclipse.m2m.atl.emftvm.Model ;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.ramses.control.atl.Aadl2AadlEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel ;

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
		initTransformation();
		this.cpuList = cpuList;
	}
	
	public Resource doTransformation(Resource inputResource, String outputDirPathName,
			String resourceSuffix,
			IProgressMonitor monitor)
			{
		
		Resource wcetResource = wcetModel.eResource();
		if(wcetResource==null)
		{
			wcetResource = rs.createResource(URI.createURI(outputDirPathName+"/reducerBA.xmi"));
			wcetResource.getContents().add(wcetModel);
		}

		
		// Load models
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(wcetResource);
		ExecEnvPool pool = AtlTransfoLauncher.getRamsesExecEnv(AADLInspectorSchedulingAnalysis.PLUGIN_NAME);
		env = pool.getExecEnv();
		env.registerInputModel("WCET", inModel);
		
		
		super.initTransformationInputs(inputResource);
		
		getAtlHook().resetCpuToIgnore(cpuList);
		Resource res = super.doTransformation(inputResource,
				outputDirPathName, resourceSuffix, monitor);
		
		pool.returnExecEnv(env);
		
		return res;
	}
	
}
