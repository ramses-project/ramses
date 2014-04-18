package fr.tpt.aadl.sched.wcetanalysis.model ;

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.Collections ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.sched.wcetanalysis.util.IDGenerator;
import fr.tpt.aadl.sched.wcetanalysis.util.LongestAndShortestPath;

public class ASTNode
{

  public static boolean hideEmptyActions = false ;

  /** Action name. */
  private final String name ;

  /** Action type. */
  private StatementKind type ;

  /** Previous actions. */
  private List<ASTNode> previous = new ArrayList<ASTNode>() ;

  /** Next actions. */
  private List<ASTNode> next = new ArrayList<ASTNode>() ;

  private ASTNode join = null ;

  /** Related Task. */
  private ComponentInstance task ;

  /** Resource ID. */
  private String resourceID = "" ;

  /** Resource Type. */
  private ResourceKind resourceType = ResourceKind.None ;

  /** Minimum execution time. */
  private double minExecutionTime = 0 ;

  /** Maximum execution time. */
  private double maxExecutionTime = 0 ;

  public static ASTNode createEmptyAction(String name,
                                           final ComponentInstance task)
  {
    ASTNode start = new ASTNode(name, StatementKind.Empty, task)
    {
      public double getMinExecutionTime()
      {
        return 0 ;
      }

      public double getMaxExecutionTime()
      {
        return 0 ;
      }
    } ;
    return start ;
  }

  public static ASTNode createEmptyAction(final ComponentInstance task)
  {
    return createEmptyAction("empty", task) ;
  }
  
  public static ASTNode createFlagNode(final ComponentInstance task, String name)
  {
	ASTNode n = createEmptyAction(name, task);
	n.type = StatementKind.ASTStartOrEnd;
	return n;
  }

  public ASTNode(
                  String name, StatementKind type, ComponentInstance task)
  {
    this.name = name ;
    this.type = type ;
    this.task = task ;
  }

  public ASTNode(
                  StatementKind type, ComponentInstance task)
  {
    this("Noname", type, task) ;
  }

  public void setJoin(ASTNode t)
  {
    join = t ;
  }

  public ComponentInstance getElement()
  {
    return task ;
  }

  public List<ASTNode> getPrevious()
  {
    return Collections.unmodifiableList(previous) ;
  }

  public List<ASTNode> getNext()
  {
    return Collections.unmodifiableList(next) ;
  }

  public ASTNode getEnd()
  {
    ASTNode end = this ;

    if(next.size() > 0)
    {
      end = next.get(0).getEnd() ;
    }

    return end ;
  }

  public ASTNode getJoin()
  {
    return join ;
  }
  
  public double getMinStartTime()
  {
	  double prevTime = 0d;
	  List<ASTNode> previousList = previous;
	  while (!previousList.isEmpty())
	  {
		  ASTNode prev = previousList.get(0);
		  prevTime += prev.getMinExecutionTime();
		  previousList = prev.previous;
	  }
	  return prevTime;
  }

  public void addNext(ASTNode t)
  {
    if(type != StatementKind.AwaitDispatch)
    {
      next.add(t) ;
      t.previous.add(this) ;
    }
  }

  public void addPrevious(ASTNode t)
  {
    previous.add(t) ;
    t.next.add(this) ;
  }

  public boolean removeNext(ASTNode t)
  {
    boolean result ;
    result = next.remove(t) ;
    t.previous.remove(this) ;
    return result ;
  }

  public boolean removePrevious(ASTNode t)
  {
    boolean result ;
    result = previous.remove(t) ;
    t.next.remove(this) ;
    return result ;
  }

  public void addAllNext(Collection<ASTNode> actions)
  {
    for(ASTNode action : actions)
    {
      addNext(action) ;
    }
  }

  public void addAllPrevious(Collection<ASTNode> actions)
  {
    for(ASTNode action : actions)
    {
      addPrevious(action) ;
    }
  }

  public void removeAllNext(Collection<ASTNode> actions)
  {
    for(ASTNode action : actions)
    {
      removeNext(action) ;
    }
  }

  public void removeAllPrevious(Collection<ASTNode> actions)
  {
    for(ASTNode action : actions)
    {
      removePrevious(action) ;
    }
  }

  public void removeAllPrevious()
  {
    List<ASTNode> tmp = new ArrayList<ASTNode>() ;
    tmp.addAll(previous) ;
    removeAllPrevious(tmp) ;
  }

  public void setResourceID(String resourceID)
  {
    this.resourceID = resourceID ;
  }

  public String getResourceID()
  {
    return resourceID ;
  }

  public void setResourceType(ResourceKind resourceType)
  {
    this.resourceType = resourceType ;
  }

  public ResourceKind getResourceType()
  {
    return resourceType ;
  }

  public String getName()
  {
    return name ;
  }

  public StatementKind getType()
  {
    return type ;
  }
  
  public void setType(StatementKind type)
  {
	  this.type = type;
  }

  public void setMinExecutionTime(double time)
  {
    minExecutionTime = time ;
  }

  public void setMaxExecutionTime(double time)
  {
	maxExecutionTime = time ;
  }
  
  public void addExecutionTime(double time)
  {
	  minExecutionTime = minExecutionTime + time;
	  maxExecutionTime = maxExecutionTime + time;
  }

  public double getMinExecutionTime()
  {
    return minExecutionTime ;
  }

  public double getMaxExecutionTime()
  {
    return maxExecutionTime ;
  }

  public String toString()
  {
    return toString(new ArrayList<ASTNode>(), 0) ;
  }

