package fr.tpt.aadl.ramses.control.osate;

import java.io.File ;

import org.apache.log4j.Logger ;
import org.eclipse.core.commands.ExecutionEvent ;
import org.eclipse.core.commands.ExecutionException ;
import org.eclipse.core.resources.IFile ;
import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.jface.viewers.ISelection ;
import org.eclipse.jface.viewers.IStructuredSelection ;
import org.eclipse.ui.handlers.HandlerUtil ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.analysis.AnalysisResult ;
import fr.tpt.aadl.ramses.analysis.AnalysisSource ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult ;
import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

public abstract class AnalysisActionHandler extends RamsesActionHandler
{

  private static Logger _LOGGER = Logger.getLogger(AnalysisActionHandler.class) ;
  private RamsesConfiguration _config = new RamsesConfiguration() ;
  
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException
  {
    try
    {
      _JOB_NAME = "AADL "+getAnalysisName()+" analysis";
      if(event!=null)
        init(event, getCommandId());
      else
      {
        if(_isOutline)
        {
          _currentProject = WorkbenchUtils.getProjectByActiveEditor() ;
        }
        else
        {
          ISelection s = HandlerUtil.getCurrentSelection(event) ;
          IFile node = (IFile) ((IStructuredSelection) s).getFirstElement() ;
          _currentProject = node.getProject() ;
        }
      }
    }
    catch(ConfigurationException e)
    {
      _LOGGER.error("Configuration of "+_JOB_NAME+" failed", e);
    }
    
    try
    {
      _config.setRamsesOutputDir(RamsesPropertyPage.
                                 fetchPropertiesValue(_currentProject, RamsesPropertyPage.OUTPUT_DIR)) ;
    }
    catch(CoreException e)
    {
      _LOGGER.error("Could not fetch output directory", e);
    }
    
    doAction() ;
    
    return null ;
  }

  @Override
  protected void jobCore(IProgressMonitor monitor) throws Exception
  {
    monitor.beginTask("Launch "+getAnalysisName()+" analysis", IProgressMonitor.UNKNOWN);
    
    if(monitor.isCanceled())
    {
      String msg = "analysis has been canceled at the begining" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
    ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
    AadlModelInstantiatior instantiator = sr.getModelInstantiatior() ;
    
    instantiator.setProgressMonitor(monitor);
    
    // For executed command from the button or the RAMSES menu,system
    // implementation has already been instantiated.
    
    if(monitor.isCanceled())
    {
      String msg = "analysis has been canceled after instantiation" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
    String resultFilePath = _config.getRamsesOutputDir().getAbsolutePath()+"/analysis_results.ares";
    File resultFile = new File(resultFilePath);
    String projectPathString = _currentProject.getLocation().toOSString();
    projectPathString = projectPathString.substring(0, projectPathString.lastIndexOf('/'));
    if(resultFilePath.contains(projectPathString))
      resultFilePath = resultFilePath.substring(projectPathString.length()+1,resultFilePath.length());
    URI resultFileURI =
        URI.createPlatformResourceURI(resultFilePath, true);
    
    Resource r = _sysInst.eResource()
        .getResourceSet()
        .getResource(resultFileURI, 
                     resultFile.exists());
    if(r==null)
      r =  _sysInst.eResource()
          .getResourceSet().createResource(resultFileURI);
    
    AnalysisArtifact aa = analysis(_sysInst, monitor);
    if(r.getContents().isEmpty())
      r.getContents().add(aa);
    else
    {
      AnalysisArtifact existingAa = 
        (AnalysisArtifact) r.getContents().get(0);
      updateAnalysisArtifact(existingAa, aa);
    }
    
    r.save(null);
    
    if(monitor.isCanceled())
    {
      String msg = "analysis has been canceled after execution" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
    WorkbenchUtils.showGenerationReport() ;
    
  }

  private void updateAnalysisArtifact(AnalysisArtifact existingArtefact,
                                      AnalysisArtifact newArtefact)
  {
    boolean foundAnalysisToUpdate = false;
    for(Object existingAr: existingArtefact.getResults())
    {
      if(foundAnalysisToUpdate)
        break;
      AnalysisResult existingQar =
          (AnalysisResult) existingAr;
      AnalysisSource existingAs = existingQar.getSource();
      for(Object newAr: newArtefact.getResults())
      {
        AnalysisResult newQar =
            (AnalysisResult) newAr;
        if(newQar instanceof QualitativeAnalysisResult
            && existingQar instanceof QuantitativeAnalysisResult)
          continue;
        if(newQar instanceof QuantitativeAnalysisResult
            && existingQar instanceof QualitativeAnalysisResult)
          continue;
        AnalysisSource newAs = newQar.getSource();
        if(newAs.getIterationId() == 
            existingAs.getIterationId()
            && 
            newAs.getMethodName().equals(existingAs.getMethodName()))
        {
          updateAnalysisResult(existingQar, newQar);
          foundAnalysisToUpdate = true;
          break;
        }
      }
    }
    if(foundAnalysisToUpdate == false)
      existingArtefact.getResults().addAll(newArtefact.getResults());
  }

  private void updateAnalysisResult(AnalysisResult existingQar,
                                    AnalysisResult newQar)
  {
    if(existingQar instanceof QualitativeAnalysisResult
        && newQar instanceof QualitativeAnalysisResult)
    {
      QualitativeAnalysisResult existingQarCasted = 
          (QualitativeAnalysisResult) existingQar;
      QualitativeAnalysisResult newQarCasted = 
          (QualitativeAnalysisResult) newQar;
      existingQarCasted.setValidated(newQarCasted.isValidated());
    }
    else if(existingQar instanceof QuantitativeAnalysisResult
        && newQar instanceof QuantitativeAnalysisResult)
    {
      QuantitativeAnalysisResult existingQarCasted = 
          (QuantitativeAnalysisResult) existingQar;
      QuantitativeAnalysisResult newQarCasted = 
          (QuantitativeAnalysisResult) newQar;
      existingQarCasted.setMargin(newQarCasted.getMargin());
      existingQarCasted.setValue(newQarCasted.getValue());
    }
  }

  protected abstract AnalysisArtifact analysis(SystemInstance _sysInst, 
                                   IProgressMonitor monitor);
  
  protected abstract String getCommandId();
  
  protected abstract String getAnalysisName();
  
}
