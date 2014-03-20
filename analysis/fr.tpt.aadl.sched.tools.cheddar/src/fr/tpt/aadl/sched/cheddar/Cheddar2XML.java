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

package fr.tpt.aadl.sched.cheddar ;

import java.io.File ;
import java.io.IOException ;

import org.apache.log4j.Logger ;
import org.jdom.Attribute ;
import org.jdom.Document ;
import org.jdom.Element ;

import fr.tpt.aadl.launch.PluginActivator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.util.workspace.XMLUtil ;
import fr.tpt.aadl.sched.cheddar.model.CheddarAddressSpace ;
import fr.tpt.aadl.sched.cheddar.model.CheddarElement ;
import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.model.CheddarResource ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;
import fr.tpt.aadl.sched.cheddar.model.ResourceUse ;

public class Cheddar2XML
{
  private static Logger _LOGGER = Logger.getLogger(Cheddar2XML.class) ;

  public Document generateXML(CheddarModel model,
                              File outputPath)
  {
    final Element root = new Element("cheddar") ;
    final Document doc = new Document(root) ;
    final Element processors = new Element("processors") ;
    final Element addrSpaces = new Element("address_spaces") ;
    final Element tasks = new Element("tasks") ;
    final Element resources = new Element("resources") ;
    String header = "" ;

    header = PluginActivator.getInstance().getCheddarHeader() ;

    root.addContent(processors) ;
    root.addContent(addrSpaces) ;
    root.addContent(tasks) ;
    root.addContent(resources) ;

    for(CheddarElement e : model.getContent())
    {
      if(e instanceof CheddarProcessor)
      {
        processors.addContent(createProcessorNode((CheddarProcessor) e,
                                                  outputPath)) ;
      }
      else if(e instanceof CheddarAddressSpace)
      {
        addrSpaces.addContent(createAddressSpaceNode((CheddarAddressSpace) e)) ;
      }
      else if(e instanceof CheddarTask)
      {
        tasks.addContent(createTaskNode((CheddarTask) e)) ;
      }
      else if(e instanceof CheddarResource)
      {
        resources.addContent(createResourceNode((CheddarResource) e)) ;
      }
    }

    XMLUtil.saveIn(doc, outputPath, header) ;
    return doc ;
  }

  private Element createProcessorNode(CheddarProcessor p,
                                      File outputPath)
  {
    final String AUTOMATON_PATH =
          outputPath.toString().replace(".xml", "_" + p.getName() + ".sc") ;
    Element e = new Element("processor") ;
    Element scheduler =
          XMLUtil.createEnclosedValue("scheduler", p.getSchedulerType()) ;
    e.addContent(XMLUtil.createEnclosedValue("name", p.getName())) ;
    e.addContent(scheduler) ;

    if(p.hasAutomaton())
    {
      scheduler.setAttribute(new Attribute("parametric_file_name",
            AUTOMATON_PATH)) ;
    }

    if(!p.isWithNetwork())
    {
      e.addContent(XMLUtil.createEnclosedValue("network_link", "No_Network")) ;
    }
    else
    {
      String msg = "Network connection is not currently handled" ;
      _LOGGER.error(msg);
      ServiceProvider.SYS_ERR_REP.error(msg, true);
    }

    try
    {
      p.saveSchedulerAs(AUTOMATON_PATH) ;
      return e ;
    }
    catch(IOException ex)
    {
      String msg = "cannot save scheduler" ;
      _LOGGER.fatal(msg, ex);
      throw new RuntimeException(msg, ex) ;
    }
  }

