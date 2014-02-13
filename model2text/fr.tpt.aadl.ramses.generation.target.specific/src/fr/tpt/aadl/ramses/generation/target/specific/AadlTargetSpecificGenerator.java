/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.generation.target.specific;

import java.io.File ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import javax.swing.JOptionPane ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.PublicPackageSection ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

import fr.tpt.aadl.ramses.analysis.AnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.util.AnalysisUtils ;
import fr.tpt.aadl.ramses.control.support.Aadl2StandaloneUnparser ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.WorkflowPilot ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.transformation.atl.AadlModelValidator;
import fr.tpt.aadl.ramses.transformation.atl.AadlToTargetSpecificAadl ;


public class AadlTargetSpecificGenerator implements Generator
{
  protected AadlToTargetSpecificAadl _targetTrans ;
  
  protected AadlTargetSpecificCodeGenerator _codeGen ;
  
  protected String _registryName = null ;
  
  private Resource currentImplResource = null;
  
  private Resource _analysisResults = null;
  
  private Map<String, Resource> modelsMap = new HashMap<String, Resource>();
  
  private String systemToInstantiate = null;
  
  private AadlModelInstantiatior _modelInstantiator ;

  private AadlModelValidator _modelValidator;
  
  
  public AadlTargetSpecificGenerator(AadlToTargetSpecificAadl targetTrans,
                                     AadlTargetSpecificCodeGenerator codeGen,
                                     AadlModelInstantiatior modelInstantiator,
                                     AadlModelValidator modelValidator)
  {
    _targetTrans = targetTrans ;
    _codeGen = codeGen ;
    _modelInstantiator = modelInstantiator ;
    _modelValidator = modelValidator;
  }
  
  public void setRegistryName(String registryName)
  {
    _registryName = registryName ;
  }
  
  @Override
  public String getRegistryName()
  {
    return _registryName ;
  }

  @Override
  public String getPluginName()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public String getPluginId()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public void generate(SystemInstance systemInstance,
                       File runtimeDir,
                       File outputDir,
                       File[] includeDirs,
                       AnalysisErrorReporterManager errManager,
                       IProgressMonitor monitor) throws GenerationException
  {
	
    Resource inputResource = systemInstance.eResource() ;
    Resource r;
    if(_modelValidator != null)
    {
    	monitor.subTask("Model validation: check compatibility for refinement.");
    	r = _modelValidator.validate(inputResource, errManager, monitor);
    }
    if(_targetTrans != null)
    {
      monitor.subTask("Model transformation (refinement) ..."); 
//      RamsesConfiguration.waitUnitOfTime(1);
      r = _targetTrans.transform(inputResource, outputDir, monitor);
      monitor.worked(1);
    }
    else
     r = inputResource;
    
    _codeGen.generate(r, runtimeDir, outputDir, includeDirs, monitor) ;
  }

  @Override
/*  public void generateWorkflow(SystemInstance systemInstance,
                          File resourceDir,
                          File generatedDir,
                          WorkflowPilot workflowPilot) throws GenerationException */
  public void generateWorkflow(SystemInstance systemInstance,
                               WorkflowPilot xmlPilot,
                               File runtimeDir,
                               File outputDir,
                               File[] includeDirs,
                               AnalysisErrorReporterManager errManager,
                               IProgressMonitor monitor) throws GenerationException
  {
	if(_analysisResults==null)
	  _analysisResults = AnalysisUtils.createNewAnalysisArtifact(outputDir.getAbsolutePath()+systemInstance.getName()+".ares");
	Resource r = systemInstance.eResource() ;
    SystemInstance currentInstance = systemInstance;
    String rootModelId = xmlPilot.getInputModelId();
    if(rootModelId!=null && !rootModelId.isEmpty())
    	modelsMap.put(rootModelId, r);
    
   systemToInstantiate = systemInstance.getSystemImplementation().getName();
    PublicPackageSection pps = (PublicPackageSection) systemInstance.getSystemImplementation().getOwner();
    AadlPackage p = (AadlPackage) pps.getOwner();
    final String initialPackageName = p.getName();
    
    int transfoCounter = 0;
    
    while(xmlPilot.hasNextOperation())
    {
      String operation = xmlPilot.getNextOperation();
      if(operation == null)
    	  return;
      if(operation.equals("analysis"))
      {
        doAnalysis(xmlPilot, outputDir, monitor, errManager);
      }
      else if(operation.equals("transformation"))
      {
    	currentInstance = doTransformation(xmlPilot, r, outputDir);
    	r = currentInstance.eResource();
      }
      else if(operation.equals("unparse"))
      {  
    	  String pkgName = initialPackageName + "_" + transfoCounter;
    	  
    	  doUnparse(currentInstance.eResource(), currentImplResource, 
    	            outputDir, pkgName, monitor);
    	  
    	  transfoCounter++;
      }
      else if(operation.equals("errorstate"))
      {
        doErrorState();
      }
      else if(operation.equals("generation"))
      {
        doGeneration(runtimeDir, outputDir, includeDirs, r, monitor);
      }   
      else
      {
        System.err.println("Undefined operation : " + operation);
      }

      xmlPilot.goForward();
    }
  }

