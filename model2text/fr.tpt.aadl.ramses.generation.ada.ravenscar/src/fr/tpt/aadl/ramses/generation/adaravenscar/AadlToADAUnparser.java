package fr.tpt.aadl.ramses.generation.adaravenscar;

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

import org.eclipse.emf.common.util.EList;
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
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.annexsupport.AnnexUnparser;

import fr.tpt.aadl.annex.behavior.AadlBaParserAction;
import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils;
import fr.tpt.aadl.annex.behavior.utils.DimensionException;
import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider;
import fr.tpt.aadl.ramses.generation.adaravenscar.AadlToADASwitchProcess;
import fr.tpt.aadl.ramses.generation.adaravenscar.AadlToADAUnparser;
import fr.tpt.aadl.ramses.generation.adaravenscar.GenerationUtilsADA;
import fr.tpt.aadl.ramses.generation.adaravenscar.annex.behavior.AadlBaToADAUnparser;
import fr.tpt.aadl.ramses.generation.adaravenscar.annex.behavior.AadlBaToADAUnparserAction;
import fr.tpt.aadl.ramses.generation.target.specific.GeneratorUtils;
import fr.tpt.aadl.utils.Aadl2Utils;
import fr.tpt.aadl.utils.PropertyUtils;
import fr.tpt.aadl.utils.names.DataModelProperties;

public class AadlToADAUnparser extends AadlProcessingSwitch implements AadlGenericUnparser
{
	public static List <String> language;
	public static ArrayList<Boolean> ADA;
	private static ArrayList <String> activityProcedures;

	private static ArrayList <String> listeTypes;

	private static AadlToADAUnparser singleton;

	// gtype.adb and .ads
	protected AadlToADASwitchProcess _gtypesImplCode ;
	protected AadlToADASwitchProcess _gtypesHeaderCode ;

	// subprogram.adb and .ads
	protected AadlToADASwitchProcess _subprogramImplCode ;
	protected AadlToADASwitchProcess _subprogramHeaderCode ;

	// activity.adb and .ads
	protected AadlToADASwitchProcess _activityImplCode ;
	protected AadlToADASwitchProcess _activityHeaderCode ;

	// partition's deployment.adb and .ads
	protected AadlToADASwitchProcess _deploymentImplCode ;
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

