package fr.tpt.aadl.ramses.control.cli.instantiation;

import org.osate.xtext.aadl2.linking.Aadl2LinkingService;

public class Aadl2StandaloneLinkingService extends Aadl2LinkingService
{
  
  StandAloneAnnexRegistry linkingserviceregistry;
  
  Aadl2StandaloneLinkingService()
  {
    super();
  }
  
  @Override
  protected void initAnnexLinkingServiceRegistry()
  {
    linkingserviceregistry = new StandAloneAnnexRegistry();
  }
}