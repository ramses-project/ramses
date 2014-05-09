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
import org.eclipse.emf.common.util.ResourceLocator ;
import org.eclipse.emf.ecore.EStructuralFeature ;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider ;
import org.eclipse.emf.edit.provider.IItemLabelProvider ;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor ;
import org.eclipse.emf.edit.provider.IItemPropertySource ;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider ;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider ;
import org.eclipse.emf.edit.provider.ItemProviderAdapter ;
import org.eclipse.emf.edit.provider.ViewerNotification ;

import fr.tpt.aadl.ramses.control.workflow.Workflow ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage ;

/**
 * This is the item provider adapter for a {@link fr.tpt.aadl.ramses.control.workflow.Workflow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowItemProvider
  extends ItemProviderAdapter
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
  public WorkflowItemProvider(AdapterFactory adapterFactory)
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

    }
    return itemPropertyDescriptors;
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
      childrenFeatures.add(WorkflowPackage.Literals.WORKFLOW__ELEMENT);
      childrenFeatures.add(WorkflowPackage.Literals.WORKFLOW__INPUT_MODEL_IDENTIFIER);
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
   * This returns Workflow.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Workflow"));
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
    return getString("_UI_Workflow_type");
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

    switch (notification.getFeatureID(Workflow.class))
    {
      case WorkflowPackage.WORKFLOW__ELEMENT:
      case WorkflowPackage.WORKFLOW__INPUT_MODEL_IDENTIFIER:
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
        (WorkflowPackage.Literals.WORKFLOW__ELEMENT,
         WorkflowFactory.eINSTANCE.createTransformation()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.WORKFLOW__ELEMENT,
         WorkflowFactory.eINSTANCE.createGeneration()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.WORKFLOW__ELEMENT,
         WorkflowFactory.eINSTANCE.createAnalysis()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.WORKFLOW__ELEMENT,
         WorkflowFactory.eINSTANCE.createUnparse()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.WORKFLOW__ELEMENT,
         WorkflowFactory.eINSTANCE.createLoop()));

    newChildDescriptors.add
      (createChildParameter
        (WorkflowPackage.Literals.WORKFLOW__INPUT_MODEL_IDENTIFIER,
         WorkflowFactory.eINSTANCE.createModelIdentifier()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return RamsesWorkflowEditPlugin.INSTANCE;
  }

}
