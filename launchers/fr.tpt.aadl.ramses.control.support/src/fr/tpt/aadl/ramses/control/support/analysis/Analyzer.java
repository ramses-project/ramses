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

package fr.tpt.aadl.ramses.control.support.analysis ;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin;

public interface Analyzer extends NamedPlugin
{
  
  public void performAnalysis(SystemInstance systemInstance,
                              RamsesConfiguration config,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor
                              )
                                                throws AnalysisException ;

  public void setParameters(Map<String, Object> parameters) ;

  public List<String> getTransformationModuleList();

  public void setIterationCounter(int i) ;
}