package fr.tpt.aadl.ramses.generation.osek.c;

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.LinkedHashMap ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AccessCategory ;
import org.osate.aadl2.AccessConnection ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ConnectedElement ;
import org.osate.aadl2.Connection ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DeviceSubcomponent ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.ThreadType ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.FileUtils ;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generation.osek.ast.Alarm ;
import fr.tpt.aadl.ramses.generation.osek.ast.Alarm.Action ;
import fr.tpt.aadl.ramses.generation.osek.ast.Counter ;
import fr.tpt.aadl.ramses.generation.osek.ast.Cpu ;
import fr.tpt.aadl.ramses.generation.osek.ast.Cpu.PeriodicTask ;
import fr.tpt.aadl.ramses.generation.osek.ast.Hook ;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL ;
import fr.tpt.aadl.ramses.generation.osek.ast.Os ;
import fr.tpt.aadl.ramses.generation.osek.ast.Os.Status ;
import fr.tpt.aadl.ramses.generation.osek.ast.Subprogram ;
import fr.tpt.aadl.ramses.generation.osek.ast.Task ;
import fr.tpt.aadl.ramses.generation.osek.ast.Task.Schedule ;
import fr.tpt.aadl.ramses.generation.utils.AadlToXUnparser ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.GlobalQueueInfo ;
import fr.tpt.aadl.ramses.generation.utils.ProcessProperties ;
import fr.tpt.aadl.ramses.generation.utils.RoutingProperties ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.EventInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.QueueInfo ;

/**
 * Unparser to generate an oil file for OSEK from aadl.
 */
public class AadlToOSEKNxtCUnparser extends AadlToXUnparser implements AadlTargetUnparser {

	
	private static String DATA_PORT_TYPE = "DataPortType";
	private static String EVENTDATA_PORT_TYPE = "ThreadQueueType";
	private final static String MAIN_APP_MODE = "std";

	/**
	 * Variable OIL
	 */
	private final static String OIL_VERSION = "2.5";

	/**
	 * Counter
	 */
	private final static String COUNTER_NAME = "SystemCounter";

	/**
	 * Thread
	 */
	private final static int THREAD_ACTIVATION = 1;
	private final static Long THREAD_STACKSIZE = 512l;
	
	/**
	 * OIL AST
	 */
	private OIL oil;

	/**
	 * Buffer for OIL generation
	 */
	private UnparseText _oilCode;

	/**
	 * Buffer for C code generation that interfaces with code generated
	 * from oil files.
	 */
	private UnparseText _mainCCode;
	private UnparseText _mainHCode;
	private File _generatedCodeDirectory;
	private Hook _startupHook;
	private Hook _shutdownHook;


	private Map<DataAccess, String> dataAccessMapping = new LinkedHashMap<DataAccess, String>();

	private static Logger _LOGGER = Logger.getLogger(AadlToOSEKNxtCUnparser.class) ;
	

	/**
	 * Methode appelée sur chaque noeud implémentant un système.
	 */
	@Override
	public TargetProperties process(SystemImplementation si,
	                                File runtimePath,
	                                File outputDir,
	                                IProgressMonitor monitor)
	                                      throws GenerationException
	{
	  oil = new OIL();
	  oil.setVersion(OIL_VERSION);
	  _generatedCodeDirectory = outputDir;
    _oilCode = new UnparseText();
    _mainCCode = new UnparseText();
    _mainHCode = new UnparseText();
    _startupHook = new Hook();
    _shutdownHook = new Hook();

		return new RoutingProperties();
	}

