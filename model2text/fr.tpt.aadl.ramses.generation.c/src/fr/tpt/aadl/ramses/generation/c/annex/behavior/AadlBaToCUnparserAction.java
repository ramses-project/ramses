/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.generation.c.annex.behavior ;


import org.osate.aadl2.AnnexSubclause ;

import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement ;
import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin ;

// ** AADL RESTRICTED BA HAS TO BE SET AS A STANDALONE ECLIPSE PLUGIN PROJECT ** 

public class AadlBaToCUnparserAction extends AadlBaUnParserAction
                                     implements NamedPlugin
{

  public static final String ANNEX_NAME = "restricted_behavior_specification" ;
  protected AadlBaToCUnparser _unparser = null ;
  
  public AadlBaToCUnparserAction()
  {
    _unparser = new AadlBaToCUnparser() ;
  }
  
  @Override
  public String unparseAnnexSubclause(AnnexSubclause subclause,
                                      String indent)
  {
    return _unparser.process((BehaviorElement) subclause) ;
  }

  public AadlBaToCUnparser getUnparser()
  {
    return _unparser ;
  }

  @Override
  public String getRegistryName()
  {
    return ANNEX_NAME ;
  }

  @Override
  public String getPluginName()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public String getPluginId()
  {
    // TODO Auto-generated method stub
    return null ;
  }
}
