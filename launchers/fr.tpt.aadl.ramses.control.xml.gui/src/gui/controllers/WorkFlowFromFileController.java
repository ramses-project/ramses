package gui.controllers;

import gui.models.WorkFlowFromFileModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Controller of the "open XML file" action
 * Handles the selection of the file and after that calls WorkFlowFromFileModel
 * 
 */
public class WorkFlowFromFileController implements ActionListener {

	private WorkflowPanelController workPan;
	private final JFileChooser fc = new JFileChooser(); 

	/**
	 * 
	 * @param workPan_
	 */
	public WorkFlowFromFileController(WorkflowPanelController workPan_){
		workPan = workPan_;
		//Specification of the JFileChooser : accepted files, default name...
		fc.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
		fc.setCurrentDirectory(new File(new String("../../model2model/fr.tpt.aadl.ramses.transformation.atl/")));
		fc.setSelectedFile(new File(""));
		fc.setDialogTitle("Open the WorkFlow (XML file)");
	}

	/**
	 * Called when the button open XML file is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = fc.showSaveDialog(workPan);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			TreeElementController oldRoot = null;

			//Saving the current root
			if (workPan.root != null){
				oldRoot = workPan.root;
			}

			WorkFlowFromFileModel wf = new WorkFlowFromFileModel(fc.getSelectedFile(), workPan);

			//If there is no error during the reading
			if (wf.parse() == 1){ //1 means no error
				
				//We empty the old root
				if (oldRoot != null){
					workPan.remove(oldRoot);
					oldRoot.removeChildFromPan();
				}

				//WorkflowPan updating
				if (workPan.isCompleted())
					workPan.getBouton().setEnabled(true);
				workPan.changeSize();
				workPan.changePositions();
				workPan.repaint();
				workPan.getInfoPan().getInstancesPanel().refreshListOfInstances(workPan.root);
			}
			//There is an error during the reading of the file
			else
			{
				workPan.root = oldRoot;
				JOptionPane.showMessageDialog(null, "XML file is not conform !\n", "Warning", JOptionPane.WARNING_MESSAGE);
			}

		}
	}

}
