package fr.tpt.aadl.ramses.control.support.generator;

import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.ArrayList ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Set ;

import org.osate.utils.FileUtils ;

public abstract class AbstractAadlToAadl implements AadlToAadl
{
  protected static final Set<String> _resourcesDirNames = new HashSet<String>() ;
  
  protected String[] _atlFileNames;
  protected List<File> _atlFiles;
  
  public void initAtlFileNameList(File resourceDir)
  {
    _atlFiles = new ArrayList<File>(_atlFileNames.length);
    for (String fileName : _atlFileNames) {
      _atlFiles.add(new File(resourceDir.getAbsolutePath() +File.separator+ fileName));
    }
  }
  
  static
  {
    _resourcesDirNames.add("ACG") ;
    _resourcesDirNames.add("BehaviorAnnexCopy") ;
    _resourcesDirNames.add("helpers") ;
    _resourcesDirNames.add("tools") ;
    _resourcesDirNames.add("uninstanciate") ;
  }
  
  public static boolean atlResourceDirChecker(File path)
  {
    for(String dirName : _resourcesDirNames)
    {
      try
      { 
        FileUtils.stringToFile(path + File.separator + dirName) ;
      }
      catch(FileNotFoundException e)
      {
        return false ;
      }
    }
    
    return true ;
  } 
  
}