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

package fr.tpt.aadl.ramses.generation.pokTT;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.UnparseText;

import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;
import fr.tpt.aadl.ramses.util.properties.PropertyUtils;

public class AadlToPokCTTUnparser extends AadlToPokCUnparser
{
	private ArrayList<String> activitiesDecl = new ArrayList<String>();
	private ArrayList<String> portsDecl = new ArrayList<String>();
	
	@Override
	protected void genDeploymentHeaderEnd(UnparseText mainHeaderCode)
	{
		if ((! activitiesDecl.isEmpty()) && (! portsDecl.isEmpty()))
			mainHeaderCode.addOutputNewline("#define POK_NEEDS_TIME_TRIGGERED 1");
	}
	
	@Override
	protected void genMainImplEnd(ProcessImplementation process, 
								  UnparseText mainImplCode)
	{
		for(String s : portsDecl)
		{
			mainImplCode.addOutputNewline("  pok_create_tt_port(" + s + ");");
		}
		portsDecl.clear();
		
		for(String s : activitiesDecl)
		{
			mainImplCode.addOutputNewline("  pok_create_tt_activity (" + s + ");");
		}
		activitiesDecl.clear();
	}

	@Override
	protected void genGlobalVariablesMainOptional(ProcessImplementation process,
			UnparseText mainImplCode)
	{
		ProcessImplementation pi = (ProcessImplementation) getImplementedAs(process);
		
		if (pi == null)
			return;
		
		for(ThreadSubcomponent ts : pi.getOwnedThreadSubcomponents())
		{
			ThreadType tt = (ThreadType) ts.getComponentType();
			ThreadImplementation ti = (ThreadImplementation) ts.getComponentImplementation();
			
			final String tName = ts.getName();
			final String tSourcesName = tName + "_sources";
			final String tDestinationsName = tName + "_destinations";
			final String tNbDestinationsName = tName + "_nb_dests";
			
			final List<Port> in = getPorts(tt, DirectionType.IN);
			
			mainImplCode.addOutput("uint8_t  " + tSourcesName + "["+in.size()+"]={");
			
			
			/** Browse all source ports. */
			String destinationLists = "";
			String destinationList  = "";
			String destinationCountList = "";
			for(int iSourcePort=0;iSourcePort<in.size();iSourcePort++)
			{
				Port source = in.get(iSourcePort);
				List<Port> out = getDestinations(ti, source);
				
				mainImplCode.addOutput(getPortIdentifier(process,source));
				if (iSourcePort<in.size()-1)
					mainImplCode.addOutput(",");
				
				
				
				
				/** Browse all destination ports connected to the source one. */
				
				final String tDestsName = tName + "_destinations_" + getPortIdentifier(process,source);
				String destIdentifierList = "";
				for(int iDestPort=0; iDestPort < out.size();iDestPort++)
				{
					Port dest = out.get(iDestPort);
					final String destID = getPortIdentifier(process,dest);
					
					destIdentifierList = destIdentifierList + destID;
					if (iDestPort < out.size()-1)
						destIdentifierList = destIdentifierList + ",";
				}
				final String tDestDecl = "uint8_t  " + tDestsName + "["+out.size()+"]={"+destIdentifierList+"};";
				destinationLists += tDestDecl + "\n";
				
				destinationList  += tDestsName + ((iSourcePort < in.size()-1) ? "," : "");
				destinationCountList += out.size() + ((iSourcePort < in.size()-1) ? "," : "");
			}
			mainImplCode.addOutputNewline("};");
			mainImplCode.addOutput(destinationLists);
			mainImplCode.addOutputNewline("uint8_t* " + tDestinationsName + "["+in.size()+"]={"+destinationList+"};");
			mainImplCode.addOutputNewline("uint8_t  " + tNbDestinationsName + "["+in.size()+"]={"+destinationCountList+"};");
			mainImplCode.addOutputNewline("");
			
			final int period = getPropertyInt("Period", ts, 0);
			final int offset = getPropertyInt("Dispatch_Offset", ts, 0);
			
			String activityInit = period + "," 
			                       + offset + ","
			                       + "&" + tSourcesName + ","
			                       + in.size() + ","
			                       + "&" + tDestinationsName + ","
			                       + tNbDestinationsName;
			
			activitiesDecl.add(activityInit);
		}
		for(PortConnection co : pi.getOwnedPortConnections())
		{
			ConnectedElement src = (ConnectedElement) co.getSource();
			ConnectedElement dest = (ConnectedElement) co.getDestination();
			if ((src.getContext()!=null) && (dest.getContext() != null))
			{
				Port p = (Port) dest.getConnectionEnd();
				
				final String portID = p.getName() + "_id";
				mainImplCode.addOutputNewline("pok_port_id_t " + portID + ";");
				
				final String portInit = "\"" + p.getName() + "\"" + ","
				                        + "sizeof(int) * " + getPropertyInt("Queue_Size", p, 1) + ","
				                        + "FIFO" + ","
				                        + "&" + portID;
				
				portsDecl.add(portInit);
			}
		}
	}

