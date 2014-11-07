/**
 * AADL-RAMSES
 *
 * Copyright © 2014 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.generation.osek.ast;

import java.util.List ;

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
  private List<String> inModes ;
	
	public Alarm(Counter counter, Task task, Cpu cpu, List<String> inModes) {
		this.counter = counter;
		this.task = task;
		this.cpu = cpu;
		this.inModes = inModes;
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

	  for(String modeId: inModes)
	  {

	    code.addOutputNewline("ALARM " + name + "_"+ modeId +"{");
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
	    code.addOutputNewline("APPMODE = " + modeId + ";");

	    code.decrementIndent();
	    code.addOutputNewline("};");

	    code.decrementIndent();
	    code.addOutputNewline("};");
	    code.addOutputNewline("");
	  }
	}
}