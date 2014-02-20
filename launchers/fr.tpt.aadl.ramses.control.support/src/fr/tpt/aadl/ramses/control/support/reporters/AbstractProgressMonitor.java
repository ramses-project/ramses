package fr.tpt.aadl.ramses.control.support.reporters;

import org.eclipse.core.runtime.IProgressMonitor ;

public abstract class AbstractProgressMonitor implements IProgressMonitor
{
  protected Logger _logger ;
  protected String _mainTask ;
  protected boolean _isNotCanceled = false ;
  protected int _totalWork = 0;
  
  public AbstractProgressMonitor(Logger logger)
  {
    _logger = logger ;
  }
  
  protected String formatBeginTask(String name,
                                   int totalWork)
  {
    // TODO to be implemented.
    return "Begin task " + name ;
  }

  protected String formatDone(String task)
  {
    // TODO to be implemented.
    return "Task " + task + " is done" ;
  }

  protected String formatCanceled(String task)
  {
    return "Task " + task + " is canceled" ;
  }

  protected String formatSubTask(String name)
  {
    // TODO to be implemented.
    return "Begin sub task " + name ;
  }

  protected String formatWorked(int work, int totalWork)
  {
    // TODO to be implemented.
    if(totalWork != IProgressMonitor.UNKNOWN)
    {
      return "work " + work ;
    }
    else
    {
      return "work " + work + "out of " + totalWork ;
    }
  }
}