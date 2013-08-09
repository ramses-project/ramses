package fr.tpt.aadl.ramses.generation.ada;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sound.sampled.Port;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.internal.text.source.DiffPainter;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.xtext.aadl2.properties.util.ThreadProperties;

import fr.tpt.aadl.annex.behavior.AadlBaParserAction;
import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils;
import fr.tpt.aadl.annex.behavior.utils.DimensionException;
import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider;
import fr.tpt.aadl.ramses.generation.ada.AadlToADASwitchProcess;
import fr.tpt.aadl.ramses.generation.ada.AadlToADAUnparser;
import fr.tpt.aadl.ramses.generation.ada.GenerationUtilsADA;
import fr.tpt.aadl.ramses.generation.ada.annex.behavior.AadlBaToADAUnparser;
import fr.tpt.aadl.ramses.generation.ada.annex.behavior.AadlBaToADAUnparserAction;
import fr.tpt.aadl.utils.Aadl2Utils;
import fr.tpt.aadl.utils.PropertyNotFound;
import fr.tpt.aadl.utils.PropertyUtils;
import fr.tpt.aadl.utils.names.DataModelProperties;

public class AadlToADAUnparser extends AadlProcessingSwitch implements AadlGenericUnparser
{
	public static List <String> language;
	public static ArrayList<Boolean> ADA;
	public static String sourceName; 
	private static ArrayList <String> activityProcedures;

    List<String> sporadicThreads = new ArrayList<>();;
    List<String> periodicThreads = new ArrayList<>();;

    private static ArrayList <String> listeTypes;
    int cpt =0;

	private static AadlToADAUnparser singleton;
    List<String> dataNames = new ArrayList<String>() ;

    public static String period = null ;
    public static String deadline = null ;
    public static String dispatchProtocol = null;
    public static String priority =null;
    public static int compteurSpor=0;
    public static int compteurPer=0;
    int nbSporadic = 0;
    int nbPeriodic=0;
	// gtype.ads
	protected AadlToADASwitchProcess _gtypesHeaderCode ;

	// subprogram.adb and .ads
	protected AadlToADASwitchProcess _subprogramImplCode ;
	protected AadlToADASwitchProcess _subprogramHeaderCode ;

	// activity.adb and .ads
	protected AadlToADASwitchProcess _activityImplCode ;
	protected AadlToADASwitchProcess _activityHeaderCode ;

	// partition deployment.ads
	protected AadlToADASwitchProcess _deploymentHeaderCode ;

	// Temporary .adb and .adb files.
	private AadlToADASwitchProcess _currentImplUnparser ;
	private AadlToADASwitchProcess _currentHeaderUnparser ;

	private List<NamedElement> _delayedDataDeclarations ;

	private Map<AadlToADASwitchProcess, Set<String>> _additionalHeaders ;

	private List<String> _processedTypes  ;

	private static final String MAIN_HEADER_INCLUSION = "\n" ;
	// Map Data Access with their relative Data Subcomponent. Relations 
	// are defined in the process implementation via connections.
	private Map<DataAccess, String> _dataAccessMapping = new HashMap<DataAccess, String>();

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

		_subprogramImplCode = new AadlToADASwitchProcess(this) ;
		_subprogramImplCode.addOutputNewline("\npackage body Subprograms is") ;
		_subprogramImplCode.incrementIndent();

		_subprogramHeaderCode = new AadlToADASwitchProcess(this) ;

		_subprogramHeaderCode.incrementIndent();

		_activityImplCode = new AadlToADASwitchProcess(this) ;
		_activityImplCode.addOutputNewline("\npackage body Activity is") ;
		_activityImplCode.incrementIndent();

		_activityHeaderCode = new AadlToADASwitchProcess(this) ;
		_activityHeaderCode.addOutputNewline("");
		_activityHeaderCode.incrementIndent();

		_deploymentHeaderCode = new AadlToADASwitchProcess(this) ;


		_processedTypes = new ArrayList<String>() ;

		_additionalHeaders = new HashMap<AadlToADASwitchProcess, Set<String>>() ;
		activityProcedures = new ArrayList<String>();
		listeTypes = new ArrayList<String>();

