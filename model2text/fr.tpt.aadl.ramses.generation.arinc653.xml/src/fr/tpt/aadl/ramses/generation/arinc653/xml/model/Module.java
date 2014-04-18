package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("ARINC_653_Module")
public class Module {
	
	@XStreamAlias("ModuleName")
	@XStreamAsAttribute
	private String moduleName;
	
	@XStreamAlias("ModuleVersion")
	@XStreamAsAttribute
	private String moduleVersion;
	
	@XStreamAlias("ModuleId")
	@XStreamAsAttribute
	private String moduleId;
	@XStreamImplicit
	private List<Partition> partitions;
	@XStreamImplicit
	private List<PartitionMemory> partitionMemories;
	
	@XStreamAlias("System_HM_Table")
	@XStreamAsAttribute
	private SystemHealthMonitoringTable systemHmTable;
	
	@XStreamAlias("Module_HM_Table")
	@XStreamAsAttribute
	private ModuleHealthMonitoringTable moduleHmTable;
	
	@XStreamAlias("Partition_HM_Table")
	@XStreamAsAttribute
	private PartitionHealthMonitoringTable partitionHmTable;
	
	@XStreamAlias("Module_Schedule")
	@XStreamAsAttribute
	private ModuleSchedule moduleSchedule;
	
	@XStreamAlias("Connection_Table")
	@XStreamAsAttribute
	private ConnectionTable connectionTable;
	
	public ConnectionTable getConnectionTable() {
		return connectionTable;
	}

	public void setConnectionTable(ConnectionTable connectionTable) {
		this.connectionTable = connectionTable;
	}

	public ModuleSchedule getModuleSchedule() {
		return moduleSchedule;
	}

	public void setModuleSchedule(ModuleSchedule moduleSchedule) {
		this.moduleSchedule = moduleSchedule;
	}

	public Module() {
		super();
		partitions=new ArrayList<Partition>();
		partitionMemories=new ArrayList<PartitionMemory>();
		moduleSchedule = new ModuleSchedule();
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleVersion() {
		return moduleVersion;
	}

	public void setModuleVersion(String moduleVersion) {
		this.moduleVersion = moduleVersion;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public List<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(List<Partition> partitions) {
		this.partitions = partitions;
	}

	@Override
	public String toString() {
		String pts="";
		for(Partition p:partitions)
			pts+="\t-"+p+"\n";
		return "Module [moduleName=" + moduleName + ", moduleVersion="
				+ moduleVersion + ", moduleId=" + moduleId + "]\n\tPartitions:\n"+pts;
	}

	public List<PartitionMemory> getPartitionMemories() {
		return partitionMemories;
	}

	public void setPartitionMemories(List<PartitionMemory> partitionMemories) {
		this.partitionMemories = partitionMemories;
	}
	
	public SystemHealthMonitoringTable getSystemHmTable() {
		return systemHmTable;
	}

	public void setSystemHmTable(SystemHealthMonitoringTable systemHmTable) {
		this.systemHmTable = systemHmTable;
	}

	public ModuleHealthMonitoringTable getModuleHmTable() {
		return moduleHmTable;
	}

	public void setModuleHmTable(ModuleHealthMonitoringTable moduleHmTable) {
		this.moduleHmTable = moduleHmTable;
	}

	public PartitionHealthMonitoringTable getPartitionHmTable() {
		return partitionHmTable;
	}

	public void setPartitionHmTable(
			PartitionHealthMonitoringTable partitionHmTable) {
		this.partitionHmTable = partitionHmTable;
	}
}
