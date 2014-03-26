package fr.tpt.aadl.ramses.control.support.utils;

public interface Command
{
  public static final int UNSET = -1 ;
  
  // Process is terminated and was not been canceled.
  public static final int OK = 0 ;
  
  //Process was not terminated and has been canceled.
  public static final int CANCEL = 1 ;
  
  // Process is terminated but with an error.
  public static final int ERROR = 2 ;
  
  // Process failed on a fatal error: get the exception via WaitMonitor.
  public static final int FATAL = 3 ;
  
  public int runBlockingCommand() throws Exception ;
  
  public boolean isCanceled() ;
  
  public String getLabel() ;
}