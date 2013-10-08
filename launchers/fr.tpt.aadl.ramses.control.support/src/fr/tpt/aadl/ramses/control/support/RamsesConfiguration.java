package fr.tpt.aadl.ramses.control.support;

import java.io.File ;
import java.io.IOException;
import java.util.ArrayList ;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List ;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.instance.InstanceObject;

public class RamsesConfiguration
{
  private static File OutputDirectory;
  private static Map<Resource,Set<File>> IncludeDirectories = new LinkedHashMap<Resource,Set<File>>();
  private static File RamsesRessourcesDir;
  private static File InputDirectory;
  private static InstantiationManager _instantiationManager = new InstantiationManagerImpl();
  private static PredefinedResourcesAccess predefinedResourcesManager;
  
  public static void setInstantiationManager(InstantiationManager im)
  {
	_instantiationManager=im;
  }
  
  public static InstantiationManager getInstantiationManager()
  {
	return _instantiationManager;
  }
  
  protected static void setOutputDir(File outputDir)
  {
    OutputDirectory = outputDir ;
  }
  
  public static void setIncludeDir(Resource r, Set<File> includeDirSet)
  {
	if(includeDirSet==null)
		includeDirSet = new HashSet<File>();
	if(IncludeDirectories.containsKey(r))
	  IncludeDirectories.get(r).addAll(includeDirSet) ;
	else
	{
	  includeDirSet.add(RamsesRessourcesDir);

	  // Add dir in which the input resource was defined
	  URI uri = r.getURI();
	  String filePath = r.getURI().toFileString();
	  int lastIndex = filePath.indexOf(uri.lastSegment());
	  File inputResourceDir = new File(filePath.substring(0, lastIndex));
	  includeDirSet.add(inputResourceDir);

	  
	  // Add Dir of C PeriodicDelayed runtime
	  File cPeriodicDelayedRuntimeDir;
	  cPeriodicDelayedRuntimeDir = new File(
			  RamsesRessourcesDir.getAbsolutePath()+"/C_runtime/PeriodicDelayed_runtime/");
	  includeDirSet.add(cPeriodicDelayedRuntimeDir);

	  // Add Dir of Ada PeriodicDelayed runtime
	  File adaPeriodicDelayedRuntimeDir;
	  adaPeriodicDelayedRuntimeDir = new File(
			  RamsesRessourcesDir.getAbsolutePath()+"/Ada_runtime/PeriodicDelayed_runtime/");
	  includeDirSet.add(adaPeriodicDelayedRuntimeDir);

	  // TODO: include other runtime directories here.
	  String pokPath = System.getenv("POK_PATH");
	  if(pokPath==null || pokPath=="")
		pokPath = System.getProperty("POK_PATH");
	  File pokFile = new File(pokPath+"/libpok/include");
	  includeDirSet.add(pokFile);
	  File pokAdaFile = new File(pokPath+"/libpok/ada");
	  includeDirSet.add(pokAdaFile);
	  IncludeDirectories.put(r, includeDirSet);
	}
  }
  
  public static void setRamsesResourcesDir(File ramsesResourcesDir)
  {
    RamsesRessourcesDir = ramsesResourcesDir ;
  }
  
  public static File getOutputDir()
  {
    return OutputDirectory;
  }

  public static Set<File> getIncludeDir(Resource r)
  {
	if(IncludeDirectories.get(r)==null)
	{
	  Set<File> includeSet = new LinkedHashSet<File>();
	  IncludeDirectories.put(r,includeSet);
	}
	return IncludeDirectories.get(r);
  }
  
  public static File getRamsesResourcesDir()
  {
    return RamsesRessourcesDir;
  }

  public static File getInputDirectory() {
	return InputDirectory;
  }

  public static void setInputDirectory(File inputDirectory) {
	InputDirectory = inputDirectory;
  }

  public static PredefinedResourcesAccess getPredefinedResourcesManager() {
	return predefinedResourcesManager;
  }

  public static void setPredefinedResourcesRegistration(PredefinedResourcesAccess 
		  predefinedResourcesRegistration) {
	RamsesConfiguration.predefinedResourcesManager = predefinedResourcesRegistration;
  }

}
