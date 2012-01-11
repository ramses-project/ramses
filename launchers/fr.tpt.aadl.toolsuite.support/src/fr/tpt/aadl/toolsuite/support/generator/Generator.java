package fr.tpt.aadl.toolsuite.support.generator ;

import java.io.File ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.toolsuite.support.plugins.NamedPlugin ;

public interface Generator extends NamedPlugin
{
  public Resource doGeneration(Resource inputResource,
                               Map<String, Resource> propertySets,
                               List<File> transformationFileName,
                               String dataTargetfilepath)
        throws Exception ;

  public void setParameters(Map<GeneratorParameter, String> parameters)
        throws Exception ;
}
