package fr.tpt.aadl.sched.cheddar.strategies.arinc ;

import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceObject ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.strategies.ProcessSection ;

public class ARINC653ProcessSection extends ProcessSection
{

  public ARINC653ProcessSection(
                                CheddarContext sections)
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
  
  
    PropertyExpression expr = null;
    try
    {
      expr = PropertyUtils.getPropertyValue("Slots_Allocation", proc);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return -1;
    }
  
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
  }*/
}
