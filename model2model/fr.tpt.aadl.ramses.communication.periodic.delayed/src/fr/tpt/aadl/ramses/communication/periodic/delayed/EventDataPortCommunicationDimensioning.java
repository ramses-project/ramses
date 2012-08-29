package fr.tpt.aadl.ramses.communication.periodic.delayed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.communication.dimensioning.DimensioningException;
import fr.tpt.aadl.ramses.util.properties.AadlUtil;



public class EventDataPortCommunicationDimensioning extends AbstractPeriodicDelayedDimensioning {

	private EventDataPortCommunicationDimensioning(FeatureInstance receiverPort) throws DimensioningException
	{
		boolean isInOrInOutFeature = receiverPort.getDirection().equals(DirectionType.IN)
				|| receiverPort.getDirection().equals(DirectionType.IN_OUT);
		if(!isInOrInOutFeature
				&& !receiverPort.getCategory().equals(FeatureCategory.EVENT_DATA_PORT))
			throw new DimensioningException("Buffer size can only be computed for an " +
					"in or inout even data port");

		readerReceivingTaskInstance = (ComponentInstance) receiverPort.eContainer();

		if(!readerReceivingTaskInstance.getCategory().equals(ComponentCategory.THREAD))
			throw new DimensioningException("Buffer size can only be computed for an " +
					"in or inout even data port of a thread component instance");

		writerInstances = new ArrayList<ComponentInstance>();
		List<ComparableThreadByDeadline> toSortWriters = new ArrayList<ComparableThreadByDeadline>();
		for(ConnectionInstance cnxInst:receiverPort.getDstConnectionInstances())
		{
			FeatureInstance writerPort = (FeatureInstance) cnxInst.getSource();
			ComponentInstance writerTaskInstance = (ComponentInstance) writerPort.eContainer();
			ComparableThreadByDeadline comparableThread = new ComparableThreadByDeadline(writerTaskInstance);
			toSortWriters.add(comparableThread);
			writerFeatureInstances.add(writerPort);

		}
		Collections.sort(toSortWriters);
		for(ComparableThreadByDeadline sortedThread : toSortWriters)
		{
			writerInstances.add(sortedThread.getThread());
		}

		bufferSize = this.computeBufferSize();
		this.setCPRSize();
		this.setCurrentPeriodReadIndex();
		for(FeatureInstance writer: this.writerFeatureInstances)
		{
			this.setCDWSize(writer);
			List<Long> writerIndexes = new ArrayList<Long>();
			this.CurrentDeadlineWriteMap.put(writer, writerIndexes);
		}
		this.setCurrentDeadlineWriteIndex();

	}

	private long computeBufferSize() throws DimensioningException
	{
		long result=0;
		long readerPeriod = AadlUtil.getInfoTaskPeriod(readerReceivingTaskInstance);
		for(ComponentInstance writerTaskInstance: this.writerInstances)
		{
			long writerTaskPeriod = getPeriod(writerTaskInstance);
			// Following code increment the result with
			// the ceil of the division readerPeriod/writerTaskPeriod
			// + 1
			// see computation of the circular arrar size in RTNS 2012
			long d = result+readerPeriod/writerTaskPeriod+1;
			if(Math.IEEEremainder(readerPeriod , writerTaskPeriod)>0)
				result = d+1;
			else
				result = d;
		}
		result = 2*result;
		return result;
	}

	private void setCurrentPeriodReadIndex() throws DimensioningException
	{
		for(int iteration=0; iteration < CPRSize; iteration++)
		{
			long CPR = 0;
			long deliveredAtIteration = 0;
			long readerTaskPeriod = getPeriod(this.readerReceivingTaskInstance);

			deliveredAtIteration = deliveredAt(iteration*readerTaskPeriod);
			CPR = deliveredAtIteration%bufferSize;

			CurrentPeriodRead.add(CPR);
		}
	}

	private void setCurrentDeadlineWriteIndex() throws DimensioningException
	{
		long offset=0;
		boolean first = true;
		for(FeatureInstance writerFeatureInstance:this.writerFeatureInstances)
		{
			if(!this.writerFeatureInstances.contains(writerFeatureInstance))
				throw new DimensioningException("ERROR: "+writerFeatureInstance.getComponentInstancePath()
						+"\n is not connected to: "+this.readerReceivingTaskInstance.getComponentInstancePath());
			ComponentInstance writerTaskInstance = (ComponentInstance) writerFeatureInstance.eContainer();
			for(int iteration=0;iteration<this.CDWSize.get(writerFeatureInstance);iteration++)
			{
				long CDW = 0;
				long writerTaskPeriod = getPeriod(writerTaskInstance);
				long writerTaskDeadline = getDeadline(writerTaskInstance);
				long writingTime = iteration*writerTaskPeriod+writerTaskDeadline;
				// we had hyperperiod to avoid negative values
				writingTime = writingTime+this.hyperperiod;

				int simultaneousWriters = 0;
				for(ComponentInstance otherWriter : this.writerInstances)
				{
					if(otherWriter.equals(writerTaskInstance))
						break;
					long otherPeriod = getPeriod(otherWriter);
					long otherDeadline = getDeadline(otherWriter);

					if(Math.IEEEremainder(writingTime-otherDeadline, otherPeriod)==0)
						simultaneousWriters++;
				}

				CDW = (deliveredAt(writingTime)-simultaneousWriters);
				if(iteration==0 && first)
				{
					offset = CDW - 1;
					first = false;
				}
				CDW = CDW - offset;
				// Since result can be negative, we wrap it up as follows:
				CDW = (CDW%bufferSize+bufferSize)%bufferSize ;
				this.CurrentDeadlineWriteMap.get(writerFeatureInstance).add(CDW);
			}
		}
	}

	private static final Map<FeatureInstance, EventDataPortCommunicationDimensioning> _instances =
			new HashMap<FeatureInstance, EventDataPortCommunicationDimensioning>();
	
	public static EventDataPortCommunicationDimensioning create(FeatureInstance port) 
			throws DimensioningException {
		if(_instances.get(port)!=null)
			return _instances.get(port);
		else
		{
			EventDataPortCommunicationDimensioning instance = new
					EventDataPortCommunicationDimensioning(port);
			_instances.put(port, instance);
			return instance;
		}
	}
}
