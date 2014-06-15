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

package fr.tpt.aadl.ramses.control.cli.instantiation.manager ;

import java.io.File ;
import java.io.FilenameFilter ;
import java.util.ArrayList ;
import java.util.Arrays ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyConstant ;
import org.osate.aadl2.PropertySet ;

import fr.tpt.aadl.ramses.control.cli.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.utils.AADLFileFilter ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public class PredefinedPropertiesManager
{

  private static List<String> expectedPropertySet = new ArrayList<String>() ;
  private static Map<String, Resource> predefinedPropertySets =
        new HashMap<String, Resource>() ;

  private static String[] names =
  {"AADL_Project", "Communication_Properties", "Data_Model",
   "Deployment_Properties", "Memory_Properties", "Modeling_Properties",
   "Programming_Properties", "Thread_Properties", "Timing_Properties",
   "Scheduler_Constants", "Generation_Properties", "pok_properties",
   "oseknxt_properties", "osek_properties", "RAMSES", "AI",
   "Maintainability_Properties"} ;
  
  private StandAloneInstantiator _instanciator ;
  
  public PredefinedPropertiesManager(StandAloneInstantiator instantiator)
  {
    _instanciator = instantiator ;
    for (int i=0; i<names.length; i++)
      expectedPropertySet.add(names[i]) ; // Added by Arnaud
  }
  
  public Map<String, Resource> parsePredefinedPropertySets() throws ParseException
  {
    File propertyDir = new File(RamsesConfiguration.getPredefinedResourceDir() + File.separator + Names.AADL_PREDEFINED_PROPERTIES_DIR_NAME) ;
    FilenameFilter filter = new AADLFileFilter() ;
    List<File> propertySetFiles =
          Arrays.asList(propertyDir.listFiles(filter)) ;
    List<Resource> propertySetResources = _instanciator.parse(propertySetFiles, false) ;

    for(String resourceName : expectedPropertySet)
    {
      for(Resource r : propertySetResources)
      {
        String fileName = r.getURI().lastSegment() ;

        if(fileName.equalsIgnoreCase(resourceName + ".aadl2")||
        		fileName.equalsIgnoreCase(resourceName + ".aadl"))
        {
          predefinedPropertySets.put(resourceName, r) ;
          break ;
        }
      }
    }

    return predefinedPropertySets ;
  }

  public Map<String, Resource> extractStandardPropertySets(List<Resource> aadlModels)
  {
    List<Resource> removable = new ArrayList<Resource>() ;

    for(Resource r : aadlModels)
    {
      if(r.getContents().get(0) instanceof PropertySet)
      {
        String propertySetName =
              ((PropertySet) r.getContents().get(0)).getName() ;

        if(expectedPropertySet.contains(propertySetName))
        {
          predefinedPropertySets.put(propertySetName, r) ;
          removable.add(r) ;
        }
      }
      else
      {
        continue ;
      }
    }

    for(Resource toRemove : removable)
    {
      aadlModels.remove(toRemove) ;
    }

    return predefinedPropertySets ;
  }

  
  public static PropertyConstant getPropertyConstantDefinition(String PropertySetName,
                                               String PropertyName)
  {
    Resource r = predefinedPropertySets.get(PropertySetName) ;
    TreeIterator<EObject> it = r.getAllContents() ;

    while(it.hasNext())
    {
      EObject elt = it.next() ;
      if(elt instanceof PropertyConstant)
      {
        PropertyConstant p = (PropertyConstant) elt ;
        if(p.getName().equalsIgnoreCase(PropertyName))
        {
          return p;
        }
      }
    }
    return null;
  }
    
  public static Property getPropertyDefinition(String PropertySetName,
                            String PropertyName)
  {
	  Resource r = predefinedPropertySets.get(PropertySetName) ;
	  TreeIterator<EObject> it = r.getAllContents() ;

	  while(it.hasNext())
	  {
		  EObject elt = it.next() ;
		  if(elt instanceof Property)
		  {
			  Property p = (Property) elt ;

			  if(p.getName().equalsIgnoreCase(PropertyName))
			  {
				  return p;
			  }
		  }
	  }
	  return null;
  }
                            
  public static String getDefaultStringValue(String PropertySetName,
                                             String PropertyName)
  {
    Property p = getPropertyDefinition(PropertySetName, PropertyName);
    if(p.getDefaultValue() != null &&
    		p.getDefaultValue() instanceof NamedValue)
    {
    	NamedValue nv = (NamedValue) p.getDefaultValue() ;
    	if(nv.getNamedValue() instanceof EnumerationLiteral)
    	{
    		EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
    		return el.getName();
    	}
    }
    return null;
  }
  
  public int getPropertiesCount()
  {
    return predefinedPropertySets.size() ;
  }

  public String getPropertySetName(int p)
  {
    return names[p] ;
  }

  public Resource getPropertySetResource(String name)
  {
    return predefinedPropertySets.get(name);
  }
}