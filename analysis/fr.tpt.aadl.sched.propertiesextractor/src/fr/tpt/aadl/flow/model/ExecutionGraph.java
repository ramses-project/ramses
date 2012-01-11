package fr.tpt.aadl.flow.model ;

import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.flow.analysis.util.LongestAndShortestPath ;
import fr.tpt.aadl.flow.analysis.util.TaskSequence ;
import fr.tpt.aadl.util.properties.PropertyUtils ;

public class ExecutionGraph
{

  private RTAction initGraph = null ;
  private RTAction iterationGraph = null ;
  private RTAction reducedSteadyState = null ;
  private ExecutionGraphRegistry registry ;

  private int priority = -1 ;

  private float startTime = -1 ;
  private float WCET = -1 ;

  public final ComponentInstance getTask()
  {
    return iterationGraph.getElement() ;
  }

  public final int getPriority()
  {
    return priority ;
  }

  public final RTAction getInitGraph()
  {
    return initGraph ;
  }

  public final RTAction getIterationGraph()
  {
    return iterationGraph ;
  }

  public RTAction getSteadyState()
  {
    if(reducedSteadyState == null)
    {
      recomputeSteadyState() ;
    }

    return reducedSteadyState ;
  }

  public float getStartTime()
  {
    if(startTime == -1)
    {
      recomputeStartTime() ;
    }

    return startTime ;
  }

  public float getWCET()
  {
    if(WCET == -1)
    {
      recomputeWCET() ;
    }

    return WCET ;
  }

  public TaskSequence getSynchronizationInstants()
  {
    return new TaskSequence(iterationGraph.reduceFromMe()) ;
  }

  public ExecutionGraphRegistry getRegistry()
  {
    return registry ;
  }

  public void recomputeSteadyState()
  {
    reducedSteadyState = iterationGraph.reduceFromMe() ;
  }

  public void recomputeStartTime()
  {
    //computedWCIS = TaskAction.createEmptyAction("Worst_Case_Init_Sequence_Start", getInitGraph().getElement());
    startTime =
          LongestAndShortestPath.getLongestPath(getInitGraph(), getInitGraph()
                                                      .getEnd()) ;
  }

  public void recomputeWCET()
  {
    //computedWCES = TaskAction.createEmptyAction("Worst_Case_Iteration_Sequence_Start", getInitGraph().getElement());
    WCET =
          LongestAndShortestPath.getLongestPath(getIterationGraph(),
                                                getIterationGraph().getEnd()) ;
  }

  public boolean isUsingResource(String resourceID)
  {
    return getSynchronizationInstants().getAccessedResources()
          .contains(resourceID) ;
  }

  public void setInitGraph(RTAction initGraph)
  {
    this.initGraph = initGraph ;
    priority = computePriority() ;
  }

  public void setIterationGraph(RTAction iterationGraph)
  {
    this.iterationGraph = iterationGraph ;
    priority = computePriority() ;
  }

  private int computePriority()
  {
    try
    {
      return (int) PropertyUtils.getIntValue(getTask(), "Priority") ;
    }
    catch(Exception e)
    {
      return 0 ;
    }
  }

  void setRegistry(ExecutionGraphRegistry registry)
  {
    this.registry = registry ;
  }

  public String toString()
  {
    return "Initialization graph : \n" + initGraph + "\n\n" +
          "Iteration graph : \n" + iterationGraph + "\n\n" +
          "Steady state sequence : \n" + getSteadyState() + "\n\n" ;
  }
}
