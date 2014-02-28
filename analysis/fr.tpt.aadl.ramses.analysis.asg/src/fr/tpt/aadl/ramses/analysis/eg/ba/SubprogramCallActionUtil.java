package fr.tpt.aadl.ramses.analysis.eg.ba;

import org.osate.aadl2.DataClassifier ;
import org.osate.ba.aadlba.DataHolder ;
import org.osate.ba.aadlba.IntegerValueVariable ;
import org.osate.ba.aadlba.Literal ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueExpression ;

import fr.tpt.aadl.ramses.analysis.eg.util.ClassifierUtil ;
import fr.tpt.aadl.ramses.analysis.eg.util.DataClassifierUtil ;

public class SubprogramCallActionUtil
{
  private SubprogramCallActionUtil(){}
  
  /*
  public static boolean isValuePassingParameter(ParameterLabel l)
  {
    return ((l instanceof ActualPortHolder)
        || (l instanceof ParameterHolder)
        || (l instanceof DataSubcomponentHolder));
  }
  
  public static boolean isInputFeature(ParameterLabel l)
  {
    if (l instanceof ActualPortHolder)
    {
      DirectionType dt = ((ActualPortHolder) l).getPort().getDirection(); 
      return dt == DirectionType.IN || dt == DirectionType.IN_OUT;
    }
    else if (l instanceof ParameterHolder)
    {
      DirectionType dt = ((ParameterHolder) l).getParameter().getDirection(); 
      return dt == DirectionType.IN || dt == DirectionType.IN_OUT;
    }
    else if (l instanceof ValueExpression)
    {
      return true;
    }
    else
    {
      System.out.println("isInputFeature: " + l.getClass().getSimpleName());
      return false;
    }
  }*/
  
  public static String getParameterValueText(ParameterLabel l)
  {
    if (l instanceof Target)
    {
      return AssignmentActionUtil.getTargetElementName((Target) l);
    }
    else if (l instanceof ValueExpression)
    {
      return "<expression>";
    }
    else
    {
      return "???";
    }
  }
  
  public static int getParameterSizeInOctets (ParameterLabel l)
  {
    long size = 0;
    if (l instanceof Target)
    {
      DataClassifier dc = ClassifierUtil.getDataClassifier((Target) l);
      size = DataClassifierUtil.getOrComputeDataSize(dc);
    }
    else if (l instanceof ValueExpression)
    {
      ValueExpression ve = (ValueExpression) l;
      SimpleExpression se = ve.getRelations().get(0).getFirstExpression();
      Value v = se.getTerms().get(0).getFactors().get(0).getFirstValue();
      if (v instanceof DataHolder)
      {
        DataHolder dh = (DataHolder) v;
        DataClassifier dc = ClassifierUtil.getDataClassifier(dh.getElement());
        size = DataClassifierUtil.getOrComputeDataSize(dc);
      }
      else if ((v instanceof Literal) || (v instanceof IntegerValueVariable))
      {
        //consider "int" type only
        //TODO: consider other types
        size = 2;
      }
    }
    return (int) size;
  }
}
