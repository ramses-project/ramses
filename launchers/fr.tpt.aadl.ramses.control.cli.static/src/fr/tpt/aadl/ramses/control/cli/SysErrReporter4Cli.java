package fr.tpt.aadl.ramses.control.cli;

import java.io.PrintStream ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractSystemErrReporter ;

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
  public void error(String msg)
  {
    msg = super.formatErrorMsg(msg) ;
    _err.println(msg) ;
  }

  @Override
  public void warning(String msg)
  {
    msg = super.formatWarningMsg(msg) ;
    _err.println(msg) ;
  }
}