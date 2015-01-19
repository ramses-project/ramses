package fr.tpt.aadl.ramses.analysis.eg.util.export;

import java.io.File ;

import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.analysis.eg.model.EGModels ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;

public abstract class EGExport
{
  protected final String outputDir;
  
  public EGExport (String outputDir)
  {
    this.outputDir = outputDir;
    if (!outputDir.endsWith(File.separator))
    {
      outputDir += File.separator;
    }
    initDirectory(new File(outputDir));
  }
  
  private void initDirectory(File f)
  {
    if (!f.exists())
    {
      f.mkdir();
    }
  }
  
  public final void launch (EGModels m, SystemInstance s)
  {
    for(ComponentInstance thread : s.getAllComponentInstances())
    {
      if (thread.getCategory() != ComponentCategory.THREAD)
      {
        continue;
      }
      
      visit (thread, m.getEG(thread));
    }
  }
  
  protected abstract void visit(ComponentInstance thread, EGNode n);
}