  private void doAnalysis(WorkflowPilot workflowPilot, File outputDir,
                          IProgressMonitor monitor,
                          AnalysisErrorReporterManager errManager)
  {
	  String analysisName = workflowPilot.getAnalysisName();
      String analysisMode = workflowPilot.getAnalysisMode();
      String analysisModelInputIdentifier = workflowPilot.getInputModelId();
      String analysisModelOutputIdentifier = workflowPilot.getOutputModelId();
      Resource inputResource = modelsMap.get(analysisModelInputIdentifier);
      SystemInstance currentInstance;
      PropertiesLinkingService pls = new PropertiesLinkingService ();
      if(inputResource.getContents().get(0) instanceof AadlPackage)
      {
   	    SystemImplementation si = (SystemImplementation) pls.
    	   		findNamedElementInsideAadlPackage(systemToInstantiate, 
    	   				((AadlPackage) inputResource.getContents().get(0)).getOwnedPublicSection());
    	//Check if instance model already exists
    	URI instanceModelURI = OsateResourceUtil.getInstanceModelURI(si);
    	Resource r = OsateResourceUtil.getResourceSet().getResource(instanceModelURI, false);
    	if(r!=null)
    	{
    	  currentInstance = (SystemInstance) r.getContents().get(0);
    	}
    	//otherwise produce one
    	else
    	{
          currentInstance = _modelInstantiator.instantiate(si); 
    	}
      }
      else
    	  currentInstance = (SystemInstance) inputResource.getContents().get(0);
      
      System.out.println("Analysis launched : " + analysisName + " | Analysis mode : " + analysisMode);
      ServiceRegistry sr = ServiceRegistryProvider.getServiceRegistry();
      Analyzer a = sr.getAnalyzer(analysisName);
      String outputModelId = workflowPilot.getOutputModelId();
      Map<String, Object> analysisParam = new HashMap<String, Object>();
      try {
        analysisParam.put("Mode", analysisMode);
        if(outputModelId!=null)
        	analysisParam.put("OutputModelIdentifier", outputModelId);
        if (a == null)
        {
      	  System.err.println("Unknown analysis: " + analysisName);
        }
        else
        {
          
          a.setParameters(analysisParam);
      	  a.performAnalysis(currentInstance,
      	                    outputDir,
      	                    errManager,
      	                    monitor) ;
      	  a.setParameters(analysisParam);
      	  Resource result = (Resource) analysisParam.get("OutputResource");
      	  if(result!=null)
      	  {
      	    SystemImplementation si = (SystemImplementation) pls.
            		findNamedElementInsideAadlPackage(systemToInstantiate, 
              				((AadlPackage) result.getContents().get(0)).getOwnedPublicSection());
      	    String systemToInstantiateSuffix = systemToInstantiate.substring(systemToInstantiate.lastIndexOf("."),
    			  systemToInstantiate.length());
    	    systemToInstantiate = analysisModelOutputIdentifier+systemToInstantiateSuffix;
    	    si.setName(systemToInstantiate);
      	  
      		SystemInstance sinst = _modelInstantiator.instantiate(si);
      		modelsMap.put(analysisModelOutputIdentifier, sinst.eResource());
      	  }
        }
        
      } catch (Exception e) {
      //} catch (AnalysisResultException e) {
        e.printStackTrace();
        return;
      }


      // Here is the line where to catch the analysis result
      // Then just send it to the xmlPilot


      if(analysisMode.equals("automatic"))
      {
    	AnalysisArtifact aa = (AnalysisArtifact) analysisParam.get("AnalysisResult");
    	_analysisResults.getContents().add(aa);
    	QualitativeAnalysisResult result = null;
    	for(int j=aa.getResults().size()-1; j>=0; j--)
    	{
    	  AnalysisResult r = (AnalysisResult) aa.getResults().get(j);
    	  if(r.getSource().getMethodName().toLowerCase().equals(a.getPluginName().toLowerCase()))
    	  {
    		if(aa.getResults().get(j) instanceof QualitativeAnalysisResult)
    		{
    		  result = (QualitativeAnalysisResult) aa.getResults().get(j); 
    		  workflowPilot.setAnalysisResult(result.isValidated());
    		}
    	  }
    	}
    	if(result == null)
    	{
    	  System.out.println(">> " + analysisName + " result not found");
    	  workflowPilot.setAnalysisResult(false);
    	}
    	if(result != null)
    	{
          System.out.println(">> " + analysisName + " result set at " + result.isValidated());
          workflowPilot.setAnalysisResult(result.isValidated());
    	}
      }
      else if(analysisMode.equals("manual")) {
        int res = JOptionPane.showConfirmDialog(null, "Was the analysis " + analysisName + " successfull?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION) 
        {
      	workflowPilot.setAnalysisResult(true);
          System.out.println(">> " + analysisName + " result set at true");
        }
        else
        {
      	workflowPilot.setAnalysisResult(false);
          System.out.println(">> " + analysisName + " result set at false");
        }
      }
  }
  
  private SystemInstance doTransformation(WorkflowPilot workflowPilot, Resource r, 
		                                      File generatedDir)
		                                                 throws GenerationException
  {
	  List<String> resourceFileNameList = workflowPilot.getTransformationFileNameList();
      System.out.println("Transformation launched : " + resourceFileNameList);

      String outputModelId = workflowPilot.getOutputModelId();
      Resource result = _targetTrans.transformWokflow(r, resourceFileNameList, 
                                                  generatedDir, outputModelId);

      PropertiesLinkingService pls = new PropertiesLinkingService ();
      SystemImplementation si = (SystemImplementation) pls.
      		findNamedElementInsideAadlPackage(systemToInstantiate, 
      				((AadlPackage) result.getContents().get(0)).getOwnedPublicSection());
      
      SystemInstance sinst = _modelInstantiator.instantiate(si);
      if(outputModelId!=null && !outputModelId.isEmpty())
    	  this.modelsMap.put(outputModelId, sinst.eResource());
      
      currentImplResource = sinst.eResource();
      
      return sinst;
  }
  
  private void doUnparse(Resource inputResource,
                         Resource expandedResult,
		                     File outputDir,
		                     String pkgName,
		                     IProgressMonitor monitor)
  {
	  Aadl2StandaloneUnparser.getAadlUnparser().setCustomPackageName(pkgName);
	  
	  if (expandedResult != null)
	  {
		  _targetTrans.unparse(inputResource, expandedResult, outputDir, monitor);
	  }
	  else
	  {
		  System.out.flush();
		  System.err.println("Cannot unparse model: expanded result is null");
		  System.err.flush();
	  }
  }
  
  private void doGeneration(File runtimePath,
                            File outputDir,
                            File[] includeDirs,
                            Resource r,
                            IProgressMonitor monitor)
		throws GenerationException {
	System.out.println("Generation launched from " + r.getURI().toFileString());
	_codeGen.generate(r, runtimePath, outputDir, includeDirs, monitor) ;
}

private void doErrorState() {
	System.err.println("\n\nXML piloting achieved in errorstate");
}

@Override
  public void setParameters(Map<String, Object> parameters)
  {
    // AadlTargetSpecificGenerator does not take any parameters: nothing to do.
  }

  @Override
  public boolean runtimePathChecker(File runtimePath)
  {
    return _codeGen.runtimePathChecker(runtimePath) ;
  }

  @Override
  public String getRuntimePathEnvVar()
  {
    return _codeGen.getRuntimePathEnvVar() ;
  }
}