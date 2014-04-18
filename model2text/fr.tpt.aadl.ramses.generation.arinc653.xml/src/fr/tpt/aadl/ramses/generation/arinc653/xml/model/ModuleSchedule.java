package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Module_Schedule")
public class ModuleSchedule {

	@XStreamImplicit
	private List<PartitionSchedule> partitionSchedules;

	@XStreamAlias("MajorFrameSeconds")
	@XStreamAsAttribute
	private double majorFrameSeconds;

	
	public double getMajorFrameSeconds() {
		return majorFrameSeconds;
	}

	public void setMajorFrameSeconds(double majorFrameSeconds) {
		this.majorFrameSeconds = majorFrameSeconds;
	}

	public List<PartitionSchedule> getPartitionSchedules() {
		return partitionSchedules;
	}
	
	public void setPartitionSchedules(List<PartitionSchedule> partitionSchedules) {
		this.partitionSchedules = partitionSchedules;
	}
	
}
