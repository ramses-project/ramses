package fr.tpt.aadl.ramses.transformation.selection.manual;


import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileInputStream ;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.LineNumberReader ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Properties ;

import javax.swing.JOptionPane ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.SystemInstance ;
//import org.eclipse.uml2.uml.NamedElement;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManager ;
import fr.tpt.aadl.ramses.transformation.selection.IHM.GlobalVariables ;
import fr.tpt.aadl.ramses.transformation.selection.IHM.IHM ;
import fr.tpt.aadl.ramses.transformation.launcher.ArchitectureRefinementProcessLauncher ;
import fr.tpt.aadl.ramses.transformation.selection.ITransformationSelection ;
import fr.tpt.aadl.ramses.transformation.selection.RuleApplicationUtils ;
import fr.tpt.aadl.ramses.transformation.selection.TransformationRuleAlternative ;
import fr.tpt.aadl.ramses.transformation.selection.TupleEntry ;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation ;
import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTuple ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcParser ;

/**
 * This class was made to do manual selection
 * 
 * @author felix SILINOU KAMDEM
 * 
 */
public class ManualSelection implements ITransformationSelection,LoopManager {
	private TrcSpecification trc;
	private Map<String,EObject> EobjectList_NameKey = new HashMap<String,EObject>();
	private Map<EObject,String> EObjectList_EObjectKey = new HashMap<EObject,String>();
	
	private Map<List<EObject>, List<String>> AlternativesRules = new HashMap<List<EObject>, List<String>>();
	int loopIteration=0;
	
	private IHM frame ; 
	
  private static Logger _LOGGER = Logger.getLogger(ManualSelection.class) ;
  
  AadlTargetSpecificGenerator generator;
  Resource currentImplResource;
  AbstractLoop l;
  AnalysisErrorReporterManager errManager;
  WorkflowPilot workflowPilot;
  RamsesConfiguration config;
  IProgressMonitor monitor;  

  Properties prop;
  
  public ManualSelection(AadlTargetSpecificGenerator aadlTargetSpecificGenerator,
                         AbstractLoop l,
                         AnalysisErrorReporterManager errManager,
                         WorkflowPilot workflowPilot,
                         RamsesConfiguration config, IProgressMonitor monitor)
  {
    String propertyFile = (String) config.getParameters().get(Names.RAMSES_PROPERTIES);
    
    this.generator = aadlTargetSpecificGenerator;
    this.l = l;
    this.errManager = errManager;
    this.workflowPilot = workflowPilot;
    this.config = config;
    this.monitor = monitor;
    
    prop = new Properties();
    try {
      InputStream in = new FileInputStream(propertyFile);
      prop.load(in);
    } catch (IOException e) {
      String message = "could not open property file "
          + propertyFile;
      _LOGGER.error(message);
      e.printStackTrace();
    }
    
    currentImplResource = generator.currentImplResource;
    
    ResourceSet rs = currentImplResource.getResourceSet();
    
    String trcPath = prop.getProperty("ArchitectureRefinementLauncher.trc");
    if(trcPath!=null)
      TrcParser.parse(trcPath, rs);
    List<Transformation> list = l.getTransformations();
    Resource r = list.get(0).eResource();
    trc = (TrcSpecification) r.getContents().get(0);
  }

