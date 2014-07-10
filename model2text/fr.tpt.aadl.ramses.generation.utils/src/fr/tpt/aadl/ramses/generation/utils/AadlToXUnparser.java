package fr.tpt.aadl.ramses.generation.utils;

import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.DataPort ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DefaultAnnexSubclause ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.EventDataPort ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.FeatureCategory ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.BlackBoardInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.EventInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.GlobalQueueInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.QueueInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.SampleInfo ;

public abstract class AadlToXUnparser
{

  private static Logger _LOGGER = Logger.getLogger(AadlToXUnparser.class) ;

  protected abstract String getGlobalQueueType();
  
  protected abstract String getBlackBoardType();

  protected abstract String getBufferType();

  protected abstract String getEventType();

  protected abstract String getQueuingType();

  protected abstract String getSamplingType();

  protected abstract String getSemaphoreType();

  protected abstract String getVirtualPortType();

  protected abstract String getFeatureLocalIdentifier(FeatureInstance fi);

  protected abstract String getGenerationIdentifier(String prefix);

  protected abstract void sendOutputQueueing(UnparseText mainImplCode, 
                                                QueueInfo info);

  protected abstract void sendOutputEvent(UnparseText mainImplCode, 
                                             EventInfo info);

  protected abstract void sendOutputBuffer(UnparseText mainImplCode, 
                                              QueueInfo info);

  protected abstract void sendOutputPrologue(ComponentInstance processInstance,
                     UnparseText mainImplCode, ProcessProperties pp);

  protected abstract void sendOutputVariableAccess(ComponentInstance processInstance,
                                             UnparseText mainImplCode, ProcessProperties pp);

