package gui.controllers;

import gui.classes.ListItem;
import gui.models.ListPanelModel;
import gui.views.ListPanelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This controls the interaction with the lists that are shown in the right panel,
 * for example deletion and adding of new transformations through a fileprompt.
 */
public class ListPanelController implements ActionListener, 
	ListDataListener, ListSelectionListener, MouseListener {
		
	private ListPanelView view;
	private ListPanelModel model;
	
	/**
	 * Takes a view, a model and some parameters for the fileprompt
	 * @param view_
	 * @param model_
	 * @param fileChooserDefaultPath what the filepromt should default to
	 * @param fileExtension_ which files to accept in fileprompt
	 */
	public ListPanelController(
			ListPanelView view_, 
			ListPanelModel model_) {
		
		view = view_;
		model = model_;
		view.addListModel(model);
		view.addListDataListener(this);
		view.addListSelectionListener(this);
		view.addMouseListener(this);
	}
	
	@Override
	public void contentsChanged(ListDataEvent e) {
		
	}

	@Override
	public void intervalAdded(ListDataEvent e) {
		
	}

	@Override
	public void intervalRemoved(ListDataEvent e) {

	}
	
	public ListPanelView getView() {
		return view;
	}
	
	public ListPanelModel getModel() {
		return model;
	}
	
	public Vector<String> getItemStrings() {
		return model.getItemsStrings();
	}
	
	public Vector<ListItem> getItems() {
		return model.getItems();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.isPopupTrigger()) {
//			showContextMenu(e); // TODO finish this. must find out which item that is clicked
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()) {
//			showContextMenu(e);
		}
	}

//	private void showContextMenu(MouseEvent e) {
//		ItemContextMenu menu = new ItemContextMenu();
//		menu.show(e.getComponent(), e.getX(), e.getY());
//	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
