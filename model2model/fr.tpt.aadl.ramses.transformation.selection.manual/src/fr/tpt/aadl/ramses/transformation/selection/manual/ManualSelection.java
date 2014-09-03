package fr.tpt.aadl.ramses.transformation.selection.manual;

import java.io.FileInputStream ;
import java.io.IOException ;
import java.io.InputStream ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;
import java.util.Properties ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManager ;
import fr.tpt.aadl.ramses.transformation.launcher.ArchitectureRefinementProcessLauncher ;
import fr.tpt.aadl.ramses.transformation.selection.ITransformationSelection ;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;

public class ManualSelection implements ITransformationSelection,LoopManager
{

  
  private static Logger _LOGGER = Logger.getLogger(ManualSelection.class) ;
  
  AadlTargetSpecificGenerator generator;
  Resource currentImplResource;
  AbstractLoop l;
  AnalysisErrorReporterManager errManager;
  WorkflowPilot workflowPilot;
  RamsesConfiguration config;
  IProgressMonitor monitor;
  
  Properties prop;
  

  public ManualSelection(AadlTargetSpecificGenerator aadlTargetSpecificGenerator,
                         AbstractLoop l,
                         AnalysisErrorReporterManager errManager,
                         WorkflowPilot workflowPilot,
                         RamsesConfiguration config, IProgressMonitor monitor)
  {
    this.generator = aadlTargetSpecificGenerator;
    this.l = l;
    this.errManager = errManager;
    this.workflowPilot = workflowPilot;
    this.config = config;
    this.monitor = monitor;
  }

  @Override
  public String getResolutionMethodName()
  {
    return ResolutionMethod.MANUAL_MERGE.getName();
  }

  @Override
  public Map<? extends String, ? extends Resource>
      processLoop() throws AnalysisException, ParseException,
                   TransformationException, ConfigurationException, IOException
  {
    Map<String, Resource> result = new HashMap<String, Resource>();
    TrcSpecification trc = (TrcSpecification) l.getTransformations().get(0).eResource().getContents().get(0);

    String propertyFile = (String) config.getParameters().get(Names.RAMSES_PROPERTIES);

    prop = new Properties();
    try {
      InputStream in = new FileInputStream(propertyFile);
      prop.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }

    ArchitectureRefinementProcessLauncher mergeLauncher = new ArchitectureRefinementProcessLauncher
        (trc,
         this.currentImplResource.getResourceSet(),
         config,
         this,
         prop,
         l.getTransformations(),
         generator._modelInstantiator,
         generator._predefinedResourceManager
            );
    SystemInstance sinst = (SystemInstance) this.currentImplResource.getContents().get(0);
    Resource res = mergeLauncher.launch(sinst, workflowPilot.getOutputModelId(), l.getIterationNb());
    result.put(workflowPilot.getOutputModelId(), res);
    
    return result;
  }
  
  @Override
  public void selectTransformation (Map<List<EObject>, ArrayList<String>> patternMatchingMap,
                                    ArrayList<ElementTransformation> tuplesToApply)
  {
    String message = "In manual selection branch";
    _LOGGER.trace(message);
    
    ServiceProvider.SYS_ERR_REP.error("Not Implemented Yet", false);
    
  }

  @Override
  public boolean shouldSelectionContinue()
  {
    return true ;
  }

}
