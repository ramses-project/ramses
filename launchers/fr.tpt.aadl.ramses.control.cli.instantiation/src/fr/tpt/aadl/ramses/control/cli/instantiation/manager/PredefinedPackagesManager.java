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
import java.util.HashMap ;
import java.util.List ;

import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataType ;

import fr.tpt.aadl.ramses.control.cli.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.utils.AADLFileFilter ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public class PredefinedPackagesManager
{
  private StandAloneInstantiator _instantiator ;

  // File names without their extension.
  private static String[] names =
  {"base_types", "aadl_runtime", "RAVENSCAR_runtime", "OJR_runtime",
   "ARINC653_runtime", "OSEK_runtime", "PeriodicDelayed_runtime",
   "PeriodicDelayedMutex_runtime", "RAMSES_processors",
   "RAMSES_buses", "rtl8029_driver"} ;
  
  private static HashMap<String, Resource> resources = new HashMap<String, Resource>() ;
  
  public PredefinedPackagesManager(StandAloneInstantiator instantiator)
  {
    _instantiator = instantiator ;
  }
  
  public void parsePredefinedPackages() throws ParseException
  {
    if(resources.isEmpty()==false)
      return;
    
    FilenameFilter filter = new AADLFileFilter() ;
    File packageDir = new File (RamsesConfiguration.getPredefinedResourceDir() + File.separator + Names.AADL_PREDEFINED_PACKAGE_DIR_NAME) ;
    
    File[] predefinedPackages = packageDir.listFiles(filter) ;
    List<File> toBeParsed = new ArrayList<File>() ;

    for(int r = 0 ; r < names.length ; r++)
    {
      for(int fIndex = 0 ; fIndex < predefinedPackages.length ; fIndex++)
      {
        StringBuilder matchName =
              new StringBuilder(predefinedPackages[fIndex].getName()) ;
        // Removes file extension.
        int pointIndex = matchName.lastIndexOf(".") ;
        matchName.delete(pointIndex, matchName.length()) ;

        if(names[r].equalsIgnoreCase(matchName.toString()))
        {
          toBeParsed.add(predefinedPackages[fIndex]) ;
          break ;
        }
      }
    }

    List<Resource> parsedResources = _instantiator.parse(toBeParsed, false) ;

    for(Resource r : parsedResources)
    {
      String resourceName = r.getURI().lastSegment() ;
      resourceName = resourceName.substring(0, resourceName.lastIndexOf('.')) ;
      resources.put(resourceName, r) ;
    }
  }
  
  public Resource getRuntimeResource()
  {
    return resources.get("aadl_runtime") ;
  }

  public Resource getBaseTypesResource()
  {
    return resources.get("base_types") ;
  }

  public DataClassifier getRuntimeDataClassifier(String name)
  {
    Resource aadlRuntime = resources.get("aadl_runtime") ;

    for(EObject obj : aadlRuntime.getContents())
    {
      if(obj instanceof DataType)
      {
        DataType dataType = (DataType) obj ;

        if(dataType.getName().equals(name))
        {
          return dataType ;
        }
      }
    }

    return null ;
  }

  public boolean allPackagesFound()
  {
    return resources.size() == names.length ;
  }

  public int getPackagesCount()
  {
    return resources.size() ;
  }

  public String getPackageName(int i)
  {
    return names[i] ;
  }

  public Resource getPackageResource(String name)
  {
    return resources.get(name) ;
  }

  public String getPackagesNotFound()
  {
    int count = names.length - resources.size() ;
    String list = "" ;
    int i = 0 ;

    while(i < count)
    {
      if(!resources.containsKey(names[i]))
      {
        list = list + " " + names[i] ;
      }

      i++ ;
    }

    return list ;
  }
}