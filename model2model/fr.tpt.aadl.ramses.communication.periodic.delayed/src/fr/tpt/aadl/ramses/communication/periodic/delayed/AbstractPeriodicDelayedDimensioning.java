package fr.tpt.aadl.ramses.communication.periodic.delayed;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.communication.dimensioning.DimensioningException;
import fr.tpt.aadl.ramses.util.math.LeastCommonMultiple;
import fr.tpt.aadl.ramses.util.properties.AadlUtil;
  
public abstract class AbstractPeriodicDelayedDimensioning {

	protected ComponentInstance readerReceivingTaskInstance;
	protected List<ComponentInstance> writerInstances;
	protected List<FeatureInstance> writerFeatureInstances =
			new ArrayList<FeatureInstance>();
	protected long CPRSize;
	protected Map<FeatureInstance, Long> CDWSize = new HashMap<FeatureInstance, Long>();
	protected List<Long> CurrentPeriodRead = new ArrayList<Long>();
	protected Map<FeatureInstance, List<Long>> CurrentDeadlineWriteMap = 
			new HashMap<FeatureInstance, List<Long>>();
	protected long bufferSize;
	protected long hyperperiod;

	public long getBufferSize()
	{
		return bufferSize;
	}

	public long getPreviousPeriodReadIndex(int iteration) throws DimensioningException
	{
		if(iteration > 0)
			return CurrentPeriodRead.get(iteration-1);
		else
			return -1;
	}

	public long getCPRSize()
	{
		return this.CurrentPeriodRead.size();
	}

	public long getCurrentPeriodReadIndex(int iteration) throws DimensioningException
	{
		return this.CurrentPeriodRead.get(iteration);
	}

	public long getCDWSize(FeatureInstance writer) throws DimensioningException
	{
		return this.CDWSize.get(writer);
	}

	public long getCurrentDeadlineWriteIndex(FeatureInstance writer, int iteration) throws DimensioningException
	{
		return this.CurrentDeadlineWriteMap.get(writer).get(iteration);
	}
	
	protected long deliveredAt(long t)throws DimensioningException
	{
		long deliveredAtIteration = 0;
		for(ComponentInstance writerTaskInstance: this.writerInstances)
		{
			long writerTaskPeriod = getPeriod(writerTaskInstance);
			long writerTaskDeadline = getDeadline(writerTaskInstance);
			long Pi=getPeriod(readerReceivingTaskInstance);
			long readingTime = ((t/writerTaskPeriod) * writerTaskPeriod + writerTaskDeadline) ;
			if(readingTime%Pi==0)
				readingTime=readingTime/Pi;
			else
				readingTime= readingTime/Pi +1;
			readingTime*=Pi;
			deliveredAtIteration = deliveredAtIteration+Math.max(0, readingTime/writerTaskPeriod + 1);
		//deliveredAtIteration=Math.max(0, readingTime/writerTaskPeriod + 1);// question prof
		}
		return deliveredAtIteration;

	}
		
	protected long getPeriod(ComponentInstance ci) throws DimensioningException
	{
		long taskPeriod = AadlUtil.getInfoTaskPeriod(ci);
		if(taskPeriod==0)
			throw new DimensioningException("Buffer size can only be computed for a periodic " +
					"task with a specified period; see thread instance: "
					+ ci.getComponentInstancePath());
		return taskPeriod;
	}

	protected long getDeadline(ComponentInstance ci) throws DimensioningException {
		long taskDeadline = AadlUtil.getInfoTaskDeadline(ci);
		taskDeadline  = AadlUtil.getInfoTaskPeriod(ci);
		if(taskDeadline==0)
			throw new DimensioningException("Buffer size can only be computed for a periodic " +
					"producer task with a specified deadline; see thread instance: "
					+ ci.getComponentInstancePath());
		return taskDeadline;
	}
	
	
	protected void setCDWSize(FeatureInstance writer) throws DimensioningException
	{
		long WritersHyperperiod = getHyperperiod(this.writerInstances);
		long MessageNumbers=0;
		for(ComponentInstance w: this.writerInstances)
		{
			long writerPeriod = getPeriod(w);
			MessageNumbers=MessageNumbers+WritersHyperperiod/writerPeriod;
		}
		
		long writerCDWSize = (LeastCommonMultiple.lcm(MessageNumbers, bufferSize)/MessageNumbers)
				*WritersHyperperiod/getPeriod((ComponentInstance) writer.eContainer());
		this.CDWSize.put(writer, writerCDWSize); 
	}
	
	protected void setCPRSize() throws DimensioningException
	{
		List<ComponentInstance> accessingTasks = new ArrayList<ComponentInstance>();
		accessingTasks.addAll(writerInstances);
		accessingTasks.add(this.readerReceivingTaskInstance);
		long AccessingTasksHyperperiod = getHyperperiod(accessingTasks);
		long MessageNumbers=0;
		
		for(ComponentInstance w: this.writerInstances)
		{
			long writerPeriod = getPeriod(w);
			MessageNumbers=MessageNumbers+AccessingTasksHyperperiod/writerPeriod;
		}
		
		this.CPRSize = (LeastCommonMultiple.lcm(MessageNumbers, bufferSize)/MessageNumbers)
				*AccessingTasksHyperperiod/getPeriod(this.readerReceivingTaskInstance);

		this.hyperperiod = AccessingTasksHyperperiod;

	}


	public long getHyperperiod(List<ComponentInstance> consideredTasks) throws DimensioningException
	{
		Long[] periods = new Long[consideredTasks.size()];
		ArrayList<Long> consideredPeriods = new ArrayList<Long>();
		for(ComponentInstance ci : consideredTasks)
		{
			consideredPeriods.add(getPeriod(ci));
		}
		consideredPeriods.toArray(periods);
		return LeastCommonMultiple.lcm(periods);
	}

}
