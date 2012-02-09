package fr.tpt.aadl.ramses.control.workflow.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;

public class WorkflowContext {

	private static IProgressMonitor monitor = new NullProgressMonitor();
	
	/** Contains PIM, all PPSM and the final PSM. */
	private ArrayList<ModelState> stateHistory = new ArrayList<ModelState>();
	
	/** Loaded modules for the current transformation step. */
	private ArrayList<String> loadedModules = new ArrayList<String>();
	
	/** Directory of generated models. */
	private final String outputDirectory;
	
	public WorkflowContext(String outputDirectory)
	{
		this.outputDirectory = outputDirectory;
	}
	
	public String getOutputDirectory()
	{
		return outputDirectory;
	}
	
	void addState(ModelState s)
	{
		stateHistory.add(s);
	}
	
	public ModelState getInitialState()
	{
		return stateHistory.get(0);
	}
	
	public int getStatesCount()
	{
		return stateHistory.size();
	}
	
	public ModelState getCurrentState()
	{
		return stateHistory.get(stateHistory.size()-1);
	}
	
	public void addModule(String module)
	{
		loadedModules.add(module);
	}
	
	List<String> getModuleList()
	{
		return loadedModules;
	}
	
	void resetModuleList()
	{
		loadedModules.clear();
	}
	
	void resetAll()
	{
		stateHistory.clear();
		resetModuleList();
	}
	
	
	public boolean callAnalyzer(Analyzer a) throws AnalysisResultException
	{
		if (a != null)
		{
			return a.performAnalysis(
					getCurrentState().getInstance(), 
					ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER, 
					monitor
			);
		}
		return true;
	}
	
	
	
	public static class ModelState
	{
		private final SystemInstance instance;
		private final String aadlFilePath;
		
		public ModelState(SystemInstance instance, String aadlFilePath)
		{
			this.instance = instance;
			this.aadlFilePath = aadlFilePath;
		}
		
		public SystemInstance getInstance()
		{
			return instance;
		}
		
		public String getAADLFilePath()
		{
			return aadlFilePath;
		}
	}
}
