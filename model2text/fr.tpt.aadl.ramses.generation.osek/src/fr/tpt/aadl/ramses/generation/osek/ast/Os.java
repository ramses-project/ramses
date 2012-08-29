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
	private final Set<File> appSrcs;
	private final Set<File> appHeaders;
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
		appSrcs = new HashSet<File>();
		appHeaders = new HashSet<File>();
		cFlags = new ArrayList<String>();
		asFlags = new ArrayList<String>();
		ldFlags = new ArrayList<String>();
		memmap = new Memmap();
		status = Status.STANDARD;
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
	
	public Set<File> getAppHeaders() {
		return appHeaders;
	}

	public void addAppHeader(File appHeader) {
		this.appHeaders.add(appHeader);
	}
	
	public Set<File> getAppSrcs() {
		return appSrcs;
	}

	public void addAppSrc(File appSrc) {
		this.appSrcs.add(appSrc);
	}

	public void addAllAppSrcs(List<File> appSrcs) {
		this.appSrcs.addAll(appSrcs);
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

		for (File src : appSrcs)
			code.addOutputNewline("APP_SRC = \"" + src.getName() + "\";");

		code.addOutputNewline("APP_NAME = \"" + appName + "\";");

		if (trampolineBasePath != null && !trampolineBasePath.isEmpty())
			code.addOutputNewline("TRAMPOLINE_BASE_PATH =\"" + trampolineBasePath + "\";");
		else
			code.addOutputNewline("TRAMPOLINE_BASE_PATH =");

		for (String cFlag : cFlags)
			code.addOutputNewline("CFLAGS = \"" + cFlag + "\";");

		for (String asFlag : asFlags)
			code.addOutputNewline("ASFLAGS = \"" + asFlag + "\";");

		for (String ldFlag : ldFlags)
			code.addOutputNewline("LDFLAGS = \"" + ldFlag + "\";");

		code.addOutputNewline("SYSTEM_CALL = " + Boolean.toString(systemCall).toUpperCase() + ";");

		code.addOutputNewline("COMPILER = \"" + compiler + "\";");

		code.addOutputNewline("ASSEMBLER = \"" + assembler + "\";");

		code.addOutputNewline("LINKER = \"" + linker + "\";");

		memmap.generateOil(code);

		code.decrementIndent();
		code.addOutputNewline("};");
		code.addOutputNewline("");
	}

}
