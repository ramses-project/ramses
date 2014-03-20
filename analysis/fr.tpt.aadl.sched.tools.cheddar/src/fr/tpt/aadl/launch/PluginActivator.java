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

package fr.tpt.aadl.launch ;

import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.IOException ;

import org.apache.log4j.Logger ;
import org.eclipse.ui.plugin.AbstractUIPlugin ;
import org.osgi.framework.Bundle ;
import org.osgi.framework.BundleContext ;

public class PluginActivator extends AbstractUIPlugin
{

  private static PluginActivator instance = null ;

  private Bundle bundle ;
  private String arinc653_template = "" ;
  private String cheddar_header = "" ;
  private String simulationDirectory = null ;
  
  private static Logger _LOGGER = Logger.getLogger(PluginActivator.class) ;

  public static PluginActivator getInstance()
  {
    if(instance == null)
    {
      instance = new PluginActivator() ;
    }

    return instance ;
  }

  @Override
  public void start(BundleContext context)
  {
    bundle = context.getBundle() ;
    instance = this ;
  }

  public String getARINC653Template()
  {
    if(arinc653_template.isEmpty())
      arinc653_template = loadFileContent("resources/arinc653_template.sc") ;
    return arinc653_template ;
  }

  public String getCheddarHeader()
  {
    if(cheddar_header.isEmpty())
      cheddar_header = loadFileContent("resources/cheddar_header.xml") ;
    return cheddar_header ;
  }

  private String loadFileContent(String path)
  {
    try
    {
      BufferedReader reader =
          new BufferedReader(new FileReader(path));
    String buffer = "", line = "" ;

    while((line = reader.readLine()) != null)
    {
      buffer += line + "\n" ;
    }

    reader.close() ;
    return buffer ;
    }
    catch (IOException e)
    {
      String msg = "cannot load \'" + path + '\'' ;
      _LOGGER.fatal(msg, e) ;
      throw new RuntimeException(msg, e) ;
    }
  }

  @Override
  public void stop(BundleContext context)
        throws Exception
  {
    bundle = null ;
    instance = null ;
  }
}