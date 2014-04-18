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

import fr.tpt.aadl.ramses.control.support.reporters.AbstractSystemErrReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.MessageStatus ;

public class SysErrReporter4Osate extends AbstractSystemErrReporter
{
  protected MessageReporter4Osate _msgReporter ;
  
  public SysErrReporter4Osate(MessageReporter4Osate msgReporter)
  {
    _msgReporter = msgReporter ;
  }
  
  @Override
  public void fatal(String msg,
                    Throwable ex)
  {
    msg = super.formatFatalMsg(msg, ex) ;
    _msgReporter.reportMessage(MessageStatus.INTERNAL_FATAL_ERROR, msg, ex);
  }

  @Override
  public void fatal(String msg)
  {
    msg = super.formatFatalMsg(msg) ;
    _msgReporter.reportMessage(MessageStatus.INTERNAL_FATAL_ERROR, msg);
  }

  @Override
  public void error(String msg, boolean isDelayed)
  {
    _nbErrors++ ;
    
    msg = super.formatErrorMsg(msg) ;
    if(isDelayed)
    {
      _delayedErrors.add(msg) ;
    }
    else
    {
      _msgReporter.reportMessage(MessageStatus.INTERNAL_ERROR, msg);
    }
  }

  @Override
  public void warning(String msg, boolean isDelayed)
  {
    _nbWarnings++ ;
    
    msg = super.formatWarningMsg(msg) ;
    
    if(isDelayed)
    {
      _delayedWarnings.add(msg) ;
    }
    else
    {
      _msgReporter.reportMessage(MessageStatus.INTERNAL_WARNING, msg);
    }
  }
}