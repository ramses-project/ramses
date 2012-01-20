package fr.tpt.aadl.toolsuite.support.generator;

import java.io.File ;
import java.util.Map ;

import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;

public interface AadlTargetUnparser
{
  public TargetProperties process(ProcessorSubcomponent processor,
                                  File generatedFilePath) 
                                        throws GenerationException ;
  
  public void process(ProcessImplementation process, File generatedFilePath,
                      TargetProperties tarProp) throws GenerationException ;
  
  public void setParameters(Map<TargetUnparserParameter, Object> parameters) ;
}
