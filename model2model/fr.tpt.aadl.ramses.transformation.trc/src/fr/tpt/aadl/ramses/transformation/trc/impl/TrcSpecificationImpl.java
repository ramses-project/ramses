/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.ModuleList;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList;
import fr.tpt.aadl.ramses.transformation.trc.TransformationList;
import fr.tpt.aadl.ramses.transformation.trc.TrcFactory ;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTuple ;

import java.util.Collection;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osate.aadl2.instance.SystemInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl#getTransformationList <em>Transformation List</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl#getDependencyList <em>Dependency List</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl#getModuleList <em>Module List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrcSpecificationImpl extends EObjectImpl implements TrcSpecification
{
  /**
	 * The cached value of the '{@link #getTransformationList() <em>Transformation List</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTransformationList()
	 * @generated
	 * @ordered
	 */
  protected TransformationList transformationList;

  /**
	 * The cached value of the '{@link #getDependencyList() <em>Dependency List</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDependencyList()
	 * @generated
	 * @ordered
	 */
  protected TransformationDependencyList dependencyList;

  /**
	 * The cached value of the '{@link #getModuleList() <em>Module List</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getModuleList()
	 * @generated
	 * @ordered
	 */
  protected ModuleList moduleList;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TrcSpecificationImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return TrcPackage.Literals.TRC_SPECIFICATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TransformationList getTransformationList()
  {
		return transformationList;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTransformationList(TransformationList newTransformationList, NotificationChain msgs)
  {
		TransformationList oldTransformationList = transformationList;
		transformationList = newTransformationList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST, oldTransformationList, newTransformationList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTransformationList(TransformationList newTransformationList)
  {
		if (newTransformationList != transformationList) {
			NotificationChain msgs = null;
			if (transformationList != null)
				msgs = ((InternalEObject)transformationList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST, null, msgs);
			if (newTransformationList != null)
				msgs = ((InternalEObject)newTransformationList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST, null, msgs);
			msgs = basicSetTransformationList(newTransformationList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST, newTransformationList, newTransformationList));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TransformationDependencyList getDependencyList()
  {
		return dependencyList;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetDependencyList(TransformationDependencyList newDependencyList, NotificationChain msgs)
  {
		TransformationDependencyList oldDependencyList = dependencyList;
		dependencyList = newDependencyList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST, oldDependencyList, newDependencyList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDependencyList(TransformationDependencyList newDependencyList)
  {
		if (newDependencyList != dependencyList) {
			NotificationChain msgs = null;
			if (dependencyList != null)
				msgs = ((InternalEObject)dependencyList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST, null, msgs);
			if (newDependencyList != null)
				msgs = ((InternalEObject)newDependencyList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST, null, msgs);
			msgs = basicSetDependencyList(newDependencyList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST, newDependencyList, newDependencyList));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ModuleList getModuleList()
  {
		return moduleList;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetModuleList(ModuleList newModuleList, NotificationChain msgs)
  {
		ModuleList oldModuleList = moduleList;
		moduleList = newModuleList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__MODULE_LIST, oldModuleList, newModuleList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setModuleList(ModuleList newModuleList)
  {
		if (newModuleList != moduleList) {
			NotificationChain msgs = null;
			if (moduleList != null)
				msgs = ((InternalEObject)moduleList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__MODULE_LIST, null, msgs);
			if (newModuleList != null)
				msgs = ((InternalEObject)newModuleList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__MODULE_LIST, null, msgs);
			msgs = basicSetModuleList(newModuleList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__MODULE_LIST, newModuleList, newModuleList));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
				return basicSetTransformationList(null, msgs);
			case TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
				return basicSetDependencyList(null, msgs);
			case TrcPackage.TRC_SPECIFICATION__MODULE_LIST:
				return basicSetModuleList(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
				return getTransformationList();
			case TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
				return getDependencyList();
			case TrcPackage.TRC_SPECIFICATION__MODULE_LIST:
				return getModuleList();
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
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
				setTransformationList((TransformationList)newValue);
				return;
			case TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
				setDependencyList((TransformationDependencyList)newValue);
				return;
			case TrcPackage.TRC_SPECIFICATION__MODULE_LIST:
				setModuleList((ModuleList)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
				setTransformationList((TransformationList)null);
				return;
			case TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
				setDependencyList((TransformationDependencyList)null);
				return;
			case TrcPackage.TRC_SPECIFICATION__MODULE_LIST:
				setModuleList((ModuleList)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case TrcPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
				return transformationList != null;
			case TrcPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
				return dependencyList != null;
			case TrcPackage.TRC_SPECIFICATION__MODULE_LIST:
				return moduleList != null;
		}
		return super.eIsSet(featureID);
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  Map<String, TrcRule> rulesMap = 
      new HashMap<String, TrcRule>();
  
  @Override
  public synchronized TrcRule getTrcRule(String value)
  {
	
    if(rulesMap.containsKey(value))
      return rulesMap.get(value) ;
    else
    {
      String prefix = value;
      if(prefix.contains("."))
        prefix = prefix.substring(0, prefix.indexOf('.'));
      Module trcModule=null;
      for(Module m: this.getModuleList().getModules())
      {
        String trcPrefix = m.getName();
        if(false==prefix.equals(trcPrefix))
        {
          continue;
        }
        trcModule = m;
        for(TrcRule r:m.getRules())
        {
          String qualifiedName = trcPrefix+'.'+r.getName(); 
          if(qualifiedName.equals(value))
          {
            rulesMap.put(value, r);
            return r;
          }
        }
      }
      if(trcModule==null)
      {
        trcModule = TrcFactory.eINSTANCE.createModule();
        this.getModuleList().getModules().add(trcModule);
        trcModule.setName(prefix);
      }
      TrcRule r = TrcFactory.eINSTANCE.createTrcRule();
      String ruleName = value;
      if(ruleName.contains("."))
    	  ruleName = ruleName.substring(ruleName.indexOf('.')+1, ruleName.length());
      r.setName(ruleName);
      trcModule.getRules().add(r);
      rulesMap.put(value, r);
      return r;
    }
  }

  
  Map<List<EObject>, Map<TrcRule, List<List<TaggedRuleApplicationTuple>>>> normalizedDependencyMap
    = new HashMap<List<EObject>, Map<TrcRule, List<List<TaggedRuleApplicationTuple>>>>();
  
    
  
  @Override
  public List<List<TaggedRuleApplicationTuple>>
      getNormalizedDependencies(List<EObject> eObjList, TrcRule appliedRule)
  {
    if(normalizedDependencyMap.get(eObjList)==null)
      return null;
    return normalizedDependencyMap.get(eObjList).get(appliedRule);
  }

  @Override
  public void
      addNormalizedDependencies(List<EObject> eObjList, 
                                TrcRule appliedRule,
                                List<List<TaggedRuleApplicationTuple>> depList)
  {
    if(normalizedDependencyMap.get(eObjList) == null)
    {
      Map<TrcRule, List<List<TaggedRuleApplicationTuple>>> newMap = 
          new HashMap<TrcRule, List<List<TaggedRuleApplicationTuple>>>();
      newMap.put(appliedRule, depList);
      normalizedDependencyMap.put(eObjList, newMap);
    }
    else
    {
      Map<TrcRule, List<List<TaggedRuleApplicationTuple>>> m =
          normalizedDependencyMap.get(eObjList);
      m.put(appliedRule, depList);
    }
  }

  @Override
  public void cleanup()
  {
    normalizedDependencyMap.clear();
    rulesMap.clear();
  }
  
  

} //TrcSpecificationImpl
