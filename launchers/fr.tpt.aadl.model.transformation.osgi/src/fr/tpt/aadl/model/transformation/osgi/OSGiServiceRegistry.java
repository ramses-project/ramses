package fr.tpt.aadl.model.transformation.osgi ;

import java.util.HashMap ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.IConfigurationElement ;
import org.eclipse.core.runtime.IExtension ;
import org.eclipse.core.runtime.IExtensionPoint ;
import org.eclipse.core.runtime.IExtensionRegistry ;
import org.eclipse.core.runtime.Platform ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexParserRegistry ;
import org.osate.annexsupport.AnnexRegistry ;
import org.osate.annexsupport.AnnexResolver ;
import org.osate.annexsupport.AnnexResolverRegistry ;
import org.osate.annexsupport.AnnexUnparser ;
import org.osate.annexsupport.AnnexUnparserRegistry ;

import fr.tpt.aadl.toolsuite.support.Names ;
import fr.tpt.aadl.toolsuite.support.analysis.Analyzer ;
import fr.tpt.aadl.toolsuite.support.plugins.NamedPlugin ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistry ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;

public class OSGiServiceRegistry implements ServiceRegistry
{
  private AnnexParserRegistry _parserRegistry ;
  private AnnexResolverRegistry _resolverRegistry ;
  private AnnexUnparserRegistry _unparserRegistry ;

  private Map<String, Analyzer> _analyzersRegistry =
        new HashMap<String, Analyzer>() ;

  private Map<String, Generator> _genRegistry =
        new HashMap<String, Generator>() ;

  public OSGiServiceRegistry()
        throws CoreException
  {
    _parserRegistry =
          (AnnexParserRegistry) AnnexRegistry
                .getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID) ;
    _resolverRegistry =
          (AnnexResolverRegistry) AnnexRegistry
                .getRegistry(AnnexRegistry.ANNEX_RESOLVER_EXT_ID) ;
    _unparserRegistry =
          (AnnexUnparserRegistry) AnnexRegistry
                .getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID) ;
    initialize(_analyzersRegistry, Names.ANALYSIS_EXT_ID) ;
    initialize(_genRegistry, Names.TRANSFORMATION_EXT_ID) ;
  }

  @SuppressWarnings("all")
  private void initialize(Map registry,
                          String extensionId)
        throws CoreException
  {
    IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry() ;
    IExtensionPoint extensionPoint =
          extensionRegistry
                .getExtensionPoint(Names.TOOLSUITE_SUPPORT_PLUGIN_ID,
                                   extensionId) ;
    IExtension[] exts = extensionPoint.getExtensions() ;

    for(int i = 0 ; i < exts.length ; i++)
    {
      IConfigurationElement[] configElems = exts[i].getConfigurationElements() ;

      for(int j = 0 ; j < configElems.length ; j++)
      {
        NamedPlugin instance =
              (NamedPlugin) configElems[j]
                    .createExecutableExtension(Names.ATT_CLASS) ;
        registry.put(instance.getRegistryName(), instance) ;
      }
    }
  }

  @Override
  public AnnexParser getParser(String annexName)
  {
    return _parserRegistry.getAnnexParser(annexName) ;
  }

  @Override
  public AnnexResolver getResolver(String annexName)
  {
    return _resolverRegistry.getAnnexResolver(annexName) ;
  }

  @Override
  public AnnexUnparser getUnparser(String annexName)
  {
    return _unparserRegistry.getAnnexUnparser(annexName) ;
  }

  @Override
  public Set<String> getAvailableAnalysisNames()
  {
    return _analyzersRegistry.keySet() ;
  }

  @Override
  public Set<String> getAvailableTransformationNames()
  {
    return _genRegistry.keySet() ;
  }

  @Override
  public Analyzer getAnalyzer(String analyzerName)
  {
    return _analyzersRegistry.get(analyzerName) ;
  }

  @Override
  public Generator getGenerator(String generatorName)
  {
    return _genRegistry.get(generatorName) ;
  }

  @Override
  public boolean isOSGi()
  {
    return true ;
  }
}
