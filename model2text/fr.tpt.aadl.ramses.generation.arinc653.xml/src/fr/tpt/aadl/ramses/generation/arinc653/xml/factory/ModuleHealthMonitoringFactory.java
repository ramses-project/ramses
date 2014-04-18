package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.AbstractHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ModuleHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionHealthMonitoringTable;

public class ModuleHealthMonitoringFactory extends AbstractHealthMonitoringFactory {

	@Override
	public AbstractHealthMonitoringTable createFromAadl(NamedElement element,
			TargetProperties tarProp) {
		AbstractHealthMonitoringTable table=null;
		try
		{
			ComponentInstance ci = (ComponentInstance) element;
			if(ci.getCategory().equals(ComponentCategory.PROCESSOR))
			{
				table = new ModuleHealthMonitoringTable();
				configureModuleTable(ci, 
						(ModuleHealthMonitoringTable)table);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return table;
	}
	
	private void configureModuleTable(ComponentInstance element, AbstractHealthMonitoringTable table)
	{
		super.configureHMTable(element, table);
	}
	
}
