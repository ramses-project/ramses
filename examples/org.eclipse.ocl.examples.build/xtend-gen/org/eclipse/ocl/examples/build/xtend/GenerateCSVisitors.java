/**
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 */
package org.eclipse.ocl.examples.build.xtend;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitors;

@SuppressWarnings("all")
public class GenerateCSVisitors extends GenerateVisitors {
  public void generateVisitors(@NonNull final GenPackage genPackage) {
    EPackage ePackage = genPackage.getEcorePackage();
    boolean _isDerived = this.isDerived();
    boolean _not = (!_isDerived);
    if (_not) {
      this.generateVisitableInterface(ePackage);
    }
    this.generateVisitorInterface(ePackage);
    this.generateDecorableVisitorInterface(ePackage, "org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor");
    this.generateAbstractVisitor(ePackage);
    this.generateAbstractNullVisitor(ePackage);
    this.generateAbstractDelegatingVisitor(ePackage);
    this.generateAbstractExtendingVisitor(ePackage);
  }
}
