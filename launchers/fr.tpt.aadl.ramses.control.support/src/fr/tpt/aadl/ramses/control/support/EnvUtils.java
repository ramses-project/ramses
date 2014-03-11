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

package fr.tpt.aadl.ramses.control.support;

public class EnvUtils
{
  /**
   * Fetch VM args or environmental variables upon the given name. Return 
   * {@code null}, if the variable is not set.
   * 
   * @param extVarName the given name
   * @return the external variable value or {@code null} if it is not set
   */
  public static String getExternalVariable(String extVarName)
  {
    String result = null ;
    
    if(extVarName != null)
    {
      result= System.getProperty(extVarName) ;
      
      if(result == null || result.isEmpty())
      {
        result=System.getenv(extVarName) ;
      }
    }

    return result ;
  }
}