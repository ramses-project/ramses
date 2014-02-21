package fr.tpt.aadl.ramses.control.cli.core;

import java.io.PrintStream ;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractProgressMonitor ;

public class RamsesProgressMonitor extends AbstractProgressMonitor
{
  protected PrintStream _output ;
  
  private Logger _logger = Logger.getLogger(RamsesProgressMonitor.class) ;
  
  public RamsesProgressMonitor(PrintStream stdOutput)
  {
    _output = stdOutput ;
  }
  
  @Override
  public void beginTask(String name,
                        int totalWork)
  {
    _mainTask = name ;
    _totalWork = totalWork ;
    String msg = super.formatBeginTask(name, totalWork) ;
    _logger.info(msg);
    _output.println(msg) ;
  }

  @Override
  public void done()
  {
    if(_isNotCanceled)
    {
      _isNotCanceled = false ; // According to the IProgressMonitor definition.
      String msg = super.formatDone(_mainTask) ;
      _logger.info(msg);
      _output.println(msg) ;
    }
  }

  @Override
  public void internalWorked(double work)
  {
    // TODO Auto-generated method stub
    System.out.println("############### internal worked is call : " + work) ;
  }

  @Override
  public boolean isCanceled()
  {
    return ! _isNotCanceled ;
  }

  @Override
  public void setCanceled(boolean value)
  {
    if(_isNotCanceled)
    {
      if(value)
      {
        _isNotCanceled = false ;
        String msg = super.formatCanceled(_mainTask) ;
        _logger.info(msg);
        _output.println(msg) ;
      }
    }
    // else do not set.
  }

  @Override
  public void setTaskName(String name)
  {
    _mainTask = name ;
  }

  @Override
  public void subTask(String name)
  {
    if(_isNotCanceled)
    {
      String msg = super.formatSubTask(name) ;
      _logger.info(msg);
      _output.println(msg) ;
    }
  }

  @Override
  public void worked(int work)
  {
    if(_isNotCanceled)
    {
      String msg = super.formatWorked(work, _totalWork) ;
      _logger.info(msg);
      _output.println(msg) ;
    }
  }
}