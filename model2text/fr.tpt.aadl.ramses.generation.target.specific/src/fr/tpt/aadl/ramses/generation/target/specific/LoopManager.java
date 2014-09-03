package fr.tpt.aadl.ramses.generation.target.specific;

import java.io.IOException ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;

public interface LoopManager
{

  String getResolutionMethodName() ;

  Map<? extends String, ? extends Resource> processLoop() throws AnalysisException, ParseException, TransformationException, ConfigurationException, IOException ;

}
