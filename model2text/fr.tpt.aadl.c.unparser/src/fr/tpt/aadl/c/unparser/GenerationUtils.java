package fr.tpt.aadl.c.unparser ;

import java.util.ArrayList ;
import java.util.Comparator ;
import java.util.HashSet ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Collections ;
import java.util.Set ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.Enumerator ;
import org.osate.aadl2.CallSpecification ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.ContainedNamedElement ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;

import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;
import fr.tpt.aadl.annex.behavior.names.DataModelProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.DimensionException ;
import fr.tpt.aadl.util.properties.PropertyUtils ;

public class GenerationUtils
{
 
  // public final static String BLACKBOARD_SUFFIX = "_id" ;
  
  public final static String THREAD_SUFFIX = "_Job" ;
  
  // Give file name, in upper case or not and with or without extension.
  public static String generateHeaderInclusionGuard(String fileName)
  {
    fileName = fileName.toUpperCase() ;
    fileName = fileName.replace('.', '_') ;
    
    StringBuilder result = new StringBuilder("#ifndef __GENERATED_") ;
    result.append(fileName);
    result.append("__\n#define __GENERATED_") ;
    result.append(fileName) ;
    result.append("__\n") ;
    
    return result.toString() ;
  }
  
  public static String getGenerationCIdentifier(String id)
  {
    return id.replaceAll("::", "__").replace('.', '_') ;
  }

  private static void setInitialization(StringBuilder initialization,
                                        List<PropertyExpression> initialValues)
  {
    for(PropertyExpression pe : initialValues)
    {
      if(pe instanceof ListValue)
      {
        ListValue lv = (ListValue) pe ;
        List<PropertyExpression> initValueList = lv.getOwnedListElements() ;

        if(initValueList.size() > 0)
        {
          initialization.append(" = ") ;
        }

        if(initValueList.size() > 1)
        {
          initialization.append("{") ;
        }

        Iterator<PropertyExpression> it = initValueList.iterator() ;

        while(it.hasNext())
        {
          PropertyExpression initValue = it.next() ;

          if(initValue instanceof StringLiteral)
          {
            StringLiteral sl = (StringLiteral) initValue ;
            initialization.append(sl.getValue()) ;

            if(it.hasNext())
            {
              initialization.append(",") ;
            }
          }
        }

        if(initValueList.size() > 1)
        {
          initialization.append("}") ;
        }
      }
    }
  }

  public static String getInitialValue(Element e)
  {
    StringBuilder initialization = new StringBuilder() ;

    if(e instanceof Data)
    {
      Data d = (Data) e ;
      TypeHolder dataTypeHolder ;

      try
      {
        if(d instanceof DataSubcomponent)
        {
          DataSubcomponent ds = (DataSubcomponent) d ;

          for(PropertyAssociation pa : ds.getOwnedPropertyAssociations())
          {
            Property p = pa.getProperty() ;

            // Sometime, properties don't have name.
            if(p.getName() != null &&
                  p.getName()
                        .equalsIgnoreCase(DataModelProperties.INITIAL_VALUE))
            {
              setInitialization(initialization, AadlBaGetProperties
                                      .getPropertyExpression(pa)) ;
              return initialization.toString() ;
            }
          }

          return getInitialValue(ds.getClassifier()) ;
        }
        else if(d instanceof DataClassifier)
        {
          DataClassifier dc = (DataClassifier) d ;
          EList<PropertyExpression> initialValueProperty =
                AadlBaGetProperties
                      .getPropertyExpression(dc,
                                             DataModelProperties.INITIAL_VALUE) ;
          setInitialization(initialization, initialValueProperty) ;
          return initialization.toString() ;
        }

        dataTypeHolder = AadlBaUtils.getTypeHolder(d) ;
      }
      catch(DimensionException exp)
      {
        // TODO Auto-generated catch block
        exp.printStackTrace() ;
      }
    }
    else if(e instanceof Port)
    {
    }
    else if(e instanceof Parameter)
    {
    }

    return initialization.toString() ;
  }

  public static Subcomponent getDeloymentProcessorSubcomponentName(ProcessSubcomponent aProcessSubcomponent)
  {
    PropertyAssociation aPropertyAssociation =
          PropertyUtils.findProperty("Actual_Processor_Binding",
                                     aProcessSubcomponent) ;

    for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
          .getOwnedValues())
    {
      if(aModalPropertyValue.getOwnedValue() instanceof ListValue)
      {
        ListValue list = (ListValue) aModalPropertyValue.getOwnedValue() ;

        for(PropertyExpression pe : list.getOwnedListElements())
        {
          if(pe instanceof ReferenceValue)
          {
            ReferenceValue rv = (ReferenceValue) pe ;
            NamedElement anElement =
                  rv.getContainmentPathElements().get(0).getNamedElement() ;

            if(anElement instanceof ProcessorSubcomponent)
            {
              ProcessorSubcomponent ps = (ProcessorSubcomponent) anElement ;
              return ps ;
            }
            else if(anElement instanceof VirtualProcessorSubcomponent)
            {
              VirtualProcessorSubcomponent vps =
                    (VirtualProcessorSubcomponent) anElement ;
              return vps ;
            }
          }
        }
      }
    }

