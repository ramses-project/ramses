package fr.tpt.aadl.sched.wcetanalysis.model ;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.sched.wcetanalysis.ASTRegistry;
import fr.tpt.aadl.sched.wcetanalysis.extractors.AST2AccessDates;
import fr.tpt.aadl.sched.wcetanalysis.util.LongestAndShortestPath;
import fr.tpt.aadl.utils.PropertyUtils;

public class TaskBody
{

  private ASTNode initAST = null ;
  private ASTNode mainLoopAST = null ;
  private ASTNode reducedMainLoopAST = null ;
  private ASTRegistry registry ;

  private int priority = -1 ;

  private double startTime = -1 ;
  private double BCET = -1;
  private double WCET = -1 ;

  public final ComponentInstance getTask()
  {
    return mainLoopAST.getElement() ;
  }

  public final int getPriority()
  {
    return priority ;
  }

  public final ASTNode getInitAST()
  {
    return initAST ;
  }

  public final ASTNode getMainLoopAST()
  {
    return mainLoopAST ;
  }

  public ASTNode getReducedMainLoopAST()
  {
    if(reducedMainLoopAST == null)
    {
      recomputeMainLoop() ;
    }

    return reducedMainLoopAST ;
  }

  public double getStartTime()
  {
    if(startTime == -1)
    {
    	startTime = LongestAndShortestPath.getLongestPath(
    			getInitAST(), getInitAST().getEnd()) ;
    }

    return startTime ;
  }

  public double getBCET()
  {
	if (BCET == -1)
	{
		BCET = LongestAndShortestPath.getShortestPath(
    			getMainLoopAST(), getMainLoopAST().getEnd()) ;
	}
	return BCET;
  }
  
  public double getWCET()
  {
    if(WCET == -1)
    {
    	WCET = LongestAndShortestPath.getLongestPath(
    			getMainLoopAST(), getMainLoopAST().getEnd()) ;
    }

    return WCET ;
  }

  public AST2AccessDates getSynchronizationInstants()
  {
    return new AST2AccessDates(mainLoopAST.reduceFromMe()) ;
  }

  public ASTRegistry getRegistry()
  {
    return registry ;
  }

  public void recomputeMainLoop()
  {
    reducedMainLoopAST = mainLoopAST.reduceFromMe() ;
  }

  public boolean isUsingResource(String resourceID)
  {
    return getSynchronizationInstants().getAccessedResources()
          .contains(resourceID) ;
  }

  public void setInitAST(ASTNode initAST)
  {
    this.initAST = initAST ;
    priority = computePriority() ;
  }

  public void setMainLoopAST(ASTNode mainLoopAST)
  {
    this.mainLoopAST = mainLoopAST ;
    priority = computePriority() ;
  }

  private int computePriority()
  {
    try
    {
      return (int) PropertyUtils.getIntValue(getTask(), "Priority") ;
    }
    catch(Exception e)
    {
      return 0 ;
    }
  }

  public void setRegistry(ASTRegistry registry)
  {
    this.registry = registry ;
  }

  public String toString()
  {
    return "Initialization graph : \n" + initAST + "\n\n" +
          "Iteration graph : \n" + mainLoopAST + "\n\n" +
          "Steady state sequence : \n" + getReducedMainLoopAST() + "\n\n" ;
  }
}