/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.control.cli ;

import org.eclipse.core.runtime.IProgressMonitor ;

import fr.tpt.aadl.ramses.control.cli.core.RamsesProgressMonitor ;
import fr.tpt.aadl.ramses.control.cli.core.ToolSuiteLauncherCommand ;
import fr.tpt.aadl.ramses.control.support.reporters.Logger ;
import fr.tpt.aadl.ramses.control.support.reporters.SystemMessageReporter ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

/**
 * This class implements a Standalone Java application for
 * the Command Line Interface (CLI) version of RAMSES.
 * It relies on class #{@link fr.tpt.aadl.ramses.control.cli.core.ToolSuiteLauncherCommand}
 * to process CLI options and execute corresponding actions.
 */
public class ToolSuiteLauncher
{

  /**
   * This method is the main entrypoint for the Java standalone 
   * version of RAMSES.
   * @param args arguments from the command line.
   */
  public static void main(String[] args)
  {
    try
    {
      Logger4Cli logger = new Logger4Cli() ;
      logger.setConsoleOutput(true);
      /**** DEBUG ****/
      logger.setLogLevel(Logger.ALL);
      /***************/      
      
      SystemMessageReporter syslogger = new SysMsgReporter4Cli(logger,
                                                               System.out,
                                                               System.err) ;
      ServiceProvider.SYS_MSG_REP = syslogger ;
      
      IProgressMonitor monitor = new RamsesProgressMonitor(logger, System.out) ;
      
      ServiceRegistry registry = new StaticServiceRegistry() ;
      
      ServiceProvider.setDefault(registry) ;
      
      ToolSuiteLauncherCommand.main(args, monitor) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
    }
    System.exit(0) ;
  }
}
