package fr.tpt.aadl.ramses.analysis.eg.util.export;

import java.io.BufferedWriter ;
import java.io.FileWriter ;
import java.io.IOException ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;

public class EG2Text extends EGExport
{
  private static Logger _LOGGER = Logger.getLogger(EG2Text.class) ;
  
  public EG2Text(String outputDir)
  {
    super(outputDir);
  }
  
  private static void print(EGNode n, BufferedWriter writer)
  {
    print(n, 0, writer);
  }
  
  @Override
  protected void visit(ComponentInstance thread,
                       EGNode n)
  {
    final String outputPath = outputDir + thread.getName() + ".txt";
    try
    {
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
      print(n, writer);
      writer.close();
    }
    catch(IOException e)
    {
      String errMsg = "cannot write to file" ;
      _LOGGER.fatal(errMsg, e) ;
      throw new RuntimeException(errMsg, e) ;
    }
  }

  private final static String[] blockStart = {"if_","while_","_start"};
  private final static String[] blockEnd = {"endif","endwhile","_end"};
  
  private static boolean containsBlock(String[] blocks, String s)
  {
    for(String block : blocks)
    {
      if (s.contains(block))
      {
        return true;
      }
    }
    return false;
  }
  
  private static void print(EGNode n, int depth, BufferedWriter writer)
  {
    String indent = fill (depth, "");
    
    String kind = n.getKind().name();
    double bcet = n.getBCET();
    double wcet = n.getWCET();
    
    try
    {
      
      String kindStr = fill (20,kind);
      String nameStr = fill (90,n.getName());
      String line = indent+kindStr + "\t" + nameStr + "\t[" + bcet + ", " + wcet + "]";
      
      //if (n.getName().startsWith("if_") || n.getName().startsWith("while_"))
      if (containsBlock(blockStart, n.getName()))
      {
        depth = depth + 1;
        line = "\n" + line;
      }
      else if (n.getAllNext().size()==1)
      {
        EGNode next = n.getAllNext().get(0);
        //if (next.getName().contains("endif") || next.getName().contains("endwhile"))
        if (containsBlock(blockEnd, next.getName()))
        {
          depth = depth - 1;
          line = line + "\n";
        }
      }
      
      writer.append(line);
      writer.newLine();
    }
    catch(IOException e)
    {
      String errMsg = "cannot write to file" ;
      _LOGGER.fatal(errMsg, e) ;
      throw new RuntimeException(errMsg, e) ;
    }
    
    for(EGNode next : n.getAllNext())
    {
      print(next, depth, writer);
    }
  }
  
  private static String fill (int spaces, String s)
  {
    spaces = Math.max(0, spaces);
    
    String s2 = s;
    while (s2.length() < spaces)
    {
      s2 += " ";
    }
    return s2;
  }
}