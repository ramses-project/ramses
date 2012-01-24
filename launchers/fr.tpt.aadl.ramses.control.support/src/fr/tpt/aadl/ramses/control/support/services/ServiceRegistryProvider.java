package fr.tpt.aadl.ramses.control.support.services ;

public class ServiceRegistryProvider
{
  private static ServiceRegistry _sr = new DefaultServiceRegistry() ;

  public static void setDefault(ServiceRegistry sr)
  {
    _sr = sr ;
  }

  public static ServiceRegistry getServiceRegistry()
  {
    return _sr ;
  }
}
