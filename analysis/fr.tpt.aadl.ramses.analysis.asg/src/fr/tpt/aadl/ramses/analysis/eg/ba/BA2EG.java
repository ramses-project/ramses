package fr.tpt.aadl.ramses.analysis.eg.ba;

import java.util.HashMap ;
import java.util.Map ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.ThreadClassifier ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;

import fr.tpt.aadl.ramses.analysis.eg.context.EGContext ;
import fr.tpt.aadl.ramses.analysis.eg.error.NYI ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNodeKind ;
import fr.tpt.aadl.ramses.analysis.eg.util.BehaviorUtil ;


/**
 * Utility class for behavior annex conversion to execution graph.
 * @author Fabien CADORET
 */
public class BA2EG
{
  private final boolean isThread;
  private final NamedElement element;
  private final BehaviorAnnex ba;
  private final String ownerName;
  
  private Map<BehaviorState, EGNode> stateToNode 
  = new HashMap<BehaviorState,EGNode>();
  
  public BA2EG (BehaviorAnnex ba)
  {
    this.ba = ba;
    this.element = (NamedElement) ba.eContainer();
    this.isThread = (element instanceof ThreadClassifier);
    this.ownerName = element.getName();
  }
  
  /**
   * Create and return the execution graph from the behavior annex
   * associated to the thread instance
   * @return root node of the execution graph
   */
  public EGNode toEG ()
  {
    if (ba == null)
    {
      return null;
    }
    
    if (isThread)
    {
      EGContext.getInstance().setCurrentThread((ComponentInstance) element);
    }
    else
    {
      
    }
    
    
    EGNode baRootNode = new EGNode(ownerName + "_ba_node");
    
    statesToEG (baRootNode);
    transitionsToEG (baRootNode);
    
    return baRootNode;
  }
  
  /**
   * Create execution graph skeleton from automaton states
   */
  private void statesToEG (EGNode rootNode)
  {
    EGNode initStateNode = null;
    
    for(BehaviorState state : ba.getStates())
    {
      EGNode stateNode = new EGNode(ownerName + "_ba_state_"+state.getName());
      stateNode.setKind(EGNodeKind.State);
      stateToNode.put(state, stateNode);
      
      if (state.isInitial())
      {
        initStateNode = stateNode;
      }
    }
    
    rootNode.addNext(initStateNode);
  }
  
  /**
   * Fill execution graph skeleton with subgraphs corresponding 
   * to transitions action blocks.
   */
  private void transitionsToEG (EGNode rootNode)
  {
    final BehaviorState mainLoopState = BehaviorUtil.getMainLoopState(ba);
    
    for(BehaviorTransition tr : ba.getTransitions())
    {
      final String trNodeName = ownerName + "_ba_trans_" + tr.getName(); 
      EGNode transNodes = transitionToEG(tr, trNodeName);
      
      BehaviorState source = tr.getSourceState();
      BehaviorState target = tr.getDestinationState();
      EGNode sourceNode    = stateToNode.get(source);
      EGNode targetNode    = stateToNode.get(target);
      
      sourceNode.addNext(transNodes);
      
      if (tr.getDestinationState()!=mainLoopState 
          || (tr.getSourceState().isInitial() && tr.getSourceState()!=mainLoopState))
      {
        transNodes.getBlockEnd().addNext(targetNode);
      }
      else
      {
        rootNode.setBlockEnd(transNodes.getBlockEnd());
        /*System.out.println("Ignore transition to main loop state " 
            + mainLoopState.getName());*/
      }
    }
  }
  
  /**
   * Create a subgraph from a behavior transition. 
   * The subgraph contains nodes corresponding to the action block 
   * associated to the transition. 
   * @param tr behavior transition
   * @param name name of the subgraph root node.
   * @return the subgraph corresponding to the given behavior transition
   */
  private EGNode transitionToEG (BehaviorTransition tr, String name)
  {
    BehaviorActionBlock bak = tr.getActionBlock();
    if (bak != null)
    {
      try
      {
        EGNode nTrans = BehaviorAction2EG.actionBlockToEG(bak, name);
        nTrans.setKind(EGNodeKind.TransitionStart);
        nTrans.getBlockEnd().setKind(EGNodeKind.TransitionEnd);
        return nTrans;
      }
      catch(NYI e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }
}
