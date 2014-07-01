/**
 */
package org.trc.xtext.dsl.dsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.trc.xtext.dsl.dsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.trc.xtext.dsl.dsl.DslPackage
 * @generated
 */
public class DslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = DslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case DslPackage.TRC_SPECIFICATION:
      {
        TrcSpecification trcSpecification = (TrcSpecification)theEObject;
        T result = caseTrcSpecification(trcSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TRC_RULE:
      {
        trcRule trcRule = (trcRule)theEObject;
        T result = casetrcRule(trcRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.MODULE_LIST:
      {
        ModuleList moduleList = (ModuleList)theEObject;
        T result = caseModuleList(moduleList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TRANSFORMATION_LIST:
      {
        TransformationList transformationList = (TransformationList)theEObject;
        T result = caseTransformationList(transformationList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TRANSFORMATION:
      {
        Transformation transformation = (Transformation)theEObject;
        T result = caseTransformation(transformation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TRANSFORMATION_IMPACT:
      {
        TransformationImpact transformationImpact = (TransformationImpact)theEObject;
        T result = caseTransformationImpact(transformationImpact);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TRANSFORMATION_DEPENDENCY_LIST:
      {
        TransformationDependencyList transformationDependencyList = (TransformationDependencyList)theEObject;
        T result = caseTransformationDependencyList(transformationDependencyList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TRANSFORMATION_DEPENDENCY:
      {
        TransformationDependency transformationDependency = (TransformationDependency)theEObject;
        T result = caseTransformationDependency(transformationDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.ABSTRACT_RULE_DEPENDENCY:
      {
        AbstractRuleDependency abstractRuleDependency = (AbstractRuleDependency)theEObject;
        T result = caseAbstractRuleDependency(abstractRuleDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.RULE_DEPENDENCY:
      {
        RuleDependency ruleDependency = (RuleDependency)theEObject;
        T result = caseRuleDependency(ruleDependency);
        if (result == null) result = caseAbstractRuleDependency(ruleDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.REQUIRES_DEPENDENCY:
      {
        requiresDependency requiresDependency = (requiresDependency)theEObject;
        T result = caserequiresDependency(requiresDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.EXCLUDE_DEPENDENCY:
      {
        excludeDependency excludeDependency = (excludeDependency)theEObject;
        T result = caseexcludeDependency(excludeDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trc Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trc Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrcSpecification(TrcSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>trc Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>trc Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casetrcRule(trcRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleList(ModuleList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModule(Module object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationList(TransformationList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformation(Transformation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Impact</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Impact</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationImpact(TransformationImpact object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Dependency List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Dependency List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationDependencyList(TransformationDependencyList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationDependency(TransformationDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Rule Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Rule Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractRuleDependency(AbstractRuleDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleDependency(RuleDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>requires Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>requires Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserequiresDependency(requiresDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>exclude Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>exclude Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseexcludeDependency(excludeDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //DslSwitch
