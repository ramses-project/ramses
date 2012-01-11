package fr.tpt.aadl.flow.extraction.util ;

import org.osate.aadl2.Element ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.ConnectionInstanceEnd ;
import org.osate.aadl2.instance.ConnectionKind ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.instance.SystemInstance ;

public class AADLUtil
{

  private AADLUtil()
  {
  }

  public static SystemInstance getSystem(ComponentInstance ci)
  {
    Element owner = ci.getOwner() ;

    while(!(owner instanceof SystemInstance))
    {
      owner = owner.getOwner() ;
    }

    return (SystemInstance) owner ;
  }

  /**
   * Returns global ID of given local (thread) resource name.
   * @param resourceID local resource id
   * @param thread thread accessing the resource.
   * @return global name of the resource.
   */
  public static String getResourceGlobalName(String resourceID,
                                             ComponentInstance thread)
  {
    SystemInstance s = getSystem(thread) ;

    for(ConnectionInstance co : s.getConnectionInstances())
    {
      if(co.getKind() == ConnectionKind.ACCESS_CONNECTION)
      {
        ConnectionInstanceEnd d = co.getDestination() ;

        if(d instanceof FeatureInstance)
        {
          if((d.getOwner() == thread) && (d.getName().equals(resourceID)))
          {
            return co.getSource().getName() ;
          }
        }
      }
    }

    return resourceID ;
  }
}
