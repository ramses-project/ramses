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
import java.util.Iterator ;
import java.util.List ;
import java.util.Set ;


import com.martiansoftware.jsap.FlaggedOption ;
import com.martiansoftware.jsap.JSAP ;
import com.martiansoftware.jsap.JSAPException ;
import com.martiansoftware.jsap.JSAPResult ;
import com.martiansoftware.jsap.QualifiedSwitch ;
import com.martiansoftware.jsap.Switch ;

import fr.tpt.aadl.ramses.control.core.ToolSuiteLauncher ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;


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
  private static final String RESOURCES_DIR_OPTION_ID =
        "resources_directory" ;
  private static final String SYSTEM_TO_INSTANTIATE_OPTION_ID =
        "system_to_instantiate" ;
  private static final String OUTPUT_DIR_OPTION_ID = "output_directory" ;
  
  private static final String GENERATION_OPTION_ID = "target_platform" ;

  private static Switch helpOnlyMode ;
  private static Switch parseOnlyMode ;
  private static Switch analysisOnlyMode ;
  private static QualifiedSwitch analysis ;
  
  public final static String DEFAULT_RESOURCES_DIR = 
                    "../../model2model/fr.tpt.aadl.ramses.transformation.atl/" ; 

  public static void main(String[] args)
  {
    JSAP jsapParse = new JSAP() ;
    JSAP jsapAnalysis = new JSAP() ;
    JSAP jsapTransfo = new JSAP() ;
    JSAP jsapGen = new JSAP() ;
    ToolSuiteLauncher launcher = new ToolSuiteLauncher() ;

    try
    {
      initSwitches(jsapParse, jsapAnalysis, jsapTransfo, jsapGen) ;
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

  // Setup and register switches into the given JASP parser, analysis and
  // transformation.
  private static void initSwitches(JSAP jsapParse,
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
                .setLongFlag("post-transformation").setShortFlag('p')
                .setList(true).setListSeparator(',')
                .setAllowMultipleDeclarations(false) ;
    post_transformation_files
          .setHelp("ASM file names used to refine the result of the superimposed uninstanciate model transformation") ;
    
    FlaggedOption resources_dir =
          new FlaggedOption(RESOURCES_DIR_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("directory").setShortFlag('d').setList(false)
                .setAllowMultipleDeclarations(false) ;
    resources_dir
          .setHelp("Path of the directory where to find predefined resources (ASM Files, AADL property set, etc...)") ;
    
    FlaggedOption generated_file_path =
          new FlaggedOption(OUTPUT_DIR_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("output").setShortFlag('o').setList(false)
                .setAllowMultipleDeclarations(false) ;
    generated_file_path.setHelp("Directory where files will be generated") ;
    
    jsapParse.registerParameter(model) ;
    jsapParse.registerParameter(includes) ;
    jsapParse.registerParameter(parseOnlyMode) ;
    jsapParse.registerParameter(resources_dir) ;
    
    jsapAnalysis.registerParameter(analysis) ;
    jsapAnalysis.registerParameter(model) ;
    jsapAnalysis.registerParameter(includes) ;
    jsapAnalysis.registerParameter(analysisOnlyMode) ;
    jsapAnalysis.registerParameter(system_to_instantiate) ;
    jsapAnalysis.registerParameter(resources_dir) ;
    
    jsapTransfo.registerParameter(analysisOnlyMode) ;
    jsapTransfo.registerParameter(helpOnlyMode) ;
    jsapTransfo.registerParameter(parseOnlyMode) ;
    jsapTransfo.registerParameter(model) ;
    jsapTransfo.registerParameter(includes) ;
    jsapTransfo.registerParameter(system_to_instantiate) ;
    jsapTransfo.registerParameter(superimposition_files) ;
    jsapTransfo.registerParameter(post_transformation_files) ;
    jsapTransfo.registerParameter(resources_dir) ;
    jsapTransfo.registerParameter(generated_file_path) ;
    jsapTransfo.registerParameter(analysis) ;
    
    FlaggedOption generation =
          new FlaggedOption(GENERATION_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setLongFlag("generation").setShortFlag('g').setList(false)
                .setAllowMultipleDeclarations(false) ;
    
    generation.setHelp("Targeted platform for code generation (pok, etc.).") ;
    
    jsapGen.registerParameter(helpOnlyMode) ;
    jsapGen.registerParameter(parseOnlyMode) ;
    jsapGen.registerParameter(model) ;
    jsapGen.registerParameter(includes) ;
    jsapGen.registerParameter(system_to_instantiate) ;
    jsapGen.registerParameter(resources_dir) ;
    jsapGen.registerParameter(generated_file_path) ;
    jsapGen.registerParameter(generation) ;
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
    System.err.println(sb.toString()) ;
  }

  private static void parse(ToolSuiteLauncher launcher,
                            JSAPResult parseConfig)
        throws Exception
  {
    String[] includeFolderNames =
          parseConfig.getStringArray(INCLUDES_OPTION_ID) ;
    String[] mainModels = parseConfig.getStringArray(SOURCE_MODELS_OPTION_ID) ;
    String resourcesDirName =
          parseConfig.getString(RESOURCES_DIR_OPTION_ID) ;
    
    // Optional switch.
    if(resourcesDirName == null)
    {
      resourcesDirName = DEFAULT_RESOURCES_DIR ;
    }
    
    File aadlResourcesDir =
          ToolSuiteLauncherCommand.getAADLResourcesDir(resourcesDirName) ;
    List<File> mainModelFiles ;
    mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   includeFolderNames) ;
    launcher.parsePredefinedRessources(aadlResourcesDir) ;
    launcher.parsePredefinedPackages(aadlResourcesDir) ;
    launcher.parse(mainModelFiles) ;
    System.out.println("Parsing terminated normally") ;
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
    String resourcesDirName =
          analysisConfig.getString(RESOURCES_DIR_OPTION_ID) ;
    
    // Optional switch.
    if(resourcesDirName == null)
    {
      resourcesDirName = DEFAULT_RESOURCES_DIR ;
    }
    
    File aadlResourcesDir =
          ToolSuiteLauncherCommand.getAADLResourcesDir(resourcesDirName) ;
    List<File> mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   includeFolderNames) ;
    launcher.parsePredefinedRessources(aadlResourcesDir) ;
    launcher.parsePredefinedPackages(aadlResourcesDir) ;
    if(analysisToPerform.length > 0)
    {
      try
      {
        launcher.initializeAnalysis(analysisToPerform) ;
      }
      catch(Exception e)
      {
        System.err.println(e.getMessage()) ;
        System.err.println(analysis.getHelp()) ;
        System.exit(0) ;
      }

      try
      {
        launcher.performAnalysis(mainModelFiles, systemToInstantiate) ;
      }
      catch(AnalysisResultException e)
      {
        System.err.println(e.getMessage()) ;
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
    
    boolean helpOnly = genConf.getBoolean(HELP_ONLY_OPTION_ID) ;

    if(helpOnly || false == genConf.success())
    {
      StringBuilder sb =
            new StringBuilder("\nGeneral Configuration Usage:\n\n") ;
      sb.append(jsapGen.getUsage()) ;
      sb.append("\n\n") ;
      sb.append(jsapGen.getHelp()) ;
      System.out.println(sb.toString()) ;
      
      if(genConf.success())
      {
        reportError(genConf.getErrorMessageIterator(), sb.toString()) ;
        System.exit(0) ;
      }
      else
      {
        System.exit(1) ; 
      }
    }
    
    String[] includeFolderNames =
          genConf.getStringArray(INCLUDES_OPTION_ID) ;
    String systemToInstantiate =
          genConf.getString(SYSTEM_TO_INSTANTIATE_OPTION_ID) ;
    String[] mainModels =
          genConf.getStringArray(SOURCE_MODELS_OPTION_ID) ;
    String generated_file_path =
          genConf.getString(OUTPUT_DIR_OPTION_ID) ;
    String resourcesDirName =
          genConf.getString(RESOURCES_DIR_OPTION_ID) ;
    
    // Optional switch.
    if(resourcesDirName == null)
    {
      resourcesDirName = DEFAULT_RESOURCES_DIR ;
    }
    
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
    
    File atlResourceDir = ToolSuiteLauncherCommand.
                                          getATLResourceDir(resourcesDirName) ;  
    
    launcher.parsePredefinedRessources(aadlResourcesDir) ;
    launcher.parsePredefinedPackages(aadlResourcesDir) ;
    File generatedFilePath =
          ToolSuiteLauncherCommand.getVerifiedPath(generated_file_path) ;
    
    try
    {
      launcher.initializeGeneration(targetName) ;
      launcher.launchModelGeneration(mainModelFiles,
                                     systemToInstantiate,
                                     generatedFilePath,
                                     targetName,
                                     atlResourceDir) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      System.err.println(e.getMessage()) ;
      System.exit(0) ;
    }
  }
  
  /*
  private static void transformation(ToolSuiteLauncher launcher,
                                     JSAP jsapTransfo,
                                     String[] args)
        throws Exception
  {
    /********************* TODO TRANSFORMATION SWITCH ***********************/
    // Temporary
//    String[] transformationToPerform = new String[]
//    {PokGenerator.GENERATOR_NAME} ;
    /************************************************************************/
    /*
    System.err.println("TRANSFORMATION IS CURRENTLY DISABLE") ;
    System.exit(0) ;
    
    JSAPResult transfoConfig = jsapTransfo.parse(args) ;
    boolean helpOnly = transfoConfig.getBoolean(HELP_ONLY_OPTION_ID) ;

    if(helpOnly)
    {
      StringBuilder sb =
            new StringBuilder("\nGeneral Configuration Usage:\n\n") ;
      sb.append(jsapTransfo.getUsage()) ;
      sb.append("\n\n") ;
      sb.append(jsapTransfo.getHelp()) ;
      System.out.println(sb.toString()) ;
      System.exit(1) ;
    }
    else
    {
      if(transfoConfig.success())
      {
        String[] analysisToPerform =
              transfoConfig.getStringArray(ANALYSIS_LIST_OPTION_ID) ;
        String[] includeFolderNames =
              transfoConfig.getStringArray(INCLUDES_OPTION_ID) ;
        String systemToInstantiate =
              transfoConfig.getString(SYSTEM_TO_INSTANTIATE_OPTION_ID) ;
        String[] mainModels =
              transfoConfig.getStringArray(SOURCE_MODELS_OPTION_ID) ;
        String target_directory_name =
              transfoConfig.getString(TARGER_DIR_OPTION_ID) ;
        String[] superimpositionFileNames =
              transfoConfig.getStringArray(SUPERIMPOSITION_FILES_OPTION_ID) ;
        String[] postTransformationFileNames =
              transfoConfig.getStringArray(POST_TRANSFORMATION_FILES_OPTION_ID) ;
        String transformationDirName =
              transfoConfig.getString(TRANSFORMATION_DIR_OPTION_ID) ;

        if(transformationDirName.endsWith("/") == false)
        {
          transformationDirName = transformationDirName + "/" ;
        }

        List<File> mainModelFiles =
              ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                       includeFolderNames) ;
        File aadlRessourcesDir =
              ToolSuiteLauncherCommand
                    .getAADLResourcesDir(transformationDirName) ;
        launcher.parsePredefinedRessources(aadlRessourcesDir) ;

        if(analysisToPerform.length > 0)
        {
          try
          {
            launcher.initializeAnalysis(analysisToPerform) ;
          }
          catch(Exception e)
          {
            System.err.println(e.getMessage()) ;
            System.err.println(analysis.getHelp()) ;
            System.exit(0) ;
          }

          try
          {
            launcher.performAnalysis(mainModelFiles, systemToInstantiate) ;
          }
          catch(AnalysisResultException e)
          {
            System.err.println(e.getMessage()) ;
            System.exit(0) ;
          }
        }

        File target_directory =
              ToolSuiteLauncherCommand.getVerifiedPath(target_directory_name) ;
        List<File> superimpositionFiles = new ArrayList<File>() ;
        List<File> postTransformationFiles = new ArrayList<File>() ;

        for(int i = 0 ; i < superimpositionFileNames.length ; i++)
        {
          superimpositionFiles.add(ToolSuiteLauncherCommand
                .getVerifiedPath(transformationDirName +
                      superimpositionFileNames[i])) ;
        }

        for(int i = 0 ; i < postTransformationFileNames.length ; i++)
        {
          postTransformationFiles.add(ToolSuiteLauncherCommand
                .getVerifiedPath(transformationDirName +
                      postTransformationFileNames[i])) ;
        }

        try
        {
          File transformationDir =
                ToolSuiteLauncherCommand.getVerifiedPath(transformationDirName) ;
          launcher.initializeTransformation(transformationToPerform) ;
          Resource result =
                launcher.launchTransformation(mainModelFiles,
                                              systemToInstantiate,
                                              target_directory,
                                              superimpositionFiles,
                                              postTransformationFiles,
                                              transformationDirName) ;
        }
        catch(AnalysisResultException e)
        {
          System.err.println(e.getMessage()) ;
          System.exit(0) ;
        }
      }
      else
      {
        StringBuilder sb =
              new StringBuilder("\nTransformation Configuration Usage:\n\n") ;
        sb.append(jsapTransfo.getUsage()) ;
        sb.append("\n\n") ;
        sb.append(jsapTransfo.getHelp()) ;
        reportError(transfoConfig.getErrorMessageIterator(), sb.toString()) ;
        System.exit(0) ;
      }
    }
    
  }
  */
  
  private static File getVerifiedPath(String filePath)
        throws Exception
  {
    File potentialFile = new File(filePath) ;

    if(potentialFile.exists())
    {
      return potentialFile ;
    }

    throw new Exception("ERROR: file or directory " + filePath +
          " could not be found") ;
  }

  private static List<File> getVerifiedPath(String[] filePath,
                                            String[] includeFolderNames)
        throws Exception
  {
    List<File> verifiedPaths = new ArrayList<File>() ;
    boolean error = false ;

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
        System.err
              .println("ERROR: file " + filePath[i] + " could not be found") ;
        error = true ;
        break ;
      }
    }

    if(error == true)
    {
      throw new Exception() ;
    }

    return verifiedPaths ;
  }

  private static File getAADLResourcesDir(String transformationDirName)
        throws Exception
  {
    File transformationDir =
          ToolSuiteLauncherCommand.getVerifiedPath(transformationDirName) ;
    File aadlResourcesDir =
          new File(transformationDir.getAbsolutePath() + "/aadl_resources") ;

    if(aadlResourcesDir.exists() == false)
    {
      throw new Exception("ERROR: file " + transformationDirName +
            " does not contain aadl_resources directory") ;
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