/**
 * AADL-RAMSES
 *
 * Copyright © 2014 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.generation.osek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger ;

import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

/**
 * Manage compilation settings from properties files.
 */
public class Resources {

  private static Logger _LOGGER = Logger.getLogger(Resources.class) ;
  
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
	 * Exception throw when a resource is not found.
	 */
	public static class KeyNotFoundException extends RuntimeException {

		private static final long serialVersionUID = -8535637734214822481L;

		public KeyNotFoundException(String key) {
			super("The key \"" + key + "\" is not found.");
		}
	}

	private Properties properties;

  public Resources(File path)
  {
    properties = new Properties() ;

    FileInputStream fis = null ;

    try
    {
      fis = new FileInputStream(path) ;
      properties.load(fis) ;
    }
    catch(IOException e)
    {
      String errMsg = "cannot load properties" ;
      _LOGGER.fatal(errMsg, e) ;
      throw new RuntimeException(errMsg, e) ;
    }
    finally
    {
      if(fis != null)
        try
        {
          fis.close() ;
        }
        catch(IOException e)
        {
          String errMsg =  "cannot close the resource file" ;
          _LOGGER.fatal(errMsg, e) ;
          throw new RuntimeException(errMsg, e) ;
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