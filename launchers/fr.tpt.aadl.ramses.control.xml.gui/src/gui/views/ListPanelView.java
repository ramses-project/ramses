package gui.views;

import gui.classes.ListItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionListener;

/**
 * A base class for a view that displays a JList containting string elements such as 
 * available transformations, available analyses or current tree-items
 */
public class ListPanelView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private DefaultListModel listModel;
	private JList itemList;		
	private JScrollPane scrollPane;

	public ListPanelView(String title) {
		setLayout(new BorderLayout());
		add(new JLabel(title), BorderLayout.NORTH);

	}
	
	/**
	 * Add a custom listModel to the JList. The custom listmodel
	 * contains methods to add and delete items from the list. Also creates adds the
	 * needed panels to the interface
	 * @param listModel_ the custom list model
	 */
	public void addListModel(DefaultListModel listModel_) {
		// TODO unclear method. it both adds the listmodel 
		// and adds the list to the interface.. not very neat.. fix this 
		listModel = listModel_;
		itemList  = new JList(listModel);
		scrollPane = new JScrollPane(itemList);
		itemList.setBackground(Color.white);
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setLayoutOrientation(JList.VERTICAL);
		add(scrollPane, BorderLayout.CENTER);		
	}
	
	/**
	 * Clear current list, takes a Vector<ListItem> and puts the ListItem.getName() in a JList
	 * @param items vector with string item names
	 */
	public void refreshList(Vector<ListItem> items) {
		if(!items.isEmpty()) {
			listModel.clear();
			Iterator<ListItem> i = items.iterator();
			while(i.hasNext())
				listModel.addElement(i.next().getName());
		}
	}
	
	/**
	 * Deletes an item from the list that has the given index
	 * @param index the index to delete
	 */
	public void deleteItem(int index) {
		if(index >= 0 && index < listModel.size()) {
			listModel.removeElementAt(index);
		}
	}
		
	public void addListDataListener(ListDataListener lcl) {
		// TODO this one doesn't work. no changes detected
		// function not desired at the moment so it's no big deal
		listModel.addListDataListener(lcl);  
	}
	
	public void addMouseListener(MouseListener ml) {
		itemList.addMouseListener(ml);
	}

	/**
	 * This listener listens to which item is selected, normally to be deleted 
	 * @param lsl ListSelectionListener
	 */
	public void addListSelectionListener(ListSelectionListener lsl){
		itemList.getSelectionModel().addListSelectionListener(lsl);
	}
	
	public DefaultListModel getListModel() {
		return listModel;
	}
	
	public JList getList() {
		return itemList;
	}
}
