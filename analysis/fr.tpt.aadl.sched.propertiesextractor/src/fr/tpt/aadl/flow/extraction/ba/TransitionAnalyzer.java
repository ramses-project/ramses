package fr.tpt.aadl.flow.extraction.ba ;

import java.util.List ;

import org.osate.aadl2.Classifier ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.RealLiteral ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions ;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues ;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction ;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.util.BehaviorAnnexUtil ;
import fr.tpt.aadl.flow.extraction.util.IDGenerator ;
import fr.tpt.aadl.flow.model.RTAction ;
import fr.tpt.aadl.flow.model.RTActionType ;
import fr.tpt.aadl.ramses.util.properties.IntegerRange ;

/**
 * Extract action flow from a list of Behavior Actions
 * @author Fabien Cadoret
 */
public class TransitionAnalyzer extends BAElementAnalyzer
{

  private final ExtractionContext ctxt ;

  /**
   * Create a BlockExecutionFlow
   * @param errManager error reporter
   */
  public TransitionAnalyzer(
                            ExtractionContext ctxt)
  {
    super(ctxt.getErrManager()) ;
    this.ctxt = ctxt ;
  }

  /**
   * Extract action flow from a list of Behavior Actions
   * @param taskInstance owner of behavior actions
   * @param actions list of Behavior Actions
   * @param blockStart first action to connect the following actions.
   * @return last action of the list
   */
  public RTAction extractFrom(ComponentInstance taskInstance,
                              List<BehaviorAction> actions,
                              RTAction blockStart)
  {
    return extractActions(taskInstance, actions, blockStart) ;
  }

  private RTAction extractActions(ComponentInstance taskInstance,
                                  List<BehaviorAction> actions,
                                  RTAction lastAction)
  {
    RTAction last = lastAction ;

    for(int indexAction = 0 ; indexAction < actions.size() ; indexAction++)
    {
      BehaviorAction action = actions.get(indexAction) ;
      last = extractAction(taskInstance, action, last) ;
    }

    return last ;
  }

  private RTAction extractAction(ComponentInstance taskInstance,
                                 BehaviorAction action,
                                 RTAction lastAction)
  {
    if(action instanceof IfStatement)
    {
      return extractIfStatement(taskInstance, (IfStatement) action, lastAction) ;
    }
    else if(action instanceof ForOrForAllStatement)
    {
      return extractForStatement(taskInstance, (ForOrForAllStatement) action,
                                 lastAction) ;
    }
    else
    {
      return extractBasicAction(action, lastAction) ;
    }
  }

  private RTAction extractIfStatement(ComponentInstance taskInstance,
                                      IfStatement action,
                                      RTAction lastAction)
  {
    RTAction actionIf =
          new RTAction(IDGenerator.getNewIdForName("if"),
                RTActionType.Conditional, taskInstance) ;
    RTAction actionIfEnd =
          new RTAction(IDGenerator.getNewIdForName("endif"),
                RTActionType.ConditionalEnd, taskInstance) ;
    actionIf.setJoin(actionIfEnd) ;
    IfStatement stmt = (IfStatement) action ;

    if(stmt.getBehaviorActions() instanceof BasicAction)
    {
      // no else
      actionIf.addNext(actionIfEnd) ;
    }

    if(stmt.getBehaviorActions() instanceof BehaviorActionSequence)
    {
      BehaviorActionSequence seq = (BehaviorActionSequence) stmt.getBehaviorActions() ;
      extractActions(
                     taskInstance, seq.getActions(), actionIf)
            .addNext(actionIfEnd) ;
    }

    lastAction.addNext(actionIf) ;
    return actionIfEnd ;
  }

  private RTAction extractForStatement(ComponentInstance taskInstance,
                                       ForOrForAllStatement forall,
                                       RTAction lastAction)
  {
    RTAction actionFor =
          new RTAction(IDGenerator.getNewIdForName("for"), RTActionType.Loop,
                taskInstance) ;
    RTAction actionForEnd =
          new RTAction(IDGenerator.getNewIdForName("endfor"),
                RTActionType.LoopEnd, taskInstance) ;
    actionFor.setJoin(actionForEnd) ;
    BehaviorActionSet set =
          (BehaviorActionSet) forall.getBehaviorActions() ;
    List<BehaviorAction> actionBlock = set.getActions() ;
    IntegerRange range = getForRange(forall) ;

    for(int i = range.getMin() ; i <= range.getMax() ; i++)
    {
      lastAction = extractFrom(taskInstance, actionBlock, actionFor) ;
    }

    lastAction.addNext(actionForEnd) ;
    return actionForEnd ;
  }

  private IntegerRange getForRange(ForOrForAllStatement forall)
  {
    ElementValues values = forall.getIteratedValues() ;

    if(values instanceof fr.tpt.aadl.annex.behavior.aadlba.IntegerRange)
    {
      fr.tpt.aadl.annex.behavior.aadlba.IntegerRange r =
            (fr.tpt.aadl.annex.behavior.aadlba.IntegerRange) values ;
      IntegerValue lower = r.getLowerIntegerValue() ;
      IntegerValue upper = r.getUpperIntegerValue() ;
      int lowerV = getIntegerValue(lower) ;
      int upperV = getIntegerValue(upper) ;
      return new IntegerRange(lowerV, upperV) ;
    }

    return null ; //XXX
  }

  private int getIntegerValue(IntegerValue v)
  {
    //TODO: extract integer parameters from "for statement".
    if(v instanceof DataComponentReference)
    {
      DataComponentReference ref = (DataComponentReference) v ;
    }

    return 0 ; //XXX
  }

