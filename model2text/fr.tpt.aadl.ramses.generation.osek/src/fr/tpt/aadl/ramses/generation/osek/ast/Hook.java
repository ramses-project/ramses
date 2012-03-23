package fr.tpt.aadl.ramses.generation.osek.ast;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Hook {

	private List<String> references; 
	private Set<Subprogram> calls;
	
	public Hook() {
		references = new LinkedList<String>();
		calls = new HashSet<Subprogram>();
	}

	public List<String> getReferences() {
		return references;
	}
	
	public void addReference(String name) {
		references.add(name);
	}
	
	public void addSubrogram(Subprogram subrogram) {
		calls.add(subrogram);
	}
	
	public Set<Subprogram> getCalls() {
		return calls;
	}
}
