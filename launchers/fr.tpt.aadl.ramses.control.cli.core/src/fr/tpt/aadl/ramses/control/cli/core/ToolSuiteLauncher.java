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
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.control.cli.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.config.ConfigStatus ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.Aadl2StandaloneUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;

/**
 * This class provides services to the Command 
 * Line Interface launcher #fr.tpt.aadl.ramses.control.cli.core.ToolSuiteLauncherCommand
 */

public class ToolSuiteLauncher
{
  private ServiceRegistry _registry ;
  private StandAloneInstantiator _instantiator ;
  private List<String> _analysisToPerform ;
  private IProgressMonitor _monitor  ;
  private PredefinedAadlModelManager _modelManager ;
  
  private static Logger _LOGGER = Logger.getLogger(ToolSuiteLauncher.class) ;
  
  public ToolSuiteLauncher(IProgressMonitor monitor,
                    StandAloneInstantiator instantiator,
                    PredefinedAadlModelManager modelManager)
  {
    _monitor = monitor ;
    _instantiator = instantiator ;
    _modelManager = modelManager ;
  }

  void initializeAnalysis(String[] analysisIdentifiers) throws ConfigurationException
  {
    _analysisToPerform =
          initialize(analysisIdentifiers, _registry.getAvailableAnalysisNames()) ;
  }
  
  private List<String> initialize(String[] processNames,
                                  Set<String> availableProcessNames) throws ConfigurationException
        
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
            new StringBuilder("invalid analysis identifiers: ") ;

      for(String s : invalidIdentifiers)
      {
        message.append(s) ;
        message.append(' ') ;
      }
      ConfigStatus.NOT_VALID.msg = message.toString() ;
      
      throw new ConfigurationException(ConfigStatus.NOT_VALID) ;
    }

    return result ;
  }

  private void performAnalysis(SystemInstance instance,
                                RamsesConfiguration config,
                                Map<String, Object> parameters)
                                                  throws AnalysisException
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
                                 config,
                                 ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER,
                               _monitor
                               ) ;
      }
    }
  }

  public List<Resource> performParse(List<File> aadlFile) throws ParseException
  {
    List<Resource> result = _instantiator.parse(aadlFile) ;
    return result ;
  }

  /**
   * This method parses AADL predefined packages and property sets
   * and registers them in the OSATE resource set.
   * @throws ParseException 
   */
  public void parsePredefinedRessources() throws ParseException
  {
    _monitor.subTask("Parse predefined AADL models");
    _modelManager.parsePredefinedAadlModels();
  }
  
  void launchDefaultGenerationProcess (List<File> mainModels,
                                     	 String systemToInstantiate,
                                     	 RamsesConfiguration config,
                                     	 File[] includeDirs,
                                     	 Map<String, Object> parameters)
                                                      throws AnalysisException,
                                                             GenerationException,
                                                         TransformationException,
                                                         ParseException
  {
    ServiceRegistry registry = ServiceProvider.getServiceRegistry() ;
    Generator generator = registry.getGenerator(config.getTargetId()) ;
    
    _monitor.subTask("Parse AADL models");
    List<Resource> aadlModels = _instantiator.parse(mainModels) ;
    
    _monitor.subTask("Instantiate AADL models");
    SystemInstance instance =
          _instantiator.instantiate(aadlModels, systemToInstantiate) ;
    
    if(instance == null)
    {
      String msg = "instanciation has failed" ;
      _LOGGER.fatal(msg);
      ServiceProvider.SYS_ERR_REP.fatal(msg);
      System.exit(-1);
    }
    
    generator.setParameters(parameters) ;
    
    generator.generate(instance, config, includeDirs,
                       ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER, _monitor) ;
  }

  void launchWorkflowProcess (List<File> mainModels,
                              String systemToInstantiate,
                              RamsesConfiguration config,
                              File[] includeDirs,
                              WorkflowPilot xmlPilot,
                              Map<String, Object> parameters)
                                                      throws AnalysisException,
                                                            GenerationException,
                                                      TransformationException,
                                                      ParseException
  {
    ServiceRegistry registry = ServiceProvider.getServiceRegistry() ;
    Generator generator = registry.getGenerator(config.getTargetId()) ;
    
    _monitor.subTask("Parse AADL models");
    List<Resource> aadlModels = _instantiator.parse(mainModels) ;
    
    _monitor.subTask("Instantiate AADL models");
    SystemInstance instance =
          _instantiator.instantiate(aadlModels, systemToInstantiate) ;
    
    if(instance == null)
    {
      String msg = "instanciation has failed" ;
      _LOGGER.fatal(msg);
      ServiceProvider.SYS_ERR_REP.fatal(msg);
      System.exit(-1);
    }

    generator.setParameters(parameters) ;
    
    generator.generateWorkflow(instance, config, xmlPilot, includeDirs,
                               ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER,
                               _monitor) ;
  }
  
  void performAnalysis(List<File> mainModelFiles,
                       String systemToInstantiate,
                       RamsesConfiguration config,
                       Map<String, Object> parameters)
                                                        throws AnalysisException,
                                                        ParseException
  {
    _monitor.subTask("Parse AADL models");
    List<Resource> aadlModels = _instantiator.parse(mainModelFiles) ;
    
    _monitor.subTask("Instantiate AADL models");
    SystemInstance instance =
          _instantiator.instantiate(aadlModels, systemToInstantiate) ;
    
    if(instance == null)
    {
      String msg = "instanciation has failed" ;
      _LOGGER.fatal(msg);
      ServiceProvider.SYS_ERR_REP.fatal(msg);
      System.exit(-1);
    }
    this.performAnalysis(instance, config, parameters) ;
  }

  void unparse(List<Resource> resources, RamsesConfiguration config) throws IOException 
  {
    _monitor.subTask("Unparse AADL resources");
    
    String fileName ;
    File outputFile ;
    PrintStream ps ;
    
    for(Resource r : resources)
    {
      fileName = r.getURI().toFileString() ;
      fileName = fileName.substring(fileName.lastIndexOf(File.separator)) ;
      outputFile = new File(config.getRamsesOutputDir() + fileName);
      
      if(outputFile.exists())
      {
        outputFile.delete() ;
      }
      
      outputFile.createNewFile() ;
      
      Aadl2StandaloneUnparser unparser = Aadl2StandaloneUnparser.getAadlUnparser();
      NamedElement el = (NamedElement) r.getContents().get(0);
      
      unparser.doUnparse(el) ;
      ps = new PrintStream(outputFile) ;
      ps.append(unparser.getOutput()) ;
      ps.close() ;
    }
  }
}