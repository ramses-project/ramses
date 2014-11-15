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

public class UtilizationFactorResult
{
	/** CPU Name */
	public final String cpuName;
	
	/** CPU Utilization factor using period */
	public final double usingPeriod;
	
	/** CPU Utilization factor using deadline */
	public final double usingDeadline;
	
	/** Analysis result */
	public final boolean result;
	
	/** Analysis result explanation */
	public final String explanation;
	
	public UtilizationFactorResult(String cpuName, 
			double usingPeriod, double usingDeadline,
			boolean result, String explanation)
	{
		this.cpuName = cpuName;
		this.usingPeriod = usingPeriod;
		this.usingDeadline = usingDeadline;
		this.result = result;
		this.explanation = explanation;
	}
}