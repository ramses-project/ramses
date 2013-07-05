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

package fr.tpt.aadl.ramses.generation.target.specific;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.LinkedHashSet;
import java.util.List ;
import java.util.Set ;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.CallSpecification ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.MemorySubcomponent ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.Subprogram;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.DimensionException ;
import fr.tpt.aadl.utils.PropertyUtils ;
import fr.tpt.aadl.utils.names.DataModelProperties ;

public class GeneratorUtils
{

  @SuppressWarnings("unused")
  public static String getInitialValue(Element e)
  {
    StringBuilder initialization = new StringBuilder() ;

    if(e instanceof Data)
    {
      Data d = (Data) e ;
      TypeHolder dataTypeHolder ;

      try
      {
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
              setInitialization(initialization, PropertyUtils
                                      .getPropertyExpression(pa)) ;
              return initialization.toString() ;
            }
          }

          return getInitialValue(ds.getClassifier()) ;
        }
        else if(d instanceof DataClassifier)
        {
          DataClassifier dc = (DataClassifier) d ;
          EList<PropertyExpression> initialValueProperty =
                PropertyUtils
                      .getPropertyExpression(dc,
                                             DataModelProperties.INITIAL_VALUE) ;
          setInitialization(initialization, initialValueProperty) ;
          return initialization.toString() ;
        }

