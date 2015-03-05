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
public class GenerateCGVisitors extends GenerateVisitors {
  public void generateVisitors(@NonNull final GenPackage genPackage) {
    EPackage ePackage = genPackage.getEcorePackage();
    this.generateAbstractExtendingVisitor(ePackage);
    this.generateAbstractNonNullExtendingVisitor(ePackage);
    this.generateVisitorInterface(ePackage);
    this.generateAbstractVisitor(ePackage);
    this.generateAbstractNullVisitor(ePackage);
  }
}
