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
 
 package fr.tpt.aadl.sched.cheddar ;

public class CheddarOptions
{

  /** Cheddar simulator command-line. */
  public static final String CHEDDAR_SIMULATOR_PATH = initCheddarPath() +
        "/framework_examples/build_schedule_from_xml";
  public static final String CHEDDAR_TOOL_NAME = initCheddarPath() +
        "/binaries/bin/debug/cheddar_d" ;

  public static final boolean CHEDDAR_EXPORT_CRITICAL_SECTIONS = true ;

  /** Enabled, this option use a unique address space for all tasks,
   * in order to allow buffers between partitions or nodes.
   */
  public static final boolean CHEDDAR_USES_GLOBAL_BUFFERS = false ;

  /** Debug option. */
  public static boolean CHEDDAR_DEBUG = false ;

  private static String initCheddarPath()
  {
    String CHEDDAR_PATH = "CHEDDAR_PATH";
    String path = System.getenv(CHEDDAR_PATH);
    if(path!=null && path.isEmpty())
    {
      path=System.getProperty(CHEDDAR_PATH);
    }
    return path;
  }
  
  private CheddarOptions()
  {
  }
}