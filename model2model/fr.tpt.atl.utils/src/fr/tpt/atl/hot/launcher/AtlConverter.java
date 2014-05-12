package fr.tpt.atl.hot.launcher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.internal.RegEx.ParseException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.parser.AtlParser;


public class AtlConverter {

	static String atlFileName;
	
/*	public static IModel convertToModel2(String file) throws ATLCoreException,
	ParseException {
		final IModel model;

		model = AtlParser.getDefault().parseToModel(new ByteArrayInputStream(getByteArrayFromFile(file)));

		return model;
	}
*/
	
	public static EObject convertToModel(String file,
	                                     ResourceSet resourceSet) throws ATLCoreException,
			ParseException {
		final EObject[] models;
		try {

			models = AtlParser.getDefault().parseWithProblems(
					new ByteArrayInputStream(getByteArrayFromFile(file)));

			final String modelURI = new Path(file).removeFileExtension().addFileExtension("atxl").toString();
			
			//System.out.println("modelURI: "+modelURI);
			final URI uri = URI.createFileURI(modelURI);

			saveResource(uri, resourceSet, models[0]);

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("ATL file conversion failed with message: "
					+ e.getMessage());
			return null;
		}
		return models[0];
	}
	
	//gets atxl file path
	public static boolean convertToCode(String file,
	                                    ResourceSet resourceSet) {
		
		final URI uriOut = URI.createURI(file, false);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("atxl", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		final EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();

		final URI atmMmURI = URI.createPlatformPluginURI("fr.tpt.atl.utils/metamodels/ATL.ecore", false); 
		Resource resourcePackage = resourceSet.getResource( atmMmURI, true); 
		
		for ( final EObject ePackage : resourcePackage.getContents() ) {
			packageRegistry.put( ( (EPackage) ePackage ).getNsURI(), ePackage );
		}
		
		Resource emfRes = resourceSet.getResource( uriOut, true );
		
		try {
//			final byte[] code = ATLUtil.convertToCode( emfRes.getContents().get( 0 ) );
			final EMFModelFactory modelFactory = new EMFModelFactory();
			final IReferenceModel atlRefModel = modelFactory.newReferenceModel();
			final EMFInjector injector = new EMFInjector();
			EObject root = emfRes.getContents().get( 0 );
			
			injector.inject( atlRefModel, root.eResource().getResourceSet().getPackageRegistry().getEPackage( "http://www.eclipse.org/gmt/2005/ATL" ).eResource() );
			final IModel model = modelFactory.newModel( atlRefModel );
			injector.inject( model, root.eResource() );
			final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			AtlParser.getDefault().extract( model, outStream, null );
			
			final byte[] code = outStream.toByteArray();
		
			final InputStream sourceStream = new ByteArrayInputStream( code );
			final String codeFileName = URI.createFileURI(new Path(file).removeFileExtension().addFileExtension("atl").toString()).toFileString();
			saveFile( sourceStream, codeFileName);

		}
		catch ( ATLCoreException | CoreException e ) {
			e.printStackTrace();
		}

		return true;
	}
	
	

	// ------------------------------------------------
	// ------------------- private methods -----------
	// ------------------------------------------------

	private static byte[] getByteArrayFromFile(String path) {
		File file = new File(path);
		try {
			FileInputStream fin = new FileInputStream(file);
			byte fileContent[] = new byte[(int) file.length()];
			fin.read(fileContent);
			fin.close();
			return fileContent;
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the file " + ioe);
		}
		return null;
	}

	private static void saveFile(final InputStream p_inputStream,
			final String path) throws CoreException {
		String filePath = path;
		if(filePath.startsWith("file:"))
			filePath = filePath.substring(5);
		final File file = new File(filePath);// ResourcesPlugin.getWorkspace().getRoot().getFile(p_path);

		OutputStream out;
		try {
			out = new FileOutputStream(file);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = p_inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			p_inputStream.close();
			out.flush();
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Resource saveResource(final URI p_uri,
	                                     ResourceSet resourceSet,
	                                     final EObject p_modelObject) 
	                                         throws IOException {
		Resource resource;

		//System.out.println("Resource saving: "+p_uri);
		resource = resourceSet.getResource(p_uri, false);
		if(resource == null)
			resource = resourceSet.createResource(p_uri);

		resource.getContents().addAll(p_modelObject.eResource().getContents());
		resource.save(null);
		return resource;
	}

}
