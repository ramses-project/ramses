package fr.tpt.aadl.ramses.control.support;

import java.io.File ;

import org.osate.utils.FileUtils ;

public abstract class AbstractPredefinedAadlModelManager implements PredefinedAadlModelManager
{
  public static boolean predefinedAadlModelDirChecker(File path)
  {
    boolean hasPropertySet = false ;
    boolean hasPackageSet = false ;
    
    File[] subDirs = path.listFiles(new FileUtils.DirectoryFileFilter()) ;
    
    for(int i = 0 ; i < subDirs.length ; i++)
    {
      if(subDirs[i].getName().equals(Names.AADL_PREDEFINED_PROPERTIES_DIR_NAME))
      {
        hasPropertySet = true ;
      }
      else if(subDirs[i].getName().equals(Names.AADL_PREDEFINED_PACKAGE_DIR_NAME))
      {
        hasPackageSet = true ;
      }
      
      if(hasPackageSet && hasPropertySet)
      {
        return true ;
      }
    }
    
    return false ;
  }
  
  public static boolean ramsesDirChecker(File path)
  {
    File[] subDirs = path.listFiles(new FileUtils.DirectoryFileFilter()) ;
    
    for(int i = 0 ; i < subDirs.length ; i++)
    {
      if(subDirs[i].getName().equals(Names.AADL_RESOURCE_DIRECTORY_NAME))
      {
        return true ;
      }
    }
    
    return false ;
  }
}