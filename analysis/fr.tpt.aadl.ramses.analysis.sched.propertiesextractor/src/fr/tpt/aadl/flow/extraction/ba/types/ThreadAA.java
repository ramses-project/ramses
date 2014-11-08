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

package fr.tpt.aadl.flow.extraction.ba.types ;

import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorTransition ;

import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.ba.AutomatonAnalyzer ;
import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.flow.model.RTAction ;
import fr.tpt.aadl.flow.model.RTActionType ;

/**
 * Extract execution flow from thread behavior annex.
 * This class uses a BABlockExecutionFlow to extract subgraph
 * from each behavior transition.
 * Each action in the transition is analyzed. If the action is a subprogram call,
 * then it is analyzed also:
 *   Case 1: if it owns a behavior annex, this one is analyzed.

 *   Case 2: if it owns the Computation_Execution_Time property,
 *   a unique action is added with duration equals to the property value.

 *   Case 3: if it has call sequence specification,
 *   a unique action is added with duration equals to the sum of analyzed called subprogram.
 *
 * @author Fabien Cadoret
 *
 *
 */
public class ThreadAA extends AutomatonAnalyzer
{

  public ThreadAA(ExtractionContext ctxt)
  {
    super(ctxt) ;
  }

  public final ExecutionGraph extractFrom(BehaviorAnnex ba,
                                          ComponentInstance task)
  {
    /*
    BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(task);
    if (ba == null)
    {
      errManager.error(task, "No behavior annex for component instance " + task.getName());
      return null;
    }
    else if (! checkIsCompatibleSpecification(ba) )
    {
      return null;
    }
    else
    {
      return extractFlowFromTransitions(ba, task);
    }*/
    if(!checkIsCompatibleSpecification(ba))
    {
      return null ;
    }
    else
    {
      return extractFlowFromTransitions(ba, task) ;
    }
  }

  protected ExecutionGraph extractFlowFromTransitions(BehaviorAnnex ba,
                                                      ComponentInstance taskI)
  {
    final Map<String, RTAction> stateToStart = new HashMap<String, RTAction>() ;
    final Map<String, RTAction> stateToEnd = new HashMap<String, RTAction>() ;
    /** For each state, register start and end actions. */
    registerStatesIntoGraph(ba, taskI, stateToStart, stateToEnd) ;
    RTAction iterationStart = null ;
    RTAction iterationEnd = null ;
    List<BehaviorTransition> transitions = ba.getTransitions() ;

    for(int indexTr = 0 ; indexTr < transitions.size() ; indexTr++)
    {
      BehaviorTransition tran = transitions.get(indexTr) ;
      BehaviorActionSequence seq =
            (BehaviorActionSequence) tran.getActionBlock() ;
      List<BehaviorAction> actions = seq.getActions() ;
      String srcState = tran.getSourceState().getName() ;
      String dstState = tran.getDestinationState().getName() ;
      RTAction srcEnd = stateToEnd.get(srcState) ;
      RTAction dstStart = stateToStart.get(dstState) ;
      RTAction dstEnd = stateToEnd.get(dstState) ;
      RTAction last =
            ctxt.getTransitionAnalyzer().extractFrom(taskI, actions, dstStart) ;

      if(last.getType() == RTActionType.WaitTaskNextActivation)
      {
        iterationStart = dstEnd.getNext().get(0) ;
        iterationEnd = last ;
      }
      else
      {
        srcEnd.addNext(dstStart) ;
        last.addNext(dstEnd) ;
      }
    }

    iterationEnd.removeAllPrevious() ;
    return createTaskMainAction(ba, stateToStart, stateToEnd, iterationStart) ;
  }

  private static ExecutionGraph createTaskMainAction(BehaviorAnnex ba,
                                                     Map<String, RTAction> stateToStart,
                                                     Map<String, RTAction> stateToEnd,
                                                     RTAction iterationStart)
  {
    final ExecutionGraph aTask = new ExecutionGraph() ;

    for(BehaviorTransition t : ba.getTransitions())
    {
      String sourceID = t.getSourceState().getName() ;
      String targetID = t.getDestinationState().getName() ;
      RTAction stStart = stateToStart.get(targetID) ;

      if(isInitial(t, sourceID))
      {
        removeIterationStartAsSuccessor(iterationStart, stStart) ;
        aTask.setInitGraph(stStart) ;
      }
      else if(stStart == iterationStart)
      {
        aTask.setIterationGraph(stStart) ;
      }
    }

    return aTask ;
  }

  private static void removeIterationStartAsSuccessor(RTAction iterationStart,
                                                      RTAction taskStart)
  {
    if(!taskStart.removeNext(iterationStart))
    {
      for(RTAction next : taskStart.getNext())
      {
        removeIterationStartAsSuccessor(iterationStart, next) ;
      }
    }
  }
}