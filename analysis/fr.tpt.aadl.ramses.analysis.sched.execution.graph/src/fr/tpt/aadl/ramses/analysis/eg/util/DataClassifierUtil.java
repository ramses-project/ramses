/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.analysis.eg.util;

import org.apache.log4j.Logger ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ClassifierValue ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ComponentPrototypeActual ;
import org.osate.aadl2.ComponentPrototypeBinding ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataImplementation ;
import org.osate.aadl2.DataPrototype ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SubcomponentType ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class DataClassifierUtil
{ 
  private static Logger _LOGGER = Logger.getLogger(DataClassifierUtil.class) ;
  
  private DataClassifierUtil(){}
  
  /*private static long getDimension (NamedElement e, int index)
  {
    long dim = 0;
    try
    {
      List<Long> values = PropertyUtils.getIntListValue(e, "Dimension");
      dim = values.get(index);
    }
    catch(Exception e1)
    {
      THANK YOU FOR LOGGING !
      //System.err.println("getDimension(): " + e1.getMessage());
    }
    return dim;
  }*/
  
  private static DataClassifier getBaseType (NamedElement e)
  {
    DataClassifier dc = null;
    
    PropertyAssociation pa = PropertyUtils.findPropertyAssociation("Base_Type", e);
    
    if(pa != null)
    {
      ModalPropertyValue mpv = pa.getOwnedValues().get(0);
      PropertyExpression pex = mpv.getOwnedValue();
      if (pex != null && pex instanceof ListValue)
      {
        PropertyExpression pe = ((ListValue) pex).getOwnedListElements().get(0);
        if (pe instanceof ClassifierValue)
        {
          ClassifierValue cv = (ClassifierValue) pe;
          Classifier c = cv.getClassifier();
          if (c instanceof DataClassifier)
          {
            return (DataClassifier) c;
          }
        }
      }
    }
    else
    {
      String msg = "cannot find Base_Type for \'" + e.getName() + '\'' ;
      _LOGGER.warn(msg) ;
      ServiceProvider.SYS_ERR_REP.warning(msg, true);
    }
    
    return dc;
  }
  
  private static long getSourceDataSizeInOctetsImpl(NamedElement e)
  {
    Long size = PropertyUtils.getIntValue(e, "Data_Size");
    
    if(size == null)
    {
      size = 0l ;
    }

    return size;
  }
  
  private static String getDataRepresentationImpl(NamedElement e)
  {
    String rep = PropertyUtils.getEnumValue(e, "Data_Representation");
    if(rep == null)
    {
      String msg = "cannot find Data_Representation for \'" + e.getName() + '\'' ;
      _LOGGER.warn(msg) ;
    }
    return rep;
  }
  
  public static long getSourceDataSizeInOctets(NamedElement e)
  {
    long size = getSourceDataSizeInOctetsImpl(e);
    if (size == 0)
    {
      if (e instanceof ComponentClassifier)
      {
        ComponentClassifier cc = (ComponentClassifier) e;
        if (cc instanceof ComponentImplementation)
        {
          ComponentImplementation ci = (ComponentImplementation) cc;
          ComponentImplementation extended = ci.getExtended();
          
          if (extended != null)
          {
            size = getSourceDataSizeInOctets (extended);
            if (size == 0)
            {
              if (ci.getType() != null)
              {
                cc = ci.getType();
              }
            }
          }
        }
        if (cc instanceof ComponentType)
        {
          ComponentType ct = (ComponentType) cc;
          ComponentType extended = (ComponentType) cc.getExtended();
          if(extended!=null)
            size = getSourceDataSizeInOctets (extended);
        }
      }
    }
    return size;
  }
  
  public static String getDataRepresentation(NamedElement e)
  {
    String rep = getDataRepresentationImpl(e);
    if (rep == null)
    {
      if (e instanceof ComponentClassifier)
      {
        ComponentClassifier cc = (ComponentClassifier) e;
        if (cc instanceof ComponentImplementation)
        {
          ComponentImplementation ci = (ComponentImplementation) cc;
          ComponentImplementation extended = ci.getExtended();
          
          if (extended != null)
          {
            rep = getDataRepresentation (extended);
            if (rep == null)
            {
              if (ci.getType() != null)
              {
                cc = ci.getType();
              }
            }
          }
        }
        if (cc instanceof ComponentType)
        {
          ComponentType ct = (ComponentType) cc;
          ComponentType extended = ct.getExtended();
          if(extended!=null)
        	rep = getDataRepresentationImpl (ct.getExtended());
        }
      }
    }
    return rep;
  }
  
  private static long computeDataSize(NamedElement e)
  {
    
    String rep = getDataRepresentation(e);
    if ((e == null) || (rep == null))
    {
      return 0;
    }
    else if ((rep.equalsIgnoreCase("Struct")) && (e instanceof DataImplementation))
    {
      DataImplementation di = (DataImplementation) e;
      long size = 0;
      for(Subcomponent sub : di.getAllSubcomponents())
      {
        if (sub instanceof DataSubcomponent)
        {
          DataSubcomponent dsub = (DataSubcomponent) sub;
          DataSubcomponentType dst = dsub.getDataSubcomponentType();
          DataClassifier subdc = resolveClassifier (dst, di);
          size += getOrComputeDataSize (subdc); 
        }
      }
      return size;
    }
    else if (rep.equalsIgnoreCase("Array"))
    {
      DataClassifier dc = getBaseType (e);
      long elementSize = getOrComputeDataSize (dc);
      return elementSize;
    }
    else
    {
      return getSourceDataSizeInOctets (e);
    }
  }
  
  private static DataClassifier resolveClassifier (DataSubcomponentType dst, DataClassifier dc)
  {
    if (dst instanceof DataClassifier)
    {
      return (DataClassifier) dst;
    }
    else if (dst instanceof DataPrototype)
    {
      //DataPrototype dp = (DataPrototype) dst;
      for(PrototypeBinding b : dc.getOwnedPrototypeBindings())
      {
        if (b.getFormal().getName().equals(dst.getName())
              && b instanceof ComponentPrototypeBinding)
        {
          ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) b;
          ComponentPrototypeActual a = cpb.getActuals().get(0);
          SubcomponentType t = a.getSubcomponentType();
          if (t instanceof DataClassifier)
          {
            return (DataClassifier) t;
          }
        }
      }
    }
    return null;
  }
  
  public static long getOrComputeDataSize (NamedElement e)
  {
    long size = getSourceDataSizeInOctets (e);
    if (size == 0)
    {
      size = computeDataSize (e);
    }
    return size;
  }
}