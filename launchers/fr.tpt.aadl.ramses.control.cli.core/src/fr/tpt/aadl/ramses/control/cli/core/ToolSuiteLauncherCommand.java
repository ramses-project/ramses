package fr.tpt.aadl.ramses.control.cli.core ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Set ;

import org.eclipse.emf.ecore.resource.Resource ;

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
import fr.tpt.aadl.ramses.generator.pok.PokGenerator ;


public class ToolSuiteLauncherCommand
{

  private static final String HELP_ONLY_OPTION_ID = "help_only" ;
  private static final String PARSE_ONLY_OPTION_ID = "parse_only" ;
  private static final String ANALYSIS_ONLY_OPTION_ID = "analysis_only" ;
  private static final String ANALYSIS_LIST_OPTION_ID = "analysis_list" ;
  private static final String SOURCE_MODELS_OPTION_ID = "source_models" ;
  private static final String INCLUDES_OPTION_ID = "includes" ;
  private static final String SUPERIMPOSITION_FILES_OPTION_ID =
        "superimposition_files" ;
  private static final String POST_TRANSFORMATION_FILES_OPTION_ID =
        "post_transformation_files" ;
  private static final String TRANSFORMATION_DIR_OPTION_ID =
        "transformation_directory" ;
  private static final String SYSTEM_TO_INSTANTIATE_OPTION_ID =
        "system_to_instantiate" ;
  private static final String TARGER_DIR_OPTION_ID = "target_dir" ;

  private static Switch helpOnlyMode ;
  private static Switch parseOnlyMode ;
  private static Switch analysisOnlyMode ;
  private static QualifiedSwitch analysis ;

  public static void main(String[] args)
  {
    JSAP jsapParse = new JSAP() ;
    JSAP jsapAnalysis = new JSAP() ;
    JSAP jsapTransfo = new JSAP() ;
    ToolSuiteLauncher launcher = new ToolSuiteLauncher() ;

    try
    {
      initSwitches(jsapParse, jsapAnalysis, jsapTransfo) ;
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

      transformation(launcher, jsapTransfo, args) ;
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
                                   JSAP jsapTransfo)
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
                .setShortFlag('m').setList(true).setListSeparator(',')
                .setLongFlag(JSAP.NO_LONGFLAG)
                .setAllowMultipleDeclarations(false) ;
    model.setHelp("List of input aadl files") ;
    FlaggedOption includes =
          new FlaggedOption(INCLUDES_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setShortFlag('i').setList(true).setListSeparator(',')
                .setLongFlag(JSAP.NO_LONGFLAG)
                .setAllowMultipleDeclarations(false) ;
    includes.setHelp("List of path to find input models") ;
    FlaggedOption system_to_instantiate =
          new FlaggedOption(SYSTEM_TO_INSTANTIATE_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(true)
                .setShortFlag('s').setList(false).setLongFlag(JSAP.NO_LONGFLAG)
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
                .setShortFlag('p').setList(true).setListSeparator(',')
                .setLongFlag(JSAP.NO_LONGFLAG)
                .setAllowMultipleDeclarations(false) ;
    post_transformation_files
          .setHelp("ASM file names used to refine the result of the superimposed uninstanciate model transformation") ;
    FlaggedOption transformation_dir =
          new FlaggedOption(TRANSFORMATION_DIR_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(true)
                .setShortFlag('d').setList(false).setLongFlag(JSAP.NO_LONGFLAG)
                .setAllowMultipleDeclarations(false) ;
    transformation_dir
          .setHelp("Path of the directory where to find predefined resources (ASM Files, AADL property set, etc...)") ;
    FlaggedOption target_dir =
          new FlaggedOption(TARGER_DIR_OPTION_ID)
                .setStringParser(JSAP.STRING_PARSER).setRequired(false)
                .setShortFlag('o').setList(false).setLongFlag(JSAP.NO_LONGFLAG)
                .setAllowMultipleDeclarations(false) ;
    target_dir.setHelp("Output directory") ;
    jsapParse.registerParameter(model) ;
    jsapParse.registerParameter(includes) ;
    jsapParse.registerParameter(parseOnlyMode) ;
    jsapParse.registerParameter(transformation_dir) ;
    jsapAnalysis.registerParameter(analysis) ;
    jsapAnalysis.registerParameter(model) ;
    jsapAnalysis.registerParameter(includes) ;
    jsapAnalysis.registerParameter(analysisOnlyMode) ;
    jsapAnalysis.registerParameter(system_to_instantiate) ;
    jsapAnalysis.registerParameter(transformation_dir) ;
    jsapTransfo.registerParameter(analysisOnlyMode) ;
    jsapTransfo.registerParameter(helpOnlyMode) ;
    jsapTransfo.registerParameter(parseOnlyMode) ;
    jsapTransfo.registerParameter(model) ;
    jsapTransfo.registerParameter(includes) ;
    jsapTransfo.registerParameter(system_to_instantiate) ;
    jsapTransfo.registerParameter(superimposition_files) ;
    jsapTransfo.registerParameter(post_transformation_files) ;
    jsapTransfo.registerParameter(transformation_dir) ;
    jsapTransfo.registerParameter(target_dir) ;
    jsapTransfo.registerParameter(analysis) ;
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
    String transformationDirName =
          parseConfig.getString(TRANSFORMATION_DIR_OPTION_ID) ;
    File aadlResourcesDir =
          ToolSuiteLauncherCommand.getAADLResourcesDir(transformationDirName) ;
    List<File> mainModelFiles ;
    mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   includeFolderNames) ;
    launcher.parsePredefinedRessources(aadlResourcesDir) ;
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
    String ressourceDirectoryName =
          analysisConfig.getString(TRANSFORMATION_DIR_OPTION_ID) ;
    File aadlResourcesDir =
          ToolSuiteLauncherCommand.getAADLResourcesDir(ressourceDirectoryName) ;
    List<File> mainModelFiles =
          ToolSuiteLauncherCommand.getVerifiedPath(mainModels,
                                                   includeFolderNames) ;
    launcher.parsePredefinedRessources(aadlResourcesDir) ;

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

  private static void transformation(ToolSuiteLauncher launcher,
                                     JSAP jsapTransfo,
                                     String[] args)
        throws Exception
  {
    /********************* TODO TRANSFORMATION SWITCH ***********************/
    // Temporary
    String[] transformationToPerform = new String[]
    {PokGenerator.GENERATOR_NAME} ;
    /************************************************************************/
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
}