package fr.tpt.aadl.ramses.control.osate;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode ;

import fr.tpt.aadl.ramses.control.support.Names ;

public class OutlinePropertyTester extends PropertyTester
{
  public static final String CAN_GENERATE_PROPERTY = "canGenerate" ;

  @Override
  public boolean test(Object receiver,
                      String property,
                      Object[] args,
                      Object expectedValue)
  {
    boolean result = false ;
    
    if(CAN_GENERATE_PROPERTY.equals(property))
    {
      EObjectNode selectedNode = (EObjectNode) receiver ; 
      
      String nodeClassName = selectedNode.getEClass().getInstanceClassName() ;
      
      if(Names.GENERATION_ROOT_OBJECT_CLASS.equals(nodeClassName))
      {
        result = true ;
      }
      else
      {
        result = false ;
      }
    }
    else
    {
      result = false ;
    }
    
    return result ;
  }
}