/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleTypeCSImpl#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleTypeCSImpl extends TypeLiteralCSImpl implements TupleTypeCS
{
  /**
   * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedParts()
   * @generated
   * @ordered
   */
  protected EList<TuplePartCS> ownedParts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TupleTypeCSImpl()
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
    return TRCPackage.Literals.TUPLE_TYPE_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TuplePartCS> getOwnedParts()
  {
    if (ownedParts == null)
    {
      ownedParts = new EObjectContainmentEList<TuplePartCS>(TuplePartCS.class, this, TRCPackage.TUPLE_TYPE_CS__OWNED_PARTS);
    }
    return ownedParts;
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
      case TRCPackage.TUPLE_TYPE_CS__OWNED_PARTS:
        return ((InternalEList<?>)getOwnedParts()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.TUPLE_TYPE_CS__OWNED_PARTS:
        return getOwnedParts();
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
      case TRCPackage.TUPLE_TYPE_CS__OWNED_PARTS:
        getOwnedParts().clear();
        getOwnedParts().addAll((Collection<? extends TuplePartCS>)newValue);
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
      case TRCPackage.TUPLE_TYPE_CS__OWNED_PARTS:
        getOwnedParts().clear();
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
      case TRCPackage.TUPLE_TYPE_CS__OWNED_PARTS:
        return ownedParts != null && !ownedParts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TupleTypeCSImpl
