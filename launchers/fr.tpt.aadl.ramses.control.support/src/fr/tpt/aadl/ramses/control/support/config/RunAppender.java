package fr.tpt.aadl.ramses.control.support.config;

import java.io.File ;
import java.io.FileFilter ;
import java.text.SimpleDateFormat ;
import java.util.Date ;

import org.apache.log4j.FileAppender ;

public class RunAppender extends FileAppender
{
  private int _maxIndex = 10 ; // Default value is 10.

  @Override
  public void activateOptions()
  {
    super.fileAppend = false ;

    this.cleanLogfiles(super.fileName) ;
    
    super.fileName = this.formatFileName(super.fileName) ;
    
    super.activateOptions();
  }
  
  private void cleanLogfiles(String originateFilePath)
  {
    File file = new File(originateFilePath) ;
    
    String fileName = file.getName() ;
    
    final String prefix ;
    
    int index = fileName.lastIndexOf('.') ;
    
    // index == -1 if file name haven't any dot.
    // index == 0 if the file name begin with a dot (hidden file undex Unix).
    if(index > 0)
    {
      prefix = fileName.substring(0, index) ;
    }
    else
    {
      prefix = fileName ;
    }
    
    File dir = file.getParentFile() ;
    
    // Only root file system doesn't have parent.
    if(dir == null)
    {
      dir = new File("/") ;
    }
    
    File[] logFiles = dir.listFiles(new FileFilter(){

      @Override
      public boolean accept(File arg0)
      {
        return arg0.getName().startsWith(prefix) ;
      }
    }) ;
    
    if(logFiles != null && logFiles.length > _maxIndex -1)
    {
      File oldest = logFiles[0] ;
      
      for(int i = 1 ; i < logFiles.length ; i++)
      {
        if(logFiles[i].lastModified() < oldest.lastModified())
        {
          oldest = logFiles[i];
        }
      }
      
      oldest.delete() ;
    }
  }

  private String formatFileName(String originateFilePath)
  {
    String datePattern = "yyyy-MM-dd-HHmmss" ;
    SimpleDateFormat sdf = new SimpleDateFormat(datePattern) ;
    
    File file = new File(originateFilePath) ;
    String fileName = file.getName() ;
    File dir = file.getParentFile() ;
    
    // Only root file system doesn't have parent.
    if(dir == null)
    {
      dir = new File("/") ;
    }
    
    int index = fileName.lastIndexOf('.') ;
    
    // logfile name has an extension.
    if(index > 0)
    {
      String prefix = fileName.substring(0, index) ;
      String extension = fileName.substring(index, fileName.length()) ;
      return dir + File.separator + prefix + '-' + sdf.format(new Date()) +
             extension ;
    }
    else
    {
      return originateFilePath + '-' + sdf.format(new Date()) ;
    }
  }
  
  public void setMaxBackupIndex(int maxIndex)
  {
    _maxIndex = maxIndex ;
  }
}