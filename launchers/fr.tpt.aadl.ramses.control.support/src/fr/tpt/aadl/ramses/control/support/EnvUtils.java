package fr.tpt.aadl.ramses.control.support;

import org.apache.log4j.Logger ;

public class EnvUtils
{
  private static Logger _LOGGER = Logger.getLogger(EnvUtils.class) ; 
  
  public static String getEnvVariable(String envVarName)
  {
    String result = null ;
    
    if(envVarName != null)
    {
      result=System.getenv(envVarName);
      
      if(result==null || result=="")
      { 
        result = System.getProperty(envVarName);
        _LOGGER.trace("\'$" + envVarName + "\' environment variable returns: \'"+
                      result + '\'');
      }
    }

    return result ;
  }
}
