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
 
 package fr.tpt.aadl.sched.cheddar.model ;

import java.io.IOException ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;

import org.osate.aadl2.Element ;

public class CheddarProcessor extends CheddarElement
{
  private boolean withNetwork = false ;

  private String schedulerType = "" ;

  private SchedulerPipeline automaton = null ;

  private List<CheddarTask> ownedTasks = new ArrayList<CheddarTask>() ;

  public CheddarProcessor(Element aadlProcessor, SchedulerPipeline automaton)
  {
    super(aadlProcessor) ;
    this.automaton = automaton ;
  }

  void addTask(CheddarTask task)
  {
    ownedTasks.add(task) ;
  }

  void removeTask(CheddarTask task)
  {
    ownedTasks.remove(task) ;
  }

  protected void setModel(CheddarModel model)
  {
    super.setModel(model) ;

    if(automaton != null)
    {
      automaton.setModel(model) ;
    }
  }

  public List<CheddarTask> getOwnedTasks()
  {
    return Collections.unmodifiableList(ownedTasks) ;
  }

  public boolean isWithNetwork()
  {
    return withNetwork ;
  }

  public void setWithNetwork(boolean withNetwork)
  {
    this.withNetwork = withNetwork ;
  }

  public String getSchedulerType()
  {
    return schedulerType ;
  }

  public void setSchedulerType(String schedulerType)
  {
    this.schedulerType = schedulerType ;
  }

  public boolean hasAutomaton()
  {
    return automaton != null ;
  }

  public SchedulerPipeline getCustomScheduler()
  {
    return automaton ;
  }

  public void saveSchedulerAs(String outputPath) throws IOException
  {
    if(hasAutomaton())
    {
      automaton.saveTo(outputPath) ;
    }
  }
}