package fr.tpt.aadl.ramses.analysis.eg.util;

import java.util.List ;

import org.osate.aadl2.AccessSpecification ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ComponentPrototypeActual ;
import org.osate.aadl2.ComponentPrototypeBinding ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.ConnectionEnd ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataPrototype ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.DirectedFeature ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.FeaturePrototypeActual ;
import org.osate.aadl2.FeaturePrototypeBinding ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.SubprogramType ;
import org.osate.ba.aadlba.BehaviorVariable ;
import org.osate.ba.aadlba.Target ;
import org.osate.utils.Aadl2Utils ;

import fr.tpt.aadl.ramses.analysis.eg.ba.AssignmentActionUtil ;
import fr.tpt.aadl.ramses.analysis.eg.context.EGContext ;

public class ClassifierUtil {

	private ClassifierUtil(){}
	
	public static DataClassifier getDataClassifier(Target t)
	{
		NamedElement e = AssignmentActionUtil.getTargetElement(t);
		return getDataClassifier(e);
	}
	
	public static DataClassifier getDataClassifierEl(DataSubcomponentType t,
			NamedElement e)
	{
		SubprogramClassifier sc = null;
		if (e instanceof SubprogramClassifier)
		{
			sc = (SubprogramClassifier) e;
		}
		else if (e instanceof SubprogramCall)
		{
			sc = (SubprogramClassifier) 
					(((SubprogramCall) e).getCalledSubprogram());
		}
		return getDataClassifier(t,sc);
	}
	
	public static DataClassifier getDataClassifier(ConnectionEnd ce,
			SubprogramClassifier c)
	{
		if (ce instanceof Parameter)
		{
			Parameter p = (Parameter) ce;
			DataSubcomponentType dst = p.getDataFeatureClassifier();
			return getDataClassifier(dst,c);
		}
		else
		{
			return null;
		}
	}
	
	public static DataClassifier getDataClassifier(DataSubcomponentType t,
			SubprogramClassifier sc)
	{
		if (t instanceof DataClassifier)
		{
			return (DataClassifier) t;
		}
		else if (t instanceof DataPrototype)
		{
			//final SubprogramClassifier sc = (SubprogramClassifier) ctxt.getCurrentVisitedElement();
			
			List<PrototypeBinding> binds = sc.getOwnedPrototypeBindings();
			if (binds != null)
			{		
				for(PrototypeBinding b : binds)
				{
					String pName = b.getFormal().getName();
					if (t.getName().equals(pName))
					{
						if (b instanceof ComponentPrototypeBinding)
						{
							ComponentPrototypeBinding cp = (ComponentPrototypeBinding) b;
							ComponentPrototypeActual actual = cp.getActuals().get(0);
							DataSubcomponentType st = (DataSubcomponentType) actual.getSubcomponentType();
							return getDataClassifier(st,sc);
						}
						else if (b instanceof FeaturePrototypeBinding)
						{
							FeaturePrototypeBinding fb = (FeaturePrototypeBinding) b;
							FeaturePrototypeActual actual = fb.getActual();
							if (actual instanceof AccessSpecification)
							{
								return (DataClassifier) 
										((AccessSpecification) actual).getClassifier();
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public static DataClassifier getDataClassifier(DataSubcomponentType t)
	{
		EGContext ctxt = EGContext.getInstance();
		DataClassifier dc = ctxt.getCurrentVisitedSubprogram().resolveClassifier(t);
		return dc;
	}
	
	public static DataClassifier getDataClassifier(NamedElement t)
	{
	  if (t instanceof DataAccess)
		{
			DataAccess da = (DataAccess) t;
			return getDataClassifier(da.getDataFeatureClassifier());
		}
		else if (t instanceof BehaviorVariable)
		{
			BehaviorVariable bv = (BehaviorVariable) t;
			return bv.getDataClassifier();
		}
		else if (t instanceof DataSubcomponent)
		{
			DataSubcomponent ds = (DataSubcomponent) t;
			return getDataClassifier(ds.getDataSubcomponentType());
		}
		else if (t instanceof Parameter)
		{
			Parameter p = (Parameter) t;
			return getDataClassifier(p.getDataFeatureClassifier());
		}
		else
		{
			return null;
		}
	}
	
	public static long getFeatureSizeInOctets (SubprogramType st, int index)
	{
	  List<Feature> features = Aadl2Utils.orderFeatures(st);
	  Feature f = features.get(index);
	  DataClassifier dc = getDataClassifier (f);
	  return (dc == null ? 0 : DataClassifierUtil.getOrComputeDataSize(dc));
	}
	
	/*
	public static long getSourceDataSize(DataClassifier dataClassifier)
  {
    if (dataClassifier == null)
    {
      return 0l;
    }
    
    try
    {
      return PropertyUtils.getIntValue(dataClassifier,
          "Source_Data_Size");
    }
    catch (Exception e)
    {
      DataClassifier baseType = null;
      try
      {
        baseType = (DataClassifier) PropertyUtils
            .getClassifierValue(dataClassifier, "Base_Type");
      }
      catch (Exception ex){}
      
      if (baseType != null)
      {
        return getSourceDataSize(baseType);
      }
      else
      {
        DataClassifier parent = (DataClassifier) getExtendedClassifier (dataClassifier);
        long size = 0;
        if (parent != null)
        {
          size = getSourceDataSize(parent);
        }
        if (size == 0)
        {
          try
          {
            String val = PropertyUtils.getStringValue(dataClassifier, 
                                                      "Initial_Value");
            size = (int) Integer.parseInt(val);
          }
          catch(Exception e1){}
        }
        return size;
      }
    }
  }*/
	
	public static Classifier getExtendedClassifier (NamedElement e)
	{
	  if (e instanceof Classifier)
	  {
	    return ((Classifier) e).getExtended();
	  }
	  else
	  {
	    return null;
	  }
	}
	
	public static ComponentType getTypeClassifier (NamedElement e)
	{
	  if (e instanceof ComponentImplementation)
	  {
	    return ((ComponentImplementation) e).getType();
	  }
	  else if (e instanceof ComponentType)
	  {
	    return ((ComponentType) e);
	  }
	  else
	  {
	    return null;
	  }
	}
	
	public static boolean isInputFeature (SubprogramType st, int index)
	{
	  List<Feature> features = Aadl2Utils.orderFeatures(st);
	  Feature f = features.get(index);
	  if (f instanceof DirectedFeature)
	  {
	    DirectedFeature df = (DirectedFeature) f;
	    return df.getDirection()==DirectionType.IN || 
	           df.getDirection()==DirectionType.IN_OUT;
	  }
	  else
	  {
	    return false;
	  }
	}
	
	public static boolean isOutputFeature (SubprogramType st, int index)
  {
	  List<Feature> features = Aadl2Utils.orderFeatures(st);
    Feature f = features.get(index);
    if (f instanceof DirectedFeature)
    {
      DirectedFeature df = (DirectedFeature) f;
      return df.getDirection()==DirectionType.OUT || 
             df.getDirection()==DirectionType.IN_OUT;
    }
    else
    {
      return false;
    }
  }
	
	public static boolean isValuePassingFeature (SubprogramType st, int index)
  {
    List<Feature> features = Aadl2Utils.orderFeatures(st);
    Feature f = features.get(index);
    return (f instanceof Parameter);
  }
}
