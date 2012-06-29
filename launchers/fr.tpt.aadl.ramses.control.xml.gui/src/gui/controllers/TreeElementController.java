package gui.controllers;

import gui.listeners.ElementsListener;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.lang.Math;
import java.util.Vector;

/**
 * This class describes any Elements such as a transformation,
 * an analysis, a code generation or an error state.
 * It extends from JLabel in order to draw easily icons and to
 * listen to mouse events
 * 
 */
public class TreeElementController extends JLabel{

	public enum ElementType { 
		EMPTY_ELEMENT,
		TRANSFORMATION,
		ANALYSIS,
		CODE_GENERATION,
		ERROR_STATE
	}
	
	private static final long serialVersionUID = 1L;
	
	private ElementType type;
	private TreeElementController childYes;
	private TreeElementController childNo;
	private TreeElementController father;
	
	private int posX;
	private int posY;
	private int width;
	
	private Vector<String> names;
	private String id;
	private boolean manualMode;

	WorkflowPanelController workPan;
	
	/**
	 * Constructor for an element
	 * It's always an empty element that we instanciate,
	 * we change it after
	 * 
	 * @param _type define the type of the element
	 * @param i x position on the panel (for drawing)
	 * @param j y position on the panel (for drawing)
	 * @param pan the element needs to know the workflow panel
	 * @param fath father of the element in the tree
	 */
	public TreeElementController(ElementType _type, int i, int j, WorkflowPanelController pan, TreeElementController fath) {
		super();
		type = _type;
		posX = i;
		posY = j;
		workPan = pan;
		father = fath;
		childYes = null;
		childNo = null;
		setManualMode(false);
		setId("");
		
		setIcon(new ImageIcon("images/element.png"));

		//setBounds place the label with a size on the workflow panel
		setBounds(posX, posY, 50, 50);
		
		addMouseListener(new ElementsListener(this, workPan));
	}
	
	/**
	 * method that will recalculate recursively positions
	 * of all elements when we made a change on the panel
	 * 
	 * @param x new x position on the panel
	 * @param y new y position on the panel
	 */
	public void changePos(int x, int y) {
		setBounds(x, y, 50, 50);
		posX=x;
		posY=y;
		if (type == ElementType.TRANSFORMATION) {
			childYes.changePos(x, y+100);
		}
		else if (type == ElementType.ANALYSIS) {
			childYes.changePos(x-width*40, y+100);
			childNo.changePos(x+width*40, y+100);
		}
	}
	
	/**
	 * When an analysis is added on the tree
	 * we need to enlarge the width of any analysis that are higher
	 * It's the same when we delete but we reduce the width
	 * 
	 * @param delta when positive we enlarge parents, when negative we reduce them
	 */
	public void changeParentWidth(int delta) {
		if (father != null) {
			if (father.getType() == ElementType.ANALYSIS) {
				father.width += delta;
			}
			father.changeParentWidth(delta);
		}
	}
	
	/**
	 * method that checks recursively if a tree is correct to transform in XML
	 * 
	 * @return true when the tree is complete
	 */
	public boolean checkComplete() {
		switch (type) {
		case EMPTY_ELEMENT:
			return false;
		case CODE_GENERATION:
			return true;
		case ERROR_STATE:
			return true;
		case TRANSFORMATION:
			return childYes.checkComplete();
		case ANALYSIS:
			return (childYes.checkComplete() && childNo.checkComplete());
		default: 
			return false;
		}
	}
	
	/**
	 * Uses to know when the panel needs to be resized
	 * 
	 * @return the length between the element and the furthest leaf
	 */
	public int getLevel() {
		switch (type) {
		case TRANSFORMATION:
			return (1+childYes.getLevel());
		case ANALYSIS:
			return (1+(Math.max(childYes.getLevel(),childNo.getLevel())));
		case CODE_GENERATION:
		case ERROR_STATE:
		case EMPTY_ELEMENT:
			return 1;
		default:
			return 0;
		}
	}
	
	/**
	 * Delete all child elements from the panel
	 */
	public void removeChildFromPan(){
		if (type == ElementType.TRANSFORMATION) {
			workPan.remove(childYes);
			childYes.removeChildFromPan();
		}
		else if (type == ElementType.ANALYSIS) {
			workPan.remove(childNo);
			workPan.remove(childYes);
			childYes.removeChildFromPan();
			childNo.removeChildFromPan();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (type == ElementType.TRANSFORMATION) {
			g.drawString(id, 15, 30);
			//setCLip allows us to draw outside the JLabel
			g.setClip(0, 0, 50, 100);
			//Drawing of the arrow
			g.drawLine(25, 50, 25, 100);
			g.drawLine(20, 95, 25, 100);
			g.drawLine(30, 95, 25, 100);
		}
		else if (type == ElementType.ANALYSIS) {
			g.drawString(id, 15, 30);
			g.setClip(0-width*40, 0, 50+2*width*40, 100);
			//Drawing of the "Yes" arrow
			g.drawLine(25-width*40, 25, 25-width*40, 100);
			g.drawLine(20-width*40, 95, 25-width*40, 100);
			g.drawLine(30-width*40, 95, 25-width*40, 100);
			g.drawLine(25-width*40,25,0,25);
			g.drawString("Yes", 25-width*40 + 5, 75);

			//Drawing of the "No" arrow
			g.drawLine(25+width*40, 25, 25+width*40, 100);
			g.drawLine(20+width*40, 95, 25+width*40, 100);
			g.drawLine(30+width*40, 95, 25+width*40, 100);
			g.drawString("No", 25+width*40 - 25, 75);
			g.drawLine(50,25,25+width*40,25);
		}
		else if (type == ElementType.ERROR_STATE) {
			g.drawString(id, 15, 25);
		}

	}
	
	//Getters and Setters for all private attributes
	public void setX(int x){
		posX = x;
	}
	public void setY(int y){
		posY = y;
	}
	public int getX() {
		return posX;
	}
	public int getY() {
		return posY;
	}
	public void setChildYes(TreeElementController child_) {
		childYes = child_;
	}
	public TreeElementController getChildYes() {
		return childYes;
	}
	public void setChildNo(TreeElementController child_) {
		childNo = child_;
	}
	public TreeElementController getChildNo() {
		return childNo;
	}
	public void setFather(TreeElementController father_) {
		father = father_;
	}
	public TreeElementController getFather() {
		return father;
	}
	public void setType(ElementType t) {
		type = t;
	}
	public ElementType getType(){
		return type;
	}
	public Vector<String> getNames() {
		return names;
	}
	public void addName(String name_) {
		if (names == null) {
			names = new Vector<String>();
		}
		names.add(name_);
	}
	public void setNames(Vector<String>names_){
		this.names = names_;
	}
	public void setWid(int wid) {
		width = wid;
	}
	public int getWid(){
		return width;
	}
	public String getId(){
		return id;
	}
	public void setId(String id_){
		id = id_;
	}
	public boolean isManualMode() {
		return manualMode;
	}
	public void setManualMode(boolean automaticMode) {
		this.manualMode = automaticMode;
	}

}
