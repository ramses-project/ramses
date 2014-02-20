package fr.tpt.aadl.ramses.control.support.reporters;


/**
 * 
 * NOT THREAD SAFE !!!
 * 
 * @see Logger
 *
 */
public interface SystemMessageReporter
{
  /**
   * Log a fatal error (also display the exception stack trace).  
   * 
   * @param clazz the faulty class
   * @param line the faulty instruction line
   * @param msg the error message
   * @param ex the exception that trigger the fatal error
   */
  public void fatal(Object clazz, int line, String msg, Throwable ex) ;

  /**
   * Log a fatal error.
   * 
   * @param clazz the faulty class
   * @param line the faulty instruction line
   * @param msg the error message
   */
  public void fatal(Object clazz, int line, String msg) ;
  
  /**
   * Log a fatal error.
   * 
   * @param msg the error message
   */
  public void fatal(String msg) ;
  
  /**
   * Log an error that do not stop RAMSES.
   * 
   * @param clazz the faulty class
   * @param line the faulty instruction line
   * @param msg the error message
   */
  public void error(Object clazz, int line, String msg) ;
  
  /**
   * Log an error that do not stop RAMSES.

   * @param msg the error message
   */
  public void error(String msg) ;
  
  /**
   * Log a warning.
   * 
   * @param clazz the faulty class
   * @param line the faulty instruction line
   * @param msg the warning message
   */
  public void warning(Object clazz, int line, String msg) ;
  
  /**
   * Log a warning.
   * 
   * @param msg the warning message
   */
  public void warning(String msg) ;
  
  /**
   * Log a debug trace.
   * 
   * @param clazz the considered class
   * @param line of an instruction
   * @param msg the trace message 
   */
  public void debug(Object clazz, int line, String msg) ;
  
  /**
   * Log a execution trace.
   * 
   * @param msg the trace message 
   */
  public void trace(String msg) ;
}