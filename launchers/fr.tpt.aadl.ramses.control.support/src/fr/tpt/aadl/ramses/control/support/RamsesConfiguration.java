package fr.tpt.aadl.ramses.control.support;

import java.io.File ;
import java.io.FileReader ;
import java.io.IOException ;
import java.util.HashSet ;
import java.util.LinkedHashMap ;
import java.util.LinkedHashSet ;
import java.util.Map ;
import java.util.Set ;
import java.util.concurrent.TimeUnit ;

import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.SystemInstance ;

public class RamsesConfiguration
{
  private static File OutputDirectory;
  private static Map<Resource,Set<File>> IncludeDirectories = new LinkedHashMap<Resource,Set<File>>();
  private static File RamsesRessourcesDir;
  private static File InputDirectory;
  private static AadlModelsManager _instantiationManager = new AadlModelsManagerImpl();
  private static PredefinedResourcesAccess predefinedResourcesManager;
  private static String runtimePath = "";
  public static final String PLATFORM_ID = "platform";
  private static String pokValidFilePath = "/misc/mk/config.mk";
  private static String osekValidFilePath = "/lego/nxtOSEK/ecrobot/c/ecrobot.c";
  private static IProject currentProject = null;
  private static SystemInstance sysint = null;
  private static IProgressMonitor ramsesMonitor =new NullProgressMonitor()  ;
  
  public static IProject getCurrentProject()
  {
  
    return currentProject ;

  }

  public static void setCurrentProject(IProject project)
  {
    currentProject = project ;
  }

  private static SystemInstance sysInstance;



  public static SystemInstance getSysInstance() {
    return sysInstance;
  }

  public static void setSysInstance(SystemInstance sysInstance) {
    RamsesConfiguration.sysInstance = sysInstance;
  }

  public static void setInstantiationManager(AadlModelsManager im)
  {
    _instantiationManager=im;
  }

  public static AadlModelsManager getInstantiationManager()
  {
    return _instantiationManager;
  }

  public static void setOutputDir(File outputDir)
  {
    OutputDirectory = outputDir ;
  }

  public static void setIncludeDir(Resource r, Set<File> includeDirSet, String targetName)
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
      System.out.println("resource ="+r.toString()) ;
      //    String filePath = r.getURI().toFileString();

      String filePath = r.getURI().toString();
      if(filePath.startsWith("platform:/resource"))
      {
        filePath = filePath.substring(18);
        String filePathPrefix = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
        System.out.println("filePathPrefix = "+filePathPrefix);
        filePath = filePathPrefix+filePath;
        System.out.println("filePath = "+filePath);
      }
      else if(filePath.startsWith("file:"))
      {
        filePath = filePath.substring(5);
        System.out.println("filePath = "+filePath);
      }
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

      // Add Dir of C OSEK runtime
      File OSEKRuntimeDir = new File(
                                     RamsesRessourcesDir.getAbsolutePath()+"/C_runtime/OSEK/");
      includeDirSet.add(OSEKRuntimeDir);
      // TODO: include other runtime directories here.
      String pokPath = System.getenv("POK_PATH");
      if(pokPath==null || pokPath=="")
        pokPath = System.getProperty("POK_PATH");
      if(pokPath!=null && targetName=="pok")
      {
        File pokFile = new File(pokPath+"/libpok/include");
        includeDirSet.add(pokFile);
        File pokAdaFile = new File(pokPath+"/libpok/ada");
        includeDirSet.add(pokAdaFile);
      }
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

  public static String getRuntimeDir() {
    return runtimePath;
  }

  public static void setRuntimeDir(String path) {
    runtimePath=path;
  }

  public static boolean pokRuntimePathValidityCheck(String path)
  {
    String  result = path.concat(pokValidFilePath.toString());
    File file = new File(result);

    try {
      FileReader fr = new FileReader(file);
      fr.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      System.out.println("File not exists !");
      return false;
    }

    return true;
  }

  public static boolean osekRuntimePathValidityCheck(String path)
  {
    String  result = path.concat(osekValidFilePath.toString());
    File file = new File(result);

    try
    {
      FileReader fr = new FileReader(file);
      fr.close(); 
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      System.out.println("File not exists !");
      return false;
    }

    return true;
  }

  public static SystemInstance getSysint()
  {
    return sysint ;
  }

  public static void setSysint(SystemInstance sysint)
  {
    RamsesConfiguration.sysint = sysint ;
  }

  public static IProgressMonitor getRamsesMonitor()
  {
    return ramsesMonitor ;
  }

  public static void setRamsesMonitor(IProgressMonitor ramsesMonitor)
  {
    RamsesConfiguration.ramsesMonitor = ramsesMonitor ;
  }
  
  public static void waitUnitOfTime(int time)
  {
    try
    {
      TimeUnit.SECONDS.sleep(time);
    }
    catch(InterruptedException e)
    {
      // TODO Manage with error reporter
      e.printStackTrace();
    }
  }
}