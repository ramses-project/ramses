package fr.tpt.aadl.sched.cheddar.events ;

import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

public class TaskSwitchEvent
{

  private final int preemptedUnit ;
  private final int preempterUnit ;

  private final TaskActivation preemptedActivation ;
  private final TaskActivation preempterActivation ;

  private final int tick ;

  public TaskSwitchEvent(
                         TaskActivation preemptedActivation,
                         TaskActivation preempterActivation, int preemptedUnit,
                         int preempterUnit, int tick)
  {
    this.preemptedActivation = preemptedActivation ;
    this.preempterActivation = preempterActivation ;
    this.preemptedUnit = preemptedUnit ;
    this.preempterUnit = preempterUnit ;
    this.tick = tick ;
  }

  public int getTick()
  {
    return tick ;
  }

  public int getPreemptedUnit()
  {
    return preemptedUnit ;
  }

  public int getPreempterUnit()
  {
    return preempterUnit ;
  }

  public TaskActivation getPreemptedActivation()
  {
    return preemptedActivation ;
  }

  public TaskActivation getPreempterActivation()
  {
    return preempterActivation ;
  }

  public CheddarTask getPreempted()
  {
    return getPreemptedActivation().getTask() ;
  }

  public CheddarTask getPreempter()
  {
    return getPreempterActivation().getTask() ;
  }

  public CheddarModel getModel()
  {
    return getPreempted().getModel() ;
  }

  public PreemptionKind getKind()
  {
    if(getPreempted().getOwner() == getPreempter().getOwner())
    {
      return PreemptionKind.Local ;
    }
    else
    {
      return PreemptionKind.Scheduler ;
    }
  }
}