		this.ADA = new ArrayList<Boolean>();
	}

	private void init()
	{
		_gtypesImplCode = new AadlToADASwitchProcess(this) ;
		_gtypesImplCode.addOutputNewline("\npackage body Gtypes is") ;

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

		_deploymentImplCode = new AadlToADASwitchProcess(this) ;
		_deploymentImplCode.addOutputNewline("\npackage body Deployment is") ;

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

		_gtypesImplCode.addOutputNewline("\nend Gtypes;\n") ;
		_subprogramImplCode.addOutputNewline("\nend Subprograms;\n") ;
		_activityImplCode.addOutputNewline("\nend Activity;\n") ;

		_deploymentImplCode.addOutputNewline("procedure Deployment is");
		_deploymentImplCode.addOutputNewline("begin");
		_deploymentImplCode.addOutputNewline("null;");		
    	_deploymentImplCode.addOutputNewline("end Deployment;");
		_deploymentImplCode.addOutputNewline("\nend Deployment;\n") ;

		try
		{
			String headerGuard = null ;

			// gtypes.adb
			FileWriter typesFile_ADA =
					new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.adb") ;
			String addTypeHeader_ADA = getAdditionalHeader(_gtypesImplCode) ;
			saveFile(typesFile_ADA, addTypeHeader_ADA, _gtypesImplCode.getOutput()) ;

			// gtypes.ads
			FileWriter typesFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("gtypes.ads") ;
			String addGtypesHeader_ADS = "with Interfaces.C;\nwith System; use System;\nwith APEX; use APEX;\nwith APEX.Blackboards; use APEX.Blackboards;\nwith APEX.Buffers; use APEX.Buffers;\n" +
					"with APEX.Events; use APEX.Events;\nwith APEX.Health_Monitoring; use APEX.Health_Monitoring;\nwith APEX.Module_Schedules; use APEX.Module_Schedules;\n" +
					"with APEX.Partitions; use APEX.Partitions;\nwith APEX.Processes; use APEX.Processes;\nwith APEX.Queuing_Ports; use APEX.Queuing_Ports;\nwith APEX.Sampling_Ports;  use APEX.Sampling_Ports;\nwith APEX.Semaphores; use APEX.Semaphores;\n" +
					"with APEX.Timing; use APEX.Timing;\n" + headerGuard;
			saveFile(typesFile_ADS, "", addGtypesHeader_ADS,
					_gtypesHeaderCode.getOutput()) ;

			// subprogram.adb
			FileWriter subprogramsFile_ADB =
					new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.adb") ;
			String addSubprogramHeader_ADB = getAdditionalHeader(_subprogramImplCode) ;
			saveFile(subprogramsFile_ADB, addSubprogramHeader_ADB,
					_subprogramImplCode.getOutput()) ;

			// subprogram.ads
			FileWriter subprogramsFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("subprograms.ads");
			String addSubprogramsHeader_ADS = "with Gtypes; use Gtypes;\nwith System; use System;\nwith Interfaces.C;\nwith APEX; use APEX;\nwith APEX.Blackboards; use APEX.Blackboards;\nwith APEX.Buffers; use APEX.Buffers;\n" +
					"with APEX.Events; use APEX.Events;\nwith APEX.Health_Monitoring; use APEX.Health_Monitoring;\nwith APEX.Module_Schedules; use APEX.Module_Schedules;\n" +
					"with APEX.Partitions; use APEX.Partitions;\nwith APEX.Processes; use APEX.Processes;\nwith APEX.Queuing_Ports; use APEX.Queuing_Ports;\nwith APEX.Sampling_Ports;  use APEX.Sampling_Ports;\nwith APEX.Semaphores; use APEX.Semaphores;\n" +
					"with APEX.Timing; use APEX.Timing;\n" + headerGuard;
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
			String addActivityHeader_ADS = "pragma No_Run_Time;\nwith System;\nwith Gtypes; use Gtypes;\nwith Subprograms; use Subprograms;\nwith Interfaces.C;\nwith APEX; use APEX;\nwith APEX.Blackboards; use APEX.Blackboards;\nwith APEX.Buffers; use APEX.Buffers;\n" +
					"with APEX.Events; use APEX.Events;\nwith APEX.Health_Monitoring; use APEX.Health_Monitoring;\nwith APEX.Module_Schedules; use APEX.Module_Schedules;\n" +
					"with APEX.Partitions; use APEX.Partitions;\nwith APEX.Processes; use APEX.Processes;\nwith APEX.Queuing_Ports; use APEX.Queuing_Ports;\nwith APEX.Sampling_Ports;  use APEX.Sampling_Ports;\nwith APEX.Semaphores; use APEX.Semaphores;\n" +
					"with APEX.Timing; use APEX.Timing;\n" + headerGuard;
			saveFile(activityFile_ADS, "",
					addActivityHeader_ADS, _activityHeaderCode.getOutput()) ;

			// partition's deployment.adb
			FileWriter deploymentFile_ADB =
					new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.adb") ;
			String addDeploymentHeader_ADB = getAdditionalHeader(_deploymentImplCode) ;
			saveFile(deploymentFile_ADB, addDeploymentHeader_ADB,
					_deploymentImplCode.getOutput()) ;


			// partition's deployment.ads
			FileWriter deploymentFile_ADS =
					new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.ads") ;
			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("deployment.ads");
			String addDeploymentHeader_ADS = "with Interfaces.C;\nwith APEX; use APEX;\nwith APEX.Blackboards; use APEX.Blackboards;\nwith APEX.Buffers; use APEX.Buffers;\n" +
					"with APEX.Events; use APEX.Events;\nwith APEX.Health_Monitoring; use APEX.Health_Monitoring;\nwith APEX.Module_Schedules; use APEX.Module_Schedules;\n" +
					"with APEX.Partitions; use APEX.Partitions;\nwith APEX.Processes; use APEX.Processes;\nwith APEX.Queuing_Ports; use APEX.Queuing_Ports;\nwith APEX.Sampling_Ports;  use APEX.Sampling_Ports;\nwith APEX.Semaphores; use APEX.Semaphores;\n" +
					"with APEX.Timing; use APEX.Timing;\n" + headerGuard;
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
		String sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;

		try
		{
			this.language = PropertyUtils.getStringListValue(ne, "Source_Language");
		}
		catch (Exception e)
		{
			this.language.add("Ada");
		}


		List<String> sourceText =
				PropertyUtils.getStringListValue(ne, "Source_Text") ;
		if(sourceNameDest!=null)
			sourceNameDest.addOutput(sourceName) ;

		int count = 0;
		for(String s : sourceText)
		{
			if((s.endsWith(".h") && this.language.get(count).equalsIgnoreCase("C")) || (s.endsWith(".ads") && this.language.get(count).equalsIgnoreCase("ADA")))
				//if(s.endsWith(".h"))
			{
				if(_additionalHeaders.containsKey(sourceTextDest) == false)
				{
					Set<String> l = new HashSet<String>() ;
					l.add(s) ;
					_additionalHeaders.put(sourceTextDest, l) ;
				}
				else
				{
					_additionalHeaders.get(sourceTextDest).add(s) ;
				}


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
			 annexName = "restricted_"+annexName;
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

	 boolean processBehavioredImplementation(BehavioredImplementation object, BehavioredImplementation owner)
	 {
		 boolean foundRestrictedAnnex = false;
		 for(AnnexSubclause annex : object.getOwnedAnnexSubclauses())
		 {
			 if(annex.getName().equalsIgnoreCase(AadlBaToADAUnparserAction.ANNEX_NAME))
			 {
				 foundRestrictedAnnex = true;
				 processAnnexSubclause(annex, owner) ;
				 break;
			 }
		 }
		 if(!foundRestrictedAnnex && !object.getOwnedSubprogramCallSequences().isEmpty())
		 {
			 for(SubprogramCallSequence scs: object.getOwnedSubprogramCallSequences())
				 process(scs);
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
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Interfaces.C.float;") ;
			 _gtypesHeaderCode.decrementIndent();
			 if (!listeTypes.contains(id))
				 listeTypes.add(id);
			 break ;
		 }
		 case INTEGER :
		 {
			 if(id.equals("Base_Types_Unsigned_8"))
			 {
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is APEX_Integer;") ;
				 _gtypesHeaderCode.decrementIndent();
				 if (!listeTypes.contains(id))
					 listeTypes.add(id);
				 break ;	 
			 }
			 else
			 {
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is System.Address;") ;
				 _gtypesHeaderCode.decrementIndent();
				 if (!listeTypes.contains(id))
					 listeTypes.add(id);
				 break ;
			 }
		 }
		 case STRING :
		 {
			 _gtypesHeaderCode.incrementIndent();
			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is Interfaces.C.string;") ;
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
			 //_gtypesHeaderCode.incrementIndent() ;
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

			 _gtypesHeaderCode.addOutputNewline("subtype " + id + " is record") ;
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
			 //_gtypesHeaderCode.addOutputNewline("}" + id + ";") ;
			 _gtypesHeaderCode.addOutputNewline("end case;") ;
			 break ;
		 }
		 case ARRAY :
		 {
			 //_gtypesHeaderCode.addOutput("typedef ") ;
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
				 _gtypesHeaderCode.incrementIndent();
				 _gtypesHeaderCode.addOutput("subtype ") ;
				 _gtypesHeaderCode.addOutput(id + " is " + object.getName()) ;

				 //         resolveExistingCodeDependencies(object, _gtypesHeaderCode,
				 //                                         _gtypesHeaderCode) ;
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
/*				 if (!GeneratorUtils.getInitialValue(object).isEmpty())
				 {
					 String chaine = GeneratorUtils.getInitialValue(object);
					 if (chaine.contains(" = sizeof("))
					 {
						 chaine = chaine.substring(10);
						 chaine = chaine.replace(")", "");
					 }
					 unparser.addOutput(" := " + chaine + "'Size") ;
				 }
*/				 unparser.addOutputNewline(";") ;

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
				 buildDataAccessMapping(object) ;

				 processEList(object.getOwnedThreadSubcomponents()) ;

				 _deploymentHeaderCode.incrementIndent();
				 _deploymentHeaderCode.addOutput(" procedure Deployment;");
				 
				 _activityHeaderCode.addOutputNewline("procedure Last_Chance_Handler " +
					 		"(Source_Location :System.Address; Line : Integer);");
				 String gnat_handler = "__gnat_last_chance_handler";
				 _activityHeaderCode.addOutputNewline("pragma Export (C, Last_Chance_Handler,\""+gnat_handler+"\");");
				
				 
				 _currentImplUnparser = _deploymentImplCode;
				 _deploymentImplCode.addOutputNewline("");
				 _deploymentImplCode.incrementIndent();
				

				 for(DataSubcomponent ds: object.getOwnedDataSubcomponents())
				 {
					 if(false == _dataAccessMapping.containsValue(ds.getName()))
					 {
						 _deploymentImplCode.addOutput(ds.getName() +" : ") ;
						 processDataSubcomponentType(ds.getDataSubcomponentType(), _deploymentImplCode, _deploymentHeaderCode);
						 _deploymentImplCode.addOutputNewline(";") ;
					 }
					 process(ds.getDataSubcomponentType());
				 }
				 
				 
				 // *** Generate deployment.adb ***
				 if(false == _dataAccessMapping.isEmpty())
				 {
					 List<String> treatedDeclarations = new ArrayList<String>();
					 for(DataAccess d : _dataAccessMapping.keySet())
					 {
						 if(treatedDeclarations.contains(_dataAccessMapping.get(d)))
						 {
							 continue;
						 }
						 else
						 {
							 DataSubcomponentType dst = d.getDataFeatureClassifier();
							 String declarationID = _dataAccessMapping.get(d);
							 _deploymentImplCode.addOutput(declarationID + " : ") ;
							 processDataSubcomponentType(dst, _deploymentImplCode, _deploymentHeaderCode);
							 _deploymentImplCode.addOutputNewline(";") ;
							 treatedDeclarations.add(declarationID);
						 }
					 }
				 }
				 _deploymentImplCode.decrementIndent();

				 _gtypesImplCode.incrementIndent();
				 _gtypesImplCode.addOutputNewline("procedure Gtypes is");
				 _gtypesImplCode.addOutputNewline("begin");
				 _gtypesImplCode.incrementIndent();
				 _gtypesImplCode.addOutputNewline("null;");
				 _gtypesImplCode.decrementIndent();	        
				 _gtypesImplCode.addOutput("end Gtypes;");
				 _gtypesHeaderCode.addOutput("procedure Gtypes;");
				 
				 _activityImplCode.addOutput("procedure Last_Chance_Handler");
				 _activityImplCode.addOutputNewline(" (Source_Location : System.Address; Line : Integer) is");
				 _activityImplCode.addOutputNewline(" pragma Unreferenced (Source_Location, Line);");
				 _activityImplCode.addOutputNewline("begin");
				 _activityImplCode.addOutputNewline("loop");
				 _activityImplCode.addOutputNewline("null;");
				 _activityImplCode.addOutputNewline("end loop;");
				 _activityImplCode.addOutputNewline("end Last_Chance_Handler;");

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
				 int taille =0;
				 {
					 String aide = GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName());
					 int i=0;
					 if (!activityProcedures.contains(aide))
					 {   i++;
						 activityProcedures.add(aide);
					 }
					 
					 taille = activityProcedures.size()-1;
				 }

				 for(DataSubcomponent d : object.getOwnedDataSubcomponents())
				 {
					 process(d) ;
				 }


				 _currentImplUnparser.addOutputNewline("procedure " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + "_Job is") ;
				 _currentImplUnparser.addOutputNewline("begin") ;

				 //testSma

				 
				 _currentImplUnparser.addOutputNewline("loop") ;
				 _currentImplUnparser.incrementIndent() ;

				 if(GeneratorUtils.getInitialValue(object).isEmpty())
				 {
					 String chaine = GeneratorUtils.getInitialValue(object);
					 if (chaine.contains(" = sizeof("))
					 {
						 chaine = chaine.substring(10);
						 chaine = chaine.replace(")", "");
					 }
				
					 
				 }
				 
				 //not complete
				 boolean b = false;

				 for(DataSubcomponent ds: object.getOwnedDataSubcomponents())
				 {
					b = ds.getName().endsWith("Length");
					 if(b==true)
    				 _activityImplCode.addOutputNewline(activityProcedures.get(taille).toString()+"_"+ds.getName()+" := "+GeneratorUtils.getInitialValue(object)+"System.Address'Size;");
				 }
				 
			//	 boolean b=object.getOwnedDataSubcomponents().get(0).getName().endsWith("Length");
			 
					 taille--;
			 
				processBehavioredImplementation(object);
				 
				 _activityImplCode.decrementIndent() ;
				 _activityImplCode.addOutputNewline("end loop;") ;
				 _activityImplCode.decrementIndent() ;
				 _activityImplCode.addOutputNewline("end " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + "_Job;") ;
				 _activityImplCode.addOutputNewline("");

				 _activityHeaderCode.addOutputNewline("procedure " + GenerationUtilsADA
						 .getGenerationADAIdentifier(object.getQualifiedName()) + "_Job;") ;
				 _activityHeaderCode.addOutputNewline("pragma Export (C,"+GenerationUtilsADA
						 .getGenerationADAIdentifier(object.qualifiedName()) + 
						 "_Job,\""+GenerationUtilsADA.getGenerationADAIdentifier(object.qualifiedName())+"_Job\");");
				 _activityHeaderCode.addOutputNewline("");

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

				 String sourceName=""; 
					try {
						sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("namesource : "+sourceName);
//				 _subprogramHeaderCode.incrementIndent();
//				 _subprogramImplCode.incrementIndent();
				 _subprogramHeaderCode.addOutputNewline(" ");
				 				 
				 _subprogramHeaderCode.addOutput("procedure ");
				 _subprogramHeaderCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getName())+"(");

				 ////
				 boolean first = true;
				 for(Feature f: orderedFeatureList)
				 {
					 if(f instanceof Parameter)
					 {
						 Parameter p = (Parameter) f ;
						 if(p==returnParameter)
							 continue;
						 if(first==false)
						 {
							 _subprogramHeaderCode.addOutput(", ") ;
						 }

						 _subprogramHeaderCode.addOutput(" "+p.getName());

						 if (Aadl2Utils.isInOutParameter(p))
						 {
							 _subprogramHeaderCode.addOutput(" : in out ") ;
						 }
						 else if (Aadl2Utils.isOutParameter(p))
						 {
							 _subprogramHeaderCode.addOutput(" : out ") ;
						 }
						 else
						 {
							 _subprogramHeaderCode.addOutput(" : in ") ;
						 }

						 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
						 first=false;

						 process(p.getDataFeatureClassifier());
					 }
					 else if(f instanceof DataAccess)
					 {
						 DataAccess da = (DataAccess) f ;
						 if(first==false)
						 {
							 _subprogramHeaderCode.addOutput(", ") ;
						 }

						 if(da.getKind().equals(AccessType.REQUIRES))
						 {
							 _subprogramHeaderCode.addOutput(" "+da.getName());

							 if (Aadl2Utils.isReadWriteDataAccess(da))
							 {
								 _subprogramHeaderCode.addOutput(" : in out ") ;
							 }
							 else if (Aadl2Utils.isWriteOnlyDataAccess(da))
							 {
								 _subprogramHeaderCode.addOutput(" : out ") ;
							 }
							 else
							 {
								 _subprogramHeaderCode.addOutput(" : in ") ;
							 }  			  
						 }

						 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
						 first=false;

						 process(da.getDataFeatureClassifier());
					 }
				 }

				 /////
     			 _subprogramHeaderCode.addOutputNewline(");");
				 _subprogramHeaderCode.addOutput("pragma Import (C, "+GenerationUtilsADA.getGenerationADAIdentifier(object.getName())+","+"\""+sourceName+"\");");

				 
				 _subprogramHeaderCode.addOutputNewline("");

				 if(!isReturnParam)
				 {   
					 
					 _subprogramImplCode.addOutput  ("procedure ");
					 _subprogramImplCode.decrementIndent();
					 
					 _subprogramHeaderCode.addOutput("procedure ");
					 _subprogramHeaderCode.decrementIndent();

				 }

				 else
				 {
					 _subprogramImplCode.addOutput("function ");
					 _subprogramHeaderCode.addOutput("function ");
						
				 }

				 _subprogramImplCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())+"(");
				 _subprogramHeaderCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName())+"(");
				 

				 //_subprogramImplCode.addOutput(" (");
				 //_subprogramHeaderCode.addOutput(" (");

				 first = true;
				 for(Feature f: orderedFeatureList)
				 {
					 if(f instanceof Parameter)
					 {
						 Parameter p = (Parameter) f ;
						 if(p==returnParameter)
							 continue;
						 if(first==false)
						 {
							 _subprogramImplCode.addOutput(", ") ;
							 _subprogramHeaderCode.addOutput(", ") ;
						 }

						 _subprogramImplCode.addOutput(" "+p.getName());
						 _subprogramHeaderCode.addOutput(" "+p.getName());

						 if (Aadl2Utils.isInOutParameter(p))
						 {
							 _subprogramImplCode.addOutput(" : in out ") ;
							 _subprogramHeaderCode.addOutput(" : in out ") ;
						 }
						 else if (Aadl2Utils.isOutParameter(p))
						 {
							 _subprogramImplCode.addOutput(" : out ") ;
							 _subprogramHeaderCode.addOutput(" : out ") ;
						 }
						 else
						 {
							 _subprogramImplCode.addOutput(" : in ") ;
							 _subprogramHeaderCode.addOutput(" : in ") ;
						 }

						 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramImplCode, _subprogramImplCode);
						 processDataSubcomponentType(object, p.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
						 first=false;

						 process(p.getDataFeatureClassifier());
					 }
					 else if(f instanceof DataAccess)
					 {
						 DataAccess da = (DataAccess) f ;
						 if(first==false)
						 {
							 _subprogramImplCode.addOutput(", ") ;
							 _subprogramHeaderCode.addOutput(", ") ;
						 }

						 if(da.getKind().equals(AccessType.REQUIRES))
						 {
							 _subprogramImplCode.addOutput(" "+da.getName());
							 _subprogramHeaderCode.addOutput(" "+da.getName());

							 if (Aadl2Utils.isReadWriteDataAccess(da))
							 {
								 _subprogramImplCode.addOutput(" : in out ") ;
								 _subprogramHeaderCode.addOutput(" : in out ") ;
							 }
							 else if (Aadl2Utils.isWriteOnlyDataAccess(da))
							 {
								 _subprogramImplCode.addOutput(" : out ") ;
								 _subprogramHeaderCode.addOutput(" : out ") ;
							 }
							 else
							 {
								 _subprogramImplCode.addOutput(" : in ") ;
								 _subprogramHeaderCode.addOutput(" : in ") ;
							 }  			  
						 }

						 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramImplCode, _currentImplUnparser);
						 processDataSubcomponentType(object, da.getDataFeatureClassifier(), _subprogramHeaderCode, _subprogramHeaderCode);
						 first=false;

						 process(da.getDataFeatureClassifier());
					 }
				 }


				 if(!isReturnParam)
				 {
					 _subprogramImplCode.addOutputNewline(") is");
					 _subprogramHeaderCode.addOutputNewline(");");
				 }
				 else
				 {
					 _subprogramImplCode.addOutputNewline(") return LE_TYPE is");
				 }

				 
				 _subprogramHeaderCode.addOutput("");		
                
				 _subprogramImplCode.addOutputNewline("begin");
				 _subprogramImplCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(object.getName())+" (");
				 
				 /////
				 for(Feature f: orderedFeatureList)
				 {
					 if(f instanceof Parameter)
					 {
						 Parameter p = (Parameter) f ;
						 if(p==returnParameter)
							 continue;

						 _subprogramImplCode.addOutput(p.getName());						
					 }
					 else if(f instanceof DataAccess)
					 {
						 DataAccess da = (DataAccess) f ;

						 if(da.getKind().equals(AccessType.REQUIRES))
						 {
							 _subprogramImplCode.addOutput(da.getName());
						 }

					 }
				 }

				 /////
				 _subprogramImplCode.addOutputNewline(");");				 
				 _subprogramImplCode.incrementIndent();
				 return null;
			 }

			 @Override
			 public String caseSubprogramImplementation(SubprogramImplementation object)
			 {
				 if(_processedTypes.contains(object.getQualifiedName()))
				 {
					 return DONE ;
				 }
				 _processedTypes.add(object.getQualifiedName());

				 try {
					 resolveExistingCodeDependencies(object, null, _subprogramHeaderCode);
				 } catch (Exception e1) {
					 caseSubprogramClassifier(object);

					 for(DataSubcomponent d : object.getOwnedDataSubcomponents())
					 {
						 process(d) ;
					 }

					 processBehavioredImplementation(object) ;
					 _subprogramImplCode.decrementIndent();
					 _subprogramImplCode.addOutputNewline("end " + GenerationUtilsADA.getGenerationADAIdentifier(object.getQualifiedName()) + ";");

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
								 _currentImplUnparser.addOutput(" = ");
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
	    					  }*/

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
					 _currentImplUnparser.addOutput(ce.getName());
				 }
			 }

			 @Override
			 public String caseThreadSubcomponent(ThreadSubcomponent object)
			 {
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
				  cpt++;
				  _currentImplUnparser.addOutput("") ;

				  String dataSubprogramName = null ;
		
				  if(_dataAccessMapping != null)
				  {   
					  dataSubprogramName = _dataAccessMapping.get(object) ;
				  }
				  
				  if(dataSubprogramName != null && cpt ==1)
				  {					  
					  _currentImplUnparser.addOutput(dataSubprogramName);
				  }
				  if(dataSubprogramName != null && cpt >1)
				  {					  
					  _currentImplUnparser.addOutput(dataSubprogramName+cpt);
				  }

				  /*			  else
				  {
					  _currentImplUnparser.addOutput(GenerationUtilsADA
							  .getGenerationADAIdentifier(object.getQualifiedName())) ;
				  }
				  */
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
		NamedElement ne;

}
