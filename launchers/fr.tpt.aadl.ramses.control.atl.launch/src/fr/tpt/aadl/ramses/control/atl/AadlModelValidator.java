package fr.tpt.aadl.ramses.control.atl;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv ;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public abstract class AadlModelValidator extends Aadl2XEMFTVMLauncher {

	public AadlModelValidator(AadlModelInstantiatior modelInstantiator,
			                      PredefinedAadlModelManager predefinedResourcesManager)
	{
		super(modelInstantiator, predefinedResourcesManager);
	}

	protected List<String> ATL_FILE_NAMES;
    public List<File> ATL_FILES;
	
  public void initAtlFileNameList(File resourceDir)
  {
    ATL_FILES = new ArrayList<File>() ;
    for(String fileName : ATL_FILE_NAMES)
    {
      ATL_FILES.add(new File(resourceDir.getAbsolutePath() + File.separator +
                             fileName)) ;
    }
  }
	
	public Resource validate(Resource inputResource, 
			                     String targetId, AnalysisErrorReporterManager errManager,
			                     IProgressMonitor monitor) throws TransformationException 
	{
	  String errorReportingGeneratedFileName = inputResource.getURI().lastSegment();
	  errorReportingGeneratedFileName = errorReportingGeneratedFileName.replaceFirst(
	      ".aaxl2", ".xmi");

	  ExecEnvPool pool = getRamsesExecEnv(targetId);
	  ExecEnv env = null;
	  if(targetId!=null && pool!=null)
	  {
	    env = pool.getExecEnv();
	    Resource res = doTransformation(targetId, inputResource, 
	                                    errorReportingGeneratedFileName, 
	                                    "_Errors", monitor);

	    return res;
	  }
	  if(env == null)
	    env = EmftvmFactory.eINSTANCE.createExecEnv();  
	  Metamodel constraintValidationMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
	  constraintValidationMetamodel.setResource(
	                                            fr.tpt.aadl.ramses.constraintsreporter.reporterPackage.eINSTANCE.eResource());
	  env.registerMetaModel("CV", constraintValidationMetamodel);
	  initAtlFileNameList(RamsesConfiguration.getAtlResourceDir()) ;
	  ArrayList<File> atlFiles = new ArrayList<File>() ;

	  for(String fileName : ATL_FILE_NAMES)
	  {
	    atlFiles.add(new File(RamsesConfiguration.getAtlResourceDir() + File.separator + fileName)) ;
	  }

	  return doTransformation(ATL_FILES, inputResource, 
	                          errorReportingGeneratedFileName, 
	                          "_Errors", monitor);
	}

	public List<String> getTransformationModuleList() {
		return ATL_FILE_NAMES;
	}
}