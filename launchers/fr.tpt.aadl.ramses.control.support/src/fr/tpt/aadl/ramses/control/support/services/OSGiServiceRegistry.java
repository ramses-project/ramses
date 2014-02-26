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

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.ConfigStatus ;
import fr.tpt.aadl.ramses.control.support.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.Names ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalyzerFactory ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.GeneratorFactory ;
import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin ;

public class OSGiServiceRegistry extends AbstractServiceRegistry implements ServiceRegistry
{
  private AnnexParserRegistry _parserRegistry ;
  private AnnexResolverRegistry _resolverRegistry ;
  private AnnexUnparserRegistry _unparserRegistry ;

  private Map<String, Analyzer> _analyzersRegistry =
        new HashMap<String, Analyzer>() ;

  private Map<String, Generator> _genRegistry =
        new HashMap<String, Generator>() ;
  
  private AadlModelInstantiatior _modelInstantiatior ;
  private PredefinedAadlModelManager _predefinedAadlModels ;

  @Override
  public void init(AadlModelInstantiatior modelInstantiatior,
                   PredefinedAadlModelManager predefinedAadlModels)
                                                   throws ConfigurationException
  {
    _modelInstantiatior = modelInstantiatior ;
    _predefinedAadlModels = predefinedAadlModels ;
    
    _parserRegistry =
          (AnnexParserRegistry) AnnexRegistry
                .getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID) ;
    _resolverRegistry =
          (AnnexResolverRegistry) AnnexRegistry
                .getRegistry(AnnexRegistry.ANNEX_RESOLVER_EXT_ID) ;
    _unparserRegistry =
          (AnnexUnparserRegistry) AnnexRegistry
                .getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID) ;
    initialize(_analyzersRegistry, Names.ANALYSIS_EXT_ID, modelInstantiatior,
                 predefinedAadlModels) ;
    initialize(_genRegistry, Names.GENERATOR_EXT_ID, modelInstantiatior,
                 predefinedAadlModels) ;
  }

  @SuppressWarnings("all")
  private void initialize(Map registry,
                          String extensionId,
                          AadlModelInstantiatior modelInstantiatior,
                          PredefinedAadlModelManager predefinedAadlModels)
                                                   throws ConfigurationException
  {
    IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry() ;
    IExtensionPoint extensionPoint =
          extensionRegistry
                .getExtensionPoint(Names.RAMSES_SUPPORT_PLUGIN_ID,
                                   extensionId) ;
    if(extensionPoint!=null)
    {
    	IExtension[] exts = extensionPoint.getExtensions() ;

    	for(int i = 0 ; i < exts.length ; i++)
    	{
    		IConfigurationElement[] configElems = exts[i].getConfigurationElements() ;

    		for(int j = 0 ; j < configElems.length ; j++)
    		{
    			if(extensionId==Names.GENERATOR_EXT_ID)
    			{
    				try
    				{
    				  GeneratorFactory factory = (GeneratorFactory) configElems[j]
                    .createExecutableExtension(Names.ATT_CLASS) ;
    				  Generator gen = factory.createGenerator(modelInstantiatior,
                                                      predefinedAadlModels);
    				  registry.put(gen.getRegistryName(), gen) ;
    				}
    				catch (CoreException e)
    				{
    				  ConfigStatus.NOT_FOUND.msg = "generator factory \'" + 
    				                               configElems[j].getName() +
    				                               "\' is not found" ;
    				  throw new ConfigurationException(ConfigStatus.NOT_FOUND) ;
    				}
    			}
    			else if(extensionId==Names.ANALYSIS_EXT_ID)
    			{
    				try
    				{
    				  AnalyzerFactory factory = (AnalyzerFactory) configElems[j]
                    .createExecutableExtension(Names.ATT_CLASS) ;

    				  Analyzer analyzer = factory.createAnalyzer(modelInstantiatior,
                                                         predefinedAadlModels) ;
    				  registry.put(analyzer.getRegistryName(), analyzer) ;
    				}
    				catch (CoreException e)
            {
              ConfigStatus.NOT_FOUND.msg = "analyzer factory \'" + 
                                           configElems[j].getName() +
                                           "\' is not found" ;
              throw new ConfigurationException(ConfigStatus.NOT_FOUND) ;
            }
    			}
    			else // XXX What is it about ???
    			{
    			  try
    			  {
    			    NamedPlugin instance =
                    (NamedPlugin) configElems[j]
                        .createExecutableExtension(Names.ATT_CLASS) ;
              registry.put(instance.getRegistryName(), instance) ;
    			  }
            catch (CoreException e)
            {
              ConfigStatus.NOT_FOUND.msg = "plugin factory \'" + 
                                           configElems[j].getName() +
                                           "\' is not found" ;
              throw new ConfigurationException(ConfigStatus.NOT_FOUND) ;
            }
    			}
    		}
    	}
    }
  }

  @Override
  public AnnexParser getParser(String annexName)
  {
    return _parserRegistry.getAnnexParser(annexName.toLowerCase()) ;
  }

  @Override
  public AnnexResolver getResolver(String annexName)
  {
    return _resolverRegistry.getAnnexResolver(annexName.toLowerCase()) ;
  }

  @Override
  public AnnexUnparser getUnparser(String annexName)
  {
    return _unparserRegistry.getAnnexUnparser(annexName.toLowerCase()) ;
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
  
  @Override
  public AadlModelInstantiatior getModelInstantiatior()
  {
    return _modelInstantiatior ;
  }

  @Override
  public PredefinedAadlModelManager getPredefinedAadlModels()
  {
    return _predefinedAadlModels ;
  }
}