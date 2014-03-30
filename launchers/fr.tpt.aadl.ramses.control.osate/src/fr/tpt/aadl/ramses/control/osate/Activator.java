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

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IStatus ;
import org.eclipse.core.runtime.Platform ;
import org.eclipse.core.runtime.Status ;
import org.eclipse.jface.resource.ImageDescriptor ;
import org.eclipse.ui.plugin.AbstractUIPlugin ;
import org.osgi.framework.BundleContext ;

import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelsManagerImpl ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
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
	// Print a session logging header.
    getLog().log(new Status(IStatus.OK, "Starting RAMSES plugin suite ...",
                            "RAMSES starting ...")); ;
    
    // Set the level to FATAL for the plugin activation. Later, RAMSES will
    // will set the level to the user configuration.
    String lvl = "FATAL" ;
    RamsesConfiguration.setupLogging(lvl, 
                                     Platform.getLogFileLocation().toFile(),
                                     false);
	  try
		{
		  super.start(context);
	    plugin = this;
	    
	    /****** Always set Ramses resouce dirs before initialize Service Registry,
	     *  instantiator and AADL models manager !!! ****************************/
	    
	    WorkbenchUtils.setResourceDirectories() ;
	    
	    MessageReporter4Osate msgReporter = new MessageReporter4Osate() ;
	    ServiceProvider.SYS_ERR_REP = new SysErrReporter4Osate(msgReporter) ;
	    
	    ServiceRegistry sr = new OSGiServiceRegistry() ;
	    AadlModelInstantiatior instantiator ;
	    instantiator = new AadlModelsManagerImpl(ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER) ;
	    
	    PredefinedAadlModelManager modelManager ;
	    modelManager = new ContributedAadlRegistration() ;
	    
	    sr.init(instantiator, modelManager);
	    ServiceProvider.setDefault(sr) ;
	    
		AtlTransfoLauncher.initTransformation();
	    
	    /**************************************************************************/
		}
		catch(Exception e) // Top level exception handler. Stop all process.
		{
		  Logger.getLogger(Activator.class).fatal("", e); 
		  ServiceProvider.SYS_ERR_REP.fatal("", e);
		}
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