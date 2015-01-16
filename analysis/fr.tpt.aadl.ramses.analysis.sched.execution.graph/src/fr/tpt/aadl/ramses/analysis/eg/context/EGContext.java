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

package fr.tpt.aadl.ramses.analysis.eg.context;

import java.util.Stack ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.ba.aadlba.SubprogramCallAction ;

import fr.tpt.aadl.ramses.analysis.eg.model.SystemProperties ;

/*
 * TODO: create a utility class to resolve parameters values and prototypes bindings
 * 
 * @See AadlBaUtils or AadlBaVisitor. Or code in these classes.
 * 
 */


public class EGContext {

	private static final EGContext instance = new EGContext();
	
	private NamedElement currentThread;
	private Stack<SubprogramCallContext> currentSubprograms = new Stack<SubprogramCallContext>();
	private SystemProperties systemProperties = new SystemProperties();
	
	public static EGContext getInstance()
	{
		return instance;
	}
	
	public NamedElement getCurrentThread()
	{
		return currentThread;
	}
	
	public void setCurrentThread(NamedElement thread)
	{
		this.currentThread = thread;
	}
	
	public void pushCurrentSubprogram(SubprogramCall sc)
	{
		currentSubprograms.push(SubprogramCallContext.create(sc));
	}
	
	public void pushCurrentSubprogram(SubprogramCallAction sc)
	{
	  SubprogramCallContext ctxt = SubprogramCallContext.create(sc);
	  //_LOGGER.trace("Push " + ctxt.getElement().getName());
		currentSubprograms.push(ctxt);
	}
	
	public SubprogramCallContext popCurrentSubprogram()
	{
		SubprogramCallContext ctxt = currentSubprograms.pop();
		//_LOGGER.trace("Pop " + ctxt.getElement().getName());
		return ctxt;
	}
	
	public SubprogramCallContext getCurrentVisitedSubprogram()
	{
		return currentSubprograms.peek(); 
	}
	
	/*
	public NamedElement getCurrentVisitedElement()
	{
		if (currentSubprograms.isEmpty())
			return currentThread;
		else
			return currentSubprograms.peek();
	}*/
	
	public SystemProperties getSystemProperties()
	{
		return systemProperties;
	}
	
	public void setSystemProperties(SystemProperties props)
	{
		systemProperties = props;
	}

	public int getVisitingSubprogramCallActionSize() {
		return currentSubprograms.size();
	}

	public SubprogramCallContext getVisitingSubprogramCallAction(int i) {
		return currentSubprograms.get(i);
	}
}