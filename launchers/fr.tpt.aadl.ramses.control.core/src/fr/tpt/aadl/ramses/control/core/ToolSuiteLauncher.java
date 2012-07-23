/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.control.core ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Set ;

import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.control.support.XMLPilot ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPackagesManager ;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPropertiesManager ;

public class ToolSuiteLauncher
{

  private ServiceRegistry _registry ;
  private PredefinedPropertiesManager _predefinedPropertiesManager ;
  private StandAloneInstantiator _instantiator ;
  private List<String> _analysisToPerform ;

  public ToolSuiteLauncher()
  {
    _registry = ServiceRegistryProvider.getServiceRegistry() ;
    _predefinedPropertiesManager = new PredefinedPropertiesManager() ;
    _instantiator = StandAloneInstantiator.getInstantiator() ;
  }

  public void initializeAnalysis(String[] analysisIdentifiers)
        throws Exception
  {
    _analysisToPerform =
          initialize(analysisIdentifiers, _registry.getAvailableAnalysisNames()) ;
  }
  
  public void initializeGeneration(String targetName)
        throws Exception
  {
    if(false == _registry.getAvailableGeneratorNames().contains(targetName))
    {
      throw new Exception ("Invalid generation target identifier: " + targetName) ;
    }
  }

  private List<String> initialize(String[] processNames,
                                  Set<String> availableProcessNames)
        throws Exception
  {
    List<String> result = new ArrayList<String>(processNames.length) ;
    List<String> invalidIdentifiers =
          new ArrayList<String>(processNames.length) ;

    ROOT: for(int i = 0 ; i < processNames.length ; i++)
    {
      for(String aaId : availableProcessNames)
      {
        if(processNames[i].equals(aaId))
        {
          result.add(processNames[i]) ;
          continue ROOT ;
        }
      }

      invalidIdentifiers.add(processNames[i]) ;
    }

    if(invalidIdentifiers.isEmpty() == false)
    {
      StringBuilder message =
            new StringBuilder("Invalid analysis identifiers: ") ;

      for(String s : invalidIdentifiers)
      {
        message.append(s) ;
        message.append(' ') ;
      }

      throw new Exception(message.toString()) ;
    }

    return result ;
  }

  private void performAnalysis(SystemInstance instance)
        throws AnalysisResultException
  {
    if(_analysisToPerform != null && _analysisToPerform.isEmpty() == false)
    {
      // to be completed with exceptions in case analysis goes wrong
      for(String analysisName : _analysisToPerform)
      {
        _registry.getAnalyzer(analysisName)
              .performAnalysis(instance,
                               ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER,
                               new NullProgressMonitor()) ;
      }
    }
  }

  public List<Resource> parse(List<File> aadlFile)
  {
    return _instantiator.parse(aadlFile) ;
  }

  public void parsePredefinedRessources()
  {
    try
    {
      File aadlResourcesDir = RamsesConfiguration.getRamsesResourcesDir();
      _predefinedPropertiesManager
            .extractStandardPropertySets(aadlResourcesDir) ;
    }
    catch(Exception e1)
    {
      e1.printStackTrace() ;
    }
  }
  
  public void launchModelGeneration (List<File> mainModels,
                                     String systemToInstantiate,
                                     File generatedFilePath,
                                     String targetName,
                                     File resourceFilePath)
                                                      throws GenerationException
  {
    List<Resource> aadlModels = _instantiator.parse(mainModels) ;
    
    SystemInstance instance =
          _instantiator.instantiate(aadlModels, systemToInstantiate) ;

    if(instance == null)
    {
      throw new GenerationException("instanciation failed.") ;
    }

    _predefinedPropertiesManager.extractStandardPropertySets(aadlModels) ;
    
    ServiceRegistry registry = ServiceRegistryProvider.getServiceRegistry() ;
    
    Generator generator = registry.getGenerator(targetName) ;
    
    generator.generate(instance, resourceFilePath,
                       generatedFilePath) ;
  }

  public void launchModelGenerationXML (List<File> mainModels,
                                        String systemToInstantiate,
                                        File generatedFilePath,
                                        String targetName,
                                        File resourceFilePath,
                                        XMLPilot xmlPilot)
                                              throws GenerationException
  {
    List<Resource> aadlModels = _instantiator.parse(mainModels) ;

    SystemInstance instance =
          _instantiator.instantiate(aadlModels, systemToInstantiate) ;

    if(instance == null)
    {
      throw new GenerationException("instanciation failed.") ;
    }

    _predefinedPropertiesManager.extractStandardPropertySets(aadlModels) ;

    ServiceRegistry registry = ServiceRegistryProvider.getServiceRegistry() ;

    Generator generator = registry.getGenerator(targetName) ;
    System.out.println("Generator.generateXML called");

    generator.generateXML(instance, resourceFilePath,
                          generatedFilePath, xmlPilot) ;
  }
  
  
  public void performAnalysis(List<File> mainModelFiles,
                              String systemToInstantiate)
        throws AnalysisResultException
  {
    List<Resource> aadlModels = _instantiator.parse(mainModelFiles) ;
    SystemInstance instance =
          _instantiator.instantiate(aadlModels, systemToInstantiate) ;
    this.performAnalysis(instance) ;
  }

  public void parsePredefinedPackages()
  {
    File aadlResourcesDir = RamsesConfiguration.getRamsesResourcesDir();
    new PredefinedPackagesManager(aadlResourcesDir);
  }
}