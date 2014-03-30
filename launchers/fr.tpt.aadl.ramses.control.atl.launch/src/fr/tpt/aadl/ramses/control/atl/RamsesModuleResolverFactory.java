package fr.tpt.aadl.ramses.control.atl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolverFactory;

import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;

public class RamsesModuleResolverFactory implements ModuleResolverFactory {
	
  private static Logger _LOGGER = Logger.getLogger(Aadl2XEMFTVMLauncher.class) ;
	
  @Override
  public ModuleResolver createModuleResolver() {
	ModuleResolver moduleResolver = new ModuleResolver() {
	  @Override
	  public Module resolveModule(String module) throws ModuleNotFoundException {
		Resource moduleRes = new EMFTVMResourceImpl();
		try {
		  String URLString = "file:" + 
				  RamsesConfiguration.getAtlResourceDir().getAbsolutePath() +
				  File.separator+
				  module;
		  if(false == URLString.endsWith(".emftvm"))
			URLString+=".emftvm";
		  URL moduleURL = new URL(URLString) ;
		  InputStream inputStream = moduleURL.openStream();
		  try {
			moduleRes.load(inputStream, Collections.emptyMap());
		  } finally {
			inputStream.close();
		  }
		  URI fileURI = URI.createFileURI(module +".emftvm");
		  moduleRes.getContents().get(0).eResource().setURI(fileURI);
		  return (Module) moduleRes.getContents().get(0);
		} catch (IOException e)
		{
		  String msg = "cannot resolve module \'" + module + '\'' ;
		  _LOGGER.fatal(msg, e);
		  throw new ModuleNotFoundException(msg, e);
		}
	  }
	};
	return moduleResolver;
  }

}
