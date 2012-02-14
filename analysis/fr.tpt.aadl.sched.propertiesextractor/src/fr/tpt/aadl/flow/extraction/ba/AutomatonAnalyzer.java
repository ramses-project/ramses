package fr.tpt.aadl.flow.extraction.ba ;

import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.model.RTAction ;

public abstract class AutomatonAnalyzer extends BAElementAnalyzer
{

  protected final ExtractionContext ctxt ;

  public AutomatonAnalyzer(
                           ExtractionContext ctxt)
  {
    super(ctxt.getErrManager()) ;
    this.ctxt = ctxt ;
  }

  protected boolean checkIsCompatibleSpecification(BehaviorAnnex ba)
  {
    List<BehaviorTransition> transitions = ba.getBehaviorTransitions() ;

    for(int indexTr = 0 ; indexTr < transitions.size() ; indexTr++)
    {
      BehaviorTransition tran = transitions.get(indexTr) ;
      BehaviorActionSequence actions =
            (BehaviorActionSequence) tran.getBehaviorActionBlockOwned()
                  .getBehaviorActionsOwned() ;

      for(BehaviorAction action : actions.getBehaviorActions())
      {
        if(action instanceof LoopStatement)
        {
          reportError(action,
                      "Unable to perform time analysis : task behavior must not owns loop/while/do statements") ;
          return false ;
        }
      }
    }

    return true ;
  }

  protected static boolean isInitial(BehaviorTransition t,
                                     String stateID)
  {
    Identifier s = t.getSourceStateIdentifiers().get(0) ;
    BehaviorState bs = (BehaviorState) s.getBaRef() ;
    return (s.getId().equals(stateID) && bs.isInitial()) ;
  }

  protected static void registerStatesIntoGraph(BehaviorAnnex ba,
                                                ComponentInstance task,
                                                Map<String, RTAction> stateToStart,
                                                Map<String, RTAction> stateToEnd)
  {
    String ownerID = ((NamedElement) ba.getOwner()).getName() ;
    ownerID = ownerID.replace(".", "_") ;

    for(BehaviorState s : ba.getBehaviorStates())
    {
      Identifier stateID = s.getIdentifierOwned() ;
      String id = stateID.getId() ;
      RTAction st =
            RTAction.createEmptyAction(ownerID + "_entering_state_" + id, task) ;
      RTAction end =
            RTAction.createEmptyAction(ownerID + "_leaving_state_" + id, task) ;
      st.setJoin(end) ;
      stateToStart.put(id, st) ;
      stateToEnd.put(id, end) ;
    }
  }

}
