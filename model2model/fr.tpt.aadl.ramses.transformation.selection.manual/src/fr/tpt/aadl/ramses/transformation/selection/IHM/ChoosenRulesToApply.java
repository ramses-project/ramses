package fr.tpt.aadl.ramses.transformation.selection.IHM;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTuple;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils;

public class ChoosenRulesToApply implements Serializable {
	
	public java.util.List<EObject> EObjectList = new ArrayList<EObject>();
	public java.util.List<TrcRule> Rules = new ArrayList<TrcRule>();
	public int choosenRule;
	
	public ChoosenRulesToApply(java.util.List<EObject> list,java.util.List<TrcRule> Rules,int choosenRule){
		this.Rules= Rules;
		this.EObjectList = list;
		this.choosenRule = choosenRule;
	}
	
	public ChoosenRulesToApply(java.util.List<EObject> list,TrcRule Rule){
		this.Rules.add(Rule);
		this.EObjectList = list;
		this.choosenRule = 0;
	}
	
	
	public TrcRule getChoosenRule(){
		return Rules.get(choosenRule);
	}
}
