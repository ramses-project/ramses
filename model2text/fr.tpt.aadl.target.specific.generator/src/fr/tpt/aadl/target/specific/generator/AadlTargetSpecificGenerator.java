package fr.tpt.aadl.target.specific.generator;

import java.io.File ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.toolsuite.support.generator.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.toolsuite.support.generator.GenerationException ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;

public class AadlTargetSpecificGenerator implements Generator
{
  protected AadlToTargetSpecificAadl _targetTrans ;
  
  protected AadlTargetSpecificCodeGenerator _codeGen ;
  
  protected String _registryName = null ;
  
  public void setRegistryName(String registryName)
  {
    _registryName = registryName ;
  }
  
  @Override
  public String getRegistryName()
  {
    return _registryName ;
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
  public void generate(Resource inputResource,
                       Map<String, Resource> standardPropertySets,
                       File generatedFilePath)
                                                      throws GenerationException
  {
    Resource r = _targetTrans.transform(inputResource, standardPropertySets,
                                        generatedFilePath) ;
    
    _codeGen.generate(r, generatedFilePath) ;
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
        throws Exception
  {
    throw new UnsupportedOperationException() ;
  }
}