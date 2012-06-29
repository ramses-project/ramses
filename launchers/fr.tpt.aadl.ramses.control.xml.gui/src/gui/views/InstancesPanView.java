package gui.views;
import gui.controllers.TreeElementController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * A view that displays all current items from the workflow tree in a Jlist 
 */
public class InstancesPanView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JList listOfInstances;
	private Vector<String> instancesTexts;

	public InstancesPanView() {
		JLabel title = new JLabel("Current instances");
		setLayout(new BorderLayout());
		
		listOfInstances = new JList();
		listOfInstances.setBackground(Color.white);
		listOfInstances.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOfInstances.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scrollPane = new JScrollPane(listOfInstances);

		add(title, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void refreshListOfInstances(TreeElementController root){
		if (root != null){
			if (instancesTexts != null) instancesTexts.clear();
			else instancesTexts = new Vector<String>();
		
			listFromTree(root);
			listOfInstances.setListData(instancesTexts);
		}
		else 
			listOfInstances.removeAll();
	}
	
	public void listFromTree(TreeElementController root) {
		switch (root.getType()){
		case ANALYSIS :
			instancesTexts.add(new String(root.getId() + " : " + root.getNames().get(0)));
			instancesTexts.add(new String(""));
			listFromTree(root.getChildYes());
			listFromTree(root.getChildNo());
			break;
		case TRANSFORMATION :
			instancesTexts.add(new String(root.getId() + " : " + root.getNames().get(0)));
			for (int i =1; i<root.getNames().size();i++) {
				instancesTexts.add(new String("          " + root.getNames().get(i)));
			}
			instancesTexts.add(new String(""));
			listFromTree(root.getChildYes());
			break;
		case CODE_GENERATION :
			instancesTexts.add(new String("Code Generation"));
			instancesTexts.add(new String(""));
			break;
		case ERROR_STATE :
			instancesTexts.add(new String("Error State"));
			instancesTexts.add(new String(""));
			break;
		default :
			break;
		}
		
	}
}