	private static int getPropertyInt(final String propertyName, NamedElement e, final int defaultValue)
	{
		 try
		    {
		      return (int) PropertyUtils.getIntValue(e, propertyName) ;
		    }
		    catch(Exception ex)
		    {
		      if (e instanceof Subcomponent)
		    	  return getPropertyInt(propertyName, ((Subcomponent)e).getComponentImplementation(),defaultValue);
		      else if (e instanceof ComponentImplementation)
		    	  return getPropertyInt(propertyName, ((ComponentImplementation)e).getType(),defaultValue);
		      else
		    	  //ex.printStackTrace() ;
		      return defaultValue;
		    }
	}

	private static String getPortIdentifier (NamedElement process, Port p)
	{
		return p.getName();
	}
	
	private static List<Port> getPorts(ThreadType tt, DirectionType d)
	{
		ArrayList<Port> l = new ArrayList<Port>();
		for(DataPort dp : tt.getOwnedDataPorts())
		{
			if (dp.getDirection() == d)
				l.add(dp);
		}
		for(EventDataPort dp : tt.getOwnedEventDataPorts())
		{
			if (dp.getDirection() == d)
				l.add(dp);
		}
		return l;
	}
	
	private static List<Port> getDestinations(ThreadImplementation ti, Port source)
	{
		ArrayList<Port> l = new ArrayList<Port>();
		for(PortConnection pc : ti.getOwnedPortConnections())
		{
			ConnectedElement ceSource = (ConnectedElement) pc.getSource();
			if (ceSource.getConnectionEnd() == source)
			{
				ConnectedElement ceDest = (ConnectedElement) pc.getDestination();
				l.add((Port) ceDest.getConnectionEnd());
			}
		}
		return l;
	}
	
	

	private static List<ComponentInstance> getAllBindedProcesses(
			ComponentInstance processor)
	{
		ArrayList<ComponentInstance> processList = new ArrayList<ComponentInstance>();
		SystemInstance s = processor.getSystemInstance();

		for (ComponentInstance c : s.getComponentInstances())
		{
			if (c.getCategory() == ComponentCategory.PROCESS)
			{
				if ((ComponentInstance) getProcessBind(c).getOwner() == processor)
				{
					processList.add(c);
				}
			}
		}

		return processList;
	}

	private static ComponentInstance getProcessBind(ComponentInstance process)
	{
		try
		{
			PropertyExpression val = PropertyUtils.getPropertyValue(
					"Actual_Processor_Binding", process);
			PropertyExpression e = ((ListValue) val).getOwnedListElements()
					.get(0);
			InstanceReferenceValue ref = (InstanceReferenceValue) e;
			InstanceObject owner = ref.getReferencedInstanceObject();
			return (ComponentInstance) owner;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	private static ComponentClassifier getImplementedAs(ProcessImplementation process)
	{
		for(NamedElement ne : HookAccessImpl.getTransformationTracesFromSourceDecl(process))
		{
			if (ne instanceof ProcessImplementation)
				return (ProcessImplementation) ne;
		}
		return null;
	} 
}