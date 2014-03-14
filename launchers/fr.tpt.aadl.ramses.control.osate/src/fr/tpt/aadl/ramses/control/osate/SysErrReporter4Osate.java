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

import org.eclipse.core.runtime.IStatus ;
import org.eclipse.core.runtime.Status ;
import org.eclipse.ui.statushandlers.StatusManager ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractSystemErrReporter ;

public class SysErrReporter4Osate extends AbstractSystemErrReporter
{
  private static StatusManager _MANAGER = StatusManager.getManager() ;
  
  @Override
  public void fatal(String msg,
                    Throwable ex)
  {
    msg = super.formatFatalMsg(msg, ex) ;
    openFatalErrorDialog(msg, ex);
  }

  @Override
  public void fatal(String msg)
  {
    msg = super.formatFatalMsg(msg) ;
    openFatalErrorDialog(msg);
  }

  @Override
  public void error(String msg, boolean isDelayed)
  {
    msg = super.formatErrorMsg(msg) ;
    if(isDelayed)
    {
      _delayedErrors.add(msg) ;
    }
    else
    {
      openErrorDialog(msg);
    }
  }

  @Override
  public void warning(String msg, boolean isDelayed)
  {
    msg = super.formatWarningMsg(msg) ;
    
    if(isDelayed)
    {
      _delayedWarnings.add(msg) ;
    }
    else
    {
      openWarningDialog(msg);
    }
  }

  @Override
  public void displayDelayedErrors()
  {
    String msg = super.formatDelayedErrors() ;
    if(msg != null)
    {
      if(_delayedErrors.isEmpty())
      {
        openWarningDialog(msg);
        _delayedWarnings.clear();
      }
      else
      {
        openErrorDialog(msg);
        _delayedErrors.clear();
        _delayedWarnings.clear();
      }
    }
  }

  @Override
  public void abortOnAadlErrors(String msg)
  {
    msg = super.formatAbortionOnAadlErrors(msg) ;
    openFatalErrorDialog(msg);
  }
  
  private void openFatalErrorDialog(String msg, Throwable e)
  {
    openDialog(IStatus.ERROR, msg, e);
  }
  
  private void openFatalErrorDialog(String msg)
  {
    openDialog(IStatus.ERROR, msg);
  }
  
  private void openErrorDialog(String msg)
  {
    openDialog(IStatus.ERROR, msg);
  }
  
  private void openWarningDialog(String msg)
  {
    openDialog(IStatus.WARNING, msg);
  }
  
  private void openDialog(int severity, String msg)
  {
    Status status = new Status(severity, Activator.PLUGIN_ID, msg) ;
    _MANAGER.handle(status, StatusManager.BLOCK);
  }
  
  private void openDialog(int severity, String msg, Throwable e)
  {
    Status status = new Status(severity, Activator.PLUGIN_ID, msg, e) ;
    _MANAGER.handle(status, StatusManager.BLOCK);
  }
}