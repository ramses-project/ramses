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