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

package fr.tpt.aadl.ramses.control.cli.osgi ;

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

import fr.tpt.aadl.ramses.control.support.Names ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

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
    initialize(_genRegistry, Names.GENERATOR_EXT_ID) ;
  }

  @SuppressWarnings("all")
  private void initialize(Map registry,
                          String extensionId)
        throws CoreException
  {
    IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry() ;
    IExtensionPoint extensionPoint =
          extensionRegistry
                .getExtensionPoint(Names.RAMSES_SUPPORT_PLUGIN_ID,
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
  public Set<String> getAvailableGeneratorNames()
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
