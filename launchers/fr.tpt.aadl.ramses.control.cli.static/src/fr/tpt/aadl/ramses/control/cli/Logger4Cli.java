package fr.tpt.aadl.ramses.control.cli;

import java.io.File ;

import org.apache.log4j.ConsoleAppender ;
import org.apache.log4j.Level ;
import org.apache.log4j.SimpleLayout ;
import org.apache.log4j.Logger ;

import fr.tpt.aadl.ramses.control.support.reporters.InternalLogger ;

/**
 * 
 * TODO: configure by the log4j config file. 
 *
 */

public class Logger4Cli implements InternalLogger
{
  private final static String _LOG_FILE_NAME = "ramses.log" ;
  
  private final static Logger _INT_LOGGER = Logger.getLogger(Logger4Cli.class) ;
  
  public Logger4Cli()
  {
    /**** DEBUG ****/
    ConsoleAppender ca = new ConsoleAppender() ;
    ca.setLayout(new SimpleLayout());
    ca.activateOptions();
    /***************/
    _INT_LOGGER.addAppender(ca);
  }

  @Override
  public void error(String msg, Throwable ex)
  {
    _INT_LOGGER.fatal(msg, ex);
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
      case InternalLogger.FATAL:
      {
        l = Level.FATAL ;
        break ;
      }
      
      case InternalLogger.ERROR:
      {
        l = Level.ERROR ;
        break ;
      }
      
      case InternalLogger.WARNING:
      {
        l = Level.WARN ;
        break ;
      }
      
      case InternalLogger.TRACE:
      {
        l = Level.TRACE ;
        break ;
      }
      
      case InternalLogger.INFO:
      {
        l = Level.INFO ;
        break ;
      }
      
      case InternalLogger.DEBUG:
      {
        l = Level.DEBUG ;
        break ;
      }
      
      case InternalLogger.ALL:
      default:
      {
        l = Level.ALL ;
        break ;
      }
    }
    
    _INT_LOGGER.setLevel(l);    
  }
}