package fr.tpt.aadl.ramses.generation.osek.ast;

import java.util.ArrayList;
import java.util.List;

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

	public Cpu() {
		os = new Os();
		counter = new Counter();
		periodicTasks = new ArrayList<PeriodicTask>();
		tasks = new ArrayList<Task>();
		isrs = new ArrayList<Isr>();
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

	public void generateOil(UnparseText code) {

		code.addOutputNewline("CPU " + name + " {");
		code.incrementIndent();
		os.generateOil(code);
		code.addOutputNewline("APPMODE " + appmode + " {");
		code.addOutputNewline("};");
		counter.generateOil(code);

		for (PeriodicTask task : periodicTasks) {
			task.task.generateOil(code);
			task.alarm.generateOil(code);
		}

		for (Task task : tasks) {
			task.generateOil(code);
		}

		for (Isr isr : isrs) {
			isr.generateOil(code);
		}

		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}
