package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Channel;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ConnectionTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Destination;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Partition;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Source;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.StandardPartition;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;
import fr.tpt.aadl.ramses.generation.utils.RoutingProperties;


public class ConnectionTableFactory extends ModelFactory<ConnectionTable> {

	@Override
	public ConnectionTable createFromAadl(NamedElement element, TargetProperties tarProp) {
		
		if(element==null || !(element instanceof ComponentInstance))
			throw new IllegalArgumentException("ConnectionTableFactory needs a ProcessorSubcomponent to create a connection table");
		ComponentInstance processor=(ComponentInstance)element;
		
		ConnectionTable result = new ConnectionTable();
		int channelId = 1;
		List<Channel> channels = new ArrayList<Channel>();
		for(ComponentInstance vps: processor.getComponentInstances())
		{
			SystemProperties props=(SystemProperties)tarProp;
			String processName = props.getPartitionToProcess().get(vps.getName());
			List<FeatureInstance> partitionPort = props.getProcessToPorts().get(processName);
			for(FeatureInstance port: partitionPort)
			{
				FeatureInstance fi = (FeatureInstance) port;
				boolean isPartitionPort = fi.getCategory().equals(FeatureCategory.DATA_PORT)
						|| fi.getCategory().equals(FeatureCategory.EVENT_PORT)
						|| fi.getCategory().equals(FeatureCategory.EVENT_DATA_PORT);
				if(!isPartitionPort)
					continue;
				
				Port p = (Port) fi.getFeature();
				if(p.getDirection().equals(DirectionType.IN))
					continue;
				
				Source s = new Source();
				StandardPartition standardPartition = new StandardPartition();
				Integer partitionId = getPropValDefault(vps, "Partition_Identifier", Integer.class, false);
				standardPartition.setPartitionIdentifier(partitionId);
				standardPartition.setPartitionName(vps.getName());
				standardPartition.setPortName(fi.getName());
				s.setStandardPartition(standardPartition);
				
				List<Destination> destinationList = new ArrayList<Destination>();
				List<FeatureInstance> dstList = RoutingProperties.getFeatureDestinations(fi);
				for(FeatureInstance dest: dstList)
				{
					Destination channelDst = new Destination();
					StandardPartition dstStandardPartition = new StandardPartition();
					ComponentInstance process = dest.getComponentInstance();
					String partitionName=null;
					Iterator<Entry<String, String>> it = props.getPartitionToProcess().entrySet().iterator();
				    while (it.hasNext()) {
				        Map.Entry<String,String> pairs = (Map.Entry<String,String>)it.next();
				        if(pairs.getValue().equals(process.getName()))
				        {
				        	partitionName = pairs.getKey();
				        	break;
				        }
				    }
					
					Partition partDest = props.getPartitions().get(partitionName);
					dstStandardPartition.setPartitionIdentifier(partDest.getPartitionIdentifier());
					dstStandardPartition.setPartitionName(partDest.getPartitionName());
					dstStandardPartition.setPortName(dest.getName());
					channelDst.setStandardPartition(dstStandardPartition);
					destinationList.add(channelDst);
				}
				Channel c = new Channel();
				c.setSource(s);
				c.setDestinationList(destinationList);
				c.setChannelIdentifier(Integer.toString(channelId));
				
				channels.add(c);
			}

		}
		result.setChannels(channels);
		return result;
	}

}
