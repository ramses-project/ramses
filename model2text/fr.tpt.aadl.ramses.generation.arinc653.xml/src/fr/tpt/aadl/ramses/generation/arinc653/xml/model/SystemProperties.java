package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osate.aadl2.Port;
import org.osate.aadl2.instance.FeatureInstance;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.ModelFactory;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SystemProperties implements TargetProperties {

	private Module module;
	private Map<String,Partition> partitions;
	private Map<String,List<QueuingPort>> partitionToQueuingPorts;
	private HashMap<String, String> partitionToProcess;
	private HashMap<String, String> ProcessToPartition;
	private HashMap<String, List<FeatureInstance>> processToPorts;
	private HashMap<String, Port> ports;
	private HashMap<String, PartitionMemory> partitionMemories;
	private HashMap<Class,ModelFactory> factories;

	public SystemProperties() {
		super();
		partitions = new HashMap<String,Partition>();
		processToPorts=new HashMap<>();
		partitionToQueuingPorts=new HashMap<>();
		partitionMemories=new HashMap<>();
		factories=new HashMap();
	}

	public Module getModule() {
		return module;
	}
	public <T> ModelFactory<T> getFactory(Class<T> objectClass) {
		return factories.get(objectClass);
	}

	public void addFactory(Class objectType, ModelFactory factory) {
		this.factories.put(objectType, factory);
	}
	public void setModule(Module module) {
		this.module = module;
	}

	public Map<String, Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(Map<String, Partition> partitions) {
		this.partitions = partitions;
	}

	public HashMap<String, String> getPartitionToProcess() {
		return partitionToProcess;
	}

	public void setPartitionToProcess(HashMap<String, String> partitionToProcess) {
		this.partitionToProcess = partitionToProcess;
	}

	public HashMap<String, List<FeatureInstance>> getProcessToPorts() {
		return processToPorts;
	}

	public void setProcessToPorts(
			HashMap<String, List<FeatureInstance>> processToPorts) {
		this.processToPorts = processToPorts;
	}

	public void setPorts(HashMap<String, Port> ports) {
		this.ports=ports;
	}

	public HashMap<String, Port> getPorts() {
		return ports;
	}

	public Map<String, List<QueuingPort>> getPartitionToQueuingPorts() {
		return partitionToQueuingPorts;
	}

	public void setPartitionToQueuingPorts(
			Map<String, List<QueuingPort>> partitionToQueuingPorts) {
		this.partitionToQueuingPorts = partitionToQueuingPorts;
	}

	public HashMap<String, String> getProcessToPartition() {
		return ProcessToPartition;
	}

	public void setProcessToPartition(HashMap<String, String> processToPartition) {
		ProcessToPartition = processToPartition;
	}

	public HashMap<String, PartitionMemory> getPartitionMemories() {
		return partitionMemories;
	}

	public void setPartitionMemories(
			HashMap<String, PartitionMemory> partitionMemories) {
		this.partitionMemories = partitionMemories;
	}
	
	public void clear()
	{
		module=null;
		partitions.clear();
		partitionToQueuingPorts.clear();
		partitionToProcess.clear();
		ProcessToPartition.clear();
		processToPorts.clear();
		ports.clear();
		partitionMemories.clear();
	}
}
