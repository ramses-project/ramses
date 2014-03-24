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

package fr.tpt.aadl.ramses.analysis.eg.model;

import java.util.ArrayList;
import java.util.Collection ;
import java.util.HashMap ;
import java.util.List;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.ramses.analysis.eg.util.EGNodeUtil ;
import fr.tpt.aadl.ramses.util.properties.AadlUtil ;

public class EGModels {

	private Map<ComponentInstance, EGNode> threadToNode = 
			new HashMap<ComponentInstance,EGNode>();
	
	private static Logger _LOGGER = Logger.getLogger(EGModels.class) ;
	
	public Set<ComponentInstance> getThreads()
	{
	  return threadToNode.keySet();
	}
	
	public void put(ComponentInstance thread, EGNode node)
	{
		threadToNode.put(thread, node);
	}
	
	public EGNode getEG(ComponentInstance thread)
	{
		return threadToNode.get(thread);
	}
	
	public Collection<EGNode> getAllEG()
	{
		return threadToNode.values();
	}
	
	public Set<Entry<ComponentInstance,EGNode>> entries()
	{
	  return threadToNode.entrySet();
	}
	
	public EGModels clone()
	{
	  EGModels clone = new EGModels();
	  for(ComponentInstance c : threadToNode.keySet())
	  {
	    EGNode n = threadToNode.get(c);
	    EGNode n2 = EGNodeUtil.clone(n);
	    clone.put(c, n2);
	  }
	  return clone;
	}
	
	
	public Map<ComponentInstance, List<EGNode>> reduce()
	{
		Map<ComponentInstance, List<EGNode>> res =
				new HashMap<ComponentInstance, List<EGNode>>();
		for(ComponentInstance c : threadToNode.keySet())
		{
			EGNode n = threadToNode.get(c);
			n.merge();

			List<EGNode> l = new ArrayList<EGNode>();
			n.EG2SequenceList(l);
			n.UpdateEndBlock(l);
			for(EGNode iter : l)
			{
				iter.merge();
				iter.getBlockEnd().addNext(new EGNode("thread_end"));
			}
			res.put(c, l);
		}
		return res;
	}
	
	public double getWCETFromPropertyInMs (ComponentInstance thread)
	{
	  return AadlUtil.getInfoMaxDuration(thread, "ms");
	}
	
	public double getWCETFromComputationInMs (ComponentInstance thread)
	{
	  return threadToNode.get(thread).getThreadWCET();
	}
}