package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class Implementation {

	private String name;
	private ImplementationTask task;
	private ImplementationIsr isr;

	public Implementation() {
		task = new ImplementationTask();
		isr = new ImplementationIsr();
	}
	
	public ImplementationTask getTask() {
		return task;
	}
	
	public ImplementationIsr getIsr() {
		return isr;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void generateOil(UnparseText code) {
		code.addOutputNewline("IMPLEMENTATION " + name + " {");
		code.incrementIndent();
		
		task.generateOil(code);
		isr.generateOil(code);
		
		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}
