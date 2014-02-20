package fr.tpt.aadl.ramses.control.support.reporters;

public abstract class AbstractSystemMessageReporter implements SystemMessageReporter 
{
  protected Logger _logger ;
  
  public AbstractSystemMessageReporter(Logger logger)
  {
    _logger = logger ;
  }
  
  protected String msgFormatter(Object clazz, int line, String msg)
  {
    // TODO to be implemented.
    //  _ handle date (specially for the delayed dump) ? 
    return msg ;
  }
}