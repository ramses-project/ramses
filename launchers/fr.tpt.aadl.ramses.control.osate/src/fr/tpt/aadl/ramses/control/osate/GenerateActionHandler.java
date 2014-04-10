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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.ramses.control.osate.properties.LoggingConfigPage;
import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.control.workflow.EcoreWorkflowPilot;

public class GenerateActionHandler extends RamsesActionHandler {

  private static Logger _LOGGER = Logger.getLogger(GenerateActionHandler.class) ;

  private static final String _OUTLINE_COMMAND_ID = 
                         "fr.tpt.aadl.ramses.control.osate.outline.generation" ;
//  private static final String MENU_OR_BUTTON_COMMAND_ID = 
//                        "fr.tpt.aadl.ramses.control.osate.instance.generation" ;
  

  // Call init method to setup these attributes.
  private RamsesConfiguration _config = new RamsesConfiguration() ;
  
  private SystemImplementation _sysImpl = null ;
  //OR (init will not initialize both)
  private SystemInstance _sysInst = null ;
  
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException
  {
    try
    {
      _JOB_NAME = "RAMSES code generation";
      init(event, _OUTLINE_COMMAND_ID) ;
      
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
    
    doAction() ;
    
    return null ;
  }

  @Override
  protected void jobCore(IProgressMonitor monitor) throws Exception
  {
    monitor.beginTask("Code generation", IProgressMonitor.UNKNOWN);
    
    if(monitor.isCanceled())
    {
      String msg = "generation has been canceled at the begining" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
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
    		  			 config.getTargetId(),
                         config.getRuntimePath(),
                         config.getOutputDir(),
                         includeDirs,
                         errReporter,
                         monitor) ;
    else
    {
      EcoreWorkflowPilot xmlPilot = new EcoreWorkflowPilot(workflow);
      generator.generateWorkflow(sinst,
    		  					 config.getTargetId(),
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