package fr.tpt.aadl.sched.wcetanalysis.extractors ;

import java.util.ArrayList ;
import java.util.List ;

import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.util.SequenceUtil;

public class AST2AccessDates
{

  private float inputTime = 0 ;
  private float computationTime = 0 ;
  private float afterWrite = 0 ;

  private float dGet = 0 ;
  private float dRelease = 0 ;

  private float readTime = 0 ;
  private float writeTime = 0 ;

  private List<ResourceAccess> readAccesses = new ArrayList<ResourceAccess>() ;
  private List<ResourceAccess> writeAccesses = new ArrayList<ResourceAccess>() ;

  public AST2AccessDates(ASTNode reduced)
  {
    computeInputTime(reduced) ;
  }

  public List<String> getAccessedResources()
  {
    List<String> res = new ArrayList<String>() ;

    for(ResourceAccess a : readAccesses)
    {
      if(!res.contains(a.getResourceID()))
      {
        res.add(a.getResourceID()) ;
      }
    }

    for(ResourceAccess a : writeAccesses)
    {
      if(!res.contains(a.getResourceID()))
      {
        res.add(a.getResourceID()) ;
      }
    }

    return res ;
  }

  private void computeInputTime(ASTNode current)
  {
    int totalTime = 0 ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t == StatementKind.GetResource)
      {
        inputTime = totalTime ;
        computeWaitRead(current) ;
        break ;
      }
      else
      {
        totalTime += current.getMinExecutionTime() ;
        current = SequenceUtil.next(current) ;
      }
    }
  }

  private void computeWaitRead(ASTNode wait)
  {
    ASTNode current = wait ;
    int waitTime = 0 ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t == StatementKind.GetResource)
      {
        ResourceAccess ra = new ResourceAccess() ;
        ra.setResourceID(current.getResourceID()) ;
        ra.setStart(inputTime + waitTime) ;
        dGet = Math.max(dGet, current.getMaxExecutionTime()) ;
        waitTime += dGet ;
        readAccesses.add(ra) ;
        current = SequenceUtil.next(current) ;
      }
      else
      {
        computeRead(current) ;
        break ;
      }
    }
  }

  private void computeRead(ASTNode firstCompute)
  {
    ASTNode current = firstCompute ;
    int totalReadTime = 0 ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t != StatementKind.ReleaseResource)
      {
        totalReadTime += current.getMaxExecutionTime() ;
        current = SequenceUtil.next(current) ;
      }
      else
      {
        readTime = totalReadTime ;
        computeReleaseRead(current) ;
        break ;
      }
    }
  }

  private void computeReleaseRead(ASTNode firstRelease)
  {
    ASTNode current = firstRelease ;
    float startDate = getStartDateOfFirstReleaseRead() ;
    float releaseTime = 0 ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t == StatementKind.ReleaseResource)
      {
        ResourceAccess ra = getReadAccess(current.getResourceID()) ;
        //releaseTime += current.getMaxExecutionTime();
        dRelease = Math.max(dRelease, current.getMaxExecutionTime()) ;
        releaseTime += dRelease ;
        ra.setEnd(startDate + releaseTime) ;
        current = SequenceUtil.next(current) ;
      }
      else
      {
        computeComputationBlock(current) ;
        break ;
      }
    }
  }

  private float getStartDateOfFirstReleaseRead()
  {
    if(readAccesses.size() > 0)
    {
      ResourceAccess ra = readAccesses.get(readAccesses.size() - 1) ;
      return ra.getStart() + dGet + readTime ;
    }

    return inputTime ;
  }

  private void computeComputationBlock(ASTNode startCompute)
  {
    ASTNode current = startCompute ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t != StatementKind.GetResource)
      {
        computationTime += current.getMinExecutionTime() ;
        current = SequenceUtil.next(current) ;
      }
      else
      {
        computeWaitWrite(current) ;
        break ;
      }
    }
  }

  private void computeWaitWrite(ASTNode wait)
  {
    ASTNode current = wait ;
    float waitTime = 0 ;
    final float startDate = getStartDateOfFirstWaitWrite() ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t == StatementKind.GetResource)
      {
        ResourceAccess ra = new ResourceAccess() ;
        ra.setResourceID(current.getResourceID()) ;
        ra.setStart(startDate + waitTime) ;
        dGet = Math.max(dGet, current.getMaxExecutionTime()) ;
        waitTime += dGet ;
        writeAccesses.add(ra) ;
        current = SequenceUtil.next(current) ;
      }
      else
      {
        computeWrite(current) ;
        break ;
      }
    }
  }

  private float getStartDateOfFirstWaitWrite()
  {
    float res = 0 ;

    if(readAccesses.size() > 0)
    {
      ResourceAccess ra = readAccesses.get(readAccesses.size() - 1) ;
      res = ra.getEnd() ;
    }

    return res + computationTime ;
  }

  private void computeWrite(ASTNode firstCompute)
  {
    ASTNode current = firstCompute ;
    int totalWriteTime = 0 ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t != StatementKind.ReleaseResource)
      {
        totalWriteTime += current.getMaxExecutionTime() ;
        current = SequenceUtil.next(current) ;
      }
      else
      {
        writeTime = totalWriteTime ;
        computeReleaseWrite(current) ;
        break ;
      }
    }
  }

  private void computeReleaseWrite(ASTNode firstRelease)
  {
    ASTNode current = firstRelease ;
    float startDate = getStartDateOfFirstReleaseWrite() ;
    float releaseTime = 0 ;

    while(current != null)
    {
      StatementKind t = current.getType() ;

      if(t == StatementKind.ReleaseResource)
      {
        ResourceAccess ra = getWriteAccess(current.getResourceID()) ;
        //releaseTime += current.getMaxExecutionTime();
        dRelease = Math.max(dRelease, current.getMaxExecutionTime()) ;
        releaseTime += dRelease ;
        ra.setEnd(startDate + releaseTime) ;
        current = SequenceUtil.next(current) ;
      }
      else
      {
        break ;
      }
    }
  }

  private float getStartDateOfFirstReleaseWrite()
  {
    ResourceAccess ra = writeAccesses.get(writeAccesses.size() - 1) ;
    return ra.getStart() + dGet + writeTime ;
  }

  public ResourceAccess getReadAccess(String resourceID)
  {
    for(ResourceAccess a : readAccesses)
    {
      if(a.getResourceID().equals(resourceID))
      {
        return a ;
      }
    }

    return null ;
  }

  public ResourceAccess getWriteAccess(String resourceID)
  {
    for(ResourceAccess a : writeAccesses)
    {
      if(a.getResourceID().equals(resourceID))
      {
        return a ;
      }
    }

    return null ;
  }

  /**
   * @return the beforeRead
   */
  public float getInputTime()
  {
    return inputTime ;
  }

  /**
   * @return the computationTime
   */
  public float getComputationTime()
  {
    return computationTime ;
  }

  /**
   * @return the afterWrite
   */
  public float getAfterWrite()
  {
    return afterWrite ;
  }

  /**
   * @return the dGet
   */
  public float getdGet()
  {
    return dGet ;
  }

  /**
   * @return the dRelease
   */
  public float getdRelease()
  {
    return dRelease ;
  }

  /**
   * @return the readTime
   */
  public float getReadTime()
  {
    return readTime ;
  }

  /**
   * @return the writeTime
   */
  public float getWriteTime()
  {
    return writeTime ;
  }

  /**
   * @return the readAccesses
   */
  public List<ResourceAccess> getReadAccesses()
  {
    return readAccesses ;
  }

  /**
   * @return the writeAccesses
   */
  public List<ResourceAccess> getWriteAccesses()
  {
    return writeAccesses ;
  }
  
  
  
  
  public class ResourceAccess
  {

    private float start = 0 ;
    private float end = 0 ;

    private String resourceID ;

    /**
     * @return the start
     */
    public float getStart()
    {
      return start ;
    }

    /**
     * @param start the start to set
     */
    void setStart(float start)
    {
      this.start = start ;
    }

    /**
     * @return the end
     */
    public float getEnd()
    {
      return end ;
    }

    /**
     * @param end the end to set
     */
    void setEnd(float end)
    {
      this.end = end ;
    }

    /**
     * @return the resourceID
     */
    public String getResourceID()
    {
      return resourceID ;
    }

    /**
     * @param resourceID the resourceID to set
     */
    void setResourceID(String resourceID)
    {
      this.resourceID = resourceID ;
    }
  }
}
