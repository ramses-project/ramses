package fr.tpt.aadl.pok.c.unparser;

import fr.tpt.aadl.toolsuite.support.generator.TargetProperties ;

public class PokProperties implements TargetProperties
{
  public boolean consoleFound = false ;
  
  public boolean stdioFound = false ;
  
  public boolean stdlibFound = false ;
  
  public int requiredStackSize = -1 ;
  
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