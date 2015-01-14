package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;
import fr.tpt.aadl.ramses.generation.utils.RoutingProperties;

public class SystemPropertiesFactory extends ModelFactory<SystemProperties> {

	@Override
	public SystemProperties createFromAadl(NamedElement element,TargetProperties tarProp) {
		if(element==null || !(element instanceof SystemInstance))
			throw new IllegalArgumentException("SystemPropertiesFactory needs a SystemInstance");
		SystemProperties props =new SystemProperties();
		try {
			HashMap<String, String> vpToProcess= new HashMap<String, String>();
			HashMap<String, String> processToPart= new HashMap<String, String>();
			HashMap<String, Port> ports= new HashMap<String, Port>();
			HashMap<String, List<FeatureInstance>> processToPorts =
			    new HashMap<String, List<FeatureInstance>>();
			SystemInstance system = (SystemInstance) element;
			for(ComponentInstance process : system.getComponentInstances())
			{
				if(!process.getCategory().equals(ComponentCategory.PROCESS))
					continue;
				
				vpToProcess.putAll(getProcessBindings(process));
				
				processToPorts.put(process.getName(),getPorts(process));
				for(FeatureInstance fi:processToPorts.get(process.getName()))
					ports.put(fi.getFeature().getName(), getProcessPort(fi));
			}
			for(String part:vpToProcess.keySet())
				processToPart.put(vpToProcess.get(part), part);
			
			props.setPartitionToProcess(vpToProcess);
			props.setProcessToPorts(processToPorts);
			props.setPorts(ports);
			props.setProcessToPartition(processToPart);
			return props;
		} catch (Exception e1) {
			e1.printStackTrace();
		}		
		return null;
	}

	private HashMap<String, String> getProcessBindings(ComponentInstance process)
	{
		HashMap<String, String> processToVp=new HashMap<String, String>();
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
						processToVp.put(ci.getName(),process.getName());
					}
				}
			}
		}
		return processToVp;
	}

	private List<FeatureInstance> getPorts(ComponentInstance process)
	{
		List<FeatureInstance> processPorts = new ArrayList<FeatureInstance>();
		for(ComponentInstance subComponent: process.getComponentInstances())
		{
			if(subComponent.getCategory().equals(ComponentCategory.THREAD))
			{
				for(FeatureInstance f:subComponent.getFeatureInstances())
					if(RoutingProperties.needsRoutage(f))
					{
						processPorts.add(f);
					}
			}
		}
		return processPorts;
	}
	public static boolean needsRoutage(FeatureInstance fi)
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

	public static boolean areCollocated(FeatureInstance src, FeatureInstance dst)
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
	public static List<FeatureInstance> getFeatureSources(FeatureInstance port)
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

	public static List<FeatureInstance> getFeatureDestinations(FeatureInstance port)
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

	private Port getProcessPort(FeatureInstance fi)
	{
		ConnectionInstance ci = null ;
		ConnectionReference cf = null ;
		ConnectedElement c = null ;

		// TODO : queue information are not always in process, recursively fetch
		// these informations.
		if(DirectionType.OUT == fi.getDirection())
		{
			ci = fi.getSrcConnectionInstances().get(0) ;
			cf = ci.getConnectionReferences().get(0) ; 
			c = (ConnectedElement)(cf.getConnection().getDestination()) ;
		}
		else
		{
			ci = fi.getDstConnectionInstances().get(0) ;
			EList<ConnectionReference> crl = ci.getConnectionReferences() ;
			cf = crl.get(crl.size() -1) ;
			c = (ConnectedElement)(cf.getConnection()).getSource() ;
		}

		Port p = (Port) c.getConnectionEnd() ;

		return p ;
	}
}

