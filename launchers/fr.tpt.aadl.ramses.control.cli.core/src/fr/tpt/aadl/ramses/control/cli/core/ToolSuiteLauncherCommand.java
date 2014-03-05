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
import java.io.FileNotFoundException ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.ecore.resource.Resource ;

import com.martiansoftware.jsap.FlaggedOption ;
import com.martiansoftware.jsap.JSAP ;
import com.martiansoftware.jsap.JSAPException ;
import com.martiansoftware.jsap.JSAPResult ;
import com.martiansoftware.jsap.QualifiedSwitch ;
import com.martiansoftware.jsap.Switch ;

import fr.tpt.aadl.ramses.control.cli.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.control.cli.instantiation.manager.ContributedAadlRegistration ;
import fr.tpt.aadl.ramses.control.support.ConfigStatus ;
import fr.tpt.aadl.ramses.control.support.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.EcoreWorkflowPilot ;
import fr.tpt.aadl.ramses.control.support.EnvUtils ;
import fr.tpt.aadl.ramses.control.support.FileUtils ;
import fr.tpt.aadl.ramses.control.support.Names ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.TransformationException ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.reporters.DefaultMessageReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.MessageStatus ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

/**
 * This class provides the main entry point of the Command Line 
 * Interface (CLI) version of RAMSES. It takes as input the 
 * set of command line arguments of RAMSES, parses them, and
 * launches the corresponding actions.
 */

public class ToolSuiteLauncherCommand
{
  private static final String HELP_ONLY_OPTION_ID = "help_only" ;
  private static final String PARSE_ONLY_OPTION_ID = "parse_only" ;
  private static final String ANALYSIS_ONLY_OPTION_ID = "analysis_only" ;
  private static final String ANALYSIS_LIST_OPTION_ID = "analysis_list" ;
  private static final String SOURCE_MODELS_OPTION_ID = "source_models" ;
  private static final String INCLUDES_OPTION_ID = "include_directories" ;
  private static final String SUPERIMPOSITION_FILES_OPTION_ID =
        "superimposition_files" ;
  private static final String POST_TRANSFORMATION_FILES_OPTION_ID =
        "post_transformation_files" ;
  private static final String SYSTEM_TO_INSTANTIATE_OPTION_ID =
        "system_to_instantiate" ;
  private static final String OUTPUT_DIR_OPTION_ID = "output_directory" ;
  
  private static final String GENERATION_OPTION_ID = "target_platform" ;
  
  private static final String PARAMETER_SEPARATOR = "=" ;
  private static final String PARAMETER_OPTION_ID = "key"+ 
                                                           PARAMETER_SEPARATOR +
                                                             "value" ;
  private static final String LOGGING_OPTION_ID = "logging" ;
  
  private static final String LOGGING_FILENAME = ".ramses-log" ;
  
  private static Switch helpOnlyMode ;
  private static Switch parseOnlyMode ;
  private static Switch analysisOnlyMode ;
  private static QualifiedSwitch analysis ;
  
  private static final String WORKFLOW_OPTION_ID = "workflow_path" ;
  
  private static final String RUNTIME_PATH_OPTION_ID = "runtime_path" ;
  
  private final static DefaultMessageReporter _reporter = new DefaultMessageReporter();
  
  private static Set<File> _includeDirs ;
  private static List<File> _mainModelFiles ;
  private static String _systemToInstantiate ;
  private static ToolSuiteLauncher _launcher ;
  
  private static Logger _logger = Logger.getLogger(ToolSuiteLauncherCommand.class) ;
  

