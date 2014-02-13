package fr.tpt.aadl.ramses.control.osate;

import java.io.File ;
import java.util.Set ;

import org.eclipse.core.resources.IFile ;
import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IWorkspaceRoot ;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.swt.SWT ;
import org.eclipse.swt.widgets.Display ;
import org.eclipse.swt.widgets.Shell ;
import org.eclipse.ui.IEditorPart ;
import org.eclipse.ui.IFileEditorInput ;
import org.eclipse.ui.IWorkbench ;
import org.eclipse.ui.IWorkbenchPage ;
import org.eclipse.ui.IWorkbenchWindow ;
import org.eclipse.ui.PlatformUI ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.FileUtils ;

import fr.tpt.aadl.ramses.control.support.Names ;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;

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
  
  public static IProject getProjectResource()
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
  
  public static void setResourceDirectories() throws Exception
  {
    String ramsesDirPath = Aadl2Utils.getAbsolutePluginPath(Names.ATL_TRANSFORMATION_PLUGIN_ID).toString() ;
    RamsesConfiguration.setRamsesResourceDir(ramsesDirPath) ;
    RamsesConfiguration.setAtlResourceDir(ramsesDirPath) ;
    RamsesConfiguration.setPredefinedResourceDir(ramsesDirPath + File.separator + Names.AADL_RESOURCE_DIRECTORY_NAME) ;
  }
  
  //TODO provide an ui to select the include directories.
  // For the moment, only the directory that contains the aadl model is
  // included.
  public static Set<File> getIncludeDirs(IProject p) throws Exception
  {
    String fullProjectPath = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toOSString() + p.getFullPath().toOSString() ;
    
    File projectPath = new File(fullProjectPath) ;
    
    Set<File> result = FileUtils.getSubDirectories(projectPath) ;
    
    result.add(projectPath) ;
    
    return result ;
  }
}