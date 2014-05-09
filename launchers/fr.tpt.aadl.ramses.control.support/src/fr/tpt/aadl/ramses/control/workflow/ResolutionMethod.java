/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.ramses.control.workflow;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Resolution Method</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getResolutionMethod()
 * @model
 * @generated
 */
public enum ResolutionMethod implements Enumerator
{
  /**
   * The '<em><b>Try Each</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRY_EACH_VALUE
   * @generated
   * @ordered
   */
  TRY_EACH(0, "TryEach", "TryEach"),

  /**
   * The '<em><b>Manual Merge</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MANUAL_MERGE_VALUE
   * @generated
   * @ordered
   */
  MANUAL_MERGE(1, "ManualMerge", "ManualMerge"),

  /**
   * The '<em><b>Sensitivity Merge</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SENSITIVITY_MERGE_VALUE
   * @generated
   * @ordered
   */
  SENSITIVITY_MERGE(2, "SensitivityMerge", "SensitivityMerge"),

  /**
   * The '<em><b>Genetic Merge</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GENETIC_MERGE_VALUE
   * @generated
   * @ordered
   */
  GENETIC_MERGE(3, "GeneticMerge", "GeneticMerge");

  /**
   * The '<em><b>Try Each</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Try Each</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TRY_EACH
   * @model name="TryEach"
   * @generated
   * @ordered
   */
  public static final int TRY_EACH_VALUE = 0;

  /**
   * The '<em><b>Manual Merge</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Manual Merge</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MANUAL_MERGE
   * @model name="ManualMerge"
   * @generated
   * @ordered
   */
  public static final int MANUAL_MERGE_VALUE = 1;

  /**
   * The '<em><b>Sensitivity Merge</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Sensitivity Merge</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SENSITIVITY_MERGE
   * @model name="SensitivityMerge"
   * @generated
   * @ordered
   */
  public static final int SENSITIVITY_MERGE_VALUE = 2;

  /**
   * The '<em><b>Genetic Merge</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Genetic Merge</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GENETIC_MERGE
   * @model name="GeneticMerge"
   * @generated
   * @ordered
   */
  public static final int GENETIC_MERGE_VALUE = 3;

  /**
   * An array of all the '<em><b>Resolution Method</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ResolutionMethod[] VALUES_ARRAY =
    new ResolutionMethod[]
    {
      TRY_EACH,
      MANUAL_MERGE,
      SENSITIVITY_MERGE,
      GENETIC_MERGE,
    };

  /**
   * A public read-only list of all the '<em><b>Resolution Method</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ResolutionMethod> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Resolution Method</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResolutionMethod get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ResolutionMethod result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Resolution Method</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResolutionMethod getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ResolutionMethod result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Resolution Method</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResolutionMethod get(int value)
  {
    switch (value)
    {
      case TRY_EACH_VALUE: return TRY_EACH;
      case MANUAL_MERGE_VALUE: return MANUAL_MERGE;
      case SENSITIVITY_MERGE_VALUE: return SENSITIVITY_MERGE;
      case GENETIC_MERGE_VALUE: return GENETIC_MERGE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ResolutionMethod(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //ResolutionMethod
