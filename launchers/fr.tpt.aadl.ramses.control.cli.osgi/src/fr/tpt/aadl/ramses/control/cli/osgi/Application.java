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

package fr.tpt.aadl.ramses.control.cli.osgi ;

import java.util.Map ;

import org.eclipse.equinox.app.IApplication ;
import org.eclipse.equinox.app.IApplicationContext ;

import fr.tpt.aadl.ramses.control.cli.core.ToolSuiteLauncherCommand ;
import fr.tpt.aadl.ramses.control.support.services.OSGiServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;

/**
 * This class implements an OSGi application for
 * the Command Line Interface (CLI) version of RAMSES.
 * It relies on class #{@link fr.tpt.aadl.ramses.control.cli.core.ToolSuiteLauncherCommand}
 * to process CLI options and execute corresponding actions.
 */
public class Application implements IApplication
{
  /**
   * This method is the main entrypoint for the Java standalone 
   * version of RAMSES.
   * @param context OSGi application context from which RAMSES 
   * argument will be extracted.
   */
  public Object start(IApplicationContext context)
        throws Exception
  {
    ServiceRegistryProvider.setDefault(new OSGiServiceRegistry()) ;
    @SuppressWarnings("unchecked")
    Map<String, String[]> argsMap = context.getArguments() ;
    String[] args = argsMap.get("application.args") ;
    ToolSuiteLauncherCommand.main(args) ;
    return IApplication.EXIT_OK ;
  }

  /* (non-Javadoc)
   * @see org.eclipse.equinox.app.IApplication#stop()
   */
  public void stop()
  {
    // nothing to do
  }
}
