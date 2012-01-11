package fr.tpt.aadl.sched.cheddar.events ;

import java.util.ArrayList ;

import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

public class TaskActivation
{

  /** Date of activation. */
  private int activationStart ;

  /** Date of execution start. */
  private int executionStart = -1 ;

  /** Date of execution end. */
  private int executionEnd = -1 ;

  /** Next activation. */
  private TaskActivation nextActivation = null ;

  /** Related task. */
  private CheddarTask task ;

  /** Indice of activation. */
  private int iActivation = 0 ;

  private final ArrayList<Integer> executionInstantsTab =
        new ArrayList<Integer>() ;
  private int[] executionInstants = null ;

  public TaskActivation(
                        int activationStart)
  {
    this.activationStart = activationStart ;
  }

  public void setExecutionStart(int executionStart)
  {
    this.executionStart = executionStart ;
  }

  public void addRunningInstant(int tick)
  {
    executionInstantsTab.add(tick) ;
  }

  public int[] getRunningInstants()
  {
    if(executionInstants == null)
    {
      computeExecutionInstantsAsArray() ;
    }

    return executionInstants ;
  }

  private synchronized void computeExecutionInstantsAsArray()
  {
    int size = executionInstantsTab.size() ;
    executionInstants = new int[size] ;

    for(int i = 0 ; i < size ; i++)
    {
      executionInstants[i] = executionInstantsTab.get(i).intValue() ;
    }
  }

  public void setExecutionEnd(int executionEnd)
  {
    this.executionEnd = executionEnd ;
    computeExecutionInstantsAsArray() ;
  }

  public void setTask(CheddarTask t)
  {
    task = t ;

    if(nextActivation != null)
    {
      nextActivation.setTask(task) ;
    }
  }

  public CheddarTask getTask()
  {
    return task ;
  }

  public void setNextActivation(TaskActivation next)
  {
    this.nextActivation = next ;

    if(nextActivation != null)
    {
      nextActivation.setTask(task) ;
    }

    setIndex(iActivation) ;
  }

  public TaskActivation getNext()
  {
    return nextActivation ;
  }

  public int getInstantForTick(int tick)
  {
    return executionInstantsTab.indexOf(tick) ;
  }

  public TaskActivation getLast()
  {
    if(nextActivation == null)
    {
      return this ;
    }
    else
    {
      return nextActivation.getLast() ;
    }
  }

  private void setIndex(int iActivation)
  {
    this.iActivation = iActivation ;

    if(nextActivation != null)
    {
      nextActivation.setIndex(iActivation + 1) ;
    }
  }

  public boolean currentDeadlineIsMissed()
  {
    return (executionEnd > getExpectedDeadline()) ||
          hasNotConsumedAllCapacity() ;
  }

  private boolean hasNotConsumedAllCapacity()
  {
    return ((task.getCapacity() > executionInstantsTab.size())) ;
  }

  public int getActivationIndex()
  {
    return iActivation ;
  }

  public int getExpectedDeadline()
  {
    return activationStart + task.getDeadline() ;
  }

  public TaskActivation getFirstMissedDeadline()
  {
    if(currentDeadlineIsMissed())
    {
      return this ;
    }
    else if(nextActivation != null)
    {
      return nextActivation.getFirstMissedDeadline() ;
    }
    else
    {
      return null ;
    }
  }

  /**
   * @return the activationStart
   */
  public int getActivationStart()
  {
    return activationStart ;
  }

  /**
   * @return the executionStart
   */
  public int getExecutionStart()
  {
    return executionStart ;
  }

  /**
   * @return the executionEnd
   */
  public int getExecutionEnd()
  {
    return executionEnd ;
  }

}
