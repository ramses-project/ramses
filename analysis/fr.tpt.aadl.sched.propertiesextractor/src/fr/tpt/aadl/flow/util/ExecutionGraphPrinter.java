package fr.tpt.aadl.flow.util ;

import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.flow.model.ExecutionGraphVisitor ;

public class ExecutionGraphPrinter implements ExecutionGraphVisitor
{

  @Override
  public void visit(ExecutionGraph aTask)
  {
    System.out.println("\n\nTask graph " + aTask.getTask().getName()) ;
    System.out.println(aTask) ;
    System.out.println("Start Time = " + aTask.getStartTime()) ;
    System.out.println("WCET = " + aTask.getWCET()) ;
  }

}
