package fr.tpt.aadl.ramses.control.osate;

import org.eclipse.core.runtime.IProgressMonitor ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractProgressMonitor ;
import fr.tpt.aadl.ramses.control.support.reporters.Logger ;

public class ProgressMonitorWrapper extends AbstractProgressMonitor
{
  protected IProgressMonitor _monitor ;
  
  public ProgressMonitorWrapper(IProgressMonitor osateMonitor,
                                Logger logger)
  {
    super(logger) ;
    _monitor = osateMonitor ;
  }
  
  @Override
  public void beginTask(String name,
                        int totalWork)
  {
    if(false == _isNotCanceled)
    {
      _mainTask = name ;
      _totalWork = totalWork ;
      _monitor.beginTask(name, totalWork);
      String msg = super.formatBeginTask(name, totalWork) ;
      _logger.info(msg);
      _isNotCanceled = true ;
    }
  }

  @Override
  public void done()
  {
    if(_isNotCanceled)
    {
      _isNotCanceled = false ; // According to the IProgressMonitor definition.
      _monitor.done();
      String msg = super.formatDone(_mainTask) ;
      _logger.info(msg) ;
    }
  }

  @Override
  public void internalWorked(double work)
  {
    _monitor.internalWorked(work);
  }

  @Override
  public boolean isCanceled()
  {
    return false == _isNotCanceled ;
  }

  @Override
  public void setCanceled(boolean value)
  {
    if(_isNotCanceled)
    {
      if(value)
      {
        _isNotCanceled = false ;
        _monitor.setCanceled(true);
        String msg = super.formatCanceled(_mainTask) ;
        _logger.info(msg) ;
      }
    }
    // else do not set.
  }

  @Override
  public void setTaskName(String name)
  {
    _mainTask = name ;
    _monitor.setTaskName(name) ;
  }

  @Override
  public void subTask(String name)
  {
    if(_isNotCanceled)
    {
      _monitor.subTask(name) ;
      String msg = super.formatSubTask(name) ;
      _logger.info(msg) ;
    }
  }

  @Override
  public void worked(int work)
  {
    if(_isNotCanceled)
    {
      _monitor.worked(work);
      String msg = super.formatWorked(work, _totalWork) ;
      _logger.info(msg) ;
    }
  }
}