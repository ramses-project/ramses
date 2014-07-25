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

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.modelsupport.UnparseText ;

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
	private List<String> appmode;
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

	public List<String> getAppmode() {
		return appmode;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAppmode(List<String> appmode) {
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
		for(String mode: appmode)
		{
		  code.addOutputNewline("APPMODE " + mode + " {");
		  code.addOutputNewline("};");
		}
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