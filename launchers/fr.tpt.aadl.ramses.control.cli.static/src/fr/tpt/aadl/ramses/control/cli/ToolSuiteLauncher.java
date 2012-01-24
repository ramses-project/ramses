package fr.tpt.aadl.ramses.control.cli ;
import fr.tpt.aadl.ramses.control.cli.core.ToolSuiteLauncherCommand ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;

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
