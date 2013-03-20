package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import fr.tpt.aadl.ramses.control.support.PredefinedResourcesAccess;

public class ContributedAadlRegistration implements PredefinedResourcesAccess { 

  private static String[] predefinedPackagesNames =
	  {"Base_Types.aadl", "arinc653_runtime.aadl2", "OSEK_runtime.aadl2", "PeriodicDelayed_runtime.aadl2"
	  } ;
  
  private static String[] predefinedPropertiesNames =
      {"AADL_Project.aadl", "Communication_Properties.aadl", "Data_Model.aadl", "Deployment_Properties.aadl",
       "Memory_Properties.aadl", "Modeling_Properties.aadl", "Programming_Properties.aadl",
       "Thread_Properties.aadl", "Timing_Properties.aadl", "Generation_Properties.aadl2",
       "pok_properties.aadl2", "oseknxt_properties.aadl2",
       "osek_properties.aadl2"
            } ;
  
  @Override
  public void setPredefinedResourcesDir(File resourceDir) throws Exception {
	// Do nothing
  }

  @Override
  public List<Resource> getPredefinedResources() {	  
	List<Resource> result = new ArrayList<Resource>();
	for(int p = 0 ; p < predefinedPackagesNames.length ; p++)
	{
	  String name = predefinedPackagesNames[p] ;
	  URI uri = URI.createPlatformResourceURI(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME
			  +"/"+name, true);
	  result.add(OsateResourceUtil.getResource(uri));
	}
    for(int p = 0 ; p < predefinedPropertiesNames.length ; p++)
	{
      String name = predefinedPropertiesNames[p] ;
  	  URI uri = URI.createPlatformResourceURI(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME
  			  +"/"+name, true);
  	  result.add(OsateResourceUtil.getResource(uri));
	}
    return result;
  }

}