	/**
	 * Generate the OIL/C code for a processor
	 * 
	 * @param processor
	 *            L'AST du processeur.
	 */
	private void genCpu(ProcessSubcomponent ps) {

		Cpu cpu = oil.getCpu();
		Os os = cpu.getOs();
		_mainHCode.addOutputNewline("#include \"kernel.h\"");

		/* Generate code for threads process */
		ProcessImplementation pi = (ProcessImplementation) ps.getComponentImplementation();
		cpu.addAllDataSubcomponent(pi.getOwnedDataSubcomponents());
		buildDataAccessMapping(pi, dataAccessMapping) ;
		
		EList<ThreadSubcomponent> subcomponents = pi.getOwnedThreadSubcomponents();

		_mainCCode.addOutputNewline("/*********** Tasks ***********/");
		for (ThreadSubcomponent threadSubcomponent : subcomponents) {
		  genTask(ps, threadSubcomponent, COUNTER_NAME);
		  genCTask(ps, threadSubcomponent);
		}

		/* Generate code for OS */

		/*
		 * If one data contains Concurrency_Control_Protocol at
		 * Priority_Ceiling STATUS => EXTENDED
		 */
		if (os.getStatus() == Status.STANDARD) {
		  ProcessImplementation processImpl = (ProcessImplementation) ps.getComponentImplementation();

		  EList<Subcomponent> subcmpts = processImpl.getAllSubcomponents();

      for(Subcomponent s : subcmpts)
      {
        if(s instanceof DataSubcomponent)
        {
          String value = PropertyUtils.getEnumValue(s,
                                              "Concurrency_Control_Protocol") ;
          if(value != null)
          {
            if(value.equals("Priority_Ceiling"))
            {
              os.setStatus(Status.EXTENDED) ;
              break ;
            }
          }
          else
          {
            String errMsg = "cannot fetch Concurrency_Control_Protocol for \'" +
                                                                     s.getName() + '\'' ;
            _LOGGER.error(errMsg) ;
            ServiceProvider.SYS_ERR_REP.error(errMsg, true) ;
          }
        }
      }
		}
		cpu.setAppmode(MAIN_APP_MODE);
		cpu.setName(ps.getName());
		genOsConfig(ps);
	}

	/**
	 * Configuration de l'OS
	 * 
	 * @param processSubcomponent
	 */
	private void genOsConfig(ProcessSubcomponent processSubcomponent) {

		/* C Data declaration */
		Os os = oil.getCpu().getOs();
		os.setName("config");
		os.setAppName(processSubcomponent.getName());
		
		_mainCCode.addOutputNewline("/*********** Data ***********/");
		ProcessImplementation pi = (ProcessImplementation) processSubcomponent.getComponentImplementation();
		for(DataSubcomponent ds: pi.getOwnedDataSubcomponents())
		{
		  if(ds.getSubcomponentType().getName().equalsIgnoreCase(EVENTDATA_PORT_TYPE)
				  || ds.getSubcomponentType().getName().equalsIgnoreCase(DATA_PORT_TYPE))
		  {
			  _mainHCode.addOutputNewline("DeclareResource("+ds.getName()+"_rez);");
//			  _mainHCode.addOutputNewline("extern const ResourceType "+ds.getName()+"_rez;");
		  }
		  if(ds.getSubcomponentType().getName().equalsIgnoreCase(EVENTDATA_PORT_TYPE))
		  {
			  _mainHCode.addOutputNewline("DeclareEvent("+ds.getName()+"_evt);");
//			  _mainHCode.addOutputNewline("extern const EventMaskType "+ds.getName()+"_evt;");
		  }
		}

		_mainCCode.addOutputNewline("");
	}

