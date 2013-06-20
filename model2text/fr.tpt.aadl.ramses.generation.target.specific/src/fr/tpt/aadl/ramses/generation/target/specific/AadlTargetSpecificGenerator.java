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

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

import fr.tpt.aadl.ramses.control.support.Aadl2StandaloneUnparser;
import fr.tpt.aadl.ramses.control.support.InstantiationManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.WorkflowPilot;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider;
import fr.tpt.aadl.ramses.transformation.atl.AadlToTargetSpecificAadl;


public class AadlTargetSpecificGenerator implements Generator
{
  protected AadlToTargetSpecificAadl _targetTrans ;
  
  protected AadlTargetSpecificCodeGenerator _codeGen ;
  
  protected String _registryName = null ;
  
  private Resource currentImplResource = null;
  
  protected AadlTargetSpecificGenerator()
  {
  }
  
  public AadlTargetSpecificGenerator(AadlToTargetSpecificAadl targetTrans,
                                     AadlTargetSpecificCodeGenerator codeGen)
  {
    _targetTrans = targetTrans ;
    _codeGen = codeGen ;
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
                       File resourceFilePath,
                       File generatedFilePath)
                                                      throws GenerationException
  {
    Resource inputResource = systemInstance.eResource() ;
    
    Resource r = _targetTrans.transform(inputResource, resourceFilePath,
                                        generatedFilePath);
    
    _codeGen.generate(r, generatedFilePath) ;
  }

  @Override
  public void generateWorkflow(SystemInstance systemInstance,
                          File resourceDir,
                          File generatedDir,
                          WorkflowPilot workflowPilot) throws GenerationException
  {
	Resource r = systemInstance.eResource() ;
    SystemInstance currentInstance = systemInstance;
    final String systemToInstantiate = systemInstance.getSystemImplementation().getName();
    
    PublicPackageSection pps = (PublicPackageSection) systemInstance.getSystemImplementation().getOwner();
    AadlPackage p = (AadlPackage) pps.getOwner();
    final String initialPackageName = p.getName();
    
    int transfoCounter = 0;
    
    while(workflowPilot.hasNextOperation())
    {
      String operation = workflowPilot.getNextOperation();
      if(operation == null)
    	  return;
      if(operation.equals("analysis"))
      {
        doAnalysis(workflowPilot, currentInstance);
      }
      else if(operation.equals("transformation"))
      {
    	currentInstance = doTransformation(workflowPilot,r,
    			resourceDir,generatedDir,systemToInstantiate);
    	
    	r = currentInstance.eResource();
      }
      else if(operation.equals("unparse"))
      {  
    	  String pkgName = initialPackageName + "_" + transfoCounter;
    	  
    	  doUnparse(currentInstance.eResource(), currentImplResource, 
    			  generatedDir, pkgName);
    	  
    	  transfoCounter++;
      }
      else if(operation.equals("errorstate"))
      {
        doErrorState();
      }
      else if(operation.equals("generation"))
      {
        doGeneration(generatedDir, r);
      }   
      else
      {
        System.err.println("Undefined operation : " + operation);
      }

      workflowPilot.goForward();
    }
  }

  private void doAnalysis(WorkflowPilot workflowPilot, SystemInstance currentInstance)
  {
	  String analysisName = workflowPilot.getNextAnalysisName();
      String analysisMode = workflowPilot.getNextAnalysisMode();
      System.out.println("Analysis launched : " + analysisName + " | Analysis mode : " + analysisMode);
      try {
        ServiceRegistry sr = ServiceRegistryProvider.getServiceRegistry();
        Analyzer a = sr.getAnalyzer(analysisName);
        Map<String, Object> modeParam = new HashMap<String, Object>();
        modeParam.put("mode", analysisMode);
        if (a == null)
        {
      	  System.err.println("Unknown analysis: " + analysisName);
        }
        else
        {
          a.setParameters(modeParam);
      	  a.performAnalysis(currentInstance, ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER,
                    new NullProgressMonitor()) ;
        }
        
      } catch (Exception e) {
      //} catch (AnalysisResultException e) {
        e.printStackTrace();
      }


      // Here is the line where to catch the analysis result
      // Then just send it to the xmlPilot


      if(analysisMode.equals("automatic"))
      {
        workflowPilot.setAnalysisResult(true);
        System.out.println(">> " + analysisName + " result set at true");
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
		  File resourceDir, File generatedDir, String systemToInstantiate) throws GenerationException
  {
	  List<String> resourceFileNameList = workflowPilot.getNextTransformationFileNameList();
      System.out.println("Transformation launched : " + resourceFileNameList);

      Resource result = _targetTrans.transformXML(r, resourceDir, resourceFileNameList, 
                                                  generatedDir);

      InstantiationManager instantiator = RamsesConfiguration.getInstantiationManager();
      PropertiesLinkingService pls = new PropertiesLinkingService ();
      SystemImplementation si = (SystemImplementation) pls.
      		findNamedElementInsideAadlPackage(systemToInstantiate, 
      				((AadlPackage) result.getContents().get(0)).getOwnedPublicSection());
      
      currentImplResource = result;
      
      return instantiator.instantiate(si);
  }
  
  private void doUnparse(Resource inputResource, Resource expandedResult,
		  File outputDir, String pkgName)
  {
	  Aadl2StandaloneUnparser.getAadlUnparser().setCustomPackageName(pkgName);
	  
	  if (expandedResult != null)
	  {
		  _targetTrans.unparse(inputResource, expandedResult, outputDir, pkgName);
	  }
	  else
	  {
		  System.out.flush();
		  System.err.println("Cannot unparse model: expanded result is null");
		  System.err.flush();
	  }
  }
  
  private void doGeneration(File generatedDir, Resource r)
		throws GenerationException {
	System.out.println("Generation launched from " + r.getURI().toFileString());
	_codeGen.generate(r, generatedDir) ;
}

private void doErrorState() {
	System.err.println("\n\nXML piloting achieved in errorstate");
}

@Override
  public void setParameters(Map<String, Object> parameters)
  {
    // AadlTargetSpecificGenerator does not take any parameters: nothing to do.
  }

}