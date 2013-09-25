package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;

import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage;
import fr.tpt.aadl.ramses.control.support.EcorePilot;
import fr.tpt.aadl.ramses.control.support.WorkflowPilot;
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
    try
    {
      targetName = 
            resource.getPersistentProperty(new QualifiedName(RamsesPropertyPage.PREFIX, 
                                                             RamsesPropertyPage.TARGET_ID));
      
      if(targetName==null)
      {
        Dialog.showError("Code Generation Error",
              "Please select a target platform for generated code");
        return;
      }
      
      outputDirName = 
            resource.getPersistentProperty(new QualifiedName(RamsesPropertyPage.PREFIX, 
                                                             RamsesPropertyPage.PATH_ID));
      
      if(outputDirName==null)
      {
        Dialog.showError("Code Generation Error",
              "Please select an output directory for generated code");
        return;
      }
      
      ServiceRegistry registry = new OSGiServiceRegistry () ;
      Generator generator = registry.getGenerator(targetName) ;
      
      File outputDir = new File (outputDirName);
      
      
      try
      {
        
        URI resourceURI = URI.createPlatformPluginURI("fr.tpt.aadl.ramses.transformation.atl", false);
        java.net.URI uri = new java.net.URI(resourceURI.toString());
        URL url = FileLocator.toFileURL(uri.toURL());
        System.out.println("\nURI: " + uri + "\nFile URL: " + url);

        File resourceDir = new File(url.toURI()); 
        
        // look for a wokflow file
        Resource r = root.eResource();
        String s = r.getURI().segment(1);
        File rootDir = new File(workspaceRoot.getProject(s).getLocationURI());
        String workflow = GenerateActionUtils.findWorkflow(rootDir);
        if(workflow==null)
          generator.generate(root, 
                             resourceDir,
                             outputDir) ;
        else
        {
          EcorePilot xmlPilot = new EcorePilot(workflow);
          generator.generateWorkflow(root,
        		                     resourceDir,
        		                     outputDir,
        		                     xmlPilot);
          
        }
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
  

}
