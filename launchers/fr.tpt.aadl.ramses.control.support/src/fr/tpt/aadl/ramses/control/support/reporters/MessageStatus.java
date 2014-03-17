/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.control.support.reporters ;

public enum MessageStatus
{
  AADL_ERROR("Error"),
  AADL_WARNING("Warning"),
  AADL_INFO("Info"),
  
  INTERNAL_FATAL_ERROR("Internal Fatal Error"),
  INTERNAL_ERROR("Internal Error"),
  INTERNAL_WARNING("Internal Warning"),
  
  INFO("");
  
  public final String _literal ;
  public String _stage = null ;

  private MessageStatus(String literal)
  {
    this._literal = literal ;
  }

  public String toString()
  {
    StringBuilder sb = new StringBuilder() ;

    sb.append('<') ;
    
    if(! (_stage == null || _stage.isEmpty()))
    {
      sb.append(_stage) ;
      sb.append(' ') ;
    }
    
    sb.append(_literal) ;
    sb.append('>') ;
    
    return sb.toString() ;
  }
}