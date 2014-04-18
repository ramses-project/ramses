package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.lang.IllegalArgumentException;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessSubcomponent;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Partition;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionMemory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;

public class PartitionMemoryFactory extends ModelFactory<PartitionMemory> {

	@Override
	public PartitionMemory createFromAadl(NamedElement element, TargetProperties tarProp) {
		if(element==null || !(element instanceof ProcessSubcomponent))
			throw new IllegalArgumentException("PartitionMemoryFactory needs a ProcessSubcomponent to create a PartitionMemory");
		SystemProperties props=(SystemProperties)tarProp;
		PartitionMemory pm=new PartitionMemory();
		Partition partition = props.getPartitions().get(props.getProcessToPartition().get(element.getName()));
		pm.setPartitionIdentifier(partition.getPartitionIdentifier());
		pm.setPartitionName(partition.getPartitionName());		
		return pm;
	}
}

