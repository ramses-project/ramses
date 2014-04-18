package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Window_Schedule")
public class WindowSchedule {

	@XStreamAlias("WindowIdentifier")
	@XStreamAsAttribute
	String windowIdentifier;

	@XStreamAlias("WindowStartSeconds")
	@XStreamAsAttribute
	double windowStartSeconds;
	
	@XStreamAlias("WindowDurationSeconds")
	@XStreamAsAttribute
	double WindowDurationSeconds;
	
	@XStreamAlias("PartitionPeriodStart")
	@XStreamAsAttribute
	boolean partitionPeriodStart = false;

	
	public String getWindowIdentifier() {
		return windowIdentifier;
	}

	public void setWindowIdentifier(String windowIdentifier) {
		this.windowIdentifier = windowIdentifier;
	}

	public double getWindowStartSeconds() {
		return windowStartSeconds;
	}

	public void setWindowStartSeconds(double windowStartSeconds) {
		this.windowStartSeconds = windowStartSeconds;
	}

	public double getWindowDurationSeconds() {
		return WindowDurationSeconds;
	}

	public void setWindowDurationSeconds(double windowDurationSeconds) {
		WindowDurationSeconds = windowDurationSeconds;
	}

	public boolean isPartitionPeriodStart() {
		return partitionPeriodStart;
	}

	public void setPartitionPeriodStart(boolean partitionPeriodStart) {
		this.partitionPeriodStart = partitionPeriodStart;
	}
	
}
