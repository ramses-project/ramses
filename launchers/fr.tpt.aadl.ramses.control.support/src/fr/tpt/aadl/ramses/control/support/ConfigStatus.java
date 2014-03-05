package fr.tpt.aadl.ramses.control.support;

public enum ConfigStatus
{
  SET ("data set", ""),
  NOT_FOUND ("data not found", ""),
  NOT_VALID ("data not valid", "")
  ;
  
  public String cardinal ; 
  public String msg ;
  
  private ConfigStatus(String cardinal, String msg)
  {
    this.msg = msg ;
  }
  
  private ConfigStatus()
  {
    this.msg  = "" ;
  }
}