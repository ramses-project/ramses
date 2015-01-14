package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.lang.IllegalArgumentException;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ConnectionTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Module;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ModuleHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ModuleSchedule;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Partition;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;

public class ModuleFactory extends ModelFactory<Module> {

	private ModelFactory<Partition> partitionFactory;
	private ModelFactory<ModuleSchedule> moduleScheduleFactory;
	private ModelFactory<ConnectionTable> connectionTableFactory;

	@Override
	public Module createFromAadl(NamedElement element, TargetProperties tarProp) {
		if(element==null || !(element instanceof ComponentInstance))
			throw new IllegalArgumentException("ModuleFactory needs a ProcessorSubcomponent to create a module");
		ComponentInstance processor=(ComponentInstance)element;
		SystemProperties props=(SystemProperties)tarProp;
		if(partitionFactory==null)
			partitionFactory=props.getFactory(Partition.class);
		if(moduleScheduleFactory==null)
			moduleScheduleFactory=props.getFactory(ModuleSchedule.class);
		if(connectionTableFactory==null)
			connectionTableFactory=props.getFactory(ConnectionTable.class);
		Module module=new Module();
		try {
			module.setModuleName(getPropVal(element, "Module_Id", String.class, false));
			module.setModuleVersion(getPropVal(element, "Module_Version", String.class, false));
			for(ComponentInstance ci : processor.getComponentInstances())
			{
				if(ci.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR))
				{
					Partition p=partitionFactory.createFromAadl(ci,tarProp);
					if(p!=null)
						module.getPartitions().add(p);
				}
			}
			ModuleSchedule moduleSchedule = moduleScheduleFactory.createFromAadl(processor, tarProp);
			module.setModuleSchedule(moduleSchedule);
			ConnectionTable ct = connectionTableFactory.createFromAadl(processor, tarProp);
			module.setConnectionTable(ct);
			
			ModelFactory<SystemHealthMonitoringTable> SystemHMTableFactory = props.getFactory(SystemHealthMonitoringTable.class);
			SystemHealthMonitoringTable shmt = SystemHMTableFactory.createFromAadl(processor, tarProp);
			module.setSystemHmTable(shmt);
			
			ModelFactory<ModuleHealthMonitoringTable> ModuleHMTableFactory = props.getFactory(ModuleHealthMonitoringTable.class);
			ModuleHealthMonitoringTable mhmt = ModuleHMTableFactory.createFromAadl(processor, tarProp);
			module.setModuleHmTable(mhmt);
			
			for(ComponentInstance ci : processor.getComponentInstances())
			{
				if(ci.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR))
				{
					ModelFactory<PartitionHealthMonitoringTable> PartitionHMTableFactory = props.getFactory(PartitionHealthMonitoringTable.class);
					PartitionHealthMonitoringTable phmt = PartitionHMTableFactory.createFromAadl(ci, tarProp);
					module.setPartitionHmTable(phmt);
				}
			}
			return module;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return null;
	}
}
