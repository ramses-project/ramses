package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Standard_Partition")
public class StandardPartition {

	@XStreamAsAttribute
	@XStreamAlias("PartitionIdentifier")
	private Integer partitionIdentifier;
	
	@XStreamAsAttribute
	@XStreamAlias("PartitionName")
	private String partitionName;
	
	@XStreamAsAttribute
	@XStreamAlias("PortName")
	private String portName;
	
	@XStreamAsAttribute
	@XStreamAlias("PhysicalAddress")
	private String physicalAddress;
	
	@XStreamAsAttribute
	@XStreamAlias("Procedure")
	private String procedure;

	public Integer getPartitionIdentifier() {
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

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

}
