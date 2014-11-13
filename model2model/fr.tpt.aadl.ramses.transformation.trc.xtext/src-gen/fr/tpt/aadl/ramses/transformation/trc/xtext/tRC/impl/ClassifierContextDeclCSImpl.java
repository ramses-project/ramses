/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ClassifierContextDeclCSImpl#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ClassifierContextDeclCSImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ClassifierContextDeclCSImpl#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierContextDeclCSImpl extends oclExprImpl implements ClassifierContextDeclCS
{
  /**
   * The default value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelfName()
   * @generated
   * @ordered
   */
  protected static final String SELF_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelfName()
   * @generated
   * @ordered
   */
  protected String selfName = SELF_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getInvariants() <em>Invariants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvariants()
   * @generated
   * @ordered
   */
  protected EList<ConstraintCS> invariants;

  /**
   * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinitions()
   * @generated
   * @ordered
   */
  protected EList<DefCS> definitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassifierContextDeclCSImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TRCPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSelfName()
  {
    return selfName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelfName(String newSelfName)
  {
    String oldSelfName = selfName;
    selfName = newSelfName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME, oldSelfName, selfName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintCS> getInvariants()
  {
    if (invariants == null)
    {
      invariants = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS);
    }
    return invariants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefCS> getDefinitions()
  {
    if (definitions == null)
    {
      definitions = new EObjectContainmentEList<DefCS>(DefCS.class, this, TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS);
    }
    return definitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
        return ((InternalEList<?>)getInvariants()).basicRemove(otherEnd, msgs);
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
        return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
        return getSelfName();
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
        return getInvariants();
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
        return getDefinitions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
        setSelfName((String)newValue);
        return;
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
        getInvariants().clear();
        getInvariants().addAll((Collection<? extends ConstraintCS>)newValue);
        return;
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
        getDefinitions().clear();
        getDefinitions().addAll((Collection<? extends DefCS>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
        setSelfName(SELF_NAME_EDEFAULT);
        return;
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
        getInvariants().clear();
        return;
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
        getDefinitions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
        return SELF_NAME_EDEFAULT == null ? selfName != null : !SELF_NAME_EDEFAULT.equals(selfName);
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
        return invariants != null && !invariants.isEmpty();
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
        return definitions != null && !definitions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (selfName: ");
    result.append(selfName);
    result.append(')');
    return result.toString();
  }

} //ClassifierContextDeclCSImpl
