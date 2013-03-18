package fr.tpt.aadl.sched.cheddar.model ;

import java.util.ArrayList ;

import java.util.Collection ;
import java.util.List ;

import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.flow.model.ExecutionGraph ;
import fr.tpt.aadl.sched.cheddar.CheddarContext ;
import fr.tpt.aadl.sched.cheddar.strategies.arinc.ARINC653Scheduler ;

public class CheddarModel
{

  private final List<CheddarElement> content ;
  private final CheddarContext strategy ;
  private final SystemInstance root ;

  private float scaling = 1f ;

  public CheddarModel(
                      List<CheddarElement> content, CheddarContext strategy,
                      SystemInstance root)
  {
    this.content = content ;
    this.strategy = strategy ;
    this.root = root ;

    for(CheddarElement e : content)
    {
      e.setModel(this) ;
    }
  }

  public float getScaling()
  {
    return scaling ;
  }

  public void setScaling(float scaling)
  {
    this.scaling = scaling ;
  }

  public SystemInstance getAADLModel()
  {
    return root ;
  }

  public CheddarProcessor getProcessor(String name)
  {
    for(CheddarElement e : content)
    {
      if((e instanceof CheddarProcessor) && (e.getName().equals(name)))
      {
        return (CheddarProcessor) e ;
      }
    }

    return null ;
  }

  public List<CheddarProcessor> getAllProcessors()
  {
    List<CheddarProcessor> res = new ArrayList<CheddarProcessor>() ;

    for(CheddarElement e : content)
    {
      if(e instanceof CheddarProcessor)
      {
        res.add((CheddarProcessor) e) ;
      }
    }

    return res ;
  }

  public CheddarAddressSpace getAddressSpace(String name,
                                             String processorName)
  {
    for(CheddarElement e : content)
    {
      if((e instanceof CheddarAddressSpace) && (e.getName().equals(name)))
      {
        CheddarAddressSpace a = (CheddarAddressSpace) e ;

        if(a.getOwner().getName().equals(processorName))
        {
          return a ;
        }
      }
    }

    return null ;
  }

  public List<CheddarAddressSpace> getAllAddressSpaces()
  {
    List<CheddarAddressSpace> res = new ArrayList<CheddarAddressSpace>() ;

    for(CheddarElement e : content)
    {
      if(e instanceof CheddarAddressSpace)
      {
        res.add((CheddarAddressSpace) e) ;
      }
    }

    return res ;
  }

  public List<CheddarTask> getAllTasks()
  {
    List<CheddarTask> res = new ArrayList<CheddarTask>() ;

    for(CheddarElement e : content)
    {
      if(e instanceof CheddarTask)
      {
        res.add((CheddarTask) e) ;
      }
    }

    return res ;
  }

  public Collection<CheddarTask> getTasks(CheddarAddressSpace as)
  {
    List<CheddarTask> res = new ArrayList<CheddarTask>() ;

    for(CheddarElement e : content)
    {
      if(e instanceof CheddarTask)
      {
        CheddarTask t = (CheddarTask) e ;

        if(t.getOwner() == as)
        {
          res.add(t) ;
        }
      }
    }

    return res ;
  }

  public CheddarTask getTask(String name,
                             String addressSpaceName,
                             String processorName)
  {
    for(CheddarElement e : content)
    {
      if((e instanceof CheddarTask) && (e.getName().equals(name)))
      {
        CheddarTask t = (CheddarTask) e ;
        CheddarAddressSpace a = t.getOwner() ;

        if(a.getName().equals(addressSpaceName) &&
              a.getOwner().getName().equals(processorName))
        {
          return t ;
        }
      }
    }

    return null ;
  }

  public CheddarTask getTask(String name,
                             String processorName)
  {
    int indexSep = name.indexOf(".") ;
    String addressSpaceName = name.substring(0, indexSep) ;
    return getTask(name, addressSpaceName, processorName) ;
  }

  public CheddarTask getTask(ComponentInstance aadlTask)
  {
    for(CheddarElement e : content)
    {
      if(e instanceof CheddarTask)
      {
        if(((CheddarTask) e).getAADLElement() == aadlTask)
        {
          return (CheddarTask) e ;
        }
      }
    }

    return null ;
  }

  public List<CheddarElement> getContent()
  {
    return content ;
  }

  public static List<CheddarTask> getUsersOf(CheddarResource r)
  {
    List<CheddarTask> ret = new ArrayList<CheddarTask>() ;

    for(ResourceUse u : r.getUses())
    {
      if(!ret.contains(u.getUser()))
      {
        ret.add(u.getUser()) ;
      }
    }

    return ret ;
  }

  public static List<CheddarResource> getUsesOf(CheddarTask t)
  {
    List<CheddarResource> ret = new ArrayList<CheddarResource>() ;

    for(ResourceUse u : t.getUses())
    {
      if(!ret.contains(u.getResource()))
      {
        ret.add(u.getResource()) ;
      }
    }

    return ret ;
  }

  public static CheddarResource getUseOf(CheddarTask t,
                                         String resourceID)
  {
    for(ResourceUse u : t.getUses())
    {
      if(u.getResource().getName().equals(resourceID))
      {
        return u.getResource() ;
      }
    }

    return null ;
  }

  public ExecutionGraph getExecutionOf(CheddarTask t)
  {
    return strategy.getExecutionRegistry()
          .getExecutionForTask((ComponentInstance) t.getAADLElement()) ;
  }

  public int getSimulationPeriod()
  {
    return strategy.getSimulationPeriod(this) ;
  }

  public boolean isARINC653()
  {
    CheddarProcessor cpu = getAllProcessors().get(0) ;
    return cpu.hasAutomaton() &&
          (cpu.getCustomScheduler() instanceof ARINC653Scheduler) ;
  }
}
