package fr.tpt.aadl.ramses.control.atl;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.TransformationException ;

public abstract class AadlModelValidator extends Aadl2XEMFTVMLauncher {

	public AadlModelValidator(AadlModelInstantiatior modelInstantiator,
			                      PredefinedAadlModelManager predefinedResourcesManager)
	{
		super(modelInstantiator, predefinedResourcesManager);
	}

	protected String[] ATL_FILE_NAMES;
    public List<File> ATL_FILES;
	
  public void initAtlFileNameList(File resourceDir)
  {
    ATL_FILES = new ArrayList<File>(ATL_FILE_NAMES.length) ;
    for(String fileName : ATL_FILE_NAMES)
    {
      ATL_FILES.add(new File(resourceDir.getAbsolutePath() + File.separator +
                             fileName)) ;
    }
  }
	
	public Resource validate(Resource inputResource, 
			                     AnalysisErrorReporterManager errManager,
			                     IProgressMonitor monitor) throws TransformationException 
	{
		initAtlFileNameList(RamsesConfiguration.getAtlResourceDir()) ;
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
    
    return atlLauncher.doTransformation(ATL_FILES, inputResource, 
                                        errorReportingGeneratedFileName, 
                                        "_Errors");
	}
}