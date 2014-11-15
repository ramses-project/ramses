package fr.tpt.aadl.ramses.analysis.memoryfootprint;

import java.util.List ;

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
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.utils.PropertyUtils ;

public class DataSizeHelper
{
  
  private final static Logger _LOGGER = Logger.getLogger(DataSizeHelper.class) ;

  private DataSizeHelper(){}
  
  private static DataClassifier getBaseType (NamedElement e)
  {
    DataClassifier dc = null;
    try
    {
      PropertyAssociation pa = PropertyUtils.findPropertyAssociation("Base_Type", e);
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
    catch(Exception e1){}
    
    return dc;
  }
  
  private static int getSourceDataSizeInOctetsImpl(NamedElement e)
  {
    double size = 0l;
    try 
    {
      size = PropertyUtils.getIntValue(e, "Data_Size");
    } 
    catch (Exception e1) 
    {
      _LOGGER.warn("Data_Size property missing for "+e.getFullName());
    }
    return (int) size;
  }
  
  private static int getSumOfDimensions(NamedElement e)
  {
    double nbOfElements = 0l;
    try
    {
      List<Long> dimensionsList = getDimentions(e);
      for(Long dim: dimensionsList)
        nbOfElements+=Double.valueOf(dim);
    }
    catch (Exception e1) 
    {
      _LOGGER.warn("Dimension property missing for "+e.getFullName());
    }
    return (int) nbOfElements;
  }
  
  private static List<Long> getDimentions(NamedElement e)
  {
    List<Long> dimensionsList = PropertyUtils.getIntListValue(e, "Dimension");
    if(dimensionsList==null)
    {
      if(e instanceof ComponentImplementation)
      {
        ComponentImplementation ci = (ComponentImplementation) e;
        ComponentType ct = ci.getType();
        dimensionsList = PropertyUtils.getIntListValue(ct, "Dimension");
        ComponentImplementation parentImpl = ci.getExtended();
        
        
        while(dimensionsList==null && parentImpl!=null)
        {
          dimensionsList = PropertyUtils.getIntListValue(parentImpl, "Dimension");
          parentImpl = parentImpl.getExtended();
        }
        if(dimensionsList==null)
          return getDimentions(ct);
      }
      else if(e instanceof ComponentType)
      {
        return getDimentions((ComponentType)e);
      }
    }
    return dimensionsList;
  }
  private static List<Long> getDimentions(ComponentType e)
  {
    List<Long> dimensionsList=PropertyUtils.getIntListValue(e, "Dimension");
    ComponentType parentType = e.getExtended();
    while(dimensionsList==null && parentType!=null)
    {
      dimensionsList = PropertyUtils.getIntListValue(parentType, "Dimension");
      parentType = parentType.getExtended();
    }
    return dimensionsList;
  }
  private static String getDataRepresentationImpl(NamedElement e)
  {
    String rep = null;
    try
    {
      rep = PropertyUtils.getEnumValue(e, "Data_Representation");
    }
    catch(Exception e1)
    {
      //System.err.println("getDataRepresentation(): " + e1.getMessage());
    }
    return rep;
  }
  
  public static double getSourceDataSizeInOctets(NamedElement e)
  {
    double size = 0;
    ComponentClassifier cc = null;
    if(e instanceof ComponentInstance)
    {
      ComponentInstance inst = (ComponentInstance) e;
      cc = inst.getComponentClassifier();
    }
    if (e instanceof ComponentClassifier)
    {
      cc = (ComponentClassifier) e;
    }
    if(cc!=null)
      size = getSourceDataSizeInOctetsImpl(cc);
    if (size == 0)
    {
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
        size = getSourceDataSizeInOctets (ct.getExtended());
      }
    }
    return size;
  }
  
  public static String getDataRepresentation(NamedElement e)
  {
    
    ComponentClassifier cc = null;
    if(e instanceof ComponentInstance)
    {
      String rep = getDataRepresentationImpl(e);
      if(rep==null)
        cc=((ComponentInstance)e).getComponentClassifier();
    }
    if (e instanceof ComponentClassifier)
    {
      cc = (ComponentClassifier) e;
    }
    String rep = getDataRepresentationImpl(cc);
    if (rep == null)
    {
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
      else if (cc instanceof ComponentType)
      {
        ComponentType ct = (ComponentType) cc;
        rep = getDataRepresentationImpl (ct.getExtended());
      }
    }
    return rep;
  }
  
  private static double computeDataSize(NamedElement e)
  {
    
    String rep = getDataRepresentation(e);
    if ((e == null) || (rep == null))
    {
      return 0;
    }
    else if ((rep.equalsIgnoreCase("Struct")) && (e instanceof DataImplementation))
    {
      DataImplementation di = (DataImplementation) e;
      double size = 0;
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
      double elementSize = getOrComputeDataSize (dc);
      double numberOfElements = getSumOfDimensions(e);
      return numberOfElements*elementSize;
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
  
  public static double getOrComputeDataSize (NamedElement e)
  {
    double size = getSourceDataSizeInOctets (e);
    if (size == 0)
    {
      size = computeDataSize (e);
    }
    return size;
  }
}