  private RTAction extractBasicAction(BehaviorAction action,
                                      RTAction lastAction)
  {
    final ComponentInstance element = lastAction.getElement() ;
    BasicAction basic = (BasicAction) action ;

    if(basic instanceof AssignmentAction)
    {
      RTAction assignAction =
            new RTAction(IDGenerator.getNewIdForName("Assignment"),
                  RTActionType.Assignment, element) ;
      lastAction.addNext(assignAction) ;
      lastAction = assignAction ;
    }
    else if(basic instanceof TimedAction)
    {
      TimedAction ta = (TimedAction) basic ;
      IntegerValue min, max ;
      float minVal, maxVal ;
      min = ta.getLowerTime().getIntegerValue() ;
      max = ta.getUpperTime().getIntegerValue() ;

      if(min instanceof IntegerLiteral)
      {
        minVal = ((IntegerLiteral) min).getValue() ;
      }
      else
      {
        minVal = (float) ((RealLiteral) min).getValue() ;
      }

      if(max instanceof IntegerLiteral)
      {
        maxVal = ((IntegerLiteral) max).getValue() ;
      }
      else
      {
        maxVal = (float) ((RealLiteral) max).getValue() ;
      }

      RTAction comp =
            new RTAction(IDGenerator.getNewIdForName("computation"),
                  RTActionType.Compute, element) ;
      comp.setMinExecutionTime(minVal) ;
      comp.setMaxExecutionTime(maxVal) ;
      lastAction.addNext(comp) ;
      lastAction = comp ;
    }
    else if(basic instanceof SubprogramCallAction)
    {
      SubprogramCallAction comAction = (SubprogramCallAction) basic ;
      NamedElement ref = BehaviorAnnexUtil.getSubprogramReference(comAction) ;
      lastAction =
            ctxt.getSubprogramAnalyzer().extractFrom((Classifier) ref,
                                                     lastAction) ;
      RTActionType type = lastAction.getType() ;

      if((type == RTActionType.WaitResource) ||
            (type == RTActionType.ReleaseResource))
      {
        String res =
              BehaviorAnnexUtil.getSharedDataNameFromSubprogramCall(comAction) ;
        lastAction.setResourceID(res) ;
      }
    }
    else
    {
      reportError(basic, "Unknown behavior action kind : " + basic) ;
    }

    return lastAction ;
  }

  /*
  private TaskAction analyzeSubprogramCall(CommunicationAction comAction,
      TaskAction lastAction,ComponentInstance element,
      NamedElement ref)
  {
    TaskActionType type = ComputationUtil.getSubprogramActionType(ref);
  
    TaskAction a = new TaskAction(IDGenerator.getNewIdForName(ref.getName()), type, element);
    a.setMinExecutionTime( ComputationUtil.getElementMinDuration(ref, this) );
    a.setMaxExecutionTime( ComputationUtil.getElementMaxDuration(ref, this) );
    lastAction.addNext(a);
    lastAction = a;
  
    if ((type == TaskActionType.WaitResource) || (type == TaskActionType.ReleaseResource))
    {
      Identifier id = getResourceID(comAction, element);
      if (id == null)
      {
        reportError(comAction,"Unable to extract resource ID from Wait/Release statement");
        return lastAction;
      }
  
      a.setResourceID(id.getId());
      a.setResourceType(ResourceType.SharedVariable);
    }
    else if ((type == TaskActionType.ReadPort) || (type == TaskActionType.WritePort))
    {
      Identifier id = getResourceID(comAction, element);
      if (id == null)
      {
        reportError(comAction,"Unable to extract resource ID from ReadPort/WritePort statement");
        return lastAction;
      }
  
      Element entity = id.getAadlReferencedEntity();
      ResourceType t = entityToResourceType(entity);
  
      a.setResourceID(id.getId());
      a.setResourceType(t);
  
      if ((t==ResourceType.EventPort)||(t==ResourceType.EventDataPort))
      {
        if (Configuration.EXPORT_BUFFER_ACCESSES)
          exportPortOperation(element, entity);
      }
    }
    return lastAction;
  }*/

  /*
  private void exportPortOperation(ComponentInstance task, Element portType)
  {
    SystemInstance s = (SystemInstance) task.getOwner().getOwner();
    for(ConnectionInstance co : s.getConnectionInstances())
    {
      if (co.getSource() instanceof FeatureInstance)
      {
        FeatureInstance fi = (FeatureInstance) co.getSource();
        if (fi.getFeature() == portType)
        {
          System.out.println("ploup");
        }
      }
    }
  }
  
  
  private Identifier getResourceID(CommunicationAction comAction, ComponentInstance thread)
  {
    SubprogramParameterList l = comAction.getSubpgmParamListOwned();
    if (l==null)
    {
      reportError(comAction,"Wait/Release/ReadPort/WritePort function must own ressource/port id parameter");
      return null;
    }
    List<ParameterLabel> params = l.getParameterList();
    if ((params==null) || (params.size()==0))
    {
      reportError(l,"Wait/Release/ReadPort/WritePort function must own ressource/port id parameter");
      return null;
    }
  
    return BehaviorAnnexUtil.getResourceIdentifierFromParameter(params.get(0), thread);
  }
  
  private static ResourceType entityToResourceType(Element e)
  {
    if (e instanceof EventDataPort)
      return ResourceType.EventDataPort;
    else if (e instanceof DataPort)
      return ResourceType.DataPort;
    else if (e instanceof EventPort)
      return ResourceType.EventPort;
    else
      return ResourceType.None;
  }*/
}
