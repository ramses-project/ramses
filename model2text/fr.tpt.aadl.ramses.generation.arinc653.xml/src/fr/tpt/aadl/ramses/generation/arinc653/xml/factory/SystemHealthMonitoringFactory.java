package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.AbstractHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ErrorIdLevel;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemStateEntry;

public class SystemHealthMonitoringFactory extends ModelFactory<AbstractHealthMonitoringTable> {

	@Override
	public AbstractHealthMonitoringTable createFromAadl(NamedElement element,
			TargetProperties tarProp) {
		AbstractHealthMonitoringTable table=null;
		try
		{
			if(element instanceof ProcessorSubcomponent)
			{
				table = new SystemHealthMonitoringTable();
				configureSystemTable((ProcessorSubcomponent)element, 
						(SystemHealthMonitoringTable)table);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return table;
	}
		
	private void configureSystemTable(ProcessorSubcomponent element,
										SystemHealthMonitoringTable table) throws Exception
	{
		List<SystemStateEntry> systemStateEntryList = new ArrayList<SystemStateEntry>();
		table.setSystemStateEntry(systemStateEntryList);

		ComponentClassifier c = (ComponentClassifier)element.getSubcomponentType();
		int idx = 1;

		for(Mode m: c.getOwnedModes())
		{
			SystemStateEntry sse = new SystemStateEntry();
			systemStateEntryList.add(sse);
			
			Integer id = getPropVal(m, "Identifier", Integer.class, false);
			if(id!=null)
				sse.setSystemState(Integer.toString(id));
			else
				sse.setSystemState(Integer.toString(idx));
			idx++;
			
			String desc = getPropVal(m, "Description", String.class, false);
			if(desc!=null)
				sse.setDescription(desc);
			
			
			List<ErrorIdLevel> errorIdList = new ArrayList<ErrorIdLevel>();
			sse.setErrorIdList(errorIdList);
			for(PropertyAssociation pa : c.getOwnedPropertyAssociations())
			{
				if(pa.getProperty().getName().equalsIgnoreCase("HM_Error_ID_Levels"))
				{
					ListValue lv = (ListValue) pa.valueInMode(m);
					for(PropertyExpression pe: lv.getOwnedListElements())
					{
						RecordValue rv = (RecordValue) pe;
						String errorIdentifier=null;
						String errorDescription=null;
						String errorLevel=null;
						String errorCode=null;
						
						for(BasicPropertyAssociation bpa: rv.getOwnedFieldValues())
						{
							if(bpa.getProperty().getName().equalsIgnoreCase("ErrorIdentifier"))
							{
								IntegerLiteral idIntegerLiteral = (IntegerLiteral) bpa.getValue();
								errorIdentifier = Long.toString(idIntegerLiteral.getValue());
							}
							else if(bpa.getProperty().getName().equalsIgnoreCase("Description"))
							{
								StringLiteral descStringLiteral = (StringLiteral) bpa.getValue();
								errorDescription = descStringLiteral.getValue();
							}
							else if(bpa.getProperty().getName().equalsIgnoreCase("ErrorLevel"))
							{
								StringLiteral levStringLiteral = (StringLiteral) bpa.getValue();
								errorLevel = levStringLiteral.getValue();
							}
							else if(bpa.getProperty().getName().equalsIgnoreCase("ErrorCode"))
							{
								StringLiteral codeStringLiteral = (StringLiteral) bpa.getValue();
								errorCode = codeStringLiteral.getValue();
							}
						}
						errorIdList.add(createErrorIdLevel(errorIdentifier, errorDescription, errorLevel, errorCode));
					}
				}
			}
		}
	}
	
	private ErrorIdLevel createErrorIdLevel(String errorIdentifier, String description,
			String errorLevel, String errorCode) {
		ErrorIdLevel newError = new ErrorIdLevel();
		newError.setErrorIdentifier(errorIdentifier);
		if(description!=null)
			newError.setDescription(description);
		newError.setErrorLevel(errorLevel);
		if(errorCode!=null)
			newError.setErrorCode(errorCode);
		return newError;
	}
	
}
