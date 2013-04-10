package fr.tpt.aadl.sched.wcetanalysis.extractors.seq;

import java.util.List;

import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;

import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.DataHolder;
import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;

public class SubprogramCallUtil {
	private final ExtractionContext ctxt;
	
	public SubprogramCallUtil(ExtractionContext ctxt)
	{
		this.ctxt = ctxt;
	}
	
	public NamedElement getAssignedValue(DataComponentReference r)
	{
		ComponentInstance th = ctxt.getCurrentVisitedThread();
		if (th == null)
		{
			return null;
		}
		SubprogramCall call = (SubprogramCall) ctxt.getCurrentVisitedElement();
		if (! (call.eContainer() instanceof SubprogramCallSequence))
		{
			return null;
		}
		
		SubprogramCallSequence seq = (SubprogramCallSequence) call.eContainer();
		BehavioredImplementation bi = (BehavioredImplementation) seq.getOwner();
		String name = r.getData().get(0).getElement().getName();
		
		for(Connection c: bi.getOwnedConnections())
		{
			ConnectedElement ceDest = (ConnectedElement) c.getDestination();
			Context dstCtxt = ceDest.getContext();
			ConnectionEnd dstCE = ceDest.getConnectionEnd();
			String dstCEName = getName(dstCE);
			if (dstCtxt==call && dstCEName.equals(name))
			{
				ConnectedElement ceSrc = (ConnectedElement) c.getSource();
				ConnectionEnd ce = ceSrc.getConnectionEnd();
				Context srcCtxt = ceSrc.getContext();
				
				String neName = ((NamedElement) ce).getName();
				
				/* Retrieve the thread instance from the current visited thread implementation
				 * to know which concrete element is connected to the feature.
				 */
				ComponentInstance pr = (ComponentInstance) th.getOwner();
				for(ConnectionInstance ci: pr.getConnectionInstances())
				{
					ConnectionInstanceEnd ciDest = ci.getDestination();
					if (ciDest.getComponentInstance()==th && ciDest.getName().equals(neName))
					{
						ConnectionInstanceEnd ciSrc = ci.getSource();
						NamedElement ciSrcE = (NamedElement) ciSrc;
						if (ciSrcE instanceof ComponentInstance)
						{
							return getSubcomponentValue(r,(ComponentInstance) ciSrcE);
						}
					}
				}
			}
		}
		return null;
	}
	
	private static String getName(NamedElement e)
	{
		if (e.getName()!=null)
		{
			return e.getName();
		}
		else if (e instanceof Feature)
		{
			return getName(((Feature) e).getRefined());
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Find the component in the hierarchy which the given path
	 * @param r behavior annex - data component reference (path)
	 * @param ci main data subcomponent starting the hierarchy
	 * @return subcomponent (ComponentInstance) corresponding to the given path
	 */
	private ComponentInstance getSubcomponentValue(DataComponentReference r, ComponentInstance ci)
	{
		final List<DataHolder> data = r.getData();
		
		ComponentInstance current = ci;
		for(int i=1;i<data.size();i++)
		{
			NamedElement ne = data.get(i).getElement();
			boolean found = false;
			for(ComponentInstance child: current.getComponentInstances())
			{
				if (child.getName().equals(ne.getName()))
				{
					found = true;
					current = child;
					break;
				}
			}
			if (!found)
			{
				return null;
			}
		}
		
		return current;
	}	
}
