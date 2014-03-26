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

package fr.tpt.aadl.ramses.control.osate;

import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.core.commands.AbstractHandler ;
import org.eclipse.core.commands.ExecutionEvent ;
import org.eclipse.core.commands.ExecutionException ;
import org.eclipse.core.resources.IFile ;
import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IResource ;
import org.eclipse.core.resources.IWorkspaceRoot ;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.IStatus ;
import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.core.runtime.Status ;
import org.eclipse.core.runtime.jobs.Job ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.transaction.RecordingCommand ;
import org.eclipse.emf.transaction.TransactionalCommandStack ;
import org.eclipse.emf.transaction.TransactionalEditingDomain ;
import org.eclipse.jface.viewers.ISelection ;
import org.eclipse.jface.viewers.IStructuredSelection ;
import org.eclipse.ui.IEditorPart ;
import org.eclipse.ui.handlers.HandlerUtil ;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.instantiation.InstantiateModel ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.osate.properties.LoggingConfigPage;
import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigStatus ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.control.workflow.EcoreWorkflowPilot ;

public class GenerateActionHandler extends AbstractHandler {

  private static final String _JOB_NAME = "RAMSES code generation" ;
  
  private static Logger _LOGGER = Logger.getLogger(GenerateActionHandler.class) ;

  private static final String _OUTLINE_COMMAND_ID = 
                         "fr.tpt.aadl.ramses.control.osate.outline.generation" ;
//  private static final String MENU_OR_BUTTON_COMMAND_ID = 
//                        "fr.tpt.aadl.ramses.control.osate.instance.generation" ;
  
  private static final String _OK_STATUS = "OK" ;
  private static final String _CANCEL_STATUS = "CANCEL" ;
  private static final String _ABORT_STATUS = "FATAL" ;
  
  // Call init method to setup these attributes.
  private boolean _isOutline = false ;
  private RamsesConfiguration _config = new RamsesConfiguration() ;
  private IProject _currentProject = null ;
  private ExecutionEvent _event = null ;
  
