/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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