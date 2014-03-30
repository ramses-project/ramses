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

import java.io.File ;
import java.util.List;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.sched.cheddar.CheddarToolchain ;

public class CheddarBackgroundExecution implements Analyzer

/*
extends
                                       AbstractInstanceOrDeclarativeModelReadOnlyAction
                                       
                                       */
{
/*
  @Override
  protected String getActionName()
  {
    return "Generate Cheddar model and simulate scheduling" ;
  }

  
  @Override
  protected void analyzeDeclarativeModel(IProgressMonitor monitor,
                                         AnalysisErrorReporterManager errManager,
                                         Element declarativeObject)
  {
  }

  @Override
  protected void analyzeInstanceModel(IProgressMonitor monitor,
                                      AnalysisErrorReporterManager errManager,
                                      SystemInstance root,
                                      SystemOperationMode som)
  */
  
  private static Logger _LOGGER = Logger.getLogger(CheddarBackgroundExecution.class) ;
  
  @Override
  public void performAnalysis(SystemInstance systemInstance,
                              File outputDir,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor
                              )
        throws AnalysisException
  {
    CheddarToolchain cheddar = new CheddarToolchain(systemInstance,
                                                    outputDir,
                                                    errManager) ;
    cheddar.createCheddarModel() ;

    try
    {
      cheddar.exportAndSimule() ;

      //TODO implement analysis report.
      if(cheddar.isSchedulable())
      {
        System.out
              .println("[There is no missed deadlines ! System is schedulable.]") ;
      }
      else
      {
        System.err
              .println("[There is missed deadlines ! System is not schedulable.]") ;
        System.err.flush() ;
      }
    }
    catch(Exception e2)
    {
      String msg = "Simulation aborted (no generated file) : bad xml model"; 
      _LOGGER.fatal(msg, e2);
      throw new AnalysisException(msg, e2) ;
    }
    return;
  }

  @Override
  public String getRegistryName()
  {
    String msg = "getRegistryName is not supported";
    _LOGGER.fatal(msg) ;
    throw new UnsupportedOperationException(msg) ;
  }

  @Override
  public String getPluginName()
  {
    String msg = "getPluginName is not supported";
    _LOGGER.fatal(msg) ;
    throw new UnsupportedOperationException(msg) ;
  }

  @Override
  public String getPluginId()
  {
    String msg = "getPluginId is not supported";
    _LOGGER.fatal(msg) ;
    throw new UnsupportedOperationException(msg) ;
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    String msg = "setParameters is not supported";
    _LOGGER.fatal(msg) ;
    throw new UnsupportedOperationException(msg) ;
  }

@Override
public List<String> getTransformationModuleList() {
	// TODO Auto-generated method stub
	return null;
}
}