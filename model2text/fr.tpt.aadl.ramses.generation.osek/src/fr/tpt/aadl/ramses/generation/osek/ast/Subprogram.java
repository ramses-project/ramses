package fr.tpt.aadl.ramses.generation.osek.ast;

import java.util.ArrayList;
import java.util.List;

public class Subprogram {

	private List<String> parameters;
	private String name;
	
	public Subprogram() {
		parameters = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getParameters() {
		return parameters;
	}
	
	public void addParameter(String parameter) {
		parameters.add(parameter);
	}
}
