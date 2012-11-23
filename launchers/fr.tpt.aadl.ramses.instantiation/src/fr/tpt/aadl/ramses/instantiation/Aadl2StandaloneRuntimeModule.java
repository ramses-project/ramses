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

package fr.tpt.aadl.ramses.instantiation ;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.osate.xtext.aadl2.valueconversion.Aadl2ValueConverter;

public class Aadl2StandaloneRuntimeModule extends org.osate.xtext.aadl2.AbstractAadl2RuntimeModule
{
	
  @Override
  public Class<? extends IValueConverterService> bindIValueConverterService() {
    return Aadl2ValueConverter.class;
  }
  
  @Override
  public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
    return Aadl2StandAloneQualifiedNameProvider.class;
  }

  @Override
  public Class<? extends org.eclipse.xtext.linking.ILinkingService> bindILinkingService() {
    return Aadl2StandaloneLinkingService.class;
  }
  
  @Override
  public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker()
  {
    return Aadl2StandaloneAnnexParserAgent.class ;
  }
  
  @Override
  public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
	return org.osate.xtext.aadl2.scoping.Aadl2GlobalScopeProvider.class;
  }
}
