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

import java.io.File ;
import java.io.FileOutputStream ;
import java.io.IOException ;
import java.io.OutputStream ;

import org.jdom.Document ;
import org.jdom.Element ;
import org.jdom.output.Format ;
import org.jdom.output.XMLOutputter ;

public class XMLUtil
{

  private static void outputXML(Document doc,
                                OutputStream stream)
  {
    XMLOutputter output = new XMLOutputter(Format.getPrettyFormat()) ;

    try
    {
      output.output(doc, stream) ;
    }
    catch(IOException e)
    {
      e.printStackTrace() ;
    }
  }

  public static void printXML(Document doc)
  {
    outputXML(doc, System.out) ;
  }

  public static void saveIn(Document doc,
                            File filename,
                            String header)
  {
    try
    {
      outputXML(doc, new FileOutputStream(filename)) ;

      if(header != null)
      {
        String buffer = FileUtil.getFileInBuffer(filename) ;
        int indexFL = buffer.indexOf("\n") ;
        buffer = header + buffer.substring(indexFL) ;
        FileUtil.saveBufferInFile(buffer, filename) ;
      }
    }
    catch(IOException e)
    {
      e.printStackTrace() ;
    }
  }

  public static Element createEnclosedValue(String elementName,
                                            String value)
  {
    Element e = new Element(elementName) ;
    e.addContent(value) ;
    return e ;
  }

  public static Element createEnclosedValue(String elementName,
                                            int value)
  {
    return createEnclosedValue(elementName, value + "") ;
  }

}
