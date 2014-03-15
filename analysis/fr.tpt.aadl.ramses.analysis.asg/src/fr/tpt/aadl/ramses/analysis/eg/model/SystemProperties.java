/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.analysis.eg.model;

import org.apache.log4j.Logger ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.analysis.eg.util.BehaviorUtil ;
import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class SystemProperties {

	private int CPU_FREQUENCY_IN_MHz = 200;
	private final int CYCLES_ADD = 1;
	private final int CYCLES_AND = 1;
	private final int CYCLES_OR = 1;
	private final int CYCLES_NOT = 1;
	private final int CYCLES_MUL = 3;
	private final int CYCLES_DIV = 30;
	private final int CYCLES_MOD = 34;
	private final int CYCLES_MUTEX = 40;
	private final int CYCLES_JMP = 3;
	private final int CYCLES_LOAD = 5;
	private final int CYCLES_STORE = 5;
	
	private static Logger _LOGGER = Logger.getLogger(SystemProperties.class) ;
	
	public double getOperationMs(OP_KIND op)
	{
		int cycles = 0;
		switch (op)
		{
			case ADD: cycles = CYCLES_ADD; break;
			case MUL: cycles = CYCLES_MUL; break;
			case DIV: cycles = CYCLES_DIV; break;
			case MOD: cycles = CYCLES_MOD; break;
			case AND: cycles = CYCLES_AND; break;
			case OR : cycles = CYCLES_OR ; break;
			case NOT: cycles = CYCLES_NOT; break;
			case MUTEX: cycles = CYCLES_MUTEX; break;
			case JMP: cycles = CYCLES_JMP; break;
			case LOAD: cycles = CYCLES_LOAD; break;
			case STORE: cycles = CYCLES_STORE; break;
		}
		
		double duration_sec = cycles / (1000*1000*CPU_FREQUENCY_IN_MHz);
		double duration_ms = 1000 * duration_sec;
		
		return duration_ms;
	}
	
	public void setCPUFrequencyInMHz(int frequency)
	{
		CPU_FREQUENCY_IN_MHz = frequency;
	}
	
	public int getWordSizeInOctets(ComponentInstance c)
	{
		//Default: 8 bits
		//TODO: read property Word_Size on Memory component
		return 1; // octets
	}
	
	public IOTime getAssignTimeInMs(ComponentInstance c)
	{
		return getIOTime(c,"Assign_Time");
	}
	public IOTime getReadTimeInMs(ComponentInstance c)
	{
		return getIOTime(c,"Read_Time");
	}
	public IOTime getWriteTimeInMs(ComponentInstance c)
	{
		return getIOTime(c,"Write_Time");
	}
	
	private static IOTime getIOTime(ComponentInstance c, String property)
	{
		switch (c.getCategory())
		{
			case THREAD: return getIOTimeThread(c, property);
			case PROCESS: return getIOTimeProcess(c, property);
			default: try {
				return getIOTimeImpl(c,property);
			} 
			catch (Exception e) 
			{
				String msg = RamsesException.formatRethrowMessage("cannot getIOTime for\'"+
			  c.getName() + '\'', e) ;
				_LOGGER.warn(msg) ;
				ServiceProvider.SYS_ERR_REP.warning(msg, true) ;
				return new IOTime();
			}
		}
	}
	
	private static IOTime getIOTimeThread(ComponentInstance thread, String property)
	{
		return getIOTimeProcess((ComponentInstance) thread.eContainer(), property);
	}
	
	/** Find property on Processor and Memory bound to the Process */
	private static IOTime getIOTimeProcess(ComponentInstance process, String property)
	{
		try
		{
			PropertyExpression pex = PropertyUtils.getPropertyValue(
					"Actual_Processor_Binding", process);
			ListValue lv = (ListValue) pex;
			PropertyExpression pe = lv.getOwnedListElements().get(0);
			if (pe instanceof InstanceReferenceValue)
			{
				InstanceReferenceValue irv = (InstanceReferenceValue) pe;
				ComponentInstance cpu = (ComponentInstance) irv
						.getReferencedInstanceObject();
				while (cpu.getCategory()==ComponentCategory.VIRTUAL_PROCESSOR)
				{
					cpu = (ComponentInstance) cpu.eContainer();
				}
				return getIOTimeImpl(cpu, property);
			}
		}
		catch (Exception e){}
		
		try
		{
		  PropertyExpression pex = PropertyUtils.getPropertyValue(
					"Actual_Memory_Binding", process);
			ListValue lv = (ListValue) pex;
      PropertyExpression pe = lv.getOwnedListElements().get(0);
			
			if (pe instanceof InstanceReferenceValue)
			{
				InstanceReferenceValue irv = (InstanceReferenceValue) pe;
				ComponentInstance mem = (ComponentInstance) irv
						.getReferencedInstanceObject();
				
				IOTime t = getIOTimeImpl(mem, property);
				if (t.isNull() && mem!=null)
				{
					if (mem.eContainer() instanceof ComponentInstance)
					{
						ComponentInstance owner = (ComponentInstance) mem.eContainer();
						if (owner.getCategory()==ComponentCategory.MEMORY)
						{
							mem = owner;
							t = getIOTimeImpl(mem, property);
						}
					}
				}
				return t;
			}
		}
		catch (Exception e)
		{
		  String msg = RamsesException.formatRethrowMessage("cannot get actual memory binding for \'" + process.getName() +
		      '\'', e) ;
		  _LOGGER.warn(msg) ;
		  ServiceProvider.SYS_ERR_REP.warning(msg, true);
		}
		
		return new IOTime();
	}
	
	private static IOTime getIOTimeImpl (ComponentInstance cpuOrMemory, String property) throws Exception
	{
		RecordValue rv = PropertyUtils.getRecordValue(cpuOrMemory, property);
		
		double fixed = 0d;
		double perByte = 0d;
		
		for(BasicPropertyAssociation value : rv.getOwnedFieldValues())
		{
			String propertyName = value.getProperty().getName();
			if (propertyName.equalsIgnoreCase("Fixed"))
			{
				IntegerLiteral v = (IntegerLiteral) value.getOwnedValue();
				fixed = BehaviorUtil.getScaledValue(v,"ms");
			}
			else if (propertyName.equalsIgnoreCase("PerByte"))
			{
			  IntegerLiteral v = (IntegerLiteral) value.getOwnedValue();
				perByte = BehaviorUtil.getScaledValue(v,"ms");
			}
		}
		
		return new IOTime(fixed,perByte);
	}
}