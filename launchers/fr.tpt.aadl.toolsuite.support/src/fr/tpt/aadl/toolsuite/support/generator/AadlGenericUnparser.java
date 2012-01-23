package fr.tpt.aadl.toolsuite.support.generator;

import java.io.File ;
import java.util.Map ;

import org.osate.aadl2.Element ;

public interface AadlGenericUnparser
{
  public void process(Element element, File generatedFilePath) 
        throws GenerationException ;
  
  public void setParameters(Map<Enum<?>, Object> parameters) ;
}
