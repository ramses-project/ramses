package gui.listeners;

import gui.controllers.ModifyElementController;
import gui.controllers.TreeElementController;
import gui.controllers.WorkflowPanelController;
import gui.controllers.TreeElementController.ElementType;
import gui.views.AddingDialog;
import gui.views.ModifyElementDialog;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Class that will listen to any Elements to know the interaction
 * that we have to do
 *
 */
public class ElementsListener implements MouseListener{

	TreeElementController elem;
	WorkflowPanelController workPan;
	JLabel infoLabel;

	/**
	 * Constructor
	 * 
	 * @param elem_ the listener needs to know which elements it is listening to
	 * @param pan we keep the workflow pan to make changes on it
	 */
	public ElementsListener(TreeElementController elem_, WorkflowPanelController pan) {
		elem = elem_;
		workPan = pan;

		//When the mouse is over the elements, the cursor changes
		if (elem != null){
			elem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}

	/**
	 * If we are on an empty we propose to add one
	 * else we propose to delete it
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {

		//We want to add an element
		if (elem.getType() == ElementType.EMPTY_ELEMENT) {

			//We create an adding dialog in function of the father's type
			ElementType type = ElementType.TRANSFORMATION;
			if (elem.getFather() != null) {
				type = elem.getFather().getType();
			}
			AddingDialog diag = new AddingDialog(null,"Add an element",true, type,workPan.getInfoPan(),0);

			//If the answer of the dialog is a type then we create it
			switch (diag.showDialog()) {
			case TRANSFORMATION:
				elem.setType(ElementType.TRANSFORMATION);
				Icon iconT = new ImageIcon("images/transfo.png");
				elem.setIcon(iconT);
				elem.setNames(diag.getNames());

				elem.setId("T"+ ++workPan.nbTrans);

				elem.setChildYes(new TreeElementController(ElementType.EMPTY_ELEMENT,elem.getX(),elem.getY()+100,workPan,elem));
				workPan.add(elem.getChildYes());
				break;
			case ANALYSIS:
				int res = JOptionPane.showConfirmDialog(null, "Do you want to manually analyse the result?", "Automatic result", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					elem.setManualMode(true);
				}
				else {
					elem.setManualMode(false);
				}
				elem.setType(ElementType.ANALYSIS);
				Icon iconA = new ImageIcon("images/analysis.png");
				elem.setIcon(iconA);
				elem.addName(diag.getNames().get(0));

				elem.setWid(1);
				elem.changeParentWidth(1);

				elem.setId("A"+ ++workPan.nbAna);

				elem.setChildYes(new TreeElementController(ElementType.EMPTY_ELEMENT,elem.getX()-50,elem.getY()+100,workPan,elem));
				elem.setChildNo(new TreeElementController(ElementType.EMPTY_ELEMENT,elem.getX()+50,elem.getY()+100,workPan,elem));
				workPan.add(elem.getChildNo());
				workPan.add(elem.getChildYes());

				workPan.changePositions();
				break;
			case CODE_GENERATION:
				elem.setType(ElementType.CODE_GENERATION);
				Icon iconG = new ImageIcon("images/generation.png");
				elem.setIcon(iconG);

				//We always check if the tree is completed when 
				//we add a terminal element
				if (workPan.isCompleted()) {
					workPan.buttonGenerate.setEnabled(true);
				}
				break;
			case ERROR_STATE:
				elem.setType(ElementType.ERROR_STATE);

				elem.setId("ES" + ++workPan.nbErr);

				Icon iconE = new ImageIcon("images/error.png");
				elem.setIcon(iconE);

				if (workPan.isCompleted()) {
					workPan.buttonGenerate.setEnabled(true);
				}
				break;
			default:
				break;
			}

			//We update the instance panel and the workflow panel
			workPan.getInfoPan().getInstancesPanel().refreshListOfInstances(workPan.root);
			workPan.changeSize();
			workPan.repaint();
		}
		//We want to delete an element
		else {

			ModifyElementDialog dialog = new ModifyElementDialog(null, elem);
			ModifyElementController modifyController = new ModifyElementController(dialog, workPan);
			dialog.initController(modifyController);

			dialog.showDialog();

		}
	}

	/**
	 * We show a label with the method when we are over the element
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (elem != null && (elem.getType() == ElementType.TRANSFORMATION || elem.getType() == ElementType.ANALYSIS)) {
			if (infoLabel == null) {
				infoLabel = new JLabel("<html><body> <u>Methods :</u> <br/>");
				for (int i=0; i<elem.getNames().size(); i++){
					infoLabel.setText(infoLabel.getText() + "&nbsp &nbsp &nbsp " + elem.getNames().get(i) + "<br />");
				}
				if (elem.getType() == ElementType.ANALYSIS){
					infoLabel.setText(infoLabel.getText() + "<u>Manual :</u>  " + elem.isManualMode() +"</body></html>");
				}
				else {
					infoLabel.setText(infoLabel.getText() + "</body></html>");
				}
			}
			else
				workPan.remove(infoLabel);		

			workPan.add(infoLabel);
			infoLabel.setBounds(elem.getX() + 60, elem.getY()-60, 400, 100);
			workPan.repaint();
		}
	}

	/**
	 * We remove the label when we are not over the element anymore
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		if (infoLabel != null) {
			workPan.remove(infoLabel);
			infoLabel = null;
			workPan.repaint();workPan.getInfoPan().getInstancesPanel().refreshListOfInstances(workPan.root);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
