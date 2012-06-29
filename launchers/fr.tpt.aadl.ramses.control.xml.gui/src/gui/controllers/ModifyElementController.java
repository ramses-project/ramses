package gui.controllers;

import gui.controllers.TreeElementController.ElementType;
import gui.views.AddingDialog;
import gui.views.ModifyElementDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 * When you click on an existing element, it display a window ModifyElementDialog, it is his controller
 * You can modify or delete the element
 *
 */
public class ModifyElementController implements ActionListener {
	private ModifyElementDialog dialog;
	private TreeElementController elem;
	private WorkflowPanelController workPan;
	
	/**
	 * 
	 * @param dialog_ ModifyElementDialog instance
	 * @param workPan_
	 */
	public ModifyElementController(ModifyElementDialog dialog_, WorkflowPanelController workPan_){
		dialog = dialog_;
		elem = dialog.getElem();
		workPan = workPan_;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Modifying
		if(arg0.getActionCommand().equals("modify")){
			//Display the dialog AddingDialog, with the modifying mode, with only transformations available
			if (elem.getType() == ElementType.TRANSFORMATION) {
				AddingDialog diag = new AddingDialog(null,"Modify an element",true, ElementType.EMPTY_ELEMENT,workPan.getInfoPan(),1);
				if (diag.showDialog() != ElementType.EMPTY_ELEMENT) {
					elem.setNames(diag.getNames());
					workPan.getInfoPan().getInstancesPanel().refreshListOfInstances(workPan.root);
					dialog.dispose();
				}
			}
			//Display the dialog AddingDialog, with the modifying mode, and then the "Do you want to analyse manually the result?" popup
			else if (elem.getType() == ElementType.ANALYSIS) {
				AddingDialog diag = new AddingDialog(null,"Modify an element",true, ElementType.EMPTY_ELEMENT,workPan.getInfoPan(),2);
				if (diag.showDialog() != ElementType.EMPTY_ELEMENT) {
					int res = JOptionPane.showConfirmDialog(null, "Do you want to analyse manually the result?", "Automatic result", JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						elem.setManualMode(true);
					}
					else {
						elem.setManualMode(false);
					}
					elem.setNames(null);
					elem.addName(diag.getNames().get(0));
					workPan.getInfoPan().getInstancesPanel().refreshListOfInstances(workPan.root);
					dialog.dispose();
				}
			}
			
		}
		
		if(arg0.getActionCommand().equals("delete")){
			int option = JOptionPane.showConfirmDialog(null, "Do you really want to delete this item? All child elements will also be deleted", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			//If we answered yes
			if(option == JOptionPane.OK_OPTION)
			{
				dialog.setVisible(false);
				switch (elem.getType()) {
				case TRANSFORMATION:
					elem.removeChildFromPan();
					break;
				case ANALYSIS:
					elem.removeChildFromPan();
					elem.changeParentWidth(-1);
					workPan.changePositions();
					break;
				default:
					break;
				}
				
				//We initialize the element as empty
				elem.setIcon(new ImageIcon("images/element.png"));
				elem.setChildNo(null);
				elem.setChildYes(null);
				elem.setName(null);
				elem.setType(ElementType.EMPTY_ELEMENT);
				
				//View updates
				workPan.buttonGenerate.setEnabled(false);
				workPan.getInfoPan().getInstancesPanel().refreshListOfInstances(workPan.root);
				workPan.changeSize();
				workPan.repaint();
			}
		}
	}

}
