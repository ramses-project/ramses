package fr.tpt.aadl.ramses.control.support;

import java.io.File ;
import java.io.FileNotFoundException ;

import org.apache.log4j.FileAppender ;
import org.apache.log4j.Level ;
import org.apache.log4j.Logger ;
import org.apache.log4j.PatternLayout ;
import org.osate.utils.FileUtils ;

import fr.tpt.aadl.ramses.control.support.generator.AbstractAadlToAadl ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

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
  
  private static Logger _LOGGER = Logger.getLogger(RamsesConfiguration.class) ;
  
  public static ConfigStatus setRamsesResourceDir(String path)
  {
    try
    {
      File resourceDir = fileChecker(path) ;
      
      if(AbstractPredefinedAadlModelManager.ramsesDirChecker(resourceDir))
      {
        _RAMSES_RESOURCE_DIR = resourceDir ;
        ConfigStatus.SET.msg = "set RAMSES resource directory to \'" + path + "\'" ;
        _LOGGER.info(ConfigStatus.SET.msg);
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
        ConfigStatus.SET.msg = "set ATL resource directory to \'" + path + "\'" ;
        _LOGGER.info(ConfigStatus.SET.msg);
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
        
        ConfigStatus.SET.msg = "set AADL predefined resource directory to \'" + path + "\'" ;
        _LOGGER.info(ConfigStatus.SET.msg);
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
            ConfigStatus.NOT_VALID.msg = "can't create the output directory at this location :" +  "\'" + path + "\'";
            return ConfigStatus.NOT_VALID ;
          }
        }
        catch(Exception e)
        {
          ConfigStatus.NOT_VALID.msg = "can't create the output directory at this location :" +  "\'" + path + "\'. Because:\n\n\t" +
          e.getMessage() ;
          return ConfigStatus.NOT_VALID ;
        }
      }
      
      _outputDir = outputDir ;
      ConfigStatus.SET.msg = "set output directory to \'" + path + "\'" ;
      _LOGGER.info(ConfigStatus.SET.msg);
      return ConfigStatus.SET ;
    }
    else
    {
      ConfigStatus.NOT_VALID.msg = "output directory is not configured" ;
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
      ServiceRegistry reg = ServiceProvider.getServiceRegistry() ;
      Generator gen = reg.getGenerator(_targetId) ;
      
      // The runtime path can be null.
      if(gen.runtimePathChecker(runtimePath))
      {
        _runtimePath = runtimePath ;
        ConfigStatus.SET.msg = "set runtime path to \'" + path + "\'" ;
        _LOGGER.info(ConfigStatus.SET.msg);
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
            ConfigStatus.SET.msg = "set runtime path to \'" + path + "\'" ;
            _LOGGER.info(ConfigStatus.SET.msg);
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
  
  public ConfigStatus setGenerationTargetId(String targetId)
  {
    ServiceRegistry reg = ServiceProvider.getServiceRegistry() ;
    Generator gen = reg.getGenerator(targetId) ;
    if(gen == null)
    {
      ConfigStatus.NOT_VALID.msg = "\'" + targetId + "\' is not a supported generation target" ;
      return ConfigStatus.NOT_VALID ;
    }
    else
    {
      _targetId = targetId ;
      ConfigStatus.SET.msg = "set generation target id to \'" + targetId + "\'" ;
      _LOGGER.info(ConfigStatus.SET.msg);
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
  
  /**
   * Setup RAMSES logging system. If loggingLevel is {@code null} or empty
   * or/and logFile is {@code null}, logging is turn off.
   * <br><br>
   * If the logging level is not recognize, it is set to DEBUG.
   * <br><br>
   * Level:<br>
   * <br>
   * ALL == TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
   * <br><br>
   * ALL, TRACE and DEBUG make logger to print extra informations (class name,
   * timestamp, method name, code line).
   * 
   * @see org.apache.log4j.Level
   * 
   * @param loggingLevel logging level
   * @param logFile the log file
   */
  public static void setupLogging(String loggingLevel,
                                  File logFile)
  {
    if(! (loggingLevel == null || loggingLevel.isEmpty() || logFile == null))
    {
      Logger rootLogger = Logger.getRootLogger() ;
      
      // Wipe out any previous appenders like the Eclipse' console appender.
      rootLogger.removeAllAppenders();
      
      Level lvl = Level.toLevel(loggingLevel) ;
      String layoutPattern ;
      
      switch(lvl.toInt())
      {
        case Level.ALL_INT:
        case Level.TRACE_INT:
        case Level.DEBUG_INT:
        {
          layoutPattern = "<%p> %m (%F::%M line %L ; %d)%n" ;
          break;
        }
        
        default:
        {
          layoutPattern = "<%p> %m%n" ;
        }
      }
            
      rootLogger.setLevel(lvl);
      
      // Configure Log4j.
      FileAppender fa = new FileAppender() ;
      PatternLayout layout = new PatternLayout(layoutPattern) ;
      fa.setLayout(layout);
      fa.setFile(logFile.toString());
      fa.setEncoding("UTF-8");
      fa.activateOptions();
      rootLogger.addAppender(fa);
      
      _LOGGER.info("logger is set to " + lvl.toString());
    }
    else
    {
      _LOGGER.info("logger is switch off") ;
      Logger.getRootLogger().setLevel(Level.OFF); ;
    }
  }
}