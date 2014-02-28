package fr.tpt.aadl.ramses.analysis.eg;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalyzerFactory ;

public class EGAnalyzerFactory implements AnalyzerFactory
{

  @Override
  public Analyzer createAnalyzer(AadlModelInstantiatior modelInstantiatior,
                                 PredefinedAadlModelManager predefinedAadlModels)
  {
    return new EGAnalyzer (modelInstantiatior, predefinedAadlModels);
  }

}
