package fr.tpt.aadl.ramses.analysis.eg;

import java.io.File ;
import java.util.List ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EPackage ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory ;
import org.eclipse.m2m.atl.emftvm.ExecEnv ;
import org.eclipse.m2m.atl.emftvm.Metamodel ;
import org.eclipse.m2m.atl.emftvm.Model ;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool ;

import fr.tpt.aadl.ramses.control.atl.Aadl2AadlEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage ;

public class Wcet2AadlEMFTVMLauncher extends Aadl2AadlEMFTVMLauncher{

	private static final String REDUCEDBA_MM_URI =
			ReducedbaPackage.eNS_URI ;
	
	AnalysisModel wcetModel;
	
	/* Some how, this class has to implements AbstractAadlToAadl
	static
	{
	  _resourcesDirNames.add("Wcetanalysis") ;
	}
	*/
	public Wcet2AadlEMFTVMLauncher(AnalysisModel model,
	                               AadlModelInstantiatior modelInstantiator,
	                               PredefinedAadlModelManager predefinedResourcesManager)
	{
		super(modelInstantiator, predefinedResourcesManager) ;
	  EPackage.Registry.INSTANCE.put(REDUCEDBA_MM_URI, ReducedbaPackage.eINSTANCE) ;
		wcetModel = model;
	}
	
	@Override
	public Resource doTransformation(String transformationId,
			                             Resource inputResource,
			                             String outputDirPathName,
			                             String resourceSuffix,
			                             IProgressMonitor monitor)
	{
	  ExecEnvPool pool = getRamsesExecEnv(transformationId); 
    ExecEnv env = pool.getExecEnv();
    
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
		
		return super.doTransformation(transformationId, inputResource,
				outputDirPathName, resourceSuffix, monitor);
	}
}