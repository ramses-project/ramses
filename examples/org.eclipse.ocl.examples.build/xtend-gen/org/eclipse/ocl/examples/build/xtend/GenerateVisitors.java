/**
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - bug397429
 */
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitorsWorkflowComponent;
import org.eclipse.ocl.examples.build.xtend.MergeWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class GenerateVisitors extends GenerateVisitorsWorkflowComponent {
  protected static EClass firstSuperClass(final EClass eClass, final EClass nullClass) {
    EList<EClass> _eSuperTypes = eClass.getESuperTypes();
    int _size = _eSuperTypes.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return nullClass;
    } else {
      EList<EClass> _eSuperTypes_1 = eClass.getESuperTypes();
      EClass eSuperClass = _eSuperTypes_1.get(0);
      boolean _isInterface = eSuperClass.isInterface();
      if (_isInterface) {
        return GenerateVisitors.firstSuperClass(eSuperClass, nullClass);
      } else {
        return eSuperClass;
      }
    }
  }
  
  @NonNull
  protected static List<EClass> getSortedEClasses(@NonNull final EPackage ePackage) {
    List<EClass> sortedEClasses = new ArrayList<EClass>();
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    for (final EClassifier eClassifier : _eClassifiers) {
      boolean _and = false;
      if (!(eClassifier instanceof EClass)) {
        _and = false;
      } else {
        boolean _isInterface = ((EClass) eClassifier).isInterface();
        boolean _not = (!_isInterface);
        _and = _not;
      }
      if (_and) {
        sortedEClasses.add(((EClass) eClassifier));
      }
    }
    final Comparator<ENamedElement> _function = new Comparator<ENamedElement>() {
      public int compare(final ENamedElement e1, final ENamedElement e2) {
        String _name = e1.getName();
        String _name_1 = e2.getName();
        return _name.compareTo(_name_1);
      }
    };
    Comparator<ENamedElement> comparator = _function;
    Collections.<EClass>sort(sortedEClasses, comparator);
    return sortedEClasses;
  }
  
  @NonNull
  protected static String getTemplatedName(@NonNull final EClass eClass) {
    StringBuilder s = new StringBuilder();
    String _name = eClass.getName();
    s.append(_name);
    List<ETypeParameter> eTypeParameters = eClass.getETypeParameters();
    int _size = eTypeParameters.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      s.append("<");
      int i = 0;
      while ((i < eTypeParameters.size())) {
        {
          if ((i > 0)) {
            s.append(",");
          }
          s.append("?");
          i = (i + 1);
        }
      }
      s.append(">");
    }
    return s.toString();
  }
  
  /**
   * Abstract«projectPrefix»«generic»Visitor
   */
  protected void generateAbstractGenericVisitor(@NonNull final EPackage ePackage, @NonNull final String generic, @NonNull final Class<?> returnClass, @NonNull final Class<?> contextClass) {
    try {
      boolean isDerived = this.isDerived();
      boolean needsOverride = this.needsOverride();
      MergeWriter writer = new MergeWriter(((((this.outputFolder + "Abstract") + this.projectPrefix) + generic) + "Visitor.java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _name = returnClass.getName();
      _builder.append(_name, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.append("import ");
      String _name_1 = contextClass.getName();
      _builder.append(_name_1, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        if (isDerived) {
          _builder.append("import ");
          _builder.append(this.superVisitorPackageName, "");
          _builder.append("ities.");
          _builder.append(this.superProjectPrefix, "");
          _builder.append(generic, "");
          _builder.append("Visitor;");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An Abstract");
      _builder.append(this.projectPrefix, " ");
      _builder.append(generic, " ");
      _builder.append("Visitor provides a default implementation for each");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* visitXxx method that delegates to the visitYyy method of the first");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* super class, (or transitively its first super class\' first super class");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* until a non-interface super-class is found). In the absence of any");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* suitable first super class, the method delegates to visiting().");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class Abstract");
      _builder.append(this.projectPrefix, "");
      _builder.append(generic, "");
      _builder.append("Visitor");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      {
        if (isDerived) {
          _builder.append("extends ");
          _builder.append(this.superProjectPrefix, "\t");
          _builder.append(generic, "\t");
          _builder.append("Visitor");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<");
      String _simpleName = returnClass.getSimpleName();
      _builder.append(_simpleName, "\t");
      _builder.append(">");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Initializes me with an initial value for my result.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param context my initial result value");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected Abstract");
      _builder.append(this.projectPrefix, "\t");
      _builder.append(generic, "\t");
      _builder.append("Visitor(@NonNull ");
      String _simpleName_1 = contextClass.getSimpleName();
      _builder.append(_simpleName_1, "\t");
      _builder.append(" context) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(context);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          EClass firstSuperClass = GenerateVisitors.firstSuperClass(eClass, eClass);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public @Nullable ");
          String _simpleName_2 = returnClass.getSimpleName();
          _builder.append(_simpleName_2, "\t");
          _builder.append(" visit");
          String _name_2 = eClass.getName();
          _builder.append(_name_2, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          {
            boolean _equals = Objects.equal(firstSuperClass, eClass);
            if (_equals) {
              _builder.append("\t\t");
              _builder.append("return visiting(object);");
              _builder.newLine();
            } else {
              _builder.append("\t\t");
              _builder.append("return visit");
              String _name_3 = firstSuperClass.getName();
              _builder.append(_name_3, "\t\t");
              _builder.append("(object);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * AbstractDelegatingVisitor
   */
  protected void generateAbstractDelegatingVisitor(@NonNull final EPackage ePackage) {
    try {
      boolean isDerived = this.isDerived();
      boolean needsOverride = this.needsOverride();
      MergeWriter writer = new MergeWriter((((this.outputFolder + "AbstractDelegating") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractDelegating");
      _builder.append(this.visitorClassName, " ");
      _builder.append(" delegates all visits.");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractDelegating");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R, C, D extends ");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R>>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      {
        if (isDerived) {
          _builder.append(this.superVisitorPackageName, "\t");
          _builder.append(".AbstractDelegating");
          _builder.append(this.superVisitorClassName, "\t");
          _builder.append("<R, C, D>");
        } else {
          {
            if (isDerived) {
              _builder.append(this.superVisitorClassName, "\t");
            } else {
              _builder.append("Abstract");
              _builder.append(this.visitorClassName, "\t");
            }
          }
          _builder.append("<R, C>");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        if (isDerived) {
          _builder.append("\t");
          _builder.append("protected AbstractDelegating");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(delegate, context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("protected final D delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected AbstractDelegating");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tassert delegate != null : \"cannot decorate a null visitor\"; //$NON-NLS-1$");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.delegate = delegate;\t\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tdelegate.setUndecoratedVisitor(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Delegates to my decorated visitor.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tpublic @NonNull Decorable");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("<R> createNestedVisitor() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("//\t\treturn delegate.createNestedVisitor();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\t}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Obtains the visitor that I decorate.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return my decorated visitor");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@SuppressWarnings(\"null\")");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected final @NonNull D getDelegate() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        if (isDerived) {
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("public @Nullable R visiting(@NonNull ");
      _builder.append(this.visitablePackageName, "\t");
      _builder.append(".");
      _builder.append(this.visitableClassName, "\t");
      _builder.append(" visitable) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return delegate.visiting(visitable);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
          String _name = eClass.getName();
          _builder.append(_name, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return delegate.visit");
          String _name_1 = eClass.getName();
          _builder.append(_name_1, "\t\t");
          _builder.append("(object);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * AbstractExtendingDelegatingVisitor
   */
  protected void generateAbstractExtendingDelegatingVisitor(@NonNull final EPackage ePackage) {
    try {
      MergeWriter writer = new MergeWriter((((this.outputFolder + "AbstractExtendingDelegating") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.append("import ");
      _builder.append(this.superVisitorPackageName, "");
      _builder.append(".AbstractDelegating");
      _builder.append(this.superVisitorClassName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(this.superVisitorPackageName, "");
      _builder.append(".");
      _builder.append(this.superVisitorClassName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractExtendingDelegating");
      _builder.append(this.visitorClassName, " ");
      _builder.append(" provides a default implementation for each");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* visitXxx method that delegates to the supertype if the supertype is in the same package as");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* the visited type, otherwise it delegates to the delegate.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractExtendingDelegating");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R, C, D extends ");
      _builder.append(this.superVisitorClassName, "");
      _builder.append("<R>>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends AbstractDelegating");
      _builder.append(this.superVisitorClassName, "\t");
      _builder.append("<R, C, D>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        if (true) {
          _builder.append("\t");
          _builder.append("protected AbstractExtendingDelegating");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(delegate, context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("protected final D delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected AbstractExtendingDelegating");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tassert delegate != null : \"cannot decorate a null visitor\"; //$NON-NLS-1$\t\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.delegate = delegate;\t\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tdelegate.setUndecoratedVisitor(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Delegates to my decorated visitor.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tpublic Decorable");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("<R> createNestedVisitor() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("//\t\treturn delegate.createNestedVisitor();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\t}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Obtains the visitor that I decorate.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return my decorated visitor");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected final D getDelegate() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public @Nullable R visiting(@NonNull ");
      _builder.append(this.visitablePackageName, "\t");
      _builder.append(".");
      _builder.append(this.visitableClassName, "\t");
      _builder.append(" visitable) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return delegate.visiting(visitable);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          EClass firstSuperClass = GenerateVisitors.firstSuperClass(eClass, eClass);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          {
            boolean _needsOverride = this.needsOverride();
            if (_needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
          String _name = eClass.getName();
          _builder.append(_name, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          {
            boolean _equals = Objects.equal(firstSuperClass, eClass);
            if (_equals) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return visiting(object);");
              _builder.newLine();
            } else {
              EPackage _ePackage = firstSuperClass.getEPackage();
              EPackage _ePackage_1 = eClass.getEPackage();
              boolean _equals_1 = Objects.equal(_ePackage, _ePackage_1);
              if (_equals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return visit");
                String _name_1 = firstSuperClass.getName();
                _builder.append(_name_1, "\t\t");
                _builder.append("(object);");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return delegate.visit");
                String _name_2 = firstSuperClass.getName();
                _builder.append(_name_2, "\t\t");
                _builder.append("(object);");
                _builder.newLineIfNotEmpty();
              }
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * AbstractExtendingVisitor
   */
  protected void generateAbstractExtendingVisitor(@NonNull final EPackage ePackage) {
    try {
      boolean isDerived = this.isDerived();
      boolean needsOverride = this.needsOverride();
      MergeWriter writer = new MergeWriter((((this.outputFolder + "AbstractExtending") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractExtending");
      _builder.append(this.visitorClassName, " ");
      _builder.append(" provides a default implementation for each");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* visitXxx method that delegates to the visitYyy method of the first");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* super class, (or transitively its first super class\' first super class");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* until a non-interface super-class is found). In the absence of any");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* suitable first super class, the method delegates to visiting().");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractExtending");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      {
        if (isDerived) {
          _builder.append(this.superVisitorPackageName, "\t");
          _builder.append(".AbstractExtending");
          _builder.append(this.superVisitorClassName, "\t");
        } else {
          _builder.append("Abstract");
          _builder.append(this.visitorClassName, "\t");
        }
      }
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Initializes me with an initial value for my result.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param context my initial result value");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected AbstractExtending");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("(@NonNull C context) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(context);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          EClass firstSuperClass = GenerateVisitors.firstSuperClass(eClass, eClass);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
          String _name = eClass.getName();
          _builder.append(_name, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          {
            boolean _equals = Objects.equal(firstSuperClass, eClass);
            if (_equals) {
              _builder.append("\t\t");
              _builder.append("return visiting(object);");
              _builder.newLine();
            } else {
              _builder.append("\t\t");
              _builder.append("return visit");
              String _name_1 = firstSuperClass.getName();
              _builder.append(_name_1, "\t\t");
              _builder.append("(object);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * AbstractNonNullExtendingVisitor
   */
  protected void generateAbstractNonNullExtendingVisitor(@NonNull final EPackage ePackage) {
    try {
      boolean isDerived = this.isDerived();
      boolean needsOverride = this.needsOverride();
      MergeWriter writer = new MergeWriter((((this.outputFolder + "AbstractNonNullExtending") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractExtendingNonNull");
      _builder.append(this.visitorClassName, " ");
      _builder.append(" provides a default implementation for each");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* visitXxx method that delegates to the visitYyy method of the first");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* super class, (or transitively its first super class first super class");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* until a non-interface super-class is found). In the absence of any");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* suitable first super class, the method delegates to visiting().");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* The return in annotated as @NonNull.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractNonNullExtending");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      {
        if (isDerived) {
          _builder.append(this.superVisitorPackageName, "\t");
          _builder.append(".AbstractNonNullExtending");
          _builder.append(this.superVisitorClassName, "\t");
        } else {
          _builder.append("Abstract");
          _builder.append(this.visitorClassName, "\t");
        }
      }
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Initializes me with an initial value for my result.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param context my initial result value");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected AbstractNonNullExtending");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("(@NonNull C context) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(context);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      {
        if ((!isDerived)) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Perform a visit to the specified visitable.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @param visitable a visitable");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return the non-null result of visiting it");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @NonNull R visit(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("R result = visitable.accept(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (result == null) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("throw new IllegalStateException(\"null return from non-null \" + getClass().getName());");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return result;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          EClass firstSuperClass = GenerateVisitors.firstSuperClass(eClass, eClass);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public @NonNull R visit");
          String _name = eClass.getName();
          _builder.append(_name, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          {
            boolean _equals = Objects.equal(firstSuperClass, eClass);
            if (_equals) {
              _builder.append("\t\t");
              _builder.append("return visiting(object);");
              _builder.newLine();
            } else {
              _builder.append("\t\t");
              _builder.append("return visit");
              String _name_1 = firstSuperClass.getName();
              _builder.append(_name_1, "\t\t");
              _builder.append("(object);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        if ((!isDerived)) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Return the result of visiting a visitable for which no more specific pivot type method");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* is available.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public abstract @NonNull R visiting(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * AbstractNullVisitor
   */
  protected void generateAbstractNullVisitor(@NonNull final EPackage ePackage) {
    try {
      boolean isDerived = this.isDerived();
      boolean needsOverride = this.needsOverride();
      MergeWriter writer = new MergeWriter((((this.outputFolder + "AbstractNull") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractNull");
      _builder.append(this.visitorClassName, " ");
      _builder.append(" provides a default implementation for each");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* visitXxx method that returns null.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractNull");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      {
        if ((!isDerived)) {
          _builder.append("\t");
          _builder.append("extends Abstract");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("<R, C>");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("\t");
          _builder.append("extends ");
          _builder.append(this.superVisitorPackageName, "\t");
          _builder.append(".AbstractNull");
          _builder.append(this.superVisitorClassName, "\t");
          _builder.append("<R, C> implements ");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("<R>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Initializes me with an initial value for my result.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param context my initial result value");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected AbstractNull");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("(@NonNull C context) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(context);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
          String _name = eClass.getName();
          _builder.append(_name, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return null;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * AbstractVisitor
   */
  protected void generateAbstractVisitor(@NonNull final EPackage ePackage) {
    try {
      boolean isDerived = this.isDerived();
      boolean needsOverride = this.needsOverride();
      MergeWriter writer = new MergeWriter((((this.outputFolder + "Abstract") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      {
        if ((!isDerived)) {
          _builder.append("import org.eclipse.jdt.annotation.Nullable;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An Abstract");
      _builder.append(this.visitorClassName, " ");
      _builder.append(" provides a default implementation of the visitor framework");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* but n implementations of the visitXXX methods..");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class Abstract");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      {
        if (isDerived) {
          _builder.append("\t");
          _builder.append("extends ");
          _builder.append(this.superVisitorPackageName, "\t");
          _builder.append(".Abstract");
          _builder.append(this.superVisitorClassName, "\t");
          _builder.append("<R, C>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        if ((!isDerived)) {
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Context for the AST visitation.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected final @NonNull C context;");
          _builder.newLine();
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Initializes me with an initial value for my result.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param context my initial result value");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected Abstract");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("(@NonNull C context) {");
      _builder.newLineIfNotEmpty();
      {
        if ((!isDerived)) {
          _builder.append("\t\t");
          _builder.append("this.context = context;");
          _builder.newLine();
        } else {
          _builder.append("\t\t");
          _builder.append("super(context);");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        if ((!isDerived)) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@SuppressWarnings(\"unchecked\")");
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public <A> A getAdapter(@NonNull Class<A> adapter) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (adapter.isAssignableFrom(getClass())) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return (A) this;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("else {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return null;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* A null-safe visitation of the specified visitable.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @param v a visitable, or <code>null</code>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return <code>null</code> if the visitable is <code>null</code>;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*\t otherwise, the result of visiting it");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R safeVisit(@Nullable ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" v) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return (v == null) ? null : v.accept(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Perform a visit to the specified visitable.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @param v a visitable, or <code>null</code>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return <code>null</code> if the visitable is <code>null</code>;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*\t otherwise, the result of visiting it");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R visit(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" v) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return v.accept(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tpublic @Nullable R visiting(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("//\t\treturn null;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\t}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * AbstractWrappingVisitor
   */
  protected void generateAbstractWrappingVisitor(@NonNull final EPackage ePackage) {
    try {
      boolean isDerived = this.isDerived();
      boolean needsOverride = this.needsOverride();
      MergeWriter writer = new MergeWriter((((this.outputFolder + "AbstractWrapping") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractWrapping");
      _builder.append(this.visitorClassName, " ");
      _builder.append(" delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractWrapping");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R, C, D extends ");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R>, P>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      {
        if (isDerived) {
          _builder.append(this.superVisitorPackageName, "\t");
          _builder.append(".AbstractWrapping");
          _builder.append(this.superVisitorClassName, "\t");
          _builder.append("<R, C, D, P>");
        } else {
          {
            if (isDerived) {
              _builder.append(this.superVisitorClassName, "\t");
            } else {
              _builder.append("Abstract");
              _builder.append(this.visitorClassName, "\t");
            }
          }
          _builder.append("<R, C>");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        if (isDerived) {
          _builder.append("\t");
          _builder.append("protected AbstractWrapping");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(delegate, context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("protected final D delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected AbstractWrapping");
          _builder.append(this.visitorClassName, "\t");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.delegate = delegate;\t\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tdelegate.setUndecoratedVisitor(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Intercept an exception thrown by the delegated visit to perform some post-functionality that may use the visitable object,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* the result of preVisit and the thrown exception to determine the overall wrapped result.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return a rethrown RuntimeException or a RuntimeException-wrapped non-RuntimeException.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected @Nullable R badVisit(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (e instanceof Exception) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("throw (RuntimeException)e;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("else {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("throw new RuntimeException(e);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Obtains the visitor that I wrap.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return my wrapped visitor");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@SuppressWarnings(\"null\")");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected @NonNull D getDelegate() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* the result of preVisit and the result of the delegated visit to determine the overall wrapped result.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return the epilogue result, which defaults to the delegated result.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected @Nullable R postVisit(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable, @Nullable P prologue, @Nullable R result) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return result;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Compute and return some value before performing the delegated visit.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return the prologue result, which defauilts to null.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected @Nullable P preVisit(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return null;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R visiting(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("throw new UnsupportedOperationException();\t\t// Cannot happen since all methods delegate.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.newLine();
          {
            if (needsOverride) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
          String _name = eClass.getName();
          _builder.append(_name, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("P prologue = preVisit(object);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("try {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("R result = delegate.visit");
          String _name_1 = eClass.getName();
          _builder.append(_name_1, "\t\t\t");
          _builder.append("(object);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return postVisit(object, prologue, result);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("catch (Throwable e) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return badVisit(object, prologue, e);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * DecorableVisitorInterface
   */
  protected void generateDecorableVisitorInterface(@NonNull final EPackage ePackage, final String visitorRootClass) {
    try {
      boolean isDerived = this.isDerived();
      MergeWriter writer = new MergeWriter((((this.outputFolder + "Decorable") + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public interface Decorable");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R> extends ");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R>");
      {
        if (isDerived) {
          _builder.append(", ");
          _builder.append(this.superVisitorPackageName, "");
          _builder.append(".Decorable");
          _builder.append(this.superVisitorClassName, "");
          _builder.append("<R>");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void setUndecoratedVisitor(@NonNull ");
      _builder.append(visitorRootClass, "\t");
      _builder.append("<R> visitor);");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String generateHeader(@NonNull final EPackage ePackage, final String javaPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*******************************************************************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    String _copyright = MergeWriter.getCopyright(this.copyright);
    String _replace = _copyright.replace("\n", "\n* ");
    _builder.append(_replace, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This code is auto-generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* from: ");
    _builder.append(this.projectName, " ");
    _builder.append("/");
    _builder.append(this.sourceFile, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Only the copyright statement is editable.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************************/");
    _builder.newLine();
    _builder.append("package\t");
    _builder.append(javaPackage, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected void generateVisitableInterface(@NonNull final EPackage ePackage) {
    try {
      MergeWriter writer = new MergeWriter(((this.outputFolder + this.visitableClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitablePackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EClass;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(this.visitableClassName, "");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Returns the result of accepting a visit from a visitor.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Implementations typically invoke a derived-class-specific");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* variant of visitXXX() to facilitate derived-class-specific");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* processing or just visit() when no such method is available.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* <p>");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Implementations of visit() may use the EcoreSwitch to perform");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* derived-class-specific processing.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* <p>");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Derived implementations of accept() may use getAdapter() to obtain");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* richer visitor interfaces.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param <R>");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param visitor");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @return the result of the visit.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Nullable <R> R accept(@NonNull ");
      _builder.append(this.visitorPackageName, "\t");
      _builder.append(".");
      _builder.append(this.visitorClassName, "\t");
      _builder.append("<R> visitor);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("EClass eClass();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void generateVisitorInterface(@NonNull final EPackage ePackage) {
    try {
      boolean isDerived = this.isDerived();
      MergeWriter writer = new MergeWriter(((this.outputFolder + this.visitorClassName) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(this.visitorClassName, "");
      _builder.append("<R>");
      {
        if (isDerived) {
          _builder.append(" extends ");
          _builder.append(this.superVisitorPackageName, "");
          _builder.append(".");
          _builder.append(this.superVisitorClassName, "");
          _builder.append("<R>");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        if ((!isDerived)) {
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Returns an object which is an instance of the given class");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* associated with this object. Returns <code>null</code> if");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* no such object can be found.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @param adapter the adapter class to look up");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return an object of the given class, ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*    or <code>null</code> if this object does not");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*    have an adapter for the given class");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Nullable <A> A getAdapter(@NonNull Class<A> adapter);");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Return the result of visiting a visitable for which no more specific pivot type method");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* is available.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Nullable R visiting(@NonNull ");
          _builder.append(this.visitablePackageName, "\t");
          _builder.append(".");
          _builder.append(this.visitableClassName, "\t");
          _builder.append(" visitable);");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
        }
      }
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          _builder.append("@Nullable R visit");
          String _name = eClass.getName();
          _builder.append(_name, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _templatedName = GenerateVisitors.getTemplatedName(eClass);
          _builder.append(_templatedName, "\t");
          _builder.append(" object);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
