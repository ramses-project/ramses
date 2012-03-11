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

package fr.tpt.aadl.ramses.generation.pok.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;

public class RoutingProperties implements TargetProperties {

	ProcessorProperties processorProp ;
  
  Set<FeatureInstance> globalPort = new HashSet<FeatureInstance>();

	Set<ComponentInstance> processes = new HashSet<ComponentInstance>();

	Set<ComponentInstance> processors = new HashSet<ComponentInstance>();
	
	Set<ComponentInstance> buses = new HashSet<ComponentInstance>();
	
	Map<ComponentInstance, List<FeatureInstance>> portPerProcess = 
	                      new HashMap<ComponentInstance, List<FeatureInstance>>();

	Map<FeatureInstance, ComponentInstance> processorPort = 
	                            new HashMap<FeatureInstance, ComponentInstance>();

	Map<ComponentInstance, Set<ComponentInstance>> processPerProcessor =
	                    new HashMap<ComponentInstance, Set<ComponentInstance>>();
	
	void setRoutingProperties(SystemInstance system)
	{
		for(ComponentInstance subComponent: system.getComponentInstances())
		{
			processComponentInstance(subComponent);
		}
	}

	private void processComponentInstance(ComponentInstance component)
	{

		if(component.getCategory().equals(ComponentCategory.PROCESS))
		{
			processes.add(component);
			getPartitionProperties(component);
		}
		else if(component.getCategory().equals(ComponentCategory.PROCESSOR))
			processors.add(component);
		else if(component.getCategory().equals(ComponentCategory.BUS))
			buses.add(component);
		else
		{
			for(ComponentInstance subComponent: component.getComponentInstances())
			{
				processComponentInstance(subComponent);
			}
		}
	}

	private void getPartitionProperties(ComponentInstance process)
	{
		List<FeatureInstance> processPorts = new ArrayList<FeatureInstance>();
		portPerProcess.put(process, processPorts);
		for(ComponentInstance subComponent: process.getComponentInstances())
		{
			if(subComponent.getCategory().equals(ComponentCategory.THREAD))
			{
				for(FeatureInstance f:subComponent.getFeatureInstances())
				{
					if(AadlToPokCUtils.needsRoutage(f))
					{
						processPorts.add(f);
						globalPort.add(f);
						processorPort.put(f, getProcessorBinding(process));
					}
				}
			}
		}
	}

	private ComponentInstance getProcessorBinding(ComponentInstance process)
	{
		PropertyAssociation deploymentPropertyAssociation=null;
		for(PropertyAssociation pa : process.getOwnedPropertyAssociations())
		{
			if(pa.getProperty().getName() == null)
			{
				continue ;
			}

			if(pa.getProperty().getName().equalsIgnoreCase("Actual_Processor_Binding"))
			{
				deploymentPropertyAssociation=pa;
				break;
			}
		}

		for(ModalPropertyValue aModalPropertyValue : deploymentPropertyAssociation
				.getOwnedValues())
		{
			if(aModalPropertyValue.getOwnedValue() instanceof ListValue)
			{
				ListValue list = (ListValue) aModalPropertyValue.getOwnedValue() ;

				for(PropertyExpression pe : list.getOwnedListElements())
				{
					if(pe instanceof InstanceReferenceValue)
					{
						InstanceReferenceValue rv = (InstanceReferenceValue) pe ;
						ComponentInstance ci = (ComponentInstance) rv.getReferencedInstanceObject();
						ComponentInstance processor = null ;
						if(ci.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR))
							processor = getParentProcessor(ci);
						else if(ci.getCategory().equals(ComponentCategory.PROCESSOR))
							processor = ci;


						if(processPerProcessor.get(processor)!=null)
							processPerProcessor.get(processor).add(process);
						else
						{
							Set<ComponentInstance> processes  =new HashSet<ComponentInstance>();
							processes.add(process);
							processPerProcessor.put(processor, processes);
						}

						return processor ;
					}
				}
			}
		}
		return null;
	}

	private ComponentInstance getParentProcessor(ComponentInstance ci) {
		if(ci.getContainingComponentInstance().getCategory().equals(ComponentCategory.PROCESSOR))
			return ci.getContainingComponentInstance();
		else
			return getParentProcessor(ci);
	}

	/*
    uint8_t pr2_partport[1] = {pr2_pdatain};
    uint8_t pr1_pdataout_deployment_destinations[1] = {pr2_pdatain_global};
    uint8_t pok_global_ports_to_local_ports[POK_CONFIG_NB_GLOBAL_PORTS] = {pr2_pdatain,pr1_pdataout};
    uint8_t pok_local_ports_to_global_ports[POK_CONFIG_NB_PORTS] = {pr2_pdatain_global,pr1_pdataout_global};
    uint8_t pok_ports_nodes[POK_CONFIG_NB_GLOBAL_PORTS] = {0,0};
    uint8_t pok_ports_nb_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {1,1};
    uint8_t* pok_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {pr2_partport,pr1_partport};
    char* pok_ports_names[POK_CONFIG_NB_PORTS] = {"pr2_pdatain","pr1_pdataout"};
    uint8_t pok_ports_identifiers[POK_CONFIG_NB_PORTS] = {pr2_pdatain,pr1_pdataout};
    uint8_t pok_ports_nb_destinations[POK_CONFIG_NB_PORTS] = {0,1};
    uint8_t* pok_ports_destinations[POK_CONFIG_NB_PORTS] = {NULL,pr1_pdataout_deployment_destinations};
    pok_port_kind_t pok_ports_kind[POK_CONFIG_NB_PORTS] = {POK_PORT_KIND_QUEUEING,POK_PORT_KIND_QUEUEING};*/


}
