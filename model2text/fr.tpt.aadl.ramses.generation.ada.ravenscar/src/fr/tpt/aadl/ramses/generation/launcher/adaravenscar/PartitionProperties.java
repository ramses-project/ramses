package fr.tpt.aadl.ramses.generation.launcher.adaravenscar;

import java.util.LinkedHashSet;
import java.util.Set;

public class PartitionProperties
{
  public boolean hasBlackboard = false ; 
  
  public boolean hasQueue = false ;
  
  public boolean hasBuffer = false ;
  
  public boolean hasEvent = false ;
  
  public boolean hasSample = false ;
    
  public Set<String> eventNames = new LinkedHashSet<String>() ;
  
}