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

package fr.tpt.aadl.flow.extraction.seq.types ;

import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.Subprogram ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.SubprogramSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.seq.CallSequenceAnalyzer ;
import fr.tpt.aadl.flow.extraction.util.ComputationUtil ;
import fr.tpt.aadl.flow.extraction.util.IDGenerator ;
import fr.tpt.aadl.flow.model.RTAction ;
import fr.tpt.aadl.flow.model.RTActionType ;

public class SubprogramSA extends CallSequenceAnalyzer
{

  public SubprogramSA(ExtractionContext ctxt)
  {
    super(ctxt) ;
  }

  public RTAction extractFrom(ComponentInstance spg,
                              RTAction lastAction)
  {
    Subcomponent sub = spg.getSubcomponent() ;
    ComponentClassifier cl = sub.getClassifier() ;
    return extractFrom(cl, lastAction) ;
  }

  public RTAction extractFrom(Classifier spg,
                              RTAction lastAction)
  {
    RTAction ret = null ;

    if(spg != null)
    {
      if(spg.getOwnedElements() != null && spg.getOwnedElements().size() > 0)
      {
        ret = extractSequence(spg, lastAction) ;
      }

      if((ret == lastAction) || (ret == null))
      {
        RTActionType type = ComputationUtil.getSubprogramActionType(spg) ;
        RTAction compute =
              new RTAction(IDGenerator.getNewIdForName(spg.getName()), type,
                    lastAction.getElement()) ;
        compute
              .setMinExecutionTime((float) ComputationUtil.getElementMinDuration(spg,
                                                                         this)) ;
        compute
              .setMaxExecutionTime((float) ComputationUtil.getElementMaxDuration(spg,
                                                                         this)) ;
        lastAction.addNext(compute) ;
        lastAction = compute ;
        ret = lastAction ;
      }
    }

    return ret ;
  }

  private RTAction extractSequence(Classifier spg,
                                   RTAction lastAction)
  {
    for(Element e : spg.getOwnedElements())
    {
      if(e instanceof SubprogramCallSequence)
      {
        SubprogramCallSequence seq = (SubprogramCallSequence) e ;

        for(SubprogramCall eCall : seq.getOwnedSubprogramCalls())
        {
          if(eCall instanceof SubprogramCall)
          {
            SubprogramCall call = (SubprogramCall) eCall ;
            Subprogram called = (Subprogram) call.getCalledSubprogram() ;
            SubprogramClassifier cl = null ;

            if(called instanceof SubprogramClassifier)
            {
              cl = (SubprogramClassifier) called ;
            }
            else
            {
              cl =
                    (SubprogramClassifier) ((SubprogramSubcomponent) called)
                          .getClassifier() ;
            }

            lastAction =
                  ctxt.getSubprogramAnalyzer().extractFrom(cl, lastAction) ;
          }
        }
      }
    }

    return lastAction ;
  }

}