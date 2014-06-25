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

package fr.tpt.atl.to.trc.handler;

import java.io.File;

public class GenerateActionUtils {

	public static String findConfigFile(File rootDirectory, String extension )
	{
		File[] list = rootDirectory.listFiles();

		if (list == null) return null;

		for ( File f : list ) {
			if ( f.isDirectory() ) {
				String result = findConfigFile( f, extension );
				if(result == null)
					continue;
				else
					return result;
			}
			else {
				if(f.getPath().endsWith("."+extension))
					return f.getAbsolutePath(); 
			}
		}
		return null;
	}
}