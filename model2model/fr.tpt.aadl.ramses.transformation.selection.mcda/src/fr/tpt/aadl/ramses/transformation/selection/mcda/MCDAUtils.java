package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.AbstractNamedValue ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.utils.PropertyUtils ;

public class MCDAUtils
{
  public static final String QUALITY_ATTRIBUTES_WEIGHT_PS = 
                                                    "Quality_Attributes_Weight";

  public static final String ACCEPTABLE_QUALITY_IMPACT_PS = 
                                                   "Quality_Impact_Importance";

  private static NamedElement resultingElement;
  
  public static NamedElement getResultingElement()
  {
    return resultingElement;
  }
  
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

  public static NamedElement getContainingNamedElement(EObject obj)
  {
    while(obj != null)
    {
      if(obj instanceof NamedElement)
      {
        return (NamedElement) obj ;
      }
      
      obj = obj.eContainer() ;
    }
    
    return null ;
  }
  
  public synchronized static PropertyExpression getContainingPropertyExpression(String propertyName,
                                                                   NamedElement ne)
  {
    PropertyExpression pe = 
        PropertyUtils.getPropertyValue(MCDAUtils.ACCEPTABLE_QUALITY_IMPACT_PS,
                                       ne);
    if(pe!=null)
    {
      resultingElement = ne;
      return pe;
    }
    resultingElement = getContainingNamedElement(ne.eContainer());
    if(pe==null && resultingElement!=null)
      return getContainingPropertyExpression(propertyName, resultingElement);
    return null;
  }
  
  public synchronized static List<RecordValue> getAcceptableQualityImpacts(EObject currentElement)
  {
    resultingElement=null;
    List<RecordValue> result = new ArrayList<RecordValue>();
    boolean isNamedElement = currentElement instanceof NamedElement; 
    if(isNamedElement==false)
    {
      currentElement = MCDAUtils.getContainingNamedElement(currentElement) ;
      if(currentElement == null)
      {
        return result ;
      }
    }
    PropertyExpression pe = 
        MCDAUtils.getContainingPropertyExpression(
                                                  MCDAUtils.ACCEPTABLE_QUALITY_IMPACT_PS,
                                                  (NamedElement)currentElement);
    if(pe==null)
      return result;

    ListValue lv = (ListValue) pe;
    for(PropertyExpression rv : lv.getOwnedListElements())
    {
      result.add((RecordValue)rv);
    }
    return result;
  }
  
  
}
