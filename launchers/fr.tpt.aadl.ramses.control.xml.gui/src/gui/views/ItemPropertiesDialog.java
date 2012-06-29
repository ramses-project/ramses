// TODO make so that user can change path: replace this transformation by another one

package gui.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * A popup that show info on the transformations in the list such as name and path
 */
public class ItemPropertiesDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	JButton buttonClose; 

	public ItemPropertiesDialog(String itemName, String itemPath) {
		setSize(450, 160);
		setLocationRelativeTo(null);
		setResizable(false);
		JLabel labelPath = new JLabel(itemPath);
		JLabel labelName = new JLabel(itemName);
		JTextField fieldPath = new JTextField(labelPath.getText());
		Font labelPathFont = labelPath.getFont();
		fieldPath.setFont(new Font(labelPathFont.getFamily(), Font.PLAIN, 11));
		fieldPath.setEditable(false);
		// TODO can't get the close action to work on this
		buttonClose = new JButton("Close"); 
		buttonClose.setActionCommand("closePropertiesPopup");
		add(labelName, BorderLayout.NORTH);
		add(fieldPath, BorderLayout.CENTER);
		add(buttonClose, BorderLayout.SOUTH);
		pack();
	}

	public void setActionListener(ActionListener al) {
		buttonClose.addActionListener(al);
	}
}
