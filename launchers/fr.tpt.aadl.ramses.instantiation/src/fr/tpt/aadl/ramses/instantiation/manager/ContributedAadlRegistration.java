package fr.tpt.aadl.ramses.instantiation.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import fr.tpt.aadl.ramses.control.support.Names ;
import fr.tpt.aadl.ramses.control.support.PredefinedResourcesAccess;

public class ContributedAadlRegistration implements PredefinedResourcesAccess { 

  PredefinedPackagesManager predefinedPackagesManager;
  PredefinedPropertiesManager predefinedPropertiesManager;

  @Override
  public void setPredefinedResourcesDir(File resourceDir) throws Exception {
	predefinedPackagesManager =
			new PredefinedPackagesManager(new File(resourceDir
	  					.getAbsolutePath() + Names.AADL_RESOURCE_DIRECTORY_NAME)) ;

	if(!predefinedPackagesManager.allPackagesFound())
		throw new Exception(
			"Illegal initialization of ATL transformation launcher: " +
			"some predefined packages not found: " +
			predefinedPackagesManager.getPackagesNotFound()) ;

   	predefinedPropertiesManager = new PredefinedPropertiesManager();
   	
  }

  @Override
  public List<Resource> getPredefinedResources() {
	List<Resource> result = new ArrayList<Resource>();

    for(int p = 0 ; p < predefinedPackagesManager.getPackagesCount() ; p++)
	{
	  String name = predefinedPackagesManager.getPackageName(p) ;
	  Resource r = predefinedPackagesManager.getPackageResource(name) ;
	  result.add(r);
	}
    for(int p = 0 ; p < predefinedPropertiesManager.getPropertiesCount() ; p++)
	{
	  String name = predefinedPropertiesManager.getPropertySetName(p) ;
	  Resource r = predefinedPropertiesManager.getPropertySetResource(name) ;
	  result.add(r);
	}
    return result;
  }

}
