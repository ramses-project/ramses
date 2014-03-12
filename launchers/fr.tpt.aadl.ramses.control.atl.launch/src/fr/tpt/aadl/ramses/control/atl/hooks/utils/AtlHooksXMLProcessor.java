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

package fr.tpt.aadl.ramses.control.atl.hooks.utils;

import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage ;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AtlHooksXMLProcessor extends XMLProcessor
{
  /**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AtlHooksXMLProcessor()
  {
		super((EPackage.Registry.INSTANCE));
		AtlHooksPackage.eINSTANCE.eClass();
	}
  
  /**
	 * Register for "*" and "xml" file extensions the AtlHooksResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new AtlHooksResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new AtlHooksResourceFactoryImpl());
		}
		return registrations;
	}
} //AtlHooksXMLProcessor