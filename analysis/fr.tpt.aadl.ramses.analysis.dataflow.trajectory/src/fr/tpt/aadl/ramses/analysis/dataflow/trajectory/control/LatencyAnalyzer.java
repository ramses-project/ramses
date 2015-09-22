package fr.tpt.aadl.ramses.analysis.dataflow.trajectory.control;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Flow ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Network ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Node ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Path ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;


public class LatencyAnalyzer extends AbstractAnalyzer
{

  private final static Logger _LOGGER = Logger.getLogger(LatencyAnalyzer.class) ;
  
  private static final String REGISTRY_NAME = Names.SWITCHED_NETWORK_ANALYSIS_PLUGIN_NAME ;
  public final static String PLUGIN_NAME = Names.SWITCHED_NETWORK_ANALYSIS_PLUGIN_NAME ;
  private final static String PLUGIN_ID = Names.SWITCHED_NETWORK_ANALYSIS_PLUGIN_NAME ;

  protected final AadlModelInstantiatior modelInstantiator;
  protected final PredefinedAadlModelManager predefinedAadlModels;
  
  public LatencyAnalyzer(AadlModelInstantiatior modelInstantiator,
                                 PredefinedAadlModelManager predefinedAadlModels)
  {
    this.modelInstantiator = modelInstantiator;
    this.predefinedAadlModels = predefinedAadlModels;
  }

  private boolean first = true;
  private int iterationCounter ;
  
  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    if(first)
    {
      mode = (String) parameters.get("Mode") ;
      AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE ;
      currentResult = f.createAnalysisArtifact() ;
      first = false ;
    }
    parameters.put("AnalysisResult", currentResult) ;
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

  @Override
  public void performAnalysis(SystemInstance systemInstance,
                              RamsesConfiguration config,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
                                                       throws AnalysisException
  {
    List<Flow> flows = new ArrayList<Flow>();
    List<Node> nodes = new ArrayList<Node>();
    
    List<ConnectionInstance> connectionOverSwitchedNtwkList = 
        new ArrayList<ConnectionInstance>();
    
    List<ComponentInstance> virtualBusList = 
        new ArrayList<ComponentInstance>();
    
    Set<ComponentInstance> devices = 
        new HashSet<ComponentInstance>();
    
    Map<ConnectionInstance, ComponentInstance> connectionToVirtualBusMap
      = new HashMap<ConnectionInstance, ComponentInstance>();
    
    for(ConnectionInstance ci: systemInstance.getAllConnectionInstances())
    {
      // check if remote
      if(!isRemoteConnection(ci))
        continue;
      // check if deployed on virtual bus
      List<ComponentInstance> connectionBindingList = 
          PropertyUtils.getComponentInstanceList(ci,
          "Actual_Connection_Binding");
      if(connectionBindingList.size()>1)
        _LOGGER.error("Multiple values for " +
            "property Actual_Processor_Binding is not supported with software connections");
      else if(connectionBindingList.get(0).getCategory().
          equals(ComponentCategory.VIRTUAL_BUS))
        virtualBusList.add(connectionBindingList.get(0));
      connectionToVirtualBusMap.put(ci, connectionBindingList.get(0));
    }
    
    for(ComponentInstance virtualBus:virtualBusList)
    {
      Flow flow = new Flow();
      Path path = new Path();
      flow.setPath(path);
      // XXX
      flow.setPeriod(36);
      flow.setPriority(10);
      flow.setDeadline(36);
      flow.setJitter(0);
      
      flows.add(flow);
      List<ComponentInstance> connectionBindingList = 
          PropertyUtils.getComponentInstanceList(virtualBus,
          "Actual_Connection_Binding");
      if(connectionBindingList.get(0).getCategory()
          == ComponentCategory.DEVICE)
      {
        Node n1 = new Node();
        nodes.add(n1);
        
      }
      else
      {
        _LOGGER.error("Virtual buses connection binding should start with " +
            "a device");
      }
    }
    
    Network n = new Network(flows, nodes, 1, 1);
    n.init();
    
    Algorithm algo = new Algorithm(n);
  }

  private boolean isRemoteConnection(ConnectionInstance cnxInstance)
  {
    if(cnxInstance.getSource() instanceof FeatureInstance
        && cnxInstance.getDestination() instanceof FeatureInstance)
    {
      FeatureInstance source = (FeatureInstance) cnxInstance.getSource();
      FeatureInstance destination = (FeatureInstance) cnxInstance.getSource();
      
      ComponentInstance sourceComponent = source.getComponentInstance();
      ComponentInstance destinationComponent = destination.getComponentInstance();
      
      List<ComponentInstance> sourceHostList = 
          PropertyUtils.getComponentInstanceList(sourceComponent,
          "Actual_Processor_Binding");
      
      if(sourceHostList.size()>1)
      {
        _LOGGER.error("Multiple values for " +
            "property Actual_Processor_Binding is not supported");
        return false;
      }
      
      List<ComponentInstance> destinationHostList = 
          PropertyUtils.getComponentInstanceList(destinationComponent,
          "Actual_Processor_Binding");
      
      if(destinationHostList.size()>1)
      {
        _LOGGER.error("Multiple values for " +
            "property Actual_Processor_Binding is not supported");
        return false;
      }
      
      ComponentInstance sourceHost = sourceHostList.get(0);
      while(sourceHost.getCategory() != ComponentCategory.PROCESSOR
          && sourceHost!=null)
      {
        sourceHost = sourceHost.getComponentInstance();
      }
      ComponentInstance destinationHost = destinationHostList.get(0);
      while(destinationHost.getCategory() != ComponentCategory.PROCESSOR
          && destinationHost!=null)
      {
        destinationHost = destinationHost.getComponentInstance();
      }
      return destinationHost!=sourceHost;
    }
    return false;
  }
  
  @Override
  public List<String> getTransformationModuleList()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public void setIterationCounter(int iterationCounter)
  {
    this.iterationCounter = iterationCounter;
  }
}
