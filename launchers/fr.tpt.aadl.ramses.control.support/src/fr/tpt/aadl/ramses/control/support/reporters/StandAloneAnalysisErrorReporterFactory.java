package fr.tpt.aadl.ramses.control.support.reporters ;

import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporter ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterFactory ;

public class StandAloneAnalysisErrorReporterFactory implements
                                                   AnalysisErrorReporterFactory
{

  private MessageReporter _reporter ;

  public StandAloneAnalysisErrorReporterFactory(
                                                MessageReporter reporter)
  {
    _reporter = reporter ;
  }

  @Override
  public AnalysisErrorReporter getReporterFor(Resource rsrc)
  {
    return new StandAloneAnalysisErrorReporter(rsrc, _reporter) ;
  }
}
