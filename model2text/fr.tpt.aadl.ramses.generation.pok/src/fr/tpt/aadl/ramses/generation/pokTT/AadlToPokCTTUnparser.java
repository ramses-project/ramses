/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.generation.pokTT;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.UnparseText;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC;
import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser;
import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUtils;
import fr.tpt.aadl.ramses.util.generation.RoutingProperties;
import fr.tpt.aadl.ramses.util.properties.PropertyUtils;

public class AadlToPokCTTUnparser extends AadlToPokCUnparser
{
	protected void genRoutingImpl(ComponentInstance processor,
			UnparseText routingImplCode, RoutingProperties routeProp)
			throws GenerationException
	{
		super.genRoutingImpl(processor, routingImplCode, routeProp);

		routingImplCode.addOutputNewline("");
		routingImplCode.addOutputNewline("/* Time-Triggered communications */");

		String intraPortsList = "";
		String intraPortsNbList = "";

		List<ComponentInstance> bindedProcesses = getAllBindedProcesses(processor);
		for (ComponentInstance deployedProcess : bindedProcesses)
		{
			int nbPorts = routeProp.portPerProcess.get(deployedProcess).size();

			intraPortsNbList = intraPortsNbList + nbPorts + ",";

			/*
			 * ProcessImplementation p = null; FlowImplementation flow = new
			 * FlowImplementation(); p.getOwnedFlowImplementations().add(flow);
			 */

			for (ComponentInstance c : deployedProcess
					.getAllComponentInstances())
			{
				if (c.getCategory() == ComponentCategory.THREAD)
				{
					String internalList = "";
					
					String arrayPorts = deployedProcess.getSubcomponent()
							.getName()
							+ "_"
							+ c.getSubcomponent().getName()
							+ "_intraports";
					
					String arrayInternalPorts = deployedProcess.getSubcomponent()
							.getName()
							+ "_"
							+ c.getSubcomponent().getName()
							+ "_intraports_internal";
					
					routingImplCode.addOutput("uint8_t " + arrayPorts + "["
							+ nbPorts + "] = {");

					intraPortsList = intraPortsList + arrayPorts + ",";

					for (FeatureInstance f : c.getFeatureInstances())
					{
						if (f.getCategory() != FeatureCategory.DATA_ACCESS)
						{
							routingImplCode.addOutput(AadlToPokCUtils
									.getFeatureLocalIdentifier(f));
							routingImplCode.addOutput(",");
							
							if (f.getDirection() == DirectionType.IN)
							{
								String internalName = AadlToPokCUtils
										.getFeatureLocalIdentifier(f) + "_internal";
								internalList = internalList + internalName + ",";
							}
						}
					}
					routingImplCode.addOutputNewline("};");
					
					if (internalList.length()>0)
					{
						routingImplCode.addOutput("uint8_t " + arrayInternalPorts + "["
								+ nbPorts + "] = {");
						routingImplCode.addOutput(internalList);
						routingImplCode.addOutputNewline("};");
					}
					
				}
			}
		}
		routingImplCode
				.addOutputNewline("uint8_t* pok_intraports_by_thread[POK_CONFIG_NB_THREADS] = {"
						+ intraPortsList + "};");
		routingImplCode
				.addOutputNewline("uint8_t pok_nb_intraports_by_thread[POK_CONFIG_NB_THREADS] = {"
						+ intraPortsNbList + "};");
	}

	private List<ComponentInstance> getAllBindedProcesses(
			ComponentInstance processor)
	{
		ArrayList<ComponentInstance> processList = new ArrayList<ComponentInstance>();
		SystemInstance s = processor.getSystemInstance();

		for (ComponentInstance c : s.getComponentInstances())
		{
			if (c.getCategory() == ComponentCategory.PROCESS)
			{
				if ((ComponentInstance) getProcessBind(c).getOwner() == processor)
				{
					processList.add(c);
				}
			}
		}

		return processList;
	}

	private ComponentInstance getProcessBind(ComponentInstance process)
	{
		try
		{
			PropertyExpression val = PropertyUtils.getPropertyValue(
					"Actual_Processor_Binding", process);
			PropertyExpression e = ((ListValue) val).getOwnedListElements()
					.get(0);
			InstanceReferenceValue ref = (InstanceReferenceValue) e;
			InstanceObject owner = ref.getReferencedInstanceObject();
			return (ComponentInstance) owner;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	protected void genDeploymentHeaderEnd(UnparseText mainHeaderCode)
	{
		mainHeaderCode.addOutputNewline("#define POK_NEEDS_TIME_TRIGGERED 1") ;
	}
	
	private String getFeatureIdentifier(FeatureInstance fi)
	{
		return GenerationUtilsC.getGenerationCIdentifier(fi.getComponentInstancePath()+"_"+fi.getName());
	}
}

/*
 * TODO
 * 
 * ***** ALL EXAMPLE :
 * 
 * KERNEL
 * 
 * deployment.h
 * 
 * #define POK_CONFIG_NB_NODES 1
 * 
 * 
 * ***** BUFFER EXAMPLE:
 * 
 * KERNEL
 * 
 * #define POK_CONFIG_NB_LOCKOBJECTS 1 (also for blackboard and event and
 * buffer) DONE
 * deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 0");
 * 
 * 
 * PART
 * 
 * main.h
 * 
 * #define POK_CONFIG_NB_BUFFERS 1 #define POK_NEEDS_BUFFERS 1 #define
 * POK_NEEDS_ARINC653_BUFFER 1
 * 
 * #include <arinc653/buffer.h>
 * 
 * deployment.c
 * 
 * uint8_t input_id; char* pok_buffers_names[POK_CONFIG_NB_BUFFERS] = {"input"};
 * 
 * activity.c
 * 
 * test__myint input_dvalue; ????????????? extern BUFFER_ID_TYPE input_id;
 * 
 * main.c
 * 
 * extern BUFFER_ID_TYPE input_id; CREATE_BUFFER ("input", sizeof
 * (BUFFER_ID_TYPE), 1, FIFO, &(input_id), &(ret));
 * 
 * ***** EVENT EXAMPLE :
 * 
 * PART
 * 
 * main.h
 * 
 * #define POK_CONFIG_NB_EVENTS 1 #define POK_NEEDS_EVENTS 1 #define
 * POK_CONFIG_ARINC653_NB_EVENTS 1 #define POK_NEEDS_ARINC653_EVENT 1
 * 
 * #include <arinc653/event.h>
 * 
 * deployment.c
 * 
 * EVENT_ID_TYPE input_id; char*
 * pok_arinc653_events_names[POK_CONFIG_ARINC653_NB_EVENTS] = {"input"};
 * 
 * main.c
 * 
 * extern EVENT_ID_TYPE input_id;
 * 
 * CREATE_EVENT ("input", &(input_id), &(ret));
 */