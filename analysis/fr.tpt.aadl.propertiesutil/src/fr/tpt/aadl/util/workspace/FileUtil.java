package fr.tpt.aadl.util.workspace ;

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

  public static void saveBufferInFile(String buffer,
                                      String filename)
  {
    File f = new File(filename) ;
    BufferedWriter writer = null ;

    try
    {
      writer = new BufferedWriter(new FileWriter(f)) ;
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
