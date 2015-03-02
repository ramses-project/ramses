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

import org.osate.aadl2.modelsupport.UnparseText ;

public class Task {

	public enum Schedule {
		FULL, NON
	}

	private String name;
	private int priority;
	private boolean autostart;
	private int activation;
	private Schedule schedule;
	private int stacksize;
	private String appmode;
	private List<String> resources = new ArrayList<String>();
	private List<String> events = new ArrayList<String>();
	
	public void setAppmode(String appmode) {
		this.appmode = appmode;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setAutostart(boolean autostart) {
		this.autostart = autostart;
	}

	public void setActivation(int activation) {
		this.activation = activation;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setStacksize(int stacksize) {
		this.stacksize = stacksize;
	}
	
	public void addResource(String res)
	{
		this.resources.add(res);
	}
	
	public void addEvent(String evt)
	{
		this.events.add(evt);
	}
	
	public void generateOil(UnparseText code) {		
		code.addOutputNewline("TASK " + name + " {");
		code.incrementIndent();
		code.addOutputNewline("PRIORITY = " + priority + ";");		
		if(autostart)
		{
			
			code.addOutputNewline("AUTOSTART = TRUE { APPMODE = " + appmode + ";};");
		}
		else
		{
			code.addOutputNewline("AUTOSTART = " + Boolean.toString(autostart).toUpperCase() + ";");
			
		}
		code.addOutputNewline("ACTIVATION = " + activation + ";");
		code.addOutputNewline("SCHEDULE = " + schedule + ";");
		if(stacksize != 0)
			code.addOutputNewline("STACKSIZE = " + stacksize + ";");
		code.decrementIndent();
		
		List <String> lst = new ArrayList<String>(); 
		lst.clear();		
		for(String resourceName: this.resources)
		{	
			if (! lst.contains(resourceName)){
				lst.add(resourceName);
				code.addOutputNewline("RESOURCE = " + resourceName + "_rez;");
			}else{
				System.out.println("WARNING : Duplicated entry for RESSOURCE "+resourceName+" in task "+this.name+" ; has been supressed");
			}
		}
		lst.clear();
		for(String eventName: this.events)
		{
			if (! lst.contains(eventName)){
				lst.add(eventName);
				code.addOutputNewline("EVENT = " + eventName + "_evt;");
			}else{
				System.out.println("WARNING : Duplicated entry for EVENT "+eventName+" in task "+this.name+" ; has been supressed");
			}
		}
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
	

	public String getName() {
		return name;
	}
} 