	/**
	 * Génération des counters de l'OIL.
	 */
	private void genCounters(ProcessorSubcomponent processor) {

		Counter counter = oil.getCpu().getCounter();
		
		Long maxValue = PropertyUtils.getIntValue(processor, "SystemCounter_MaxAllowedValue") ;
		Long ticksPerBase = PropertyUtils.getIntValue(processor, "SystemCounter_TicksPerBase");
		Long minCycle = PropertyUtils.getIntValue(processor, "SystemCounter_MinCycle");
		
		if(maxValue == null || ticksPerBase == null || minCycle == null)
		{
		  String what = "";
		  if(maxValue == null)
		  {
		    what = "SystemCounter_MaxAllowedValue" ;
		    maxValue = -1l ;
		  }
		  
		  if(ticksPerBase == null)
		  {
		    what += " SystemCounter_TicksPerBase" ;
		    ticksPerBase = -1l ;
		  }
		  
		  if(minCycle == null)
		  {
		    what += " SystemCounter_MinCycle" ;
		    minCycle = -1l ;
		  }
		  
		  String errMsg = "cannot fetch " + what + " for \'" + processor.getName() + '\'';
		  _LOGGER.error(errMsg);
		  ServiceProvider.SYS_ERR_REP.error(errMsg, true);
		}
		  
		counter.setName(processor.getName()+"_"+COUNTER_NAME);
		counter.setMaxAllowedValue(maxValue.intValue());
		counter.setTicksPerBase(ticksPerBase.intValue());
		counter.setMinCycle(minCycle.intValue());
	}
	
	/**
	 * Génération du code OIL d'un thread.
	 * 
	 * @param ps
	 *            Le processeur conteannt les threads.
	 * @param thread
	 *            L'AST du thread.
	 * @param counterName
	 *            Le nom du compteur sur lequel la tâche se synchronise
	 */
	private void genTask(ProcessSubcomponent ps, ThreadSubcomponent thread, String counterName) {

		final Cpu cpu = oil.getCpu();
		final Counter counter = cpu.getCounter();
		final Os os = cpu.getOs();

		/*
		 * If one thread/device contains Initialize_Entrypoint STARTUPHOOK =
		 * true
		 */
		if (os.getStartupHook() == false) {
			if (PropertyUtils.findProperty("Initialize_Entrypoint", thread) != null)
				os.setStartupHook(true);
		}

		/*
		 * If one thread/device contains Finalize_Entrypoint SHUTDOWNHOOK = true
		 */
		if (os.getShutdownHook() == false) {
			if (PropertyUtils.findProperty("Finalize_Entrypoint", thread) != null)
				os.setShutdownHook(true);
		}

		/* Begin task */

		Task task = new Task();
		Schedule schedule;
		Long stackSize = PropertyUtils.getIntValue(thread, "Stack_Size");
		Long priority = PropertyUtils.getIntValue(thread, "Priority");
		
		if(priority == null)
    {
		  String errMsg =  "cannot fetch Priority for \'" + thread.getName() + '\'' ;
	    _LOGGER.error(errMsg);
	    ServiceProvider.SYS_ERR_REP.error(errMsg, true);
      priority = -1l ;
    }
		
		if(stackSize == null)
		{
		  stackSize = THREAD_STACKSIZE;
		  String msg =  "set default stack size for \'" + thread.getName() + '\'' ;
      _LOGGER.warn(msg);
      ServiceProvider.SYS_ERR_REP.warning(msg, true);
		}
		
		Boolean scheduler = PropertyUtils.getBooleanValue(ps, "Preemptive_Scheduler") ;
		if(scheduler == null)
		{
		  schedule = Schedule.FULL ;
		  String msg =  "set default scheduler for \'" + thread.getName() + '\'' ;
      _LOGGER.warn(msg);
      ServiceProvider.SYS_ERR_REP.warning(msg, true);
		}
		else
		{
		  if(scheduler)
        schedule = Schedule.FULL ;
      else
        schedule = Schedule.NON ;
		}

		task.setName(thread.getName());
		task.setPriority(priority.intValue());
		task.setActivation(THREAD_ACTIVATION);

		task.setSchedule(schedule);
		task.setStacksize(stackSize.intValue());
		
		ThreadImplementation ti = (ThreadImplementation) thread.getSubcomponentType();
		ThreadType tt = (ThreadType) ti.getType();
		for(DataAccess da: this.dataAccessMapping.keySet())
		{
      for(DataAccess tda : tt.getOwnedDataAccesses())
      {
        if(tda.equals(da))
        {
          task.addResource(this.dataAccessMapping.get(tda)) ;
          if(da.getDataFeatureClassifier().getName()
                .equalsIgnoreCase(EVENTDATA_PORT_TYPE))
            task.addEvent(this.dataAccessMapping.get(da)) ;
        }
      }
		}
		
		/* End task */

		/*
		 * Generate alarme associated to periodic tasks
		 */
		{
			String dispatchProtocol = PropertyUtils.getEnumValue(thread, "Dispatch_Protocol");

			if ("Periodic".equals(dispatchProtocol)) {

				/* Begin Alarm */

				Long period = PropertyUtils.getIntValue(thread, "Period");
				if(period == null)
				{
				  String errMsg =  "cannot fetch Period for " + thread.getName() ;
				  _LOGGER.error(errMsg);
				  ServiceProvider.SYS_ERR_REP.error(errMsg, true);
				  period = -1l ;
				}
				
				int alarmTime=0;
				try{
					alarmTime = 1;
				} catch(Exception exc)
				{
				}
				Alarm alarm = new Alarm(counter, task, cpu);

				alarm.setName("wakeUp" + thread.getName());
				alarm.setAction(Action.ACTIVATETASK);
				alarm.setAutostart(true);
				alarm.setAlarmTime(alarmTime);
				alarm.setCycleTime(period.intValue());

				task.setAutostart(false);

				cpu.addPeriodicTask(new PeriodicTask(task, alarm));
				/* End Alarm */
			} else {
				task.setAutostart(true);
				cpu.addTask(task);
			}
		}
	}

