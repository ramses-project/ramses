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

package fr.tpt.aadl.ramses.analysis.eg.model;

import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.NamedElement ;

import fr.tpt.aadl.ramses.analysis.eg.context.EGContext ;
import fr.tpt.aadl.ramses.analysis.eg.util.EGNodeUtil ;
import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public final class EGNode {

	private String name = "ASNode";
	private double bcet = 0d;
	private double wcet = 0d;
	private EGNodeKind kind = EGNodeKind.Computation;
	private NamedElement sharedData = null;
	private NamedElement sharedDataAccess = null;
	
	private List<EGNode> nextNodes = new ArrayList<EGNode>();
	
	/** Returns "endif" node for "if" node, null otherwise */
	private EGNode blockEnd = null;
	
	private final NamedElement thread;
	
	private static Logger _LOGGER = Logger.getLogger(EGNode.class) ;
	
	private static int instanceCounter = 0;
	private final int instanceIndex;
	
	{
	  instanceCounter++;
	  instanceIndex = instanceCounter;
	}
	
	public EGNode(String name)
	{
		setName(name);
		this.thread = EGContext.getInstance().getCurrentThread();
		this.blockEnd = this;
	}
	
	public EGNode(EGNode n)
	{
		this(n,n.getName());
	}
	
	public EGNode(EGNode n, String name)
	{
		setName(name);
		this.thread = n.getThread();
		this.bcet = n.bcet;
		this.wcet = n.wcet;
		this.kind = n.kind;
		this.sharedData = n.sharedData;
		this.sharedDataAccess = n.sharedDataAccess;
	}
	
	public void setBlockEnd(EGNode n)
	{
		blockEnd = n;
	}
	
	public EGNode getBlockEnd()
	{
		return blockEnd;
	}
	
	private void setName(String name)
	{
	  int indexSep = name.lastIndexOf("_");
	  if (indexSep != -1)
	  {
	    String suffix = name.substring(indexSep+1);
	    try 
	    { 
	      Integer.parseInt(suffix);
	      name = name.substring(0,indexSep);
	    } 
	    catch (NumberFormatException e)
	    {
	      String msg = RamsesException.formatRethrowMessage("cannot parse integer",
	                                                        e);
	      _LOGGER.error(msg, e);
	      ServiceProvider.SYS_ERR_REP.error(msg, true);
	    }
	  }
	  
		this.name = name + "_" + instanceIndex;
	}
	
	public String getName()
	{
		return name;
	}
	
	public NamedElement getThread()
	{
		return thread;
	}
	
	public void setKind(EGNodeKind kind)
	{
		this.kind = kind;
	}
	
	public EGNodeKind getKind()
	{
		return kind;
	}
	
	public void setSharedData(NamedElement data)
	{
		sharedData = data;
	}
	
	public void setSharedDataAccess(NamedElement dataAccess)
	{
	  sharedDataAccess = dataAccess;
	}
	
	public NamedElement getSharedData()
	{
		return sharedData;
	}
	
	public NamedElement getSharedDataAccess()
	{
	  return sharedDataAccess;
	}
	
	public void setBCET_and_WCET(double time)
	{
		bcet = time;
		wcet = time;
	}
	
	public void setBCET(double bcet)
	{
		this.bcet = bcet;
	}
	
	public void setWCET(double wcet)
	{
		this.wcet = wcet;
	}
	
	public void addTimeOverhead(double ov)
	{
		bcet = bcet + ov;
		wcet = wcet + ov;
	}

	public double getBCET()
	{
		return bcet;
	}
	
	public double getWCET()
	{
		return wcet;
	}
	
	public double getThreadWCET()
	{
	  double w = wcet;
	  if (nextNodes.size()==1)
	  {
	    w+= nextNodes.get(0).getThreadWCET();
	  }
	  return w;
	}
	
	public List<EGNode> getAllNext()
	{
		return nextNodes;
	}
	
	public void addNext(EGNode n)
	{
		if (!nextNodes.contains(n))
			nextNodes.add(n);
	}
	
	public void removeNext(EGNode n)
	{
		if (nextNodes.contains(n))
			nextNodes.remove(n);
	}
	
	/** Reduce conditional block */
	private boolean mergeBranches()
	{
		if (nextNodes.size()>1)
		{
			/*double min = LongestAndShortestPath.getShortestPath(
					this, this.getBlockEnd()) ;
			
			double max = LongestAndShortestPath.getLongestPath(
	        		this, this.getBlockEnd()) ;*/
		  
		  final double min = EGNodeUtil.computeBCET(this);
		  final double max = EGNodeUtil.computeWCET(this);
      
		  _LOGGER.debug("Merge branches from " + this.getName() + 
		                     " ("+nextNodes.get(0).getName()+","+nextNodes.get(1).getName()+")");
		  _LOGGER.debug(" => BCET: " + min + "\t" + "WCET: " + max);
		  
			setBCET(min);
      setWCET(max);
      nextNodes.clear();
      nextNodes.addAll(blockEnd.nextNodes);
      blockEnd.nextNodes.clear();
      blockEnd = this;
      setName("if_block");
      return true;
		}
		else
		{
		  return false;
		}
	}
	
	public boolean merge()
	{
	  boolean merged = false;
	  
	  if (nextNodes.size()>1)
		{
			merged = mergeBranches();
		}
	  if (nextNodes.isEmpty())
    {
      return merged;
    }
		
	  EGNode next = nextNodes.get(0);
		
		if (this.isMergeable() && next.isMergeable())
		{
		  _LOGGER.debug("Merge sequence: " + getName() + " with " + next.getName());
		  _LOGGER.debug(" => This BCET: " + bcet + "\t" + "This WCET: " + wcet);
		  _LOGGER.debug(" => Next BCET: " + next.getBCET() + "\t" + "Next WCET: " + next.getWCET());
      
      setBCET(bcet + next.getBCET());
      setWCET(wcet + next.getWCET());
      
      _LOGGER.debug(" => New BCET: " + bcet + "\t" + "New WCET: " + wcet);
      
      setName("Computation_Block");
      nextNodes.clear();
      nextNodes.addAll(next.nextNodes);
      next.nextNodes.clear();
      
      merged = merge();
		}
		else
		{
		  merged = next.merge();
		  if (merged)
		  {
		    merge();
		  }
		}
		return merged;
	}
	
	private boolean isMergeable()
	{
	  return kind.isMergeable() && nextNodes.size()<2;
	}
}