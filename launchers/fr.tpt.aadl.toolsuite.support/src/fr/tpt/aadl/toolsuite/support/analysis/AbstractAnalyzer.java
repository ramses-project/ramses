package fr.tpt.aadl.toolsuite.support.analysis ;

import org.osate.aadl2.instance.SystemInstance ;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelModifyActionAction ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import org.eclipse.core.runtime.IProgressMonitor ;

import fr.tpt.aadl.toolsuite.support.plugins.NamedPlugin ;

public abstract class AbstractAnalyzer extends
                                      AbstractInstanceOrDeclarativeModelModifyActionAction
                                                                                          implements
                                                                                          Analyzer,
                                                                                          NamedPlugin

{
  @Override
  public void performAnalysis(SystemInstance instance,
                              AnalysisErrorReporterManager errReporterManager,
                              IProgressMonitor monitor)
        throws AnalysisResultException
  {
    this.analyzeInstanceModel(monitor, errReporterManager, instance, null) ;
  }
}
