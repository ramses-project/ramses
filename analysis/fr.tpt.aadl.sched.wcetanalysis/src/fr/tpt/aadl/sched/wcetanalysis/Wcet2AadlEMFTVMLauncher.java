package fr.tpt.aadl.sched.wcetanalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.transformation.atl.Aadl2AadlEMFTVMLauncher;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage;

public class Wcet2AadlEMFTVMLauncher extends Aadl2AadlEMFTVMLauncher{

	private static final String REDUCEDBA_MM_URI =
			ReducedbaPackage.eNS_URI ;
	
	AnalysisModel wcetModel;
	
	public Wcet2AadlEMFTVMLauncher(AnalysisModel model) throws ATLCoreException {
		EPackage.Registry.INSTANCE.put(REDUCEDBA_MM_URI, ReducedbaPackage.eINSTANCE) ;
		wcetModel = model;
		this.initTransformation();
	}

	@Override
	protected void initTransformation() throws ATLCoreException {
		// register reducedBa
		super.initTransformation();
	}
	
	@Override
	public Resource doTransformation(List<File> transformationFileList,
			Resource inputResource, String outputDirPathName,
			String resourceSuffix)
			throws FileNotFoundException, IOException, ATLCoreException,
			GenerationException {
		
		ResourceSet rs = inputResource.getResourceSet();
		
		Resource wcetResource = wcetModel.eResource();
		if(wcetResource==null)
		{
			wcetResource = rs.createResource(URI.createURI(outputDirPathName+"/reducerBA.xmi"));
			wcetResource.getContents().add(wcetModel);
		}
		// Load reduced ba metamodel 
		Metamodel aadlInstanceMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		aadlInstanceMetaModel.setResource(rs.getResource(URI.createURI(REDUCEDBA_MM_URI), true));
		env.registerMetaModel("REDUCEDBA", aadlInstanceMetaModel);
		
		// Load models
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(wcetResource);
		env.registerInputModel("WCET", inModel);
		
		return super.doTransformation(transformationFileList, inputResource,
				outputDirPathName, resourceSuffix);
	}
	
}
