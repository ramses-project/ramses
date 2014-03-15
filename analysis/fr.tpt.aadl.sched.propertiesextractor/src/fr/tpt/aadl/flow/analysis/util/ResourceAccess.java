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

package fr.tpt.aadl.flow.analysis.util ;

public class ResourceAccess
{

  private float start = 0 ;
  private float end = 0 ;

  private String resourceID ;

  /**
   * @return the start
   */
  public float getStart()
  {
    return start ;
  }

  /**
   * @param start the start to set
   */
  void setStart(float start)
  {
    this.start = start ;
  }

  /**
   * @return the end
   */
  public float getEnd()
  {
    return end ;
  }

  /**
   * @param end the end to set
   */
  void setEnd(float end)
  {
    this.end = end ;
  }

  /**
   * @return the resourceID
   */
  public String getResourceID()
  {
    return resourceID ;
  }

  /**
   * @param resourceID the resourceID to set
   */
  void setResourceID(String resourceID)
  {
    this.resourceID = resourceID ;
  }
}