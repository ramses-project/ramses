package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class OIL {

	private String version;

	private Implementation implementation;

	private Cpu cpu;

	public OIL() {
		this.implementation = new Implementation();
		this.cpu = new Cpu();
	}

	public Implementation getImplementation() {
		return implementation;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void generateOil(UnparseText code) {
		code.addOutputNewline("#include \"implementation.oil\"");

		code.addOutputNewline("");

		cpu.generateOil(code);
		code.addOutputNewline("");
	}
}
