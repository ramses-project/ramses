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
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceObject ;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.CheddarOptions ;
import fr.tpt.aadl.sched.cheddar.model.CheddarAddressSpace ;
import fr.tpt.aadl.sched.cheddar.model.CheddarElement ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;

public class ProcessSection extends
                           CheddarModelConversionPart<CheddarAddressSpace>
{

  public ProcessSection(CheddarContext sections)
  {
    super(ComponentCategory.PROCESS, sections) ;
  }

  @Override
  protected boolean confirmExport(ComponentInstance process)
  {
    return !CheddarOptions.CHEDDAR_USES_GLOBAL_BUFFERS ;
  }

  @Override
  protected CheddarAddressSpace addInstanceSubNodes(ComponentInstance aadlInstance)
  {
    CheddarAddressSpace a = new CheddarAddressSpace(aadlInstance) ;
    ComponentInstance processor = getInfoProcessCPU(aadlInstance) ;
    /** Properties. */
    a.setData_memory_size(getInfoProcessMemorySize(aadlInstance, 0)) ;
    a.setStack_memory_size(getInfoProcessStackSize(aadlInstance, 0)) ;
    a.setText_memory_size(getInfoProcessMemorySize(aadlInstance, 0)) ;
    a.setHeap_memory_size(getInfoProcessHeapSize(aadlInstance, 0)) ;
    a.setPartition_index(getInfoPartitionIndex(aadlInstance)) ;
    /** Cheddar processor. */
    a.setOwner((CheddarProcessor) getMappingOf(processor)) ;
    return a ;
  }

  @Override
  protected final void endSection(List<CheddarElement> output)
  {
    CheddarModelConversionPart<?> thSection =
          sections.getExtractionSection(ComponentCategory.THREAD) ;
    ResourceSection dataSection =
          (ResourceSection) sections
                .getExtractionSection(ComponentCategory.DATA) ;

    for(ComponentInstance process : getVisitedComponents())
    {
      thSection.export(process, output) ;
    }

    if(CheddarOptions.CHEDDAR_EXPORT_CRITICAL_SECTIONS)
    {
      for(ComponentInstance process : getVisitedComponents())
      {
        dataSection.export(process, output) ;
      }
    }
  }

  protected ComponentInstance getProcessBind(ComponentInstance process)
  {
    ListValue lv = (ListValue) PropertyUtils.
        getPropertyValue("Actual_Processor_Binding", process) ;
    if(lv != null)
    {
      InstanceReferenceValue ref = (InstanceReferenceValue) lv.getOwnedListElements().get(0) ;
      InstanceObject owner = ref.getReferencedInstanceObject() ;
      return (ComponentInstance) owner ;
    }
    else
    {
      return null ;
    }
  }

  protected ComponentInstance getInfoProcessCPU(ComponentInstance process)
  {
    return getProcessBind(process) ;
  }

  protected int getInfoProcessMemorySize(ComponentInstance process,
                                         int defaultValue)
  {
    return (int) getInfoIntegerProperty(process, "Source_Code_Size",
                                        defaultValue) ;
  }

  protected int getInfoProcessStackSize(ComponentInstance process,
                                        int defaultValue)
  {
    return (int) getInfoIntegerProperty(process, "Source_Stack_Size",
                                        defaultValue) ;
  }

  protected int getInfoProcessDataSize(ComponentInstance process,
                                       int defaultValue)
  {
    return (int) getInfoIntegerProperty(process, "Source_Data_Size",
                                        defaultValue) ;
  }

  protected int getInfoProcessHeapSize(ComponentInstance process,
                                       int defaultValue)
  {
    return (int) getInfoIntegerProperty(process, "Source_Heap_Size",
                                        defaultValue) ;
  }

  //TODO : define a more generic method for user parameters
  protected int getInfoPartitionIndex(ComponentInstance process)
  {
    return -1 ;
  }
}