package fr.tpt.aadl.ramses.instantiation;

import java.util.HashMap ;

import org.eclipse.core.runtime.IConfigurationElement ;
import org.eclipse.core.runtime.IExtension ;
import org.eclipse.core.runtime.IExtensionPoint ;
import org.eclipse.core.runtime.IExtensionRegistry ;
import org.eclipse.core.runtime.Platform ;
import org.osate.annexsupport.AnnexLinkingServiceProxy ;
import org.osate.annexsupport.AnnexPlugin ;
import org.osate.annexsupport.AnnexProxy ;
import org.osate.annexsupport.AnnexRegistry ;

public class StandAloneAnnexRegistry extends AnnexRegistry
{

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
