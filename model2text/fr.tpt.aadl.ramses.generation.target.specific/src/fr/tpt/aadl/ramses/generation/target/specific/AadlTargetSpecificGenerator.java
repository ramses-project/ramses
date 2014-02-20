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
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.PublicPackageSection ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

import fr.tpt.aadl.ramses.analysis.AnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.util.AnalysisUtils ;
import fr.tpt.aadl.ramses.control.atl.AadlModelValidator ;
import fr.tpt.aadl.ramses.control.atl.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.support.Aadl2StandaloneUnparser ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.AadlModelsManagerImpl ;
import fr.tpt.aadl.ramses.control.support.AbstractLoop ;
import fr.tpt.aadl.ramses.control.support.WorkflowPilot ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;


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
  
  /** Loop debug  (loopValidIteration must be negative to disable debug) **/
  private static int loopValidIteration = -1;
  private int loopIteration = -1;
  /****************/
  
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
    	if(false==r.getContents().isEmpty())
    	{
    	  for(EObject err : r.getContents())
    	  {
    		if(err instanceof fr.tpt.aadl.ramses.constraintsreporter.Error)
    		{
    		  fr.tpt.aadl.ramses.constraintsreporter.Error constraintError =
    						(fr.tpt.aadl.ramses.constraintsreporter.Error) err;
    		  errManager.error((Element) constraintError.getObject(), 
    						constraintError.getMessage());
    		}
    	  }
    	  return;
    	}
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
	if(_modelValidator != null)
    {
      monitor.subTask("Model validation: check compatibility for refinement.");
      Resource errRes = _modelValidator.validate(r, errManager, monitor);
      if(false==errRes.getContents().isEmpty())
      {
    	for(EObject err : errRes.getContents())
    	{
    	  if(err instanceof fr.tpt.aadl.ramses.constraintsreporter.Error)
    	  {
    		fr.tpt.aadl.ramses.constraintsreporter.Error constraintError =
    						(fr.tpt.aadl.ramses.constraintsreporter.Error) err;
    		errManager.error((Element) constraintError.getObject(), 
    						constraintError.getMessage());
    	  }
    	}
    	return;
      }
    }
    SystemInstance currentInstance = systemInstance;
    String rootModelId = xmlPilot.getInputModelId();
    if(rootModelId!=null && !rootModelId.isEmpty())
    	modelsMap.put(rootModelId, r);
    
   systemToInstantiate = xmlPilot.getOutputModelId()+".impl";
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
    	  currentInstance = doTransformation(xmlPilot, outputDir);
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
      else if(operation.equals("loop"))
      {
        doLoop(xmlPilot.getLoop(),errManager, xmlPilot, outputDir, monitor);
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
    doAnalysis(analysisName,analysisMode,analysisModelInputIdentifier,
               analysisModelOutputIdentifier, errManager,workflowPilot,outputDir,monitor);
  }
  
  private void doAnalysis(String analysisName, String analysisMode,
                          String analysisModelInputIdentifier,
                          String analysisModelOutputIdentifier,
                          AnalysisErrorReporterManager errManager,
                          WorkflowPilot workflowPilot,
                          File outputDir,
                          IProgressMonitor monitor)
  {
	  _modelInstantiator = new AadlModelsManagerImpl(errManager);
	    
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
      ServiceRegistry sr = ServiceProvider.getServiceRegistry();
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
      		systemToInstantiate = analysisModelOutputIdentifier+".impl";
      	    SystemImplementation si = (SystemImplementation) pls.
            		findNamedElementInsideAadlPackage(systemToInstantiate, 
              				((AadlPackage) result.getContents().get(0)).getOwnedPublicSection());
      	  
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
  
  private void doLoop(AbstractLoop l,AnalysisErrorReporterManager errManager,
                      WorkflowPilot xmlPilot, File outputDir,
                      IProgressMonitor monitor)
  {
    AbstractLoop.AbstractAnalysis a = l.getAnalysis();
    final String inputId = l.getInputModelIdentifier();
    final String outputId = l.getOutputModelIdentifier();
    
    loopIteration = -1;
    for(List<String> moduleList : l.getModuleLists())
    {
      loopIteration++;
      System.out.println("Start loop iteration = " + loopIteration);
      try
      {
        doTransformation(moduleList,inputId,outputId,outputDir);
        if (isValidLoopIteration(a,errManager,xmlPilot,outputDir,outputId,monitor))
        {
          break;
        }
      }
      catch(GenerationException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  private boolean isValidLoopIteration (AbstractLoop.AbstractAnalysis a, AnalysisErrorReporterManager errManager,
                                        WorkflowPilot xmlPilot, File outputDir,
                                        String outputId, IProgressMonitor monitor)
  {
     if (loopValidIteration >= 0)
     {
       /** Debug mode (valid iteration is fixed by the user) */
       return loopIteration == loopValidIteration;
     }
     else
     {
       /** Check iteration validity by specified analysis */
       return doLoopAnalysis(a,errManager,xmlPilot,outputDir,monitor,outputId,outputId);
     }
  }
  
  private boolean doLoopAnalysis(AbstractLoop.AbstractAnalysis a,
                              AnalysisErrorReporterManager errManager,
                              WorkflowPilot xmlPilot,
                              File outputDir,
                              IProgressMonitor monitor,
                              String inputId,
                              String outputId)
  {
    if (a instanceof AbstractLoop.Analysis)
    {
       AbstractLoop.Analysis aa = (AbstractLoop.Analysis) a;
       String inputIdSpecific = aa.getInputModelIdentifier();
       String outputIdSpecific = aa.getOutputModelIdentifier();
       inputId = (inputIdSpecific == null) ? inputId : inputIdSpecific;
       outputId = (outputIdSpecific == null) ? outputId : outputIdSpecific;
       doAnalysis(aa.getMethod(),aa.getMode(),inputId,outputId,errManager,
                  xmlPilot,outputDir,monitor);
      
       return xmlPilot.getAnalysisResult();
    }
    else if (a instanceof AbstractLoop.Conjunction)
    {
      AbstractLoop.Conjunction c = (AbstractLoop.Conjunction) a;
      for(AbstractLoop.AbstractAnalysis aa : c.getSequence())
      { 
         if (! doLoopAnalysis(aa,errManager,xmlPilot,outputDir,monitor,inputId,outputId))
         {
           return false;
         }
      }
      return true;
    }
    else if (a instanceof AbstractLoop.Disjunction)
    {
      AbstractLoop.Disjunction d = (AbstractLoop.Disjunction) a;
      for(AbstractLoop.AbstractAnalysis aa : d.getSequence())
      {
         if (doLoopAnalysis(aa,errManager,xmlPilot,outputDir,monitor,inputId,outputId))
         {
           return true;
         }
      }
      return false;
    }
    else
      return false;
  }

  private SystemInstance doTransformation(WorkflowPilot workflowPilot, File generatedDir)
		                                                 throws GenerationException
	{
    List<String> resourceFileNameList = workflowPilot.getTransformationFileNameList();
    String inputModelId = workflowPilot.getInputModelId();
    String outputModelId = workflowPilot.getOutputModelId();
    return doTransformation(resourceFileNameList,inputModelId,outputModelId,generatedDir);
	}
		                                                 
  private SystemInstance doTransformation(List<String> resourceFileNameList,
                                          String inputModelId, String outputModelId, 
                                          File generatedDir) throws GenerationException
  {
      Resource r = modelsMap.get(inputModelId);
    
      System.out.println("Transformation launched");
      System.out.println("  Input model  : " + inputModelId);
      System.out.println("  Module list  : " + resourceFileNameList);
      System.out.println("  Output model : " + outputModelId);

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