package fr.tpt.aadl.ramses.control.support;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

public interface PredefinedResourcesAccess {

	
  /**
   * This method returns the list of resources resulting from the parsing
   * of predefined property sets and packages.
   * @return list of resources (predefined aadl models) statically registered 
   * in RAMSES
   */
  List<Resource> getPredefinedResources();
  
  /**
   * This method initializes the root directory from which RAMSES will
   * look for predefined aadl models (in {@link #getPredefinedResources()})
   * @param resourceDir the directory from which RAMSES will
   * look for predefined aadl models.
   * @throws Exception when some predefined resources are not found
   */
  void setPredefinedResourcesDir(File resourceDir) throws Exception;
}
