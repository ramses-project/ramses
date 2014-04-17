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

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.List ;

import org.osate.aadl2.Element ;

public class CheddarResource extends CheddarElement
{
  private CheddarAddressSpace owner ;

  private String protocol = "" ;

  private List<ResourceUse> uses = new ArrayList<ResourceUse>() ;

  public CheddarResource(Element aadlElement)
  {
    super(aadlElement) ;
  }

  public void addUse(CheddarTask user,
                     float wait,
                     float release)
  {
    uses.add(new ResourceUse(user, this, wait, release)) ;
  }

  public Collection<ResourceUse> getUses()
  {
    return uses ;
  }

  /**
   * @return the address_space
   */
  public CheddarAddressSpace getOwner()
  {
    return owner ;
  }

  /**
   * @param address_space the address_space to set
   */
  public void setOwner(CheddarAddressSpace address_space)
  {
    this.owner = address_space ;
  }

  /**
   * @return the protocol
   */
  public String getProtocol()
  {
    return protocol ;
  }

  /**
   * @param protocol the protocol to set
   */
  public void setProtocol(String protocol)
  {
    this.protocol = protocol ;
  }
}