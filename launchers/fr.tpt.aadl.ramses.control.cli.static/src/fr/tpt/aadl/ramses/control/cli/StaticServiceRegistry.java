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

package fr.tpt.aadl.ramses.control.cli ;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexResolver;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.ba.AadlBaParserAction ;
import org.osate.ba.AadlBaResolver ;
import org.osate.ba.AadlBaUnParserAction ;

import fr.tpt.aadl.launch.AADLInspectorSchedulingAnalysis;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer;
import fr.tpt.aadl.ramses.control.support.generator.AbstractGeneratorFactory;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.AbstractServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.generation.ada.annex.behavior.AadlBaToADAUnparserAction;
import fr.tpt.aadl.ramses.generation.c.annex.behavior.AadlBaToCUnparserAction;
import fr.tpt.aadl.ramses.generation.launcher.adaravenscar.AdaRavenscarGeneratorFactory;
import fr.tpt.aadl.ramses.generation.osek.OSEKGeneratorFactory;
import fr.tpt.aadl.ramses.generation.pok.ada.AdaPokGeneratorFactory;
import fr.tpt.aadl.ramses.generation.pok.c.PokGeneratorFactory;
import fr.tpt.aadl.sched.wcetanalysis.WcetAnalysis;

/**
 * This class implements the API to register statically services into RAMSES. These
 * services are used in the standalone Java version of RAMSES.
 */
public class StaticServiceRegistry extends AbstractServiceRegistry implements ServiceRegistry
{

  private Map<String, AnnexParser> _parsers =
        new HashMap<String, AnnexParser>() ;
  private Map<String, AnnexUnparser> _unparsers =
        new HashMap<String, AnnexUnparser>() ;
  private Map<String, AnnexResolver> _resolvers =
        new HashMap<String, AnnexResolver>() ;
  private Map<String, Analyzer> _analyzers = new HashMap<String, Analyzer>() ;

  private Map<String, Generator> _gen = new HashMap<String, Generator>() ;

  StaticServiceRegistry()
        throws Exception
  {
    // Setup AADLBA Front End parser, resolver and unparser.
    _parsers.put(AadlBaParserAction.ANNEX_NAME, new AadlBaParserAction()) ;
    _parsers.put(AadlBaToCUnparserAction.ANNEX_NAME, new AadlBaParserAction()) ;
    _resolvers.put(AadlBaResolver.ANNEX_NAME, new AadlBaResolver()) ;
    _resolvers.put(AadlBaToCUnparserAction.ANNEX_NAME, new AadlBaResolver()) ;
    _unparsers.put(AadlBaUnParserAction.ANNEX_NAME, new AadlBaUnParserAction()) ;
    _unparsers.put(AadlBaToCUnparserAction.ANNEX_NAME,
                   new AadlBaToCUnparserAction()) ;
    _unparsers.put(AadlBaToADAUnparserAction.ANNEX_NAME,
            new AadlBaToADAUnparserAction()) ;
    
    _analyzers.put(WcetAnalysis.PLUGIN_NAME, new WcetAnalysis());
    _analyzers.put(AADLInspectorSchedulingAnalysis.PLUGIN_NAME, new AADLInspectorSchedulingAnalysis());
    
    AbstractGeneratorFactory pokGeneratorFactory = new PokGeneratorFactory();
    AbstractGeneratorFactory oSEKGeneratorFactory =new OSEKGeneratorFactory();
    AbstractGeneratorFactory adaGeneratorFactory = new AdaPokGeneratorFactory();
    AbstractGeneratorFactory adaRavenscarGeneratorFactory = new AdaRavenscarGeneratorFactory();
    
    Generator genPok = pokGeneratorFactory.createGenerator() ;
    Generator genOsek = oSEKGeneratorFactory.createGenerator();
    Generator genAda = adaGeneratorFactory.createGenerator();
    Generator genAdaRavenscar = adaRavenscarGeneratorFactory.createGenerator();
    
    
    _gen.put(genPok.getRegistryName(), genPok) ;
    _gen.put(genOsek.getRegistryName(), genOsek) ;
    _gen.put(genAda.getRegistryName(), genAda) ;
    _gen.put(genAdaRavenscar.getRegistryName(), genAdaRavenscar) ;

  }

  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#getParser(String)
   */
  @Override
  public AnnexParser getParser(String annexName)
  {
    return _parsers.get(annexName.toLowerCase()) ;
  }

  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#getResolver(String)
   */
  @Override
  public AnnexResolver getResolver(String annexName)
  {
    return _resolvers.get(annexName.toLowerCase()) ;
  }

  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#getUnparser(String)
   */
  @Override
  public AnnexUnparser getUnparser(String annexName)
  {
    return _unparsers.get(annexName.toLowerCase()) ;
  }

  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#getAvailableAnalysisNames()
   */
  @Override
  public Set<String> getAvailableAnalysisNames()
  {
    return _analyzers.keySet() ;
  }

  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#getAvailableGeneratorNames()
   */
  @Override
  public Set<String> getAvailableGeneratorNames()
  {
    return _gen.keySet() ;
  }

  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#getAnalyzer()
   */  
  @Override
  public Analyzer getAnalyzer(String analyzerName)
  {
    return _analyzers.get(analyzerName) ;
  }

  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#getGenerator()
   */ 
  @Override
  public Generator getGenerator(String TransformationName)
  {
    return _gen.get(TransformationName) ;
  }
  
  /**
   *  @see fr.tpt.aadl.ramses.control.support.services.ServiceRegistry#isOSGi()
   */ 
  @Override
  public boolean isOSGi()
  {
    return false ;
  }
}