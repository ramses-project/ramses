package fr.tpt.aadl.ramses.transformation.atl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;

public abstract class AadlModelValidator extends Aadl2XEMFTVMLauncher {

	public AadlModelValidator(AadlModelInstantiatior modelInstantiator,
			PredefinedAadlModelManager predefinedResourcesManager)
			throws ATLCoreException {
		super(modelInstantiator, predefinedResourcesManager);
	}

	protected String[] ATL_FILE_NAMES;
    public List<File> ATL_FILES;
	
	public void initAtlFileNameList(File resourceDir)
    {
        ATL_FILES = new ArrayList<File>(ATL_FILE_NAMES.length);
        for (String fileName : ATL_FILE_NAMES) {
        ATL_FILES.add(new File(resourceDir.getAbsolutePath() +File.separator+ fileName));
      }
    }
	
	public Resource validate(Resource inputResource, 
			AnalysisErrorReporterManager errManager,
			IProgressMonitor monitor) 
	{
		initAtlFileNameList(RamsesConfiguration.getAtlResourceDir()) ;

	    try
	    {
	      ArrayList<File> atlFiles = new ArrayList<File>(ATL_FILE_NAMES.length) ;

	      for(String fileName : ATL_FILE_NAMES)
	      {
	        atlFiles.add(new File(RamsesConfiguration.getAtlResourceDir() + File.separator + fileName)) ;
	      }
	      Aadl2ConstraintValidationEMFTVMLauncher atlLauncher =
	            new Aadl2ConstraintValidationEMFTVMLauncher(_modelInstantiator,
	                  _predefinedResourcesManager) ;
	      
	      String errorReportingGeneratedFileName = inputResource.getURI().lastSegment();
	      errorReportingGeneratedFileName = errorReportingGeneratedFileName.replaceFirst(
					".aaxl2", ".xmi");
	      
	      return atlLauncher.doTransformation(ATL_FILES, 
	    		  inputResource, 
	    		  errorReportingGeneratedFileName, 
	    		  "_Errors");
	    }
	    catch(Exception e)
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace() ;
	      return null ;
	    }
	}

	
}
