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
package fr.tpt.atl.hot.launcher;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import fr.tpt.atl.hot.launcher.AtlConverter;
import fr.tpt.atl.hot.launcher.AtlHotTransfoLauncher;

public class Atl2XLauncher extends AtlHotTransfoLauncher {
	
  public Atl2XLauncher(String transformation, ResourceSet rs)
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
  public void loadModels(String[] inModelPaths) throws ATLCoreException,
    IOException 
  {
	System.out.println("loadModels");
    AtlConverter.convertToModel(inModelPaths[0], resourceSet);
	ModelFactory factory = new EMFModelFactory();
	IInjector injector = new EMFInjector();
	String root = "platform:/plugin/" + "fr.tpt.atl.utils/";
	IReferenceModel mm_atlMetamodel = factory.newReferenceModel();
	injector.inject(mm_atlMetamodel, getMetamodelUri("MM_ATL"));
	
	this.inModel = factory.newModel(mm_atlMetamodel);

	boolean modelExists = false;
	String s = null;
	while (!modelExists) 
	  {
	    s = new Path(inModelPaths[0]).removeFileExtension()
	    		  .addFileExtension("trc").toString();
		if (new File(s).exists()) 
		{
		  modelExists = true;
		} 
		else 
		{
		  try 
		  {
		    Thread.sleep(200);
		  } 
		  catch (InterruptedException e) 
		  {
			e.printStackTrace();
		  }
	    }
	  }

	String fileURI = URI.createFileURI(inModelPaths[0]).toString();
	injector.inject(inModel, new Path(fileURI).removeFileExtension()
			  .addFileExtension("trc").toString());

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
  public Object doHot(IProgressMonitor monitor) throws ATLCoreException,
    IOException, ATLExecutionException 
  {
	ILauncher launcher = new EMFVMLauncher();
	Map<String, Object> launcherOptions = getOptions();
	launcher.initialize(launcherOptions);
	launcher.addInModel(inModel, "IN", "MM_ATL");
	launcher.addOutModel(outModel, "OUT", "MM_ATL");
	return launcher.launch("run", monitor, launcherOptions,
			  (Object[]) getModulesList());
  }
  
}
