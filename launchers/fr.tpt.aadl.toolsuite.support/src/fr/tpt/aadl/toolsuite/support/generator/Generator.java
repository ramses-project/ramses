package fr.tpt.aadl.toolsuite.support.generator ;

import java.io.File ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.toolsuite.support.plugins.NamedPlugin ;

public interface Generator extends NamedPlugin
{
  public void generate(Resource inputResource,
                       Map<String, Resource> standardPropertySets,
                       File generatedFilePath) throws GenerationException ;

  public void setParameters(Map<GeneratorParameter, String> parameters)
        throws Exception ;
}
