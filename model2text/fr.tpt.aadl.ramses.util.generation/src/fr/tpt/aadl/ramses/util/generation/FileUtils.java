package fr.tpt.aadl.ramses.util.generation;

import java.io.BufferedWriter ;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter ;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource ;

public class FileUtils {

  
  public static File getContainingDirectory(Resource r)
  {
    return new File(r.getURI().toFileString()).getParentFile().getParentFile();
  }
  
  public static void saveFile(File directory,
                              String fileName,
                              String content) throws IOException
  {
    BufferedWriter output ;

    FileWriter file =
          new FileWriter(directory.getAbsolutePath() + "/" + fileName) ;

    output = new BufferedWriter(file) ;

    output.write(content) ;

    output.close() ;
  }
  
	public static void deleteDirectory(File file) {

		if (file.isDirectory()) {
			for (File subFile : file.listFiles())
				deleteDirectory(subFile);
			file.delete();
		} else
			file.delete();
	}

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

	public static File copyFile(File src, File dest) {
		InputStream in = null;
		OutputStream out = null;

		
		if (dest.isDirectory())
		{
			dest = new File(dest, src.getName());
			if(dest.exists())
			  return dest;
		}

		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
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

		return dest;
	}

	public static List<String> copyFiles(File src, File dest, String... filenameExtension) {

		List<String> paths = new ArrayList<String>();
		List<File> files = new ArrayList<File>();

		if (src.isDirectory() == false) {
			return null;
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

		return paths;
	}
}