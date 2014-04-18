package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.NamedElement;
import org.osate.utils.PropertyUtils;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.BaseDataType;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.DirectionType;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.QueuingPort;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;


public class QueuingPortFactory extends ModelFactory<QueuingPort> {

	@SuppressWarnings("incomplete-switch")
	@Override
	public QueuingPort createFromAadl(NamedElement element, TargetProperties tarProp) {
		if(element==null || !(element instanceof EventDataPort))
			throw new IllegalArgumentException("QueuingPortFactory needs an EventDataPort to create a QueuingPort");
		QueuingPort port=new QueuingPort();
		EventDataPort edt=(EventDataPort)element;
		SystemProperties props=(SystemProperties)tarProp;
		try {
			String name = getPropVal(props.getPorts().get(element.getName()), "Source_Name", String.class, false);
			port.setPortName(name!=null?name:element.getName());
			port.setMaxNbMessages(getPropVal(props.getPorts().get(element.getName()), "Queue_Size", int.class, true));
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
	
	private String getDataSize(EventDataPort port)
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
