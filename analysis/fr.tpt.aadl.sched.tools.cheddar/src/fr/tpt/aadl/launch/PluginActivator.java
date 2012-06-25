package fr.tpt.aadl.launch ;

import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.IOException ;
import java.io.InputStreamReader ;
import java.net.URL ;

import org.eclipse.core.runtime.FileLocator ;
import org.eclipse.core.runtime.Path ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.osgi.baseadaptor.BaseData ;
import org.eclipse.osgi.framework.internal.core.BundleHost ;
import org.eclipse.ui.plugin.AbstractUIPlugin ;
import org.osgi.framework.Bundle ;
import org.osgi.framework.BundleContext ;

import fr.tpt.aadl.ramses.control.core.RamsesConfiguration ;

@SuppressWarnings("restriction")
public class PluginActivator extends AbstractUIPlugin
{

  private static PluginActivator instance = null ;

  private Bundle bundle ;
  private String arinc653_template = "" ;
  private String cheddar_header = "" ;
  private String simulationDirectory = null ;

  public static PluginActivator getInstance()
  {
    if(instance == null)
    {
      instance = new PluginActivator() ;
    }

    return instance ;
  }

  public String getSimulationDirectory(Resource instance)
  {
    if(simulationDirectory == null && RamsesConfiguration.getOutputDir()!=null)
    {
      /*BundleHost bh = (BundleHost) bundle ;
      BaseData bd = (BaseData) bh.getBundleData() ;
      String path = bd.getBundleFile().getBaseFile().getAbsolutePath() ;
      simulationDirectory = path + "/simulation/" ;*/
      
      simulationDirectory = RamsesConfiguration.getOutputDir().getAbsolutePath() ;
    }
    if(simulationDirectory == null)
      simulationDirectory = instance.getURI().toFileString();
    
    return simulationDirectory ;
  }

  @Override
  public void start(BundleContext context)
        throws Exception
  {
    bundle = context.getBundle() ;
    instance = this ;
  }

  public String getARINC653Template()
        throws Exception
  {
    if(arinc653_template.isEmpty())
      arinc653_template = loadFileContent("resources/arinc653_template.sc") ;
    return arinc653_template ;
  }

  public String getCheddarHeader()
        throws Exception
  {
    if(cheddar_header.isEmpty())
      cheddar_header = loadFileContent("resources/cheddar_header.xml") ;
    return cheddar_header ;
  }

  private String loadFileContent(String path)
        throws IOException
  {
    
    BufferedReader reader =
          new BufferedReader(new FileReader(path));
    String buffer = "", line = "" ;

    while((line = reader.readLine()) != null)
    {
      buffer += line + "\n" ;
    }

    reader.close() ;
    return buffer ;
  }

  @Override
  public void stop(BundleContext context)
        throws Exception
  {
    bundle = null ;
    instance = null ;
  }

}
