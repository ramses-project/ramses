package fr.tpt.aadl.sched.wcetanalysis;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class WcetAnalysisDebug
{
	private static Collection<PrintStream> printers 
			= new ArrayList<PrintStream>();
	
	private static Collection<PrintStream> errorPrinters 
	= new ArrayList<PrintStream>();
	
	//public final static boolean ENABLED = true;
	
	public final static String INDENT = "  ";
	
	private static String tab = "";
	private static boolean doIndent = true;
	
	private WcetAnalysisDebug(){}
	
	public static void addPrinter(PrintStream ps)
	{
		if (!printers.contains(ps) && ps != null)
			printers.add(ps);
	}
	
	public static void addErrorPrinter(PrintStream ps)
	{
		if (!errorPrinters.contains(ps) && ps != null)
			errorPrinters.add(ps);
	}
	
	public static void incrementIndent()
	{
		tab += INDENT;
		//System.out.println("indent++");
	}
	
	public static void decrementIndent()
	{
		tab = tab.substring(0,tab.length()-INDENT.length());
	}
	
	public static void print(String msg)
	{
		String fmsg = (doIndent && tab!=null ? tab : "") + msg;
		
		for(PrintStream ps : printers)
		{
			ps.print(fmsg);
		}
		/*
		if (ENABLED)
		{
			System.out.print(fmsg);
		}*/
		doIndent = false;
	}
	
	public static void println(String msg)
	{
		print(msg + "\n");
		doIndent = true;
	}
	
	public static void println()
	{
		println("");
		doIndent = true;
	}
	
	public static void error(String msg)
	{
		String fmsg = (doIndent && tab!=null ? tab : "") + msg;
		for(PrintStream ps: printers)
		{
			ps.flush();
		}
		for(PrintStream ps: errorPrinters)
		{
			ps.println(fmsg);
			ps.flush();
		}
		/*if (ENABLED)
		{
			System.out.flush();
			System.err.println((doIndent && tab!=null ? tab : "") + msg);
			System.err.flush();
		}*/
	}
}
