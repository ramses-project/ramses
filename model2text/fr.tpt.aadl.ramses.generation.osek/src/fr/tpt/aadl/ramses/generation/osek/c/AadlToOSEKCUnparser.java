package fr.tpt.aadl.ramses.generation.osek.c;

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DeviceSubcomponent ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.Port ;
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
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.FileUtils ;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generation.osek.Resources ;
import fr.tpt.aadl.ramses.generation.osek.ast.Alarm ;
import fr.tpt.aadl.ramses.generation.osek.ast.Alarm.Action ;
import fr.tpt.aadl.ramses.generation.osek.ast.Counter ;
import fr.tpt.aadl.ramses.generation.osek.ast.Cpu ;
import fr.tpt.aadl.ramses.generation.osek.ast.Cpu.PeriodicTask ;
import fr.tpt.aadl.ramses.generation.osek.ast.Hook ;
import fr.tpt.aadl.ramses.generation.osek.ast.Implementation ;
import fr.tpt.aadl.ramses.generation.osek.ast.ImplementationIsr ;
import fr.tpt.aadl.ramses.generation.osek.ast.ImplementationTask ;
import fr.tpt.aadl.ramses.generation.osek.ast.Isr ;
import fr.tpt.aadl.ramses.generation.osek.ast.Memmap ;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL ;
import fr.tpt.aadl.ramses.generation.osek.ast.Os ;
import fr.tpt.aadl.ramses.generation.osek.ast.Os.Status ;
import fr.tpt.aadl.ramses.generation.osek.ast.Subprogram ;
import fr.tpt.aadl.ramses.generation.osek.ast.Task ;
import fr.tpt.aadl.ramses.generation.osek.ast.Task.Schedule ;
import fr.tpt.aadl.ramses.generation.utils.AadlToXUnparser ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.EventInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.QueueInfo ;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;
import fr.tpt.aadl.ramses.generation.utils.ProcessProperties ;
import fr.tpt.aadl.ramses.generation.utils.RoutingProperties ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.* ;

/**
 * Unparser to generate an oil file for OSEK from aadl.
 */
public class AadlToOSEKCUnparser extends AadlToXUnparser implements AadlTargetUnparser {

	private final static String MAIN_APP_MODE = "std";

	/**
	 * Compilation config
	 */
//	private final static String compilationFile = "compilation.properties";

	/**
	 * OSEK
	 */
//	private final static String C_OSEK_RUNTIME = "osek_runtime.c";
//	private final static String H_OSEK_RUNTIME = "osek_runtime.h";

	/**
	 * Variable OIL
	 */
	private final static String OIL_VERSION = "2.5";

	/**
	 * Trampoline
	 */
	private final static String TRAMPOLINE_NAME = "trampoline";
	private final static int TRAMPOLINE_STACKSIZE = 500;
	private final static int TRAMPOLINE_PRIORITY = 1;
	private final static int ISR_STACKSIZE = 500;

	/**
	 * OS config
	 */
	private final static String OS_NAME = "config";
	private final static boolean OS_SYSTEM_CALL = true;
	private final static boolean MEMORY_PROTECTION = false;

	/**
	 * Counter
	 */
	private final static String COUNTER_NAME = "SystemCounter";

	/**
	 * Thread
	 */
	private final static int THREAD_ACTIVATION = 1;
	private final static long THREAD_STACKSIZE = 512l;
	
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

	/**
	 * Application resources for compilation 
	 */
	private Resources resources;
	
	 private static Logger _LOGGER = Logger.getLogger(AadlToOSEKCUnparser.class) ;

	public AadlToOSEKCUnparser(OIL oil) {
		this.oil = oil;
		oil.setVersion(OIL_VERSION);
	}

	/**
	 * Methode appelée sur chaque noeud implémentant un système.
	 */
	@Override
	public TargetProperties process(SystemImplementation si,
	                                File runtimePath,
	                                File outputDir,
	                                IProgressMonitor monitor) throws GenerationException {

	  _generatedCodeDirectory = outputDir;
    _oilCode = new UnparseText();
    _mainCCode = new UnparseText();
    _mainHCode = new UnparseText();
    _startupHook = new Hook();
    _shutdownHook = new Hook();
	  
	  _mainCCode.addOutputNewline("#include \"tpl_os.h\"");
	  _mainCCode.addOutputNewline("");
	  
		genDevice(si);
		genCounters(si);

		return new RoutingProperties();
	}

