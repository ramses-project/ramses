package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class ImplementationIsr {

	private int stackSize;

	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}

	public void generateOil(UnparseText code) {
		code.addOutputNewline("ISR {");
		code.incrementIndent();
		code.addOutputNewline("UINT32 STACKSIZE = " + stackSize + ";");
		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}
