/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.analysis.eg ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.util.Aadl2Util ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.AnalysisSource ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGModels ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel ;

public class EGAnalyzer extends AbstractAnalyzer
{
  private static final String REGISTRY_NAME = "WCET" ;
  public final static String PLUGIN_NAME = "WCET" ;
  private final static String PLUGIN_ID = "WCET" ;
  
  private AadlModelInstantiatior _instantiator ;
  private PredefinedAadlModelManager _predefinedResourcesManager ;
  
  private final AnalysisArtifact currentResult = createResult();
  
  private String outputModelIdentifier = null;
  private Resource aadlWithWcet;

  public EGAnalyzer(AadlModelInstantiatior instantiator,
                      PredefinedAadlModelManager predefinedResourcesManager)
  {
    _instantiator = instantiator ;
    _predefinedResourcesManager = predefinedResourcesManager ;
  }
  
  private static AnalysisArtifact createResult()
  {
    /** WCET analysis returns always true (it must be followed 
     * by a scheduling analysis */
    
    final AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
    
    AnalysisSource source = f.createAnalysisSource();
    source.setMethodName(PLUGIN_NAME);
    
    AnalysisArtifact currentResult = f.createAnalysisArtifact();
    
    QualitativeAnalysisResult r = f.createQualitativeAnalysisResult();
    r.setValidated(true);
    r.setSource(source);
    currentResult.getResults().add(r);
    
    return currentResult;
  }
  
  /*@Override
  protected String getActionName() 
  {
  	return ACTION_NAME;
  }*/
  
  @Override
  public void performAnalysis(SystemInstance systemInstance,
                              File outputDir,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
        throws AnalysisException
  {
    EGLauncher launcher = new EGLauncher(systemInstance) ;
    launcher.launch() ;
  
    EGModels models = launcher.lastLaunchResults() ;
    
    //EG2DOT eg2dot = new EG2DOT ("/home/fabien/execution_graphs/", DOTLayout.dot);
    //eg2dot.launch(models,systemInstance);
    
    /** Clone graph and reduce to a sequence **/
    
    EGModels models2 = models.clone();
    models2.reduce();
    
    //EG2DOT eg2dot2 = new EG2DOT ("/home/fabien/execution_graphs/reduced/", DOTLayout.dot);
    //eg2dot2.launch(models2,systemInstance);
    
    /** Print WCET overhead */
    
    for(ComponentInstance thread: models2.getThreads())
    {
      double wcet0 = models2.getWCETFromPropertyInMs(thread);
      double wcet1 = models2.getWCETFromComputationInMs(thread);
      System.out.printf(thread.getName()+"\t: WCET0=%.4g\tWCET1=%.4g\n",wcet0,wcet1);
    } 
    
    /** Normalize results */
    
    EG2ResultModel eg2resultModel = new EG2ResultModel(models2);
    AnalysisModel result = eg2resultModel.getAnalysisModel();
    
    produceAnalysisAADLModel(result, outputDir, systemInstance);
  }
  
  
  private void produceAnalysisAADLModel(AnalysisModel m, File outputDir,
                                        SystemInstance systemInstance)
  {
    Wcet2AadlEMFTVMLauncher launcher = new Wcet2AadlEMFTVMLauncher(m, _instantiator, _predefinedResourcesManager);
    List<File> transformationFileList = new ArrayList<File>();
    Aadl2Util.setUseTunedEqualsMethods (false);
    
    transformationFileList.add(new File(RamsesConfiguration.getAtlResourceDir().getAbsolutePath()+"/WcetAnalysis/ReducedBA"));
    
    launcher.setOutputPackageName(outputModelIdentifier);
    File wcetOutputDir = new File(outputDir.getAbsolutePath()+"/wcet");
    if(wcetOutputDir.exists()==false)
      wcetOutputDir.mkdir();
    File aadlWithWcetFile = new File(wcetOutputDir.getAbsolutePath()+File.separator+outputModelIdentifier+".aadl2");
    Resource rootResource = systemInstance.eResource();
    aadlWithWcet = launcher.doTransformation(transformationFileList, 
                  rootResource,
                  outputDir.getAbsolutePath(),
                  "_"+outputModelIdentifier);
    
    aadlWithWcet.setURI(URI.createFileURI(aadlWithWcetFile.getAbsolutePath()));
    
    _instantiator.serialize(aadlWithWcet, aadlWithWcetFile.getAbsolutePath());
    
    Aadl2Util.setUseTunedEqualsMethods (false);
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    mode = (String) parameters.get("Mode");
    outputModelIdentifier = (String) parameters.get("OutputModelIdentifier");
    parameters.put("AnalysisResult", currentResult);
    parameters.put("OutputResource", aadlWithWcet); 
  }

  @Override
  public String getRegistryName()
  {
    return REGISTRY_NAME ;
  }

  @Override
  public String getPluginName()
  {
    return PLUGIN_NAME ;
  }

  @Override
  public String getPluginId()
  {
    return PLUGIN_ID ;
  }
}