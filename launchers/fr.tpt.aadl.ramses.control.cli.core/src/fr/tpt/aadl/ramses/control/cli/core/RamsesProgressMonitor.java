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

package fr.tpt.aadl.ramses.control.cli.core;

import java.io.PrintStream ;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractProgressMonitor ;

public class RamsesProgressMonitor extends AbstractProgressMonitor
{
  protected PrintStream _output ;
  protected boolean _isNotCanceled = true ;
  private Logger _logger = Logger.getLogger(RamsesProgressMonitor.class) ;
  
  public RamsesProgressMonitor(PrintStream stdOutput)
  {
    _output = stdOutput ;
  }
  
  @Override
  public void beginTask(String name,
                        int totalWork)
  {
    _mainTask = name ;
    _totalWork = totalWork ;
    String msg = super.formatBeginTask(name, totalWork) ;
    _logger.info(msg);
    _output.println(msg) ;
  }

  @Override
  public void done()
  {
    if(_isNotCanceled)
    {
      _isNotCanceled = false ; // According to the IProgressMonitor definition.
      String msg = super.formatDone(_mainTask) ;
      _logger.info(msg);
      _output.println(msg) ;
    }
  }

  @Override
  public void internalWorked(double work)
  {
    _logger.warn("############### internal worked is call : " + work) ;
  }

  @Override
  public boolean isCanceled()
  {
    return ! _isNotCanceled ;
  }

  @Override
  public void setCanceled(boolean value)
  {
    if(_isNotCanceled)
    {
      if(value)
      {
        _isNotCanceled = false ;
        String msg = super.formatCanceled(_mainTask) ;
        _logger.info(msg);
        _output.println(msg) ;
      }
    }
    // else do not set.
  }

  @Override
  public void setTaskName(String name)
  {
    _mainTask = name ;
  }

  @Override
  public void subTask(String name)
  {
    if(_isNotCanceled)
    {
      String msg = super.formatSubTask(name) ;
      _logger.info(msg);
      _output.println(msg) ;
    }
  }

  @Override
  public void worked(int work)
  {
    if(_isNotCanceled)
    {
      String msg = super.formatWorked(work, _totalWork) ;
      _logger.info(msg);
      _output.println(msg) ;
    }
  }
}