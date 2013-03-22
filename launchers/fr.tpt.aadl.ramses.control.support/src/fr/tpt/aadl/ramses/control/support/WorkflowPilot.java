package fr.tpt.aadl.ramses.control.support;

import java.util.List;

public interface WorkflowPilot {
	
	public boolean hasNextOperation();
	
	public String getNextOperation();
	
	public String getNextAnalysisName();
	
	public String getNextAnalysisMode();
	
	public List<String> getNextTransformationFileNameList();
	
	public void setAnalysisResult(boolean _analysisResult);
	
	public void goForward();
	
}
