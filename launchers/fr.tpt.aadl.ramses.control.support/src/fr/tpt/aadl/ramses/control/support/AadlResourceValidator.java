package fr.tpt.aadl.ramses.control.support;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;


public class AadlResourceValidator {
	
	public static void validate (ResourceSet resourceSet)
	  {
	    for(Resource input_resource : resourceSet.getResources())
	    {
	      for(EObject myModel : input_resource.getContents())
	      {
	        Diagnostic diagnostic = Diagnostician.INSTANCE.validate(myModel) ;

	        switch ( diagnostic.getSeverity() )
	        {
	          case Diagnostic.ERROR :

	            for(Diagnostic d : diagnostic.getChildren())
	            {
	              System.err.println("Model has errors: "
	                    + input_resource.getURI().lastSegment() + " " + d.getMessage()) ;
	            }

	            break ;
	          case Diagnostic.WARNING :

	            for(Diagnostic d : diagnostic.getChildren())
	            {
	              System.err.println("Model has warnings: " + d.getMessage()) ;
	            }

	            break ;
	        }
	      }
	    }
	  }
}
