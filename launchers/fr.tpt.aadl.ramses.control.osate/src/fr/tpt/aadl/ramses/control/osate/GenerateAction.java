package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.lang.reflect.InvocationTargetException ;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit ;

import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.PreferenceDialog ;
import org.eclipse.jface.window.Window ;
import org.eclipse.swt.widgets.Display ;
import org.eclipse.ui.dialogs.PreferencesUtil ;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;

import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage;
import fr.tpt.aadl.ramses.control.support.EcorePilot;
import fr.tpt.aadl.ramses.control.support.Names;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.OSGiServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;

public class GenerateAction extends AbstractAnalyzer
{
  
  private static final String ACTION_NAME = "Generate Code" ;
  private static final String GENERATOR_NAME = "RAMSES" ;
  private final static String PLUGIN_NAME = "Ramses4Osate" ;
  private final static String PLUGIN_ID = "fr.tpt.aadl.ramses.control.osate" ;
  private Set<File> _includeDirSet = null;
  private static final String OUTPUT_DIR_OPTION_ID = "output_directory" ;
//  private static final String SOURCE_MODELS_OPTION_ID = "source_models" ;
//  private static final String SYSTEM_TO_INSTANTIATE_OPTION_ID =
//	        "system_to_instantiate" ;
//  private static final String INCLUDES_OPTION_ID = "include_directories" ;
  private static String RAMSES_DIR ;
  private static String outputDirPath = "/output";
  
  
  
  @Override
  protected void analyzeDeclarativeModel(IProgressMonitor monitor,
                                         AnalysisErrorReporterManager errManager,
                                         Element declarativeObject)
  {
    Dialog.showError("Code Generation Error",
          "Please select an instance model");
  }

