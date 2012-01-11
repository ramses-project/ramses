package fr.tpt.aadl.sched.cheddar.strategies.arinc ;

import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.model.CheddarAddressSpace ;
import fr.tpt.aadl.sched.cheddar.strategies.ThreadSection ;

public class ARINC653ThreadSection extends ThreadSection
{

  public ARINC653ThreadSection(
                               CheddarContext sections)
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