	@SuppressWarnings("unchecked")
	@Override
	public void selectTransformation(
			Map<List<EObject>, ArrayList<String>> patternMatchingMap,
			ArrayList<ElementTransformation> tuplesToApply) {
		String message = "In manual selection branch";
		_LOGGER.trace(message);
				
		GlobalVariables.applytuple = tuplesToApply;
		System.out.println("******************* Start debugin *********************");
		// patternMatchingMap = Map< List<Elt>,List<Transformation> >	; Transformation = {rule}	
		// first put patternMatchingMap in this form List< Elt,List<Transformation> > it is the list of rule that can be applied on one element
		//Object[] ob;EObject, List<String>
		List <Object[] > patternMatchingMap2=null;
		
		// retreive elt into patternMatchingMap as a collection
		Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingCollection = patternMatchingMap.entrySet().iterator();
		
		List<List<RuleApplicationTuple>> exclusionDependencies = new ArrayList<List<RuleApplicationTuple>>();
		//unnamedEobjects= null ;
		// for debuging
		String inFile = "../fileRamses.rdsl";
		createNewFile(inFile);
		ArrayList<String> mesElts = new ArrayList<String>();
		ArrayList<EObject> mesObjs = new ArrayList<EObject>();
		ArrayList<String> applyAStr = new ArrayList<String>();
		List<List<TaggedRuleApplicationTuple>> TaggedRuleApplicationT =  new ArrayList<List<TaggedRuleApplicationTuple>>();
		String afficheLesObjets = "";
		int cpt=1;
		int cptOb=0;
		int objectNumber=1; 
		// iterate through a collection, for each key entry retreive the list of rule that can be applied
		for (Iterator iterator = patternMatchingCollection; iterator.hasNext();) {
			String applyStr = "";
			Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>)iterator.next();
			List<String> candidateTransformationList = tuple.getValue();
			List<EObject> candidateObjects = tuple.getKey();
			
			// Get all the EObjects and affect for each one a unique name if he does'nt have one already
			//The map EObjectList_EObjectKey has EObjects reference as Keys and the values are the name of the EObjects
			//The map EobjectList_NameKey has EObjects Name as Keys and the values are the Reference for the EObjects
			for (int k = 0; k < candidateObjects.size(); k++){
					if(getKeyByValue(candidateObjects.get(k))==null){
							if(candidateObjects.get(k) instanceof NamedElement ){
								//EObjectList_EObjectKey.put(candidateObjects.get(k),((NamedElement) candidateObjects.get(k)).getQualifiedName());
								EobjectList_NameKey.put(((NamedElement) candidateObjects.get(k)).getQualifiedName(),candidateObjects.get(k));
							}
							else {
								//EObjectList_EObjectKey.put(candidateObjects.get(k), candidateObjects.get(k).getClass().getName()+ (objectNumber));		
								EobjectList_NameKey.put( candidateObjects.get(k).getClass().getName()+ (objectNumber++) , candidateObjects.get(k));					
							}
					}
					
					if(candidateObjects.get(k) instanceof NamedElement ){
						EObjectList_EObjectKey.put(candidateObjects.get(k),((NamedElement) candidateObjects.get(k)).getQualifiedName());
					}
					else {
						EObjectList_EObjectKey.put(candidateObjects.get(k), candidateObjects.get(k).getClass().getName()+ (objectNumber));		
					}						
			}
			
			GlobalVariables.EObjectList_EObjectKey=EObjectList_EObjectKey;
			
			
			if (candidateTransformationList.size()>1) {
				
				AlternativesRules.put(candidateObjects, candidateTransformationList);
						
				afficheLesObjets += "\n Alternative "+cpt+":\n" ;
				afficheLesObjets += "\tfor {";
				for (int j = 0; j < candidateObjects.size(); j++) {
					if (j==0) {
						if(candidateObjects.get(j) instanceof NamedElement){
							//afficheLesObjets += ((NamedElement) candidateObjects.get(j)).getQualifiedName();
							afficheLesObjets += ((NamedElement) candidateObjects.get(j)) ; //.getQualifiedName();

						}
						else {
							//afficheLesObjets += getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb ;
							afficheLesObjets += candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb ;

						}
					} else {
						if(candidateObjects.get(j) instanceof NamedElement){
							//afficheLesObjets += ", " + ((NamedElement) candidateObjects.get(j)).getQualifiedName();
							afficheLesObjets += ", " + ((NamedElement) candidateObjects.get(j));//.getQualifiedName();

						}
						else {
							//afficheLesObjets += ", " + getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb;
							afficheLesObjets += ", " + candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb;

						}
					}
					cptOb +=1;
				}
				afficheLesObjets += "} select:\n";
				int cptVal=0;
				for (int j = 0; j < candidateTransformationList.size(); j++) {
					if (cptVal==0) {
						afficheLesObjets += "\t" + candidateTransformationList.get(j);
					} else {
						afficheLesObjets += " or " + candidateTransformationList.get(j);
					}
					cptVal +=1;
				} 
//				afficheLesObjets += ";\n";
//				afficheLesObjets +="Decision "+cpt+" : Select "+ candidateTransformationList.get(0) +" for {"+printAllObjects(candidateObjects)+"} ;\n";
//				TaggedRuleApplicationT = TrcUtils.getNormalizedDependencies(trc, candidateObjects, candidateTransformationList.get(0));
//				afficheLesObjets += printListList(TaggedRuleApplicationT,Integer.toString(cpt));
				cpt +=1;
			}
			else{
				
				//GlobalVariables.tuplesToApply.add(new ChoosenRulesToApply(candidateObjects,candidateTransformationList.get(0)));
				applyStr += "\nApply Rule ";
				int cptVal=0;
				for (int j = 0; j < candidateTransformationList.size(); j++) {
					if (cptVal==0) {
						applyStr += "\t" + candidateTransformationList.get(j);
					} else {
						applyStr += " or " + candidateTransformationList.get(j);
					}
					cptVal +=1;
				} 
				applyStr += " for Elements {";
				for (int j = 0; j < candidateObjects.size(); j++) {
					if (j==0) {
						if(candidateObjects.get(j) instanceof NamedElement)
							applyStr += ((NamedElement) candidateObjects.get(j));
//applyStr += ((NamedElement) candidateObjects.get(j)).getQualifiedName();
						else 
							applyStr += candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb ;
						//applyStr += getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb ;
					} else {
						if(candidateObjects.get(j) instanceof NamedElement)
							applyStr += ", " + ((NamedElement) candidateObjects.get(j));
					//	applyStr += ", " + ((NamedElement) candidateObjects.get(j)).getQualifiedName();
						else 
							applyStr += ", " + candidateObjects.get(j);//candidateObjects.get(j).getClass().getName()+" "+cptOb;
					//	applyStr += ", " + getKeyByValue(candidateObjects.get(j));//candidateObjects.get(j).getClass().getName()+" "+cptOb;

					}
					cptOb +=1;
				}
				applyStr += "};";
				applyAStr.add(applyStr);
//				TaggedRuleApplicationT = TrcUtils.getNormalizedDependencies(trc, candidateObjects, candidateTransformationList.get(0));
//				applyAStr.add(printListList(TaggedRuleApplicationT));
			}

		}
		
		
		// Add apply Rule in the file
		for (int i = 0; i < applyAStr.size(); i++) {
			afficheLesObjets += applyAStr.get(i);
		}
		
//		afficheLesObjets += "\n\n nombre d'elements "+cpt;
//		afficheLesObjets += "\n\n\n";
		copyIntoFile(inFile, afficheLesObjets);
		//afficheMap();
		
