package fr.tpt.aadl.ramses.control.cli;

import java.io.PrintStream ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractSystemMessageReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.Logger ;

public class SysMsgReporter4Cli extends AbstractSystemMessageReporter
{
  protected PrintStream _output ;
  protected PrintStream _err ;
  
  public SysMsgReporter4Cli(Logger logger, PrintStream outputStream,
                                           PrintStream errStream)
  {
    super(logger) ;
    _output = outputStream ;
  }
  
  @Override
  public void fatal(Object clazz,
                    int line,
                    String msg,
                    Throwable ex)
  {
   msg = super.msgFormatter(clazz, line, msg) ;
   if(false == _logger.hasConsoleOutputOn())
   {
     _err.println(msg) ;
   }
   _logger.fatal(msg, ex);
  }

  @Override
  public void fatal(Object clazz,
                    int line,
                    String msg)
  {
    fatal(super.msgFormatter(clazz, line, msg)) ;
  }
  
  @Override
  public void fatal(String msg)
  {
    if(false == _logger.hasConsoleOutputOn())
    {
      _err.println(msg) ;
    }
    _logger.fatal(msg);
  }

  @Override
  public void warning(Object clazz,
                      int line,
                      String msg)
  {
    warning(super.msgFormatter(clazz, line, msg)) ;
  }

  @Override
  public void error(Object clazz,
                    int line,
                    String msg)
  {
    error(super.msgFormatter(clazz, line, msg));
  }

  @Override
  public void error(String msg)
  {
    if(false == _logger.hasConsoleOutputOn())
    {
      _err.println(msg) ;
    }
    _logger.error(msg);
  }

  @Override
  public void warning(String msg)
  {
    if(false == _logger.hasConsoleOutputOn())
    {
      _output.println(msg) ;
    }
    _logger.warning(msg);
  }
  
  public void debug(Object clazz, int line, String msg)
  {
    msg = super.msgFormatter(clazz, line, msg) ;
    
    if(false == _logger.hasConsoleOutputOn())
    {
      _output.println(msg) ;
    }
    _logger.debug(msg);
  }
  
  public void trace(String msg)
  {
    if(false == _logger.hasConsoleOutputOn())
    {
      _output.println(msg) ;
    }
    _logger.trace(msg);
  }
}