		_delayedDataDeclarations = new ArrayList<NamedElement>() ;
	}

	public void saveGeneratedFilesContent(File targetDirectory)
	{

		for(NamedElement ne : _delayedDataDeclarations)
		{
			getADATypeDeclarator(ne, false) ;
		}


		_gtypesHeaderCode.addOutputNewline("\nend Gtypes;\n") ;
		_subprogramHeaderCode.addOutputNewline("\nend Subprograms;\n") ;
		_activityHeaderCode.addOutputNewline("\nend Activity;\n") ;
		_deploymentHeaderCode.addOutputNewline("\nend Deployment;\n") ;

		_subprogramImplCode.addOutputNewline("\nend Subprograms;\n") ;
		_activityImplCode.addOutputNewline("\nend Activity;\n") ;
		
		
		try
		{
			String headerGuard = null ;

			// gtypes.ads
			FileWriter typesFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("gtypes.ads") ;
			String addGtypesHeader_ADS = "pragma Style_Checks(\"NM32766\");\n" + headerGuard;
			saveFile(typesFile_ADS, "", addGtypesHeader_ADS,
					_gtypesHeaderCode.getOutput()) ;

			// subprogram.adb
			FileWriter subprogramsFile_ADB =
					new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.adb") ;
			String addSubprogramHeader_ADB = getAdditionalHeader(_subprogramImplCode) ;
			saveFile(subprogramsFile_ADB, addSubprogramHeader_ADB,
					_subprogramImplCode.getOutput()) ;

    		String sourceText = AadlBaToADAUnparser.srcText.replaceAll(".ads", "");
			// subprogram.ads
			FileWriter subprogramsFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("subprograms.ads");
		    String addSubprogramsHeader_ADS = "pragma Style_Checks(\"NM32766\");\nwith Gtypes; use Gtypes;\n"+"with "+sourceText+";\n"+ headerGuard;
			saveFile(subprogramsFile_ADS, "", addSubprogramsHeader_ADS,
					_subprogramHeaderCode.getOutput()) ;

			// activity.adb     
			FileWriter activityFile_ADB =
					new FileWriter(targetDirectory.getAbsolutePath() + "/activity.adb") ;
			String addActivityHeader_ADB = getAdditionalHeader(_activityImplCode) ;
			saveFile(activityFile_ADB, addActivityHeader_ADB, _activityImplCode.getOutput()) ;

			// activity.ads
			FileWriter activityFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/activity.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("activity.ads");
			String addActivityHeader_ADS = "pragma Style_Checks(\"NM32766\");\nwith System;\nwith Ada.Real_Time;\nwith Subprograms;use Subprograms;\nwith Gtypes; use Gtypes;\n" + headerGuard;
			saveFile(activityFile_ADS, "",
					addActivityHeader_ADS, _activityHeaderCode.getOutput()) ;


			// partition's deployment.ads
			FileWriter deploymentFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("deployment.ads");
			String addDeploymentHeader_ADS = "pragma Style_Checks(\"NM32766\");\n" + headerGuard;
			saveFile(deploymentFile_ADS, "", MAIN_HEADER_INCLUSION,
					addDeploymentHeader_ADS, _deploymentHeaderCode.getOutput()) ;

		}
		catch(IOException e)
		{
			// TODO: handle error message.
			e.printStackTrace() ;
		}
	}

	private String getAdditionalHeader(AadlToADASwitchProcess fileUnparser)
	{
		StringBuffer res = new StringBuffer("") ;

		if(_additionalHeaders.containsKey(fileUnparser))
		{
			Set<String> additionalTypeHeaders = _additionalHeaders.get(fileUnparser) ;

			for(String s : additionalTypeHeaders)
			{
				s.substring(0, 1).toUpperCase();
				res.append("with " + s + "\n") ;
			}
		}

		return res.toString() ;
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

	public boolean resolveExistingCodeDependencies(NamedElement object,
			AadlToADASwitchProcess sourceNameDest,
			AadlToADASwitchProcess sourceTextDest)
					throws Exception
					{
		ne = object;
		
		List<String> sourceText =
				PropertyUtils.getStringListValue(ne, "Source_Text") ;
		

		Set<String> l = new HashSet<String>() ;
		int count = 0;
		for(String s : sourceText)
		{
			if((s.endsWith(".h") && this.language.get(count).equalsIgnoreCase("C")) || (s.endsWith(".ads")))
				//if(s.endsWith(".h"))
			{
				if(_additionalHeaders.containsKey(sourceTextDest) == false)
				{
					l.add(s) ;
					_additionalHeaders.put(sourceTextDest, l) ;
				}
				else
				{
					_additionalHeaders.get(sourceTextDest).add(s) ;
				}
			    sourceName = GenerationUtilsADA.resolveExistingCodeDependencies(object, l);

				if(sourceNameDest!=null)
					sourceNameDest.addOutput(sourceName) ;


				return true ;
			}
			count++;
		}

		return false ;
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
			resolveExistingCodeDependencies(dst, sourceNameDest, sourceTextDest) ;
		}
		catch(Exception e)
		{
			if(dst instanceof DataPrototype && owner!=null)
			{
				for(PrototypeBinding pb: owner.getOwnedPrototypeBindings())
				{
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
			} else
				sourceNameDest.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(dst
						.getQualifiedName())) ;
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
		 String annexName = as.getName() ;
		 if(annexName.equalsIgnoreCase(AadlBaUnParserAction.ANNEX_NAME))
			 annexName = "ada_"+annexName;
		 AnnexUnparser unparser =
				 ServiceRegistryProvider.getServiceRegistry()
				 .getUnparser(annexName) ;

		 // XXX May AadlBaToADAUnparser have its own interface ???
		 if(unparser != null && unparser instanceof AadlBaToADAUnparserAction )
		 {
			 AadlBaToADAUnparserAction baToADAUnparserAction =
					 (AadlBaToADAUnparserAction) unparser ;

			 AadlBaToADAUnparser baToADAUnparser =
					 baToADAUnparserAction.getUnparser() ;

			 baToADAUnparser.setDataAccessMapping(_dataAccessMapping) ;
			 baToADAUnparser.setOwner(owner);

			 baToADAUnparserAction.unparseAnnexSubclause(as,
					 codeUnparser.getIndent()) ;



			 baToADAUnparser.addIndent_ADB(codeUnparser.getIndent()) ;
			 baToADAUnparser.addIndent_ADS(headerUnparser.getIndent()) ;
			 codeUnparser.addOutput(baToADAUnparser.getCContent()) ;
			 headerUnparser.addOutput(baToADAUnparser.getHContent()) ;

			 if(_additionalHeaders.get(headerUnparser) == null)
			 {
				 Set<String> t = new HashSet<String>() ;
				 _additionalHeaders.put(headerUnparser, t) ;
			 }

			 _additionalHeaders.get(headerUnparser)
			 .addAll(baToADAUnparser.getAdditionalHeaders()) ;
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


	 protected void getADATypeDeclarator(NamedElement object,
			 boolean delayComplexTypes)
	 {

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
							 getADATypeDeclarator(cv.getClassifier(), false);
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
			 if (!listeTypes.contains(id))
				 listeTypes.add(id);
			 break ;
		 }
		 case CHARACTER :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Character;") ;
			 _gtypesHeaderCode.decrementIndent();
			 if (!listeTypes.contains(id))
				 listeTypes.add(id);
			 break ;
		 }
		 case FIXED :
			 break ;
		 case FLOAT :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Float;") ;
			 _gtypesHeaderCode.decrementIndent();
			 if (!listeTypes.contains(id))
				 listeTypes.add(id);
			 break ;
		 }
		 case INTEGER :
		 {
			 //if(id.equals("Base_Types_Unsigned_8"))
			 //{
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Integer;") ;
				 _gtypesHeaderCode.decrementIndent();
				 
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutput("Integer_Default_Value : " + id + " := 0") ;
				 _gtypesHeaderCode.addOutputNewline(";") ;
				 
				 if (!listeTypes.contains(id))
					 listeTypes.add(id);
				 break ;	 

		 }
		 case STRING :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is String;") ;
			 _gtypesHeaderCode.decrementIndent();
			 if (!listeTypes.contains(id))
				 listeTypes.add(id);
			 break ;
		 }
		 // Complex types
		 case ENUM :
		 {
			 if(delayComplexTypes)
			 {
				 _delayedDataDeclarations.add(object) ;
				 break ;
			 }

			 if (!listeTypes.contains(id))
				 listeTypes.add(id);

			 _gtypesHeaderCode.addOutputNewline("subtype e_" + id + " is ( ") ;
	
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
										 " = " +
												 stringifiedRepresentation.get(lv
														 .getOwnedListElements().indexOf(v)) ;
							 }

							 if(it.hasNext())
							 {
								 rep += "," ;
							 }

							 _gtypesHeaderCode.addOutputNewline(id + "_" +
									 enumString.getValue() + rep) ;
						 }
					 }
				 }
			 }

			 _gtypesHeaderCode.decrementIndent() ;
			 _gtypesHeaderCode.addOutputNewline(") " + id + ";") ;
			 break ;
		 }
		 case STRUCT :
		 {
			 if(delayComplexTypes)
			 {
				 _delayedDataDeclarations.add(object) ;
				 break ;
			 }

			 if (!listeTypes.contains(id))
				 listeTypes.add(id);

			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is new record") ;
			 _gtypesHeaderCode.incrementIndent() ;
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
							 _gtypesHeaderCode.addOutputNewline(stringifiedElementNames.get(lv.getOwnedListElements()
									 .indexOf(v)) + " : " + type +";") ;
						 }
					 }
				 }
			 }

			 _gtypesHeaderCode.decrementIndent() ;
			 _gtypesHeaderCode.addOutputNewline("end record;") ;
			 break ;
		 }
		 case UNION :
		 {
			 if(delayComplexTypes)
			 {
				 _delayedDataDeclarations.add(object) ;
				 break ;
			 }

			 if (!listeTypes.contains(id))
				 listeTypes.add(id);

			 _gtypesHeaderCode.addOutputNewline("case " + id + " is") ;
			 _gtypesHeaderCode.incrementIndent() ;
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
					 int indice = 1;

					 for(PropertyExpression v : lv.getOwnedListElements())
					 {
						 if(v instanceof ClassifierValue)
						 {
							 _gtypesHeaderCode.addOutputNewline("when " + indice + " =>");
							 _gtypesHeaderCode.incrementIndent();
							 indice++;
							 ClassifierValue cv = (ClassifierValue) v ;
							 String type =
									 GenerationUtilsADA.getGenerationADAIdentifier(cv
											 .getClassifier().getQualifiedName()) ;
							 _gtypesHeaderCode.addOutputNewline(stringifiedElementNames.get(lv.getOwnedListElements()
									 .indexOf(v)) + " : " + type + ";") ;
							 _gtypesHeaderCode.decrementIndent() ;
						 }
					 }
				 }
			 }

			 _gtypesHeaderCode.decrementIndent() ;
			 _gtypesHeaderCode.addOutputNewline("end case;") ;
			 break ;
		 }
		 case ARRAY :
		 {

			 EList<PropertyExpression> baseType =
					 PropertyUtils
					 .getPropertyExpression(dataTypeHolder.klass,
							 DataModelProperties.BASE_TYPE) ;

			 if (!listeTypes.contains(id))
				 listeTypes.add(id);

			 _gtypesHeaderCode.addOutput(id) ;
			 _gtypesHeaderCode.addOutput(" : array ") ;
			 EList<PropertyExpression> arrayDimensions =
					 PropertyUtils
					 .getPropertyExpression(dataTypeHolder.klass,
							 DataModelProperties.DIMENSION) ;

			 for(PropertyExpression dimensionProperty : arrayDimensions)
			 {
				 if(dimensionProperty instanceof ListValue)
				 {
					 ListValue lv = (ListValue) dimensionProperty ;

					 for(PropertyExpression v : lv.getOwnedListElements())
					 {
						 if(v instanceof IntegerLiteral)
						 {
							 _gtypesHeaderCode.addOutput("(0 .. ") ;
							 IntegerLiteral dimension = (IntegerLiteral) v ;
							 _gtypesHeaderCode.addOutput(Long.toString(dimension.getValue() - 1)) ;
							 _gtypesHeaderCode.addOutput(" )") ;
						 }
					 }
				 }
			 }

			 _gtypesHeaderCode.addOutputNewline(" of ") ;

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
							 _gtypesHeaderCode.addOutput(GenerationUtilsADA
									 .getGenerationADAIdentifier(cv.getClassifier()
											 .getQualifiedName())) ;
						 }
					 }
				 }
			 }

			 _gtypesHeaderCode.addOutputNewline(";") ;
			 break ;
		 }
		 case UNKNOWN :
		 {
			 try
			 {
				 _gtypesHeaderCode.addOutputNewline("");
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutput("subtype ") ;
				 _gtypesHeaderCode.addOutput(id + " is " + object.getName()) ;


				 _gtypesHeaderCode.addOutputNewline(";") ;
				 _gtypesHeaderCode.decrementIndent();

				 if (!listeTypes.contains(id))
					 listeTypes.add(id);
			 }
			 catch(Exception e)
			 {
				 return ;
			 }

			 break ;
		 }
		 }
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

				 getADATypeDeclarator(object, true) ;
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
						 ServiceRegistryProvider.getServiceRegistry()
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
						 ServiceRegistryProvider.getServiceRegistry().getUnparser("--") ;

				 if(unparser != null)
				 {
				 }

				 return DONE ;
			 }

			 @Override
			 public String caseDataImplementation(DataImplementation object)
			 {
				 _currentHeaderUnparser = _gtypesHeaderCode ;
				 _gtypesHeaderCode.processComments(object) ;
				 getADATypeDeclarator(object, true) ;
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

				 //Deployment Header Code

				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("pragma Preelaborate;");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("type Node_Type is ");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_K);");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.addOutputNewline("");				 

				 _deploymentHeaderCode.addOutputNewline("for Node_Type use ");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_K => 1);");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 
				 _deploymentHeaderCode.addOutputNewline("");				 					
				 
				 _deploymentHeaderCode.addOutputNewline("for Node_Type'Size use 8;");
				 
				 _deploymentHeaderCode.addOutputNewline("");				 					
				 
				 _deploymentHeaderCode.addOutputNewline("Max_Node_Image_Size : constant Standard.Integer := 8;");
				 
				 _deploymentHeaderCode.addOutputNewline("");				 					
				 
				 _deploymentHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_Node_Type_Range is ");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("Node_Type range Node_Type'First .. Node_Type'Last;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_1_Max_Node_Image_Size is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("Integer range 1 .. Max_Node_Image_Size;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();

				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_Node_Image_Component is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("Standard.String (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_1_Max_Node_Image_Size);");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();

				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_Node_Image_Array is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_Node_Type_Range)");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("of UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()).replaceAll("_refined_", "")+"_Node_Image_Component;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("Node_Image : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_Node_Image_Array := ");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_Node_Image_Array'");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+" => \""+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"\");");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();

				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("My_Node : constant Node_Type :=");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+";");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 _deploymentHeaderCode.addOutputNewline("--  For each thread in the distributed application nodes, add an enumerator");
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("type Entity_Type is ");
				 
				 _deploymentHeaderCode.addOutput("(");
				 
				 int taille = object.getOwnedThreadSubcomponents().size();
				 int taille2 = object.getOwnedThreadSubcomponents().size();
				 int taille3 = object.getOwnedThreadSubcomponents().size();
				 int taille4 = object.getOwnedThreadSubcomponents().size();

				 for (ThreadSubcomponent th : object.getOwnedThreadSubcomponents())
				 {
					 taille--;
					 if(taille >= 1)
						 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K,");
					 else
						 _deploymentHeaderCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K");
				 }

				 _deploymentHeaderCode.addOutputNewline(");");

				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("for Entity_Type use");
				 _deploymentHeaderCode.addOutput("(");

				 int cpt = 0;

				 for (ThreadSubcomponent th : object.getOwnedThreadSubcomponents())
				 {
					 cpt++;
					 taille2--;
					 if(taille2 >= 1)
					 {
						 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
						 _deploymentHeaderCode.incrementIndent();
						 _deploymentHeaderCode.incrementIndent();
						 _deploymentHeaderCode.addOutputNewline(""+cpt+",");
						 _deploymentHeaderCode.decrementIndent();
						 _deploymentHeaderCode.decrementIndent();
					 }
					 else
					 {
					 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
					 _deploymentHeaderCode.incrementIndent();
					 _deploymentHeaderCode.incrementIndent();
					 _deploymentHeaderCode.addOutput(""+cpt);
					 _deploymentHeaderCode.decrementIndent();
					 _deploymentHeaderCode.decrementIndent();
					 }
				 }
				 _deploymentHeaderCode.addOutputNewline(");");

				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("for Entity_Type'Size use 8;");
				 
				 _deploymentHeaderCode.addOutputNewline("  --  Entity Table");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Type_Range is");
				 _deploymentHeaderCode.addOutputNewline("Entity_Type range Entity_Type'First .. Entity_Type'Last;");

				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Table_Array is");
				 _deploymentHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Type_Range)");
				 _deploymentHeaderCode.addOutputNewline("of Node_Type");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("Entity_Table : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Table_Array :=");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Table_Array'");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.addOutputNewline("(");

				 	String Dispatch = null;
				 	
				 
				 for (ThreadSubcomponent th : object.getOwnedThreadSubcomponents())
				 {

					    try {
							Dispatch = PropertyUtils.getEnumValue(th, "Dispatch_Protocol");
						} catch (Exception exception) {
							throw new PropertyNotFound(exception);
						}
					 if (Dispatch.equals("Sporadic"))
					 {
						 nbSporadic++;
						 sporadicThreads.add(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K");
					 }
					 else
					 {
						 nbPeriodic++;
						 periodicThreads.add(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K");
					 }
					 
					 taille3--;
					 if(taille3 >= 1)
					 {
						 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
						 _deploymentHeaderCode.incrementIndent();
						 _deploymentHeaderCode.incrementIndent();		 
						 _deploymentHeaderCode.addOutputNewline(""+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_K,");
						 _deploymentHeaderCode.decrementIndent();
						 _deploymentHeaderCode.decrementIndent();
					 }
					 else
					 {
					 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
					 _deploymentHeaderCode.incrementIndent();
					 _deploymentHeaderCode.incrementIndent();
					 _deploymentHeaderCode.addOutputNewline(""+GenerationUtilsADA.getGenerationADAIdentifier(object.getContainingComponentImpl().getFullName())+"_K");
					 _deploymentHeaderCode.decrementIndent();
					 _deploymentHeaderCode.decrementIndent();
					 }
				 }
				 					 
				 _deploymentHeaderCode.addOutputNewline(");");
				 
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("  Max_Entity_Image_Size : constant Standard.Integer := 14");
				 
				 _deploymentHeaderCode.addOutputNewline("  --  Maximal Entity_Image size for this node ");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("  --  Maximal Entity_Image size for this node ");

				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("  --  Entity Image");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_1_Max_Entity_Image_Size is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();	 
				 _deploymentHeaderCode.addOutputNewline("Integer range 1 .. Max_Entity_Image_Size;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
			 
				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Image_Component is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("Standard.String");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("(UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_1_Max_Entity_Image_Size);");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
			 
				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Image_Array is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Type_Range)");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("of UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Image_Component;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
			 
				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("Entity_Image : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Image_Array :=");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Entity_Image_Array'");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.addOutputNewline("(");

				 for (ThreadSubcomponent th : object.getOwnedThreadSubcomponents())
				 {
					 taille4--;
					 if(taille4 >= 1)
					 {
						 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
						 _deploymentHeaderCode.incrementIndent();
						 _deploymentHeaderCode.incrementIndent();
						 _deploymentHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K\"");
						 _deploymentHeaderCode.decrementIndent();
						 _deploymentHeaderCode.decrementIndent();
					 }
					 else
					 {
					 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
					 _deploymentHeaderCode.incrementIndent();
					 _deploymentHeaderCode.incrementIndent();
					 _deploymentHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K\"");
					 _deploymentHeaderCode.decrementIndent();
					 _deploymentHeaderCode.decrementIndent();

					 }
				 }
				 
				 _deploymentHeaderCode.addOutputNewline(");");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("  --  For each thread port in the distributed application nodes, add an enumerator");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("type Port_Type is");

				 _deploymentHeaderCode.addOutput("(");

				 int sum = 0;
				 int sum2 = 0;
				 int sum3 = 0;
				 int sum4 = 0;
				 
				 for (ThreadSubcomponent th : object.getOwnedThreadSubcomponents())
				 {
					 sum =sum +th.getAllFeatures().size();
					 sum2 =sum2 +th.getAllFeatures().size();
					 sum3 = sum3 +th.getAllFeatures().size();
					 sum4 = sum4 +th.getAllFeatures().size();

				 }						 
				 
				 for(int i=0; i<object.getOwnedThreadSubcomponents().size();i++)
				 {
					 for(int nbPorts =0; nbPorts<object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
					 {
						sum --;
					    if(sum >=1)
				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K,");
						 else
  				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K");		 
					 }
				 }
				 
				 _deploymentHeaderCode.addOutputNewline(");");

				 _deploymentHeaderCode.addOutputNewline("");


				 _deploymentHeaderCode.addOutputNewline("for Port_Type use");

				 _deploymentHeaderCode.addOutput("(");

				 int cptt =0;
				 for(int i=0; i<object.getOwnedThreadSubcomponents().size();i++)
				 {
					 for(int nbPorts =0; nbPorts<object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
					 {
						cptt++;
						sum2 --;
					    if(sum2 >=1)
				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => "+cptt+",");
						 else
  				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => "+cptt);		 
					 }
				 }
				 _deploymentHeaderCode.addOutputNewline(");");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("  --  Size of Port_Type fixed to 16 bits");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("for Port_Type'Size use 16;");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("--  Port Table");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Type_Range is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("Port_Type range Port_Type'First .. Port_Type'Last;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Table_Array is");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Type_Range)");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("of Entity_Type;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();

				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("  Port_Table : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Table_Array :=");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Table_Array'");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.addOutput("(");
				 
				 for(int i=0; i<object.getOwnedThreadSubcomponents().size();i++)
				 {
					 for(int nbPorts =0; nbPorts<object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
					 {
						sum3 --;
					    if(sum3 >=1)
					    {
					    	 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");
							 _deploymentHeaderCode.incrementIndent();
							 _deploymentHeaderCode.incrementIndent();
							 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+object.getOwnedThreadSubcomponents().get(i).getFullName()+"_K"+",");
							 _deploymentHeaderCode.decrementIndent();
							 _deploymentHeaderCode.decrementIndent();
					    }
						 else
						 {
			  				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");		 
			  				 _deploymentHeaderCode.incrementIndent();
							 _deploymentHeaderCode.incrementIndent();
			  				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+object.getOwnedThreadSubcomponents().get(i).getFullName()+"_K");
							 _deploymentHeaderCode.decrementIndent();
							 _deploymentHeaderCode.decrementIndent();
						 }
					 }
				 }
				 _deploymentHeaderCode.addOutputNewline(");");
				 
				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("Max_Port_Image_Size : constant Standard.Integer := 19;");
				 
				 _deploymentHeaderCode.addOutputNewline("--  Maximal Port_Image size for this node");

				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("subtype Port_Sized_String is");
  				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("Standard.String");
  				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("(1 .. Deployment.Max_Port_Image_Size);");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("--  Port Image");
				 
				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Image_Array is");
  				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Type_Range)");
  				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("of Port_Sized_String;");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();

				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("Port_Image : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Image_Array :=");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_Port_Image_Array'");
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutput("(");
				 
				 for(int i=0; i<object.getOwnedThreadSubcomponents().size();i++)
				 {
					 for(int nbPorts =0; nbPorts<object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
					 {
						sum4 --;
					    if(sum4 >=1)
					    {
					    	 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");
							 _deploymentHeaderCode.incrementIndent();
							 _deploymentHeaderCode.incrementIndent();
					    	 _deploymentHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K \""+",");
							 _deploymentHeaderCode.decrementIndent();
							 _deploymentHeaderCode.decrementIndent();
					    }
						 else
						 {
			  				 _deploymentHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");		 
							 _deploymentHeaderCode.incrementIndent();
							 _deploymentHeaderCode.incrementIndent();
			  				 _deploymentHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(object.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(object.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K \"");
							 _deploymentHeaderCode.decrementIndent();
							 _deploymentHeaderCode.decrementIndent();
						 }
					 }
				 }
				 
				 _deploymentHeaderCode.addOutputNewline(");");
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();
				 _deploymentHeaderCode.decrementIndent();


				 _deploymentHeaderCode.addOutputNewline("");
				 
				 _deploymentHeaderCode.addOutputNewline("--  Maximal message payload size for this node (in bits)");
				
				 _deploymentHeaderCode.addOutputNewline("");

				 _deploymentHeaderCode.addOutputNewline("Max_Payload_Size : constant Standard.Integer := 112;");

				 _deploymentHeaderCode.addOutputNewline("");
					
				 /*Process Impl Code*/
				 buildDataAccessMapping(object) ;

				 processEList(object.getOwnedThreadSubcomponents()) ;
 
				 return DONE ;
			 }
			 		 
			 // Builds the data access mapping via the connections described in the
			 // process implementation.
			 private void buildDataAccessMapping(ComponentImplementation cptImpl)
			 {

				 EList<Subcomponent> subcmpts = cptImpl.getAllSubcomponents() ;

				 List<String> dataSubcomponentNames = new ArrayList<String>() ;

				 // Fetches data subcomponent names.
				 for(Subcomponent s : subcmpts)
				 {
					 if(s instanceof DataSubcomponent)
					 {
						 dataSubcomponentNames.add(s.getName()) ;
					 }
				 }

				 // Binds data subcomponent names with DataAcess objects.
				 // See process implementation's connections.
				 for(Connection connect : cptImpl.getAllConnections())
				 {
					 if (connect instanceof AccessConnection &&
							 ((AccessConnection) connect).getAccessCategory() == AccessCategory.DATA &&
							 connect.getAllDestination() instanceof DataSubcomponent)
					 {

						 if(connect.getAllDestination() instanceof DataSubcomponent)
						 {
							 DataSubcomponent destination =  (DataSubcomponent) connect.
									 getAllDestination() ;

							 if(Aadl2Utils.contains(destination.getName(), dataSubcomponentNames))
							 {
								 ConnectedElement source = (ConnectedElement) connect.getSource() ;
								 DataAccess da = (DataAccess) source.getConnectionEnd() ;
								 _dataAccessMapping.put(da, destination.getName()) ; 
							 }
						 }
						 else
						 {
							 if(connect.getAllSource() instanceof DataSubcomponent)
							 {
								 DataSubcomponent source =  (DataSubcomponent) connect.
										 getAllSource() ;
								 if(Aadl2Utils.contains(source.getName(), dataSubcomponentNames))
								 {
									 ConnectedElement dest = (ConnectedElement) connect.getDestination() ;

									 DataAccess da = (DataAccess) dest.getConnectionEnd() ;
									 _dataAccessMapping.put(da, source.getName()) ;
								 }
							 }
						 }
					 }
				 }
			 }

			 @Override
			 public String caseProcessSubcomponent(ProcessSubcomponent object)
			 {
				 process(object.getComponentImplementation()) ;
				 return DONE ;
			 }

			 @Override
			 public String caseThreadImplementation(ThreadImplementation object)
			 {
				 	 
				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return DONE ;
				 }
				 _processedTypes.add(object.getQualifiedName());
				 _currentImplUnparser = _activityImplCode ;
				 _currentHeaderUnparser = _activityHeaderCode ;
				 buildDataAccessMapping(object) ;
				 process(object.getType()) ;

				 _currentImplUnparser.incrementIndent() ;

				 
				 for(DataSubcomponent d : object.getOwnedDataSubcomponents())
				 {
					 process(d) ;
				 }


				 _currentImplUnparser.addOutputNewline("function " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + "_Job"+" return PolyORB_HI.Errors.Error_Kind "+ "is") ;
				 				 _currentImplUnparser.addOutputNewline("Error_u : PolyORB_HI.Errors.Error_Kind;");
				 _currentImplUnparser.addOutputNewline("begin") ;

				 //testSma
				 
				 
				 _currentImplUnparser.addOutputNewline("loop") ;
				 _currentImplUnparser.incrementIndent() ;
				 			 					 
						processBehavioredImplementation(object);
						 
						 _activityImplCode.decrementIndent() ;
						 _activityImplCode.addOutputNewline("end loop;") ;
						 _activityImplCode.addOutputNewline("--  Return error code");
						 _activityImplCode.addOutputNewline("return Error_u;");
						 _activityImplCode.decrementIndent() ;
						 _activityImplCode.addOutput("end " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + "_Job;") ;
						 
						 _activityImplCode.addOutputNewline("");						 
						 
						 _activityHeaderCode.addOutput("function " + GenerationUtilsADA
								 .getGenerationADAIdentifier(object.getQualifiedName()) + "_Job") ;
						 
						 _activityHeaderCode.addOutputNewline(" return  PolyORB_HI.Errors.Error_Kind;");



						 _activityHeaderCode.addOutput("package "+GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + "_Task");
						 
						 if(dispatchProtocol.equals("Periodic"))
						 {
							 
							 _activityHeaderCode.addOutputNewline(" is new PolyORB_HI.Periodic_Task");
							 _activityHeaderCode.addOutputNewline("(");
							 
							 _activityHeaderCode.addOutput("Entity => ");
 							 _activityHeaderCode.addOutputNewline("Deployment."+periodicThreads.get(compteurPer).toString()+",");
							 compteurPer++;
							 
							 if(period !=null)
							 {
							 _activityHeaderCode.addOutputNewline("Task_period => Ada.Real_Time.Milliseconds");
							 _activityHeaderCode.addOutputNewline("("+period+"),");
							 }
							 
							 if(deadline != null)
							 {
							 _activityHeaderCode.addOutputNewline("Task_Deadline => Ada.Real_Time.Milliseconds");
							 _activityHeaderCode.addOutputNewline("("+deadline+"),");
							 }
							 
							 _activityHeaderCode.addOutputNewline("Task_Priority => ("+priority+")");
							 _activityHeaderCode.addOutputNewline("Task_Stack_Size => 10000");
							 _activityHeaderCode.addOutputNewline("Job => "+GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())); 
							 _activityHeaderCode.addOutputNewline(");");

							 _activityHeaderCode.addOutputNewline("");
							 
						 }

						 
						 else
						 {
							 _activityHeaderCode.addOutputNewline(" is new PolyORB_HI.Sporadic_Task");
	 						 
							 _activityHeaderCode.addOutputNewline("(");
							 
							 _activityHeaderCode.addOutput("Entity => ");

							_activityHeaderCode.addOutputNewline("Deployment."+sporadicThreads.get(compteurSpor).toString()+",");
							compteurSpor++;

							 // a modifier 
							 _activityHeaderCode.addOutputNewline("Port_Type => The_Receiver_2_impl_Port_Type");
							 if(period !=null)
							 {
							 _activityHeaderCode.addOutputNewline("Task_period => Ada.Real_Time.Milliseconds");
							 _activityHeaderCode.addOutputNewline("("+period+"),");
							 }
							 
							 if(deadline != null)
							 {
							 _activityHeaderCode.addOutputNewline("Task_Deadline => Ada.Real_Time.Milliseconds");
							 _activityHeaderCode.addOutputNewline("("+deadline+"),");
							 }
							 
							 _activityHeaderCode.addOutputNewline("Task_Priority => ("+priority+")");
							 _activityHeaderCode.addOutputNewline("Task_Stack_Size => 10000");
							 _activityHeaderCode.addOutputNewline("Job => "+GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())); 
							 _activityHeaderCode.addOutputNewline("Wait_For_Incoming_Events => Wait_For_Incoming_Events");
							 _activityHeaderCode.addOutputNewline(");");

							 _activityHeaderCode.addOutputNewline("");
 
						 }						 						 

						 return null ;
			 }

			 @Override
			 public String caseSubprogramCallSequence(SubprogramCallSequence object)
			 {
				 for(CallSpecification cs : object.getOwnedCallSpecifications())
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
				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return DONE ;
				 }
				 _processedTypes.add(object.getQualifiedName());
				 
				 //the problem
				 try {
					 resolveExistingCodeDependencies(object, null, _subprogramHeaderCode);
				 } catch (Exception e1) {
					 
					 caseSubprogramClassifier(object);
					 processBehavioredType(object) ;

					 _subprogramImplCode.decrementIndent();
					 _subprogramImplCode.addOutputNewline("end " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + ";");	
				 }

				 return DONE;
			 }

			 @Override
			 public String caseSubprogramClassifier(SubprogramClassifier object)
			 {
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
					 _subprogramHeaderCode.addOutput("procedure ");
				 }

				 else
				 {
					 _subprogramImplCode.addOutput("function ");
					 _subprogramHeaderCode.addOutput("function ");
						
				 }

				 _subprogramImplCode.decrementIndent();   
			     _subprogramImplCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()));
			     _subprogramHeaderCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()));

       	         _subprogramImplCode.addOutput("(");
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
			  			  _subprogramImplCode.addOutput("; ") ;
			  			  _subprogramHeaderCode.addOutput("; ") ;
			  			}			  			
			 			processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramImplCode, _subprogramImplCode);
			  			processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
			  			System.out.println();
						 if (Aadl2Utils.isInOutParameter(p))
						 {
							 _subprogramImplCode.addOutput(" : in out ") ;
							 _subprogramHeaderCode.addOutput(" : in out ") ;
							 _subprogramHeaderCode.addOutput(p.getDataFeatureClassifier().getFullName());
							 _subprogramImplCode.addOutput(p.getDataFeatureClassifier().getFullName());

						 }
						 else if (Aadl2Utils.isOutParameter(p))
						 {
							 _subprogramImplCode.addOutput(" : out ") ;
							 _subprogramHeaderCode.addOutput(" : out ") ;
							 _subprogramHeaderCode.addOutput(p.getDataFeatureClassifier().getFullName());
							 _subprogramImplCode.addOutput(p.getDataFeatureClassifier().getFullName());
						 }
						 else
						 {
							 _subprogramImplCode.addOutput(" : in ") ;
							 _subprogramHeaderCode.addOutput(" : in ") ;
							 _subprogramHeaderCode.addOutput(p.getDataFeatureClassifier().getFullName());
							 _subprogramImplCode.addOutput(p.getDataFeatureClassifier().getFullName());
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
							 _subprogramHeaderCode.addOutput("; ") ;
						 }

						 if(da.getKind().equals(AccessType.REQUIRES))
						 {
							 _subprogramImplCode.addOutput(" "+da.getName());
							 _subprogramHeaderCode.addOutput(" "+da.getName());

							 if (Aadl2Utils.isReadWriteDataAccess(da))
							 {
								 _subprogramImplCode.addOutput(" : in out ") ;
								 _subprogramHeaderCode.addOutput(" : in out ") ;
								 _subprogramHeaderCode.addOutput(da.getDataFeatureClassifier().getFullName());
								 _subprogramImplCode.addOutput(da.getDataFeatureClassifier().getFullName());
							 }
							 else if (Aadl2Utils.isWriteOnlyDataAccess(da))
							 {
								 _subprogramImplCode.addOutput(" : out ") ;
								 _subprogramHeaderCode.addOutput(" : out ") ;
								 _subprogramHeaderCode.addOutput(da.getDataFeatureClassifier().getFullName());
								 _subprogramImplCode.addOutput(da.getDataFeatureClassifier().getFullName());
							 }
							 else
							 {
								 _subprogramImplCode.addOutput(" : in ") ;
								 _subprogramHeaderCode.addOutput(" : in ") ;
								 _subprogramHeaderCode.addOutput(da.getDataFeatureClassifier().getFullName());
								 _subprogramImplCode.addOutput(da.getDataFeatureClassifier().getFullName());
							 }  			  
						 }
		

