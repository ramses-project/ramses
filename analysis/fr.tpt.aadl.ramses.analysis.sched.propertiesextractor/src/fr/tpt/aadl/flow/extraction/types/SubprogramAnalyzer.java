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

import org.osate.aadl2.Classifier ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorAnnex ;

import fr.tpt.aadl.flow.extraction.ExecutionAnalyzer ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.ba.types.SubprogramAA ;
import fr.tpt.aadl.flow.extraction.seq.types.SubprogramSA ;
import fr.tpt.aadl.flow.extraction.util.BehaviorAnnexUtil ;
import fr.tpt.aadl.flow.model.RTAction ;

public class SubprogramAnalyzer extends ExecutionAnalyzer
{

  private final SubprogramAA spgAA ;
  private final SubprogramSA spgSA ;

  public SubprogramAnalyzer(
                            ExtractionContext ctxt)
  {
    super(ctxt.getErrManager()) ;
    spgAA = new SubprogramAA(ctxt) ;
    spgSA = new SubprogramSA(ctxt) ;
  }

  public RTAction extractFrom(ComponentInstance spg,
                              RTAction lastAction)
  {
    BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg) ;

    if(ba != null)
    {
      return spgAA.extractFrom(ba, lastAction) ;
    }
    else
    {
      return spgSA.extractFrom(spg, lastAction) ;
    }
  }

  public RTAction extractFrom(Classifier spg,
                              RTAction lastAction)
  {
    BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg) ;

    if(ba != null)
    {
      return spgAA.extractFrom(ba, lastAction) ;
    }
    else
    {
      return spgSA.extractFrom(spg, lastAction) ;
    }
  }
}