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

import java.util.Collection ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;

import fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis ;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption ;
import fr.tpt.aadl.ramses.control.workflow.List ;
import fr.tpt.aadl.ramses.control.workflow.Loop ;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl#getAnalysis <em>Analysis</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl#isInitialAnalysis <em>Initial Analysis</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl#getOutputModelIdentifier <em>Output Model Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl#getFoundOption <em>Found Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl#getNotFoundOption <em>Not Found Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends WorkflowElementImpl implements Loop {
	/**
	 * The cached value of the '{@link #getAlternatives() <em>Alternatives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternatives()
	 * @generated
	 * @ordered
	 */
	protected EList alternatives;

	/**
	 * The cached value of the '{@link #getAnalysis() <em>Analysis</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysis()
	 * @generated
	 * @ordered
	 */
	protected AbstractAnalysis analysis;

	/**
	 * The default value of the '{@link #isInitialAnalysis() <em>Initial Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialAnalysis()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIAL_ANALYSIS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitialAnalysis() <em>Initial Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialAnalysis()
	 * @generated
	 * @ordered
	 */
	protected boolean initialAnalysis = INITIAL_ANALYSIS_EDEFAULT;

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
	 * The cached value of the '{@link #getFoundOption() <em>Found Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFoundOption()
	 * @generated
	 * @ordered
	 */
	protected AnalysisOption foundOption;

	/**
	 * The cached value of the '{@link #getNotFoundOption() <em>Not Found Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotFoundOption()
	 * @generated
	 * @ordered
	 */
	protected AnalysisOption notFoundOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAlternatives() {
		if (alternatives == null) {
			alternatives = new EObjectContainmentEList(List.class, this, WorkflowPackage.LOOP__ALTERNATIVES);
		}
		return alternatives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAnalysis getAnalysis() {
		return analysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysis(AbstractAnalysis newAnalysis, NotificationChain msgs) {
		AbstractAnalysis oldAnalysis = analysis;
		analysis = newAnalysis;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__ANALYSIS, oldAnalysis, newAnalysis);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysis(AbstractAnalysis newAnalysis) {
		if (newAnalysis != analysis) {
			NotificationChain msgs = null;
			if (analysis != null)
				msgs = ((InternalEObject)analysis).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__ANALYSIS, null, msgs);
			if (newAnalysis != null)
				msgs = ((InternalEObject)newAnalysis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__ANALYSIS, null, msgs);
			msgs = basicSetAnalysis(newAnalysis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__ANALYSIS, newAnalysis, newAnalysis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitialAnalysis() {
		return initialAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialAnalysis(boolean newInitialAnalysis) {
		boolean oldInitialAnalysis = initialAnalysis;
		initialAnalysis = newInitialAnalysis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__INITIAL_ANALYSIS, oldInitialAnalysis, initialAnalysis));
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
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER, oldOutputModelIdentifier, newOutputModelIdentifier);
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
		if (newOutputModelIdentifier != outputModelIdentifier) {
			NotificationChain msgs = null;
			if (outputModelIdentifier != null)
				msgs = ((InternalEObject)outputModelIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER, null, msgs);
			if (newOutputModelIdentifier != null)
				msgs = ((InternalEObject)newOutputModelIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER, null, msgs);
			msgs = basicSetOutputModelIdentifier(newOutputModelIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER, newOutputModelIdentifier, newOutputModelIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisOption getFoundOption() {
		return foundOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFoundOption(AnalysisOption newFoundOption, NotificationChain msgs) {
		AnalysisOption oldFoundOption = foundOption;
		foundOption = newFoundOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__FOUND_OPTION, oldFoundOption, newFoundOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFoundOption(AnalysisOption newFoundOption) {
		if (newFoundOption != foundOption) {
			NotificationChain msgs = null;
			if (foundOption != null)
				msgs = ((InternalEObject)foundOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__FOUND_OPTION, null, msgs);
			if (newFoundOption != null)
				msgs = ((InternalEObject)newFoundOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__FOUND_OPTION, null, msgs);
			msgs = basicSetFoundOption(newFoundOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__FOUND_OPTION, newFoundOption, newFoundOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisOption getNotFoundOption() {
		return notFoundOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotFoundOption(AnalysisOption newNotFoundOption, NotificationChain msgs) {
		AnalysisOption oldNotFoundOption = notFoundOption;
		notFoundOption = newNotFoundOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__NOT_FOUND_OPTION, oldNotFoundOption, newNotFoundOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotFoundOption(AnalysisOption newNotFoundOption) {
		if (newNotFoundOption != notFoundOption) {
			NotificationChain msgs = null;
			if (notFoundOption != null)
				msgs = ((InternalEObject)notFoundOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__NOT_FOUND_OPTION, null, msgs);
			if (newNotFoundOption != null)
				msgs = ((InternalEObject)newNotFoundOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.LOOP__NOT_FOUND_OPTION, null, msgs);
			msgs = basicSetNotFoundOption(newNotFoundOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.LOOP__NOT_FOUND_OPTION, newNotFoundOption, newNotFoundOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.LOOP__ALTERNATIVES:
				return ((InternalEList)getAlternatives()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.LOOP__ANALYSIS:
				return basicSetAnalysis(null, msgs);
			case WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER:
				return basicSetOutputModelIdentifier(null, msgs);
			case WorkflowPackage.LOOP__FOUND_OPTION:
				return basicSetFoundOption(null, msgs);
			case WorkflowPackage.LOOP__NOT_FOUND_OPTION:
				return basicSetNotFoundOption(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.LOOP__ALTERNATIVES:
				return getAlternatives();
			case WorkflowPackage.LOOP__ANALYSIS:
				return getAnalysis();
			case WorkflowPackage.LOOP__INITIAL_ANALYSIS:
				return isInitialAnalysis() ? Boolean.TRUE : Boolean.FALSE;
			case WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER:
				return getOutputModelIdentifier();
			case WorkflowPackage.LOOP__FOUND_OPTION:
				return getFoundOption();
			case WorkflowPackage.LOOP__NOT_FOUND_OPTION:
				return getNotFoundOption();
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
			case WorkflowPackage.LOOP__ALTERNATIVES:
				getAlternatives().clear();
				getAlternatives().addAll((Collection)newValue);
				return;
			case WorkflowPackage.LOOP__ANALYSIS:
				setAnalysis((AbstractAnalysis)newValue);
				return;
			case WorkflowPackage.LOOP__INITIAL_ANALYSIS:
				setInitialAnalysis(((Boolean)newValue).booleanValue());
				return;
			case WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER:
				setOutputModelIdentifier((ModelIdentifier)newValue);
				return;
			case WorkflowPackage.LOOP__FOUND_OPTION:
				setFoundOption((AnalysisOption)newValue);
				return;
			case WorkflowPackage.LOOP__NOT_FOUND_OPTION:
				setNotFoundOption((AnalysisOption)newValue);
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
			case WorkflowPackage.LOOP__ALTERNATIVES:
				getAlternatives().clear();
				return;
			case WorkflowPackage.LOOP__ANALYSIS:
				setAnalysis((AbstractAnalysis)null);
				return;
			case WorkflowPackage.LOOP__INITIAL_ANALYSIS:
				setInitialAnalysis(INITIAL_ANALYSIS_EDEFAULT);
				return;
			case WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER:
				setOutputModelIdentifier((ModelIdentifier)null);
				return;
			case WorkflowPackage.LOOP__FOUND_OPTION:
				setFoundOption((AnalysisOption)null);
				return;
			case WorkflowPackage.LOOP__NOT_FOUND_OPTION:
				setNotFoundOption((AnalysisOption)null);
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
			case WorkflowPackage.LOOP__ALTERNATIVES:
				return alternatives != null && !alternatives.isEmpty();
			case WorkflowPackage.LOOP__ANALYSIS:
				return analysis != null;
			case WorkflowPackage.LOOP__INITIAL_ANALYSIS:
				return initialAnalysis != INITIAL_ANALYSIS_EDEFAULT;
			case WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER:
				return outputModelIdentifier != null;
			case WorkflowPackage.LOOP__FOUND_OPTION:
				return foundOption != null;
			case WorkflowPackage.LOOP__NOT_FOUND_OPTION:
				return notFoundOption != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (initialAnalysis: ");
		result.append(initialAnalysis);
		result.append(')');
		return result.toString();
	}

} //LoopImpl
