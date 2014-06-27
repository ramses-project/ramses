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

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
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

import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.atl.hot.launcher.Atl2XLauncher;
import fr.tpt.atl.hot.launcher.AtlConverter;

public class Atl2TrcLauncher extends Atl2XLauncher {

private static final String TRC_MM_URI =
  fr.tpt.aadl.ramses.transformation.trc.TrcPackage.eNS_URI;
	
  public Atl2TrcLauncher(String transformation, ResourceSet rs)
    throws IOException
  {
    super(transformation, rs) ;
    EPackage.Registry.INSTANCE.put(TRC_MM_URI, TrcPackage.eINSTANCE) ;
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

  
  @Override
  public void loadModels(String[] inModelPaths) throws ATLCoreException,
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

    inModel = factory.newModel(mm_atlMetamodel);

	String fileURI = URI.createFileURI(inModelPaths[0]).toString();
	injector.inject(inModel, new Path(fileURI).removeFileExtension()
			.addFileExtension("atxl").toString());
	// atxl file
	
	outModel = factory.newModel(mm_trcMetamodel);
}


	/**
	 * Transform the models.
	 * 
	 * @param monitor
	 *            the progress monitor
	 * @return 
	 * @throws ATLCoreException
	 *             if an error occurs during models handling
	 * @throws IOException
	 *             if a module cannot be read
	 * @throws ATLExecutionException
	 *             if an error occurs during the execution
	 * 
	 * @generated
	 */
  @Override
 public Object doHot(IProgressMonitor monitor) throws ATLCoreException,
    IOException, ATLExecutionException 
  {
    ILauncher launcher = new EMFVMLauncher();
	Map<String, Object> launcherOptions = getOptions();
	launcher.initialize(launcherOptions);
	launcher.addInModel(inModel, "IN", "MM_ATL");
	launcher.addOutModel(outModel, "OUT", "MM_TRC");
	return launcher.launch("run", monitor, launcherOptions,
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
  
  @Override
  public void saveModels(String outFilePath) throws ATLCoreException {

		// atxl file
		IExtractor extractor = new EMFExtractor();
		extractor.extract(outModel, outFilePath);
	}
}
