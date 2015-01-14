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

package fr.tpt.aadl.ramses.generation.utils;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AccessCategory ;
import org.osate.aadl2.AccessConnection ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ConnectedElement ;
import org.osate.aadl2.Connection ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.DataRepresentation ;
import org.osate.ba.analyzers.TypeHolder ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.DimensionException ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.PropertyUtils ;
import org.osate.utils.names.DataModelProperties ;

import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.util.math.LeastCommonMultiple ;
import fr.tpt.aadl.ramses.util.properties.AadlUtil ;


public class GeneratorUtils
{
  private static Logger _LOGGER = Logger.getLogger(GeneratorUtils.class) ;
  
  public static String getInitialValue(NamedElement e, String language)
  {
    StringBuilder initialization = new StringBuilder() ;

    if(e instanceof Data)
    {
      Data d = (Data) e ;
      if(d instanceof DataSubcomponent)
      {
        DataSubcomponent ds = (DataSubcomponent) d ;
        for(PropertyAssociation pa : ds.getOwnedPropertyAssociations())
        {
          Property p = pa.getProperty() ;

          // Sometime, properties don't have name.
          if(p.getName() != null &&
              p.getName()
              .equalsIgnoreCase(DataModelProperties.INITIAL_VALUE))
          {
            setInitialization(ds, initialization, PropertyUtils
                              .getPropertyExpression(pa), language) ;
            return initialization.toString() ;
          }
        }

        return getInitialValue(ds.getClassifier(), language) ;
      }
      else if(d instanceof DataClassifier)
      {
        DataClassifier dc = (DataClassifier) d ;
        EList<PropertyExpression> initialValueProperty =
            PropertyUtils
            .findPropertyExpression(dc,
                                   DataModelProperties.INITIAL_VALUE) ;
        setInitialization(dc, initialization, initialValueProperty, language) ;
        return initialization.toString() ;
      }
    }
    else if(e instanceof Port)
    {
    
    }
    else if(e instanceof Parameter)
    {
    
    }
    return initialization.toString() ;
  }

  public static Subcomponent getDeloymentProcessorSubcomponentName(
                                       ProcessSubcomponent aProcessSubcomponent)
  {
    PropertyAssociation aPropertyAssociation =
          PropertyUtils.findPropertyAssociation("Actual_Processor_Binding",
                                     aProcessSubcomponent) ;

    if(aPropertyAssociation == null)
    {
      String errMsg = "Actual_Processor_Binding property not set for component instance "+
            aProcessSubcomponent.getName() ;
      _LOGGER.error(errMsg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
    	return null;
    }
    
    for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
          .getOwnedValues())
    {
      if(aModalPropertyValue.getOwnedValue() instanceof ListValue)
      {
        ListValue list = (ListValue) aModalPropertyValue.getOwnedValue() ;

        for(PropertyExpression pe : list.getOwnedListElements())
        {
          if(pe instanceof ReferenceValue)
          {
            ReferenceValue rv = (ReferenceValue) pe ;
            NamedElement anElement =
                  rv.getContainmentPathElements().get(0).getNamedElement() ;

            if(anElement instanceof ProcessorSubcomponent)
            {
              ProcessorSubcomponent ps = (ProcessorSubcomponent) anElement ;
              return ps ;
            }
            else if(anElement instanceof VirtualProcessorSubcomponent)
            {
              VirtualProcessorSubcomponent vps =
                    (VirtualProcessorSubcomponent) anElement ;
              return vps ;
            }
          }
        }
      }
    }

    return null ;
  }

  public static List<ProcessSubcomponent> getBindedProcesses(ProcessorSubcomponent object)
  {
    List<ProcessSubcomponent> bindedProcess = new ArrayList<ProcessSubcomponent>() ;
    SystemImplementation si = (SystemImplementation) object.eContainer();
    for(ProcessSubcomponent ps : si.getOwnedProcessSubcomponents())
    {
      if(getDeloymentProcessorSubcomponentName(ps)
          .equals(object))
      {
        bindedProcess.add(ps) ;
      }
    }
    
    return bindedProcess ;
  }

  private static void setInitialization(NamedElement obj,
		  								                  StringBuilder initialization,
                                        List<PropertyExpression> initialValues,
                                        String language)
  {
    boolean isStringType = false;
    DataClassifier dc;
    if(obj instanceof DataSubcomponent)
    {
      DataSubcomponent ds = (DataSubcomponent) obj;
      dc = (DataClassifier) ds.getDataSubcomponentType();
    }
    else
      dc=(DataClassifier) obj;
    
    try
    {
      TypeHolder dataTypeHolder = AadlBaUtils.getTypeHolder(dc);
      isStringType=dataTypeHolder.dataRep.equals(DataRepresentation.STRING);
    }
    catch(DimensionException ex)
    {
      String errMsg = "fail to fetch the initial value of " +  obj.getName();
      _LOGGER.error(errMsg, ex);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
    }

    for(PropertyExpression pe : initialValues)
    {
      if(pe instanceof ListValue)
      {
        ListValue lv = (ListValue) pe ;
        List<PropertyExpression> initValueList = lv.getOwnedListElements() ;

        if(initValueList.size() > 0)
        {
          if(language.equals("ada"))
            initialization.append(" := ") ;
          else
            initialization.append(" = ") ;
        }

        if(isStringType && false==initialization.toString().startsWith("\""))
          initialization.append("\"");
        
        if(initValueList.size() > 1)
        {
          if(language.equals("ada"))
        	  initialization.append("(") ;
          else
        	  initialization.append("{") ;
        }

        Iterator<PropertyExpression> it = initValueList.iterator() ;

        while(it.hasNext())
        {
          PropertyExpression initValue = it.next() ;

          if(initValue instanceof StringLiteral)
          {
            StringLiteral sl = (StringLiteral) initValue ;
            if (language.equalsIgnoreCase("java"))
            {
            	if (obj instanceof DataClassifier)
            	{
		          	if (AadlBaUtils.getDataRepresentation((DataClassifier)obj) == DataRepresentation.ENUM)	
		          	{
		              initialization.append(obj.getQualifiedName() +
		                                    "INSERTDOTHERE");
		          	}
            	}
            }
            initialization.append(sl.getValue()) ;

            if(it.hasNext())
            {
              initialization.append(",") ;
            }
          }
        }

        if(initValueList.size() > 1)
        {
          if(language.equals("ada"))
            initialization.append(")") ;
          else
          	initialization.append("}") ;
        }
        if(isStringType && false==initialization.toString().endsWith("\""))
          initialization.append("\"");

      }
    }
  }
  
