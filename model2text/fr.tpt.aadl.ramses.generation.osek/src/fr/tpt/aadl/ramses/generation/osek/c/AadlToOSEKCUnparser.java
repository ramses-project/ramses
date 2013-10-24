package fr.tpt.aadl.ramses.generation.osek.c;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.utils.PropertyNotFound ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC;
import fr.tpt.aadl.ramses.generation.osek.Resources;
import fr.tpt.aadl.ramses.generation.osek.ast.Alarm;
import fr.tpt.aadl.ramses.generation.osek.ast.Alarm.Action;
import fr.tpt.aadl.ramses.generation.osek.ast.Counter;
import fr.tpt.aadl.ramses.generation.osek.ast.Cpu;
import fr.tpt.aadl.ramses.generation.osek.ast.Cpu.PeriodicTask;
import fr.tpt.aadl.ramses.generation.osek.ast.Hook;
import fr.tpt.aadl.ramses.generation.osek.ast.Implementation;
import fr.tpt.aadl.ramses.generation.osek.ast.ImplementationIsr;
import fr.tpt.aadl.ramses.generation.osek.ast.ImplementationTask;
import fr.tpt.aadl.ramses.generation.osek.ast.Isr;
import fr.tpt.aadl.ramses.generation.osek.ast.Memmap;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL;
import fr.tpt.aadl.ramses.generation.osek.ast.Os;
import fr.tpt.aadl.ramses.generation.osek.ast.Os.Status;
import fr.tpt.aadl.ramses.generation.osek.ast.Subprogram;
import fr.tpt.aadl.ramses.generation.osek.ast.Task;
import fr.tpt.aadl.ramses.generation.osek.ast.Task.Schedule;
import fr.tpt.aadl.ramses.util.generation.FileUtils;
import fr.tpt.aadl.ramses.util.generation.GeneratorUtils;
import fr.tpt.aadl.ramses.util.generation.RoutingProperties;

/**
 * Unparser to generate an oil file for OSEK from aadl.
 */
public class AadlToOSEKCUnparser implements AadlTargetUnparser {

	private final static String MAIN_APP_MODE = "std";

	/**
	 * Compilation config
	 */
	private final static String compilationFile = "compilation.properties";

	/**
	 * OSEK
	 */
	private final static String C_OSEK_RUNTIME = "osek_runtime.c";
	private final static String H_OSEK_RUNTIME = "osek_runtime.h";

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
	private final static int THREAD_STACKSIZE = 512;
	
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

	public AadlToOSEKCUnparser(OIL oil) {
		this.oil = oil;
		oil.setVersion(OIL_VERSION);
	}

	/**
	 * Method called before browsing the AST thanks to the "process" method. 
	 * 
	 * @param generatedCodeDirectory
	 * TODO
	 * @param generatedOilPath
	 *            path in which output files are generated
	 * @param configurationPath
	 *            path of the directory in which are stored the
	 *            configuration files.
	 * @param oilFile
	 *            name of the generated oil file
	 * @param cFile
	 *            name of the generated c file
	 */
	public void open(File generatedCodeDirectory, File configurationPath) {

	  _generatedCodeDirectory = generatedCodeDirectory;
		_oilCode = new UnparseText();
		_mainCCode = new UnparseText();
		_mainHCode = new UnparseText();
		resources = new Resources(new File(configurationPath, compilationFile));
		_startupHook = new Hook();
		_shutdownHook = new Hook();
		
	}

	/**
	 * Methode appelée sur chaque noeud implémentant un système.
	 */
	@Override
	public TargetProperties process(SystemImplementation si, File generatedFilePath) throws GenerationException {

	  File configurationPath = RamsesConfiguration.getInputDirectory();
	  open(generatedFilePath, configurationPath);
	  
	  _mainCCode.addOutputNewline("/*** This file has been generated by students, use it at your own risk ***/");
	  _mainCCode.addOutputNewline("#include \"tpl_os.h\"");
	  _mainCCode.addOutputNewline("");

		genDevice(si);
		genCounters(si);

		return new RoutingProperties();
	}

	/**
	 * Method call on subprogram implementation
	 */
	public void process(SubprogramType elt, File generatedFilePath) {

		Os os = oil.getCpu().getOs();

		if (_startupHook.getReferences().contains(elt.getName())) {
			try {
				Subprogram subprogram = new Subprogram();
				subprogram.setName(PropertyUtils.getStringValue(elt, "Source_Name"));
				subprogram.addParameter(PropertyUtils.getStringValue(elt, "nxtport"));
				_startupHook.addSubrogram(subprogram);
	
			} catch (Exception e) {
	
			}
		} else if (_shutdownHook.getReferences().contains(elt.getName())) {
	
			try {
				Subprogram subprogram = new Subprogram();
				subprogram.setName(PropertyUtils.getStringValue(elt, "Source_Name"));
				subprogram.addParameter(PropertyUtils.getStringValue(elt, "nxtport"));
				_shutdownHook.addSubrogram(subprogram);
			} catch (Exception e) {
	
			}
		}
		
		
	}


