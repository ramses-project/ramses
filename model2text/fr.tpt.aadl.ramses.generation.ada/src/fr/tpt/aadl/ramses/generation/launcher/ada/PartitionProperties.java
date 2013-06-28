package fr.tpt.aadl.ramses.generation.launcher.ada;

import java.util.LinkedHashSet;
import java.util.Set;

import fr.tpt.aadl.ramses.generation.launcher.ada.AadlToConfADAUnparser.BlackBoardInfo;
import fr.tpt.aadl.ramses.generation.launcher.ada.AadlToConfADAUnparser.QueueInfo;
import fr.tpt.aadl.ramses.generation.launcher.ada.AadlToConfADAUnparser.SampleInfo;


public class PartitionProperties
{
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