package fr.tpt.aadl.ramses.transformation.selection.IHM;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTulpe;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils;


public class PanelGroup implements ActionListener,Serializable{
	
	private JPanel decisionPanel ; 
	public JButton applyButton;
	//public JComboBox[] decisionComboBox;
	public JComboBox decisionComboBox = new JComboBox();
	private JLabel desicionLabel;
	private AlternativePanel sousPanel;
	public List<ChoosenRulesToApply> ruleToApply = new ArrayList<ChoosenRulesToApply>();
	private int applyRuleNumber = 0;
	private boolean NoMoreDecisionToTake = false; 

	public PanelGroup(){
		decisionPanel = new JPanel(new GridLayout(0,1,3,3));
		decisionPanel.setBorder(new LineBorder(Color.BLUE));	
		decisionPanel.setBorder(new TitledBorder(null, "Decision", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	
	}
	
	public JPanel getPanelGroup(){		
		return decisionPanel;		
	}
	
	public boolean checkDecisions(){
		if(!NoMoreDecisionToTake) return sousPanel.checkAllSubDecisions() ;
		return true;
	}
	
	public void NoConsequences(){
		desicionLabel= new JLabel("None");
		decisionPanel.add(desicionLabel);
		NoMoreDecisionToTake = true; 

	}
	
	
	public void addSelection(List<List<TaggedRuleApplicationTulpe>> taggedRuleApplicationT){
		applyButton = new JButton("Apply");
		applyButton.addActionListener(this);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setLeftComponent(applyButton);
		
		JSplitPane splitPaneV = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPaneV);
		splitPaneV.setTopComponent(decisionComboBox);		
		sousPanel = new AlternativePanel();
		splitPaneV.setBottomComponent(sousPanel.getAlternativePanel());
		decisionPanel.add(splitPane);
		NoMoreDecisionToTake = false; 

	}
	
	public void affectAppliedRule(){
		if(!NoMoreDecisionToTake && ruleToApply.size()>0){
			GlobalVariables.tuplesToApply.add(new ChoosenRulesToApply(ruleToApply.get(applyRuleNumber).EObjectList,ruleToApply.get(applyRuleNumber).getChoosenRule()));
		}

		if(!NoMoreDecisionToTake) sousPanel.getAllAppliedRule();
	}
	
	public ChoosenRulesToApply RuleToApplyForThisPanel(){
		try{
			return this.ruleToApply.get(applyRuleNumber) ;
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == applyButton){
			sousPanel.RemoveAllPanel();
			sousPanel.SetAlternative(TrcUtils.getNormalizedDependencies(GlobalVariables.trc,ruleToApply.get(decisionComboBox.getSelectedIndex()).EObjectList,ruleToApply.get(decisionComboBox.getSelectedIndex()).getChoosenRule()),0);
			applyRuleNumber = decisionComboBox.getSelectedIndex();
			this.getPanelGroup().validate();
			this.getPanelGroup().repaint();
		}
		
	}

	
}
