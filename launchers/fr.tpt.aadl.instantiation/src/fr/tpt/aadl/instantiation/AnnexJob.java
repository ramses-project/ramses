package fr.tpt.aadl.instantiation ;

import java.io.File ;
import java.util.Collections ;
import java.util.List ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.DefaultAnnexSubclause ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;

import antlr.RecognitionException ;

public class AnnexJob
{
  private DefaultAnnexSubclause _annex ;

  private String _filename ;

  private int _line ;

  private int _offset ;

  private AnnexParser _parser ;

  private ParseErrorReporter _parserErrReporter ;

  private AnnexResolver _resolver ;

  private List<?> _annexElements ;

  private AnalysisErrorReporterManager _errManager ;

  // DEBUG
  private String _parentContainer ;

  public AnnexJob(
                  DefaultAnnexSubclause annex, String filename, int line,
                  int offset, AnnexParser parser,
                  ParseErrorReporter parserErrReporter, AnnexResolver resolver,
                  AnalysisErrorReporterManager analysisErrManager)
  {
    _annex = annex ;
    _filename = filename ;
    _line = line ;
    _offset = offset ;
    _parser = parser ;
    _parserErrReporter = parserErrReporter ;
    _resolver = resolver ;
    _errManager = analysisErrManager ;
  }

  public boolean parse()
  {
    boolean result ;
    AnnexSubclause as ;
    String annexText = _annex.getSourceText() ;
    String annexName = _annex.getName() ;

    try
    {
      //DEBUG
      String filename = (new File(_filename)).getName() ;
      _parentContainer = ((ComponentClassifier) _annex.eContainer()).getName() ;
      System.out.println("*** try to parse " + annexName + " in " +
            _parentContainer + " from " + filename) ;

      if(annexText.length() > 6)
      {
        annexText = annexText.substring(3, annexText.length() - 3) ;
      }

      as =
            _parser.parseAnnexSubclause(annexName, annexText, _filename, _line,
                                        _offset, _parserErrReporter) ;

      if(as != null && _parserErrReporter.getNumErrors() == 0)
      {
        as.setName(annexName) ;
        // replace default annex library with the new one.
        EList<AnnexSubclause> ael =
              ((Classifier) _annex.eContainer()).getOwnedAnnexSubclauses() ;
        int idx = ael.indexOf(_annex) ;
        ael.add(idx, as) ;
        ael.remove(_annex) ;
        _annexElements = Collections.singletonList(as) ;
        result = true ;
      }
      else
      {
        result = false ;
      }
    }
    catch(RecognitionException e)
    {
      e.printStackTrace() ;
      result = false ;
    }

    return result ;
  }

  // Caller may add this code after resolve()
  /*
  if(_resolveErrManager.getNumErrors()>0)
  {
     diagnosticsConsumer.consume(
                             new XtextSyntaxDiagnostic(node),
                             Severity.ERROR);
  }
  */
  public boolean resolve()
  {
    if(_annexElements != null)
    {
      //DEBUG
      String filename = (new File(_filename)).getName() ;
      System.out.println("*** try to resolve " + _annex.getName() + " in " +
            _parentContainer + " from " + filename) ;
      _resolver.resolveAnnex(_annex.getName(), _annexElements, _errManager) ;
      return _errManager.getNumErrors() == 0 ;
    }
    else
    {
      return false ;
    }
  }
}
