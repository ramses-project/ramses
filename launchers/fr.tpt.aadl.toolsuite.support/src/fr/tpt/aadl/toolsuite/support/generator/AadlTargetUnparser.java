package fr.tpt.aadl.toolsuite.support.generator;

import java.io.File ;
import java.util.Map ;

import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.instance.SystemInstance;

public interface AadlTargetUnparser
{
	
  public void process(SystemInstance system,
		  			  File generatedFilePath)
		  			  throws GenerationException ;
  
  public TargetProperties process(ProcessorSubcomponent processor,
                                  File generatedFilePath) 
                                        throws GenerationException ;
  
  public void process(ProcessImplementation process, File generatedFilePath,
                      TargetProperties tarProp) throws GenerationException ;
  
  public void setParameters(Map<TargetUnparserParameter, Object> parameters) ;
}
