package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.util;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;

import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc ;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph ;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode ;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphFactory ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTulpe ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils ;

public class DependencyGraphUtils
{

  public static DependencyGraph createDependencyGraph(
      TrcSpecification trc,
      Map<List<EObject>, ArrayList<String>> patternMatchingMap)
  {
    DependencyGraph result = GraphFactory.eINSTANCE.createDependencyGraph();
    
    Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
    
    List<List<EObject>> treatedObjects = new ArrayList<List<EObject>>();
    while (patternMatchingIt.hasNext()) 
    {
      Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>)patternMatchingIt.next();
      List<EObject> currentElements = tuple.getKey();
      List<String> currentTransformationAlternatives = tuple.getValue();
      if(true == treatedObjects.contains(currentElements))
        continue;
      else
      {
        treatedObjects.add(currentElements);
        DependencyNode dn = getOrCreateDependencyNode(result, currentElements);
        
        // Retrieve dependencies for each alternative
        for(String ruleId: currentTransformationAlternatives)
        {
          List<List<TaggedRuleApplicationTulpe>> accessibleTupleList =
              TrcUtils.getNormalizedDependencies(trc, currentElements, ruleId);
          
          for(List<TaggedRuleApplicationTulpe> tarList: accessibleTupleList)
          {
            for(TaggedRuleApplicationTulpe tar: tarList)
            {
              DependencyNode nextNode = getOrCreateDependencyNode(result, tar.getPatternMatchedElement());
              
              // Add nodes to arcs 
              
              DependencyArc curToNextArc = GraphFactory.eINSTANCE.createDependencyArc();
              curToNextArc.setSourceNode(dn);
              curToNextArc.setTargetNode(nextNode);
              
              
              DependencyArc nextToCurArc = GraphFactory.eINSTANCE.createDependencyArc();
              nextToCurArc.setSourceNode(nextNode);
              nextToCurArc.setTargetNode(dn);
              
              // Add arcs to nodes
              dn.getOutArcs().add(curToNextArc);
              dn.getInArcs().add(nextToCurArc);
              
              nextNode.getOutArcs().add(nextToCurArc);
              nextNode.getInArcs().add(curToNextArc);
              
            }
          }
          
        }
        
      }
    }
    return result;
  }

  private static DependencyNode
      getOrCreateDependencyNode(DependencyGraph graph,
                                List<EObject> elements)
  {
    DependencyNode result = getDependencyNode(graph,elements);
    if(result!=null)
      return result;
    
    result = GraphFactory.eINSTANCE.createDependencyNode();
    graph.getNodes().add(result);
    result.getMatchedElements().addAll(elements);
    return result ;
  }
  
  public static DependencyNode
      getDependencyNode(DependencyGraph graph,
                        List<EObject> elements)
  {
    for(DependencyNode dn: graph.getNodes())
    {
      if(dn.getMatchedElements().equals(elements))
        return dn;
    }
    return null;
  }

  public static List<DependencyNode>
      getConnectedSubgraph(DependencyGraph dg, List<EObject> currentElements)
  {
    // 1 - Identify nodes for currentElements
    DependencyNode firstNode=null;
    for(DependencyNode dn: dg.getNodes())
    {
      if(dn.getMatchedElements().equals(currentElements))
      {
        firstNode = dn;
        break;
      }
    }
    if(firstNode==null)
      return null;
    
    // 2 - Look for connected nodes
    List<DependencyNode> result = new ArrayList<DependencyNode>();
    getConnectedSubgraph(firstNode,result);
    return result ;
  }
  
  private static void 
      getConnectedSubgraph(DependencyNode dg, List<DependencyNode> result)
  {
    if(result.contains(dg))
      return;
    result.add(dg);
    for(DependencyArc da: dg.getOutArcs())
    {
      DependencyNode target = da.getTargetNode();
      getConnectedSubgraph(target, result);
    }
    for(DependencyArc da: dg.getInArcs())
    {
      DependencyNode source = da.getSourceNode();
      getConnectedSubgraph(source, result);
    }
  }
  
}
