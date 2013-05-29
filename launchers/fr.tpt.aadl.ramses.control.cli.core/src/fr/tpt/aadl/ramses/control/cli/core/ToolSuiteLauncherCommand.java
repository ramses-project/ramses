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
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.emf.ecore.resource.Resource ;

import com.martiansoftware.jsap.FlaggedOption ;
import com.martiansoftware.jsap.JSAP ;
import com.martiansoftware.jsap.JSAPException ;
import com.martiansoftware.jsap.JSAPResult ;
import com.martiansoftware.jsap.QualifiedSwitch ;
import com.martiansoftware.jsap.Switch ;

import fr.tpt.aadl.ramses.control.support.EcorePilot;
import fr.tpt.aadl.ramses.control.support.Names ;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.XMLPilot ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException ;
import fr.tpt.aadl.ramses.control.support.reporters.MessageStatus ;
import fr.tpt.aadl.ramses.control.support.reporters.StandAloneInternalErrorReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.DefaultMessageReporter ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;


public class ToolSuiteLauncherCommand extends RamsesConfiguration
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
  private static final String RAMSES_DIR ;
  private static final String GENERATION_OPTION_ID = "target_platform" ;
  
  private static final String PARAMETER_SEPARATOR = "=" ;
  private static final String PARAMETER_OPTION_ID = "key"+ 
                                                           PARAMETER_SEPARATOR +
                                                             "value" ;
  private static Switch helpOnlyMode ;
  private static Switch parseOnlyMode ;
  private static Switch analysisOnlyMode ;
  private static QualifiedSwitch analysis ;
  
  private static final String XML_OPTION_ID = "xml_path" ;
  private static final String WORKFLOW_OPTION_ID = "workflow_path" ;
  
  private final static DefaultMessageReporter _reporter = new DefaultMessageReporter();
  private final static StandAloneInternalErrorReporter _errorReporter = new StandAloneInternalErrorReporter(_reporter);
  
  static
  {
    String tmp = System.getProperty(Names.RAMSES_RESOURCES_VAR) ;
    if (tmp == null || tmp.isEmpty())
    {
      tmp = System.getenv(Names.RAMSES_RESOURCES_VAR) ;
    }
    if(! (tmp == null || tmp.isEmpty()))
    {
      RAMSES_DIR = tmp ;
    }
    else // try to found out where it is ...
    {
      File workingDirectory = new File(System.getProperty("user.dir")) ;
      boolean found = false ;
      for (File f : workingDirectory.listFiles())
      {
        // RAMSES resources are in the current working directory: this is the
        // case for the regular RAMSES deployment.
        if(f.isDirectory() && f.getName().equalsIgnoreCase(
                                            Names.AADL_RESOURCE_DIRECTORY_NAME))
        {
          found = true ;
          break ;
        }
      }
      
      if(found)
      {
        RAMSES_DIR = "." ;
      }
      else // finally affect it the default directory for development environment.
      {
        RAMSES_DIR = 
            "../../model2model/fr.tpt.aadl.ramses.transformation.atl/" ;
      }
    }
  }
  
  public static void main(String[] args)
  {
	JSAP jsapHelp = new JSAP() ;
    JSAP jsapParse = new JSAP() ;
    JSAP jsapAnalysis = new JSAP() ;
    JSAP jsapTransfo = new JSAP() ;
    JSAP jsapGen = new JSAP() ;
    ToolSuiteLauncher launcher = new ToolSuiteLauncher() ;

    try
    {
      initSwitches(jsapHelp, jsapParse, jsapAnalysis, jsapTransfo, jsapGen) ;
      JSAPResult helpConf = jsapHelp.parse(args) ;
      boolean helpOnly = helpConf.getBoolean(HELP_ONLY_OPTION_ID) ;

      if(helpOnly)
      {
    	  printHelp(jsapHelp, args);
      }
      
      JSAPResult parseConfig = jsapParse.parse(args) ;
      boolean parseOnly = parseConfig.getBoolean(PARSE_ONLY_OPTION_ID) ;
      jsapParse.unregisterParameter(parseOnlyMode) ;

      if(parseOnly)
      {
        if(parseConfig.success())
        {
          parse(launcher, parseConfig) ;
          System.exit(1) ;
        }
        else
        {
          StringBuilder sb =
                new StringBuilder("\nParsing Configuration Usage:\n\n--parse ") ;
          sb.append(jsapParse.getUsage()) ;
          sb.append("\n\n") ;
          sb.append(jsapParse.getHelp()) ;
          reportError(parseConfig.getErrorMessageIterator(), sb.toString()) ;
          System.exit(0) ;
        }
      }

      JSAPResult analysisConfig = jsapAnalysis.parse(args) ;
      boolean analysisOnly = analysisConfig.getBoolean(ANALYSIS_ONLY_OPTION_ID) ;
      jsapAnalysis.unregisterParameter(analysisOnlyMode) ;

      if(analysisOnly)
      {
        if(analysisConfig.success())
        {
          analyse(launcher, analysisConfig) ;
          System.exit(1) ;
        }
        else
        {
          StringBuilder sb =
                new StringBuilder(
                      "\nAnalysis Configuration Usage:\n\n--analysis ") ;
          sb.append(jsapAnalysis.getUsage()) ;
          sb.append("\n\n") ;
          sb.append(jsapAnalysis.getHelp()) ;
          reportError(analysisConfig.getErrorMessageIterator(), sb.toString()) ;
          System.exit(0) ;
        }
      }

      // Currently disable
//      transformation(launcher, jsapTransfo, args) ;
      
      generation(launcher, jsapGen, args) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      System.exit(0) ;
    }

    // TODO : call unparser
  }

  
  private static void printHelp(JSAP jsapHelp, String[] args)
  {
	  
    StringBuilder sb =
    		new StringBuilder("\nGeneral Configuration Usage:\n\n") ;
    sb.append(jsapHelp.getUsage()) ;
    sb.append("\n\n") ;
    sb.append(jsapHelp.getHelp()) ;
    _reporter.reportMessage(MessageStatus.INFO, sb.toString()) ;
    System.exit(1) ; 
  }
  
  // Setup and register switches into the given JASP parser, analysis and
  // transformation.
  private static void initSwitches(JSAP jsapHelp,
		  						   JSAP jsapParse,
                                   JSAP jsapAnalysis,
                                   JSAP jsapTransfo,
                                   JSAP jsapGen)
        throws JSAPException
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
    ServiceRegistry sr = ServiceRegistryProvider.getServiceRegistry() ;
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
    
    FlaggedOption xml_path =
          new FlaggedOption(XML_OPTION_ID)
                  .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                  .setLongFlag("xml").setShortFlag(JSAP.NO_SHORTFLAG).setList(false)
                  .setAllowMultipleDeclarations(false) ;
    xml_path.setHelp("The specified XML file contains the workflow") ;

                  
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
    
    jsapHelp.registerParameter(helpOnlyMode) ;
    jsapHelp.registerParameter(parseOnlyMode) ;
    jsapHelp.registerParameter(model) ;
    jsapHelp.registerParameter(includes) ;
    
    jsapHelp.registerParameter(analysisOnlyMode) ;
    jsapHelp.registerParameter(analysis) ;
    jsapHelp.registerParameter(system_to_instantiate) ;
    jsapHelp.registerParameter(generated_file_path) ;
    
    jsapHelp.registerParameter(superimposition_files) ;
    jsapHelp.registerParameter(post_transformation_files) ;
    jsapHelp.registerParameter(generation) ;
    jsapHelp.registerParameter(xml_path) ;
    jsapHelp.registerParameter(workflow_path) ;
    jsapHelp.registerParameter(parameters);
    
    jsapParse.registerParameter(model) ;
    jsapParse.registerParameter(includes) ;
    jsapParse.registerParameter(parseOnlyMode) ;
    jsapParse.registerParameter(parameters);
    jsapParse.registerParameter(generated_file_path);
    
    jsapAnalysis.registerParameter(analysis) ;
    jsapAnalysis.registerParameter(model) ;
    jsapAnalysis.registerParameter(includes) ;
    jsapAnalysis.registerParameter(analysisOnlyMode) ;
    jsapAnalysis.registerParameter(system_to_instantiate) ;
    jsapAnalysis.registerParameter(generated_file_path) ;
    jsapAnalysis.registerParameter(parameters);
    jsapAnalysis.registerParameter(helpOnlyMode) ;
    
    jsapTransfo.registerParameter(analysisOnlyMode) ;
    jsapTransfo.registerParameter(helpOnlyMode) ;
    jsapTransfo.registerParameter(parseOnlyMode) ;
    jsapTransfo.registerParameter(model) ;
    jsapTransfo.registerParameter(includes) ;
    jsapTransfo.registerParameter(system_to_instantiate) ;
    jsapTransfo.registerParameter(superimposition_files) ;
    jsapTransfo.registerParameter(post_transformation_files) ;
    jsapTransfo.registerParameter(generated_file_path) ;
    jsapTransfo.registerParameter(analysis) ;
    jsapTransfo.registerParameter(parameters);
    
    
    jsapGen.registerParameter(helpOnlyMode) ;
    jsapGen.registerParameter(parseOnlyMode) ;
    jsapGen.registerParameter(model) ;
    jsapGen.registerParameter(includes) ;
    jsapGen.registerParameter(system_to_instantiate) ;
    jsapGen.registerParameter(generated_file_path) ;
    jsapGen.registerParameter(generation) ;
    jsapGen.registerParameter(xml_path) ;
    jsapGen.registerParameter(workflow_path) ;
    jsapGen.registerParameter(parameters);
  }

  private static Map<String, Object> parametersHandler(JSAPResult config)
        throws Exception
  {
    String[] unparsedParameters = config.getStringArray(PARAMETER_OPTION_ID) ;

    Map<String, Object> result = null ;

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
        else
        // Wrong parameters format.
        {
          String errorMsg =
                "wrong parameters format : must be " + PARAMETER_OPTION_ID ;
          System.err.println(errorMsg) ;
          throw new Exception(errorMsg) ;
        }
      }
    }

    return result ;
  }
  
  @SuppressWarnings("rawtypes")
  private static void reportError(Iterator errs,
                                  String message)
  {
    StringBuilder sb = new StringBuilder() ;

    while(errs.hasNext())
    {
      sb.append("Error: ") ;
      sb.append(errs.next()) ;
      sb.append('\n') ;
    }

    sb.append(message) ;
    _errorReporter.internalErrorImpl(sb.toString()) ;
  }

  private static void parse(ToolSuiteLauncher launcher,
                            JSAPResult parseConfig)
        throws Exception
  {
    String[] includeFolderNames =
          parseConfig.getStringArray(INCLUDES_OPTION_ID) ;
    String[] mainModels = parseConfig.getStringArray(SOURCE_MODELS_OPTION_ID) ;
    
    File aadlResourcesDir =
          ToolSuiteLauncherCommand.getAADLResourcesDir(RAMSES_DIR) ;
    RamsesConfiguration.setRamsesResourcesDir(aadlResourcesDir);
    
    List<File> mainModelFiles ;
    mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   includeFolderNames) ;
    launcher.parsePredefinedRessources() ;
    launcher.parsePredefinedPackages() ;
    List<Resource> modelResources = launcher.parse(mainModelFiles) ;
    MessageStatus ms = MessageStatus.INFO ;
    
    String msg = "instanciation has " ;
    
    ServiceRegistry sr = ServiceRegistryProvider.getServiceRegistry() ;
    
    if(sr.getNbError() > 0)
    {
      msg += "FAILED" ;
    }
    else
    {
      msg += "succeded" ;
    }
    
    _reporter.reportMessage(ms, msg) ;
    
    // Unparse if --output option is set.
    String unparse_file_path =
        parseConfig.getString(OUTPUT_DIR_OPTION_ID) ;
    
    if( ! (
            unparse_file_path == null ||
            unparse_file_path.isEmpty()
          )
      )
    {
      File outputPath = ToolSuiteLauncherCommand.
                                            getVerifiedPath(unparse_file_path) ;
      
      launcher.unparse(modelResources, outputPath) ;
    }
  }

  private static void analyse(ToolSuiteLauncher launcher,
                              JSAPResult analysisConfig)
        throws Exception
  {
    String[] includeFolderNames =
          analysisConfig.getStringArray(INCLUDES_OPTION_ID) ;
    String[] mainModels =
          analysisConfig.getStringArray(SOURCE_MODELS_OPTION_ID) ;
    String[] analysisToPerform =
          analysisConfig.getStringArray(ANALYSIS_LIST_OPTION_ID) ;
    String systemToInstantiate =
          analysisConfig.getString(SYSTEM_TO_INSTANTIATE_OPTION_ID) ;
    String analysis_output_path =
          analysisConfig.getString(OUTPUT_DIR_OPTION_ID) ;
    
    if(analysis_output_path!=null)
    {
      File outputDir =
            ToolSuiteLauncherCommand.getVerifiedPath(analysis_output_path) ;
      RamsesConfiguration.setOutputDir(outputDir);
    }
        
    File aadlResourcesDir =
          ToolSuiteLauncherCommand.getAADLResourcesDir(RAMSES_DIR) ;
    RamsesConfiguration.setRamsesResourcesDir(aadlResourcesDir);
    
    List<File> mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   includeFolderNames) ;
    launcher.parsePredefinedRessources() ;
    launcher.parsePredefinedPackages() ;
    if(analysisToPerform.length > 0)
    {
      try
      {
        launcher.initializeAnalysis(analysisToPerform) ;
      }
      catch(Exception e)
      {
        _errorReporter.internalErrorImpl(e.getMessage());
        _reporter.reportMessage(MessageStatus.INFO, analysis.getHelp()) ;
        System.exit(0) ;
      }

      try
      {
        Map<String, Object> parameters = parametersHandler(analysisConfig) ;
        
        launcher.performAnalysis(mainModelFiles, systemToInstantiate,
                                 parameters) ;
      }
      catch(AnalysisResultException e)
      {
        _errorReporter.internalErrorImpl("An error ocurred when performing analysis: "+analysisToPerform);
        _errorReporter.internalErrorImpl(e.getMessage()) ;
        System.exit(0) ;
      }
    }
  }
  
  private static void generation(ToolSuiteLauncher launcher,
                                 JSAP jsapGen,
                                 String[] args)
                                                   throws Exception
  {
    JSAPResult genConf = jsapGen.parse(args) ;
    
    if(false == genConf.success())
    {
    	StringBuilder sb =
                new StringBuilder("\nParsing Configuration Usage:\n\n--parse ") ;
        sb.append(jsapGen.getUsage()) ;
        sb.append("\n\n") ;
        sb.append(jsapGen.getHelp()) ;
        reportError(genConf.getErrorMessageIterator(), sb.toString()) ;
        System.exit(0) ;
    }
    
    String[] includeFolderNames =
          genConf.getStringArray(INCLUDES_OPTION_ID) ;
    String systemToInstantiate =
          genConf.getString(SYSTEM_TO_INSTANTIATE_OPTION_ID) ;
    String[] mainModels =
          genConf.getStringArray(SOURCE_MODELS_OPTION_ID) ;
    String generated_file_path =
          genConf.getString(OUTPUT_DIR_OPTION_ID) ;
    String resourcesDirName = RAMSES_DIR ;
    
    String targetName = genConf.getString(GENERATION_OPTION_ID) ;

    if(resourcesDirName.endsWith("/") == false)
    {
      resourcesDirName = resourcesDirName + "/" ;
    }

    List<File> mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   includeFolderNames) ;
    
    ToolSuiteLauncherCommand.getVerifiedPath(resourcesDirName) ;
    
    File aadlResourcesDir =
          ToolSuiteLauncherCommand
                .getAADLResourcesDir(resourcesDirName) ;
    
    RamsesConfiguration.setRamsesResourcesDir(aadlResourcesDir);
    
    File atlResourceDir = ToolSuiteLauncherCommand.
                                          getATLResourceDir(resourcesDirName) ;  
    
    launcher.parsePredefinedRessources() ;
    launcher.parsePredefinedPackages() ;
    File outputDir = new File(generated_file_path) ;
    
    try
    {
      outputDir.mkdirs() ;
    }
    catch (Exception e)
    {
      _errorReporter.internalErrorImpl(e) ;
      System.exit(0) ;
    }
    
    RamsesConfiguration.setOutputDir(outputDir);
    
    try
    {
      String workflow_path =
            genConf.getString(WORKFLOW_OPTION_ID) ;
      
      String xml_path =
            genConf.getString(XML_OPTION_ID) ;

      Map<String, Object> parameters = parametersHandler(genConf) ;
      
      if(workflow_path != null)
      {
        EcorePilot xmlPilot = new EcorePilot(genConf.getString(WORKFLOW_OPTION_ID));
        
        launcher.initializeGeneration(targetName) ;
        launcher.launchModelGenerationWorkflow(mainModelFiles,
                                          systemToInstantiate,
                                          outputDir,
                                          targetName,
                                          atlResourceDir,
                                          xmlPilot,
                                          parameters) ;
      }
      else if(xml_path != null)
      {
    	XMLPilot xmlPilot = new XMLPilot(genConf.getString(XML_OPTION_ID));
          
        launcher.initializeGeneration(targetName) ;
        launcher.launchModelGenerationWorkflow(mainModelFiles,
                                          systemToInstantiate,
                                          outputDir,
                                          targetName,
                                          atlResourceDir,
                                          xmlPilot,
                                          parameters) ;
      }
      else
      {
    	launcher.initializeGeneration(targetName) ;
        launcher.launchModelGeneration(mainModelFiles,
                                       systemToInstantiate,
                                       outputDir,
                                       targetName,
                                       atlResourceDir,
                                       parameters) ;
      }
    }
    catch(Exception e)
    {
    	if(System.getProperty("DEBUG")!=null)
        {
            e.printStackTrace() ;
        }
            _errorReporter.internalErrorImpl(e) ;
            System.exit(0) ;
    }

    
  }
  
  private static File getVerifiedPath(String filePath) throws Exception
  {
    File potentialFile = new File(filePath) ;

    if(potentialFile.exists())
    {
      return potentialFile ;
    }

    throw new Exception("file or directory " + potentialFile.getCanonicalPath() +
          " could not be found") ;
  }

  private static List<File> getVerifiedPath(String[] filePath,
                                            String[] includeFolderNames)
        throws Exception
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
        continue ;
      }

      boolean pathFound = false ;

      for(int j = 0 ; j < includeFolderNames.length ; j++)
      {
        if(includeFolderNames[j].endsWith("/") == false)
        {
          includeFolderNames[j] = includeFolderNames[j] + "/" ;
        }

        potentialFile = new File(includeFolderNames[j] + filePath[i]) ;

        if(potentialFile.exists())
        {
          verifiedPaths.add(potentialFile) ;
          pathFound = true ;
          break ;
        }
      }

      if(pathFound == false)
      {
        errorMessage = "file " + new File(filePath[i]).getCanonicalPath() + " could not be found";
        error = true ;
        break ;
      }
    }

    if(error == true)
    {
      throw new Exception(errorMessage);
    }

    return verifiedPaths ;
  }

  private static File getAADLResourcesDir(String transformationDirName)
        throws Exception
  {
    File transformationDir =
          ToolSuiteLauncherCommand.getVerifiedPath(transformationDirName) ;
    File aadlResourcesDir =
          new File(transformationDir.getAbsolutePath() + '/' +
                   Names.AADL_RESOURCE_DIRECTORY_NAME) ;

    if(aadlResourcesDir.exists() == false)
    {
      throw new Exception("ERROR: file " + transformationDirName +
            " does not contain " + Names.AADL_RESOURCE_DIRECTORY_NAME +
            " directory") ;
    }

    return aadlResourcesDir ;
  }
  
  private static File getATLResourceDir(String dirName)
        throws Exception
  {
    File result =
          ToolSuiteLauncherCommand.getVerifiedPath(dirName) ;
    
    return result ;
  }
}