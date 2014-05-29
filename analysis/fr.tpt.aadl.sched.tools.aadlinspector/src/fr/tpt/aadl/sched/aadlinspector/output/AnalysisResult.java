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

import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.launch.AADLInspectorSchedulingAnalysis ;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.AnalysisSource ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.util.properties.AadlUtil ;
import fr.tpt.aadl.sched.aadlinspector.output.ResponseTimeResult.TaskResponseTimeResult ;

public class AnalysisResult 
{
	private Map<String, UtilizationFactorResult> utilizationFactorResults
		= new HashMap<String,UtilizationFactorResult>();
	
	private Map<String, ResponseTimeResult> responseTimeResults
		= new HashMap<String,ResponseTimeResult>();

	private SystemInstance model = null;
	
	void setModel(SystemInstance model) 
	{
		this.model = model;
	}

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
	
	public void normalize(AnalysisArtifact aaResults)
	{
	  QualitativeAnalysisResult schedulable=null;
	  for(Object obj: aaResults.getResults())
	  {
	    fr.tpt.aadl.ramses.analysis.AnalysisResult ar  = 
	        (fr.tpt.aadl.ramses.analysis.AnalysisResult) obj;
	    if(ar instanceof QualitativeAnalysisResult)
	    {
	      QualitativeAnalysisResult qar = (QualitativeAnalysisResult) ar;
	      if(qar.getSource().getMethodName().equals(AADLInspectorSchedulingAnalysis.PLUGIN_NAME))
	      {
	        schedulable = qar;
	        if(!isSchedulable())    
	          schedulable.setValidated(false);
	      }
	    }
	  }
	  AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
	  if(schedulable==null)
	  {
	    schedulable = f.createQualitativeAnalysisResult();
	    AnalysisSource schedulable_s = f.createAnalysisSource();
	    schedulable_s.setMethodName(AADLInspectorSchedulingAnalysis.PLUGIN_NAME);
	    schedulable.setValidated(isSchedulable());
	    schedulable.setSource(schedulable_s);
	    aaResults.getResults().add(schedulable);
	  }
	  
	  
	  for(String cpuName : responseTimeResults.keySet())
    {
      ResponseTimeResult rtrs = getResponseTimeResults(cpuName);
      Map<String,TaskResponseTimeResult> rtr = rtrs.getResponseTimes();
      for(String taskName : rtr.keySet())
      {
        QuantitativeAnalysisResult responseMargin=null;
        
        double deadline = getDeadline(cpuName, taskName);
        double wcrt = rtr.get(taskName).worst;
        double margin = 100*(deadline - wcrt)/deadline;
        
        for(Object obj: aaResults.getResults())
        {
          fr.tpt.aadl.ramses.analysis.AnalysisResult ar  = 
              (fr.tpt.aadl.ramses.analysis.AnalysisResult) obj;
          if(ar instanceof QuantitativeAnalysisResult)
          {
            QuantitativeAnalysisResult qar = (QuantitativeAnalysisResult) ar;
            if(qar.getSource().getMethodName().equals(AADLInspectorSchedulingAnalysis.PLUGIN_NAME)
                && qar.getSource().getScope().equals(taskName))
            {
              responseMargin = qar;
              if(margin<responseMargin.getMargin())
              {
                responseMargin.setMargin((float) margin);
                responseMargin.setValue((float) wcrt);
              }
            }
          }
        }
        if(responseMargin==null)
        {
          AnalysisSource responseMargin_s = f.createAnalysisSource();
          responseMargin_s.setMethodName(AADLInspectorSchedulingAnalysis.PLUGIN_NAME);
          responseMargin_s.setScope(taskName);
          
          responseMargin = f.createQuantitativeAnalysisResult();
          responseMargin.setMargin((float) margin);
          responseMargin.setLimit((float) deadline);
          responseMargin.setValue((float) wcrt);
          responseMargin.setSource(responseMargin_s);
          
          aaResults.getResults().add(responseMargin);
        }
      }
    }
	}
	
	
	private String getAIQualifiedName(ComponentInstance ci)
	{
		String result = ci.getName();
		if(ci instanceof SystemInstance && ci.eContainer()==null)
		{
			result = "root";
		}
		else if(ci.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
			result = getAIQualifiedName((ComponentInstance) ci.eContainer());
		else if(ci.getCategory() == ComponentCategory.PROCESSOR)
		{
			String prefix = getAIQualifiedName((ComponentInstance) ci.eContainer());
			result = prefix+"."+result;
		}
		else if(ci.getCategory() == ComponentCategory.PROCESS)
		{
		  List<ComponentInstance> lci = PropertyUtils.getComponentInstanceList(ci,
          "Actual_Processor_Binding") ;
		  if(lci != null)
		  {
		    ComponentInstance bindedCPU = lci.get(0) ;
	      String prefix = getAIQualifiedName(bindedCPU);
	      result = prefix+"."+result;
		  }
		}
		else if(ci.getCategory() == ComponentCategory.THREAD)
		{
			String prefix = getAIQualifiedName((ComponentInstance) ci.eContainer());
			result = prefix+"."+result;
		}
		return result;
	}
	
	private double getDeadline(String cpuName, String taskName)
	{
		ComponentInstance cpu = null;
		ComponentInstance task = null;
		
		for(ComponentInstance c : model.getComponentInstances())
		{
			String qName = getAIQualifiedName(c);
			if ((c.getCategory()==ComponentCategory.PROCESSOR)
					&& (qName.equals(cpuName)))
			{
				cpu = c;
				break;
			}
		}
		
		for(ComponentInstance c : model.getAllComponentInstances())
		{
			String qName = getAIQualifiedName(c);
			if ((c.getCategory()==ComponentCategory.THREAD)
					&& (qName.equals(taskName)))
			{
				task = c;
				break;
			}
		}
		
		if (task!=null)
		{
			return AadlUtil.getInfoTaskDeadline(task);
		}
		else
		{
			return 0d;
		}
	}
}