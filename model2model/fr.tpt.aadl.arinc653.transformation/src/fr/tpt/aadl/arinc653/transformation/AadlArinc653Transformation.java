package fr.tpt.aadl.arinc653.transformation ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.toolsuite.support.generator.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.toolsuite.support.generator.GenerationException ;
import fr.tpt.aadl.transformation.ATLTransfoLauncher ;

public class AadlArinc653Transformation implements
                                       AadlToTargetSpecificAadl
{
  public static final String ATL_FILE_PATH = 
                           "../../model2model/fr.tpt.aadl.transformation.atl/" ;
  
  public static final String[] ATL_FILE_NAMES = new String[]
        {"ExpandThreadsPorts.asm","ExpandSubprogramCalls.asm",
         "ExpandThreadsDispatchProtocol.asm","CreateThreadsBehavior.asm"};
  
  public static final List<File> ATL_FILES = 
                                    new ArrayList<File>(ATL_FILE_NAMES.length) ;
  
  public static final String GENERATED_FILENAME_PREFIX = "arinc653_specific_" ;
  
  static
  {
    for(String fileName : ATL_FILE_NAMES)
    {
      ATL_FILES.add(new File(ATL_FILE_PATH + fileName)) ;
    }
  }
  
  @Override
  public Resource transform(Resource inputResource,
                            Map<String, Resource> standardPropertySets,
                            File generatedFilePath)
                                                      throws GenerationException
  {
    ATLTransfoLauncher atlTransfo = null ;
    
    try
    {
      atlTransfo = new ATLTransfoLauncher() ;

      File generatorDirectory = new File(ATL_FILE_PATH) ;
      atlTransfo.setGenerationPathDirectory(generatorDirectory) ;

      String aaxlGeneratedFileName = GENERATED_FILENAME_PREFIX + 
                            inputResource.getURI().toFileString() + ".aaxl2" ;
      
      Resource expandedResult =
            atlTransfo.doGeneration(inputResource, standardPropertySets,
                                    ATL_FILES, aaxlGeneratedFileName) ;
      
      /*
      for(File f : postTransformationFiles)
      {
        List<File> refinements = new ArrayList<File>() ;
        refinements.add(f) ;
        expandedResult =
              atlTransfo.doGeneration(expandedResult, standardPropertySets,
                                      refinements, dataTargetfilepath) ;
      }
      */
      
      // DEBUG
      String aadlGeneratedFileName = GENERATED_FILENAME_PREFIX + 
                              inputResource.getURI().toFileString() + ".aadl2" ;
      
      StandAloneInstantiator instantiator =
            StandAloneInstantiator.getInstantiator() ;
      instantiator.serialize(expandedResult, aadlGeneratedFileName) ;

      return expandedResult ;
    }
    catch(Exception e)
    {
      throw new GenerationException(e.getMessage()) ;
    }
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}
