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
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.AccessConnection ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ConnectedElement ;
import org.osate.aadl2.Connection ;
import org.osate.aadl2.ConnectionEnd ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ThreadClassifier ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.flow.extraction.ExtractionContext ;

public class ExecutionGraphRegistry
{
  private Map<NamedElement, List<ExecutionGraph>> processToExecutionList =
        new HashMap<NamedElement, List<ExecutionGraph>>() ;
  private List<NamedElement> ignoreForVisitors = new ArrayList<NamedElement>() ;

  private List<ExecutionGraphVisitor> visitors =
        new ArrayList<ExecutionGraphVisitor>() ;

  public ExecutionGraphRegistry(SystemInstance root,
                                AnalysisErrorReporterManager errManager)
  {
    for(ComponentInstance i : root.getAllComponentInstances())
    {
      if(i.getCategory() == ComponentCategory.PROCESS)
      {
        List<ExecutionGraph> allGraphs =
              ExtractionContext.createGraphList(i, errManager) ;
        processToExecutionList.put(i, allGraphs) ;
        processToExecutionList.put(i.getSubcomponent()
                                         .getComponentImplementation(),
                                   allGraphs) ;
        ignoreForVisitors.add(i) ;

        for(ExecutionGraph g : allGraphs)
        {
          if(g != null)
          {
            g.setRegistry(this) ;
          }
        }
      }
    }
  }

  public void addGraphVisitor(ExecutionGraphVisitor v)
  {
    visitors.add(v) ;
  }

  public void notifyVisitors()
  {
    List<ExecutionGraph> whole = getAllExecutionGraphs() ;

    for(ExecutionGraphVisitor v : visitors)
    {
      for(ExecutionGraph a : whole)
      {
        v.visit(a) ;
      }
    }
  }

  public List<ExecutionGraph> getUsersOf(ComponentInstance process,
                                         String resourceID)
  {
    List<ExecutionGraph> users = new ArrayList<ExecutionGraph>() ;
    ProcessSubcomponent sub = (ProcessSubcomponent) process.getSubcomponent() ;
    ProcessImplementation processC =
          (ProcessImplementation) sub.getClassifier() ;

    for(Connection c : processC.getOwnedConnections())
    {
      if(!(c instanceof AccessConnection))
      {
        continue ;
      }

      AccessConnection acc = (AccessConnection) c ;
      ConnectionEnd source =
            ((ConnectedElement) acc.getSource()).getConnectionEnd() ;
      ConnectionEnd dest =
            ((ConnectedElement) acc.getDestination()).getConnectionEnd() ;

      if((source.getName().equals(resourceID)) && (dest instanceof DataAccess))
      {
        DataAccess access = (DataAccess) dest ;
        ThreadClassifier tt = (ThreadClassifier) access.getOwner() ;

        for(ComponentInstance subP : process.getComponentInstances())
        {
          if(subP.getCategory() == ComponentCategory.THREAD)
          {
            ThreadImplementation sti =
                  (ThreadImplementation) subP.getSubcomponent().getClassifier() ;

            if(sti.getType() == tt)
            {
              ExecutionGraph ta = getExecutionForTask(subP) ;

              if(ta != null)
              {
                users.add(ta) ;
              }

              break ;
            }
          }
        }
      }
    }

    return users ;
  }

  public ExecutionGraph getExecutionForTask(ComponentInstance task)
  {
    ComponentInstance process = (ComponentInstance) task.getOwner() ;
    List<ExecutionGraph> automatonList = getExecutionForOwnedTasks(process) ;

    for(ExecutionGraph a : automatonList)
    {
      if(a.getTask() == task)
      {
        return a ;
      }
    }

    return null ;
  }

  public List<ExecutionGraph> getExecutionForOwnedTasks(NamedElement process)
  {
    return processToExecutionList.get(process) ;
  }

  public List<ExecutionGraph> getAllExecutionGraphs()
  {
    List<ExecutionGraph> result = new ArrayList<ExecutionGraph>() ;

    for(NamedElement process : processToExecutionList.keySet())
    {
      if(!ignoreForVisitors.contains(process))
      {
        List<ExecutionGraph> l = processToExecutionList.get(process) ;
        result.addAll(l) ;
      }
    }

    return result ;
  }
}