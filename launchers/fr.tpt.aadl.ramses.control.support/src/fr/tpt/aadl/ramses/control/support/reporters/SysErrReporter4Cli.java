package fr.tpt.aadl.ramses.control.support.reporters;

import java.io.PrintStream ;

/**
 * 
 * This class doesn't encapsulate log4j in order to keep 
 * class and method name, code line informations when log4j is called.
 *
 */
public class SysErrReporter4Cli extends AbstractSystemErrReporter
{
  protected PrintStream _output ;
  protected PrintStream _err ;
  
  public SysErrReporter4Cli(PrintStream outputStream,
                            PrintStream errStream)
  {
    _output = outputStream ;
    _err = errStream ;
  }

  @Override
  public void fatal(String msg,
                    Throwable ex)
  {
    msg = super.formatFatalMsg(msg, ex) ;
    _err.println(msg) ;
  }

  @Override
  public void fatal(String msg)
  {
    msg = super.formatFatalMsg(msg) ;
    _err.println(msg) ;
  }

  @Override
  public void error(String msg, boolean isDelayed)
  {
    msg = super.formatErrorMsg(msg) ;
    
    if(isDelayed)
    {
      _delayedErrors.add(msg) ;
    }
    else
    {
      _err.println(msg) ;
    }
  }

  @Override
  public void warning(String msg, boolean isDelayed)
  {
    msg = super.formatWarningMsg(msg) ;
    
    if(isDelayed)
    {
      _delayedWarnings.add(msg) ;
    }
    else
    {
      _err.println(msg) ;
    }
  }

  @Override
  public void displayDelayedErrors()
  {
    String msg = super.formatDelayedErrors() ;
    if(msg != null)
    {
      _err.println(msg) ;
      _delayedErrors.clear();
      _delayedWarnings.clear();
    }
  }

  @Override
  public void abortOnAadlErrors(String msg)
  {
    msg = super.formatAbortionOnAadlErrors(msg) ;
    _output.println(msg) ;
  }
}