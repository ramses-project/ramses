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

package fr.tpt.aadl.ramses.analysis.eg;

import java.util.List ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.CalledSubprogram ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.ba.aadlba.BehaviorAnnex ;

import fr.tpt.aadl.ramses.analysis.eg.ba.BA2EG ;
import fr.tpt.aadl.ramses.analysis.eg.context.EGContext ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGModels ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.analysis.eg.seq.CallSequence2EG ;
import fr.tpt.aadl.ramses.analysis.eg.util.BehaviorUtil ;
import fr.tpt.aadl.ramses.analysis.eg.util.DoubleRange ;

public class EGLauncher {

	private final SystemInstance root;
	private EGModels models = new EGModels();
	
	private static EGLauncher instance = null;
	
	private static Logger _LOGGER = Logger.getLogger(EGLauncher.class) ;
	
	public EGLauncher(SystemInstance root)
	{
		this.root = root;
		instance = this;
	}
	
	public static EGLauncher getCurrentInstance()
	{
		return instance;
	}
	
	/**
	 * Launch execution graph analysis for all thread components in the model.
	 */
	public EGModels launch()
	{
		models = new EGModels();
		for(ComponentInstance c : root.getAllComponentInstances())
		{
			if (c.getCategory() == ComponentCategory.THREAD)
			{
				doThreadAnalysis(c);
			}
		}
		return models;
	}
	
	public EGModels lastLaunchResults()
  {
  	return models;
  }

  private void doThreadAnalysis(ComponentInstance thread)
	{
		EGContext.getInstance().setCurrentThread(thread);
		
		EGNode entryNode = entrypoint (thread) ;
    models.put(thread, entryNode);
	}
	
	/**
	 * Find an entrypoint for a given thread instance. The entrypoint is the main 
	 * element which will be used to build the execution graph.
	 * @param entry current entrypoint (default: the thread component)
	 * @param thread the thread component
	 * @return the root of the execution graph 
	 */
	public static EGNode entrypoint (NamedElement entry)
	{
	  /** Try to find a behavior annex in the current entrypoint */
	  BehaviorAnnex ba = null;
    
	  ba = BehaviorUtil.getBehaviorAnnex(entry) ;
    
	  if (ba != null)
    {
	    /** Behavior annex found on the entrypoint */
      return new BA2EG (ba).toEG();
    }
	  else
	  {
	    /** Try to find a call sequence in the entrypoint */
	    List<SubprogramCall> sequence = BehaviorUtil.getCallSequence(entry);
	    if (sequence != null)
	    {
	      /** Call sequence found */
	      if (sequence.size()==1) // entrypoint subprogram
	      {
	        /** Unique call: assumes its an entrypoint subprogram */
	        SubprogramCall call = sequence.get(0);
	        CalledSubprogram called = call.getCalledSubprogram();
	        if (called instanceof SubprogramClassifier)
	        {
	          EGContext.getInstance().pushCurrentSubprogram(call);
	          EGNode e = entrypoint ((SubprogramClassifier) called);
	          EGContext.getInstance().popCurrentSubprogram();
	          return e;
	        }
	        else // subprogram prototype ?
	        {
	          String msg = "unsupported type \'" +
	              called.getClass().getSimpleName() + '\'' ;
	          _LOGGER.fatal(msg) ;
	          throw new UnsupportedOperationException(msg);
	        }
	      }
	      else if (sequence.size() > 1)
	      {
	        /** Multiple calls: the execution graph will be defined from them */
	        return new CallSequence2EG (sequence).toEG();
	      }
	    }
	  }
	  
	  /** No behavior */
	  double bcet = 0;
	  double wcet = 0;
	  DoubleRange range = BehaviorUtil.getComputeExecutionTimeInMs(entry);
    bcet = range.getMin();
    wcet = range.getMax();
	  
	  EGNode nCompute = new EGNode ("No_Behavior_Call_" + entry.getName());
    nCompute.setBCET(bcet);
	  nCompute.setWCET(wcet);
    return nCompute;
	}
}