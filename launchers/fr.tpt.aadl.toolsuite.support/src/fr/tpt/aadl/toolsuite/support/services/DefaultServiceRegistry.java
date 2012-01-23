package fr.tpt.aadl.toolsuite.support.services ;

import java.util.HashSet ;
import java.util.Set ;

import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;
import org.osate.annexsupport.AnnexUnparser ;

import fr.tpt.aadl.toolsuite.support.analysis.Analyzer ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;

public class DefaultServiceRegistry implements ServiceRegistry
{
  @Override
  public AnnexParser getParser(String name)
  {
    return null ;
  }

  @Override
  public AnnexResolver getResolver(String name)
  {
    return null ;
  }

  @Override
  public AnnexUnparser getUnparser(String annexName)
  {
    return null ;
  }

  @Override
  public Set<String> getAvailableAnalysisNames()
  {
    return new HashSet<String>(0) ;
  }

  @Override
  public Set<String> getAvailableTransformationNames()
  {
    return new HashSet<String>(0) ;
  }

  @Override
  public Analyzer getAnalyzer(String analyzerName)
  {
    return null ;
  }

  @Override
  public Generator getGenerator(String name)
  {
    return null ;
  }

  @Override
  public boolean isOSGi()
  {
    return false ;
  }
}
