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
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.build.xtend.GenerateOCLCommon;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public abstract class GenerateOCLCommonXtend extends GenerateOCLCommon {
  protected String declareCollectionTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<CollectionType> _sortedCollectionTypes = this.getSortedCollectionTypes(_rootPackage);
      for(final CollectionType type : _sortedCollectionTypes) {
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
        _builder.append("(\"");
        String _name_2 = type.getName();
        _builder.append(_name_2, "");
        _builder.append("\"/*");
        Type _elementType = type.getElementType();
        String _name_3 = _elementType.getName();
        _builder.append(_name_3, "");
        _builder.append("*/, \"");
        Number _lower = type.getLower();
        String _string = _lower.toString();
        _builder.append(_string, "");
        _builder.append("\", \"");
        Number _upper = type.getUpper();
        String _string_1 = _upper.toString();
        _builder.append(_string_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareEnumerations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Enumeration> _sortedEnumerations = this.getSortedEnumerations(_rootPackage);
      for(final Enumeration enumeration : _sortedEnumerations) {
        String _partialName = this.partialName(enumeration);
        String _plus = ("_" + _partialName);
        String enumerationName = this.getPrefixedSymbolName(enumeration, _plus);
        _builder.newLineIfNotEmpty();
        _builder.append("protected final @NonNull Enumeration ");
        _builder.append(enumerationName, "");
        _builder.append(" = createEnumeration(\"");
        String _name = enumeration.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          List<EnumerationLiteral> _ownedLiteral = enumeration.getOwnedLiteral();
          for(final EnumerationLiteral enumerationLiteral : _ownedLiteral) {
            _builder.append("protected final @NonNull EnumerationLiteral ");
            String _name_1 = enumerationLiteral.getName();
            String _plus_1 = ((("el_" + enumerationName) + "_") + _name_1);
            String _prefixedSymbolName = this.getPrefixedSymbolName(enumerationLiteral, _plus_1);
            _builder.append(_prefixedSymbolName, "");
            _builder.append(" = createEnumerationLiteral(\"");
            String _name_2 = enumerationLiteral.getName();
            _builder.append(_name_2, "");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  protected String declareMetaclasses(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Metaclass<?>> _sortedMetaclasses = this.getSortedMetaclasses(_rootPackage);
      for(final Metaclass<?> type : _sortedMetaclasses) {
        _builder.append("protected final @NonNull Metaclass<?> ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createMetaclass(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareOclTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Type> _sortedOclTypes = this.getSortedOclTypes(pkg);
      for(final Type type : _sortedOclTypes) {
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
        _builder.append("(\"");
        String _name_2 = type.getName();
        _builder.append(_name_2, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareParameterTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Type> _sortedParameterTypes = this.getSortedParameterTypes(_rootPackage);
      for(final Type type : _sortedParameterTypes) {
        _builder.append("protected final @NonNull Class ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createClass(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declarePrimitiveTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<PrimitiveType> _sortedPrimitiveTypes = this.getSortedPrimitiveTypes(_rootPackage);
      for(final PrimitiveType type : _sortedPrimitiveTypes) {
        _builder.append("protected final @NonNull PrimitiveType ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createPrimitiveType(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareProperties(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Property> allProperties = this.getAllProperties(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Property property : allProperties) {
          _builder.append("protected final @NonNull Property ");
          String _partialName = this.partialName(property);
          String _plus = ("pr_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(property, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createProperty(\"");
          String _name = property.getName();
          _builder.append(_name, "");
          _builder.append("\", ");
          Type _type = property.getType();
          String _symbolName = this.getSymbolName(_type);
          _builder.append(_symbolName, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String declareTupleTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TupleType> _sortedTupleTypes = this.getSortedTupleTypes(_rootPackage);
      for(final TupleType type : _sortedTupleTypes) {
        _builder.append("protected final @NonNull TupleType ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createTupleType(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        {
          List<Property> _sortedTupleParts = this.getSortedTupleParts(type);
          boolean _hasElements = false;
          for(final Property property : _sortedTupleParts) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("\t", "");
            } else {
              _builder.appendImmediate(",\n\t", "");
            }
            _builder.append("createProperty(\"");
            String _name_1 = property.getName();
            _builder.append(_name_1, "");
            _builder.append("\", ");
            Type _type = property.getType();
            String _symbolName = this.getSymbolName(_type);
            _builder.append(_symbolName, "");
            _builder.append(")");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String defineCollectionTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installCollectionTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "\t");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equal(orphanPackage, null));
        if (_notEquals) {
          _builder.append("\t");
          _builder.append("final List<Type> orphanTypes = ");
          String _symbolName_1 = this.getSymbolName(orphanPackage);
          _builder.append(_symbolName_1, "\t");
          _builder.append(".getOwnedType();");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("CollectionType type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        Root _rootPackage = this.getRootPackage(pkg);
        List<CollectionType> _sortedCollectionTypes = this.getSortedCollectionTypes(_rootPackage);
        for(final CollectionType type : _sortedCollectionTypes) {
          {
            TemplateableElement _unspecializedElement = type.getUnspecializedElement();
            boolean _equals = Objects.equal(_unspecializedElement, null);
            if (_equals) {
              _builder.append("\t");
              _builder.append("ownedTypes.add(type = ");
              String _symbolName_2 = this.getSymbolName(type);
              _builder.append(_symbolName_2, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("orphanTypes.add(type = ");
              String _symbolName_3 = this.getSymbolName(type);
              _builder.append(_symbolName_3, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("type.setUnspecializedElement(");
              TemplateableElement _unspecializedElement_1 = type.getUnspecializedElement();
              String _symbolName_4 = this.getSymbolName(_unspecializedElement_1);
              _builder.append(_symbolName_4, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("type.setElementType(");
          Type _elementType = type.getElementType();
          String _symbolName_5 = this.getSymbolName(_elementType);
          _builder.append(_symbolName_5, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type);
          _builder.append(_emitSuperClasses, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineComments(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void installComments() {");
    _builder.newLine();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Element> _sortedCommentedElements = this.getSortedCommentedElements(_rootPackage);
      for(final Element pElement : _sortedCommentedElements) {
        {
          List<Comment> _sortedComments = this.getSortedComments(pElement);
          for(final Comment pComment : _sortedComments) {
            _builder.append("\t");
            _builder.append("installComment(");
            String _symbolName = this.getSymbolName(pElement);
            _builder.append(_symbolName, "\t");
            _builder.append(", \"");
            String _javaString = this.javaString(pComment);
            _builder.append(_javaString, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String defineEnumerations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void installEnumerations() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final List<Type> ownedTypes = ");
    String _symbolName = this.getSymbolName(pkg);
    _builder.append(_symbolName, "\t");
    _builder.append(".getOwnedType();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Enumeration type;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("List<EnumerationLiteral> enumerationLiterals;");
    _builder.newLine();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Enumeration> _sortedEnumerations = this.getSortedEnumerations(_rootPackage);
      for(final Enumeration enumeration : _sortedEnumerations) {
        _builder.append("\t");
        _builder.append("ownedTypes.add(type = ");
        String _symbolName_1 = this.getSymbolName(enumeration);
        _builder.append(_symbolName_1, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("enumerationLiterals = type.getOwnedLiteral();");
        _builder.newLine();
        {
          List<EnumerationLiteral> _ownedLiteral = enumeration.getOwnedLiteral();
          for(final EnumerationLiteral enumerationLiteral : _ownedLiteral) {
            _builder.append("\t");
            _builder.append("enumerationLiterals.add(");
            String _symbolName_2 = this.getSymbolName(enumerationLiteral);
            _builder.append(_symbolName_2, "\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("type.getSuperClass().add(_Enumeration);");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String defineIterations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Iteration> allIterations = this.getSortedIterations(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = allIterations.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          {
            for(final Iteration iteration : allIterations) {
              _builder.append("protected final @NonNull Iteration ");
              String _partialName = this.partialName(iteration);
              String _plus = ("it_" + _partialName);
              String _prefixedSymbolName = this.getPrefixedSymbolName(iteration, _plus);
              _builder.append(_prefixedSymbolName, "");
              _builder.append(" = createIteration(\"");
              String _name = iteration.getName();
              _builder.append(_name, "");
              _builder.append("\", ");
              Type _type = iteration.getType();
              String _symbolName = this.getSymbolName(_type);
              _builder.append(_symbolName, "");
              _builder.append(", ");
              {
                String _implementationClass = iteration.getImplementationClass();
                boolean _notEquals = (!Objects.equal(_implementationClass, null));
                if (_notEquals) {
                  _builder.append("\"");
                  String _implementationClass_1 = iteration.getImplementationClass();
                  _builder.append(_implementationClass_1, "");
                  _builder.append("\", ");
                  String _implementationClass_2 = iteration.getImplementationClass();
                  _builder.append(_implementationClass_2, "");
                  _builder.append(".INSTANCE");
                } else {
                  _builder.append("null, null");
                }
              }
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
        }
      }
      _builder.append("protected void installIterations() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Operation> ownedIterations;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Parameter> ownedParameters;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Iteration iteration;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Parameter parameter;");
      _builder.newLine();
      {
        List<Type> _sortedOwningTypes = this.getSortedOwningTypes(allIterations);
        for(final Type type : _sortedOwningTypes) {
          _builder.append("\t");
          _builder.append("ownedIterations = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "\t");
          _builder.append(".getOwnedOperation();");
          _builder.newLineIfNotEmpty();
          {
            List<Iteration> _sortedIterations = this.getSortedIterations(type, allIterations);
            for(final Iteration iteration_1 : _sortedIterations) {
              _builder.append("\t");
              _builder.append("ownedIterations.add(iteration = ");
              String _symbolName_2 = this.getSymbolName(iteration_1);
              _builder.append(_symbolName_2, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              {
                boolean _isInvalidating = iteration_1.isInvalidating();
                if (_isInvalidating) {
                  _builder.append("\t");
                  _builder.append("iteration.setIsInvalidating(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isRequired = iteration_1.isRequired();
                boolean _not = (!_isRequired);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("iteration.setIsRequired(false);");
                  _builder.newLine();
                }
              }
              {
                boolean _isStatic = iteration_1.isStatic();
                if (_isStatic) {
                  _builder.append("\t");
                  _builder.append("iteration.setIsStatic(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isValidating = iteration_1.isValidating();
                if (_isValidating) {
                  _builder.append("\t");
                  _builder.append("iteration.setIsValidating(true);");
                  _builder.newLine();
                }
              }
              {
                List<Parameter> _ownedIterator = iteration_1.getOwnedIterator();
                int _size_1 = _ownedIterator.size();
                boolean _greaterThan_1 = (_size_1 > 0);
                if (_greaterThan_1) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = iteration.getOwnedIterator();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedIterator_1 = iteration_1.getOwnedIterator();
                    for(final Parameter parameter : _ownedIterator_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_1 = parameter.getName();
                      _builder.append(_name_1, "\t");
                      _builder.append("\", ");
                      Type _type_1 = parameter.getType();
                      String _symbolName_3 = this.getSymbolName(_type_1);
                      _builder.append(_symbolName_3, "\t");
                      _builder.append(", ");
                      boolean _isRequired_1 = parameter.isRequired();
                      _builder.append(_isRequired_1, "\t");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _isRequired_2 = parameter.isRequired();
                        boolean _not_1 = (!_isRequired_2);
                        if (_not_1) {
                          _builder.append("\t");
                          _builder.append("parameter.setIsRequired(false);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
              {
                List<Parameter> _ownedAccumulator = iteration_1.getOwnedAccumulator();
                int _size_2 = _ownedAccumulator.size();
                boolean _greaterThan_2 = (_size_2 > 0);
                if (_greaterThan_2) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = iteration.getOwnedAccumulator();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedAccumulator_1 = iteration_1.getOwnedAccumulator();
                    for(final Parameter parameter_1 : _ownedAccumulator_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_2 = parameter_1.getName();
                      _builder.append(_name_2, "\t");
                      _builder.append("\", ");
                      Type _type_2 = parameter_1.getType();
                      String _symbolName_4 = this.getSymbolName(_type_2);
                      _builder.append(_symbolName_4, "\t");
                      _builder.append(", ");
                      boolean _isRequired_3 = parameter_1.isRequired();
                      _builder.append(_isRequired_3, "\t");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _isRequired_4 = parameter_1.isRequired();
                        boolean _not_2 = (!_isRequired_4);
                        if (_not_2) {
                          _builder.append("\t");
                          _builder.append("parameter.setIsRequired(false);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
              {
                List<Parameter> _ownedParameter = iteration_1.getOwnedParameter();
                int _size_3 = _ownedParameter.size();
                boolean _greaterThan_3 = (_size_3 > 0);
                if (_greaterThan_3) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = iteration.getOwnedParameter();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedParameter_1 = iteration_1.getOwnedParameter();
                    for(final Parameter parameter_2 : _ownedParameter_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_3 = parameter_2.getName();
                      _builder.append(_name_3, "\t");
                      _builder.append("\", ");
                      Type _type_3 = parameter_2.getType();
                      String _symbolName_5 = this.getSymbolName(_type_3);
                      _builder.append(_symbolName_5, "\t");
                      _builder.append(", ");
                      boolean _isRequired_5 = parameter_2.isRequired();
                      _builder.append(_isRequired_5, "\t");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _isRequired_6 = parameter_2.isRequired();
                        boolean _not_3 = (!_isRequired_6);
                        if (_not_3) {
                          _builder.append("\t");
                          _builder.append("parameter.setIsRequired(false);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineLambdaTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<LambdaType> allLambdaTypes = this.getSortedLambdaTypes(_rootPackage);
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final LambdaType type : allLambdaTypes) {
          _builder.append("protected final @NonNull LambdaType ");
          String _partialName = this.partialName(type);
          String _plus = ("_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createLambdaType(\"");
          String _name = type.getName();
          _builder.append(_name, "");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("protected void installLambdaTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> orphanTypes = ");
      String _symbolName = this.getSymbolName(orphanPackage);
      _builder.append(_symbolName, "\t");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("LambdaType type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final LambdaType type_1 : allLambdaTypes) {
          _builder.append("\t");
          _builder.append("orphanTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type_1);
          _builder.append(_symbolName_1, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("type.setContextType(");
          Type _contextType = type_1.getContextType();
          String _symbolName_2 = this.getSymbolName(_contextType);
          _builder.append(_symbolName_2, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            List<Type> _parameterType = type_1.getParameterType();
            for(final Type parameterType : _parameterType) {
              _builder.append("\t");
              _builder.append("type.getParameterType().add(");
              String _symbolName_3 = this.getSymbolName(parameterType);
              _builder.append(_symbolName_3, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("type.setResultType(");
          Type _resultType = type_1.getResultType();
          String _symbolName_4 = this.getSymbolName(_resultType);
          _builder.append(_symbolName_4, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type_1);
          _builder.append(_emitSuperClasses, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineMetaclasses(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Metaclass<?>> allMetaclasses = this.getSortedMetaclasses(_rootPackage);
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installMetaclasses() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "\t");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equal(orphanPackage, null));
        if (_notEquals) {
          _builder.append("\t");
          _builder.append("final List<Type> orphanTypes = ");
          String _symbolName_1 = this.getSymbolName(orphanPackage);
          _builder.append(_symbolName_1, "\t");
          _builder.append(".getOwnedType();");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("Metaclass<?> type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final Metaclass<?> type : allMetaclasses) {
          {
            TemplateableElement _unspecializedElement = type.getUnspecializedElement();
            boolean _equals = Objects.equal(_unspecializedElement, null);
            if (_equals) {
              _builder.append("\t");
              _builder.append("ownedTypes.add(type = ");
              String _symbolName_2 = this.getSymbolName(type);
              _builder.append(_symbolName_2, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("orphanTypes.add(type = ");
              String _symbolName_3 = this.getSymbolName(type);
              _builder.append(_symbolName_3, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("type.setUnspecializedElement(");
              TemplateableElement _unspecializedElement_1 = type.getUnspecializedElement();
              String _symbolName_4 = this.getSymbolName(_unspecializedElement_1);
              _builder.append(_symbolName_4, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("type.setInstanceType(");
          Type _instanceType = type.getInstanceType();
          String _symbolName_5 = this.getSymbolName(_instanceType);
          _builder.append(_symbolName_5, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type);
          _builder.append(_emitSuperClasses, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineOclTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      List<Type> allOclTypes = this.getSortedOclTypes(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installOclTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "\t");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("Type type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final Type type : allOclTypes) {
          _builder.append("\t");
          _builder.append("ownedTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            if ((!(type instanceof AnyType))) {
              _builder.append("\t");
              String _emitSuperClasses = this.emitSuperClasses(type);
              _builder.append(_emitSuperClasses, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineOperations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Operation> allOperations = this.getSortedOperations(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Operation operation : allOperations) {
          _builder.append("protected final @NonNull Operation ");
          String _partialName = this.partialName(operation);
          String _plus = ("op_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(operation, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createOperation(\"");
          String _name = operation.getName();
          _builder.append(_name, "");
          _builder.append("\", ");
          Type _type = operation.getType();
          String _symbolName = this.getSymbolName(_type);
          _builder.append(_symbolName, "");
          _builder.append(", ");
          {
            String _implementationClass = operation.getImplementationClass();
            boolean _notEquals = (!Objects.equal(_implementationClass, null));
            if (_notEquals) {
              _builder.append("\"");
              String _implementationClass_1 = operation.getImplementationClass();
              _builder.append(_implementationClass_1, "");
              _builder.append("\", ");
              String _implementationClass_2 = operation.getImplementationClass();
              _builder.append(_implementationClass_2, "");
              _builder.append(".INSTANCE");
            } else {
              _builder.append("null, null");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("protected void installOperations() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Operation> ownedOperations;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Parameter> ownedParameters;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Operation operation;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Parameter parameter;");
      _builder.newLine();
      {
        List<Type> _sortedOwningTypes = this.getSortedOwningTypes(allOperations);
        for(final Type type : _sortedOwningTypes) {
          _builder.append("\t");
          _builder.append("ownedOperations = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "\t");
          _builder.append(".getOwnedOperation();");
          _builder.newLineIfNotEmpty();
          {
            List<Operation> _sortedOperations = this.getSortedOperations(type, allOperations);
            for(final Operation operation_1 : _sortedOperations) {
              _builder.append("\t");
              _builder.append("ownedOperations.add(operation = ");
              String _symbolName_2 = this.getSymbolName(operation_1);
              _builder.append(_symbolName_2, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              {
                boolean _isInvalidating = operation_1.isInvalidating();
                if (_isInvalidating) {
                  _builder.append("\t");
                  _builder.append("operation.setIsInvalidating(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isRequired = operation_1.isRequired();
                boolean _not = (!_isRequired);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("operation.setIsRequired(false);");
                  _builder.newLine();
                }
              }
              {
                boolean _isStatic = operation_1.isStatic();
                if (_isStatic) {
                  _builder.append("\t");
                  _builder.append("operation.setIsStatic(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isValidating = operation_1.isValidating();
                if (_isValidating) {
                  _builder.append("\t");
                  _builder.append("operation.setIsValidating(true);");
                  _builder.newLine();
                }
              }
              {
                OpaqueExpression _bodyExpression = operation_1.getBodyExpression();
                boolean _notEquals_1 = (!Objects.equal(_bodyExpression, null));
                if (_notEquals_1) {
                  _builder.append("\t");
                  _builder.append("operation.setBodyExpression(createOpaqueExpression(");
                  Type _type_1 = operation_1.getType();
                  String _symbolName_3 = this.getSymbolName(_type_1);
                  _builder.append(_symbolName_3, "\t");
                  _builder.append(", \"");
                  OpaqueExpression _bodyExpression_1 = operation_1.getBodyExpression();
                  String _javaString = this.javaString(_bodyExpression_1);
                  _builder.append(_javaString, "\t");
                  _builder.append("\"));");
                  _builder.newLineIfNotEmpty();
                }
              }
              {
                List<Parameter> _ownedParameter = operation_1.getOwnedParameter();
                int _size = _ownedParameter.size();
                boolean _greaterThan = (_size > 0);
                if (_greaterThan) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = operation.getOwnedParameter();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedParameter_1 = operation_1.getOwnedParameter();
                    for(final Parameter parameter : _ownedParameter_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_1 = parameter.getName();
                      _builder.append(_name_1, "\t");
                      _builder.append("\", ");
                      Type _type_2 = parameter.getType();
                      String _symbolName_4 = this.getSymbolName(_type_2);
                      _builder.append(_symbolName_4, "\t");
                      _builder.append(", ");
                      boolean _isRequired_1 = parameter.isRequired();
                      _builder.append(_isRequired_1, "\t");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String definePackages(final org.eclipse.ocl.examples.pivot.Package pkg0) {
    String _xblockexpression = null;
    {
      Root rootPackage = this.getRootPackage(pkg0);
      List<org.eclipse.ocl.examples.pivot.Package> allPackages = this.getSortedPackages(rootPackage);
      HashSet<org.eclipse.ocl.examples.pivot.Package> morePackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>(allPackages);
      morePackages.remove(pkg0);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = morePackages.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          {
            for(final org.eclipse.ocl.examples.pivot.Package pkg1 : morePackages) {
              _builder.append("protected final @NonNull ");
              EClass _eClass = pkg1.eClass();
              String _name = _eClass.getName();
              _builder.append(_name, "");
              _builder.append(" ");
              String _partialName = this.partialName(pkg1);
              String _plus = ("pk_" + _partialName);
              String _prefixedSymbolName = this.getPrefixedSymbolName(pkg1, _plus);
              _builder.append(_prefixedSymbolName, "");
              _builder.append(" = create");
              EClass _eClass_1 = pkg1.eClass();
              String _name_1 = _eClass_1.getName();
              _builder.append(_name_1, "");
              _builder.append("(\"");
              String _name_2 = pkg1.getName();
              _builder.append(_name_2, "");
              _builder.append("\", ");
              {
                String _nsPrefix = pkg1.getNsPrefix();
                boolean _notEquals = (!Objects.equal(_nsPrefix, null));
                if (_notEquals) {
                  _builder.append("\"");
                  String _nsPrefix_1 = pkg1.getNsPrefix();
                  _builder.append(_nsPrefix_1, "");
                  _builder.append("\"");
                } else {
                  _builder.append("null");
                }
              }
              _builder.append(", ");
              {
                String _nsURI = pkg1.getNsURI();
                boolean _notEquals_1 = (!Objects.equal(_nsURI, null));
                if (_notEquals_1) {
                  _builder.append("\"");
                  String _nsURI_1 = pkg1.getNsURI();
                  _builder.append(_nsURI_1, "");
                  _builder.append("\"");
                } else {
                  _builder.append("null");
                }
              }
              _builder.append(", null);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
        }
      }
      _builder.append("protected void installPackages() {");
      _builder.newLine();
      _builder.append("\t");
      String _emitRoot = this.emitRoot(rootPackage);
      _builder.append(_emitRoot, "\t");
      _builder.newLineIfNotEmpty();
      {
        int _size_1 = allPackages.size();
        boolean _greaterThan_1 = (_size_1 > 0);
        if (_greaterThan_1) {
          {
            for(final org.eclipse.ocl.examples.pivot.Package pkg2 : allPackages) {
              _builder.append("\t");
              String _emitPackage = this.emitPackage(pkg2);
              _builder.append(_emitPackage, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineParameterTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void installParameterTypes() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String definePrecedences(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Library> allLibraries = this.getSortedLibraries(_rootPackage);
      Root _rootPackage_1 = this.getRootPackage(pkg);
      List<Operation> allOperations = this.getSortedOperationsWithPrecedence(_rootPackage_1);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = allLibraries.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _builder.append("protected void installPrecedences() {");
          _builder.newLine();
          {
            for(final Library lib : allLibraries) {
              _builder.append("\t");
              List<Precedence> allPrecedences = this.getSortedPrecedences(lib);
              _builder.newLineIfNotEmpty();
              {
                for(final Precedence precedence : allPrecedences) {
                  _builder.append("\t");
                  _builder.append("final Precedence ");
                  String _partialName = this.partialName(precedence);
                  String _plus = ("prec_" + _partialName);
                  String _prefixedSymbolName = this.getPrefixedSymbolName(precedence, _plus);
                  _builder.append(_prefixedSymbolName, "\t");
                  _builder.append(" = createPrecedence(\"");
                  String _name = precedence.getName();
                  _builder.append(_name, "\t");
                  _builder.append("\", AssociativityKind.");
                  AssociativityKind _associativity = precedence.getAssociativity();
                  String _string = _associativity.toString();
                  String _upperCase = _string.toUpperCase();
                  _builder.append(_upperCase, "\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.newLine();
              _builder.append("\t");
              _builder.append("final List<Precedence> ownedPrecedences = ");
              String _symbolName = this.getSymbolName(lib);
              _builder.append(_symbolName, "\t");
              _builder.append(".getOwnedPrecedence();");
              _builder.newLineIfNotEmpty();
              {
                List<Precedence> _ownedPrecedence = lib.getOwnedPrecedence();
                for(final Precedence precedence_1 : _ownedPrecedence) {
                  _builder.append("\t");
                  _builder.append("ownedPrecedences.add(");
                  String _symbolName_1 = this.getSymbolName(precedence_1);
                  _builder.append(_symbolName_1, "\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          {
            for(final Operation operation : allOperations) {
              _builder.append("\t");
              String _symbolName_2 = this.getSymbolName(operation);
              _builder.append(_symbolName_2, "\t");
              _builder.append(".setPrecedence(");
              Precedence _precedence = operation.getPrecedence();
              String _symbolName_3 = this.getSymbolName(_precedence);
              _builder.append(_symbolName_3, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String definePrimitiveTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<PrimitiveType> allTypes = this.getSortedPrimitiveTypes(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installPrimitiveTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "\t");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("PrimitiveType type;");
      _builder.newLine();
      {
        for(final PrimitiveType type : allTypes) {
          _builder.append("\t");
          List<Type> superClasses = this.getSuperclassesInPackage(type);
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("ownedTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            for(final Type superClass : superClasses) {
              _builder.append("\t");
              _builder.append("type.getSuperClass().add(");
              String _symbolName_2 = this.getSymbolName(superClass);
              _builder.append(_symbolName_2, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineProperties(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Property> allProperties = this.getAllProperties(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installProperties() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Property> ownedProperties;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Property property;");
      _builder.newLine();
      {
        List<Type> _sortedOwningTypes2 = this.getSortedOwningTypes2(allProperties);
        for(final Type type : _sortedOwningTypes2) {
          _builder.append("\t");
          _builder.append("ownedProperties = ");
          String _symbolName = this.getSymbolName(type);
          _builder.append(_symbolName, "\t");
          _builder.append(".getOwnedAttribute();");
          _builder.newLineIfNotEmpty();
          {
            List<Property> _sortedProperties = this.getSortedProperties(type, allProperties);
            for(final Property property : _sortedProperties) {
              _builder.append("\t");
              _builder.append("ownedProperties.add(property = ");
              String _symbolName_1 = this.getSymbolName(property);
              _builder.append(_symbolName_1, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              {
                boolean _isComposite = property.isComposite();
                if (_isComposite) {
                  _builder.append("\t");
                  _builder.append("property.setIsComposite(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isDerived = property.isDerived();
                if (_isDerived) {
                  _builder.append("\t");
                  _builder.append("property.setIsDerived(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isID = property.isID();
                if (_isID) {
                  _builder.append("\t");
                  _builder.append("property.setIsID(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isImplicit = property.isImplicit();
                if (_isImplicit) {
                  _builder.append("\t");
                  _builder.append("property.setImplicit(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isReadOnly = property.isReadOnly();
                if (_isReadOnly) {
                  _builder.append("\t");
                  _builder.append("property.setIsReadOnly(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isRequired = property.isRequired();
                boolean _not = (!_isRequired);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("property.setIsRequired(false);");
                  _builder.newLine();
                }
              }
              {
                boolean _isResolveProxies = property.isResolveProxies();
                if (_isResolveProxies) {
                  _builder.append("\t");
                  _builder.append("property.setIsResolveProxies(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isStatic = property.isStatic();
                if (_isStatic) {
                  _builder.append("\t");
                  _builder.append("property.setIsStatic(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isTransient = property.isTransient();
                if (_isTransient) {
                  _builder.append("\t");
                  _builder.append("property.setIsTransient(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isUnsettable = property.isUnsettable();
                if (_isUnsettable) {
                  _builder.append("\t");
                  _builder.append("property.setIsUnsettable(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isVolatile = property.isVolatile();
                if (_isVolatile) {
                  _builder.append("\t");
                  _builder.append("property.setIsVolatile(true);");
                  _builder.newLine();
                }
              }
              {
                Property _opposite = property.getOpposite();
                boolean _notEquals = (!Objects.equal(_opposite, null));
                if (_notEquals) {
                  _builder.append("\t");
                  _builder.append("property.setOpposite(");
                  Property _opposite_1 = property.getOpposite();
                  String _symbolName_2 = this.getSymbolName(_opposite_1);
                  _builder.append(_symbolName_2, "\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              {
                String _implementationClass = property.getImplementationClass();
                boolean _notEquals_1 = (!Objects.equal(_implementationClass, null));
                if (_notEquals_1) {
                  _builder.append("\t");
                  _builder.append("property.setImplementationClass(\"");
                  String _implementationClass_1 = property.getImplementationClass();
                  _builder.append(_implementationClass_1, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("property.setImplementation(");
                  String _implementationClass_2 = property.getImplementationClass();
                  _builder.append(_implementationClass_2, "\t");
                  _builder.append(".INSTANCE);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineTemplateBindings(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TemplateableElement> allTemplateableElements = this.getSortedTemplateableElements(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installTemplateBindings() {");
      _builder.newLine();
      {
        for(final TemplateableElement templateableElement : allTemplateableElements) {
          {
            List<TemplateBinding> _templateBinding = templateableElement.getTemplateBinding();
            for(final TemplateBinding templateBinding : _templateBinding) {
              _builder.append("\t");
              String _symbolName = this.getSymbolName(templateableElement);
              _builder.append(_symbolName, "\t");
              _builder.append(".getTemplateBinding().add(createTemplateBinding(");
              TemplateSignature _signature = templateBinding.getSignature();
              String _symbolName_1 = this.getSymbolName(_signature);
              _builder.append(_symbolName_1, "\t");
              _builder.append(",");
              _builder.newLineIfNotEmpty();
              {
                List<TemplateParameterSubstitution> _parameterSubstitution = templateBinding.getParameterSubstitution();
                boolean _hasElements = false;
                for(final TemplateParameterSubstitution templateParameterSubstitution : _parameterSubstitution) {
                  if (!_hasElements) {
                    _hasElements = true;
                  } else {
                    _builder.appendImmediate(",\n", "\t\t");
                  }
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("createTemplateParameterSubstitution(");
                  TemplateParameter _formal = templateParameterSubstitution.getFormal();
                  String _symbolName_2 = this.getSymbolName(_formal);
                  _builder.append(_symbolName_2, "\t\t");
                  _builder.append(", ");
                  ParameterableElement _actual = templateParameterSubstitution.getActual();
                  String _symbolName_3 = this.getSymbolName(_actual);
                  _builder.append(_symbolName_3, "\t\t");
                  _builder.append(")");
                }
              }
              _builder.append("));");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineTemplateSignatures(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TemplateParameter> allTemplateParameters = this.getSortedTemplateParameters(_rootPackage);
      Root _rootPackage_1 = this.getRootPackage(pkg);
      List<TemplateSignature> allTemplateSignatures = this.getSortedTemplateSignatures(_rootPackage_1);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final TemplateParameter templateParameter : allTemplateParameters) {
          _builder.append("protected final @NonNull TypeTemplateParameter ");
          String _partialName = this.partialName(templateParameter);
          String _plus = ("tp_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(templateParameter, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createTypeTemplateParameter(");
          ParameterableElement _ownedParameteredElement = templateParameter.getOwnedParameteredElement();
          String _symbolName = this.getSymbolName(_ownedParameteredElement);
          _builder.append(_symbolName, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        for(final TemplateSignature templateSignature : allTemplateSignatures) {
          _builder.append("protected final @NonNull TemplateSignature ");
          String _partialName_1 = this.partialName(templateSignature);
          String _plus_1 = ("ts_" + _partialName_1);
          String _prefixedSymbolName_1 = this.getPrefixedSymbolName(templateSignature, _plus_1);
          _builder.append(_prefixedSymbolName_1, "");
          _builder.append(" = createTemplateSignature(");
          TemplateableElement _template = templateSignature.getTemplate();
          String _symbolName_1 = this.getSymbolName(_template);
          _builder.append(_symbolName_1, "");
          {
            List<TemplateParameter> _ownedParameter = templateSignature.getOwnedParameter();
            for(final TemplateParameter templateParameter_1 : _ownedParameter) {
              _builder.append(", ");
              String _symbolName_2 = this.getSymbolName(templateParameter_1);
              _builder.append(_symbolName_2, "");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("protected void installTemplateSignatures() {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String defineTupleTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TupleType> allTupleTypes = this.getSortedTupleTypes(_rootPackage);
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installTupleTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> orphanTypes = ");
      String _symbolName = this.getSymbolName(orphanPackage);
      _builder.append(_symbolName, "\t");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("TupleType type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final TupleType type : allTupleTypes) {
          _builder.append("\t");
          _builder.append("orphanTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            List<Property> _sortedProperties = this.getSortedProperties(type);
            for(final Property property : _sortedProperties) {
              {
                String _implementationClass = property.getImplementationClass();
                boolean _notEquals = (!Objects.equal(_implementationClass, null));
                if (_notEquals) {
                  _builder.append("\t");
                  String _symbolName_2 = this.getSymbolName(property);
                  _builder.append(_symbolName_2, "\t");
                  _builder.append(".setImplementationClass(\"");
                  String _implementationClass_1 = property.getImplementationClass();
                  _builder.append(_implementationClass_1, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _symbolName_3 = this.getSymbolName(property);
                  _builder.append(_symbolName_3, "\t");
                  _builder.append(".setImplementation(");
                  String _implementationClass_2 = property.getImplementationClass();
                  _builder.append(_implementationClass_2, "\t");
                  _builder.append(".INSTANCE);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type);
          _builder.append(_emitSuperClasses, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String emitCreateProperty(final Property property) {
    String _name = property.getName();
    String _plus = ("createProperty(" + _name);
    String _plus_1 = (_plus + ", ");
    Type _type = property.getType();
    String _symbolName = this.getSymbolName(_type);
    String _plus_2 = (_plus_1 + _symbolName);
    return (_plus_2 + ")");
  }
  
  protected String emitPackage(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<org.eclipse.ocl.examples.pivot.Package> _sortedPackages = this.getSortedPackages(pkg);
      for(final org.eclipse.ocl.examples.pivot.Package nestedPackage : _sortedPackages) {
        {
          List<org.eclipse.ocl.examples.pivot.Package> _nestedPackage = nestedPackage.getNestedPackage();
          int _size = _nestedPackage.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            String _emitPackage = this.emitPackage(nestedPackage);
            _builder.append(_emitPackage, "");
            _builder.newLineIfNotEmpty();
          }
        }
        String _symbolName = this.getSymbolName(pkg);
        _builder.append(_symbolName, "");
        _builder.append(".getNestedPackage().add(");
        String _symbolName_1 = this.getSymbolName(nestedPackage);
        _builder.append(_symbolName_1, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String emitRoot(final Root pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<org.eclipse.ocl.examples.pivot.Package> _sortedPackages = this.getSortedPackages(pkg);
      for(final org.eclipse.ocl.examples.pivot.Package nestedPackage : _sortedPackages) {
        {
          List<org.eclipse.ocl.examples.pivot.Package> _nestedPackage = nestedPackage.getNestedPackage();
          int _size = _nestedPackage.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            String _emitPackage = this.emitPackage(nestedPackage);
            _builder.append(_emitPackage, "");
            _builder.newLineIfNotEmpty();
          }
        }
        String _symbolName = this.getSymbolName(pkg);
        _builder.append(_symbolName, "");
        _builder.append(".getNestedPackage().add(");
        String _symbolName_1 = this.getSymbolName(nestedPackage);
        _builder.append(_symbolName_1, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String emitSuperClasses(final Type type) {
    String _xblockexpression = null;
    {
      List<Type> superClasses = this.getSuperclassesInPackage(type);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = superClasses.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _builder.append("superClasses = type.getSuperClass();");
          _builder.newLine();
          {
            for(final Type superClass : superClasses) {
              _builder.append("superClasses.add(");
              String _symbolName = this.getSymbolName(superClass);
              _builder.append(_symbolName, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          if ((type instanceof CollectionType)) {
            _builder.append("superClasses = type.getSuperClass();");
            _builder.newLine();
            _builder.append("superClasses.add(_OclAny);");
            _builder.newLine();
          } else {
            if ((!(type instanceof AnyType))) {
              _builder.append("superClasses = type.getSuperClass();");
              _builder.newLine();
              _builder.append("superClasses.add(_OclElement);");
              _builder.newLine();
            }
          }
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String partialName(final EObject element) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof CollectionType) {
        Type _elementType = ((CollectionType)element).getElementType();
        boolean _equals = Objects.equal(_elementType, null);
        if (_equals) {
          _matched=true;
          return this.javaName(((NamedElement)element));
        }
      }
    }
    if (!_matched) {
      if (element instanceof CollectionType) {
        _matched=true;
        String _javaName = this.javaName(((NamedElement)element));
        String _plus = (_javaName + "_");
        Type _elementType = ((CollectionType)element).getElementType();
        String _partialName = this.partialName(_elementType);
        return (_plus + _partialName);
      }
    }
    if (!_matched) {
      if (element instanceof LambdaType) {
        Type _contextType = ((LambdaType)element).getContextType();
        boolean _equals = Objects.equal(_contextType, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof LambdaType) {
        _matched=true;
        String _javaName = this.javaName(((NamedElement)element));
        String _plus = (_javaName + "_");
        Type _contextType = ((LambdaType)element).getContextType();
        String _partialName = this.partialName(_contextType);
        return (_plus + _partialName);
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        TemplateParameter _templateParameter = ((Type)element).getTemplateParameter();
        boolean _notEquals = (!Objects.equal(_templateParameter, null));
        if (_notEquals) {
          _matched=true;
          TemplateParameter _templateParameter_1 = ((Type)element).getTemplateParameter();
          String _simpleName = this.simpleName(_templateParameter_1);
          String _plus = (_simpleName + "_");
          String _javaName = this.javaName(((NamedElement)element));
          return (_plus + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        List<TemplateBinding> _templateBinding = ((Type)element).getTemplateBinding();
        int _size = _templateBinding.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          String _javaName = this.javaName(((NamedElement)element));
          _builder.append(_javaName, "");
          {
            List<TemplateParameterSubstitution> _templateParameterSubstitutions = this.getTemplateParameterSubstitutions(((TemplateableElement)element));
            for(final TemplateParameterSubstitution tps : _templateParameterSubstitutions) {
              _builder.append("_");
              ParameterableElement _actual = tps.getActual();
              String _simpleName = this.simpleName(_actual);
              _builder.append(_simpleName, "");
            }
          }
          return _builder.toString();
        }
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        _matched=true;
        return this.javaName(((NamedElement)element));
      }
    }
    if (!_matched) {
      if (element instanceof Comment) {
        String _body = ((Comment)element).getBody();
        boolean _equals = Objects.equal(_body, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof Comment) {
        _matched=true;
        String _body = ((Comment)element).getBody();
        String _body_1 = ((Comment)element).getBody();
        int _length = _body_1.length();
        int _minus = (_length - 1);
        int _min = Math.min(11, _minus);
        String _substring = _body.substring(0, _min);
        return this.javaName(element, _substring);
      }
    }
    if (!_matched) {
      if (element instanceof EnumerationLiteral) {
        Enumeration _enumeration = ((EnumerationLiteral)element).getEnumeration();
        boolean _equals = Objects.equal(_enumeration, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof EnumerationLiteral) {
        _matched=true;
        Enumeration _enumeration = ((EnumerationLiteral)element).getEnumeration();
        String _partialName = this.partialName(_enumeration);
        String _plus = (_partialName + "_");
        String _javaName = this.javaName(((NamedElement)element));
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        Type _owningType = ((Operation)element).getOwningType();
        boolean _equals = Objects.equal(_owningType, null);
        if (_equals) {
          _matched=true;
          String _javaName = this.javaName(((NamedElement)element));
          return ("null_" + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        _matched=true;
        Type _owningType = ((Operation)element).getOwningType();
        String _partialName = this.partialName(_owningType);
        String _plus = (_partialName + "_");
        String _javaName = this.javaName(((NamedElement)element));
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof org.eclipse.ocl.examples.pivot.Package) {
        _matched=true;
        return this.javaName(((NamedElement)element));
      }
    }
    if (!_matched) {
      if (element instanceof Parameter) {
        EObject _eContainer = ((Parameter)element).eContainer();
        boolean _equals = Objects.equal(_eContainer, null);
        if (_equals) {
          _matched=true;
          String _javaName = this.javaName(((NamedElement)element));
          return ("null_" + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Parameter) {
        _matched=true;
        EObject _eContainer = ((Parameter)element).eContainer();
        String _partialName = this.partialName(_eContainer);
        String _plus = (_partialName + "_");
        String _javaName = this.javaName(((NamedElement)element));
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof Precedence) {
        _matched=true;
        return this.javaName(((NamedElement)element));
      }
    }
    if (!_matched) {
      if (element instanceof Property) {
        _matched=true;
        return this.getPartialName(((Property)element));
      }
    }
    if (!_matched) {
      if (element instanceof TemplateBinding) {
        TemplateSignature _signature = ((TemplateBinding)element).getSignature();
        TemplateableElement _template = _signature.getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateBinding) {
        _matched=true;
        TemplateableElement _boundElement = ((TemplateBinding)element).getBoundElement();
        return this.partialName(_boundElement);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        TemplateSignature _signature = ((TemplateParameter)element).getSignature();
        TemplateableElement _template = _signature.getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          TemplateSignature _signature_1 = ((TemplateParameter)element).getSignature();
          String _partialName = this.partialName(_signature_1);
          String _plus = ("[" + _partialName);
          return (_plus + "]");
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        ParameterableElement _parameteredElement = ((TemplateParameter)element).getParameteredElement();
        boolean _equals = Objects.equal(_parameteredElement, null);
        if (_equals) {
          _matched=true;
          TemplateSignature _signature = ((TemplateParameter)element).getSignature();
          TemplateableElement _template = _signature.getTemplate();
          return this.partialName(_template);
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        if (true) {
          _matched=true;
          TemplateSignature _signature = ((TemplateParameter)element).getSignature();
          TemplateableElement _template = _signature.getTemplate();
          return this.partialName(_template);
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        _matched=true;
        TemplateSignature _signature = ((TemplateParameter)element).getSignature();
        TemplateableElement _template = _signature.getTemplate();
        String _partialName = this.partialName(_template);
        String _plus = (_partialName + "_");
        ParameterableElement _parameteredElement = ((TemplateParameter)element).getParameteredElement();
        String _simpleName = this.simpleName(_parameteredElement);
        return (_plus + _simpleName);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        TemplateBinding _templateBinding = ((TemplateParameterSubstitution)element).getTemplateBinding();
        boolean _equals = Objects.equal(_templateBinding, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        TemplateBinding _templateBinding = ((TemplateParameterSubstitution)element).getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        boolean _equals = Objects.equal(_boundElement, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        _matched=true;
        TemplateBinding _templateBinding = ((TemplateParameterSubstitution)element).getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        return this.partialName(_boundElement);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateSignature) {
        TemplateableElement _template = ((TemplateSignature)element).getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateSignature) {
        _matched=true;
        TemplateableElement _template = ((TemplateSignature)element).getTemplate();
        return this.partialName(_template);
      }
    }
    EClass _eClass = element.eClass();
    String _name = _eClass.getName();
    return ("xyzzy" + _name);
  }
  
  protected String simpleName(final EObject element) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        TemplateSignature _signature = ((TemplateParameter)element).getSignature();
        TemplateableElement _template = _signature.getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        _matched=true;
        TemplateSignature _signature = ((TemplateParameter)element).getSignature();
        TemplateableElement _template = _signature.getTemplate();
        return this.simpleName(_template);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        TemplateBinding _templateBinding = ((TemplateParameterSubstitution)element).getTemplateBinding();
        boolean _equals = Objects.equal(_templateBinding, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        TemplateBinding _templateBinding = ((TemplateParameterSubstitution)element).getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        boolean _equals = Objects.equal(_boundElement, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        _matched=true;
        TemplateBinding _templateBinding = ((TemplateParameterSubstitution)element).getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        return this.simpleName(_boundElement);
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        TemplateParameter _templateParameter = ((Type)element).getTemplateParameter();
        boolean _equals = Objects.equal(_templateParameter, null);
        if (_equals) {
          _matched=true;
          return this.javaName(((NamedElement)element));
        }
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        _matched=true;
        TemplateParameter _templateParameter = ((Type)element).getTemplateParameter();
        String _simpleName = this.simpleName(_templateParameter);
        String _plus = (_simpleName + "_");
        String _javaName = this.javaName(((NamedElement)element));
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        Type _owningType = ((Operation)element).getOwningType();
        boolean _equals = Objects.equal(_owningType, null);
        if (_equals) {
          _matched=true;
          String _javaName = this.javaName(((NamedElement)element));
          return ("null_" + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        _matched=true;
        Type _owningType = ((Operation)element).getOwningType();
        String _simpleName = this.simpleName(_owningType);
        String _plus = (_simpleName + "_");
        String _javaName = this.javaName(((NamedElement)element));
        return (_plus + _javaName);
      }
    }
    EClass _eClass = element.eClass();
    String _name = _eClass.getName();
    return ("xyzzy" + _name);
  }
}
