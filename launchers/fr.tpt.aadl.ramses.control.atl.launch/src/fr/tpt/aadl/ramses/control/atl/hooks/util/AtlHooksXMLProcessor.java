/**
 */
package fr.tpt.aadl.ramses.control.atl.hooks.util;

import fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AtlHooksXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtlHooksXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    AtlHooksPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the AtlHooksResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new AtlHooksResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new AtlHooksResourceFactoryImpl());
    }
    return registrations;
  }

} //AtlHooksXMLProcessor
