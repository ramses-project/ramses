package fr.tpt.aadl.ramses.control.workflow.core;

import java.util.ArrayList;
import java.util.List;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer;
import fr.tpt.aadl.ramses.control.workflow.core.WorkflowContext.ModelState;

public class Branch implements BranchAction {
	
	private Analyzer preAnalysis;
	
	private ArrayList<BranchAction> actions = new ArrayList<BranchAction>();
	
	private boolean createState = false;	
	
	public void setPreAnalysis(Analyzer preAnalysis)
	{
		this.preAnalysis = preAnalysis;
	}
	
	public void setCreateState(boolean createState)
	{
		this.createState = createState;
	}
	
	@Override
	public boolean execute(WorkflowContext c) throws AnalysisResultException 
	{
		if (c.callAnalyzer(preAnalysis))
		{
			for(BranchAction a : actions)
			{
				if (!a.execute(c))
					return false;
			}
			
			if (createState)
			{
				ModelState newState = createState(c);
				
				c.addState(newState);
				c.resetModuleList();
			}
			
			return true;
		}
		return false;
	}
	
	private ModelState createState(WorkflowContext c)
	{
		ModelState current = c.getCurrentState();
		List<String> modules = c.getModuleList();
		String filename = getStateName(c);
		
		
		String currentPath = current.getAADLFilePath();
		String superimpositionList = "";
		String cmd;
		
		for(String module : modules)
		{
			superimpositionList = superimpositionList + module + ",";
		}
		superimpositionList = superimpositionList.substring(0,superimpositionList.length()-1);
		
		
		
		cmd = 
				"-m " + currentPath
			+  " -t:" + superimpositionList
			+  " -s"  + current.getInstance().getSystemImplementation().getName()
			+  " -o"  + c.getOutputDirectory()
		;
		//TODO: call ToolSuiteLauncher
		System.out.println(cmd);
		
		//TODO: return output model
		return null;
	}
	
	private String getStateName(WorkflowContext c)
	{
		int index = c.getStatesCount();
		
		String initialFilePath = c.getInitialState().getAADLFilePath();
		String filename = initialFilePath.substring(0,initialFilePath.lastIndexOf("."))
				          + "_" + index + ".aadl2";
				
		return filename;
	}
}
