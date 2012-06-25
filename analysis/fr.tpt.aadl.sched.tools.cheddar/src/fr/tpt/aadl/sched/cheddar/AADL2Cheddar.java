package fr.tpt.aadl.sched.cheddar ;

import java.util.ArrayList ;
import java.util.List ;

import org.jdom.Document ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.launch.PluginActivator ;
import fr.tpt.aadl.flow.model.ExecutionGraphRegistry ;
import fr.tpt.aadl.sched.cheddar.model.CheddarElement ;
import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.strategies.CheddarModelConversionPart ;

public class AADL2Cheddar
{

  /** Strategy to extract Cheddar model from an AADL model. */
  private CheddarContext strategy ;

  private final SystemInstance root ;

  private final ExecutionGraphRegistry registry ;

  private String OUTPUT_PATH = null ;

  private Document cheddarXML = null ;

  /** Tool which export Cheddar model in XML file. */
  private Cheddar2XML modelToXML = new Cheddar2XML() ;

  private CheddarModel cheddarModel = null ;
  private List<CheddarElement> cheddarElements = null ;

  private final String prefix ;

  private final float scaling ;

  //FIXME: remove registry, execution graph analysis must be isolated from Cheddar

  public AADL2Cheddar(
                      String prefix, SystemInstance root,
                      AnalysisErrorReporterManager errManager, float scaling)
  {
    this.root = root ;
    this.prefix = prefix ;
    this.scaling = scaling ;
    this.strategy = CheddarContext.getContextFor(root) ;
    this.registry = new ExecutionGraphRegistry(root, errManager) ;
    this.strategy.setExecutionRegistry(this.registry) ;
  }

  /*
  public void addSupport()
  {
    registry.addGraphVisitor(new ExecutionGraphPrinter());
    registry.addGraphVisitor(new Automaton2DOT("/home/fabien/tmp/cheddar/"));
  }*/

  public void createCheddarModel()
  {
    CheddarModelConversionPart.init() ;
    OUTPUT_PATH =
          PluginActivator.getInstance().getSimulationDirectory(root.eResource()) + prefix +
                root.getName() + ".xml" ;
    /** Step 1 : Extract Cheddar Model from AADL Model. */
    cheddarElements = new ArrayList<CheddarElement>() ;
    strategy.getExtractionSection(ComponentCategory.PROCESSOR)
          .export(root, cheddarElements) ;
    strategy.getExtractionSection(ComponentCategory.PROCESS)
          .export(root, cheddarElements) ;
    cheddarModel = new CheddarModel(cheddarElements, strategy, root) ;
    cheddarModel.setScaling(scaling) ;
  }

  public void exportCheddarModel()
  {
    if(cheddarElements == null)
    {
      createCheddarModel() ;
    }

    /** Step 2 : Export Cheddar Model in XML File. */
    cheddarXML = modelToXML.generateXML(cheddarModel, OUTPUT_PATH) ;
    //XMLUtil.printXML(cheddarXML);
    /** Step 3 : Notify observers. */
    //strategy.getExecutionRegistry().notifyVisitors();
  }

  public String getCheddarXMLPath()
  {
    return OUTPUT_PATH ;
  }

  public Document getCheddarXML()
  {
    if(cheddarXML == null)
    {
      exportCheddarModel() ;
    }

    return cheddarXML ;
  }

  public CheddarModel getCheddarModel()
  {
    if(cheddarModel == null)
    {
      exportCheddarModel() ;
    }

    return cheddarModel ;
  }
}
