package fr.tpt.aadl.ramses.control.support.reporters;

public interface InternalLogger
{
  // Severity rule:
  // ALL == DEBUG < INFO < WARN < ERROR < FATAL < OFF
  public final static short OFF     = 0 ;
  public final static short FATAL   = 1 ;
  public final static short ERROR   = 2 ;
  public final static short WARNING = 3 ;
  public final static short TRACE   = 4 ;
  public final static short INFO    = 5 ;
  public final static short DEBUG   = 6 ;
  public final static short ALL     = 7 ;
  
  /**
   * Log a fatal error.
   * Format the given message and the given exception.   
   * 
   * @param msg the given error message
   * @param ex the given exception
   */
  public void error(String msg, Throwable ex) ;
  
  /**
   * Log an error message (not fatal).
   * 
   * @param msg the message to be logged
   */
  public void error(String msg) ;
  
  /**
   * Log a warning message.
   * 
   * @param msg the message to be logged
   */
  public void warning(String msg) ;
  
  /**
   * Log an execution trace.
   * 
   * @param trace the trace to be logged
   */
  public void trace(String trace) ;
  
  /**
   * Log an user information message.
   * 
   * @param msg the message to be logged
   */
  public void info(String msg) ;
  
  /**
   * Log a debug trace.
   * 
   * @param trace the message to be logged
   */
  public void debug(String trace) ;
  
  /**
   * Set the level of log message.
   * Displaying rule:
   * ALL == DEBUG < INFO < WARN < ERROR < FATAL < OFF
   * 
   * @param lvl
   */
  public void setLogLevel(short lvl) ;
}