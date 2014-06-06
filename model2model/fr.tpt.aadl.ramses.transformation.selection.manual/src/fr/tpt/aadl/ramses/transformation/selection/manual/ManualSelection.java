package fr.tpt.aadl.ramses.transformation.selection.manual;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.transformation.selection.ITransformationSelection ;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;

public class ManualSelection implements ITransformationSelection
{

  
  private static Logger _LOGGER = Logger.getLogger(ManualSelection.class) ;
  
  public ManualSelection(TrcSpecification trc)
  {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void selectTransformation (Map<List<EObject>, ArrayList<String>> patternMatchingMap,
                                    ArrayList<ElementTransformation> tuplesToApply)
  {
    String message = "In manual selection branch";
    _LOGGER.trace(message);
    
    ServiceProvider.SYS_ERR_REP.error("Not Implemented Yet", false);
    
  }

  @Override
  public boolean shouldSelectionContinue()
  {
    return true ;
  }
}
