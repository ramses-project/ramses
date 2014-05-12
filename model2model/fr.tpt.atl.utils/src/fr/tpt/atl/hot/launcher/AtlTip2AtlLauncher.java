package fr.tpt.atl.hot.launcher;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.util.InstanceResourceFactoryImpl;
import org.osate.ba.aadlba.AadlBaPackage;

import fr.tpt.aadl.ramses.transformation.tip.TipPackage;


public class AtlTip2AtlLauncher extends AtlHotTransfoLauncher
{

	/**
	 * The IN2 model.
	 * @generated
	 */
	protected IModel in2Model;	
	private IModel in3Model;
	
	private static final String AADLI_MM_URI =
			org.osate.aadl2.instance.InstancePackage.eNS_URI ;
	private static final String AADLBA_MM_URI =
			org.osate.ba.aadlba.AadlBaPackage.eNS_URI ;
	private static final String AADL2_MM_URI =
			org.osate.aadl2.Aadl2Package.eNS_URI ;
	private static final String TIP_MM_URI =
			fr.tpt.aadl.ramses.transformation.tip.TipPackage.eNS_URI;
	
	
	public AtlTip2AtlLauncher(String hotTransformationName, 
	                          ResourceSet rs) throws IOException {
		super(hotTransformationName, rs);

		EPackage.Registry.INSTANCE.put(AADL2_MM_URI,
				org.osate.aadl2.Aadl2Package.eINSTANCE) ;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"tip", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"atxl", new XMIResourceFactoryImpl());
		
		EPackage.Registry.INSTANCE.put(AADLI_MM_URI, InstancePackage.eINSTANCE) ;
		EPackage.Registry.INSTANCE.put(AADLBA_MM_URI, AadlBaPackage.eINSTANCE) ;
		EPackage.Registry.INSTANCE.put(TIP_MM_URI, TipPackage.eINSTANCE) ;
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("aaxl2", new InstanceResourceFactoryImpl()) ;
		
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
			IOException {

		AtlConverter.convertToModel(inModelPaths[0], resourceSet);

		ModelFactory factory = new EMFModelFactory();
		
		EMFInjector injector = new EMFInjector();

		IReferenceModel mm_atlMetamodel = factory.newReferenceModel();
		injector.inject(mm_atlMetamodel, getMetamodelUri("MM_ATL"));
		
		IReferenceModel mm_tipMetamodel = factory.newReferenceModel();
		injector.inject(mm_tipMetamodel, getMetamodelUri("MM_TIP"));

		IReferenceModel mm_AADLIMetamodel = factory.newReferenceModel();
		injector.inject(mm_AADLIMetamodel, getMetamodelUri("AADLI"));
		
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

		/*String fileName = URI.createFileURI(inModelPaths[0]).toString();
		Path filePath = (Path) new Path(fileName).removeFileExtension()
		.addFileExtension("atxl").removeFirstSegments(1);
		URI atxlURI = URI.createFileURI("/"+filePath.toString());
		Resource atlResource = resourceSet.getResource(atxlURI, false);
		if(atlResource==null)
			atlResource=resourceSet.createResource(atxlURI);
		injector.inject(inModel, atlResource);*/
		
		String fileURI = URI.createFileURI(inModelPaths[0]).toString();
		injector.inject(inModel, new Path(fileURI).removeFileExtension()
				.addFileExtension("atxl").toString());

		/*URI tipURI = URI.createFileURI(inModelPaths[1]);
		Resource tipResource = resourceSet.getResource(tipURI, false);
		this.in2Model = factory.newModel(mm_tipMetamodel);
		injector.inject(in2Model, tipResource);*/
		this.in2Model = factory.newModel(mm_tipMetamodel);
		fileURI = URI.createFileURI(inModelPaths[1]).toString();
		injector.inject(in2Model, fileURI);

		/*URI instanceModelURI = URI.createFileURI(inModelPaths[2]);
		Resource instanceResource = resourceSet.getResource(instanceModelURI, false);
		if(instanceResource==null)
			instanceResource = resourceSet.createResource(instanceModelURI);
		in3Model = factory.newModel(mm_AADLIMetamodel);
		injector.inject(in3Model, instanceResource);*/
		
		this.in3Model = factory.newModel(mm_AADLIMetamodel);
		fileURI = URI.createFileURI(inModelPaths[2]).toString();
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFInjector.OPTION_LOAD_ON_DEMAND, false);
		injector.inject(in3Model, fileURI, options);

		
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
			IOException, ATLExecutionException {
		EMFVMLauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = getOptions();
		launcherOptions.put("allowInterModelReferences", Boolean.TRUE);
		launcher.initialize(launcherOptions);
		launcher.addInModel(inModel, "IN", "MM_ATL");
		launcher.addInModel(in2Model, "IN2", "MM_TIP");
		launcher.addInModel(in3Model, "INSTANCE_MODEL", "AADLI");
		launcher.addOutModel(outModel, "OUT", "MM_ATL");
		return launcher.launch("run", monitor, launcherOptions,
				(Object[]) getModulesList());
	}


}
