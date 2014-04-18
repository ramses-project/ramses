/**
 */
package fr.tpt.aadl.ramses.constraintsreporter.impl;

import fr.tpt.aadl.ramses.constraintsreporter.reporterFactory;
import fr.tpt.aadl.ramses.constraintsreporter.reporterPackage;

import org.apache.log4j.Logger ;
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
public class reporterFactoryImpl extends EFactoryImpl implements reporterFactory {
	
  private static Logger _LOGGER = Logger.getLogger(reporterFactoryImpl.class) ;
  
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static reporterFactory init() {
		try {
			reporterFactory thereporterFactory = (reporterFactory)EPackage.Registry.INSTANCE.getEFactory(reporterPackage.eNS_URI);
			if (thereporterFactory != null) {
				return thereporterFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new reporterFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public reporterFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case reporterPackage.ERROR: return createError();
			default:
			{
			  String msg = "The class '" + eClass.getName() + "' is not a valid classifier" ;
			  _LOGGER.fatal(msg);
			  throw new IllegalArgumentException(msg);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.tpt.aadl.ramses.constraintsreporter.Error createError() {
		ErrorImpl error = new ErrorImpl();
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public reporterPackage getreporterPackage() {
		return (reporterPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static reporterPackage getPackage() {
		return reporterPackage.eINSTANCE;
	}

} //reporterFactoryImpl
