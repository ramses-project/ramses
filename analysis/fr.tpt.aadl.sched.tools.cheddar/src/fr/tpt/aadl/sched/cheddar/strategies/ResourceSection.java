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
 
 package fr.tpt.aadl.sched.cheddar.strategies ;

import java.util.List ;

import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.flow.analysis.util.ResourceAccess ;
import fr.tpt.aadl.flow.analysis.util.TaskSequence ;
import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.flow.model.ExecutionGraphRegistry ;
import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.model.CheddarAddressSpace ;
import fr.tpt.aadl.sched.cheddar.model.CheddarResource ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

public class ResourceSection extends
                            CheddarModelConversionPart<CheddarResource>
{

  public ResourceSection(CheddarContext sections)
  {
    super(ComponentCategory.DATA, sections) ;
  }

  @Override
  protected CheddarResource addInstanceSubNodes(ComponentInstance aadlInstance)
  {
    CheddarResource r = new CheddarResource(aadlInstance) ;
    ComponentInstance process = (ComponentInstance) aadlInstance.getOwner() ;
    r.setName(aadlInstance.getName()) ;
    r.setOwner((CheddarAddressSpace) getMappingOf(process)) ;
    r.setProtocol("IMMEDIATE_PRIORITY_CEILING_PROTOCOL") ;
    extractFlow(r, process) ;
    r.setName(process.getName() + "." + aadlInstance.getName()) ;
    return r ;
  }

  private void extractFlow(CheddarResource r,
                           ComponentInstance process)
  {
    final String resourceID = r.getName() ;
    ExecutionGraphRegistry register = sections.getExecutionRegistry() ;
    List<ExecutionGraph> graphList = register.getUsersOf(process, resourceID) ;

    for(ExecutionGraph graph : graphList)
    {
      TaskSequence seq = graph.getSynchronizationInstants() ;
      ResourceAccess read = seq.getReadAccess(resourceID) ;
      ResourceAccess write = seq.getWriteAccess(resourceID) ;

      if(read != null)
      {
        ComponentInstance t = (ComponentInstance) graph.getTask() ;
        CheddarTask user = (CheddarTask) getMappingOf(t) ;
        r.addUse(user, read.getStart(), read.getEnd()) ;
      }

      if(write != null)
      {
        ComponentInstance t = (ComponentInstance) graph.getTask() ;
        CheddarTask user = (CheddarTask) getMappingOf(t) ;
        r.addUse(user, write.getStart(), write.getEnd()) ;
      }
    }
  }
}