package org.trc.xtext.dsl.post.processor

import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.EcorePackage$Literals
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.common.util.BasicEMap$Entry
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecore.EAnnotation
import org.eclipse.emf.ecore.EOperation

class DslPostProcessor implements IXtext2EcorePostProcessor{
	
	def static void augment(GeneratedMetamodel metamodel) {
	new DslPostProcessor().process(metamodel)
}
	override process(GeneratedMetamodel metamodel) {
		metamodel.process
	}
	
	def process(EPackage p) 
	{
		p.EClassifiers.filter(typeof(EClass)).forEach[addToStringOperation]
	}
		
	def addToStringOperation(EClass c) {
	val op = EcoreFactory::eINSTANCE.createEOperation
	op.name = 'toString'
	op.EType = EcorePackage::eINSTANCE.EString
	c.EOperations += op.addBodyAnnotation('if (eIsProxy()) return super.toString(); return ToString.valueOf(this);')
	}

	def addBodyAnnotation(EOperation op, String strBody) {
	val body = EcoreFactory::eINSTANCE.createEAnnotation
	body.source = GenModelPackage::eNS_URI
	body.createBody(strBody)
	op.EAnnotations += body
	op
	}
	
	def createBody(EAnnotation annotation, String strBody) {
	val map = EcoreFactory::eINSTANCE.create(EcorePackage::eINSTANCE.getEStringToStringMapEntry()) as BasicEMap$Entry
	map.key = "body"
	map.value = strBody
	annotation.details.add(map)
	}
	 
}