package fr.tpt.aadl.ramses.transformation.trc.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class RuleApplicationTulpe {

	private List<EObject> _patternMatchedElementList;
	private String  _transformationRuleName;
	
	
  public List<EObject> getPatternMatchedElement() {
		return _patternMatchedElementList;
	}
	
	public void setPatternMatchedElement(List<EObject> patternMatchedElement) {
		this._patternMatchedElementList = patternMatchedElement;
	}
	
	public String getTransformationRuleName() {
		return _transformationRuleName;
	}
	
	public void setTransformationRuleName(String transformationRuleName) {
		this._transformationRuleName = transformationRuleName;
	}
  
}
