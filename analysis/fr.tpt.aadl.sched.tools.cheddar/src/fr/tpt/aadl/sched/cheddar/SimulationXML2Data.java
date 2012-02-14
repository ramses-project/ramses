package fr.tpt.aadl.sched.cheddar ;

import java.util.StringTokenizer ;

import org.w3c.dom.Document ;
import org.w3c.dom.Element ;
import org.w3c.dom.Node ;
import org.w3c.dom.NodeList ;

import fr.tpt.aadl.sched.cheddar.events.SimulationData ;
import fr.tpt.aadl.sched.cheddar.events.TimelineData ;
import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.model.CheddarProcessor ;
import fr.tpt.aadl.sched.cheddar.model.CheddarTask ;

public class SimulationXML2Data
{

  /** Simulation file path. */
  private final Document simulationXML ;

  /** Cheddar model. */
  private final CheddarModel inputModel ;

  private SimulationData sim ;

  private int simulationPeriod ;

  public SimulationXML2Data(
                            CheddarModel inputModel, Document simulationXML)
  {
    this.simulationXML = simulationXML ;
    this.inputModel = inputModel ;
  }

  public void execute()
        throws Exception
  {
    CheddarContext ctxt =
          CheddarContext.getContextFor(inputModel.getAADLModel()) ;
    simulationPeriod = ctxt.getSimulationPeriod(inputModel) ;
    sim =
          new SimulationData(ctxt.getTimeEventsInterpreterFactory(),
                simulationPeriod) ;
    parseXML() ;
  }

  public SimulationData getSimulation()
        throws Exception
  {
    if(sim == null)
    {
      execute() ;
    }

    return sim ;
  }

  private void parseXML()
  {
    final Element root = simulationXML.getDocumentElement() ;
    NodeList children = root.getChildNodes() ;

    for(int index = 0 ; index < children.getLength() ; index++)
    {
      Node nodeCPU = children.item(index) ;

      if(nodeCPU.getNodeName().equals("processor"))
      {
        /** Name balise. */
        String cpuName = parseXMLCpuName(nodeCPU) ;
        CheddarProcessor cpu = inputModel.getProcessor(cpuName) ;
        TimelineData events = sim.getSimulationInterpreterFor(cpu) ;
        parseXMLCpuExecution(events, nodeCPU, cpuName) ;
      }
    }
  }

  private static String parseXMLCpuName(Node nodeCPU)
  {
    NodeList children = nodeCPU.getChildNodes() ;

    for(int index = 0 ; index < children.getLength() ; index++)
    {
      Node infoCPU = children.item(index) ;
      String infoType = infoCPU.getNodeName() ;

      if(infoType.equals("name"))
      {
        return infoCPU.getTextContent().trim() ;
      }
    }

    return null ;
  }

  private void parseXMLCpuExecution(TimelineData cpuEvents,
                                    Node nodeCPU,
                                    String cpuName)
  {
    NodeList children = nodeCPU.getChildNodes() ;

    for(int index = 0 ; index < children.getLength() ; index++)
    {
      Node infoCPU = children.item(index) ;
      String infoType = infoCPU.getNodeName() ;
      String infoValue = infoCPU.getTextContent() ;

      if((infoType.equals("#text")) || (infoType.equals("name")))
      {
        continue ;
      }

      StringTokenizer tok = new StringTokenizer(infoValue, " ") ;
      int date = Integer.parseInt(tok.nextToken()) ;
      String taskName = tok.nextToken() ;
      CheddarTask task = inputModel.getTask(taskName, cpuName) ;

      if(infoType.equals("task_activation") && (date < simulationPeriod))
      {
        cpuEvents.addTaskActivation(task, date) ;
      }
      else if(infoType.equals("start_of_task_capacity"))
      {
        cpuEvents.setTaskExecutionStart(task, date) ;
      }
      else if(infoType.equals("end_of_task_capacity"))
      {
        cpuEvents.setTaskExecutionEnd(task, date) ;
      }
      else if(infoType.equals("running_task"))
      {
        cpuEvents.setTaskIsRunning(task, date) ;
      }
    }
  }
}
