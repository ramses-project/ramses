package fr.tpt.aadl.ramses.control.support.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * This class gives different util methods to manipulate (create, save, delete...)
 * files.
 */

public class FileUtils {

	/**
	 * This method checks that files stored in an array of path (String) actually
	 * exist.
	 * @param fileNamesArray the array fo String referencing files.
	 * @param faultyFiles the files not found
	 * @return a set of #{@link java.io.File} identified from the path in 
	 * {@code includeDirArray}.
	 */
	public static Set<File> checkFilesExist(String fileNamesArray[], boolean[] faultyFiles)
	{
		Set<File> includeDirSet = new LinkedHashSet<File>();
	    for(int i = 0 ; i < fileNamesArray.length ; i++)
	    {
	      File potentialFile = new File(fileNamesArray[i]) ;
	      
	      if(potentialFile.exists())
	      {
	    	  includeDirSet.add(potentialFile) ;
	    	  faultyFiles[i] = false ;
	        continue ;
	      }
	      else
	      {
	        faultyFiles[i] = true ;
	      }
	    }
	    return includeDirSet;
	}
	
	/**
	 * This method deletes a file or a directory. If {@code file} is
	 * a directory, its content is deleted recursively and then it is
	 * deleted as well.
	 * @param file the file or directory that must be deleted.
	 */
	public static void deleteDirectory(File file) {

		if (file.isDirectory()) {
			for (File subFile : file.listFiles())
				deleteDirectory(subFile);
			file.delete();
		} else
			file.delete();
	}

	/**
	 * This method create a new #{@link java.io.File}, puts
	 *  the String {@code content} in this {@code file}, and saves it.
	 * @param file the destination in which {@code content} must be 
	 * saved.
	 * @param content the String that identifies the future content
	 * of the file
	 * @return true if the creation of the file succeeds, false 
	 * otherwise.
	 */
	public static boolean createFile(File file, String content) {
		PrintWriter writer = null;
		try {
			if (file.createNewFile()) {
				writer = new PrintWriter(file);
				writer.write(content);
			}
		} catch (IOException e) {
			return false;
		} finally {
			if (writer != null)
				writer.close();
		}
		return true;
	}

	/**
	 * From a directory, this method looks recursively 
	 * for files with a given extension.
	 * @param file the root directory from which files with extension
	 * {@code filenameExtension} will be retrieved.
	 * @param filenameExtension the file extension to identified files
	 * of interest.
	 * @return the list of File found with the extension 
	 * {@code filenameExtension}.
	 */
	public static List<File> findFiles(File file, String filenameExtension) {

		List<File> paths = new ArrayList<File>();
		List<File> files = new ArrayList<File>();

		if (file.isDirectory() == false)
			return null;

		files.add(file);

		while (files.isEmpty() == false) {

			File tmpFile = files.remove(files.size() - 1);

			for (File subFile : tmpFile.listFiles())
				if (subFile.isDirectory())
					files.add(subFile);
				else if (subFile.getName().endsWith(filenameExtension)) {
					paths.add(subFile);
				}
		}

		return paths;
	}

	/**
	 * This method copies the content of a file (possibly directory)
	 * in another file. Both must be created before calling this 
	 * method.
	 * @param src the source file that will be copied.
	 * @param dest the destination file, result of the copy.
	 */
	public static void copyFile(File src, File dest) {
		InputStream in = null;
		OutputStream out = null;

		if (dest.isDirectory())
			dest = new File(dest, src.getName());

		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * This method copies, from a given directory, a set
	 * of files with a given list of file extensions.
	 * @param src the root directory from which files are copied.
	 * @param dest the destination directory in which files are copied.
	 * @param filenameExtension a list of file extension to find which file
	 * to copy.
	 */
	public static void copyFiles(File src, File dest, String... filenameExtension) {

		List<File> files = new ArrayList<File>();

		if (src.isDirectory() == false) {
			return;
		} else {
			files.add(src);

			while (files.isEmpty() == false) {

				File tmpFile = files.remove(files.size() - 1);

				for (File subFile : tmpFile.listFiles()) {
					if (subFile.isDirectory()) {
						files.add(subFile);
					} else {
						for (String extension : filenameExtension) {
							if (subFile.getName().endsWith(extension)) {
								copyFile(subFile, new File(dest, subFile.getName()));
							}
						}
					}
				}
			}
		}
	}

	/**
	 * This method save the String {@code content} in a file which name is
	 * {@code fileName}. The file is saved in directory {@code directory}.
	 * @param directory the directory in which new file will be saved.
	 * @param fileName the name of the created file.
	 * @param content the content saved in the created file.
	 * @throws IOException {@link IOException}
	 */
	public static void saveFile(File directory,
			String fileName,
			String content) throws IOException
	{
		BufferedWriter output ;

		FileWriter file =
				new FileWriter(directory.getAbsolutePath() + File.separator + fileName) ;

		output = new BufferedWriter(file) ;

		output.write(content) ;

		output.close() ;
	}
	
	public static String getFileInBuffer(String filename)
	        throws IOException
	  {
	    BufferedReader reader =
	          new BufferedReader(new FileReader(new File(filename))) ;
	    String buffer = "" ;
	    String line = "" ;

	    while((line = reader.readLine()) != null)
	    {
	      buffer += line + "\n" ;
	    }

	    reader.close() ;
	    return buffer ;
	  }
	
}