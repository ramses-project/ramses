package fr.tpt.aadl.ramses.generation.pok.c;

import java.util.LinkedHashSet;
import java.util.Set;

import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser.BlackBoardInfo;
import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser.QueueInfo;
import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser.SampleInfo;

public class PartitionProperties
{
	
  public PartitionProperties(String prefix)
  {
	this.prefix=prefix;
  }
  
  public String prefix = "";
  
  public boolean hasBlackboard = false ; 
  
  public boolean hasQueue = false ;
  
  public boolean hasBuffer = false ;
  
  public boolean hasEvent = false ;
  
  public boolean hasSample = false ;
  
  public Set<BlackBoardInfo> blackboardInfo = new LinkedHashSet<BlackBoardInfo>() ;
  
  public Set<String> eventNames = new LinkedHashSet<String>() ;
  
  public Set<QueueInfo> bufferInfo = new LinkedHashSet<QueueInfo>() ;
  
  public Set<QueueInfo> queueInfo = new LinkedHashSet<QueueInfo>();
  
  public Set<SampleInfo> sampleInfo = new LinkedHashSet<SampleInfo>();
  
}