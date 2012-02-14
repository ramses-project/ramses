package fr.tpt.aadl.sched.cheddar.model ;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;

import org.osate.aadl2.Element ;

public class CheddarProcessor extends CheddarElement
{

  private boolean withNetwork = false ;

  private String schedulerType = "" ;

  private SchedulerPipeline automaton = null ;

  private List<CheddarTask> ownedTasks = new ArrayList<CheddarTask>() ;

  public CheddarProcessor(
                          Element aadlProcessor, SchedulerPipeline automaton)
  {
    super(aadlProcessor) ;
    this.automaton = automaton ;
  }

  void addTask(CheddarTask task)
  {
    ownedTasks.add(task) ;
  }

  void removeTask(CheddarTask task)
  {
    ownedTasks.remove(task) ;
  }

  protected void setModel(CheddarModel model)
  {
    super.setModel(model) ;

    if(automaton != null)
    {
      automaton.setModel(model) ;
    }
  }

  public List<CheddarTask> getOwnedTasks()
  {
    return Collections.unmodifiableList(ownedTasks) ;
  }

  public boolean isWithNetwork()
  {
    return withNetwork ;
  }

  public void setWithNetwork(boolean withNetwork)
  {
    this.withNetwork = withNetwork ;
  }

  public String getSchedulerType()
  {
    return schedulerType ;
  }

  public void setSchedulerType(String schedulerType)
  {
    this.schedulerType = schedulerType ;
  }

  public boolean hasAutomaton()
  {
    return automaton != null ;
  }

  public SchedulerPipeline getCustomScheduler()
  {
    return automaton ;
  }

  public void saveSchedulerAs(String outputPath)
  {
    if(hasAutomaton())
    {
      try
      {
        automaton.saveTo(outputPath) ;
      }
      catch(Exception e)
      {
        e.printStackTrace() ;
      }
    }
  }

}
