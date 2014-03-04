package fr.tpt.aadl.ramses.generation.ada;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.ba.AadlBaParserAction ;
import org.osate.ba.AadlBaUnParserAction ;
import org.osate.ba.analyzers.TypeHolder ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.DimensionException ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.PropertyNotFound ;
import org.osate.utils.PropertyUtils ;
import org.osate.utils.names.DataModelProperties ;

import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider;
import fr.tpt.aadl.ramses.generation.ada.AadlToADASwitchProcess;
import fr.tpt.aadl.ramses.generation.ada.AadlToADAUnparser;
import fr.tpt.aadl.ramses.generation.ada.GenerationUtilsADA;
import fr.tpt.aadl.ramses.generation.ada.annex.behavior.AadlBaToADAUnparser;
import fr.tpt.aadl.ramses.generation.ada.annex.behavior.AadlBaToADAUnparserAction;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;

public class AadlToADAUnparser extends AadlProcessingSwitch implements AadlGenericUnparser
{
	private AadlBaToADAUnparserAction baToADAUnparserAction = new AadlBaToADAUnparserAction();
	private static AadlToADAUnparser singleton;

	
    public static String period = null ;
    public static String deadline = null ;
    public static String dispatchProtocol = null;
    public static String priority =null;
    
    // gtype.ads and .adb
	protected AadlToADASwitchProcess _gtypesHeaderCode ;
	protected AadlToADASwitchProcess _gtypesImplCode ;
	
	// subprogram.adb and .ads
	protected AadlToADASwitchProcess _subprogramImplCode ;
	protected AadlToADASwitchProcess _subprogramHeaderCode ;

	// partition's deployment.adb and .ads
	protected AadlToADASwitchProcess _deploymentImplCode ;
	protected AadlToADASwitchProcess _deploymentHeaderCode ;

	// partition's deployment.h
	protected AadlToADASwitchProcess _deploymentCHeaderCode ;
	  
	// activity.adb and .ads
	protected AadlToADASwitchProcess _activityImplCode ;
	protected AadlToADASwitchProcess _activityHeaderCode ;

	// Temporary .adb and .adb files.
	private AadlToADASwitchProcess _currentImplUnparser ;
	private AadlToADASwitchProcess _currentHeaderUnparser ;

	private Map<AadlToADASwitchProcess, Set<String>> _additionalHeaders ;

	private List<String> _processedTypes  ;
    public Set<NamedElement> additionalUnparsing = new LinkedHashSet<NamedElement>();
    private static final String MAIN_HEADER_INCLUSION = "" ;

//    private static final String MAIN_HEADER_INCLUSION = "#include \"main.h\"\n" ;
	// Map Data Access with their relative Data Subcomponent. Relations 
	// are defined in the process implementation via connections.
	private Map<DataAccess, String> _dataAccessMapping = new HashMap<DataAccess, String>();
	
	private List<SubprogramClassifier> subprogramsUnparsingStack = new ArrayList<SubprogramClassifier>();

	public static AadlToADAUnparser getAadlToADAUnparser()
	{
		if(singleton==null)
			singleton = new AadlToADAUnparser();
		return singleton;
	}

	private AadlToADAUnparser()
	{
		super() ;
		init() ;
	}

	private void init()
	{
		
		_gtypesHeaderCode = new AadlToADASwitchProcess(this) ;
		_gtypesImplCode = new AadlToADASwitchProcess(this) ;
		_gtypesImplCode.addOutputNewline("\npackage body Gtypes is") ;
		
		_subprogramImplCode = new AadlToADASwitchProcess(this) ;
		_subprogramImplCode.addOutputNewline("\npackage body Subprograms is") ;
		_subprogramImplCode.incrementIndent();
		_subprogramHeaderCode = new AadlToADASwitchProcess(this) ;
		_subprogramHeaderCode.incrementIndent();


		_deploymentHeaderCode = new AadlToADASwitchProcess(this) ;
	    _deploymentCHeaderCode = new AadlToADASwitchProcess(this) ;
	    
		_activityImplCode = new AadlToADASwitchProcess(this) ;
		_activityImplCode.addOutputNewline("\npackage body Activity is") ;
		_activityImplCode.incrementIndent();

		_activityHeaderCode = new AadlToADASwitchProcess(this) ;
		_activityHeaderCode.addOutputNewline("");
		_activityHeaderCode.incrementIndent();
		
		_deploymentImplCode = new AadlToADASwitchProcess(this) ;
		_deploymentImplCode.addOutputNewline("\npackage body Deployment is") ;

		_processedTypes = new ArrayList<String>() ;

		_additionalHeaders = new HashMap<AadlToADASwitchProcess, Set<String>>() ;

	}

