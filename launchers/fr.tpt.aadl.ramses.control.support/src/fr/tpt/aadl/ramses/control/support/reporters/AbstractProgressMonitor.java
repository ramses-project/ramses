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

import org.eclipse.core.runtime.IProgressMonitor ;

public abstract class AbstractProgressMonitor implements IProgressMonitor
{
  protected String _mainTask ;
  protected int _totalWork = 0;
  
  protected String formatBeginTask(String name,
                                   int totalWork)
  {
    // TODO to be implemented.
    return "Begin task \'" + name + '\'';
  }

  protected String formatDone(String task)
  {
    // TODO to be implemented.
    return "Task " + task + " is done" ;
  }

  protected String formatCanceled(String task)
  {
    return "Task " + task + " is canceled" ;
  }

  protected String formatSubTask(String name)
  {
    // TODO to be implemented.
    return "Begin sub task \'" + name + '\'';
  }

  protected String formatWorked(int work, int totalWork)
  {
    // TODO to be implemented.
    if(totalWork == IProgressMonitor.UNKNOWN)
    {
      return "work " + work ;
    }
    else
    {
      return "work " + work + "out of " + totalWork ;
    }
  }
}