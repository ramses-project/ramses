package fr.tpt.aadl.ramses.control.support.reporters;

public interface SystemErrReporter
{
  /**
   * Report a fatal error (also display the exception stack trace).  
   * 
   * @param msg the error message
   * @param ex the exception that trigger the fatal error
   */
  public void fatal(String msg, Throwable ex) ;

  /**
   * Report a fatal error.
   * 
   * @param msg the error message
   */
  public void fatal(String msg) ;
  
  /**
   * Report an error that do not stop RAMSES to execute.
   * If delayed is {@code true}, the message is stored and can be print 
   * via {@link #displayDelayedErrors()}. Otherwise, the error is printed at once.
   * 
   * @see #displayDelayedErrors()
   * @param msg the error message
   */
  public void error(String msg, boolean isDelayed) ;
  
  /**
   * Report a warning.
   * If delayed is {@code true}, the message is stored and can be print 
   * via {@link #displayDelayedErrors()}. Otherwise, the error is printed at once.
   * 
   * @param msg the warning message
   */
  public void warning(String msg, boolean isDelayed) ;
  
  /**
   * Show the delayed errors and warnings that don't abort RAMSES.
   * Do nothing if there is not any delayed error or warning.
   */
  public void displayDelayedErrors() ;
  
  /**
   * Returns {@code true} if the error reporter has delayed errors to be printed.
   * Otherwise, returns {@code false}. 
   * 
   * @return {@code true} if the error reporter has delayed errors to be printed.
   * Otherwise, returns {@code false}.
   */
  public boolean hasDelayedErrors() ;
  
  /**
   * Report an abortion on AADL errors (parsing, etc.).
   * 
   * @param msg the abortion message
   */
  public void abortOnAadlErrors(String msg) ;
}