package fr.tpt.rdal.parser;

import org.osate.aadl2.NamedElement;

import fr.openpeople.rdal2.model.rdal.Sensitivity;

public class ComparableSensitivity {

	
	private Sensitivity sensitivity;
	private long priority;
	
	public ComparableSensitivity(Sensitivity sensitivity, long priority)
	{
		this.sensitivity = sensitivity;
		this.priority = priority;
	}

	public Sensitivity getSensitivity() {
		return sensitivity;
	}
	
	public long getPriority()
	{
		return priority;
	}
	
}
