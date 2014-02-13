package fr.tpt.aadl.ramses.control.support;

import java.util.List ;

import org.eclipse.emf.ecore.resource.Resource ;

public interface PredefinedAadlModelManager {

  public static String[] predefinedPackagesNames =
  {"Base_Types.aadl", "RAVENSCAR_runtime.aadl2", "OJR_runtime.aadl2",
   "ARINC653_runtime.aadl2", "OSEK_runtime.aadl2",
   "PeriodicDelayed_runtime.aadl2", "PeriodicDelayedMutex_runtime.aadl2"} ;
    
  public static String[] predefinedPropertiesNames =
  {"AADL_Project.aadl", "Communication_Properties.aadl", "Data_Model.aadl",
   "Deployment_Properties.aadl", "Memory_Properties.aadl",
   "Modeling_Properties.aadl", "Programming_Properties.aadl",
   "Thread_Properties.aadl", "Timing_Properties.aadl",
   "Generation_Properties.aadl2", "pok_properties.aadl2",
   "oseknxt_properties.aadl2", "osek_properties.aadl2"} ;
  
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
  public void parsePredefinedAadlModels() throws Exception;
}