package gui.views;

import gui.controllers.InfoPanController;
import gui.controllers.TreeElementController.ElementType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListSelectionModel;

public class AddingDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	JComboBox combo, comboAnalysis;
	JList listTrans;
	JLabel comboTranLab, comboAnaLab;
	JScrollPane scrollList;
	Vector<String> names;
	ElementType returnType;

	public AddingDialog(JFrame parent, String title, boolean modal, ElementType type, InfoPanController infoPanel, int mode){
		super(parent, title, modal);

		names = new Vector<String>();
		returnType = ElementType.EMPTY_ELEMENT;
		
		setSize(500, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initDialog(type, infoPanel, mode);
		
	}
	
	public ElementType showDialog() {
		setVisible(true);
		return returnType;
	}
	
	public void initDialog(ElementType type, InfoPanController infoPanel, int mode) {
		Vector<String> st = new Vector<String>();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		switch(mode) {
		case 0:
			switch(type) {
			case EMPTY_ELEMENT:
				st.add("Transformation");
				st.add("Analysis");
				break;
			case TRANSFORMATION:
				st.add("Transformation");
				st.add("Analysis");
				st.add("Code Generator");
				break;
			case ANALYSIS :
				st.add("Transformation");
				st.add("Analysis");
				st.add("Code Generator");
				st.add("Error state");
				break;
			default:
				break;
			}
			break;
		case 1:
			st.add("Transformation");
			break;
		case 2:
			st.add("Analysis");
			break;
		default:
			break;
		}
		
		JLabel comboLab = new JLabel("Element type: ");
		combo = new JComboBox(st);
		
		JPanel panel1 = new JPanel();
		panel1.add(comboLab);
		panel1.add(combo);
		panel.add(panel1);
		

		comboTranLab = new JLabel("Available transformations: ");
		Vector<String> transformations = infoPanel.getTransformations();
		if(!transformations.isEmpty()) {
			listTrans = new JList(transformations);
			listTrans.setSelectionModel(new DefaultListSelectionModel() {
				private static final long serialVersionUID = 1L;
				private int i0 = -1;
				private int i1 = -1;

				public void setSelectionInterval(int index0, int index1) {
					if(i0 == index0 && i1 == index1){
						if(getValueIsAdjusting()){
							setValueIsAdjusting(false);
							setSelection(index0, index1);
						}
					}else{
						i0 = index0;
						i1 = index1;
						setValueIsAdjusting(false);
						setSelection(index0, index1);
					}
				}
				private void setSelection(int index0, int index1){
					if(super.isSelectedIndex(index0)) {
						super.removeSelectionInterval(index0, index1);
					}else {
						super.addSelectionInterval(index0, index1);
					}
				}
			});
		}
		else
			listTrans = new JList();
		
		listTrans.setVisibleRowCount(3);
		scrollList = new JScrollPane(listTrans);
		
		JPanel panel2 = new JPanel();
		panel2.add(comboTranLab);
		panel2.add(scrollList);
		panel.add(panel2);
		
		comboAnaLab = new JLabel("Available analyses:");
		Vector<String> analyses = infoPanel.getAnalyses();
		if(!analyses.isEmpty())
			comboAnalysis = new JComboBox(analyses);
		else
			comboAnalysis = new JComboBox();
		
		combo.addActionListener(new ItemListener());
		
		JPanel panel3 = new JPanel();
		panel3.add(comboAnaLab);
		panel3.add(comboAnalysis);
		panel.add(panel3);
		if (mode == 2) {
			comboAnaLab.setVisible(true);
			comboAnalysis.setVisible(true);
			scrollList.setVisible(false);
    		comboTranLab.setVisible(false);
		}
		else {
			comboAnaLab.setVisible(false);
			comboAnalysis.setVisible(false);
		}
		
		JButton boutonOk = new JButton("Add");
		boutonOk.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				boolean isCorrect = false;
				if(combo.getSelectedItem().toString() == "Transformation") {
					if (!listTrans.isSelectionEmpty()) {
						returnType = ElementType.TRANSFORMATION;
						int[] indices = listTrans.getSelectedIndices();
						for(int i = 0; i < indices.length ; i++) {
						     names.add((String)listTrans.getModel().getElementAt(indices[i]));
						 }
						isCorrect = true;
					}
				}
				else if (combo.getSelectedItem().toString() == "Analysis") {
					if (comboAnalysis.getSelectedItem() != null) {
						returnType = ElementType.ANALYSIS;
						names.add(comboAnalysis.getSelectedItem().toString());
						isCorrect = true;
					}
				}
				else if (combo.getSelectedItem().toString() == "Code Generator") {
					returnType = ElementType.CODE_GENERATION;
					isCorrect= true;
				}
				else if (combo.getSelectedItem().toString() == "Error state") {
					returnType = ElementType.ERROR_STATE;
					isCorrect = true;
				}
				if (isCorrect) {
					setVisible(false);
				}
			} 
		}); 
		
		JButton boutonCancel = new JButton("Cancel");
		boutonCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				returnType = ElementType.EMPTY_ELEMENT;
				setVisible(false);
			} 
		}); 
		
		JPanel panel4 = new JPanel();
		panel4.add(boutonOk);
		panel4.add(boutonCancel);
		panel.add(panel4);
		
		this.getContentPane().add(panel);
	}
	
	public Vector<String> getNames(){
		return names;
	}
	
	class ItemListener implements ActionListener{
		 
        public void actionPerformed(ActionEvent e) {
        	String item = combo.getSelectedItem().toString();
            
        	if (item == "Analysis") {
        		scrollList.setVisible(false);
        		comboTranLab.setVisible(false);
        		comboAnalysis.setVisible(true);
        		comboAnaLab.setVisible(true);
        		
        	}
        	else if (item == "Transformation") {
        		scrollList.setVisible(true);
        		comboTranLab.setVisible(true);
        		comboAnalysis.setVisible(false);
        		comboAnaLab.setVisible(false);
        	}
        	else {
        		scrollList.setVisible(false);
        		comboTranLab.setVisible(false);
        		comboAnalysis.setVisible(false);
        		comboAnaLab.setVisible(false);
        	}
        }               
	}
}
