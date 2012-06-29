package gui.views;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Right click menu for items in the lists. Not finished
 */
public class ItemContextMenu extends JPopupMenu {

	private static final long serialVersionUID = 1L;

	public ItemContextMenu() {
		JMenuItem itemProperties = new JMenuItem("Properties");
		add(itemProperties);
	}
	
	public void addActionListener(ActionListener al) {
		this.addActionListener(al);
	}
}
