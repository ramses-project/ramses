package fr.tpt.aadl.ramses.generation.osek.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.DataAccess;
import org.osate.aadl2.modelsupport.UnparseText;

import fr.tpt.aadl.ramses.util.generation.GeneratorUtils;

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
		
		for(String resourceName: this.resources)
		{
			code.addOutputNewline("RESOURCE = " + resourceName + "_rez;");
		}
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}

	public String getName() {
		return name;
	}
}
