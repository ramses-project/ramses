package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;

import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.OSGiServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;

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
        generator.generate(root, 
                           resourceDir,
                           outputDir) ;
      }
      catch(GenerationException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      catch(URISyntaxException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      catch(MalformedURLException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      catch(IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
    catch(CoreException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
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
  public void setParameters(Map<Enum<?>, String> parameters)
        throws Exception
  {
    // TODO Auto-generated method stub
    
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
