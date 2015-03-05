/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
 
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

  public TaskSwitchEvent(TaskActivation preemptedActivation,
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