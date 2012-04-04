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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.transformation.atl.hooks.impl ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.parsesupport.LocationReference;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.analyzers.AadlBaNameResolver;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.control.support.utils.Aadl2Utils;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPackagesManager;
import fr.tpt.aadl.ramses.transformation.atl.AtlTransfoLauncher;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage;
import fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hook Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class HookAccessImpl extends EObjectImpl implements HookAccess
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private Map<String, BehaviorAnnex> createdThreadAnnexes =
        new HashMap<String, BehaviorAnnex>() ;
  PredefinedPackagesManager predefinedPackagesManager ;

  public void setPredefinedPackagesManager(PredefinedPackagesManager p)
  {
    predefinedPackagesManager = p ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HookAccessImpl()
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
    return AtlHooksPackage.Literals.HOOK_ACCESS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BehaviorAnnex createBehaviorAnnex(ThreadImplementation threadImpl)
  {
    if(createdThreadAnnexes.isEmpty())
    {
      AtlTransfoLauncher atlLauncher ;

      try
      {
        atlLauncher = new AtlTransfoLauncher() ;
      }
      catch(Exception e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace() ;
        return null ;
      }

      Resource inputResource = threadImpl.eResource() ;
      Map<String, Resource> propertySets = new HashMap<String, Resource>() ;
      // TODO: replace ${workspace} by an ocarina specific environment variable
      String transformationFileName =
            AtlTransfoLauncher.getTransformationDirName() +
                  "CreateThreadsBehavior.asm" ;
      File transformationFile = new File(transformationFileName) ;
      List<File> transformationFileList = new ArrayList<File>() ;
      transformationFileList.add(transformationFile) ;

      try
      {
        Resource outputResource =
              atlLauncher.doGeneration(inputResource, propertySets,
                                       transformationFileList, "") ;

        for(Object o : outputResource.getContents())
        {
          if(o instanceof ThreadImplementation)
          {
            ThreadImplementation t = (ThreadImplementation) o ;

            if(t.getOwnedAnnexSubclauses().get(0) instanceof BehaviorAnnex)
            {
              BehaviorAnnex ba =
                    (BehaviorAnnex) t.getOwnedAnnexSubclauses().get(0) ;
              ba.setAadlRef(t) ;
              createdThreadAnnexes.put(t.getName(), ba) ;
            }
          }
        }
      }
      catch(FileNotFoundException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
      }
      catch(IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
      }
      catch(ATLCoreException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
      }
      catch(Exception e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
      }
    }

    BehaviorAnnex ba = createdThreadAnnexes.get(threadImpl.getQualifiedName()) ;
    return ba ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDirectionIn(DirectedFeature feature)
  {
    feature.setDirection(DirectionType.IN) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void resolveBANames(BehaviorAnnex ba)
  {
    AadlBaNameResolver nameResolver =
          new AadlBaNameResolver(ba,
                ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER) ;
    nameResolver.resolveNames() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<Feature> orderFeatures(ComponentType cpt)
  {
    EList<Feature> res = new BasicEList<Feature>() ;
    res.addAll(Aadl2Utils.orderFeatures(cpt)) ;
    return res ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void copyLocationReference(Element target,
                                    Element source)
  {
    INode node = NodeModelUtils.findActualNodeFor(source) ;
    int line;
    if(node!=null)
    	line = node.getStartLine() ;
    else
    {
    	line = source.getLocationReference().getLine();
    }
    LocationReference lr =
          new LocationReference(source.eResource().getURI().lastSegment(), line) ;
    target.setLocationReference(lr) ;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
    private static Map<NamedElement, InstanceObject> _transformationTrace = new HashMap<NamedElement, InstanceObject>();
    
  public void addTransformationBackTrace(NamedElement targetDeclarative, InstanceObject sourceInstance) {
    _transformationTrace.put(targetDeclarative, sourceInstance);
  }
  
  public static InstanceObject getTransformationTrace(NamedElement targetDeclarative)
  {
    return _transformationTrace.get(targetDeclarative);
  }
  
  public static List<NamedElement> getTransformationTracesFromSource(InstanceObject sourceInstance)
  {
	  ArrayList<NamedElement> l = new ArrayList<NamedElement>();
	  for(NamedElement e : _transformationTrace.keySet())
	  {
		  if (_transformationTrace.get(e) == sourceInstance)
		  {
			  l.add(e);
		  }
	  }
	  return l;
  }
  
  public static List<NamedElement> getTransformationTracesFromSourceDecl(ComponentImplementation el)
  {
	  ArrayList<NamedElement> l = new ArrayList<NamedElement>();
	  for(NamedElement e : _transformationTrace.keySet())
	  {
		  if (e instanceof SystemImplementation)
			  continue;
		  
		  if (_transformationTrace.get(e) instanceof ComponentInstance )
		  {
			  ComponentInstance c = (ComponentInstance) _transformationTrace.get(e);
			  if ((c.getName()+".impl").equals(el.getName()))
				  l.add(e);
		  }
	  }
	  return l;
  }

} //HookAccessImpl