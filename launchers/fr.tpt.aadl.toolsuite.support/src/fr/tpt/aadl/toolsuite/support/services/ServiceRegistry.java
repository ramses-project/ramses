package fr.tpt.aadl.toolsuite.support.services ;

import java.util.Set ;

import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterFactory ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;
import org.osate.annexsupport.AnnexUnparser ;

import fr.tpt.aadl.toolsuite.support.analysis.Analyzer ;
import fr.tpt.aadl.toolsuite.support.reporters.MessageReporter ;
import fr.tpt.aadl.toolsuite.support.reporters.StandAloneAnalysisErrorReporterFactory ;
import fr.tpt.aadl.toolsuite.support.reporters.StandAloneInternalErrorReporter ;
import fr.tpt.aadl.toolsuite.support.reporters.StandAloneParseErrorReporter ;
import fr.tpt.aadl.toolsuite.support.reporters.StdOutputMessageReporter ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;

public interface ServiceRegistry
{
  public final static MessageReporter MSG_REPORTER =
        new StdOutputMessageReporter() ;

  public final static InternalErrorReporter INT_ERR_REPORTER =
        new StandAloneInternalErrorReporter(MSG_REPORTER) ;

  public final static StandAloneParseErrorReporter PARSE_ERR_REPORTER =
        new StandAloneParseErrorReporter(MSG_REPORTER) ;

  public final static AnalysisErrorReporterFactory ANALYSIS_ERR_REPORTER_FACT =
        new StandAloneAnalysisErrorReporterFactory(MSG_REPORTER) ;

  public final static AnalysisErrorReporterManager ANALYSIS_ERR_REPORTER_MANAGER =
        new AnalysisErrorReporterManager(INT_ERR_REPORTER,
              ANALYSIS_ERR_REPORTER_FACT) ;

  public boolean isOSGi() ;

  public AnnexParser getParser(String annexName) ;

  public AnnexResolver getResolver(String annexName) ;

  public AnnexUnparser getUnparser(String annexName) ;

  public Set<String> getAvailableAnalysisNames() ;

  public Analyzer getAnalyzer(String analyzerName) ;

  public Set<String> getAvailableTransformationNames() ;

  public Generator getTransformation(String TransformationName) ;
}
