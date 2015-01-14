package fr.tpt.aadl.ramses.generation.target.specific;

import fr.tpt.aadl.ramses.control.atl.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.GeneratorFactory ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;

public class WorkflowGeneratorFactory implements GeneratorFactory
{

  @Override
  public Generator
      createGenerator(AadlModelInstantiatior modelInstantiator,
                      PredefinedAadlModelManager predefinedAadlModels)
  {
    AadlToTargetSpecificAadl targetTrans = 
        new WorkflowBasedTransformation(modelInstantiator, predefinedAadlModels);
    AadlTargetSpecificGenerator result = 
        new AadlTargetSpecificGenerator(targetTrans, null,
                                        modelInstantiator,
                                        null,
                                        predefinedAadlModels) ;

    result.setRegistryName("workflow_only") ;

    return result ;
  }

}
