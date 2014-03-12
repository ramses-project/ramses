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

package fr.tpt.aadl.ramses.control.cli.instantiation.manager;

import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.ramses.control.cli.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.control.support.instantiation.AbstractPredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;

public class ContributedAadlRegistration extends AbstractPredefinedAadlModelManager
{ 
  private PredefinedPackagesManager _predefinedPackagesManager;
  private PredefinedPropertiesManager _predefinedPropertiesManager;

  private StandAloneInstantiator _instantiator ;
  
  private static Logger _LOGGER = Logger.getLogger(ContributedAadlRegistration.class) ;
  
  public ContributedAadlRegistration(StandAloneInstantiator instantiator)
  {
    _instantiator = instantiator ;
    
    _predefinedPackagesManager =
          new PredefinedPackagesManager(_instantiator) ;
    
    _predefinedPropertiesManager = new PredefinedPropertiesManager(_instantiator);
  }
  
  @Override
  public void parsePredefinedAadlModels() throws ParseException
  {
    // Always parse the property sets before packages !
    _predefinedPropertiesManager.parsePredefinedPropertySets() ;
    
    _predefinedPackagesManager.parsePredefinedPackages() ;
    
    if(!_predefinedPackagesManager.allPackagesFound())
    {
      String errMsg = "Illegal initialization of ATL transformation launcher: "+
                      "some predefined packages not found: " +
                      _predefinedPackagesManager.getPackagesNotFound() ;
      _LOGGER.fatal(errMsg) ;
      throw new ParseException(errMsg) ;
    }
  }

  /**
   * @see fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager#getPredefinedResources()
   */
  @Override
  public List<Resource> getPredefinedResources()
  {
    List<Resource> result = new ArrayList<Resource>() ;

    for(int p = 0 ; p < _predefinedPackagesManager.getPackagesCount() ; p++)
    {
      String name = _predefinedPackagesManager.getPackageName(p) ;
      Resource r = _predefinedPackagesManager.getPackageResource(name) ;
      result.add(r) ;
    }
    for(int p = 0 ; p < _predefinedPropertiesManager.getPropertiesCount() ; p++)
    {
      String name = _predefinedPropertiesManager.getPropertySetName(p) ;
      Resource r = _predefinedPropertiesManager.getPropertySetResource(name) ;
      result.add(r) ;
    }
    return result ;
  }
}