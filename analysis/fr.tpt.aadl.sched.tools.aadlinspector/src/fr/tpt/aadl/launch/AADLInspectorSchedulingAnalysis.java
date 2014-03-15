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

package fr.tpt.aadl.launch;

import java.io.File ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.sched.aadlinspector.AADLInspectorLauncher ;
import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult ;

public class AADLInspectorSchedulingAnalysis extends AbstractAnalyzer {
	
//	private final static String ACTION_NAME = "AADLInspector Scheduling Simulation";
	private final static String ANALYZER_NAME = "AADLInspector-SchedulingAnalysis";
	public final static String PLUGIN_NAME = "AADLInspector-SchedulingAnalysis";
	private final static String PLUGIN_ID = "AADLInspector-SchedulingAnalysis";
	
	
	@Override
	public String getRegistryName() 
	{
		return ANALYZER_NAME;
	}

	@Override
	public String getPluginName() 
	{
		return PLUGIN_NAME;
	}

	@Override
	public String getPluginId() 
	{
		return PLUGIN_ID;
	}

	/*
	@Override
	protected String getActionName() 
	{
		return ACTION_NAME;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, Element declarativeObject) {}
*/
	boolean first = true;
	@Override
	public void setParameters(Map<String, Object> parameters) 
	{
	  if(first)
	  {
		mode = (String) parameters.get("Mode");
		AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
		currentResult = f.createAnalysisArtifact();
		parameters.put("AnalysisResult", currentResult);
		first = false;
	  }
	}

	/*
	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, SystemInstance root,
			SystemOperationMode som) 
	{
		
		try
		{
			AnalysisResult r = AADLInspectorLauncher.launchAnalysis(root, mode);
			r.normalize(currentResult);
		}
		catch (Exception e)
		{
			PLEASE LOG ME !
			System.err.println("AADLInspector: " + e.getMessage());
		}
		return;
	}
	*/
	
	public void performAnalysis(SystemInstance root,
                              File outputDir,
                              AnalysisErrorReporterManager errorReporter,
                              IProgressMonitor monitor
                              )
                              throws AnalysisException
  {
	  AnalysisResult r = AADLInspectorLauncher.launchAnalysis(root, outputDir, mode);
    r.normalize(currentResult);
	  
    return;
  }
}