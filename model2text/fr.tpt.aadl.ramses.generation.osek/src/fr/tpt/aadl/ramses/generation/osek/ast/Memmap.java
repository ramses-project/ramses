package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class Memmap {

	private String compiler;
	private String linker;
	private String assembler;
	private boolean memoryProtection;

	public void setCompiler(String compiler) {
		this.compiler = compiler;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	public void setAssembler(String assembler) {
		this.assembler = assembler;
	}

	public void setMemoryProtection(boolean memoryProtection) {
		this.memoryProtection = memoryProtection;
	}

	public void generateOil(UnparseText code) {

		code.addOutputNewline("MEMMAP = TRUE {");
		code.incrementIndent();
		code.addOutputNewline("COMPILER = " + compiler + ";");
		code.addOutputNewline("LINKER = " + linker + ";");
		code.addOutputNewline("ASSEMBLER = " + assembler + ";");
		code.addOutputNewline("MEMORY_PROTECTION = " + Boolean.toString(memoryProtection).toUpperCase() + ";");
		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}
