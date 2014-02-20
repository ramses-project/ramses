package fr.tpt.aadl.ramses.control.osate;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractSystemMessageReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.Logger ;

public class SysMsgReporter4Osate extends AbstractSystemMessageReporter
{
  public SysMsgReporter4Osate(Logger logger)
  {
    super(logger) ;
  }
  
  @Override
  public void fatal(Object clazz,
                    int line,
                    String msg,
                    Throwable ex)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void fatal(Object clazz,
                    int line,
                    String msg)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void fatal(String msg)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void error(Object clazz,
                    int line,
                    String msg)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void error(String msg)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void warning(Object clazz,
                      int line,
                      String msg)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void warning(String msg)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void debug(Object clazz,
                    int line,
                    String msg)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void trace(String msg)
  {
    // TODO Auto-generated method stub
    
  }

}
