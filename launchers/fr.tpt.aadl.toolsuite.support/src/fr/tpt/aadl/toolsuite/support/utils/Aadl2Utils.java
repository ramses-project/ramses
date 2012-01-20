package fr.tpt.aadl.toolsuite.support.utils;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.List ;

import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.Feature ;

public class Aadl2Utils
{
  public static List<Feature> orderFeatures(ComponentType cpt)
  {
    List<Feature> res = new ArrayList<Feature>() ;
    res.addAll(cpt.getOwnedFeatures()) ;
    FeaturePositionComparator comparator = new FeaturePositionComparator() ;
    Collections.sort(res, comparator) ;
    return res ;
  }
  
  public static class FeaturePositionComparator implements Comparator<Feature>
  {

    @Override
    public int compare(Feature arg0,
                       Feature arg1)
    {
      if(arg0.getLocationReference() != null &&
            arg1.getLocationReference() != null)
      {
        if(arg0.getLocationReference().getLine() < arg1.getLocationReference()
              .getLine())
        {
          return -1 ;
        }

        if(arg0.getLocationReference().getLine() > arg1.getLocationReference()
              .getLine())
        {
          return 1 ;
        }

        return 0 ;
      }

      INode node0 = NodeModelUtils.findActualNodeFor(arg0) ;
      int offset0 = node0.getOffset() ;
      int line0 = node0.getStartLine() ;
      INode node1 = NodeModelUtils.findActualNodeFor(arg1) ;
      int offset1 = node1.getOffset() ;
      int line1 = node1.getStartLine() ;

      if(line0 < line1)
      {
        return -1 ;
      }

      if(line0 == line1)
      {
        if(offset0 < offset1)
        {
          return -1 ;
        }

        if(offset0 > offset1)
        {
          return 1 ;
        }
      }

      if(line0 > line1)
      {
        return 1 ;
      }

      return 0 ;
    }
  }
}
