package fr.tpt.aadl.ramses.control.cli.core;

import java.io.PrintStream ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractProgressMonitor ;
import fr.tpt.aadl.ramses.control.support.reporters.Logger ;

public class RamsesProgressMonitor extends AbstractProgressMonitor
{
  protected PrintStream _output ;
  
  public RamsesProgressMonitor(Logger logger, PrintStream outputStream)
  {
    super(logger) ;
    _output = outputStream ;
  }
  
  @Override
  public void beginTask(String name,
                        int totalWork)
  {
    if(! _isNotCanceled)
    {
      _mainTask = name ;
      _totalWork = totalWork ;
      String msg = super.formatBeginTask(name, totalWork) ;
      if(false == _logger.hasConsoleOutputOn())
      {
        _output.println(msg) ;
      }
      _logger.info(msg) ;
      _isNotCanceled = true ;
    }
  }

  @Override
  public void done()
  {
    if(_isNotCanceled)
    {
      _isNotCanceled = false ; // According to the IProgressMonitor definition.
      String msg = super.formatDone(_mainTask) ;
      if(false == _logger.hasConsoleOutputOn())
      {
        _output.println(msg) ;
      }
      _logger.info(msg) ;
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
        if(false == _logger.hasConsoleOutputOn())
        {
          _output.println(msg) ;
        }
        _logger.info(msg) ;
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
      if(false == _logger.hasConsoleOutputOn())
      {
        _output.println(msg) ;
      }
      _logger.info(msg) ;
    }
  }

  @Override
  public void worked(int work)
  {
    if(_isNotCanceled)
    {
      String msg = super.formatWorked(work, _totalWork) ;
      if(false == _logger.hasConsoleOutputOn())
      {
        _output.println(msg) ;
      }
      _logger.info(msg) ;
    }
  }
}