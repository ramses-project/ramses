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

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.emf.common.util.Diagnostic ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.util.Diagnostician ;
import org.eclipse.xtext.resource.XtextResource ;
import org.eclipse.xtext.resource.XtextResourceSet ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.instantiation.InstantiateModel ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl ;
import org.osate.aadl2.util.Aadl2ResourceImpl ;
import org.osate.core.OsateCorePlugin ;

import com.google.inject.Injector ;

import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

public class StandAloneInstantiator
{

  private static StandAloneInstantiator _instantiator ;
  private InstantiateModel instantiateModel ;
  private ResourceSet aadlResourceSet = new ResourceSetImpl() ;
  private Aadl2StandaloneLinking aadlStandAloneSetup =
        new Aadl2StandaloneLinking() ;
  private final Injector injector = aadlStandAloneSetup
        .createInjectorAndDoEMFRegistration() ;
  private final XtextResourceSet resourceSet = injector
        .getInstance(XtextResourceSet.class) ;

  private OsateCorePlugin corePlugin = new OsateCorePlugin();
  
  // Singleton
  protected StandAloneInstantiator()
  {
    instantiateModel =
          new InstantiateModel(new NullProgressMonitor(),
                ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER) ;
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
          .put("aaxl2", new Aadl2ResourceFactoryImpl()) ;
  }

  public static StandAloneInstantiator getInstantiator()
  {
    if(_instantiator == null)
    {
      _instantiator = new StandAloneInstantiator() ;
    }

    return _instantiator ;
  }

  public List<Resource> getAllResources()
  {
    return resourceSet.getResources() ;
  }

  public SystemInstance instantiate(List<Resource> models,
                                    String systemToInstantiate)
  {
    for(Resource r : models)
    {
      AadlPackage aadlPackage ;

      if(r.getContents().get(0) instanceof AadlPackage)
      {
        aadlPackage = (AadlPackage) r.getContents().get(0) ;
      }
      else
      {
        continue ;
      }

      for(NamedElement member : aadlPackage.getOwnedPublicSection()
            .getOwnedMembers())
      {
        if(member instanceof SystemImplementation)
        {
          SystemImplementation toInstantiate = (SystemImplementation) member ;

          if(toInstantiate.getName().equals(systemToInstantiate))
          {
            URI instanceURI =
                  OsateResourceUtil.getInstanceModelURI(toInstantiate) ;
            Aadl2ResourceImpl aadlResource =
                  (Aadl2ResourceImpl) aadlResourceSet.getResource(instanceURI,
                                                                  false) ;

            if(aadlResource == null)
            {
              aadlResource =
                    (Aadl2ResourceImpl) aadlResourceSet
                          .createResource(instanceURI) ;
            }

            return instantiateModel.createSystemInstanceInt(toInstantiate,
                                                            aadlResource) ;
          }
        }
      }
    }

    return null ;
  }

  private Resource parse(File aadlFile)
  {
    // Must specify file protocol. Otherwise, got resource doesn't exist when
    // using OSGi mechanism.
    //TODO: implemente test osgi and add "file:" in case osgi is used
    URI uri = URI.createFileURI(aadlFile.toString()) ;
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
    resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, loadOption) ;
    boolean existParsingErrors = false ;

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

    this.validate() ;
    Aadl2StandaloneAnnexParserAgent._jobHandler.parseAllAnnexes() ;

    if(!existParsingErrors &&
          ServiceRegistry.PARSE_ERR_REPORTER.getNumErrors() == 0)
    {
      Aadl2StandaloneAnnexParserAgent._jobHandler.resolveAllAnnexes() ;
    }
    else
    {
      System.err.println("Exit on parse error") ;
      java.lang.System.exit(-1) ;
    }

    return result ;
  }

  public void validate()
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

  public void serialize(Resource transfoResult,
                        String targetFileName)
  {
    // serialization code
    //Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();
    //XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
    //    XtextResource resource = (XtextResource)resourceSet.createResource(URI.createURI(targetFileName));
    //    resource.getContents().add(transfoResult.getContents().get(0));
    //    SaveOptions.Builder sb = SaveOptions.newBuilder();
    //    Map<Object,Object> options = new HashMap();
    //    sb.getOptions().addTo(options);
    //    try {
    //      resource.save(options);
    //    } catch (IOException e) {
    //      e.printStackTrace();
    //    }
    String resultFileContent =
          Aadl2StandaloneUnparser.getAadlUnparser()
                .doUnparse((Element) transfoResult.getContents().get(0)) ;

    try
    {
      BufferedWriter out = new BufferedWriter(new FileWriter(targetFileName)) ;
      out.write(resultFileContent) ;
      out.close() ;
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }

    java.lang.System.out.println("Serialized result in: " + targetFileName) ;
  }

  public ResourceSet getAadlResourceSet()
  {
    return resourceSet ;
  }
}
