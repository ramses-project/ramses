package fr.tpt.aadl.model.transformation.cli ;

import java.util.HashMap ;
import java.util.Map ;
import java.util.Set ;

import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;
import org.osate.annexsupport.AnnexUnparser ;

import fr.tpt.aadl.annex.behavior.AadlBaParserAction ;
import fr.tpt.aadl.annex.behavior.AadlBaResolver ;
import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction ;
import fr.tpt.aadl.c.unparser.annex.behavior.AadlBaToCUnparserAction ;
import fr.tpt.aadl.launch.WCETAnalysis ;
import fr.tpt.aadl.toolsuite.support.analysis.Analyzer ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistry ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;

public class StaticServiceRegistry implements ServiceRegistry
{

  private Map<String, AnnexParser> _parsers =
        new HashMap<String, AnnexParser>() ;
  private Map<String, AnnexUnparser> _unparsers =
        new HashMap<String, AnnexUnparser>() ;
  private Map<String, AnnexResolver> _resolvers =
        new HashMap<String, AnnexResolver>() ;
  private Map<String, Analyzer> _analyzers = new HashMap<String, Analyzer>() ;

  private Map<String, Generator> _trans = new HashMap<String, Generator>() ;

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
//    _trans.put(PokGenerator.GENERATOR_NAME, new PokGenerator()) ;
  }

  @Override
  public AnnexParser getParser(String annexName)
  {
    return _parsers.get(annexName) ;
  }

  @Override
  public AnnexResolver getResolver(String annexName)
  {
    return _resolvers.get(annexName) ;
  }

  @Override
  public AnnexUnparser getUnparser(String annexName)
  {
    return _unparsers.get(annexName) ;
  }

  @Override
  public Set<String> getAvailableAnalysisNames()
  {
    return _analyzers.keySet() ;
  }

  @Override
  public Set<String> getAvailableTransformationNames()
  {
    return _trans.keySet() ;
  }

  @Override
  public Analyzer getAnalyzer(String analyzerName)
  {
    return _analyzers.get(analyzerName) ;
  }

  public Generator getTransformation(String TransformationName)
  {
    return _trans.get(TransformationName) ;
  }

  @Override
  public boolean isOSGi()
  {
    return false ;
  }
}