	/**
	 * Méthode appelée après le parcours de l'AST via les methodes process.
	 */
	public void close() {

	  String msg = "Hooks generation" ;
    _LOGGER.trace(msg);
		
		_mainCCode.addOutputNewline("void StartupHook(void)");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();
		for (Subprogram subprogram : _startupHook.getCalls()) {
		  _mainCCode.addOutput(subprogram.getName());
		  _mainCCode.addOutput("(");
			
			for(String parameter: subprogram.getParameters())
			  _mainCCode.addOutput(parameter);
			
			_mainCCode.addOutputNewline(");");
		}
		_mainCCode.decrementIndent();
		_mainCCode.addOutputNewline("}");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutputNewline("void ShutdownHook(StatusType ercd)");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();
		for (Subprogram subprogram : _shutdownHook.getCalls()) {
			_mainCCode.addOutput(subprogram.getName());
			_mainCCode.addOutput("(");
			
			for(String parameter: subprogram.getParameters())
				_mainCCode.addOutput(parameter);
			
			_mainCCode.addOutputNewline(");");
		}
		_mainCCode.decrementIndent();
		_mainCCode.addOutputNewline("}");
		_mainCCode.addOutputNewline("");
		
		_mainHCode.addOutputNewline("DeclareCounter("+oil.getCpu().getCounter().getName()+");");
		_mainCCode.addOutputNewline("");
		
		/* LEJOS OSEK hook to be invoked from an ISR in category 2 */
		_mainCCode.addOutputNewline("void user_1ms_isr_type2(void)");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();
		_mainCCode.addOutputNewline("StatusType ercd;");
		

		_mainCCode.addOutputNewline("ercd = SignalCounter("+oil.getCpu().getCounter().getName()+"); /* Increment OSEK Alarm Counter */"); 
		_mainCCode.addOutputNewline("if(ercd != E_OK)");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();
		_mainCCode.addOutputNewline("ShutdownOS(ercd);");
		_mainCCode.addOutputNewline("}");
		_mainCCode.incrementIndent();
		_mainCCode.addOutputNewline("}");
		_mainCCode.incrementIndent();
		
		// Generate OIL
		oil.generateOil(_oilCode);

		_mainHCode.addOutputNewline("#include \"gtypes.h\"");
		_mainHCode.addOutputNewline("#endif");
	}

