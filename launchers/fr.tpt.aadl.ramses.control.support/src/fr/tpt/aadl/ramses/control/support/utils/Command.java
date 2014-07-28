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

public interface Command
{
  
  public int getStatus();
  
  /**
   * Unknown exit status.
   */
  public static final int UNSET = -1 ;
  
  /**
   *  Command is terminated and was not been canceled.
   */
  public static final int OK = 0 ;
  
  /**
   * Command was not terminated and has been canceled.
   */
  public static final int CANCEL = 1 ;
  
  /**
   * Command is terminated but with an error.
   */
  public static final int ERROR = 2 ;
  
  /**
   * Command failed on a fatal error: get the exception via WaitMonitor.
   */
  public static final int FATAL = 3 ;
  
  /**
   * Implement the Command logic.
   * 
   * @return Command exit status
   * @throws Exception Command can throws any exception
   */
  public int run() throws Exception ;
  
  /**
   * Return if the command has been canceled or not.
   *  
   * @return {@code true} if the command has been canceled, {@code false} otherwise
   */
  public boolean isCanceled() ;
  
  /**
   * Return the command's label.
   * 
   * @return the command's label
   */
  public String getLabel() ;
}