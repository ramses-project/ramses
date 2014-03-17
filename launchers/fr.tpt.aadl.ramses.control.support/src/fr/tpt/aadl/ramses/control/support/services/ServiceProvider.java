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

package fr.tpt.aadl.ramses.control.support.services ;

import fr.tpt.aadl.ramses.control.support.reporters.MessageReporter4Cli ;
import fr.tpt.aadl.ramses.control.support.reporters.SysErrReporter4Cli ;
import fr.tpt.aadl.ramses.control.support.reporters.SystemErrReporter ;

public class ServiceProvider
{
  private static ServiceRegistry _sr ;
  
  public static void setDefault(ServiceRegistry sr)
  {
    _sr = sr ;
  }

  public static ServiceRegistry getServiceRegistry()
  {
    return _sr ;
  }
  
  // Set a default system error reporter for the JUnit test which could use
  // util classes that may call the system error reporter.
  public static SystemErrReporter SYS_ERR_REP = new SysErrReporter4Cli(new
                                         MessageReporter4Cli());
}