package fr.tpt.aadl.toolsuite.support.generator;

import java.io.File ;
import java.util.Map ;

import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;

public interface TargetBuilderGenerator
{
  public void process(SystemImplementation system,
                      File generatedFilePath)
                          throws GenerationException ;
  
  public void process(ProcessorSubcomponent processor,
                      File generatedFilePath)
                            throws GenerationException ;
  
  public void process(ProcessSubcomponent process,
                      File generatedFilePath)
                            throws GenerationException ;
  
  public void setParameters(Map<Enum<?>, Object> parameters) ;
}
