/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypedRefCS;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationContextDeclCSImpl extends MinimalEObjectImpl.Container implements OperationContextDeclCS
{
  /**
   * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPathName()
   * @generated
   * @ordered
   */
  protected PathNameCS pathName;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ParameterCS> parameters;

  /**
   * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedType()
   * @generated
   * @ordered
   */
  protected TypedRefCS ownedType;

  /**
   * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditions()
   * @generated
   * @ordered
   */
  protected EList<ConstraintCS> preconditions;

  /**
   * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostconditions()
   * @generated
   * @ordered
   */
  protected EList<ConstraintCS> postconditions;

  /**
   * The cached value of the '{@link #getBodies() <em>Bodies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBodies()
   * @generated
   * @ordered
   */
  protected EList<SpecificationCS> bodies;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationContextDeclCSImpl()
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
    return TRCPackage.Literals.OPERATION_CONTEXT_DECL_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathNameCS getPathName()
  {
    return pathName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs)
  {
    PathNameCS oldPathName = pathName;
    pathName = newPathName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME, oldPathName, newPathName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPathName(PathNameCS newPathName)
  {
    if (newPathName != pathName)
    {
      NotificationChain msgs = null;
      if (pathName != null)
        msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME, null, msgs);
      if (newPathName != null)
        msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME, null, msgs);
      msgs = basicSetPathName(newPathName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME, newPathName, newPathName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterCS> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, TRCPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedRefCS getOwnedType()
  {
    return ownedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedType(TypedRefCS newOwnedType, NotificationChain msgs)
  {
    TypedRefCS oldOwnedType = ownedType;
    ownedType = newOwnedType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedType(TypedRefCS newOwnedType)
  {
    if (newOwnedType != ownedType)
    {
      NotificationChain msgs = null;
      if (ownedType != null)
        msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE, null, msgs);
      if (newOwnedType != null)
        msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE, null, msgs);
      msgs = basicSetOwnedType(newOwnedType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE, newOwnedType, newOwnedType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintCS> getPreconditions()
  {
    if (preconditions == null)
    {
      preconditions = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, TRCPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS);
    }
    return preconditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintCS> getPostconditions()
  {
    if (postconditions == null)
    {
      postconditions = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, TRCPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS);
    }
    return postconditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SpecificationCS> getBodies()
  {
    if (bodies == null)
    {
      bodies = new EObjectContainmentEList<SpecificationCS>(SpecificationCS.class, this, TRCPackage.OPERATION_CONTEXT_DECL_CS__BODIES);
    }
    return bodies;
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
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME:
        return basicSetPathName(null, msgs);
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE:
        return basicSetOwnedType(null, msgs);
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
        return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
        return ((InternalEList<?>)getPostconditions()).basicRemove(otherEnd, msgs);
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
        return ((InternalEList<?>)getBodies()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME:
        return getPathName();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
        return getParameters();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE:
        return getOwnedType();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
        return getPreconditions();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
        return getPostconditions();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
        return getBodies();
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
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME:
        setPathName((PathNameCS)newValue);
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ParameterCS>)newValue);
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE:
        setOwnedType((TypedRefCS)newValue);
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
        getPreconditions().clear();
        getPreconditions().addAll((Collection<? extends ConstraintCS>)newValue);
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
        getPostconditions().clear();
        getPostconditions().addAll((Collection<? extends ConstraintCS>)newValue);
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
        getBodies().clear();
        getBodies().addAll((Collection<? extends SpecificationCS>)newValue);
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
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME:
        setPathName((PathNameCS)null);
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
        getParameters().clear();
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE:
        setOwnedType((TypedRefCS)null);
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
        getPreconditions().clear();
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
        getPostconditions().clear();
        return;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
        getBodies().clear();
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
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PATH_NAME:
        return pathName != null;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__OWNED_TYPE:
        return ownedType != null;
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
        return preconditions != null && !preconditions.isEmpty();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
        return postconditions != null && !postconditions.isEmpty();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
        return bodies != null && !bodies.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OperationContextDeclCSImpl
