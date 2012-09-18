package fr.tpt.aadl.ramses.control.support;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

public class RamsesConfiguration
{
  private static File OutputDirectory;
  private static List<File> IncludeDirectories = new ArrayList<File>();
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
  
  protected static void addIncludeDir(File includeDir)
  {
    IncludeDirectories.add(includeDir) ;
  }
  
  protected static void setRamsesResourcesDir(File ramsesResourcesDir)
  {
    RamsesRessourcesDir = ramsesResourcesDir ;
  }
  
  public static File getOutputDir()
  {
    return OutputDirectory;
  }

  protected static List<File> getIncludeDir()
  {
    return IncludeDirectories;
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
