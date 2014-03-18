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

import java.util.Collections ;
import java.util.LinkedList ;
import java.util.List ;

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
    
    if(! (initialMsg == null || initialMsg.isEmpty()))
    {
      sb.append(initialMsg) ;
      sb.append(" (") ;
      formatException(sb, ex);
      sb.append(')') ;
    }
    else
    {
      formatException(sb, ex);
    }

    return sb.toString() ;
  }
  
  private void formatException(StringBuilder sb, Throwable ex)
  {
    if(!(ex.getMessage() == null ||
         ex.getMessage().isEmpty() ||
         "null".equals(ex.getMessage())))
    {
      sb.append(ex.getMessage()) ;
    }
    else
    {
      sb.append(ex.getClass().getSimpleName()) ;
    }
  }
  
  protected String formatFatalMsg(String initialMsg)
  {
    return "<Fatal Error> Abort on fatal error (see log file for more information): " +
            initialMsg ;
  }
  
  protected String formatErrorMsg(String initialMsg)
  {
    return "<Internal Error> " + initialMsg ;
  }
  
  protected String formatWarningMsg(String initialMsg)
  {
    return "<Internal Warning> " + initialMsg ;
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
  
  @Override
  public List<String> getDelayedErrors()
  {
    return Collections.unmodifiableList(_delayedErrors) ;
  }

  @Override
  public List<String> getDelayedWarnings()
  {
    return Collections.unmodifiableList(_delayedWarnings) ;
  }

  @Override
  public void clearErrorsAndWarnings()
  {
    _delayedErrors.clear();
    _delayedWarnings.clear();
    _nbErrors = 0 ;
    _nbWarnings = 0 ;
  }
}