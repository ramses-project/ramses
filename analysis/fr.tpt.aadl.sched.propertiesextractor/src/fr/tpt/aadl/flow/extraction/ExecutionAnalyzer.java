package fr.tpt.aadl.flow.extraction ;

import org.osate.aadl2.Element ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

public abstract class ExecutionAnalyzer
{

  protected final AnalysisErrorReporterManager errManager ;

  public ExecutionAnalyzer(
                           AnalysisErrorReporterManager errManager)
  {
    this.errManager = errManager ;
  }

  public void reportError(Element target,
                          String msg)
  {
    System.err.println("[Error]" + msg) ;
    System.err.flush() ;
    /*
    if ((errManager != null) && (target!=null))
    {
      errManager.error(target, msg);
    }*/
  }

  public void reportWarning(Element target,
                            String msg)
  {
    System.err.println("[Warning] " + msg) ;
    System.err.flush() ;
    /*
    if ((errManager != null) && (target!=null))
    {
      errManager.warning(target, msg);
    }*/
  }

}
