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

/*
 * @author Etienne Borde
 */

package fr.tpt.aadl.ramses.generation.pok.makefile ;

import java.util.ArrayList ;
import java.util.List ;

import org.osate.aadl2.CallSpecification ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceReferenceValue ;

public class Services
{

  public List<String> getListOfReferencedObjects(ProcessImplementation aProcessImplementation)
  {
    List<String> result = new ArrayList<String>() ;

    for(ThreadSubcomponent aTheadSubcomponent : aProcessImplementation
          .getOwnedThreadSubcomponents())
    {
      if(aTheadSubcomponent.getComponentImplementation() != null)
      {
        this.getListOfReferencedObjects((ThreadImplementation) aTheadSubcomponent
                                              .getComponentImplementation(),
                                        result) ;
      }
      else
      {
        /*
         *  TODO: throw exception, the thread component instance should reference a thread implementation
         *  to call user operations
         */
      }
    }

    return result ;
  }

  public void getListOfReferencedObjects(ThreadImplementation aThreadImplementation,
                                         List<String> result)
  {
    for(SubprogramCallSequence aCallSequence : aThreadImplementation
          .getOwnedSubprogramCallSequences())
    {
      for(CallSpecification aCallSpecification : aCallSequence
            .getOwnedCallSpecifications())
      {
        this.getListOfReferencedObjects(aCallSpecification, result) ;
      }
    }
  }

  public void getListOfReferencedObjects(CallSpecification aCallSpecification,
                                         List<String> result)
  {
    if(aCallSpecification instanceof SubprogramCall)
    {
      this.getListOfReferencedObjects((SubprogramCall) aCallSpecification,
                                      result) ;
    }
  }

  public void getListOfReferencedObjects(SubprogramCall aSubprogramCall,
                                         List<String> result)
  {
    if(aSubprogramCall.getCalledSubprogram() instanceof SubprogramType)
    {
      SubprogramType aSubprogramType =
            (SubprogramType) aSubprogramCall.getCalledSubprogram() ;

      for(PropertyAssociation aPropertyAssociation : aSubprogramType
            .getOwnedPropertyAssociations())
      {
        getListOfReferencedObjects(aPropertyAssociation, result) ;
      }
    }
    else if(aSubprogramCall.getCalledSubprogram() instanceof SubprogramImplementation)
    {
      SubprogramImplementation aSubprogramImplementation =
            (SubprogramImplementation) aSubprogramCall.getCalledSubprogram() ;

      for(PropertyAssociation aPropertyAssociation : aSubprogramImplementation
            .getOwnedPropertyAssociations())
      {
        getListOfReferencedObjects(aPropertyAssociation, result) ;
      }

      for(CallSpecification aCallSpecification : aSubprogramImplementation
            .getCallSpecifications())
      {
        this.getListOfReferencedObjects(aCallSpecification, result) ;
      }
    }
  }

  public void getListOfReferencedObjects(PropertyAssociation aPropertyAssociation,
                                         List<String> result)
  {
    if(aPropertyAssociation.getProperty().getName() != null &&
          aPropertyAssociation.getProperty().getName()
                .equals("Source_Location"))
    {
      for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
            .getOwnedValues())
      {
        result.add(((StringLiteral) aModalPropertyValue.getOwnedValue())
              .getValue()) ;
      }
    }
  }

  public String getDeloymentProcessorSubcomponentName(ComponentInstance aProcessInstance)
  {
    for(PropertyAssociation aPropertyAssociation : aProcessInstance
          .getOwnedPropertyAssociations())
    {
      if(aPropertyAssociation.getProperty().getName()
            .equals("Actual_Processor_Binding"))
      {
        for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
              .getOwnedValues())
        {
          if(aModalPropertyValue.getOwnedValue() instanceof ListValue)
          {
            ListValue list = (ListValue) aModalPropertyValue.getOwnedValue() ;

            for(Element anElement : list.getOwnedListElements())
            {
              if(anElement instanceof InstanceReferenceValue)
              {
                InstanceReferenceValue reference =
                      (InstanceReferenceValue) anElement ;

                if(reference.getReferencedInstanceObject() instanceof ComponentInstance)
                {
                  ComponentInstance referencedInstance =
                        (ComponentInstance) reference
                              .getReferencedInstanceObject() ;

                  if(referencedInstance.getCategory()
                        .equals(ComponentCategory.VIRTUAL_PROCESSOR))
                  {
                    return ((ComponentInstance) referencedInstance.getOwner())
                          .getSubcomponent().getName() ;
                  }
                }
              }
            }
          }
        }
      }
    }

    return "" ;
  }

}
