/**
 * AADL-RAMSES
 * 
 * Copyright Â© 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

/*
 * author: Etienne Borde
 *
 */

package fr.tpt.aadl.ramses.transformation.atl ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertySet;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;

public abstract class AtlTransfoLauncher
{

  protected static File resourcesDir = null ;

  protected static final EMFInjector injector = new EMFInjector() ;
//  private static final EMFExtractor extractor = new EMFExtractor() ;

  // Load the input file resource
  private static final EMFModelFactory factory = new EMFModelFactory() ;
  protected static EMFReferenceModel aadlbaMetamodel ;


  /*
   * The parameters of the transformation: asm file, input and a-output path.
   */ 

  public static File getTransformationDirName()
  {
    return AtlTransfoLauncher.resourcesDir ;
  }

  protected abstract void initTransformation() throws ATLCoreException;
  
  public abstract Resource generationEntryPoint(Resource inputResource,
		  File resourceDir,
		  List<File> transformationFileList,
		  File outputDir) throws GenerationException;

  public abstract Resource doGeneration(Resource inputResource,
                               List<File> transformationFileList,
                               String outputDirPathName)
        throws FileNotFoundException, IOException, ATLCoreException, Exception;
  
  
  
  protected abstract Resource doTransformation(List<File> transformationFileList, Resource inputResource,
		  String outputDirPathName)
        throws FileNotFoundException, IOException, ATLCoreException;

  
  
  protected void registerPredefinedResourcesInLauncher(EMFVMLauncher launcher)
  {
    for(Resource r: RamsesConfiguration.getPredefinedResourcesManager()
    		.getPredefinedResources())
    {
      String name;
      EObject obj = r.getContents().get(0);
      if(obj instanceof PropertySet)
    	  name = ((PropertySet)obj).getName() ;
      else
    	name = ((AadlPackage)obj).getName() ;
      EMFModel rModel = (EMFModel) factory.newModel(aadlbaMetamodel) ;
      injector.inject(rModel, r) ;
      launcher.addInModel(rModel, name.toUpperCase(), "AADLBA") ;
    }
  }
  
  protected void setPredefinedResourcesDirectory(File dir)
                                              throws ATLCoreException, Exception
  {
	if(resourcesDir==null)
		this.initTransformation() ;
    AtlTransfoLauncher.resourcesDir = dir ;
  }
  
  protected abstract void registerDefaultTransformations(List<Object> atlModules, EMFVMLauncher launcher) throws IOException;
  
}