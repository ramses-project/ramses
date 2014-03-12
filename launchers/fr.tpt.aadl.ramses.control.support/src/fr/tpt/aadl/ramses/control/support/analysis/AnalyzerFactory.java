package fr.tpt.aadl.ramses.control.support.analysis;

import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public interface AnalyzerFactory
{
  public Analyzer createAnalyzer(AadlModelInstantiatior modelInstantiatior,
                                 PredefinedAadlModelManager predefinedAadlModels) ;
}
