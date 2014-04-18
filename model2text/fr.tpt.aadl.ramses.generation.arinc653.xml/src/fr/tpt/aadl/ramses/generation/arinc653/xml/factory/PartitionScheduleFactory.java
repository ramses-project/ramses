package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionSchedule;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.WindowSchedule;

public class PartitionScheduleFactory extends ModelFactory<PartitionSchedule> {

	private double majorFrameSecond;

	private List<Double> offsetList;
	
	private List<Double> durationList;
	
	
	public double getMajorFrameSecond() {
		return majorFrameSecond;
	}

	public void setMajorFrameSecond(double majorFrameSecond) {
		this.majorFrameSecond = majorFrameSecond;
	}

	public List<Double> getOffsetList() {
		return offsetList;
	}

	public void setOffsetList(List<Double> offsetList) {
		this.offsetList = offsetList;
	}

	public List<Double> getDurationList() {
		return durationList;
	}

	public void setDurationList(List<Double> durationList) {
		this.durationList = durationList;
	}

	@Override
	public PartitionSchedule createFromAadl(NamedElement element,
			TargetProperties tarProp) {
		if(element==null || !(element instanceof ComponentInstance))
			throw new IllegalArgumentException("PartitionScheduleFactory needs a ComponentInstance to create a PartitionSchedule");
		PartitionSchedule result = new PartitionSchedule();
		Integer partitionId = getPropValDefault(element, "Partition_Identifier", Integer.class, false);
		result.setPartitionIdentifier(partitionId);
		result.setPartitionName(element.getName());
		try {
			// MAF / number of occurrences in partition windows
			double periodSeconds = majorFrameSecond/durationList.size();
			result.setPeriodSeconds(periodSeconds);
			double periodDurationSeconds = 0.0;
			List<WindowSchedule> windowSchedule = new ArrayList<WindowSchedule>();
			int i = 0;
			for(double d : durationList)
			{
				periodDurationSeconds+=d;
				WindowSchedule ws = new WindowSchedule();
				ws.setWindowDurationSeconds(d);
				ws.setWindowIdentifier(partitionId+Integer.toString(i));
				ws.setWindowStartSeconds(offsetList.get(i));
				windowSchedule.add(ws);
				i++;
			}
			result.setPeriodDurationSeconds(periodDurationSeconds);
			result.setWindowSchedule(windowSchedule);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
