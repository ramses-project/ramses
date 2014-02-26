package fr.tpt.aadl.ramses.control.cli.instantiation;

import java.util.HashMap ;

import org.eclipse.core.runtime.IConfigurationElement ;
import org.eclipse.core.runtime.Platform ;
import org.osate.annexsupport.AnnexProxy ;
import org.osate.annexsupport.AnnexRegistry ;

public class StandAloneAnnexRegistry extends AnnexRegistry
{

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  protected void initialize(String extensionId) {
    if(Platform.isRunning())
      super.initialize(extensionId);
    else
    {
      extensions = new HashMap();
      extensions.put("behavior_specification", null);
    }
  }
  
  @Override
  protected AnnexProxy createProxy(IConfigurationElement configElem)
  {
    return new StandAloneAnnexProxy(configElem);
  }

}
