package fr.tpt.aadl.target.specific.generator;

import java.io.File ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.toolsuite.support.generator.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.toolsuite.support.generator.GenerationException ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;
import fr.tpt.aadl.toolsuite.support.generator.GeneratorParameter ;

public class AadlTargetSpecificGenerator implements Generator
{
  protected AadlToTargetSpecificAadl _targetTrans ;
  
  protected AadlTargetSpecificCodeGenerator _codeGen ;
  
  
  @Override
  public String getRegistryName()
  {
    // TODO Auto-generated method stub
    return null ;
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

  @Override
  public Resource generate(Resource inputResource,
                           Map<String, Resource> standardPropertySets,
                           File generatedFilePath)
        throws GenerationException
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public void setParameters(Map<GeneratorParameter, String> parameters)
        throws Exception
  {
    // TODO Auto-generated method stub
    
  }
}