	public List<PrototypeBinding> getCurrentPrototypeBindings(String ctxt)
	  {
		  System.out.println("Inherited prototype bindings for " + ctxt);
		  
		  List<PrototypeBinding> bindings = new ArrayList<PrototypeBinding>();
		  for(SubprogramClassifier c: subprogramsUnparsingStack)
		  {
			  System.out.println("  prototype bindings from " + c.getName());
			  List<PrototypeBinding> cBindings = c.getOwnedPrototypeBindings();
			  for(PrototypeBinding b : cBindings)
			  {
				  if(b instanceof FeaturePrototypeBinding)
				  {
					  FeaturePrototypeBinding cpb = (FeaturePrototypeBinding) b;
					  SubcomponentType st = null;
					  if(cpb.getActual() instanceof AccessSpecification)
					  {
						  st = ((AccessSpecification)cpb.getActual()).getClassifier();
					  }
					  else if(cpb.getActual() instanceof PortSpecification)
					  {
						  st = ((PortSpecification)cpb.getActual()).getClassifier();
					  }
					  System.out.println("    prototype binding " + b.getFormal().getName() + " => " + st.getName());

				  }
				  else
				  {
					  ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) b;
					  SubcomponentType st = cpb.getActuals().get(0).getSubcomponentType();
					  System.out.println("    prototype binding " + b.getFormal().getName() + " => " + st.getName());

				  }
				  
			  }			  
			  bindings.addAll(cBindings);
		  }
		  return bindings;
	  }
	public void saveGeneratedFilesContent(File targetDirectory)
	{

		_gtypesHeaderCode.addOutputNewline("\nend Gtypes;\n") ;
		_gtypesImplCode.addOutputNewline("\nend Gtypes;\n") ;
		
		_subprogramHeaderCode.addOutputNewline("\nend Subprograms;\n") ;
		_subprogramImplCode.addOutputNewline("\nend Subprograms;\n") ;
		
		_activityHeaderCode.addOutputNewline("\nend Activity;\n") ;
		_activityImplCode.addOutputNewline("\nend Activity;\n") ;
		
		_deploymentHeaderCode.addOutputNewline("\nend Deployment;\n") ;
	    _deploymentCHeaderCode.addOutputNewline("\n#endif\n") ; 
		_deploymentImplCode.addOutputNewline("procedure Deployment is");
		_deploymentImplCode.addOutputNewline("begin");
		_deploymentImplCode.addOutputNewline("null;");		
    	_deploymentImplCode.addOutputNewline("end Deployment;");
		_deploymentImplCode.addOutputNewline("\nend Deployment;\n") ;
		
		try
		{
			String headerGuard = null ;
    		
    		
			// gtypes.ads
			FileWriter typesFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("gtypes.ads") ;
			String addGtypesHeader_ADS = "with System; use System;\n";
			addGtypesHeader_ADS += getGeneratedCodeForAdditionalHeaders(_gtypesHeaderCode) + headerGuard;
			saveFile(typesFile_ADS, "", addGtypesHeader_ADS,
					_gtypesHeaderCode.getOutput()) ;

			// gtypes.adb
			FileWriter typesFile_ADA =
					new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.adb") ;
			String addTypeHeader_ADA = getGeneratedCodeForAdditionalHeaders(_gtypesImplCode) ;
			saveFile(typesFile_ADA, addTypeHeader_ADA, _gtypesImplCode.getOutput()) ;

			// subprogram.adb
			FileWriter subprogramsFile_ADB =
					new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.adb") ;
			String addSubprogramHeader_ADB = getGeneratedCodeForAdditionalHeaders(_subprogramImplCode) ;
			saveFile(subprogramsFile_ADB, addSubprogramHeader_ADB,
					_subprogramImplCode.getOutput()) ;

			// subprogram.ads
			FileWriter subprogramsFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("subprograms.ads");
			String addSubprogramsHeader_ADS = getGeneratedCodeForAdditionalHeaders(_subprogramHeaderCode);
			addSubprogramsHeader_ADS += "with Gtypes; use Gtypes;\nwith System; use System;\n" + headerGuard;
			saveFile(subprogramsFile_ADS, "", addSubprogramsHeader_ADS,
					_subprogramHeaderCode.getOutput()) ;

			// activity.adb
			FileWriter activityFile_ADB =
					new FileWriter(targetDirectory.getAbsolutePath() + "/activity.adb") ;
			String addActivityHeader_ADB = getGeneratedCodeForAdditionalHeaders(_activityImplCode) ;
			saveFile(activityFile_ADB, addActivityHeader_ADB, _activityImplCode.getOutput()) ;

			// activity.ads
			FileWriter activityFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/activity.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("activity.ads");
			String addActivityHeader_ADS = "with System;use System;\nwith Subprograms;use Subprograms;\n" +
					"with Gtypes; use Gtypes;\nwith Deployment; use Deployment;\n";
			addActivityHeader_ADS += getGeneratedCodeForAdditionalHeaders(_activityHeaderCode) + headerGuard;
			saveFile(activityFile_ADS, "",
					addActivityHeader_ADS, _activityHeaderCode.getOutput()) ;

			// partition's deployment.ads
			FileWriter deploymentFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("deployment.ads");
			String addDeploymentHeader_ADS = "with Gtypes; use Gtypes;\n";
			addDeploymentHeader_ADS += getGeneratedCodeForAdditionalHeaders(_deploymentHeaderCode) + headerGuard;
			saveFile(deploymentFile_ADS, "", addDeploymentHeader_ADS, _deploymentHeaderCode.getOutput()) ;
		
		      // partition's deployment.h
		      FileWriter deploymentFile_H =
		            new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.h") ;
		      headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("deployment.h");
		      String addDeploymentHeader_H = getGeneratedCodeForAdditionalHeaders(_deploymentCHeaderCode) ;
		      saveFile(deploymentFile_H, headerGuard, MAIN_HEADER_INCLUSION,
		               addDeploymentHeader_H, _deploymentCHeaderCode.getOutput()) ;

		      // partition's deployment.adb
			  FileWriter deploymentFile_ADB =
					new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.adb") ;
			  String addDeploymentHeader_ADB = getGeneratedCodeForAdditionalHeaders(_deploymentImplCode) ;
			  saveFile(deploymentFile_ADB, addDeploymentHeader_ADB,
				       _deploymentImplCode.getOutput()) ;

		}
		catch(IOException e)
		{
			// TODO: handle error message.
			e.printStackTrace() ;
		}

	}

	  private void clean() {
			this._additionalHeaders.clear();
			this._dataAccessMapping.clear();
		  }

	private String getGeneratedCodeForAdditionalHeaders(AadlToADASwitchProcess fileUnparser)
	{
		StringBuffer res = new StringBuffer("") ;

		if(_additionalHeaders.containsKey(fileUnparser))
		{
			Set<String> additionalTypeHeaders = _additionalHeaders.get(fileUnparser) ;

			for(String s : additionalTypeHeaders)
			{
				s.substring(0, 1).toUpperCase();
				s=fileNameToPackageName(s);
				res.append("with " + s + "; use " + s +";\n") ;
			}
		}

		return res.toString() ;
	}

	private String fileNameToPackageName(String s)
	{
		String res=s;
		if(s.endsWith(".ads") || s.endsWith(".adb"))
			res=s.substring(s.lastIndexOf('/')+1, s.length()-4);
		return res.replace('-', '.');
	}
	
	private void saveFile(FileWriter file,
			String ... content)
	{
		BufferedWriter output ;
		StringBuilder sb = new StringBuilder() ;

		for(String s : content)
		{
			sb.append(s) ;
		}

		try
		{
			output = new BufferedWriter(file) ;

			output.write(sb.toString()) ;

			output.close() ;
		}
		catch(IOException e)
		{
			// TODO: handle error message.
			e.printStackTrace() ;
		}
	}

	Set<String> getAdditionalHeaderSet(AadlToADASwitchProcess sourceTextDest)
	{
		Set<String> l;
		if(_additionalHeaders.containsKey(sourceTextDest) == false)
		{
		  l = new HashSet<String>() ;
		  _additionalHeaders.put(sourceTextDest, l) ;
		}
		else
		{
		  l = _additionalHeaders.get(sourceTextDest) ;
		}
		return l;
	}
	
	public boolean resolveExistingCodeDependencies(NamedElement object,
			AadlToADASwitchProcess sourceNameDest,
			AadlToADASwitchProcess sourceTextDest)
					throws Exception
					{
		Set<String> l = getAdditionalHeaderSet(sourceTextDest);
		String sourceName = GenerationUtilsADA.resolveExistingCodeDependencies(object, l);
		if(sourceName!=null)
		{
		  if(sourceNameDest!=null)
			sourceNameDest.addOutput(sourceName);
		  return true;
		}
		else
			throw new Exception("In component "+object.getName()+": Source_Text " +
		      		"property should also reference a header (.h extension) file");
		
					}

	
	  protected void processDataSubcomponentType(DataSubcomponentType dst,
			  DataSubcomponentType childDst)
	  {
		  if(childDst instanceof DataImplementation)
		  {
			  DataImplementation compImpl = (DataImplementation) childDst;
			  for(DataSubcomponent ds: compImpl.getOwnedDataSubcomponents())
			  {
				  if(ds.getRefined()!=null)
				  {
					  DataSubcomponent refinedDs = (DataSubcomponent) ds.getRefined();
					  AadlToADAUnparser.getAadlToADAUnparser().process(refinedDs.getDataSubcomponentType());
				  }
			  }
			  boolean refined=false;
			  for(DataSubcomponent ds: compImpl.getOwnedDataSubcomponents())
			  {
				  if(ds.getRefined()!=null)
				  {
					  refined=true;
					  _gtypesHeaderCode.addOutput(ds.getRefined().getName()+": ");
					  String refineDsName = GenerationUtilsADA.resolveExistingCodeDependencies(ds.getDataSubcomponentType(), 
							_additionalHeaders.get(AadlToADAUnparser.getAadlToADAUnparser()._gtypesHeaderCode));
					  if(refineDsName==null)
						  refineDsName = GenerationUtilsADA.getGenerationADAIdentifier(ds.getDataSubcomponentType().getQualifiedName());
					  _gtypesHeaderCode.addOutput(refineDsName);
					  _gtypesHeaderCode.addOutputNewline(";");
				  }
			  }
		  }
	  }
	
	protected void processDataSubcomponentType(DataSubcomponentType dst,
			AadlToADASwitchProcess sourceNameDest, 
			AadlToADASwitchProcess sourceTextDest)
	{
		processDataSubcomponentType(null, dst, sourceNameDest, sourceTextDest);
	}

	protected void processDataSubcomponentType(Classifier owner,
			DataSubcomponentType dst,
			AadlToADASwitchProcess sourceNameDest, 
			AadlToADASwitchProcess sourceTextDest)
	{

		try
		{
			String sourceName = GenerationUtilsADA.resolveExistingDependency(dst, getAdditionalHeaderSet(sourceTextDest));
			if(sourceNameDest!=null)
				sourceNameDest.addOutput(sourceName);
			//resolveExistingCodeDependencies(dst, sourceNameDest, sourceTextDest) ;
		}
		catch(Exception e)
		{
			if(dst instanceof DataPrototype && owner!=null)
			{
				for(PrototypeBinding pb: owner.getOwnedPrototypeBindings())
				{
					if(pb instanceof FeaturePrototypeBinding
							&& pb.getFormal().getName().equalsIgnoreCase(dst.getName()))
					{
						FeaturePrototypeBinding fpb = (FeaturePrototypeBinding) pb;
						if(fpb.getActual() instanceof AccessSpecification)
						{
							AccessSpecification as = (AccessSpecification)fpb.getActual();
							if(as.getClassifier() instanceof DataSubcomponentType)
								processDataSubcomponentType(owner, (DataSubcomponentType) as.getClassifier(),
										sourceNameDest, sourceTextDest);
						}
						else if(fpb.getActual() instanceof PortSpecification)
						{
							PortSpecification ps = (PortSpecification)fpb.getActual();
							if(ps.getClassifier() instanceof DataSubcomponentType)
								processDataSubcomponentType(owner, (DataSubcomponentType) ps.getClassifier(),
										sourceNameDest, sourceTextDest);
						}
					}
					if(pb instanceof ComponentPrototypeBinding
							&& pb.getFormal().getName().equalsIgnoreCase(dst.getName()))
					{
						for(ComponentPrototypeActual pa: ((ComponentPrototypeBinding) pb).getActuals())
						{
							if(pa.getSubcomponentType() instanceof DataSubcomponentType)
							{
								DataSubcomponentType dstActual = (DataSubcomponentType) pa.getSubcomponentType();
								processDataSubcomponentType(owner, dstActual, sourceNameDest, sourceTextDest);
								break;
							}
						}
					}
				}
			} 
			else
			{
				if(sourceNameDest!=null)
					sourceNameDest.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(dst
							.getQualifiedName())) ;
			}
		}
	}

	boolean processBehavioredType(ComponentType type)
	{
		return processBehavioredType(type, type);
	}

	boolean processBehavioredType(ComponentType type, ComponentType owner)
	{
		boolean foundRestrictedAnnex = false;
		for(AnnexSubclause annex : type.getOwnedAnnexSubclauses())
		{
			if(annex.getName().equalsIgnoreCase(AadlBaParserAction.ANNEX_NAME))
			{
				foundRestrictedAnnex = true;
				processAnnexSubclause(annex, owner) ;
				break;
			}
		}
		if(!foundRestrictedAnnex && type.getExtended()!=null)
			foundRestrictedAnnex = processBehavioredType(type.getExtended(), owner);
		return foundRestrictedAnnex;
	}

	/**
	 * unparses annex subclause
	 *
	 * @param as
	 *            AnnexSubclause object
	 */
	 public String processAnnexSubclause(AnnexSubclause as, NamedElement owner)
	{
		 AadlToADASwitchProcess codeUnparser;
		 AadlToADASwitchProcess headerUnparser;
		 if(owner instanceof SubprogramClassifier)
		 {
			 codeUnparser = _subprogramImplCode;
			 headerUnparser = _subprogramHeaderCode;
		 }
		 else
		 {
			 codeUnparser = _activityImplCode;
			 headerUnparser = _subprogramHeaderCode;
		 }
		 
		 AadlBaToADAUnparser baToADAUnparser =
					 baToADAUnparserAction.getUnparser() ;

		 baToADAUnparser.setDataAccessMapping(_dataAccessMapping) ;
		 baToADAUnparser.setOwner(owner);

		 baToADAUnparserAction.unparseAnnexSubclause(as,
				 codeUnparser.getIndent());

		 baToADAUnparser.addIndent_ADB(codeUnparser.getIndent()) ;
		 baToADAUnparser.addIndent_ADS(headerUnparser.getIndent()) ;
		 codeUnparser.addOutput(baToADAUnparser.getADAContent()) ;
		 headerUnparser.addOutput(baToADAUnparser.getADSContent()) ;

		 if(_additionalHeaders.get(headerUnparser) == null)
		 {
			 Set<String> t = new HashSet<String>() ;
			 _additionalHeaders.put(headerUnparser, t) ;
			 baToADAUnparser.getAdditionalHeaders().clear();
		 }

		 if (owner instanceof SubprogramType)
		 {
			 subprogramsUnparsingStack.remove(subprogramsUnparsingStack.size()-1);
		 }

		 for(NamedElement ne: baToADAUnparser.getCoreElementsToBeUnparsed())
		 {
			 process(ne);
		 }
		 return DONE ;
	}

	  boolean processBehavioredImplementation(BehavioredImplementation object)
	  {
		  return processBehavioredImplementation(object, object);
	  }
	  
	  public boolean processBehavioredImplementation(BehavioredImplementation object, BehavioredImplementation owner)
	  {
		  boolean foundRestrictedAnnex = false;
		  for(AnnexSubclause annex : object.getOwnedAnnexSubclauses())
	      {
	        if(annex.getName().equalsIgnoreCase(AadlBaUnParserAction.ANNEX_NAME))
	        {
	        	foundRestrictedAnnex = true;
	        	processAnnexSubclause(annex, owner) ;
	        	break;
	        }
	      }
		  if(!foundRestrictedAnnex && !object.getOwnedSubprogramCallSequences().isEmpty())
		  {
		  	for(SubprogramCallSequence scs: object.getOwnedSubprogramCallSequences())
		  	{
		  		process(scs);
		  	}
		  	foundRestrictedAnnex=true;
		  }
		  if(!foundRestrictedAnnex && object.getExtended()!=null)
			  foundRestrictedAnnex = processBehavioredImplementation((BehavioredImplementation)object.getExtended(), object);
		  return foundRestrictedAnnex;
	  }


	 protected void getADATypeDeclarator(NamedElement object)
	 {

		 boolean referencedType = true;
		 try {
			GenerationUtilsADA.resolveExistingDependency(object, _additionalHeaders.get(_currentHeaderUnparser));
		} catch (Exception e1) {
			referencedType=false;
		}
		 if(referencedType)
			 return;
		 
		 String id =
				 GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) ;
		 TypeHolder dataTypeHolder = null ;

		 try
		 {
			 dataTypeHolder = AadlBaUtils.getTypeHolder(object) ;
		 }
		 catch(DimensionException e)
		 {
			 // TODO: handle error message.
			 e.printStackTrace() ;
		 }

		 EList<PropertyExpression> numberRepresentation =
				 PropertyUtils
				 .getPropertyExpression(dataTypeHolder.klass,
						 DataModelProperties.NUMBER_REPRESENTATION) ;
		 String numberRepresentationValue = "" ;

		 for(PropertyExpression n : numberRepresentation)
		 {
			 if(n instanceof NamedValue)
			 {
				 NamedValue el = (NamedValue) n ;
				 numberRepresentationValue =
						 ((EnumerationLiteral) el.getNamedValue()).getName().toLowerCase() ;
				 break;
			 }
		 }

		 // define types the current data type depends on
		 EList<PropertyExpression> referencedBaseType =
				 PropertyUtils
				 .getPropertyExpression(dataTypeHolder.klass,
						 DataModelProperties.BASE_TYPE) ;

		 for(PropertyExpression baseTypeProperty : referencedBaseType)
		 {
			 if(baseTypeProperty instanceof ListValue)
			 {
				 ListValue lv = (ListValue) baseTypeProperty ;

				 for(PropertyExpression v : lv.getOwnedListElements())
				 {
					 if(v instanceof ClassifierValue)
					 {
						 ClassifierValue cv = (ClassifierValue) v ;
						 if(_processedTypes.contains(cv.getClassifier().getQualifiedName())==false && cv.getClassifier() instanceof DataSubcomponentType)
						 {
							 getADATypeDeclarator(cv.getClassifier());
							 _processedTypes.add(cv.getClassifier().getQualifiedName());
						 }
					 }
				 }
			 }
		 }
		 switch ( dataTypeHolder.dataRep )
		 {
		 // Simple types
		 
		 case BOOLEAN :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Boolean;") ;
			 _gtypesHeaderCode.decrementIndent();
			 break ;
		 }
		 case CHARACTER :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Character;") ;
			 _gtypesHeaderCode.decrementIndent();
			 break ;
		 }
		 case FIXED :
			 break ;
		 case FLOAT :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Float;") ;
			 _gtypesHeaderCode.decrementIndent();
			 break ;
		 }
		 case INTEGER :
		 {
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Integer;") ;
				 _gtypesHeaderCode.decrementIndent();
				 break ;	 

		 }
		 case STRING :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is String;") ;
			 _gtypesHeaderCode.decrementIndent();
			 break ;
		 }
		 // Complex types
		 case ENUM :
		 {
			 
			 StringBuilder enumDeclaration = new StringBuilder("type " + id + " is ( ");
		        List<String> stringifiedRepresentation = new ArrayList<String>() ;
		        EList<PropertyExpression> dataRepresentation =
		              PropertyUtils
		                    .getPropertyExpression(dataTypeHolder.klass,
		                                           DataModelProperties.REPRESENTATION) ;

		        for(PropertyExpression representationProperty : dataRepresentation)
		        {
		          if(representationProperty instanceof ListValue)
		          {
		            ListValue lv = (ListValue) representationProperty ;

		            for(PropertyExpression v : lv.getOwnedListElements())
		            {
		              if(v instanceof StringLiteral)
		              {
		                StringLiteral enumString = (StringLiteral) v ;
		                stringifiedRepresentation.add(enumString.getValue()) ;
		              }
		            }
		          }
		        }

		        EList<PropertyExpression> dataEnumerators =
		              PropertyUtils
		                    .getPropertyExpression(dataTypeHolder.klass,
		                                           DataModelProperties.ENUMERATORS) ;

		        for(PropertyExpression enumeratorProperty : dataEnumerators)
		        {
		          if(enumeratorProperty instanceof ListValue)
		          {
		            ListValue lv = (ListValue) enumeratorProperty ;
		            Iterator<PropertyExpression> it =
		                  lv.getOwnedListElements().iterator() ;

		            while(it.hasNext())
		            {
		              PropertyExpression v = it.next() ;

		              if(v instanceof StringLiteral)
		              {
		                StringLiteral enumString = (StringLiteral) v ;
		                String rep = "" ;

		                if(stringifiedRepresentation.isEmpty() == false)
		                {
		                  rep =
		                        " := " +
		                              stringifiedRepresentation.get(lv
		                                    .getOwnedListElements().indexOf(v)) ;
		                }

		                if(it.hasNext())
		                {
		                  rep += "," ;
		                }
		                enumDeclaration.append("\t"+id + "_" +
		                        enumString.getValue() + rep+"\n");
		              }
		            }
		          }
		        }

		        _gtypesHeaderCode.addOutput(enumDeclaration.toString()) ;
		        _gtypesHeaderCode.addOutputNewline(");") ;
		        break ;
	 
		 }
		 case STRUCT :
		 {
			 StringBuilder structDefinition = new StringBuilder("type " + id + " is record\n");
			 EList<PropertyExpression> elementNames =
					 PropertyUtils
					 .getPropertyExpression(dataTypeHolder.klass,
							 DataModelProperties.ELEMENT_NAMES) ;
			 if(elementNames.isEmpty()==false)
			 {
				 List<String> stringifiedElementNames = new ArrayList<String>() ;

				 for(PropertyExpression elementNameProperty : elementNames)
				 {
					 if(elementNameProperty instanceof ListValue)
					 {
						 ListValue lv = (ListValue) elementNameProperty ;

						 for(PropertyExpression v : lv.getOwnedListElements())
						 {
							 if(v instanceof StringLiteral)
							 {
								 StringLiteral eltName = (StringLiteral) v ;
								 stringifiedElementNames.add(eltName.getValue()) ;
							 }
						 }
					 }
				 }

				 EList<PropertyExpression> elementTypes =
						 PropertyUtils
						 .getPropertyExpression(dataTypeHolder.klass,
								 DataModelProperties.BASE_TYPE) ;

				 for(PropertyExpression elementTypeProperty : elementTypes)
				 {
					 if(elementTypeProperty instanceof ListValue)
					 {
						 ListValue lv = (ListValue) elementTypeProperty ;

						 for(PropertyExpression v : lv.getOwnedListElements())
						 {
							 if(v instanceof ClassifierValue)
							 {
								 ClassifierValue cv = (ClassifierValue) v ;
								 String type =
										 GenerationUtilsADA.getGenerationADAIdentifier(cv
												 .getClassifier().getQualifiedName()) ;
								 structDefinition.append("\t"+ stringifiedElementNames.get(lv.getOwnedListElements()
										 .indexOf(v)) +
										 " : " + type
										 + ";\n") ;
							 }
						 }
					 }
				 }
			 }
			 else
			 {
				 if(object instanceof DataImplementation)
				 {
					 DataImplementation impl = (DataImplementation) object;
					 DataImplementation extended = null;
					 if(impl.getOwnedExtension()!=null)
						 extended = (DataImplementation) impl.getOwnedExtension().getExtended();
					 ArrayList<DataImplementation> parentList = new ArrayList<DataImplementation>();
					 parentList.add(impl);
					 while(extended!=null)
					 {
						 parentList.add(extended);
						 extended = (DataImplementation) extended.getExtended();
					 }
					 ArrayList<DataSubcomponent> concatenatedDataSubcomponents = new ArrayList<DataSubcomponent>();
					 ArrayList<DataSubcomponent> updatedConcatenatedDataSubcomponents = 
							 new ArrayList<DataSubcomponent>();
					 for(int i=parentList.size()-1;i>=0;i--)
					 {
						 if(concatenatedDataSubcomponents.isEmpty())
						 {
							 concatenatedDataSubcomponents.addAll(parentList.get(i).getOwnedDataSubcomponents());
							 continue;
						 }
						 updatedConcatenatedDataSubcomponents.addAll(concatenatedDataSubcomponents);
						 for(DataSubcomponent ds: concatenatedDataSubcomponents)
						 {
							 int fake=0;
							 for(DataSubcomponent parentDs: parentList.get(i).getOwnedDataSubcomponents())
							 {
								 if(parentDs.getRefined()!=null
										 && ds.getName().equalsIgnoreCase(parentDs.getRefined().getName()))
								 {
									 updatedConcatenatedDataSubcomponents.add(updatedConcatenatedDataSubcomponents.indexOf(ds), parentDs);
									 updatedConcatenatedDataSubcomponents.remove(ds);
								 }
							 }
						 }
						 
					 }
					 for(DataSubcomponent ds:updatedConcatenatedDataSubcomponents)
					 {
						 DataSubcomponentType dst = ds.getDataSubcomponentType();
						 Set<String> l;
						 if(_additionalHeaders.containsKey(_gtypesHeaderCode) == false)
						 {
							 l = new HashSet<String>() ;
							 _additionalHeaders.put(_gtypesHeaderCode, l) ;
						 }
						 else
						 {
							 l = _additionalHeaders.get(_gtypesHeaderCode) ;
						 }
						 structDefinition.append("\t"+ds.getName()+": ");
						 String sourceName = GenerationUtilsADA.resolveExistingCodeDependencies(dst, l);
						 if(sourceName!=null)
							 structDefinition.append(sourceName);
						 else
						 {
							 process(dst);
							 sourceName = GenerationUtilsADA.getGenerationADAIdentifier(dst.getQualifiedName());
							 structDefinition.append(sourceName);
						 }
						 structDefinition.append(";\n");
					 }
				 }
			 }
			 _gtypesHeaderCode.addOutput(structDefinition.toString());
			 _gtypesHeaderCode.addOutputNewline("end record;") ;
		 
			 break ;
		 }
		 case UNION :
		 {
			 
			 
			 StringBuilder unionDeclaration = new StringBuilder("case " + id + " is ");
		        EList<PropertyExpression> elementNames =
		              PropertyUtils
		                    .getPropertyExpression(dataTypeHolder.klass,
		                                           DataModelProperties.ELEMENT_NAMES) ;
		        List<String> stringifiedElementNames = new ArrayList<String>() ;

		        for(PropertyExpression elementNameProperty : elementNames)
		        {
		          if(elementNameProperty instanceof ListValue)
		          {
		            ListValue lv = (ListValue) elementNameProperty ;

		            for(PropertyExpression v : lv.getOwnedListElements())
		            {
		              if(v instanceof StringLiteral)
		              {
		                StringLiteral eltName = (StringLiteral) v ;
		                stringifiedElementNames.add(eltName.getValue()) ;
		              }
		            }
		          }
		        }

		        EList<PropertyExpression> elementTypes =
		              PropertyUtils
		                    .getPropertyExpression(dataTypeHolder.klass,
		                                           DataModelProperties.BASE_TYPE) ;

		        for(PropertyExpression elementTypeProperty : elementTypes)
		        {
		          if(elementTypeProperty instanceof ListValue)
		          {
		            ListValue lv = (ListValue) elementTypeProperty ;

		            for(PropertyExpression v : lv.getOwnedListElements())
		            {
		              if(v instanceof ClassifierValue)
		              {
		                ClassifierValue cv = (ClassifierValue) v ;
		                String type =
		                      GenerationUtilsADA.getGenerationADAIdentifier(cv
		                            .getClassifier().getQualifiedName()) ;
		                unionDeclaration.append("\t"+type +
		                      " " +
		                      stringifiedElementNames.get(lv.getOwnedListElements()
		                            .indexOf(v)) + ";\n") ;
		              }
		            }
		          }
		        }
		        _gtypesHeaderCode.addOutput(unionDeclaration.toString());
		        _gtypesHeaderCode.addOutputNewline("end" + id + ";") ;
		        break ;
			 
		 }
		 case ARRAY :
		 {

//			 StringBuilder arrayDef = new StringBuilder (id+" : array");
			 // check if data type is a subtype of an existing type.
			 DataSubcomponentType parentDst = processParentDataSubcomponentType(object);
			 if(parentDst!=null)
			 {
				 String parentID = "";
				 parentID = GenerationUtilsADA.resolveExistingCodeDependencies(parentDst, _additionalHeaders.get(_gtypesHeaderCode));
				 if(parentID==null)
					 parentID = GenerationUtilsADA.getGenerationADAIdentifier(parentDst.getQualifiedName());
				 _gtypesHeaderCode.addOutput("subtype "+id+" is " +parentID);
				 EList<PropertyExpression> arrayDimensions =
						 PropertyUtils
						 .getPropertyExpression(dataTypeHolder.klass,
								 DataModelProperties.DIMENSION) ;

				 if(false == arrayDimensions.isEmpty())
				 {
					 for(PropertyExpression dimensionProperty : arrayDimensions)
					 {
						 if(dimensionProperty instanceof ListValue)
						 {
							 ListValue lv = (ListValue) dimensionProperty ;

							 for(PropertyExpression v : lv.getOwnedListElements())
							 {
								 if(v instanceof IntegerLiteral)
								 {
									 IntegerLiteral dimension = (IntegerLiteral) v ;
									 if(dimension.getValue()>0)
									 {
										 _gtypesHeaderCode.addOutput("(Integer range 0 .. ") ;
										 _gtypesHeaderCode.addOutput(Long.toString(dimension.getValue() - 1)+")") ;
									 }
								 }
							 }
						 }
					 }

				 }
			 }
			 else
			 {
				 
				 EList<PropertyExpression> baseType =
						 PropertyUtils
						 .getPropertyExpression(dataTypeHolder.klass,
								 DataModelProperties.BASE_TYPE) ;
				 String baseTypeName="";
				 boolean found = false;
				 for(PropertyExpression baseTypeProperty : baseType)
				 {
					 if(baseTypeProperty instanceof ListValue)
					 {
						 ListValue lv = (ListValue) baseTypeProperty ;

						 for(PropertyExpression v : lv.getOwnedListElements())
						 {
							 if(v instanceof ClassifierValue)
							 {
								 ClassifierValue cv = (ClassifierValue) v ;
								 if(false == _processedTypes.contains(cv.getClassifier().getQualifiedName()))
								 {
									 getADATypeDeclarator(cv.getClassifier());
									 _processedTypes.add(cv.getClassifier().getQualifiedName());
								 }
								 baseTypeName=GenerationUtilsADA.resolveExistingCodeDependencies(cv.getClassifier(), _additionalHeaders.get(_gtypesHeaderCode));
								 if(baseTypeName==null)
									 baseTypeName = GenerationUtilsADA
									 .getGenerationADAIdentifier(cv.getClassifier()
											 .getQualifiedName()) ;
								 
								 found=true;
								 break;
							 }
						 }
						 if(found)
							 break;
					 }
				 }
				 //			 _gtypesHeaderCode.addOutput(arrayDef.toString());
				 //			 _gtypesHeaderCode.addOutput(" ") ;
				 //			 _gtypesHeaderCode.addOutput(id) ;
				 EList<PropertyExpression> arrayDimensions =
						 PropertyUtils
						 .getPropertyExpression(dataTypeHolder.klass,
								 DataModelProperties.DIMENSION) ;

				 if(arrayDimensions.isEmpty())
				 {
					 _gtypesHeaderCode.addOutput("type ");
					 _gtypesHeaderCode.addOutput(id);
					 _gtypesHeaderCode.addOutput(" is array (");
					 if(arrayDimensions.size()>0)
					 {
						 for(int dim=0; dim<arrayDimensions.size()-1; dim++)
						 {
							_gtypesHeaderCode.addOutput("Integer range <>") ;
							if(dim!=0 && dim!=arrayDimensions.size()-1)
								_gtypesHeaderCode.addOutput(",") ;
						 }
							 
					 }
					 else
						 _gtypesHeaderCode.addOutput("Integer range <>") ;
					 _gtypesHeaderCode.addOutput(") ") ;

					 _gtypesHeaderCode.addOutput(" of ") ;
					 _gtypesHeaderCode.addOutput(baseTypeName);
				 }
				 else
				 {
					 for(PropertyExpression dimensionProperty : arrayDimensions)
					 {
						 if(dimensionProperty instanceof ListValue)
						 {
							 ListValue lv = (ListValue) dimensionProperty ;

							 for(PropertyExpression v : lv.getOwnedListElements())
							 {
								 if(v instanceof IntegerLiteral)
								 {
									 _gtypesHeaderCode.addOutput("subtype "+id);
									 _gtypesHeaderCode.addOutput(" is ");
									 _gtypesHeaderCode.addOutput(baseTypeName);
									 IntegerLiteral dimension = (IntegerLiteral) v ;
									 if(dimension.getValue()-1>0)
									 {
										 _gtypesHeaderCode.addOutput("(Integer range 0 .. ") ;
										 _gtypesHeaderCode.addOutput(Long.toString(dimension.getValue() - 1)+")") ;
									 }
								 }
							 }
						 }
					 }
				 }
			 }
			 _gtypesHeaderCode.addOutputNewline(";") ;
			 break ;


		 }
		 case UNKNOWN :
		 {
			 boolean isExistingDependency=false;
			 try
			 {
				 resolveExistingCodeDependencies(object, null,
                         _gtypesHeaderCode) ; /* this is to trigger exception in case the 
                         dependency is not resolved. In this case the 
                         null parameter will enable not to generate anything*/
				 _gtypesHeaderCode.addOutputNewline("");
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutput("subtype ") ;
		          resolveExistingCodeDependencies(object, _gtypesHeaderCode,
                          _gtypesHeaderCode) ;
				 _gtypesHeaderCode.addOutput(id + " is " + object.getName()) ;

				 _gtypesHeaderCode.addOutputNewline(";") ;
				 _gtypesHeaderCode.decrementIndent();

			 }
			 catch(Exception e)
			 {
				 return ;
			 }

			 break ;
		 }
		 }
	 }

	 
  	  
        	  
	 private DataSubcomponentType processParentDataSubcomponentType(
			NamedElement object) {
		 DataSubcomponentType parentDst = null;
		 if(object instanceof DataType)
		 {
			 DataType dt = (DataType) object;
			 if(dt.getOwnedExtension()!=null)
			 {
				 parentDst = (DataSubcomponentType) dt.getExtended();
			 }
			 
		 }
		 else if(object instanceof DataImplementation)
		 {
			 DataImplementation di = (DataImplementation) object;
			 if(di.getOwnedExtension()!=null)
			 {
				 parentDst = (DataSubcomponentType) di.getExtended();
				 
			 }
		 }
		 if(parentDst!=null && parentDst!=object)
		 {
			 process(parentDst);
			 return parentDst;
		 }
		 return null;
	}

	@Override
	 protected void initSwitches()
	 {
		 aadl2Switch = new Aadl2Switch<String>()
				 {
			 @Override
			 public String caseDataType(DataType object)
			 {
				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return DONE ;
				 }
				 _processedTypes.add(object.getQualifiedName());
				 _gtypesHeaderCode.processComments(object) ;
				 getADATypeDeclarator((NamedElement)object) ;
				 return DONE ;
			 }

			 @Override
			 public String caseAadlPackage(AadlPackage object)
			 {
				 process(object.getOwnedPublicSection()) ;
				 process(object.getOwnedPrivateSection()) ;
				 return DONE ;
			 }

			 /**
			  * unparses annex library
			  *
			  * @param al
			  *            AnnexLibrary object
			  */
			 @Override
			 public String caseAnnexLibrary(AnnexLibrary al)
			 {
				 String annexName = al.getName() ;
				 AnnexUnparser unparser =
						 ServiceProvider.getServiceRegistry()
						 .getUnparser(annexName) ;

				 if(unparser != null)
				 {
					 unparser.unparseAnnexLibrary(al, _currentImplUnparser.getIndent()) ;
				 }

				 return DONE ;
			 }

			 /**
			  * unparses default annex library
			  *
			  * @param dal
			  *            DefaultAnnexLibrary object
			  */
			 @Override
			 public String caseDefaultAnnexLibrary(DefaultAnnexLibrary dal)
			 {
				 AnnexUnparser unparser =
						 ServiceProvider.getServiceRegistry().getUnparser("--") ;

				 if(unparser != null)
				 {
				 }

				 return DONE ;
			 }

			 @Override
			 public String caseDataImplementation(DataImplementation object)
			 {
				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return DONE ;
				 }
			     _processedTypes.add(object.getQualifiedName());
				 _currentHeaderUnparser = _gtypesHeaderCode ;
				 _gtypesHeaderCode.processComments(object) ;
				 getADATypeDeclarator(object) ;
				 return null ;
			 }

			 @Override
			 public String caseDataSubcomponent(DataSubcomponent object)
			 {
				 AadlToADASwitchProcess unparser ;

				 if(object.getContainingComponentImpl() instanceof DataImplementation)
				 {
					 unparser = _currentHeaderUnparser ;
				 }
				 else
				 {
					 unparser = _currentImplUnparser ;
				 }

				 unparser.processComments(object) ;
				 DataSubcomponentType dst = object.getDataSubcomponentType() ;

				 unparser.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object
						 .getQualifiedName())) ;
				 unparser.addOutput(" : ");
				 processDataSubcomponentType(dst, unparser, _currentHeaderUnparser);

				 
				 _currentImplUnparser.addOutput(GeneratorUtils.getInitialValue(object, "ada")) ;
				 unparser.addOutputNewline(";") ;

				 
				 if(_processedTypes.contains(object.getDataSubcomponentType().getQualifiedName()) == false)
				 {
					 _processedTypes.add(object.getQualifiedName());
					 process(object.getDataSubcomponentType());
				 }
				 return DONE ;
			 }

			 @Override
			 public String caseProcessImplementation(ProcessImplementation object)
			 {
				 GeneratorUtils.buildDataAccessMapping(object, _dataAccessMapping) ;

				 processEList(object.getOwnedThreadSubcomponents()) ;

				 _subprogramHeaderCode.addOutputNewline("procedure Last_Chance_Handler " +
						 "(Source_Location :System.Address; Line : Integer);");
				 String gnat_handler = "__gnat_last_chance_handler";
				 _subprogramHeaderCode.decrementIndent();
				 _subprogramHeaderCode.addOutputNewline("pragma Export (C, Last_Chance_Handler,\""+gnat_handler+"\");");

				 _gtypesImplCode.incrementIndent();
				 _gtypesImplCode.addOutputNewline("procedure Gtypes is");
				 _gtypesImplCode.addOutputNewline("begin");
				 _gtypesImplCode.incrementIndent();
				 _gtypesImplCode.addOutputNewline("null;");
				 _gtypesImplCode.decrementIndent();	        
				 _gtypesImplCode.addOutput("end Gtypes;");

				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutput("procedure Gtypes;");
				 _gtypesHeaderCode.decrementIndent();

				 _subprogramImplCode.addOutput("procedure Last_Chance_Handler");
				 _subprogramImplCode.addOutputNewline(" (Source_Location : System.Address; Line : Integer) is");
				 _subprogramImplCode.decrementIndent();
				 _subprogramImplCode.addOutputNewline(" pragma Unreferenced (Source_Location, Line);");
				 _subprogramImplCode.addOutputNewline("begin");
				 _subprogramImplCode.addOutputNewline("loop");
				 _subprogramImplCode.addOutputNewline("null;");
				 _subprogramImplCode.addOutputNewline("end loop;");
				 _subprogramImplCode.addOutputNewline("end Last_Chance_Handler;");

				 _deploymentHeaderCode.addOutputNewline("procedure Deployment;");

				 List<String> dataSubcomponentNames = new ArrayList<String>();
				 Map<String, DataSubcomponent> dataSubcomponentMapping = new HashMap<String, DataSubcomponent>();
				 Map<DataSubcomponent, String> globalVariablesInit = new LinkedHashMap<DataSubcomponent, String>();
				 for(DataSubcomponent ds: object.getOwnedDataSubcomponents())
				 {
					 dataSubcomponentNames.add(ds.getName());
					 if(false == _dataAccessMapping.containsValue(ds.getName()))
					 {			        	  
						 _deploymentHeaderCode.addOutput(ds.getName()+" : ") ;
						 processDataSubcomponentType(ds.getDataSubcomponentType(), _deploymentHeaderCode, _deploymentHeaderCode);
						 String initialValue = GeneratorUtils.getInitialValue(ds, "ada");
						 _deploymentHeaderCode.addOutputNewline(initialValue+";") ;
						 if(initialValue!=null)
							 globalVariablesInit.put(ds, initialValue);
						 
					 }
					 else
					 {
						 dataSubcomponentMapping.put(ds.getName(), ds);
					 }
					 process(ds.getDataSubcomponentType());
				 }

				 if(false == _dataAccessMapping.isEmpty())
				 {
					 List<String> treatedDeclarations = new ArrayList<String>();
					 for(DataAccess d : _dataAccessMapping.keySet())
					 {
						 if(treatedDeclarations.contains(_dataAccessMapping.get(d)))
						 {
							 continue;
						 }
						 else if(dataSubcomponentNames.contains(_dataAccessMapping.get(d)))
						 {
							 DataSubcomponentType dst = d.getDataFeatureClassifier();
							 String declarationID = _dataAccessMapping.get(d);
							 _deploymentHeaderCode.addOutput(declarationID+" : ");
							 processDataSubcomponentType(dst, _deploymentHeaderCode, _deploymentHeaderCode);
							 DataSubcomponent ds = dataSubcomponentMapping.get(_dataAccessMapping.get(d));
							 if(ds!=null)
							 {
								 String initialValue = GeneratorUtils.getInitialValue(ds, "ada");
								 _deploymentHeaderCode.addOutputNewline(initialValue);
								 if(initialValue!=null && false==initialValue.equals(""))
									 globalVariablesInit.put(ds, initialValue);
							 }
							 _deploymentHeaderCode.addOutputNewline(";") ;
							 treatedDeclarations.add(declarationID);

						 }
					 }
				 }
				 
				 
				 _deploymentHeaderCode.addOutputNewline("procedure Init_Global_Variables;");
				 _deploymentHeaderCode.addOutputNewline("pragma Export (C, Init_Global_Variables, \"Init_Global_Variables\");");

				 _deploymentImplCode.incrementIndent();
				 _deploymentImplCode.addOutputNewline("procedure Init_Global_Variables is");
				 _deploymentImplCode.addOutputNewline("begin");
				 _deploymentImplCode.incrementIndent();
				 if(false == globalVariablesInit.keySet().isEmpty())
				 {
					 for(DataSubcomponent ds: globalVariablesInit.keySet())
					 {
						 _deploymentImplCode.addOutputNewline(ds.getName() + globalVariablesInit.get(ds)+";");
					 }
				 }
				 else
					 _deploymentImplCode.addOutputNewline("null;");
				 _deploymentImplCode.decrementIndent();
				 _deploymentImplCode.addOutputNewline("end Init_Global_Variables;");
				 _deploymentImplCode.decrementIndent();

				 return DONE ;
			 }

			 @Override
			 public String caseProcessSubcomponent(ProcessSubcomponent object)
			 {
			        process(object.getComponentImplementation()) ;
			        for(NamedElement ne: additionalUnparsing)
			        	process(ne);
			        additionalUnparsing.clear();
			        return DONE ;
			 }

			 @Override
			 public String caseThreadImplementation(ThreadImplementation object)
			 {
			   	
		    	for(SubprogramSubcomponent sc:object.getOwnedSubprogramSubcomponents())
		    	{
		    		process(sc);
		    	}
	 
				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return DONE ;
				 }
			        _processedTypes.add(object.getQualifiedName());
			    	_currentImplUnparser = _activityImplCode ;
			        _currentHeaderUnparser = _activityHeaderCode ;
			        GeneratorUtils.buildDataAccessMapping(object, _dataAccessMapping) ;
			        process(object.getType()) ;
			        
					 _currentImplUnparser.addOutputNewline("procedure " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) +GenerationUtilsADA.THREAD_SUFFIX+" is") ;
					 _currentImplUnparser.addOutputNewline("begin") ;
					 
			        _currentImplUnparser.incrementIndent() ;

			        for(DataSubcomponent d : object.getOwnedDataSubcomponents())
			        {
			          process(d) ;
			        }
			        
			        _currentImplUnparser.addOutputNewline("while TRUE loop") ;
			        _currentImplUnparser.incrementIndent() ;
			        
			        processBehavioredImplementation(object);
			        
			        _activityImplCode.decrementIndent() ;
			        _activityImplCode.addOutputNewline("end loop;") ;
			        _activityImplCode.decrementIndent() ;
			        _activityImplCode.addOutputNewline("end "+ GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())+GenerationUtilsADA.THREAD_SUFFIX+";") ;
			        
			        _activityHeaderCode.addOutputNewline("procedure " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())+GenerationUtilsADA.THREAD_SUFFIX+";") ;

			        _activityHeaderCode.addOutputNewline("pragma Export (C,"+GenerationUtilsADA
							 .getGenerationADAIdentifier(object.qualifiedName())+GenerationUtilsADA.THREAD_SUFFIX +
							 ",\n     \""+GenerationUtilsADA.getGenerationADAIdentifier(object.qualifiedName())+GenerationUtilsADA.THREAD_SUFFIX+"\");");
					 _activityHeaderCode.addOutputNewline("");

					 return null ;
			 }

			 @Override
			 public String caseSubprogramCallSequence(SubprogramCallSequence object)
			 {
				 for(SubprogramCall cs : object.getOwnedSubprogramCalls())
				 {
					 if(cs instanceof SubprogramCall)
					 {
						 SubprogramCall sc = (SubprogramCall) cs;
						 process(sc);
					 }
				 }
				 return null ;
			 }

			 @Override
			 public String caseSubprogramType(SubprogramType object)
			 {
				 _currentImplUnparser = _subprogramImplCode;
				 _currentHeaderUnparser = _subprogramHeaderCode; 

				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return DONE ;
				 }
				 _processedTypes.add(object.getQualifiedName());

				 try {
					 resolveExistingCodeDependencies(object, null, _subprogramHeaderCode);
					 addExternalCSubprograms(object, _subprogramHeaderCode);
				 } catch (Exception e1) {
					 caseSubprogramClassifier((SubprogramClassifier) object);

					 processBehavioredType(object) ;

					 Set<String> l = getAdditionalHeaderSet(_subprogramHeaderCode);
			         _subprogramImplCode.decrementIndent();
			         _subprogramImplCode.addOutput("end ");
			          try
						 {
							 String sourceName = PropertyUtils.getStringValue(object, "Source_Name") ;
							 _subprogramImplCode.addOutput(sourceName);
						 }
						 catch(Exception e)
						 {
							 _subprogramImplCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()));
						 }
			          _subprogramImplCode.addOutputNewline(";");
				 }
				 return DONE;
			 }
			 
			 void addExternalCSubprograms(SubprogramClassifier object, AadlToADASwitchProcess _subprogramHeaderCode)
			 {
				 try
				  {
					  NamedElement ne = object ;
					  String sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;
					  List<String> sourceText =
							  PropertyUtils.getStringListValue(ne, "Source_Text") ;
					  for(String s : sourceText)
					  {
						  if(s.endsWith(".ads"))
						  {
							  return;
						  }
					  }
					  for(String s : sourceText)
					  {
						  if(s.endsWith(".h") && object instanceof SubprogramClassifier)
						  {
							  _additionalHeaders.get(_subprogramHeaderCode).add("Interfaces.C");
							  addSubprogramDeclaration(object);
							  _subprogramHeaderCode.addOutputNewline("pragma Import (C, "+sourceName+","+"\""+sourceName+"\");");
							  return;
						  }
					  }
				  }
				 catch (Exception e)
				 {
					 
				 }
			 }
			 
				 
