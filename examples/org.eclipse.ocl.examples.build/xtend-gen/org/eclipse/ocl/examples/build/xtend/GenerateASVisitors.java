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
import org.eclipse.ocl.examples.pivot.utilities.AS2Moniker;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;

@SuppressWarnings("all")
public class GenerateASVisitors extends GenerateVisitors {
  public void generateVisitors(@NonNull final GenPackage genPackage) {
    EPackage ePackage = genPackage.getEcorePackage();
    boolean _isDerived = this.isDerived();
    boolean _not = (!_isDerived);
    if (_not) {
      this.generateVisitableInterface(ePackage);
    }
    this.generateVisitorInterface(ePackage);
    this.generateAbstractVisitor(ePackage);
    this.generateAbstractNullVisitor(ePackage);
    this.generateAbstractDelegatingVisitor(ePackage);
    this.generateAbstractExtendingVisitor(ePackage);
    this.generateAbstractWrappingVisitor(ePackage);
    boolean _isDerived_1 = this.isDerived();
    if (_isDerived_1) {
      this.generateAbstractGenericVisitor(ePackage, "AS2XMIid", Boolean.class, AS2XMIid.class);
      this.generateAbstractGenericVisitor(ePackage, "AS2Moniker", Object.class, AS2Moniker.class);
      this.generateAbstractGenericVisitor(ePackage, "ASSaverLocate", Object.class, ASSaver.class);
      this.generateAbstractGenericVisitor(ePackage, "ASSaverResolve", Object.class, ASSaver.class);
    }
  }
}
