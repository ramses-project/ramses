/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.ModuleList#getModules <em>Modules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getModuleList()
 * @model
 * @generated
 */
public interface ModuleList extends EObject
{
  /**
   * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.Module}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getModuleList_Modules()
   * @model containment="true"
   * @generated
   */
  EList<Module> getModules();

} // ModuleList
