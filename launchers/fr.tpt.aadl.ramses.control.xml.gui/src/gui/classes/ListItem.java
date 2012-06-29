package gui.classes;

/**
 * An item that is displayed in the list to the right. Can be a 
 * transformation or an analysis and holds a name and path as variables
 */
public class ListItem {
	
	private String name;
	private String absolutePath;
	
	/**
	 * @param name The filename without the file extension
	 * @param path The full canonical path to the file
	 */
	public ListItem(String name, String path) {
		this.name = name;
		this.absolutePath = path;
	}
	
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String path) {
		this.absolutePath = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
