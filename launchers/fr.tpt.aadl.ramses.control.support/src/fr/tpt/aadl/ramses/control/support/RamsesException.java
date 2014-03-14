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

public abstract class RamsesException extends Exception
{
  protected String _encapsMessage ;  
  
  /**
   * 
   */
  private static final long serialVersionUID = -8622765345145000268L ;
  
  public RamsesException(String errorMessage)
  {
    super(errorMessage) ;
  }
  
  /**
   * Rethrow encapsulation
   * 
   * @param errorMessage the encapsulating message
   * @param e the exception been encapsulated
   */
  public RamsesException(String errorMessage, Throwable e)
  {
    super(errorMessage, e) ;
    _encapsMessage = errorMessage ;
  }
  
  @Override
  public String getMessage()
  {
    return formatRethrowMessage(_encapsMessage, super.getCause()) ;
  }
  
  public static String formatRethrowMessage(String initialMessage,
                                            Throwable ex)
  {
    if(ex != null &&
       ex.getMessage() != null &&
       ! ex.getMessage().equalsIgnoreCase("null"))
    {
      initialMessage += " (" + ex.getMessage() + ')' ;
    }
      
    return initialMessage ;
  }
}