	private void genDevice(SystemImplementation si) {

		Os os = oil.getCpu().getOs();

		for (DeviceSubcomponent device : si.getOwnedDeviceSubcomponents()) {
			
			try {
				Classifier classifier = PropertyUtils.getClassifierValue(device, "Initialize_Entrypoint");
				/*
				 * If one thread/device contains Initialize_Entrypoint STARTUPHOOK = true
				 */
				os.setStartupHook(true);
				_startupHook.addReference(classifier.getName());
			} catch (Exception e) {

			}

			try {
				Classifier classifier = PropertyUtils.getClassifierValue(device, "Finalize_Entrypoint");
				/*
				 * If one thread/device contains Finalize_Entrypoint SHUTDOWNHOOK = true
				 */
				os.setShutdownHook(true);
				_shutdownHook.addReference(classifier.getName());
			} catch (Exception e) {

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

		  for (Subcomponent s : subcmpts) {
		    if (s instanceof DataSubcomponent) {
		      String value;
		      try {
		        value = PropertyUtils.getEnumValue(s, "Concurrency_Control_Protocol");
		        if (value.equals("Priority_Ceiling")) {
		          os.setStatus(Status.EXTENDED);
		          break;
		        }
		      } catch (Exception e) {
		        // DO NOTHING
		      }
		    }
		  }
		}

		cpu.setName(ps.getName());
		genOsConfig(ps);

		cpu.setAppmode(MAIN_APP_MODE);

	}

	/**
	 * Configuration de l'OS
	 * 
	 * @param processSubcomponent
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
		String source;
		int maxValue;
		int ticksPerBase;
		int minCycle;

		try {
			source = PropertyUtils.getStringValue(si, "SystemCounter_Source");
			maxValue = (int) PropertyUtils.getIntValue(si, "SystemCounter_MaxAllowedValue");
			ticksPerBase = (int) PropertyUtils.getIntValue(si, "SystemCounter_TicksPerBase");
			minCycle = (int) PropertyUtils.getIntValue(si, "SystemCounter_MinCycle");

		} catch (Exception exception) {
			throw new PropertyNotFound(exception);
		}

		counter.setName(COUNTER_NAME);
		counter.setSource(source);
		counter.setMaxAllowedValue(maxValue);
		counter.setTicksPerBase(ticksPerBase);
		counter.setMinCycle(minCycle);
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
		int priority;
		Schedule schedule;
		int stackSize;

		try {
			priority = (int) PropertyUtils.getIntValue(thread, "Priority");
		} catch (Exception exception) {
			throw new PropertyNotFound(exception);
		}

		try {
			boolean scheduler = PropertyUtils.getBooleanValue(ps, "Preemptive_Scheduler");
			if (scheduler)
				schedule = Schedule.FULL;
			else
				schedule = Schedule.NON;
		} catch (Exception exception) {
			schedule = Schedule.FULL;
		}

		stackSize = THREAD_STACKSIZE;

		try {
			stackSize = (int) PropertyUtils.getIntValue(thread, "Source_Stack_Size");
		} catch (Exception exception) {

		}

		task.setName(thread.getName());
		task.setPriority(priority);
		task.setActivation(THREAD_ACTIVATION);

		task.setSchedule(schedule);
		task.setStacksize(stackSize);


		ThreadImplementation ti = (ThreadImplementation) thread.getSubcomponentType();
		
		for(SubprogramCallSequence scs: ti.getOwnedSubprogramCallSequences())
		{
		  for(CallSpecification cs: scs.getOwnedCallSpecifications())
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
		try {
			String dispatchProtocol = PropertyUtils.getEnumValue(thread, "Dispatch_Protocol");

			if (dispatchProtocol.equals("Periodic")) {

				/* Begin Alarm */

				int period = (int) PropertyUtils.getIntValue(thread, "Period");
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
				alarm.setCycleTime(period);

				task.setAutostart(false);

				cpu.addPeriodicTask(new PeriodicTask(task, alarm));
				/* End Alarm */
			} else {
				task.setAutostart(true);
				cpu.addTask(task);
			}
		} catch (Exception exception) {
			throw new PropertyNotFound(exception);
		}
	}

	/**
	 * Méthode appelée après le parcours de l'AST via les methodes process.
	 */
	public void close() {

		System.out.println("======== Hooks generation ============");
		
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
	public void process(ProcessorSubcomponent processor, File generatedFilePath, TargetProperties tarProp)
			throws GenerationException {
		// TODO Do NOT Use
	}

	@Override
	public void process(ProcessSubcomponent process, File generatedFilePath, TargetProperties tarProp)
			throws GenerationException {
    
    // Generate main.h
    genMainHeader() ;
    
    // Generate main.c
    genMainImpl(process) ;
    
    
    close();
    
    try
    {
      
      FileUtils.saveFile(generatedFilePath, "main.h",
               _mainHCode.getParseOutput()) ;
      
      FileUtils.saveFile(generatedFilePath, "main.c",
               _mainCCode.getParseOutput()) ;
      
      FileUtils.saveFile(generatedFilePath, process.getName() + ".oil",
                         _oilCode.getParseOutput()) ;
    }
    catch(IOException e)
    {
      // TODO : error message to handle.
      e.printStackTrace() ;
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
	public void setParameters(Map<Enum<?>, Object> parameters) {
		// TODO Do NOT Use
	}
}
