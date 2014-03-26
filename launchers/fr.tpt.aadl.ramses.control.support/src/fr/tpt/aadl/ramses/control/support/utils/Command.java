package fr.tpt.aadl.ramses.control.support.utils;

public interface Command
{
  public static final int UNSET = -1 ;
  public static final int OK = 0 ;
  public static final int CANCEL = 1 ;
  public static final int ERROR = 2 ;
  public static final int FATAL = 3 ;
  
  public int runBlockingCommand() throws Exception ;
  
  public boolean isCanceled() ;
  
  public String getLabel() ;
}