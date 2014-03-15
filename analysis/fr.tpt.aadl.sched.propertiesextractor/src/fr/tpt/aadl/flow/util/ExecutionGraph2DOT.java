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

package fr.tpt.aadl.flow.util ;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.flow.model.ExecutionGraphVisitor ;
import fr.tpt.aadl.flow.model.RTAction ;
import fr.tpt.aadl.flow.model.RTActionType ;

public class ExecutionGraph2DOT implements ExecutionGraphVisitor
{

  public static final boolean DELETE_DOT_FILES = false ;

  private String outputDir ;

  private boolean exportInit = false ;
  private boolean exportSteadyGlobal = true ;

  private HashMap<String, String> actionToResource =
        new HashMap<String, String>() ;
  
  private static Logger _LOGGER = Logger.getLogger(ExecutionGraph2DOT.class) ;

  public ExecutionGraph2DOT(String outputDir)
  {
    this.outputDir = outputDir ;

    if(!outputDir.endsWith(File.separator))
    {
      outputDir += File.separator ;
    }
  }

  public void visit(ExecutionGraph a)
  {
    int priority = a.getPriority() ;
    final RTAction INIT_GLOBAL = a.getInitGraph() ;
    final RTAction ITER_GLOBAL = a.getIterationGraph() ;
    final RTAction STEADY = a.getSteadyState() ;
    final String TASK_NAME = a.getTask().getName() ;
    final String INIT_GLOBAL_PATH =
          outputDir + TASK_NAME + "_initialization.dot" ;
    final String ITER_GLOBAL_PATH = outputDir + TASK_NAME + "_steady.dot" ;
    final String STEADY_PATH = outputDir + TASK_NAME + "_reduced.dot" ;

    if(exportInit)
    {
      saveFlowModelAsPng(INIT_GLOBAL, INIT_GLOBAL_PATH, priority) ;
    }

    if(exportSteadyGlobal)
    {
      saveFlowModelAsPng(ITER_GLOBAL, ITER_GLOBAL_PATH, priority) ;
    }

    saveFlowModelAsPng(STEADY, STEADY_PATH, priority) ;
  }

  private void saveFlowModelAsPng(RTAction flow,
                                  String outputPath,
                                  int priority)
  {
    try
    {
      File f ;
      BufferedWriter writer ;
      String title ;
      String content ;
      List<String> actionNames ;
      List<String> transitionNames ;
      f = new File(outputPath) ;

      if(!f.exists())
      {
        f.createNewFile() ;
      }

      writer = new BufferedWriter(new FileWriter(outputPath)) ;
      actionNames = new ArrayList<String>() ;
      transitionNames = new ArrayList<String>() ;
      title = flow.getElement().getName() + " [Priority : " + priority + "]" ;
      collectActionNames(flow, actionNames) ;
      collectTransitionNames(flow, transitionNames, new ArrayList<RTAction>()) ;
      content = getGlobalContent(title, actionNames, transitionNames) ;
      writer.write(content) ;
      writer.close() ;
      String outputImage = outputPath.replace(".dot", ".png") ;
      String cmd = "dot " + outputPath + " -Tpng -o " + outputImage ;
      //System.out.println(cmd);
      Process cmdP = Runtime.getRuntime().exec(cmd) ;
      cmdP.waitFor() ;

      if(DELETE_DOT_FILES)
      {
        f.delete() ;
      }
    }
    catch(Exception e) // IOException & InterruptedException
    {
      String msg = "cannot save the flow model into png" ;
      _LOGGER.fatal(msg, e) ;
      throw new RuntimeException(msg, e) ;
    }
  }

  private String getGlobalContent(String title,
                                  List<String> actionNames,
                                  List<String> transitionNames)
  {
    String s = "digraph TaskFlow {\n\tlabel = \"" + title + "\";\n\n" ;

    for(int index = 0 ; index < actionNames.size() ; index++)
    {
      String actionName = actionNames.get(index) ;
      String actionLabel = actionName ;

      if(smoothLabel(
                     actionName).equals("GetResource") ||
            smoothLabel(
                        actionName).equals("ReleaseResource"))
      {
        actionName += " [color=red]" ;
      }
      else if(index == 0)
      {
        actionName += " [shape=Mdiamond]" ;
      }

      s +=
            "\n\t" + smoothName(actionName) + " [label=\"" +
                  smoothLabel(actionLabel) + "\"];" ;
    }

    s += "\n\n" ;

    for(String transitionName : transitionNames)
    {
      s += "\n\t" + transitionName + ";" ;
    }

    return s + "\n}" ;
  }

  private static String smoothName(String name)
  {
    String newname = name ;

    while(newname.contains("-"))
    {
      newname = newname.replace("-", "_") ;
    }

    return newname ;
  }

  private String smoothLabel(String name)
  {
    String newname = name ;

    while(newname.contains("-"))
    {
      newname = newname.replace("-", "_") ;
    }

    int index = newname.lastIndexOf("__") ;

    if(index != -1)
    {
      newname = newname.substring(0, index) ;
    }

    String resourceID = actionToResource.get(name) ;

    if(resourceID != null)
    {
      newname += " (" + resourceID + ")" ;
    }

    return newname ;
  }

  private void collectActionNames(RTAction flow,
                                  List<String> names)
  {
    names.add(flow.getName()) ;

    if(flow.getResourceID() != null)
    {
      if(flow.getType() == RTActionType.WaitResource)
      {
        actionToResource.put("GetResource", flow.getResourceID()) ;
      }
      else if(flow.getType() == RTActionType.ReleaseResource)
      {
        actionToResource.put("ReleaseResource", flow.getResourceID()) ;
      }
      else
      {
        actionToResource.put(flow.getName(), flow.getResourceID()) ;
      }
    }

    for(RTAction next : flow.getNext())
    {
      if(!names.contains(next.getName()))
      {
        collectActionNames(next, names) ;
      }
    }
  }

  private static void collectTransitionNames(RTAction flow,
                                             List<String> transitions,
                                             List<RTAction> visited)
  {
    if(!visited.contains(flow))
    {
      visited.add(flow) ;

      for(RTAction next : flow.getNext())
      {
        float min = flow.getMinExecutionTime() ;
        float max = flow.getMaxExecutionTime() ;
        String name =
              smoothName(flow.getName()) +
                    " -> " +
                    smoothName(next.getName() + "[label=\"[" + min + "," + max +
                          "]\"]") ;
        transitions.add(name) ;
        collectTransitionNames(next, transitions, visited) ;
      }
    }
  }
}