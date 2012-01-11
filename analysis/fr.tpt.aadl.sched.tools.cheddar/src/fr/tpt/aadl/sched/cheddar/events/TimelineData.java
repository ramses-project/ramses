package fr.tpt.aadl.sched.cheddar.events ;

import java.util.HashMap ;
import java.util.List ;
import java.util.Set ;

import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

/**
 * Abstract scheduling simulation analyzer for a local CPU.
 * Specific schedulers can consider specific global time semantic.
 * @author Fabien Cadoret
 */
public abstract class TimelineData
{

  /** Processor. */
  protected final CheddarProcessor cpu ;

  /** Association Task -> Events. */
  protected final HashMap<CheddarTask, TaskActivation> taskToEvents =
        new HashMap<CheddarTask, TaskActivation>() ;

  protected SimulationData simulationData = null ;

  public TimelineData(
                      CheddarProcessor cpu)
  {
    this.cpu = cpu ;
  }

  void setSimulationData(SimulationData owner)
  {
    simulationData = owner ;
  }

  public CheddarProcessor getProcessor()
  {
    return cpu ;
  }

  public TaskActivation getEventsFor(CheddarTask task)
  {
    return taskToEvents.get(task) ;
  }

  public Set<CheddarTask> getRegisteredTasks()
  {
    return taskToEvents.keySet() ;
  }

  public abstract void addTaskActivation(CheddarTask task,
                                         int activationStart) ;

  public abstract void setTaskExecutionStart(CheddarTask task,
                                             int executionStart) ;

  public abstract void setTaskIsRunning(CheddarTask task,
                                        int tick) ;

  public abstract void setTaskExecutionEnd(CheddarTask task,
                                           int executionEnd) ;

  public abstract float getCPUUtilizationFactor() ;

  public abstract int getTotalRunning() ;

  public abstract CheddarTask getTaskRunningAt(int tick) ;

  /**
   * Returns the list of registered preemption events.
   * @return list of registered preemption events.
   */
  public abstract List<TaskSwitchEvent> getPreemptionEvents() ;

  public abstract TimelineData getDefault() ;

  public interface Factory
  {

    public TimelineData createFor(CheddarProcessor cpu) ;

  }
}
