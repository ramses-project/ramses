package fr.tpt.aadl.launch;

import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalyzerFactory ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class CheddarFactory implements AnalyzerFactory
{
  @Override
  public Analyzer createAnalyzer(AadlModelInstantiatior modelInstantiatior,
                                 PredefinedAadlModelManager predefinedAadlModels)
  {
    return new WCETAnalysis() ;
  }
}