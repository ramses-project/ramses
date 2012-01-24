package fr.tpt.aadl.ramses.instantiation.manager ;

import java.io.File ;
import java.io.FilenameFilter ;

import fr.tpt.aadl.ramses.control.support.Names ;

public class AADLFileFilter implements FilenameFilter
{

  public boolean accept(File dir,
                        String name)
  {
    return name.endsWith(Names.FILE_EXTENSIONS[0]) ||
          name.endsWith(Names.FILE_EXTENSIONS[1]) ;
  }

}
