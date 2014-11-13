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

package fr.tpt.aadl.ramses.control.atl.hooks.impl ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.impl.EObjectImpl ;
import org.eclipse.xtext.EcoreUtil2 ;
import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.DirectedFeature ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.instance.InstanceObject ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.parsesupport.LocationReference ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.PortCountValue ;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.communication.dimensioning.DimensioningException ;
import fr.tpt.aadl.ramses.communication.periodic.delayed.EventDataPortCommunicationDimensioning ;
import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage ;
import fr.tpt.aadl.ramses.control.atl.hooks.HookAccess ;
import fr.tpt.aadl.ramses.control.atl.hooks.utils.ComparablePortByCriticality ;
import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.util.math.LeastCommonMultiple ;
import fr.tpt.aadl.ramses.util.properties.AadlUtil ;

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

  private String outputPackageName;
  
  private static Logger _LOGGER = Logger.getLogger(HookAccessImpl.class);
  
  private static final String _ENUMERATORS = "Enumerators" ;

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
   */
  public void putTransitionWhereSrc(BehaviorState state, BehaviorTransition transition)
  {
    AadlBaVisitors.putTransitionWhereSrc(state,transition);
  }

  
  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<Long> getCurrentPerionReadTable(FeatureInstance port) {
		EList<Long> CPRTable = new BasicEList<Long>();
		try {
			EventDataPortCommunicationDimensioning EDPCD = 
					EventDataPortCommunicationDimensioning.create(port);
			
			String CPRString = "";
			long CPRSize = EDPCD.getCPRSize();
			_LOGGER.trace("CPRSize "+CPRSize);
			for(int iteration=0;iteration<CPRSize;iteration++)
			{
				long CPR_iteration = EDPCD.getCurrentPeriodReadIndex(iteration);
				CPRString = CPRString + String.valueOf(CPR_iteration);
				if(iteration<CPRSize-1)
					CPRString = CPRString + ", ";
				CPRTable.add(CPR_iteration);
			}
			_LOGGER.trace("CPR Table "+CPRString);
		} catch (DimensioningException e)
		{
		  String errMsg =  RamsesException.formatRethrowMessage("cannot get current period on read table for \'"+
		port + '\'', e) ;
      _LOGGER.error(errMsg, e);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
		}
		return CPRTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public long getHyperperiod(FeatureInstance port) {
	  Long hyperperiod= new Long(0);
	  ArrayList<ComponentInstance> threads = new ArrayList<ComponentInstance>();
	  for(ConnectionInstance fi: port.getDstConnectionInstances())
	  {
	    threads.add((ComponentInstance) fi.getSource().eContainer());
	  }
	  threads.add((ComponentInstance) port.eContainer());
	  hyperperiod = getHyperperiod(threads);
	  return hyperperiod;
	}
	
	public Long getHyperperiodFromThreads(List<ComponentInstance> consideredTasks)
	{
	  return getHyperperiod(consideredTasks);
	}
	
	public long getHyperperiod(List<ComponentInstance> consideredTasks)
	{
	  Long[] periods = new Long[consideredTasks.size()];
	  ArrayList<Long> consideredPeriods = new ArrayList<Long>();
	  for(ComponentInstance ci : consideredTasks)
	  {
	    consideredPeriods.add( AadlUtil.getInfoTaskPeriod(ci));
	  }
	  consideredPeriods.toArray(periods);
	  return LeastCommonMultiple.lcm(periods);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<Long> getCurrentDeadlineWriteTable(FeatureInstance port, FeatureInstance destinationPort) {
		EList<Long> CDWTable = new BasicEList<Long>();
		try {
			EventDataPortCommunicationDimensioning EDPCD = 
					EventDataPortCommunicationDimensioning.create(destinationPort);
			_LOGGER.trace(port.getInstanceObjectPath());
			long CDWSize = EDPCD.getCDWSize(port);
			_LOGGER.trace("CDWSize " + CDWSize);
			String CDWString = "";
			for(int iteration=0;iteration<CDWSize;iteration++)
			{
				long CDW_iteration = EDPCD.getCurrentDeadlineWriteIndex(port, iteration);
				CDWString = CDWString + String.valueOf(CDW_iteration);
				if(iteration < CDWSize-1)
					CDWString = CDWString + ", ";
				CDWTable.add(CDW_iteration);
			}
			_LOGGER.trace("CDW Table "+CDWString);
		} catch (DimensioningException e) {
		  String errMsg =  RamsesException.formatRethrowMessage("cannot get current dead line for \'"+
		      port + '\'', e) ;
		        _LOGGER.error(errMsg, e);
		        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
		}
		return CDWTable;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public long getBufferSize(FeatureInstance destinationFeatureInstance) {
		try {
			EventDataPortCommunicationDimensioning EDPCD =
					EventDataPortCommunicationDimensioning.create(destinationFeatureInstance);
			long size = EDPCD.getBufferSize();
			_LOGGER.trace("Buffer size " + size);
			return size;
		} catch (DimensioningException e) {
		  String errMsg =  RamsesException.formatRethrowMessage("cannot get the buffer size for \'"+
		      destinationFeatureInstance + '\'', e) ;
		        _LOGGER.error(errMsg, e);
		        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
		}
		return 0;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setDirection(DirectedFeature feature, String direction) {
		if(direction.equals("in"))
		{
		  feature.setIn(true);
		  feature.setOut(false);
		}
		else if(direction.equals("out"))
		{
		  feature.setIn(false);
      feature.setOut(true);
		}
		else
		{
		  feature.setIn(true);
      feature.setOut(true);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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

  public boolean isUsedInSpecialOperator(BehaviorAnnex ba, Port p, String operatorName) {
    if(operatorName.equalsIgnoreCase("fresh"))
      return AadlBaVisitors.isFresh(ba, p);
    else if(operatorName.equalsIgnoreCase("count"))
    {
      for(PortCountValue pcv : EcoreUtil2.getAllContentsOfType(ba, PortCountValue.class))
      {
        if(pcv.getElement().equals(p))
          return true;
      }
    }
    return false;
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
  
  public String getOutputPackageName()
  {
	return outputPackageName;
  }
  
  public void setOutputPackageName(String param)
  {
	outputPackageName = param;
  }
  
  public String getTimingPrecision(NamedElement ne)
  {
	return AadlUtil.getPrecision(ne);
  }
  
  public long getFloor(Double d)
  {
	return d.longValue();
  }
  
  public long getCeil(Double d)
  {
	Double res = Math.ceil(d);
	return res.longValue();
  }
  
  public Object log(String msg, Object o)
  {
	if(o instanceof NamedElement)
	{
	  NamedElement ne = (NamedElement) o;
	  _LOGGER.trace("\t"+ne.getFullName()+": "+ msg);
	}
	else if(o instanceof Boolean)
	{
	  Boolean b = (Boolean) o;
	  _LOGGER.trace("\t"+b.toString()+": "+ msg);
	}
	else if(o!=null)
	  _LOGGER.trace("\t"+o.toString()+": "+ msg);
	else
	  _LOGGER.trace("\t NULL: "+ msg);
	return o;
  }
  
  private List<ComponentInstance> cpuToIgnore;
    
  public List<ComponentInstance> getCpuToIgnore()
  {
    return cpuToIgnore;
  }
   
  public void resetCpuToIgnore(List<ComponentInstance> cpuList)
  {
    cpuToIgnore = cpuList;
  }
  
  public boolean deployedOnIgnoredCpu(ComponentInstance c) throws AnalysisException
  {
    if(c instanceof SystemInstance)
      return false;
    if(c.getContainingComponentImpl()==null)
      return false; // workaround bug in osate
    List<ComponentInstance> execUnit =
    		PropertyUtils
    		.getComponentInstanceList(c,
    				"Actual_Processor_Binding") ;
    if(execUnit.size()==1)
    {
      ComponentInstance exec = execUnit.get(0);
      if(isContainedBy(cpuToIgnore, exec))
    	return true;
    }
    else
      throw new AnalysisException("Thread instance "+c.getName()+
    		  " is deployed on several execution units (processor or " +
    		  "virtual processo components)");
    return false;
  }

  private boolean isContainedBy(List<ComponentInstance> cpuToIgnore,
		  ComponentInstance execUnit) 
  {
	if(cpuToIgnore.contains(execUnit))
	  return true;
	else
	  if(execUnit.eContainer()==null || execUnit.eContainer() instanceof SystemInstance)
		return false;
	  else
		return isContainedBy(cpuToIgnore, (ComponentInstance) execUnit.eContainer());
  }

  
  public EList<String> getListOfPath(PropertyAssociation pa)
  {
    List<String> res = new BasicEList<String>();
    ListValue lv = (ListValue) pa.getOwnedValues().get(0).getOwnedValue();
    URI dirURI = pa.eResource().getURI();
    String path = "";
    if(dirURI.isFile())
      path = dirURI.toFileString();
    else
      path = dirURI.toString();
    int index = path.lastIndexOf(File.separator);
    path = path.substring(0, index+1);
    
    for(PropertyExpression pe: lv.getOwnedListElements())
    {
      StringLiteral sl = (StringLiteral) pe;
      String fileName = sl.getValue();
      File f = new File(fileName);
      if(f.exists())
        res.add(fileName);
      else
      {
        File prefixedF = new File(path+fileName);
        if(prefixedF.exists())
          res.add(path+fileName);
      }
    }
    return (EList<String>) res;
  }

  public Integer minus (Long lhs, Long rhs)
  {
    return (int) (lhs-rhs);
  }
  
  void allPortCount(List<PortCountValue> result, EObject e)
  {
    if(e instanceof BehaviorTransition)
    {
      BehaviorTransition bt = (BehaviorTransition) e;
      allPortCount(result, bt.getActionBlock());
    }
    for(EObject be : EcoreUtil2.getAllContentsOfType(e, EObject.class))
    {
      if(be instanceof PortCountValue)
        result.add((PortCountValue) be);
      else
        allPortCount(result, be);
    }
  }
  
  public EList<Port> allPortCount(BehaviorElement e)
  {
    List<PortCountValue> pcvList =  new ArrayList<PortCountValue>();
    allPortCount(pcvList, e);
    
    Set<Port> pList = new HashSet<Port>();
    for(PortCountValue pcv: pcvList)
    {
      pList.add((Port) pcv.getElement());
    }
    EList<Port> res = new BasicEList<Port>(pList);
    return res;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  public StringLiteral getStringLiteral(PropertyAssociation pa,
                                        String stringLiteralValue)
  {
    Element el = null ;
    EList<PropertyExpression> pes = PropertyUtils.getPropertyExpression(pa) ;
    for(PropertyExpression pe : pes)
    {
      el = PropertyUtils.getValue(pe, stringLiteralValue) ;
    
      if(el != null)
      {
        return (StringLiteral) el ;
      }
    }
    
    return null ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  public PropertyAssociation getEnumerators(Classifier classifier)
  {
    return PropertyUtils.findPropertyAssociation(_ENUMERATORS, classifier);
  }
} //HookAccessImpl