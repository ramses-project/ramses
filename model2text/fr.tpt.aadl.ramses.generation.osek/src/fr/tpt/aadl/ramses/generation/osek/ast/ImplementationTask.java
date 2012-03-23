package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class ImplementationTask {

	private int stackSize;
	private int priority;

	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void generateOil(UnparseText code) {

		code.addOutputNewline("TASK {");
		code.incrementIndent();

		code.addOutputNewline("UINT32 STACKSIZE = " + stackSize + ";");
		code.addOutputNewline("UINT32 PRIORITY = " + priority + ";");

		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}
