package fr.tpt.aadl.ramses.analysis.dataflow.trajectory.exceptions;

public class NodeDoesNotHavePredecessor extends Exception {
	/**
   * 
   */
  private static final long serialVersionUID = 1L ;
  public String message;
	
	public NodeDoesNotHavePredecessor(String message) {
		this.message = message;
	}
}
