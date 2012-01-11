package fr.tpt.aadl.model.transformation.osgi ;

import java.util.Map ;

import org.eclipse.equinox.app.IApplication ;
import org.eclipse.equinox.app.IApplicationContext ;

import fr.tpt.aadl.toolsuite.cli.ToolSuiteLauncherCommand ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistryProvider ;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication
{
  /* (non-Javadoc)
   * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
   */
  public Object start(IApplicationContext context)
        throws Exception
  {
    ServiceRegistryProvider.setDefault(new OSGiServiceRegistry()) ;
    @SuppressWarnings("unchecked")
    Map<String, String[]> argsMap = context.getArguments() ;
    String[] args = argsMap.get("application.args") ;
    ToolSuiteLauncherCommand.main(args) ;
    return IApplication.EXIT_OK ;
  }

  /* (non-Javadoc)
   * @see org.eclipse.equinox.app.IApplication#stop()
   */
  public void stop()
  {
    // nothing to do
  }
}
