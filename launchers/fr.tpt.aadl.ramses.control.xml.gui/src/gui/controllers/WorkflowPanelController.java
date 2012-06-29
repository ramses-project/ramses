package gui.controllers;

import gui.controllers.TreeElementController.ElementType;
import gui.listeners.ResizePanListener;
import gui.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 * Class that will contain and display the tree
 */
public class WorkflowPanelController extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public TreeElementController root;
	public JButton buttonGenerate;
	public int nbTrans;
	public int nbAna;
	public int nbErr;
	InfoPanController infoPanel;
	
	/**
	 * Constructor that instanciates the panel and creates the beginning of the tree
	 */
	public WorkflowPanelController() {
		setBackground(new Color((float)0.9, (float)0.9, (float)0.9));
		setMinimumSize(new Dimension(600,600));
		setPreferredSize(new Dimension(600,600));
		setBorder(BorderFactory.createLineBorder(Color.black));

		nbTrans = 0;
		nbAna = 0;
		nbErr = 0;
		
		buttonGenerate = new JButton("Generate XML");
		buttonGenerate.addActionListener(new GenerateXMLController(this));
		buttonGenerate.setEnabled(false);
		buttonGenerate.setBounds(250, 10, 50, 20);
		add(buttonGenerate);
		
		//Layout = null because we want to place components ourselves
		setLayout(null);
		
		ResizePanListener rpl = new ResizePanListener(this);
		addComponentListener(rpl);
		
		root = new TreeElementController(ElementType.EMPTY_ELEMENT,250,140,this, null);
		add(root);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//Drawing of the "input model"
		g.setColor(Color.white);
		g.fillRoundRect((getWidth()-75)/2, 50, 75, 40, 10, 10);
		g.setColor(getForeground());
		g.drawString("Input", (getWidth()-150)/2+58, 67);
		g.drawString("model", (getWidth()-150)/2+55, 82);
		
		//Drawing of the first arrow
		g.drawLine(getWidth()/2, 90, getWidth()/2, 140);
		g.drawLine((getWidth()/2)-5, 135, getWidth()/2, 140);
		g.drawLine((getWidth()/2)+5, 135, getWidth()/2, 140);
	}
	
	/**
	 * Recalculate positions of all elements
	 */
	public void changePositions(){
		buttonGenerate.setBounds((getWidth()-200)/2, 10, 200, 30);
		root.changePos((getWidth()-50)/2, 140);
		repaint();
	}
	
	/**
	 * check if we have to change size of the panel so that
	 * the tree will fit
	 */
	public void changeSize() {
		int new_height = 600;
		if (getLevel() >= 5) {
			new_height = 600 +(getLevel()-4)*100;
		}
		int new_width = 600;
		if (getMaxWidth() >= 4) {
			new_width = 600 + (getMaxWidth()-3)*300;
		}
		setPreferredSize(new Dimension(new_width, new_height));
		
		//We reset the viewport of the scroll to have it actualized
		Main.scroll.setViewportView(this);
		//We set the horizontal scrollbar at the middle every time
		JScrollBar hBar = Main.scroll.getHorizontalScrollBar();
		hBar.setValue((hBar.getMaximum()-hBar.getVisibleAmount())/2);
	}
	
	/**
	 * We have to know the maximum width of analysis to set the width of the panel
	 * @return the width of the first analysis
	 */
	public int getMaxWidth() {
		TreeElementController curr = root;
		
		while (curr != null && curr.getType() != ElementType.EMPTY_ELEMENT) {
			if (curr.getType() == ElementType.ANALYSIS) {
				return curr.getWid();
			}
			curr = curr.getChildYes();
		}
		
		return 0;
	}
	
	/**
	 * If the level is too large, we have to resize the panel
	 * @return the number of level that are in the tree
	 */
	public int getLevel() {
		return root.getLevel();
	}
	
	/**
	 * 
	 * @return true if the tree is complete and we can build it
	 */
	public boolean isCompleted() {
		return root.checkComplete();
	}
	
	//Getters and Setters
	public void setInfoPan(InfoPanController info) {
		infoPanel = info;
	}
	public InfoPanController getInfoPan() {
		return infoPanel;
	}
	public TreeElementController getRoot(){
		return root;
	}

	public JButton getBouton() {
		return buttonGenerate;
	}
}
