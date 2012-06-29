package gui.views;

import java.awt.Dimension;
import java.awt.Insets;

import gui.controllers.ModifyElementController;
import gui.controllers.TreeElementController;
import gui.controllers.TreeElementController.ElementType;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Dialog to modify an existing element
 * Contains :
 * - a label that displays the informations
 * - a button modify (for the transformation or analysis elements)
 * - a button delete 
 *
 */
public class ModifyElementDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private TreeElementController elem;
	private JButton modifyButton;
	private JButton deleteButton;
	
	/**
	 * 
	 * @param parent
	 * @param element_
	 */
	public ModifyElementDialog(JFrame parent, TreeElementController element_){
		super(parent, "", true);
		elem = element_;
		
		initDialog();
	}

	/**
	 * Initialization of buttons, titles...
	 * 
	 */
	private void initDialog() {

		String title = new String("");
		boolean isModifiable = false;
		
		switch (elem.getType()) {
		case TRANSFORMATION:
			title = "Transformation";
			isModifiable = true;
			break;
		case ANALYSIS:
			title = "Analysis";
			isModifiable = true;
			break;
		case CODE_GENERATION:
			title = "Generation";
			break;
		case ERROR_STATE:
			title = "Error";
			break;
		default:
			break;
		}
		
		this.setTitle(title);
		
		initComponents(isModifiable);
		
	}

	/**
	 * Label and buttons initialization
	 * 
	 * @param isModifiable
	 */
	private void initComponents(boolean isModifiable) {
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));

		//If transformation or analysis, modify button and JLabel with name
		if (isModifiable){
			JLabel lab;

			lab = new JLabel("<html><body> <u>Methods :</u> <br/>");
			for (int i=0; i<elem.getNames().size(); i++){
				lab.setText(lab.getText() + "&nbsp &nbsp &nbsp " + elem.getNames().get(i) + "<br />");
			}
			if (elem.getType() == ElementType.ANALYSIS){
				lab.setText(lab.getText() + "<u>Manual :</u>  " + elem.isManualMode());
			}
			lab.setText(lab.getText() + "</body></html>");
			Box hBox0 = Box.createHorizontalBox();
			hBox0.add(lab);
			pane.add(hBox0);
			
	        pane.add(Box.createRigidArea(new Dimension(0, 10)));
	 
	        Box hBox1 = Box.createHorizontalBox();
			modifyButton = new JButton("Modify");
			modifyButton.setActionCommand("modify");
			modifyButton.setMinimumSize(new Dimension(100, 30));
			modifyButton.setMaximumSize(new Dimension(100, 30));
			hBox1.add(modifyButton);
			pane.add(hBox1);
		}
		
        pane.add(Box.createRigidArea(new Dimension(0, 10)));

        Box hBox2 = Box.createHorizontalBox();
		deleteButton = new JButton("Delete");
		deleteButton.setActionCommand("delete");
		deleteButton.setMinimumSize(new Dimension(100, 30));
		deleteButton.setMaximumSize(new Dimension(100, 30));
		hBox2.add(deleteButton);
		pane.add(hBox2);
		
		this.getContentPane().add(pane);

		pack();
		setMinimumSize(new Dimension(150,100));
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	/**
	 * Add the controller to the existing buttons
	 * 
	 * @param controller
	 */
	public void initController(ModifyElementController controller) {
		if (elem.getType() == ElementType.ANALYSIS||elem.getType() == ElementType.TRANSFORMATION)
			modifyButton.addActionListener(controller);
		deleteButton.addActionListener(controller);
	}
	
	public TreeElementController getElem() {
		return elem;
	}

	public int showDialog() {
		setVisible(true);
		return 0;
	}



}
