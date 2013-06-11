package fr.tpt.aadl.sched.aadlinspector.output;

import java.util.HashMap;
import java.util.Map;

public class ResponseTimeResult 
{
	private Map<String, TaskResponseTimeResult> results
		= new HashMap<String,TaskResponseTimeResult>();
	
	private String scheduler = "";
	private boolean preemptive = true;
	private boolean result = false;
	private String explanation = "";
	
	void setResponseTime(String taskName, TaskResponseTimeResult r)
	{
		results.put(taskName, r);
	}
	
	void setScheduler(String scheduler)
	{
		this.scheduler = scheduler;
	}
	
	void setPreemptive(boolean preemptive)
	{
		this.preemptive = preemptive;
	}
	
	void setResult(boolean result)
	{
		this.result = result;
	}
	
	void setExplanation(String explanation)
	{
		this.explanation = explanation;
	}

	public TaskResponseTimeResult getResponseTime(String taskName)
	{
		return results.get(taskName);
	}

	public String getScheduler() {
		return scheduler;
	}

	public boolean isPreemptive() {
		return preemptive;
	}

	public boolean isResult() {
		return result;
	}

	public String getExplanation() {
		return explanation;
	}



	public static class TaskResponseTimeResult
	{
		public final String taskName;
		public final double best;
		public final double worst;
		public final double average;
		
		public TaskResponseTimeResult(String taskName,
				double best, double worst, double average)
		{
			this.taskName = taskName;
			this.best = best;
			this.worst = worst;
			this.average = average;
		}
	}
	
}
