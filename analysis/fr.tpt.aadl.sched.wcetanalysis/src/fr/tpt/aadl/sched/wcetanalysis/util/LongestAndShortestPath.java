package fr.tpt.aadl.sched.wcetanalysis.util ;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.FloydWarshallShortestPaths;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;

public class LongestAndShortestPath
{

  private static class TaskActionEdge extends DefaultWeightedEdge
  {
    /**
     *
     */
    private static final long serialVersionUID = -6370836410508768410L ;

    private ASTNode source ;
    @SuppressWarnings("unused")
    private ASTNode dest ;

    private TaskActionEdge(
                           ASTNode source, ASTNode dest)
    {
      this.source = source ;
      this.dest = dest ;
    }
  }

  private static void fillGraphFrom(ASTNode source,
                                    DefaultDirectedWeightedGraph<ASTNode, TaskActionEdge> graph,
                                    List<ASTNode> visited,
                                    int coeff)
  {
    if(!visited.contains(source))
    {
      visited.add(source) ;

      for(ASTNode next : source.getNext())
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

  private static GraphPath<ASTNode, TaskActionEdge> FloywdWarshallShortestPaths(Graph<ASTNode, TaskActionEdge> graph,
                                                                                 ASTNode source,
                                                                                 ASTNode dest)
  {
    FloydWarshallShortestPaths<ASTNode, TaskActionEdge> algo =
          new FloydWarshallShortestPaths<ASTNode, TaskActionEdge>(graph) ;
    GraphPath<ASTNode, TaskActionEdge> path =
          algo.getShortestPath(source, dest) ;
    return path ;
  }

  @SuppressWarnings(
  {"unchecked", "rawtypes"})
  public static float getLongestPath(ASTNode source,
                                     ASTNode end)
  {
    if(source == end)
    {
      return source.getMaxExecutionTime() ;
    }

    DefaultDirectedWeightedGraph<ASTNode, TaskActionEdge> g =
          new DefaultDirectedWeightedGraph(TaskActionEdge.class) ;
    fillGraphFrom(source, g, new ArrayList<ASTNode>(), -1) ;
    GraphPath<ASTNode, TaskActionEdge> path =
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
  public static float getShortestPath(ASTNode source,
                                      ASTNode end)
  {
    DefaultDirectedWeightedGraph<ASTNode, TaskActionEdge> g =
          new DefaultDirectedWeightedGraph(TaskActionEdge.class) ;
    fillGraphFrom(source, g, new ArrayList<ASTNode>(), 1) ;
    GraphPath<ASTNode, TaskActionEdge> path =
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
