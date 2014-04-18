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
 
 package fr.tpt.aadl.sched.cheddar.strategies.arinc ;

import java.util.List ;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.sched.cheddar.CheddarOptions ;
import fr.tpt.aadl.sched.cheddar.events.TaskSwitchEvent ;
import fr.tpt.aadl.sched.cheddar.events.TimelineData ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;
import fr.tpt.aadl.sched.cheddar.strategies.BasicTimelineData ;

public class ARINC653TimelineData extends BasicTimelineData
{
  protected final ARINC653Scheduler scheduler ;
  protected final BasicTimelineData globalTimeInterpreter ;
  private static Logger _LOGGER = Logger.getLogger(ARINC653TimelineData.class) ;

  public ARINC653TimelineData(CheddarProcessor cpu)
  {
    super(cpu) ;
    globalTimeInterpreter = new BasicTimelineData(cpu) ;
    scheduler = (ARINC653Scheduler) cpu.getCustomScheduler() ;
  }

  @Override
  public TimelineData getDefault()
  {
    return globalTimeInterpreter ;
  }

  @Override
  public void addTaskActivation(CheddarTask task,
                                int activationStart)
  {
    int localTick =
          scheduler.localTick(activationStart, task.getOwner()
                                    .getPartition_index()) ;
    super.addTaskActivation(task, localTick) ;
    globalTimeInterpreter.addTaskActivation(task, activationStart) ;

    if(CheddarOptions.CHEDDAR_DEBUG)
    {
      _LOGGER.debug("[TaskActivation]      " + task.getName() + "\t" +
                  "globalTick = " + activationStart + "\t   localTick = " +
                  localTick) ;
    }
  }

  @Override
  public void setTaskExecutionStart(CheddarTask task,
                                    int executionStart)
  {
    int localTick =
          scheduler.localTick(executionStart, task.getOwner()
                                    .getPartition_index()) ;
    super.setTaskExecutionStart(task, localTick) ;
    globalTimeInterpreter.setTaskExecutionStart(task, executionStart) ;

    if(CheddarOptions.CHEDDAR_DEBUG)
    {
      _LOGGER.debug("[TaskStartExecution]  " + task.getName() + "\t" +
            "globalTick = " + executionStart + "\t   localTick = " + localTick) ;
    }
  }

  @Override
  public void setTaskIsRunning(CheddarTask task,
                               int tick)
  {
    int localTick =
          scheduler.localTick(tick, task.getOwner().getPartition_index()) ;
    super.setTaskIsRunning(task, localTick) ;
    globalTimeInterpreter.setTaskIsRunning(task, tick) ;

    if(CheddarOptions.CHEDDAR_DEBUG)
    {
      _LOGGER.debug("[TaskIsRunning]       " + task.getName() + "\t" +
            "globalTick = " + tick + "\t   localTick = " + localTick) ;
    }
  }

  @Override
  public void setTaskExecutionEnd(CheddarTask task,
                                  int executionEnd)
  {
    int localTick =
          scheduler.localTick(executionEnd, task.getOwner()
                                    .getPartition_index()) ;
    super.setTaskExecutionEnd(task, localTick) ;
    globalTimeInterpreter.setTaskExecutionEnd(task, executionEnd) ;

    if(CheddarOptions.CHEDDAR_DEBUG)
    {
      _LOGGER.debug("[TaskEndExecution]    " + task.getName() + "\t" +
            "globalTick = " + executionEnd + "\t   localTick = " + localTick) ;
    }
  }

  @Override
  public List<TaskSwitchEvent> getPreemptionEvents()
  {
    return globalTimeInterpreter.getPreemptionEvents() ;
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
      return new ARINC653TimelineData(cpu) ;
    }
  }
}