	/**
	 * Method call on subprogram implementation
	 */
	public void process(SubprogramType elt, File generatedFilePath)
  {
    //		Os os = oil.getCpu().getOs();
	  
	  String name = PropertyUtils.getStringValue(elt, "Source_Name") ;
    String port = PropertyUtils.getStringValue(elt, "nxtport") ;
    if(name == null || port == null)
    {
      String what = "";
      if(name == null)
      {
        what = "Source_Name";
      }
      
      if(port == null)
      {
        what += " nxtport" ;
      }
      
      String errMsg = "cannot fetch " + what + " for \'" + elt.getName() + '\'';
      _LOGGER.error(errMsg) ;
      ServiceProvider.SYS_ERR_REP.error(errMsg, true) ;
      return ;
    }
    else
    {
      Subprogram subprogram = new Subprogram() ;
      subprogram.setName(name) ;
      subprogram.addParameter(port) ;
      
      if(_startupHook.getReferences().contains(elt.getName()))
      {
        _startupHook.addSubrogram(subprogram) ;
      }
      else if(_shutdownHook.getReferences().contains(elt.getName()))
      {
        _shutdownHook.addSubrogram(subprogram) ;
      }
    }
  }

	private void genDevice(SystemImplementation si) {

		Os os = oil.getCpu().getOs();

		for (DeviceSubcomponent device : si.getOwnedDeviceSubcomponents())
		{
		  Classifier classifier = PropertyUtils.getClassifierValue(device, "Initialize_Entrypoint");
		  if(classifier != null)
			{
				/*
				 * If one thread/device contains Initialize_Entrypoint STARTUPHOOK = true
				 */
				os.setStartupHook(true);
				_startupHook.addReference(classifier.getName());
			}
		  else
			{
			  String errMsg =  "cannot fetch initialize entry point for \'" + device + '\'';
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
			}

		  classifier = PropertyUtils.getClassifierValue(device, "Finalize_Entrypoint");
			if(classifier != null)
		  {
				/*
				 * If one thread/device contains Finalize_Entrypoint SHUTDOWNHOOK = true
				 */
				os.setShutdownHook(true);
				_shutdownHook.addReference(classifier.getName());
			}
			else
			{
			  String errMsg =  "cannot fetch finalize entry point for \'" + device.getName() + '\'' ;
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
			}
		}
	}

	/**
	 * Generate the OIL file.
	 */
	private void genImplementation() {

		Implementation impl = oil.getImplementation();
		ImplementationTask task = impl.getTask();
		ImplementationIsr isr = impl.getIsr();

		impl.setName(TRAMPOLINE_NAME);

		task.setStackSize(TRAMPOLINE_STACKSIZE);
		task.setPriority(TRAMPOLINE_PRIORITY);

		isr.setStackSize(ISR_STACKSIZE);
	}

