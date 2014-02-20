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

package fr.tpt.aadl.ramses.control.osate;

import org.eclipse.jface.resource.ImageDescriptor ;
import org.eclipse.ui.plugin.AbstractUIPlugin ;
import org.osate.ui.dialogs.Dialog ;
import org.osgi.framework.BundleContext ;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.AadlModelsManagerImpl ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.reporters.Logger ;
import fr.tpt.aadl.ramses.control.support.services.OSGiServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "fr.tpt.aadl.ramses.control.osate"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		try
    {
		  Logger4Osate logger = new Logger4Osate() ;
		  /**** DEBUG ****/
		  logger.setLogLevel(Logger.ALL) ;
	    /***************/
	    
		  ServiceProvider.SYS_MSG_REP = new SysMsgReporter4Osate(logger) ; 
		  
		  /*** Always set Ramses resouce dirs before initialize Service Registry, instantiator and AADL models manager !!! ***/
		  WorkbenchUtils.setResourceDirectories() ;
    }
    catch(Exception e)
    {
      // DEBUG
      e.printStackTrace();
      
      Dialog.showError("Configuration Error",
                       "Not enable to fetch RAMSES directory: \n\n" +
                       e.getMessage());
    }
		
		ServiceRegistry sr = new OSGiServiceRegistry() ;
		AadlModelInstantiatior instantiator ;
		instantiator = new AadlModelsManagerImpl(ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER) ;
		
		PredefinedAadlModelManager modelManager ;
		modelManager = new ContributedAadlRegistration() ;
		
		sr.init(instantiator, modelManager);
		ServiceProvider.setDefault(sr) ;
		/**************************************************************************/
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
