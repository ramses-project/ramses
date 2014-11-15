/**
 */
package fr.tpt.aadl.ramses.transformation.tip;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.tip.TipFactory
 * @model kind="package"
 * @generated
 */
public interface TipPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "tip";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://fr.tpt.aadl.ramses.transformation/TIP/1.0";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "tip";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	TipPackage eINSTANCE = fr.tpt.aadl.ramses.transformation.tip.impl.TipPackageImpl.init();

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.tip.impl.TipSpecificationImpl <em>Specification</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipSpecificationImpl
   * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipPackageImpl#getTipSpecification()
   * @generated
   */
	int TIP_SPECIFICATION = 0;

	/**
   * The feature id for the '<em><b>Iterations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TIP_SPECIFICATION__ITERATIONS = 0;

	/**
   * The feature id for the '<em><b>Project Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TIP_SPECIFICATION__PROJECT_NAME = 1;

	/**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TIP_SPECIFICATION__VERSION = 2;

	/**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TIP_SPECIFICATION_FEATURE_COUNT = 3;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.tip.impl.IterationImpl <em>Iteration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.tip.impl.IterationImpl
   * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipPackageImpl#getIteration()
   * @generated
   */
	int ITERATION = 1;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITERATION__ID = 0;

	/**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITERATION__ELEMENTS = 1;

	/**
   * The number of structural features of the '<em>Iteration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITERATION_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl <em>Element Transformation</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl
   * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipPackageImpl#getElementTransformation()
   * @generated
   */
	int ELEMENT_TRANSFORMATION = 2;

	/**
   * The feature id for the '<em><b>Element Id</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TRANSFORMATION__ELEMENT_ID = 0;

	/**
   * The feature id for the '<em><b>Element Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TRANSFORMATION__ELEMENT_NAME = 1;

	/**
   * The feature id for the '<em><b>Is Exclusion</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TRANSFORMATION__IS_EXCLUSION = 2;

  /**
   * The feature id for the '<em><b>Transformation Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TRANSFORMATION__TRANSFORMATION_ID = 3;

	/**
   * The number of structural features of the '<em>Element Transformation</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TRANSFORMATION_FEATURE_COUNT = 4;


	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.TipSpecification
   * @generated
   */
	EClass getTipSpecification();

	/**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getIterations <em>Iterations</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Iterations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getIterations()
   * @see #getTipSpecification()
   * @generated
   */
	EReference getTipSpecification_Iterations();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getProjectName <em>Project Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getProjectName()
   * @see #getTipSpecification()
   * @generated
   */
	EAttribute getTipSpecification_ProjectName();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getVersion()
   * @see #getTipSpecification()
   * @generated
   */
	EAttribute getTipSpecification_Version();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.tip.Iteration <em>Iteration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iteration</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.Iteration
   * @generated
   */
	EClass getIteration();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.tip.Iteration#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.Iteration#getId()
   * @see #getIteration()
   * @generated
   */
	EAttribute getIteration_Id();

	/**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.tip.Iteration#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.Iteration#getElements()
   * @see #getIteration()
   * @generated
   */
	EReference getIteration_Elements();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation <em>Element Transformation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Transformation</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.ElementTransformation
   * @generated
   */
	EClass getElementTransformation();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getTransformationId <em>Transformation Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Transformation Id</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getTransformationId()
   * @see #getElementTransformation()
   * @generated
   */
	EAttribute getElementTransformation_TransformationId();

	/**
   * Returns the meta object for the reference list '{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getElementId <em>Element Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Element Id</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getElementId()
   * @see #getElementTransformation()
   * @generated
   */
	EReference getElementTransformation_ElementId();

	/**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getElementName <em>Element Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Element Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getElementName()
   * @see #getElementTransformation()
   * @generated
   */
	EAttribute getElementTransformation_ElementName();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#isIsExclusion <em>Is Exclusion</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Exclusion</em>'.
   * @see fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#isIsExclusion()
   * @see #getElementTransformation()
   * @generated
   */
	EAttribute getElementTransformation_IsExclusion();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	TipFactory getTipFactory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.tip.impl.TipSpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipSpecificationImpl
     * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipPackageImpl#getTipSpecification()
     * @generated
     */
		EClass TIP_SPECIFICATION = eINSTANCE.getTipSpecification();

		/**
     * The meta object literal for the '<em><b>Iterations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TIP_SPECIFICATION__ITERATIONS = eINSTANCE.getTipSpecification_Iterations();

		/**
     * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute TIP_SPECIFICATION__PROJECT_NAME = eINSTANCE.getTipSpecification_ProjectName();

		/**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute TIP_SPECIFICATION__VERSION = eINSTANCE.getTipSpecification_Version();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.tip.impl.IterationImpl <em>Iteration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.tip.impl.IterationImpl
     * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipPackageImpl#getIteration()
     * @generated
     */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ITERATION__ID = eINSTANCE.getIteration_Id();

		/**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ITERATION__ELEMENTS = eINSTANCE.getIteration_Elements();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl <em>Element Transformation</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl
     * @see fr.tpt.aadl.ramses.transformation.tip.impl.TipPackageImpl#getElementTransformation()
     * @generated
     */
		EClass ELEMENT_TRANSFORMATION = eINSTANCE.getElementTransformation();

		/**
     * The meta object literal for the '<em><b>Transformation Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ELEMENT_TRANSFORMATION__TRANSFORMATION_ID = eINSTANCE.getElementTransformation_TransformationId();

		/**
     * The meta object literal for the '<em><b>Element Id</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ELEMENT_TRANSFORMATION__ELEMENT_ID = eINSTANCE.getElementTransformation_ElementId();

		/**
     * The meta object literal for the '<em><b>Element Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ELEMENT_TRANSFORMATION__ELEMENT_NAME = eINSTANCE.getElementTransformation_ElementName();

		/**
     * The meta object literal for the '<em><b>Is Exclusion</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ELEMENT_TRANSFORMATION__IS_EXCLUSION = eINSTANCE.getElementTransformation_IsExclusion();

	}

} //TipPackage
