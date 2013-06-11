package fr.tpt.aadl.sched.aadlinspector.output;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnalysisResult 
{
	private Map<String, UtilizationFactorResult> utilizationFactorResults
		= new HashMap<String,UtilizationFactorResult>();
	
	private Map<String, ResponseTimeResult> responseTimeResults
		= new HashMap<String,ResponseTimeResult>();
	
	public boolean isSchedulable()
	{
		Set<String> cpuNames = responseTimeResults.keySet();
		for(String cpuName : cpuNames)
		{
			if (!getResponseTimeResults(cpuName).isResult())
			{
				return false;
			}
		}
		return true;
	}
	
	public UtilizationFactorResult getUtilizationFactor(String cpuName)
	{
		return utilizationFactorResults.get(cpuName);
	}
	
	public ResponseTimeResult getResponseTimeResults(String cpuName)
	{
		return responseTimeResults.get(cpuName);
	}
	
	void setUtilizationFactorResult(String cpuName, UtilizationFactorResult r)
	{
		utilizationFactorResults.put(cpuName, r);
	}
	
	void setResponseTimeResult (String cpuName, ResponseTimeResult r)
	{
		responseTimeResults.put(cpuName, r);
	}
}
