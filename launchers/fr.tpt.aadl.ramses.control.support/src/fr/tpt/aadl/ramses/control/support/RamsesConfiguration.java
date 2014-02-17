package fr.tpt.aadl.ramses.control.support;

import java.io.File ;
import java.io.FileNotFoundException ;

import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.control.support.generator.AbstractAadlToAadl ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;

import org.osate.utils.FileUtils ;

public class RamsesConfiguration
{
  // Directory where generated files are produced.
  private  File _outputDir;
  
  // Path to the platform runtime.
  private File _runtimePath = null ;
  
  // Execution platform  id.
  private String _targetId = null ;
  
  private static File _PREDEFINED_RESOUCE_DIR ;
  private static File _ATL_RESOURCE_DIR ;
  private static File _RAMSES_RESOURCE_DIR ;
  private static File _AADL_PACKAGE_DIR ;
  private static File _AADL_PROPERTYSET_DIR ;
  
  public static ConfigStatus setRamsesResourceDir(String path)
  {
    try
    {
      File resourceDir = fileChecker(path) ;
      
      if(AbstractPredefinedAadlModelManager.ramsesDirChecker(resourceDir))
      {
        _RAMSES_RESOURCE_DIR = resourceDir ;
        ConfigStatus.SET.msg = "Set RAMSES resource directory to \'" + path + "\'" ;
        return ConfigStatus.SET ;
      }
      else
      {
        ConfigStatus.NOT_VALID.msg = "\'" + path + "\' is not a valid RAMSES resource directory" ;
        return  ConfigStatus.NOT_VALID ;
      }
    }
    catch(ConfigurationException e)
    {
      return e.status ;
    }
  }
  
  public File getOutputDir()
  {
    return _outputDir ;
  }

  public File getRuntimePath()
  {
    return _runtimePath ;
  }

  public String getTargetId()
  {
    return _targetId ;
  }

  public static File getPredefinedResourceDir()
  {
    return _PREDEFINED_RESOUCE_DIR ;
  }

  public static File getAtlResourceDir()
  {
    return _ATL_RESOURCE_DIR ;
  }

  public static File getRamsesResourceDir()
  {
    return _RAMSES_RESOURCE_DIR ;
  }

  public static ConfigStatus setAtlResourceDir(String path)
  {
    try
    {
      File resourceDir = fileChecker(path) ;
      
      if(AbstractAadlToAadl.atlResourceDirChecker(resourceDir))
      {
        _ATL_RESOURCE_DIR = resourceDir ;
        ConfigStatus.SET.msg = "Set ATL resource directory to \'" + path + "\'" ;
        return ConfigStatus.SET ;
      }
      else
      {
        ConfigStatus.NOT_VALID.msg = "\'" + path + "\' is not a valid ATL resource directory" ;
        return ConfigStatus.NOT_VALID ;
      }
    }
    catch(ConfigurationException e)
    {
      return e.status ;
    }
  }
  
  public static ConfigStatus setPredefinedResourceDir(String path)
  {
    try
    {
      File resourceDir = fileChecker(path) ;
      
      if(AbstractPredefinedAadlModelManager.predefinedAadlModelDirChecker(resourceDir))
      {
        _PREDEFINED_RESOUCE_DIR = resourceDir ;
        
        _AADL_PACKAGE_DIR = new File(resourceDir + File.separator + Names.AADL_PREDEFINED_PACKAGE_DIR_NAME) ;
        _AADL_PROPERTYSET_DIR = new File(resourceDir + File.separator + Names.AADL_PREDEFINED_PROPERTIES_DIR_NAME) ;
        
        ConfigStatus.SET.msg = "Set AADL predefined resource directory to \'" + path + "\'" ;
        return ConfigStatus.SET ;
      }
      else
      {
        ConfigStatus.NOT_VALID.msg = "\'" + path + "\' is not a valid AADL predefined resource directory" ;
        return ConfigStatus.NOT_VALID ;
      }
    }
    catch(ConfigurationException e)
    {
      return e.status ;
    }
  }
  
