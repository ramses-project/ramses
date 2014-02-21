package fr.tpt.aadl.ramses.control.support.reporters;

public interface SystemErrReporter
{
  /**
   * Log a fatal error (also display the exception stack trace).  
   * 
   * @param msg the error message
   * @param ex the exception that trigger the fatal error
   */
  public void fatal(String msg, Throwable ex) ;

  /**
   * Log a fatal error.
   * 
   * @param msg the error message
   */
  public void fatal(String msg) ;
  
  /**
   * Log an error that do not stop RAMSES.

   * @param msg the error message
   */
  public void error(String msg) ;
  
  /**
   * Log a warning.
   * 
   * @param msg the warning message
   */
  public void warning(String msg) ;
}