package fr.tpt.aadl.ramses.generator.pok.c;

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
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.generator.c.GenerationUtilsC ;

public class RoutingProperties implements TargetProperties {

	public Set<FeatureInstance> globalPort = new HashSet<FeatureInstance>();

	public Set<ComponentInstance> processes = new HashSet<ComponentInstance>();

	public Set<ComponentInstance> processors = new HashSet<ComponentInstance>();
	
	public Set<ComponentInstance> buses = new HashSet<ComponentInstance>();
	
	public Map<ComponentInstance, List<FeatureInstance>> portPerProcess = new HashMap<ComponentInstance, List<FeatureInstance>>();

	public Map<FeatureInstance, ComponentInstance> processorPort = new HashMap<FeatureInstance, ComponentInstance>();

	public Map<ComponentInstance, List<ComponentInstance>> processPerProcessor = new HashMap<ComponentInstance, List<ComponentInstance>>();
	
	
	public static String getFeatureLocalIdentifier(FeatureInstance fi)
	{
		return GenerationUtilsC.getGenerationCIdentifier(fi.getComponentInstancePath()+"_"+fi.getName());
	}
	
	public static String getFeatureGlobalIdentifier(FeatureInstance fi)
	{
		return GenerationUtilsC.getGenerationCIdentifier(fi.getComponentInstancePath()+"_"+fi.getName()+"_global");
	}
	
	public static String getComponentInstanceIdentifier(ComponentInstance instance)
	{
		return GenerationUtilsC.getGenerationCIdentifier(instance.getComponentInstancePath());
	}
	
	public void setRoutingProperties(SystemInstance system)
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
					if(needsRoutage(f))
					{
						processPorts.add(f);
						globalPort.add(f);
						processorPort.put(f, getProcessorBinding(process));
					}
				}
			}
		}
	}

	private boolean needsRoutage(FeatureInstance fi)
	{
		boolean result = false;
		if(fi.getCategory().equals(FeatureCategory.DATA_PORT)
				|| fi.getCategory().equals(FeatureCategory.EVENT_PORT)
				|| fi.getCategory().equals(FeatureCategory.EVENT_DATA_PORT))
		{
			List<FeatureInstance> dstList = getFeatureDestinations(fi);
			if(dstList!=null)
			{
				for(FeatureInstance dst : dstList)
					if(false == areCollocated(fi,dst))
						return true;
			}
			List<FeatureInstance> srcList = getFeatureSources(fi);
			if(dstList!=null)
			{
				for(FeatureInstance src : srcList)
					if(false == areCollocated(fi,src))
						return true;
			}
		}
		return result;
	}
	
	private boolean areCollocated(FeatureInstance src, FeatureInstance dst)
	{
		ComponentInstance srcProcess=null, dstProcess=null;
		if(src.getContainingComponentInstance().getCategory()
				.equals(ComponentCategory.THREAD))
			srcProcess = src.getContainingComponentInstance()
				.getContainingComponentInstance();
		if(dst.getContainingComponentInstance().getCategory()
				.equals(ComponentCategory.THREAD))
			dstProcess = dst.getContainingComponentInstance()
				.getContainingComponentInstance();
		if(srcProcess==null || dstProcess==null)
			return false;
		return srcProcess.equals(dstProcess);
	}
	
	private List<FeatureInstance> getFeatureSources(FeatureInstance port)
	{
		// The parameter "port" must be port of a thread component
		if(!port.getContainingComponentInstance().getCategory()
				.equals(ComponentCategory.THREAD))
			return null;

		List<FeatureInstance> result = new ArrayList<FeatureInstance>();
		for(ConnectionInstance ci: port.getDstConnectionInstances())
		{
			FeatureInstance fi = (FeatureInstance)ci.getSource();
			if(fi.getContainingComponentInstance().getCategory()
					.equals(ComponentCategory.THREAD))
			{
				result.add(fi);
			}
		}
		return result;
	}
	
	public List<FeatureInstance> getFeatureDestinations(FeatureInstance port)
	{
		// The parameter "port" must be port of a thread component
		if(!port.getContainingComponentInstance().getCategory()
				.equals(ComponentCategory.THREAD))
			return null;

		List<FeatureInstance> result = new ArrayList<FeatureInstance>();
		for(ConnectionInstance ci: port.getSrcConnectionInstances())
		{
			FeatureInstance fi = (FeatureInstance)ci.getDestination();
			if(fi.getContainingComponentInstance().getCategory()
					.equals(ComponentCategory.THREAD))
			{
				result.add(fi);
			}
		}
		return result;
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
							List<ComponentInstance> processes  =new ArrayList<ComponentInstance>();
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
