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

import org.osate.aadl2.ContainmentPathElement ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.model.SchedulerPipeline ;
import fr.tpt.aadl.sched.cheddar.strategies.ProcessorSection ;

public class ARINC653ProcessorSection extends ProcessorSection
{
  public ARINC653ProcessorSection(CheddarContext sections)
  {
    super(sections) ;
  }

  @Override
  protected String getSchedulerType()
  {
    return "pipeline_User_Defined_Protocol" ;
  }

  protected SchedulerPipeline getSchedulerAutomaton(ComponentInstance processor)
  {
    ARINC653Scheduler s = new ARINC653Scheduler() ;
    int slots = getSlotsCount(processor) ;
    int partitions = getPartitionsCount(processor) ;
    s.setSlotsCount(slots) ;
    s.setPartitionCount(partitions) ;

    for(int slot = 0 ; slot < slots ; slot++)
    {
      int p = getPartitionAtSlot(processor, slot) ;
      int d = getSlotDuration(processor, slot) ;
      s.setPartitionAtSlot(slot, p) ;
      s.setSlotDuration(slot, d) ;
    }

    return s ;
  }

  protected int getPartitionsCount(ComponentInstance proc)
  {
    //TODO: don't works if processor owns other kinds of components
    return proc.getComponentInstances().size() ;
  }

  protected int getSlotsCount(ComponentInstance proc)
  {
    PropertyExpression expr =
        PropertyUtils.getPropertyValue("Partition_Slots", proc) ;
    if(expr != null)
    {
      ListValue list = (ListValue) expr ;
      return list.getOwnedListElements().size() ;
    }
    else
    {
      return 0 ;
    }
  }

  protected int getSlotDuration(ComponentInstance proc,
                                int slot)
  {
    PropertyExpression expr =
        PropertyUtils.getPropertyValue("Partition_Slots", proc) ;
    if(expr != null)
    {
      
      ListValue list = (ListValue) expr ;
      PropertyExpression value = list.getOwnedListElements().get(slot) ;
      IntegerLiteral duration = (IntegerLiteral) value ;
      return (int) duration.getValue() ;
    }
    {
      return 0 ;
    }
  }

  protected int getPartitionAtSlot(ComponentInstance proc,
                                   int slot)
  {
    PropertyExpression expr =
        PropertyUtils.getPropertyValue("Slots_Allocation", proc) ;
    if(expr != null)
    {
      ListValue list = (ListValue) expr ;
      PropertyExpression value = list.getOwnedListElements().get(slot) ;
      ReferenceValue ref = (ReferenceValue) value ;
      ContainmentPathElement el = ref.getContainmentPathElements().get(0) ;
      VirtualProcessorSubcomponent VPsub =
            (VirtualProcessorSubcomponent) el.getNamedElement() ;
      return getPartitionIndex(proc, VPsub) ;
    }
    else
    {
      return -1 ;
    }
  }

  private int getPartitionIndex(ComponentInstance proc,
                                VirtualProcessorSubcomponent VPsub)
  {
    for(int indexP = 0 ; indexP < proc.getComponentInstances().size() ; indexP++)
    {
      ComponentInstance vp = proc.getComponentInstances().get(indexP) ;

      if(vp.getSubcomponent() == VPsub)
      {
        return indexP ;
      }
    }

    return -1 ;
  }
}