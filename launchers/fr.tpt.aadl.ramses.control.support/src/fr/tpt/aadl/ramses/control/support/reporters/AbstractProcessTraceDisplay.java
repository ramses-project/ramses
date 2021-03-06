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

import java.io.BufferedReader ;
import java.io.File ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;
import java.io.PrintStream ;

public abstract class AbstractProcessTraceDisplay
{
  /**
   * This method displays in console messages printed on 
   * standard output by the external process launched.
   * @param p the external process that was launched.
   * Otherwise, it does not.
   */
  public void displayOutputMessage(Process p) throws IOException
  {
    InputStream is = p.getInputStream();
    display(is, false) ;
  }

  /**
   * This method displays on console messages printed on
   * error output by the external process launched.
   * @param p the external process that was launched.
   * Otherwise, it does not.
   */
  public void displayErrorMessage(Process p) throws IOException
  {
    InputStream is = p.getErrorStream();
    display(is, true) ;
  }
  
  /**
   * This method save in a log file messages printed on
   * standard output by the external process launched.
   * @param p the external process that was launched.
   * @param log the log file.
   * @throws IOException if log file does not exist.
   */
  public static void saveOutputMessage(Process p, File log) throws IOException
  {
    PrintStream ps = new PrintStream(log) ;
    InputStream is = p.getInputStream() ;
    displayInStream(is, ps) ;
    ps.close() ;
  }
  
  /**
   * This method save in a log file messages printed on
   * error output by the external process launched.
   * @param p the external process that was launched.
   * @param log the log file.
   * @throws IOException if log file does not exist.
   */
  public static void saveErrorMessage(Process p, File log) throws IOException
  {
    PrintStream ps = new PrintStream(log) ;
    InputStream is = p.getErrorStream();
    displayInStream(is, ps) ;
    ps.close() ;
  }
  
  protected static void displayInStream(InputStream is, PrintStream ps) 
                                                              throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = in.readLine()) != null)
    {
      ps.println(line);
    }
  }
  
  abstract protected void display(InputStream is, boolean isError) throws IOException ;
}