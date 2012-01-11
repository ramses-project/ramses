package fr.tpt.aadl.resources.manager ;

import java.io.File ;
import java.io.FilenameFilter ;

import fr.tpt.aadl.toolsuite.support.Names ;

public class AADLFileFilter implements FilenameFilter
{

  public boolean accept(File dir,
                        String name)
  {
    return name.endsWith(Names.FILE_EXTENSIONS[0]) ||
          name.endsWith(Names.FILE_EXTENSIONS[1]) ;
  }

}
