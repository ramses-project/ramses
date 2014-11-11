package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.ArrayList ;
import java.util.List ;

import org.osate.aadl2.AbstractNamedValue ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.utils.PropertyUtils ;

public class MCDAUtils
{
  
  public static String QUALITY_ATTRIBUTES_WEIGHT_PS = 
      "Quality_Attributes_Weight";
  
  public static List<String> getReferencedQualityAttributes(SystemInstance si)
  {
    List<String> result = new ArrayList<String>();
    ListValue lv = PropertyUtils.getListValue(si, QUALITY_ATTRIBUTES_WEIGHT_PS);
    for(PropertyExpression pe: lv.getOwnedListElements())
    {
      RecordValue rv = (RecordValue) pe;
      List<BasicPropertyAssociation> bpaList = rv.getOwnedFieldValues();
      for(BasicPropertyAssociation bpa: bpaList)
      {
        PropertyExpression expr = bpa.getValue();
        if(expr instanceof NamedValue)
        {
          NamedValue nv = (NamedValue) expr;
          AbstractNamedValue anv = nv.getNamedValue();
          if (anv instanceof EnumerationLiteral) {
            EnumerationLiteral el = (EnumerationLiteral) anv;
            result.add(el.getName());
          }
        }
      }
    }
    return result;
  }
}