    return null ;
  }

  public static List<ProcessSubcomponent> getBindedProcesses(ProcessorSubcomponent object)
  {
    List<ProcessSubcomponent> bindedProcess =
          new ArrayList<ProcessSubcomponent>() ;
    SystemImplementation si = (SystemImplementation) object.eContainer() ;

    for(ProcessSubcomponent ps : si.getOwnedProcessSubcomponents())
    {
      if(GenerationUtils.getDeloymentProcessorSubcomponentName(ps)
            .equals(object))
      {
        bindedProcess.add(ps) ;
      }
    }

    return bindedProcess ;
  }

  public static Set<String> getListOfReferencedObjects(ProcessImplementation aProcessImplementation)
  {
    Set<String> result = new HashSet<String>() ;

    for(ThreadSubcomponent aTheadSubcomponent : aProcessImplementation
          .getOwnedThreadSubcomponents())
    {
      if(aTheadSubcomponent.getComponentImplementation() != null)
      {
        getListOfReferencedObjects((ThreadImplementation) aTheadSubcomponent
                                         .getComponentImplementation(), result) ;
      }
      else
      {
        /*
         *  TODO: throw exception, the thread component instance should reference a thread implementation
         *  to call user operations
         */
      }
    }

    return result ;
  }

  public static void getListOfReferencedObjects(ThreadImplementation aThreadImplementation,
                                                Set<String> result)
  {
    for(SubprogramCallSequence aCallSequence : aThreadImplementation
          .getOwnedSubprogramCallSequences())
    {
      for(CallSpecification aCallSpecification : aCallSequence
            .getOwnedCallSpecifications())
      {
        getListOfReferencedObjects(aCallSpecification, result) ;
      }
    }
  }

  public static void getListOfReferencedObjects(CallSpecification aCallSpecification,
                                                Set<String> result)
  {
    if(aCallSpecification instanceof SubprogramCall)
    {
      getListOfReferencedObjects((SubprogramCall) aCallSpecification, result) ;
    }
  }

  public static void getListOfReferencedObjects(SubprogramCall aSubprogramCall,
                                                Set<String> result)
  {
    if(aSubprogramCall.getCalledSubprogram() instanceof SubprogramType)
    {
      SubprogramType aSubprogramType =
            (SubprogramType) aSubprogramCall.getCalledSubprogram() ;

      for(PropertyAssociation aPropertyAssociation : aSubprogramType
            .getOwnedPropertyAssociations())
      {
        getListOfReferencedObjects(aPropertyAssociation, result) ;
      }
    }
    else if(aSubprogramCall.getCalledSubprogram() instanceof SubprogramImplementation)
    {
      SubprogramImplementation aSubprogramImplementation =
            (SubprogramImplementation) aSubprogramCall.getCalledSubprogram() ;

      for(PropertyAssociation aPropertyAssociation : aSubprogramImplementation
            .getOwnedPropertyAssociations())
      {
        getListOfReferencedObjects(aPropertyAssociation, result) ;
      }

      for(CallSpecification aCallSpecification : aSubprogramImplementation
            .getCallSpecifications())
      {
        getListOfReferencedObjects(aCallSpecification, result) ;
      }
    }
  }

  public static void getListOfReferencedObjects(PropertyAssociation aPropertyAssociation,
                                                Set<String> result)
  {
    if(aPropertyAssociation.getProperty().getName() != null &&
          aPropertyAssociation.getProperty().getName()
                .equals("Source_Location"))
    {
      for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
            .getOwnedValues())
      {
        result.add(((StringLiteral) aModalPropertyValue.getOwnedValue())
              .getValue()) ;
      }
    }
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

  public static List<Feature> orderFeatures(ComponentType cpt)
  {
    List<Feature> res = new ArrayList<Feature>() ;
    res.addAll(cpt.getOwnedFeatures()) ;
    FeaturePositionComparator comparator = new FeaturePositionComparator() ;
    Collections.sort(res, comparator) ;
    return res ;
  }

  public static String generateSectionTitle(String object)
  {
    checkSectionObject(object) ;
    int maxChar = 80 ;
    char spacer = ' ' ;
    StringBuilder sb = new StringBuilder() ;
    int titleChar = maxChar - object.length() - 8 ;
    int nbStars = titleChar / 2 ;
    boolean symetric = (titleChar % 2) == 0 ;
    sb.append("/* ") ;

    for(int i = 0 ; i < nbStars ; i++)
    {
      sb.append(spacer) ;
    }

    sb.append(' ') ;
    sb.append(object) ;
    sb.append(' ') ;

    if(false == symetric)
    {
      nbStars++ ;
    }

    for(int i = 0 ; i < nbStars ; i++)
    {
      sb.append(spacer) ;
    }

    sb.append(" */\n") ;
    return sb.toString() ;
  }

  public static String generateSectionComment(String comment)
  {
    checkSectionObject(comment) ;
    int maxChar = 80 ;
    char spacer = ' ' ;
    StringBuilder sb = new StringBuilder() ;
    int titleChar = comment.length() + 4 ;
    sb.append("/* ") ;
    sb.append(comment) ;
    sb.append(' ') ;

    for(int i = titleChar ; i < maxChar - 3 ; i++)
    {
      sb.append(spacer) ;
    }

    sb.append(" */") ;
    return sb.toString() ;
  }

  private static void checkSectionObject(String object)
  {
    if(object.length() > 74) // 80 - 6 length of /*_ x 2
    {
      String errorMsg = "title more than 78 characters" ;
      System.err.println(errorMsg) ;
      throw new UnsupportedOperationException(errorMsg) ;
    }
  }

  public static String generateSectionMark()
  {
    return "\n/******************************************************************************/\n" ;
  }
  
/*  public static String generateBlackboardId(String blackboardName)
  {
    return blackboardName + BLACKBOARD_SUFFIX ;
  }
*/
}