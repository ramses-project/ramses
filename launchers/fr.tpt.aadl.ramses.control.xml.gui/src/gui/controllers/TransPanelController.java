package gui.controllers;

import gui.classes.ListItem;
import gui.models.ListPanelModel;
import gui.views.ItemPropertiesDialog;
import gui.views.ListPanelView;
import gui.views.TransPanelView;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 * Controller that extends ListPanelController. Holds specific
 * functionality that is needed for the list that displays Available Transformations
 */
public class TransPanelController extends ListPanelController {
	
	ListPanelModel model;
	TransPanelView view;
	ItemPropertiesDialog itemPropertiesDialog;
	private int selectedIndex = -1;
	private final JFileChooser fc = new JFileChooser();
	private String fileExtension;
	private String transRootFolder;
	
	public TransPanelController(TransPanelView view_, ListPanelModel model_) {
		super((ListPanelView)view_, model_);
		model = model_;
		view = view_;
		view.addActionListener(this);
		fileExtension = ".asm";
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File defaultDirectory = new File("../../model2model/fr.tpt.aadl.ramses.transformation.atl/"); 
		fc.setCurrentDirectory(defaultDirectory);
		try {
			transRootFolder = defaultDirectory.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.setItemRootFolder(transRootFolder);
	}

	public Vector<String> getTransformations() {
		Vector<String> transformations = getItemStrings();
		return transformations;
	}

	public void loadDefaultTransformations() {
		Vector<ListItem> defaultTransformations = model.importItemsFromDirectory(new File("../../model2model/fr.tpt.aadl.ramses.transformation.atl/helpers"), ".asm");
		view.refreshList(defaultTransformations);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		view.getButtonProperties().setEnabled(true);
		view.getButtonDelete().setEnabled(true);
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		if(!lsm.getValueIsAdjusting())
			selectedIndex = lsm.getMinSelectionIndex();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("addItems")) {
	        int returnVal = fc.showOpenDialog(view);
	 
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	
	            Vector<ListItem> items = new Vector<ListItem>();
	    		items.clear();
	            if(file.isDirectory()) {
	                items = model.importItemsFromDirectory(file, fileExtension);
	            } else {
	            	items = model.importItemFromFile(file, fileExtension);
	    		}
	    		if(!items.isEmpty())
	    			view.refreshList(items);
	        } 
		}
		
		if(e.getActionCommand().equals("deleteItem")) {
			// TODO check if transform exists in workflow tree: in that case, deny removal
			// TODO remove multiple items at once
			if(selectedIndex != -1) {
				view.deleteItem(selectedIndex);
			}
		}
		
		if (e.getActionCommand().equals("showPropertiesPopup")) {
			ListItem item = model.getItem(selectedIndex);
			itemPropertiesDialog = new ItemPropertiesDialog(item.getName(), item.getAbsolutePath());
			itemPropertiesDialog.setActionListener(this);
			itemPropertiesDialog.setVisible(true);
		}
		
		if(e.getActionCommand().equals("closePropertiesPopup")) {
			itemPropertiesDialog.setVisible(false);
		}
	}
}
