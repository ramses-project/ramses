package fr.tpt.aadl.ramses.transformation.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;

public interface ITransformationSelection {

	public void selectTransformation (Map<List<EObject>, ArrayList<TrcRule>> patternMatchingMap, ArrayList<ElementTransformation> tuplesToApply);

  boolean shouldSelectionContinue() ;
	
}
