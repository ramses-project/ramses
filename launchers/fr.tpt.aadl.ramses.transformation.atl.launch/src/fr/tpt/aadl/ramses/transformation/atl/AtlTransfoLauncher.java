/*
 * author: Etienne Borde
 *
 */

package fr.tpt.aadl.ramses.transformation.atl ;

import java.io.File ;
import java.io.FileNotFoundException ;
import java.io.IOException ;
import java.net.URL ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.EPackage ;
import org.eclipse.emf.ecore.EcorePackage ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl ;
import org.eclipse.m2m.atl.core.ATLCoreException ;
import org.eclipse.m2m.atl.core.emf.EMFExtractor ;
import org.eclipse.m2m.atl.core.emf.EMFInjector ;
import org.eclipse.m2m.atl.core.emf.EMFModel ;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory ;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel ;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.instance.InstancePackage ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl ;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage ;

import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPackagesManager ;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksFactory ;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage ;
import fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess ;

public class AtlTransfoLauncher
{

  private static File transformationDir = null ;

  private static AtlTransfoLauncher launched = null ;

  private static final EMFInjector injector = new EMFInjector() ;
  private static final EMFExtractor extractor = new EMFExtractor() ;

  // Load the input file resource
  private static final EMFModelFactory factory = new EMFModelFactory() ;
  private static EMFReferenceModel aadlMetamodel ;
  private static EMFReferenceModel aadlbaMetamodel ;
  private static EMFReferenceModel aadliMetamodel ;
  private static EMFReferenceModel atlRefiningTraceMetamodel ;
  private static EMFReferenceModel ATLHookMetamodel ;

  private List<File> transformationFilepath ;

  private static final String AADLBA_MM_URI =
        fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage.eNS_URI ;
  private static final String AADL2_MM_URI =
        org.osate.aadl2.Aadl2Package.eNS_URI ;
  private static final String AADLI_MM_URI =
        org.osate.aadl2.instance.InstancePackage.eNS_URI ;
  private static final String ATLHOOKS_MM_URI = AtlHooksPackage.eNS_URI ;

  /*
   * The parameters of the transformation: asm file, input and a-output path.
   */
  private static String dataTargetfilepath ;
  private static PredefinedPackagesManager predefinedPackagesManager ;

  public AtlTransfoLauncher()
        throws Exception
  {
    launched = this ;
  }

  public static AtlTransfoLauncher getInstance()
  {
    return launched ;
  }

  public static File getTransformationDirName()
  {
    return AtlTransfoLauncher.transformationDir ;
  }

