package fr.tpt.aadl.ramses.transformation.atl;

import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.util.properties.AadlUtil;

public class ComparablePortByCriticality implements Comparable<ComparablePortByCriticality> {

	private long _criticality=0;
	private FeatureInstance _featureInstance=null;
	
	public ComparablePortByCriticality(FeatureInstance port)
	{
		_featureInstance = port;
		_criticality = AadlUtil.getInfoPortCriticality(port);
	}
	
	@Override
	public int compareTo(ComparablePortByCriticality toCompare) {
		if(_criticality<toCompare._criticality)
			return -1;
		else if(_criticality==toCompare._criticality)
			return 0; 
		else return 1;
	}

	public FeatureInstance getFeatureInstance()
	{
		return _featureInstance;
	}

}
