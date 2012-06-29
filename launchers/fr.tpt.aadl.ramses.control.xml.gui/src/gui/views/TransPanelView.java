package gui.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This extension of the ListPanelView adds an "add transformations" button that
 * allows for adding transformations through a fileprompt. There's also a
 * delete button to remove a selected transformation.
 */
public class TransPanelView extends ListPanelView {

	private static final long serialVersionUID = 1L;
	private JButton buttonAdd = new JButton("Add");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonProperties = new JButton("Properties");

	public TransPanelView(String title) {
		super(title);

		setSize(300,250);
		setPreferredSize(new Dimension(300,250));
		setMaximumSize(new Dimension(300,300));
		
		buttonProperties.setEnabled(false);
		getButtonDelete().setEnabled(false);
		JPanel buttons = new JPanel(new BorderLayout());
		buttons.add(buttonAdd, BorderLayout.WEST);
		buttons.add(getButtonProperties(), BorderLayout.CENTER);
		buttons.add(getButtonDelete(), BorderLayout.EAST);
		add(buttons, BorderLayout.SOUTH);
	}
	
	public void addActionListener(ActionListener al) {
		buttonAdd.addActionListener(al);
		buttonAdd.setActionCommand("addItems");
		buttonProperties.addActionListener(al);
		buttonProperties.setActionCommand("showPropertiesPopup");
		buttonDelete.addActionListener(al);
		buttonDelete.setActionCommand("deleteItem");
	}

	public JButton getButtonProperties() {
		return buttonProperties;
	}

	public JButton getButtonDelete() {
		return buttonDelete;
	}
}
