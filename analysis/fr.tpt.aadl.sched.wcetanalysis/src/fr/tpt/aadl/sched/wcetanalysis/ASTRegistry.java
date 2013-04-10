package fr.tpt.aadl.sched.wcetanalysis ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBodyVisitor;

public class ASTRegistry
{

  private Map<NamedElement, List<TaskBody>> process2Bodies =
        new HashMap<NamedElement, List<TaskBody>>() ;
  private List<NamedElement> ignoreForVisitors = new ArrayList<NamedElement>() ;

  private List<TaskBodyVisitor> visitors =
        new ArrayList<TaskBodyVisitor>() ;

  public ASTRegistry(SystemInstance root, AnalysisErrorReporterManager errManager)
  {
    for(ComponentInstance i : root.getAllComponentInstances())
    {
      if(i.getCategory() == ComponentCategory.PROCESS)
      {
        List<TaskBody> allGraphs = ExtractionContext.createTaskBodies(i, errManager) ;
        process2Bodies.put(i, allGraphs) ;
        process2Bodies.put(i.getSubcomponent().getComponentImplementation(),allGraphs) ;
        ignoreForVisitors.add(i);

        for(TaskBody g : allGraphs)
        {
          if(g != null)
          {
            g.setRegistry(this) ;
          }
        }
      }
    }
  }

  public void addTaskBodyVisitor(TaskBodyVisitor v)
  {
    visitors.add(v) ;
  }

  public void notifyVisitors()
  {
    List<TaskBody> whole = getAllBodies() ;

    for(TaskBodyVisitor v : visitors)
    {
      for(TaskBody a : whole)
      {
        v.visit(a) ;
      }
    }
  }

  
  public List<TaskBody> getUsersOf(ComponentInstance process,
                                         String resourceID)
  {
    List<TaskBody> users = new ArrayList<TaskBody>() ;
    ProcessSubcomponent sub = (ProcessSubcomponent) process.getSubcomponent() ;
    ProcessImplementation processC =
          (ProcessImplementation) sub.getClassifier() ;

    for(Connection c : processC.getOwnedConnections())
    {
      if(!(c instanceof AccessConnection))
      {
        continue ;
      }

      AccessConnection acc = (AccessConnection) c ;
      ConnectionEnd source =
            ((ConnectedElement) acc.getSource()).getConnectionEnd() ;
      ConnectionEnd dest =
            ((ConnectedElement) acc.getDestination()).getConnectionEnd() ;

      if((source.getName().equals(resourceID)) && (dest instanceof DataAccess))
      {
        DataAccess access = (DataAccess) dest ;
        ThreadClassifier tt = (ThreadClassifier) access.getOwner() ;

        for(ComponentInstance subP : process.getComponentInstances())
        {
          if(subP.getCategory() == ComponentCategory.THREAD)
          {
            ThreadImplementation sti =
                  (ThreadImplementation) subP.getSubcomponent().getClassifier() ;

            if(sti.getType() == tt)
            {
              TaskBody ta = getBodyForThread(subP) ;

              if(ta != null)
              {
                users.add(ta) ;
              }

              break ;
            }
          }
        }
      }
    }

    return users ;
  }

  public TaskBody getBodyForThread(ComponentInstance task)
  {
    ComponentInstance process = (ComponentInstance) task.getOwner() ;
    List<TaskBody> automatonList = getBodiesForProcess(process) ;

    for(TaskBody a : automatonList)
    {
      if(a.getTask() == task)
      {
        return a ;
      }
    }

    return null ;
  }

  public List<TaskBody> getBodiesForProcess(NamedElement process)
  {
    return process2Bodies.get(process) ;
  }

  public List<TaskBody> getAllBodies()
  {
    List<TaskBody> result = new ArrayList<TaskBody>() ;

    for(NamedElement process : process2Bodies.keySet())
    {
      if(!ignoreForVisitors.contains(process))
      {
        List<TaskBody> l = process2Bodies.get(process) ;
        result.addAll(l) ;
      }
    }

    return result ;
  }
}
