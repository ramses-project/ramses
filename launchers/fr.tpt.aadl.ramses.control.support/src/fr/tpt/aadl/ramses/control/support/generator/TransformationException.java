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

package fr.tpt.aadl.ramses.control.support.generator;

import fr.tpt.aadl.ramses.control.support.RamsesException ;

public class TransformationException extends RamsesException
{
  /**
   * 
   */
  private static final long serialVersionUID = 7398628902124971999L ;

  public TransformationException(String errorMessage)
  {
    super(errorMessage) ;
  }
  
  public TransformationException(String errorMessage, Throwable e)
  {
    super(errorMessage, e) ;
  }
}