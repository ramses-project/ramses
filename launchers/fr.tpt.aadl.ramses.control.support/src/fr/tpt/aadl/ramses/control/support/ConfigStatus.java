package fr.tpt.aadl.ramses.control.support;

public enum ConfigStatus
{
  SET, NOT_FOUND, NOT_VALID ;
  
  public String msg ;
  
  private ConfigStatus(String msg)
  {
    this.msg = msg ;
  }
  
  private ConfigStatus()
  {
    this.msg  = "" ;
  }
}