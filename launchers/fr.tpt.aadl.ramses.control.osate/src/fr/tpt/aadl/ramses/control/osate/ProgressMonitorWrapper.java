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

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractProgressMonitor ;

public class ProgressMonitorWrapper extends AbstractProgressMonitor
{
  protected IProgressMonitor _monitor ;
  
  private Logger _logger = Logger.getLogger(ProgressMonitorWrapper.class) ;
  
  public ProgressMonitorWrapper(IProgressMonitor osateMonitor)
  {
    _monitor = osateMonitor ;
  }
  
  @Override
  public void beginTask(String name,
                        int totalWork)
  {
    _mainTask = name ;
    _totalWork = totalWork ;
    _monitor.beginTask(name, totalWork);
    String msg = super.formatBeginTask(name, totalWork) ;
    _logger.info(msg);
  }

  @Override
  public void done()
  {
    if(false == _monitor.isCanceled())
    {
      _monitor.done();
      String msg = super.formatDone(_mainTask) ;
      _logger.info(msg) ;
    }
  }

  @Override
  public void internalWorked(double work)
  {
    _monitor.internalWorked(work);
  }

  @Override
  public boolean isCanceled()
  {
    return _monitor.isCanceled() ;
  }

  @Override
  public void setCanceled(boolean value)
  {
    if(false == _monitor.isCanceled())
    {
      if(value)
      {
        _monitor.setCanceled(true);
        String msg = super.formatCanceled(_mainTask) ;
        _logger.info(msg) ;
      }
    }
    // else do not set.
  }

  @Override
  public void setTaskName(String name)
  {
    _mainTask = name ;
    _monitor.setTaskName(name) ;
  }

  @Override
  public void subTask(String name)
  {
    if(false == _monitor.isCanceled())
    {
      _monitor.subTask(name) ;
      String msg = super.formatSubTask(name) ;
      _logger.info(msg) ;
    }
  }

  @Override
  public void worked(int work)
  {
    if(false == _monitor.isCanceled())
    {
      _monitor.worked(work);
      String msg = super.formatWorked(work, _totalWork) ;
      _logger.info(msg) ;
    }
  }
}