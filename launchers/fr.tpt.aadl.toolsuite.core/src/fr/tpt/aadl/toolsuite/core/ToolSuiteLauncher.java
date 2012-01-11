package fr.tpt.aadl.toolsuite.core ;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;

import org.eclipse.emf.common.util.URI ;
import java.util.ArrayList ;
import java.util.EnumMap ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.emf.common.util.BasicMonitor ;
import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.PublicPackageSection ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.generation.code.AadlToCUnparser ;
import fr.tpt.aadl.generation.code.GenerationUtils ;
import fr.tpt.aadl.generation.makefile.pok.AadlToMakefileUnparser ;
import fr.tpt.aadl.generation.makefile.pok.GenerateMakefile ;
import fr.tpt.aadl.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.resources.manager.PredefinedPackagesManager ;
import fr.tpt.aadl.resources.manager.PredefinedPropertiesManager ;
import fr.tpt.aadl.toolsuite.support.analysis.AnalysisResultException ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistry ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;
import fr.tpt.aadl.toolsuite.support.generator.GeneratorParameter ;

public class ToolSuiteLauncher
{

  private ServiceRegistry _registry ;
  private PredefinedPropertiesManager _predefinedPropertiesManager ;
  private PredefinedPackagesManager _predefinedRuntimeManager ;
  private StandAloneInstantiator _instantiator ;
  private List<String> _analysisToPerform ;
  private List<String> _transformationToPerform ;

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

  public void initializeTransformation(String[] transformationIdentifiers)
        throws Exception
  {
    _transformationToPerform =
          initialize(transformationIdentifiers, _registry
                           .getAvailableTransformationNames()) ;
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

  public void parsePredefinedRessources(File aadlResourcesDir)
  {
    try
    {
      _predefinedPropertiesManager
            .extractStandardPropertySets(aadlResourcesDir) ;
      _predefinedRuntimeManager =
            new PredefinedPackagesManager(aadlResourcesDir) ;
    }
    catch(Exception e1)
    {
      e1.printStackTrace() ;
    }
  }

  public Resource launchTransformation(List<File> mainModels,
                                       String systemToInstantiate,
                                       File target_directory,
                                       List<File> transformationFileNames,
                                       List<File> postTransformationFileNames,
                                       String transformationDir)
        throws AnalysisResultException
  {
    List<Resource> aadlModels = _instantiator.parse(mainModels) ;
    return this.launchModelTransformation(aadlModels, systemToInstantiate,
                                          target_directory,
                                          transformationFileNames,
                                          postTransformationFileNames,
                                          transformationDir) ;
  }

  public Resource launchModelTransformation(List<Resource> aadlModels,
                                            String systemToInstantiate,
                                            File target_directory,
                                            List<File> transformationFiles,
                                            List<File> postTransformationFiles,
                                            String transformationDir)
        throws AnalysisResultException
  {
    Resource output = null ;
    SystemInstance instance =
          _instantiator.instantiate(aadlModels, systemToInstantiate) ;

    if(instance == null)
    {
      throw new AnalysisResultException() ;
    }

    this.performAnalysis(instance) ;
    Resource instanceResource = instance.eResource() ;
    Map<String, Resource> standardPropertySets ;
    standardPropertySets =
          _predefinedPropertiesManager.extractStandardPropertySets(aadlModels) ;
    Map<GeneratorParameter, String> parameters =
          new EnumMap<GeneratorParameter, String>(GeneratorParameter.class) ;
    parameters.put(GeneratorParameter.GENERATION_PATH, transformationDir) ;

    try
    {
      for(String transName : _transformationToPerform)
      {
        Generator generator = _registry.getTransformation(transName) ;
        generator.setParameters(parameters) ;
        String dataTargetfilepath =
              target_directory +
                    instanceResource.getURI().toFileString()
                          .substring(instanceResource.getURI().toFileString()
                                           .lastIndexOf('/'),
                                     instanceResource.getURI().toFileString()
                                           .lastIndexOf(".aaxl2")) + ".aaxl2" ;
        Resource expandedResult =
              generator.doGeneration(instanceResource, standardPropertySets,
                                     transformationFiles, dataTargetfilepath) ;

        for(File f : postTransformationFiles)
        {
          List<File> refinements = new ArrayList<File>() ;
          refinements.add(f) ;
          expandedResult =
                generator.doGeneration(expandedResult, standardPropertySets,
                                       refinements, dataTargetfilepath) ;
        }

        dataTargetfilepath =
              target_directory +
                    instanceResource.getURI().toFileString()
                          .substring(instanceResource.getURI().toFileString()
                                           .lastIndexOf('/'),
                                     instanceResource.getURI().toFileString()
                                           .lastIndexOf(".aaxl2")) + ".aadl2" ;
        _instantiator.serialize(expandedResult, dataTargetfilepath) ;
        TreeIterator<EObject> iter = expandedResult.getAllContents() ;
        File generatedCodeDirectory =
              new File(target_directory + "/generated-code") ;
        generatedCodeDirectory.mkdir() ;

        while(iter.hasNext())
        {
          Element elt = (Element) iter.next() ;

          if(elt instanceof SystemImplementation)
          {
            SystemImplementation si = (SystemImplementation) elt ;
            AadlToMakefileUnparser makefileGenerator =
                  new AadlToMakefileUnparser() ;
            File makeFileDir = new File(target_directory + "/generated-code") ;
            makefileGenerator.generateMakefile(si, makeFileDir) ;

            for(ProcessorSubcomponent ps : si.getOwnedProcessorSubcomponents())
            {
              // create directory with the processor subcomponent name
              File processorMakeFileDir =
                    new File(target_directory + "/generated-code/" +
                          ps.getName()) ;
              processorMakeFileDir.mkdir() ;
              makefileGenerator.generateMakefile(ps, processorMakeFileDir) ;
              AadlToCUnparser generator_C = new AadlToCUnparser() ;
              generator_C.doProcess(ps) ;
              generator_C.saveGeneratedKernelFiles(processorMakeFileDir) ;
            }

            for(ProcessSubcomponent ps : si.getOwnedProcessSubcomponents())
            {
              String bindingProcessorName =
                    GenerationUtils.getDeloymentProcessorSubcomponentName(ps)
                          .getName() ;
              String generationTargetDirectory =
                    target_directory + "/generated-code/" +
                          bindingProcessorName + "/" + ps.getName() ;
              File processDirectory = new File(generationTargetDirectory) ;
              boolean processDirectoryCreated = processDirectory.mkdir() ;
              AadlToCUnparser generator_C = new AadlToCUnparser() ;
              Resource baseTypes =
                    _predefinedRuntimeManager.getBaseTypesResource() ;
              generator_C.doProcess((Element) baseTypes.getContents().get(0)) ;
              generator_C.doProcess(ps) ;
              generator_C.saveGeneratedFilesContent(processDirectory) ;
              makefileGenerator.generateMakefile(ps, processDirectory) ;
            }
          }
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
    }

    return output ;
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
}
