package gui.controllers;

import gui.models.XMLGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * Controller that handle the "Generate XML" action 
 *  
 * A DialogBox to choose the file to create is displayed and then XMLGenerator is created
 * 
 */
public class GenerateXMLController implements ActionListener {

	private WorkflowPanelController workPan;
	private final JFileChooser fc = new JFileChooser(); 
	
	/**
	 * Conctructor
	 * 
	 * @param workPan_
	 */
	public GenerateXMLController(WorkflowPanelController workPan_){
		workPan = workPan_;
		//Specification of the JFileChooser : accepted files, default name...
		fc.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
		fc.setCurrentDirectory(new File(new String("../../model2model/fr.tpt.aadl.ramses.transformation.atl/")));
		fc.setSelectedFile(new File("workflow.xml"));
		fc.setDialogTitle("Save the WorkFlow (XML file)");
	}
	
	/**
	 * Open the dialog, and if the file is choosed, call the generation
	 * with XMLGenerator
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 int returnVal = fc.showSaveDialog(workPan);
		 
	     if (returnVal == JFileChooser.APPROVE_OPTION) {
	    	 new XMLGenerator(workPan.getRoot(), fc.getSelectedFile());
	     }
	}

}
