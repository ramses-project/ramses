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

import java.io.File ;
import java.io.IOException ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;

import javax.xml.parsers.ParserConfigurationException ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.xml.sax.SAXException ;

import fr.tpt.aadl.sched.cheddar.events.SimulationData ;
import fr.tpt.aadl.sched.cheddar.events.TaskActivation ;
import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;

public class CheddarToolchain
{
  private final SystemInstance root ;
  private final AnalysisErrorReporterManager errManager ;

  private AADL2Cheddar exporter ;
  private CheddarSimulator simulator ;
  private SimulationXML2Data importer ;
  private SimulationData simulation ;
  
  private File _outputDir ;

  private final String prefix ;
  
  private static Logger _LOGGER = Logger.getLogger(CheddarToolchain.class) ;

  public CheddarToolchain(String prefix, SystemInstance root,
                          File outputDir,
                          AnalysisErrorReporterManager errManager)
  {
    this._outputDir = outputDir ;
    this.prefix = prefix ;
    this.root = root ;
    this.errManager = errManager ;
  }

  public CheddarToolchain(SystemInstance root,
                          File outputDir,
                          AnalysisErrorReporterManager errManager)
  {
    this("", root, outputDir, errManager) ;
  }

  public void resetSchedulingData()
  {
    exporter = null ;
    simulator = null ;
    importer = null ;
    simulation = null ;
    System.gc() ;
  }

  public CheddarModel createCheddarModel(float scaling)
  {
    if(exporter == null)
    {
      exporter = new AADL2Cheddar(prefix, root, _outputDir, errManager, scaling) ;
    }

    exporter.createCheddarModel() ;
    return exporter.getCheddarModel() ;
  }

  public CheddarModel createCheddarModel()
  {
    return createCheddarModel(1f) ;
  }

  public CheddarModel getCheddarModel()
  {
    return exporter.getCheddarModel() ;
  }

  public void exportAndSimule()
  {
    exportAndSimule(1f) ;
  }

  public void exportAndSimule(boolean withUI)
  {
    exportAndSimule(1f, withUI) ;
  }

  public long exportAndSimule(float scaling)
  {
    return exportAndSimule(scaling, false) ;
  }

  public long exportAndSimule(float scaling,
                              boolean withUI)
  {
    /** Step 1 Export. */
    if(exporter == null)
    {
      createCheddarModel(scaling) ;
    }

    exporter.exportCheddarModel() ;
    /** Step 2 Simulate. */
    simulator = new CheddarSimulator(exporter) ;
    return simulator.execute(withUI) ;
  }

  public long createExportAndSimule()
  {
    return createExportAndSimule(1f) ;
  }

  /**
   * Export AADL model to Cheddar model and simule.
   * @param scaling time scaling (default 1f).
   */
  public long createExportAndSimule(float scaling)
  {
    /** Step 1 Generate Cheddar model and then XML */
    createCheddarModel(scaling) ;
    /** Step 2 Simulate. */
    return exportAndSimule(scaling);
    /*
    simulator = new CheddarSimulator(exporter) ;
    return simulator.execute(false) ;*/
  }

  public SimulationData getSimulationData() throws ParserConfigurationException,
                                                   SAXException, IOException
  {
    if(simulation == null)
    {
      extractSimulation() ;
    }

    return simulation ;
  }

  private void extractSimulation() throws ParserConfigurationException,
                                          SAXException, IOException
  {
    if(exporter == null)
    {
      createExportAndSimule() ;
    }

    /** Step 3 Analyse simulation. */
    importer =
          new SimulationXML2Data(exporter.getCheddarModel(), simulator
                .getSimulationXML()) ;
    importer.execute() ;
    simulation = importer.getSimulation() ;
  }

  public boolean isSchedulable() throws ParserConfigurationException,
                                        SAXException, IOException
  {
    if(simulation == null)
    {
      extractSimulation() ;
    }

    Map<ComponentInstance, List<TaskActivation>> missedDeadlines =
          simulation.getAADLMissedDeadlines() ;
    Iterator<ComponentInstance> itTask = missedDeadlines.keySet().iterator() ;

    if(CheddarOptions.CHEDDAR_DEBUG)
    {
      _LOGGER.debug("\n") ;
    }

    boolean hasMissed = false ;

    while(itTask.hasNext())
    {
      NamedElement task = itTask.next() ;
      List<TaskActivation> missedList = missedDeadlines.get(task) ;

      for(TaskActivation missed : missedList)
      {
        String msg =
              "  \\!/ Task " + task.getName() + " [activation = " +
                    missed.getActivationStart() + " deadline = " +
                    missed.getExpectedDeadline() + " end = " +
                    missed.getExecutionEnd() + "]" ;

        if(CheddarOptions.CHEDDAR_DEBUG)
        {
          _LOGGER.debug(msg) ;
        }

        errManager.error(task, msg) ;
        hasMissed = true ;
      }
    }

    return !hasMissed ;
  }
}