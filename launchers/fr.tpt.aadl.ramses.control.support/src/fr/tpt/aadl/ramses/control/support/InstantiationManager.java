package fr.tpt.aadl.ramses.control.support;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;

public interface InstantiationManager {

	SystemInstance instantiate(SystemImplementation si);
	
	void serialize(Resource transfoResult, String targetFileName);
}
