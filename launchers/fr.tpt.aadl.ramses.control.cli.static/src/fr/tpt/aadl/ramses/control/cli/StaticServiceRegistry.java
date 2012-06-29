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

import fr.tpt.aadl.annex.behavior.AadlBaParserAction;
import fr.tpt.aadl.annex.behavior.AadlBaResolver;
import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction;
import fr.tpt.aadl.launch.WCETAnalysis;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.generation.c.annex.behavior.AadlBaToCUnparserAction;
import fr.tpt.aadl.ramses.generation.osek.OSEKGeneratorFactory;
import fr.tpt.aadl.ramses.generation.pok.PokGeneratorFactory;
import fr.tpt.aadl.ramses.generation.pokTT.PokTTGeneratorFactory ;

public class StaticServiceRegistry implements ServiceRegistry
{

  private Map<String, AnnexParser> _parsers =
        new HashMap<String, AnnexParser>() ;
  private Map<String, AnnexUnparser> _unparsers =
        new HashMap<String, AnnexUnparser>() ;
  private Map<String, AnnexResolver> _resolvers =
        new HashMap<String, AnnexResolver>() ;
  private Map<String, Analyzer> _analyzers = new HashMap<String, Analyzer>() ;

  private Map<String, Generator> _gen = new HashMap<String, Generator>() ;

  public StaticServiceRegistry()
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
    _analyzers.put(WCETAnalysis.ANALYZER_NAME, new WCETAnalysis()) ;
    
    Generator genPok = PokGeneratorFactory.createPokGenerator(false) ;
    Generator genPokTT = PokTTGeneratorFactory.createPokTTGenerator(false) ;
    Generator genOsek = OSEKGeneratorFactory.createOSEKGenerator(false);
    
    _gen.put(genPok.getRegistryName(), genPok) ;
    _gen.put(genPokTT.getRegistryName(), genPokTT) ;
    _gen.put(genOsek.getRegistryName(), genOsek) ;
  }

  @Override
  public AnnexParser getParser(String annexName)
  {
    return _parsers.get(annexName.toLowerCase()) ;
  }

  @Override
  public AnnexResolver getResolver(String annexName)
  {
    return _resolvers.get(annexName.toLowerCase()) ;
  }

  @Override
  public AnnexUnparser getUnparser(String annexName)
  {
    return _unparsers.get(annexName.toLowerCase()) ;
  }

  @Override
  public Set<String> getAvailableAnalysisNames()
  {
    return _analyzers.keySet() ;
  }

  @Override
  public Set<String> getAvailableGeneratorNames()
  {
    return _gen.keySet() ;
  }

  @Override
  public Analyzer getAnalyzer(String analyzerName)
  {
    return _analyzers.get(analyzerName) ;
  }

  public Generator getGenerator(String TransformationName)
  {
    return _gen.get(TransformationName) ;
  }

  @Override
  public boolean isOSGi()
  {
    return false ;
  }
}