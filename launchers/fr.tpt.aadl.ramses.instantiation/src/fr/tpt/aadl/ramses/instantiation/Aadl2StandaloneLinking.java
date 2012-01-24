package fr.tpt.aadl.ramses.instantiation ;

import org.osate.xtext.aadl2.Aadl2StandaloneSetup ;

import com.google.inject.Guice ;
import com.google.inject.Injector ;
import com.google.inject.Module ;

public class Aadl2StandaloneLinking extends Aadl2StandaloneSetup
{
  @Override
  public Injector createInjector()
  {
    return Guice.createInjector((Module) new Aadl2StandaloneRuntimeModule()) ;
  }
}
