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
	
	public Map<String, TaskResponseTimeResult> getResponseTimes()
	{
		return results;
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