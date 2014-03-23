package fr.tpt.aadl.ramses.control.atl;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class AtlLauncherActivator implements BundleActivator {

	private static Logger _LOGGER = Logger.getLogger(AtlLauncherActivator.class) ;
	
	@Override
	public void start(BundleContext context) throws Exception {
		_LOGGER.trace("Init ATL Launcher: start bundle");
		AtlTransfoLauncher.initTransformation();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
