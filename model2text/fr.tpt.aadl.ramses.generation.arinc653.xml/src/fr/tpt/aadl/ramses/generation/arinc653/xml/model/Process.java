package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Process")
public class Process {
	
	@XStreamAlias("Name")
	@XStreamAsAttribute
	private String name;
	
	@XStreamAlias("StackSize")
	@XStreamAsAttribute
	private String stackSize;
	
	public Process() {
		super();
	}

	public Process(String name, String stackSize) {
		super();
		this.name = name;
		this.stackSize = stackSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStackSize() {
		return stackSize;
	}

	public void setStackSize(String stackSize) {
		this.stackSize = stackSize;
	}
	
	
}
