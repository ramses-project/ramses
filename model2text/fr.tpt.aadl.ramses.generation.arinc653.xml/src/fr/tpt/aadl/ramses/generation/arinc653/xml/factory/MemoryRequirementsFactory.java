package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.List;

import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.utils.PropertyUtils;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.MemoryRequirements;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils;


public class MemoryRequirementsFactory extends ModelFactory<MemoryRequirements> {

	@Override
	public MemoryRequirements createFromAadl(NamedElement element, TargetProperties tarProp) {
		if(element==null || !(element instanceof ComponentInstance))
			throw new IllegalArgumentException("MemoryRequirementsFactory needs a component instance to create MemoryRequirements");
		ComponentInstance proc=(ComponentInstance)element;

		MemoryRequirements mr=new MemoryRequirements();
		MemorySubcomponent mem = (MemorySubcomponent) GeneratorUtils.getDeloymentMemorySubcomponent(proc);
		try {
			
			try
			{
			  String accessTypes = PropertyUtils.getEnumValue(mem, "Memory_Protocol");
			  boolean isReadAccess=false,isWriteAccess=false,isExecuteAccess=false;
			  
			  // Supported_Access_Type : type enumeration (read, write, execute);
			  if(accessTypes.equalsIgnoreCase("read_only"))
			  {
				  isReadAccess = true;
			  }
			  if(accessTypes.equalsIgnoreCase("write_only"))
			  {
				  isWriteAccess = true;
			  }
			  if(accessTypes.equalsIgnoreCase("read_write"))
			  {
				  isWriteAccess = true;
				  isReadAccess = true;
			  }
			  if(accessTypes.equalsIgnoreCase("execute"))
			  {
				  isExecuteAccess = true;
			  }
			  if(isReadAccess && !isWriteAccess && !isExecuteAccess)
			  {
				  mr.setAccess("READ_ONLY");
			  }
			  if(!isReadAccess && isWriteAccess && !isExecuteAccess)
			  {
				  mr.setAccess("WRITE_ONLY");
			  }
			  if(isReadAccess && isWriteAccess && !isExecuteAccess)
			  {
				  mr.setAccess("READ_WRITE");
			  }
			  if(!isReadAccess && !isWriteAccess && isExecuteAccess)
			  {
				  mr.setAccess("EXECUTE_ONLY");
			  }
			  List<String> memoryTypes = PropertyUtils.getStringListValue(mem, "Memory_Type");
			  if(memoryTypes.size()==1)
			  {
				  //Supported_Memory_Type : type enumeration (Data_Memory, Code_Memory, IO_Memory);
				  switch (memoryTypes.get(0).toLowerCase()) {
				case "data_memory":
					mr.setType("DATA");
					break;
				case "code_memory":
					mr.setType("CODE");
					break;
				case "io_memory":
					mr.setType("INPUT_OUTPUT");
				default:
					break;
				}
			  }
				 
			  
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mr.setPhysicalAddress(getPropVal(mem, "Base_Address", String.class, false));
			// XXX: Warning, need to check default unit.
			mr.setSizeBytes(getPropVal(mem, "Memory_Size", int.class, false));
			mr.setPhysicalAddress(getPropVal(mem, "Region_Name", String.class, false));
			return mr;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return null;
	}
}

