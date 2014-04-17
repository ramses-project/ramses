/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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
 
 package fr.tpt.aadl.sched.cheddar.strategies ;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;

import org.jdom.Element ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.util.workspace.XMLUtil ;
import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.model.CheddarElement ;

public abstract class CheddarModelConversionPart<E extends CheddarElement>
{
  private static HashMap<ComponentCategory, String> aadlTypeToSectionName ;
  private static HashMap<ComponentCategory, String> aadlTypeToInstanceName ;

  static
  {
    aadlTypeToSectionName = new HashMap<ComponentCategory, String>() ;
    aadlTypeToSectionName.put(ComponentCategory.PROCESSOR, "processors") ;
    aadlTypeToSectionName.put(ComponentCategory.PROCESS, "address_spaces") ;
    aadlTypeToSectionName.put(ComponentCategory.THREAD, "tasks") ;
    aadlTypeToInstanceName = new HashMap<ComponentCategory, String>() ;
    aadlTypeToInstanceName.put(ComponentCategory.PROCESSOR, "processor") ;
    aadlTypeToInstanceName.put(ComponentCategory.PROCESS, "address_space") ;
    aadlTypeToInstanceName.put(ComponentCategory.THREAD, "task") ;
  }

  private ComponentCategory aadlcategory ;
  public final String sectionName ;
  public final String instanceName ;

  private List<ComponentInstance> visitedComponents =
        new ArrayList<ComponentInstance>() ;

  protected static AnalysisErrorReporterManager errManager ;

  protected final CheddarContext sections ;

  private final static Map<ComponentInstance, CheddarElement> mapping =
        new HashMap<ComponentInstance, CheddarElement>() ;

  private List<CheddarElement> currentOutput = null ;

  protected CheddarModelConversionPart(
                                       ComponentCategory aadlcategory,
                                       CheddarContext sections)
  {
    this.aadlcategory = aadlcategory ;
    this.sectionName = aadlTypeToSectionName.get(aadlcategory) ;
    this.instanceName = aadlTypeToInstanceName.get(aadlcategory) ;
    this.sections = sections ;
  }

  public final ComponentCategory getCategory()
  {
    return aadlcategory ;
  }

  public static void setErrManager(AnalysisErrorReporterManager _errManager)
  {
    errManager = _errManager ;
  }

  public static void init()
  {
    mapping.clear() ;
  }

  protected boolean confirmExport(ComponentInstance c)
  {
    return true ;
  }

  /**
   * Export the component section to XML Document
   * @param doc XML document
   * @param root AADL component which owns elements of the section
   */
  public final void export(ComponentInstance root,
                           List<CheddarElement> output)
  {
    currentOutput = output ;

    for(ComponentInstance sub : root.getComponentInstances())
    {
      if(sub.getCategory().getValue() == aadlcategory.getValue())
      {
        if(confirmExport(sub))
        {
          E cheddarElement = addInstanceSubNodes(sub) ;

          if(cheddarElement.getName() == null)
          {
            cheddarElement.setName(sub.getName()) ;
          }

          /*mapping.put(sub, cheddarElement);
          output.add(cheddarElement);*/
          registerElement(sub, cheddarElement) ;
        }
        else
        {
          visitedComponents.add(sub) ;
        }
      }
    }

    endSection(output) ;
    visitedComponents.clear() ;
  }

  protected final void registerElement(ComponentInstance sub,
                                       E cheddarElement)
  {
    mapping.put(sub, cheddarElement) ;
    currentOutput.add(cheddarElement) ;
    visitedComponents.add(sub) ;
  }

  protected static final CheddarElement getMappingOf(ComponentInstance c)
  {
    return mapping.get(c) ;
  }

  protected static final CheddarElement getMappingOf(ComponentImplementation c)
  {
    Iterator<ComponentInstance> itInstances = mapping.keySet().iterator() ;

    while(itInstances.hasNext())
    {
      ComponentInstance ci = itInstances.next() ;

      if(ci.getSubcomponent().getComponentImplementation() == c)
      {
        return getMappingOf(ci) ;
      }
    }

    return null ;
  }

  protected final List<ComponentInstance> getVisitedComponents()
  {
    return Collections.unmodifiableList(visitedComponents) ;
  }

  /**
   * All all sub nodes needed for the specified component instance
   * @param aadlInstance aadl component instance
   * @param xmlInstance aadl component instance (XML)
   */
  protected abstract E addInstanceSubNodes(ComponentInstance aadlInstance) ;

  /** Specify actions which will be perfomed when section will be closed. */
  protected void endSection(List<CheddarElement> output)
  {
  }

  /**
   * Create an enclosed field in the specified xmlNode
   * @param xmlInstance xmlNode
   * @param name field name
   * @param value field value
   */
  protected static final void addEnclosedField(Element xmlInstance,
                                               String name,
                                               String value)
  {
    xmlInstance.addContent(XMLUtil.createEnclosedValue(name, value)) ;
  }

  protected final long getInfoIntegerProperty(ComponentInstance process,
                                              String aadlPropertyName,
                                              long defaultValue)
  {
    Long value = PropertyUtils.getIntValue(process, aadlPropertyName) ;
    if(value == null)
    {
      value = defaultValue ;
    }

    return value ;
  }
}