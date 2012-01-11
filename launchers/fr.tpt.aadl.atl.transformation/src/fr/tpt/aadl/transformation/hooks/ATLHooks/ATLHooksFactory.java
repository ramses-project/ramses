/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.transformation.hooks.ATLHooks ;

import org.eclipse.emf.ecore.EFactory ;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.ATLHooksPackage
 * @generated
 */
public interface ATLHooksFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ATLHooksFactory eINSTANCE =
        fr.tpt.aadl.transformation.hooks.ATLHooks.impl.ATLHooksFactoryImpl
              .init() ;

  /**
   * Returns a new object of class '<em>Hook Access</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hook Access</em>'.
   * @generated
   */
  HookAccess createHookAccess() ;

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ATLHooksPackage getATLHooksPackage() ;

} //ATLHooksFactory
