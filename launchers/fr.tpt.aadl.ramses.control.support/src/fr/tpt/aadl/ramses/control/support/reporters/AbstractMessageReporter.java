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

import org.osate.aadl2.Element ;
import org.osate.aadl2.parsesupport.LocationReference ;

import fr.tpt.aadl.utils.Aadl2Utils ;

public abstract class AbstractMessageReporter implements MessageReporter
{
  abstract protected void printMessage(String msg, MessageStatus status) ;

  @Override
  public void reportMessage(MessageStatus status,
                            String filename,
                            int line,
                            String message)
  {
    File file = new File(filename) ;
    filename = file.getName() ;
    StringBuilder sb = new StringBuilder(status.toString()) ;
    sb.append(" in ") ;
    sb.append(filename) ;
    sb.append(" at line ") ;
    sb.append(line) ;
    sb.append(": ") ;
    sb.append(message) ;
    printMessage(sb.toString(), status) ;
  }

  @Override
  public void reportMessage(MessageStatus status,
                            String message)
  {
    StringBuilder sb = new StringBuilder(status.toString()) ;
    sb.append(' ') ;
    sb.append(message) ;
    printMessage(sb.toString(), status) ;
  }

  @Override
  public void reportMessage(MessageStatus status,
                            Element where,
                            String message)
  {
    LocationReference locref = Aadl2Utils.getLocationReference(where) ; 
    
    String filename = locref.getFilename() ;
    /*if (filename==null)
    {
    	return;
    }*/

    if(filename.contains("null"))
    {
      filename.replace("null", where.eResource().getURI().toString()) ;
    }

    File file = new File(filename) ;
    filename = file.getName() ;
    int line = locref.getLine() ;
    StringBuilder sb = new StringBuilder(status.toString()) ;
    sb.append(" in ") ;
    sb.append(filename) ;
    sb.append(" at line ") ;
    sb.append(line) ;
    sb.append(": ") ;
    sb.append(message) ;
    printMessage(sb.toString(), status) ;
  }
}