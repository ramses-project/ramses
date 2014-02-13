/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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
import java.util.Set ;

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
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter ;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.core.OsateCorePlugin ;
import org.osate.ui.dialogs.Dialog ;

import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.EcoreWorkflowPilot ;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl ;

public class GenerateActionHandler extends AbstractHandler {

  private static final String _JOB_NAME = "RAMSES code generation" ;
  
  protected static final InternalErrorReporter 
                                             internalErrorLogger = 
                                             new LogInternalErrorReporter
                                             (OsateCorePlugin
                                             .getDefault().getBundle());

  private static final String _OUTLINE_COMMAND_ID = 
                         "fr.tpt.aadl.ramses.control.osate.outline.generation" ;
//  private static final String MENU_OR_BUTTON_COMMAND_ID = 
//                        "fr.tpt.aadl.ramses.control.osate.instance.generation" ;
  
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException
  {
    IProject currentProject = WorkbenchUtils.getProjectResource() ;
    
    // Reinitialize the registry as include directors (eg projects directories),
    // may be added or deleted.

    // Fetch RAMSES configuration.
    RamsesConfiguration config = null ;
    try
    {
      config = RamsesPropertyPage.fetchProperties(currentProject) ;
    }
    catch (ConfigurationException ee)
    {
      if(RamsesPropertyPage.openPropertyDialog(currentProject))
      {
        try
        {
          // Reload configuration.
          config = RamsesPropertyPage.fetchProperties(currentProject) ;
        }
        catch (Exception e)
        {
          Dialog.showError("Configuration Error",
                           "Not enable to load RAMSES properties: \n\n" +
                           e.getMessage());
          
          // Abort generation. Error has already been reported at this point.
          return null ;
        }
      }
      else // User has canceled.
      {
        return null ;
      }
    }
    catch (CoreException e)
    {
      Dialog.showError("Configuration Error",
                       "Not enable to load RAMSES properties: \n\n" +
                       e.getMessage());
      
      // Abort generation. Error has already been reported at this point.
      return null ;
    }
    
    // if (config.checkForGeneration())
    {
      doGenerate(currentProject, event, config) ;
    }
    /*else // Configuration is missing.
    {
      // TODO report ?
      return null ;
    }
    */
    return null ;
  }
  
  private SystemInstance getSelectedSystemInstance(ExecutionEvent event)
  {
    ISelection s = HandlerUtil.getCurrentSelection(event) ;
    IFile node = (IFile) ((IStructuredSelection) s).getFirstElement() ;
    Resource resource = OsateResourceUtil.getResource((IResource) node) ;
    return (SystemInstance) resource.getContents().get(0) ;
  }
  
  private SystemImplementation getOutlineSelectedSystem(ExecutionEvent event,
                                                        IEditorPart editor)
                                                        throws Exception
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
      Dialog.showError("Model Instantiate", message);
      
      throw e ;
    }
    
    return result ;
  }
  
  private void jobCore( IProject currentProject,
                        ExecutionEvent event,
                        RamsesConfiguration config,
                        IProgressMonitor monitor
                      ) throws Exception
  {
    SystemInstance sysInstance = null ;
    
    // Make sur that this xtext editor is saved.
    IEditorPart editor = HandlerUtil.getActiveEditor(event) ;
    WorkbenchUtils.saveEditor(editor);
    
    ServiceRegistry sr = ServiceRegistryProvider.getServiceRegistry() ;
    AadlModelInstantiatior instantiator =sr.getModelInstantiatior() ;
    
    instantiator.setProgressMonitor(monitor);
    
    // For the executed command from outline menu,the system implementation 
    // root has to be instantiated prior to the code generation.
    if(_OUTLINE_COMMAND_ID.equals(event.getCommand().getId()))
    {
      SystemImplementation sysImpl = null ;
      // Fetch system implementation model.
      sysImpl = getOutlineSelectedSystem(event, editor) ;
      
      // Fetch instantiate the model.
      sysInstance = instantiator.instantiate(sysImpl) ;
    }
    else
    {
      // For executed command from the button or the RAMSES menu,system
      // implementation has already been instantiated.
      sysInstance = getSelectedSystemInstance(event) ;
    }
    
    generate(currentProject, sysInstance, config, monitor);
  }
  
  private void doGenerate(final IProject currentProject,
                          final ExecutionEvent event,
                          final RamsesConfiguration config)
  {
    Job job = new Job(_JOB_NAME)
    {
      @Override
      protected IStatus run(final IProgressMonitor monitor)
      {
        IStatus result = null ;
        
        final TransactionalEditingDomain domain =
              TransactionalEditingDomain.Registry.INSTANCE
                    .getEditingDomain("org.osate.aadl2.ModelEditingDomain") ;
        // We execute this command on the command stack because otherwise, we will
        // not have write permissions on the editing domain.
        RecordingCommand cmd = new RecordingCommand(domain)
        {
          protected void doExecute()
          {
            try
            {
              jobCore(currentProject, event, config, monitor) ;
              this.setLabel("OK");
            }
            catch(Exception e)
            {
              // TODO Manage with error reporter
              e.printStackTrace() ;
              this.setLabel("CANCEL");
            }
          }
        } ;

        try
        {
          ((TransactionalCommandStack) domain.getCommandStack()).execute(cmd,
                                                                         null) ;
        }
        catch(Exception e)
        {
          // TODO Manage with error reporter
          e.printStackTrace() ;
          result = Status.CANCEL_STATUS ;
        }
        finally
        {
          HookAccessImpl.cleanupTransformationTrace() ;
        }
        
        if(result == null)
        {
          result = ("OK".equals(cmd.getLabel())) ? Status.OK_STATUS :
                                                   Status.CANCEL_STATUS ; 
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
                        IProgressMonitor monitor)
                        throws Exception
  {
    try
    {
      ServiceRegistry registry;
      registry = ServiceRegistryProvider.getServiceRegistry() ;
      Generator generator = registry.getGenerator(config.getTargetId()) ;
      
      SystemImplementation sysImpl = sinst.getSystemImplementation() ;
      
      IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      
      // look for a workflow file
      Resource r = sysImpl.eResource();
      String s = r.getURI().segment(1);
      File rootDir = new File(workspaceRoot.getProject(s).getLocationURI());
      String workflow = GenerateActionUtils.findWorkflow(rootDir);
      
      AnalysisErrorReporterManager errReporter = 
                                WorkbenchUtils.getAnalysisErrReporterManager() ;
      
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
    catch (UnsupportedOperationException uoe)
    {
      Dialog.showError("Code Generation", "Operation is not supported:\n" +
                       uoe.getMessage());
      throw uoe ;
    }
    catch (Exception other)
    {
      other.printStackTrace();
      Dialog.showError("Code Generation", "Error when generating code:\n" +
                       other.getMessage());
      throw other ;
    }
  }
}