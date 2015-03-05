/**
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 */
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.build.xtend.GenerateOCLMetaModel;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class GenerateOCLMetaModelXtend extends GenerateOCLMetaModel {
  protected String declareEnumerations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Enumeration> allEnumerations = this.getSortedEnumerations(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Enumeration enumeration : allEnumerations) {
          String _partialName = this.partialName(enumeration);
          String _plus = ("_" + _partialName);
          String enumerationName = this.getPrefixedSymbolName(enumeration, _plus);
          _builder.newLineIfNotEmpty();
          _builder.append("protected final @NonNull Enumeration ");
          _builder.append(enumerationName, "");
          _builder.append(" = createEnumeration(");
          String _ecoreLiteral = this.getEcoreLiteral(enumeration);
          _builder.append(_ecoreLiteral, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            List<EnumerationLiteral> _ownedLiteral = enumeration.getOwnedLiteral();
            for(final EnumerationLiteral enumerationLiteral : _ownedLiteral) {
              _builder.append("protected final @NonNull EnumerationLiteral ");
              String _name = enumerationLiteral.getName();
              String _plus_1 = ((("el_" + enumerationName) + "_") + _name);
              String _prefixedSymbolName = this.getPrefixedSymbolName(enumerationLiteral, _plus_1);
              _builder.append(_prefixedSymbolName, "");
              _builder.append(" = createEnumerationLiteral(");
              String _ecoreLiteral_1 = this.getEcoreLiteral(enumerationLiteral);
              _builder.append(_ecoreLiteral_1, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String declareOclTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      List<Type> allOclTypes = this.getSortedOclTypes(pkg);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Type type : allOclTypes) {
          _builder.append("protected final @NonNull ");
          EClass _eClass = type.eClass();
          String _name = _eClass.getName();
          _builder.append(_name, "");
          _builder.append(" ");
          String _partialName = this.partialName(type);
          String _plus = ("_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = create");
          EClass _eClass_1 = type.eClass();
          String _name_1 = _eClass_1.getName();
          _builder.append(_name_1, "");
          _builder.append("(");
          String _ecoreLiteral = this.getEcoreLiteral(type);
          _builder.append(_ecoreLiteral, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String declareProperties(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Property> allProperties = this.getAllProperties(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        List<Type> _sortedOwningTypes2 = this.getSortedOwningTypes2(allProperties);
        for(final Type type : _sortedOwningTypes2) {
          {
            List<Property> _sortedProperties = this.getSortedProperties(type, allProperties);
            for(final Property property : _sortedProperties) {
              _builder.append("protected final @NonNull Property ");
              String _partialName = this.partialName(property);
              String _plus = ("pr_" + _partialName);
              String _prefixedSymbolName = this.getPrefixedSymbolName(property, _plus);
              _builder.append(_prefixedSymbolName, "");
              _builder.append(" = createProperty(");
              String _ecorePropertyLiteral = this.getEcorePropertyLiteral(property);
              _builder.append(_ecorePropertyLiteral, "");
              _builder.append(", ");
              Type _type = property.getType();
              String _symbolName = this.getSymbolName(_type);
              _builder.append(_symbolName, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineCollectionTypeName(final Set<Type> allTypes, final String typeName) {
    String _xblockexpression = null;
    {
      CollectionType collectionType = this.findCollectionType(allTypes, typeName);
      String collectionName = this.getPrefixedSymbolName(collectionType, ("_" + typeName));
      TemplateSignature _ownedTemplateSignature = collectionType.getOwnedTemplateSignature();
      String signatureName = this.getPrefixedSymbolName(_ownedTemplateSignature, (("_" + typeName) + "_"));
      TemplateSignature _ownedTemplateSignature_1 = collectionType.getOwnedTemplateSignature();
      List<TemplateParameter> _ownedParameter = _ownedTemplateSignature_1.getOwnedParameter();
      TemplateParameter _get = _ownedParameter.get(0);
      String parameterName = this.getPrefixedSymbolName(_get, (("_" + typeName) + "_T"));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected final @NonNull CollectionType ");
      _builder.append(collectionName, "");
      _builder.append(" = standardLibrary.get");
      _builder.append(typeName, "");
      _builder.append("Type();");
      _builder.newLineIfNotEmpty();
      _builder.append("@SuppressWarnings(\"null\") protected final @NonNull TemplateSignature ");
      _builder.append(signatureName, "");
      _builder.append(" = ");
      _builder.append(collectionName, "");
      _builder.append(".getOwnedTemplateSignature();");
      _builder.newLineIfNotEmpty();
      _builder.append("@SuppressWarnings(\"null\") protected final @NonNull TemplateParameter ");
      _builder.append(parameterName, "");
      _builder.append(" = ");
      _builder.append(signatureName, "");
      _builder.append(".getOwnedParameter().get(0);");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String definePrimitiveTypeName(final Set<Type> allTypes, final String typeName) {
    String _xblockexpression = null;
    {
      DataType primitiveType = this.findPrimitiveType(allTypes, typeName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected final @NonNull PrimitiveType ");
      String _prefixedSymbolName = this.getPrefixedSymbolName(primitiveType, ("_" + typeName));
      _builder.append(_prefixedSymbolName, "");
      _builder.append(" = standardLibrary.get");
      _builder.append(typeName, "");
      _builder.append("Type();");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String generateMetamodel(final Root root) {
    String _xblockexpression = null;
    {
      List<org.eclipse.ocl.examples.pivot.Package> _nestedPackage = root.getNestedPackage();
      org.eclipse.ocl.examples.pivot.Package pkg = this.findPackage(_nestedPackage);
      boolean _equals = Objects.equal(pkg, null);
      if (_equals) {
        return null;
      }
      Set<Metaclass<?>> allMetaclasses = this.getAllMetaclasses(root);
      Set<CollectionType> allCollectionTypes = this.getAllCollectionTypes(root);
      Set<Enumeration> allEnumerations = this.getAllEnumerations(root);
      Set<LambdaType> allLambdaTypes = this.getAllLambdaTypes(root);
      Set<Precedence> allPrecedences = this.getAllPrecedences(root);
      Set<PrimitiveType> allPrimitiveTypes = this.getAllPrimitiveTypes(root);
      Set<TemplateBinding> allTemplateBindings = this.getAllTemplateBindings(root);
      Set<TemplateSignature> allTemplateSignatures = this.getAllTemplateSignatures(root);
      Set<TupleType> allTupleTypes = this.getAllTupleTypes(root);
      Set<Type> allTypes = this.getAllTypes(root);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/*******************************************************************************");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Copyright (c) 2010,2014 E.D.Willink and others.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* All rights reserved. This program and the accompanying materials");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* are made available under the terms of the Eclipse Public License v1.0");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* which accompanies this distribution, and is available at");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* http://www.eclipse.org/legal/epl-v10.html");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Contributors:");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*     E.D.Willink - initial API and implementation");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*******************************************************************************");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* This code is 100% auto-generated");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* from: ");
      _builder.append(this.sourceFile, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* by: org.eclipse.ocl.examples.build.xtend.GenerateOCLMetaModel.xtend");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* and: org.eclipse.ocl.examples.build.GeneratePivotMetaModel.mwe2");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Do not edit it.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*******************************************************************************/");
      _builder.newLine();
      _builder.append("package\t");
      _builder.append(this.javaPackageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.math.BigInteger;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.emf.common.util.URI;");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.domain.ids.IdManager;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.domain.library.LibraryFeature;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.domain.utilities.DomainUtil;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.*;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.Class;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.Package;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.manager.PivotStandardLibrary;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.model.OCLstdlib;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.resource.ASResourceImpl;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* This is the ");
      _builder.append(this.uri, " ");
      _builder.append(" Pivot Model of the Pivot Model");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* auto-generated from ");
      _builder.append(this.sourceFile, " ");
      _builder.append(".");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* It facilitates efficient model loading without the overheads of model reading.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("@SuppressWarnings({\"nls\", \"unused\"})");
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(this.javaClassName, "");
      _builder.append(" extends ASResourceImpl");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*\tThe URI of this Standard Library.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static final @NonNull String PIVOT_URI = \"");
      _builder.append(this.uri, "\t");
      _builder.append("\";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static @NonNull Package create(@NonNull PivotStandardLibrary standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(this.javaClassName, "\t\t");
      _builder.append(" resource = new ");
      _builder.append(this.javaClassName, "\t\t");
      _builder.append("(DomainUtil.nonNullEMF(URI.createURI(PIVOT_URI)));");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("Contents contents = new Contents(standardLibrary, name, nsPrefix, nsURI);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("resource.getContents().add(contents.root);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return contents.metamodel;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected OCLMetaModel(@NonNull URI uri) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(uri, OCLASResourceFactory.INSTANCE);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected static class LibraryContents extends AbstractContents");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected final @NonNull PivotStandardLibrary standardLibrary;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected LibraryContents(@NonNull PivotStandardLibrary standardLibrary) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("this.standardLibrary = standardLibrary;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected static class Contents extends LibraryContents");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected final @NonNull Root ");
      String _prefixedSymbolName = this.getPrefixedSymbolName(root, "root");
      _builder.append(_prefixedSymbolName, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("protected final @NonNull Package ");
      String _prefixedSymbolName_1 = this.getPrefixedSymbolName(pkg, "metamodel");
      _builder.append(_prefixedSymbolName_1, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _defineCollectionTypeName = this.defineCollectionTypeName(allTypes, "Bag");
      _builder.append(_defineCollectionTypeName, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _definePrimitiveTypeName = this.definePrimitiveTypeName(allTypes, "Boolean");
      _builder.append(_definePrimitiveTypeName, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _defineCollectionTypeName_1 = this.defineCollectionTypeName(allTypes, "Collection");
      _builder.append(_defineCollectionTypeName_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _definePrimitiveTypeName_1 = this.definePrimitiveTypeName(allTypes, "Integer");
      _builder.append(_definePrimitiveTypeName_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected final @NonNull Class _OclAny = standardLibrary.getOclAnyType();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected final @NonNull Class _OclElement = standardLibrary.getOclElementType();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _defineCollectionTypeName_2 = this.defineCollectionTypeName(allTypes, "OrderedCollection");
      _builder.append(_defineCollectionTypeName_2, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _defineCollectionTypeName_3 = this.defineCollectionTypeName(allTypes, "OrderedSet");
      _builder.append(_defineCollectionTypeName_3, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _definePrimitiveTypeName_2 = this.definePrimitiveTypeName(allTypes, "Real");
      _builder.append(_definePrimitiveTypeName_2, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _defineCollectionTypeName_4 = this.defineCollectionTypeName(allTypes, "Sequence");
      _builder.append(_defineCollectionTypeName_4, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _defineCollectionTypeName_5 = this.defineCollectionTypeName(allTypes, "Set");
      _builder.append(_defineCollectionTypeName_5, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _definePrimitiveTypeName_3 = this.definePrimitiveTypeName(allTypes, "String");
      _builder.append(_definePrimitiveTypeName_3, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _definePrimitiveTypeName_4 = this.definePrimitiveTypeName(allTypes, "UnlimitedNatural");
      _builder.append(_definePrimitiveTypeName_4, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _defineCollectionTypeName_6 = this.defineCollectionTypeName(allTypes, "UniqueCollection");
      _builder.append(_defineCollectionTypeName_6, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected Contents(@NonNull PivotStandardLibrary standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("super(standardLibrary);");
      _builder.newLine();
      _builder.append("\t\t\t");
      String _symbolName = this.getSymbolName(root);
      _builder.append(_symbolName, "\t\t\t");
      _builder.append(" = createRoot(\"");
      String _nsURI = pkg.getNsURI();
      _builder.append(_nsURI, "\t\t\t");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      String _symbolName_1 = this.getSymbolName(pkg);
      _builder.append(_symbolName_1, "\t\t\t");
      _builder.append(" = createPackage(name, nsPrefix, nsURI, IdManager.METAMODEL);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("installPackages();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("installOclTypes();");
      _builder.newLine();
      {
        int _size = allPrimitiveTypes.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _builder.append("\t\t\t");
          _builder.append("installPrimitiveTypes();");
          _builder.newLine();
        }
      }
      {
        int _size_1 = allEnumerations.size();
        boolean _greaterThan_1 = (_size_1 > 0);
        if (_greaterThan_1) {
          _builder.append("\t\t\t");
          _builder.append("installEnumerations();");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("installParameterTypes();");
      _builder.newLine();
      {
        int _size_2 = allCollectionTypes.size();
        boolean _greaterThan_2 = (_size_2 > 0);
        if (_greaterThan_2) {
          _builder.append("\t\t\t");
          _builder.append("installCollectionTypes();");
          _builder.newLine();
        }
      }
      {
        int _size_3 = allMetaclasses.size();
        boolean _greaterThan_3 = (_size_3 > 0);
        if (_greaterThan_3) {
          _builder.append("\t\t\t");
          _builder.append("installMetaclasses();");
          _builder.newLine();
        }
      }
      {
        int _size_4 = allLambdaTypes.size();
        boolean _greaterThan_4 = (_size_4 > 0);
        if (_greaterThan_4) {
          _builder.append("\t\t\t");
          _builder.append("installLambdaTypes();");
          _builder.newLine();
        }
      }
      {
        int _size_5 = allTupleTypes.size();
        boolean _greaterThan_5 = (_size_5 > 0);
        if (_greaterThan_5) {
          _builder.append("\t\t\t");
          _builder.append("installTupleTypes();");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("installOperations();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("installIterations();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("installProperties();");
      _builder.newLine();
      {
        int _size_6 = allTemplateSignatures.size();
        boolean _greaterThan_6 = (_size_6 > 0);
        if (_greaterThan_6) {
          _builder.append("\t\t\t");
          _builder.append("installTemplateSignatures();");
          _builder.newLine();
        }
      }
      {
        int _size_7 = allTemplateBindings.size();
        boolean _greaterThan_7 = (_size_7 > 0);
        if (_greaterThan_7) {
          _builder.append("\t\t\t");
          _builder.append("installTemplateBindings();");
          _builder.newLine();
        }
      }
      {
        int _size_8 = allPrecedences.size();
        boolean _greaterThan_8 = (_size_8 > 0);
        if (_greaterThan_8) {
          _builder.append("\t\t\t");
          _builder.append("installPrecedences();");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("installComments();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _definePackages = this.definePackages(pkg);
      _builder.append(_definePackages, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      String _declareOclTypes = this.declareOclTypes(pkg);
      _builder.append(_declareOclTypes, "\t\t");
      _builder.newLineIfNotEmpty();
      {
        int _size_9 = allPrimitiveTypes.size();
        boolean _greaterThan_9 = (_size_9 > 0);
        if (_greaterThan_9) {
          _builder.newLine();
          _builder.append("\t\t");
          String _declarePrimitiveTypes = this.declarePrimitiveTypes(pkg);
          _builder.append(_declarePrimitiveTypes, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_10 = allEnumerations.size();
        boolean _greaterThan_10 = (_size_10 > 0);
        if (_greaterThan_10) {
          _builder.newLine();
          _builder.append("\t\t");
          String _declareEnumerations = this.declareEnumerations(pkg);
          _builder.append(_declareEnumerations, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      String _declareParameterTypes = this.declareParameterTypes(pkg);
      _builder.append(_declareParameterTypes, "\t\t");
      _builder.newLineIfNotEmpty();
      {
        int _size_11 = allCollectionTypes.size();
        boolean _greaterThan_11 = (_size_11 > 0);
        if (_greaterThan_11) {
          _builder.newLine();
          _builder.append("\t\t");
          String _declareCollectionTypes = this.declareCollectionTypes(pkg);
          _builder.append(_declareCollectionTypes, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_12 = allMetaclasses.size();
        boolean _greaterThan_12 = (_size_12 > 0);
        if (_greaterThan_12) {
          _builder.newLine();
          _builder.append("\t\t");
          String _declareMetaclasses = this.declareMetaclasses(pkg);
          _builder.append(_declareMetaclasses, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_13 = allTupleTypes.size();
        boolean _greaterThan_13 = (_size_13 > 0);
        if (_greaterThan_13) {
          _builder.newLine();
          _builder.append("\t\t");
          String _declareTupleTypes = this.declareTupleTypes(pkg);
          _builder.append(_declareTupleTypes, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      String _defineOclTypes = this.defineOclTypes(pkg);
      _builder.append(_defineOclTypes, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      String _definePrimitiveTypes = this.definePrimitiveTypes(pkg);
      _builder.append(_definePrimitiveTypes, "\t\t");
      _builder.newLineIfNotEmpty();
      {
        int _size_14 = allEnumerations.size();
        boolean _greaterThan_14 = (_size_14 > 0);
        if (_greaterThan_14) {
          _builder.newLine();
          _builder.append("\t\t");
          String _defineEnumerations = this.defineEnumerations(pkg);
          _builder.append(_defineEnumerations, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      String _defineParameterTypes = this.defineParameterTypes(pkg);
      _builder.append(_defineParameterTypes, "\t\t");
      _builder.newLineIfNotEmpty();
      {
        int _size_15 = allCollectionTypes.size();
        boolean _greaterThan_15 = (_size_15 > 0);
        if (_greaterThan_15) {
          _builder.newLine();
          _builder.append("\t\t");
          String _defineCollectionTypes = this.defineCollectionTypes(pkg);
          _builder.append(_defineCollectionTypes, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_16 = allMetaclasses.size();
        boolean _greaterThan_16 = (_size_16 > 0);
        if (_greaterThan_16) {
          _builder.newLine();
          _builder.append("\t\t");
          String _defineMetaclasses = this.defineMetaclasses(pkg);
          _builder.append(_defineMetaclasses, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_17 = allTupleTypes.size();
        boolean _greaterThan_17 = (_size_17 > 0);
        if (_greaterThan_17) {
          _builder.newLine();
          _builder.append("\t\t");
          String _defineTupleTypes = this.defineTupleTypes(pkg);
          _builder.append(_defineTupleTypes, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_18 = allLambdaTypes.size();
        boolean _greaterThan_18 = (_size_18 > 0);
        if (_greaterThan_18) {
          _builder.newLine();
          _builder.append("\t\t");
          String _defineLambdaTypes = this.defineLambdaTypes(pkg);
          _builder.append(_defineLambdaTypes, "\t\t");
          _builder.append("\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      String _defineOperations = this.defineOperations(pkg);
      _builder.append(_defineOperations, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      String _defineIterations = this.defineIterations(pkg);
      _builder.append(_defineIterations, "\t\t");
      _builder.append("\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      String _declareProperties = this.declareProperties(pkg);
      _builder.append(_declareProperties, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      String _defineProperties = this.defineProperties(pkg);
      _builder.append(_defineProperties, "\t\t");
      _builder.newLineIfNotEmpty();
      {
        int _size_19 = allTemplateSignatures.size();
        boolean _greaterThan_19 = (_size_19 > 0);
        if (_greaterThan_19) {
          _builder.newLine();
          _builder.append("\t\t");
          String _defineTemplateSignatures = this.defineTemplateSignatures(pkg);
          _builder.append(_defineTemplateSignatures, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_20 = allTemplateBindings.size();
        boolean _greaterThan_20 = (_size_20 > 0);
        if (_greaterThan_20) {
          _builder.newLine();
          _builder.append("\t\t");
          String _defineTemplateBindings = this.defineTemplateBindings(pkg);
          _builder.append(_defineTemplateBindings, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _size_21 = allPrecedences.size();
        boolean _greaterThan_21 = (_size_21 > 0);
        if (_greaterThan_21) {
          _builder.newLine();
          _builder.append("\t\t");
          String _definePrecedences = this.definePrecedences(pkg);
          _builder.append(_definePrecedences, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      String _defineComments = this.defineComments(pkg);
      _builder.append(_defineComments, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
