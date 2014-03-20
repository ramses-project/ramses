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

import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;

import javax.xml.parsers.DocumentBuilder ;
import javax.xml.parsers.DocumentBuilderFactory ;
import javax.xml.parsers.ParserConfigurationException ;

import org.apache.log4j.Logger ;
import org.w3c.dom.Document ;
import org.xml.sax.SAXException ;

import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;

public class CheddarSimulator
{

  private String inputXMLPath = "" ;
  private String outputXMLPath = "" ;
  private final CheddarModel inputModel ;

  private boolean executed = false ;

  private long lastSimulationDuration = 0l ;
  
  private static Logger _LOGGER = Logger.getLogger(CheddarSimulator.class) ;

  public CheddarSimulator(
                          CheddarModel cheddarModel, String inputXMLPath)
  {
    this.inputModel = cheddarModel ;
    this.inputXMLPath = inputXMLPath ;
    this.outputXMLPath = inputXMLPath.replace(".xml", "_sim.xml") ;
  }

  public CheddarSimulator(AADL2Cheddar aadl2Cheddar)
  {
    this(aadl2Cheddar.getCheddarModel(), aadl2Cheddar.getCheddarXMLPath().toString()) ;
  }

  /**
   * Execute scheduling simulation.
   * @param withUI
   * @return real scheduling simulation duration in milliseconds.
   */
  public long execute(boolean withUI)
  {
    if(withUI)
    {
      String cmd = CheddarOptions.CHEDDAR_TOOL_NAME + " " + inputXMLPath ;
      //cmd = "/usr/bin/nautilus";
      _LOGGER.trace(cmd) ;
      CheddarUIHandler h = new CheddarUIHandler(cmd) ;
      h.start() ;
      return 0l ;
    }
    else
    {
      return executeWithoutUI() ;
    }
  }

  private long executeWithoutUI()
  {
    int simulationPeriod = inputModel.getSimulationPeriod() ;
    String cmd =
          CheddarOptions.CHEDDAR_SIMULATOR_PATH + " -i " + inputXMLPath +
                " -o " + outputXMLPath + " " + simulationPeriod ;

    if(CheddarOptions.CHEDDAR_DEBUG)
    {
      _LOGGER.debug("------- Scheduling simulation -------") ;
      _LOGGER.debug("Simulation Period : " + simulationPeriod) ;
      _LOGGER.debug("Simulation Execution ..." + cmd) ;
    }

    long simulationStartDate = System.currentTimeMillis() ;
    Process p = null ;
    String line ;

    try
    {
      p = Runtime.getRuntime().exec(cmd) ;
      BufferedReader input =
            new BufferedReader(new InputStreamReader(p.getInputStream())) ;

      while((line = input.readLine()) != null)
      {
        // Do not put this condition out of the while: the input stream must be read even if
        // the configuration don't show the outputs. Otherwise, the process never stop.
        if(CheddarOptions.CHEDDAR_DEBUG)
        {
          System.out.println(line) ;
        }
      }

      p.waitFor() ;
    }
    catch(Exception e) // IOException and InterruptedException
    {
      String msg = "simulation error: could not execute = \'" + cmd  + '\'';
      _LOGGER.fatal(msg, e);
      throw new RuntimeException(msg, e) ;
    }

    executed = true ;
    lastSimulationDuration = System.currentTimeMillis() - simulationStartDate ;
    return lastSimulationDuration ;
  }

  public long getLastSimulationDurationInMillis()
  {
    return lastSimulationDuration ;
  }

  public Document getSimulationXML() throws ParserConfigurationException,
                                            SAXException, IOException
  {
    if(!executed)
    {
      execute(false) ;
    }

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance() ;
    DocumentBuilder builder = factory.newDocumentBuilder() ;
    return builder.parse(outputXMLPath) ;
  }

  private class CheddarUIHandler extends Thread
  {
    private final String cmd ;

    private CheddarUIHandler(String cmd)
    {
      this.cmd = cmd ;
    }

    public void run()
    {
      try
      {
        Process p = Runtime.getRuntime().exec(cmd) ;
        Thread t = new Thread(new CheddarReader(p.getInputStream())) ;
        Thread t2 = new Thread(new CheddarReader(p.getErrorStream())) ;
        t.start() ;
        t2.start() ;
        //p.waitFor();
        //t.join();
        //t2.join();
      }
      catch(IOException e)
      {
        String msg = "simulation error: could not execute = \'" + cmd  + '\'';
        _LOGGER.fatal(msg, e);
        throw new RuntimeException(msg, e) ;
      }
    }
  }

  private class CheddarReader implements Runnable
  {

    private final BufferedReader reader ;

    private CheddarReader(InputStream is)
    {
      this.reader = new BufferedReader(new InputStreamReader(is)) ;
    }

    @Override
    public void run()
    {
      String line ;

      try
      {
        while((line = reader.readLine()) != null)
        {
          // Do not put this condition out of the while: the input stream must be read even if
          // the configuration don't show the outputs. Otherwise, the process never stop.
          if(CheddarOptions.CHEDDAR_DEBUG)
          {
            _LOGGER.debug(line) ;
          }
        }
      }
      catch(IOException e)
      {
        String errMsg =  "cannot read simulation result" ;
        _LOGGER.fatal(errMsg, e) ;
        throw new RuntimeException(errMsg, e) ;
      }
    }

  }
}