  @Override
  protected void analyzeInstanceModel(IProgressMonitor monitor,
                                      AnalysisErrorReporterManager errManager,
                                      SystemInstance root,
                                      SystemOperationMode som)
  {
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    String workspaceURI = root.eResource().getURI().toString();
    if(workspaceURI.startsWith("platform:/resource"))
    	workspaceURI = workspaceURI.substring(18);
    
    IResource resource=workspaceRoot.findMember(workspaceURI);
    
    String targetName = null;
    String outputDirName = null;
    String outputPathName = null;
    boolean flag = false;
    IProject project = resource.getProject();
    int loop = 0;
    RamsesConfiguration.setCurrentProject(project);
    RamsesConfiguration.setRamsesMonitor(monitor);
    try
    {
      while(true)
      {
        loop++;
        targetName = 
              project.getPersistentProperty(new QualifiedName(RamsesPropertyPage.PREFIX, 
                                                              RamsesPropertyPage.TARGET_ID));

        outputDirName = 
              project.getPersistentProperty(new QualifiedName(RamsesPropertyPage.PREFIX, 
                                                              RamsesPropertyPage.PATH_ID));

        outputPathName = 
              project.getPersistentProperty(new QualifiedName(RamsesPropertyPage.PREFIX, 
                                                              RamsesPropertyPage.PLATFORM_PATH));
        if((outputPathName==null)||(outputDirName==null)||(targetName==null))
        { 
          if(loop > 1)
            return;
          
          Display.getDefault().syncExec(new Runnable() {
            public void run() {
              PreferenceDialog prefDiag = PreferencesUtil.
                    createPropertyDialogOn(getShell(), RamsesConfiguration.getCurrentProject(),
                                           "fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage",
                                           null, null);
              if(prefDiag.open() == Window.CANCEL)
              {
                return;
              }
            }
          });
        }
        else
          break;
      }
      System.out.println("targetName = "+targetName) ;
      System.out.println("outputDirName = "+outputDirName) ;
      System.out.println("outputPathName = "+outputPathName) ;
      
      
      IProgressMonitor ramsesMonit = RamsesConfiguration.getRamsesMonitor();
      ramsesMonit.beginTask("This process may take several seconds...", 3);
      ramsesMonit.subTask("Transformation model ...");
//      RamsesConfiguration.setMonitMessage("Transformation model ...");
      RamsesConfiguration.waitUnitOfTime(1);
      
      RamsesConfiguration.setRuntimeDir(outputPathName);
      
      ServiceRegistry registry = new OSGiServiceRegistry () ;
      Generator generator = registry.getGenerator(targetName) ;
      
      File outputDir = new File (outputDirName);
      RamsesConfiguration.setOutputDir(outputDir);
      
      try
      {
        
        URI resourceURI = URI.createPlatformPluginURI("fr.tpt.aadl.ramses.transformation.atl", false);
        java.net.URI uri = new java.net.URI(resourceURI.toString());
        URL url = FileLocator.toFileURL(uri.toURL());
        System.out.println("\nURI: " + uri + "\nFile URL: " + url);

        File resourceDir = new File(url.toURI()); 
      
  	  	try {
  		  RamsesConfiguration.setRamsesResourcesDir(resourceDir);
  	  	} catch (Exception e) {
  		  // TODO Auto-generated catch block
  		  e.printStackTrace();
  	  	}

  	  	RamsesConfiguration.setIncludeDir(root.getSystemImplementation().eResource(), _includeDirSet, targetName);
  	  	
  	  	
        // look for a wokflow file
        Resource r = root.eResource();
        String s = r.getURI().segment(1);
        File rootDir = new File(workspaceRoot.getProject(s).getLocationURI());
        String workflow = GenerateActionUtils.findWorkflow(rootDir);
        
//        RamsesConfiguration.setRamsesMonitor(ramsesMonit);
        if(workflow==null)
        {
          generator.generate(root,         
                             resourceDir,
                             outputDir) ;
        }
        else
        {
          EcorePilot xmlPilot = new EcorePilot(workflow);
          generator.generateWorkflow(root,
        		                     resourceDir,
        		                     outputDir,
        		                     xmlPilot);
          
        }
        //End of progressbar
        ramsesMonit.worked(1);
        
        ResourcesPlugin.getWorkspace().getRoot().
        	refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
      }
      catch(GenerationException e)
      {
        Dialog.showError("Code Generation Error ", "See stack trace in console");
  	  	e.printStackTrace();
      }
      catch(Exception e)
      {
    	  Dialog.showError("Internal Error", "See stack trace in console");
    	  e.printStackTrace();
      }
      
    }
    catch(Exception e)
    {
    	Dialog.showError("Internal Error ", "See stack trace in console");
  	  	e.printStackTrace();
    }
    finally {
		HookAccessImpl.cleanupTransformationTrace();
	}
    
  }
  
  @Override
  protected String getActionName()
  {
    return ACTION_NAME ;
  }

  @Override
  protected Bundle getBundle() {
    return Activator.getDefault().getBundle();
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    throw new UnsupportedOperationException () ;
  }

  @Override
  public String getRegistryName()
  {
    return GENERATOR_NAME;
  }

  @Override
  public String getPluginName()
  {
    return PLUGIN_NAME;
  }

  @Override
  public String getPluginId()
  {
    return PLUGIN_ID;
  }
  
  private static File getPublicAADLResourcesDir(String transformationDirName)
		  throws Exception
  {
	  File transformationDir = getPublicVerifiedPath(transformationDirName) ;
	  File aadlResourcesDir =
			  new File(transformationDir.getAbsolutePath() + '/' +
					  Names.AADL_RESOURCE_DIRECTORY_NAME) ;

	  if(aadlResourcesDir.exists() == false)
	  {
		  throw new Exception("ERROR: file " + transformationDirName +
				  " does not contain " + Names.AADL_RESOURCE_DIRECTORY_NAME +
				  " directory") ;
	  }

	  return aadlResourcesDir ;
	}

  private static File getPublicVerifiedPath(String filePath) throws Exception
  {
	  File potentialFile = new File(filePath) ;

	  if(potentialFile.exists())
	  {
		  return potentialFile ;
	  }

	  throw new Exception("file or directory " + potentialFile.getCanonicalPath() +
			  " could not be found") ;
  }

}
