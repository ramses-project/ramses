/*
* generated by Xtext
*/
package fr.tpt.aadl.ramses.transformation.trc.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TRCStandaloneSetup extends TRCStandaloneSetupGenerated{

	public static void doSetup() {
		new TRCStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

