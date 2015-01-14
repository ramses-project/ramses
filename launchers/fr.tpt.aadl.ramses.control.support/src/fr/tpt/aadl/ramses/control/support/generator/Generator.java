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

package fr.tpt.aadl.ramses.control.support.generator ;

import java.io.File ;
import java.util.List;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;

public interface Generator extends NamedPlugin
{
  //TODO: doc me !
  // runtimePath can be null.
  public void generate(SystemInstance systemInstance,
                       RamsesConfiguration config,
                       File[] includeDirs,
                       AnalysisErrorReporterManager errManager,
                       IProgressMonitor monitor) throws AnalysisException,
                                                        GenerationException,
                                                        TransformationException;

  // TODO: doc me !
  // runtimePath can be null.
  public Map<String, Resource> generateWorkflow(SystemInstance systemInstance,
                               RamsesConfiguration config,
                               WorkflowPilot xmlPilot,
                               File[] includeDirs,
                               AnalysisErrorReporterManager errManager,
                               IProgressMonitor monitor) throws AnalysisException,
                                                                GenerationException,
                                                                TransformationException;

  // runtimePath can be null.
  public boolean runtimePathChecker(File runtimePath) ;
  
  public String getRuntimePathEnvVar() ;
  
  public List<String> getTransformationModuleList();

  public List<String> getValidationModuleList();

  void cleanUp() ;

}