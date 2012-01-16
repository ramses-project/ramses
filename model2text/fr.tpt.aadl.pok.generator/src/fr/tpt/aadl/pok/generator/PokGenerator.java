package fr.tpt.aadl.pok.generator;

import java.io.File ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;

import org.osate.aadl2.Element ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;

import fr.tpt.aadl.c.unparser.AadlToCUnparser ;
import fr.tpt.aadl.c.unparser.GenerationUtils ;
import fr.tpt.aadl.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.pok.makefile.generator.AadlToMakefileUnparser ;
import fr.tpt.aadl.resources.manager.PredefinedPackagesManager ;

import fr.tpt.aadl.toolsuite.support.generator.GenerationException ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;
import fr.tpt.aadl.toolsuite.support.generator.GeneratorParameter ;
import fr.tpt.aadl.toolsuite.support.plugins.NamedPlugin ;

import fr.tpt.aadl.transformation.ATLTransfoLauncher ;

public class PokGenerator implements NamedPlugin, Generator 
{
  public final static String GENERATOR_NAME = "PokGenerator" ;

  @Override
  public String getRegistryName()
  {
    return GENERATOR_NAME ;
  }

  @Override
  public String getPluginName()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public String getPluginId()
  {
    // TODO Auto-generated method stub
    return null ;
  }
  
  // It may be factorized in an abstract class.
  private Resource doAtlTransformation(
                                   Resource inputResource,
                                   Map<String, Resource> standardPropertySets,
                                   List<File> transformationFileName,
                                   String dataTargetfilepath,
                                   String transformationDir,
                                   List<File> postTransformationFiles,
                                   File target_directory) throws GenerationException
  {
    ATLTransfoLauncher atlTransfo = null ;
    
    try
    {
      atlTransfo = new ATLTransfoLauncher() ;
      
      if(transformationDir == null || transformationDir.isEmpty())
      {
        throw new GenerationException(GeneratorParameter.GENERATION_PATH.literal +
              " is not set.") ;
      }
      else
      {
        File generatorDirectory = new File(transformationDir) ;
        atlTransfo.setGenerationPathDirectory(generatorDirectory) ;
      }

      Resource expandedResult =
            atlTransfo.doGeneration(inputResource, standardPropertySets,
                                    transformationFileName, dataTargetfilepath) ;

      for(File f : postTransformationFiles)
      {
        List<File> refinements = new ArrayList<File>() ;
        refinements.add(f) ;
        expandedResult =
              atlTransfo.doGeneration(expandedResult, standardPropertySets,
                                     refinements, dataTargetfilepath) ;
      }
      
      // XXX Why an other time ?
      dataTargetfilepath =
            target_directory +
                  inputResource.getURI().toFileString()
                        .substring(inputResource.getURI().toFileString()
                                         .lastIndexOf('/'),
                                         inputResource.getURI().toFileString()
                                         .lastIndexOf(".aaxl2")) + ".aadl2" ;
      
      // DEBUG 
      StandAloneInstantiator instantiator = StandAloneInstantiator.getInstantiator() ;
      instantiator.serialize(expandedResult, dataTargetfilepath) ;
      
      return expandedResult ;
    }
    catch(Exception e)
    {
      throw new GenerationException(e.getMessage()) ;
    }
  }
  
  
  // @Override
  // TODO parameters and interface design refactoring.
  public Resource doGeneration(Resource inputResource,
                               Map<String, Resource> standardPropertySets,
                               List<File> transformationFileName,
                               String dataTargetfilepath,
                               String transformationDir,
                               List<File> postTransformationFiles,
                               Resource baseTypes,
                               File target_directory) throws GenerationException
  {
    Resource expandedResult = doAtlTransformation(inputResource,
                                                  standardPropertySets,
                                                  transformationFileName,
                                                  dataTargetfilepath,
                                                  transformationDir,
                                                  postTransformationFiles,
                                                  target_directory) ;
    
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
//          generator_C.saveGeneratedKernelFiles(processorMakeFileDir) ;
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
          processDirectory.mkdir() ;
          AadlToCUnparser generator_C = new AadlToCUnparser() ;
          
          generator_C.doProcess((Element) baseTypes.getContents().get(0)) ;
          generator_C.doProcess(ps) ;
          generator_C.saveGeneratedFilesContent(processDirectory) ;
          makefileGenerator.generateMakefile(ps, processDirectory) ;
        }
      }
    }  

    // DEBUG
    return null ;
  }

  @Override
  public void setParameters(Map<GeneratorParameter, String> parameters)
        throws Exception
  {
    throw new Exception ();
  }
}