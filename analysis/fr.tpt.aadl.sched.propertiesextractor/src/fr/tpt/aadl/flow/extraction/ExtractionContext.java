package fr.tpt.aadl.flow.extraction ;

import java.util.ArrayList ;
import java.util.List ;

import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.flow.extraction.ba.TransitionAnalyzer ;
import fr.tpt.aadl.flow.extraction.types.SubprogramAnalyzer ;
import fr.tpt.aadl.flow.extraction.types.ThreadAnalyzer ;
import fr.tpt.aadl.flow.model.ExecutionGraph ;

public class ExtractionContext extends ExecutionAnalyzer
{

  private final ThreadAnalyzer threadA ;
  private final SubprogramAnalyzer spgA ;
  private final TransitionAnalyzer transA ;

  public ExtractionContext(
                           AnalysisErrorReporterManager errManager)
  {
    super(errManager) ;
    transA = new TransitionAnalyzer(this) ;
    threadA = new ThreadAnalyzer(this) ;
    spgA = new SubprogramAnalyzer(this) ;
  }

  public AnalysisErrorReporterManager getErrManager()
  {
    return errManager ;
  }

  public ThreadAnalyzer getThreadAnalyzer()
  {
    return threadA ;
  }

  public SubprogramAnalyzer getSubprogramAnalyzer()
  {
    return spgA ;
  }

  public TransitionAnalyzer getTransitionAnalyzer()
  {
    return transA ;
  }

  public static List<ExecutionGraph> createGraphList(ComponentInstance process,
                                                     AnalysisErrorReporterManager errManager)
  {
    List<ExecutionGraph> ownedGraphs = new ArrayList<ExecutionGraph>() ;
    ExtractionContext ctxt = new ExtractionContext(errManager) ;

    for(ComponentInstance owned : process.getComponentInstances())
    {
      if(owned.getCategory() == ComponentCategory.THREAD)
      {
        ExecutionGraph aTask = ctxt.getThreadAnalyzer().extractFrom(owned) ;

        if(aTask != null)
        {
          // Component owns a behavior annex: execution is extracted from it
          ownedGraphs.add(aTask) ;
        }
      }
    }

    return ownedGraphs ;
  }
}