  public ConfigStatus setOutputDir(String path)
  {
    if(! (path == null || path.isEmpty()))
    {
      File outputDir = new File(path) ;
      
      if(! outputDir.exists())
      {
        try
        {
          if(! outputDir.mkdirs())
          {
            ConfigStatus.NOT_VALID.msg = "Can't create the output directory at this location :" +  "\'" + path + "\'";
            return ConfigStatus.NOT_VALID ;
          }
        }
        catch(Exception e)
        {
          ConfigStatus.NOT_VALID.msg = "Can't create the output directory at this location :" +  "\'" + path + "\'. Because:\n\n\t" +
          e.getMessage() ;
          return ConfigStatus.NOT_VALID ;
        }
      }
      
      _outputDir = outputDir ;
      ConfigStatus.SET.msg = "Set output directory to \'" + path + "\'" ;
      return ConfigStatus.SET ;
    }
    else
    {
      ConfigStatus.NOT_VALID.msg = "Output directory is not configured" ;
      return ConfigStatus.NOT_VALID ;
    }
  }

  // path can be null.
  public ConfigStatus setRuntimePath(String path)
  {
    try
    {
      File runtimePath = null ;
      if(path != null)
      {
        runtimePath = fileChecker(path) ;
      }
      ServiceRegistry reg = ServiceRegistryProvider.getServiceRegistry() ;
      Generator gen = reg.getGenerator(_targetId) ;
      
      // The runtime path can be null.
      if(gen.runtimePathChecker(runtimePath))
      {
        _runtimePath = runtimePath ;
        ConfigStatus.SET.msg = "Set runtime path to \'" + path + "\'" ;
        return ConfigStatus.SET ;
      }
      else
      {
        String envPath = EnvUtils.getEnvVariable(gen.getRuntimePathEnvVar()) ;
        
        if(envPath != null)
        {
          runtimePath = fileChecker(envPath) ;
          if(gen.runtimePathChecker(runtimePath))
          {
            _runtimePath = runtimePath ;
            ConfigStatus.SET.msg = "Set runtime path to \'" + path + "\'" ;
            return ConfigStatus.SET ;
          }
          else
          {
            ConfigStatus.NOT_VALID.msg = "the $" + gen.getRuntimePathEnvVar() + " doesn't point to a valid runtime path" ;
            return ConfigStatus.NOT_VALID ;
          }
        }
        else
        { 
          String msg = "";
          
          if(path == null || path.isEmpty())
          {
            msg = "missing runtime path" ;
          }
          else
          {
            msg = "\'" + path + "\' is not a valid runtime path" ;
          }
          
          msg += " and $" + gen.getRuntimePathEnvVar() + " is not set" ;
          
          ConfigStatus.NOT_VALID.msg = msg ; 
          return ConfigStatus.NOT_VALID ;
        }
      }
    }
    catch(ConfigurationException e)
    {
      return e.status ;
    }
  }
  
  public ConfigStatus setGeneretionTargetId(String targetId)
  {
    ServiceRegistry reg = ServiceRegistryProvider.getServiceRegistry() ;
    Generator gen = reg.getGenerator(targetId) ;
    if(gen == null)
    {
      ConfigStatus.NOT_VALID.msg = "\'" + targetId + "\' is not a supported generation target" ;
      return ConfigStatus.NOT_VALID ;
    }
    else
    {
      _targetId = targetId ;
      ConfigStatus.SET.msg = "Set generation target id to \'" + targetId + "\'" ;
      return ConfigStatus.SET ;
    }
  }
  
  private static File fileChecker(String path) throws ConfigurationException
  {
    try
    {
      return FileUtils.stringToFile(path) ;
    }
    catch(FileNotFoundException e)
    {
      ConfigStatus.NOT_FOUND.msg = "\'" + path + "\' is not found" ;
      throw new ConfigurationException(ConfigStatus.NOT_FOUND) ;
    }
  }

  public static File getAadlPackageDir()
  {
    return _AADL_PACKAGE_DIR ;
  }

  public static File getAadlPropertysetDir()
  {
    return _AADL_PROPERTYSET_DIR ;
  }
}