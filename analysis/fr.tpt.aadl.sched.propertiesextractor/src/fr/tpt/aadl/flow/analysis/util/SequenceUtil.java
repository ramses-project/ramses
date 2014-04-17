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

package fr.tpt.aadl.flow.analysis.util ;

import fr.tpt.aadl.flow.model.RTAction ;
import fr.tpt.aadl.flow.model.RTActionType ;

public class SequenceUtil
{

  private SequenceUtil()
  {
  }

  public static RTAction getFirstAfterSequenceOf(RTActionType sequenceType,
                                                 RTAction start)
  {
    RTAction current = start ;

    while(current != null && (current.getType() != sequenceType))
    {
      current = next(current) ;
    }

    while(current != null)
    {
      if(current.getType() != sequenceType)
      {
        return current ;
      }

      current = next(current) ;
    }

    return null ;
  }

  public static RTAction getFirstOf(RTActionType sequenceType,
                                    RTAction start)
  {
    RTAction current = start ;

    while(current != null)
    {
      if(current.getType() == sequenceType)
      {
        return current ;
      }

      current = next(current) ;
    }

    return null ;
  }

  public static RTAction next(RTAction a)
  {
    if(a.getNext().size() > 0)
    {
      return a.getNext().get(0) ;
    }
    else
    {
      return null ;
    }
  }
}