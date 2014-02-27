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


package fr.tpt.aadl.ramses.generation.pok.ada;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.generation.ada.GenerationUtilsADA;

public class AadlToPokADAUtils
{
  public static String getFeatureLocalIdentifier(FeatureInstance fi)
  {
    return GenerationUtilsADA.getGenerationADAIdentifier(fi.getComponentInstancePath()+"_"+fi.getName());
  }
  
  public static String getFeatureGlobalIdentifier(FeatureInstance fi)
  {
    return GenerationUtilsADA.getGenerationADAIdentifier(fi.getComponentInstancePath()+"_"+fi.getName()+"_global");
  }
  
  public static String getComponentInstanceIdentifier(ComponentInstance instance)
  {
    return GenerationUtilsADA.getGenerationADAIdentifier(instance.getComponentInstancePath());
  }
}