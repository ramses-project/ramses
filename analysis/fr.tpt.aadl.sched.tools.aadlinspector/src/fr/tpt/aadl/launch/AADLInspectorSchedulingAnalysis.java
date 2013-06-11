package fr.tpt.aadl.launch;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.sched.aadlinspector.AADLInspectorLauncher;
import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult;

public class AADLInspectorSchedulingAnalysis extends AbstractAnalyzer {
	
	public final static String ACTION_NAME = "AADLInspector Scheduling Simulation";
	public final static String ANALYZER_NAME = "AADLInspector-Simulation";
	public final static String PLUGIN_NAME = "AADLInspector-Simulation";
	public final static String PLUGIN_ID = "AADLInspector-Simulation";
	
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

	@Override
	protected String getActionName() 
	{
		return ACTION_NAME;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, Element declarativeObject) {}

	@Override
	public void setParameters(Map<String, Object> parameters) {}

	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, SystemInstance root,
			SystemOperationMode som) 
	{
		boolean schedulable = false;
		
		try
		{
			AnalysisResult r = AADLInspectorLauncher.launchAnalysis(root);
			schedulable = r.isSchedulable();
		}
		catch (Exception e)
		{
			System.err.println("AADLInspector: " + e.getMessage());
		}
		System.out.println("Scheduling analysis result: " + schedulable);
	}

}
