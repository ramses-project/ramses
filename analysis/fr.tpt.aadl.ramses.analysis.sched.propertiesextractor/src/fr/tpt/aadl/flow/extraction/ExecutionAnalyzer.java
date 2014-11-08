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

package fr.tpt.aadl.flow.extraction ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public abstract class ExecutionAnalyzer
{
  protected final AnalysisErrorReporterManager errManager ;
  
  private static Logger _LOGGER = Logger.getLogger(ExecutionAnalyzer.class) ;

  public ExecutionAnalyzer(AnalysisErrorReporterManager errManager)
  {
    this.errManager = errManager ;
  }

  public void reportError(Element target,
                          String msg)
  {
    // WHY DON'T USE ERROR REPORTER ?
    
    // TEMPORARY LOG
    msg = ("[Error]" + msg + " for \'" + target.getClass().getSimpleName() +
           '\'') ;
    
    _LOGGER.warn(msg) ;
    ServiceProvider.SYS_ERR_REP.warning(msg, true) ;
    
    /*
    if ((errManager != null) && (target!=null))
    {
      errManager.error(target, msg);
    }*/
  }

  public void reportWarning(Element target,
                            String msg)
  {
    // WHY DON'T USE ERROR REPORTER ?
    
    // TEMPORARY LOG
    msg = ("[Warning]" + msg + " for \'" + target.getClass().getSimpleName() +
        '\'') ;
 
    _LOGGER.warn(msg) ;
   ServiceProvider.SYS_ERR_REP.warning(msg, true) ;
    /*
    if ((errManager != null) && (target!=null))
    {
      errManager.warning(target, msg);
    }*/
  }
}