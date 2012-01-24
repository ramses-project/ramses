/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.transformation.atl.hooks.impl;

import fr.tpt.aadl.ramses.transformation.atl.hooks.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AtlHooksFactoryImpl extends EFactoryImpl implements AtlHooksFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AtlHooksFactory init()
  {
    try
    {
      AtlHooksFactory theAtlHooksFactory = (AtlHooksFactory)EPackage.Registry.INSTANCE.getEFactory("http://fr.tpt.aadl.ramses.transformation.atl.launch"); 
      if (theAtlHooksFactory != null)
      {
        return theAtlHooksFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AtlHooksFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtlHooksFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AtlHooksPackage.HOOK_ACCESS: return createHookAccess();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HookAccess createHookAccess()
  {
    HookAccessImpl hookAccess = new HookAccessImpl();
    return hookAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtlHooksPackage getAtlHooksPackage()
  {
    return (AtlHooksPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AtlHooksPackage getPackage()
  {
    return AtlHooksPackage.eINSTANCE;
  }

} //AtlHooksFactoryImpl
