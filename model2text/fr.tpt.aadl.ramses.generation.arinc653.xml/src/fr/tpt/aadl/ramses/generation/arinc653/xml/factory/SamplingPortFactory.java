package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import org.osate.aadl2.DataPort;
import org.osate.aadl2.NamedElement;
import org.osate.utils.PropertyUtils;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.BaseDataType;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.DirectionType;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SamplingPort;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;

public class SamplingPortFactory extends ModelFactory<SamplingPort> {

	@SuppressWarnings("incomplete-switch")
	@Override
	public SamplingPort createFromAadl(NamedElement element, TargetProperties tarProp) {
		if(element==null || !(element instanceof DataPort))
			throw new IllegalArgumentException("QueuingPortFactory needs an EventDataPort to create a QueuingPort");
		SamplingPort port=new SamplingPort();
		DataPort edt=(DataPort)element;
		SystemProperties props=(SystemProperties)tarProp;
		try {
			String name = getPropVal(props.getPorts().get(element.getName()), "Source_Name", String.class, false);
			port.setPortName(name!=null?name:element.getName());
			port.setRefreshRateSeconds(getPropVal(props.getPorts().get(element.getName()), "Sampling_Refresh_Period", int.class, true));
			DirectionType dt=null;
			switch(edt.getDirection())
			{
			case OUT:
				dt=DirectionType.SOURCE;
				break;
			case IN:
				dt=DirectionType.DESTINATION;
				break;
			}
			port.setDirection(dt);
			port.setMaxMessageSize(getDataSize(edt));
			return port;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getDataSize(DataPort port)
	{
		String res=null;
		try {
			res=getPropVal(port.getDataFeatureClassifier(), "Source_Data_Size", String.class, false);
			if(res!=null) return res;
			res=PropertyUtils.getEnumValue(port.getDataFeatureClassifier(), "Data_Representation").toString();
			if(res==null) return res;
			return BaseDataType.valueOf(res).getSize();
		} catch (Exception e) {
		}
		return null;
	}
}
