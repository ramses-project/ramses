package fr.tpt.aadl.ramses.control.support;

import java.util.List;

/**
 * This interface specifies the methods that must be implemented by a workflow 
 * parser
 */
public interface WorkflowPilot {
	
	/**
	 * This method identifies whether there still exist operations to process
	 * in the workflow.
	 * @return true if there still exist operations to process.
	 */
	public boolean hasNextOperation();
	
	/**
	 * This method identifies the type of the next operations to process
	 * in the workflow.
	 * @return the identifier of an operation ("transformation", "generation",
	 * "analysis", or "unparse").
	 */
	public String getNextOperation();
	
	/**
	 * This method identifies the plugin name of the current action in the 
	 * workflow being processed.
	 * @return the plugin name of the current analysis action
	 */
	public String getAnalysisName();
	
	/**
	 * This method identifies the mode of the current action in the 
	 * workflow being processed.
	 * @return the mode ("automatic" or "manual") of the current analysis action
	 */
	public String getAnalysisMode();
	
	/**
	 * This method retrieves the list of model transformation files for the
	 * current action in the workflow.
	 * @return the list of transformation files as strings.
	 */
	public List<String> getTransformationFileNameList();
	
	/**
   * This method returns the qualitative result of the last
   * analysis processed in the workflow.
   * @return qualitative result of the last analysis
   */
  public boolean getAnalysisResult();
	
	/**
	 * This method stores the qualitative result of the last 
	 * analysis processed in the workflow.
	 * @param analysisResult identifies the qualitative
	 * result of the last analysis.
	 */
	public void setAnalysisResult(boolean analysisResult);
	
	/**
	 * This method sets the current workflow element attribute to the current
	 * action to process in the workflow.
	 */
	public void goForward();
	
	/**
	 * This method retrieves the identifier of the input model for the 
	 * current action in the workflow being processed.
	 * @return the identifier of the input model for the current action
	 * in the workflow being processed.
	 */
	public String getInputModelId();
	
	/**
	 * This method retrieves the identifier of the output model for the 
	 * current action in the workflow being processed.
	 * @return the identifier of the output model for the current action
	 * in the workflow being processed.
	 */
	public String getOutputModelId();
	
	
	/**
   * Returns the current loop executed in the workflow
   */
  public AbstractLoop getLoop();
}
