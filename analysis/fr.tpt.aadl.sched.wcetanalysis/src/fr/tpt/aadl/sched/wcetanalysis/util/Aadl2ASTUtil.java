package fr.tpt.aadl.sched.wcetanalysis.util;

import java.util.List;

import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;

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
}
