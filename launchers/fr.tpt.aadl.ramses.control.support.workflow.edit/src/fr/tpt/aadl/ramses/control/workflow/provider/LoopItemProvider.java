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
package fr.tpt.aadl.ramses.control.workflow.provider;


import java.util.Collection ;
import java.util.List ;

import org.eclipse.emf.common.notify.AdapterFactory ;
import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.ecore.EStructuralFeature ;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory ;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider ;
import org.eclipse.emf.edit.provider.IItemLabelProvider ;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor ;
import org.eclipse.emf.edit.provider.IItemPropertySource ;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider ;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider ;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor ;
import org.eclipse.emf.edit.provider.ViewerNotification ;

import fr.tpt.aadl.ramses.control.workflow.Loop ;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage ;

/**
 * This is the item provider adapter for a {@link fr.tpt.aadl.ramses.control.workflow.Loop} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LoopItemProvider
  extends WorkflowElementItemProvider
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addAlternativesPropertyDescriptor(object);
      addResolutionMethodPropertyDescriptor(object);
      addMaxNbIterationPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Alternatives feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAlternativesPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Loop_alternatives_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Loop_alternatives_feature", "_UI_Loop_type"),
         WorkflowPackage.Literals.LOOP__ALTERNATIVES,
         true,
         true,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Resolution Method feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addResolutionMethodPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Loop_resolutionMethod_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Loop_resolutionMethod_feature", "_UI_Loop_type"),
         WorkflowPackage.Literals.LOOP__RESOLUTION_METHOD,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Max Nb Iteration feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMaxNbIterationPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Loop_maxNbIteration_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Loop_maxNbIteration_feature", "_UI_Loop_type"),
         WorkflowPackage.Literals.LOOP__MAX_NB_ITERATION,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(WorkflowPackage.Literals.LOOP__ANALYSIS);
      childrenFeatures.add(WorkflowPackage.Literals.LOOP__OUTPUT_MODEL_IDENTIFIER);
      childrenFeatures.add(WorkflowPackage.Literals.LOOP__FOUND_OPTION);
      childrenFeatures.add(WorkflowPackage.Literals.LOOP__NOT_FOUND_OPTION);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns Loop.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Loop"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    ResolutionMethod labelValue = ((Loop)object).getResolutionMethod();
    String label = labelValue == null ? null : labelValue.toString();
    return label == null || label.length() == 0 ?
      getString("_UI_Loop_type") :
      getString("_UI_Loop_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(Loop.class))
    {
      case WorkflowPackage.LOOP__RESOLUTION_METHOD:
      case WorkflowPackage.LOOP__MAX_NB_ITERATION:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case WorkflowPackage.LOOP__ANALYSIS:
      case WorkflowPackage.LOOP__OUTPUT_MODEL_IDENTIFIER:
      case WorkflowPackage.LOOP__FOUND_OPTION:
      case WorkflowPackage.LOOP__NOT_FOUND_OPTION:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.LOOP__ANALYSIS,
         WorkflowFactory.eINSTANCE.createConjunction()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.LOOP__ANALYSIS,
         WorkflowFactory.eINSTANCE.createDisjunction()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.LOOP__ANALYSIS,
         WorkflowFactory.eINSTANCE.createAnalysis()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.LOOP__OUTPUT_MODEL_IDENTIFIER,
         WorkflowFactory.eINSTANCE.createModelIdentifier()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.LOOP__FOUND_OPTION,
         WorkflowFactory.eINSTANCE.createAnalysisOption()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.LOOP__NOT_FOUND_OPTION,
         WorkflowFactory.eINSTANCE.createAnalysisOption()));
  }

  /**
   * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection)
  {
    Object childFeature = feature;
    Object childObject = child;

    boolean qualify =
      childFeature == WorkflowPackage.Literals.LOOP__FOUND_OPTION ||
      childFeature == WorkflowPackage.Literals.LOOP__NOT_FOUND_OPTION;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
