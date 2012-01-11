package fr.tpt.aadl.instantiation ;

import java.util.List ;

import org.eclipse.emf.ecore.EObject ;
import org.eclipse.xtext.EcoreUtil2 ;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer ;
import org.eclipse.xtext.linking.lazy.LazyLinker ;
import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.DefaultAnnexSubclause ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;

import fr.tpt.aadl.toolsuite.support.services.ServiceRegistry ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistryProvider ;

public class Aadl2StandaloneAnnexParserAgent extends LazyLinker
{
  public static AnnexJobHandler _jobHandler = new AnnexJobHandler() ;

  // TODO : ask Peter to externalize part of the method not to copy/paste osate code

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.xtext.linking.impl.AbstractCleaningLinker#afterModelLinked(org.eclipse.emf.ecore.EObject,
   * org.eclipse.xtext.diagnostics.IDiagnosticConsumer)
   */
  @Override
  protected void afterModelLinked(EObject model,
                                  IDiagnosticConsumer diagnosticsConsumer)
  {
    INode node = NodeModelUtils.findActualNodeFor(model) ;
    int offset = node.getTotalOffset() ;
    int line = node.getTotalStartLine() ;
    String filename = model.eResource().getURI().toString() ;
    // set up reporter for ParseErrors
    ParseErrorReporter errReporter = ServiceRegistry.PARSE_ERR_REPORTER ;
    AnalysisErrorReporterManager resolveErrManager =
          ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER ;
    ServiceRegistry registry = ServiceRegistryProvider.getServiceRegistry() ;
    List<DefaultAnnexSubclause> asl =
          EcoreUtil2.eAllOfType(model, DefaultAnnexSubclause.class) ;

    // XXX Processes Behavior Annex only.
    for(DefaultAnnexSubclause defaultAnnexSubclause : asl)
    {
      String annexText = defaultAnnexSubclause.getSourceText() ;
      String annexName = defaultAnnexSubclause.getName() ;

      if(annexText != null && annexName != null)
      {
        AnnexParser ap = registry.getParser(annexName) ;
        AnnexResolver ar = registry.getResolver(annexName) ;
        _jobHandler.addJob(new AnnexJob(defaultAnnexSubclause, filename, line,
              offset, ap, errReporter, ar, resolveErrManager)) ;
      }
    }
  }
}
