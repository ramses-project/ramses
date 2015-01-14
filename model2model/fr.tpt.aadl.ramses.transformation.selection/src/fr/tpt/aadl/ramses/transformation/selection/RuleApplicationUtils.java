package fr.tpt.aadl.ramses.transformation.selection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator ;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.InstanceObject ;

import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;
import fr.tpt.aadl.ramses.transformation.tip.util.TipUtils;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;

public class RuleApplicationUtils {

  static Map<TrcRule, List<TrcRule>> rulesInheritenceMap = new HashMap<TrcRule, List<TrcRule>>();
	
	public static Map<TrcRule, List<TrcRule>> getRulesInheritenceMap() {
		return rulesInheritenceMap;
	}
	
	public static void setTransformationToApply(TransformationRuleAlternative tupleWithAlternatives, 
	                                            TrcRule transformationToApply,
	                                            ArrayList<ElementTransformation> tuplesToApply)
	{
		ElementTransformation et = TipUtils.createElementTransformation((List<EObject>) tupleWithAlternatives.getMatchedElements(), 
		                                                                transformationToApply.getQualifiedName());
		tuplesToApply.add(et);
		// Exclude not selected rules
		for(TrcRule s: tupleWithAlternatives.getAlternativeRules())
		{
			List<String> toExclude = new ArrayList<String>();
			if(s.equals(transformationToApply))
				continue;
			toExclude.add(s.getQualifiedName());
			// we cut the branch as close as possible from the trunk
			List<TrcRule> inheritedRulesForInclusion = rulesInheritenceMap.get(transformationToApply);
			if(inheritedRulesForInclusion.contains(s))
				continue;
			List<TrcRule> inheritedRulesForExclusion = rulesInheritenceMap.get(s);

			if(inheritedRulesForExclusion!=null && inheritedRulesForExclusion.size()>0)
			{
				for(int i=inheritedRulesForExclusion.size()-1;i>=0;i--)
				{
					if(inheritedRulesForInclusion.contains(inheritedRulesForExclusion.get(i)))
						continue;
					if(false == inheritedRulesForExclusion.get(i).equals(transformationToApply))
					{
						toExclude.add(inheritedRulesForExclusion.get(i).getQualifiedName());
					}
				}
			}
			for(String toExcludeRule: toExclude)
			{
			  ElementTransformation exc = TipUtils.createElementTransformation((List<EObject>) tupleWithAlternatives.getMatchedElements(), toExcludeRule);
			  exc.setIsExclusion(true);
			  tuplesToApply.add(exc);
			}
		}
	}

	public static void clean()
	{
		rulesInheritenceMap.clear();
	}

	
	public static String getRuleApplicationAsString(RuleApplicationTuple rat)
	{
	  String result="[";
	  for(EObject obj: rat.getPatternMatchedElement())
	    if(obj instanceof InstanceObject)
	    {
	      InstanceObject io = (InstanceObject) obj;
	      result+=io.getInstanceObjectPath()+"; ";
	    }
	    else if(obj instanceof NamedElement)
	    {
	      NamedElement ne = (NamedElement) obj;
	      result+=ne.getQualifiedName()+"; ";
	    }
	    else
	      result+="NaNE; ";
	  result+="] --> ";
	  result += rat.getTransformationRule();
	  return result;
	}
	
