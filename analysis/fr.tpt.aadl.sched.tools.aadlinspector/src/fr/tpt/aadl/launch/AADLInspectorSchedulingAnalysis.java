package fr.tpt.aadl.launch;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.ramses.analysis.AnalysisArtifact;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.sched.aadlinspector.AADLInspectorLauncher;
import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult;

public class AADLInspectorSchedulingAnalysis extends AbstractAnalyzer {
	
	private final static String ACTION_NAME = "AADLInspector Scheduling Simulation";
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

	@Override
	protected String getActionName() 
	{
		return ACTION_NAME;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, Element declarativeObject) {}

	@Override
	public void setParameters(Map<String, Object> parameters) 
	{
	  mode = (String) parameters.get("Mode");
	  AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
	  currentResult = f.createAnalysisArtifact();
	  parameters.put("AnalysisResult", currentResult);
	}

	@Override
	protected Resource analyzeInstanceModel(IProgressMonitor monitor,
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
			System.err.println("AADLInspector: " + e.getMessage());
		}
		return null;
	}

}
