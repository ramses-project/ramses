package fr.tpt.aadl.ramses.generator.pok.c;

import java.util.HashMap ;
import java.util.Map ;

import org.osate.aadl2.ProcessImplementation ;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;

public class PokProperties implements TargetProperties
{
  public boolean consoleFound = false ;
  
  public boolean stdioFound = false ;
  
  public boolean stdlibFound = false ;
  
  public int requiredStackSize = 0 ;
  
  public Map<ProcessImplementation, Long> requiredStackSizePerPartition = 
        new HashMap<ProcessImplementation, Long>();
  public Map<ProcessImplementation, PartitionProperties> partitionProperties = 
        new HashMap<ProcessImplementation, PartitionProperties>();
  
/*
  private Map<ProcessImplementation, PartitionProperties> _partitionMapping = 
                     new HashMap<ProcessImplementation, PartitionProperties>() ;

  public PartitionProperties getPartitionProperties(ProcessImplementation process)
  {
    return _partitionMapping.get(process) ;
  }
  
  public void putPartitionProperties(ProcessImplementation process,
                                     PartitionProperties partitionProp)
  {
    _partitionMapping.put(process, partitionProp) ;
  }
*/
}