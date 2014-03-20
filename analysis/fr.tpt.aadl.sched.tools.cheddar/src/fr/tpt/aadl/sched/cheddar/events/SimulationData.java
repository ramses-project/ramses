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

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;

import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

public class SimulationData
{

  private HashMap<CheddarProcessor, TimelineData> cpuToEvents =
        new HashMap<CheddarProcessor, TimelineData>() ;

  private TimelineData.Factory factory ;

  private final int simulationPeriod ;

  public SimulationData(TimelineData.Factory factory, int simulationPeriod)
  {
    this.factory = factory ;
    this.simulationPeriod = simulationPeriod ;
  }

  public int getSimulationPeriod()
  {
    return simulationPeriod ;
  }

  public TimelineData getSimulationInterpreterFor(CheddarProcessor cpu)
  {
    TimelineData events = cpuToEvents.get(cpu) ;

    if(events == null)
    {
      events = factory.createFor(cpu) ;
      events.setSimulationData(this) ;
      cpuToEvents.put(cpu, events) ;
    }

    return events ;
  }

  public Map<CheddarProcessor, TimelineData> getSimulationInterpreters()
  {
    return Collections.unmodifiableMap(cpuToEvents) ;
  }

  public List<TaskActivation> getMissedDeadlineFor(CheddarTask task)
  {
    CheddarProcessor cpu = task.getOwner().getOwner() ;
    TimelineData cpuEvents = getSimulationInterpreterFor(cpu) ;
    TaskActivation taskEvents = cpuEvents.getEventsFor(task) ;
    List<TaskActivation> l = new ArrayList<TaskActivation>() ;
    TaskActivation currentMissed = taskEvents.getFirstMissedDeadline() ;

    while(currentMissed != null)
    {
      if(currentMissed.currentDeadlineIsMissed())
      {
        l.add(currentMissed) ;
      }

      currentMissed = currentMissed.getNext() ;

      if(currentMissed != null)
      {
        currentMissed = currentMissed.getFirstMissedDeadline() ;
      }
    }

    return l ;
  }

  public Map<CheddarTask, List<TaskActivation>> getCheddarMissedDeadlines()
  {
    Map<CheddarTask, List<TaskActivation>> result =
          new HashMap<CheddarTask, List<TaskActivation>>() ;
    Iterator<CheddarProcessor> itCPU = cpuToEvents.keySet().iterator() ;

    while(itCPU.hasNext())
    {
      CheddarProcessor cpu = itCPU.next() ;
      Iterator<CheddarTask> itTask = cpu.getOwnedTasks().iterator() ;

      while(itTask.hasNext())
      {
        CheddarTask task = itTask.next() ;
        List<TaskActivation> missed = getMissedDeadlineFor(task) ;
        result.put(task, missed) ;
      }
    }

    return result ;
  }

  public Map<ComponentInstance, List<TaskActivation>> getAADLMissedDeadlines()
  {
    Map<ComponentInstance, List<TaskActivation>> result =
          new HashMap<ComponentInstance, List<TaskActivation>>() ;
    Map<CheddarTask, List<TaskActivation>> missed = getCheddarMissedDeadlines() ;

    for(Entry<CheddarTask, List<TaskActivation>> e : missed.entrySet())
    {
      result.put((ComponentInstance) e.getKey().getAADLElement(), e.getValue()) ;
    }

    return result ;
  }

  public boolean hasMissedDeadlineFor(CheddarTask task)
  {
    return getMissedDeadlineFor(task) != null ;
  }

  public Map<CheddarProcessor, List<TaskSwitchEvent>> getPreemptionEvents()
        throws Exception
  {
    HashMap<CheddarProcessor, List<TaskSwitchEvent>> res ;
    res = new HashMap<CheddarProcessor, List<TaskSwitchEvent>>() ;
    Map<CheddarProcessor, TimelineData> inter = getSimulationInterpreters() ;

    for(CheddarProcessor p : inter.keySet())
    {
      TimelineData i = inter.get(p) ;
      res.put(p, i.getPreemptionEvents()) ;
    }

    return res ;
  }
}