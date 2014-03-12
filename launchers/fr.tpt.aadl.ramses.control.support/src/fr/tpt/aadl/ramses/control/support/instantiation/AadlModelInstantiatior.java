package fr.tpt.aadl.ramses.control.support.instantiation;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;

/**
 * This interface specifies the methods to manage AADL systems instantiation
 */
public interface AadlModelInstantiatior {

	/**
	 * Search the system implementation by the given name in the given AADL
	 * resources. Then instantiate the system implementation found and return the
	 * instance. 
	 * 
	 * @param aadlModels list of AADL model resources containing the system 
	 * implementation to instantiate
	 * @param systemToInstantiate name of the system implementation
	 * to instantiate
	 * @return the system instance resulting from the instantiation,
	 * null if the system instantiation failed.
	 */
	SystemInstance instantiate(List<Resource> aadlModels,
			                       String systemToInstantiate);
	
	/**
	 * Instantiate the given system implementation node.
	 * @param si the system implementation to instantiate
	 * @return the system instance resulting from instantiation, null
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
	
	public void setProgressMonitor(IProgressMonitor monitor) ;
}
