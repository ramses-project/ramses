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

package fr.tpt.aadl.ramses.control.osate;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode ;

import fr.tpt.aadl.ramses.control.support.utils.Names ;

public class OutlinePropertyTester extends PropertyTester
{
  public static final String CAN_GENERATE_PROPERTY = "canGenerate" ;

  @Override
  public boolean test(Object receiver,
                      String property,
                      Object[] args,
                      Object expectedValue)
  {
    boolean result = false ;
    
    if(CAN_GENERATE_PROPERTY.equals(property))
    {
      EObjectNode selectedNode = (EObjectNode) receiver ; 
      
      String nodeClassName = selectedNode.getEClass().getInstanceClassName() ;
      
      if(Names.GENERATION_ROOT_OBJECT_CLASS.equals(nodeClassName))
      {
        result = true ;
      }
      else
      {
        result = false ;
      }
    }
    else
    {
      result = false ;
    }
    
    return result ;
  }
}