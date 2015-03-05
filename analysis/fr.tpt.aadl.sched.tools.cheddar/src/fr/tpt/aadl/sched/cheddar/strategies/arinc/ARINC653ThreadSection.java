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
 
 package fr.tpt.aadl.sched.cheddar.strategies.arinc ;

import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.model.CheddarAddressSpace ;
import fr.tpt.aadl.sched.cheddar.strategies.ThreadSection ;

public class ARINC653ThreadSection extends ThreadSection
{
  public ARINC653ThreadSection(CheddarContext sections)
  {
    super(sections) ;
    setTypeConversion("Periodic", CheddarTaskType.PARAMETRIC_TYPE) ;
  }

  protected String getInfoTaskActivationRule(ComponentInstance task)
  {
    return "arinc653_periodic" ;
  }

  protected int getInfoTaskStartTime(ComponentInstance task)
  {
    ComponentInstance process = task.getContainingComponentInstance() ;
    CheddarAddressSpace ap = (CheddarAddressSpace) getMappingOf(process) ;
    ARINC653Scheduler sched =
          (ARINC653Scheduler) ap.getOwner().getCustomScheduler() ;
    /*
    int start = 0;
    for(int i=0;i<ap.getPartition_index();i++)
    {
      start += sched.getPartitionDuration(i);
    }
    return start;*/
    int[] pSlots = sched.getPartitionSlots(ap.getPartition_index()) ;
    return sched.getSlotStartTime(pSlots[0]) ;
  }
}