	public static String printAlternativesToFile(Map<List<EObject>, ArrayList<TrcRule>> patternMatchingMap)
	{
	  Iterator<Entry<List<EObject>, ArrayList<TrcRule>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
	  
	  ArrayList<String> mesElts = new ArrayList<String>();
    ArrayList<EObject> mesObjs = new ArrayList<EObject>();
    ArrayList<String> applyAStr = new ArrayList<String>();
    
    Map<String,EObject> EobjectList_NameKey = new HashMap<String,EObject>();
    Map<EObject,String> EObjectList_EObjectKey = new HashMap<EObject,String>();
    
    
    String objectsToDisplay = "";
    int cpt=1;
    int cptOb=0;
    int objectNumber=1; 
    // iterate through a collection, for each key entry retreive the list of rule that can be applied
    while(patternMatchingIt.hasNext()) {
      String applyStr = "";
      Map.Entry<List<EObject>, ArrayList<TrcRule>> tuple =
          (Map.Entry<List<EObject>, ArrayList<TrcRule>>)patternMatchingIt.next();
      List<TrcRule> candidateTransformationList = tuple.getValue();
      List<EObject> candidateObjects = tuple.getKey();
      
      // Get all the EObjects and affect for each one a unique name if he does'nt have one already
      //The map EObjectList_EObjectKey has EObjects reference as Keys and the values are the name of the EObjects
      //The map EobjectList_NameKey has EObjects Name as Keys and the values are the Reference for the EObjects
      for (int k = 0; k < candidateObjects.size(); k++){
          if(getKeyByValue(candidateObjects.get(k), EobjectList_NameKey)==null){
              if(candidateObjects.get(k) instanceof NamedElement ){
                //EObjectList_EObjectKey.put(candidateObjects.get(k),((NamedElement) candidateObjects.get(k)).getQualifiedName());
                EobjectList_NameKey.put(((NamedElement) candidateObjects.get(k)).getQualifiedName(),candidateObjects.get(k));
              }
              else {
                //EObjectList_EObjectKey.put(candidateObjects.get(k), candidateObjects.get(k).getClass().getName()+ (objectNumber));    
                EobjectList_NameKey.put( candidateObjects.get(k).getClass().getName()+ (objectNumber++) , candidateObjects.get(k));         
              }
          }
          
          if(candidateObjects.get(k) instanceof NamedElement ){
            EObjectList_EObjectKey.put(candidateObjects.get(k),((NamedElement) candidateObjects.get(k)).getQualifiedName());
          }
          else {
            EObjectList_EObjectKey.put(candidateObjects.get(k), candidateObjects.get(k).getClass().getName()+ (objectNumber));    
          }           
      }
      
      
      if (candidateTransformationList.size()>1) {
        
        objectsToDisplay += "Alternative "+cpt+":\n" ;
        objectsToDisplay += "\tfor {";
        for (int j = 0; j < candidateObjects.size(); j++) {
          if (j==0) {
            if(candidateObjects.get(j) instanceof InstanceObject)
              objectsToDisplay += ((InstanceObject) candidateObjects.get(j)).getInstanceObjectPath();
            else if(candidateObjects.get(j) instanceof NamedElement){
              objectsToDisplay += ((NamedElement) candidateObjects.get(j)).getQualifiedName();
              //objectsToDisplay += ((NamedElement) candidateObjects.get(j)) ; //.getQualifiedName();

            }
            else {
              //objectsToDisplay += getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb ;
              //objectsToDisplay += candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb ;
              objectsToDisplay+="NaNE";
            }
          } else {
            if(candidateObjects.get(j) instanceof InstanceObject)
              objectsToDisplay += ", " + ((InstanceObject) candidateObjects.get(j)).getInstanceObjectPath();
            else if(candidateObjects.get(j) instanceof NamedElement){
              //objectsToDisplay += ", " + getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb;
              objectsToDisplay += ", " + ((NamedElement) candidateObjects.get(j)).getQualifiedName();//candidateObjects.get(j).getClass().getName()+" "+cptOb;
            }
            else {
              //objectsToDisplay += ", " + getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb;
              //objectsToDisplay += ", " + candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb;
              objectsToDisplay+=", NaNE";

            }
          }
          cptOb +=1;
        }
        objectsToDisplay += "} select:\n";
        int cptVal=0;
        for (int j = 0; j < candidateTransformationList.size(); j++) {
          if (cptVal==0) {
            objectsToDisplay += "\t\t" + candidateTransformationList.get(j).getQualifiedName();
          } else {
            objectsToDisplay += "\n\t\tor\n\t\t" + candidateTransformationList.get(j).getQualifiedName();
          }
          cptVal +=1;
        } 
        objectsToDisplay += ";\n";
        cpt +=1;
      }
      else{
        
        //GlobalVariables.tuplesToApply.add(new ChoosenRulesToApply(candidateObjects,candidateTransformationList.get(0)));
        applyStr += "\nApply Rule ";
        int cptVal=0;
        for (int j = 0; j < candidateTransformationList.size(); j++) {
          if (cptVal==0) {
            applyStr += "\t" + candidateTransformationList.get(j);
          } else {
            applyStr += " or " + candidateTransformationList.get(j);
          }
          cptVal +=1;
        } 
        applyStr += " for Elements {";
        for (int j = 0; j < candidateObjects.size(); j++) {
          if (j==0) {
            if(candidateObjects.get(j) instanceof NamedElement)
              applyStr += ((NamedElement) candidateObjects.get(j));
//applyStr += ((NamedElement) candidateObjects.get(j)).getQualifiedName();
            else 
              applyStr += candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb ;
            //applyStr += getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb ;
          } else {
            if(candidateObjects.get(j) instanceof NamedElement)
              applyStr += ", " + ((NamedElement) candidateObjects.get(j));
          //  applyStr += ", " + ((NamedElement) candidateObjects.get(j)).getQualifiedName();
            else 
              applyStr += ", " + candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb;
          //  applyStr += ", " + getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb;

          }
          cptOb +=1;
        }
        applyStr += "};\n";
        applyAStr.add(applyStr);
//        TaggedRuleApplicationT = TrcUtils.getNormalizedDependencies(trc, candidateObjects, candidateTransformationList.get(0));
//        applyAStr.add(printListList(TaggedRuleApplicationT));
      }
    }
    return objectsToDisplay;
	}
	
	public static String getKeyByValue(EObject object,
	                                   Map<String,EObject> EobjectList_NameKey){
    Iterator<Entry<String,EObject>> EObject_NameKey_Element = EobjectList_NameKey.entrySet().iterator();
    while(EObject_NameKey_Element.hasNext())
    {
      Map.Entry<String,EObject> tuple = (Map.Entry<String,EObject>) EObject_NameKey_Element.next();
      EObject EobjectRef = tuple.getValue();
      String EObjectName = tuple.getKey();
      if(object == EobjectRef ){
        return EObjectName;
      }
    }
    return null;
  }
}
