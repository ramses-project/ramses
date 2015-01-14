package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NumberValue ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ModuleSchedule ;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionSchedule ;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties ;


public class ModuleScheduleFactory extends ModelFactory<ModuleSchedule> {

	private ModelFactory<PartitionSchedule> partitionScheduleFactory;
	
	private static Logger _LOGGER = Logger.getLogger(ModuleScheduleFactory.class) ;
	
	@Override
	public ModuleSchedule createFromAadl(NamedElement element,
			TargetProperties tarProp) {
		if(element==null || !(element instanceof ComponentInstance))
			throw new IllegalArgumentException("ModuleScheduleFactory needs a ProcessorSubcomponent to create a module schedule");
		ComponentInstance processor=(ComponentInstance)element;
		SystemProperties props=(SystemProperties)tarProp;
		if(partitionScheduleFactory == null)
			partitionScheduleFactory = props.getFactory(PartitionSchedule.class);
		ModuleSchedule result = new ModuleSchedule();
		try {
			NumberValue nv = (NumberValue) PropertyUtils.getPropertyValue("Module_Major_Frame", element);
			double majorFrame = nv.getScaledValue("sec");
			result.setMajorFrameSeconds(majorFrame);
			List<PartitionSchedule> partitionSchedules = new ArrayList<PartitionSchedule>();
			
			
			NamedElement ne = processor.getContainingClassifier();
	    PropertyAssociation moduleSchedulePA = PropertyUtils.
	                               findPropertyAssociation("Module_Schedule", ne);
	    if(moduleSchedulePA == null)
	    {
	      String errMsg =  "cannot fetch Module_Schedule for \'"+
	          processor.getName() + '\'' ;
	      _LOGGER.error(errMsg);
	      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
	    }
	    ModalPropertyValue mpv = moduleSchedulePA.getOwnedValues().get(0);
	    ListValue lv = (ListValue) mpv.getOwnedValue();
	    
	    List<Double> partitionSlots = new ArrayList<Double>();
	    
	    for(PropertyExpression pe : lv.getOwnedListElements())
	    {
	      RecordValue rv = (RecordValue) pe;
	      for(BasicPropertyAssociation bpa: rv.getOwnedFieldValues())
	      {
	        if(bpa.getProperty().getName().equalsIgnoreCase("Duration"))
	        {
	          NumberValue nvSlot = (NumberValue) bpa.getValue();
	          partitionSlots.add(nvSlot.getScaledValue("sec"));
	        }
	      }
	    }

	    List<VirtualProcessorSubcomponent> partitionSlotsAlloc = new ArrayList<VirtualProcessorSubcomponent>();
      
	    for(PropertyExpression pe : lv.getOwnedListElements())
	    {
	      RecordValue rv = (RecordValue) pe;
	      for(BasicPropertyAssociation bpa: rv.getOwnedFieldValues())
	      {
	        if(bpa.getProperty().getName().equalsIgnoreCase("Partition"))
	        {
	          ReferenceValue nvAlloc = (ReferenceValue) bpa.getValue();
	          partitionSlotsAlloc.add((VirtualProcessorSubcomponent)nvAlloc.getContainmentPathElements().get(0).getNamedElement());
	        }
	      }
	    }
			
			for(ComponentInstance ci : processor.getComponentInstances())
			{
				if(false == ci.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR))
					continue;
				
				((PartitionScheduleFactory) partitionScheduleFactory).setMajorFrameSecond(majorFrame);
				List<Double> durationList = new ArrayList<Double>();
				List<Double> offsetList = new ArrayList<Double>();
				int i=0;
				for(VirtualProcessorSubcomponent allocatedVPS: partitionSlotsAlloc)
				{
					if(allocatedVPS.equals(ci))
					{
						durationList.add(partitionSlots.get(i));
						double offset = 0.0;
						int j = i;
						while(j>0)
						{
							j--;
							offset += partitionSlots.get(j);
						}
						offsetList.add(offset);
					}
					i++;
				}
				
				((PartitionScheduleFactory) partitionScheduleFactory).setDurationList(durationList);
				((PartitionScheduleFactory) partitionScheduleFactory).setOffsetList(offsetList);
				PartitionSchedule ps = partitionScheduleFactory.createFromAadl(ci, tarProp);
				partitionSchedules.add(ps);
			}
			result.setPartitionSchedules(partitionSchedules);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
