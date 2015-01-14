/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.ramses.control.workflow.impl;

import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowElement;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowImpl#getElement <em>Element</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowImpl#getInputModelIdentifier <em>Input Model Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowImpl#getRequirementsRoot <em>Requirements Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkflowImpl extends EObjectImpl implements Workflow
{
  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected WorkflowElement element;

  /**
   * The cached value of the '{@link #getInputModelIdentifier() <em>Input Model Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputModelIdentifier()
   * @generated
   * @ordered
   */
  protected ModelIdentifier inputModelIdentifier;

  /**
   * The cached value of the '{@link #getRequirementsRoot() <em>Requirements Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementsRoot()
   * @generated
   * @ordered
   */
  protected EObject requirementsRoot;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WorkflowImpl()
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
    return WorkflowPackage.Literals.WORKFLOW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkflowElement getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(WorkflowElement newElement, NotificationChain msgs)
  {
    WorkflowElement oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(WorkflowElement newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__ELEMENT, newElement, newElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelIdentifier getInputModelIdentifier()
  {
    return inputModelIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInputModelIdentifier(ModelIdentifier newInputModelIdentifier, NotificationChain msgs)
  {
    ModelIdentifier oldInputModelIdentifier = inputModelIdentifier;
    inputModelIdentifier = newInputModelIdentifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER, oldInputModelIdentifier, newInputModelIdentifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInputModelIdentifier(ModelIdentifier newInputModelIdentifier)
  {
    if (newInputModelIdentifier != inputModelIdentifier)
    {
      NotificationChain msgs = null;
      if (inputModelIdentifier != null)
        msgs = ((InternalEObject)inputModelIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER, null, msgs);
      if (newInputModelIdentifier != null)
        msgs = ((InternalEObject)newInputModelIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER, null, msgs);
      msgs = basicSetInputModelIdentifier(newInputModelIdentifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER, newInputModelIdentifier, newInputModelIdentifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getRequirementsRoot()
  {
    if (requirementsRoot != null && requirementsRoot.eIsProxy())
    {
      InternalEObject oldRequirementsRoot = (InternalEObject)requirementsRoot;
      requirementsRoot = eResolveProxy(oldRequirementsRoot);
      if (requirementsRoot != oldRequirementsRoot)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.WORKFLOW__REQUIREMENTS_ROOT, oldRequirementsRoot, requirementsRoot));
      }
    }
    return requirementsRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetRequirementsRoot()
  {
    return requirementsRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequirementsRoot(EObject newRequirementsRoot)
  {
    EObject oldRequirementsRoot = requirementsRoot;
    requirementsRoot = newRequirementsRoot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__REQUIREMENTS_ROOT, oldRequirementsRoot, requirementsRoot));
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
      case WorkflowPackage.WORKFLOW__ELEMENT:
        return basicSetElement(null, msgs);
      case WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER:
        return basicSetInputModelIdentifier(null, msgs);
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
      case WorkflowPackage.WORKFLOW__ELEMENT:
        return getElement();
      case WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER:
        return getInputModelIdentifier();
      case WorkflowPackage.WORKFLOW__REQUIREMENTS_ROOT:
        if (resolve) return getRequirementsRoot();
        return basicGetRequirementsRoot();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WorkflowPackage.WORKFLOW__ELEMENT:
        setElement((WorkflowElement)newValue);
        return;
      case WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER:
        setInputModelIdentifier((ModelIdentifier)newValue);
        return;
      case WorkflowPackage.WORKFLOW__REQUIREMENTS_ROOT:
        setRequirementsRoot((EObject)newValue);
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
      case WorkflowPackage.WORKFLOW__ELEMENT:
        setElement((WorkflowElement)null);
        return;
      case WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER:
        setInputModelIdentifier((ModelIdentifier)null);
        return;
      case WorkflowPackage.WORKFLOW__REQUIREMENTS_ROOT:
        setRequirementsRoot((EObject)null);
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
      case WorkflowPackage.WORKFLOW__ELEMENT:
        return element != null;
      case WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER:
        return inputModelIdentifier != null;
      case WorkflowPackage.WORKFLOW__REQUIREMENTS_ROOT:
        return requirementsRoot != null;
    }
    return super.eIsSet(featureID);
  }

} //WorkflowImpl
