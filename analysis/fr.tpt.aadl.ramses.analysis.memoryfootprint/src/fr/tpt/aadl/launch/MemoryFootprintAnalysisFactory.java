package fr.tpt.aadl.launch;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalyzerFactory ;

public class MemoryFootprintAnalysisFactory implements AnalyzerFactory
{

  @Override
  public Analyzer createAnalyzer(AadlModelInstantiatior modelInstantiatior,
                                 PredefinedAadlModelManager predefinedAadlModels)
  {
    return new MemoryFootprintAnalyzer (modelInstantiatior, predefinedAadlModels);
  }

}
