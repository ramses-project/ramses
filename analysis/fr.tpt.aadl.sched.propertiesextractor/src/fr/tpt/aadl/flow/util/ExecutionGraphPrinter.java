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

package fr.tpt.aadl.flow.util ;

import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.flow.model.ExecutionGraphVisitor ;

public class ExecutionGraphPrinter implements ExecutionGraphVisitor
{
  @Override
  public void visit(ExecutionGraph aTask)
  {
    // TODO: analyse result reporting.
    System.out.println("\n\nTask graph " + aTask.getTask().getName()) ;
    System.out.println(aTask) ;
    System.out.println("Start Time = " + aTask.getStartTime()) ;
    System.out.println("WCET = " + aTask.getWCET()) ;
  }
}