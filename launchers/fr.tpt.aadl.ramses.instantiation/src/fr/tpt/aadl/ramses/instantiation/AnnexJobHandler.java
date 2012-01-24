package fr.tpt.aadl.ramses.instantiation ;

import java.util.ArrayList ;
import java.util.List ;

public class AnnexJobHandler
{
  private List<AnnexJob> _jobList = new ArrayList<AnnexJob>() ;

  public void addJob(AnnexJob job)
  {
    _jobList.add(job) ;
  }

  public boolean parseAllAnnexes()
  {
    boolean result = true ;

    for(AnnexJob job : _jobList)
    {
      result &= job.parse() ;
    }

    return result ;
  }

  public boolean resolveAllAnnexes()
  {
    boolean result = true ;

    for(AnnexJob job : _jobList)
    {
      result &= job.resolve() ;
    }

    return result ;
  }
}
