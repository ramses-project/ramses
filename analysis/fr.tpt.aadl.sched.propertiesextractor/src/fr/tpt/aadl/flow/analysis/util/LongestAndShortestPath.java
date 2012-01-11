package fr.tpt.aadl.flow.analysis.util ;

import java.util.ArrayList ;
import java.util.List ;

import org.jgrapht.Graph ;
import org.jgrapht.GraphPath ;
import org.jgrapht.alg.FloydWarshallShortestPaths ;
import org.jgrapht.graph.DefaultDirectedWeightedGraph ;
import org.jgrapht.graph.DefaultWeightedEdge ;

import fr.tpt.aadl.flow.model.RTAction ;

public class LongestAndShortestPath
{

  private static class TaskActionEdge extends DefaultWeightedEdge
  {
    /**
     *
     */
    private static final long serialVersionUID = -6370836410508768410L ;

    private RTAction source ;
    @SuppressWarnings("unused")
    private RTAction dest ;

    private TaskActionEdge(
                           RTAction source, RTAction dest)
    {
      this.source = source ;
      this.dest = dest ;
    }
  }

  private static void fillGraphFrom(RTAction source,
                                    DefaultDirectedWeightedGraph<RTAction, TaskActionEdge> graph,
                                    List<RTAction> visited,
                                    int coeff)
  {
    if(!visited.contains(source))
    {
      visited.add(source) ;

      for(RTAction next : source.getNext())
      {
        TaskActionEdge edge = new TaskActionEdge(source, next) ;

        if(!graph.containsVertex(source))
        {
          graph.addVertex(source) ;
        }

        if(!graph.containsVertex(next))
        {
          graph.addVertex(next) ;
        }

        graph.addEdge(source, next, edge) ;

        if(coeff == -1)
        {
          graph.setEdgeWeight(edge, source.getMaxExecutionTime() * coeff) ;
        }
        else
        {
          graph.setEdgeWeight(edge, source.getMinExecutionTime() * coeff) ;
        }

        fillGraphFrom(next, graph, visited, coeff) ;
      }
    }
  }

  private static GraphPath<RTAction, TaskActionEdge> FloywdWarshallShortestPaths(Graph<RTAction, TaskActionEdge> graph,
                                                                                 RTAction source,
                                                                                 RTAction dest)
  {
    FloydWarshallShortestPaths<RTAction, TaskActionEdge> algo =
          new FloydWarshallShortestPaths<RTAction, TaskActionEdge>(graph) ;
    GraphPath<RTAction, TaskActionEdge> path =
          algo.getShortestPath(source, dest) ;
    return path ;
  }

  @SuppressWarnings(
  {"unchecked", "rawtypes"})
  public static float getLongestPath(RTAction source,
                                     RTAction end)
  {
    if(source == end)
    {
      return source.getMaxExecutionTime() ;
    }

    DefaultDirectedWeightedGraph<RTAction, TaskActionEdge> g =
          new DefaultDirectedWeightedGraph(TaskActionEdge.class) ;
    fillGraphFrom(source, g, new ArrayList<RTAction>(), -1) ;
    GraphPath<RTAction, TaskActionEdge> path =
          FloywdWarshallShortestPaths(g, source, end) ;
    List<TaskActionEdge> edgeList = path.getEdgeList() ;
    float size = 0 ;

    for(TaskActionEdge edge : edgeList)
    {
      size += edge.source.getMaxExecutionTime() ;
    }

    return size ;
  }

  @SuppressWarnings(
  {"unchecked", "rawtypes"})
  public static float getShortestPath(RTAction source,
                                      RTAction end)
  {
    DefaultDirectedWeightedGraph<RTAction, TaskActionEdge> g =
          new DefaultDirectedWeightedGraph(TaskActionEdge.class) ;
    fillGraphFrom(source, g, new ArrayList<RTAction>(), -1) ;
    GraphPath<RTAction, TaskActionEdge> path =
          FloywdWarshallShortestPaths(g, source, end) ;
    List<TaskActionEdge> edgeList = path.getEdgeList() ;
    float size = 0 ;

    for(TaskActionEdge edge : edgeList)
    {
      size += edge.source.getMinExecutionTime() ;
    }

    return size ;
  }
}
