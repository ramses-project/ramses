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
  private ArrayList<String> ignored_files;
  private ArrayList<String> ignored_dir;
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
  
  //old constructor
//  public CompareDirectory(String ref, String Gen) throws IOException {
//    // Initialisation
//    this.listRef = new ArrayList<File>();
//    this.listGen = new ArrayList<File>();    
//    rootRef = new File(ref);
//    rootGen = new File(Gen);	
//    try {
//      this.setMaxPath(20);
//      iterateOnDirectories(ref, maxPath, this.listRef);
//
//      this.setMaxPath(20);
//      iterateOnDirectories(Gen,maxPath , this.listGen);
//    } catch (Exception e) {
//      System.out.println(e.toString());
//    }
//  }
  
  public CompareDirectory(String ref, String Gen, ArrayList<String> ig_f,ArrayList<String> ig_d) throws IOException {
	    // Initialization
	    this.listRef = new ArrayList<File>();
	    this.listGen = new ArrayList<File>();
	    rootRef = new File(ref);
	    rootGen = new File(Gen);
	    ignored_files = ig_f;
	    ignored_dir =ig_d;
	    
	    ignored_files.add(".aaxl2");
	    ignored_files.add(".o");
		ignored_files.add(".elf");
		ignored_files.add(".elf.map");
		ignored_files.add(".lo");
		ignored_files.add(".bin");
		
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
  private void iterateOnDirectories(String repertoire, int j, ArrayList<File> list) throws IOException {

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
  public void iterateOnDirectories(File dir, int depth, int maxDepth,
      ArrayList<File> list) {
    if (depth > maxDepth || dir.getName().contains(".svn")) {
      return;
    }
    if (dir.isDirectory() && !isIgnoredDir(dir)) {
      // System.out.println("Dossier : " + dir.toString());
      list.add(dir);
      File[] subdirs = dir.listFiles();
      for (int i = 0; i < subdirs.length; i++) {
        File subDir = subdirs[i];
        iterateOnDirectories(subDir, depth + 1, maxDepth, list);
      }
    } else if (dir.isFile() 
    		&& !dir.getName().contains("~")
    		&& !isIgnoredFile(dir)    		
    		) {
//       System.out.println("        fichier : " + dir.toString());
      list.add(dir);
    }
  }

  private  Boolean isIgnoredFile (File f){
	  Boolean res = false;
	  for ( String i : ignored_files)
		  res = res || f.getName().endsWith(i);	  
	  return res;
  }
  
  private Boolean isIgnoredDir (File f){
	  Boolean res = false;
	  for ( String i : ignored_dir)
		  res = res || f.getName().endsWith(i);	  
	  return res;
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