package fr.tpt.aadl.ramses.generation.osek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Manage compilation settings from properties files.
 */
public class Resources {

	/**
	 * Exception throw when properties files is not found.
	 */
	public static class RessourceNotFoundException extends RuntimeException {

		private static final long serialVersionUID = -8535637734214822481L;

		public RessourceNotFoundException(Throwable cause) {
			super(cause);
		}
	}

	/**
	 * Exception throw when a ressource is not found.
	 */
	public static class KeyNotFoundException extends RuntimeException {

		private static final long serialVersionUID = -8535637734214822481L;

		public KeyNotFoundException(String key) {
			super("The key \"" + key + "\" is not found.");
		}
	}

	private Properties properties;

	public Resources(File path) {

		properties = new Properties();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(path);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			new RessourceNotFoundException(e);
		} catch (IOException e) {
			new RessourceNotFoundException(e);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public String getValue(String key) throws KeyNotFoundException {

		String value = properties.getProperty(key);
		if (value == null)
			throw new KeyNotFoundException(key);

		return value;
	}

	/**
	 * Fetch all properties matching keyX where x is a integer from 0 to N.  
	 */
	public List<String> getValues(String key) throws KeyNotFoundException {

		List<String> values = new ArrayList<String>();

		for (int cpt = 0;; cpt++) {
			String value = properties.getProperty(key + cpt);
			if (value == null)
				break;
			else
				values.add(value);
		}

		if (values.size() == 0)
			throw new KeyNotFoundException(key);

		return values;
	}
}
