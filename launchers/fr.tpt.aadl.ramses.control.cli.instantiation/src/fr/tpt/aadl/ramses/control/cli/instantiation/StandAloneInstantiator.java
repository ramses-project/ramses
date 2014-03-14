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

package fr.tpt.aadl.ramses.control.cli.instantiation ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.xtext.resource.IResourceServiceProvider ;
import org.eclipse.xtext.resource.XtextResource ;
import org.eclipse.xtext.resource.XtextResourceSet ;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl ;
import org.osate.core.OsateCorePlugin ;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval ;

import com.google.inject.Inject ;
import com.google.inject.Injector ;

import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelsManagerImpl ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlResourceValidator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

public class StandAloneInstantiator extends AadlModelsManagerImpl
{
  OsateCorePlugin corePlugin = new OsateCorePlugin();

  private static final Aadl2StandaloneLinking aadlStandAloneSetup =
        new Aadl2StandaloneLinking() ;
  private static final Injector injector = aadlStandAloneSetup
        .createInjectorAndDoEMFRegistration() ;
  private static final XtextResourceSet resourceSet = injector
        .getInstance(XtextResourceSet.class) ;
  
  @Inject
  private ResourceDescriptionsProvider rdp = injector.getInstance(ResourceDescriptionsProvider.class); 
	 
  @Inject 
  private IResourceServiceProvider.Registry rspr = injector.getInstance(IResourceServiceProvider.Registry.class);
  
  private static Logger _LOGGER = Logger.getLogger(StandAloneInstantiator.class) ;
  
  public StandAloneInstantiator(AnalysisErrorReporterManager errManager,
                                IProgressMonitor monitor)
  {
    super(errManager, monitor) ;

    try
    {
      corePlugin.registerInjectorFor("org.osate.xtext.aadl2.properties.Properties",
                                     injector) ;
    }
    catch(Exception e)
    {
      String msg = RamsesException.formatRethrowMessage("initialization error",
                                                        e);
      _LOGGER.fatal(msg, e);
      ServiceProvider.SYS_ERR_REP.fatal(msg, e);
      java.lang.System.exit(-1) ;
    }

    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
                                      .put("aaxl2",
                                           new Aadl2ResourceFactoryImpl()) ;

    EMFIndexRetrieval.registerResourceProviders(rdp, rspr) ;
  }

  private Resource parse(File aadlFile)
  {
    // Must specify file protocol. Otherwise, got resource doesn't exist when
    // using OSGi mechanism.
    // TODO: implement test osgi and add "file:" in case osgi is used
    URI uri = URI.createFileURI(aadlFile.getAbsolutePath().toString()) ;
    
    Resource input_resource = resourceSet.getResource(uri, true) ;
    if(input_resource.getErrors().isEmpty() == false)
    {
      for(org.eclipse.emf.ecore.resource.Resource.Diagnostic diag : input_resource
            .getErrors())
      {
        // Reports OSATE parsing error.
        String filename = aadlFile.toString() ;
        int line = diag.getLine() ;
        String message = diag.getMessage() ;
        ServiceRegistry.PARSE_ERR_REPORTER.error(filename, line,
                                                 "(from OSATE) " + message) ;
      }
    }
    else
    {
      return input_resource ;
    }

    return null ;
  }

  public List<Resource> parse(List<File> aadlFiles)
  {
    return this.parse(aadlFiles, true) ;
  }

  public List<Resource> parse(List<File> aadlFiles,
                              boolean loadOption)
  {
    List<Resource> result = new ArrayList<Resource>() ;
    boolean existParsingErrors = false ;
    resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, loadOption) ;
    for(File s : aadlFiles)
    {
      Resource r = this.parse(s) ;

      if(r != null)
      {
        result.add(r) ;
      }
      else
      {
        existParsingErrors = true ;
      }
    }
    
    AadlResourceValidator.validate(resourceSet) ;
    if(loadOption)
    {
      OsateResourceUtil.setResourceSet(resourceSet);
      Aadl2StandaloneAnnexParserAgent._jobHandler.parseAllAnnexes() ;
      
      // It doesn't resolve annex in case of AADL main code parsing errors.
      // Annex resolution is delegated to the job task but will not be performed
      // at any annex parsing error.
      if(!existParsingErrors)
      {
        Aadl2StandaloneAnnexParserAgent._jobHandler.resolveAllAnnexes() ;
      }
      else
      {
        String msg = "parse error. Note that annexes were not resolved" ;
        _LOGGER.fatal(msg);
        ServiceProvider.SYS_ERR_REP.fatal(msg);
        java.lang.System.exit(-1) ;
      }
    }

    return result ;
  }

  public ResourceSet getAadlResourceSet()
  {
    return resourceSet ;
  }
}