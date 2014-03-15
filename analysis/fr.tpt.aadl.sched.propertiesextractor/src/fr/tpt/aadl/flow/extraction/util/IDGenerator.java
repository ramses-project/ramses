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

package fr.tpt.aadl.flow.extraction.util ;

import java.util.HashMap ;
import java.util.Map ;

public class IDGenerator
{
  private static Map<String, Integer> nameOccurrences =
        new HashMap<String, Integer>() ;

  public static String getNewIdForName(String name)
  {
    Integer countO = nameOccurrences.get(name) ;
    int count = 1 ;

    if(countO != null)
    {
      count = countO.intValue() + 1 ;
    }

    nameOccurrences.put(name, count) ;
    return name + "__" + count ;
  }
}