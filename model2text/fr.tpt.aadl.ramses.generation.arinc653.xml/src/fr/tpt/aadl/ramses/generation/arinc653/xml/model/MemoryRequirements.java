package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Memory_Requirements")
public class MemoryRequirements {

	@XStreamAlias("RegionName")
	@XStreamAsAttribute
	private String regionName;
	
	@XStreamAlias("Type")
	@XStreamAsAttribute
	private String type;
	
	@XStreamAlias("SizeBytes")
	@XStreamAsAttribute
	private int sizeBytes;
	
	@XStreamAlias("PhysicalAddress")
	@XStreamAsAttribute
	private String physicalAddress;
	
	@XStreamAlias("Access")
	@XStreamAsAttribute
	private String access;
	
	public MemoryRequirements() {
		super();
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSizeBytes() {
		return sizeBytes;
	}

	public void setSizeBytes(int val) {
		this.sizeBytes = val;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
}
