package fr.tpt.aadl.ramses.communication.periodic.delayed;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger ;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.communication.dimensioning.DimensioningException;

public class DataPortCommunicationDimensioning extends AbstractPeriodicDelayedDimensioning {

  private static Logger _LOGGER = Logger.getLogger(DataPortCommunicationDimensioning.class) ;
  
	public DataPortCommunicationDimensioning(FeatureInstance receiverPort) throws DimensioningException
	{
		boolean isInOrInOutFeature = receiverPort.getDirection().equals(DirectionType.IN)
				|| receiverPort.getDirection().equals(DirectionType.IN_OUT);
		if(!isInOrInOutFeature
				&& !receiverPort.getCategory().equals(FeatureCategory.DATA_PORT))
		{
		  String errMsg = "Data port dimensioning can only be computed for an " +
                      "in or inout data port" ;
	     _LOGGER.fatal(errMsg) ;
	     throw new DimensioningException(errMsg);
		}
		
		readerReceivingTaskInstance = (ComponentInstance) receiverPort.eContainer();
		
		if(!readerReceivingTaskInstance.getCategory().equals(ComponentCategory.THREAD))
		{
      String errMsg = "Data port dimensioning can only be computed for an " +
                      "in or inout even data port of a thread component instance" ;
       _LOGGER.fatal(errMsg) ;
       throw new DimensioningException(errMsg);
    }
		
		for(ConnectionInstance cnxInst:receiverPort.getDstConnectionInstances())
		{
			FeatureInstance writerPort = (FeatureInstance) cnxInst.getSource();
			ComponentInstance writerTaskInstance = (ComponentInstance) writerPort.eContainer();
			writerInstances.add(writerTaskInstance);
			writerFeatureInstances.add(writerPort);
		}
		bufferSize = 2;
		this.setCPRSize();
		this.setCurrentPeriodReadIndex();
		for(FeatureInstance writer:this.writerFeatureInstances)
		{
			this.setCDWSize(writer);
			List<Long> writerIndexes = new ArrayList<Long>();
			this.CurrentDeadlineWriteMap.put(writer, writerIndexes);
			this.setCurrentDeadlineWriteIndex(writer);
		}
		
	}

	private void setCurrentDeadlineWriteIndex(FeatureInstance writerFeatureInstance) throws DimensioningException 
	{
		if(!this.writerInstances.contains(writerFeatureInstance))
		{
      String errMsg = writerFeatureInstance.getComponentInstancePath() +
                      "\n is not connected to: " +
                      this.readerReceivingTaskInstance.getComponentInstancePath() ;
       _LOGGER.fatal(errMsg) ;
       throw new DimensioningException(errMsg);
    }
		  
		for(int iteration=0;iteration<this.CDWSize.get(writerFeatureInstance);iteration++)
		{
			long CDW = 0;
			long writingTime = iteration*getPeriod((ComponentInstance)writerFeatureInstance.eContainer())+getDeadline((ComponentInstance)writerFeatureInstance.eContainer());
			long readerPeriod = getPeriod(readerReceivingTaskInstance);
			long readIteration = writingTime/readerPeriod;
			long currentReadIndexValue = getCurrentPeriodReadIndex(Integer.parseInt(String.valueOf(readIteration)));
			CDW = inverseOf(currentReadIndexValue);
			this.CurrentDeadlineWriteMap.get(writerFeatureInstance).add(Long.parseLong(String.valueOf(CDW)));
		}
	}

	private void setCurrentPeriodReadIndex() throws DimensioningException 
	{
		this.CurrentPeriodRead.add(Long.parseLong("0"));
		for(int iteration=1;iteration<this.CPRSize;iteration++)
		{
			long messagesAtCurrentIteration=deliveredAt(iteration*getPeriod(readerReceivingTaskInstance));
			long messagesAtPreviousIteration=deliveredAt((iteration-1)*getPeriod(readerReceivingTaskInstance));
			if(messagesAtCurrentIteration==messagesAtPreviousIteration)
				this.CurrentPeriodRead.add(this.CurrentPeriodRead.get(iteration-1));
			else
			{
				long readIndexValue = inverseOf(this.CurrentPeriodRead.get(iteration-1));
				this.CurrentPeriodRead.add(readIndexValue);
			}
		}
	}
	
	private long inverseOf(long readIndexValue) throws DimensioningException
	{
		if(readIndexValue==1)
		{
		  return 0;
		}
		else if(readIndexValue==0)
		{
		  return 1;
		}
		
		String errMsg = "data port buffer contains only two slots" ;
		_LOGGER.fatal(errMsg) ;
		throw new DimensioningException(errMsg);
	}
}