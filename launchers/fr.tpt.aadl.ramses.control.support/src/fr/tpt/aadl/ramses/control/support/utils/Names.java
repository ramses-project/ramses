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

package fr.tpt.aadl.ramses.control.support.utils ;

public class Names
{
  public final static String[] FILE_EXTENSIONS = new String[]
  {"aadl2", "aadl"} ;

  public final static String RAMSES_SUPPORT_PLUGIN_ID =
                                          "fr.tpt.aadl.ramses.control.support" ;
  
  public final static String ATL_TRANSFORMATION_PLUGIN_ID =
                                       "fr.tpt.aadl.ramses.transformation.atl" ;

  public final static String ANALYSIS_EXT_ID = "analyzer" ;

  public final static String GENERATOR_EXT_ID = "generator" ;

  public static final String ATT_ID = "id" ;
  public static final String ATT_NAME = "name" ;
  public static final String ATT_ANNEXNAME = "annexName" ;
  public static final String ATT_CLASS = "class" ;
  
  public static final String AADL_RESOURCE_DIRECTORY_NAME="aadl_resources" ;
  public static final String RAMSES_RESOURCES_VAR = "RAMSES_DIR";
  
  public static final String GENERATION_ROOT_OBJECT_CLASS = "org.osate.aadl2.SystemImplementation" ;
  
  public static final String DEFAULT_RAMSES_RESOUCE_DIR = "." ;
  
  public static final String AADL_PREDEFINED_PACKAGE_DIR_NAME = "package" ;
  
  public static final String AADL_PREDEFINED_PROPERTIES_DIR_NAME = "propertyset" ;
  
  public static final String LOG4J_CONSOLE_APPENDER_NAME = "ramses_console_log" ;
  
  public static final String NEW_LINE = System.getProperty("line.separator");
  
  public static final String LOGGING_FILENAME = ".ramses-log" ;

  public static final String VALIDATOR_SUFFIX = "-validator";

  public static final String RAMSES_PROPERTIES = "RAMSES_PROPERTIES" ;
}