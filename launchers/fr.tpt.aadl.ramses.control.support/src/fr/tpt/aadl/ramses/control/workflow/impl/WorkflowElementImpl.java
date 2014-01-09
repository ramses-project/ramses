/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow.impl;

import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import fr.tpt.aadl.ramses.control.workflow.WorkflowElement;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;
import org.eclipse.emf.common.notify.Notification;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowElementImpl#getInputModelIdentifier <em>Input Model Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkflowElementImpl extends EObjectImpl implements WorkflowElement {
	/**
	 * The cached value of the '{@link #getInputModelIdentifier() <em>Input Model Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputModelIdentifier()
	 * @generated
	 * @ordered
	 */
	protected ModelIdentifier inputModelIdentifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.WORKFLOW_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelIdentifier getInputModelIdentifier() {
		if (inputModelIdentifier != null && inputModelIdentifier.eIsProxy()) {
			InternalEObject oldInputModelIdentifier = (InternalEObject)inputModelIdentifier;
			inputModelIdentifier = (ModelIdentifier)eResolveProxy(oldInputModelIdentifier);
			if (inputModelIdentifier != oldInputModelIdentifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER, oldInputModelIdentifier, inputModelIdentifier));
			}
		}
		return inputModelIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelIdentifier basicGetInputModelIdentifier() {
		return inputModelIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputModelIdentifier(ModelIdentifier newInputModelIdentifier) {
		ModelIdentifier oldInputModelIdentifier = inputModelIdentifier;
		inputModelIdentifier = newInputModelIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER, oldInputModelIdentifier, inputModelIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER:
				if (resolve) return getInputModelIdentifier();
				return basicGetInputModelIdentifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowPackage.WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER:
				setInputModelIdentifier((ModelIdentifier)newValue);
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
		switch (featureID) {
			case WorkflowPackage.WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER:
				setInputModelIdentifier((ModelIdentifier)null);
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
		switch (featureID) {
			case WorkflowPackage.WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER:
				return inputModelIdentifier != null;
		}
		return super.eIsSet(featureID);
	}

} //WorkflowElementImpl
