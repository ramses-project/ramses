package fr.tpt.aadl.ramses.communication.periodic.delayed;

import org.osate.aadl2.instance.ComponentInstance;


import fr.tpt.aadl.ramses.util.properties.AadlUtil;

public class ComparableThreadByDeadline implements Comparable<ComparableThreadByDeadline> 
{
	private ComponentInstance thread;
	private long deadline;
	
	public ComponentInstance getThread()
	{
		return thread;
	}
	
	public ComparableThreadByDeadline(ComponentInstance thread)
	{
		this.thread=thread;
		this.deadline = AadlUtil.getInfoTaskDeadline(thread);
	}

	@Override
	public int compareTo(ComparableThreadByDeadline toCompare)
	{
		if(deadline<toCompare.deadline)
			return -1;
		else if(deadline==toCompare.deadline)
			return 0; 
		else return 1;
	} 
}