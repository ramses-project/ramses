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

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.Collections ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.flow.analysis.util.LongestAndShortestPath ;
import fr.tpt.aadl.flow.extraction.util.IDGenerator ;

public class RTAction
{

  public static boolean hideEmptyActions = false ;

  /** Action name. */
  private final String name ;

  /** Action type. */
  private final RTActionType type ;

  /** Previous actions. */
  private List<RTAction> previous = new ArrayList<RTAction>() ;

  /** Next actions. */
  private List<RTAction> next = new ArrayList<RTAction>() ;

  private RTAction join = null ;

  /** Related Task. */
  private ComponentInstance task ;

  /** Resource ID. */
  private String resourceID = "" ;

  /** Resource Type. */
  private ResourceType resourceType = ResourceType.None ;

  /** Minimum execution time. */
  private float minExecutionTime = 0 ;

  /** Maximum execution time. */
  private float maxExecutionTime = 0 ;
  
  private static Logger _LOGGER = Logger.getLogger(RTAction.class) ;

  public static RTAction createEmptyAction(String name,
                                           final ComponentInstance task)
  {
    RTAction start = new RTAction(name, RTActionType.Empty, task)
    {
      public float getMinExecutionTime()
      {
        return 0 ;
      }

      public float getMaxExecutionTime()
      {
        return 0 ;
      }
    } ;
    return start ;
  }

  public static RTAction createEmptyAction(final ComponentInstance task)
  {
    return createEmptyAction("empty", task) ;
  }

  public RTAction(
                  String name, RTActionType type, ComponentInstance task)
  {
    this.name = name ;
    this.type = type ;
    this.task = task ;
  }

  public RTAction(
                  RTActionType type, ComponentInstance task)
  {
    this("Noname", type, task) ;
  }

  public void setJoin(RTAction t)
  {
    join = t ;
  }

  public ComponentInstance getElement()
  {
    return task ;
  }

  public List<RTAction> getPrevious()
  {
    return Collections.unmodifiableList(previous) ;
  }

  public List<RTAction> getNext()
  {
    return Collections.unmodifiableList(next) ;
  }

  public RTAction getEnd()
  {
    RTAction end = this ;

    if(next.size() > 0)
    {
      end = next.get(0).getEnd() ;
    }

    return end ;
  }

  public RTAction getJoin()
  {
    return join ;
  }

  public void addNext(RTAction t)
  {
    if(type != RTActionType.WaitTaskNextActivation)
    {
      next.add(t) ;
      t.previous.add(this) ;
    }
  }

  public void addPrevious(RTAction t)
  {
    previous.add(t) ;
    t.next.add(this) ;
  }

  public boolean removeNext(RTAction t)
  {
    boolean result ;
    result = next.remove(t) ;
    t.previous.remove(this) ;
    return result ;
  }

  public boolean removePrevious(RTAction t)
  {
    boolean result ;
    result = previous.remove(t) ;
    t.next.remove(this) ;
    return result ;
  }

  public void addAllNext(Collection<RTAction> actions)
  {
    for(RTAction action : actions)
    {
      addNext(action) ;
    }
  }

  public void addAllPrevious(Collection<RTAction> actions)
  {
    for(RTAction action : actions)
    {
      addPrevious(action) ;
    }
  }

  public void removeAllNext(Collection<RTAction> actions)
  {
    for(RTAction action : actions)
    {
      removeNext(action) ;
    }
  }

  public void removeAllPrevious(Collection<RTAction> actions)
  {
    for(RTAction action : actions)
    {
      removePrevious(action) ;
    }
  }

  public void removeAllPrevious()
  {
    List<RTAction> tmp = new ArrayList<RTAction>() ;
    tmp.addAll(previous) ;
    removeAllPrevious(tmp) ;
  }

  public void setResourceID(String resourceID)
  {
    this.resourceID = resourceID ;
  }

  public String getResourceID()
  {
    return resourceID ;
  }

  public void setResourceType(ResourceType resourceType)
  {
    this.resourceType = resourceType ;
  }

  public ResourceType getResourceType()
  {
    return resourceType ;
  }

  public String getName()
  {
    return name ;
  }

  public RTActionType getType()
  {
    return type ;
  }

  public void setMinExecutionTime(float time)
  {
    minExecutionTime = time ;
  }

  public void setMaxExecutionTime(float time)
  {
    maxExecutionTime = time ;
  }

  public float getMinExecutionTime()
  {
    return minExecutionTime ;
  }

  public float getMaxExecutionTime()
  {
    return maxExecutionTime ;
  }

  public String toString()
  {
    return toString(new ArrayList<RTAction>(), 0) ;
  }

  private String toString(List<RTAction> visited,
                          int tab)
  {
    String s = fillWithBlank("", tab) + toStringBasic(tab) ;

    if(!visited.contains(this))
    {
      visited.add(this) ;

      for(RTAction n : next)
      {
        s += "\n" + n.toString(visited, tab + 1) ;
      }

      visited.remove(this) ;
    }

    return s ;
  }