  private SystemImplementation _sysImpl = null ;
  //OR (init will not initialize both)
  private SystemInstance _sysInst = null ;
  
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException
  {
    try
    {
      init(event) ;
      
      // Fetch RAMSES configuration.
      try
      {
        RamsesPropertyPage.fetchProperties(_currentProject, _config) ;
      }
      catch (ConfigurationException ee)
      {
        if(RamsesPropertyPage.openPropertyDialog(_currentProject))
        {
          // Reload configuration.
          RamsesPropertyPage.fetchProperties(_currentProject, _config) ;
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
    
    doGenerate() ;
    
    return null ;
  }
  
  private void init(ExecutionEvent event) throws ConfigurationException
  {
    _event = event ;
    _isOutline = _OUTLINE_COMMAND_ID.equals(event.getCommand().getId()) ;
    if(_isOutline)
    {
      _currentProject = WorkbenchUtils.getProjectByActiveEditor() ;
      _sysImpl = getOutlineSelectedSystem(event) ;
      _LOGGER.info("OSATE project is \'" + _currentProject.getName() + '\'');
      _LOGGER.info("system implementation to generate (outline action) is \'" + _sysImpl.getFullName() + '\'');
    }
    else
    {
      ISelection s = HandlerUtil.getCurrentSelection(event) ;
      IFile node = (IFile) ((IStructuredSelection) s).getFirstElement() ;
      _currentProject = node.getProject() ;
      Resource resource = OsateResourceUtil.getResource((IResource) node) ;
      // Fetch system implementation model.
      _sysInst = (SystemInstance) resource.getContents().get(0) ;
      _LOGGER.info("OSATE project is \'" + _currentProject.getName() + '\'');
      _LOGGER.info("system implementation to generate (button action) is \'" + _sysInst.getFullName() + '\'');
    }
  }

  private SystemImplementation getOutlineSelectedSystem(ExecutionEvent event)
                                                        throws ConfigurationException
  {
    SystemImplementation result = null ;
    
    try
    {
      ISelection s = HandlerUtil.getCurrentSelection(event) ;
      
      // Prior checking were performed on the selection (for instance, object type).
      // See OutlinePropertyTester.
      // It doesn't worth to perform theses checking twice.
      
      EObjectNode node = (EObjectNode)((IStructuredSelection) s).getFirstElement() ;
      Resource resource = OsateResourceUtil.getResource(node.getEObjectURI()) ;
      EObject obj = node.getEObject(resource) ;
      result = (SystemImplementation) obj ;
    }
    catch (Exception e)
    {
      String message;
      message = "Not enable to fetch the selected system implementation node";
      if (InstantiateModel.getErrorMessage() != null)
      {
        message = message + " - reason: " + InstantiateModel.getErrorMessage() +
                     "\nRefer to the help content and FAQ for more information";
      }
      
      ConfigStatus.NOT_VALID.msg = message ;
      throw new ConfigurationException(ConfigStatus.NOT_VALID) ;
    }
    
    return result ;
  }
  
  private void jobCore(IProgressMonitor monitor) throws ConfigurationException,
                                                        AnalysisException,
                                                        GenerationException,
                                                        TransformationException,
                                                        FileNotFoundException,
                                                        CoreException
  {
    monitor.beginTask("Code generation", IProgressMonitor.UNKNOWN);
    
    ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
    AadlModelInstantiatior instantiator =sr.getModelInstantiatior() ;
    
    instantiator.setProgressMonitor(monitor);
    
    // For the executed command from outline menu,the system implementation 
    // root has to be instantiated prior to the code generation.
    if(_isOutline)
    {
      // Fetch instantiate the model.
      _sysInst = instantiator.instantiate(_sysImpl) ;
    }
    // For executed command from the button or the RAMSES menu,system
    // implementation has already been instantiated.
    
    if(monitor.isCanceled())
    {
      String msg = "generation has been canceled after instantiation" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
    generate(_currentProject, _sysInst, _config, monitor);
    
    if(monitor.isCanceled())
    {
      String msg = "generation has been canceled after code generation" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
    WorkbenchUtils.showGenerationReport() ;
  }
  
  private void doGenerate()
  {
    Job job = new Job(_JOB_NAME)
    {
      @Override
      protected IStatus run(final IProgressMonitor monitor)
      {
        IStatus result = null ;
        
        try
        {
          final TransactionalEditingDomain domain = TransactionalEditingDomain.
              Registry.INSTANCE.
              getEditingDomain("org.osate.aadl2.ModelEditingDomain") ;
          // We execute this command on the command stack because otherwise, we will
          // not have write permissions on the editing domain.
          RecordingCommandWithException cmd = new RecordingCommandWithException(domain)
          {
            protected void doExecute()
            {
              try
              {
                ProgressMonitorWrapper monitorWrapper = new ProgressMonitorWrapper(
                                                                      monitor) ;
                // Make sur that this xtext editor is saved.
                IEditorPart editor = HandlerUtil.getActiveEditor(_event) ;
                WorkbenchUtils.saveEditor(editor);
                
                jobCore(monitorWrapper) ;
                
                this.setLabel(_OK_STATUS) ;
              }
              catch(OperationCanceledException e)
              {
                StringBuilder sb = new StringBuilder() ;
                sb.append(Names.NEW_LINE) ;
                sb.append(Names.NEW_LINE) ;
                sb.append("********************************************************************************") ;
                sb.append(Names.NEW_LINE) ;
                if(! (e.getMessage() == null || e.getMessage().isEmpty()))
                {
                  sb.append(e.getMessage()) ;
                }
                else
                {
                  sb.append("User has canceled") ;
                }
                sb.append(Names.NEW_LINE) ;
                sb.append("********************************************************************************") ;
                
                _LOGGER.info(sb.toString());
                
                this.setLabel(_CANCEL_STATUS);
              }
              catch(Exception e)
              {
                _LOGGER.fatal("", e) ;
                // Don't report error to the user.
                // Eclipse will open an error dialog thanks to the status.
                this.setLabel(_ABORT_STATUS) ;
                this.exceptionCaught = e ;
              }
            }
          } ;

          ((TransactionalCommandStack) domain.getCommandStack()).execute(cmd,
                                                                         null) ;
          if(_ABORT_STATUS.equals(cmd.getLabel()))
          {
            result = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                                "FATAL ERROR", cmd.exceptionCaught) ;
          }
          else
          {
            // Don't show error if any exception has been raised: escape side effects.
            if(_OK_STATUS.equals(cmd.getLabel()))
            {
              result = Status.OK_STATUS ;
            }
            else
            {
              result = Status.CANCEL_STATUS ;
            }
          }
        }
        catch(Exception e)
        {
          _LOGGER.fatal("", e);
          result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "FATAL ERROR", e) ;
        }
        finally
        {
          HookAccessImpl.cleanupTransformationTrace() ;
        }
        
        return result ;
      }
    };
    
    job.setUser(true);
    job.schedule();
  }

  private void generate(IProject currentProject,
                        SystemInstance sinst,
                        RamsesConfiguration config,
                        IProgressMonitor monitor) throws AnalysisException,
                                                         GenerationException,
                                                         TransformationException,
                                                         FileNotFoundException,
                                                         CoreException
  {
    ServiceRegistry registry;
    registry = ServiceProvider.getServiceRegistry() ;
    Generator generator = registry.getGenerator(config.getTargetId()) ;
    
    SystemImplementation sysImpl = sinst.getSystemImplementation() ;
    
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    
    // look for a workflow file
    Resource r = sysImpl.eResource();
    String s = r.getURI().segment(1);
    File rootDir = new File(workspaceRoot.getProject(s).getLocationURI());
    String workflow = GenerateActionUtils.findWorkflow(rootDir);
    
    AnalysisErrorReporterManager errReporter = 
                                 ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER ;
    
    // Reinitialize the registry as include directors (eg projects directories),
    // may be added or deleted.
    Set<File> tmp = WorkbenchUtils.getIncludeDirs(currentProject) ;
    File[] includeDirs = new File[tmp.size()] ;
    tmp.toArray(includeDirs) ;
    
    if(workflow==null)
      generator.generate(sinst, 
                         config.getRuntimePath(),
                         config.getOutputDir(),
                         includeDirs,
                         errReporter,
                         monitor) ;
    else
    {
      EcoreWorkflowPilot xmlPilot = new EcoreWorkflowPilot(workflow);
      generator.generateWorkflow(sinst,
                                 xmlPilot,
                                 config.getRuntimePath(),
                                 config.getOutputDir(),
                                 includeDirs,
                                 errReporter,
                                 monitor);
    }
    
    ResourcesPlugin.getWorkspace().getRoot().
    refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor()); 
  }
}

abstract class RecordingCommandWithException extends RecordingCommand
{
  public RecordingCommandWithException(TransactionalEditingDomain domain)
  {
    super(domain) ;
  }

  public Throwable exceptionCaught = null ;
}