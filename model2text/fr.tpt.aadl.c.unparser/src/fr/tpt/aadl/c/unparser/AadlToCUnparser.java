package fr.tpt.aadl.c.unparser ;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.Collection ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.* ;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch ;
import org.osate.aadl2.util.Aadl2Switch ;
import org.osate.annexsupport.AnnexRegistry ;
import org.osate.annexsupport.AnnexUnparser ;
import org.osate.annexsupport.AnnexUnparserRegistry ;
import fr.tpt.aadl.toolsuite.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.util.properties.PropertyUtils ;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;
import fr.tpt.aadl.annex.behavior.names.DataModelProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.DimensionException ;
import fr.tpt.aadl.c.unparser.GenerationUtils ;
import fr.tpt.aadl.c.unparser.annex.behavior.AadlBaToCUnparser ;
import fr.tpt.aadl.c.unparser.annex.behavior.AadlBaToCUnparserAction ;

public class AadlToCUnparser extends AadlProcessingSwitch
{

  private final String TYPE_HEADER = "#ifndef __GENERATED_GTYPES_H__\n"
        + "#define __GENERATED_GTYPES_H__\n" ;

  private final String SUBPROGRAM_HEADER =
        "#ifndef __GENERATED_SUBPROGRAMS_H__\n"
              + "#define __GENERATED_SUBPROGRAMS_H__\n"
              + "#include \"gtypes.h\"\n" ;

  private final String ACTIVITY_HEADER = "#ifndef __GENERATED_ACTIVITY_H__\n"
        + "#define __GENERATED_ACTIVITY_H__\n" + "#include \"subprograms.h\"\n" ;

  private final String DEPLOYMENT_HEADER =
        "#ifndef __GENERATED_DEPLOYMENT_H__\n"
              + "#define __GENERATED_DEPLOYMENT_H__\n" ;

  // *************************************************************************
  // XXX Every static variables have to be reseted between partition files
  // generation => miss conception. This class has to be refactored.
  // *************************************************************************

  // POK's Additional features flags.
  private static boolean _consoleFound = false, _stdioFound = false,
        _stdlibFound = false ;

  // POK config stacks size.
  private static long _requiredStackSize = 0 ;

  // POK partition's main.c flags.
  private boolean _hasToAddBlackboardHeader = false,
        _hasToAddSamplingHeader = false ;

  private final static String THREAD_SUFFIX = "_Job" ;

  public AadlToCUnparser()
  {
    super() ;
    cMainFileCode = new AadlToCSwitchProcess(this) ;
    cMainFileCode.addOutputNewline("#include \"activity.h\"") ;
    cMainFileCode.addOutputNewline("#include \"deployment.h\"") ;
    // XXX Is there any condition for the generation of theses directives ?
    cMainFileCode.addOutputNewline("#include <arinc653/types.h>") ;
    cMainFileCode.addOutputNewline("#include <arinc653/process.h>") ;
    cMainFileCode.addOutputNewline("#include <arinc653/partition.h>") ;
    cDataTypeFileCode = new AadlToCSwitchProcess(this) ;
    cDataTypeFileCode.addOutputNewline("#include \"gtypes.h\"") ;
    cDataTypeHeaderFileCode = new AadlToCSwitchProcess(this) ;
    cSubprogramsFileCode = new AadlToCSwitchProcess(this) ;
    cSubprogramsFileCode.addOutputNewline("#include \"subprograms.h\"") ;
    cSubprogramsHeaderFileCode = new AadlToCSwitchProcess(this) ;
    cActivityFileCode = new AadlToCSwitchProcess(this) ;
    cActivityFileCode.addOutputNewline("#include \"activity.h\"") ;
    cActivityHeaderFileCode = new AadlToCSwitchProcess(this) ;
    cDeploymentHeaderFileCode = new AadlToCSwitchProcess(this) ;
    cDeploymentFileCode = new AadlToCSwitchProcess(this) ;
    cDeploymentFileCode.addOutputNewline("#include <arinc653/types.h>") ;
    cDeploymentFileCode.addOutputNewline("#include \"deployment.h\"\n") ;
  }

  protected AadlToCSwitchProcess cMainFileCode ;

  protected AadlToCSwitchProcess cDataTypeFileCode ;
  protected AadlToCSwitchProcess cDataTypeHeaderFileCode ;

  protected AadlToCSwitchProcess cSubprogramsFileCode ;
  protected AadlToCSwitchProcess cSubprogramsHeaderFileCode ;

  protected AadlToCSwitchProcess cActivityFileCode ;
  protected AadlToCSwitchProcess cActivityHeaderFileCode ;

  protected AadlToCSwitchProcess cDeploymentFileCode ;
  protected AadlToCSwitchProcess cDeploymentHeaderFileCode ;

  private AadlToCSwitchProcess currentCUnparser ;
  private AadlToCSwitchProcess currentHUnparser ;

  private static List<NamedElement> delayedDataDeclarations =
        new ArrayList<NamedElement>() ;

  private Map<AadlToCSwitchProcess, Set<String>> additionalHeaders =
        new HashMap<AadlToCSwitchProcess, Set<String>>() ;

  private List<NamedElement> processedTypes = new ArrayList<NamedElement>() ;
  
  private static Map<DataAccess, String> _blackboardNames ;

