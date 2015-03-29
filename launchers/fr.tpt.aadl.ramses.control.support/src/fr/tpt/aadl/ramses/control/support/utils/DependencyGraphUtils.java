package fr.tpt.aadl.ramses.control.support.utils;

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
import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTuple ;

public class DependencyGraphUtils
{

  public static RuleApplicationTuple getActualRuleApplicationTuple(Map<List<EObject>, ArrayList<TrcRule>> patternMatchingMap,
                                                                   List<EObject> matchedElements,
                                                                   TrcRule transformationRuleName)
  {
    Iterator<Entry<List<EObject>, ArrayList<TrcRule>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
    while (patternMatchingIt.hasNext()) 
    {
      Map.Entry<List<EObject>, ArrayList<TrcRule>> tuple = (Map.Entry<List<EObject>, ArrayList<TrcRule>>)patternMatchingIt.next();
      for(TrcRule ruleName: tuple.getValue())
      {
        if(transformationRuleName.equals(ruleName))
        {
          boolean stop=false;
          for(EObject obj : matchedElements)
          {
            if(tuple.getKey().contains(obj)==false)
            {
              stop=true;
              break;
            }
          }
          if(!stop)
          {
            RuleApplicationTuple newRat = new RuleApplicationTuple();
            newRat.setTransformationRule(ruleName);
            newRat.getPatternMatchedElement().addAll(tuple.getKey());
            return newRat;
          }
        }
      }
    }
    return null;
  }
  
  
  private static List<RuleApplicationTuple> getActualRuleApplicationTuple(Map<List<EObject>, ArrayList<TrcRule>> patternMatchingMap,
                                                                          List<TaggedRuleApplicationTuple> dependencyList)
  {
    List<RuleApplicationTuple> result = new ArrayList<RuleApplicationTuple>();
    
    Iterator<Entry<List<EObject>, ArrayList<TrcRule>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
    while (patternMatchingIt.hasNext()) 
    {
      Map.Entry<List<EObject>, ArrayList<TrcRule>> tuple = (Map.Entry<List<EObject>, ArrayList<TrcRule>>)patternMatchingIt.next();
      for(TaggedRuleApplicationTuple trat:dependencyList)
      {
        for(TrcRule ruleName: tuple.getValue())
        {
          if(trat.getTransformationRule().equals(ruleName))
          {
            boolean stop=false;
            for(EObject obj : trat.getPatternMatchedElement())
            {
              if(tuple.getKey().contains(obj)==false)
              {
                stop=true;
                break;
              }
            }
            if(!stop)
            {
              RuleApplicationTuple newRat = new RuleApplicationTuple();
              newRat.setTransformationRule(ruleName);
              newRat.getPatternMatchedElement().addAll(tuple.getKey());
              result.add(newRat);
            }
          }
        }
      }
    }
    
    return result;
  }
  public static DependencyGraph createDependencyGraph(
      TrcSpecification trc,
      Map<List<EObject>, ArrayList<TrcRule>> patternMatchingMap)
  {
    DependencyGraph result = GraphFactory.eINSTANCE.createDependencyGraph();
    
    Iterator<Entry<List<EObject>, ArrayList<TrcRule>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
    
    List<List<EObject>> treatedObjects = new ArrayList<List<EObject>>();
    while (patternMatchingIt.hasNext()) 
    {
      Map.Entry<List<EObject>, ArrayList<TrcRule>> tuple = (Map.Entry<List<EObject>, ArrayList<TrcRule>>)patternMatchingIt.next();
      List<EObject> currentElements = tuple.getKey();
      List<TrcRule> currentTransformationAlternatives = tuple.getValue();
      if(true == treatedObjects.contains(currentElements))
        continue;
      else
      {
        treatedObjects.add(currentElements);
        
        // Retrieve dependencies for each alternative
        for(TrcRule ruleId: currentTransformationAlternatives)
        {
          DependencyNode dn = getOrCreateDependencyNode(result,
                                                        currentElements,
                                                        ruleId);
          
          List<List<TaggedRuleApplicationTuple>> accessibleTupleList =
              TrcUtils.getNormalizedDependencies(trc, currentElements, ruleId);
          
          for(List<TaggedRuleApplicationTuple> tarList: accessibleTupleList)
          {
            List<RuleApplicationTuple> realTarList = 
                getActualRuleApplicationTuple(patternMatchingMap, tarList);
                
            for(RuleApplicationTuple tar: realTarList)
            {
              DependencyNode nextNode = getOrCreateDependencyNode(result, 
                                                                  tar.getPatternMatchedElement(),
                                                                  tar.getTransformationRule());
              
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
                                List<EObject> elements,
                                TrcRule rule)
  {
    DependencyNode result = getDependencyNode(graph,
                                              elements,
                                              rule);
    if(result!=null)
      return result;
    
    result = GraphFactory.eINSTANCE.createDependencyNode();
    graph.getNodes().add(result);
    result.getMatchedElements().addAll(elements);
    result.setTransformationRule(rule);
    return result ;
  }
  
  public static DependencyNode
      getDependencyNode(DependencyGraph graph,
                        List<EObject> elements,
                        TrcRule rule)
  {
    for(DependencyNode dn: graph.getNodes())
    {
      TrcRule dnRuleName = dn.getTransformationRule();
      if(dn.getMatchedElements().equals(elements)
          && dnRuleName.equals(rule))
        return dn;
    }
    return null;
  }

  public static List<DependencyNode>
      getConnectedSubgraph(DependencyGraph dg, 
                           List<EObject> currentElements,
                           TrcRule rule)
  {
    // 1 - Identify nodes for currentElements
    DependencyNode firstNode=null;
    for(DependencyNode dn: dg.getNodes())
    {
      if(dn.getMatchedElements().equals(currentElements)
          && dn.getTransformationRule().equals(rule))
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
