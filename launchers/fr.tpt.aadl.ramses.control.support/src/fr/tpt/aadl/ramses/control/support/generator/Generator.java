package fr.tpt.aadl.ramses.control.support.generator ;

import java.io.File ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin ;

public interface Generator extends NamedPlugin
{
  public void generate(SystemInstance instance,
                       Map<String, Resource> standardPropertySets,
                       File generatedFilePath) throws GenerationException ;

  public void setParameters(Map<Enum<?>, Object> parameters)
        throws Exception ;
}
