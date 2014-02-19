package fr.tpt.aadl.ramses.control.support.reporters;

public interface InternalErrorReporter
{
  public void reportFatalError(Object clazz, int line, String msg, Throwable ex);
  
  public void reportError(Object clazz, int line, String msg) ;
  
  public void reportWarning(Object clazz, int line, String msg) ;
}