  /**
   * This method is the main entry point of the Command Line 
   * Interface (CLI) version of RAMSES. It takes as input the 
   * set of command line arguments of RAMSES, parses them, and
   * launches the corresponding actions.
   * @throws JSAPException 
   * @throws ConfigurationException 
   * @throws AnalysisException 
   * @throws GenerationException 
   * @throws TransformationException 
   * @throws IOException 
   * @throws Exception 
   */
  public static void main(String[] args) throws AnalysisException,
                                                GenerationException,
                                                TransformationException
  {
    try
    {
      JSAP jsap = new JSAP() ;

      initSwitches(jsap) ;
      JSAPResult options = jsap.parse(args) ;
      boolean helpOnly = options.getBoolean(HELP_ONLY_OPTION_ID) ;

      if(helpOnly)
      {
        printHelp(jsap, args);
        System.exit(1) ; 
      }
      else
      {
        if(options.success())
        {
          boolean parseOnly = options.getBoolean(PARSE_ONLY_OPTION_ID) ;
          boolean analysisOnly = options.getBoolean(ANALYSIS_ONLY_OPTION_ID) ;
          
          commonOptionsHandler(options) ;
          
          if(parseOnly)
          {
            parse(options) ;
          }
          else if(analysisOnly)
          { 
            analyse(options) ;
          }
          else // Case of generation.
          {
            generation(options) ;
          }
        }
      
        System.exit(1);
      }
    }
    catch(ConfigurationException ex)
    {
      String msg = "while setting up RAMSES" ;
      _logger.fatal(msg, ex);
      ServiceProvider.SYS_ERR_REP.fatal(msg, ex);
      System.exit(0);
    }
    catch(JSAPException ex)
    {
      String msg = "while setting up RAMSES" ;
      _logger.fatal(msg, ex);
      ServiceProvider.SYS_ERR_REP.fatal(msg, ex);
      System.exit(0);
    }
  }
  
  private static void printHelp(JSAP jsapHelp, String[] args)
  {
    
    StringBuilder sb =
        new StringBuilder("\nGeneral Configuration Usage:\n\n") ;
    sb.append(jsapHelp.getUsage()) ;
    sb.append("\n\n") ;
    sb.append(jsapHelp.getHelp()) ;
    _reporter.reportMessage(MessageStatus.INFO, sb.toString()) ;
  }
  
