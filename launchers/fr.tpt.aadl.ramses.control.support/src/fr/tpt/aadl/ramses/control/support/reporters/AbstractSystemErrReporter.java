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

package fr.tpt.aadl.ramses.control.support.reporters;

import java.util.LinkedList ;

import fr.tpt.aadl.ramses.control.support.utils.Names ;

public abstract class AbstractSystemErrReporter implements SystemErrReporter
{
  protected LinkedList<String> _delayedErrors = new LinkedList<String>() ;
  protected LinkedList<String> _delayedWarnings = new LinkedList<String>() ;
  
  protected int _nbErrors = 0;
  protected int _nbWarnings = 0;
  
  protected String formatFatalMsg(String initialMsg, Throwable ex)
  {
    StringBuilder sb = new StringBuilder() ;
    sb.append("Abort on fatal error (see log file for more information): ");
    sb.append(initialMsg) ;
    sb.append(" (") ;
    
    if(! ( ex.getMessage() == null ||
           ex.getMessage().isEmpty() ||
           "null".equals(ex.getMessage())
         )
      )
    {
      sb.append(ex.getMessage()) ;
    }
    else
    {
      sb.append(ex.getClass().getSimpleName()) ;
    }
    sb.append(')') ;

    return sb.toString() ;
  }
  
  protected String formatFatalMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "Abort on fatal error (see log file for more information): " +
            initialMsg ;
  }
  
  protected String formatErrorMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "<Error> " + initialMsg ;
  }
  
  protected String formatWarningMsg(String initialMsg)
  {
    // TODO to be implemented.
    return "<Warning> " + initialMsg ;
  }
  
  @Override
  public String formatDelayedErrors()
  {
    if(!(_delayedErrors.isEmpty() && _delayedWarnings.isEmpty()))
    {
      // TODO to be refined.
      StringBuilder sb = new StringBuilder() ;
      
      sb.append("RAMSES system report:") ;
      
      if(false == _delayedErrors.isEmpty())
      {
        sb.append(Names.NEW_LINE);
        sb.append(Names.NEW_LINE);
        sb.append("\tErrors:");
        sb.append(Names.NEW_LINE);
        sb.append(Names.NEW_LINE);
        for(String msg : _delayedErrors)
        {
          sb.append("\t_ ") ;
          sb.append(msg) ;
        }
      }
      
      if(false == _delayedWarnings.isEmpty())
      {
        sb.append(Names.NEW_LINE);
        sb.append(Names.NEW_LINE);
        sb.append("\tWarnings:");
        sb.append(Names.NEW_LINE);
        sb.append(Names.NEW_LINE);
        for(String msg : _delayedWarnings)
        {
          sb.append("\t_ ") ;
          sb.append(msg) ;
        }
      }
      
      return sb.toString() ;
    }
    else
    {
      return null ;
    }
  }
  
  @Override
  public boolean hasDelayedErrors()
  {
    return (false == _delayedErrors.isEmpty()) ||
           (false == _delayedWarnings.isEmpty()) ; 
  }
  
  @Override
  public int getNbErrors()
  {
    return _nbErrors ;
  }
  
  @Override
  public int getNbWarnings()
  {
    return _nbWarnings ;
  }
}