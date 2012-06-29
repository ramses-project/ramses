package gui.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import gui.controllers.TreeElementController;

/**
 * Class that generate the XML file from the displayed workflow 
 * 
 */
public class XMLGenerator {
	
	private TreeElementController root;
	private File file;
	//DocType Definition (DTD) of the XML file. Can be used to validate the XML file.
	private String docType = new String("<!DOCTYPE workflow [\n"
			+ "<!ELEMENT workflow (transformation | analysis | generation)>\n"
			+ "<!ELEMENT analysis (yes,no)>\n"
			+ "<!ELEMENT yes (transformation | analysis | generation | errorstate)>\n"
			+ "<!ELEMENT no (transformation | analysis | generation | errorstate)>\n"
			+ "<!ELEMENT transformation (list,(transformation | analysis | generation | errorstate))>\n"
			+ "<!ELEMENT list (file+)>\n"
			+ "<!ELEMENT file EMPTY>\n"
			+ "<!ATTLIST file path CDATA #REQUIRED>\n"
			+ "<!ELEMENT generation EMPTY>\n"
			+ "<!ELEMENT errorstate EMPTY>\n"
			+ "<!ATTLIST analysis method CDATA #REQUIRED\n"
			+ "                   mode CDATA #IMPLIED>\n"
			+ "<!ATTLIST errorstate type CDATA #IMPLIED>\n"
			+ "]>\n");
	
	/**
	 * 
	 * @param root_ root element of the Workflow
	 * @param file_ output file
	 */
	public XMLGenerator(TreeElementController root_, File file_){
		root = root_;
		file = file_;
		
		try {
			generateXMLFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Generation function
	 * 
	 * @throws IOException 
	 */
	private void generateXMLFile() throws IOException {
		//File opening : can throw an exception, because of the file name.
		FileWriter fileWriter = new FileWriter(file, false);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//Header of the XML file
		bufferedWriter.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n");
		bufferedWriter.write(docType);
		//Root element of the XML File
		bufferedWriter.write("<workflow>\n");
		//Recursive function called
		bufferedWriter.write(generateTree(root, 1));
		bufferedWriter.write("</workflow>\n");
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
	/**
	 * Recursive function
	 * Create the String containing the XML tree 
	 * 
	 * @param currentElem current element in the recursion, to be written in the String.
	 * @param recursionLevel the indentation rises with the level of recursion
	 * @return String containing the XML sub tree of the branch starting with currentElem
	 */
	public String generateTree(TreeElementController currentElem, int recursionLevel){
		switch (currentElem.getType()){
			//End tags are ERROR_STATE or CODE_GENERATION
			case ERROR_STATE :
				return tab(recursionLevel) + "<errorstate />\n";
			case CODE_GENERATION :
				return tab(recursionLevel) + "<generation />\n";
				
			//For the other tags, the function is called between the opening tag and the terminating tag.	
			case TRANSFORMATION :
				
				//Building of <file path="..." /> list 
				String fileList = new String("");
				for (int i=0, n = currentElem.getNames().size(); i < n; i++){
					fileList += tab(recursionLevel + 2) + "<file path=\"" + currentElem.getNames().get(i) + ".asm\" />\n";
				}
				
				return tab(recursionLevel) + "<transformation>\n"
				+ tab(recursionLevel + 1) + "<list>\n"
					+ fileList
				+ tab(recursionLevel + 1) + "</list>\n"
				+ generateTree(currentElem.getChildYes(), recursionLevel + 1)
				+ tab(recursionLevel) + "</transformation>\n";
			case ANALYSIS :
				String modeAttributeValue = "";
				if (currentElem.isManualMode()) modeAttributeValue = "manual";
				else modeAttributeValue = "automatic";
				String modeAttribute = " mode=\"" + modeAttributeValue + "\"";
				return tab(recursionLevel) + "<analysis method=\"" + currentElem.getNames().get(0) + "\"" + modeAttribute + ">\n"
					//Yes branch
					+ tab(recursionLevel + 1) + "<yes>\n" 
						+ generateTree(currentElem.getChildYes(), recursionLevel + 2) 
					+ tab(recursionLevel + 1) + "</yes>\n"
					//No branch
					+ tab(recursionLevel + 1) + "<no>\n" 
						+ generateTree(currentElem.getChildNo(), recursionLevel + 2) 
					+ tab(recursionLevel + 1) + "</no>\n"
				+ tab(recursionLevel) + "</analysis>\n";
			case EMPTY_ELEMENT :
				break;
			default :
				break;
		}
		return null;
	}
	
	/**
	 * 
	 * @param recursionLevel
	 * @return String of spaces that will be used at each start of line to indent the XML code. The number of spaces depends on the level. 
	 */
	private String tab(int recursionLevel){
		String result = new String("");
		for (int i = 0; i < recursionLevel; i++) result += "    ";
		return result;
	}
}
