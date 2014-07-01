package org.trc.xtext.dsl.post.processor;

import com.google.common.collect.Iterables;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

@SuppressWarnings("all")
public class DslPostProcessor implements IXtext2EcorePostProcessor {
  public static void augment(final GeneratedMetamodel metamodel) {
    DslPostProcessor _dslPostProcessor = new DslPostProcessor();
    _dslPostProcessor.process(metamodel);
  }
  
  public void process(final GeneratedMetamodel metamodel) {
    this.process(metamodel);
  }
  
  public void process(final EPackage p) {
    EList<EClassifier> _eClassifiers = p.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Procedure1<EClass> _function = new Procedure1<EClass>() {
      public void apply(final EClass it) {
        DslPostProcessor.this.addToStringOperation(it);
      }
    };
    IterableExtensions.<EClass>forEach(_filter, _function);
  }
  
  public boolean addToStringOperation(final EClass c) {
    boolean _xblockexpression = false;
    {
      final EOperation op = EcoreFactory.eINSTANCE.createEOperation();
      op.setName("toString");
      EDataType _eString = EcorePackage.eINSTANCE.getEString();
      op.setEType(_eString);
      EList<EOperation> _eOperations = c.getEOperations();
      EOperation _addBodyAnnotation = this.addBodyAnnotation(op, "if (eIsProxy()) return super.toString(); return ToString.valueOf(this);");
      boolean _add = _eOperations.add(_addBodyAnnotation);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  public EOperation addBodyAnnotation(final EOperation op, final String strBody) {
    EOperation _xblockexpression = null;
    {
      final EAnnotation body = EcoreFactory.eINSTANCE.createEAnnotation();
      body.setSource(GenModelPackage.eNS_URI);
      this.createBody(body, strBody);
      EList<EAnnotation> _eAnnotations = op.getEAnnotations();
      _eAnnotations.add(body);
      _xblockexpression = (op);
    }
    return _xblockexpression;
  }
  
  public boolean createBody(final EAnnotation annotation, final String strBody) {
    boolean _xblockexpression = false;
    {
      EClass _eStringToStringMapEntry = EcorePackage.eINSTANCE.getEStringToStringMapEntry();
      EObject _create = EcoreFactory.eINSTANCE.create(_eStringToStringMapEntry);
      final BasicEMap.Entry map = ((BasicEMap.Entry) _create);
      map.setKey("body");
      map.setValue(strBody);
      EMap<String,String> _details = annotation.getDetails();
      boolean _add = _details.add(map);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
}
