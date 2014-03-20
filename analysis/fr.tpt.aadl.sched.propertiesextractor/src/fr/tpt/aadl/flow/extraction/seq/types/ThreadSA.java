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

package fr.tpt.aadl.flow.extraction.seq.types ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.seq.CallSequenceAnalyzer ;
import fr.tpt.aadl.flow.extraction.util.ComputationUtil ;
import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.flow.model.RTAction ;
import fr.tpt.aadl.flow.model.RTActionType ;
import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class ThreadSA extends CallSequenceAnalyzer
{
  private static Logger _LOGGER = Logger.getLogger(ThreadSA.class) ;
  
  public ThreadSA(ExtractionContext ctxt)
  {
    super(ctxt) ;
  }

  public ExecutionGraph extractFrom(ComponentInstance comp)
  {
    ExecutionGraph au = new ExecutionGraph() ;
    au.setInitGraph(extractInitSequence(comp)) ;
    //au.setIterationGraph(extractIterationSequence(comp));
    RTAction first = RTAction.createEmptyAction(comp) ;
    ctxt.getSubprogramAnalyzer().extractFrom(comp, first) ;
    au.setIterationGraph(first) ;
    return au ;
  }

  private RTAction extractInitSequence(ComponentInstance comp)
  {
    SubprogramClassifier sc = null ;

    Classifier c =
        PropertyUtils.getClassifierValue(comp, "Initialize_Entrypoint") ;
    if(c != null)
    {
      if(c instanceof SubprogramClassifier)
      {
        sc = (SubprogramClassifier) c ;
      }
    }
    else
    {
      String msg = "cannot find Initialize_Entrypoint for \'"+
                     comp.getName() + '\'' ;
      _LOGGER.warn(msg) ;
      ServiceProvider.SYS_ERR_REP.warning(msg, true);
    }

    if(sc == null)
    {
      return new RTAction("Task Init", RTActionType.Compute, comp) ;
    }
    else
    {
      RTAction init = new RTAction(sc.getName(), RTActionType.Compute, comp) ;
      float computationTime = (float) ComputationUtil.getElementMaxDuration(sc, this) ;
      init.setMaxExecutionTime(computationTime) ;
      return init ;
    }
  }

  /*
  private TaskAction extractIterationSequence(ComponentInstance task)
  {
    SystemInstance root = (SystemInstance) task.getOwner();
  
    List<ConnectionInstance> conns = root.getConnectionInstances();
    List<TaskAction> inputs = new ArrayList<TaskAction>();
    List<TaskAction> outputs = new ArrayList<TaskAction>();
  
    TaskAction taskStart = TaskAction.createEmptyAction("TaskStart", task);
    TaskAction taskEnd = TaskAction.createEmptyAction("TaskEnd", task);
  
    for(int index=0; index<conns.size(); index++)
    {
      ConnectionInstance conn = conns.get(index);
      ConnectionInstanceEnd eStart = conn.getSource();
      ConnectionInstanceEnd eEnd = conn.getDestination();
  
      ConnectionInstance start = eStart.getSrcConnectionInstances().get(0);
      ConnectionInstance end = eEnd.getDstConnectionInstances().get(0);
  
      if ((! (start.getSource() instanceof FeatureInstance)) || (! (end.getSource() instanceof FeatureInstance)))
        continue;
  
      FeatureInstance fSource = (FeatureInstance) start.getSource();
      FeatureInstance fEnd = (FeatureInstance) end.getDestination();
  
      if (fSource.getOwner() == task)
      {
        switch (start.getKind())
        {
          case PORT_CONNECTION :
            createPortAction(fSource, inputs, outputs, taskStart);
            break;
        }
      }
      else if (fEnd.getOwner() == task)
      {
        switch (end.getKind())
        {
          case PORT_CONNECTION :
            createPortAction(fEnd, inputs, outputs, taskStart);
            break;
        }
      }
    }
  
    TaskAction last = taskStart;
    for(int index=0; index < inputs.size(); index++)
    {
      TaskAction input = inputs.get(index);
      input.addPrevious(last);
      last = input;
    }
  
    for(int index=0; index < outputs.size(); index++)
    {
      TaskAction output = outputs.get(index);
      output.addPrevious(last);
      last = output;
    }
    last.addNext(taskEnd);
    last = taskEnd;
  
    return last;
  }
  
  private static void createPortAction(FeatureInstance f, List<TaskAction> inputs, List<TaskAction> outputs, TaskAction start)
  {
    switch (f.getDirection())
    {
        case IN :
          inputs.add(new TaskAction(f.getName(), TaskActionType.ReadPort, start.getElement()));
          break;
        case OUT :
          outputs.add(new TaskAction(f.getName(), TaskActionType.WritePort, start.getElement()));
          break;
    }
  }*/

  /*
  public void extractProcessTasksExecutionFlow(
      ComponentInstance process, SystemInstance root,
      Map<ComponentInstance, TaskAction> taskToAction)
  {
  
    for(ComponentInstance sub : process.getAllComponentInstances())
    {
      if (sub.getCategory().getValue() == ComponentCategory.THREAD_VALUE)
      {
        TaskAction lastAction = extractTaskExecutionFlow(sub, root);
        taskToAction.put(sub, lastAction);
      }
    }
  }
  
  
  public void extractVPTasksExecutionFlow(
      ComponentInstance vp, SystemInstance root,
      Map<ComponentInstance, TaskAction> taskToAction)
  {
    for(ComponentInstance sub : root.getAllComponentInstances())
    {
      if (sub.getCategory().getValue() == ComponentCategory.PROCESS_VALUE)
      {
        if (PropertyUtils.getPropertyComponentRef("Actual_Processor_Binding", sub)==vp)
        {
          extractProcessTasksExecutionFlow(sub, root, taskToAction);
        }
      }
    }
  }
  
  public void extractNodeTasksExecutionFlow(
      ComponentInstance node, SystemInstance root,
      Map<ComponentInstance, TaskAction> taskToAction)
  {
    for(ComponentInstance pSub : node.getAllComponentInstances())
    {
      if (pSub.getCategory().getValue() == ComponentCategory.VIRTUAL_PROCESSOR_VALUE)
        extractVPTasksExecutionFlow(pSub, root,taskToAction);
    }
  }
  
  public Map<ComponentInstance, TaskAction> extractTasksExecutionFlow(SystemInstance root)
  {
    Map<ComponentInstance, TaskAction> taskToAction = new HashMap<ComponentInstance, TaskAction>();
    for(ComponentInstance sub : root.getAllComponentInstances())
    {
      if (sub.getCategory().getValue() == ComponentCategory.PROCESSOR_VALUE)
      {
        extractNodeTasksExecutionFlow(sub, root,taskToAction);
      }
    }
    return taskToAction;
  }*/
}