  private void initTransformation(File transformationDir)
        throws ATLCoreException
  {
    EPackage.Registry.INSTANCE.put(AADL2_MM_URI,
                                   org.osate.aadl2.Aadl2Package.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put(ATLHOOKS_MM_URI, AtlHooksPackage.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put(AADLBA_MM_URI, AadlBaPackage.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put(AADLI_MM_URI, InstancePackage.eINSTANCE) ;
    EPackage.Registry.INSTANCE.put("http://www.eclipse.org/emf/2002/Ecore",
                                   EcorePackage.eINSTANCE) ;
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
          .put("aaxl2", new Aadl2ResourceFactoryImpl()) ;
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
          .put("ecore", new EcoreResourceFactoryImpl()) ;
    // Initialize the aadl metamodel
    aadlMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(aadlMetamodel, AADL2_MM_URI) ;
    aadlbaMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(aadlbaMetamodel, AADLBA_MM_URI) ;
    aadliMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(aadliMetamodel, AADLI_MM_URI) ;
    atlRefiningTraceMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(atlRefiningTraceMetamodel, "file:" +
                          transformationDir.getAbsolutePath() +
                          "/atl_metamodels/RefiningTrace.ecore") ;
    ATLHookMetamodel = (EMFReferenceModel) factory.newReferenceModel() ;
    injector.inject(ATLHookMetamodel, ATLHOOKS_MM_URI) ;
  }

  public Resource doGeneration(Resource inputResource,
                               Map<String, Resource> propertySets,
                               List<File> transformationFileName,
                               String dataTargetfilepath)
        throws FileNotFoundException, IOException, ATLCoreException, Exception
  {
    if(AtlTransfoLauncher.transformationDir == null)
      throw new Exception(
            "Illegal initialization of ATL transformation launcher: "
                  + "directory containing .asm files is undefined") ;

    this.transformationFilepath = transformationFileName ;

    if(dataTargetfilepath != "")
    {
      AtlTransfoLauncher.dataTargetfilepath = dataTargetfilepath ;
    }

    return doTransformation(inputResource, propertySets) ;
  }
  
  private Resource doTransformation(Resource inputResource,
                                   Map<String, Resource> propertySets)
        throws FileNotFoundException, IOException, ATLCoreException
  {
    boolean workingWithInstances =
          (inputResource.getContents().get(0) instanceof SystemInstance) ;
    List<Object> atlModules = new ArrayList<Object>() ;
    // Initialize the ATL launcher
    EMFVMLauncher launcher = new EMFVMLauncher() ;
    launcher.initialize(Collections.<String, Object> emptyMap()) ;
    // Create the ATL-EMF source and target models
    EMFModel sourceModel ;

    if(workingWithInstances)
    {
      sourceModel = (EMFModel) factory.newModel(aadliMetamodel) ;
    }
    else
    {
      sourceModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
    }

    injector.inject(sourceModel, inputResource) ;
    EMFModel targetModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
    ResourceSet rs =
          StandAloneInstantiator.getInstantiator().getAadlResourceSet() ;
    Resource outputResource =
          rs.createResource(URI.createFileURI(dataTargetfilepath
                .replaceAll(".aaxl2", ".aadl2"))) ;
    injector.inject(targetModel, outputResource) ;
    // create ATLHook
    EMFModel atlHookModel = (EMFModel) factory.newModel(ATLHookMetamodel) ;
    URI fileURI =
          URI.createURI(AtlTransfoLauncher.transformationDir.getAbsolutePath() +
                "/ATLHook.atlhooks") ;
    ResourceSet set = new ResourceSetImpl() ;
    Resource hookResource = set.createResource(fileURI) ;
    HookAccess atlHook = AtlHooksFactory.eINSTANCE.createHookAccess() ;
    atlHook.setPredefinedPackagesManager(predefinedPackagesManager) ;
    hookResource.getContents().add(atlHook) ;
    hookResource.load(null) ;
    //Resource hookResource = atlHook.eResource();
    injector.inject(atlHookModel, hookResource) ;
    EMFModel refiningTraceModel =
          (EMFModel) factory.newModel(atlRefiningTraceMetamodel) ;

    // Launch the ATL transformation
    if(workingWithInstances)
    {
      launcher.addInModel(sourceModel, "IN", "AADLI") ;
    }
    else
    {
      launcher.addInModel(sourceModel, "IN", "AADLBA") ;
    }

    launcher.addInModel(atlHookModel, "HOOKS", "ATLHOOKS") ;
    //launcher.addInModel(runtimeModel, "AADL_RUNTIME", "AADLBA");
    //launcher.addInModel(baseTypesModel, "BASE_TYPES", "AADLBA");
    registerPredefinedPackagesInLauncher(launcher) ;
    launcher.addOutModel(targetModel, "OUT", "AADLBA") ;
    launcher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace") ;
    this.addStandardPropertySetInputs(propertySets, launcher) ;

    if(workingWithInstances)
    {
      URL asmMainFile =
            new URL("file:" + transformationDir.getAbsolutePath() +
                  "/Uninstanciate.asm") ;
      Object loadedMainModule = launcher.loadModule(asmMainFile.openStream()) ;
      atlModules.add(loadedMainModule) ;

      for(File f : transformationFilepath)
      {
        URL asmSuperImposeFile = new URL("file:" + f.toString()) ;
        Object loadedSuperImposeModule =
              launcher.loadModule(asmSuperImposeFile.openStream()) ;
        atlModules.add(loadedSuperImposeModule) ;
      }
    }
    else
    {
      URL asmSuperImposeFile =
            new URL("file:" + transformationFilepath.get(0).toString()) ;
      Object loadedSuperImposeModule =
            launcher.loadModule(asmSuperImposeFile.openStream()) ;
      atlModules.add(loadedSuperImposeModule) ;
    }

    Map<String, Object> options = new HashMap<String, Object>() ;
    options.put("allowInterModelReferences", "true") ;
    URL libraryFile ;
    List<String> fileName = new ArrayList<String>() ;
    fileName.add("/helpers/AADLCopyHelpers") ;
    fileName.add("/helpers/AADLICopyHelpers") ;
    fileName.add("/tools/PropertiesTools") ;
    fileName.add("/tools/FeaturesTools") ;
    fileName.add("/tools/BehaviorAnnexTools") ;
    fileName.add("/uninstanciate/Features") ;
    fileName.add("/uninstanciate/Implementations") ;
    //fileName.add("/uninstanciate/Misc");
    fileName.add("/uninstanciate/Properties") ;
    fileName.add("/uninstanciate/Types") ;
    fileName.add("/helpers/Services") ;

    for(String s : fileName)
    {
      libraryFile =
            new URL("file:" + transformationDir.getAbsolutePath() + s + ".asm") ;
      Object loadedLibrary = launcher.loadModule(libraryFile.openStream()) ;
      launcher.addLibrary(s, loadedLibrary) ;
    }

    launcher.launch(EMFVMLauncher.RUN_MODE, new NullProgressMonitor(), options,
                    atlModules.toArray()) ;

    // Save the resulting model
    if(targetModel.getResource() == null ||
          targetModel.getResource().getContents().isEmpty())
    {
      extractor.extract(sourceModel, dataTargetfilepath) ;
      return sourceModel.getResource() ;
    }
    else
    {
      extractor.extract(targetModel, dataTargetfilepath) ;
      return targetModel.getResource() ;
    }
  }

  private void addStandardPropertySetInputs(Map<String, Resource> propertySets,
                                            EMFVMLauncher launcher)
  {
    for(String s : propertySets.keySet())
    {
      EMFModel propertySetModel ;
      propertySetModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
      injector.inject(propertySetModel, propertySets.get(s)) ;

      if(propertySetModel != null)
      {
        launcher.addInModel(propertySetModel, s.toUpperCase(), "AADLBA") ;
      }
    }
  }

  public DataSubcomponentType getRuntimeData(String dataName)
  {
    DataSubcomponentType result = null ;
    Resource aadlRuntime = predefinedPackagesManager.getRuntimeResource() ;

    for(EObject c : aadlRuntime.getContents())
    {
      if(c instanceof DataSubcomponentType)
      {
        result = (DataSubcomponentType) c ;

        if(result.getName() == dataName)
        {
          return result ;
        }
      }
    }

    return null ;
  }

  public void registerPredefinedPackagesInLauncher(EMFVMLauncher launcher)
  {
    for(int p = 0 ; p < predefinedPackagesManager.getPackagesCount() ; p++)
    {
      String name = predefinedPackagesManager.getPackageName(p) ;
      Resource r = predefinedPackagesManager.getPackageResource(name) ;
      EMFModel rModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
      injector.inject(rModel, r) ;
      launcher.addInModel(rModel, name.toUpperCase(), "AADLBA") ;
    }
  }

  public void setGenerationPathDirectory(File transformationDir)
        throws ATLCoreException, Exception
  {
    AtlTransfoLauncher.transformationDir = transformationDir ;
    predefinedPackagesManager =
          new PredefinedPackagesManager(new File(transformationDir
                .getAbsolutePath() +
                "/aadl_resources")) ;

    if(!predefinedPackagesManager.allPackagesFound())
      throw new Exception(
            "Illegal initialization of ATL transformation launcher: " +
                  "some predefined packages not found: " +
                  predefinedPackagesManager.getPackagesNotFound()) ;

    this.initTransformation(transformationDir) ;
  }
}