package fr.tpt.aadl.ramses.control.core;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

public class RamsesConfiguration
{
  private static File OutputDirectory;
  private static List<File> IncludeDirectories = new ArrayList<File>();
  
  private static File RamsesRessourcesDir;
  
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
  
  protected static File getRamsesResourcesDir()
  {
    return RamsesRessourcesDir;
  }

}
