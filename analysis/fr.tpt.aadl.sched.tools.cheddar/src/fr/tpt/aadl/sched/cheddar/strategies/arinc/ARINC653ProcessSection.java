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
import org.osate.aadl2.instance.InstanceObject ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.strategies.ProcessSection ;

public class ARINC653ProcessSection extends ProcessSection
{
  public ARINC653ProcessSection(CheddarContext sections)
  {
    super(sections) ;
  }

  protected ComponentInstance getInfoProcessCPU(ComponentInstance process)
  {
    InstanceObject VP = getProcessBind(process) ;
    ComponentInstance CPU = VP.getContainingComponentInstance() ;
    return CPU ;
  }

  @Override
  protected int getInfoPartitionIndex(ComponentInstance process)
  {
    //TODO: CPU must not own subcomponents other than VP !
    ComponentInstance VP = getProcessBind(process) ;
    ComponentInstance proc = getInfoProcessCPU(process) ;
    return proc.getComponentInstances().indexOf(VP) ;
  }

  /*protected int getInfoPartitionIndex(ComponentInstance process)
  {
    //TODO: CPU must not own subcomponents other than VP !
  
    ComponentInstance VP = getProcessBind(process);
    ComponentInstance proc = getInfoProcessCPU(process);
  
  
    PropertyExpression expr = PropertyUtils.getPropertyValue("Slots_Allocation", proc);
    if(expr != null
    {
      ListValue list = (ListValue) expr;
  
    for(int refIndex = 0; refIndex < list.getOwnedListElements().size(); refIndex++)
    {
      ReferenceValue ref = (ReferenceValue) list.getOwnedListElements().get(refIndex);
      ContainmentPathElement el = ref.getContainmentPathElements().get(0);
      VirtualProcessorSubcomponent VPsub = (VirtualProcessorSubcomponent) el.getNamedElement();
  
      if (VPsub.getName().equals(VP.getName()))
      {
        return refIndex;
      }
    }
    return -1;
    }
    else
    {
      return -1;
    }
  }*/
}