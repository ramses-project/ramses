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

import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.sched.cheddar.CheddarOptions ;
import fr.tpt.aadl.sched.cheddar.CheddarToolchain ;

public class WCETAnalysis extends AbstractAnalyzer
{

  public static final String ACTION_NAME = "Model-Based WCET analysis" ;
  public static final String ANALYZER_NAME = "WCETAnalysis" ;
  public final static String PLUGIN_NAME = "AADL-Toolsuite-Scheduling-Cheddar" ;
  public final static String PLUGIN_ID = "fr.tpt.aadl.sched.tools.cheddar" ;
  
  private static Logger _LOGGER = Logger.getLogger(WCETAnalysis.class) ;

/*
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
  {
    CheddarOptions.CHEDDAR_DEBUG = true ;
    CheddarToolchain cheddar = new CheddarToolchain(root, errManager) ;

    try
    {
      cheddar.createExportAndSimule() ;
      System.out.println("schedulable : " + cheddar.isSchedulable()) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ; LOGG ME !
    }
    return;
  }
*/
/*
  @Override
  protected String getActionName()
  {
    return ACTION_NAME ;
  }
*/
  @Override
  public String getRegistryName()
  {
    return WCETAnalysis.ANALYZER_NAME ;
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
  }

  @Override
  public String getPluginName()
  {
    return WCETAnalysis.PLUGIN_NAME ;
  }

  @Override
  public String getPluginId()
  {
    return WCETAnalysis.PLUGIN_ID ;
  }

  @Override
  public void performAnalysis(SystemInstance root,
                              RamsesConfiguration config,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
                                                        throws AnalysisException
  {
    CheddarOptions.CHEDDAR_DEBUG = true ;
    CheddarToolchain cheddar = new CheddarToolchain(root, config.getOutputDir(), errManager) ;
    cheddar.createExportAndSimule() ;
    try
    {
      _LOGGER.trace("schedulable : " + cheddar.isSchedulable()) ;
    }
    catch(Exception e)
    {
      String msg = "cannot compute schedulabelity for \'" + root.getName() + '\'' ;
      _LOGGER.fatal(msg, e);
      throw new AnalysisException(msg, e) ;
    }
  }

@Override
public List<String> getTransformationModuleList() {
	// TODO Auto-generated method stub
	return null;
}
}