/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.util.workspace ;

import java.io.BufferedReader ;
import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.IOException ;

public class FileUtil
{

	private FileUtil()
	{
	}


	public static String getFileInBuffer(File filename)
			throws IOException
			{
		BufferedReader reader =
				new BufferedReader(new FileReader(filename)) ;
		String buffer = "" ;
		String line = "" ;

		while((line = reader.readLine()) != null)
		{
			buffer += line + "\n" ;
		}

		reader.close() ;
		return buffer ;
			}

	public static void saveBufferInFile(String buffer,
			File filename)
	{
		BufferedWriter writer = null ;

		try
		{
			writer = new BufferedWriter(new FileWriter(filename)) ;
			writer.write(buffer) ;
			writer.close() ;
		}
		catch(IOException e)
		{
			try
			{
				writer.close() ;
			}
			catch(Exception e2)
			{
			}
		}
		finally
		{
			try
			{
				writer.close() ;
			}
			catch(Exception e2)
			{
			}
		}
	}
}
