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

import java.io.PrintStream ;

public class DefaultMessageReporter extends AbstractMessageReporter
{
  protected void printMessage(String msg, MessageStatus status)
  {
    this.getStream(status).println(msg) ;
  }
  
  protected PrintStream getStream(MessageStatus status)
  {
    PrintStream result ;
    
    switch(status)
    {
      case ERROR :
      case INTERNAL_ERROR :
      case WARNING : {result = System.err ; break ;}
      
      case INFO :
      default : {result = System.out ; break ;}
    }
    
    return result ;
  }
}