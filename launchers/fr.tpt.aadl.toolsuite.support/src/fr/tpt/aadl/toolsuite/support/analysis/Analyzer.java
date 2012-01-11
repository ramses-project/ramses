package fr.tpt.aadl.toolsuite.support.analysis ;

import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.toolsuite.support.plugins.NamedPlugin ;

public interface Analyzer extends NamedPlugin
{
  // TODO : return generic analysis results. Any ideas ? Return Resource ???
  public void performAnalysis(SystemInstance instance,
                              AnalysisErrorReporterManager errReporterManager,
                              IProgressMonitor monitor)
        throws AnalysisResultException ;

  public void setParameters(Map<AnalyzerParameter, String> parameters)
        throws Exception ;
}
