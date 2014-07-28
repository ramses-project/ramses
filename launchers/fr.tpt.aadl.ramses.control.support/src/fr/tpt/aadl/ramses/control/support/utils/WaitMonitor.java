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

package fr.tpt.aadl.ramses.control.support.utils;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.OperationCanceledException ;

public class WaitMonitor extends Thread
{
  private Command _action ; 
  
  private Exception _caughtException = null ;
  
  private int _exitCode = Command.UNSET;
  
  private static Logger _LOGGER = Logger.getLogger(WaitMonitor.class) ; 
  
  public WaitMonitor(Command action)
  {
    _action = action ;
  }
  
  @Override
  public void run()
  {
    try
    {
      _exitCode = _action.run();
    }
    catch(OperationCanceledException e)
    {
      // It means that _action.run() detected that user has canceled.
      _exitCode = Command.CANCEL ;
      _LOGGER.trace("the command has been canceled. Return cancel exit code");
    }
    catch(InterruptedException e)
    {
      // It means that _action.run() detected that user has canceled.
      _exitCode = Command.CANCEL ;
      _LOGGER.trace("the command has been interrupted. Return cancel exit code");
    }
    catch(Exception e)
    {
      _LOGGER.fatal("command has failed", e);
      _caughtException = e ;
      _exitCode = Command.FATAL ;
    }
    finally
    {
      synchronized(_action) {_action.notifyAll();}
    }
  }
  
  /**
   * Return a caught exception during the command execution or {@code null} if
   * there was not any exception thrown.
   * 
   * @return a caught exception or {@code null}
   */
  public Exception getCaughtException()
  {
    return _caughtException ;
  }
  
  /**
   * Wait until the command has finished or has been canceled or has crashed 
   * on a fatal error. waitAndCheck will try to stop the command by raising an
   * Interrupted Exception.
   * 
   * @param period time in milliseconds that cancellation is check 
   * @return command exit code
   * @throws InterruptedException on any thread interruption
   */
  public int waitAndCheck(int period) throws InterruptedException
  {
    long currentTime ;
    long beforeWaiting ;
    boolean hasToContinue = true ;
     
    while(hasToContinue)
    {
      beforeWaiting = System.currentTimeMillis() ;
      
      synchronized(_action)
      {
        _action.wait(period) ;
      }
      
      currentTime = System.currentTimeMillis() ;

      // operation has finished before timeout.
      if(beforeWaiting + period > currentTime
          || _action.getStatus()==Command.UNSET)
      {
        hasToContinue = false ;
      }
      else
      {
        // Operation has been canceled.
        if(_action.isCanceled())
        {
          hasToContinue = false ;
          _exitCode = Command.CANCEL ;
          this.interrupt();
        }
        else 
        {
          // Operation is not complete and has not been canceled.
          continue ;
        }
      }
    }
    
    return _exitCode ;
  }
}