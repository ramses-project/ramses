/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.instance.ComponentInstance;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reduced Thread BA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedThreadBAImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedThreadBAImpl#getThread <em>Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReducedThreadBAImpl extends EObjectImpl implements ReducedThreadBA {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadBehaviorElement> elements;

	/**
	 * The cached value of the '{@link #getThread() <em>Thread</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThread()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance thread;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReducedThreadBAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReducedbaPackage.Literals.REDUCED_THREAD_BA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadBehaviorElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<ThreadBehaviorElement>(ThreadBehaviorElement.class, this, ReducedbaPackage.REDUCED_THREAD_BA__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getThread() {
		if (thread != null && thread.eIsProxy()) {
			InternalEObject oldThread = (InternalEObject)thread;
			thread = (ComponentInstance)eResolveProxy(oldThread);
			if (thread != oldThread) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReducedbaPackage.REDUCED_THREAD_BA__THREAD, oldThread, thread));
			}
		}
		return thread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetThread() {
		return thread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThread(ComponentInstance newThread) {
		ComponentInstance oldThread = thread;
		thread = newThread;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReducedbaPackage.REDUCED_THREAD_BA__THREAD, oldThread, thread));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReducedbaPackage.REDUCED_THREAD_BA__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReducedbaPackage.REDUCED_THREAD_BA__ELEMENTS:
				return getElements();
			case ReducedbaPackage.REDUCED_THREAD_BA__THREAD:
				if (resolve) return getThread();
				return basicGetThread();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReducedbaPackage.REDUCED_THREAD_BA__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ThreadBehaviorElement>)newValue);
				return;
			case ReducedbaPackage.REDUCED_THREAD_BA__THREAD:
				setThread((ComponentInstance)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ReducedbaPackage.REDUCED_THREAD_BA__ELEMENTS:
				getElements().clear();
				return;
			case ReducedbaPackage.REDUCED_THREAD_BA__THREAD:
				setThread((ComponentInstance)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ReducedbaPackage.REDUCED_THREAD_BA__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case ReducedbaPackage.REDUCED_THREAD_BA__THREAD:
				return thread != null;
		}
		return super.eIsSet(featureID);
	}

} //ReducedThreadBAImpl
