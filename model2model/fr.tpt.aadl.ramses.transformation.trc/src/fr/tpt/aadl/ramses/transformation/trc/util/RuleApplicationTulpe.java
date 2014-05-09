package fr.tpt.aadl.ramses.transformation.trc.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class RuleApplicationTulpe {

	List<EObject> patternMatchedElementList;
	
	public List<EObject> getPatternMatchedElement() {
		return patternMatchedElementList;
	}
	
	public void setPatternMatchedElement(List<EObject> patternMatchedElement) {
		this.patternMatchedElementList = patternMatchedElement;
	}
	
	String  transformationRuleName;
	
	public String getTransformationRuleName() {
		return transformationRuleName;
	}
	
	public void setTransformationRuleName(String transformationRuleName) {
		this.transformationRuleName = transformationRuleName;
	}
	
}