  private String toStringBasic(int tab)
  {
    if((type != RTActionType.Empty) || (!hideEmptyActions))
    {
      float tmin = getMinExecutionTime() ;
      float t = getMaxExecutionTime() ;
      String formatType = fillWithBlank(getType().name(), 15 + tab) ;
      String concName =
            getName() + (resourceID != null ? "(" + resourceID + ")" : "") ;
      String s = fillWithBlank(formatType + "\t" + concName, 60 + tab) ;
      s += "\tC = [" + tmin + "," + t + "]" ;
      return s ;
    }
    else
    {
      return "" ;
    }
  }

  public final boolean equals(Object o)
  {
    if(o instanceof RTAction)
    {
      RTAction a = (RTAction) o ;
      return name.equals(a.getName()) && type.equals(a.getType()) ;
    }

    return false ;
  }

  private String fillWithBlank(String s,
                               int requiredLength)
  {
    if((type != RTActionType.Empty) || (!hideEmptyActions))
    {
      String ret = s ;

      while(ret.length() < requiredLength)
      {
        ret += " " ;
      }

      return ret ;
    }
    else
    {
      return "" ;
    }
  }

  public RTAction reduceFromMe()
  {
    return doClone().reduceFromMeImpl() ;
  }

  private RTAction reduceFromMeImpl()
  {
    if(next.size() > 1)
    {
      if(type == RTActionType.Conditional)
      {
        RTAction clone =
              new RTAction(IDGenerator.getNewIdForName("ComputationBlocks"),
                    RTActionType.Compute, task) ;
        float min = LongestAndShortestPath.getShortestPath(this, this.join) ;
        float max = LongestAndShortestPath.getLongestPath(this, this.join) ;
        clone.setMinExecutionTime(min) ;
        clone.setMaxExecutionTime(max) ;

        for(RTAction joinNext : join.next)
        {
          joinNext.removePrevious(this) ;
          joinNext.addPrevious(clone) ;
        }

        return clone.reduceFromMeImpl() ;
      }
      else
      {
        String msg = '\'' + type.name() + "\' type not yet implemented" ;
        _LOGGER.fatal(msg) ;
        throw new RuntimeException(msg) ;
      }
    }
    else if(next.size() == 1)
    {
      RTAction loneNext = next.get(0).reduceFromMeImpl() ;
      next.clear() ;

      if(canBeReduced() && loneNext.canBeReduced())
      {
        RTAction clone =
              new RTAction(IDGenerator.getNewIdForName("ComputationSeq"),
                    RTActionType.Compute, task) ;
        clone.setMinExecutionTime(minExecutionTime +
              loneNext.getMinExecutionTime()) ;
        clone.setMaxExecutionTime(maxExecutionTime +
              loneNext.getMaxExecutionTime()) ;
        clone.addAllNext(loneNext.next) ;
        ArrayList<RTAction> tmpNext = new ArrayList<RTAction>() ;
        tmpNext.addAll(loneNext.next) ;
        loneNext.removeAllNext(tmpNext) ;
        return clone.reduceFromMeImpl() ;
      }
      else
      {
        next.add(loneNext) ;
        return this ;
      }
    }
    else
    {
      return this ;
    }
  }

  private boolean canBeReduced()
  {
    return ((type != RTActionType.WaitResource) &&
          (type != RTActionType.ReleaseResource) &&
          (type != RTActionType.ReadPort) && (type != RTActionType.WritePort)) ;
  }

  private RTAction doBasicClone()
  {
    return doBasicClone(name, type) ;
  }

  private RTAction doBasicClone(String name,
                                RTActionType type)
  {
    RTAction clone = new RTAction(name, type, getElement()) ;
    clone.setMinExecutionTime(getMinExecutionTime()) ;
    clone.setMaxExecutionTime(getMaxExecutionTime()) ;
    clone.setResourceID(getResourceID()) ;
    clone.setResourceType(getResourceType()) ;
    return clone ;
  }

  private RTAction doClone()
  {
    HashMap<RTAction, RTAction> cloneToSource =
          new HashMap<RTAction, RTAction>() ;
    HashMap<RTAction, RTAction> sourceToClone =
          new HashMap<RTAction, RTAction>() ;
    RTAction myClone = doClone(cloneToSource, sourceToClone) ;
    myClone.updateJoin(cloneToSource, sourceToClone) ;
    return myClone ;
  }

  private RTAction doClone(Map<RTAction, RTAction> cloneToSource,
                           Map<RTAction, RTAction> sourceToClone)
  {
    RTAction clone = doBasicClone() ;
    cloneToSource.put(clone, this) ;
    sourceToClone.put(this, clone) ;

    for(RTAction n : next)
    {
      clone.addNext(n.doClone(cloneToSource, sourceToClone)) ;
    }

    return clone ;
  }

  private void updateJoin(Map<RTAction, RTAction> cloneToSource,
                          Map<RTAction, RTAction> sourceToClone)
  {
    RTAction source = cloneToSource.get(this) ;
    join = sourceToClone.get(source.join) ;

    for(RTAction n : next)
    {
      n.updateJoin(cloneToSource, sourceToClone) ;
    }
  }
}