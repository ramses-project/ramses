package fr.tpt.aadl.ramses.transformation.selection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;
import fr.tpt.aadl.ramses.transformation.tip.util.TipUtils;

public class RuleApplicationUtils {

    static Map<String, List> rulesInheritenceMap = new HashMap<String, List>();
	
	public static Map<String, List> getRulesInheritenceMap() {
		return rulesInheritenceMap;
	}
	
	public static void setTransformationToApply(Entry<List<EObject>, ArrayList<String>> tupleWithAlternatives, 
			String transformationToApply,
			ArrayList<ElementTransformation> tuplesToApply)
	{
		ElementTransformation et = TipUtils.createElementTransformation((List<EObject>) tupleWithAlternatives.getKey(), transformationToApply);
		tuplesToApply.add(et);
		// Exclude not selected rules
		for(String s: tupleWithAlternatives.getValue())
		{
			List<String> toExclude = new ArrayList<String>();
			if(s.equals(transformationToApply))
				continue;
			toExclude.add(s);
			// we cut the branch as close as possible from the trunk
			List<String> inheritedRulesForInclusion = rulesInheritenceMap.get(transformationToApply);
			if(inheritedRulesForInclusion.contains(s))
				continue;
			List<String> inheritedRulesForExclusion = rulesInheritenceMap.get(s);

			if(inheritedRulesForExclusion!=null && inheritedRulesForExclusion.size()>0)
			{
				for(int i=inheritedRulesForExclusion.size()-1;i>=0;i--)
				{
					if(inheritedRulesForInclusion.contains(inheritedRulesForExclusion.get(i)))
						continue;
					if(false == inheritedRulesForExclusion.get(i).equals(transformationToApply))
					{
						toExclude.add(inheritedRulesForExclusion.get(i));
					}
				}
			}
			for(String toExcludeRule: toExclude)
			{
			  ElementTransformation exc = TipUtils.createElementTransformation((List<EObject>) tupleWithAlternatives.getKey(), toExcludeRule);
			  exc.setIsExclusion(true);
			  tuplesToApply.add(exc);
			}
		}
	}

	public static void clean()
	{
		rulesInheritenceMap.clear();
	}

}
