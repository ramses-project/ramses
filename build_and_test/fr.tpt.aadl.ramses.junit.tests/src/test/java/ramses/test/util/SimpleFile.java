package ramses.test.util;

import java.io.File;
import java.io.IOException ;

import com.saxman.textdiff.Report;
import com.saxman.textdiff.TextDiff;
/**
 * 
 * @author asnoun date : 07 June 2012
 */
public class SimpleFile implements Comparable<Object> {
	String path;
	
	public String getPath() {
		return path;
	}

	String name;
	
	File file;
	

	
	/**
	 * 
	 * @param File
	 *            : f
	 */
	public SimpleFile(File f, File rootDirectory) {
		this.path = f.getAbsolutePath().replaceFirst(rootDirectory.getAbsolutePath()+"/", "");
		this.name = f.getName();
		this.file = f;
	}

	/**
	 * 
	 * @param File
	 *            : f1
	 * @return true only if the two files (same name, same size,
	 * @throws IOException
	 */
	public boolean equals(SimpleFile f1) throws IOException {
		boolean s = true;
		s = s && (f1.path.compareTo(this.path) == 0);
			
		if( s && 
			!f1.file.isDirectory())
		{
		  Report report = new TextDiff().compare( this.file, f1.file );  
		  if(report.containsDiff())
		  {
			System.out.println("Differences found between: \nOld file: "+this.file.getAbsolutePath()+
					"\nand\n" +
					"New file: "+f1.file.getAbsolutePath()+"\n");
		    report.print( );
		    s = false;
		  }
		}
		return s;
	}

	/**
	 * return String : file component
	 */
	public String toString() {
		return this.path;
	}

  public int compareTo(Object o)
  {
    if (o instanceof SimpleFile) {
      if (this.equals(o)) {
        return 1;
      } else
        return 0;

    } else
      return 0;
  }
  
}