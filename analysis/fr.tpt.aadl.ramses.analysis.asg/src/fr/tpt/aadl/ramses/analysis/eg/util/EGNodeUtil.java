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

package fr.tpt.aadl.ramses.analysis.eg.util;

import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;

public class EGNodeUtil {

	private static Map<EGNode, EGNode> sourceToClone = 
			new HashMap<EGNode,EGNode>();
	
	private EGNodeUtil(){}
	
	public static EGNode clone(EGNode n)
	{
	  if (n==null)
	  {
	    return null;
	  }
	  else if (sourceToClone.containsKey(n))
	  {
	    return sourceToClone.get(n);
	  }
	  else
		{
			return cloneImpl(n);
		}		
	}
	
	private static EGNode cloneImpl(EGNode n)
	{
	  EGNode n2 = new EGNode(n);
	  sourceToClone.put(n, n2);
	  
    for(EGNode sourceNext : n.getAllNext())
    {
      EGNode next = clone(sourceNext);
      n2.addNext(next);
    }
    n2.setBlockEnd(clone(n.getBlockEnd()));
    
    return n2;
	}
	
	public static double computeBCET (EGNode root)
	{
	  return computeBCET(root,root.getBlockEnd());
	}
	
	public static double computeWCET (EGNode root)
  {
    return computeWCET(root,root.getBlockEnd());
  }
	
	private static double computeBCET (EGNode source, EGNode end)
	{
	  double currentBCET = source.getBCET();
	  if (source != end)
	  {
	    List<EGNode> nextNodes = source.getAllNext();
	    if (nextNodes.size()==1)
	    {
	      EGNode loneNext = source.getAllNext().get(0);
	      currentBCET = currentBCET + computeBCET (loneNext,end);
	    }
	    else if (nextNodes.size()==2)
	    {
	      double subBCET1 = computeBCET (nextNodes.get(0),end);
	      double subBCET2 = computeBCET (nextNodes.get(1),end);
	      currentBCET = currentBCET + Math.min(subBCET1, subBCET2);
	    }
	  }
	  return currentBCET;
	}
	
	private static double computeWCET (EGNode source, EGNode end)
  {
    double currentWCET = source.getWCET();
    if (source != end)
    {
      List<EGNode> nextNodes = source.getAllNext();
      if (nextNodes.size()==1)
      {
        EGNode loneNext = source.getAllNext().get(0);
        currentWCET = currentWCET + computeWCET (loneNext,end);
      }
      else if (nextNodes.size()==2)
      {
        double subWCET1 = computeWCET (nextNodes.get(0),end);
        double subWCET2 = computeWCET (nextNodes.get(1),end);
        currentWCET = currentWCET + Math.max(subWCET1, subWCET2);
      }
    }
    return currentWCET;
  }
}