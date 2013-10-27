package fr.tpt.aadl.ramses.generation.osek.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.modelsupport.UnparseText;

public class Cpu {

	public static class PeriodicTask {
		private Task task;
		private Alarm alarm;

		public PeriodicTask(Task task, Alarm alarm) {
			this.task = task;
			this.alarm = alarm;
		}
	}

	private String name;
	private Os os;
	private String appmode;
	private Counter counter;
	private List<PeriodicTask> periodicTasks;
	private List<Task> tasks;
	private List<Isr> isrs;
	private List<DataSubcomponent> datasubcomponents;
	private Map<DataAccess, String> dataAccessMapping;
	
	
	public Cpu() {
		os = new Os();
		counter = new Counter();
		periodicTasks = new ArrayList<PeriodicTask>();
		tasks = new ArrayList<Task>();
		isrs = new ArrayList<Isr>();
		datasubcomponents = new ArrayList<DataSubcomponent>();
	}

	public Os getOs() {
		return os;
	}

	public String getAppmode() {
		return appmode;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAppmode(String appmode) {
		this.appmode = appmode;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void addPeriodicTask(PeriodicTask task) {
		periodicTasks.add(task);
	}

	public void addIsr(Isr isr) {
		isrs.add(isr);
	}

	public List<Isr> getIsrs() {
		return isrs;
	}

	public void addAllDataSubcomponent(List<DataSubcomponent> dataSubcomponents)
	{
		datasubcomponents.addAll(dataSubcomponents);
	}
	
	public void setDataAccessMapping(Map<DataAccess, String> dataAccessMapping)
	{
		this.dataAccessMapping = dataAccessMapping;
	}
	
	public void generateOil(UnparseText code) {

		code.addOutputNewline("CPU " + name + " {");
		code.incrementIndent();
		os.generateOil(code);
		code.addOutputNewline("APPMODE " + appmode + " {");
		code.addOutputNewline("};");
		counter.generateOil(code);

		for(DataSubcomponent ds: datasubcomponents)
		{
		  if(ds.getSubcomponentType().getName().equalsIgnoreCase("ThreadQueueType")
				  || ds.getSubcomponentType().getName().equalsIgnoreCase("DataPortType"))
		  {
			  code.addOutputNewline("RESOURCE "+ds.getName()+"_rez");
			  code.addOutputNewline("{");
			  code.incrementIndent();
			  code.addOutputNewline("RESOURCEPROPERTY = STANDARD;");
			  code.decrementIndent();
			  code.addOutputNewline("};");
		  }
		  if(ds.getSubcomponentType().getName().equalsIgnoreCase("ThreadQueueType"))
		  {
			code.addOutputNewline("EVENT "+ds.getName()+"_evt {");
			code.incrementIndent();
			code.addOutputNewline("MASK = AUTO;");
			code.decrementIndent();
			code.addOutputNewline("};");
		  }
		}
		
		for (PeriodicTask task : periodicTasks) {
			task.task.generateOil(code);
			task.alarm.generateOil(code);
		}

		for (Task task : tasks) {
			task.generateOil(code);
		}

		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}
