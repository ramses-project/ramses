package fr.tpt.aadl.ramses.control.atl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class AtlLauncherActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Init ATL Launcher: start bundle");
		//AtlTransfoLauncher.initTransformation(env);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
