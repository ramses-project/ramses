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