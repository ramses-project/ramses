/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.transformation.hooks.ATLHooks.impl ;

import fr.tpt.aadl.transformation.hooks.ATLHooks.* ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.EPackage ;

import org.eclipse.emf.ecore.impl.EFactoryImpl ;

import org.eclipse.emf.ecore.plugin.EcorePlugin ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ATLHooksFactoryImpl extends EFactoryImpl implements
                                                     ATLHooksFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ATLHooksFactory init()
  {
		try {
			ATLHooksFactory theATLHooksFactory = (ATLHooksFactory)EPackage.Registry.INSTANCE.getEFactory("http://fr.tpt.aadl.transformation.atl.hooks"); 
			if (theATLHooksFactory != null) {
				return theATLHooksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ATLHooksFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ATLHooksFactoryImpl()
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
		switch (eClass.getClassifierID()) {
			case ATLHooksPackage.HOOK_ACCESS: return createHookAccess();
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
  public ATLHooksPackage getATLHooksPackage()
  {
		return (ATLHooksPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static ATLHooksPackage getPackage()
  {
		return ATLHooksPackage.eINSTANCE;
	}

} //ATLHooksFactoryImpl
