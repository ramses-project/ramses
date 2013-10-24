package fr.tpt.aadl.flow.extraction.ba ;

import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.LoopStatement ;

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
    List<BehaviorTransition> transitions = ba.getTransitions() ;

    for(int indexTr = 0 ; indexTr < transitions.size() ; indexTr++)
    {
      BehaviorTransition tran = transitions.get(indexTr) ;
      BehaviorActionBlock bab = tran.getActionBlock();
      
      BehaviorActionSequence actions =
            (BehaviorActionSequence) bab.getContent();

      for(BehaviorAction action : actions.getActions())
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
    BehaviorState bs = t.getSourceState() ;
    return (bs.getName().equals(stateID) && bs.isInitial()) ;
  }

  protected static void registerStatesIntoGraph(BehaviorAnnex ba,
                                                ComponentInstance task,
                                                Map<String, RTAction> stateToStart,
                                                Map<String, RTAction> stateToEnd)
  {
    String ownerID = ((NamedElement) ba.getOwner()).getName() ;
    ownerID = ownerID.replace(".", "_") ;

    for(BehaviorState s : ba.getStates())
    {
      String id = s.getName() ;
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
