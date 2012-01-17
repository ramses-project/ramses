package fr.tpt.aadl.pok.c.unparser;

import java.util.HashSet ;
import java.util.Set ;

public class CpuProperties
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

class PartitionProperties
{
  public Set<String> blackboardNames = new HashSet<String>() ;
}
