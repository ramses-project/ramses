/**
 */
package fr.tpt.aadl.ramses.transformation.trc.provider;


import fr.tpt.aadl.ramses.transformation.trc.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RuleDependencyItemProvider
	extends AbstractRuleDependencyItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RuleDependencyItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

	/**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addVariableIdPropertyDescriptor(object);
      addFieldNamesPropertyDescriptor(object);
      addRequiredTransformationPropertyDescriptor(object);
      addRequiredRulePropertyDescriptor(object);
      addIsExclusionPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

	/**
   * This adds a property descriptor for the Variable Id feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addVariableIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RuleDependency_variableId_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RuleDependency_variableId_feature", "_UI_RuleDependency_type"),
         TrcPackage.Literals.RULE_DEPENDENCY__VARIABLE_ID,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Field Names feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addFieldNamesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RuleDependency_fieldNames_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RuleDependency_fieldNames_feature", "_UI_RuleDependency_type"),
         TrcPackage.Literals.RULE_DEPENDENCY__FIELD_NAMES,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Required Transformation feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addRequiredTransformationPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RuleDependency_requiredTransformation_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RuleDependency_requiredTransformation_feature", "_UI_RuleDependency_type"),
         TrcPackage.Literals.RULE_DEPENDENCY__REQUIRED_TRANSFORMATION,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Required Rule feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addRequiredRulePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RuleDependency_requiredRule_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RuleDependency_requiredRule_feature", "_UI_RuleDependency_type"),
         TrcPackage.Literals.RULE_DEPENDENCY__REQUIRED_RULE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Is Exclusion feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addIsExclusionPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RuleDependency_isExclusion_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RuleDependency_isExclusion_feature", "_UI_RuleDependency_type"),
         TrcPackage.Literals.RULE_DEPENDENCY__IS_EXCLUSION,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

	/**
   * This returns RuleDependency.gif.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/RuleDependency"));
  }

	/**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public String getText(Object object) {
    RuleDependency ruleDependency = (RuleDependency)object;
    return getString("_UI_RuleDependency_type") + " " + ruleDependency.getVariableId();
  }

	/**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(RuleDependency.class))
    {
      case TrcPackage.RULE_DEPENDENCY__VARIABLE_ID:
      case TrcPackage.RULE_DEPENDENCY__FIELD_NAMES:
      case TrcPackage.RULE_DEPENDENCY__REQUIRED_RULE:
      case TrcPackage.RULE_DEPENDENCY__IS_EXCLUSION:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors , Object object ) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

}
