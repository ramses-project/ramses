package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Partition")
public class Partition {
	
	@XStreamAlias("PartitionIdentifier")
	@XStreamAsAttribute
	private Integer partitionIdentifier;
	
	@XStreamAsAttribute
	@XStreamAlias("PartitionName")
	private String partitionName;
	
	@XStreamAsAttribute
	@XStreamAlias("Criticality")
	private CriticalityType criticality;
	
	@XStreamAsAttribute
	@XStreamAlias("SystemPartition")
	private boolean systemPartition;
	
	@XStreamAsAttribute
	@XStreamAlias("EntryPoint")
	private String entryPoint;
	
	@XStreamImplicit
	private List<QueuingPort> queuingPorts;
	
	@XStreamImplicit
	private List<SamplingPort> samplingPorts;
	
	public Partition() {
		super();
		this.queuingPorts=new ArrayList<>();
	}

	public Partition(Integer partitionIdentifier, String partitionName,
			CriticalityType criticality, boolean systemPartition,
			String entryPoint) {
		super();
		this.partitionIdentifier = partitionIdentifier;
		this.partitionName = partitionName;
		this.criticality = criticality;
		this.systemPartition = systemPartition;
		this.entryPoint = entryPoint;
		this.queuingPorts=new ArrayList<>();
	}

	public int getPartitionIdentifier() {
		return partitionIdentifier;
	}

	public void setPartitionIdentifier(Integer partitionIdentifier) {
		this.partitionIdentifier = partitionIdentifier;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public CriticalityType getCriticality() {
		return criticality;
	}

	public void setCriticality(CriticalityType criticality) {
		this.criticality = criticality;
	}

	public boolean isSystemPartition() {
		return systemPartition;
	}

	public void setSystemPartition(boolean systemPartition) {
		this.systemPartition = systemPartition;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public List<QueuingPort> getQueuingPorts() {
		return queuingPorts;
	}

	public void setQueuingPorts(List<QueuingPort> queuingPorts) {
		this.queuingPorts = queuingPorts;
	}

	
	public List<SamplingPort> getSamplingPorts() {
		return samplingPorts;
	}

	public void setSamplingPorts(List<SamplingPort> samplingPorts) {
		this.samplingPorts = samplingPorts;
	}

	@Override
	public String toString() {
		return "Partition [partitionIdentifier=" + partitionIdentifier
				+ ", partitionName=" + partitionName + ", criticality="
				+ criticality + ", systemPartition=" + systemPartition
				+ ", EntryPoint=" + entryPoint + "]";
	}
	
}
