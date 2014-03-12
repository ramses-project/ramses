/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.control.workflow.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import fr.tpt.aadl.ramses.control.workflow.Unparse;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unparse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.UnparseImpl#getElement <em>Element</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.UnparseImpl#getOutputModelIdentifier <em>Output Model Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnparseImpl extends WorkflowElementImpl implements Unparse {
	/**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
	protected AnalysisElement element;

	/**
   * The cached value of the '{@link #getOutputModelIdentifier() <em>Output Model Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOutputModelIdentifier()
   * @generated
   * @ordered
   */
	protected ModelIdentifier outputModelIdentifier;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected UnparseImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected EClass eStaticClass() {
    return WorkflowPackage.Literals.UNPARSE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AnalysisElement getElement() {
    return element;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetElement(AnalysisElement newElement, NotificationChain msgs) {
    AnalysisElement oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.UNPARSE__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setElement(AnalysisElement newElement) {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.UNPARSE__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.UNPARSE__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.UNPARSE__ELEMENT, newElement, newElement));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ModelIdentifier getOutputModelIdentifier() {
    return outputModelIdentifier;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetOutputModelIdentifier(ModelIdentifier newOutputModelIdentifier, NotificationChain msgs) {
    ModelIdentifier oldOutputModelIdentifier = outputModelIdentifier;
    outputModelIdentifier = newOutputModelIdentifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER, oldOutputModelIdentifier, newOutputModelIdentifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOutputModelIdentifier(ModelIdentifier newOutputModelIdentifier) {
    if (newOutputModelIdentifier != outputModelIdentifier)
    {
      NotificationChain msgs = null;
      if (outputModelIdentifier != null)
        msgs = ((InternalEObject)outputModelIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER, null, msgs);
      if (newOutputModelIdentifier != null)
        msgs = ((InternalEObject)newOutputModelIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER, null, msgs);
      msgs = basicSetOutputModelIdentifier(newOutputModelIdentifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER, newOutputModelIdentifier, newOutputModelIdentifier));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case WorkflowPackage.UNPARSE__ELEMENT:
        return basicSetElement(null, msgs);
      case WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER:
        return basicSetOutputModelIdentifier(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case WorkflowPackage.UNPARSE__ELEMENT:
        return getElement();
      case WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER:
        return getOutputModelIdentifier();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case WorkflowPackage.UNPARSE__ELEMENT:
        setElement((AnalysisElement)newValue);
        return;
      case WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER:
        setOutputModelIdentifier((ModelIdentifier)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case WorkflowPackage.UNPARSE__ELEMENT:
        setElement((AnalysisElement)null);
        return;
      case WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER:
        setOutputModelIdentifier((ModelIdentifier)null);
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case WorkflowPackage.UNPARSE__ELEMENT:
        return element != null;
      case WorkflowPackage.UNPARSE__OUTPUT_MODEL_IDENTIFIER:
        return outputModelIdentifier != null;
    }
    return super.eIsSet(featureID);
  }

} //UnparseImpl
