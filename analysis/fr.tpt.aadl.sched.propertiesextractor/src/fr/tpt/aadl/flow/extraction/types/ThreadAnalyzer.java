package fr.tpt.aadl.flow.extraction.types ;

import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorAnnex ;

import fr.tpt.aadl.flow.extraction.ExecutionAnalyzer ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.ba.types.ThreadAA ;
import fr.tpt.aadl.flow.extraction.seq.types.ThreadSA ;
import fr.tpt.aadl.flow.extraction.util.BehaviorAnnexUtil ;
import fr.tpt.aadl.flow.model.ExecutionGraph ;

public class ThreadAnalyzer extends ExecutionAnalyzer
{

  private final ThreadAA threadAA ;
  private final ThreadSA threadSA ;

  public ThreadAnalyzer(
                        ExtractionContext ctxt)
  {
    super(ctxt.getErrManager()) ;
    threadAA = new ThreadAA(ctxt) ;
    threadSA = new ThreadSA(ctxt) ;
  }

  public final ExecutionGraph extractFrom(ComponentInstance task)
  {
    BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(task) ;

    if(ba != null)
    {
      return threadAA.extractFrom(ba, task) ;
    }
    else
    {
      return threadSA.extractFrom(task) ;
    }
  }

}
