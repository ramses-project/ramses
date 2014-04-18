package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.utils.PropertyUtils;

import fr.tpt.aadl.ramses.generation.arinc653.xml.model.AbstractHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ErrorIdAction;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ErrorIdLevel;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemStateEntry;

public abstract class AbstractHealthMonitoringFactory extends ModelFactory<AbstractHealthMonitoringTable> {

	protected void configureHMTable(ComponentInstance element, AbstractHealthMonitoringTable table)
	{
		try {
			
			List<SystemStateEntry> sseList = new ArrayList<SystemStateEntry>();
			table.setSystemStateEntry(sseList);
			
			populateHMActions(element, sseList);
			populateHMErrors(element, sseList);
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
	
	private void populateHMErrors(ComponentInstance element,
			List<SystemStateEntry> sseList) {
		PropertyAssociation pa = PropertyUtils.findProperty("HM_Error_ID_Levels", element);
		if (pa==null)
			return;
		
		List<ModalPropertyValue> values = pa.getOwnedValues();
		
		for(ModalPropertyValue v : values)
		{
			SystemStateEntry sse = new SystemStateEntry();
			sseList.add(sse);
			
			List<ErrorIdLevel> errorIdList = new ArrayList<ErrorIdLevel>();
			sse.setErrorIdList(errorIdList);
			
			for(Mode m : v.getAllInModes())
			{
				String systemId=null;
				List<PropertyAssociation> modePaList = m.getOwnedPropertyAssociations();
				for(PropertyAssociation modePa : modePaList)
				{
					RecordValue rv = (RecordValue) modePa.getOwnedValues().get(0);
					List<BasicPropertyAssociation> bpaList = rv.getOwnedFieldValues();
					for(BasicPropertyAssociation bpa : bpaList)
					{
						BasicProperty bp = bpa.getProperty();
						if(bp.getName().equalsIgnoreCase("Identifier"))
						{
							IntegerLiteral il = (IntegerLiteral) bpa.getValue();
							sse.setSystemState(Long.toString(il.getValue()));
						}
						else if(bp.getName().equalsIgnoreCase("Description"))
						{
							StringLiteral sl = (StringLiteral) bpa.getValue();
							sse.setDescription(sl.getValue());
						}
					}
				}
			}
			PropertyExpression expr = v.getOwnedValue();
			if (expr instanceof ListValue) {
				ListValue lv = (ListValue) expr;
				ErrorIdLevel level = new ErrorIdLevel();
				errorIdList.add(level);
				for (PropertyExpression pe : lv.getOwnedListElements()) {
					if(pe instanceof RecordValue)
					{
						
						RecordValue rv = (RecordValue) pe;
						List<BasicPropertyAssociation> bpaList = rv.getOwnedFieldValues();
						for(BasicPropertyAssociation bpa : bpaList)
						{
							BasicProperty bp = bpa.getProperty();
							if(bp.getName().equalsIgnoreCase("ErrorIdentifier"))
							{
								IntegerLiteral il = (IntegerLiteral) bpa.getValue();
								level.setErrorIdentifier(Long.toString(il.getValue()));
							}
							else if(bp.getName().equalsIgnoreCase("Description"))
							{
								StringLiteral sl = (StringLiteral) bpa.getValue();
								level.setDescription(sl.getValue());
							}
							else if(bp.getName().equalsIgnoreCase("ErrorLevel"))
							{
								NamedValue sl = (NamedValue) bpa.getValue();
								level.setErrorLevel(((EnumerationLiteral)sl.getNamedValue()).getName());
							} 
						}
						
					}
				}
			}
		}
		
	}

	private void populateHMActions(ComponentInstance element, List<SystemStateEntry> sseList)
	{
		PropertyAssociation pa = PropertyUtils.findProperty("HM_Error_ID_Actions", element);
		if (pa==null)
			return;
		
		List<ModalPropertyValue> values = pa.getOwnedValues();
		
		for(ModalPropertyValue v : values)
		{
			SystemStateEntry sse = new SystemStateEntry();
			sseList.add(sse);
			
			List<ErrorIdAction> errorActionList = new ArrayList<ErrorIdAction>();
			sse.setErrorActionList(errorActionList);
			
			for(Mode m : v.getAllInModes())
			{
				String systemId=null;
				List<PropertyAssociation> modePaList = m.getOwnedPropertyAssociations();
				for(PropertyAssociation modePa : modePaList)
				{
					if(modePa.getProperty().getName().equalsIgnoreCase("State_Information"))
					{
						RecordValue rv = (RecordValue) modePa.getOwnedValues().get(0);
						List<BasicPropertyAssociation> bpaList = rv.getOwnedFieldValues();
						for(BasicPropertyAssociation bpa : bpaList)
						{
							BasicProperty bp = bpa.getProperty();
							if(bp.getName().equalsIgnoreCase("Identifier"))
							{
								IntegerLiteral il = (IntegerLiteral) bpa.getValue();
								sse.setSystemState(Long.toString(il.getValue()));
							}
							else if(bp.getName().equalsIgnoreCase("Description"))
							{
								StringLiteral sl = (StringLiteral) bpa.getValue();
								sse.setDescription(sl.getValue());
							}
						}
					}
				}
				sse.setSystemState(systemId);
			}
			
			PropertyExpression expr = v.getOwnedValue();
			if (expr instanceof ListValue) {
				ListValue lv = (ListValue) expr;
				ErrorIdAction action = new ErrorIdAction();
				errorActionList.add(action);
				for (PropertyExpression pe : lv.getOwnedListElements()) {
					if(pe instanceof RecordValue)
					{
						
						RecordValue rv = (RecordValue) pe;
						List<BasicPropertyAssociation> bpaList = rv.getOwnedFieldValues();
						for(BasicPropertyAssociation bpa : bpaList)
						{
							BasicProperty bp = bpa.getProperty();
							if(bp.getName().equalsIgnoreCase("ErrorIdentifier"))
							{
								IntegerLiteral il = (IntegerLiteral) bpa.getValue();
								action.setErrorIdentifier(Long.toString(il.getValue()));
							}
							else if(bp.getName().equalsIgnoreCase("Description"))
							{
								StringLiteral sl = (StringLiteral) bpa.getValue();
								action.setDescription(sl.getValue());
							}
							else if(bp.getName().equalsIgnoreCase("Action"))
							{
								StringLiteral sl = (StringLiteral) bpa.getValue();
								action.setErrorCode(sl.getValue());
							}
						}
						
					}
				}
			}
		}
	}
}
