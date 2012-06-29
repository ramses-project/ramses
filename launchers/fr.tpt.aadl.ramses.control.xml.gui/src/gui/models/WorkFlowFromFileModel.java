package gui.models;

import gui.controllers.TreeElementController;
import gui.controllers.WorkflowPanelController;
import gui.controllers.TreeElementController.ElementType;

import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;

import org.jdom2.Element;
import org.jdom2.input.*;

/**
 * Creation of the Workflow using a existing XML file
 * The file is validate using his DocType Definition
 * then a JDOM tree is created
 * The JDOM tree is converted to the WorkflowPan tree (starting with root)
 * 
 */
public class WorkFlowFromFileModel {

	static org.jdom2.Document document;
	private File file;
	private WorkflowPanelController workPan;

	/**
	 * Constructor
	 * 
	 * @param file_ file to read
	 * @param pan_
	 */
	public WorkFlowFromFileModel(File file_, WorkflowPanelController pan_) {
		workPan = pan_;
		file = file_;
	}
	
	/**
	 * 
	 * @return 0 means "An error occurred", and 1 means "Good"
	 */
	public int parse(){
		@SuppressWarnings("deprecation")
		SAXBuilder sxb = new SAXBuilder(true);	//true to validate the file (with his DTD)
		try
		{
			//Creation of the JDOM tree
			document = sxb.build(file);
			
			//First element is <workflow>, so we take his first child
			Element rootDom = document.getRootElement().getChildren().get(0);
			
			//Call of the recursive function that create the Elements tree
			workPan.root = computeTreeFromDom(rootDom, null);
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	/**
	 * Recursive function that create the TreeElement tree
	 * 
	 * @param domElement current JDOM element, to convert in a TreeElement
	 * @param father_ TreeElement father of the current element
	 * @return
	 */
	private TreeElementController computeTreeFromDom(Element domElement, TreeElementController father_){
		TreeElementController currentElement = copyDomToElements(domElement);
		currentElement.setFather(father_);
		
		//Recursion to create children
		switch (currentElement.getType()){
		case TRANSFORMATION :
			//One branch
			currentElement.setChildYes(computeTreeFromDom(domElement.getChildren().get(1), currentElement));
			break;
		case ANALYSIS :
			//Two branches
			currentElement.setChildYes(computeTreeFromDom(domElement.getChild("yes").getChildren().get(0), currentElement));
			currentElement.setChildNo(computeTreeFromDom(domElement.getChild("no").getChildren().get(0), currentElement));
			currentElement.changeParentWidth(1);
			break;
		default :
			break;
		}
		

		workPan.add(currentElement);
		return currentElement;
	}

	/**
	 * Conversion of a JDOM Element to a TreeElement
	 * @param domElement
	 * @return
	 */
	private TreeElementController copyDomToElements(Element domElement) {
		ElementType type;
		if (domElement.getName() == "transformation") type = ElementType.TRANSFORMATION;
		else if (domElement.getName() == "analysis") type = ElementType.ANALYSIS;
		else if (domElement.getName() == "generation") type = ElementType.CODE_GENERATION;
		else if (domElement.getName() == "errorstate") type = ElementType.ERROR_STATE;
		else type = ElementType.EMPTY_ELEMENT;

		//Creation of the Workflow element
		TreeElementController element = new TreeElementController(type, (workPan.getWidth()-50)/2, 140, workPan, null);

		//We set up the attributes
		switch (type){
		case TRANSFORMATION :
			//Fill the Names attribute with the <file path="..." /> tags
			List<Element> filePathList = domElement.getChild("list").getChildren();
			
			for (int i=0, n = filePathList.size(); i < n; i++){
				String fileName = filePathList.get(i).getAttribute("path").getValue();
				//Remove the .asm extension
				int lastDotIndex = fileName.lastIndexOf(".");
				element.addName(fileName.substring(0, lastDotIndex));
			}			
			
			element.setId("T" + ++workPan.nbTrans);
			element.setIcon(new ImageIcon("images/transfo.png"));
			break;
		case ANALYSIS :
			element.addName(domElement.getAttribute("method").getValue());
			
			//Existing attribute mode
			if (domElement.getAttributes().size() == 2){
				if (domElement.getAttribute("mode").getValue().equals("manual")) element.setManualMode(true);
				else element.setManualMode(false);
			}
			element.setWid(1);
			element.setId("A" + ++workPan.nbAna);
			element.setIcon(new ImageIcon("images/analysis.png"));
			break;
		case CODE_GENERATION :
			element.setIcon(new ImageIcon("images/generation.png"));
			break;
		case ERROR_STATE :
			element.setIcon(new ImageIcon("images/error.png"));
			element.setId("ES" + ++workPan.nbErr);
			break;
		default :
			break;
		}

		return element;
	}
}