  public static NamedElement getDeloymentMemorySubcomponent(NamedElement aProcessSubcomponent)
  {
    // aProcessSubcomponent could be a of class ComponentInstance as well
    PropertyAssociation aPropertyAssociation =
          PropertyUtils.findPropertyAssociation("Actual_Memory_Binding",
                                     aProcessSubcomponent) ;

    if(aPropertyAssociation != null)
    {
      for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation.
                                                               getOwnedValues())
      {
        if(aModalPropertyValue.getOwnedValue() instanceof ListValue)
        {
          ListValue list = (ListValue) aModalPropertyValue.getOwnedValue() ;

          for(PropertyExpression pe : list.getOwnedListElements())
          {
            if(pe instanceof ReferenceValue)
            {
              ReferenceValue rv = (ReferenceValue) pe ;
              NamedElement anElement =
                                       rv.getContainmentPathElements()
                                         .get(rv.getContainmentPathElements()
                                                .size() - 1).getNamedElement() ;

              return anElement;
            }
          }
        }
      }
    }

    return null ;
  }
  
  //Builds the data access mapping via the connections described in the
  // process implementation.
  public static void buildDataAccessMapping(ComponentImplementation cptImpl,
                                            Map<DataAccess, String> _dataAccessMapping)
  {
    
    EList<Subcomponent> subcmpts = cptImpl.getAllSubcomponents() ;
    
    List<String> dataSubcomponentNames = new ArrayList<String>() ;
    
    // Fetches data subcomponent names.
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent)
      {
        dataSubcomponentNames.add(s.getName()) ;
      }
    }
    
    // Binds data subcomponent names with DataAcess objects
    // of threads.
    // See process implementation's connections.
    for(Connection connect : cptImpl.getAllConnections())
    {
      if (connect instanceof AccessConnection &&
         ((AccessConnection) connect).getAccessCategory() == AccessCategory.DATA)
      {

      if(connect.getAllDestination() instanceof DataSubcomponent)
      {
        DataSubcomponent destination =  (DataSubcomponent) connect.
                                                       getAllDestination() ;
        
          if(Aadl2Utils.contains(destination.getName(), dataSubcomponentNames))
          {
            ConnectedElement source = (ConnectedElement) connect.getSource() ;
            DataAccess da = (DataAccess) source.getConnectionEnd() ;
            _dataAccessMapping.put(da, destination.getName()) ; 
          }
      }
        else if(connect.getAllSource() instanceof DataSubcomponent)
        {
          DataSubcomponent source =  (DataSubcomponent) connect.
              getAllSource() ;
          if(Aadl2Utils.contains(source.getName(), dataSubcomponentNames))
          {
            ConnectedElement dest = (ConnectedElement) connect.getDestination() ;
             
            DataAccess da = (DataAccess) dest.getConnectionEnd() ;
            _dataAccessMapping.put(da, source.getName()) ;
          }
        }
        else if(connect.getAllDestination() instanceof DataAccess
            && connect.getAllSource() instanceof DataAccess)
        {
          if(!(connect.getAllDestination().eContainer() instanceof Thread)
            && !(connect.getAllSource().eContainer() instanceof Thread))
            continue;
          DataAccess destination = (DataAccess) connect.getAllDestination();
          DataAccess source = (DataAccess) connect.getAllSource();
          if(_dataAccessMapping.containsKey(destination) &&
              !_dataAccessMapping.containsKey(source))
            _dataAccessMapping.put(source, _dataAccessMapping.get(destination)) ;
          if(_dataAccessMapping.containsKey(source) &&
              !_dataAccessMapping.containsKey(destination))
            _dataAccessMapping.put(destination, _dataAccessMapping.get(source)) ;
          
        }
      }
    }
  }
  
  public static long getHyperperiod(List<ComponentInstance> consideredTasks)
  {
    Long[] periods = new Long[consideredTasks.size()];
    ArrayList<Long> consideredPeriods = new ArrayList<Long>();
    for(ComponentInstance ci : consideredTasks)
    {
      consideredPeriods.add(AadlUtil.getInfoTaskPeriod(ci));
    }
    consideredPeriods.toArray(periods);
    return LeastCommonMultiple.lcm(periods);
  }
}