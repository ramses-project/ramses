package fr.tpt.aadl.ramses.control.support.reporters;

import java.util.LinkedList ;

/**
 * 
 * NOT THREAD SAFE !!!
 * 
 * Internal Logger wrapper. It handles delayed message logging.
 * 
 * @see InternalLogger
 *
 */
public class RamsesLogger
{
  protected boolean _streamMode = false ;
  
  protected InternalLogger _internalLogger ;
  
  protected LinkedList<Msg> _msgList = new LinkedList<Msg>() ; 
  
  public RamsesLogger(InternalLogger internalLogger)
  {
    _internalLogger = internalLogger ;
  }
  
  protected class Msg
  {
    public String msg ;
    public short severity ;
    
    public Msg(short severity, String msg)
    {
      this.severity = severity ;
      this.msg = msg ;
    }
  }
    
  protected void dump()
  {
    Msg msg ;
    
    while((msg = _msgList.pollFirst()) != null)
    {
      switch(msg.severity)
      {
        case InternalLogger.DEBUG:
        {
          _internalLogger.debug(msg.msg);
          break ;
        }
        
        case InternalLogger.TRACE:
        {
          _internalLogger.trace(msg.msg);
          break ;
        }
        
        case InternalLogger.INFO:
        {
          _internalLogger.info(msg.msg);
          break ;
        }
      }
    }
    
    _streamMode = true ;
    _msgList.clear() ;
  }
  
  /**
   * If the stream mode is on ({@code true}), every log message is written in
   * the log stream at once. Otherwise ({@code false}), the log messages will
   * be written only if an error (FATAL or ERROR severities) is log.
   * 
   * @param isOn
   */
  public void setStreamMode(boolean isOn)
  {
    _streamMode = isOn ;
  }
  
  /**
   * Log a fatal error (also display the exception stack trace).  
   * This switch automatically to the stream mode.
   * 
   * @see #setStreamMode(boolean)
   * 
   * @param clazz the faulty class
   * @param line the faulty instruction line
   * @param msg the error message
   * @param ex the exception that trigger the fatal error
   */
  public void error(Object clazz, int line, String msg, Throwable ex)
  {
    msg = msgFormatter(clazz, line, msg, ex) ;
    dump();
    _internalLogger.error(msg, ex);
  }

  /**
   * Log an error that do not stop RAMSES.
   * This switch automatically to the stream mode.
   * 
   * @see #setStreamMode(boolean)
   * 
   * @param clazz the faulty class
   * @param line the faulty instruction line
   * @param msg the error message
   */
  public void error(Object clazz, int line, String msg)
  {
    msg = msgFormatter(clazz, line, msg) ;
    dump();
    _internalLogger.error(msg);
  }
  
  /**
   * Log a warning.
   * 
   * @param clazz the faulty class
   * @param line the faulty instruction line
   * @param msg the warning message
   */
  public void warning(Object clazz, int line, String msg)
  {
    msg = msgFormatter(clazz, line, msg) ;
    
    if(_streamMode)
    {
      _internalLogger.warning(msg);
    }
    else
    {
      _msgList.addLast(new Msg(InternalLogger.WARNING, msg)) ;
    }
  }
  
  /**
   * Log a execution trace.
   * 
   * @param clazz the considered class
   * @param line of an instruction
   * @param msg the trace message 
   */
  public void trace(Object clazz, int line, String msg)
  {
    msg = msgFormatter(clazz, line, msg) ;
    
    if(_streamMode)
    {
      _internalLogger.trace(msg);
    }
    else
    {
      _msgList.addLast(new Msg(InternalLogger.TRACE, msg)) ;
    }
  }
  
  /**
   * Log a user message.
   * 
   * @param msg the user message 
   */
  public void info(String msg)
  {
    if(_streamMode)
    {
      _internalLogger.info(msg);
    }
    else
    {
      _msgList.addLast(new Msg(InternalLogger.INFO, msg)) ;
    }
  }
  
  /**
   * Log a debug trace.
   * 
   * @param clazz the considered class
   * @param line of an instruction
   * @param msg the trace message 
   */
  public void debug(Object clazz, int line, String msg)
  {
    msg = msgFormatter(clazz, line, msg) ;
    
    if(_streamMode)
    {
      _internalLogger.debug(msg);
    }
    else
    {
      _msgList.addLast(new Msg(InternalLogger.DEBUG, msg)) ;
    }
  }
  
  protected String msgFormatter(Object clazz, int line, String msg)
  {
    // TODO to be implemented.
    //  _ handle date (specially for the delayed dump) ? 
    return msg ;
  }
  
  protected String msgFormatter(Object clazz,
                              int line,
                              String msg,
                              Throwable ex)
  {
    // TODO Auto-generated method stub
    return msg ;
  }
}