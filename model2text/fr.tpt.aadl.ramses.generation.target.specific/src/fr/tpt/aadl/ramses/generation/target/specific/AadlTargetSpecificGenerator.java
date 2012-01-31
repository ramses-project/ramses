package fr.tpt.aadl.ramses.generation.target.specific;

import java.io.File ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.control.support.generator.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;

public class AadlTargetSpecificGenerator implements Generator
{
  protected AadlToTargetSpecificAadl _targetTrans ;
  
  protected AadlTargetSpecificCodeGenerator _codeGen ;
  
  protected String _registryName = null ;
  
  public AadlTargetSpecificGenerator(AadlToTargetSpecificAadl targetTrans,
                                     AadlTargetSpecificCodeGenerator codeGen)
  {
    _targetTrans = targetTrans ;
    _codeGen = codeGen ;
  }
  
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
  public void generate(SystemInstance instance,
                       Map<String, Resource> standardPropertySets,
                       File generatedFilePath)
                                                      throws GenerationException
  {
    Resource inputResource = instance.eResource() ;
    
    Resource r = _targetTrans.transform(inputResource, standardPropertySets,
                                        generatedFilePath) ;
    
    _codeGen.generate(r, generatedFilePath) ;
  }

  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
        throws Exception
  {
    throw new UnsupportedOperationException() ;
  }
}