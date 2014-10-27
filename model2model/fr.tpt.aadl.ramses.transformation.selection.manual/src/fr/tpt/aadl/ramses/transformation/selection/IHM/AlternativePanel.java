package fr.tpt.aadl.ramses.transformation.selection.IHM;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTulpe;


public class AlternativePanel implements Serializable {
	
	private JPanel alternetivePanel;
	private List<PanelGroup> panels = new ArrayList<PanelGroup>();
	public boolean NoMoreDecisionToTake = false; 
	//private List<List<List<TaggedRuleApplicationTulpe>>> TaggedRuleApplicationTopPanel =  new ArrayList<List<List<TaggedRuleApplicationTulpe>>>();
	private List<ChoosenRulesToApply> ruleToApply = new ArrayList<ChoosenRulesToApply>();
	
	
	public AlternativePanel(){

		alternetivePanel = new JPanel() ; 
		alternetivePanel.setLayout(new BoxLayout(alternetivePanel,BoxLayout.Y_AXIS));
		alternetivePanel.setPreferredSize(alternetivePanel.getPreferredSize());

	}
	
	public boolean checkAllSubDecisions(){
		for(int i=0; i<panels.size();i++){
			if(!panels.get(i).checkDecisions()) return false;
		}
		if(panels.size()==0) return false;
		return true;
	}
	
	public void getAllAppliedRule(){
		for(int i=0; i<panels.size();i++){
			panels.get(i).affectAppliedRule();
		}
	}
	
	public void RemoveAllPanel(){
		panels.clear();
		alternetivePanel.removeAll();
		alternetivePanel.revalidate();
		alternetivePanel.repaint();
		NoMoreDecisionToTake=false;
	}

	
	public void AddNoConsequence(){
		panels.add(new PanelGroup());
		alternetivePanel.add(panels.get(panels.size()-1).getPanelGroup());	
		panels.get(panels.size()-1).NoConsequences();
	}

	
	public void AddSelection(List<List<TaggedRuleApplicationTulpe>> taggedRuleApplicationT){
		panels.add(new PanelGroup());
		alternetivePanel.add(panels.get(panels.size()-1).getPanelGroup());	
		panels.get(panels.size()-1).addSelection(taggedRuleApplicationT);
	}

	
	public JPanel getAlternativePanel(){
		return alternetivePanel;
	}


	public void SetAlternative(
			List<List<TaggedRuleApplicationTulpe>> taggedRuleApplicationT,
			int index) {
		List<TaggedRuleApplicationTulpe> taggedRuleApplicationTuple = new ArrayList<TaggedRuleApplicationTulpe>();
		int k=0 ;
		int i=0;
		int SelectionNumber=0;
		String string="";
		for (k = 0; k < taggedRuleApplicationT.size(); k++){
			AddSelection(taggedRuleApplicationT);
			taggedRuleApplicationTuple.addAll(taggedRuleApplicationT.get(k));
			for (i = 0; i < taggedRuleApplicationTuple.size(); i++){
				if(!taggedRuleApplicationTuple.get(i).isExclusion()){
					string= "SELECT "+ taggedRuleApplicationTuple.get(i).getTransformationRuleName() +" FOR { "+ printAllObjects(taggedRuleApplicationTuple.get(i).getPatternMatchedElement()) +" }";
					panels.get(panels.size()-1).decisionComboBox.addItem(string);	//exclusionTuple.put(taggedRuleApplicationTuple.get(i).getPatternMatchedElement(), taggedRuleApplicationTuple.get(i).getTransformationRuleName());
					panels.get(panels.size()-1).ruleToApply.add(new ChoosenRulesToApply(taggedRuleApplicationTuple.get(i).getPatternMatchedElement(),taggedRuleApplicationTuple.get(i).getTransformationRuleName()));
				}
			}
		}
		if(k==0) AddNoConsequence();
		
	}
	
	private String printAllObjects(List<EObject> eobjects){
		
		String eobject_String= "";
		for (int k = 0; k < eobjects.size(); k++){
			if(k<eobjects.size()-1) eobject_String += GlobalVariables.EObjectList_EObjectKey.get(eobjects.get(k)) +", ";
			else eobject_String +=GlobalVariables.EObjectList_EObjectKey.get(eobjects.get(k));
		}	
		return eobject_String;
	}
	
	public String getKeyByValue(EObject object){
		Iterator<Entry<String,EObject>> EObject_NameKey_Element = GlobalVariables.EobjectList_NameKey.entrySet().iterator();
		for (Iterator iterator = EObject_NameKey_Element; iterator.hasNext();)
		{
			Map.Entry<String,EObject> tuple = (Map.Entry<String,EObject>)iterator.next();
			EObject EobjectRef = tuple.getValue();
			String EObjectName = tuple.getKey();
			if(object == EobjectRef ){
				return EObjectName;
			}
		}
		return null;
	}

}