        dataTypeHolder = AadlBaUtils.getTypeHolder(d) ;
      }
      catch(DimensionException exp)
      {
        // TODO Auto-generated catch block
        exp.printStackTrace() ;
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
          PropertyUtils.findProperty("Actual_Processor_Binding",
                                     aProcessSubcomponent) ;

    if(aPropertyAssociation == null)
    {
    	System.out.println("ERROR: Actual_Processor_Binding property not set for component instance "+
    			aProcessSubcomponent.getName());
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

  public static List<ProcessSubcomponent> getBindedProcesses(
                                                   ProcessorSubcomponent object)
  {
    List<ProcessSubcomponent> bindedProcess =
          new ArrayList<ProcessSubcomponent>() ;
    SystemImplementation si = (SystemImplementation) object.eContainer() ;

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

  public static Set<String> getListOfReferencedObjects(ProcessImplementation aProcessImplementation)
  {
    Set<String> result = new LinkedHashSet<String>() ;
    for(ThreadSubcomponent aTheadSubcomponent : aProcessImplementation
          .getOwnedThreadSubcomponents())
    {
      if(aTheadSubcomponent.getComponentImplementation() != null)
      {
        getListOfReferencedObjects((ThreadImplementation) aTheadSubcomponent
                                         .getComponentImplementation(), result) ;
      }
      else
      {
        /*
         *  TODO: throw exception, the thread component instance should reference
         *  a thread implementation to call user operations
         */
      }
    }

    return result ;
  }

  public static void getListOfReferencedObjects(
                                     ThreadImplementation aThreadImplementation,
                                     Set<String> result)
  {
	for(SubprogramCallSequence aCallSequence : aThreadImplementation
          .getOwnedSubprogramCallSequences())
    {
      for(CallSpecification aCallSpecification : aCallSequence
            .getOwnedCallSpecifications())
      {
        getListOfReferencedObjects(aCallSpecification, result) ;
      }
    }
    for(SubprogramSubcomponent sc:aThreadImplementation.getOwnedSubprogramSubcomponents())
    {
    	getListOfReferencedObjects(sc, result) ;
    }
  }

  private static void getListOfReferencedObjects(SubprogramSubcomponent sc,
		Set<String> result) {
	SubprogramSubcomponentType sst = sc.getSubprogramSubcomponentType();
	for(PropertyAssociation aPropertyAssociation : sst
            .getOwnedPropertyAssociations())
    {
       getListOfReferencedObjects(aPropertyAssociation, result) ;
    }
	if (sst instanceof SubprogramImplementation)
	{
		SubprogramImplementation si = (SubprogramImplementation) sst;
		for(PropertyAssociation aPropertyAssociation : si.getType()
	            .getOwnedPropertyAssociations())
	    {
	       getListOfReferencedObjects(aPropertyAssociation, result) ;
	    }
	}
	
}

public static void getListOfReferencedObjects(CallSpecification aCallSpecification,
                                                Set<String> result)
  {
    if(aCallSpecification instanceof SubprogramCall)
    {
      SubprogramCall sc = (SubprogramCall) aCallSpecification;
      getListOfReferencedObjects((Subprogram) sc.getCalledSubprogram(), result) ;
    }
  }

  public static void getListOfReferencedObjects(Subprogram aSubprogram,
      Set<String> result)
  {
  	if(aSubprogram instanceof SubprogramType)
    {
      SubprogramType aSubprogramType =
            (SubprogramType) aSubprogram ;

      for(AnnexSubclause annex: aSubprogramType.getAllAnnexSubclauses())
      {
      	if(annex instanceof BehaviorAnnex)
      	{
      		BehaviorAnnex ba = (BehaviorAnnex) annex;
      		getListOfReferencedObjects(ba,
              	result);
      	}
      }
      for(PropertyAssociation aPropertyAssociation : aSubprogramType
            .getOwnedPropertyAssociations())
      {
        getListOfReferencedObjects(aPropertyAssociation, result) ;
      }
    }
    else if(aSubprogram instanceof SubprogramImplementation)
    {
      SubprogramImplementation aSubprogramImplementation =
            (SubprogramImplementation) aSubprogram ;

      for(AnnexSubclause annex: aSubprogramImplementation.getAllAnnexSubclauses())
      {
      	if(annex instanceof BehaviorAnnex)
      	{
      		BehaviorAnnex ba = (BehaviorAnnex) annex;
      		getListOfReferencedObjects(ba,
              	result);
      	}
      }
      for(PropertyAssociation aPropertyAssociation : aSubprogramImplementation
            .getOwnedPropertyAssociations())
      {
        getListOfReferencedObjects(aPropertyAssociation, result) ;
      }

      for(CallSpecification aCallSpecification : aSubprogramImplementation
            .getCallSpecifications())
      {
        getListOfReferencedObjects(aCallSpecification, result) ;
      }
    }
  }
  
  private static void getListOfReferencedObjects(BehaviorAnnex ba,
			Set<String> result)
	{
		for(BehaviorActionBlock bab: ba.getActions())
		{
			Iterator<EObject> iter = bab.eAllContents();
			while(iter.hasNext())
			{
				EObject next = iter.next();
				if(next instanceof SubprogramCallAction)
				{
					SubprogramCallAction sca = (SubprogramCallAction) next;
					getListOfReferencedObjects((Subprogram) sca.getSubprogram().getElement(), result);
				}
			}
		}
	}

	public static void getListOfReferencedObjects(PropertyAssociation aPropertyAssociation,
                                                Set<String> result)
  {
    if(aPropertyAssociation.getProperty().getName() != null &&
          (aPropertyAssociation.getProperty().getName()
                .equals("Source_Location")
                ||
                aPropertyAssociation.getProperty().getName()
                .equals("Source_Text"))
                )
    {
      for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
            .getOwnedValues())
      {
    	PropertyExpression aPE = aModalPropertyValue.getOwnedValue();
    	if(aPE instanceof StringLiteral)
    	{
    	  StringLiteral sl = (StringLiteral) aPE;
    	  String value = sl.getValue();
    	  if(value.endsWith(".c") || value.endsWith(".o"))
    	  {
    		value = value.substring(0,value.length()-2);  
    		value = value.concat(".o");
    	  }
    	  else
      	    continue;
    	  result.add(value);
    	}
    	else if(aPE instanceof ListValue)
    	{
    	  for(PropertyExpression pe: ((ListValue) aPE).getOwnedListElements())
    	  {
    		StringLiteral sl = (StringLiteral) pe;
        	String value = sl.getValue();
        	if(value.endsWith(".c") || value.endsWith(".o"))
      	  	{
      		  value = value.substring(0,value.length()-2);  
      		  value = value.concat(".o");
      	    }
        	else
        	  continue;
        	result.add(value) ;
    	  }
        }
      }
    }
  }

  private static void setInitialization(StringBuilder initialization,
                                        List<PropertyExpression> initialValues)
  {
    for(PropertyExpression pe : initialValues)
    {
      if(pe instanceof ListValue)
      {
        ListValue lv = (ListValue) pe ;
        List<PropertyExpression> initValueList = lv.getOwnedListElements() ;

        if(initValueList.size() > 0)
        {
          initialization.append(" = ") ;
        }

        if(initValueList.size() > 1)
        {
          initialization.append("{") ;
        }

        Iterator<PropertyExpression> it = initValueList.iterator() ;

        while(it.hasNext())
        {
          PropertyExpression initValue = it.next() ;

          if(initValue instanceof StringLiteral)
          {
            StringLiteral sl = (StringLiteral) initValue ;
            initialization.append(sl.getValue()) ;

            if(it.hasNext())
            {
              initialization.append(",") ;
            }
          }
        }

        if(initValueList.size() > 1)
        {
          initialization.append("}") ;
        }
      }
    }
  }
  
  public static Subcomponent getDeloymentMemorySubcomponent(
                                       ProcessSubcomponent aProcessSubcomponent)
  {
    PropertyAssociation aPropertyAssociation =
          PropertyUtils.findProperty("Actual_Memory_Binding",
                                     aProcessSubcomponent) ;

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
               rv.getContainmentPathElements().get(rv.getContainmentPathElements().
                                                   size()-1).getNamedElement() ;

          if(anElement instanceof MemorySubcomponent)
          {
            MemorySubcomponent ms = 
                (MemorySubcomponent) anElement;
            return ms;
          }
        }
      }
    }
  }

  return null ;
  }
}
