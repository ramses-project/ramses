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

package fr.tpt.aadl.ramses.control.atl.hooks.utils;

import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.util.properties.AadlUtil;

public class ComparablePortByCriticality implements Comparable<ComparablePortByCriticality>
{
	private long _criticality=1;
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