  protected void findCommunicationMechanism(ProcessImplementation process,
                                            ProcessProperties pp)
  {
    EList<Subcomponent> subcmpts = process.getAllSubcomponents() ;
    
    for(Subcomponent s : subcmpts)
    {
      NamedElement ne = HookAccessImpl.getTransformationTrace(s);
      if(ne==null)
        continue;
      if(s instanceof DataSubcomponent)
      {
        if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getGlobalQueueType()))
        {
          globalQueueHandler(s.getName(),
                             (ComponentInstance) HookAccessImpl.
                             getTransformationTrace(s), pp);
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getBlackBoardType()))
        {
          
          blackBoardHandler(s.getName(),
                            (FeatureInstance) HookAccessImpl.
                            getTransformationTrace(s), pp);
          pp.hasBlackboard = true;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getQueuingType()))
        {
          queueHandler(s.getName(),
                       (FeatureInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);

          pp.hasQueue = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getSamplingType()))
        {
          sampleHandler(s.getName(), (FeatureInstance) HookAccessImpl.
                        getTransformationTrace(s), pp);
          pp.hasSample = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getEventType()))
        {

          eventHandler(s.getName(), (ComponentInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);
          pp.hasEvent = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getBufferType()))
        {
          bufferHandler(s.getName(),
                        (FeatureInstance) HookAccessImpl.
                        getTransformationTrace(s), pp);
          pp.hasBuffer = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getSemaphoreType()))
        {
          pp.semaphoreNames.add(s.getName());
          pp.hasSemaphore = true;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
            .equalsIgnoreCase(getVirtualPortType()))
        {
          pp.virtualNames.add(s.getName());
          pp.hasVirtual = true;
        }
      }
    }
    
    for(QueueInfo qi : pp.queueInfo)
    {
      boolean found=false;
      for(FeatureInstance fi: qi.portList)
      {
        if(found)
          break;
        for(GlobalQueueInfo gqi: pp.globalQueueInfo)
        {
          if(gqi.component.equals(fi.getComponentInstance()))
          {
            qi.gQueue=gqi;
            found=true;
            break;
          }
        }
      }
    }
    
    for(QueueInfo qi : pp.bufferInfo)
    {
      boolean found=false;
      for(FeatureInstance fi: qi.portList)
      {
        if(found)
          break;
        for(GlobalQueueInfo gqi: pp.globalQueueInfo)
        {
          if(gqi.component.equals(fi.getComponentInstance()))
          {
            qi.gQueue=gqi;
            found=true;
            break;
          }
        }
      }
    }
  }


  private void globalQueueHandler(String name,
                                  ComponentInstance transformationTrace,
                                  ProcessProperties pp)
  {
    GlobalQueueInfo gqi = new GlobalQueueInfo();
    gqi.id=name;
    gqi.component = transformationTrace;
    
    pp.globalQueueInfo.add(gqi);
  }

  private void queueHandler(String id, FeatureInstance fi, ProcessProperties pp)
  {
    Port p = (Port) fi.getFeature() ;

    QueueInfo queueInfo = new QueueInfo() ;

    queueInfo.id = id;
    
    queueInfo.uniqueId = getFeatureLocalIdentifier(fi);
    queueInfo.direction = p.getDirection() ;

    ComponentInstance threadInstance = fi.getComponentInstance();
    List<FeatureInstance> threadInputPortsList = new ArrayList<FeatureInstance>();
    for(FeatureInstance iter: threadInstance.getFeatureInstances())
      if(iter.getDirection().equals(DirectionType.IN) &&
          (iter.getCategory().equals(FeatureCategory.EVENT_DATA_PORT) 
                                     || iter.getCategory().equals(FeatureCategory.EVENT_PORT)))
        threadInputPortsList.add(iter);
    
    queueInfo.threadPortId = threadInputPortsList.indexOf(fi);
    queueInfo.portList = new ArrayList<FeatureInstance>();
    queueInfo.portList.add(fi);
    List<ConnectionInstance> allConnectionInstances = new ArrayList<ConnectionInstance>();
    allConnectionInstances.addAll(fi.getSrcConnectionInstances());
    allConnectionInstances.addAll(fi.getDstConnectionInstances());
    for(ConnectionInstance ci: allConnectionInstances)
    {
      queueInfo.portList.add((FeatureInstance) ci.getSource());
      queueInfo.portList.add((FeatureInstance) ci.getDestination());
    }

    Long timeOut = PropertyUtils.getIntValue(fi, "Timeout");
    if(timeOut==null)
      timeOut=(long) 0;
    queueInfo.timeOut = timeOut;

    if(fi.getCategory() == FeatureCategory.EVENT_DATA_PORT)
    {
      EventDataPort port  = (EventDataPort) fi.getFeature() ;
      if(isUsedInFresh(fi))
        queueInfo.dataType=getGenerationIdentifier(pp.prefix)+port.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      else
      {
        String value = PropertyUtils.getStringValue(port.getDataFeatureClassifier(),
            "Source_Name") ;
        if(value != null)
        {
          queueInfo.dataType=value ;
        }
        else
        {
          queueInfo.dataType = getGenerationIdentifier(port.getDataFeatureClassifier().getQualifiedName()) ;
        }
      }
    }
    if(getQueueInfo(p, queueInfo))
    {
      pp.queueInfo.add(queueInfo) ;
    }
  }

  private void bufferHandler(String id, FeatureInstance fi, ProcessProperties pp)
  {
    QueueInfo queueInfo = new QueueInfo() ;

    queueInfo.id = id;
    queueInfo.uniqueId = getFeatureLocalIdentifier(fi);
    
    ComponentInstance threadInstance = fi.getComponentInstance();
    List<FeatureInstance> threadInputPortsList = new ArrayList<FeatureInstance>();
    for(FeatureInstance iter: threadInstance.getFeatureInstances())
      if(iter.getDirection().equals(DirectionType.IN) &&
          (iter.getCategory().equals(FeatureCategory.EVENT_DATA_PORT) 
                                     || iter.getCategory().equals(FeatureCategory.EVENT_PORT)))
        threadInputPortsList.add(iter);
    
    queueInfo.threadPortId = threadInputPortsList.indexOf(fi);
    
    queueInfo.portList = new ArrayList<FeatureInstance>();
    queueInfo.portList.add(fi);
    List<ConnectionInstance> allConnectionInstances = new ArrayList<ConnectionInstance>();
    allConnectionInstances.addAll(fi.getSrcConnectionInstances());
    allConnectionInstances.addAll(fi.getDstConnectionInstances());
    for(ConnectionInstance ci: allConnectionInstances)
    {
      queueInfo.portList.add((FeatureInstance) ci.getSource());
      queueInfo.portList.add((FeatureInstance) ci.getDestination());
    }
    Long timeOut = PropertyUtils.getIntValue(fi, "Timeout");
    if(timeOut==null)
      timeOut=(long) 0;
    queueInfo.timeOut = timeOut;
    if(fi.getCategory() == FeatureCategory.EVENT_DATA_PORT)
    {
      EventDataPort port  = (EventDataPort) fi.getFeature() ;
      if(isUsedInFresh(fi))
        queueInfo.dataType=getGenerationIdentifier(pp.prefix)+port.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      else
      {
        String value = PropertyUtils.getStringValue(port.getDataFeatureClassifier(),
            "Source_Name") ;
        if(value != null)
        {
          queueInfo.dataType=value ;
        }
        else
        {
          queueInfo.dataType = getGenerationIdentifier(port.getDataFeatureClassifier().getQualifiedName()) ;
        }
      }
    }
    else if(fi.getCategory() == FeatureCategory.EVENT_PORT)
    {
      queueInfo.dataType="int";
    }


    if(getQueueInfo((Port)fi.getFeature(), queueInfo))
    {
      pp.bufferInfo.add(queueInfo) ;
    }
    else
    {
      queueInfo.type = "FIFO";
      queueInfo.size = 10;
      pp.bufferInfo.add(queueInfo) ;
    }

  }

  // Return false QueueInfo object is not completed.
  private boolean getQueueInfo(Port port, QueueInfo info)
  {
    boolean result = true ;

    // XXX temporary. Until ATL transformation modifications.
    //  info.id = RoutingProperties.getFeatureLocalIdentifier(fi) ;

    if(info.type == null)
    {
      String value = PropertyUtils.getEnumValue(port, "Queue_Processing_Protocol") ;
      if(value != null)
      {
        info.type = value ;
      }
      else
      {
        result = false ;
      }
    }

    if(info.size == -1)
    {
      Long value = PropertyUtils.getIntValue(port, "Queue_Size") ;
      if(value != null)
      {
        info.size = value ;
      }
      else
      {
        result = false ;
      }
    }

    return result ;
  }

  private void eventHandler(String id, ComponentInstance ci, ProcessProperties pp)
  {
    EventInfo eventInfo = new EventInfo();
    eventInfo.id = id;
    eventInfo.component= ci;
    pp.eventInfo.add(eventInfo);
  }

  private void sampleHandler(String id, FeatureInstance fi, ProcessProperties pp)
  {
    Port p = (Port) fi.getFeature() ;

    SampleInfo sampleInfo = new SampleInfo() ;
    sampleInfo.direction = p.getDirection() ;

    if(fi.getCategory() == FeatureCategory.DATA_PORT)
    {
      DataPort port  = (DataPort) fi.getFeature() ;
      if(isUsedInFresh(fi))
      {
        sampleInfo.dataType=getGenerationIdentifier(pp.prefix)+port.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      }
      else
      {
        String value = PropertyUtils.getStringValue(port.getDataFeatureClassifier(),
            "Source_Name") ;
        if(value != null)
        {
          sampleInfo.dataType=value ;
        }
        else
        {
          sampleInfo.dataType = getGenerationIdentifier(port.getDataFeatureClassifier().getQualifiedName()) ;
        }
      }
    }

    sampleInfo.id = id;
    sampleInfo.uniqueId = getFeatureLocalIdentifier(fi);

    if(getSampleInfo(p, sampleInfo))
    {
      pp.sampleInfo.add(sampleInfo) ;
    }
  }

  private boolean getSampleInfo(Port port, SampleInfo info)
  {
    boolean result = true ;

    // XXX temporary. Until ATL transformation modifications.
    //  info.id = RoutingProperties.getFeatureLocalIdentifier(fi) ;

    if(info.refresh == -1)
    {
      Long value = PropertyUtils.getIntValue(port,
          "Sampling_Refresh_Period") ;
      if(value != null)
      {
        info.refresh = value ;
      }
      else
      {
        String msg =  "set default Sampling_Refresh_Period value for sampling port \'" +
            port.getQualifiedName() + "\'" ;
        _LOGGER.warn(msg);
        ServiceProvider.SYS_ERR_REP.warning(msg, true);

        info.refresh = 10l;
        //TODO: restore and resolve issue with pingpong-ba result = false ;
      }
    }

    return result ;
  }

  private void blackBoardHandler(String id, FeatureInstance fi, ProcessProperties pp)
  {

    BlackBoardInfo blackboardInfo = new BlackBoardInfo() ;
    blackboardInfo.id = id;

    if(fi.getCategory() == FeatureCategory.DATA_PORT)
    {
      DataPort p  = (DataPort) fi.getFeature() ;
      if(isUsedInFresh(fi))
        blackboardInfo.dataType=getGenerationIdentifier(pp.prefix)+p.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      else
      {
        String value = PropertyUtils.getStringValue(p.getDataFeatureClassifier(),
            "Source_Name") ;
        if(value != null)
        {
          blackboardInfo.dataType=value ;
        }
        else
        {
          blackboardInfo.dataType = getGenerationIdentifier(p.getDataFeatureClassifier().getQualifiedName()) ;
        }
      }
    }
    pp.blackboardInfo.add(blackboardInfo); 

  }

  private BehaviorAnnex getBa(FeatureInstance fi)
  {
    ComponentInstance ci = (ComponentInstance) fi.eContainer() ;
    BehaviorAnnex ba = null ;
    for(AnnexSubclause as : ci.getSubcomponent().getClassifier()
        .getOwnedAnnexSubclauses())
    {
      if(as.getName().equalsIgnoreCase("behavior_specification"))
      {
        if(as instanceof BehaviorAnnex)
        {
          ba = (BehaviorAnnex) as ;
          break ;
        }
        else if(as instanceof DefaultAnnexSubclause)
        {
          DefaultAnnexSubclause das = (DefaultAnnexSubclause) as ;
          ba = (BehaviorAnnex) das.getParsedAnnexSubclause();
          break;
        }
      }
    }
    return ba ;
  }

  private boolean isUsedInFresh(FeatureInstance fi)
  {
    if(fi.getComponentInstance().getCategory() == ComponentCategory.PROCESS)
    {
      ComponentInstance process = fi.getComponentInstance() ;
      for(ComponentInstance thread : process.getComponentInstances())
      {
        if(!thread.getCategory().equals(ComponentCategory.THREAD))
          continue ;
        for(FeatureInstance threadFeature : thread.getFeatureInstances())
        {
          if(threadFeature.getDirection() == DirectionType.IN)
          {
            for(ConnectionInstance cnxInst : threadFeature
                .getDstConnectionInstances())
            {
              int last = cnxInst.getConnectionReferences().size() - 1 ;
              if(cnxInst.getConnectionReferences().get(last).getSource() == fi)
              {
                if(isUsedInFresh((FeatureInstance) cnxInst
                                 .getConnectionReferences().get(last).getDestination()))
                  return true ;
              }
            }
          }
          if(threadFeature.getDirection() == DirectionType.OUT)
          {
            for(ConnectionInstance cnxInst : threadFeature
                .getSrcConnectionInstances())
            {
              if(cnxInst.getConnectionReferences().get(0).getDestination() == fi)
              {
                if(isUsedInFresh((FeatureInstance) cnxInst
                                 .getConnectionReferences().get(0).getSource()))
                  return true ;
              }
            }
          }
        }
      }
    }
    if(fi.getComponentInstance().getCategory() == ComponentCategory.THREAD)
    {
      Port p = (Port) fi.getFeature() ;
      BehaviorAnnex ba = getBa(fi) ;
      if(ba != null)
      {
        if(AadlBaVisitors.isFresh(ba, p))
          return true ;
        for(ConnectionInstance cnxi : fi.getSrcConnectionInstances())
        {
          if(cnxi.getSource() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getSource() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }
          if(cnxi.getDestination() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getDestination() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }

        }
        for(ConnectionInstance cnxi : fi.getDstConnectionInstances())
        {
          if(cnxi.getSource() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getSource() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }
          if(cnxi.getDestination() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getDestination() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }
        }
      }
    }
    return false ;
  }

  protected void genSendOutputImpl(ComponentInstance processInstance,
                                   UnparseText mainImplCode,
                                   UnparseText mainHeaderCode,
                                   ProcessProperties pp)
  {

    List<FeatureInstance> featureInstances = new ArrayList<FeatureInstance>();
    for(ComponentInstance ci: processInstance.getComponentInstances())
    {
      if(ci.getCategory().equals(ComponentCategory.THREAD))
      {
        for(FeatureInstance fi: ci.getFeatureInstances())
        {
          if(fi.getFeature() instanceof Port
              && ((Port)fi.getFeature()).getDirection().equals(DirectionType.OUT))
            featureInstances.add(fi);
        }
      }
    }

    mainHeaderCode.addOutputNewline("void __aadl_send_output (unsigned int port_variable, void * value);");
    
    sendOutputVariableAccess(processInstance, mainImplCode, pp);
    
    mainImplCode.addOutputNewline("void __aadl_send_output (unsigned int port_variable, void * value)") ;
    mainImplCode.addOutputNewline("{") ;
    mainImplCode.incrementIndent();
    
    sendOutputPrologue(processInstance, mainImplCode, pp);

    mainImplCode.addOutputNewline("switch (port_variable) {");
    mainImplCode.incrementIndent();

    int i = 0;
    for(FeatureInstance fi: featureInstances)
    {
      mainImplCode.addOutputNewline("case "+ i +":");
      mainImplCode.incrementIndent();
      QueueInfo info=null;
      for(QueueInfo bi: pp.bufferInfo)
      {
        if(bi.portList.contains(fi))
        {
          info=bi;
          sendOutputBuffer(mainImplCode, info);
        }
      }
      for(EventInfo eventInfo : pp.eventInfo)
      {
        for(ConnectionInstance ci: fi.getSrcConnectionInstances())
          if(eventInfo.component.equals(ci.getDestination().getComponentInstance()))
            sendOutputEvent(mainImplCode, eventInfo);
      }
      for(QueueInfo qi: pp.queueInfo)
      {
        if(qi.portList.contains(fi))
        {
          info=qi;
          sendOutputQueueing(mainImplCode, info);
        }
      }

      mainImplCode.addOutputNewline("break;");
      mainImplCode.decrementIndent();
      i++;
    }

    mainImplCode.decrementIndent();
    mainImplCode.addOutputNewline("}") ;
    mainImplCode.decrementIndent();
    mainImplCode.addOutputNewline("}") ;

  }

}