//				 srcName = "";
//		          try {
//					srcName = PropertyUtils.
//					    getStringValue(object, "Source_Name") ;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//		          	if(!srcName.equals(""))	
//		          	{
//			            
//						 Parameter returnParameter = null;
//						 List<Feature> orderedFeatureList = null;
//						 if(object instanceof SubprogramImplementation)
//						 {
//							 SubprogramImplementation si = (SubprogramImplementation) object;
//							 orderedFeatureList = Aadl2Utils.orderFeatures(si.getType()) ;
//						 }
//						 else if (object instanceof SubprogramType)
//						 {
//							 SubprogramType st = (SubprogramType) object;
//							 orderedFeatureList = Aadl2Utils.orderFeatures(st) ;
//						 }
//						 boolean isReturnParam=false;
//						 for(Feature param: orderedFeatureList)
//						 {
//							 if(param instanceof Parameter)
//							 {
//								 Parameter p = (Parameter) param ;
//								 isReturnParam = GenerationUtilsADA.isReturnParameter(p);
//							 }
//						 }
//						 _subprogramHeaderCode.addOutput("procedure "+srcName+" (");
//
//						 boolean first = true;
//
//						 for(Feature f: orderedFeatureList)
//						 {					 
//					    	  if(f instanceof Parameter)
//					  		  {
//					  		    Parameter p = (Parameter) f ;
//					  			if(p==returnParameter)
//					  			  continue;
//					  			if(first==false)
//					  			{
//					  			  _subprogramHeaderCode.addOutput("; ") ;
//					  			}
//					  			_subprogramHeaderCode.addOutput(p.getName()) ;
//								 if (Aadl2Utils.isInOutParameter(p))
//								 {
//									 _subprogramHeaderCode.addOutput(" : in out ") ;
//									 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
//							  			
//								 }
//								 else if (Aadl2Utils.isOutParameter(p))
//								 {
//									 _subprogramHeaderCode.addOutput(" : out ") ;
//									 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
//							  			
//								 }
//								 else
//								 {
//									 _subprogramHeaderCode.addOutput(" : in ") ;
//									 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
//								 }
//								 first=false;
//								 process(p.getDataFeatureClassifier());
//							 }
//							 else if(f instanceof DataAccess)
//							 {
//								 DataAccess da = (DataAccess) f ;
//								 if(first==false)
//								 {
//									 _subprogramHeaderCode.addOutput("; ") ;
//								 }
//									
//								 if(da.getKind().equals(AccessType.REQUIRES))
//								 {
//									 _subprogramHeaderCode.addOutput(" "+da.getName());
//
//									 if (Aadl2Utils.isReadWriteDataAccess(da))
//									 {
//										 _subprogramHeaderCode.addOutput(" : in out ") ;
//										 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
//									 }
//									 else if (Aadl2Utils.isWriteOnlyDataAccess(da))
//									 {
//										 _subprogramHeaderCode.addOutput(" : out ") ;
//										 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
//									 }
//									 else
//									 {
//										 _subprogramHeaderCode.addOutput(" : in ") ;
//										 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
//									 }  			  
//								 }
//
//								 first=false;
//
//								 process(da.getDataFeatureClassifier());
//							 }
//						 }					    	
//						 _subprogramHeaderCode.addOutputNewline(");");
//		    		     _subprogramHeaderCode.addOutputNewline("");
//
//		    		     _subprogramHeaderCode.addOutputNewline("pragma Import (C, "+srcName+","+"\""+srcName+"\");");
//		          	}	    		     
//		          	
//		          	
//		          	_currentImplUnparser = _subprogramImplCode;
//			      	_currentHeaderUnparser = _subprogramHeaderCode; 
//			      	
//			    	if(_processedTypes.contains(object.getQualifiedName()))
//			        {
//			          return DONE ;
//			        }
//			        _processedTypes.add(object.getQualifiedName());
//			    	
//			        try {
//			          resolveExistingCodeDependencies(object, null, _subprogramHeaderCode);
//			        } catch (Exception e1) {
//			          caseSubprogramClassifier((SubprogramClassifier) object);
//			                
//			          processBehavioredType(object) ;
//			          	    
//						 _subprogramImplCode.decrementIndent();
//						 _subprogramImplCode.addOutputNewline("end " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + ";");	
//			        }
//			  	    
//			  	    return DONE;					 
//			 }

			 private void addSubprogramDeclaration(SubprogramClassifier object) {
				// TODO Auto-generated method stub
				 subprogramsUnparsingStack.add(object);

				 Parameter returnParameter = null;
				 List<Feature> orderedFeatureList = null;
				 if(object instanceof SubprogramImplementation)
				 {
					 SubprogramImplementation si = (SubprogramImplementation) object;
					 orderedFeatureList = Aadl2Utils.orderFeatures(si.getType()) ;
				 }
				 else if (object instanceof SubprogramType)
				 {
					 SubprogramType st = (SubprogramType) object;
					 orderedFeatureList = Aadl2Utils.orderFeatures(st) ;
				 }
				 boolean isReturnParam=false;
				 for(Feature param: orderedFeatureList)
				 {
					 if(param instanceof Parameter)
					 {
						 Parameter p = (Parameter) param ;
						 isReturnParam = GenerationUtilsADA.isReturnParameter(p);
					 }
				 }
				 				 
				 if(!isReturnParam)
				 {   		 
					 _subprogramHeaderCode.addOutput("procedure ");
				 }

				 else
				 {
					 _subprogramHeaderCode.addOutput("function ");
				 }
				 try
				 {
					 String sourceName = PropertyUtils.getStringValue(object, "Source_Name") ;
					 _subprogramHeaderCode.addOutput(sourceName);
				 }
				 catch(Exception e)
				 {
				     _subprogramHeaderCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()));
				 }

	 	         _subprogramHeaderCode.addOutput("(");
				 boolean first = true;

				 // Fetches data subcomponent names.
				 
				 for(Feature f: orderedFeatureList)
				 {					 
			    	  if(f instanceof Parameter)
			  		  {
			  		    Parameter p = (Parameter) f ;
			  			if(p==returnParameter)
			  			  continue;
			  			if(first==false)
			  			{
			  			  _subprogramHeaderCode.addOutput("; ") ;
			  			}			  			
			 			
						_subprogramHeaderCode.addOutput(" "+p.getName()); 
			  			if (Aadl2Utils.isInOutParameter(p))
						 {
							 _subprogramHeaderCode.addOutput(" : in out ") ;
							 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
						 }
						 else if (Aadl2Utils.isOutParameter(p))
						 {
							 _subprogramHeaderCode.addOutput(" : out ") ;
							 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
						 }
						 else
						 {
							 _subprogramHeaderCode.addOutput(" : in ") ;
							 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
						 }


						 first=false;

						 process(p.getDataFeatureClassifier());
					 }
					 else if(f instanceof DataAccess)
					 {
						 DataAccess da = (DataAccess) f ;
						 if(first==false)
						 {
							 _subprogramHeaderCode.addOutput("; ") ;
						 }						 
						 if(da.getKind().equals(AccessType.REQUIRES))
						 {
							 _subprogramHeaderCode.addOutput(" "+da.getName());

							 if (Aadl2Utils.isReadWriteDataAccess(da))
							 {
								 _subprogramHeaderCode.addOutput(" : in out ") ;
								 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
							 }
							 else if (Aadl2Utils.isWriteOnlyDataAccess(da))
							 {
								 _subprogramHeaderCode.addOutput(" : out ") ;
								 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
							 }
							 else
							 {
								 _subprogramHeaderCode.addOutput(" : in ") ;
								 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
							 }  			  
						 }

						 first=false;

						 process(da.getDataFeatureClassifier());
					 }
				 }
				 _subprogramHeaderCode.addOutputNewline(");");
    		     _subprogramHeaderCode.addOutputNewline("");
			}

			@Override
			 public String caseSubprogramClassifier(SubprogramClassifier object)
			 {
			    subprogramsUnparsingStack.add(object);
			    addSubprogramDeclaration(object);
				 Parameter returnParameter = null;
				 List<Feature> orderedFeatureList = null;
				 if(object instanceof SubprogramImplementation)
				 {
					 SubprogramImplementation si = (SubprogramImplementation) object;
					 orderedFeatureList = Aadl2Utils.orderFeatures(si.getType()) ;
				 }
				 else if (object instanceof SubprogramType)
				 {
					 SubprogramType st = (SubprogramType) object;
					 orderedFeatureList = Aadl2Utils.orderFeatures(st) ;
				 }
				 boolean isReturnParam=false;
				 for(Feature param: orderedFeatureList)
				 {
					 if(param instanceof Parameter)
					 {
						 Parameter p = (Parameter) param ;
						 isReturnParam = GenerationUtilsADA.isReturnParameter(p);
					 }
				 }
				 				 
				 if(!isReturnParam)
				 {   
					 _subprogramImplCode.addOutputNewline("");
					 _subprogramImplCode.addOutput  ("procedure ");
				 }

				 else
				 {
					 _subprogramImplCode.addOutput("function ");
				 }

				 _subprogramImplCode.decrementIndent();   
				 try
				 {
					 String sourceName = PropertyUtils.getStringValue(object, "Source_Name") ;
					 _subprogramImplCode.addOutput(sourceName);
				 }
				 catch(Exception e)
				 {
					 _subprogramImplCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()));
				 }
       	         _subprogramImplCode.addOutput("(");
			    		        
				 boolean first = true;

				 // Fetches data subcomponent names.
				 
				 for(Feature f: orderedFeatureList)
				 {					 
			    	  if(f instanceof Parameter)
			  		  {
			  		    Parameter p = (Parameter) f ;
			  			if(p==returnParameter)
			  			  continue;
			  			if(first==false)
			  			{
			  			  _subprogramImplCode.addOutput("; ") ;
			  			}			  			
			 			
			  			_subprogramImplCode.addOutput(" "+p.getName());
			  			if (Aadl2Utils.isInOutParameter(p))
						 {
							 _subprogramImplCode.addOutput(" : in out ") ;
							 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramImplCode, _subprogramHeaderCode);
						 }
						 else if (Aadl2Utils.isOutParameter(p))
						 {
							 _subprogramImplCode.addOutput(" : out ") ;
							 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramImplCode, _subprogramHeaderCode);
						 }
						 else
						 {
							 _subprogramImplCode.addOutput(" : in ") ;
							 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramImplCode, _subprogramHeaderCode);
						 }


						 first=false;

						 process(p.getDataFeatureClassifier());
					 }
					 else if(f instanceof DataAccess)
					 {
						 DataAccess da = (DataAccess) f ;
						 if(first==false)
						 {
							 _subprogramImplCode.addOutput("; ") ;
						 }						 
						 if(da.getKind().equals(AccessType.REQUIRES))
						 {
							 _subprogramImplCode.addOutput(" "+da.getName());

							 if (Aadl2Utils.isReadWriteDataAccess(da))
							 {
								 _subprogramImplCode.addOutput(" : in out ") ;
								 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramImplCode, _subprogramHeaderCode);
							 }
							 else if (Aadl2Utils.isWriteOnlyDataAccess(da))
							 {
								 _subprogramImplCode.addOutput(" : out ") ;
								 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramImplCode, _subprogramHeaderCode);
							 }
							 else
							 {
								 _subprogramImplCode.addOutput(" : in ") ;
								 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramImplCode, _subprogramHeaderCode);
							 }  			  
						 }

						 first=false;

						 process(da.getDataFeatureClassifier());
					 }
				 }
				 _subprogramImplCode.addOutput(")");
				 _subprogramImplCode.addOutputNewline(" is ");
				 _subprogramImplCode.incrementIndent();

				 return null;
			 }

			 @Override
			 public String caseSubprogramImplementation(SubprogramImplementation object)
			 {
//				 	sourceTextName(object);
//
//				    _currentImplUnparser = _subprogramImplCode;
//			    	_currentHeaderUnparser = _subprogramHeaderCode; 
//			    	if(_processedTypes.contains(object.getQualifiedName()))
//			        {
//			          return DONE ;
//			        }
//			        _processedTypes.add(object.getQualifiedName());
//			        try {
//			          resolveExistingCodeDependencies(object, null, _subprogramHeaderCode);
//			        } catch (Exception e1) {
//			      	  caseSubprogramClassifier((SubprogramClassifier) object);
//			        
//			    	  for(DataSubcomponent d : object.getOwnedDataSubcomponents())
//			          {
//			            process(d) ;
//			          }
//
//			          processBehavioredImplementation(object) ;
//
//						 _subprogramImplCode.decrementIndent();
//			  		     _subprogramImplCode.addOutputNewline("end "+GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())+";");
//			        }
//
//				 
//				 return DONE;
				 
				 _currentImplUnparser = _subprogramImplCode;
			    	_currentHeaderUnparser = _subprogramHeaderCode; 
			    	if(_processedTypes.contains(object.getQualifiedName()))
			        {
			          return DONE ;
			        }
			        _processedTypes.add(object.getQualifiedName());
			        try {
			          resolveExistingCodeDependencies(object, null, _subprogramHeaderCode);
			          addExternalCSubprograms(object, _subprogramHeaderCode);
			        } catch (Exception e1) {
			      	  caseSubprogramClassifier((SubprogramClassifier) object);
			        
			    	  for(DataSubcomponent d : object.getOwnedDataSubcomponents())
			          {
			            process(d) ;
			          }

			          processBehavioredImplementation(object) ;
			          Set<String> l = getAdditionalHeaderSet(_subprogramHeaderCode);
			          _subprogramImplCode.decrementIndent();
			          _subprogramImplCode.addOutput("end ");
			          try
						 {
							 String sourceName = PropertyUtils.getStringValue(object, "Source_Name") ;
							 _subprogramImplCode.addOutput(sourceName);
						 }
						 catch(Exception e)
						 {
							 _subprogramImplCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()));
						 }
			          _subprogramImplCode.addOutputNewline(";");
			        }
			    	  
			    	return DONE;
			 }

			 @Override
			 public String caseSubprogramCall(SubprogramCall object)
			 {
				 
				 Parameter returnParameter = null;

				 if(object.getCalledSubprogram() != null)
				 {
		    		  SubprogramType st = null ;
		    		  
		    		  SubprogramSubcomponentType sct;
		    		  if(object.getCalledSubprogram() instanceof SubprogramAccess)
		    			  sct = ((SubprogramAccess)object.getCalledSubprogram()).getSubprogramFeatureClassifier();
		    		  else
		    			  sct = (SubprogramSubcomponentType) object.getCalledSubprogram() ;


		    		  if(sct instanceof SubprogramType)
		    		  {
		    			  st = (SubprogramType) sct ;
		    		  }
		    		  else
		    		  {
		    			  SubprogramImplementation si = (SubprogramImplementation) sct ;
		    			  st = si.getType() ;
		    		  }

		    		  List<Feature> orderedFeatureList = Aadl2Utils.orderFeatures(st) ;
		    		  List<ConnectionEnd> orderedParamValue = new ArrayList<ConnectionEnd>();
		    		  for(Feature f: orderedFeatureList)
		    		  {
		    			  ConnectionEnd ce = Aadl2Utils.getConnectedEnd(object, f);
		    			  orderedParamValue.add(ce);
		    		  }

		    		  for(Feature param: orderedFeatureList)
		    		  {
		    			  if(param instanceof Parameter)
		    			  {
		    				  Parameter p = (Parameter) param ;
		    				  boolean isReturnParam = GenerationUtilsADA.isReturnParameter(p);;
		    				  
		    				  if(isReturnParam)
		    				  {
		    					  returnParameter = p;
		    					  ConnectionEnd ce = orderedParamValue.get(orderedFeatureList.indexOf(p));
								  processConnectionEnd(ce);
								  _currentImplUnparser.addOutput(" := ");
		    					  break;
		    				  }
		    			  }
		    		  }

					 try {
						 resolveExistingCodeDependencies(sct, _currentImplUnparser, _currentHeaderUnparser);
		    			  System.out.println("sma");

					 } catch (Exception e1) {
						 _currentImplUnparser.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(sct.getQualifiedName()));
					 }

					 if(st != null)
					 {  
						 _currentImplUnparser.addOutput(" (") ;
						 boolean first = true;
						 for(Feature feature: orderedFeatureList)
						 {
							 if(feature instanceof Parameter)
							 {
								 Parameter p = (Parameter) feature ;
								 if(p==returnParameter)
									 continue;
								 if(first==false)
									 _currentImplUnparser.addOutput(", ") ;

								 ConnectionEnd ce = orderedParamValue.get(orderedFeatureList.indexOf(p));
								 if(ce != null)
									 processConnectionEnd(ce);
								 first=false;
							 }
							 else if(feature instanceof DataAccess)
							 {
								 DataAccess da = (DataAccess) feature ;
								 if(first==false)
									 _currentImplUnparser.addOutput(", ") ;

								 String name = null ;

								 // If a data access mapping is provided:
								 // Transforms any data access into the right data subcomponent
								 // 's name thanks to the given data access mapping.
								 ConnectionEnd parentAccess = orderedParamValue.get(orderedFeatureList.indexOf(da));
								 if(_dataAccessMapping != null && parentAccess instanceof DataAccess)
								 {
									 name = _dataAccessMapping.get(parentAccess);
								 }

								 if (name != null)
								 {
									 _currentImplUnparser.addOutput(name);
								 }
								 else
								 {
									 processConnectionEnd(parentAccess);
								 }
								 first=false;
							 }

						 }

						 _currentImplUnparser.addOutputNewline(");") ;
					 }
					 process(sct);
				 }
				 return DONE ;
			 }

			 private void processConnectionEnd(ConnectionEnd ce)
			 {
				 if(ce instanceof DataSubcomponent)
					 _currentImplUnparser.addOutput(
							 GenerationUtilsADA.getGenerationADAIdentifier(ce.getQualifiedName()));
				 
				 else
				 {
					 _currentImplUnparser.addOutput(
							 GenerationUtilsADA.getGenerationADAIdentifier(ce.getQualifiedName()));
				  }
			 }

			 @Override
			 public String caseThreadSubcomponent(ThreadSubcomponent object)
			 {
				    try
				    {
				      long value = PropertyUtils.getIntValue(object, "Period") ;
				      period = Long.toString(value) ;
				    }
				    catch(Exception e)
				    {
				      period = null ;
				    }

				    try
				    {
				      long value = PropertyUtils.getIntValue(object, "Deadline") ;
				      deadline = Long.toString(value) ;
				    }
				    catch(Exception e)
				    {
				      // If deadline is not set, use period instead.
				      deadline = period ;
				    }

				    try
				    {
				      long value = PropertyUtils.getIntValue(object, "Priority") ;
				      priority = Long.toString(value) ;
				    }
				    catch(Exception e)
				    {
				      // If deadline is not set, use period instead.
				      deadline = period ;
				    }

				    try {
						dispatchProtocol = PropertyUtils.getEnumValue(object, "Dispatch_Protocol");
					} catch (Exception exception) {
						throw new PropertyNotFound(exception);
					}
				    
					
				    
				 process(object.getComponentImplementation()) ;
				 return null ;
			 }

			 @Override
			 public String caseThreadType(ThreadType object)
			 {
				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return null ;
				 }

				 _processedTypes.add(object.getQualifiedName()) ;
				 _currentHeaderUnparser = _activityHeaderCode ;
				 _currentImplUnparser = _activityImplCode ;

				 for(DataAccess d : object.getOwnedDataAccesses())
				 {
					 if(d.getKind().equals(AccessType.REQUIRES))
					 {
						 process(d) ;
					 }
				 }

				 return null ;
			 }

			 /**
			  *  subprogram group access
			  */
			  @Override
			  public String caseSubprogramGroupAccess(SubprogramGroupAccess object)
			  {
				  return DONE ;
			  }

	
			  /**
			   * data access
			   */
			  @Override
		      public String caseDataAccess(DataAccess object)
		      {
		        /*_currentImplUnparser.addOutput("") ;
		        String actualParameterName = null ;
		        
		        if(_dataAccessMapping != null)
		        {
		          if(object.getContainingClassifier() instanceof ThreadClassifier)
		        	  actualParameterName = "Deployment."+_dataAccessMapping.get(object) ;
		          else if(object.getContainingClassifier() instanceof SubprogramClassifier)
		        	  actualParameterName = "Activity."+_dataAccessMapping.get(object) ;
		          _currentImplUnparser.addOutput(actualParameterName);
		        }
		        else
		        {
		          _currentImplUnparser.addOutput(GenerationUtilsADA
		                .getGenerationADAIdentifier(object.getQualifiedName())) ;
		        }
		        _currentImplUnparser.addOutput(" : ") ;
		        
		        try
		        {
		          resolveExistingCodeDependencies(object.getDataFeatureClassifier(),
		                               _currentImplUnparser, _currentHeaderUnparser);
		        }
		        catch(Exception e)
		        {
		          _currentImplUnparser.addOutput(GenerationUtilsADA
		                .getGenerationADAIdentifier(object.getDataFeatureClassifier()
		                      .getQualifiedName())) ;
		        }


		        _currentImplUnparser.addOutputNewline(";") ;

		        boolean nl=false;
		        
		        if(actualParameterName==null)
		        nl=true;
		        */
		        return DONE ;
		      }
				 } ;
	 }
	 

	 @Override
	 public void process(Element element, File generatedFilePath) 
			 throws GenerationException
			 {
		 AadlToADASwitchProcess.process(element) ;
		 saveGeneratedFilesContent(generatedFilePath) ;
		 // Reset all AadlToADASwitchProcess private attributes !
		 init() ;
			 }

	 @Override
	 public void setParameters(Map<Enum<?>, Object> parameters)
	 {
		 throw new UnsupportedOperationException() ;
	 }


		
}