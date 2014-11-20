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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.log4j.Logger ;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.emftvm.compiler.EmftvmCompilerPlugin;

/**
 * Entry point of the 'EModelCopy' transformation module.
 */
public abstract class AtlHotTransfoLauncher {
  
  private static Logger _LOGGER = Logger.getLogger(AtlHotTransfoLauncher.class) ;
  
	/**
	 * The property file. Stores module list, the metamodel and library
	 * locations.
	 * 
	 * @generated
	 */
	private Properties properties;

	/**
	 * The IN model.
	 * 
	 * @generated
	 */
	protected IModel inModel;

	/**
	 * The OUT model.
	 * 
	 * @generated
	 */
	protected IModel outModel;
	
	private String hotTransformationName;
	
	protected ResourceSet resourceSet;
	
	/**
	 * Constructor.
	 * 
	 * @generated
	 */
	public AtlHotTransfoLauncher(String transformation,
	                             ResourceSet rs) throws IOException {
	  this.hotTransformationName = transformation;
	  this.properties = new Properties();
	  try {
      properties.load(this.getFileURL(transformation+".properties").openStream());
    } catch (IOException e) {
    	e.printStackTrace();
    }

//		this.setHotTransformationName(getHotTransformationName());
//		properties.load(getFileURL(new Path(filePath).removeFileExtension().toString()+".properties").openStream());
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());
		
		resourceSet = rs;
	}
	


	public void launchHot(String[] inputAtlPaths, String outputAtlPath)
			throws IOException, ATLCoreException {
	  _LOGGER.trace("HOT load models");
		this.loadModels(inputAtlPaths); //-> produces model.atxl
		_LOGGER.trace("HOT launch");
		this.doHot(new NullProgressMonitor()); //-> transforms model.atxl to model_refined.atxl
		_LOGGER.trace("Save atl file");
		this.saveModels(outputAtlPath); // -> transforms model_refined.atxl to model_refined.atl
		// workaround bug in the atl pretty printer: replace 
		// to
		//  t : MM_ATL2PM!ElementTransformationTuple (
		//		   key <- Sequence {
		// by
		// to
		//  t : MM_ATL2PM!ElementTransformationTuple (
		//   key <:= Sequence {
		
/*		BufferedReader reader = new BufferedReader(new FileReader(outputAtlPath));
	    PrintWriter writerTMP = new PrintWriter(new FileWriter(outputAtlPath+"_tmp"));
	    String line = null;
	    while ((line = reader.readLine()) != null)
	    	writerTMP.println(line.replaceAll("key <- Sequence ","key <:= Sequence "));

	    // Be aware of the potential for resource leaks here. Proper resource
	    // handling has been omitted in the interest of brevity
	    reader.close();
	    writerTMP.close();
	    
	    BufferedReader readerTMP = new BufferedReader(new FileReader(outputAtlPath+"_tmp"));
	    PrintWriter writer = new PrintWriter(new FileWriter(outputAtlPath));
	    line = null;
	    while ((line = readerTMP.readLine()) != null)
	        writer.println(line);
		
	    readerTMP.close();
	    writer.close();*/
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
	public abstract void loadModels(String[] inModelPaths) throws ATLCoreException,
			IOException;
	
	/**
	 * Save the output and input/output models.
	 * 
	 * @param outModelPath
	 *            the OUT model path
	 * @throws ATLCoreException
	 *             if a problem occurs while saving models
	 * 
	 * @generated
	 */
	public void saveModels(String outFilePath) throws ATLCoreException {

		// atxl file
		String outModelPath = outFilePath.substring(0, outFilePath.length()-4).concat(".atxl");
		outModelPath = URI.createFileURI(outModelPath).toString();
		IExtractor extractor = new EMFExtractor();
		extractor.extract(outModel, outModelPath);

		AtlConverter.convertToCode(outModelPath, resourceSet);
	}


	public abstract Object doHot(IProgressMonitor monitor) throws ATLCoreException,
			IOException, ATLExecutionException;

	/**
	 * Returns an Array of the module input streams, parameterized by the
	 * property file.
	 * 
	 * @return an Array of the module input streams
	 * @throws IOException
	 *             if a module cannot be read
	 * 
	 * @generated
	 */
	protected InputStream[] getModulesList() throws IOException {
		InputStream[] modules = null;
		String modulesList = properties
				.getProperty(getHotTransformationName()+".modules");
		if (modulesList != null) {
			String[] moduleNames = modulesList.split(",");
			modules = new InputStream[moduleNames.length];
			for (int i = 0; i < moduleNames.length; i++) {
				String asmModulePath = new Path(moduleNames[i].trim())
						.removeFileExtension().addFileExtension("asm")
						.toString();
				modules[i] = getFileURL(asmModulePath).openStream();
			}
		}
		return modules;
	}

	/**
	 * Returns the URI of the given metamodel, parameterized from the property
	 * file.
	 * 
	 * @param metamodelName
	 *            the metamodel name
	 * @return the metamodel URI
	 * 
	 * @generated
	 */
	protected String getMetamodelUri(String metamodelName) {
		String root = "platform:/plugin/" + "fr.tpt.atl.utils/";		
		return root+properties.getProperty(getHotTransformationName()+".metamodels."
				+ metamodelName);
	}


	/**
	 * Returns the file name of the given library, parameterized from the
	 * property file.
	 * 
	 * @param libraryName
	 *            the library name
	 * @return the library file name
	 * 
	 * @generated
	 */
	protected InputStream getLibraryAsStream(String libraryName)
			throws IOException {
		return getFileURL(
				properties.getProperty(getHotTransformationName()+".libraries."
						+ libraryName)).openStream();
	}

	/**
	 * Returns the options map, parameterized from the property file.
	 * 
	 * @return the options map
	 * 
	 * @generated
	 */
	protected Map<String, Object> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		for (Entry<Object, Object> entry : properties.entrySet()) {
			if (entry.getKey().toString()
					.startsWith(getHotTransformationName()+".options.")) {
				options.put(
						entry.getKey()
								.toString()
								.replaceFirst(getHotTransformationName()+".options.",
										""), entry.getValue().toString());
			}
		}
		return options;
	}

	/**
	 * Finds the file in the plug-in. Returns the file URL.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the file URL
	 * @throws IOException
	 *             if the file doesn't exist
	 * 
	 * @generated
	 */
	protected URL getFileURL(String fileName) throws IOException {
		final URL fileURL;
		fileURL = AtlHotTransfoLauncher.class.getResource(fileName);

		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}


	protected String getHotTransformationName() {
		return hotTransformationName;
	}
	
}
