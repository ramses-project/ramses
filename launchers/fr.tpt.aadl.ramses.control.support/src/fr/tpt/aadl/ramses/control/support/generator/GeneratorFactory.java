package fr.tpt.aadl.ramses.control.support.generator;

import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public interface GeneratorFactory {

  /**
   * 
   * @param modelInstantiatior
   * @param predefinedAadlModels
   * @param includeDirs the set of directory paths that may contain AADL model or user code.
   * @return
   */
	public Generator createGenerator(AadlModelInstantiatior modelInstantiatior,
	                                 PredefinedAadlModelManager predefinedAadlModels);
}