/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.control.support.instantiation;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * This class provides a static method for EMF validation of a given resource set
 */
public class AadlResourceValidator {
	
  /**
   * This static method proceed to EMF validation of a given resource set
   * @param resourceSet the resource set from which all resources will be
   * validated
   */
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