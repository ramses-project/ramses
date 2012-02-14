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

/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.tpt.aadl.ramses.generation.pok.makefile ;

import org.eclipse.core.runtime.Plugin ;
import org.osgi.framework.BundleContext ;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends Plugin
{

  /**
   * The plug-in ID.
   */
  public static final String PLUGIN_ID =
        "fr.tpt.aadl.code.generation.makefile.pok" ;

  /**
   * The shared instance.
   */
  private static Activator plugin ;

  /**
   * The constructor.
   */
  public Activator()
  {
  }

  /**
   * {@inheritDoc}
   *
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  public void start(BundleContext context)
        throws Exception
  {
    super.start(context) ;
    plugin = this ;
  }

  /**
   * {@inheritDoc}
   *
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  public void stop(BundleContext context)
        throws Exception
  {
    plugin = null ;
    super.stop(context) ;
  }

  /**
   * Returns the shared instance.
   *
   * @return the shared instance
   */
  public static Activator getDefault()
  {
    return plugin ;
  }

}
