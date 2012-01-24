/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.transformation.hooks.ATLHooks ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EPackage ;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.ATLHooksFactory
 * @model kind="package"
 * @generated
 */
public interface ATLHooksPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "ATLHooks" ;

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://fr.tpt.aadl.transformation.atl.hooks" ;

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "ATLHooks" ;

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  ATLHooksPackage eINSTANCE =
        fr.tpt.aadl.transformation.hooks.ATLHooks.impl.ATLHooksPackageImpl.init() ;

  /**
	 * The meta object id for the '{@link fr.tpt.aadl.transformation.hooks.ATLHooks.impl.HookAccessImpl <em>Hook Access</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.impl.HookAccessImpl
	 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.impl.ATLHooksPackageImpl#getHookAccess()
	 * @generated
	 */
  int HOOK_ACCESS = 0 ;

  /**
	 * The number of structural features of the '<em>Hook Access</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int HOOK_ACCESS_FEATURE_COUNT = 0 ;

  /**
	 * Returns the meta object for class '{@link fr.tpt.aadl.transformation.hooks.ATLHooks.HookAccess <em>Hook Access</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hook Access</em>'.
	 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.HookAccess
	 * @generated
	 */
  EClass getHookAccess() ;

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  ATLHooksFactory getATLHooksFactory() ;

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link fr.tpt.aadl.transformation.hooks.ATLHooks.impl.HookAccessImpl <em>Hook Access</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.impl.HookAccessImpl
		 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.impl.ATLHooksPackageImpl#getHookAccess()
		 * @generated
		 */
    EClass HOOK_ACCESS = eINSTANCE.getHookAccess() ;

  }

} //ATLHooksPackage
