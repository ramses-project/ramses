/**
 */
package fr.tpt.aadl.ramses.transformation.trc.util;

import fr.tpt.aadl.ramses.transformation.trc.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage
 * @generated
 */
public class TrcSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TrcPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrcSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TrcPackage.eINSTANCE;
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
      case TrcPackage.TRC_SPECIFICATION:
      {
        TrcSpecification trcSpecification = (TrcSpecification)theEObject;
        T result = caseTrcSpecification(trcSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.TRANSFORMATION_IMPACT:
      {
        TransformationImpact transformationImpact = (TransformationImpact)theEObject;
        T result = caseTransformationImpact(transformationImpact);
        if (result == null) result = caseTransformationElement(transformationImpact);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.TRANSFORMATION:
      {
        Transformation transformation = (Transformation)theEObject;
        T result = caseTransformation(transformation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.TRANSFORMATION_DEPENDENCY:
      {
        TransformationDependency transformationDependency = (TransformationDependency)theEObject;
        T result = caseTransformationDependency(transformationDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.ABSTRACT_RULE_DEPENDENCY:
      {
        AbstractRuleDependency abstractRuleDependency = (AbstractRuleDependency)theEObject;
        T result = caseAbstractRuleDependency(abstractRuleDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.RULE_DEPENDENCY_CONJUNCTION:
      {
        RuleDependencyConjunction ruleDependencyConjunction = (RuleDependencyConjunction)theEObject;
        T result = caseRuleDependencyConjunction(ruleDependencyConjunction);
        if (result == null) result = caseRuleDependencyComposite(ruleDependencyConjunction);
        if (result == null) result = caseAbstractRuleDependency(ruleDependencyConjunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.RULE_DEPENDENCY_DISJUNCTION:
      {
        RuleDependencyDisjunction ruleDependencyDisjunction = (RuleDependencyDisjunction)theEObject;
        T result = caseRuleDependencyDisjunction(ruleDependencyDisjunction);
        if (result == null) result = caseRuleDependencyComposite(ruleDependencyDisjunction);
        if (result == null) result = caseAbstractRuleDependency(ruleDependencyDisjunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.RULE_DEPENDENCY:
      {
        RuleDependency ruleDependency = (RuleDependency)theEObject;
        T result = caseRuleDependency(ruleDependency);
        if (result == null) result = caseAbstractRuleDependency(ruleDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.RULE_DEPENDENCY_COMPOSITE:
      {
        RuleDependencyComposite ruleDependencyComposite = (RuleDependencyComposite)theEObject;
        T result = caseRuleDependencyComposite(ruleDependencyComposite);
        if (result == null) result = caseAbstractRuleDependency(ruleDependencyComposite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.TRANSFORMATION_ELEMENT:
      {
        TransformationElement transformationElement = (TransformationElement)theEObject;
        T result = caseTransformationElement(transformationElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.MODULE_LIST:
      {
        ModuleList moduleList = (ModuleList)theEObject;
        T result = caseModuleList(moduleList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.SPECIFICATION_ELEMENT:
      {
        SpecificationElement specificationElement = (SpecificationElement)theEObject;
        T result = caseSpecificationElement(specificationElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.TRANSFORMATION_LIST:
      {
        TransformationList transformationList = (TransformationList)theEObject;
        T result = caseTransformationList(transformationList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST:
      {
        TransformationDependencyList transformationDependencyList = (TransformationDependencyList)theEObject;
        T result = caseTransformationDependencyList(transformationDependencyList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrcSpecification(TrcSpecification object)
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
   * Returns the result of interpreting the object as an instance of '<em>Rule Dependency Conjunction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Dependency Conjunction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleDependencyConjunction(RuleDependencyConjunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Dependency Disjunction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Dependency Disjunction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleDependencyDisjunction(RuleDependencyDisjunction object)
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
   * Returns the result of interpreting the object as an instance of '<em>Rule Dependency Composite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Dependency Composite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleDependencyComposite(RuleDependencyComposite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationElement(TransformationElement object)
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
   * Returns the result of interpreting the object as an instance of '<em>Specification Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specification Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecificationElement(SpecificationElement object)
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

} //TrcSwitch
