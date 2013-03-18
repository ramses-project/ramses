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

	protected EventDataPortCommunicationDimensioning(FeatureInstance receiverPort) throws DimensioningException
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

	protected long computeBufferSize() throws DimensioningException
	{
		long result = 0;
		long maxDeadline = 0;
		for(ComponentInstance writerTaskInstance: this.writerInstances)
		{
			if(getDeadline(writerTaskInstance) > maxDeadline){
				maxDeadline = getDeadline(writerTaskInstance);
			}
		}
		long readerPeriod = AadlUtil.getInfoTaskPeriod(readerReceivingTaskInstance);
		long writerPeriod = 0;

		for(ComponentInstance writerTaskInstance: this.writerInstances)
		{
			writerPeriod = getDeadline(writerTaskInstance);

			result += ((2 * readerPeriod + maxDeadline) / writerPeriod) + 1;
		}
		return result;
	}


	protected void setCurrentPeriodReadIndex() throws DimensioningException
	{

		long readerTaskPeriod = getPeriod(this.readerReceivingTaskInstance);
		// pour chaque période de l'HP
		for(int iteration= 1; iteration <= CPRSize; iteration++)
		{
			long SEJDprev = 0;
			long readingTime = iteration*readerTaskPeriod;
			
			for(ComponentInstance otherWriter : this.writerInstances)
			{
				long otherPeriod = getPeriod(otherWriter);
				long otherDeadline = getDeadline(otherWriter);
				SEJDprev += ((readingTime - otherDeadline) / otherPeriod) + 1;
			}
			SEJDprev=(SEJDprev-1)%bufferSize;
			CurrentPeriodRead.add(SEJDprev);

		}
	}


	protected void setCurrentDeadlineWriteIndex() throws DimensioningException
	{
		boolean first=true;
		for(FeatureInstance writerFeatureInstance:this.writerFeatureInstances)
		{
			if(!this.writerFeatureInstances.contains(writerFeatureInstance))
				throw new DimensioningException("ERROR: "+writerFeatureInstance.getComponentInstancePath()
						+"\n is not connected to: "+this.readerReceivingTaskInstance.getComponentInstancePath());
			ComponentInstance writerTaskInstance = (ComponentInstance) writerFeatureInstance.eContainer();
			for(int iteration=0;iteration<this.CDWSize.get(writerFeatureInstance);iteration++)
			{
				long CDW = 0, SEJD = 0;
				long writerTaskPeriod = getPeriod(writerTaskInstance);
				long writerTaskDeadline = getDeadline(writerTaskInstance);
				long writingTime = iteration*writerTaskPeriod + writerTaskDeadline;

				int simultaneousWriters = 0;

				boolean found = false;
				
				for(ComponentInstance otherWriter : this.writerInstances)
				{
					long otherPeriod = getPeriod(otherWriter);
					long otherDeadline = getDeadline(otherWriter);

					// formule
					if(otherWriter.equals(writerTaskInstance)){
						found = true;
					}

					SEJD += ((writingTime - otherDeadline) / otherPeriod) + 1;
					if((((writingTime - otherDeadline) % otherPeriod) == 0) 
							&& (found)){
						simultaneousWriters++;
					}
				}
				CDW = SEJD - simultaneousWriters;
				CDW = CDW%bufferSize;
				if(first && (CDW <= 1)){
					this.CurrentDeadlineWriteMap.get(writerFeatureInstance).add((long) 0);
					first = false;
					continue;
				}
				this.CurrentDeadlineWriteMap.get(writerFeatureInstance).add(CDW);
			}
		}
	}

	

	protected static final Map<FeatureInstance, EventDataPortCommunicationDimensioning> _instances =
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
