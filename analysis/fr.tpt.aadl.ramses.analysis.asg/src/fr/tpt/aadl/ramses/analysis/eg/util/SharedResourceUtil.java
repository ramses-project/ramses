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

package fr.tpt.aadl.ramses.analysis.eg.util;

import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNodeKind ;

public class SharedResourceUtil
{
  private static final String[] GET_SUBPROGRAMS = {"Get_Resource", "Wait_Semaphore"};
  private static final String[] RELEASE_SUBPROGRAMS = {"Release_Resource", "Signal_Semaphore"};
  
  private SharedResourceUtil(){}
  
  public static boolean isGet_Resource (String name)
  {
    for(String _name : GET_SUBPROGRAMS)
    {
      if (name.equals(_name))
      {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isRelease_Resource (String name)
  {
    for(String _name : RELEASE_SUBPROGRAMS)
    {
      if (name.equals(_name))
      {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSynchronizationSubprogram (String name)
  {
    return isGet_Resource (name) || isRelease_Resource (name);
  }
  
  public static void setSynchronizationNode (EGNode n, String name)
  {
    if (isGet_Resource(name))
    {
      n.setKind(EGNodeKind.CriticalSectionStart);
    }
    else if (isRelease_Resource(name))
    {
      n.setKind(EGNodeKind.CriticalSectionEnd);
    }
  }
}