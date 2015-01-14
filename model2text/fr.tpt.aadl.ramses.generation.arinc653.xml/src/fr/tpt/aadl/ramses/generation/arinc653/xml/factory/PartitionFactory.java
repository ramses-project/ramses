package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.ArrayList;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.CriticalityType;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Partition;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.QueuingPort;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SamplingPort;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;

public class PartitionFactory extends ModelFactory<Partition> {

	private ModelFactory<QueuingPort> queuingPortFactory;
	private ModelFactory<SamplingPort> samplingPortFactory;
	
	public PartitionFactory() {
		super();
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public Partition createFromAadl(NamedElement element,TargetProperties tarProp) {
		if(element==null || !(element instanceof ComponentInstance))
			throw new IllegalArgumentException("PartitionFactory needs a VirtualProcessorSubcomponent to create a partition");
		Partition partition =new Partition();
		SystemProperties props=(SystemProperties)tarProp;
		queuingPortFactory=props.getFactory(QueuingPort.class);
		samplingPortFactory=props.getFactory(SamplingPort.class);
		try {
			String entryPoint=getPropVal(element, "EntryPoint", String.class, false);
			if(entryPoint==null)
				entryPoint = "main";
			partition.setCriticality(CriticalityType.valueOf(getPropValDefault(element, "Criticality", String.class, "LEVEL_A")));
			partition.setEntryPoint(entryPoint);
			Integer partitionIdentifier = getPropVal(element, "Partition_Identifier", Integer.class, false);
			if(partitionIdentifier==null)
			{
				ProcessorImplementation pi = (ProcessorImplementation) element.eContainer();
				partitionIdentifier = pi.getOwnedVirtualProcessorSubcomponents().indexOf(element);
			}
			partition.setPartitionIdentifier(partitionIdentifier);
			String partitionName = getPropVal(element, "Partition_Name", String.class, false);
			if(partitionName==null || partitionName.isEmpty())
				partitionName = element.getName();
			partition.setPartitionName(partitionName);
			partition.setSystemPartition(getPropValDefault(element, "System_Partition", boolean.class, false));
			ArrayList<QueuingPort> queuingPorts=new ArrayList<QueuingPort>();
			ArrayList<SamplingPort> samplingPorts=new ArrayList<SamplingPort>();
			String boundProc=props.getPartitionToProcess().get(element.getName());
			for(FeatureInstance fi: props.getProcessToPorts().get(boundProc))
			{
				switch(fi.getCategory())
				{
				case EVENT_DATA_PORT:
					queuingPorts.add(queuingPortFactory.createFromAadl(fi.getFeature(),props));
					break;
				case DATA_PORT:
					samplingPorts.add(samplingPortFactory.createFromAadl(fi.getFeature(),props));
					break;
				}
			}
			partition.setQueuingPorts(queuingPorts);
			partition.setSamplingPorts(samplingPorts);
			props.getPartitions().put(element.getName(),partition);
			return partition;
		} catch (Exception e1) {
			e1.printStackTrace();
		}		
		return partition;
	}

	public ModelFactory<QueuingPort> getQueuingPortFactory() {
		return queuingPortFactory;
	}

	public void setQueuingPortFactory(ModelFactory<QueuingPort> queuingPortFactory) {
		this.queuingPortFactory = queuingPortFactory;
	}

	public ModelFactory<SamplingPort> getSamplingPortFactory() {
		return samplingPortFactory;
	}

	public void setSamplingPortFactory(
			ModelFactory<SamplingPort> samplingPortFactory) {
		this.samplingPortFactory = samplingPortFactory;
	}
}
