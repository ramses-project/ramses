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

package fr.tpt.aadl.sched.cheddar ;

import java.util.HashMap ;

import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.flow.model.ExecutionGraphRegistry ;
import fr.tpt.aadl.sched.cheddar.events.TimelineData ;
import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.strategies.BasicTimelineData ;
import fr.tpt.aadl.sched.cheddar.strategies.CheddarModelConversionPart ;
import fr.tpt.aadl.sched.cheddar.strategies.Hyperperiod ;
import fr.tpt.aadl.sched.cheddar.strategies.ProcessSection ;
import fr.tpt.aadl.sched.cheddar.strategies.ProcessorSection ;
import fr.tpt.aadl.sched.cheddar.strategies.ResourceSection ;
import fr.tpt.aadl.sched.cheddar.strategies.ThreadSection ;
import fr.tpt.aadl.sched.cheddar.strategies.arinc.ARINC653Hyperperiod ;
import fr.tpt.aadl.sched.cheddar.strategies.arinc.ARINC653ProcessSection ;
import fr.tpt.aadl.sched.cheddar.strategies.arinc.ARINC653ProcessorSection ;
import fr.tpt.aadl.sched.cheddar.strategies.arinc.ARINC653ThreadSection ;

public class CheddarContext
{
  public final static CheddarContext DEFAULT = initDefault() ;
  public final static CheddarContext ARINC653 = initARINC653() ;

  private static CheddarContext initDefault()
  {
    CheddarContext sec ;
    sec = new CheddarContext() ;
    sec.registerSection(new ProcessorSection(sec)) ;
    sec.registerSection(new ProcessSection(sec)) ;
    sec.registerSection(new ThreadSection(sec)) ;
    sec.registerSection(new ResourceSection(sec)) ;
    return sec ;
  }

  private static CheddarContext initARINC653()
  {
    CheddarContext sec = new CheddarContext() ;
    sec.registerSection(new ARINC653ProcessorSection(sec)) ;
    sec.registerSection(new ARINC653ProcessSection(sec)) ;
    sec.registerSection(new ARINC653ThreadSection(sec)) ;
    sec.registerSection(new ResourceSection(sec)) ;
    sec.period = ARINC653Hyperperiod.getInstance() ;
    //sec.timeEventsInterpreterFactory = ARINC653TimelineData.Factory.getInstance();
    return sec ;
  }

  public static CheddarContext getContextFor(SystemInstance root)
  {
    for(ComponentInstance c : root.getComponentInstances())
    {
      if(c.getCategory() == ComponentCategory.PROCESSOR)
      {
        for(ComponentInstance cc : c.getComponentInstances())
        {
          if(cc.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
          {
            return ARINC653 ;
          }
        }
      }
    }

    return DEFAULT ;
  }

  /** AADL extraction strategy. */
  private HashMap<ComponentCategory, CheddarModelConversionPart<?>> conversionParts =
        new HashMap<ComponentCategory, CheddarModelConversionPart<?>>() ;

  /** Execution graph registry. */
  private ExecutionGraphRegistry executionGraphRegistry = null ;

  /** Simulation hyperperiod computation. */
  private Hyperperiod period = Hyperperiod.Basic.getInstance() ;

  /** Time events interpreter factory. */
  private TimelineData.Factory timeEventsInterpreterFactory =
        BasicTimelineData.Factory.getInstance() ;

  private void registerSection(CheddarModelConversionPart<?> section)
  {
    conversionParts.put(section.getCategory(), section) ;
  }

  public CheddarModelConversionPart<?> getExtractionSection(ComponentCategory aadlCategory)
  {
    return conversionParts.get(aadlCategory) ;
  }

  public ExecutionGraphRegistry getExecutionRegistry()
  {
    return executionGraphRegistry ;
  }

  public int getSimulationPeriod(CheddarModel m)
  {
    return period.getValue(m) ;
  }

  public TimelineData.Factory getTimeEventsInterpreterFactory()
  {
    return timeEventsInterpreterFactory ;
  }

  public void setExecutionRegistry(ExecutionGraphRegistry registry)
  {
    executionGraphRegistry = registry ;
  }
}