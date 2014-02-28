package fr.tpt.aadl.ramses.analysis.eg.model;

import java.util.Collection ;
import java.util.HashMap ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Set ;

import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.ramses.analysis.eg.util.EGNodeUtil ;
import fr.tpt.aadl.ramses.util.properties.AadlUtil ;

public class EGModels {

	private Map<ComponentInstance, EGNode> threadToNode = 
			new HashMap<ComponentInstance,EGNode>();
	
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
	
	public void reduce()
	{
	  for(ComponentInstance c : threadToNode.keySet())
    {
	    EGNode.debug("Reduction for thread " + c.getName() + "\n");
	    EGNode n = threadToNode.get(c);
	    n.merge();
	    n.merge();
	    n.getBlockEnd().addNext(new EGNode("thread_end"));
    }
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