	private void genCTask(ProcessSubcomponent ps, ThreadSubcomponent thread) {
		String threadName = thread.getComponentImplementation().getQualifiedName();
		threadName = GenerationUtilsC.getGenerationCIdentifier(threadName);
		_mainCCode.addOutputNewline("/*** Task " + threadName + " ***/");
		_mainCCode.addOutputNewline("extern void *" + threadName + "_Job(void);");
		_mainCCode.addOutputNewline("");

		_mainHCode.addOutputNewline("DeclareTask(" + thread.getName() + ");");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutputNewline("TASK(" + thread.getName() + ")");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();

		_mainCCode.addOutputNewline(threadName + "_Job();");

		_mainCCode.decrementIndent();
		_mainCCode.addOutputNewline("}");
		_mainCCode.addOutputNewline("");
	}

	// XXX: Just implemented to respect the interface definition, but they are
	// not used in case of OSEK
	@Override
	public void process(ProcessorSubcomponent processor,
	                    TargetProperties tarProp,
	                    File runtimePath,
                      File outputDir,
                      IProgressMonitor monitor)
	                                                		throws GenerationException
  {
		genCounters(processor);
	}

	@Override
	public void process(ProcessSubcomponent process,
	                    TargetProperties tarProp,
	                    File runtimePath,
                      File outputDir,
                      IProgressMonitor monitor)
	{
    // Generate main.h
    genMainHeader() ;
    
    // Generate main.c
    genMainImpl(process) ;
    
    close();
    
    try
    {
      FileUtils.saveFile(outputDir, "main.h",
               _mainHCode.getParseOutput()) ;
      
      FileUtils.saveFile(outputDir, "main.c",
               _mainCCode.getParseOutput()) ;
      
      FileUtils.saveFile(outputDir, process.getName() + ".oil",
                         _oilCode.getParseOutput()) ;
    }
    catch(IOException e)
    {
      String errMsg = "cannot save the generated files" ;
      _LOGGER.fatal(errMsg, e) ;
      throw new RuntimeException(errMsg, e) ;
    }
	}

	private void genMainHeader()
  {
    String guard = GenerationUtilsC.generateHeaderInclusionGuard("main.h") ;
    _mainHCode.addOutputNewline(guard) ;
  }
	
