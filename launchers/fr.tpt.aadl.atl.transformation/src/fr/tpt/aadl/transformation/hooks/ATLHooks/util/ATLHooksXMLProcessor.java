/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.transformation.hooks.ATLHooks.util ;

import fr.tpt.aadl.transformation.hooks.ATLHooks.ATLHooksPackage ;

import java.util.Map ;

import org.eclipse.emf.ecore.EPackage ;

import org.eclipse.emf.ecore.resource.Resource ;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor ;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ATLHooksXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ATLHooksXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE)) ;
    ATLHooksPackage.eINSTANCE.eClass() ;
  }

  /**
   * Register for "*" and "xml" file extensions the ATLHooksResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if(registrations == null)
    {
      super.getRegistrations() ;
      registrations.put(XML_EXTENSION, new ATLHooksResourceFactoryImpl()) ;
      registrations.put(STAR_EXTENSION, new ATLHooksResourceFactoryImpl()) ;
    }

    return registrations ;
  }

} //ATLHooksXMLProcessor
