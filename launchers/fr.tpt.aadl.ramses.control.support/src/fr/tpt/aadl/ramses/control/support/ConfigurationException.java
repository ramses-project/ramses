package fr.tpt.aadl.ramses.control.support;

public class ConfigurationException extends Exception
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L ;
  public ConfigStatus status ;
  
  public ConfigurationException (ConfigStatus status)
  {
    this.status = status ; 
  }
  
  @Override
  public String getMessage()
  {
    return "configuration failed: " + status.msg + " (" + status.cardinal + ')' ;
  }
}