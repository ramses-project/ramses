package fr.tpt.aadl.flow.analysis.util ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;

import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.flow.model.ExecutionGraphRegistry ;

public class BlockingTimeComputation
{

  private ExecutionGraph graph ;

  private final float dGet ;
  private final float dRelease ;

  /*
  private HashMap<CheddarTask, TaskAction> taskToReduce = new HashMap<CheddarTask, TaskAction>();
  private HashMap<CheddarTask, Integer> taskToReadTime = new HashMap<CheddarTask, Integer>();
  private HashMap<CheddarTask, Integer> taskToWriteTime = new HashMap<CheddarTask, Integer>();*/

  private final TaskSequence seq ;

  private static HashMap<ExecutionGraph, BlockingTimeComputation> graphToComp ;

  public static void init()
  {
    graphToComp = null ;
  }

  public static float computeFor(ExecutionGraph g)
  {
    if(graphToComp == null)
    {
      graphToComp = new HashMap<ExecutionGraph, BlockingTimeComputation>() ;
      ExecutionGraphRegistry reg = g.getRegistry() ;

      for(ExecutionGraph g2 : reg.getAllExecutionGraphs())
      {
        graphToComp.put(g2, new BlockingTimeComputation(g2)) ;
      }
    }

    return graphToComp.get(g).getBlockingTime() ;
  }

  private BlockingTimeComputation(
                                  ExecutionGraph g)
  {
    this.graph = g ;
    this.seq = graph.getSynchronizationInstants() ;
    this.dGet = seq.getdGet() ;
    this.dRelease = seq.getdRelease() ;
  }

  private float getBlockingTime()
  {
    List<String> uses = seq.getAccessedResources() ;
    float B = 0 ;

    for(String r : uses)
    {
      float Br = computeBlockingTime(r) ;
      B = Math.max(Br, B) ;
    }

    return B ;
  }

  private float computeBlockingTime(String r)
  {
    List<ExecutionGraph> users = getUsersOf(r) ;
    float B = 0 ;

    for(ExecutionGraph u : users)
    {
      float BU = computeCS(u, r) ;
      B = Math.max(B, BU) ;
    }

    return B ;
  }

  private List<ExecutionGraph> getUsersOf(String r)
  {
    List<ExecutionGraph> allG = graph.getRegistry().getAllExecutionGraphs() ;
    List<ExecutionGraph> usersLow = new ArrayList<ExecutionGraph>() ;

    for(ExecutionGraph u : allG)
    {
      if((u.getPriority() < graph.getPriority()) && (u.isUsingResource(r)))
      {
        usersLow.add(u) ;
      }
    }

    return usersLow ;
  }

  private float computeCS(ExecutionGraph t,
                          String r)
  {
    float CSr = computeCSr(t, r) ;
    float CSw = computeCSw(t, r) ;
    return Math.max(CSr, CSw) ;
  }

  private float computeCSr(ExecutionGraph t,
                           String r)
  {
    float execTime ;
    List<ResourceAccess> readList ;
    TaskSequence seqt = t.getSynchronizationInstants() ;
    readList = seqt.getReadAccesses() ;
    execTime = seqt.getReadTime() + (dGet + dRelease) * readList.size() ;
    int indexCurrent = readList.indexOf(seqt.getReadAccess(r)) ;

    for(int index = indexCurrent + 1 ; index < readList.size() ; index++)
    {
      String r2 = readList.get(index).getResourceID() ;
      float B = computeBlockingTime(r2) ;
      execTime += B ;
    }

    return execTime ;
  }

  private float computeCSw(ExecutionGraph t,
                           String r)
  {
    float execTime ;
    List<ResourceAccess> writeList ;
    TaskSequence seqt = t.getSynchronizationInstants() ;
    writeList = seqt.getWriteAccesses() ;
    execTime = seqt.getWriteTime() + (dGet + dRelease) * writeList.size() ;
    int indexCurrent = writeList.indexOf(seqt.getWriteAccess(r)) ;

    for(int index = indexCurrent + 1 ; index < writeList.size() ; index++)
    {
      String r2 = writeList.get(index).getResourceID() ;
      float B = computeBlockingTime(r2) ;
      execTime += B ;
    }

    return execTime ;
  }
}
