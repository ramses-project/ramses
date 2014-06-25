/*******************************************************************************
 * Copyright (c) 2010, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.tpt.atl.to.trc.launcher;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import fr.tpt.atl.hot.launcher.Atl2XLauncher;
import fr.tpt.atl.hot.launcher.AtlConverter;

public class Atl2TrcLauncher extends Atl2XLauncher {
	
  public Atl2TrcLauncher(String transformation, ResourceSet rs)
    throws IOException
  {
    super(transformation, rs) ;
  }
  
  
  
  /**
	 * Load the input and input/output models, initialize output models.
	 * 
	 * @param inModelPath
	 *            the IN model path
	 * @throws ATLCoreException
	 *             if a problem occurs while loading models
	 * @throws IOException
	 * @generated
	 */

  public void loadModels(String[] inModelPaths, int tableSize) throws ATLCoreException,
  IOException 
  {
//	for(int i=0; i<tableSize; i++)
//	{
	  AtlConverter.convertToModel(inModelPaths[0], resourceSet);
//	}
//	String rootAtl = "platform:/plugin/" + "fr.tpt.atl.utils/";

	ModelFactory factory = new EMFModelFactory();
    IInjector injector = new EMFInjector();

//    String[] fileURI = new String[tableSize];

    IReferenceModel mm_atlMetamodel = factory.newReferenceModel();
    injector.inject(mm_atlMetamodel, getMetamodelUri("MM_ATL"));

    IReferenceModel mm_trcMetamodel = factory.newReferenceModel();
    injector.inject(mm_trcMetamodel, getMetamodelUri("MM_TRC"));

    this.inModel = factory.newModel(mm_atlMetamodel);

	boolean modelExists = false;
	String s = null;
	while (!modelExists) {
		s = new Path(inModelPaths[0]).removeFileExtension()
				.addFileExtension("atxl").toString();
		if (new File(s).exists()) {
			modelExists = true;
		} else {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
    
//    String[] s = new String[tableSize];
////   	  for(int i=0; i<tableSize; i++)
////   	  {
//   		s[0] = new Path(inModelPaths[0]).removeFileExtension().
//   				  addFileExtension("atxl").toString();
//
//   		fileURI[0] = URI.createFileURI(inModelPaths[0]).toString();
//   	    injector.inject(inModel, new Path(fileURI[0]).removeFileExtension()
//   	    		.addFileExtension("atxl").toString());
////    }

	String fileURI = URI.createFileURI(inModelPaths[0]).toString();
	injector.inject(inModel, new Path(fileURI).removeFileExtension()
			.addFileExtension("atxl").toString());

	/*URI tipURI = URI.createFileURI(inModelPaths[1]);
	Resource tipResource = resourceSet.getResource(tipURI, false);
	this.in2Model = factory.newModel(mm_tipMetamodel);
	injector.inject(in2Model, tipResource);*/

	/*URI instanceModelURI = URI.createFileURI(inModelPaths[2]);
	Resource instanceResource = resourceSet.getResource(instanceModelURI, false);
	if(instanceResource==null)
		instanceResource = resourceSet.createResource(instanceModelURI);
	in3Model = factory.newModel(mm_AADLIMetamodel);
	injector.inject(in3Model, instanceResource);*/
	
	this.outModel = factory.newModel(mm_atlMetamodel);
}


	/**
	 * Transform the models.
	 * 
	 * @param monitor
	 *            the progress monitor
	 * @throws ATLCoreException
	 *             if an error occurs during models handling
	 * @throws IOException
	 *             if a module cannot be read
	 * @throws ATLExecutionException
	 *             if an error occurs during the execution
	 * 
	 * @generated
	 */
  public Resource doHot(IProgressMonitor monitor) throws ATLCoreException,
    IOException, ATLExecutionException 
  {
    ILauncher launcher = new EMFVMLauncher();
	Map<String, Object> launcherOptions = getOptions();
	launcher.initialize(launcherOptions);
	launcher.addInModel(inModel, "IN", "MM_ATL");
	launcher.addOutModel(outModel, "OUT", "MM_TRC");
	return (Resource) launcher.launch("run", monitor, launcherOptions,
			  (Object[]) getModulesList());
  }
  
  @Override
  protected URL getFileURL(String fileName) throws IOException {
		final URL fileURL;
		fileURL = Atl2TrcLauncher.class.getResource(fileName);

		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}
  
  
  public Resource launchHot(String[] atlInputs) throws ATLCoreException, IOException {
	this.loadModels(atlInputs,atlInputs.length);
	return this.doHot(new NullProgressMonitor());
  }
  
}
