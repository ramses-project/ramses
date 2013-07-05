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

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.ProcessClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC;

public class AadlToPokCUtils
{
  private static String getProcessPortName(FeatureInstance fi)
  {
	if(((ComponentInstance)fi.eContainer()).getCategory()==ComponentCategory.PROCESS)
	  return ((ComponentInstance) fi.eContainer()).getName();
	if(fi.getDirection() == DirectionType.IN)
	{
	  int last = fi.getDstConnectionInstances().get(0).getConnectionReferences().size()-1;
	  return ((ComponentInstance)fi.getDstConnectionInstances().get(0).getConnectionReferences().get(last).getSource().eContainer()).getName();
	}
	else
	  return ((ComponentInstance)fi.getSrcConnectionInstances().get(0).getConnectionReferences().get(0).getDestination().eContainer()).getName();
  }
  public static String getFeatureLocalIdentifier(FeatureInstance fi)
  {
	
    return GenerationUtilsC.getGenerationCIdentifier(getProcessPortName(fi)+"_"+fi.getName());
  }
  
  public static String getFeatureGlobalIdentifier(FeatureInstance fi)
  {
    return GenerationUtilsC.getGenerationCIdentifier(fi.getComponentInstancePath()+"_"+fi.getName()+"_global");
  }
  
  public static String getComponentInstanceIdentifier(ComponentInstance instance)
  {
    return GenerationUtilsC.getGenerationCIdentifier(instance.getComponentInstancePath());
  }
  
}
