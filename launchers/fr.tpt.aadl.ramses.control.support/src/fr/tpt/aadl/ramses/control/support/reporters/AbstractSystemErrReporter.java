package fr.tpt.aadl.ramses.control.support.reporters;

import java.util.LinkedList ;

public abstract class AbstractSystemErrReporter implements SystemErrReporter
{
  protected LinkedList<String> _delayedErrors = new LinkedList<String>() ;
  protected LinkedList<String> _delayedWarnings = new LinkedList<String>() ;
  
  protected String formatFatalMsg(String initialMsg, Throwable ex)
  {
    StringBuilder sb = new StringBuilder() ;
    sb.append("<Fatal error> ");
    sb.append(initialMsg) ;
    sb.append(":\n\n\t") ;
    sb.append(ex.getMessage()) ;
    
    return sb.toString() ;
  }
  
  protected String formatFatalMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "<Fatal error> " + initialMsg ;
  }
  
  protected String formatErrorMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "<Error> " + initialMsg ;
  }
  
  protected String formatWarningMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "<Warning> " + initialMsg ;
  }
  
  protected String formatDelayedErrors()
  {
    if(!(_delayedErrors.isEmpty() && _delayedWarnings.isEmpty()))
    {
      // TODO to be refined.
      StringBuilder sb = new StringBuilder() ;
      
      sb.append("RAMSES system report:") ;
      
      if(false == _delayedErrors.isEmpty())
      {
        sb.append("\n\n\tErrors:\n\n");
        for(String msg : _delayedErrors)
        {
          sb.append("\t_ ") ;
          sb.append(msg) ;
        }
      }
      
      if(false == _delayedWarnings.isEmpty())
      {
        sb.append("\n\n\tWarnings:\n\n");
        for(String msg : _delayedWarnings)
        {
          sb.append("\t_ ") ;
          sb.append(msg) ;
        }
      }
      
      return sb.toString() ;
    }
    else
    {
      return null ;
    }
  }
  
  @Override
  public boolean hasDelayedErrors()
  {
    return (false == _delayedErrors.isEmpty()) ||
           (false == _delayedWarnings.isEmpty()) ; 
  }
  
  protected String formatAbortionOnAadlErrors(String initialMsg)
  {
    // TODO : to be refined.
    return initialMsg ;
  }
}