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

package fr.tpt.aadl.flow.model ;

import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.flow.analysis.util.LongestAndShortestPath ;
import fr.tpt.aadl.flow.analysis.util.TaskSequence ;

public class ExecutionGraph
{

  private RTAction initGraph = null ;
  private RTAction iterationGraph = null ;
  private RTAction reducedSteadyState = null ;
  private ExecutionGraphRegistry registry ;

  private long priority = -1 ;

  private float startTime = -1 ;
  private float WCET = -1 ;

  public final ComponentInstance getTask()
  {
    return iterationGraph.getElement() ;
  }

  public final long getPriority()
  {
    return priority ;
  }

  public final RTAction getInitGraph()
  {
    return initGraph ;
  }

  public final RTAction getIterationGraph()
  {
    return iterationGraph ;
  }

  public RTAction getSteadyState()
  {
    if(reducedSteadyState == null)
    {
      recomputeSteadyState() ;
    }

    return reducedSteadyState ;
  }

  public float getStartTime()
  {
    if(startTime == -1)
    {
      recomputeStartTime() ;
    }

    return startTime ;
  }

  public float getWCET()
  {
    if(WCET == -1)
    {
      recomputeWCET() ;
    }

    return WCET ;
  }

  public TaskSequence getSynchronizationInstants()
  {
    return new TaskSequence(iterationGraph.reduceFromMe()) ;
  }

  public ExecutionGraphRegistry getRegistry()
  {
    return registry ;
  }

  public void recomputeSteadyState()
  {
    reducedSteadyState = iterationGraph.reduceFromMe() ;
  }

  public void recomputeStartTime()
  {
    //computedWCIS = TaskAction.createEmptyAction("Worst_Case_Init_Sequence_Start", getInitGraph().getElement());
    startTime =
          LongestAndShortestPath.getLongestPath(getInitGraph(), getInitGraph()
                                                      .getEnd()) ;
  }

  public void recomputeWCET()
  {
    //computedWCES = TaskAction.createEmptyAction("Worst_Case_Iteration_Sequence_Start", getInitGraph().getElement());
    WCET =
          LongestAndShortestPath.getLongestPath(getIterationGraph(),
                                                getIterationGraph().getEnd()) ;
  }

  public boolean isUsingResource(String resourceID)
  {
    return getSynchronizationInstants().getAccessedResources()
          .contains(resourceID) ;
  }

  public void setInitGraph(RTAction initGraph)
  {
    this.initGraph = initGraph ;
    priority = computePriority() ;
  }

  public void setIterationGraph(RTAction iterationGraph)
  {
    this.iterationGraph = iterationGraph ;
    priority = computePriority() ;
  }

  private Long computePriority()
  {
    Long result = PropertyUtils.getIntValue(getTask(), "Priority") ; 
    if(result == null)
    {
      result = 0l ;
    }
    
    return result ;
  }

  void setRegistry(ExecutionGraphRegistry registry)
  {
    this.registry = registry ;
  }

  public String toString()
  {
    return "Initialization graph : \n" + initGraph + "\n\n" +
          "Iteration graph : \n" + iterationGraph + "\n\n" +
          "Steady state sequence : \n" + getSteadyState() + "\n\n" ;
  }
}