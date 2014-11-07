/**
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 */
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.build.xtend.GenerateCSVisitors;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitors;
import org.eclipse.ocl.examples.build.xtend.MergeWriter;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class GenerateCS2ASVisitors extends GenerateCSVisitors {
  public void generateVisitors(@NonNull final GenPackage genPackage) {
    super.generateVisitors(genPackage);
    boolean _isDerived = this.isDerived();
    if (_isDerived) {
      this.generateContainmentVisitor(genPackage);
      this.generatePreOrderVisitor(genPackage);
      this.generatePostOrderVisitor(genPackage);
      this.generateLeft2RightVisitor(genPackage);
    }
  }
  
  protected void generateContainmentVisitor(@NonNull final GenPackage genPackage) {
    EPackage csPackage = genPackage.getEcorePackage();
    String visitorVariant = "Containment";
    String resultTypeName = "Continuation<?>";
    String className = ((("Abstract" + this.projectPrefix) + visitorVariant) + "Visitor");
    String extendedClass = ((this.superProjectPrefix + visitorVariant) + "Visitor");
    String interfaceName = (((this.visitorClassName + "<") + resultTypeName) + ">");
    List<Class<?>> additionalImports = new ArrayList<Class<?>>();
    additionalImports.add(Continuation.class);
    this.generateContextfulAbstractExtendingVisitor(csPackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  protected void generatePreOrderVisitor(@NonNull final GenPackage genPackage) {
    EPackage csPackage = genPackage.getEcorePackage();
    String visitorVariant = "PreOrder";
    String resultTypeName = "Continuation<?>";
    String className = ((("Abstract" + this.projectPrefix) + visitorVariant) + "Visitor");
    String extendedClass = ((this.superProjectPrefix + visitorVariant) + "Visitor");
    String interfaceName = (((this.visitorClassName + "<") + resultTypeName) + ">");
    List<Class<?>> additionalImports = new ArrayList<Class<?>>();
    additionalImports.add(Continuation.class);
    this.generateContextfulAbstractExtendingVisitor(csPackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  protected void generatePostOrderVisitor(@NonNull final GenPackage genPackage) {
    EPackage csPackage = genPackage.getEcorePackage();
    String visitorVariant = "PostOrder";
    String resultTypeName = "Continuation<?>";
    String className = ((("Abstract" + this.projectPrefix) + visitorVariant) + "Visitor");
    String extendedClass = ((this.superProjectPrefix + visitorVariant) + "Visitor");
    String interfaceName = (((this.visitorClassName + "<") + resultTypeName) + ">");
    List<Class<?>> additionalImports = new ArrayList<Class<?>>();
    additionalImports.add(Continuation.class);
    this.generateContextfulAbstractExtendingVisitor(csPackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  protected void generateLeft2RightVisitor(@NonNull final GenPackage genPackage) {
    EPackage csPackage = genPackage.getEcorePackage();
    String visitorVariant = "Left2Right";
    String resultTypeName = "Element";
    String className = ((("Abstract" + this.projectPrefix) + visitorVariant) + "Visitor");
    String extendedClass = ((this.superProjectPrefix + visitorVariant) + "Visitor");
    String interfaceName = (((this.visitorClassName + "<") + resultTypeName) + ">");
    List<Class<?>> additionalImports = new ArrayList<Class<?>>();
    additionalImports.add(Element.class);
    this.generateContextfulAbstractExtendingVisitor(csPackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  /**
   * Assumptions to be considered:
   * - the package of the extended visitor of generated visitors need to be qualified as follows:
   *    <code> «superProjectName».cs2as </code>
   */
  protected void generateContextfulAbstractExtendingVisitor(@NonNull final EPackage ePackage, @NonNull final String className, @NonNull final String extendedClassName, @NonNull final String interfaceName, @NonNull final String resultTypeName, @NonNull final List<Class<?>> additionalImports) {
    try {
      MergeWriter writer = new MergeWriter(((this.outputFolder + className) + ".java"));
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;");
      _builder.newLine();
      _builder.append("import ");
      _builder.append(this.superProjectName, "");
      _builder.append(".cs2as.");
      _builder.append(extendedClassName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        for(final Class<?> addtionalImport : additionalImports) {
          _builder.append("import ");
          String _name = addtionalImport.getName();
          _builder.append(_name, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An ");
      _builder.append(className, " ");
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
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class ");
      _builder.append(className, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      _builder.append(extendedClassName, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(interfaceName, "\t");
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
      _builder.append("protected ");
      _builder.append(className, "\t");
      _builder.append("(@NonNull CS2PivotConversion context) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(context);");
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
          _builder.append("\t");
          _builder.append("public @Nullable ");
          _builder.append(resultTypeName, "\t");
          _builder.append(" visit");
          String _name_1 = eClass.getName();
          _builder.append(_name_1, "\t");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "\t");
          _builder.append(".");
          String _name_2 = eClass.getName();
          _builder.append(_name_2, "\t");
          _builder.append(" csElement) {");
          _builder.newLineIfNotEmpty();
          {
            boolean _equals = Objects.equal(firstSuperClass, eClass);
            if (_equals) {
              _builder.append("\t\t");
              _builder.append("return visiting(csElement);");
              _builder.newLine();
            } else {
              _builder.append("\t\t");
              _builder.append("return visit");
              String _name_3 = firstSuperClass.getName();
              _builder.append(_name_3, "\t\t");
              _builder.append("(csElement);");
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
}
