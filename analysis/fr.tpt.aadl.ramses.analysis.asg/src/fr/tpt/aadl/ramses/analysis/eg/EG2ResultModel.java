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

package fr.tpt.aadl.ramses.analysis.eg;

import java.util.List ;
import java.util.Map.Entry ;

import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.ramses.analysis.eg.model.EGModels ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNodeKind ;
import fr.tpt.aadl.ramses.util.properties.AadlUtil ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaFactory ;

public class EG2ResultModel
{
  private final EGModels model;
  
  public EG2ResultModel(EGModels model)
  {
    this.model = model;
  }
  
  public AnalysisModel getAnalysisModel()
  {
    ReducedbaFactory factory = ReducedbaFactory.eINSTANCE;
    AnalysisModel m = factory.createAnalysisModel();
    for(Entry<ComponentInstance,EGNode> entry: model.entries())
    {
      
      ReducedThreadBA reducedba = getReducedBA(entry.getKey(),entry.getValue());
      m.getThreadsBA().add(reducedba);
    }
    return m;
  }
  
  private ReducedThreadBA getReducedBA(ComponentInstance thread, EGNode root)
  {
    ReducedbaFactory factory = ReducedbaFactory.eINSTANCE; 
    ReducedThreadBA bamodel = factory.createReducedThreadBA();
    
    bamodel.setThread(thread);
    
    addCriticalSectionOverheads(root);
    
    EGNode node = root;
    
    while (node != null)
    {
      if (node.getKind() == EGNodeKind.CriticalSectionStart)
      {
        CriticalSectionBegin csBegin = factory.createCriticalSectionBegin();
        csBegin.setSharedData((DataAccess) node.getSharedDataAccess());
        bamodel.getElements().add(csBegin);
      }
      else if (node.getKind() == EGNodeKind.CriticalSectionEnd)
      {
        CriticalSectionEnd csEnd = factory.createCriticalSectionEnd();
        csEnd.setSharedData((DataAccess) node.getSharedDataAccess());
        bamodel.getElements().add(csEnd);
      }
      else
      {
        Computation comp = factory.createComputation();
        double bcet = node.getBCET();
        double wcet = node.getWCET();
        
        String precision = AadlUtil.getPrecision(node.getThread());
        
        comp.setMin(bcet);
        comp.setMax(wcet);
        comp.setUnit(precision);
        
        bamodel.getElements().add(comp);
      }
      
      if (!node.getAllNext().isEmpty())
      {
        node = node.getAllNext().get(0);
      }
      else
      {
        node = null;
      }
    }
    
    return bamodel;
  }
  
  private static void addCriticalSectionOverheads(EGNode root)
  {
    List<EGNode> nextNodes = root.getAllNext();
    if (nextNodes.size()==1)
    {
      EGNode next = nextNodes.get(0);
      if ((root.getKind()==EGNodeKind.CriticalSectionStart)
            && (next.getKind()==EGNodeKind.Computation))
      {
        next.setBCET(next.getBCET()+root.getBCET());
        next.setWCET(next.getWCET()+root.getWCET());
        root.setBCET(0);
        root.setWCET(0);
      }
      else if ((root.getKind()==EGNodeKind.Computation)
            && (next.getKind()==EGNodeKind.CriticalSectionEnd))
      {
        root.setBCET(next.getBCET()+root.getBCET());
        root.setWCET(next.getWCET()+root.getWCET());
        next.setBCET(0);
        next.setWCET(0);
      }
      addCriticalSectionOverheads(next);
    }
  }
}