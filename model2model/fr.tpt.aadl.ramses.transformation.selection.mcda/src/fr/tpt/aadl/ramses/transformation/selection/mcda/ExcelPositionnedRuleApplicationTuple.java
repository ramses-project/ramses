package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.List ;

import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;

public class ExcelPositionnedRuleApplicationTuple extends RuleApplicationTuple
{

  private int transformationRow;
  
  private List<Integer> elementRowList;

  public List<Integer> getElementRow()
  {
    return elementRowList;
  }

  public void setElementRow(List<Integer> rowList)
  {
    this.elementRowList = rowList;
  }

  public int getTransformationRow()
  {
    return transformationRow;
  }

  public void setTransformationRow(int transformationRow)
  {
    this.transformationRow = transformationRow;
  }
  
}
