package ramses.test.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author asnoun samir Date : 07 June 2012
 * 
 */
public class CompareDirectory {
  
  private int maxPath = 20;
  private ArrayList<File> listRef;
  private ArrayList<File> listGen;
  
  File rootRef;
  File rootGen;
  
  /**
   * 
   * @param ref
   *            : Path Folder of the developer code reference
   * @param Gen
   *            : Path folder of the code server generated
   * @throws IOException
   */
  public CompareDirectory(String ref, String Gen) throws IOException {
    // Initialisation
    this.listRef = new ArrayList<File>();
    this.listGen = new ArrayList<File>();
    rootRef = new File(ref);
    rootGen = new File(Gen);
    try {
      this.setMaxPath(20);
      iterateOnDirectories(ref, maxPath, this.listRef);

      this.setMaxPath(20);
      iterateOnDirectories(Gen,maxPath , this.listGen);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  /**
   * 
   * @return
   * @throws IOException
   */
  public boolean evaluate() throws IOException {
	boolean noDiff = true;
    ArrayList<SimpleFile> sListGen = new ArrayList<SimpleFile>();
    for (File f : listGen) {
      SimpleFile sfg = new SimpleFile(f, rootGen);
      sListGen.add(sfg);
    }

    ArrayList<SimpleFile> sListRef = new ArrayList<SimpleFile>();
    for (File f : listRef) {
      SimpleFile sfr = new SimpleFile(f, rootRef);
      sListRef.add(sfr);
    }
    
    
    
    ArrayList<SimpleFile> inRefNotInGenImb = new ArrayList<SimpleFile>();
    boolean same_imb = false;
    for (SimpleFile sfR : sListRef) {
      //System.out.println(sfR.toString());
      
      same_imb = false;
      for (SimpleFile sfG : sListGen) {
        //System.out.println(sfG.toString());
        if(sfR.getPath().equals(sfG.getPath()))
        {
          same_imb = true ;
          if(!sfR.equals(sfG) && noDiff)
        	  noDiff=false;
          break;
        }
      
      }
      if(!same_imb)
        inRefNotInGenImb.add(sfR);
    }
    
    ArrayList<SimpleFile> inGenNotInRefImb = new ArrayList<SimpleFile>();
    for (SimpleFile sfG : sListGen) {
      //System.out.println(sfR.toString());
      
      same_imb = false;
      for (SimpleFile  sfR : sListRef) {
        //System.out.println(sfG.toString());
        if(sfR.getPath().equals(sfG.getPath()))
        {
            same_imb = true ;
            break;
         }  
      
      }
      if(!same_imb)
        inGenNotInRefImb.add(sfG);
    }
    
    
    

    try {
      if(!inGenNotInRefImb.isEmpty())
      {
    	System.err.println("");
    	System.err.println("----- File(s) in reference directory but not in generated directory -------");
        for (SimpleFile sf2 : inGenNotInRefImb) {
          System.err.println(sf2.toString());
        }
        System.err.println("---------------------------");
  
      }
      if(!inRefNotInGenImb.isEmpty())
      {
    	  System.err.println("----- File(s) in generated directory but not in reference directory -------");
        for (SimpleFile sf : inRefNotInGenImb ) {
          System.err.println(sf.toString());
        }
        System.err.println("------------------------");
      }
    } catch (Exception e) {
      // TODO: handle exception
      // System.out.println(e.toString());
    }
    
    return inRefNotInGenImb.isEmpty() && inGenNotInRefImb.isEmpty() && noDiff;
  }

  /**
   * 
   * @param repertoire
   * @param j
   * @param list
   * @throws IOException 
   */
  private static void iterateOnDirectories(String repertoire, int j,
      ArrayList<File> list) throws IOException {

    File rep = new File(repertoire);
    if (!rep.exists())
      throw new IOException(repertoire + ": directory does not exist");
    if(rep.getName().contains(".svn"))
    {
    	return;
    }
    String s[] = rep.list();
    try {
      iterateOnDirectories(rep, s.length, j, list);
    } catch (Exception e) {
      System.out.println(e.toString());
    }

    list.remove(rep);
  }

  /**
   * 
   * @param dir
   * @param depth
   * @param maxDepth
   * @param list
   */
  public static void iterateOnDirectories(File dir, int depth, int maxDepth,
      ArrayList<File> list) {
    if (depth > maxDepth || dir.getName().contains(".svn")) {
      return;
    }
    if (dir.isDirectory()
    	&& ! dir.getName().endsWith("kernel")
    	&& ! dir.getName().contains("build/data/hudson")	
    		) {
      // System.out.println("Dossier : " + dir.toString());
      list.add(dir);
      File[] subdirs = dir.listFiles();
      for (int i = 0; i < subdirs.length; i++) {
        File subDir = subdirs[i];
        iterateOnDirectories(subDir, depth + 1, maxDepth, list);
      }
    } else if (dir.isFile() 
    		&& !dir.getName().contains("~")
    		&& ! dir.getName().endsWith(".aaxl2")
    		&& ! dir.getName().endsWith(".o")
    		&& ! dir.getName().endsWith(".pid")
    		&& ! dir.getName().endsWith(".elf")
    		&& ! dir.getName().endsWith(".elf.map")
    		&& ! dir.getName().endsWith(".lo")
    		&& ! dir.getName().endsWith(".bin")
    		&& ! dir.getName().equals("sizes.c")
    		&& ! dir.getName().endsWith(".map")
    		&& ! dir.getName().endsWith("kernel_cfg.c")
    		&& ! dir.getName().endsWith("kernel_id.h")
    		) {
      // System.out.println("        fichier : " + dir.toString());
      list.add(dir);
    }
  }

  /**
   * 
   * @return
   */
  public int getDecMaxPath() {
    this.maxPath--;
    return maxPath;
  }

  /**
   * 
   * @param maxPath
   */
  public void setMaxPath(int maxPath) {
    this.maxPath = maxPath;
  }
}