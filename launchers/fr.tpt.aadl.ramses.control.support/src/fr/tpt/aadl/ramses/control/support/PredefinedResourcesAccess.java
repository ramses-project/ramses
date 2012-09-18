package fr.tpt.aadl.ramses.control.support;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

public interface PredefinedResourcesAccess {

  List<Resource> getPredefinedResources();
  
  void setPredefinedResourcesDir(File resourceDir) throws Exception;
}