	private void genMainImpl(ProcessSubcomponent process)
	{
	  _mainCCode.addOutputNewline("#include \"main.h\"");
	  genCpu(process);
	  
	  StringBuilder sb = new StringBuilder(process.getQualifiedName());
    ProcessProperties pp = new ProcessProperties(sb.substring(0, sb.lastIndexOf("::")+2)) ;
    
    ProcessImplementation processImpl = (ProcessImplementation) 
        process.getComponentImplementation() ;
    
    this.findCommunicationMechanism(processImpl, pp);
    
    ComponentInstance processInstance = (ComponentInstance) HookAccessImpl.getTransformationTrace(process);
    
    genSendOutputImpl(processInstance, _mainCCode, _mainHCode, pp);
	  
	}
	
	
	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		// TODO Do NOT Use
	}
	
	  //Builds the data access mapping via the connections described in the
	  // process implementation.
  private void buildDataAccessMapping(ComponentImplementation cptImpl,
                                      Map<DataAccess, String> _dataAccessMapping)
  {
    EList<Subcomponent> subcmpts = cptImpl.getAllSubcomponents() ;

    List<String> dataSubcomponentNames = new ArrayList<String>() ;

    // Fetches data subcomponent names.
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent)
      {
        if(s.getSubcomponentType().getName()
              .equalsIgnoreCase(EVENTDATA_PORT_TYPE) ||
              s.getSubcomponentType().getName()
                    .equalsIgnoreCase(DATA_PORT_TYPE))
        {
          dataSubcomponentNames.add(s.getName()) ;
        }
      }
    }

    // Binds data subcomponent names with DataAcess objects
    // of threads.
    // See process implementation's connections.
    for(Connection connect : cptImpl.getAllConnections())
    {
      if(connect instanceof AccessConnection &&
            ((AccessConnection) connect).getAccessCategory() == AccessCategory.DATA)
      {

        if(connect.getAllDestination() instanceof DataSubcomponent)
        {
          DataSubcomponent destination =
                (DataSubcomponent) connect.getAllDestination() ;

          if(Aadl2Utils.contains(destination.getName(), dataSubcomponentNames))
          {
            ConnectedElement source = (ConnectedElement) connect.getSource() ;
            DataAccess da = (DataAccess) source.getConnectionEnd() ;
            _dataAccessMapping.put(da, destination.getName()) ;
          }
        }
        else if(connect.getAllSource() instanceof DataSubcomponent)
        {
          DataSubcomponent source = (DataSubcomponent) connect.getAllSource() ;
          if(Aadl2Utils.contains(source.getName(), dataSubcomponentNames))
          {
            ConnectedElement dest = (ConnectedElement) connect.getDestination() ;

            DataAccess da = (DataAccess) dest.getConnectionEnd() ;
            _dataAccessMapping.put(da, source.getName()) ;
          }
        }
        else if(connect.getAllDestination() instanceof DataAccess &&
              connect.getAllSource() instanceof DataAccess)
        {
          if(!(connect.getAllDestination().eContainer() instanceof Thread) &&
                !(connect.getAllSource().eContainer() instanceof Thread))
            continue ;
          DataAccess destination = (DataAccess) connect.getAllDestination() ;
          DataAccess source = (DataAccess) connect.getAllSource() ;
          if(_dataAccessMapping.containsKey(destination) &&
                !_dataAccessMapping.containsKey(source))
            _dataAccessMapping.put(source, _dataAccessMapping.get(destination)) ;
          if(_dataAccessMapping.containsKey(source) &&
                !_dataAccessMapping.containsKey(destination))
            _dataAccessMapping.put(destination, _dataAccessMapping.get(source)) ;
        }
      }
    }
  }

  @Override
  protected String getBlackBoardType()
  {
    return "OSEK_runtime::DataPortType" ;
  }

  @Override
  protected String getBufferType()
  {
    return "OSEK_runtime::PortQueueType" ;
  }

  @Override
  protected String getEventType()
  {
    return null ;
  }

  @Override
  protected String getQueuingType()
  {
    // return null: queuing (ARINC terminology) does not exist on OSEK
    return null ;
  }

  @Override
  protected String getSamplingType()
  {
    // return null: sampling (ARINC terminology) does not exist on OSEK
    return null ;
  }

  @Override
  protected String getSemaphoreType()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  protected String getVirtualPortType()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  protected String getFeatureLocalIdentifier(FeatureInstance fi)
  {
    return GenerationUtilsC.getGenerationCIdentifier(fi.getComponentInstance().
                                                     getName()+"_"+fi.getName());
  }

  @Override
  protected String getGenerationIdentifier(String prefix)
  {
    return GenerationUtilsC.getGenerationCIdentifier(prefix);
  }

  @Override
  protected void sendOutputQueueing(UnparseText mainImplCode, QueueInfo info)
  {
    return;
  }

  @Override
  protected void sendOutputEvent(UnparseText mainImplCode, EventInfo info)
  {
    return;
  }

  @Override
  protected void sendOutputBuffer(UnparseText mainImplCode, QueueInfo info)
  {
    mainImplCode.addOutputNewline("ret = SendOutput_runtime(&" + info.gQueue.id +
                                  ", "+ info.threadPortId + ", value);");   
  }

  @Override
  protected void sendOutputPrologue(ComponentInstance processInstance,
                                    UnparseText mainImplCode,
                                    ProcessProperties pp)
  {
    mainImplCode.addOutputNewline("StatusType ret;");
  }

  @Override
  protected String getGlobalQueueType()
  {
    return "OSEK_runtime::ThreadQueueType" ;
  }

  @Override
  protected void sendOutputVariableAccess(ComponentInstance processInstance,
                                          UnparseText mainImplCode,
                                          ProcessProperties pp)
  {
    for(GlobalQueueInfo gqi: pp.globalQueueInfo)
    {
      mainImplCode.addOutputNewline("extern thread_queue_t "+ gqi.id+";");
    }

  }
}
