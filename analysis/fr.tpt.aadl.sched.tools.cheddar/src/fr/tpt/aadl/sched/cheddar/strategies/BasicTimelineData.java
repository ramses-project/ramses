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
 
 package fr.tpt.aadl.sched.cheddar.strategies ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;

import fr.tpt.aadl.sched.cheddar.events.TaskActivation ;
import fr.tpt.aadl.sched.cheddar.events.TaskSwitchEvent ;
import fr.tpt.aadl.sched.cheddar.events.TimelineData ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

/**
 * Simulation analyzer for standard scheduling on a processor.
 * @author Fabien Cadoret
 */
public class BasicTimelineData extends TimelineData
{
  /** Defines which task is activated on each tick. */
  private HashMap<Integer, TaskActivation> tickToTaskActivation =
        new HashMap<Integer, TaskActivation>() ;

  /** Association Task -> Current activation. */
  private final HashMap<CheddarTask, TaskActivation> taskToCurrentActivation =
        new HashMap<CheddarTask, TaskActivation>() ;

  private int totalRunning = 0 ;

  public BasicTimelineData(CheddarProcessor cpu)
  {
    super(cpu) ;
  }

  public void addTaskActivation(CheddarTask task,
                                int activationStart)
  {
    TaskActivation newActivation = new TaskActivation(activationStart) ;
    TaskActivation firstActivation = taskToEvents.get(task) ;

    if(firstActivation == null)
    {
      newActivation.setTask(task) ;
      taskToEvents.put(task, newActivation) ;
    }
    else
    {
      firstActivation.getLast().setNextActivation(newActivation) ;
    }

    if(taskToCurrentActivation.get(task) == null)
    {
      taskToCurrentActivation.put(task, newActivation) ;
    }
  }

  private TaskActivation getCurrentActivation(CheddarTask t)
  {
    return taskToCurrentActivation.get(t) ;
  }

  public void setTaskExecutionStart(CheddarTask task,
                                    int executionStart)
  {
    TaskActivation events = getCurrentActivation(task) ;
    events.setExecutionStart(executionStart) ;
  }

  @Override
  public void setTaskIsRunning(CheddarTask task,
                               int tick)
  {
    TaskActivation events = getCurrentActivation(task) ;
    events.addRunningInstant(tick) ;
    tickToTaskActivation.put(tick, events) ;
    totalRunning++ ;
  }

  @Override
  public void setTaskExecutionEnd(CheddarTask task,
                                  int executionEnd)
  {
    //TaskActivation events = getEventsFor(task).getLast();
    TaskActivation events = getCurrentActivation(task) ;
    events.setExecutionEnd(executionEnd) ;
    taskToCurrentActivation.put(task, events.getNext()) ;
  }

  @Override
  public List<TaskSwitchEvent> getPreemptionEvents()
  {
    List<TaskSwitchEvent> preemptions = new ArrayList<TaskSwitchEvent>() ;

    for(CheddarTask t : getRegisteredTasks())
    {
      /** First event is the first activation of the task. */
      TaskActivation currentActivation = getEventsFor(t) ;

      while(currentActivation != null)
      {
        int[] running = currentActivation.getRunningInstants() ;

        //Context switch due to preemption

        if(running.length > 1)
        {
          for(int i = 1 ; i < running.length ; i++)
          {
            int r0 = running[i - 1] ;
            int r1 = running[i] ;

            if(r1 != r0 + 1)
            {
              TaskSwitchEvent p = null ;
              p = createTaskSwitchEvent(currentActivation, r0 + 1, i - 1) ;
              preemptions.add(p) ;
            }
          }
        }

        // Context switch due to replenishment

        if(running.length > 0)
        {
          int lastRunning = running[running.length - 1] ;
          TaskActivation other = tickToTaskActivation.get(lastRunning + 1) ;

          if((other != null) && (other.getTask() != t))
          {
            TaskSwitchEvent p = null ;
            p =
                  createTaskSwitchEvent(currentActivation, lastRunning + 1,
                                        running.length - 1) ;
            preemptions.add(p) ;
          }
        }

        currentActivation = currentActivation.getNext() ;
      }
    }

    return preemptions ;
  }

  @Override
  public CheddarTask getTaskRunningAt(int tick)
  {
    TaskActivation a = tickToTaskActivation.get(tick) ;
    return (a != null) ? a.getTask() : null ;
  }

  @Override
  public float getCPUUtilizationFactor()
  {
    //return FloatUtil.divide((float) totalRunning,(float) simulationData.getSimulationPeriod());
    return ((float) ((int) ((((float) totalRunning) / (float) simulationData
          .getSimulationPeriod()) * 100f))) / 100f ;
  }

  @Override
  public int getTotalRunning()
  {
    return totalRunning ;
  }

  @Override
  public TimelineData getDefault()
  {
    return this ;
  }

  /**
   * Create a task switch event event.
   * Determines which other task activation has preempted the given one.
   * Determines also, the running instant of the preempter task which creates preemption.
   *
   * @param preempted task activation when preemption has occured.
   * @param preemptionTick global tick when preemption has occured.
   * @param preemptedUnit last running instant (relative to task capacity) of the preempted task before preemption.
   * @return task switch event.
   */
  private TaskSwitchEvent createTaskSwitchEvent(TaskActivation preempted,
                                                int preemptionTick,
                                                int preemptedUnit)
  {
    TaskActivation preempter = tickToTaskActivation.get(preemptionTick) ;
    int preempterUnit = preempter.getInstantForTick(preemptionTick) ;
    return new TaskSwitchEvent(preempted, preempter, preemptedUnit,
          preempterUnit, preemptionTick) ;
  }

  public static class Factory implements TimelineData.Factory
  {
    private static Factory instance ;

    public static synchronized Factory getInstance()
    {
      if(instance == null)
      {
        instance = new Factory() ;
      }

      return instance ;
    }

    private Factory()
    {
    }

    @Override
    public TimelineData createFor(CheddarProcessor cpu)
    {
      return new BasicTimelineData(cpu) ;
    }
  }
}