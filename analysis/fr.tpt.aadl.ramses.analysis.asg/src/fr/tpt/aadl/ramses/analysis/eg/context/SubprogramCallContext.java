package fr.tpt.aadl.ramses.analysis.eg.context;

import java.util.Collections ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ComponentPrototypeActual ;
import org.osate.aadl2.ComponentPrototypeBinding ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataPrototype ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.SubcomponentType ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramType ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.utils.Aadl2Utils ;

public class SubprogramCallContext
{
  private Map<String,String> parameterValues = new HashMap<String,String>();
  private final NamedElement element;
  
  private SubprogramCallContext (NamedElement element)
  {
    this.element = element;
  }
  
  public String getSubprogramName ()
  {
    return element.getName();
  }
  
  public NamedElement getElement()
  {
    return element;
  }
  
  public String toString()
  {
    return this.getClass().getSimpleName() + " " + element.getName();
  }
  
  private void putParameter (String name, long value)
  {
    parameterValues.put(name, value+"");
  }
  
  public String getParameterStringValue (String name)
  {
    return parameterValues.get(name);
  }
  
  public int getParameterIntValue (String name)
  {
    String value = getParameterStringValue(name);
    return (value==null ? 0 : Integer.parseInt(value));
  }
  
  private SubprogramType getSubprogramType()
  {
    if (element instanceof SubprogramType)
    {
      return (SubprogramType) element;
    }
    else if (element instanceof SubprogramImplementation)
    {
      return ((SubprogramImplementation) element).getType();
    }
    else
    {
      return null;
    }
  }
  
  public DataClassifier resolveClassifier (DataSubcomponentType c)
  {
    if (c instanceof DataPrototype)
    {
      return resolvePrototype ((DataPrototype) c);
    }
    else if (c instanceof DataClassifier)
    {
      return ((DataClassifier) c);
    }
    else
    {
      return null;
    }
  }
  
  public DataClassifier resolvePrototype (DataPrototype dp)
  {
    final SubprogramType t = getSubprogramType();
    final List<PrototypeBinding> bindings = t.getOwnedPrototypeBindings();
    
    if (bindings == null)
    {
      return null;
    }
    
    for(PrototypeBinding pb : bindings)
    {
      if (pb instanceof ComponentPrototypeBinding)
      {
        ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) pb;
        if ((cpb.getFormal().getName().equals(dp.getName())) 
              && cpb.getActuals()!=null && !cpb.getActuals().isEmpty())
        {
          ComponentPrototypeActual actual = cpb.getActuals().get(0);
          SubcomponentType s = actual.getSubcomponentType();
          if (s instanceof DataClassifier)
          {
            return (DataClassifier) s;
          }
        }
      }
    }
    
    return null;
  }
  
  
  public static SubprogramCallContext create (SubprogramCallAction action)
  {
    final NamedElement e = action.getSubprogram().getElement();
    final List<Feature> features = orderFeatures (e);
    
    SubprogramCallContext ctxt = new SubprogramCallContext (e);
    int indexParam = 0;
    for(ParameterLabel l : action.getParameterLabels())
    {
      Feature fe = features.get(indexParam);
      
      if (l instanceof ValueExpression)
      {
        ValueExpression ve = (ValueExpression) l;
        Relation r = ve.getRelations().get(0);
        SimpleExpression exp = r.getFirstExpression();
        Term t = exp.getTerms().get(0);
        Factor f = t.getFactors().get(0);
        Value v = f.getFirstValue();
        if (v instanceof BehaviorIntegerLiteral)
        {
          BehaviorIntegerLiteral bil = (BehaviorIntegerLiteral) v;
          ctxt.putParameter (fe.getName(), bil.getValue());
        }
      }
      indexParam++;
    }
    
    return ctxt;
  }
  
  private static List<Feature> orderFeatures (NamedElement e)
  {
    if (e instanceof ComponentType)
    {
      ComponentType t = (ComponentType) e;
      return Aadl2Utils.orderFeatures(t);
    }
    else if (e instanceof ComponentImplementation)
    {
      ComponentImplementation ci = (ComponentImplementation) e;
      return orderFeatures (ci.getType());
    }
    else
    {
      return Collections.emptyList();
    }
  }
  
  public static SubprogramCallContext create (SubprogramCall call)
  {
    final NamedElement e = (SubprogramClassifier) call.getCalledSubprogram();
    SubprogramCallContext ctxt = new SubprogramCallContext (e);
    
    //TODO: create context for subprogram call (in call sequence)
    
    return ctxt;
  }
  
  
}
