/**
 * AADL-RAMSES
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

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
  
  protected List<String> _atlFileNames;
  
  public List<String> getTransformationModuleList() {
	return _atlFileNames;
  }
  
  protected List<File> _atlFiles;
  
  public void initAtlFileNameList(File resourceDir)
  {
    _atlFiles = new ArrayList<File>();
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