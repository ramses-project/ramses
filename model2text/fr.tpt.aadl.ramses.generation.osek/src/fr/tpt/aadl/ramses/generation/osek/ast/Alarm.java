package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class Alarm {

	public enum Action {
		ACTIVATETASK
	}

	private String name;
	private Counter counter;
	private Task task;
	private Action action;
	private boolean autostart;
	private int alarmTime;
	private int cycleTime;
	private Cpu cpu;
	
	public Alarm(Counter counter, Task task, Cpu cpu) {
		this.counter = counter;
		this.task = task;
		this.cpu = cpu;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public void setAutostart(boolean autostart) {
		this.autostart = autostart;
	}

	public void setAlarmTime(int alarmTime) {
		this.alarmTime = alarmTime;
	}

	public void setCycleTime(int cycleTime) {
		this.cycleTime = cycleTime;
	}

	public void generateOil(UnparseText code) {

		code.addOutputNewline("ALARM " + name + " {");
		code.incrementIndent();
		code.addOutputNewline("COUNTER = " + counter.getName() + ";");

		code.addOutputNewline("ACTION = " + action + " {");
		code.incrementIndent();
		code.addOutputNewline("TASK = " + task.getName() + ";");
		code.decrementIndent();
		code.addOutputNewline("};");

		code.addOutputNewline("AUTOSTART = " + Boolean.toString(autostart).toUpperCase() + " {");
		code.incrementIndent();
		code.addOutputNewline("ALARMTIME = " + alarmTime + ";");
		code.addOutputNewline("CYCLETIME = " + cycleTime + ";");
		code.addOutputNewline("APPMODE = " + cpu.getAppmode() + ";");
		code.decrementIndent();
		code.addOutputNewline("};");

		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}
