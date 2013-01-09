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

import java.util.List ;

import org.eclipse.emf.ecore.EObject ;
import org.eclipse.xtext.EcoreUtil2 ;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer ;
import org.eclipse.xtext.linking.lazy.LazyLinker ;
import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.DefaultAnnexSubclause ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;

import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;

public class Aadl2StandaloneAnnexParserAgent extends LazyLinker
{
  public static AnnexJobHandler _jobHandler = new AnnexJobHandler() ;

  // TODO : ask Peter to externalize part of the method not to copy/paste osate code

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.xtext.linking.impl.AbstractCleaningLinker#afterModelLinked(org.eclipse.emf.ecore.EObject,
   * org.eclipse.xtext.diagnostics.IDiagnosticConsumer)
   */
  @Override
  protected void afterModelLinked(EObject model,
                                  IDiagnosticConsumer diagnosticsConsumer)
  {
    String filename = model.eResource().getURI().toString() ;
    // set up reporter for ParseErrors
    ParseErrorReporter errReporter = ServiceRegistry.PARSE_ERR_REPORTER ;
    AnalysisErrorReporterManager resolveErrManager =
          ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER ;
    ServiceRegistry registry = ServiceRegistryProvider.getServiceRegistry() ;
    List<DefaultAnnexSubclause> asl =
          EcoreUtil2.eAllOfType(model, DefaultAnnexSubclause.class) ;

    // XXX Processes Behavior Annex only.
    for(DefaultAnnexSubclause defaultAnnexSubclause : asl)
    {
      String annexText = defaultAnnexSubclause.getSourceText() ;
      String annexName = defaultAnnexSubclause.getName() ;
      INode node = NodeModelUtils.findActualNodeFor(defaultAnnexSubclause) ;
      
      int offset = node.getOffset();
      int line = node.getStartLine();
      String sourceText = defaultAnnexSubclause.getSourceText();
      if (sourceText == null) break;
      int nlength = node.getLength();
      int sourcelength = sourceText.length();
      offset = offset + (nlength-sourcelength-1)+3;
      
      if(annexText != null && annexName != null)
      {
        
        if (annexText.length() > 6) {
          annexText = annexText.substring(3, annexText.length() - 3);
        }
        
        AnnexParser ap = registry.getParser(annexName) ;
        AnnexResolver ar = registry.getResolver(annexName) ;
        
        if(ap == null)
        {
          System.err.println("RAMSES doesn't parse " + annexName +
                             "annex subclause ") ; 
        }
        
        if(ar == null)
        {
          System.err.println("RAMSES doesn't resolve " + annexName +
                             "annex subclause ") ; 
        }
        
        _jobHandler.addJob(new AnnexJob(defaultAnnexSubclause, filename, line,
              offset, ap, errReporter, ar, resolveErrManager)) ;
      }
    }
  }
}
