package fr.tpt.aadl.ramses.generation.pok.c;

import java.util.HashSet;
import java.util.Set;

import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser.BlackBoardInfo;
import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser.QueueInfo;
import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser.SampleInfo;

public class PartitionProperties
{
  public boolean hasBlackboard = false ; 
  
  public boolean hasQueue = false ;
  
  public boolean hasBuffer = false ;
  
  public boolean hasEvent = false ;
  
  public boolean hasSample = false ;
  
  public Set<BlackBoardInfo> blackboardInfo = new HashSet<BlackBoardInfo>() ;
  
  public Set<String> eventNames = new HashSet<String>() ;
  
  public Set<QueueInfo> bufferInfo = new HashSet<QueueInfo>() ;
  
  public Set<QueueInfo> queueInfo = new HashSet<QueueInfo>();
  
  public Set<SampleInfo> sampleInfo = new HashSet<SampleInfo>();
  
}