package fr.tpt.aadl.ramses.control.osate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexResolver;
import org.osate.annexsupport.AnnexUnparser;

import fr.tpt.aadl.ramses.control.support.analysis.Analyzer;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.generation.c.annex.behavior.AadlBaToCUnparserAction;

public class OsateServiceRegistry implements ServiceRegistry {

	
	public OsateServiceRegistry() {
		_unparsers.put(AadlBaToCUnparserAction.ANNEX_NAME,
		  		(AnnexUnparser) new AadlBaToCUnparserAction()) ;
	}

	private Map<String, AnnexUnparser> _unparsers =
	        new HashMap<String, AnnexUnparser>() ;
	
	@Override
	public boolean isOSGi() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AnnexParser getParser(String annexName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnexResolver getResolver(String annexName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnexUnparser getUnparser(String annexName) {
		return _unparsers.get(annexName);
	}

	@Override
	public Set<String> getAvailableAnalysisNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Analyzer getAnalyzer(String analyzerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getAvailableGeneratorNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Generator getGenerator(String generator) {
		// TODO Auto-generated method stub
		return null;
	}

}
