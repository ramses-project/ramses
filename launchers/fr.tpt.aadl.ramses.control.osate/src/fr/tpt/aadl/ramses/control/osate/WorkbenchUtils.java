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
import java.util.Set ;

import org.eclipse.core.resources.IFile ;
import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IWorkspaceRoot ;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.IStatus ;
import org.eclipse.core.runtime.MultiStatus ;
import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.core.runtime.Status ;
import org.eclipse.jface.viewers.ISelection ;
import org.eclipse.jface.viewers.IStructuredSelection ;
import org.eclipse.swt.SWT ;
import org.eclipse.swt.widgets.Display ;
import org.eclipse.swt.widgets.Shell ;
import org.eclipse.ui.IEditorPart ;
import org.eclipse.ui.IFileEditorInput ;
import org.eclipse.ui.IWorkbench ;
import org.eclipse.ui.IWorkbenchPage ;
import org.eclipse.ui.IWorkbenchWindow ;
import org.eclipse.ui.PlatformUI ;
import org.eclipse.ui.statushandlers.StatusManager ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.FileUtils ;

import fr.tpt.aadl.ramses.control.support.config.ConfigStatus ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.reporters.SystemErrReporter ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public class WorkbenchUtils
{
  public static final String ANALYSIS_ERROR_REPORTER_MARKER = 
        "fr.tpt.ramses.control.osate" ;
  
  
  public static IEditorPart getActiveEditor()
  {
    IWorkbench wb = PlatformUI.getWorkbench();
    IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
    IWorkbenchPage page = win.getActivePage();

    return page.getActiveEditor();
  }
  
  public static void saveEditor(IEditorPart editor)
  {
    if (editor.isDirty())
    {
      editor.doSave(new NullProgressMonitor());
    }
  }
  
  // May return null !
  public static IProject getProjectByExplorer()
  {
    IProject result = null;
    
    IWorkbench wb = PlatformUI.getWorkbench();
    IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
    IWorkbenchPage page = win.getActivePage();

    ISelection sel = page.getSelection() ;
    
    if (sel instanceof IStructuredSelection)
    {
      IStructuredSelection structSel = (IStructuredSelection) sel ;
      
      if(structSel.getFirstElement() instanceof IProject)
      {
        result = (IProject) structSel.getFirstElement() ;
      }
    }
    
    return result ;
  }
  
  //May return null !
  public static IProject getProjectByActiveEditor()
  {
    IWorkbench wb = PlatformUI.getWorkbench();
    IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
    IWorkbenchPage page = win.getActivePage();
    IEditorPart activeEditor = page.getActiveEditor();
    IProject project = null;
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IProject projects[] = root.getProjects();
    for(IProject p : projects)
    {
      if(!p.getName().equals(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME))
      {
        if(p.isOpen())
        {
          activeEditor = page.getActiveEditor();

          if(activeEditor  != null)
          {
            IFileEditorInput input = (IFileEditorInput)activeEditor.getEditorInput() ;
            IFile file = input.getFile();
            IProject activeProject = file.getProject();
            String activeProjectName = activeProject.getName();
            if(p.getName().equals(activeProjectName))
            {
              project = p;
              break;
            }
          }
        }

      }
    }

    return project ;
  }
  
  public static Shell getCurrentShell()
  {
    Display display = Display.getCurrent();
    return new Shell(display, SWT.BORDER);
  }
  
  public static AnalysisErrorReporterManager getAnalysisErrReporterManager()
  {
    return new AnalysisErrorReporterManager(
               new MarkerAnalysisErrorReporter.Factory(
                   WorkbenchUtils.ANALYSIS_ERROR_REPORTER_MARKER)) ;
  }
  
  public static void setResourceDirectories() throws ConfigurationException
  {
    String ramsesDirPath = null ;
    
    try
    {
      ramsesDirPath = Aadl2Utils.getAbsolutePluginPath(Names.
                                      ATL_TRANSFORMATION_PLUGIN_ID).toString() ;
    }
    catch(Exception e)
    {
      ConfigStatus.NOT_FOUND.msg = e.getMessage() ;
      throw new ConfigurationException(ConfigStatus.NOT_FOUND) ;
    }
    
    RamsesConfiguration.setRamsesResourceDir(ramsesDirPath) ;
    RamsesConfiguration.setAtlResourceDir(ramsesDirPath) ;
    RamsesConfiguration.setPredefinedResourceDir(ramsesDirPath + File.separator + Names.AADL_RESOURCE_DIRECTORY_NAME) ;
  }
  
  //TODO provide an ui to select the include directories.
  // For the moment, only the directory that contains the aadl model is
  // included.
  public static Set<File> getIncludeDirs(IProject p)
  {
    String fullProjectPath = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toOSString() + p.getFullPath().toOSString() ;
    
    File projectPath = new File(fullProjectPath) ;
    
    Set<File> result = FileUtils.getSubDirectories(projectPath) ;
    
    result.add(projectPath) ;
    
    return result ;
  }

  public static void showGenerationReport()
  {
    SystemErrReporter errRep = ServiceProvider.SYS_ERR_REP  ;
    StringBuffer sb = new StringBuffer() ;
    IStatus status ;
    int style = StatusManager.BLOCK ;
    int code = IStatus.INFO ;
    sb.append("Code generation was successfully done") ;
   
    if(errRep.hasDelayedErrors())
    {
      sb.append(" with ") ;
      
      if(errRep.getNbWarnings() != 0)
      {
        sb.append(errRep.getNbWarnings()) ;
        sb.append(" warning(s)");
      }
      
      if(errRep.getNbErrors() != 0)
      {
        if(errRep.getNbWarnings() != 0)
        {
          sb.append(" and ") ;
        }
        
        sb.append(errRep.getNbErrors()) ;
        sb.append(" error(s)") ;
      }
      
      MultiStatus tmp = new MultiStatus(Activator.PLUGIN_ID, code,
                                           sb.toString(), null) ;
      
      for(String error : errRep.getDelayedErrors())
      {
        tmp.add(new Status(code, Activator.PLUGIN_ID, error));
      }
      
      for(String warning : errRep.getDelayedWarnings())
      {
        tmp.add(new Status(code, Activator.PLUGIN_ID, warning));
      }
       
      status = tmp ;
      style |= StatusManager.LOG ; 
      
      errRep.clearErrorsAndWarnings();
    }
    else
    {
      status = new Status(code, Activator.PLUGIN_ID, sb.toString()) ;
    }
    
    StatusManager.getManager().handle(status, style);
  }
}