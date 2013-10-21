package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class Isr {
	private String name;
	private int category;
	private int priority;
	private String source;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}
