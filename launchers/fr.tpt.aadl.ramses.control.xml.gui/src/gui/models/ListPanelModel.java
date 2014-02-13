package gui.models;

import gui.classes.ListItem;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultListModel;

/**
* Handles the logic for the transformations, and analyses lists such as reading 
* a file or a folder for certain files that are to be displayed in a Jlist
*/
public class ListPanelModel extends DefaultListModel {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Contains all the list items
	 */
	private Vector<ListItem> items = new Vector<ListItem>();
	private String itemRootFolder;
	
	public ListPanelModel() {
		
	}
	
	/**
	 * Reads all files with the specified fileExtension from a folder,
	 * inserts them into a Vector<ListItem> and returns the vector 
	 * to be sent to and displayed in the view
	 * @param file where to look for files
	 * @param fileExtension which files to pick
	 * @return Vector with the loaded filenames
	 * @throws IOException 
	 */
	public Vector<ListItem> importItemsFromDirectory(File file, String fileExtension) {
		String fileNames[] = null;
		if(file.isDirectory()) {
			fileNames = file.list();
			for(String fileName : fileNames) {
				try {
					processAndImportItem(new File(file.getCanonicalPath() + File.separator + fileName), fileExtension);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return items;
	}

	/**
	 * Reads one file 
	 * @param file which file to read
	 * @param fileExtension which filetype to accept
	 * @return A 1-sized vector with a filename (string)
	 * @throws IOException 
	 */
	public Vector<ListItem> importItemFromFile(File file, String fileExtension) {
		processAndImportItem(file, fileExtension);
		return items;
	}
	
	private void processAndImportItem(File file, String fileExtension) {
		String fileName = file.getName();
		if (fileName.endsWith(fileExtension)) {
			fileName = fileName.replaceFirst(fileExtension, "");
			ListItem newItem;
			try {
				String fileCanPath = file.getCanonicalPath();
				fileName = fileName.replaceFirst(fileExtension, "");
				String fileRelPath = fileCanPath.replaceFirst(itemRootFolder + File.separator, "");
				fileRelPath = fileRelPath.replaceFirst(".asm", "");
				newItem = new ListItem(
						fileRelPath,
						fileCanPath);
				if(!itemExists(newItem))
					items.add(newItem);
				// else
					// TODO show dialog that says that item already exists 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean itemExists(ListItem item) {
		if(items.isEmpty())
			return false;
		
		Boolean exists = false;
		Iterator<ListItem> i = items.iterator();

		// iterate trough items and see if an item with the the same name already exists		
		while(i.hasNext()){
			ListItem next = i.next();
			if(next.getName().equals(item.getName()))
				return true;
			else
				exists = false;
		}
		return exists;
	}

	/**
	 * @return vector with string items
	 */
	public Vector<String> getItemsStrings() {
		Enumeration<?> enume = this.elements();
		Vector<String> itemStrings = new Vector<String>();
		while(enume.hasMoreElements())
			itemStrings.add(enume.nextElement().toString());
		return itemStrings;
	}
	
	public Vector<ListItem> getItems() {
		return items;
	}

	public ListItem getItem(int selectedIndex) {
		return items.get(selectedIndex);
	}

	public void setItemRootFolder(String itemRootFolder_) {
		itemRootFolder = itemRootFolder_;
	}
}
