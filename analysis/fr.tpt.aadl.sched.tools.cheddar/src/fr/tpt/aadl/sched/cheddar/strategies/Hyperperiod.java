package fr.tpt.aadl.sched.cheddar.strategies ;

import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

public interface Hyperperiod
{

  public int getValue(CheddarModel m) ;

  public class Basic implements Hyperperiod
  {

    private static Basic instance = null ;

    public static synchronized Basic getInstance()
    {
      if(instance == null)
      {
        instance = new Basic() ;
      }

      return instance ;
    }

    private Basic()
    {
    }

    @Override
    public int getValue(CheddarModel m)
    {
      int period = -1 ;

      for(CheddarTask t : m.getAllTasks())
      {
        if(period == -1)
        {
          period = t.getPeriod() ;
        }
        else
        {
          period = lcm(period, t.getPeriod()) ;
        }
      }

      return period ;
    }

    private static int lcm(int a,
                           int b)
    {
      return lcm(a, b, a) ;
    }

    private static int lcm(int a,
                           int b,
                           int r)
    {
      if(r % b == 0)
      {
        return r ;
      }
      else
      {
        return lcm(a, b, r + a) ;
      }
    }
  }
}
