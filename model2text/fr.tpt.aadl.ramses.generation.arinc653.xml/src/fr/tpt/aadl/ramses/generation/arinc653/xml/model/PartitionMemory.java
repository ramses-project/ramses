package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Partition_Memory")
public class PartitionMemory {
	
	@XStreamAlias("PartitionIdentifier")
	@XStreamAsAttribute
	Integer partitionIdentifier;
	
	@XStreamAlias("PartitionName")
	@XStreamAsAttribute
	String partitionName;

	@XStreamImplicit
	List<MemoryRequirements> memoryRequirements;
	
	public PartitionMemory() {
		super();
		memoryRequirements=new ArrayList<MemoryRequirements>();
	}

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

	public List<MemoryRequirements> getMemoryRequirements() {
		return memoryRequirements;
	}

	public void setMemoryRequirements(List<MemoryRequirements> memoryRequirements) {
		this.memoryRequirements = memoryRequirements;
	}
	
	
}
