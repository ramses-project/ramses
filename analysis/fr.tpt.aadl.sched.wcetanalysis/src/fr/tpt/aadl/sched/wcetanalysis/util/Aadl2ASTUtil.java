package fr.tpt.aadl.sched.wcetanalysis.util;

import java.util.List;

import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ba.aadlba.SubprogramCallAction;
import org.osate.utils.PropertyUtils;

import fr.tpt.aadl.sched.wcetanalysis.model.IOTime;

public class Aadl2ASTUtil
{

	private Aadl2ASTUtil()
	{
	}

	/**
	 * Returns global ID of given local (thread) resource name.
	 * 
	 * @param resourceID
	 *            local resource id
	 * @param thread
	 *            thread accessing the resource.
	 * @return global name of the resource.
	 */
	public static String getResourceGlobalName(String resourceID,
			ComponentInstance thread)
	{
		SystemInstance s = thread.getSystemInstance();

		for (ConnectionInstance co : s.getConnectionInstances())
		{
			if (co.getKind() == ConnectionKind.ACCESS_CONNECTION)
			{
				ConnectionInstanceEnd d = co.getDestination();

				if (d instanceof FeatureInstance)
				{
					if ((d.getOwner() == thread)
							&& (d.getName().equals(resourceID)))
					{
						return co.getSource().getName();
					}
				}
			}
		}

		return resourceID;
	}

	public static boolean hasBehavior(Classifier c)
	{
		if (BehaviorAnnexUtil.getBehaviorAnnex(c) != null)
		{
			return true;
		}
		else if (c instanceof BehavioredImplementation)
		{
			BehavioredImplementation bi = (BehavioredImplementation) c;
			List<CallSpecification> l = bi.getCallSpecifications();
			return (l != null && !l.isEmpty());
		}
		else
		{
			return false;
		}
	}
	
	public static DataClassifier getDataClassifier(DataSubcomponentType t,
			SubprogramClassifier sc)
	{
		return getDataClassifier(t,sc,null);
	}
	
	public static DataClassifier getDataClassifier(DataSubcomponentType t,
			SubprogramClassifier sc, SubprogramCallAction callAction)
	{
		if (t instanceof DataClassifier)
		{
			//TODO: dataclassifier refined by feature connection
			
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
	
	public static IOTime getWriteTime(ComponentInstance thread)
	{
		return getMemoryIOTime((ComponentInstance) thread.eContainer(), 
				"Write_Time");
	}
	
	public static IOTime getReadTime(ComponentInstance thread)
	{
		return getMemoryIOTime((ComponentInstance) thread.eContainer(), 
				"Read_Time");
	}
	
	private static IOTime getMemoryIOTime(ComponentInstance process,
			String property)
	{
		if (process.getCategory() == ComponentCategory.PROCESS)
		{
			try
			{
				PropertyExpression pe = PropertyUtils.getPropertyValue(
						"Actual_Memory_Binding", process);
				ComponentInstance mem = null;
				if (pe instanceof InstanceReferenceValue)
				{
					InstanceReferenceValue irv = (InstanceReferenceValue) pe;
					mem = (ComponentInstance) irv
							.getReferencedInstanceObject();
				}
				else if(pe instanceof ListValue)
				{
					ListValue lv = (ListValue) pe;
					InstanceReferenceValue irv = (InstanceReferenceValue) lv.getOwnedListElements().get(0);
					mem = (ComponentInstance) irv
							.getReferencedInstanceObject();
				}
				RecordValue rv = PropertyUtils.getRecordValue(mem, property);

				double fixed = 0d;
				double perByte = 0d;

				for(BasicPropertyAssociation value : rv.getOwnedFieldValues())
				{
					String propertyName = value.getProperty().getName();
					if (propertyName.equalsIgnoreCase("Fixed"))
					{
						RangeValue range = (RangeValue) value.getOwnedValue();
						fixed = range.getMaximumValue().getScaledValue("ms");
					}
					else if (propertyName.equalsIgnoreCase("PerByte"))
					{
						RangeValue range = (RangeValue) value.getOwnedValue();
						perByte = range.getMaximumValue().getScaledValue("ms");
					}
				}

				return new IOTime(fixed,perByte);
			}
			catch (Exception e){}
		}
		return new IOTime();
	}
}
