package fr.tpt.aadl.instantiation ;

import org.osate.xtext.aadl2.Aadl2RuntimeModule ;

public class Aadl2StandaloneRuntimeModule extends Aadl2RuntimeModule
{
  @Override
  public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker()
  {
    return Aadl2StandaloneAnnexParserAgent.class ;
  }
}