  // Setup and register switches into the given JASP parser, analysis and
  // transformation.
  private static void initSwitches(JSAP jsap) throws JSAPException
  {
    helpOnlyMode =
          new Switch(HELP_ONLY_OPTION_ID).setLongFlag("help").setShortFlag('h') ;
    helpOnlyMode.setHelp("Print help for usage") ;
    parseOnlyMode =
          new Switch(PARSE_ONLY_OPTION_ID).setLongFlag("parse")
                .setShortFlag(JSAP.NO_SHORTFLAG) ;
    parseOnlyMode.setHelp("Only parse input models") ;
    analysisOnlyMode =
          new Switch(ANALYSIS_ONLY_OPTION_ID).setLongFlag("analysis")
                .setShortFlag(JSAP.NO_SHORTFLAG) ;
    analysisOnlyMode
          .setHelp("Parse, instantiate and analyze the instance model") ;
    analysis =
          (QualifiedSwitch) (new QualifiedSwitch(ANALYSIS_LIST_OPTION_ID)
                .setShortFlag('a').setLongFlag(JSAP.NO_LONGFLAG).setList(true)
                .setListSeparator(',').setAllowMultipleDeclarations(false)) ;
    ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
    Set<String> analysisNames = sr.getAvailableAnalysisNames() ;
    String availableAnalysis = "" ;

    if(!analysisNames.isEmpty())
    {
      StringBuilder sb = new StringBuilder() ;

      for(String s : analysisNames)
      {
        sb.append(s) ;
        sb.append(", ") ;
      }

      // Escapes the last separator.
      sb.setLength(sb.length() - 2) ;
      availableAnalysis = sb.toString() ;
    }

    analysis
          .setHelp("List of analysis to be performed on instance model; available analysis identifiers are: " +
                availableAnalysis) ;
    
    FlaggedOption logging = new FlaggedOption(LOGGING_OPTION_ID)
      .setStringParser(JSAP.STRING_PARSER).setRequired(false)
      .setLongFlag("log").setShortFlag('l').setList(false)
      .setAllowMultipleDeclarations(false) ;
    
    logging.setHelp("enable the logging file and set the level (ALL | TRACE | DEBUG | INFO | WARN | ERROR | FATAL") ;
    
    FlaggedOption model =
          new FlaggedOption(SOURCE_MODELS_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(true)
                .setLongFlag("model").setShortFlag('m').setList(true)
                .setListSeparator(',')
                .setAllowMultipleDeclarations(false) ;
    model.setHelp("List of input aadl files") ;
    
    FlaggedOption includes =
          new FlaggedOption(INCLUDES_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("include").setShortFlag('i').setList(true)
                .setListSeparator(',')
                .setAllowMultipleDeclarations(false) ;
    includes.setHelp("List of path to find input models") ;
    
    FlaggedOption runtimePath =
          new FlaggedOption(RUNTIME_PATH_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("runtime-path").setShortFlag('r').setList(false)
                .setAllowMultipleDeclarations(false) ;
    runtimePath.setHelp("Path to the targeted platform runtime") ;
    
    FlaggedOption system_to_instantiate =
          new FlaggedOption(SYSTEM_TO_INSTANTIATE_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("system").setShortFlag('s').setList(false)
                .setAllowMultipleDeclarations(false) ;
    system_to_instantiate
          .setHelp("Name of the system to instantiate in input aadl files") ;
    
    QualifiedSwitch superimposition_files =
          (QualifiedSwitch) (new QualifiedSwitch(
                SUPERIMPOSITION_FILES_OPTION_ID).setShortFlag('t')
                .setLongFlag("transformation").setList(true)
                .setListSeparator(',').setAllowMultipleDeclarations(false)) ;
    superimposition_files
          .setHelp("Determines whether model transformation is performed or not:\n"
                + "-t or --transformation only launch the uninstanciate.atl model transformation"
                + "-t:MyFile.asm launch the superimposition of uninstanciate.atl with MyFile.atl") ;
    
    FlaggedOption post_transformation_files =
          new FlaggedOption(POST_TRANSFORMATION_FILES_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("post-transformation").setShortFlag('x')
                .setList(true).setListSeparator(',')
                .setAllowMultipleDeclarations(false) ;
    post_transformation_files
          .setHelp("ASM file names used to refine the result of the superimposed uninstanciate model transformation") ;
    
    FlaggedOption generated_file_path =
          new FlaggedOption(OUTPUT_DIR_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("output").setShortFlag('o').setList(false)
                .setAllowMultipleDeclarations(false) ;
    generated_file_path.setHelp("Directory where files will be generated") ;
                  
   FlaggedOption workflow_path =
        new FlaggedOption(WORKFLOW_OPTION_ID)
                  .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                  .setLongFlag("workflow").setShortFlag(JSAP.NO_SHORTFLAG).setList(false)
                  .setAllowMultipleDeclarations(false) ;
   workflow_path.setHelp("The specified ecore file contains the workflow") ;

    FlaggedOption generation =
        new FlaggedOption(GENERATION_OPTION_ID)
            .setStringParser(JSAP.STRING_PARSER).setRequired(false)
            .setLongFlag("generation").setShortFlag('g').setList(false)
            .setAllowMultipleDeclarations(false) ;

    generation.setHelp("Targeted platform for code generation (pok, etc.).") ;

    FlaggedOption parameters =
           new FlaggedOption(PARAMETER_OPTION_ID)
                  .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                  .setLongFlag("parameter").setShortFlag('p').setList(true)
                  .setListSeparator(',')
                  .setAllowMultipleDeclarations(false) ;
                  
    parameters.setHelp("additional parameters given as key=value format") ;
    
    jsap.registerParameter(helpOnlyMode) ;
    jsap.registerParameter(parseOnlyMode) ;
    jsap.registerParameter(logging) ;
    jsap.registerParameter(model) ;
    jsap.registerParameter(includes) ;
    
    jsap.registerParameter(analysisOnlyMode) ;
    jsap.registerParameter(analysis) ;
    jsap.registerParameter(system_to_instantiate) ;
    jsap.registerParameter(generated_file_path) ;
    
    jsap.registerParameter(superimposition_files) ;
    jsap.registerParameter(post_transformation_files) ;
    jsap.registerParameter(generation) ;
    jsap.registerParameter(runtimePath);
    jsap.registerParameter(workflow_path) ;
    jsap.registerParameter(parameters);
  }

  private static Map<String, Object> parametersHandler(JSAPResult config)
                                                                throws ConfigurationException
  {
    String[] unparsedParameters = config.getStringArray(PARAMETER_OPTION_ID) ;

    Map<String, Object> result = new HashMap<String, Object>() ;

    if(unparsedParameters.length != 0)
    {
      result = new HashMap<String, Object>() ;

      for(String tmp : unparsedParameters)
      {
        String[] splited = tmp.split(PARAMETER_SEPARATOR) ;

        if(splited.length == 2)
        {
          result.put(splited[0], splited[1]) ;
        }
        else // Wrong parameters format.
        {
          String errorMsg =
                "wrong parameters format: must be " + PARAMETER_OPTION_ID ;
          _logger.fatal(errorMsg);
          ConfigStatus.NOT_VALID.msg = errorMsg ;
          throw new ConfigurationException(ConfigStatus.NOT_VALID) ;
        }
      }
    }

    return result ;
  }
  
  private static void commonOptionsHandler(JSAPResult options) throws ConfigurationException 
  {
    String loggingOption = options.getString(LOGGING_OPTION_ID) ;
    
    String currentDirectory = System.getProperty("user.dir") ;
    
    File logFile = new File(currentDirectory + File.separator + LOGGING_FILENAME) ;
    
    RamsesConfiguration.setupLogging(loggingOption, logFile) ;
    
    String[] includeFolderNames =
          options.getStringArray(INCLUDES_OPTION_ID) ;
    String[] mainModels = options.getStringArray(SOURCE_MODELS_OPTION_ID) ;
    
    boolean[] faultyDirs = new boolean[includeFolderNames.length] ;
    
    _includeDirs = FileUtils.checkFilesExist(includeFolderNames, faultyDirs) ;
    
    for (int i = 0 ; i < faultyDirs.length ; i++)
    {
      if(faultyDirs[i])
      {
        String msg = "the directory \'" + includeFolderNames[i] + "\' is not found" ;
        _logger.error(msg);
        ServiceProvider.SYS_ERR_REP.error(msg, true);
      }
    }
    
    /*** Always set Ramses resouce dirs before initialize Service Registry, instantiator and AADL models manager !!! ***/
    setRamsesResourceDir(_includeDirs) ;
    
    RamsesProgressMonitor monitor = new RamsesProgressMonitor(System.out) ;
    
    
    StandAloneInstantiator instantiator = new StandAloneInstantiator(ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER,
                                                                     monitor) ;
    PredefinedAadlModelManager modelManager = new ContributedAadlRegistration(instantiator) ;
    
    ServiceRegistry registry = ServiceProvider.getServiceRegistry() ;
    
    registry.init(instantiator, modelManager);
    /**************************************************************************/
    
    
    _launcher = new ToolSuiteLauncher(monitor, instantiator, modelManager) ;
    
    _mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   _includeDirs) ;
  }
  
  private static void parse(JSAPResult options) 
  {
    _launcher.parsePredefinedRessources() ;
    List<Resource> modelResources = _launcher.performParse(_mainModelFiles) ;
    MessageStatus ms = MessageStatus.INFO ;
    
    String msg = "parsing has " ;
    
    ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
    
    if(sr.getNbError() > 0)
    {
      msg += "FAILED" ;
    }
    else
    {
      msg += "SUCCEEDED" ;
    }
    
    _reporter.reportMessage(ms, msg) ;
    
    // Unparse if --output option is set.
    // Unparsing will crash if the model have name resolution errors. But it 
    // still can't be possible to discriminate the nature of the errors.
    // So unparse anyway.
    String unparse_file_path =
        options.getString(OUTPUT_DIR_OPTION_ID) ;
    
    if (unparse_file_path != null && !unparse_file_path.isEmpty())
    {
      RamsesConfiguration ramsesConfig = new RamsesConfiguration() ;
      ConfigStatus status = ramsesConfig.setOutputDir(unparse_file_path) ;
      
      if(status == ConfigStatus.SET)
      {
        try
        {
          _launcher.unparse(modelResources, ramsesConfig) ;
        }
        catch (IOException e)
        {
          String errMsg = "while unparsing" ;
          _logger.fatal(errMsg, e);
          ServiceProvider.SYS_ERR_REP.fatal(errMsg, e);
          System.exit(0);
        }
      }
    }
  }

  private static void instantiationOptionsHandler(JSAPResult options,
                                                  RamsesConfiguration config)
                                                                throws ConfigurationException
  {
    _systemToInstantiate =
          options.getString(SYSTEM_TO_INSTANTIATE_OPTION_ID) ;
    String output_path =
          options.getString(OUTPUT_DIR_OPTION_ID) ;
    
    
    ConfigStatus status = config.setOutputDir(output_path) ;
    if(status != ConfigStatus.SET)
    {
      _logger.fatal(status.msg);
      throw new ConfigurationException(status) ;
    }
  }
  
  private static void analyse(JSAPResult options) throws AnalysisException,
                                                         ConfigurationException
  {
    RamsesConfiguration config = new RamsesConfiguration() ;
    instantiationOptionsHandler(options, config);
    
    String[] analysisToPerform =
          options.getStringArray(ANALYSIS_LIST_OPTION_ID) ;
   
    _launcher.parsePredefinedRessources() ;
    
    if(analysisToPerform.length > 0)
    {
      _launcher.initializeAnalysis(analysisToPerform) ;
      
      Map<String, Object> parameters = parametersHandler(options) ;
        
      _launcher.performAnalysis(_mainModelFiles, _systemToInstantiate, config,
                                  parameters) ;
    }
  }
  
  private static File[] toArray(Set<File> fileSet)
  {
    File[] result = new File[fileSet.size()] ;
    fileSet.toArray(result) ;
    return result ;
  }
  
  private static void generation(JSAPResult options) throws AnalysisException,
                                                         ConfigurationException,
                                                            GenerationException,
                                                         TransformationException
  {
    RamsesConfiguration config = new RamsesConfiguration() ;
    instantiationOptionsHandler(options, config);
    
    String targetName = options.getString(GENERATION_OPTION_ID) ;
    ConfigStatus status = config.setGenerationTargetId(targetName) ;
    if(status != ConfigStatus.SET)
    {
      _logger.fatal(status.msg) ;
      throw new ConfigurationException(status) ;
    }
    
    String path = options.getString(RUNTIME_PATH_OPTION_ID) ;
    
    _logger.trace("runtime path given as an arg: \'" + path + '\'') ;
    
    status = config.setRuntimePath(path) ;
    if(status != ConfigStatus.SET)
    {
      _logger.fatal(status.msg) ;
      throw new ConfigurationException(status) ;
    }
    
    _launcher.parsePredefinedRessources() ;
    
    File[] inclDirs = toArray(_includeDirs) ;
    
    String workflow_path =
          options.getString(WORKFLOW_OPTION_ID) ;
      
    Map<String, Object> parameters = parametersHandler(options) ;
      
    if(workflow_path != null)
    {
      try
      {
        File workflowFile = org.osate.utils.FileUtils.stringToFile(workflow_path) ;
        
        EcoreWorkflowPilot xmlPilot = new EcoreWorkflowPilot(workflowFile.toString());
          
        _launcher.launchWorkflowProcess(_mainModelFiles,
                                        _systemToInstantiate,
                                        config,
                                        inclDirs,
                                        xmlPilot,
                                        parameters) ;
      }
      catch (FileNotFoundException ex)
      {
        String msg = "generation workflow file \'" + workflow_path + "\' is not found" ;
        _logger.fatal(msg, ex);
        ServiceProvider.SYS_ERR_REP.fatal(msg, ex);
        System.exit(0);
      }
    }
    else
    {
      _launcher.launchDefaultGenerationProcess(_mainModelFiles,
                                               _systemToInstantiate,
                                               config,
                                               inclDirs,
                                               parameters) ;
    }
  }

  private static List<File> getVerifiedPath(String[] filePath,
                                            Set<File> includeDirs) throws ConfigurationException
  {
    List<File> verifiedPaths = new ArrayList<File>() ;
    boolean error = false ;
    String errorMessage = "";

    for(int i = 0 ; i < filePath.length ; i++)
    {
      File potentialFile = new File(filePath[i]) ;
      
      if(potentialFile.exists())
      {
        verifiedPaths.add(potentialFile) ;
        
        try
        {
          File containingDir = org.osate.utils.FileUtils.getContainingDirectory(potentialFile) ;
          includeDirs.add(containingDir) ;
        }
        catch (NullPointerException e)
        {
          // Nothing to do.
        }
        continue ;
      }

      boolean pathFound = false ;

      for(File includeDir : includeDirs)
      {
        potentialFile = verifyPath(includeDir, filePath[i]) ;
        if(potentialFile != null)
        {
          verifiedPaths.add(potentialFile) ;
          pathFound = true ;
          break ;
        }
      }
      
      potentialFile = verifyInRamsesDirs(filePath[i]) ;
      if(potentialFile != null)
      {
        verifiedPaths.add(potentialFile) ;
        pathFound = true ;
      }
      
      if(pathFound == false)
      {
        errorMessage = "file \'" + filePath[i] + "\' not found";
        error = true ;
        break ;
      }
    }

    if(error == true)
    {
      _logger.fatal(errorMessage) ;
      ConfigStatus.NOT_FOUND.msg = errorMessage ;
      throw new ConfigurationException(ConfigStatus.NOT_FOUND);
    }

    return verifiedPaths ;
  }
  
  private static File verifyInRamsesDirs(String path)
  {
    File result = verifyPath(RamsesConfiguration.getAadlPackageDir(), path) ;
    
    if(result == null)
    {
      result = verifyPath(RamsesConfiguration.getAadlPropertysetDir(), path) ;
      
      if(result == null)
      {
        result = verifyPath(RamsesConfiguration.getRamsesResourceDir(), path) ;
        
        if(result == null)
        {
          result = verifyPath(RamsesConfiguration.getAtlResourceDir(), path) ;
          
          if(result == null)
          {
            verifyPath(RamsesConfiguration.getPredefinedResourceDir(), path) ;
          }
        }
        
      }
    }
    
    return result ;
  }
  
  private static File verifyPath(File includeDir, String path)
  {
    File result = new File(includeDir + File.separator + path) ;
    
    if(! result.exists())
    {
      result = null ;
    }
    
    return result ;
  }

  private static void setRamsesResourceDir(Set<File> includeFolder)
                                                   throws ConfigurationException
  {
    ConfigStatus status = null;
    short count = 0 ;
    boolean hasToThrow = false ;
    
    for(File folder : includeFolder)
    {
      if(count != 1)
      {
        status = RamsesConfiguration.setRamsesResourceDir(folder.toString()) ;
        if(status == ConfigStatus.SET)
        {
          count += 1 ;
          
          if(count/100 != 1)
          {
            status = RamsesConfiguration.setPredefinedResourceDir(folder.toString() + File.separator +
                                                                  Names.AADL_RESOURCE_DIRECTORY_NAME) ;
            if(status == ConfigStatus.SET)
            {
              count += 100 ;
            }
          }
        }
      }
      
      if(count/10 != 1)
      {
        status = RamsesConfiguration.setAtlResourceDir(folder.toString()) ;
        if(status == ConfigStatus.SET)
        {
          count += 10 ;
        }
      }
      
      if(count/100 != 1)
      {
        status = RamsesConfiguration.setPredefinedResourceDir(folder.toString()) ;
        if(status == ConfigStatus.SET)
        {
          count += 100 ;
        }
      }
    }
    
    if(count != 111)
    {
      String folder = EnvUtils.getEnvVariable(Names.RAMSES_RESOURCES_VAR) ;
      
      status = RamsesConfiguration.setRamsesResourceDir(folder) ;
      if(status == ConfigStatus.SET)
      {
        status = RamsesConfiguration.setAtlResourceDir(folder) ;
        if(status == ConfigStatus.SET)
        {
          status = RamsesConfiguration.setPredefinedResourceDir(folder) ;
          if(status != ConfigStatus.SET)
          {
            String calculatedPredefinedDir = folder + File.separator + Names.AADL_RESOURCE_DIRECTORY_NAME ; 
            
            status = RamsesConfiguration.setPredefinedResourceDir(calculatedPredefinedDir) ;
            if(status != ConfigStatus.SET)
            {
              _logger.fatal(status.msg);
              hasToThrow = true ;
            }
          }
        }
        else
        {
          _logger.fatal(status.msg);
          hasToThrow = true ;
        }
      }
      else
      {
        _logger.fatal(status.msg);
        hasToThrow = true ;
      }
    }
    
    if(hasToThrow)
    {
      throw new ConfigurationException(status) ;
    }
  }
}