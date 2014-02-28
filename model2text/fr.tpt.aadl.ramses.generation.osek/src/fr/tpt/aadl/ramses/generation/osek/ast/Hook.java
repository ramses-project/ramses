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