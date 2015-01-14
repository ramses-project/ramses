package fr.tpt.aadl.ramses.transformation.trc.util;

import java.util.ArrayList ;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;

public class RuleApplicationTuple {

	private List<EObject> _patternMatchedElementList = 
	    new ArrayList<EObject>();
	private TrcRule  _transformationRuleName;
	
	
  public List<EObject> getPatternMatchedElement() {
		return _patternMatchedElementList;
	}
	
	public void setPatternMatchedElement(List<EObject> patternMatchedElement) {
		this._patternMatchedElementList = patternMatchedElement;
	}
	
	public TrcRule getTransformationRule() {
		return _transformationRuleName;
	}
	
	public void setTransformationRule(TrcRule transformationRuleName) {
		this._transformationRuleName = transformationRuleName;
	}
  
}
