package fr.tpt.aadl.launch;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.ramses.control.atl.Aadl2AadlEMFTVMLauncher;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage;

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
	                                     throws ATLCoreException
	{
		super(modelInstantiator, predefinedResourcesManager) ;
	    wcetModel = model;
		initTransformation(env);
		this.cpuList = cpuList;
	}
	
	@Override
	public Resource doTransformation(List<File> transformationFileList,
			Resource inputResource, String outputDirPathName,
			String resourceSuffix)
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
		env.registerInputModel("WCET", inModel);
		
		
		super.initTransformationInputs(transformationFileList, inputResource);
		getAtlHook().resetCpuToIgnore(cpuList);
		return super.doTransformation(transformationFileList, inputResource,
				outputDirPathName, resourceSuffix);
	}
	
}
