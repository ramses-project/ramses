/**
 */
package fr.tpt.aadl.ramses.transformation.tip.impl;

import fr.tpt.aadl.ramses.transformation.tip.Iteration;
import fr.tpt.aadl.ramses.transformation.tip.TipPackage;
import fr.tpt.aadl.ramses.transformation.tip.TipSpecification;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;

import fr.tpt.aadl.ramses.transformation.tip.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.impl.TipSpecificationImpl#getIterations <em>Iterations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.impl.TipSpecificationImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.impl.TipSpecificationImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TipSpecificationImpl extends EObjectImpl implements TipSpecification {
	/**
   * The cached value of the '{@link #getIterations() <em>Iterations</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIterations()
   * @generated
   * @ordered
   */
	protected EList iterations;

	/**
   * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getProjectName()
   * @generated
   * @ordered
   */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getProjectName()
   * @generated
   * @ordered
   */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
	protected static final String VERSION_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
	protected String version = VERSION_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TipSpecificationImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected EClass eStaticClass() {
    return TipPackage.Literals.TIP_SPECIFICATION;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList getIterations() {
    if (iterations == null)
    {
      iterations = new EObjectContainmentEList(Iteration.class, this, TipPackage.TIP_SPECIFICATION__ITERATIONS);
    }
    return iterations;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getProjectName() {
    return projectName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setProjectName(String newProjectName) {
    String oldProjectName = projectName;
    projectName = newProjectName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TipPackage.TIP_SPECIFICATION__PROJECT_NAME, oldProjectName, projectName));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getVersion() {
    return version;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setVersion(String newVersion) {
    String oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TipPackage.TIP_SPECIFICATION__VERSION, oldVersion, version));
  }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName(DynamicEObjectImpl ref) {
		if(ref instanceof InstanceObject)
		{
			InstanceObject iobj = (InstanceObject) ref;
			return iobj.getInstanceObjectPath();
		}
		else
		if(ref instanceof NamedElement)
			return ((NamedElement)ref).getQualifiedName();
		return null;
	}

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case TipPackage.TIP_SPECIFICATION__ITERATIONS:
        return ((InternalEList)getIterations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case TipPackage.TIP_SPECIFICATION__ITERATIONS:
        return getIterations();
      case TipPackage.TIP_SPECIFICATION__PROJECT_NAME:
        return getProjectName();
      case TipPackage.TIP_SPECIFICATION__VERSION:
        return getVersion();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case TipPackage.TIP_SPECIFICATION__ITERATIONS:
        getIterations().clear();
        getIterations().addAll((Collection)newValue);
        return;
      case TipPackage.TIP_SPECIFICATION__PROJECT_NAME:
        setProjectName((String)newValue);
        return;
      case TipPackage.TIP_SPECIFICATION__VERSION:
        setVersion((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case TipPackage.TIP_SPECIFICATION__ITERATIONS:
        getIterations().clear();
        return;
      case TipPackage.TIP_SPECIFICATION__PROJECT_NAME:
        setProjectName(PROJECT_NAME_EDEFAULT);
        return;
      case TipPackage.TIP_SPECIFICATION__VERSION:
        setVersion(VERSION_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case TipPackage.TIP_SPECIFICATION__ITERATIONS:
        return iterations != null && !iterations.isEmpty();
      case TipPackage.TIP_SPECIFICATION__PROJECT_NAME:
        return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
      case TipPackage.TIP_SPECIFICATION__VERSION:
        return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (projectName: ");
    result.append(projectName);
    result.append(", version: ");
    result.append(version);
    result.append(')');
    return result.toString();
  }

} //TipSpecificationImpl
