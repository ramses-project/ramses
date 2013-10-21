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

package fr.tpt.aadl.ramses.control.cli.core ;

import java.io.File ;
import java.io.IOException ;
import java.io.PrintStream ;
import java.util.ArrayList ;
import java.util.LinkedHashSet;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

import fr.tpt.aadl.ramses.control.support.Aadl2StandaloneUnparser ;
import fr.tpt.aadl.ramses.control.support.InstantiationManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.WorkflowPilot;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.reporters.MessageStatus ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPackagesManager ;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPropertiesManager ;

public class ToolSuiteLauncher
{

  private ServiceRegistry _registry ;
  private PredefinedPropertiesManager _predefinedPropertiesManager ;
  private StandAloneInstantiator _instantiator ;
  private List<String> _analysisToPerform ;
  private Set<File> _includeDirSet;
  
  public ToolSuiteLauncher()
  {
    _registry = ServiceRegistryProvider.getServiceRegistry() ;
    _predefinedPropertiesManager = new PredefinedPropertiesManager() ;
    _instantiator = StandAloneInstantiator.getInstantiator() ;
    RamsesConfiguration.setInstantiationManager(_instantiator);
  }

  void initializeAnalysis(String[] analysisIdentifiers)
        throws Exception
  {
    _analysisToPerform =
          initialize(analysisIdentifiers, _registry.getAvailableAnalysisNames()) ;
  }
  
  void initializeGeneration(String targetName, String[] includeDirArray)
        throws Exception
  {
    if(false == _registry.getAvailableGeneratorNames().contains(targetName))
    {
      throw new Exception ("Invalid generation target identifier: " + targetName) ;
    }
    String errors = "";
    _includeDirSet = new LinkedHashSet<File>();
    // TODO: move next in a file utils
    for(int i = 0 ; i < includeDirArray.length ; i++)
    {
      File potentialFile = new File(includeDirArray[i]) ;
      
      if(potentialFile.exists())
      {
    	_includeDirSet.add(potentialFile) ;
        continue ;
      }
      else
    	errors+="\t"+includeDirArray[i]+"\n";
    }
    if(false == errors.isEmpty())
    {
      throw new Exception("ERROR: could not be find directories (given in -i option):\n"+errors);
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

  private void performAnalysis(SystemInstance instance,
                                Map<String, Object> parameters)
        throws AnalysisResultException
  {
    if(_analysisToPerform != null && _analysisToPerform.isEmpty() == false)
    {
      // to be completed with exceptions in case analysis goes wrong
      for(String analysisName : _analysisToPerform)
      {
        Analyzer analyzer = _registry.getAnalyzer(analysisName) ;
        
        // Set parameters to null in order to reset analyzer's parameters.
        analyzer.setParameters(parameters) ;
        analyzer.performAnalysis(instance,
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
  
  void launchModelGeneration (List<File> mainModels,
                                     String systemToInstantiate,
                                     File generatedFilePath,
                                     String targetName,
                                     File resourceFilePath,
                                     Map<String, Object> parameters)
                                                      throws GenerationException
  {
    List<Resource> aadlModels = _instantiator.parse(mainModels) ;
    
    SystemInstance instance =
          this.instantiate(aadlModels, systemToInstantiate) ;
    
    if(instance == null)
    {
      throw new GenerationException("instanciation failed.") ;
    }
    
    RamsesConfiguration.setIncludeDir(instance.getSystemImplementation().eResource(), _includeDirSet, targetName);
    
    _predefinedPropertiesManager.extractStandardPropertySets(aadlModels) ;
    
    ServiceRegistry registry = ServiceRegistryProvider.getServiceRegistry() ;
    
    Generator generator = registry.getGenerator(targetName) ;
    
    generator.setParameters(parameters) ;
    
    generator.generate(instance, resourceFilePath,
                       generatedFilePath) ;
  }

  public void launchModelGenerationWorkflow (List<File> mainModels,
                                        	 String systemToInstantiate,
                                        	 File generatedFilePath,
                                        	 String targetName,
                                        	 File resourceFilePath,
                                        	 WorkflowPilot xmlPilot,
                                        	 Map<String, Object> parameters)
                                              throws GenerationException
  {
    List<Resource> aadlModels = _instantiator.parse(mainModels) ;

    SystemInstance instance =
          this.instantiate(aadlModels, systemToInstantiate) ;

    if(instance == null)
    {
      throw new GenerationException("instanciation failed.") ;
    }

    RamsesConfiguration.setIncludeDir(instance.getSystemImplementation().eResource(), _includeDirSet, targetName);
    
    _predefinedPropertiesManager.extractStandardPropertySets(aadlModels) ;

    ServiceRegistry registry = ServiceRegistryProvider.getServiceRegistry() ;

    Generator generator = registry.getGenerator(targetName) ;
    System.out.println("Generator.generateXML called");
    
    generator.setParameters(parameters) ;
    
    generator.generateWorkflow(instance, resourceFilePath,
                          generatedFilePath, xmlPilot) ;
  }
  
  
  void performAnalysis(List<File> mainModelFiles,
                               String systemToInstantiate,
                               Map<String, Object> parameters)
        throws AnalysisResultException
  {
    List<Resource> aadlModels = _instantiator.parse(mainModelFiles) ;
    SystemInstance instance =
          this.instantiate(aadlModels, systemToInstantiate) ;
    this.performAnalysis(instance, parameters) ;
  }

  public SystemInstance instantiate(List<Resource> aadlModels,
		String systemToInstantiate) {
    for(Resource r : aadlModels)
    {
	  InstantiationManager instantiator = RamsesConfiguration.getInstantiationManager();
      PropertiesLinkingService pls = new PropertiesLinkingService ();
      AadlPackage pkg = (AadlPackage) r.getContents().get(0);
      SystemImplementation si = (SystemImplementation) pls.
      		findNamedElementInsideAadlPackage(systemToInstantiate, 
      				pkg.getOwnedPublicSection());
      if(si==null)
    	  continue;
      return instantiator.instantiate(si);
    }
    System.err.println("ERROR: "+ 
    			systemToInstantiate +
    			" could not be found for instantiation.");
	return null;
  }

  public void parsePredefinedPackages()
  {
    File aadlResourcesDir = RamsesConfiguration.getRamsesResourcesDir();
    new PredefinedPackagesManager(aadlResourcesDir);
  }

  public void unparse(List<Resource> resources, File outputPath) throws IOException
  {
    String fileName ;
    String outputFilePath ;
    File outputFile ;
    PrintStream ps ;
    String msg ;
    
    for(Resource r : resources)
    {
      fileName = r.getURI().toFileString() ;
      fileName = fileName.substring(fileName.lastIndexOf(File.separator)) ;
      outputFilePath = outputPath.getAbsolutePath() + fileName ; 
      outputFile = new File(outputFilePath);
      
      if(outputFile.exists())
      {
        outputFile.delete() ;
      }
      
      outputFile.createNewFile() ;
      
      Aadl2StandaloneUnparser unparser = Aadl2StandaloneUnparser.getAadlUnparser();
      NamedElement el = (NamedElement) r.getContents().get(0);
      
      msg = "Unparse " + el.getName() + " into " + outputFile.getAbsolutePath() ;
      ServiceRegistry.MSG_REPORTER.reportMessage(MessageStatus.INFO, msg) ;      
      
      unparser.doUnparse(el) ;
      ps = new PrintStream(outputFile) ;
      ps.append(unparser.getOutput()) ;
      ps.close() ;
    }
  }
}