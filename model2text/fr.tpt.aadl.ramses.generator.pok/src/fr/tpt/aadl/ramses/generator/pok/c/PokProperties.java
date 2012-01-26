package fr.tpt.aadl.ramses.generator.pok.c;

import java.util.HashMap ;
import java.util.Map ;

import org.osate.aadl2.ProcessImplementation ;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;

public class PokProperties implements TargetProperties
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