package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.AbstractHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionHealthMonitoringTable;

public class PartitionHealthMonitoringFactory extends AbstractHealthMonitoringFactory {

	@Override
	public AbstractHealthMonitoringTable createFromAadl(NamedElement element,
			TargetProperties tarProp) {
		AbstractHealthMonitoringTable table=null;
		try
		{
			if(element instanceof ComponentInstance)
			{
				table = new PartitionHealthMonitoringTable();
				configurePartitionTable((ComponentInstance)element, 
						(PartitionHealthMonitoringTable)table);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return table;
	}
	
	
	protected void configurePartitionTable(ComponentInstance element, PartitionHealthMonitoringTable table)
	{
		try {
			// get Partition Identifier
			Integer partitionId = getPropValDefault(element, "Partition_Identifier", Integer.class, false);
			table.setPartitionIdentifier(Integer.toString(partitionId));
			
			String partitionName= getPropVal(element, "Partition_Name", String.class, false);
			if(partitionName==null || partitionName.isEmpty())
				partitionName = element.getName();
			table.setPartitionName(partitionName);
			
			super.configureHMTable(element, table);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// <Partition_HM_Table PartitionIdentifier="1" PartitionName="process_as1" PartitionCallback="error_handler">
		// <System_State_Entry SystemState="3" Description="partition init">
		// <Error_ID_Action ErrorIdentifier="3" Description="partition config error" Action="IDLE"/>
		// <Error_ID_Action ErrorIdentifier="4" Description="partition init error" Action="COLD_START"/>
		// <Error_ID_Action ErrorIdentifier="5" Description="segmentation error" Action="COLD_START"/>
		// <Error_ID_Action ErrorIdentifier="6" Description="time duration exceeded" Action="IGNORE"/>
		// <Error_ID_Action ErrorIdentifier="7" Description="invalid OS call" Action="IGNORE"/>
		// </System_State_Entry>
		
		// <System_State_Entry SystemState="4" Description="partition error handler">
		// <Error_ID_Action ErrorIdentifier="5" Description="segmentation error" Action="IDLE"/>
		// <Error_ID_Action ErrorIdentifier="6" Description="time duration exceeded" Action="IGNORE"/>
		// <Error_ID_Action ErrorIdentifier="7" Description="invalid OS call" Action="IDLE"/>
		// <Error_ID_Action ErrorIdentifier="8" Description="divide by 0" Action="WARM_START"/>
		// <Error_ID_Action ErrorIdentifier="9" Description="overflow" Action="WARM_START"/>
		// </System_State_Entry>
		
		// <System_State_Entry SystemState="5" Description="process execution">
		// <Error_ID_Action ErrorIdentifier="5" Description="segmentation error" Action="IDLE"/>
		// <Error_ID_Action ErrorIdentifier="6" Description="time duration exceeded" Action="WARM_START"/>
		// <Error_ID_Action ErrorIdentifier="7" Description="invalid OS call" Action="IDLE"/>
		// <Error_ID_Action ErrorIdentifier="8" Description="divide by 0" Action="IDLE"/>
		// <Error_ID_Action ErrorIdentifier="9" Description="overflow" Action="IDLE"/>
		// </System_State_Entry>
	}
}
