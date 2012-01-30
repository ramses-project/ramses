package fr.tpt.aadl.ramses.control.support.generator;

import java.io.File ;
import java.util.Map ;

import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;

public interface AadlTargetUnparser
{
  public void process(ProcessorSubcomponent processor,
                      File generatedFilePath,
                      TargetProperties tarProp) 
                                        throws GenerationException ;
  
  public void process(ProcessSubcomponent process,
                      File generatedFilePath,
                      TargetProperties tarProp) throws GenerationException ;
  
  public TargetProperties process(SystemImplementation si,
                                  File generatedFilePath)
                                                throws GenerationException ;
  
  public void setParameters(Map<Enum<?>, Object> parameters) ;
}
