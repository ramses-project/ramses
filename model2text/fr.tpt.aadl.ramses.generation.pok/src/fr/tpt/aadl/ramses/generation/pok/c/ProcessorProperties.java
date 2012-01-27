package fr.tpt.aadl.ramses.generation.pok.c;

import java.util.HashMap ;
import java.util.Map ;

import org.osate.aadl2.ProcessImplementation ;

public class ProcessorProperties
{
  boolean consoleFound = false ;
  
  boolean stdioFound = false ;
  
  boolean stdlibFound = false ;
  
  int requiredStackSize = 0 ;
  
  Map<ProcessImplementation, Long> requiredStackSizePerPartition = 
        new HashMap<ProcessImplementation, Long>();
  Map<ProcessImplementation, PartitionProperties> partitionProperties = 
        new HashMap<ProcessImplementation, PartitionProperties>();
}