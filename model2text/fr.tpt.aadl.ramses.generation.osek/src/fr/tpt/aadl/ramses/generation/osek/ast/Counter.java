package fr.tpt.aadl.ramses.generation.osek.ast;

import org.osate.aadl2.modelsupport.UnparseText;

public class Counter {

	private String name;
	private String source;
	private int maxAllowedValue;
	private int ticksPerBase;
	private int minCycle;

	public Counter() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setMaxAllowedValue(int maxAllowedValue) {
		this.maxAllowedValue = maxAllowedValue;
	}

	public void setTicksPerBase(int ticksPerBase) {
		this.ticksPerBase = ticksPerBase;
	}

	public void setMinCycle(int minCycle) {
		this.minCycle = minCycle;
	}

	public void generateOil(UnparseText code) {
		code.addOutputNewline("COUNTER " + name + "{");
		code.incrementIndent();
		code.addOutputNewline("MAXALLOWEDVALUE = " + maxAllowedValue + ";");
		code.addOutputNewline("TICKSPERBASE = " + ticksPerBase + ";");
		code.addOutputNewline("MINCYCLE = " + minCycle + ";");
		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}

	public String getName() {
		return name;
	}
}
