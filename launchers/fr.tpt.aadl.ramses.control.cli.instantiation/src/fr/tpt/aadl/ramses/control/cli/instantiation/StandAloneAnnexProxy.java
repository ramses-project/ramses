package fr.tpt.aadl.ramses.control.cli.instantiation;

import org.eclipse.core.runtime.IConfigurationElement ;
import org.osate.annexsupport.AnnexProxy ;

public class StandAloneAnnexProxy extends AnnexProxy
{
  StandAloneAnnexProxy(IConfigurationElement configElem)
  {
    super(configElem) ;
  }

  StandAloneAnnexProxy(String id,
                       String name,
                       String annexName,
                       String className)
  {
    super(id, name, annexName, className) ;
  }
}