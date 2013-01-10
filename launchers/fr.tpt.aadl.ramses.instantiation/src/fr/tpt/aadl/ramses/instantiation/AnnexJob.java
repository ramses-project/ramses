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

import java.io.File ;
import java.util.Collections ;
import java.util.List ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.DefaultAnnexSubclause ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;

import antlr.RecognitionException ;

public class AnnexJob
{
  private DefaultAnnexSubclause _annex ;

  private String _filename ;

  private int _line ;

  private int _offset ;

  private AnnexParser _parser ;

  private ParseErrorReporter _parserErrReporter ;

  private AnnexResolver _resolver ;

  private List<?> _annexElements ;

  private AnalysisErrorReporterManager _errManager ;
  
  private boolean _hasParsingError = false ;

  // DEBUG
  private String _parentContainer ;

  public AnnexJob(
                  DefaultAnnexSubclause annex, String filename, int line,
                  int offset, AnnexParser parser,
                  ParseErrorReporter parserErrReporter, AnnexResolver resolver,
                  AnalysisErrorReporterManager analysisErrManager)
  {
    _annex = annex ;
    _filename = filename ;
    _line = line ;
    _offset = offset ;
    _parser = parser ;
    _parserErrReporter = parserErrReporter ;
    _resolver = resolver ;
    _errManager = analysisErrManager ;
  }

  public boolean parse()
  {
    boolean result = false ;
    AnnexSubclause as ;
    
    if(_parser != null)
    {
      String annexText = _annex.getSourceText() ;
      String annexName = _annex.getName() ;

      try
      {
        //DEBUG
        String filename = (new File(_filename)).getName() ;
        _parentContainer = ((ComponentClassifier) _annex.eContainer()).getName() ;
        System.out.println("info: Parse " + annexName + " in " +
              _parentContainer + " from " + filename) ;

        if(annexText.length() > 6)
        {
          annexText = annexText.substring(3, annexText.length() - 3) ;
        }
        
        int nb_errors = _parserErrReporter.getNumErrors() ;
        
        as =
              _parser.parseAnnexSubclause(annexName, annexText, _filename, _line,
                                          _offset, _parserErrReporter) ;

        if(as != null && _parserErrReporter.getNumErrors() == nb_errors)
        {
          as.setName(annexName) ;
          // replace default annex library with the new one.
          EList<AnnexSubclause> ael =
                ((Classifier) _annex.eContainer()).getOwnedAnnexSubclauses() ;
          int idx = ael.indexOf(_annex) ;
          ael.add(idx, as) ;
          ael.remove(_annex) ;
          _annexElements = Collections.singletonList(as) ;
          result = true ;
        }
        else
        {
          result = false ;
          _hasParsingError = true ;
        }
      }
      catch(RecognitionException e)
      {
        e.printStackTrace() ;
        result = false ;
      }
    }

    return result ;
  }

  // Caller may add this code after resolve()
  /*
  if(_resolveErrManager.getNumErrors()>0)
  {
     diagnosticsConsumer.consume(
                             new XtextSyntaxDiagnostic(node),
                             Severity.ERROR);
  }
  */
  public boolean resolve()
  {
    if(_resolver != null)
    {
      if(_annexElements != null && ! _hasParsingError)
      {
        //DEBUG
        String filename = (new File(_filename)).getName() ;
        System.out.println("info: Resolve " + _annex.getName() + " in " +
              _parentContainer + " from " + filename) ;
        _resolver.resolveAnnex(_annex.getName(), _annexElements, _errManager) ;
        return _errManager.getNumErrors() == 0 ;
      }
      else
      {
        System.err.println("info: " + _parentContainer + " has parsing errors. Skip resolving for this annex.") ;
        return false ;
      }
    }
    else
    {
      return false ;
    }
  }
}
