/**
 * AADL-BA-FrontEnd
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

package fr.tpt.aadl.ramses.osate.wizards;

import java.io.File ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IPath ;
import org.osate.ba.wizards.AadlBaAbstractWizard ;
import org.osate.ba.wizards.AadlBaExamplesWizard ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.FileUtils ;

import fr.tpt.aadl.ramses.control.osate.Activator ;

public class RamsesExamplesWizard extends AadlBaAbstractWizard
{
  private static Logger _LOGGER = Logger.getLogger(RamsesExamplesWizard.class) ;
  
  public RamsesExamplesWizard ()
  {
    super();
    newProjectCreationPage = new RamsesExamplesWizardPage("basicNewProjectPage");
    newProjectCreationPage.setTitle("Aadl RAMSES Project");
    newProjectCreationPage.setDescription("Create a new Aadl RAMSES project resource.");
  }
  
  public class RamsesExamplesWizardPage extends AadlBaExamplesWizardPage
  {
    public RamsesExamplesWizardPage(String pageId)
    {
      super(pageId) ;
      
      File rootExamplePath ;
      try
      {
        rootExamplePath = Aadl2Utils.getPluginFile(Activator.PLUGIN_ID,
                                                          _EXAMPLE_ROOT_PATH) ;
        String[][] items = new String[][]{{"arinc653", "common-components", "osek"}} ;
        
        super.setSelectedItems(items, rootExamplePath);
      }
      catch(Exception e)
      {
        reportError("examples not found",e) ;
      }
    }

    @Override
    protected Map<String, List<Integer>> loadExamples(String examplesPath) 
                                                                throws Exception
    {
      File rootPath = Aadl2Utils.getPluginFile(Activator.PLUGIN_ID,
                                               examplesPath) ;
      if (rootPath.isDirectory())
      {
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        int count = 0 ;
        
        for(File f : rootPath.listFiles())
        {
          if (f.isDirectory() &&
              ! Aadl2Utils.contains(f.getName(), _EXCLUDED_DIRECTORIES))
          {
            String key = f.getName() ;
            key = key.replaceAll(_NAME_SEPARATOR, " ") ;
            
            File[] contain = f.listFiles() ;
            
            if(contain.length > 0)
            {
              List<Integer> index = new ArrayList<Integer>(contain.length) ;
              
              for (File inside : contain)
              {
                if (inside.isDirectory() &&
                    ! Aadl2Utils.contains(inside.getName(), _EXCLUDED_DIRECTORIES))
                {
                  index.add(count) ;
                  _fileMapping.add(key) ;
                  _files.add(inside) ;
                  count++ ;
                }
                else
                {
                  continue ;
                }
              }
              
              result.put(key, index) ;
            }
            else
            {
              continue ;
            }
          }
          else
          {
            continue ;
          }
        }
        
        return result ;
      }
      else
      {
        String msg = '\'' + examplesPath + "\' is not directory" ;
        _LOGGER.fatal(msg);
        throw new Exception(msg) ;
      }
    }
  }
  
  @Override
  public boolean performFinish()
  {
    boolean result = super.performFinish() ;
    
    if(result)
    {
      try
      {
        List<File> selectedExamples =
                      this.fetchSelectedExamples(_SelectedExamplesTreeContent) ;
        if(!selectedExamples.isEmpty())
        {
          IPath projectPath = this.newProject.getLocation() ;

          File destFolder =
                new File(projectPath.toString()) ;
          destFolder.mkdir() ;
          
          FileUtils.copyFiles(selectedExamples, destFolder,
                              _EXCLUDED_DIRECTORIES) ;
          
          this.newProject.refreshLocal(2, null) ;
        }
      }
      catch (Exception e)
      {
        result = false ;
        reportError("Save examples problem", e) ;
      }
    }
    
    return result ;
  }
}
