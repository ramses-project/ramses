package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public abstract class AbstractHealthMonitoringTable {

	
	@XStreamImplicit
	private List<SystemStateEntry> systemStateEntry;
	
	public List<SystemStateEntry> getSystemStateEntry() {
		return systemStateEntry;
	}

	public void setSystemStateEntry(List<SystemStateEntry> systemStateEntry) {
		this.systemStateEntry = systemStateEntry;
	}
	
	
}
