package fr.tpt.aadl.ramses.util.workspace ;

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
                            String filename,
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
