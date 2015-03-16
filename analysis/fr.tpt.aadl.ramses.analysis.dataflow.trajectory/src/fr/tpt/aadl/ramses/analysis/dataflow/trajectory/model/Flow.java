package fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model;

import java.util.ArrayList;
import java.util.List;

public class Flow {
	private Path path;
	private int priority;
	private int deadline;
	private int period;
	private int jitter;
	private List<Flow> higherPriorityFlows;
	private List<Flow> samePriorityFlows;
	private List<Flow> LowerPriorityFlows;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Flow() {
		super();
		higherPriorityFlows = new ArrayList<Flow>();
		samePriorityFlows = new ArrayList<Flow>();
		LowerPriorityFlows = new ArrayList<Flow>();
	}
	
	public Flow(Path path, int priority, int deadline, int periode, int jitter, String id) {
		super();
		this.path = path;
		this.priority = priority;
		this.deadline = deadline;
		this.period = periode;
		this.jitter = jitter;
		this.id = id;
	}
	
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int periode) {
		this.period = periode;
	}
	public int getJitter() {
		return jitter;
	}
	public void setJitter(int jitter) {
		this.jitter = jitter;
	}
	public List<Flow> getHigherPriorityFlows() {
		return higherPriorityFlows;
	}

	public void setHigherPriorityFlows(List<Flow> higherPriorityFlows) {
		this.higherPriorityFlows = higherPriorityFlows;
	}

	public List<Flow> getSamePriorityFlows() {
		return samePriorityFlows;
	}

	public void setSamePriorityFlows(List<Flow> samePriorityFlows) {
		this.samePriorityFlows = samePriorityFlows;
	}

	public List<Flow> getLowerPriorityFlows() {
		return LowerPriorityFlows;
	}
	public void setLowerPriorityFlows(List<Flow> lowerPriorityFlows) {
		LowerPriorityFlows = lowerPriorityFlows;
	}
}
