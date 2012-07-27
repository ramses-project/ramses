package fr.tpt.aadl.ramses.generation.pok.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
  
  public List<BlackBoardInfo> blackboardInfo = new ArrayList<BlackBoardInfo>() ;
  
  public List<String> eventNames = new ArrayList<String>() ;
  
  public List<QueueInfo> bufferInfo = new ArrayList<QueueInfo>() ;
  
  public List<QueueInfo> queueInfo = new ArrayList<QueueInfo>();
  
  public List<SampleInfo> sampleInfo = new ArrayList<SampleInfo>();
  
}