package fr.tpt.aadl.ramses.control.osate;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.maintainability.MaintainabilityAnalysis ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;

public class MaintainabilityAnalysisActionHandler extends AnalysisActionHandler
{
  
  protected AnalysisArtifact analysis(SystemInstance sysInst,
                        IProgressMonitor monitor) 
  {
    MaintainabilityAnalysis analysis = new MaintainabilityAnalysis();
    AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE ;
    AnalysisArtifact result = f.createAnalysisArtifact() ;
    analysis.doAnalysis(sysInst, result, 0);
    return result;
  }

  @Override
  protected String getCommandId()
  {
    return "fr.tpt.aadl.ramses.control.osate.outline.maintainability.analysis" ;
  }

  @Override
  protected String getAnalysisName()
  {
    return "maintainability";
  }
}
