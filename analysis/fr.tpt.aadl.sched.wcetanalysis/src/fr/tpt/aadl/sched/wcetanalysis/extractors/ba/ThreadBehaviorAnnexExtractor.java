package fr.tpt.aadl.sched.wcetanalysis.extractors.ba ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;

import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;

/**
 * Extract execution flow from thread behavior annex.
 * This class uses a BABlockExecutionFlow to extract subgraph
 * from each behavior transition.
 * Each action in the transition is analyzed. If the action is a subprogram call,
 * then it is analyzed also:
 *   Case 1: if it owns a behavior annex, this one is analyzed.

 *   Case 2: if it owns the Computation_Execution_Time property,
 *   a unique action is added with duration equals to the property value.

 *   Case 3: if it has call sequence specification,
 *   a unique action is added with duration equals to the sum of analyzed called subprogram.
 *
 * @author Fabien Cadoret
 *
 *
 */
public class ThreadBehaviorAnnexExtractor extends BehaviorAnnexExtractor
{

  public ThreadBehaviorAnnexExtractor(
                  ExtractionContext ctxt)
  {
    super(ctxt) ;
  }

  public final TaskBody extractFrom(BehaviorAnnex ba,
                                          ComponentInstance task)
  {
    if(!checkIsCompatibleSpecification(ba))
    {
      return null ;
    }
    else
    {
      return extractFromImpl(ba, task) ;
    }
  }

  protected TaskBody extractFromImpl(BehaviorAnnex ba, ComponentInstance taskI)
  {
    final Map<String, ASTNode> stateToStart = new HashMap<String, ASTNode>() ;
    final Map<String, ASTNode> stateToEnd = new HashMap<String, ASTNode>() ;
    /** For each state, register start and end actions. */
    registerStatesIntoGraph(ba, taskI, stateToStart, stateToEnd) ;
    ASTNode iterationStart = null ;
    ASTNode iterationEnd = null ;
    final BehaviorState finalState = getFinalState(ba);
    List<BehaviorTransition> transitions = ba.getTransitions() ;

    for(int indexTr = 0 ; indexTr < transitions.size() ; indexTr++)
    {
      BehaviorTransition tran = transitions.get(indexTr) ;
      
      if (tran.getDestinationState()==finalState)
    	  continue;
      
      List<BehaviorAction> actions = getActions(tran);
      
      String srcState = tran.getSourceState().getName() ;
      String dstState = tran.getDestinationState().getName() ;
      ASTNode srcEnd = stateToEnd.get(srcState) ;
      ASTNode dstStart = stateToStart.get(dstState) ;
      ASTNode dstEnd = stateToEnd.get(dstState) ;
      ASTNode last = ctxt.behaviorActionBlockExtractor.extractFrom(taskI, actions, dstStart);

      
      if(last.getType() == StatementKind.AwaitDispatch)
      {
    	if (dstEnd.getNext().isEmpty())
    	{
    		iterationStart = dstStart;
    		iterationEnd = last;
    	}
    	else
    	{
    		iterationStart = dstEnd.getNext().get(0) ;
            iterationEnd = last ;
    	}
      }
      else if (dstStart != last)
      {
    	 srcEnd.addNext(dstStart) ;
         last.addNext(dstEnd) ;
      }
    }

    iterationEnd.removeAllPrevious() ;
    return createTaskMainAction(taskI, ba, stateToStart, stateToEnd, iterationStart) ;
  }

  private static TaskBody createTaskMainAction(		 ComponentInstance taskI,
		  											 BehaviorAnnex ba,
                                                     Map<String, ASTNode> stateToStart,
                                                     Map<String, ASTNode> stateToEnd,
                                                     ASTNode iterationStart)
  {
    final TaskBody aTask = new TaskBody() ;

    for(BehaviorTransition t : ba.getTransitions())
    {
      String sourceID = t.getSourceState().getName() ;
      String targetID = t.getDestinationState().getName() ;
      ASTNode stStart = stateToStart.get(targetID) ;

      if(isInitial(t, sourceID))
      {
        removeIterationStartAsSuccessor(iterationStart, stStart) ;
        aTask.setInitAST(stStart) ;
      }
      else if(stStart == iterationStart)
      {
    	aTask.setMainLoopAST(stStart) ;
      }
    }

    return aTask ;
  }

  private static void removeIterationStartAsSuccessor(ASTNode iterationStart,
                                                      ASTNode taskStart)
  {
    if(!taskStart.removeNext(iterationStart))
    {
      for(ASTNode next : taskStart.getNext())
      {
        removeIterationStartAsSuccessor(iterationStart, next) ;
      }
    }
  }
}
