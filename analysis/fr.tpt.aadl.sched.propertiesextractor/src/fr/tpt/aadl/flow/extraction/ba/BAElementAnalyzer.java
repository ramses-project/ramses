package fr.tpt.aadl.flow.extraction.ba ;

import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.flow.extraction.ExecutionAnalyzer ;

public abstract class BAElementAnalyzer extends ExecutionAnalyzer
{

  public BAElementAnalyzer(
                           AnalysisErrorReporterManager errManager)
  {
    super(errManager) ;
  }
}
