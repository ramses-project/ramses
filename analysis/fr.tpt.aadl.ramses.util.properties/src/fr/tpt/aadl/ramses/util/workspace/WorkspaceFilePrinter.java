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

import java.io.ByteArrayInputStream ;
import java.io.File ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.PrintStream ;

import org.eclipse.core.resources.IFile ;
import org.eclipse.core.resources.IResource ;
import org.eclipse.core.resources.IWorkspaceRoot ;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.Path ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.util.AadlUtil ;

public class WorkspaceFilePrinter extends PrintStream
{

  public static PrintStream create(SystemInstance root,
                                   String name)
  {
    try
    {
      return new WorkspaceFilePrinter(root, name) ;
    }
    catch(Exception e)
    {
    }

    return System.out ;
  }

  private IFile file = null ;

  public WorkspaceFilePrinter(
                              SystemInstance root, String name)
        throws CoreException, IOException
  {
    super(createFile(root, name)) ;
    this.file = getFile(root, name) ;
  }

  private String buffer = "" ;

  private static File createFile(SystemInstance root,
                                 String name)
        throws CoreException, IOException
  {
    IFile file = getFile(root, name) ;

    if(!file.exists())
    {
      File f = file.getLocation().toFile() ;
      System.out.println(f.getAbsolutePath()) ;
      f.createNewFile() ;
      file.create(new ByteArrayInputStream(new byte[0]), true, null) ;
    }

    return file.getLocation().toFile() ;
  }

  private static IFile getFile(SystemInstance root,
                               String name)
  {
    final IWorkspaceRoot wr = ResourcesPlugin.getWorkspace().getRoot() ;
    String outputPath = getOutputPath(root, name) ;
    final IFile file = wr.getFile(new Path(outputPath)) ;
    return file ;
  }

  private static String getOutputPath(SystemInstance root,
                                      String name)
  {
    Resource res = root.eResource() ;
    String path = res.getURI().path() ;
    String newPath = path.replace("aaxl", "aadl") ;
    newPath = newPath.replace("_impl_Instance", name).replace(".aadl2", ".txt") ;

    if(newPath.startsWith("/resource/"))
    {
      newPath = newPath.substring(9) ;
    }

    int indexSep = newPath.lastIndexOf("/") ;
    newPath =
          newPath.substring(0, indexSep) + "/_" +
                newPath.substring(indexSep + 1) ;
    return newPath ;
  }

  public void println()
  {
    buffer += "\n" ;
  }

  public void println(String s)
  {
    buffer += s + "\n" ;
  }

  public void write(int i)
  {
    buffer += i ;
  }

  public void write(byte[] buf)
  {
    buffer += new String(buf) ;
  }

  public void write(byte[] buf,
                    int off,
                    int len)
  {
    buffer += new String(buf, off, len) ;
  }

  @SuppressWarnings("deprecation")
  public void close()
  {
    final InputStream input = new ByteArrayInputStream(buffer.getBytes()) ;

    try
    {
      if(file.exists())
      {
        file.setContents(input, true, true, null) ;
      }
      else
      {
        AadlUtil.makeSureFoldersExist(file.getFullPath()) ;
        file.create(input, true, null) ;
      }

      file.setDerived(true) ;
      file.deleteMarkers(null, true, IResource.DEPTH_INFINITE) ;
    }
    catch(final CoreException e)
    {
      e.printStackTrace() ;
    }
  }

}
