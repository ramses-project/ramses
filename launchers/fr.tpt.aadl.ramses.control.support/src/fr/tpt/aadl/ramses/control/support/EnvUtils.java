package fr.tpt.aadl.ramses.control.support;

public class EnvUtils
{
  public static String getEnvVariable(String envVarName)
  {
    String result = null ;
    
    if(envVarName != null)
    {
      result=System.getenv(envVarName);      
    }

    return result ;
  }
}
