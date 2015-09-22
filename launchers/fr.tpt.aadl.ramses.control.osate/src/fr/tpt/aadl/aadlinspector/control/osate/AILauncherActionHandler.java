package fr.tpt.aadl.aadlinspector.control.osate;

import java.io.IOException ;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.control.osate.RamsesActionHandler;
import fr.tpt.aadl.ramses.control.osate.WorkbenchUtils;
import fr.tpt.aadl.ramses.control.osate.properties.AadlInspectorPropertyPage;
import fr.tpt.aadl.ramses.control.osate.properties.LoggingConfigPage;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.sched.aadlinspector.AADLInspectorLauncher;
import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult ;

public class AILauncherActionHandler extends RamsesActionHandler {

	
	private static Logger _LOGGER = Logger.getLogger(AILauncherActionHandler.class) ;
	  
	private static final String _OUTLINE_COMMAND_ID = 
            "fr.tpt.aadl.ramses.control.osate.inspector.launch.outline" ;
	
	private RamsesConfiguration _config = new RamsesConfiguration() ;
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	  try
	  {
		_JOB_NAME = "AADL Inspector launcher";
		if(event!=null)
			init(event, _OUTLINE_COMMAND_ID);
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
			try
		{
			AadlInspectorPropertyPage.fetchProperties(_currentProject, _config) ;
		}
		catch (ConfigurationException ee)
	    {
	      if(AadlInspectorPropertyPage.openPropertyDialog(_currentProject))
	      {
	        // Reload configuration.
	        AadlInspectorPropertyPage.fetchProperties(_currentProject, _config) ;
	      }
	      else // User has canceled.
	      {
	    	return null ;
	      }
	    }
		finally
		{
		  // Only call once because it creates a log file.
	      LoggingConfigPage.fetchLoggingProperties(_currentProject);
	      _config.log() ;
	    }
	  }  
	  catch (Exception e) // Configuration and CoreException caught.
	  {
		String msg = "cannot load RAMSES properties" ;
		_LOGGER.fatal(msg, e);
		ServiceProvider.SYS_ERR_REP.fatal(msg, e);
		// Abort generation.
		return null ;
	  }
	  
	  doAction();
	  
	  return null ;
	}


	@Override
	protected void jobCore(IProgressMonitor monitor) throws Exception {
		  monitor.beginTask("Launch AADL Inspector", IProgressMonitor.UNKNOWN);
	    
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
	    
	    analysis(_sysInst, _config, monitor);
	    
	    if(monitor.isCanceled())
	    {
	      String msg = "analysis has been canceled after execution" ;
	      _LOGGER.trace(msg);
	      throw new OperationCanceledException(msg) ;
	    }
	    
	    WorkbenchUtils.showGenerationReport() ;
	  }


	private void analysis(SystemInstance sysInst,
			RamsesConfiguration config, IProgressMonitor monitor) throws AnalysisException, InterruptedException {
		
		AADLInspectorLauncher aiLauncher = new AADLInspectorLauncher(config.getAadlInspectorInstallDir());
		
		AnalysisResult ar = aiLauncher.launchAnalysis(sysInst, config.getAadlInspectorOutputDir(), config.getMode(), monitor);
		
		if(ar==null)
		{
		  String msg = "AADL Inspector Analysis failed; check input model and launch AADL" +
		      "Inspector with graphical interface to analyse the reasons of this error.";
		  ServiceProvider.SYS_ERR_REP.error(msg, false);
		}
		
		AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE ;
    AnalysisArtifact result = f.createAnalysisArtifact() ;
    ar.normalize(result);
	  try
    {
      updateAnalysisResults(result);
    }
    catch(IOException e)
    {
      String msg = "cannot save analysis results" ;
      _LOGGER.error(msg, e);
      ServiceProvider.SYS_ERR_REP.error(msg, false);
    }
	}
	
}


