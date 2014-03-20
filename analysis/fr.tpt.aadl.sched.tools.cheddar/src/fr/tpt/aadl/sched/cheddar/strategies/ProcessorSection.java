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

import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.CheddarOptions ;
import fr.tpt.aadl.sched.cheddar.model.CheddarAddressSpace ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.model.SchedulerPipeline ;

public class ProcessorSection extends
                             CheddarModelConversionPart<CheddarProcessor>
{
  public ProcessorSection(CheddarContext sections)
  {
    super(ComponentCategory.PROCESSOR, sections) ;
  }

  @Override
  protected CheddarProcessor addInstanceSubNodes(ComponentInstance aadlInstance)
  {
    SchedulerPipeline automatonGen = getSchedulerAutomaton(aadlInstance) ;
    CheddarProcessor p = new CheddarProcessor(aadlInstance, automatonGen) ;
    p.setSchedulerType(getSchedulerType()) ;
    p.setWithNetwork(getInfoProcNetwork(aadlInstance)) ;

    if(CheddarOptions.CHEDDAR_USES_GLOBAL_BUFFERS)
    {
      CheddarAddressSpace as = new CheddarAddressSpace(aadlInstance) ;
      as.setOwner(p) ;
      as.setName(p.getName() + "_address_space") ;
    }

    return p ;
  }

  protected String getSchedulerType()
  {
    return "POSIX_1003_HIGHEST_PRIORITY_FIRST_PROTOCOL" ;
  }

  protected SchedulerPipeline getSchedulerAutomaton(ComponentInstance processor)
  {
    return null ;
  }

  protected boolean getInfoProcNetwork(ComponentInstance proc)
  {
    return false ;
  }
}