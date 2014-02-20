package fr.tpt.aadl.ramses.control.cli;

import java.io.File ;

import org.apache.log4j.ConsoleAppender ;
import org.apache.log4j.Level ;
import org.apache.log4j.SimpleLayout ;

import fr.tpt.aadl.ramses.control.support.reporters.Logger ;

/**
 * 
 * TODO: configure by the log4j config file. 
 *
 */

public class Logger4Cli implements Logger
{
  private final static String _LOG_FILE_NAME = "ramses.log" ;
  
  private final static org.apache.log4j.Logger _INT_LOGGER = 
                           org.apache.log4j.Logger.getLogger(Logger4Cli.class) ;
  
  private final static ConsoleAppender _CA = new ConsoleAppender() ;
  
  private boolean _isConsolOutputOn = false ;
  
  static
  {
    _CA.setLayout(new SimpleLayout());
    _CA.activateOptions();
  }
  
  public Logger4Cli()
  {
  }

  @Override
  public void fatal(String msg, Throwable ex)
  {
    _INT_LOGGER.fatal(msg, ex);
  }
  
  @Override
  public void fatal(String msg)
  {
    _INT_LOGGER.fatal(msg);
  }

  @Override
  public void error(String msg)
  {
    _INT_LOGGER.error(msg) ;
  }

  @Override
  public void warning(String msg)
  {
    _INT_LOGGER.warn(msg) ;
  }

  @Override
  public void debug(String msg)
  {
    _INT_LOGGER.debug(msg) ;
  }

  @Override
  public void trace(String msg)
  {
    _INT_LOGGER.trace(msg) ;
  }

  @Override
  public void info(String msg)
  {
    _INT_LOGGER.info(msg) ;
  }

  @Override
  public void setLogLevel(short lvl)
  {
    Level l ;
    
    switch(lvl)
    {
      case Logger.FATAL:
      {
        l = Level.FATAL ;
        break ;
      }
      
      case Logger.ERROR:
      {
        l = Level.ERROR ;
        break ;
      }
      
      case Logger.WARNING:
      {
        l = Level.WARN ;
        break ;
      }
      
      case Logger.INFO:
      {
        l = Level.INFO ;
        break ;
      }
      
      case Logger.DEBUG:
      {
        l = Level.DEBUG ;
        break ;
      }
      
      case Logger.TRACE:
      {
        l = Level.TRACE ;
        break ;
      }
      
      case Logger.ALL:
      default:
      {
        l = Level.ALL ;
        break ;
      }
    }
    
    _INT_LOGGER.setLevel(l);    
  }

  @Override
  public void setConsoleOutput(boolean isOn)
  {
    if(isOn && (! _isConsolOutputOn))
    {
      _INT_LOGGER.addAppender(_CA);
      _isConsolOutputOn = true ;
    }
    else if(_isConsolOutputOn && (! isOn))
    {
      _INT_LOGGER.removeAppender(_CA);
      _isConsolOutputOn = false ;
    }
    // else nothing to do.
  }

  @Override
  public boolean hasConsoleOutputOn()
  {
    return _isConsolOutputOn ;
  }
}