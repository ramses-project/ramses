package fr.tpt.aadl.ramses.analysis.eg.model;

public enum EGNodeKind {

	Computation,
	
	CriticalSectionEnd,
	
	CriticalSectionStart,
	
	State,
	
	TransitionStart,
	
	TransitionEnd;
	
	public boolean isMergeable()
	{
		return this != CriticalSectionStart && this != CriticalSectionEnd;
	}
	
}
