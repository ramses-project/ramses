package fr.tpt.aadl.ramses.analysis.eg.context;

import java.util.Stack ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.ba.aadlba.SubprogramCallAction ;

import fr.tpt.aadl.ramses.analysis.eg.model.SystemProperties ;

/*
 * TODO: create a utility class to resolve parameters values and prototypes bindings
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
	  //System.out.println("Push " + ctxt.getElement().getName());
		currentSubprograms.push(ctxt);
	}
	
	public SubprogramCallContext popCurrentSubprogram()
	{
		SubprogramCallContext ctxt = currentSubprograms.pop();
		//System.out.println("Pop " + ctxt.getElement().getName());
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
