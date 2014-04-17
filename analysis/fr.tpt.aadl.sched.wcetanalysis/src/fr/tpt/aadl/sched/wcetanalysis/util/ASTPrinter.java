package fr.tpt.aadl.sched.wcetanalysis.util ;

import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBodyVisitor;

public class ASTPrinter implements TaskBodyVisitor
{

  @Override
  public void visit(TaskBody aTask)
  {
    System.out.println("\n\nTask graph " + aTask.getTask().getName()) ;
    System.out.println(aTask) ;
    System.out.println("Start Time = " + aTask.getStartTime()) ;
    System.out.println("WCET = " + aTask.getWCET()) ;
  }

}
