/**
 * AADL-RAMSES
 *
 * Copyright © 2014 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.generation.osek.ast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osate.aadl2.modelsupport.UnparseText;

public class Os {

	public enum Status {
		EXTENDED, STANDARD
	}

	private String name;
	private Status status;
	private boolean startupHook;
	private boolean shutdownHook;
	private String trampolineBasePath;
	private String appName;
	private final List<String> cFlags;
	private final List<String> asFlags;
	private final List<String> ldFlags;
	private boolean systemCall;
	private String compiler;
	private String linker;
	private String assembler;

	private Memmap memmap;

	public Os() {
		cFlags = new ArrayList<String>();
		asFlags = new ArrayList<String>();
		ldFlags = new ArrayList<String>();
		memmap = new Memmap();
		status = Status.EXTENDED;
		startupHook = false;
		trampolineBasePath = null;
	}

	public Status getStatus() {
		return status;
	}

	public boolean getStartupHook() {
		return startupHook;
	}

	public boolean getShutdownHook() {
		return shutdownHook;
	}

	public Memmap getMemmap() {
		return memmap;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStartupHook(boolean startupHook) {
		this.startupHook = startupHook;
	}

	public void setShutdownHook(boolean shutdownHook) {
		this.shutdownHook = shutdownHook;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getTrampolineBasePath() {
		return trampolineBasePath;
	}
	
	public void setTrampolineBasePath(String trampolineBasePath) {
		this.trampolineBasePath = trampolineBasePath;
	}

	public void addAllCFlags(List<String> cFlags) {
		this.cFlags.addAll(cFlags);
	}

	public void addAllAsFlags(List<String> asFlags) {
		this.asFlags.addAll(asFlags);
	}

	public void addAllLdFlags(List<String> ldFlags) {
		this.ldFlags.addAll(ldFlags);
	}

	public void setSystemCall(boolean systemCall) {
		this.systemCall = systemCall;
	}

	public void setCompiler(String compiler) {
		this.compiler = compiler;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	public void setAssembler(String assembler) {
		this.assembler = assembler;
	}

	public void generateOil(UnparseText code) {

		code.addOutputNewline("OS " + name + " {");
		code.incrementIndent();

		code.addOutputNewline("STATUS = " + status + ";");
		code.addOutputNewline("STARTUPHOOK = " + Boolean.toString(startupHook).toUpperCase() + ";");
		code.addOutputNewline("SHUTDOWNHOOK = " + Boolean.toString(shutdownHook).toUpperCase() + ";");
		code.addOutputNewline("ERRORHOOK = FALSE;"); 
		code.addOutputNewline("PRETASKHOOK = FALSE;");
		code.addOutputNewline("POSTTASKHOOK = FALSE;");
		code.addOutputNewline("USEGETSERVICEID = FALSE;");
		code.addOutputNewline("USEPARAMETERACCESS = FALSE;");
		code.addOutputNewline("USERESSCHEDULER = FALSE;");

		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}
}