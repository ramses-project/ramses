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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.transformation.atl.hooks.impl ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.parsesupport.LocationReference;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;
import fr.tpt.aadl.annex.behavior.utils.AadlBaVisitors;
import fr.tpt.aadl.ramses.transformation.atl.ComparablePortByCriticality;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage;
import fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess;
import fr.tpt.aadl.utils.Aadl2Utils;
import fr.tpt.aadl.ramses.communication.dimensioning.DimensioningException;
import fr.tpt.aadl.ramses.communication.periodic.delayed.EventDataPortCommunicationDimensioning;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hook Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class HookAccessImpl extends EObjectImpl implements HookAccess
{

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected HookAccessImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return AtlHooksPackage.Literals.HOOK_ACCESS;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<Feature> orderFeatures(ComponentType cpt)
  {
    EList<Feature> res = new BasicEList<Feature>() ;
    res.addAll(Aadl2Utils.orderFeatures(cpt)) ;
    return res ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void copyLocationReference(Element target,
                                    Element source)
  {
    INode node = NodeModelUtils.findActualNodeFor(source) ;
    int line=-1;
    
    if(node!=null)
    	line = node.getStartLine() ;
    else if(source.getLocationReference() != null)
    {
    	line = source.getLocationReference().getLine();
    }
    
    String filename = source.eResource().getURI().lastSegment() ;
    
    LocationReference lr ;
    
    if(source instanceof BehaviorElement &&
       target instanceof BehaviorElement &&
       source.getLocationReference() != null )
    {
      AadlBaLocationReference src = (AadlBaLocationReference) 
                                                 source.getLocationReference() ;
      lr = src.clone() ;
      lr.setFilename(filename) ;
    }
    else
    {
      lr = new LocationReference(filename, line) ;
    }
    
    target.setLocationReference(lr) ;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
    private static Map<NamedElement, NamedElement> _transformationTrace = new HashMap<NamedElement, NamedElement>();
    
    public void addTransformationBackTrace(NamedElement targetDeclarative, NamedElement sourceInstance) {
      _transformationTrace.put(targetDeclarative, sourceInstance);
    }
  
    public static void cleanupTransformationTrace()
    {
    	_transformationTrace.clear();
    }
    
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void putTransitionWhereSrc(BehaviorState state, BehaviorTransition transition)
  {
    AadlBaVisitors.putTransitionWhereSrc(state, transition);
  }

  
  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Long> getCurrentPerionReadTable(FeatureInstance port) {
		EList<Long> CPRTable = new BasicEList<Long>();
		try {
			EventDataPortCommunicationDimensioning EDPCD = 
					EventDataPortCommunicationDimensioning.create(port);
			
			String CPRString = "";
			long CPRSize = EDPCD.getCPRSize();
			System.out.println("CPRSize "+CPRSize);
			for(int iteration=0;iteration<CPRSize;iteration++)
			{
				long CPR_iteration = EDPCD.getCurrentPeriodReadIndex(iteration);
				CPRString = CPRString + String.valueOf(CPR_iteration);
				if(iteration<CPRSize-1)
					CPRString = CPRString + ", ";
				CPRTable.add(CPR_iteration);
			}
			System.out.println("CPR Table "+CPRString);
		} catch (DimensioningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CPRTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Long getHyperperiod(FeatureInstance port) {
		Long hyperperiod= new Long(0);
		try {
			EventDataPortCommunicationDimensioning EDPCD = 
					EventDataPortCommunicationDimensioning.create(port);
			ArrayList<ComponentInstance> threads = new ArrayList<ComponentInstance>();
			for(ConnectionInstance fi: port.getDstConnectionInstances())
			{
				threads.add((ComponentInstance) fi.getSource().eContainer());
			}
			threads.add((ComponentInstance) port.eContainer());
			hyperperiod = EDPCD.getHyperperiod(threads);
		} catch (DimensioningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hyperperiod;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Long> getCurrentDeadlineWriteTable(FeatureInstance port, FeatureInstance destinationPort) {
		EList<Long> CDWTable = new BasicEList<Long>();
		try {
			EventDataPortCommunicationDimensioning EDPCD = 
					EventDataPortCommunicationDimensioning.create(destinationPort);
			System.out.println(port.getInstanceObjectPath());
			long CDWSize = EDPCD.getCDWSize(port);
			System.out.println("CDWSize " + CDWSize);
			String CDWString = "";
			for(int iteration=0;iteration<CDWSize;iteration++)
			{
				long CDW_iteration = EDPCD.getCurrentDeadlineWriteIndex(port, iteration);
				CDWString = CDWString + String.valueOf(CDW_iteration);
				if(iteration < CDWSize-1)
					CDWString = CDWString + ", ";
				CDWTable.add(CDW_iteration);
			}
			System.out.println("CDW Table "+CDWString);
		} catch (DimensioningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CDWTable;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public long getBufferSize(FeatureInstance destinationFeatureInstance) {
		try {
			EventDataPortCommunicationDimensioning EDPCD =
					EventDataPortCommunicationDimensioning.create(destinationFeatureInstance);
			long size = EDPCD.getBufferSize();
			System.out.println("Buffer size " + size);
			return size;
		} catch (DimensioningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDirection(DirectedFeature feature, String direction) {
		if(direction.equals("in"))
			feature.setDirection(DirectionType.IN);
		else if(direction.equals("out"))
			feature.setDirection(DirectionType.OUT);
		else
			feature.setDirection(DirectionType.IN_OUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public static NamedElement getTransformationTrace(NamedElement targetDeclarative)
  {
	for(NamedElement ne: _transformationTrace.keySet())
	{
	  if(ne.getQualifiedName().equals(targetDeclarative.getQualifiedName()))
		  return _transformationTrace.get(ne);
	}
    return null;
  }
  
  public static List<NamedElement> getTransformationTracesFromSource(InstanceObject sourceInstance)
  {
	  ArrayList<NamedElement> l = new ArrayList<NamedElement>();
	  for(NamedElement e : _transformationTrace.keySet())
	  {
		  if (_transformationTrace.get(e) == sourceInstance)
		  {
			  l.add(e);
		  }
	  }
	  return l;
  }
  
  public static List<NamedElement> getTransformationTracesFromSourceDecl(ComponentImplementation el)
  {
	  ArrayList<NamedElement> l = new ArrayList<NamedElement>();
	  for(NamedElement e : _transformationTrace.keySet())
	  {
		  if (e instanceof SystemImplementation)
			  continue;
		  
		  if (_transformationTrace.get(e) instanceof ComponentInstance )
		  {
			  ComponentInstance c = (ComponentInstance) _transformationTrace.get(e);
			  if ((c.getName()+".impl").equals(el.getName()))
				  l.add(e);
		  }
	  }
	  return l;
  }

  public Boolean isUsedInFreshClause(BehaviorAnnex ba, Port p) {
	return AadlBaVisitors.isFresh(ba, p);
  }
  
  public List<FeatureInstance> getFeaturesOrderedByCriticality(ComponentInstance ci)
  {
	List<FeatureInstance> result = new ArrayList<FeatureInstance>();
	List<ComparablePortByCriticality> cpbcList = new ArrayList<ComparablePortByCriticality>();
	for(FeatureInstance fi: ci.getFeatureInstances())
	{
	  if(fi.getFeature() instanceof Port)
	  {
		ComparablePortByCriticality cpbc = new ComparablePortByCriticality(fi);
		cpbcList.add(cpbc);
	  }
	}
	Collections.sort(cpbcList);
	for(ComparablePortByCriticality iter: cpbcList)
	{
	  result.add(iter.getFeatureInstance());
	}
	return result;
  }
  
  public NamedElement getElement(NamedElement ne)
  {
	  return ne;
  }
} //HookAccessImpl