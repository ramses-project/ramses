package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Partition_Schedule")
public class PartitionSchedule {

	@XStreamAlias("PartitionIdentifier")
	@XStreamAsAttribute
	Integer PartitionIdentifier;
	
	@XStreamAlias("PartitionName")
	@XStreamAsAttribute
	String PartitionName;
	
	@XStreamAlias("PeriodSeconds")
	@XStreamAsAttribute
	double PeriodSeconds;
	
	@XStreamAlias("PeriodDurationSeconds")
	@XStreamAsAttribute
	double PeriodDurationSeconds;

	@XStreamImplicit
	List<WindowSchedule> windowSchedule;
	
	public Integer getPartitionIdentifier() {
		return PartitionIdentifier;
	}

	public void setPartitionIdentifier(Integer partitionIdentifier) {
		PartitionIdentifier = partitionIdentifier;
	}

	public String getPartitionName() {
		return PartitionName;
	}

	public void setPartitionName(String partitionName) {
		PartitionName = partitionName;
	}

	public double getPeriodSeconds() {
		return PeriodSeconds;
	}

	public void setPeriodSeconds(double periodSeconds) {
		PeriodSeconds = periodSeconds;
	}

	public double getPeriodDurationSeconds() {
		return PeriodDurationSeconds;
	}

	public void setPeriodDurationSeconds(double periodDurationSeconds) {
		PeriodDurationSeconds = periodDurationSeconds;
	}

	public List<WindowSchedule> getWindowSchedule() {
		return windowSchedule;
	}

	public void setWindowSchedule(List<WindowSchedule> windowSchedule) {
		this.windowSchedule = windowSchedule;
	}
	
}
