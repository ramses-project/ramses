package fr.tpt.aadl.ramses.control.support.reporters;

public abstract class AbstractSystemErrReporter implements SystemErrReporter
{
  protected String formatFatalMsg(String initialMsg, Throwable ex)
  {
    // TODO to be implemented.
    
    // DEBUG
    StringBuilder sb = new StringBuilder() ;
    
    sb.append(initialMsg) ;
    sb.append(":\n\\n\t") ;
    sb.append(ex.getMessage()) ;
    
    return sb.toString() ;
  }
  
  protected String formatFatalMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "Fatal error: " + initialMsg ;
  }
  
  protected String formatErrorMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "Error: " + initialMsg ;
  }
  
  protected String formatWarningMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "Warning: " + initialMsg ;
  }
}