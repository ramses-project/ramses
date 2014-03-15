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

package fr.tpt.aadl.flow.extraction.types ;

import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorAnnex ;

import fr.tpt.aadl.flow.extraction.ExecutionAnalyzer ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.ba.types.ThreadAA ;
import fr.tpt.aadl.flow.extraction.seq.types.ThreadSA ;
import fr.tpt.aadl.flow.extraction.util.BehaviorAnnexUtil ;
import fr.tpt.aadl.flow.model.ExecutionGraph ;

public class ThreadAnalyzer extends ExecutionAnalyzer
{
  private final ThreadAA threadAA ;
  private final ThreadSA threadSA ;

  public ThreadAnalyzer(
                        ExtractionContext ctxt)
  {
    super(ctxt.getErrManager()) ;
    threadAA = new ThreadAA(ctxt) ;
    threadSA = new ThreadSA(ctxt) ;
  }

  public final ExecutionGraph extractFrom(ComponentInstance task)
  {
    BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(task) ;

    if(ba != null)
    {
      return threadAA.extractFrom(ba, task) ;
    }
    else
    {
      return threadSA.extractFrom(task) ;
    }
  }
}