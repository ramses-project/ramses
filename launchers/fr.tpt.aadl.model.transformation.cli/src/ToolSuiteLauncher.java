import fr.tpt.aadl.model.transformation.cli.StaticServiceRegistry ;
import fr.tpt.aadl.toolsuite.cli.ToolSuiteLauncherCommand ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistryProvider ;

public class ToolSuiteLauncher
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    try
    {
      ServiceRegistryProvider.setDefault(new StaticServiceRegistry()) ;
      ToolSuiteLauncherCommand.main(args) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
    }
  }
}
