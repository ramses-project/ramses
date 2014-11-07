package fr.tpt.aadl.ramses.generation.utils;

import java.util.List ;

import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.FeatureInstance ;

public class GenerationInfos
{

  public static class GlobalQueueInfo
  {
    public String id = null;
    
    public ComponentInstance component ;

  }
  
  public static class BlackBoardInfo
  {
    public String id = null ;

    public String dataType = null;
  }

  public static class EventInfo
  {
    public ComponentInstance component ;
    
    public String id = null ;
  }

  public static class QueueInfo
  {    
    public GlobalQueueInfo gQueue = null;

    public List<FeatureInstance> portList ;

    public Long timeOut ;

    public String id = null ;

    public String uniqueId = null;

    public long size = -1 ;

    public String type = null ;

    public String dataType = null;

    public DirectionType direction = null ;

    public int threadPortId = -1 ;

  }

  public static class SampleInfo
  {
    public String id = null ;

    public String uniqueId = null;

    public long refresh = -1 ;

    public String dataType = null;

    public DirectionType direction = null ;
  }

  public static class BufferInfo
  {
    public List<FeatureInstance> portList ;

    public String id = null ;

    public String uniqueId = null;

    public long refresh = -1 ;

    public String dataType = null;

    public DirectionType direction = null ;

  }

}