  public void saveGeneratedFilesContent(File targetDirectory)
  {
    currentHUnparser = cDataTypeHeaderFileCode ;

    for(NamedElement ne : delayedDataDeclarations)
    {
      getCTypeDeclarator(ne, false) ;
    }

    cDataTypeHeaderFileCode.addOutputNewline("\n#endif\n") ;
    cSubprogramsHeaderFileCode.addOutputNewline("\n#endif\n") ;
    cActivityHeaderFileCode.addOutputNewline("\n#endif\n") ;
    cDeploymentHeaderFileCode.addOutputNewline("\n#endif\n") ;

    try
    {
      FileWriter typesFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.c") ;
      String addTypeHeader_C = getAdditionalHeader(cDataTypeFileCode) ;
      saveFile(typesFile_C, addTypeHeader_C + cDataTypeFileCode.getOutput()) ;
      FileWriter typesFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.h") ;
      String addTypeHeader_H = getAdditionalHeader(cDataTypeHeaderFileCode) ;
      saveFile(typesFile_H, this.TYPE_HEADER + addTypeHeader_H +
                     cDataTypeHeaderFileCode.getOutput()) ;
      FileWriter subprogramsFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.c") ;
      String addSubprogramHeader_C = getAdditionalHeader(cSubprogramsFileCode) ;
      saveFile(subprogramsFile_C, addSubprogramHeader_C +
                     cSubprogramsFileCode.getOutput()) ;
      FileWriter subprogramsFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.h") ;
      String addSubprogramsHeader_H =
            getAdditionalHeader(cSubprogramsHeaderFileCode) ;
      saveFile(subprogramsFile_H, this.SUBPROGRAM_HEADER +
                     addSubprogramsHeader_H +
                     cSubprogramsHeaderFileCode.getOutput()) ;
      FileWriter activityFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/activity.c") ;
      String addActivityHeader_C = getAdditionalHeader(cActivityFileCode) ;
      saveFile(activityFile_C, addActivityHeader_C +
                     cActivityFileCode.getOutput()) ;
      FileWriter activityFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/activity.h") ;
      String addActivityHeader_H = getAdditionalHeader(cActivityHeaderFileCode) ;
      saveFile(activityFile_H, this.ACTIVITY_HEADER + addActivityHeader_H +
                     cActivityHeaderFileCode.getOutput()) ;
      FileWriter deploymentFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.c") ;
      String addDeploymentHeader_C = getAdditionalHeader(cDeploymentFileCode) ;
      saveFile(deploymentFile_C, addDeploymentHeader_C +
                     cDeploymentFileCode.getOutput()) ;
      FileWriter deploymentFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.h") ;
      String addDeploymentHeader_H =
            getAdditionalHeader(cDeploymentHeaderFileCode) ;
      saveFile(deploymentFile_H, this.DEPLOYMENT_HEADER + '\n' +
                     addDeploymentHeader_H +
                     cDeploymentHeaderFileCode.getOutput()) ;
      FileWriter mainFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/main.c") ;
      String addMainHeader_C = getAdditionalHeader(cMainFileCode) ;
      saveFile(mainFile_C, addMainHeader_C + cMainFileCode.getOutput()) ;
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
  }

  private String getAdditionalHeader(AadlToCSwitchProcess fileUnparser)
  {
    StringBuffer res = new StringBuffer("") ;

    if(additionalHeaders.containsKey(fileUnparser))
    {
      Set<String> additionalTypeHeaders = additionalHeaders.get(fileUnparser) ;

      for(String s : additionalTypeHeaders)
      {
        res.append("#include \"" + s + "\"\n") ;
      }
    }

    return res.toString() ;
  }

  private void saveFile(FileWriter file,
                        String content)
  {
    BufferedWriter output ;

    try
    {
      output = new BufferedWriter(file) ;
      output.write(content) ;
      output.close() ;
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
  }

  public String getDataTypeCodeContent()
  {
    return cDataTypeFileCode.getOutput() ;
  }

  public String getDataTypeHeaderContent()
  {
    return cDataTypeHeaderFileCode.getOutput() ;
  }

  public String getSubprogramsFileCodeContent()
  {
    return cSubprogramsFileCode.getOutput() ;
  }

  public String getSubprogramsHeaderContent()
  {
    return cSubprogramsHeaderFileCode.getOutput() ;
  }

  public String getActivityCodeContent()
  {
    return cActivityFileCode.getOutput() ;
  }

  public String getActivityHeaderContent()
  {
    return cActivityHeaderFileCode.getOutput() ;
  }

  public boolean resolveExistingCodeDependencies(NamedElement object,
                                                 AadlToCSwitchProcess sourceNameDest,
                                                 AadlToCSwitchProcess sourceTextDest)
        throws Exception
  {
    NamedElement ne = object ;
    String sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;
    List<String> sourceText =
          PropertyUtils.getStringListValue(ne, "Source_Text") ;
    sourceNameDest.addOutput(sourceName) ;

    for(String s : sourceText)
    {
      if(s.endsWith(".h"))
      {
        if(additionalHeaders.containsKey(sourceTextDest) == false)
        {
          Set<String> l = new HashSet<String>() ;
          l.add(s) ;
          additionalHeaders.put(sourceTextDest, l) ;
        }
        else
        {
          additionalHeaders.get(sourceTextDest).add(s) ;
        }

        return true ;
      }
    }

    return false ;
  }

  protected void getCTypeDeclarator(NamedElement object,
                                    boolean delayComplexTypes)
  {
    String id =
          GenerationUtils.getGenerationCIdentifier(object.getQualifiedName()) ;
    TypeHolder dataTypeHolder = null ;

    try
    {
      dataTypeHolder = AadlBaUtils.getTypeHolder(object) ;
    }
    catch(DimensionException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }

    EList<PropertyExpression> numberRepresentation =
          AadlBaGetProperties
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
      }
    }

    switch ( dataTypeHolder.dataRep )
    {
    // Simple types
      case BOOLEAN :
        currentHUnparser.addOutputNewline("typedef char " + id + ";") ;
        break ;
      case CHARACTER :
      {
        currentHUnparser.addOutput("typedef ") ;
        currentHUnparser.addOutputNewline(numberRepresentationValue + " char " +
              id + ";") ;
        break ;
      }
      case FIXED :
        break ;
      case FLOAT :
        currentHUnparser.addOutputNewline("typedef float " + id + ";") ;
        break ;
      case INTEGER :
      {
        currentHUnparser.addOutput("typedef ") ;
        currentHUnparser.addOutputNewline(numberRepresentationValue + " int " +
              id + ";") ;
        break ;
      }
      case STRING :
        currentHUnparser.addOutputNewline("typedef char * " + id + ";") ;
        break ;
      // Complex types
      case ENUM :
      {
        if(delayComplexTypes)
        {
          delayedDataDeclarations.add(object) ;
          break ;
        }

        currentHUnparser.addOutputNewline("typedef enum " + id + " {") ;
        currentHUnparser.incrementIndent() ;
        List<String> stringifiedRepresentation = new ArrayList<String>() ;
        EList<PropertyExpression> dataRepresentation =
              AadlBaGetProperties
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
              AadlBaGetProperties
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

                currentHUnparser.addOutputNewline(id + "_" +
                      enumString.getValue() + rep) ;
              }
            }
          }
        }

        currentHUnparser.decrementIndent() ;
        currentHUnparser.addOutputNewline("} " + id + ";") ;
        break ;
      }
      case STRUCT :
      {
        if(delayComplexTypes)
        {
          delayedDataDeclarations.add(object) ;
          break ;
        }

        currentHUnparser.addOutputNewline("typedef struct " + id + " {") ;
        currentHUnparser.incrementIndent() ;
        EList<PropertyExpression> elementNames =
              AadlBaGetProperties
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
              AadlBaGetProperties
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
                      GenerationUtils.getGenerationCIdentifier(cv
                            .getClassifier().getQualifiedName()) ;
                currentHUnparser.addOutputNewline(type +
                      " " +
                      stringifiedElementNames.get(lv.getOwnedListElements()
                            .indexOf(v)) + ";") ;
              }
            }
          }
        }

        currentHUnparser.decrementIndent() ;
        currentHUnparser.addOutputNewline("} " + id + ";") ;
        break ;
      }
      case UNION :
      {
        if(delayComplexTypes)
        {
          delayedDataDeclarations.add(object) ;
          break ;
        }

        currentHUnparser.addOutputNewline("typedef union " + id + " {") ;
        currentHUnparser.incrementIndent() ;
        EList<PropertyExpression> elementNames =
              AadlBaGetProperties
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
              AadlBaGetProperties
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
                      GenerationUtils.getGenerationCIdentifier(cv
                            .getClassifier().getQualifiedName()) ;
                currentHUnparser.addOutputNewline(type +
                      " " +
                      stringifiedElementNames.get(lv.getOwnedListElements()
                            .indexOf(v)) + ";") ;
              }
            }
          }
        }

        currentHUnparser.decrementIndent() ;
        currentHUnparser.addOutputNewline("}" + id + ";") ;
        break ;
      }
      case ARRAY :
      {
        currentHUnparser.addOutput("typedef ") ;
        EList<PropertyExpression> baseType =
              AadlBaGetProperties
                    .getPropertyExpression(dataTypeHolder.klass,
                                           DataModelProperties.BASE_TYPE) ;

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
                currentHUnparser.addOutput(GenerationUtils
                      .getGenerationCIdentifier(cv.getClassifier()
                            .getQualifiedName())) ;
              }
            }
          }
        }

        currentHUnparser.addOutput(" ") ;
        currentHUnparser.addOutput(id) ;
        EList<PropertyExpression> arrayDimensions =
              AadlBaGetProperties
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
                currentHUnparser.addOutput("[") ;
                IntegerLiteral dimension = (IntegerLiteral) v ;
                currentHUnparser.addOutput(Long.toString(dimension.getValue())) ;
                currentHUnparser.addOutput("]") ;
              }
            }
          }
        }

        currentHUnparser.addOutputNewline(";") ;
        break ;
      }
      case UNKNOWN :
      {
        try
        {
          currentHUnparser.addOutput("typedef ") ;
          resolveExistingCodeDependencies(object, cDataTypeHeaderFileCode,
                                          cDataTypeHeaderFileCode) ;
          currentHUnparser.addOutput(" ") ;
          currentHUnparser.addOutput(id) ;
          currentHUnparser.addOutputNewline(";") ;
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
        if(processedTypes.contains(object))
        {
          return DONE ;
        }

        processedTypes.add(object) ;
        currentHUnparser = cDataTypeHeaderFileCode ;
        cDataTypeHeaderFileCode.processComments(object) ;
        getCTypeDeclarator((NamedElement) object, true) ;
        return DONE ;
      }

      public String caseAadlPackage(AadlPackage object)
      {
        process(object.getOwnedPublicSection()) ;
        process(object.getOwnedPrivateSection()) ;
        return DONE ;
      }

      public String casePrivatePackageSection(PrivatePackageSection object)
      {
        return null ;
      }

      public String casePublicPackageSection(PublicPackageSection object)
      {
        processEList(object.getOwnedClassifiers()) ;
        return null ;
      }

      public String casePackageSection(PackageSection object)
      {
        return DONE ;
      }

      public String casePackageRename(PackageRename object)
      {
        return DONE ;
      }

      public String caseComponentTypeRename(ComponentTypeRename object)
      {
        return DONE ;
      }

      public String caseFeatureGroupTypeRename(FeatureGroupTypeRename object)
      {
        return DONE ;
      }

      /**
       * outputs the content of a component implementation It picks up
       * after the superclass case. It returns done as processing is
       * complete.
       */
      public String caseComponentImplementation(ComponentImplementation object)
      {
        return DONE ;
      }

      /**
       * Add the common part of component types
       */
      public String caseComponentType(ComponentType object)
      {
        return DONE ;
      }

      public String caseMode(Mode object)
      {
        return DONE ;
      }

      /**
       * unparse mode transitions
       */
      public String caseModeTransition(ModeTransition object)
      {
        return DONE ;
      }

      /**
       * Does the bulk of subcomponent declarations
       */
      public String caseSubcomponent(Subcomponent object)
      {
        return DONE ;
      }

      public String caseArrayDimension(ArrayDimension object)
      {
        return DONE ;
      }

      public String caseArraySize(ArraySize object)
      {
        return DONE ;
      }

      /**
       * unparses annex library
       *
       * @param al
       *            AnnexLibrary object
       */
      public String caseAnnexLibrary(AnnexLibrary al)
      {
        String annexName = al.getName() ;
        AnnexUnparser unparser =
              ServiceRegistryProvider.getServiceRegistry()
                    .getUnparser(annexName) ;

        if(unparser != null)
        {
          unparser.unparseAnnexLibrary(al, currentCUnparser.getIndent()) ;
        }

        return DONE ;
      }

      /**
       * unparses default annex library
       *
       * @param dal
       *            DefaultAnnexLibrary object
       */
      public String caseDefaultAnnexLibrary(DefaultAnnexLibrary dal)
      {
        String annexName = dal.getName() ;
        AnnexUnparser unparser =
              ServiceRegistryProvider.getServiceRegistry().getUnparser("*") ;

        if(unparser != null)
        {
        }

        return DONE ;
      }

      /**
       * unparses annex subclause
       *
       * @param as
       *            AnnexSubclause object
       */
      public String caseAnnexSubclause(AnnexSubclause as)
      {
        String annexName = "restricted_" + as.getName() ;
        AnnexUnparser unparser =
              ServiceRegistryProvider.getServiceRegistry()
                    .getUnparser(annexName) ;

        if(unparser != null)
        {
          
          if(unparser instanceof AadlBaToCUnparserAction)
          {
            ((AadlBaToCUnparserAction) unparser).
                           createUnparser(_blackboardNames) ; 
          }
          
          unparser.unparseAnnexSubclause(as, currentCUnparser.getIndent()) ;

          if(unparser instanceof AadlBaToCUnparserAction)
          {
            AadlBaToCUnparserAction baToCUnparserAction =
                  (AadlBaToCUnparserAction) unparser ;

            if(baToCUnparserAction.getUnparser() instanceof AadlBaToCUnparser)
            {
              AadlBaToCUnparser baToCUnparser =
                    (AadlBaToCUnparser) baToCUnparserAction.getUnparser() ;
              
              baToCUnparser.addIndent_C(currentCUnparser.getIndent()) ;
              baToCUnparser.addIndent_H(currentHUnparser.getIndent()) ;
              currentCUnparser.addOutput(baToCUnparser.getCContent()) ;
              currentHUnparser.addOutput(baToCUnparser.getHContent()) ;

              if(additionalHeaders.get(currentHUnparser) == null)
              {
                Set<String> t = new HashSet<String>() ;
                additionalHeaders.put(currentHUnparser, t) ;
              }

              additionalHeaders.get(currentHUnparser)
                    .addAll(baToCUnparser.getAdditionalHeaders()) ;
            }
          }
        }

        return DONE ;
      }

      /**
       * unparses defaultannex subclause
       *
       * @param das
       *            DefaultAnnexSubclause object
       */
      public String caseDefaultAnnexSubclause(DefaultAnnexSubclause das)
      {
        AnnexUnparserRegistry registry =
              (AnnexUnparserRegistry) AnnexRegistry
                    .getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID) ;
        String annexName = das.getName() ;
        AnnexUnparser unparser = registry.getAnnexUnparser("*") ;

        if(unparser != null)
        {
        }

        return DONE ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseBusImplementation(BusImplementation object)
      {
        return null ;
      }

      public String caseBusSubcomponent(BusSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseBusType(BusType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDataImplementation(DataImplementation object)
      {
        currentHUnparser = cDataTypeHeaderFileCode ;
        cDataTypeHeaderFileCode.processComments(object) ;
        getCTypeDeclarator((NamedElement) object, true) ;
        return null ;
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseDataSubcomponent(DataSubcomponent object)
      {
        AadlToCSwitchProcess unparser ;

        if(object.getContainingComponentImpl() instanceof DataImplementation)
        {
          unparser = currentHUnparser ;
        }
        else
        {
          unparser = currentCUnparser ;
        }

        unparser.processComments(object) ;
        DataSubcomponentType dst = object.getDataSubcomponentType() ;

        try
        {
          resolveExistingCodeDependencies(dst, unparser, currentHUnparser) ;
        }
        catch(Exception e)
        {
          unparser.addOutput(GenerationUtils.getGenerationCIdentifier(dst
                .getQualifiedName())) ;
        }

        unparser.addOutput(" ") ;
        unparser.addOutput(GenerationUtils.getGenerationCIdentifier(object
              .getQualifiedName())) ;
        unparser.addOutput(GenerationUtils.getInitialValue(object)) ;
        unparser.addOutputNewline(";") ;

        if(processedTypes.contains(object.getDataSubcomponentType()) == false)
        {
          process(object.getDataSubcomponentType()) ;
          processedTypes.add(object.getDataSubcomponentType()) ;
        }

        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDeviceImplementation(DeviceImplementation object)
      {
        return null ;
      }

      public String caseDeviceSubcomponent(DeviceSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDeviceType(DeviceType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemoryImplementation(MemoryImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemorySubcomponent(MemorySubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemoryType(MemoryType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessImplementation(ProcessImplementation object)
      {
        StringBuilder sb = new StringBuilder() ;
        
        // And set some static flags.
        // DEBUG
        _blackboardNames = buildBlackboardMap(object) ;
        
        processEList(object.getOwnedThreadSubcomponents()) ;
        EList<ThreadSubcomponent> lthreads =
              object.getOwnedThreadSubcomponents() ;
        // *** Generate deployment.h ***
        generateDeploymentHeader(object) ;
        
        // XXX performance to be improved.
        // Removes duplicates.
        Set<String> blackboardNames = new HashSet<String>(_blackboardNames.values());

        // *** Generate main.c ***

        // Adds the header files.
        if(true == _hasToAddBlackboardHeader)
        {
          cMainFileCode.addOutputNewline("#include <arinc653/blackboard.h>") ;
        }

        if(true == _hasToAddSamplingHeader)
        {
          cMainFileCode.addOutputNewline("#include <arinc653/sampling.h>") ;
        }

        //Generate global variables
        cMainFileCode.addOutputNewline(GenerationUtils.generateSectionMark()) ;
        cMainFileCode.addOutputNewline(GenerationUtils
              .generateSectionTitle("GLOBAL VARIABLES")) ;

        if(false == lthreads.isEmpty())
        {
          cMainFileCode
                .addOutputNewline("PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];") ;
        }

        if(false == blackboardNames.isEmpty())
        {
          // Generate blackboards names array.
          sb.append("char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {") ;

          for(String name : blackboardNames)
          {
            sb.append('\"') ;
            sb.append(name) ;
            sb.append('\"') ;
          }

          sb.append("};") ;
          cMainFileCode.addOutputNewline(sb.toString()) ;
          // Generate external variable (declared in deployment.c).
          sb.setLength(0) ; // Reset string builder.

          for(String name : blackboardNames)
          {
            sb.append("extern BLACKBOARD_ID_TYPE ") ;
            sb.append(GenerationUtils.generateBlackboardId(name)) ;
            sb.append(";\n") ;
          }

          cMainFileCode.addOutput(sb.toString()) ;
          sb.setLength(0) ; // Reset string builder.
        }

        cMainFileCode.addOutputNewline(GenerationUtils.generateSectionMark()) ;
        cMainFileCode.addOutputNewline(GenerationUtils
              .generateSectionTitle("MAIN")) ;
        cMainFileCode.addOutputNewline("int main ()") ;
        cMainFileCode.addOutputNewline("{") ;
        cMainFileCode.addOutputNewline("  PROCESS_ATTRIBUTE_TYPE tattr;") ;
        cMainFileCode.addOutputNewline("  RETURN_CODE_TYPE ret;") ;
        // For each declared thread
        // Zero stands for ARINC's IDL thread.
        int threadIndex = 1 ;

        for(ThreadSubcomponent t : lthreads)
        {
          ThreadImplementation timpl =
                (ThreadImplementation) t.getComponentImplementation() ;
          cMainFileCode.addOutput("  tattr.ENTRY_POINT = ") ;
          cMainFileCode.addOutput(GenerationUtils
                .getGenerationCIdentifier(timpl.getQualifiedName())) ;
          cMainFileCode.addOutputNewline(THREAD_SUFFIX + ';') ;
          String period = null ;
          String deadline = null ;
          String timeCapacity = null ;

          try
          {
            long value = PropertyUtils.getIntValue(t, "Period") ;
            period = Long.toString(value) ;
          }
          catch(Exception e)
          {
            period = null ;
          }

          // If period is not set, don't generate.
          if(period != null)
          {
            cMainFileCode.addOutput("  tattr.PERIOD = ") ;
            cMainFileCode.addOutputNewline(period + ';') ;
          }

          try
          {
            long value = PropertyUtils.getIntValue(t, "Deadline") ;
            deadline = Long.toString(value) ;
          }
          catch(Exception e)
          {
            // If deadline is not set, use period instead.
            deadline = period ;
          }

          // If period and deadline are not set , don't generate.
          if(deadline != null)
          {
            cMainFileCode.addOutput("  tattr.DEADLINE = ") ;
            cMainFileCode.addOutputNewline(deadline + ';') ;
          }

          try
          {
            float value =
                  PropertyUtils.getMaxRangeValue(t, "Compute_Execution_Time") ;
            timeCapacity = Integer.toString((int) value) ;
          }
          catch(Exception e)
          {
            timeCapacity = null ;
          }

          // If compute execution time is not set, don't generate.
          if(timeCapacity != null)
          {
            cMainFileCode.addOutput("  tattr.TIME_CAPACITY = ") ;
            cMainFileCode.addOutputNewline(timeCapacity + ';') ;
          }

          cMainFileCode
                .addOutput("  CREATE_PROCESS (&(tattr), &(arinc_threads[") ;
          cMainFileCode.addOutput(Integer.toString(threadIndex)) ;
          cMainFileCode.addOutputNewline("]), &(ret));") ;
          threadIndex++ ;
        }

        // For each blackboard
        for(String name : blackboardNames)
        {
          cMainFileCode.addOutput("  CREATE_BLACKBOARD (\"") ;
          cMainFileCode.addOutput(name) ;
          cMainFileCode.addOutput("\", sizeof (int), &(") ;
          cMainFileCode.addOutput(GenerationUtils.generateBlackboardId(name));
          cMainFileCode.addOutputNewline("), &(ret));") ;
        }

        cMainFileCode
              .addOutputNewline("  SET_PARTITION_MODE (NORMAL, &(ret));") ;
        cMainFileCode.addOutputNewline("  return (0);") ;
        cMainFileCode.addOutputNewline("}") ;
        cMainFileCode.addOutputNewline(GenerationUtils.generateSectionMark()) ;
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorImplementation(VirtualProcessorImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorSubcomponent(VirtualProcessorSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorType(VirtualProcessorType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusImplementation(VirtualBusImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusSubcomponent(VirtualBusSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusType(VirtualBusType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractImplementation(AbstractImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractSubcomponent(AbstractSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractType(AbstractType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorImplementation(ProcessorImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorSubcomponent(ProcessorSubcomponent object)
      {
        generateDeploymentHeader(object) ;
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorType(ProcessorType object)
      {
        return null ;
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseProcessSubcomponent(ProcessSubcomponent object)
      {
        process(object.getComponentImplementation()) ;
        return DONE ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessType(ProcessType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSystemImplementation(SystemImplementation object)
      {
        return null ;
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseSystemSubcomponent(SystemSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSystemType(SystemType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupImplementation(ThreadGroupImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupSubcomponent(ThreadGroupSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupType(ThreadGroupType object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadImplementation(ThreadImplementation object)
      {
        process(object.getType()) ;
        cActivityFileCode.addOutput("void* ") ;
        cActivityFileCode.addOutput(GenerationUtils
              .getGenerationCIdentifier(object.getQualifiedName())) ;
        cActivityFileCode.addOutputNewline(THREAD_SUFFIX + "()") ;
        cActivityFileCode.addOutputNewline("{") ;
        cActivityFileCode.incrementIndent() ;

        for(DataSubcomponent d : object.getOwnedDataSubcomponents())
        {
          process(d) ;
        }

        currentCUnparser = cActivityFileCode ;
        currentHUnparser = cActivityHeaderFileCode ;
        
        for(AnnexSubclause annex : object.getOwnedAnnexSubclauses())
        {
          process(annex) ;
        }

        cActivityFileCode.decrementIndent() ;
        cActivityFileCode.addOutputNewline("}") ;
        
        cActivityHeaderFileCode.addOutput("void*  ") ;
        cActivityHeaderFileCode.addOutput(GenerationUtils
              .getGenerationCIdentifier(object.getQualifiedName())) ;
        cActivityHeaderFileCode.addOutputNewline(THREAD_SUFFIX + "();\n") ;
        
        return null ;
      }

      /**
       * Fills in identifier & category name lets super class fill in the
       * rest.
       */
      public String caseThreadSubcomponent(ThreadSubcomponent object)
      {
        process(object.getComponentImplementation()) ;
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadType(ThreadType object)
      {
        if(processedTypes.contains(object))
        {
          return null ;
        }

        processedTypes.add(object) ;
        currentHUnparser = cActivityHeaderFileCode ;
        currentCUnparser = cActivityFileCode ;

        for(DataAccess d : object.getOwnedDataAccesses())
        {
          if(d.getKind().equals(AccessType.REQUIRED))
          {
            process(d) ;
          }
        }

        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramImplementation(SubprogramImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramType(SubprogramType object)
      {
        return null ;
      }

      public String caseSubprogramSubcomponent(SubprogramSubcomponent object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramGroupImplementation(SubprogramGroupImplementation object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramGroupType(SubprogramGroupType object)
      {
        return null ;
      }

      public String caseSubprogramGroupSubcomponent(SubprogramGroupSubcomponent object)
      {
        return null ;
      }

      /**
       * Prototypes
       */
      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramPrototype(SubprogramPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSystemPrototype(SystemPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseAbstractPrototype(AbstractPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessPrototype(ProcessPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadGroupPrototype(ThreadGroupPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseThreadPrototype(ThreadPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseProcessorPrototype(ProcessorPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseMemoryPrototype(MemoryPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseBusPrototype(BusPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseDevicePrototype(DevicePrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualProcessorPrototype(VirtualProcessorPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseVirtualBusPrototype(VirtualBusPrototype object)
      {
        return null ;
      }

      /**
       * Fills in category name lets super class fill in the rest.
       */
      public String caseSubprogramGroupPrototype(SubprogramGroupPrototype object)
      {
        return null ;
      }

      /**
       * Does the bulk of prototype declarations
       */
      public String caseComponentPrototype(ComponentPrototype object)
      {
        return DONE ;
      }

      public String caseFeatureGroupPrototype(FeatureGroupPrototype object)
      {
        return DONE ;
      }

      /**
       * Does the bulk of feature prototype declarations
       */
      public String caseFeaturePrototype(FeaturePrototype object)
      {
        return DONE ;
      }

      /**
       * Does the  prototype binding
       */
      public String caseComponentPrototypeBinding(ComponentPrototypeBinding object)
      {
        return DONE ;
      }

      /**
       * Does the  prototype actual
       */
      public String caseComponentPrototypeActual(ComponentPrototypeActual object)
      {
        return DONE ;
      }

      /**
       * Does the  feature group prototype binding
       */
      public String caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding object)
      {
        return DONE ;
      }

      public String caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual object)
      {
        FeatureType sct = object.getFeatureType() ;
        return DONE ;
      }

      /**
       * Does the  feature prototype binding
       */
      public String caseFeaturePrototypeBinding(FeaturePrototypeBinding object)
      {
        return DONE ;
      }

      public String casePortSpecification(PortSpecification object)
      {
        return DONE ;
      }

      public String caseAccessSpecification(AccessSpecification object)
      {
        return DONE ;
      }

      public String caseFeaturePrototypeReference(FeaturePrototypeReference object)
      {
        return DONE ;
      }

      /**
       * call sequence processing.
       */
      public String caseSubprogramCallSequence(SubprogramCallSequence object)
      {
        return DONE ;
      }

      /**
       * subprogram call processing.
       */
      public String caseSubprogramCall(SubprogramCall object)
      {
        return DONE ;
      }

      public String caseProcessorCall(ProcessorCall object)
      {
        return DONE ;
      }

      public String casePortConnection(PortConnection object)
      {
        return DONE ;
      }

      public String caseFeatureGroupConnection(FeatureGroupConnection object)
      {
        return DONE ;
      }

      public String caseParameterConnection(ParameterConnection object)
      {
        return DONE ;
      }

      public String caseAccessConnection(AccessConnection object)
      {
        return DONE ;
      }

      /**
       * bus access
       */
      public String caseBusAccess(BusAccess object)
      {
        return DONE ;
      }

      /**
       *  subprogram access
       */
      public String caseSubprogramAccess(SubprogramAccess object)
      {
        return DONE ;
      }

      /**
       *  subprogram group access
       */
      public String caseSubprogramGroupAccess(SubprogramGroupAccess object)
      {
        return DONE ;
      }

      /**
       * data access
       */
      public String caseDataAccess(DataAccess object)
      {
        currentCUnparser.addOutput("extern ") ;
        
        String blackboardName = _blackboardNames.get(object) ;
        
        if(blackboardName != null)
        {
          currentCUnparser.addOutput(GenerationUtils.generateBlackboardId(
                                                             blackboardName));
        }
        else
        {
          try
          {
            resolveExistingCodeDependencies(object.getDataFeatureClassifier(),
                                           currentCUnparser, currentHUnparser) ;
          }
          catch(Exception e)
          {
            currentCUnparser.addOutput(GenerationUtils
                  .getGenerationCIdentifier(object.getDataFeatureClassifier()
                        .getQualifiedName())) ;
          }
          
          currentCUnparser.addOutput(" ") ;
          currentCUnparser.addOutput(GenerationUtils
                .getGenerationCIdentifier(object.getQualifiedName())) ;
        }

        currentCUnparser.addOutputNewline(";") ;
        return DONE ;
      }

      public String caseDataPort(DataPort object)
      {
        return null ;
      }

      /**
       * Does the name and category. Port handles the rest
       */
      public String caseEventDataPort(EventDataPort object)
      {
        return null ;
      }

      /**
       * Does the name and category. Port handles the rest
       */
      public String caseEventPort(EventPort object)
      {
        return null ;
      }

      /**
       * Does the common part of port
       */
      public String casePort(Port object)
      {
        return DONE ;
      }

      /**
       * Does the parameter
       */
      public String caseParameter(Parameter object)
      {
        return DONE ;
      }

      /**
       * Does the port group
       */
      public String caseFeatureGroup(FeatureGroup object)
      {
        return DONE ;
      }

      /**
       * Add the common part of component types
       */
      public String caseFeatureGroupType(FeatureGroupType object)
      {
        return DONE ;
      }

      /**
       * Handles all provides, requires, and parameters
       */
      public String caseAbstractFeature(AbstractFeature object)
      {
        return DONE ;
      }

      /**
       * Handles flow  spec
       */
      public String caseFlowSpecification(FlowSpecification object)
      {
        return DONE ;
      }

      /**
       * Handles flow implementation
       */
      public String caseFlowImplementation(FlowImplementation object)
      {
        return DONE ;
      }

      /**
       * Handles flow ETEF
       */
      public String caseEndToEndFlow(EndToEndFlow object)
      {
        return DONE ;
      }

      public String casePropertySet(PropertySet object)
      {
        return DONE ;
      }

      public String caseAadlBoolean(AadlBoolean object)
      {
        return DONE ;
      }

      public String caseAadlString(AadlString object)
      {
        return DONE ;
      }

      public String caseAadlInteger(AadlInteger object)
      {
        return DONE ;
      }

      public String caseAadlReal(AadlReal object)
      {
        return DONE ;
      }

      public String caseEnumerationType(EnumerationType object)
      {
        return DONE ;
      }

      public String caseUnitsType(UnitsType object)
      {
        return DONE ;
      }

      public String caseEnumerationLiteral(EnumerationLiteral object)
      {
        return DONE ;
      }

      public String caseUnitLiteral(UnitLiteral object)
      {
        return DONE ;
      }

      public String caseReferenceType(ReferenceType object)
      {
        return DONE ;
      }

      public String caseReferenceValue(ReferenceValue object)
      {
        return DONE ;
      }

      public String caseClassifierType(ClassifierType object)
      {
        return DONE ;
      }

      public String caseClassifierValue(ClassifierValue object)
      {
        return DONE ;
      }

      public String caseMetaclassReference(MetaclassReference object)
      {
        return DONE ;
      }

      public String caseModalPropertyValue(ModalPropertyValue object)
      {
        return DONE ;
      }

      public String casePropertyAssociation(PropertyAssociation object)
      {
        return DONE ;
      }

      public String caseContainedNamedElement(ContainedNamedElement object)
      {
        return DONE ;
      }

      public String caseContainmentPathElement(ContainmentPathElement object)
      {
        return DONE ;
      }

      public String casePropertyConstant(PropertyConstant object)
      {
        return DONE ;
      }

      public String caseProperty(Property object)
      {
        return DONE ;
      }

      public String caseBasicProperty(BasicProperty object)
      {
        return DONE ;
      }

      public String caseListType(ListType object)
      {
        return DONE ;
      }

      public String caseListValue(ListValue object)
      {
        return DONE ;
      }

      public String caseOperation(Operation object)
      {
        return DONE ;
      }

      public String caseBooleanLiteral(BooleanLiteral object)
      {
        return DONE ;
      }

      public String caseStringLiteral(StringLiteral object)
      {
        return DONE ;
      }

      public String caseNumberValue(NumberValue object)
      {
        return DONE ;
      }

      public String caseNamedValue(NamedValue object)
      {
        return DONE ;
      }

      public String caseRangeType(RangeType object)
      {
        return DONE ;
      }

      public String caseRangeValue(RangeValue object)
      {
        return DONE ;
      }

      public String caseArrayRange(ArrayRange object)
      {
        if(object == null)
        {
          return DONE ;
        }

        return DONE ;
      }

      public String caseNumericRange(NumericRange object)
      {
        return DONE ;
      }

      public String caseRecordType(RecordType object)
      {
        return DONE ;
      }

      public String caseRecordValue(RecordValue object)
      {
        return DONE ;
      }

      public String caseBasicPropertyAssociation(BasicPropertyAssociation object)
      {
        return DONE ;
      }
    } ;
  }

  public void doProcess(Element element)
  {
    AadlToCSwitchProcess.process(element) ;
  }

  public void saveGeneratedKernelFiles(File processorMakeFileDir)
  {
    File f = new File(processorMakeFileDir.getAbsolutePath() + "/kernel") ;

    if(f.exists() == false)
    {
      f.mkdir() ;
    }

    FileWriter deployment_C ;
    cDeploymentHeaderFileCode.addOutputNewline("\n#endif\n") ;

    try
    {
      deployment_C =
            new FileWriter(processorMakeFileDir.getAbsolutePath() +
                  "/kernel/deployment.c") ;
      String addDeploymentHeader_C = getAdditionalHeader(cDeploymentFileCode) ;
      saveFile(deployment_C, addDeploymentHeader_C +
                     cDeploymentFileCode.getOutput()) ;
      FileWriter deployment_H =
            new FileWriter(processorMakeFileDir.getAbsolutePath() +
                  "/kernel/deployment.h") ;
      String addDeploymentHeader_H =
            getAdditionalHeader(this.cDeploymentHeaderFileCode) ;
      saveFile(deployment_H, this.DEPLOYMENT_HEADER + '\n' +
                     addDeploymentHeader_H +
                     cDeploymentHeaderFileCode.getOutput()) ;
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
  }

  void generateDeploymentHeader(ProcessorSubcomponent object)
  {
    // POK::Additional_Features => (libc_stdio,libc_stdlib,console);
    // this property is associated to virtual processors
    List<VirtualProcessorSubcomponent> bindedVPS =
          new ArrayList<VirtualProcessorSubcomponent>() ;

    for(Subcomponent sub : object.getComponentImplementation()
          .getOwnedSubcomponents())
      if(sub instanceof VirtualProcessorSubcomponent)
      {
        bindedVPS.add((VirtualProcessorSubcomponent) sub) ;
      }

    List<String> additionalFeatures ;

    for(VirtualProcessorSubcomponent vps : bindedVPS)
    {
      try
      {
        additionalFeatures =
              PropertyUtils.getStringListValue(vps, "Additional_Features") ;

        if(_consoleFound == false)
        {
          for(String s : additionalFeatures)
            if(s.equalsIgnoreCase("console"))
            {
              // POK_NEEDS_CONSOLE has to be in both kernel's deployment.h
              cDeploymentHeaderFileCode
                    .addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
              _consoleFound = true ;
              break ;
            }
        }

        if(_stdioFound == false)
        {
          for(String s : additionalFeatures)
            if(s.equalsIgnoreCase("libc_stdio"))
            {
              _stdioFound = true ;
              break ;
            }
        }

        if(_stdlibFound == false)
        {
          for(String s : additionalFeatures)
            if(s.equalsIgnoreCase("libc_stdlib"))
            {
              _stdlibFound = true ;
              break ;
            }
        }
      }
      catch(Exception e)
      {
      }
    }

    // TODO: the integer ID in this macro must be set carefully to respect the routing table
    // defined in deployment.c files in the generated code for a partition
    int id =
          ((SystemImplementation) object.eContainer())
                .getOwnedProcessorSubcomponents().indexOf(object) ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_LOCAL_NODE " +
                Integer.toString(id)) ;
    // POK_GENERATED_CODE 1 always true in our usage context
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;
    /*Hum, ici je dirai que tu dois mettre ceci d�s que tu as des t�ches p�riodiques ou ordonnanceurs RR ou du statique.
    L'endroit o� il g�n�re cette macro n'est pas encore super clair pour moi dans ocarina ...*/
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_GETTICK 1") ;
    // POK_NEEDS_THREADS 1 always true in our usage context.
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_THREADS 1") ;

    if(bindedVPS.size() > 0)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_PARTITIONS 1") ;
    }

    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_SCHED 1") ;
    /*  The maccro POK_CONFIG_NB_PARTITIONS indicates the amount of partitions in*/
    /*   the current system.It corresponds to the amount of process components in */
    /*  the system.*/
    List<ProcessSubcomponent> bindedProcess =
          GenerationUtils.getBindedProcesses(object) ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_PARTITIONS " +
                Integer.toString(bindedVPS.size())) ;
    List<ThreadSubcomponent> bindedThreads =
          new ArrayList<ThreadSubcomponent>() ;
    List<Integer> threadNumberPerPartition = new ArrayList<Integer>() ;

    for(ProcessSubcomponent p : bindedProcess)
    {
      ProcessImplementation pi =
            (ProcessImplementation) p.getComponentImplementation() ;
      bindedThreads.addAll(pi.getOwnedThreadSubcomponents()) ;
      threadNumberPerPartition.add(Integer.valueOf(pi
            .getOwnedThreadSubcomponents().size())) ;
    }

    /*  The maccro POK_CONFIG_NB_THREADS indicates the amount of threads used in */
    /*  the kernel.It comprises the tasks for the partition and the main task of */
    /*  each partition that initialize all ressources.*/
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(2 + bindedProcess.size() +
                      bindedThreads.size())) ;
    /*  The maccro POK_CONFIG_NB_PARTITIONS_NTHREADS indicates the amount of */
    /*  threads in each partition we also add an additional process that */
    /*  initialize all partition's entities (communication, threads, ...)*/
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_PARTITIONS_NTHREADS {") ;

    for(Integer i : threadNumberPerPartition)
    {
      cDeploymentHeaderFileCode.addOutput(Integer.toString(i + 1)) ;

      if(threadNumberPerPartition.indexOf(i) != (threadNumberPerPartition
            .size() - 1))
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;

    try
    {
      boolean foundRR = false ;

      for(VirtualProcessorSubcomponent vps : bindedVPS)
      {
        String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;

        if(requiredScheduler.equalsIgnoreCase("RR") && foundRR == false)
        {
          foundRR = true ;
          cDeploymentHeaderFileCode
                .addOutputNewline("#define POK_NEEDS_SCHED_RR 1") ;
        }
      }
    }
    catch(Exception e)
    {
    }

    // TODO: define POK_CONFIG_PARTITIONS_SCHEDULER: sched algo associated to each partition
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_PARTITIONS_SCHEDULER {") ;

    try
    {
      for(VirtualProcessorSubcomponent vps : bindedVPS)
      {
        String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;

        if(requiredScheduler.equalsIgnoreCase("RR"))
        {
          cDeploymentHeaderFileCode.addOutput("POK_SCHED_RR") ;
        }

        if(bindedVPS.indexOf(vps) != bindedVPS.size() - 1)
        {
          cDeploymentHeaderFileCode.addOutput(",") ;
        }
      }
    }
    catch(Exception e)
    {
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    // TODO: define lock objects for distributed use-case
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_LOCKOBJECTS 1") ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_LOCKOBJECTS 1") ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_PARTITIONS_NLOCKOBJECTS {1}") ;
    /*  The maccro POK_CONFIG_PARTTITIONS_SIZE indicates the required amount of */
    /*  memory for each partition.This value was deduced from the property */
    /*  POK::Needed_Memory_Size of each process*/
    // comes from property POK::Needed_Memory_Size => XXX Kbyte;
    List<Long> memorySizePerPartition = new ArrayList<Long>() ;

    try
    {
      for(ProcessSubcomponent p : bindedProcess)
      {
        memorySizePerPartition.add(PropertyUtils
              .getIntValue(p, "Needed_Memory_Size")) ;
      }
    }
    catch(Exception e)
    {
    }

    cDeploymentHeaderFileCode.addOutput("#define POK_CONFIG_PARTITIONS_SIZE {") ;

    for(Long l : memorySizePerPartition)
    {
      cDeploymentHeaderFileCode.addOutput(Long.toString(l)) ;

      if(memorySizePerPartition.indexOf(l) != memorySizePerPartition.size() - 1)
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    List<Long> slotPerPartition =
          PropertyUtils.getIntListValue(object, "Slots") ;
    // POK_CONFIG_SCHEDULING_SLOTS extracted from POK::Slots => (500 ms);
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_SCHEDULING_SLOTS {") ;

    for(Long l : slotPerPartition)
    {
      cDeploymentHeaderFileCode.addOutput(Long.toString(l)) ;

      if(slotPerPartition.indexOf(l) != slotPerPartition.size() - 1)
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    // Toujours d�fini � partir du proc impl POK::Slots_Allocation => ( reference (part1));
    List<Subcomponent> slotsAllocation =
          PropertyUtils.getSubcomponentList(object, "Slots_Allocation") ;
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {") ;

    for(Subcomponent sAllocation : slotsAllocation)
    {
      int referencedComponentId = bindedVPS.indexOf(sAllocation) ;
      cDeploymentHeaderFileCode.addOutput(Integer
            .toString(referencedComponentId)) ;

      if(slotsAllocation.indexOf(sAllocation) != slotsAllocation.size() - 1)
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    // la pp slots de POK peut contenir une liste ... donc il faut compter
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_SCHEDULING_NBSLOTS " +
                Integer.toString(slotPerPartition.size())) ;

    // pp POK::Major_Frame => 1000 ms; dans proc impl
    try
    {
      Long majorFrame = PropertyUtils.getIntValue(object, "Major_Frame") ;
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_CONFIG_SCHEDULING_MAJOR_FRAME " +
                  Long.toString(majorFrame)) ;
    }
    catch(Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }

    for(ProcessSubcomponent ps : bindedProcess)
    {
      ProcessImplementation pi =
            (ProcessImplementation) ps.getComponentImplementation() ;

      for(ThreadSubcomponent ts : pi.getOwnedThreadSubcomponents())
      {
        try
        {
          _requiredStackSize +=
                PropertyUtils.getIntValue(ts, "Source_Stack_Size") ;
        }
        catch(Exception e)
        {
          _requiredStackSize += 16384 ;
        }
      }
    }

    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
                Long.toString(_requiredStackSize)) ;
    // TODO: define buses for distributed use-case
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 0") ;
    cDeploymentHeaderFileCode.addOutputNewline("typedef enum") ;
    cDeploymentHeaderFileCode.addOutputNewline("{") ;
    cDeploymentHeaderFileCode.incrementIndent() ;
    cDeploymentHeaderFileCode.addOutputNewline("invalid_bus = 0") ;
    cDeploymentHeaderFileCode.decrementIndent() ;
    cDeploymentHeaderFileCode.addOutputNewline("} pok_bus_identifier_t;") ;
    // enum�ration de la liste de "node"
    SystemImplementation si = (SystemImplementation) object.eContainer() ;
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_CONFIG_NB_NODES " +
          Integer.toString(si.getOwnedProcessorSubcomponents().size())) ;
  }
  
  //Populates blackboard list: pok_runtime::Blackboard_Id_Type data
  // subcomponent's names will be blackboard names.
  private Map<DataAccess, String> buildBlackboardMap(
                                              ProcessImplementation processImpl)
  {
    Map<DataAccess, String> result = new HashMap<DataAccess, String>() ;
    
    EList<Subcomponent> subcmpts = processImpl.getAllSubcomponents() ;
    
    List<String> blackboardNames = new ArrayList<String>() ;
    
    // Fetches blackboard names.
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent &&
            s.getClassifier().getQualifiedName()
                  .equalsIgnoreCase("pok_runtime::Blackboard_Id_Type"))
      {
        blackboardNames.add(s.getName()) ;
      }
    }
    
    // Binds blackboard names with DataAcess objects. See process' connections.
    
    for(Connection connect : processImpl.getAllConnections())
    {
      if (connect instanceof AccessConnection &&
         ((AccessConnection) connect).getAccessCategory() == AccessCategory.DATA)
      {
        DataSubcomponent destination =  (DataSubcomponent) connect.
                                                           getAllDestination() ;
        
        if(AadlBaUtils.contains(destination.getName(), blackboardNames))
        {
          ConnectedElement source = (ConnectedElement) connect.getSource() ;
          
          DataAccess da = (DataAccess) source.getConnectionEnd() ;
          
          result.put(da, destination.getName()) ;
        }
      }
    }
    
    return result ;
  }
  
  // Returns blackboard names list.
  private void generateDeploymentHeader(ProcessImplementation processImpl)
  {
    List<ThreadSubcomponent> bindedThreads =
          processImpl.getOwnedThreadSubcomponents() ;
    // *** generate deployment.h ****
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;

    if(_consoleFound == true)
    {
      cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
    }

    if(_stdioFound == true)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDIO 1") ;
    }

    if(_stdlibFound == true)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDLIB 1") ;
    }

    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(bindedThreads.size() + 1)) ;
    
    // XXX performance to be improved.
    // Removes duplicates.
    Set<String> blackboardNames = new HashSet<String>(_blackboardNames.values());
    
    int blackboardNeeded = (blackboardNames.isEmpty()) ? 0 : 1 ;

    if(false == blackboardNames.isEmpty())
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_CONFIG_NB_BLACKBOARDS " +
                  blackboardNames.size()) ;
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_ARINC653_BLACKBOARD 1") ;
      _hasToAddBlackboardHeader = true ;
    }

    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_BLACKBOARDS " + blackboardNeeded) ;

    if(_requiredStackSize != 0)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
                  Long.toString(_requiredStackSize)) ;
    }

    // XXX Is there any condition for the generation of theses directives ?
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_TIME 1") ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PROCESS 1") ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PARTITION 1") ;

    // XXX Is there any condition for the generation of POK_NEEDS_MIDDLEWARE ?
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_MIDDLEWARE 1") ;

    // *** Generate deployment.c ***
    if(false == blackboardNames.isEmpty())
    {
      StringBuilder sb = new StringBuilder() ;

      for(String name : blackboardNames)
      {
        sb.append("uint8_t ") ;
        sb.append(GenerationUtils.generateBlackboardId(name)) ;
        sb.append(';') ;
      }

      cDeploymentFileCode.addOutputNewline(sb.toString()) ;
    }
  }
}
