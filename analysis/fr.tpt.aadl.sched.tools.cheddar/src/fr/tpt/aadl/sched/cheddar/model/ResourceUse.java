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
 
 package fr.tpt.aadl.sched.cheddar.model ;

public class ResourceUse
{
  private CheddarTask user ;

  private float waitDate ;

  private float releaseDate ;

  private CheddarResource r ;

  ResourceUse(CheddarTask user, CheddarResource r, float wait, float release)
  {
    this.user = user ;
    this.waitDate = wait ;
    this.releaseDate = release ;
    this.r = r ;
    user.addUse(this) ;
  }

  public CheddarResource getResource()
  {
    return r ;
  }

  /**
   * @return the user
   */
  public CheddarTask getUser()
  {
    return user ;
  }

  /**
   * @return the waitDate
   */
  public float getWaitDate()
  {
    return waitDate ;
  }

  /**
   * @return the releaseDate
   */
  public float getReleaseDate()
  {
    return releaseDate ;
  }
}