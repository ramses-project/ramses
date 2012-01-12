/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.transformation.hooks.ATLHooks.impl ;

import java.io.File ;
import java.io.FileNotFoundException ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.impl.EObjectImpl ;
import org.osate.aadl2.ComponentType ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.m2m.atl.core.ATLCoreException ;
import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.DirectedFeature ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.parsesupport.LocationReference ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.analyzers.AadlBaNameResolver ;
import fr.tpt.aadl.c.unparser.GenerationUtils ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistry ;
import fr.tpt.aadl.transformation.ATLTransfoLauncher ;
import fr.tpt.aadl.resources.manager.PredefinedPackagesManager ;
import fr.tpt.aadl.transformation.hooks.ATLHooks.ATLHooksPackage ;
import fr.tpt.aadl.transformation.hooks.ATLHooks.HookAccess ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

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
    super() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ATLHooksPackage.Literals.HOOK_ACCESS ;
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
      ATLTransfoLauncher atlLauncher ;

      try
      {
        atlLauncher = new ATLTransfoLauncher() ;
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
            ATLTransfoLauncher.getTransformationDirName() +
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
    res.addAll(GenerationUtils.orderFeatures(cpt)) ;
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
    int offset = node.getOffset() ;
    int line = node.getStartLine() ;
    LocationReference lr =
          new LocationReference(source.eResource().getURI().lastSegment(), line) ;
    target.setLocationReference(lr) ;
  }

} //HookAccessImpl
