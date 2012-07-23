/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */


package fr.tpt.aadl.ramses.instantiation ;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.*;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.xtext.aadl2.unparsing.AadlUnparser;

import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider;


public class Aadl2StandaloneUnparser extends AadlUnparser
{

  private UnparseText aadlText ;

  private static ServiceRegistry serviceRegistry ;

  protected static Aadl2StandaloneUnparser unparser = null ;

  public static Aadl2StandaloneUnparser getAadlUnparser()
  {
    if(unparser == null)
    {
      unparser = new Aadl2StandaloneUnparser() ;
    }

    return unparser ;
  }

  public Aadl2StandaloneUnparser()
  {
    super() ;

    try
    {
      serviceRegistry = ServiceRegistryProvider.getServiceRegistry() ;
    }
    catch(Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
  }

  protected final void initSwitches()
  {
    /* here we are creating the various unparse switches */
    aadl2Switch = new Aadl2Switch<String>()
    {
      public String caseAadlPackage(AadlPackage object)
      {
        return super.caseAadlPackage(object);
      }

      public String casePrivatePackageSection(PrivatePackageSection object)
      {
        return super.casePrivatePackageSection(object) ;
      }

      /*
       * (non-Javadoc)
       *
       * @see edu.cmu.sei.aadl.model.core.util.CoreSwitch#caseAadlPublic(edu.cmu.sei.aadl.model.core.AadlPublic)
       */
      public String casePublicPackageSection(PublicPackageSection object)
      {
        return super.casePublicPackageSection(object) ;
      }

      public String casePackageSection(PackageSection object)
      {
        return super.casePackageSection(object) ;
      }

      public String casePackageRename(PackageRename object)
      {
        return super.casePackageRename(object) ;
      }

      public String caseComponentTypeRename(ComponentTypeRename object)
      {
    	return super.caseComponentTypeRename(object);
      }

      public String caseFeatureGroupTypeRename(FeatureGroupTypeRename object)
      {
        return caseFeatureGroupTypeRename(object) ;
      }

      /**
       * outputs the content of a component implementation It picks up
       * after the superclass case. It returns done as processing is
       * complete.
       */
      public String caseComponentImplementation(ComponentImplementation object)
      {
        return super.caseComponentImplementation(object) ;
      }

      /**
       * Add the common part of component types
       */
      public String caseComponentType(ComponentType object)
      {
        return super.caseComponentType(object) ;
      }

      /*
       * (non-Javadoc)
       *
       * @see edu.cmu.sei.aadl.model.core.util.CoreSwitch#caseMode(edu.cmu.sei.aadl.model.core.Mode)
       */
      public String caseMode(Mode object)
      {
        return super.caseMode(object) ;
      }

      /**
       * unparse mode transitions
       */
      public String caseModeTransition(ModeTransition object)
      {
        return super.caseModeTransition(object) ;
      }

      /**
       * Does the bulk of subcomponent declarations
       */
      public String caseSubcomponent(Subcomponent object)
      {
        return super.caseSubcomponent(object) ;
      }

      public String caseArrayDimension(ArrayDimension object)
      {
        return caseArrayDimension(object) ;
      }

      public String caseArraySize(ArraySize object)
      {
        return caseArraySize(object) ;
      }

      /**
       * unparses annex library
       *
       * @param al
       *            AnnexLibrary object
       */
      public String caseAnnexLibrary(AnnexLibrary al)
      {
        String annexName = al.getName() ;
        AnnexUnparser unparser = serviceRegistry.getUnparser(annexName) ;

        if(unparser != null)
        {
          processComments(al) ;
          aadlText.addOutputNewline("annex " + annexName + " {**") ;
          aadlText.incrementIndent() ;
          aadlText.addOutput(unparser
                .unparseAnnexLibrary(al, aadlText.getIndentString())) ;
          aadlText.decrementIndent() ;
          aadlText.addOutputNewline("**};") ;
        }

        return DONE ;
      }

      /**
       * unparses default annex library
       *
       * @param dal
       *            DefaultAnnexLibrary object
       */
      //         public String caseDefaultAnnexLibrary(DefaultAnnexLibrary dal) {
      //            AnnexUnparserRegistry registry = (AnnexUnparserRegistry) AnnexRegistry
      //                  .getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
      //            String annexName = dal.getName();
      //            AnnexUnparser unparser = registry.getAnnexUnparser("*");
      //
      //            if (unparser != null) {
      //               processComments(dal);
      //               aadlText.addOutput("annex " + annexName + " {**");
      //               aadlText.incrementIndent();
      //               aadlText.addOutput(unparser.unparseAnnexLibrary(dal,
      //                     aadlText.getIndentString()));
      //               aadlText.decrementIndent();
      //               aadlText.addOutputNewline("**};");
      //            }
      //            return DONE;
      //         }
      /**
       * unparses annex subclause
       *
       * @param as
       *            AnnexSubclause object
       */
      public String caseAnnexSubclause(AnnexSubclause as)
      {
        String annexName = as.getName() ;
        AnnexUnparser unparser = serviceRegistry.getUnparser(annexName) ;

        if(unparser != null)
        {
          processComments(as) ;
          aadlText.addOutputNewline("annex " + annexName + " {**") ;
          aadlText.incrementIndent() ;
          aadlText.addOutput(unparser
                .unparseAnnexSubclause(as, aadlText.getIndentString())) ;
          aadlText.decrementIndent() ;
          aadlText.addOutputNewline("**};") ;
        }

        return DONE ;
      }

      /**
       * unparses defaultannex subclause
       *
       * @param das
       *            DefaultAnnexSubclause object
       */
      //         public String caseDefaultAnnexSubclause(DefaultAnnexSubclause das) {
      //            AnnexUnparserRegistry registry = (AnnexUnparserRegistry) AnnexRegistry
      //                  .getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
      //            String annexName = das.getName();
      //            AnnexUnparser unparser = registry.getAnnexUnparser("*");
      //
      //            if (unparser != null) {
      //               processComments(das);
      //               aadlText.addOutputNewline("annex " + annexName + " {**");
      //               aadlText.incrementIndent();
      //               aadlText.addOutputNewline(unparser.unparseAnnexSubclause(
      //                     das, aadlText.getIndentString()));
      //               aadlText.decrementIndent();
      //               aadlText.addOutputNewline("**};");
      //            }
      //            return DONE;
      //         }
      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseBusImplementation(BusImplementation object)
      {
        return super.caseBusImplementation(object) ;
      }

      /*
       * (non-Javadoc)
       *
       * @see edu.cmu.sei.aadl.model.component.util.ComponentSwitch#caseBusSubcomponent(edu.cmu.sei.aadl.model.component.BusSubcomponent)
       */
      public String caseBusSubcomponent(BusSubcomponent object)
      {
        return super.caseBusSubcomponent(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseBusType(BusType object)
      {
        return super.caseBusType(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDataImplementation(DataImplementation object)
      {
        return super.caseDataImplementation(object) ;
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseDataSubcomponent(DataSubcomponent object)
      {
        return super.caseDataSubcomponent(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDataType(DataType object)
      {
        return caseDataType(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDeviceImplementation(DeviceImplementation object)
      {
        return caseDeviceImplementation(object) ;
      }

      /*
       * (non-Javadoc)
       *
       * @see edu.cmu.sei.aadl.model.component.util.ComponentSwitch#caseDeviceSubcomponent(edu.cmu.sei.aadl.model.component.DeviceSubcomponent)
       */
      public String caseDeviceSubcomponent(DeviceSubcomponent object)
      {
        return super.caseDeviceSubcomponent(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDeviceType(DeviceType object)
      {
        return super.caseDeviceType(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemoryImplementation(MemoryImplementation object)
      {
        return super.caseMemoryImplementation(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemorySubcomponent(MemorySubcomponent object)
      {
        return super.caseMemorySubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemoryType(MemoryType object)
      {
        return super.caseMemory(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessImplementation(ProcessImplementation object)
      {
        return super.caseProcessImplementation(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorImplementation(VirtualProcessorImplementation object)
      {
        return super.caseVirtualProcessorImplementation(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorSubcomponent(VirtualProcessorSubcomponent object)
      {
    	  return super.caseVirtualProcessorSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorType(VirtualProcessorType object)
      {
    	  return super.caseVirtualProcessorType(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusImplementation(VirtualBusImplementation object)
      {
    	  return super.caseVirtualBusImplementation(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusSubcomponent(VirtualBusSubcomponent object)
      {
    	  return super.caseVirtualBusSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusType(VirtualBusType object)
      {
    	  return super.caseVirtualBusType(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractImplementation(AbstractImplementation object)
      {
    	  return super.caseAbstractImplementation(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractSubcomponent(AbstractSubcomponent object)
      {
    	  return super.caseAbstractSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractType(AbstractType object)
      {
    	  return super.caseAbstractType(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorImplementation(ProcessorImplementation object)
      {
    	  return super.caseProcessorImplementation(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorSubcomponent(ProcessorSubcomponent object)
      {
    	  return super.caseProcessorSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorType(ProcessorType object)
      {
    	  return super.caseProcessorType(object);
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseProcessSubcomponent(ProcessSubcomponent object)
      {
    	  return super.caseProcessSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessType(ProcessType object)
      {
    	  return super.caseProcessType(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSystemImplementation(SystemImplementation object)
      {
    	  return super.caseSystemImplementation(object);
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseSystemSubcomponent(SystemSubcomponent object)
      {
    	  return super.caseSystemSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSystemType(SystemType object)
      {
        return super.caseSystemType(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupImplementation(ThreadGroupImplementation object)
      {
        return super.caseThreadGroupImplementation(object) ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupSubcomponent(ThreadGroupSubcomponent object)
      {
        return super.caseThreadGroupSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupType(ThreadGroupType object)
      {
    	  return super.caseThreadGroupType(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadImplementation(ThreadImplementation object)
      {
    	  return super.caseThreadImplementation(object);
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseThreadSubcomponent(ThreadSubcomponent object)
      {
    	  return super.caseThreadSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadType(ThreadType object)
      {
    	  return super.caseThreadType(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramImplementation(SubprogramImplementation object)
      {
    	  return super.caseSubprogramImplementation(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramType(SubprogramType object)
      {
    	  return super.caseSubprogramType(object);
      }

      /*
       * (non-Javadoc)
       *
       */
      public String caseSubprogramSubcomponent(SubprogramSubcomponent object)
      {
        return super.caseSubprogramSubcomponent(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramGroupImplementation(SubprogramGroupImplementation object)
      {
    	  return super.caseSubprogramGroupImplementation(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramGroupType(SubprogramGroupType object)
      {
    	  return super.caseSubprogramGroupType(object);
      }

      /*
       * (non-Javadoc)
       *
       */
      public String caseSubprogramGroupSubcomponent(SubprogramGroupSubcomponent object)
      {
    	  return super.caseSubprogramGroupSubcomponent(object);
      }

      /**
       * Prototypes
       */
      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramPrototype(SubprogramPrototype object)
      {
    	  return super.caseSubprogramPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSystemPrototype(SystemPrototype object)
      {
    	  return super.caseSystemPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractPrototype(AbstractPrototype object)
      {
    	  return super.caseAbstractPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessPrototype(ProcessPrototype object)
      {
        return super.caseProcessPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupPrototype(ThreadGroupPrototype object)
      {
        return super.caseThreadGroupPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadPrototype(ThreadPrototype object)
      {
        return super.caseThreadPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorPrototype(ProcessorPrototype object)
      {
        return super.caseProcessorPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemoryPrototype(MemoryPrototype object)
      {
        return super.caseMemoryPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseBusPrototype(BusPrototype object)
      {
        return super.caseBusPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDevicePrototype(DevicePrototype object)
      {
        return super.caseDevicePrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorPrototype(VirtualProcessorPrototype object)
      {
        return super.caseVirtualProcessorPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusPrototype(VirtualBusPrototype object)
      {
        return super.caseVirtualBusPrototype(object);
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramGroupPrototype(SubprogramGroupPrototype object)
      {
        return super.caseSubprogramGroupPrototype(object);
      }

      /**
       * Does the bulk of prototype declarations
       */
      public String caseComponentPrototype(ComponentPrototype object)
      {
        return super.caseComponentPrototype(object);
      }

      public String caseFeatureGroupPrototype(FeatureGroupPrototype object)
      {
        return super.caseFeatureGroupPrototype(object);
      }

      /**
       * Does the bulk of feature prototype declarations
       */
      public String caseFeaturePrototype(FeaturePrototype object)
      {
        return super.caseFeaturePrototype(object);
      }

      /**
       * Does the  prototype binding
       */
      public String caseComponentPrototypeBinding(ComponentPrototypeBinding object)
      {
    	  return super.caseComponentPrototypeBinding(object);
      }

      /**
       * Does the  prototype actual
       */
      public String caseComponentPrototypeActual(ComponentPrototypeActual object)
      {
    	  return super.caseComponentPrototypeActual(object);
      }

      /**
       * Does the  feature group prototype binding
       */
      public String caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding object)
      {
    	  return super.caseFeatureGroupPrototypeBinding(object);
      }

      public String caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual object)
      {
    	  return super.caseFeatureGroupPrototypeActual(object);
      }

      /**
       * Does the  feature prototype binding
       */
      public String caseFeaturePrototypeBinding(FeaturePrototypeBinding object)
      {
    	  return super.caseFeaturePrototypeBinding(object);
      }

      public String casePortSpecification(PortSpecification object)
      {
    	  return super.casePortSpecification(object);
      }

      public String caseAccessSpecification(AccessSpecification object)
      {
    	  return super.caseAccessSpecification(object);
      }

      public String caseFeaturePrototypeReference(FeaturePrototypeReference object)
      {
    	  return super.caseFeaturePrototypeReference(object);
      }

      /**
       * call sequence processing.
       */
      public String caseSubprogramCallSequence(SubprogramCallSequence object)
      {
    	  return super.caseSubprogramCallSequence(object);
      }

      /**
       * subprogram call processing.
       */
      public String caseSubprogramCall(SubprogramCall object)
      {
    	  return super.caseSubprogramCall(object);
      }

      public String caseProcessorCall(ProcessorCall object)
      {
    	  return super.caseProcessorCall(object);
      }

      public String casePortConnection(PortConnection object)
      {
    	  return super.casePortConnection(object);
      }

      public String caseFeatureGroupConnection(FeatureGroupConnection object)
      {
    	  return super.caseFeatureGroupConnection(object);
      }

      public String caseParameterConnection(ParameterConnection object)
      {
    	  return super.caseParameterConnection(object);
      }

      public String caseAccessConnection(AccessConnection object)
      {
    	  return super.caseAccessConnection(object);
      }

      /**
       * bus access
       */
      public String caseBusAccess(BusAccess object)
      {
    	  return super.caseBusAccess(object);
      }

      /**
       *  subprogram access
       */
      public String caseSubprogramAccess(SubprogramAccess object)
      {
    	  return super.caseSubprogramAccess(object);
      }

      /**
       *  subprogram group access
       */
      public String caseSubprogramGroupAccess(SubprogramGroupAccess object)
      {
    	  return super.caseSubprogramGroupAccess(object);
      }

      /**
       * data access
       */
      public String caseDataAccess(DataAccess object)
      {
    	  return super.caseDataAccess(object);
      }

      public String caseDataPort(DataPort object)
      {
    	  return super.caseDataPort(object);
      }

      /**
       * Does the name and category. Port handles the rest
       */
      public String caseEventDataPort(EventDataPort object)
      {
    	  return super.caseEventDataPort(object);
      }

      /**
       * Does the name and category. Port handles the rest
       */
      public String caseEventPort(EventPort object)
      {
    	  return super.caseEventPort(object);
      }

      /**
       * Does the common part of port
       */
      public String casePort(Port object)
      {
    	  return super.casePort(object);
      }

      /**
       * Does the parameter
       */
      public String caseParameter(Parameter object)
      {
    	  return super.caseParameter(object);
      }

      /**
       * Does the port group
       */
      public String caseFeatureGroup(FeatureGroup object)
      {
    	  return super.caseFeatureGroup(object);
      }

      /**
       * Add the common part of component types
       */
      public String caseFeatureGroupType(FeatureGroupType object)
      {
    	  return super.caseFeatureGroupType(object);
      }

      /**
       * Handles all provides, requires, and parameters
       */
      public String caseAbstractFeature(AbstractFeature object)
      {
    	  return super.caseAbstractFeature(object);
      }

      /**
       * Handles flow  spec
       */
      public String caseFlowSpecification(FlowSpecification object)
      {
    	  return super.caseFlowSpecification(object);
      }

      /**
       * Handles flow implementation
       */
      public String caseFlowImplementation(FlowImplementation object)
      {
    	  return super.caseFlowImplementation(object);
      }

      /**
       * Handles flow ETEF
       */
      public String caseEndToEndFlow(EndToEndFlow object)
      {
    	  return super.caseEndToEndFlow(object);
      }

      public String casePropertySet(PropertySet object)
      {
    	  return super.casePropertySet(object);
      }

      public String caseAadlBoolean(AadlBoolean object)
      {
    	  return super.caseAadlBoolean(object);
      }

      public String caseAadlString(AadlString object)
      {
    	  return super.caseAadlString(object);
      }

      public String caseAadlInteger(AadlInteger object)
      {
    	  return super.caseAadlInteger(object);
      }

      public String caseAadlReal(AadlReal object)
      {
    	  return super.caseAadlReal(object);
      }

      public String caseEnumerationType(EnumerationType object)
      {
    	  return super.caseEnumerationType(object);
      }

      public String caseUnitsType(UnitsType object)
      {
    	  return super.caseUnitsType(object);
      }

      public String caseEnumerationLiteral(EnumerationLiteral object)
      {
    	  return super.caseEnumerationLiteral(object);
      }

      public String caseUnitLiteral(UnitLiteral object)
      {
    	  return super.caseUnitLiteral(object);
      }

      public String caseReferenceType(ReferenceType object)
      {
    	  return super.caseReferenceType(object);
      }

      public String caseReferenceValue(ReferenceValue object)
      {
    	  return super.caseReferenceValue(object);
      }

      public String caseClassifierType(ClassifierType object)
      {
    	  return super.caseClassifierType(object);
      }

      public String caseClassifierValue(ClassifierValue object)
      {
    	  return super.caseClassifierValue(object);
      }

      public String caseMetaclassReference(MetaclassReference object)
      {
    	  return super.caseMetaclassReference(object);
      }

      public String caseModalPropertyValue(ModalPropertyValue object)
      {
    	  return super.caseModalPropertyValue(object);
      }

      public String casePropertyAssociation(PropertyAssociation object)
      {
    	  return super.casePropertyAssociation(object);
      }

      public String caseContainedNamedElement(ContainedNamedElement object)
      {
    	  return super.caseContainedNamedElement(object);
      }

      public String caseContainmentPathElement(ContainmentPathElement object)
      {
    	  return super.caseContainmentPathElement(object);
      }

      public String casePropertyConstant(PropertyConstant object)
      {
    	  return super.casePropertyConstant(object);
      }

      public String caseProperty(Property object)
      {
    	  return super.caseProperty(object);
      }

      public String caseBasicProperty(BasicProperty object)
      {
    	  return super.caseBasicProperty(object);
      }

      public String caseListType(ListType object)
      {
    	  return super.caseListType(object);
      }

      public String caseListValue(ListValue object)
      {
    	  return super.caseListValue(object);
      }

      public String caseOperation(Operation object)
      {
    	  return super.caseOperation(object);
      }

      public String caseBooleanLiteral(BooleanLiteral object)
      {
    	  return super.caseBooleanLiteral(object);
      }

      public String caseStringLiteral(StringLiteral object)
      {
    	  return super.caseStringLiteral(object);
      }

      public String caseNumberValue(NumberValue object)
      {
    	  return super.caseNumberValue(object);
      }

      public String caseNamedValue(NamedValue object)
      {
    	  return super.caseNamedValue(object);
      }

      public String caseRangeType(RangeType object)
      {
    	  return super.caseRangeType(object);
      }

      public String caseRangeValue(RangeValue object)
      {
    	  return super.caseRangeValue(object);
      }

      public String caseArrayRange(ArrayRange object)
      {
    	  return super.caseArrayRange(object);
      }

      public String caseNumericRange(NumericRange object)
      {
    	return super.caseNumericRange(object);
      }

      public String caseRecordType(RecordType object)
      {
    	return super.caseRecordType(object);
      }

      public String caseRecordValue(RecordValue object)
      {
    	return super.caseRecordValue(object);
      }

      public String caseBasicPropertyAssociation(BasicPropertyAssociation object)
      {
        return super.caseBasicPropertyAssociation(object);
      }
    } ;
  }


  private void processComments(final Element obj) {
		if (obj != null) {
			EList<Comment> el = obj.getOwnedComments();
			if (!el.isEmpty()){
				for (Comment comment : el) {
					String str = comment.getBody();
					if (!str.startsWith("--") ) {
						str = "--" +(str.startsWith(" ") ? "" : " ") + str;
					}
					aadlText.addOutputNewline(str);
				}
			} else {
				// see if there are comments in the parse tree
				processComment(obj);
			}
		}
	}

}
