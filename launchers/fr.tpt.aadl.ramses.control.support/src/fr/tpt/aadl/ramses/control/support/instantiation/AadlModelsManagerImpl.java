package fr.tpt.aadl.ramses.control.support.instantiation;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.instantiation.InstantiateModel ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

import fr.tpt.aadl.ramses.control.support.generator.Aadl2StandaloneUnparser ;


public class AadlModelsManagerImpl implements AadlModelInstantiatior {

	protected InstantiateModel _instantiateModel ;
        
	private ResourceSet aadlResourceSet = new ResourceSetImpl();
//	protected AadlModelInstantiatior _modelInstantiator ;
	protected IProgressMonitor _monitor = new NullProgressMonitor() ;
	protected AnalysisErrorReporterManager _errManager ;
	
	private static Logger _LOGGER = Logger.getLogger(AadlModelsManagerImpl.class) ;
	
	public AadlModelsManagerImpl(AnalysisErrorReporterManager errManager)
  {
    _errManager = errManager ;
    _instantiateModel = new InstantiateModel(_monitor, errManager) ;
  }
	
	public AadlModelsManagerImpl(AnalysisErrorReporterManager errManager,
	                             IProgressMonitor monitor)
	{
	  _errManager = errManager ;
	  _monitor = monitor ;
	  _instantiateModel = new InstantiateModel(monitor, errManager) ;
	}
	
	public void setProgressMonitor(IProgressMonitor monitor)
	{
	  _monitor = monitor ;
	  _instantiateModel = new InstantiateModel(_monitor, _errManager) ;
	}
	
	/**
	 * @see AadlModelsManagerImpl#instantiate(SystemImplementation)
	 */
	@Override
	public SystemInstance instantiate(SystemImplementation si) {
	  if(si == null)
	  {
		String errMsg =  "cannot delete the previous AADL resource set" ;
        _LOGGER.fatal(errMsg);
        throw new RuntimeException(errMsg) ;
	  }
	  URI instanceURI =
	       OsateResourceUtil.getInstanceModelURI(si) ;
	  
	  Resource aadlResource = aadlResourceSet.getResource(instanceURI,
	                                                      false) ;
    if(aadlResource != null)
    {
      try
      {
        aadlResource.delete(null) ;
      }
      catch(IOException e)
      {
        String errMsg =  "cannot delete the previous AADL resource set" ;
        _LOGGER.fatal(errMsg, e);
        throw new RuntimeException(errMsg, e) ;
      }
    }
    
	  aadlResource = aadlResourceSet
              .createResource(instanceURI) ;

	  SystemInstance instance = _instantiateModel.createSystemInstanceInt(si,
	                                                    aadlResource) ;
	  
	  if(instance == null)
	  {
		  String errMsg = "Model instantiation failed";
		  _LOGGER.fatal(errMsg);
		  throw new RuntimeException(errMsg);
	  }
	  
	  return instance;
    }

	/**
	 * @see AadlModelInstantiatior#instantiate(List, String)
	 */
	@Override
	public	SystemInstance instantiate(List<Resource> aadlModels,
			                               String systemToInstantiate)
  {
    for(Resource r : aadlModels)
    {
      PropertiesLinkingService pls = new PropertiesLinkingService() ;
      AadlPackage pkg = (AadlPackage) r.getContents().get(0) ;
      SystemImplementation si = (SystemImplementation) pls.
                    findNamedElementInsideAadlPackage(systemToInstantiate,
                                                  pkg.getOwnedPublicSection()) ;
      if(si == null)
        continue ;
      return this.instantiate(si) ;
    }

    return null ;
  }

	/**
	 * @see AadlModelsManagerImpl#serialize(Resource, String)
	 */
	@Override
	public synchronized void serialize(Resource transfoResult,
	                        String targetFileName)
  {
    // serialization code
    //	    XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI(targetFileName));
    //	    resource.getContents().add(transfoResult.getContents().get(0));
    //	    SaveOptions.Builder sb = SaveOptions.newBuilder();
    //	    Map<Object,Object> options = new HashMap<Object,Object>();
    //	    sb.getOptions().addTo(options);
    //	    try {
    //	    	resource.save(options);
    //	    } catch (IOException e) {
    //	    	e.printStackTrace(); LOOG ME !
    //	    }

    //		  Serializer serializer = injector.getInstance(Serializer.class);
    //		  String resultFileContent = serializer.serialize(transfoResult.getContents().get(0));
    try
    {
      transfoResult.load(null) ;
    }
    catch(IOException e)
    {
      String errMsg =  "cannot load the resources" ;
      _LOGGER.fatal(errMsg, e);
      throw new RuntimeException(errMsg, e) ;
    }
    
    Aadl2StandaloneUnparser unparser =
                                       Aadl2StandaloneUnparser.getAadlUnparser() ;
    String resultFileContent =
                               unparser.doUnparse((Element) transfoResult.getContents()
                                                                         .get(0)) ;
    try
    {
      File clean = new File(targetFileName) ;
      clean.delete() ;
      BufferedWriter out = new BufferedWriter(new FileWriter(targetFileName)) ;
      out.write(resultFileContent) ;
      out.close() ;
    }
    catch(IOException e)
    {
      String errMsg =  "cannot write into file" ;
      _LOGGER.fatal(errMsg, e);
      throw new RuntimeException(errMsg, e) ;
    }

    _LOGGER.trace("Serialized result in: " + targetFileName) ;
  }
}