  private String toString(List<ASTNode> visited,
                          int tab)
  {
    String s = fillWithBlank("", tab) + toStringBasic(tab) ;

    if(!visited.contains(this))
    {
      visited.add(this) ;

      for(ASTNode n : next)
      {
        s += "\n" + n.toString(visited, tab + 1) ;
      }

      visited.remove(this) ;
    }

    return s ;
  }

  private String toStringBasic(int tab)
  {
    if((type != StatementKind.Empty) || (!hideEmptyActions))
    {
      double tmin = getMinExecutionTime() ;
      double t = getMaxExecutionTime() ;
      String formatType = fillWithBlank(getType().name(), 15 + tab) ;
      String concName =
            getName() + (resourceID != null ? "(" + resourceID + ")" : "") ;
      String s = fillWithBlank(formatType + "\t" + concName, 60 + tab) ;
      s += "\tC = [" + tmin + "," + t + "]" ;
      return s ;
    }
    else
    {
      return "" ;
    }
  }

  public final boolean equals(Object o)
  {
    if(o instanceof ASTNode)
    {
      ASTNode a = (ASTNode) o ;
      return name.equals(a.getName()) && type.equals(a.getType()) ;
    }

    return false ;
  }

  private String fillWithBlank(String s,
                               int requiredLength)
  {
    if((type != StatementKind.Empty) || (!hideEmptyActions))
    {
      String ret = s ;

      while(ret.length() < requiredLength)
      {
        ret += " " ;
      }

      return ret ;
    }
    else
    {
      return "" ;
    }
  }

  public ASTNode reduceFromMe()
  {
    return doClone().reduceFromMeImpl() ;
  }

  private ASTNode reduceFromMeImpl()
  {
    if(next.size() > 1)
    {
      if((type == StatementKind.Conditional) 
    	  || (type == StatementKind.Empty) || (type == StatementKind.Compute)
    	  || (type == StatementKind.ASTStartOrEnd))
      {
        ASTNode clone = new ASTNode(IDGenerator.getNewIdForName(
        		"ComputationBlocks"), StatementKind.Compute, task) ;
        double min = LongestAndShortestPath.getShortestPath(this, this.join) ;
        double max = LongestAndShortestPath.getLongestPath(this, this.join) ;
        clone.setMinExecutionTime(min) ;
        clone.setMaxExecutionTime(max) ;

        for(ASTNode joinNext : join.next)
        {
          joinNext.removePrevious(this) ;
          joinNext.addPrevious(clone) ;
        }

        return clone.reduceFromMeImpl() ;
      }
      else
      {
        return this;
      }
    }
    else if(next.size() == 1)
    {
      return reduceSequence();
    }
    else
    {
      return this ;
    }
  }

  private ASTNode reduceSequence() 
  {
	ASTNode loneNext = next.get(0).reduceFromMeImpl() ;
    next.clear() ;

	if(canBeReduced() && loneNext.canBeReduced())
	{
		ASTNode clone = new ASTNode(IDGenerator.getNewIdForName("ComputationSeq"),
                    				StatementKind.Compute, task) ;
        clone.setMinExecutionTime(minExecutionTime + loneNext.getMinExecutionTime()) ;
        clone.setMaxExecutionTime(maxExecutionTime + loneNext.getMaxExecutionTime()) ;
        clone.addAllNext(loneNext.next) ;
        
        ArrayList<ASTNode> tmpNext = new ArrayList<ASTNode>() ;
        tmpNext.addAll(loneNext.next) ;
        loneNext.removeAllNext(tmpNext) ;
        return clone.reduceFromMeImpl() ;
    }
    else
    {
    	next.add(loneNext) ;
        return this ;
    }
  }

  private boolean canBeReduced()
  {
	switch (type)
	{
		case GetResource:
		case ReleaseResource:
		case ReadPort:
		case WritePort:
		case ASTStartOrEnd:		return false;
		default:				return true;
	}
  }

  private ASTNode doBasicClone()
  {
    return doBasicClone(name, type) ;
  }

  private ASTNode doBasicClone(String name,
                                StatementKind type)
  {
    ASTNode clone = new ASTNode(name, type, getElement()) ;
    clone.setMinExecutionTime(getMinExecutionTime()) ;
    clone.setMaxExecutionTime(getMaxExecutionTime()) ;
    clone.setResourceID(getResourceID()) ;
    clone.setResourceType(getResourceType()) ;
    return clone ;
  }

  private ASTNode doClone()
  {
    HashMap<ASTNode, ASTNode> cloneToSource =
          new HashMap<ASTNode, ASTNode>() ;
    HashMap<ASTNode, ASTNode> sourceToClone =
          new HashMap<ASTNode, ASTNode>() ;
    ASTNode myClone = doClone(cloneToSource, sourceToClone) ;
    myClone.updateJoin(cloneToSource, sourceToClone) ;
    return myClone ;
  }

  private ASTNode doClone(Map<ASTNode, ASTNode> cloneToSource,
                           Map<ASTNode, ASTNode> sourceToClone)
  {
    ASTNode clone = doBasicClone() ;
    cloneToSource.put(clone, this) ;
    sourceToClone.put(this, clone) ;

    for(ASTNode n : next)
    {
      clone.addNext(n.doClone(cloneToSource, sourceToClone)) ;
    }

    return clone ;
  }

  private void updateJoin(Map<ASTNode, ASTNode> cloneToSource,
                          Map<ASTNode, ASTNode> sourceToClone)
  {
    ASTNode source = cloneToSource.get(this) ;
    join = sourceToClone.get(source.join) ;

    for(ASTNode n : next)
    {
      n.updateJoin(cloneToSource, sourceToClone) ;
    }
  }
}
