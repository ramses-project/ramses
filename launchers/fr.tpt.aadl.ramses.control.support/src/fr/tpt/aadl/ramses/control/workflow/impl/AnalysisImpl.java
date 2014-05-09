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

import fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis;
import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl#getYesOption <em>Yes Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl#getNoOption <em>No Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl#getOutputModelIdentifier <em>Output Model Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnalysisImpl extends WorkflowElementImpl implements Analysis
{
  /**
   * The cached value of the '{@link #getYesOption() <em>Yes Option</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYesOption()
   * @generated
   * @ordered
   */
  protected AnalysisOption yesOption;

  /**
   * The cached value of the '{@link #getNoOption() <em>No Option</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNoOption()
   * @generated
   * @ordered
   */
  protected AnalysisOption noOption;

  /**
   * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected static final String METHOD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected String method = METHOD_EDEFAULT;

  /**
   * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected static final String MODE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected String mode = MODE_EDEFAULT;

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
  protected AnalysisImpl()
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
    return WorkflowPackage.Literals.ANALYSIS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisOption getYesOption()
  {
    return yesOption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetYesOption(AnalysisOption newYesOption, NotificationChain msgs)
  {
    AnalysisOption oldYesOption = yesOption;
    yesOption = newYesOption;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__YES_OPTION, oldYesOption, newYesOption);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setYesOption(AnalysisOption newYesOption)
  {
    if (newYesOption != yesOption)
    {
      NotificationChain msgs = null;
      if (yesOption != null)
        msgs = ((InternalEObject)yesOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ANALYSIS__YES_OPTION, null, msgs);
      if (newYesOption != null)
        msgs = ((InternalEObject)newYesOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ANALYSIS__YES_OPTION, null, msgs);
      msgs = basicSetYesOption(newYesOption, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__YES_OPTION, newYesOption, newYesOption));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisOption getNoOption()
  {
    return noOption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNoOption(AnalysisOption newNoOption, NotificationChain msgs)
  {
    AnalysisOption oldNoOption = noOption;
    noOption = newNoOption;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__NO_OPTION, oldNoOption, newNoOption);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNoOption(AnalysisOption newNoOption)
  {
    if (newNoOption != noOption)
    {
      NotificationChain msgs = null;
      if (noOption != null)
        msgs = ((InternalEObject)noOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ANALYSIS__NO_OPTION, null, msgs);
      if (newNoOption != null)
        msgs = ((InternalEObject)newNoOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ANALYSIS__NO_OPTION, null, msgs);
      msgs = basicSetNoOption(newNoOption, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__NO_OPTION, newNoOption, newNoOption));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethod(String newMethod)
  {
    String oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__METHOD, oldMethod, method));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMode()
  {
    return mode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMode(String newMode)
  {
    String oldMode = mode;
    mode = newMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__MODE, oldMode, mode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelIdentifier getOutputModelIdentifier()
  {
    return outputModelIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutputModelIdentifier(ModelIdentifier newOutputModelIdentifier, NotificationChain msgs)
  {
    ModelIdentifier oldOutputModelIdentifier = outputModelIdentifier;
    outputModelIdentifier = newOutputModelIdentifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER, oldOutputModelIdentifier, newOutputModelIdentifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutputModelIdentifier(ModelIdentifier newOutputModelIdentifier)
  {
    if (newOutputModelIdentifier != outputModelIdentifier)
    {
      NotificationChain msgs = null;
      if (outputModelIdentifier != null)
        msgs = ((InternalEObject)outputModelIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER, null, msgs);
      if (newOutputModelIdentifier != null)
        msgs = ((InternalEObject)newOutputModelIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER, null, msgs);
      msgs = basicSetOutputModelIdentifier(newOutputModelIdentifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER, newOutputModelIdentifier, newOutputModelIdentifier));
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
      case WorkflowPackage.ANALYSIS__YES_OPTION:
        return basicSetYesOption(null, msgs);
      case WorkflowPackage.ANALYSIS__NO_OPTION:
        return basicSetNoOption(null, msgs);
      case WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER:
        return basicSetOutputModelIdentifier(null, msgs);
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
      case WorkflowPackage.ANALYSIS__YES_OPTION:
        return getYesOption();
      case WorkflowPackage.ANALYSIS__NO_OPTION:
        return getNoOption();
      case WorkflowPackage.ANALYSIS__METHOD:
        return getMethod();
      case WorkflowPackage.ANALYSIS__MODE:
        return getMode();
      case WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER:
        return getOutputModelIdentifier();
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
      case WorkflowPackage.ANALYSIS__YES_OPTION:
        setYesOption((AnalysisOption)newValue);
        return;
      case WorkflowPackage.ANALYSIS__NO_OPTION:
        setNoOption((AnalysisOption)newValue);
        return;
      case WorkflowPackage.ANALYSIS__METHOD:
        setMethod((String)newValue);
        return;
      case WorkflowPackage.ANALYSIS__MODE:
        setMode((String)newValue);
        return;
      case WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER:
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
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case WorkflowPackage.ANALYSIS__YES_OPTION:
        setYesOption((AnalysisOption)null);
        return;
      case WorkflowPackage.ANALYSIS__NO_OPTION:
        setNoOption((AnalysisOption)null);
        return;
      case WorkflowPackage.ANALYSIS__METHOD:
        setMethod(METHOD_EDEFAULT);
        return;
      case WorkflowPackage.ANALYSIS__MODE:
        setMode(MODE_EDEFAULT);
        return;
      case WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER:
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
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case WorkflowPackage.ANALYSIS__YES_OPTION:
        return yesOption != null;
      case WorkflowPackage.ANALYSIS__NO_OPTION:
        return noOption != null;
      case WorkflowPackage.ANALYSIS__METHOD:
        return METHOD_EDEFAULT == null ? method != null : !METHOD_EDEFAULT.equals(method);
      case WorkflowPackage.ANALYSIS__MODE:
        return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
      case WorkflowPackage.ANALYSIS__OUTPUT_MODEL_IDENTIFIER:
        return outputModelIdentifier != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == AnalysisElement.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AbstractAnalysis.class)
    {
      switch (derivedFeatureID)
      {
        case WorkflowPackage.ANALYSIS__YES_OPTION: return WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION;
        case WorkflowPackage.ANALYSIS__NO_OPTION: return WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == AnalysisElement.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AbstractAnalysis.class)
    {
      switch (baseFeatureID)
      {
        case WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION: return WorkflowPackage.ANALYSIS__YES_OPTION;
        case WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION: return WorkflowPackage.ANALYSIS__NO_OPTION;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (method: ");
    result.append(method);
    result.append(", mode: ");
    result.append(mode);
    result.append(')');
    return result.toString();
  }

} //AnalysisImpl
