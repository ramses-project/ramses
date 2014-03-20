/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.analysis.eg.ba;

import java.util.List ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.ConnectedElement ;
import org.osate.aadl2.Connection ;
import org.osate.aadl2.ConnectionEnd ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.ConnectionInstanceEnd ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.ba.aadlba.AssignmentAction ;
import org.osate.ba.aadlba.BasicAction ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorTime ;
import org.osate.ba.aadlba.CondStatement ;
import org.osate.ba.aadlba.DataAccessHolder ;
import org.osate.ba.aadlba.DataAccessPrototypeHolder ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.ForOrForAllStatement ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.LockAction ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.TimedAction ;
import org.osate.ba.aadlba.UnlockAction ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.aadlba.WhileOrDoUntilStatement ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.IntegerRange ;

import fr.tpt.aadl.ramses.analysis.eg.EGLauncher ;
import fr.tpt.aadl.ramses.analysis.eg.ba.ValueExpressionUtil.DataToken ;
import fr.tpt.aadl.ramses.analysis.eg.ba.ValueExpressionUtil.ExpressionToken ;
import fr.tpt.aadl.ramses.analysis.eg.ba.ValueExpressionUtil.ExpressionTokens ;
import fr.tpt.aadl.ramses.analysis.eg.ba.ValueExpressionUtil.OperatorToken ;
import fr.tpt.aadl.ramses.analysis.eg.context.EGContext ;
import fr.tpt.aadl.ramses.analysis.eg.context.SubprogramCallContext ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNodeKind ;
import fr.tpt.aadl.ramses.analysis.eg.model.SystemProperties ;
import fr.tpt.aadl.ramses.analysis.eg.util.BehaviorUtil ;
import fr.tpt.aadl.ramses.analysis.eg.util.ClassifierUtil ;
import fr.tpt.aadl.ramses.analysis.eg.util.SharedResourceUtil ;
import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class BehaviorAction2EG
{
  private static final Logger _LOGGER = Logger.getLogger(BehaviorAction2EG.class) ; 
  
  private BehaviorAction2EG(){}

  public static EGNode actionBlockToEG (BehaviorActionBlock block, String name)
  {
    return actionsToEG (block.getContent(), name);
  }
  
  public static EGNode actionsToEG (BehaviorActions actions, String name)
  {
    List<BehaviorAction> actionList = BehaviorUtil.getBehaviorActions(actions);
    EGNode trStartNode   = new EGNode(name + "_start");
    EGNode trEndNode     = new EGNode(name + "_end");
    
    trStartNode.setBlockEnd(trEndNode);
    
    EGNode lastNode = trStartNode;
    for(BehaviorAction action: actionList)
    {
      EGNode actionNode ;
      try
      {
        actionNode = actionToEG(action) ;
      }
      catch(UnsupportedOperationException e)
      {
        String msg = RamsesException.formatRethrowMessage("cannot do action to EG",
                                                          e) ;
        _LOGGER.error("", e) ;
        ServiceProvider.SYS_ERR_REP.error(msg, true);
        actionNode = new EGNode (name + "_<error>");
      }
      lastNode.addNext(actionNode);
      lastNode = actionNode.getBlockEnd();
    }
    lastNode.addNext(trEndNode);
    return trStartNode;
  }
  
  /**
   * Returns the root node of the subgraph corresponding to the given action
   * @param action behavior action
   * @return root node of the subgraph corresponding to the given action
   */
  public static EGNode actionToEG (BehaviorAction action)
  {
    if (action instanceof BasicAction)
    {
      if (action instanceof AssignmentAction)
      {
        return assignmentToEG((AssignmentAction) action);
      }
      else if (action instanceof SubprogramCallAction)
      {
        return subprogramCallToEG((SubprogramCallAction) action);
      }
      else if (action instanceof TimedAction)
      {
        return timedActionToEG ((TimedAction) action);
      }
      else if (action instanceof LockAction)
      {
        return lockActionToEG ((LockAction) action);
      }
      else if (action instanceof UnlockAction)
      {
        return unlockActionToEG ((UnlockAction) action);
      }
      else
      {
        String msg = '\'' +
            action.getClass().getSimpleName() + "\' is not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg);
      }
    }
    else if (action instanceof CondStatement)
    {
      if (action instanceof IfStatement)
      {
        return ifToEG((IfStatement) action);
      }
      else if (action instanceof ForOrForAllStatement)
      {
        ForOrForAllStatement s = (ForOrForAllStatement) action;
        if (s.isForAll())
        {
          return forAllToEG (s);
        }
        else
        {
          return forToEG (s);
        }
      }
      else if (action instanceof WhileOrDoUntilStatement)
      {
        WhileOrDoUntilStatement s = (WhileOrDoUntilStatement) action;
        if (s.isDoUntil())
        {
          return doUntilToEG (s);
        }
        else
        {
          return whileToEG (s);
        }
      }
      else
      {
        String msg = '\'' +
            action.getClass().getSimpleName() + "\' is not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg);
      }
    }
    else
    {
      String msg = '\'' +
          action.getClass().getSimpleName() + "\' is not supported" ;
      _LOGGER.fatal(msg);
      throw new UnsupportedOperationException(msg);
    }
  }
  
  private static EGNode assignmentToEG (AssignmentAction a)
  {
    Target target = a.getTarget();
    ValueExpression assigned = a.getValueExpression();
    
    boolean ignoreCopy = ((target instanceof DataAccessHolder) 
                      || (target instanceof DataAccessPrototypeHolder));
    
    String targetName = AadlBaUtils.getDataClassifier(target).getName() ;
    EGNode assignmentNode = subExpressionsToEG(assigned,"Assign_"+ targetName, 
                                               false, ignoreCopy);
    return assignmentNode;
  }
  
  
  private static EGNode subExpressionsToEG (ValueExpression ve, String name,
                                           boolean isSubprogramInputParameter,
                                           boolean ignoreTargetCopy)
  {
    final ComponentInstance thread = (ComponentInstance) 
          EGContext.getInstance().getCurrentThread();
    
    //FIXME: MsgValue (data) := DataValue (data access) --> consider DataValue as a data not a pointer (copy time)
    
    List<ExpressionTokens> subExpressions = ValueExpressionUtil.decompose(ve,
                                                                          isSubprogramInputParameter,
                                                                          !ignoreTargetCopy);
    
    EGNode nAssign = new EGNode(name);
    EGNode last = nAssign;
    int cpt = 0;
    for(ExpressionTokens sub : subExpressions)
    {
      cpt++;
      EGNode n = new EGNode("expr_"+cpt+"_"+sub.toString());
      
      //List<DataToken> dataTokens = sub.getDataTokens();
      //DataToken dt = dataTokens.get(0);
      
      int dataTokens = 0;
      int operatorTokens = 0;
      DataToken dt = null;
      OperatorToken ot = null;
      for(ExpressionToken tok : sub.getTokens())
      {
        if (tok instanceof DataToken)
        {
          dataTokens++;
          dt = (DataToken) tok;
        }
        else if (tok instanceof OperatorToken)
        {
          operatorTokens++; 
          ot = (OperatorToken) tok;
        }
      }
      
      /** Time to load and read data members and write target var */
      n.addTimeOverhead(dt.getLoadTimeInMs(thread)*dataTokens);
      n.addTimeOverhead(dt.getReadTimeInMs(thread)*dataTokens);
      n.addTimeOverhead(dt.getWriteTimeInMs(thread)*dataTokens);
      
      /** Time do load and execute operators */
      if (ot != null)
      {
        n.addTimeOverhead(ot.getLoadTimeInMs(thread)*operatorTokens);
        n.addTimeOverhead(ot.getExecutionTime(thread)*operatorTokens);
      }
      
      last.addNext(n);
      last = n;
    }
    nAssign.setBlockEnd(last);
    return nAssign;
  }
  
  private static EGNode subprogramCallToEG (SubprogramCallAction a)
  {
    EGContext.getInstance().pushCurrentSubprogram(a);
    
    final EGContext ctxt = EGContext.getInstance();
    final SystemProperties sp = ctxt.getSystemProperties();
    final ComponentInstance thread = (ComponentInstance) ctxt.getCurrentThread();
    
    try
    {
      SubprogramClassifier sc = BehaviorUtil.getSubprogramClassifier(a);
      
      EGNode nCall = new EGNode ("SubprogramCallAction_" + sc.getName());
      
      /** Time to load and copy parameters **/
      EGNode lastNode = subprogramCallParametersToEG(a, sp, thread, sc, nCall) ;
      
      /** Subprogram execution */
      EGNode callNode = EGLauncher.entrypoint(sc);
      lastNode.addNext(callNode);
      
      nCall.setBlockEnd(callNode.getBlockEnd());
      
      if (SharedResourceUtil.isSynchronizationSubprogram(sc.getName()))
      {
        //ComponentInstance sharedData = getSharedData (a);
        //callNode.setSharedData(sharedData);
        getSharedData(a,callNode);
        SharedResourceUtil.setSynchronizationNode(callNode, sc.getName());
      }
      
      EGContext.getInstance().popCurrentSubprogram();
      
      return nCall;
    }
    catch(UnsupportedOperationException e)
    {
      String msg = RamsesException.formatRethrowMessage("unsupported operation", e);
      _LOGGER.error("", e);
      ServiceProvider.SYS_ERR_REP.error(msg, true);
    }
    
    EGContext.getInstance().popCurrentSubprogram();
    // Is it for DEBUG ?
    return new EGNode("subprogramcall_block");
  }

  private static EGNode subprogramCallParametersToEG(SubprogramCallAction a,
                                                    final SystemProperties sp,
                                                    final ComponentInstance thread,
                                                    SubprogramClassifier sc,
                                                    EGNode lastNode)
  {
    SubprogramType sct = (SubprogramType) ClassifierUtil.getTypeClassifier(sc);
    for(int indexParam=0;indexParam<a.getParameterLabels().size();indexParam++)
    {
      final String pName = sc.getName() + "_param_" + indexParam;
      
      ParameterLabel l = a.getParameterLabels().get(indexParam);
      final boolean isInput = ClassifierUtil.isInputFeature(sct, indexParam);
      final boolean isValuePassing = ClassifierUtil.isValuePassingFeature(sct, indexParam); 
      boolean copyParam =  isInput && isValuePassing;
      /*String value = SubprogramCallActionUtil.getParameterValueText(l);
      System.out.printf("\t%s parameter %d\t is %s\t%s (copy: %s)\n",
                        (isInput ? "Input " : "Output"), 
                        indexParam,
                        (isValuePassing ? "value" : "reference"),
                        value, 
                        String.valueOf(copyParam));*/
      
      final int valueOctets = SubprogramCallActionUtil.getParameterSizeInOctets(l);
      final int defOctets = (int) ClassifierUtil.getFeatureSizeInOctets(sct, indexParam);
      final int octets = Math.max(valueOctets, defOctets);
      
      double loadTime = sp.getAssignTimeInMs(thread).getTime(octets);
      
      String actionName = (copyParam ? "Assign_and_copy_" : "Assign_");
      
      EGNode nAssign = new EGNode(actionName + pName + "_" + octets + "octets");
      nAssign.setKind(EGNodeKind.Computation);
      nAssign.setBCET_and_WCET(loadTime);
      
      lastNode.addNext(nAssign);
      lastNode = nAssign;
      
      if (copyParam)
      {
        double readTime = sp.getReadTimeInMs(thread).getTime(octets);
        double writeTime = sp.getWriteTimeInMs(thread).getTime(octets);
        
        if (!isInput)
        {
          readTime = 0;
        }
        
        EGNode nCopy = new EGNode("Copy_" + pName);
        nCopy.setKind(EGNodeKind.Computation);
        nCopy.setBCET_and_WCET(readTime + writeTime);
        
        lastNode.addNext(nCopy);
        lastNode = nCopy;
      }
    }
    
    return lastNode;
  }

  private static void getSharedData (SubprogramCallAction action, EGNode accessNode)
  {
    SubprogramClassifier sc = null;
    
    sc = BehaviorUtil.getSubprogramClassifier(action) ;
    
    SubprogramType st = (SubprogramType) ClassifierUtil.getTypeClassifier(sc);
    List<Feature> features = Aadl2Utils.orderFeatures(st);
    
    /** Find resource ID **/
    int resourceIndex = -1;
    for(ParameterLabel l : action.getParameterLabels())
    {
      final int index = action.getParameterLabels().indexOf(l);
      if (features.get(index) instanceof DataAccess)
      {
        resourceIndex = index;
        break;
      }
    }
    if (resourceIndex==-1)
    {
      String msg = "Cannot find shared resource for SubprogramCallAction \'" +
          sc.getName() + '\'' ;
      _LOGGER.error(msg);
      ServiceProvider.SYS_ERR_REP.error(msg, true);
    }
    
    ParameterLabel l = action.getParameterLabels().get(resourceIndex);
    ValueExpression e = (ValueExpression) l;
    Relation r = e.getRelations().get(0);
    SimpleExpression se = r.getFirstExpression();
    Term t = se.getTerms().get(0);
    Factor f = t.getFactors().get(0);
    Value v = f.getFirstValue();
    DataAccessHolder h = (DataAccessHolder) v;
    
    DataAccess da = getDataAccess(h) ;
    accessNode.setSharedDataAccess(da);
    
    if (da==null)
    {
      String msg = "Cannot find shared resource for SubprogramCallAction \'" +
                   sc.getName() + '\'' ; 
      _LOGGER.error(msg);
      ServiceProvider.SYS_ERR_REP.error(msg, true);
    }
    else
    {
      ComponentInstance c = getDataAccessElement (da);
      accessNode.setSharedData(c);
    }
    
    //return null;
  }

  private static DataAccess getDataAccess(DataAccessHolder h)
  {
    DataAccess da = (DataAccess) h.getElement();
    
    ComponentInstance thread = (ComponentInstance) EGContext.getInstance().getCurrentThread();
    ThreadImplementation ti = (ThreadImplementation) thread.getSubcomponent().getClassifier();
    
    DataAccess threadDA = null;
    for(Connection ci : ti.getOwnedConnections())
    {
      ConnectedElement target = (ConnectedElement) ci.getDestination();
      ConnectionEnd cend = target.getConnectionEnd();
      if (cend == da)
      {
        ConnectedElement source = (ConnectedElement) ci.getSource();
        ConnectionEnd cstart = source.getConnectionEnd();
        if (cstart instanceof DataAccess)
        {
          threadDA = (DataAccess) cstart;
          break;
        }
      }
      else 
      {
    	  ConnectedElement source = (ConnectedElement) ci.getSource();
    	  cend = source.getConnectionEnd();
    	  if (cend == da)
          {
            ConnectedElement dst = (ConnectedElement) ci.getDestination();
            ConnectionEnd cfini = dst.getConnectionEnd();
            if (cfini instanceof DataAccess)
            {
              threadDA = (DataAccess) cfini;
              break;
            }
          }
      }
    }
    
    return threadDA == null ? da : threadDA;
  }
  
  private static ComponentInstance getDataAccessElement (DataAccess threadDA)
  {
    ComponentInstance thread = (ComponentInstance) EGContext.getInstance().getCurrentThread();
    ComponentInstance process = (ComponentInstance) thread.eContainer();
    
    for(ConnectionInstance ci : process.getConnectionInstances())
    {
      ConnectionInstanceEnd end = ci.getDestination();
      if (end instanceof FeatureInstance)
      {
        FeatureInstance fi = (FeatureInstance) end;
        Feature _f = fi.getFeature();
        if (_f == threadDA)
        {
          ConnectionInstanceEnd source = ci.getSource();
          if (source instanceof ComponentInstance)
          {
            ComponentInstance c = (ComponentInstance) source;
            if (c.getCategory() == ComponentCategory.DATA)
            {
              return c;
            }
          }
        }
      }
    }
    return null;
  }
  
  private static EGNode timedActionToEG(TimedAction a)
  {
    BehaviorTime min = a.getLowerTime();
    BehaviorTime max = a.getUpperTime();
    
    BehaviorIntegerLiteral bilmin = (BehaviorIntegerLiteral) min.getIntegerValue();
    BehaviorIntegerLiteral bilmax = (BehaviorIntegerLiteral) min.getIntegerValue();
    long minValue = bilmin.getValue();
    long maxValue = bilmax.getValue();
    
    if (min.getUnit()==null && max.getUnit()==null)
    {
      //String unit = AadlUtil.getPrecision(EGContext.getInstance().getCurrentThread());
      EGNode n = new EGNode("TimedAction");
      n.setBCET(minValue);
      n.setWCET(maxValue);
      return n;
    }
    else
    {
      //TODO: convert unit
      
      EGNode n = new EGNode("TimedAction");
      n.setBCET(minValue);
      n.setWCET(maxValue);
      return n;
    }
  }

  private static EGNode lockActionToEG(LockAction a)
  {
    DataAccessHolder h = a.getDataAccess();
    DataAccess da = h.getDataAccess();
    EGNode n = new EGNode("LockAction");
    configureLockAction(n, da, EGNodeKind.CriticalSectionStart);
    return n;
  }
  
  private static void configureLockAction(EGNode n, DataAccess da,
                                          EGNodeKind kind)
  {
	  NamedElement currentVisiting = EGContext.getInstance().getCurrentThread();
	  int size = EGContext.getInstance().getVisitingSubprogramCallActionSize();
	
	  SubprogramType spg = (SubprogramType) da.getContainingClassifier();
	  int containerFeatureIdx = Aadl2Utils.orderFeatures(spg).indexOf(da);
	  String paramValue = "";
	  for(int i=size;i>0;i--)
	  {
	    String paramName = spg.getOwnedFeatures().get(containerFeatureIdx).
	                                                                    getName();
	    SubprogramCallContext scc = EGContext.getInstance().
	                                         getVisitingSubprogramCallAction(i-1);
	    paramValue = scc.getParameterStringValue(paramName);
	    SubprogramClassifier sc = (SubprogramClassifier) scc.getElement();
	    
	    if(sc instanceof SubprogramType)
	      spg = (SubprogramType) sc;
	    else
		  spg = ((SubprogramImplementation) sc).getType();
	    
	    containerFeatureIdx = getFeatureIndex(spg, paramValue);
	  }
	
	  ComponentInstance ci = (ComponentInstance) currentVisiting;
	  ComponentType ct = ci.getSubcomponent().getComponentType();
	  int daIndex = getFeatureIndex(ct, paramValue);
	  da = (DataAccess) ct.getOwnedFeatures().get(daIndex);
	  n.setKind(kind);
	  n.setSharedDataAccess(da);
	  ComponentInstance data = getDataAccessElement (da);
	  n.setSharedData(data);
  }
  
  private static int getFeatureIndex(ComponentType ct, String featureName)
  {
	  int res = -1;
	  for(Feature f:ct.getOwnedFeatures())
	  {
		  res++;
		  if(f.getName().equals(featureName))
			  return res;
	  }
	  return -1;
  }

  private static EGNode unlockActionToEG(UnlockAction a)
  {
    DataAccessHolder h = a.getDataAccess() ;
    DataAccess da = h.getDataAccess() ;
    EGNode n = new EGNode("UnlockAction") ;
    configureLockAction(n, da, EGNodeKind.CriticalSectionEnd) ;
    return n ;
  }
  
  private static EGNode ifToEG (IfStatement a)
  {
    EGNode nIf = new EGNode("if");
    
    EGNode nEndif = new EGNode("endif");
    EGNode nCond = subExpressionsToEG (a.getLogicalValueExpression(), "ifcond",
                                                                    false,true);
    EGNode nThenStart = actionsToEG (a.getBehaviorActions(), "ifthen") ;
    
    nIf.addNext(nCond);
    nIf.setBlockEnd(nEndif);
    
    nCond.getBlockEnd().addNext(nThenStart);
    nThenStart.getBlockEnd().addNext(nEndif);
    
    ElseStatement e = a.getElseStatement();
    EGNode nElseStart = null;
    if (e != null)
    {
      nElseStart = actionsToEG (e.getBehaviorActions(), "ifelse") ;
    }
    else
    {
      nElseStart = new EGNode("ifelse");
    }
    nCond.getBlockEnd().addNext(nElseStart);
    nElseStart.getBlockEnd().addNext(nEndif);

    nCond.getBlockEnd().setBlockEnd(nEndif);
    
    return nIf;
  }
  
  private static EGNode forToEG (ForOrForAllStatement a)
  {
    IntegerRange r = null;
    try
    {
      r = BehaviorUtil.getForStatementRange(a) ;
    }
    catch(UnsupportedOperationException e)
    {
      String msg = RamsesException.formatRethrowMessage("cannot getForStatementRange",
                                                        e);
      _LOGGER.error(msg);
      ServiceProvider.SYS_ERR_REP.error(msg, true);
      
      EGNode n = new EGNode ("for_block_<error>");
      n.setBlockEnd(n);
      return n;
    }
    
    EGNode nodeFor = new EGNode("for");
    EGNode nodeForEnd = new EGNode("endfor");
    nodeFor.setBlockEnd(nodeForEnd);
    
    EGNode first = nodeFor;
    for(int i=r.getMin();i<=r.getMax();i++)
    {
      EGNode nIt = BehaviorAction2EG.actionsToEG(
          a.getBehaviorActions(), "Iteration_it="+i);
      first.addNext(nIt);
      first = nIt;
    }
    first.addNext(nodeForEnd);
    
    return nodeFor;
  }

  private static EGNode whileToEG (WhileOrDoUntilStatement a)
  {
    final int iterations = WhileLoopUtil.computeMaxIterations(a);
    EGNode actionWhile = new EGNode("while");
    EGNode actionWhileEnd = new EGNode("endwhile");
    actionWhile.setBlockEnd(actionWhileEnd);
  
    final ValueExpression condition = a.getLogicalValueExpression();
    final BehaviorActions body = a.getBehaviorActions();
    
    EGNode condNode = subExpressionsToEG(condition, "whilecond_0",false, true);
    
    actionWhile.addNext(condNode);
    
    EGNode iterationNode = condNode.getBlockEnd();
    for(int i=0;i<iterations;i++)
    {
      //debug("Iteration " + (i+1), "*");
      
      /** Iteration body */
      EGNode nodeIter = BehaviorAction2EG.actionsToEG(body, "iteration_" + (i+1));
      iterationNode.addNext(nodeIter);
      iterationNode = nodeIter;
      
      /** Next iteration condition */
      EGNode condNodeIter = 
            BehaviorAction2EG.subExpressionsToEG(condition, "whilecond_"+(i+1),false,true);
      nodeIter.getBlockEnd().addNext(condNodeIter);
      iterationNode = condNodeIter.getBlockEnd();
    }
    iterationNode.getBlockEnd().addNext(actionWhileEnd);
    return actionWhile;
  }

  
  private static EGNode doUntilToEG (WhileOrDoUntilStatement a)
  {
    return new EGNode("dountil_block");
  }
  
  private static EGNode forAllToEG (ForOrForAllStatement a)
  {
    return new EGNode("forall_block");
  }
}