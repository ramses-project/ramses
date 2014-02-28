package fr.tpt.aadl.ramses.analysis.eg.ba;

import org.osate.aadl2.NamedElement ;
import org.osate.ba.aadlba.DataComponentReference ;
import org.osate.ba.aadlba.DataHolder ;
import org.osate.ba.aadlba.Target ;

public class AssignmentActionUtil {

	private AssignmentActionUtil(){}
	
	public static NamedElement getTargetElement(Target t)
	{
		if (t instanceof DataHolder)
		{
			return ((DataHolder) t).getElement();
		}
		else if (t instanceof DataComponentReference)
		{
			DataComponentReference r = (DataComponentReference) t;
			DataHolder h = r.getData().get(r.getData().size() - 1);
			return ((DataHolder) h).getElement();
		}
		else
		{
			System.err.println("getTargetElement: not yet supported " + 
					t.getClass().getSimpleName());
		}

		return null;
	}
	
	public static String getTargetElementName (Target t)
	{
	  NamedElement e = getTargetElement (t);
	  return (e==null ? "null" : e.getName());
	}
	
	
}
