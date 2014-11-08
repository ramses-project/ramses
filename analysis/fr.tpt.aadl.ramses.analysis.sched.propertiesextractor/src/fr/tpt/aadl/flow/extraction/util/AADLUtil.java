/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

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