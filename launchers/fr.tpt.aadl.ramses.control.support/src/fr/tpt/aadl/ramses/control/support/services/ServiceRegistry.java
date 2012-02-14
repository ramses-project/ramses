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

package fr.tpt.aadl.ramses.control.support.services ;

import java.util.Set ;

import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterFactory ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;
import org.osate.annexsupport.AnnexUnparser ;

import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.reporters.MessageReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.StandAloneAnalysisErrorReporterFactory ;
import fr.tpt.aadl.ramses.control.support.reporters.StandAloneInternalErrorReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.StandAloneParseErrorReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.StdOutputMessageReporter ;

public interface ServiceRegistry
{
  public final static MessageReporter MSG_REPORTER =
        new StdOutputMessageReporter() ;

  public final static InternalErrorReporter INT_ERR_REPORTER =
        new StandAloneInternalErrorReporter(MSG_REPORTER) ;

  public final static StandAloneParseErrorReporter PARSE_ERR_REPORTER =
        new StandAloneParseErrorReporter(MSG_REPORTER) ;

  public final static AnalysisErrorReporterFactory ANALYSIS_ERR_REPORTER_FACT =
        new StandAloneAnalysisErrorReporterFactory(MSG_REPORTER) ;

  public final static AnalysisErrorReporterManager ANALYSIS_ERR_REPORTER_MANAGER =
        new AnalysisErrorReporterManager(INT_ERR_REPORTER,
              ANALYSIS_ERR_REPORTER_FACT) ;

  public boolean isOSGi() ;

  public AnnexParser getParser(String annexName) ;

  public AnnexResolver getResolver(String annexName) ;

  public AnnexUnparser getUnparser(String annexName) ;

  public Set<String> getAvailableAnalysisNames() ;

  public Analyzer getAnalyzer(String analyzerName) ;

  public Set<String> getAvailableGeneratorNames() ;

  public Generator getGenerator(String generator) ;
}
