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

import java.util.List ;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.strategies.Hyperperiod ;

public class ARINC653Hyperperiod implements Hyperperiod
{
  private static ARINC653Hyperperiod instance = null ;
  
  private static Logger _LOGGER = Logger.getLogger(ARINC653Hyperperiod.class) ;

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
      String msg = 
          "Undefined simulation period for distributed ARINC653 systems" ;
      _LOGGER.fatal(msg) ;
      throw new RuntimeException(msg) ;
    }

    ARINC653Scheduler a = (ARINC653Scheduler) pl.get(0).getCustomScheduler() ;
    return a.getMajorFrame() ;
  }
}