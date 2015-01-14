package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Partition_HM_Table")
public class PartitionHealthMonitoringTable extends AbstractHealthMonitoringTable {

	@XStreamAlias("PartitionIdentifier")
	@XStreamAsAttribute
	private String partitionIdentifier;

	@XStreamAlias("PartitionName")
	@XStreamAsAttribute
	private String partitionName;
	
	@XStreamAlias("PartitionCallBack")
	@XStreamAsAttribute
	private String partitionCallBack;

	
	public String getPartitionIdentifier() {
		return partitionIdentifier;
	}

	public void setPartitionIdentifier(String partitionIdentifier) {
		this.partitionIdentifier = partitionIdentifier;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public String getPartitionCallBack() {
		return partitionCallBack;
	}

	public void setPartitionCallBack(String partitionCallBack) {
		this.partitionCallBack = partitionCallBack;
	}

}
