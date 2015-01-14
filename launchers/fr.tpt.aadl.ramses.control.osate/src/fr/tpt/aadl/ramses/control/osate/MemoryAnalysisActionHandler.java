package fr.tpt.aadl.ramses.control.osate;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.memoryfootprint.MemoryFootprintAnalysis ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;

public class MemoryAnalysisActionHandler extends AnalysisActionHandler
{

  @Override
  protected AnalysisArtifact analysis(SystemInstance sysInst,
                                      IProgressMonitor monitor)
  {
    MemoryFootprintAnalysis analysis = new MemoryFootprintAnalysis ();
    AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE ;
    AnalysisArtifact result = f.createAnalysisArtifact() ;
    analysis.doAnalysis(sysInst, result, 0);
    return result;
  }

  @Override
  protected String getCommandId()
  {
    return "fr.tpt.aadl.ramses.control.osate.outline.memory.analysis" ;
  }

  @Override
  protected String getAnalysisName()
  {
    return "memory" ;
  }

  
}
