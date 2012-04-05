package fr.tpt.aadl.flow.extraction.ba.types ;

import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.ba.AutomatonAnalyzer ;
import fr.tpt.aadl.flow.extraction.util.BehaviorAnnexUtil ;
import fr.tpt.aadl.flow.model.RTAction ;

/**
 * Extract execution flow from subprogram behavior annex.
 * @author Fabien Cadoret
 *
 */
public class SubprogramAA extends AutomatonAnalyzer
{

  public SubprogramAA(
                      ExtractionContext ctxt)
  {
    super(ctxt) ;
  }

  public RTAction extractFrom(BehaviorAnnex ba,
                              RTAction lastAction)
  {
    if(!checkIsCompatibleSpecification(ba))
    {
      return null ;
    }
    else
    {
      ComponentInstance task = lastAction.getElement() ;
      return extractFlowFromTransitions(ba, task, lastAction) ;
    }
  }

  private RTAction extractFlowFromTransitions(BehaviorAnnex ba,
                                              ComponentInstance task,
                                              RTAction lastAction)
  {
    final Map<String, RTAction> stateToStart = new HashMap<String, RTAction>() ;
    final Map<String, RTAction> stateToEnd = new HashMap<String, RTAction>() ;
    /** For each state, register start and end actions. */
    registerStatesIntoGraph(ba, task, stateToStart, stateToEnd) ;
    String initStateID = BehaviorAnnexUtil.getInitialState(ba) ;
    String finalStateID = BehaviorAnnexUtil.getFinalState(ba) ;
    RTAction initialAction = stateToStart.get(initStateID) ;
    RTAction endAction = stateToEnd.get(finalStateID) ;
    initialAction.addNext(stateToEnd.get(initStateID)) ;
    List<BehaviorTransition> transitions = ba.getTransitions() ;

    for(int indexTr = 0 ; indexTr < transitions.size() ; indexTr++)
    {
      BehaviorTransition tran = transitions.get(indexTr) ;
      BehaviorActionSequence seq =
            (BehaviorActionSequence) tran.getActionBlock();
      
      List<BehaviorAction> actions = seq.getActions() ;
      String srcState = tran.getSourceState().getName() ;
      String dstState = tran.getDestinationState().getName() ;
      RTAction srcEnd = stateToEnd.get(srcState) ;
      RTAction dstStart = stateToStart.get(dstState) ;
      RTAction dstEnd = stateToEnd.get(dstState) ;
      RTAction last =
            ctxt.getTransitionAnalyzer().extractFrom(task, actions, dstStart) ;
      srcEnd.addNext(dstStart) ;
      last.addNext(dstEnd) ;
    }

    lastAction.addNext(initialAction) ;
    return endAction ;
  }

}