		GlobalVariables.toIHM = AlternativesRules; 
		frame = new IHM (trc);
		frame.setVisible(true);
		
	    Thread t = new Thread() {
	        public void run() {
	            synchronized(GlobalVariables.lock) {
	                    try {
	    	                System.out.println("Waiting now");
	                    	GlobalVariables.lock.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                System.out.println("Working now");
	        		if(GlobalVariables.doneSelecting) {
	        			_LOGGER.trace("*********************** Validate 	*************************");
	        			for(int i=0; i<GlobalVariables.tuplesToApply.size();i++)
	        			{
	        				GlobalVariables.testMap.clear();
	        				GlobalVariables.testMap.put(GlobalVariables.tuplesToApply.get(i).EObjectList, (ArrayList) GlobalVariables.tuplesToApply.get(i).Rules);
	        				Map.Entry<List<EObject>, ArrayList<String>> tuple = GlobalVariables.testMap.entrySet().iterator().next();
	        				if( GlobalVariables.tuplesToApply.get(i).Rules.size()>1){
		        				try{	 
		        				  TransformationRuleAlternative tra = new TransformationRuleAlternative(tuple.getKey(), 
		        	                                                                              tuple.getValue());
		        	        
			        					RuleApplicationUtils.setTransformationToApply(tra, GlobalVariables.tuplesToApply.get(i).getChoosenRule(), GlobalVariables.applytuple);
			        					//System.out.println("setTransformationToApply is succefully set !");
			        				}
			        				catch(Exception e){
			        					 e.printStackTrace();
			        					 
			        				}
	        				}

	        			}
	        			JOptionPane.showMessageDialog(frame,
	        				    "Your validation has succeeded.\nClick Ok to Continue");
	        		}
	        		else {
	        			System.out.println("*********************** End debugin *************************");
	        			JOptionPane.showMessageDialog(frame,
	        				    "You exited without validating you Alternatives!\nClick Ok to Continue",
	        				    "No choices are made",
	        				    JOptionPane.WARNING_MESSAGE);
	        			//ServiceProvider.SYS_ERR_REP.error("Not Implemented Yet", false);
	        		}
	            }
	        }
	    };
	    t.start();  			
		try
    {
      t.join();
    }
    catch(InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	}
	
	private String printListList(
			List<List<TaggedRuleApplicationTuple>> taggedRuleApplicationList, String compteur) {
		
		String Printable= "Consequences : null \n";
		int k=0 ;
		int i=0;
		List<TaggedRuleApplicationTuple> taggedRuleApplicationTuple = new ArrayList<TaggedRuleApplicationTuple>();		
		for (k = 0; k < taggedRuleApplicationList.size(); k++){		
			if(k== 0) Printable= "Consequences : \n";
			taggedRuleApplicationTuple.addAll(taggedRuleApplicationList.get(k));
			Printable += "\tdecision: "+ compteur+"."+(k+1)+ " : \n" ;
			for (i = 0; i < taggedRuleApplicationTuple.size(); i++){
				if(i <taggedRuleApplicationTuple.size()-1){
					if(!taggedRuleApplicationTuple.get(i).isExclusion()){
						Printable += "\t\t\tSELECT " + taggedRuleApplicationTuple.get(i).getTransformationRuleName() ; 
						Printable += " for { " + printAllObjects(taggedRuleApplicationTuple.get(i).getPatternMatchedElement()) +" }";
					}
					else{
						Printable += "\t\t\tEXCLUDE " + taggedRuleApplicationTuple.get(i).getTransformationRuleName();
						Printable += " for { " +printAllObjects(taggedRuleApplicationTuple.get(i).getPatternMatchedElement())+" }\n" ; 
					}	
				}
				else {
					if(!taggedRuleApplicationTuple.get(i).isExclusion()){
						Printable += "\t\t\tOR\n " ;
						Printable += "\t\t\tSELECT " + taggedRuleApplicationTuple.get(i).getTransformationRuleName() ; 
						Printable += " for { " + printAllObjects(taggedRuleApplicationTuple.get(i).getPatternMatchedElement()) +" }\n";
					}
					else{
						Printable += "\t\t\tAND\n " ;
						Printable += "\t\t\tEXLUDE " + taggedRuleApplicationTuple.get(i).getTransformationRuleName();
						Printable += " for { " +printAllObjects(taggedRuleApplicationTuple.get(i).getPatternMatchedElement())+" }" ; 
					}	
				}

//				if(i != taggedRuleApplicationTuple.size()-1)
//					Printable +="\n";
				Printable += "\n";
			}
		}
		Printable += "\n";
		System.out.println(Printable);
		return Printable; 
	}

	private String printAllObjects(List<EObject> eobjects){
		
		String eobject_String= "";
		for (int k = 0; k < eobjects.size(); k++){
			if(k<eobjects.size()-1) eobject_String += getKeyByValue(eobjects.get(k)) +", ";
			else eobject_String +=getKeyByValue(eobjects.get(k));
		}	
		return eobject_String;
	}
	
	public void afficheMap(){
		Iterator<Entry<String,EObject>> EObject_NameKey_Element = EobjectList_NameKey.entrySet().iterator();
		for (Iterator iterator = EObject_NameKey_Element; iterator.hasNext();)
		{
			Map.Entry<String,EObject> tuple = (Map.Entry<String,EObject>)iterator.next();
			EObject EobjectRef = tuple.getValue();
			String EObjectName = tuple.getKey();
			System.out.println("EObject  :  "+ EObjectName+"\t\t"+EobjectRef.toString());
		}	
	}
	
	public String getKeyByValue(EObject object){
		Iterator<Entry<String,EObject>> EObject_NameKey_Element = EobjectList_NameKey.entrySet().iterator();
		for (Iterator iterator = EObject_NameKey_Element; iterator.hasNext();)
		{
			Map.Entry<String,EObject> tuple = (Map.Entry<String,EObject>)iterator.next();
			EObject EobjectRef = tuple.getValue();
			String EObjectName = tuple.getKey();
			if(object == EobjectRef ){
				return EObjectName;
			}
		}
		return null;
	}
	
	 public List<String> transformationsToApply(List<String> candidateTransformationList, Entry<List<EObject>, ArrayList<String>> tuple, List<List<RuleApplicationTuple>> exclusionDependencies) {
		    List<String> transformationsToApply = null; 
		  
			if(candidateTransformationList.size()==1){
				transformationsToApply = candidateTransformationList;
			}
			else {
				List<String> newCandidateTransformationList = new ArrayList<String>();
				newCandidateTransformationList.addAll(tuple.getValue());
				
				for(List<RuleApplicationTuple> toExcludeList: exclusionDependencies)
				{
					for(RuleApplicationTuple toExclude: toExcludeList)
					{
						// verify if our EObject containt List<EObject> _patternMatchedElementList
						if(!containsAll(tuple.getKey(), toExclude.getPatternMatchedElement()))
							continue;
						for(String s: tuple.getValue())
						{
							// toExclude.getTransformationRuleName() == _transformationRuleName
							if(s.equalsIgnoreCase(toExclude.getTransformationRuleName()))
							{
								newCandidateTransformationList.remove(s);
							}
							else{
								System.out.println("tuple.getValue() = "+tuple.getValue()+" !=	toExclude.getTransformationRuleName()");
							}
						}
					}
					
					// Tuple to use
					TupleEntry newTuple = new TupleEntry(tuple.getKey(), newCandidateTransformationList);
					
					// We select all dependency					
					if(((List<String>)newTuple.getValue()).size()>=1)
					{
						transformationsToApply = (List<String>)newTuple.getValue();
						break;
					}
					else
					{
						continue;
					}
					
				}
				if(exclusionDependencies.isEmpty())
				{
					transformationsToApply = (List<String>)tuple;
				}
				if(transformationsToApply == null)
					try {
						throw new Exception("Could not find transformation to apply after considering exclusions for" +
								tuple.getValue());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			return transformationsToApply;
	  }	
	
	private boolean containsAll(List<EObject> key, List<EObject> patternMatchedElement) {
		for(EObject o: patternMatchedElement)
		{
			if(false == key.contains(o))
				return false;
		}
		return true;
	}

	public static void createNewFile(String fileName) {
		File nomFichier = new File(fileName);
		try {
			nomFichier.createNewFile();
			System.out.println(System.getProperty("user.dir"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyIntoFile(String inFile, String string2write) {
		if ((new File(inFile)).exists()) {
			BufferedWriter out;
			try {
				out = new BufferedWriter(new FileWriter(inFile));
				out.write(string2write);
				out.newLine();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Le fichier n'existe pas");
		}
	}

	public static void printFileContaint(String source) {
		if ((new File(source)).exists()) {
			try {
				String ligneLue;
				// creation du flux
				FileReader fr = new FileReader(source);
				LineNumberReader lnr = new LineNumberReader(fr);
				try {
					// lecture et affichage des donn�es
					while ((ligneLue = lnr.readLine()) != null) {
						System.out.println(ligneLue);
					}
				}
				// lib�ration des ressources
				finally {
					lnr.close();
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Le fichier n'existe pas");
		}
	}

  @Override
  public boolean shouldSelectionContinue()
  {
    // TODO Auto-generated method stub
    return false ;
  }


  @Override
  public String getResolutionMethodName()
  {
    return ResolutionMethod.MANUAL_MERGE.getName() ;
  }


  @Override
  public Map<? extends String, ? extends Resource>
      processLoop() throws AnalysisException, ParseException,
                   TransformationException, ConfigurationException, IOException
  {
    Map<String, Resource> resultingMap = new HashMap<String, Resource>();
    
    ArchitectureRefinementProcessLauncher mergeLauncher = new ArchitectureRefinementProcessLauncher
        (trc,
         this.currentImplResource.getResourceSet(),
         config,
         this,
         prop,
         l.getTransformations(),
         generator._modelInstantiator,
         generator._predefinedResourceManager
         );
    
    SystemInstance sinst = (SystemInstance) this.currentImplResource.getContents().get(0);
    loopIteration++;
    Resource result = mergeLauncher.launch(sinst, workflowPilot.getOutputModelId(), l.getIterationNb());
    String modelIdSuffix = "_iter_"+loopIteration;
    resultingMap.put(workflowPilot.getOutputModelId()+modelIdSuffix, result);
    return resultingMap;
  }

  @Override
  public String getModelIdSuffix()
  {
    return workflowPilot.getOutputModelId() +  "_iter_"+ loopIteration;
  }

  @Override
  public int getCurrentIterationNb()
  {
    return loopIteration;
  }
	

}