//						 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramImplCode, _currentImplUnparser);
//						 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);

						 first=false;

						 process(da.getDataFeatureClassifier());
					 }
				 }
				 _subprogramImplCode.addOutput(")");
				 _subprogramImplCode.addOutputNewline(" is ");
				 _subprogramImplCode.incrementIndent();
			    	
				 _subprogramHeaderCode.addOutputNewline(");");
    		     _subprogramHeaderCode.addOutputNewline("");


    		     System.out.println("");
 
    		 					 
				 return null;
			 }

			 @Override
			 public String caseSubprogramImplementation(SubprogramImplementation object)
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
			        } catch (Exception e1) {
			      	  caseSubprogramClassifier((SubprogramClassifier) object);
			        
			    	  for(DataSubcomponent d : object.getOwnedDataSubcomponents())
			          {
			            process(d) ;
			          }

			          processBehavioredImplementation(object) ;

						 _subprogramImplCode.decrementIndent();
			  		     _subprogramImplCode.addOutputNewline("end "+GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())+";");  		   
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
								 /*if(Aadl2Utils.isInOutParameter(p) ||
	    							  Aadl2Utils.isOutParameter(p))
	    					  {
	    						  _currentImplUnparser.addOutput("&") ;
	    					  }*/
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
							/*if(da.getKind().equals(AccessType.REQUIRES))
	    					  {
	    						  if(Aadl2Utils.isReadWriteDataAccess(da)
	    								  || Aadl2Utils.isWriteOnlyDataAccess(da))
	    						  {
	    							  _currentImplUnparser.addOutput("&") ;
	    						  }
	    					  }
	    					  */

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
			  int cpt=0;
			  @Override
		      public String caseDataAccess(DataAccess object)
		      {
		        _currentImplUnparser.addOutput("") ;
		        String dataSubprogramName = null ;
		        
		        if(_dataAccessMapping != null)
		        {
		          dataSubprogramName = _dataAccessMapping.get(object) ;
		        }
		        
		        // a modifier
		        if(dataSubprogramName != null)
		        {
		          _currentImplUnparser.addOutput(dataSubprogramName);
 		          _activityHeaderCode.addOutputNewline("type "+dataSubprogramName+"_Port_Type"+" is(");
 		          _activityHeaderCode.addOutputNewline(dataSubprogramName+");");
 		          _activityHeaderCode.addOutputNewline("");

		        }		 
		        else
		        {
		          _currentImplUnparser.addOutput(GenerationUtilsADA
		                .getGenerationADAIdentifier(object.getQualifiedName())) ;

		          _activityHeaderCode.addOutputNewline("type "+GenerationUtilsADA
			                .getGenerationADAIdentifier(object.getQualifiedName())+"_Port_Type"+" is(");
 		          _activityHeaderCode.addOutputNewline(GenerationUtilsADA
			                .getGenerationADAIdentifier(object.getQualifiedName())+");");
 		          _activityHeaderCode.addOutputNewline("");
 		          
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
		        
		        if(dataSubprogramName==null)
		        nl=true;
		        
		        if(nl)
		        {
			        if(dispatchProtocol.equals("Sporadic"))
			          {
			        	  _currentImplUnparser.addOutputNewline("");
		 		          _currentImplUnparser.addOutputNewline("procedure Wait_For_Incoming_Events");
		 		          _currentImplUnparser.addOutputNewline("(Entity : PolyORB_HI_Generated.Deployment.Entity_Type;");
		 		          // a modifier out static
		 		          _currentImplUnparser.addOutputNewline("Port : out "+GenerationUtilsADA
					                .getGenerationADAIdentifier(object.getQualifiedName())+")");
		 		          _currentImplUnparser.addOutputNewline(")");
		 		          _currentImplUnparser.addOutputNewline("is");
		 		          _currentImplUnparser.addOutputNewline("begin");
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("case Entity is");
		 		          // am modifier
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("when PolyORB_HI_Generated.Deployment.proc_a_Task3_K =>");
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("null;");
		 		          _currentImplUnparser.addOutputNewline("pragma Warnings (Off);");
		 		          _currentImplUnparser.addOutputNewline("when others =>");
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("raise Program_Error;");
		 		          _currentImplUnparser.decrementIndent();
   		 		          _currentImplUnparser.addOutputNewline("pragma Warnings (On);");
   		 		          _currentImplUnparser.decrementIndent();
   		 		          _currentImplUnparser.addOutputNewline("end case");
		 		          _currentImplUnparser.decrementIndent();
		 		          _currentImplUnparser.addOutputNewline("end Wait_For_Incoming_Events");
		 		          
			          }

		        }
		        else
		        {
			        if(dispatchProtocol.equals("Sporadic"))
			          {
			        	  _currentImplUnparser.addOutputNewline("");
		 		          _currentImplUnparser.addOutputNewline("procedure Wait_For_Incoming_Events");
		 		          _currentImplUnparser.addOutputNewline("(Entity : PolyORB_HI_Generated.Deployment.Entity_Type;");
		 		          // a modifier out static
		 		          _currentImplUnparser.addOutputNewline("Port : out "+dataSubprogramName);
		 		          _currentImplUnparser.addOutputNewline(")");
		 		          _currentImplUnparser.addOutputNewline("is");
		 		          _currentImplUnparser.addOutputNewline("begin");
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("case Entity is");
		 		          // am modifier
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("when PolyORB_HI_Generated.Deployment.proc_a_Task3_K =>");
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("null;");
		 		          _currentImplUnparser.addOutputNewline("pragma Warnings (Off);");
		 		          _currentImplUnparser.addOutputNewline("when others =>");
		 		          _currentImplUnparser.incrementIndent();
		 		          _currentImplUnparser.addOutputNewline("raise Program_Error;");
		 		          _currentImplUnparser.decrementIndent();
   		 		          _currentImplUnparser.addOutputNewline("pragma Warnings (On);");
   		 		          _currentImplUnparser.decrementIndent();
   		 		          _currentImplUnparser.addOutputNewline("end case");
		 		          _currentImplUnparser.decrementIndent();
		 		          _currentImplUnparser.addOutputNewline("end Wait_For_Incoming_Events");
			          }
		        }
		        
		        
		        return DONE ;
		      }
				 } ;
	 }
	 
	  public boolean sourceTextName(NamedElement object)
	  {		
		 try
	    {
	      NamedElement ne = object ;
	      String sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;
	      
	      List<String> sourceText =
	            PropertyUtils.getStringListValue(ne, "Source_Text") ;
	      
	      for(String s : sourceText)
	      {
	    	  System.out.println("sourceText"+s);
	    	}
	      throw new Exception("In component "+ne.getName()+": Source_Text " +
	      		"property should also reference a ads (.ads extension) file");
	    }
	    catch(Exception e)
	    {
	      return false ;
	    }
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
		NamedElement ne;


		
}
