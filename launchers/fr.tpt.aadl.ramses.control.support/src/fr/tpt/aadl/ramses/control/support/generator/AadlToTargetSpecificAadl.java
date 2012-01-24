package fr.tpt.aadl.ramses.control.support.generator;

import java.io.File ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

public interface AadlToTargetSpecificAadl
{
  public Resource transform(Resource inputResource,
                            Map<String, Resource> standardPropertySets,
                            File generatedFilePath) throws GenerationException ;
  
  public void setParameters(Map<Enum<?>, Object> parameters) ;
}
