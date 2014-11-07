package fr.tpt.aadl.ramses.generation.utils;

import java.util.LinkedHashSet;
import java.util.Set;

import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.* ;

public class ProcessProperties
{
  public ProcessProperties(String prefix)
  {
	this.prefix=prefix;
  }
  
  public String prefix = "";
  
  public boolean hasBlackboard = false ; 
  
  public boolean hasQueue = false ;
  
  public boolean hasBuffer = false ;
  
  public boolean hasEvent = false ;
  
  public boolean hasSample = false ;
  
  public boolean hasVirtual = false ;
  
  public Set<GlobalQueueInfo> globalQueueInfo = new LinkedHashSet<GlobalQueueInfo>() ;
  
  public Set<BlackBoardInfo> blackboardInfo = new LinkedHashSet<BlackBoardInfo>() ;
  
  public Set<EventInfo> eventInfo = new LinkedHashSet<EventInfo>() ;
  
  public Set<QueueInfo> bufferInfo = new LinkedHashSet<QueueInfo>() ;
  
  public Set<QueueInfo> queueInfo = new LinkedHashSet<QueueInfo>();
  
  public Set<SampleInfo> sampleInfo = new LinkedHashSet<SampleInfo>();

  public boolean hasSemaphore;
  
  public Set<String> semaphoreNames = new LinkedHashSet<String>();

  public Set<String> virtualNames = new LinkedHashSet<String>();

}