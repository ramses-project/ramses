package fr.tpt.aadl.ramses.transformation.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;

public interface ITransformationSelection {

	public void selectTransformation (Map<List<EObject>, ArrayList<String>> patternMatchingMap, ArrayList<ElementTransformation> tuplesToApply) throws Exception;
	
}
