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

package fr.tpt.aadl.ramses.control.support.instantiation;

import java.util.List ;

import org.eclipse.emf.ecore.resource.Resource ;

public interface PredefinedAadlModelManager {

  public static String[] predefinedPackagesNames =
  {"Base_Types.aadl", "RAVENSCAR_runtime.aadl2", "OJR_runtime.aadl2",
   "ARINC653_runtime.aadl2", "OSEK_runtime.aadl2",
   "PeriodicDelayed_runtime.aadl2", "PeriodicDelayedMutex_runtime.aadl2",
   "rtl8029_driver.aadl2", "RAMSES_processors.aadl2", "RAMSES_buses.aadl2"} ;
    
  public static String[] predefinedPropertiesNames =
  {"AADL_Project.aadl", "Communication_Properties.aadl", "Data_Model.aadl",
   "Deployment_Properties.aadl", "Memory_Properties.aadl",
   "Modeling_Properties.aadl", "Programming_Properties.aadl",
   "Thread_Properties.aadl", "Timing_Properties.aadl",
   "Generation_Properties.aadl2", "pok_properties.aadl2",
   "osek_properties.aadl2", "RAMSES.aadl2", "AI.aadl"} ;
  
  /**
   * This method returns the list of resources resulting from the parsing
   * of predefined property sets and packages.
   * @return list of resources (predefined aadl models) statically registered 
   * in RAMSES
   */
  public List<Resource> getPredefinedResources();
  
  /**
   * This method parse the predefined AADL models (propertysets and packages) 
   * from which RAMSES will look at (in {@link #getPredefinedResources()})
   * @throws Exception when some predefined resources are not found
   */
  public void parsePredefinedAadlModels() throws ParseException;
}