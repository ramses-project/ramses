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

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.reporters.DefaultMessageReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.MessageReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.StandAloneAnalysisErrorReporterFactory ;
import fr.tpt.aadl.ramses.control.support.reporters.StandAloneInternalErrorReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.StandAloneParseErrorReporter ;

/**
 * This interface specifies the API to register services 
 * in order to plug them inside RAMSES.
 */
public interface ServiceRegistry
{
  public final static MessageReporter MSG_REPORTER =
        new DefaultMessageReporter() ;

  public final static InternalErrorReporter INT_ERR_REPORTER =
        new StandAloneInternalErrorReporter(MSG_REPORTER) ;

  public final static StandAloneParseErrorReporter PARSE_ERR_REPORTER =
        new StandAloneParseErrorReporter(MSG_REPORTER) ;

  public final static AnalysisErrorReporterFactory ANALYSIS_ERR_REPORTER_FACT =
        new StandAloneAnalysisErrorReporterFactory(MSG_REPORTER) ;

  public final static AnalysisErrorReporterManager ANALYSIS_ERR_REPORTER_MANAGER =
        new AnalysisErrorReporterManager(ANALYSIS_ERR_REPORTER_FACT) ;

  /**
   * Initialize the registry. This method has to be called prior calling the
   * others methods.
   * 
   * @param modelInstantiatior the provided AADL model instantiator
   * @param predefinedAadlModels the provided predefined AADL models 
   * @param includeDirs the set of directory paths that may contain AADL model or user code.
   * @throws Exception for any initialization errors 
   */
  public void init(AadlModelInstantiatior modelInstantiatior,
                   PredefinedAadlModelManager predefinedAadlModels) throws Exception ;
  
  /**
   * This method check if the OSGi platform is used or not.
   * OSGi facilities should be used to register services in case
   * it is present.
   * @return true if OSGi platform is used
   */
  public boolean isOSGi() ;

  /**
   * This method returns an object (or service in this context) of type
   * #{@link org.osate.annexsupport.AnnexParser} according to the name
   * of the annex that needs to be parsed.
   * @param annexName the name (aadl id) of the annex that needs to be 
   * parsed
   * @return an object (or service in this context) of type
   * #{@link org.osate.annexsupport.AnnexParser}
   */
  public AnnexParser getParser(String annexName) ;

  /**
   * This method returns an object (or service in this context) of type
   * #{@link org.osate.annexsupport.AnnexResolver} according to the name
   * of the annex for which references need to be resolved.
   * @param annexName the name (aadl id) of the annex that needs to be 
   * parsed
   * @return an object (or service in this context) of type
   * #{@link org.osate.annexsupport.AnnexResolver}
   */
  public AnnexResolver getResolver(String annexName) ;

  /**
   * This method returns an object (or service in this context) of type
   * #{@link org.osate.annexsupport.AnnexUnparser} according to the name
   * of the annex that needs to be unparsed.
   * @param annexName the name (aadl id) of the annex that needs to be 
   * unparsed
   * @return an object (or service in this context) of type
   * #{@link org.osate.annexsupport.AnnexUnparser}
   */
  public AnnexUnparser getUnparser(String annexName) ;

  /**
   * This method lists the name of analysis services that have been plugged
   * in RAMSES.
   * @return list of available analysis identifiers
   */
  public Set<String> getAvailableAnalysisNames() ;

  /**
   * This method returns the on object of type 
   * #{@link fr.tpt.aadl.ramses.control.support.analysis.Analyzer}, which
   * can be used to proceed to the analysis identified by analyzerName.
   * @param analyzerName the name of an analysis
   * @return an object from which the analysis can be launched
   */
  public Analyzer getAnalyzer(String analyzerName) ;

  /**
   * This method lists the name of code generation services that have been plugged
   * in RAMSES.
   * @return list of available code generator identifiers
   */
  public Set<String> getAvailableGeneratorNames() ;

  /**
   * This method returns the on object of type 
   * #{@link fr.tpt.aadl.ramses.control.support.generator.Generator}, which
   * can be used to proceed to the codeGeneration identified by generatorName.
   * @param generatorName the name of a code generator
   * @return an object from which the code generation can be launched
   */
  public Generator getGenerator(String generatorName) ;
  
  /**
   * This method returns the number of errors that occurred during 
   * TODO: check if this is normal... 
   * @return number of errors
   */
  public int getNbError() ;
  
  public AadlModelInstantiatior getModelInstantiatior() ;
  
  public PredefinedAadlModelManager getPredefinedAadlModels() ;
}