	/**
	 * Generate the OIL/C code for a processor
	 * 
	 * @param processor
	 *            L'AST du processeur.
	 * @throws GenerationException 
	 */
	private void genCpu(ProcessSubcomponent ps) {

		Cpu cpu = oil.getCpu();
		Os os = cpu.getOs();

		/* Generate code for threads process */
		ProcessImplementation pi = (ProcessImplementation) ps.getComponentImplementation();
		
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
                                                                     s.getName() +
                                                                     '\'' ;
            _LOGGER.error(errMsg) ;
            ServiceProvider.SYS_ERR_REP.error(errMsg, true) ;
          }
        }
      }
		}

		cpu.setName(ps.getName());
		genOsConfig(ps);

		List<String> modeIdList = new ArrayList<String>();
		modeIdList.add(MAIN_APP_MODE);
		cpu.setAppmode(modeIdList);

	}

	/**
	 * Configuration de l'OS
	 * 
	 * @param processSubcomponent
	 * @throws GenerationException 
	 */
	private void genOsConfig(ProcessSubcomponent processSubcomponent) {

		Os os = oil.getCpu().getOs();
		Memmap memmap = os.getMemmap();

		List<String> cFlags = resources.getValues("cpu.os.cflags");
		List<String> asFlags = resources.getValues("cpu.os.asflags");
		List<String> ldFlags = resources.getValues("cpu.os.ldflags");
		String compiler = resources.getValue("cpu.os.compiler");
		String assembler = resources.getValue("cpu.os.assembler");
		String linker = resources.getValue("cpu.os.linker");
		String memmapCompiler = resources.getValue("cpu.os.memmap.compiler");
		String memmapLinker = resources.getValue("cpu.os.memmap.linker");
		String memmapAssembler = resources.getValue("cpu.os.memmap.assembler");

		os.setName(OS_NAME);
		os.setAppName(processSubcomponent.getName());

		String trampolineBasePath = System.getenv().get("TRAMPOLINEPATH");
		if (trampolineBasePath != null)
			os.setTrampolineBasePath(trampolineBasePath);

		os.addAllCFlags(cFlags);
		os.addAllAsFlags(asFlags);
		os.addAllLdFlags(ldFlags);
		os.setCompiler(compiler);
		os.setAssembler(assembler);
		os.setLinker(linker);
		os.setSystemCall(OS_SYSTEM_CALL);
		

		memmap.setMemoryProtection(MEMORY_PROTECTION);
		memmap.setCompiler(memmapCompiler);
		memmap.setAssembler(memmapAssembler);
		memmap.setLinker(memmapLinker);

		/* C Data declaration */

		_mainCCode.addOutputNewline("/*********** Data ***********/");
		ProcessImplementation pi = (ProcessImplementation) processSubcomponent.getComponentImplementation();

		for (Subcomponent sc : pi.getAllSubcomponents()) {
			if (sc instanceof DataSubcomponent) {
				genCData((DataSubcomponent) sc);
			}
		}

		_mainCCode.addOutputNewline("");
	}

	/**
	 * Génération des counters de l'OIL.
	 */
	private void genCounters(SystemImplementation si) {

		Counter counter = oil.getCpu().getCounter();
		String source = PropertyUtils.getStringValue(si, "SystemCounter_Source");
		Long maxValue = PropertyUtils.getIntValue(si, "SystemCounter_MaxAllowedValue");
		Long ticksPerBase= PropertyUtils.getIntValue(si, "SystemCounter_TicksPerBase");
		Long minCycle= PropertyUtils.getIntValue(si, "SystemCounter_MinCycle");

		if(source == null || maxValue == null || ticksPerBase == null ||
		   minCycle == null)
		{
		  String what = "";
		  
		  if(source == null)
		  {
		    what = "SystemCounter_Source" ;
		  }
		  
		  if(maxValue == null)
		  {
		    what += " SystemCounter_MaxAllowedValue";
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
		  
		  String errMsg =  "cannot fetch " + what + " for \'" + si.getName() + '\'';
      _LOGGER.error(errMsg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
		}
		
    counter.setName(COUNTER_NAME) ;
    counter.setSource(source) ;
    counter.setMaxAllowedValue(maxValue.intValue()) ;
    counter.setTicksPerBase(ticksPerBase.intValue()) ;
    counter.setMinCycle(minCycle.intValue()) ;
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
			if (PropertyUtils.findPropertyAssociation("Initialize_Entrypoint", thread) != null)
				os.setStartupHook(true);
		}

		/*
		 * If one thread/device contains Finalize_Entrypoint SHUTDOWNHOOK = true
		 */
		if (os.getShutdownHook() == false) {
			if (PropertyUtils.findPropertyAssociation("Finalize_Entrypoint", thread) != null)
				os.setShutdownHook(true);
		}

		/* Begin task */

		Task task = new Task();
		Schedule schedule;
		
		Long priority = PropertyUtils.getIntValue(thread, "Priority");
		if(priority == null)
		{
		  String errMsg =  "cannot fetch Priority for \'" + thread.getName() + '\'';
      _LOGGER.error(errMsg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
      priority = -1l ;
		}

		Boolean scheduler = PropertyUtils.getBooleanValue(ps,"Preemptive_Scheduler") ;
		if(scheduler == null)
		{
		  schedule = Schedule.FULL ;
		  String msg =  "set the default scheduler value for \'" + thread.getName() + '\'' ;
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
		
		Long stackSize = PropertyUtils.getIntValue(thread, "Stack_Size");
		
		if(stackSize == null)
		{
		  stackSize = THREAD_STACKSIZE;
		  String msg =  "set the default Source_Stack_Size value for \'" + thread.getName() + '\'' ;
      _LOGGER.warn(msg);
      ServiceProvider.SYS_ERR_REP.warning(msg, true);
		}

		task.setName(thread.getName());
		task.setPriority(priority.intValue());
		task.setActivation(THREAD_ACTIVATION);

		task.setSchedule(schedule);
		task.setStacksize(stackSize.intValue());


		ThreadImplementation ti = (ThreadImplementation) thread.getSubcomponentType();
		
		for(SubprogramCallSequence scs: ti.getOwnedSubprogramCallSequences())
		{
		  for(SubprogramCall cs: scs.getOwnedSubprogramCalls())
		  {
		    if(cs instanceof SubprogramCall)
		    {
		      SubprogramCall sc = (SubprogramCall) cs;
		      if(sc.getCalledSubprogram() instanceof SubprogramType)
		        this.process((SubprogramType) sc.getCalledSubprogram(), _generatedCodeDirectory);
		    }
		  }
		}
		
		/* End task */

		/*
		 * Generate alarme associated to periodic tasks
		 */
		String dispatchProtocol = PropertyUtils.getEnumValue(thread, "Dispatch_Protocol");

    if ("Periodic".equals(dispatchProtocol)) {

      /* Begin Alarm */

      Long period = PropertyUtils.getIntValue(thread, "Period");
      if(period == null)
      {
        String errMsg =  "cannot fetch Period for \'" + thread.getName() + '\'';
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
      List<String> modeIdList = new ArrayList<String>();
      modeIdList.add(MAIN_APP_MODE);
      Alarm alarm = new Alarm(counter, task, cpu, modeIdList);

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

	/**
	 * Méthode appelée après le parcours de l'AST via les methodes process.
	 */
	public void close() {

	  String msg = "hooks generation" ;
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

		_mainCCode.addOutputNewline("void ShutdownHook(void)");
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
		
		// Generate OIL
		oil.generateOil(_oilCode);
		
		_mainHCode.addOutputNewline("#include \"gtypes.h\"");
		_mainHCode.addOutputNewline("#endif");
	}

	/**
	 * OSEK/C code generation for a data subcomponent 
	 * 
	 * @param thread
	 *            L'AST du thread.
	 * @throws GenerationException 
	 */
	private void genCData(DataSubcomponent data) {
		_mainCCode.addOutputNewline("#define OS_START_SEC_VAR_UNSPECIFIED");
		_mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutput("VAR(" + GenerationUtilsC.getGenerationCIdentifier(data.getAllClassifier().getQualifiedName())
				+ ", OS_VAR) " + data.getName());
		String init="";
		init = GeneratorUtils.getInitialValue(data.getDataSubcomponentType(), "c");
		if(! init.isEmpty())
			_mainCCode.addOutput(" = "+init);
		_mainCCode.addOutputNewline(";");
		
		_mainCCode.addOutputNewline("");
		_mainCCode.addOutputNewline("#define OS_STOP_SEC_VAR_UNSPECIFIED");
		_mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
		_mainCCode.addOutputNewline("");
	}

	private void genCMain() {
		_mainCCode.addOutputNewline("/*********** OS Main ***********/");
		_mainCCode.addOutputNewline("");
		_mainCCode.addOutputNewline("FUNC(int, OS_APPL_CODE) main(void)");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();
		_mainCCode.addOutputNewline("StartOS(OSDEFAULTAPPMODE);");
		_mainCCode.addOutputNewline("return 0;");
		_mainCCode.decrementIndent();
		_mainCCode.addOutputNewline("}");
		_mainCCode.addOutputNewline("");
		_mainCCode.addOutputNewline("");
	}

	/**
	 * OSEK a besoin d'une tache IDLE pour fonctionner : elle est donc déclarée
	 * en dur dans le code.
	 */
	private void genIdleTask() {

		Task idleTask;
		String name = "taskIdle";

		idleTask = new Task();
		idleTask.setName(name);
		idleTask.setPriority(1);
		idleTask.setAutostart(true);
		idleTask.setActivation(1);
		idleTask.setSchedule(Schedule.FULL);
		idleTask.setAppmode(MAIN_APP_MODE);

		oil.getCpu().addTask(idleTask);

		_mainCCode.addOutputNewline("/*********** Idle Task ***********/");
		_mainCCode.addOutputNewline("DeclareTask(" + name + ");");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutputNewline("#define APP_Task_" + name + "_START_SEC_CODE");
		_mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutputNewline("TASK(" + name + ")");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();
		_mainCCode.addOutputNewline("TerminateTask();");
		_mainCCode.decrementIndent();
		_mainCCode.addOutputNewline("}");

		_mainCCode.addOutputNewline("");
		_mainCCode.addOutputNewline("#define APP_Task_" + name + "_STOP_SEC_CODE");
		_mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
		_mainCCode.addOutputNewline("");
		_mainCCode.addOutputNewline("");
	}

	private void genCTask(ProcessSubcomponent ps, ThreadSubcomponent thread) {
		String threadName = thread.getComponentImplementation().getQualifiedName();
		threadName = GenerationUtilsC.getGenerationCIdentifier(threadName);
		_mainCCode.addOutputNewline("/*** Task " + threadName + " ***/");
		_mainCCode.addOutputNewline("extern void *" + threadName + "_Job(void);");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutputNewline("DeclareTask(" + thread.getName() + ");");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutputNewline("#define APP_Task_" + thread.getName() + "_START_SEC_CODE");
		_mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
		_mainCCode.addOutputNewline("");

		_mainCCode.addOutputNewline("TASK(" + thread.getName() + ")");
		_mainCCode.addOutputNewline("{");
		_mainCCode.incrementIndent();

		_mainCCode.addOutputNewline(threadName + "_Job();");

		_mainCCode.decrementIndent();
		_mainCCode.addOutputNewline("}");

		_mainCCode.addOutputNewline("");
		_mainCCode.addOutputNewline("#define APP_Task_" + thread.getName() + "_STOP_SEC_CODE");
		_mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
		_mainCCode.addOutputNewline("");
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
			throws GenerationException {
	  String msg = "process not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
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
	  
	  genImplementation();
	  genCMain();
    genIdleTask();
    genCpu(process);
    
    
    StringBuilder sb = new StringBuilder(process.getQualifiedName());
    ProcessProperties pp = new ProcessProperties(sb.substring(0, sb.lastIndexOf("::")+2)) ;
    
    ProcessImplementation processImpl = (ProcessImplementation) 
        process.getComponentImplementation() ;

    this.findCommunicationMechanism(processImpl, pp);
    
    ComponentInstance processInstance = (ComponentInstance) HookAccessImpl.getTransformationTrace(process);
    
    genSendOutputImpl(processInstance, _mainCCode, _mainHCode, pp);

    
	  // TODO generate isr
    Isr isr = new Isr();
    isr.setName("isr_button_stop");
    isr.setPriority(1);
    isr.setCategory(2);
    isr.setSource("button_stop");
    oil.getCpu().addIsr(isr);
    
 // TODO generate code
    for (Isr currentIsr : oil.getCpu().getIsrs()) {
      _mainCCode.addOutputNewline("#define APP_ISR_" + currentIsr.getName() + "_START_SEC_CODE");
      _mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
      _mainCCode.addOutputNewline("");
      _mainCCode.addOutputNewline("ISR(" + currentIsr.getName() + ")");
      _mainCCode.addOutputNewline("{");
      _mainCCode.incrementIndent();
      _mainCCode.addOutputNewline("ShutdownOS(E_OK);");
      _mainCCode.decrementIndent();
      _mainCCode.addOutputNewline("}");
      _mainCCode.addOutputNewline("");
      _mainCCode.addOutputNewline("#define APP_ISR_" + currentIsr.getName() + "_STOP_SEC_CODE");
      _mainCCode.addOutputNewline("#include \"tpl_memmap.h\"");
    }
	}

  @Override
	public void setParameters(Map<Enum<?>, Object> parameters)
	{
	  String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
	}

  @Override
  protected String getBlackBoardType()
  {
    return "OSEK_runtime::DataPortType" ;
  }

  @Override
  protected String getBufferType()
  {
    return "OSEK_runtime::TPortQueueType" ;
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
    mainImplCode.addOutputNewline("ret = SendOutput_runtime(" + info.id +
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
    return "OSEK_runtime::ThreadQueueType";
  }

  @Override
  protected void sendOutputVariableAccess(ComponentInstance processInstance,
                                          UnparseText mainImplCode,
                                          ProcessProperties pp)
  {
    // TODO Auto-generated method stub
    
  }
}