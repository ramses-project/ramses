package fr.tpt.aadl.sched.cheddar.strategies.arinc ;

import org.osate.aadl2.ContainmentPathElement ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.model.SchedulerPipeline ;
import fr.tpt.aadl.sched.cheddar.strategies.ProcessorSection ;
import fr.tpt.aadl.utils.PropertyUtils ;

public class ARINC653ProcessorSection extends ProcessorSection
{

  public ARINC653ProcessorSection(
                                  CheddarContext sections)
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
    try
    {
      PropertyExpression expr =
            PropertyUtils.getPropertyValue("Partition_Slots", proc) ;
      ListValue list = (ListValue) expr ;
      return list.getOwnedListElements().size() ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      return 0 ;
    }
  }

  protected int getSlotDuration(ComponentInstance proc,
                                int slot)
  {
    try
    {
      PropertyExpression expr =
            PropertyUtils.getPropertyValue("Partition_Slots", proc) ;
      ListValue list = (ListValue) expr ;
      PropertyExpression value = list.getOwnedListElements().get(slot) ;
      IntegerLiteral duration = (IntegerLiteral) value ;
      return (int) duration.getValue() ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      return 0 ;
    }
  }

  protected int getPartitionAtSlot(ComponentInstance proc,
                                   int slot)
  {
    try
    {
      PropertyExpression expr =
            PropertyUtils.getPropertyValue("Slots_Allocation", proc) ;
      ListValue list = (ListValue) expr ;
      PropertyExpression value = list.getOwnedListElements().get(slot) ;
      ReferenceValue ref = (ReferenceValue) value ;
      ContainmentPathElement el = ref.getContainmentPathElements().get(0) ;
      VirtualProcessorSubcomponent VPsub =
            (VirtualProcessorSubcomponent) el.getNamedElement() ;
      return getPartitionIndex(proc, VPsub) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
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
