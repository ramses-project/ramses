package fr.tpt.aadl.ramses.control.support;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;

/**
 * This interface specifies the methods to manage AADL systems instantiation
 */
public interface AadlModelsManager {

	/**
	 * This method search for a system implementation with name
	 * {@code systemToInstantiate} in a list of aadl models, instantiates
	 * it and returns the system instance.
	 * @param aadlModels list of aadl model containing the system 
	 * implementation to instantiate
	 * @param systemToInstantiate name of the system implementation
	 * to instantiate
	 * @return the system instance resulting from the instantiation,
	 * null if the system instantiation failed.
	 */
	SystemInstance instantiate(List<Resource> aadlModels,
			String systemToInstantiate);
	
	/**
	 * This method interfaces with OSATE to call its instantiation mechanism
	 * from a given aadl system implementation.
	 * @param si the system implementation to instantiate
	 * @return the syste instance resulting from instantiation, null
	 * if the instantiation failed.
	 */
	SystemInstance instantiate(SystemImplementation si);
	
	/**
	 * This method serializes an AADL resource into a target file.
	 * @param transfoResult the resource in which aadl model has
	 * been created.
	 * @param targetFileName the path of the aadl file in which
	 * aadl code will be added.
	 */
	void serialize(Resource transfoResult, String targetFileName);
}
