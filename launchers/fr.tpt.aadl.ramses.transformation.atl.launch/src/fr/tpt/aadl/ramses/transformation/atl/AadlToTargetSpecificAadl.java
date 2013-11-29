/**
 * AADL-RAMSES
 *
 * Copyright ¬© 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.transformation.atl;

import java.io.File ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List ;
import java.util.Map ;
import java.util.concurrent.Callable ;
import java.util.concurrent.ExecutionException ;
import java.util.concurrent.FutureTask ;
import java.util.concurrent.TimeUnit ;
import java.util.concurrent.TimeoutException ;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexResolver;
import org.osate.ba.AadlBaParserAction ;

import antlr.RecognitionException;

import fr.tpt.aadl.ramses.control.support.AadlResourceValidator;
import fr.tpt.aadl.ramses.control.support.InstantiationManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.AadlToAadl;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider;
//import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator;
import fr.tpt.aadl.ramses.transformation.atl.AtlTransfoLauncher;

public abstract class AadlToTargetSpecificAadl implements AadlToAadl
{
	protected static AadlResourceValidator extractor;
    protected String[] ATL_FILE_NAMES;
    public List<File> ATL_FILES;
    private static final String DEFAULT_ATL_FILE_PATH =
      "../../model2model/fr.tpt.aadl.ramses.transformation.atl/" ;
    
    public void initAtlFileNameList(File resourceDir)
    {
        ATL_FILES = new ArrayList<File>(ATL_FILE_NAMES.length);
        for (String fileName : ATL_FILE_NAMES) {
        ATL_FILES.add(new File(resourceDir.getAbsolutePath() +"/"+ fileName));
      }
    }
   
  public Resource transform(Resource inputResource,
                            File resourceDir,
                            File outputDir) throws GenerationException
  {
     
      initAtlFileNameList(resourceDir);
      if(resourceDir == null)
    {
      resourceDir = new File(DEFAULT_ATL_FILE_PATH) ;
    }

    try {
        ArrayList<File> atlFiles = new ArrayList<File>(ATL_FILE_NAMES.length) ;
     
      for(String fileName : ATL_FILE_NAMES)
      {
        atlFiles.add(new File(resourceDir + "/" + fileName)) ;
      }
      Aadl2AadlEMFTVMLauncher atlLauncher = new Aadl2AadlEMFTVMLauncher();
        return atlLauncher.generationEntryPoint(inputResource,
                resourceDir,
                atlFiles,
                outputDir);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }
  }
  public Resource unparse(Resource inputResource, 
		  Resource expandedResult, File outputDir)
  {
	  String aadlGeneratedFileName = expandedResult.getURI().lastSegment();
	  aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
	  		  ".aaxl2", ".aadl2");

	  File outputModelDir =  new File(outputDir.getAbsolutePath()+"/refined-models");
	  if(outputModelDir.exists()==false)
		  outputModelDir.mkdir();
	  InstantiationManager instantiator = RamsesConfiguration.getInstantiationManager();
	  String outputFilePath=outputModelDir.getAbsolutePath()+"/"+aadlGeneratedFileName;
	  File outputFile = new File(outputFilePath);

	  instantiator.serialize(expandedResult, outputFilePath);

	  try {
		  return extractAadlResource(inputResource, outputFile);
	  } catch (Exception e) {
		  e.printStackTrace();
		  return null;
	  }
  }

  public static Resource extractAadlResource(Resource inputResource, File outputFile) throws InterruptedException, ExecutionException, CoreException, IOException, RecognitionException
  {
	  URI uri;
	  SystemInstance si = (SystemInstance) inputResource.getContents().get(0);
	  if(Platform.isRunning())
	  {
		  String workspaceLocation = ResourcesPlugin.getWorkspace()
				  .getRoot().getLocationURI().getPath();
		  int outputPathHeaderIndex = workspaceLocation.length();

		  String outputAbsolutePath = outputFile.getAbsolutePath().toString();
		  String outputPlatformRelativePath = "";
		  if(outputPathHeaderIndex>0)
			  outputPlatformRelativePath = outputAbsolutePath.substring(outputPathHeaderIndex);
		  IResource rootMember=null;
		  while(ResourcesPlugin.getWorkspace().getRoot().findMember(outputPlatformRelativePath)==null
				  && outputPlatformRelativePath.contains("/"))
		  {
			  if(rootMember==null)
			  {
				  String rootMemberPath = outputPlatformRelativePath.substring(0,outputPlatformRelativePath.indexOf("/"));
				  rootMember = ResourcesPlugin.getWorkspace().getRoot().findMember(rootMemberPath);
				  if(rootMember!=null)
					  rootMember.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			  }
			  outputPlatformRelativePath=outputPlatformRelativePath.substring(outputPlatformRelativePath.indexOf("/")+1);
		  }

		  uri = URI.createPlatformResourceURI(outputPlatformRelativePath, true) ;

		  ResourceSet rs = OsateResourceUtil.getResourceSet();
		  Resource xtextResource = rs.getResource(uri, true);

		  URI inputURI = si.getSystemImplementation().eResource().getURI();
		  IPath path = new Path(inputURI.toString().substring(18));
		  File inputDir = new File (workspaceLocation+path.toOSString());
		  RamsesConfiguration.setInputDirectory(inputDir.getParentFile());
		  return xtextResource;
	  }
	  else
	  {
		  uri = URI.createFileURI(outputFile.getAbsolutePath().toString()) ;
		  RamsesConfiguration.setInputDirectory(new File(si.getSystemImplementation().eResource().getURI().toFileString()).getParentFile());
		  final Resource xtextResource = si.getSystemImplementation().eResource().getResourceSet().getResource(uri, true) ;
		  xtextResource.load(null);
		  
		  // Implements a timeout of 10s.
		  
		  Callable<Boolean> app = new Callable<Boolean>(){

        @Override
        public Boolean call() throws Exception
        {
          AadlResourceValidator.validate(xtextResource.getResourceSet());
          return true ;
        }
		    
		  } ;
		  
		  FutureTask<Boolean> ft = new FutureTask<Boolean>(app) ;
		  
		  new Thread(ft).start() ;		  
		  
		  try
      {
		    ft.get(10, TimeUnit.SECONDS) ;
      }
      catch (TimeoutException ee)
		  {
		    // Nothing to do, just continue.
		  }
		  		  
		  ServiceRegistry sr = ServiceRegistryProvider.getServiceRegistry();
		  ParseErrorReporter errReporter = ServiceRegistry.PARSE_ERR_REPORTER ;
		  AnalysisErrorReporterManager errManager = ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER;
		  Iterator<EObject> iter = xtextResource.getAllContents();
		  while(iter.hasNext())
		  {
			  Collection<Object> dasList = EcoreUtil.getObjectsByType(iter.next().eContents(), Aadl2Package.eINSTANCE.getDefaultAnnexSubclause());
			  for (Object o : dasList)
			  {
				  DefaultAnnexSubclause das = (DefaultAnnexSubclause) o;
				  String annexName = das.getName();
				  if(annexName.equalsIgnoreCase(AadlBaParserAction.ANNEX_NAME))
				  {
					  AnnexParser ap = sr.getParser(annexName);
					  ICompositeNode node = NodeModelUtils.findActualNodeFor(das);
					  String annexText = das.getSourceText();
					  if(annexText.length() > 6)
					  {
						  annexText = annexText.substring(3, annexText.length() - 3) ;
					  }
					  AnnexSubclause as = ap.parseAnnexSubclause(annexName,
							  annexText,
							  outputFile.getName(),
							  node.getStartLine(),
							  node.getOffset(),
							  errReporter);
					  AnnexResolver ar = sr.getResolver(annexName) ;
					  if(as != null && errReporter.getNumErrors() == 0)
					  {
						  as.setName(annexName) ;
						  // replace default annex library with the new one.
						  EList<AnnexSubclause> ael =
						  ((Classifier) das.eContainer()).getOwnedAnnexSubclauses() ;
						  int idx = ael.indexOf(das) ;
						  ael.add(idx, as) ;
						  ael.remove(das) ;
						  List<AnnexSubclause> annexElements = Collections.singletonList(as) ;
						  ar.resolveAnnex(das.getName(), annexElements, errManager) ;
					  }
				  }
			  }
		  }
		  return xtextResource;
	  }
  }

abstract public void setParameters(Map<Enum<?>, Object> parameters);
 
  public static void validate(ResourceSet rs) throws RecognitionException, CoreException, IOException, InterruptedException, ExecutionException
  {
	AadlResourceValidator.validate(rs);
  }
  
  public Resource transformXML(Resource inputResource,
                                                           File resourceDir,
                                                           List<String> resourceFileNameList,
                                                           File outputDir) throws GenerationException
  {
      if(resourceDir == null)
      {
          resourceDir = new File(DEFAULT_ATL_FILE_PATH) ;
      }

      ArrayList<File> atlFiles = new ArrayList<File>() ;
      for(String resourceFileName : resourceFileNameList)
      {
    	  String resourcePath = resourceFileName;
    	  if(false == resourceFileName.startsWith(File.separator))
    		  resourcePath=resourceDir+"/"+resourceFileName;
          atlFiles.add(new File(resourcePath)) ;
      }

      try {
    	  Aadl2AadlEMFTVMLauncher atlLauncher = new Aadl2AadlEMFTVMLauncher();
          return atlLauncher.generationEntryPoint(inputResource,
                  resourceDir,
                  atlFiles,
                  outputDir);
      } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          return null;
      }
  }

}