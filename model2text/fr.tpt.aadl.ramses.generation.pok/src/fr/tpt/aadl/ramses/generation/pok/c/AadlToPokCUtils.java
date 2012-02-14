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

import java.util.ArrayList ;
import java.util.List ;

import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.FeatureCategory ;
import org.osate.aadl2.instance.FeatureInstance ;

import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC ;

public class AadlToPokCUtils
{
  static String getFeatureLocalIdentifier(FeatureInstance fi)
  {
    return GenerationUtilsC.getGenerationCIdentifier(fi.getComponentInstancePath()+"_"+fi.getName());
  }
  
  static String getFeatureGlobalIdentifier(FeatureInstance fi)
  {
    return GenerationUtilsC.getGenerationCIdentifier(fi.getComponentInstancePath()+"_"+fi.getName()+"_global");
  }
  
  static String getComponentInstanceIdentifier(ComponentInstance instance)
  {
    return GenerationUtilsC.getGenerationCIdentifier(instance.getComponentInstancePath());
  }
  
  static boolean needsRoutage(FeatureInstance fi)
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
  
  static boolean areCollocated(FeatureInstance src, FeatureInstance dst)
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
  
  static List<FeatureInstance> getFeatureSources(FeatureInstance port)
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
  
  static List<FeatureInstance> getFeatureDestinations(FeatureInstance port)
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
}
