package fr.tpt.aadl.ramses.analysis.eg.model;

public class IOTime {

	public final double Fixed;
	public final double PerByte;
	
	public IOTime(double Fixed, double PerByte)
	{
		this.Fixed = Fixed;
		this.PerByte = PerByte;
	}
	
	public IOTime()
	{
		this(0d,0d);
	}
	
	public boolean isNull()
	{
		return Fixed==0d && PerByte==0d;
	}
	
	public double getTime(int bytes)
	{
		return Fixed + (PerByte * bytes);
	}
	
	public double getTime(long bytes)
	{
		return Fixed + (PerByte * bytes);
	}
	
}
