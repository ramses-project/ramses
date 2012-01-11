package fr.tpt.aadl.sched.cheddar.strategies.arinc ;

import java.util.List ;

import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.strategies.Hyperperiod ;

public class ARINC653Hyperperiod implements Hyperperiod
{

  private static ARINC653Hyperperiod instance = null ;

  public synchronized static ARINC653Hyperperiod getInstance()
  {
    if(instance == null)
    {
      instance = new ARINC653Hyperperiod() ;
    }

    return instance ;
  }

  private ARINC653Hyperperiod()
  {
  }

  @Override
  public int getValue(CheddarModel m)
  {
    List<CheddarProcessor> pl = m.getAllProcessors() ;

    if(pl.size() > 1)
    {
      throw new RuntimeException(
            "Undefined simulation period for distributed ARINC653 systems") ;
    }

    ARINC653Scheduler a = (ARINC653Scheduler) pl.get(0).getCustomScheduler() ;
    return a.getMajorFrame() ;
  }

}