  private Element createAddressSpaceNode(CheddarAddressSpace a)
  {
    Element e = new Element("address_space") ;
    e.addContent(XMLUtil.createEnclosedValue("name", a.getName())) ;
    e.addContent(XMLUtil
          .createEnclosedValue("cpu_name", a.getOwner().getName())) ;
    e.addContent(XMLUtil.createEnclosedValue("text_memory_size", a
                                                   .getText_memory_size())) ;
    e.addContent(XMLUtil.createEnclosedValue("stack_memory_size", a
                                                   .getStack_memory_size())) ;
    e.addContent(XMLUtil.createEnclosedValue("data_memory_size", a
                                                   .getData_memory_size())) ;
    e.addContent(XMLUtil.createEnclosedValue("heap_memory_size", a
                                                   .getHeap_memory_size())) ;
    return e ;
  }

  private Element createResourceNode(CheddarResource r)
  {
    Element e = new Element("resource") ;
    Element uses = new Element("resource_used_by") ;
    e.addContent(XMLUtil.createEnclosedValue("name", r.getName())) ;
    e.addContent(XMLUtil.createEnclosedValue("address_space_name", r.getOwner()
                                                   .getName())) ;
    e.addContent(XMLUtil.createEnclosedValue("cpu_name", r.getOwner()
                                                   .getOwner().getName())) ;
    e.addContent(XMLUtil.createEnclosedValue("state", 1)) ;
    e.addContent(XMLUtil.createEnclosedValue("protocol", r.getProtocol())) ;
    e.addContent(uses) ;

    for(ResourceUse use : r.getUses())
    {
      String val =
            use.getUser().getName() + " " + use.getWaitDate() + " " +
                  use.getReleaseDate() ;
      uses.addContent(XMLUtil.createEnclosedValue("resource_user", val)) ;
    }

    return e ;
  }

  private Element createTaskNode(CheddarTask t)
  {
    Element e = new Element("task") ;
    e.setAttribute(new Attribute("task_type", t.getType().name())) ;
    e.addContent(XMLUtil.createEnclosedValue("name", t.getName())) ;
    e.addContent(XMLUtil.createEnclosedValue("address_space_name", t.getOwner()
                                                   .getName())) ;
    e.addContent(XMLUtil.createEnclosedValue("cpu_name", t.getOwner()
                                                   .getOwner().getName())) ;
    e.addContent(XMLUtil.createEnclosedValue("capacity", t.getCapacity())) ;
    e.addContent(XMLUtil.createEnclosedValue("start_time", t.getStart_time())) ;
    e.addContent(XMLUtil.createEnclosedValue("policy", t.getQueueing_policy())) ;
    e.addContent(XMLUtil.createEnclosedValue("deadline", t.getDeadline())) ;
    e.addContent(XMLUtil.createEnclosedValue("blocking_time", t
                                                   .getBlocking_time())) ;
    e.addContent(XMLUtil.createEnclosedValue("priority", t.getPriority())) ;
    e.addContent(XMLUtil.createEnclosedValue("text_memory_size", t
                                                   .getText_memory_size())) ;
    e.addContent(XMLUtil.createEnclosedValue("stack_memory_size", t
                                                   .getStack_memory_size())) ;
    e.addContent(XMLUtil.createEnclosedValue("period", t.getPeriod())) ;
    e.addContent(XMLUtil.createEnclosedValue("jitter", t.getJitter())) ;
    String aRule = t.getActivationRule() ;

    if(aRule != null)
    {
      //e.addContent(XMLUtil.createEnclosedValue("seed", "0"));
      //e.addContent(XMLUtil.createEnclosedValue("predictable_seed", "TRUE"));
      e.addContent(XMLUtil.createEnclosedValue("activation_rule", aRule)) ;
    }

    Element parameters = new Element("parameters") ;
    int partitionIndex = t.getOwner().getPartition_index() ;

    if(partitionIndex >= 0)
    {
      Element partition =
            XMLUtil.createEnclosedValue("parameter", partitionIndex +
                                              " task_partition") ;
      partition.setAttribute(new Attribute("parameter_type", "integer")) ;
      parameters.addContent(partition) ;
    }

    if(parameters.getContentSize() > 0)
    {
      e.addContent(parameters) ;
    }

    return e ;
  }
}