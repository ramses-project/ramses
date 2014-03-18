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

import java.io.File ;
import java.io.PrintStream ;

import org.osate.aadl2.Element ;
import org.osate.aadl2.parsesupport.LocationReference ;
import org.osate.utils.Aadl2Utils ;

public class MessageReporter4Cli implements MessageReporter
{
  @Override
  public void reportMessage(MessageStatus status,
                            String filename,
                            int line,
                            String message)
  {
    File file = new File(filename) ;
    filename = file.getName() ;
    
    StringBuilder sb = new StringBuilder() ;
    
    sb.append(message) ;
    sb.append(" in ") ;
    sb.append(filename) ;
    sb.append(" at line ") ;
    sb.append(line) ;
    
    printMessage(sb.toString(), status) ;
  }

  @Override
  public void reportMessage(MessageStatus status,
                            String message)
  {
    printMessage(message, status) ;
  }

  @Override
  public void reportMessage(MessageStatus status,
                            Element where,
                            String message)
  {
    StringBuilder sb = new StringBuilder() ;
    sb.append(message) ;
    
    LocationReference locref = Aadl2Utils.getLocationReference(where) ; 
    String filename = locref.getFilename() ;

    if (filename != null)
    {
      if(filename.contains("null"))
      {
        filename.replace("null", where.eResource().getURI().toString()) ;
      }

      File file = new File(filename) ;
      filename = file.getName() ;
      int line = locref.getLine() ;

      sb.append(" in ") ;
      sb.append(filename) ;
      sb.append(" at line ") ;
      sb.append(line) ;
    }

    printMessage(sb.toString(), status) ;
  }
  
  protected void printMessage(String msg, MessageStatus status)
  {
    this.getStream(status).println(msg) ;
  }
  
  protected PrintStream getStream(MessageStatus status)
  {
    PrintStream result ;
    
    switch(status)
    {
      case INTERNAL_FATAL_ERROR :
      case INTERNAL_ERROR :   
      case INTERNAL_WARNING :
      case AADL_ERROR:
      case AADL_WARNING:
      {
        result = System.err ; break ;
      }
     
      case INFO:
      default :
      {
        result = System.out ; break ;
      }
    }
    
    return result ;
  }

  @Override
  public void reportMessage(MessageStatus status, String msg, Throwable e)
  {
    this.printMessage(msg, status);
  }
}