package fr.tpt.aadl.c.unparser ;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.ArrayList ;
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
import org.osate.annexsupport.AnnexUnparser ;
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

/*
  private final String TYPE_HEADER = "#ifndef __GENERATED_GTYPES_H__\n"
        + "#define __GENERATED_GTYPES_H__\n" ;

  private final String SUBPROGRAM_HEADER =
        "#ifndef __GENERATED_SUBPROGRAMS_H__\n"
              + "#define __GENERATED_SUBPROGRAMS_H__\n"
              + "#include \"gtypes.h\"\n" ;
*/
/*  
  private final String ACTIVITY_HEADER = "#ifndef __GENERATED_ACTIVITY_H__\n"
        + "#define __GENERATED_ACTIVITY_H__\n" + "#include \"subprograms.h\"\n" ;

  private final String DEPLOYMENT_HEADER =
        "#ifndef __GENERATED_DEPLOYMENT_H__\n"
              + "#define __GENERATED_DEPLOYMENT_H__\n" ;
*/              

  // *************************************************************************
  // XXX Every static variables have to be reseted between partition files
  // generation => miss conception. This class has to be refactored.
  // *************************************************************************

/*  
  
  // POK's Additional features flags.
  private static boolean _consoleFound = false, _stdioFound = false,
        _stdlibFound = false ;

  // POK config stacks size.
  private static long _requiredStackSize = 0 ;

  // POK partition's main.c flags.
  private boolean _hasToAddBlackboardHeader = false,
        _hasToAddSamplingHeader = false ;

*/
  
  //protected AadlToCSwitchProcess cMainFileCode ;

  // gtype.c and .h
  protected AadlToCSwitchProcess _gtypesImplCode ;
  protected AadlToCSwitchProcess _gtypesHeaderCode ;

  // subprogram.c and .h
  protected AadlToCSwitchProcess _subprogramImplCode ;
  protected AadlToCSwitchProcess _subprogramHeaderCode ;
  
  // activity.c and .h
  protected AadlToCSwitchProcess _activityImplCode ;
  protected AadlToCSwitchProcess _activityHeaderCode ;

  // partition's deployment.c and .h
  protected AadlToCSwitchProcess _deploymentImplCode ;
  protected AadlToCSwitchProcess _deploymentHeaderCode ;

  private AadlToCSwitchProcess _currentImplUnparser ;
  private AadlToCSwitchProcess _currentHeaderUnparser ;

  private static List<NamedElement> _delayedDataDeclarations =
      new ArrayList<NamedElement>() ;

  private Map<AadlToCSwitchProcess, Set<String>> _additionalHeaders =
      new HashMap<AadlToCSwitchProcess, Set<String>>() ;

  private List<NamedElement> _processedTypes = new ArrayList<NamedElement>() ;

//private static Map<DataAccess, String> _blackboardNames ;
  
  private static final String MAIN_HEADER_INCLUSION = "#include \"main.h\"\n" ;
  
  // Map Data Access with their relative Data Subcomponent. Relations 
  // are defined in the process implementation via connections.
  private Map<DataAccess, String> _dataAccessMapping ;
  
  public AadlToCUnparser()
  {
    super() ;
/*
    cMainFileCode = new AadlToCSwitchProcess(this) ;
    cMainFileCode.addOutputNewline("#include \"activity.h\"") ;
    cMainFileCode.addOutputNewline("#include \"deployment.h\"") ;
    // XXX Is there any condition for the generation of theses directives ?
    cMainFileCode.addOutputNewline("#include <arinc653/types.h>") ;
    cMainFileCode.addOutputNewline("#include <arinc653/process.h>") ;
    cMainFileCode.addOutputNewline("#include <arinc653/partition.h>") ;
*/    
    _gtypesImplCode = new AadlToCSwitchProcess(this) ;
    _gtypesImplCode.addOutputNewline("#include \"gtypes.h\"") ;
    
    _gtypesHeaderCode = new AadlToCSwitchProcess(this) ;
//    _gtypesHeaderCode.addOutputNewline(MAIN_HEADER_INCLUSION) ;
    
    _subprogramImplCode = new AadlToCSwitchProcess(this) ;
    _subprogramImplCode.addOutputNewline("#include \"subprograms.h\"") ;
    
    _subprogramHeaderCode = new AadlToCSwitchProcess(this) ;
    
    _subprogramHeaderCode.addOutputNewline("#include \"gtypes.h\"") ;    
    
    _activityImplCode = new AadlToCSwitchProcess(this) ;
    _activityImplCode.addOutputNewline("#include \"activity.h\"") ;
    
    _activityHeaderCode = new AadlToCSwitchProcess(this) ;
//    _activityHeaderCode.addOutputNewline(MAIN_HEADER_INCLUSION) ;
    _activityHeaderCode.addOutputNewline("#include \"subprograms.h\"") ;
        
    _deploymentImplCode = new AadlToCSwitchProcess(this) ;
    //_deploymentImplCode.addOutputNewline("#include <arinc653/types.h>") ;
    _deploymentImplCode.addOutputNewline("#include \"deployment.h\"") ;
    
    _deploymentHeaderCode = new AadlToCSwitchProcess(this) ;
//    _deploymentHeaderCode.addOutputNewline(MAIN_HEADER_INCLUSION) ;
  }
  /*
  
  
  _activityHeaderCode.addOutputNewline(GenerationUtils.
                                       generateHeaderInclusionGuard("activity.h")) ;
  
  _deploymentHeaderCode.addOutputNewline(GenerationUtils.
                                         generateHeaderInclusionGuard("deployment.h")) ;
                                         
                                         */

  public void saveGeneratedFilesContent(File targetDirectory)
  {
    _currentHeaderUnparser = _gtypesHeaderCode ;

    for(NamedElement ne : _delayedDataDeclarations)
    {
      getCTypeDeclarator(ne, false) ;
    }

    _gtypesHeaderCode.addOutputNewline("\n#endif\n") ;
    _subprogramHeaderCode.addOutputNewline("\n#endif\n") ;
    _activityHeaderCode.addOutputNewline("\n#endif\n") ;
    _deploymentHeaderCode.addOutputNewline("\n#endif\n") ;

    try
    {
      String headerGuard = null ;
      
      // gtypes.c
      FileWriter typesFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.c") ;
      String addTypeHeader_C = getAdditionalHeader(_gtypesImplCode) ;
      saveFile(typesFile_C, addTypeHeader_C, _gtypesImplCode.getOutput()) ;
      
      // gtypes.h
      FileWriter typesFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/gtypes.h") ;
      headerGuard = GenerationUtils.generateHeaderInclusionGuard("gtypes.h") ;
      String addTypeHeader_H = getAdditionalHeader(_gtypesHeaderCode) ;
      saveFile(typesFile_H, headerGuard, MAIN_HEADER_INCLUSION, addTypeHeader_H,
               _gtypesHeaderCode.getOutput()) ;
      
      // subprogram.c
      FileWriter subprogramsFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.c") ;
      String addSubprogramHeader_C = getAdditionalHeader(_subprogramImplCode) ;
      saveFile(subprogramsFile_C, addSubprogramHeader_C,
                     _subprogramImplCode.getOutput()) ;
      
      // subprogram.h
      FileWriter subprogramsFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/subprograms.h") ;
      headerGuard = GenerationUtils.generateHeaderInclusionGuard("subprograms.h");
      String addSubprogramsHeader_H = getAdditionalHeader(_subprogramHeaderCode) ;
      saveFile(subprogramsFile_H, headerGuard, addSubprogramsHeader_H,
                     _subprogramHeaderCode.getOutput()) ;
      
      // activity.c     
      FileWriter activityFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/activity.c") ;
      String addActivityHeader_C = getAdditionalHeader(_activityImplCode) ;
      saveFile(activityFile_C, addActivityHeader_C, _activityImplCode.getOutput()) ;
      
      // activity.h
      FileWriter activityFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/activity.h") ;
      headerGuard = GenerationUtils.generateHeaderInclusionGuard("activity.h");
      String addActivityHeader_H = getAdditionalHeader(_activityHeaderCode) ;
      saveFile(activityFile_H, headerGuard, MAIN_HEADER_INCLUSION, 
               addActivityHeader_H, _activityHeaderCode.getOutput()) ;
      
      // partition's deployment.c
      FileWriter deploymentFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.c") ;
      String addDeploymentHeader_C = getAdditionalHeader(_deploymentImplCode) ;
      saveFile(deploymentFile_C, addDeploymentHeader_C,
                     _deploymentImplCode.getOutput()) ;
      
      
      // partition's deployment.h
      FileWriter deploymentFile_H =
            new FileWriter(targetDirectory.getAbsolutePath() + "/deployment.h") ;
      headerGuard = GenerationUtils.generateHeaderInclusionGuard("deployment.h");
      String addDeploymentHeader_H = getAdditionalHeader(_deploymentHeaderCode) ;
      saveFile(deploymentFile_H, headerGuard, MAIN_HEADER_INCLUSION,
               addDeploymentHeader_H, _deploymentHeaderCode.getOutput()) ;

/*      
      FileWriter mainFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/main.c") ;
      String addMainHeader_C = getAdditionalHeader(cMainFileCode) ;
      saveFile(mainFile_C, addMainHeader_C + cMainFileCode.getOutput()) ;
*/
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

    if(_additionalHeaders.containsKey(fileUnparser))
    {
      Set<String> additionalTypeHeaders = _additionalHeaders.get(fileUnparser) ;

      for(String s : additionalTypeHeaders)
      {
        res.append("#include \"" + s + "\"\n") ;
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
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
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
        _currentHeaderUnparser.addOutputNewline("typedef char " + id + ";") ;
        break ;
      case CHARACTER :
      {
        _currentHeaderUnparser.addOutput("typedef ") ;
        _currentHeaderUnparser.addOutputNewline(numberRepresentationValue + " char " +
              id + ";") ;
        break ;
      }
      case FIXED :
        break ;
      case FLOAT :
        _currentHeaderUnparser.addOutputNewline("typedef float " + id + ";") ;
        break ;
      case INTEGER :
      {
        _currentHeaderUnparser.addOutput("typedef ") ;
        _currentHeaderUnparser.addOutputNewline(numberRepresentationValue + " int " +
              id + ";") ;
        break ;
      }
      case STRING :
        _currentHeaderUnparser.addOutputNewline("typedef char * " + id + ";") ;
        break ;
      // Complex types
      case ENUM :
      {
        if(delayComplexTypes)
        {
          _delayedDataDeclarations.add(object) ;
          break ;
        }

        _currentHeaderUnparser.addOutputNewline("typedef enum " + id + " {") ;
        _currentHeaderUnparser.incrementIndent() ;
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

                _currentHeaderUnparser.addOutputNewline(id + "_" +
                      enumString.getValue() + rep) ;
              }
            }
          }
        }

        _currentHeaderUnparser.decrementIndent() ;
        _currentHeaderUnparser.addOutputNewline("} " + id + ";") ;
        break ;
      }
      case STRUCT :
      {
        if(delayComplexTypes)
        {
          _delayedDataDeclarations.add(object) ;
          break ;
        }

        _currentHeaderUnparser.addOutputNewline("typedef struct " + id + " {") ;
        _currentHeaderUnparser.incrementIndent() ;
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
                _currentHeaderUnparser.addOutputNewline(type +
                      " " +
                      stringifiedElementNames.get(lv.getOwnedListElements()
                            .indexOf(v)) + ";") ;
              }
            }
          }
        }

        _currentHeaderUnparser.decrementIndent() ;
        _currentHeaderUnparser.addOutputNewline("} " + id + ";") ;
        break ;
      }
      case UNION :
      {
        if(delayComplexTypes)
        {
          _delayedDataDeclarations.add(object) ;
          break ;
        }

        _currentHeaderUnparser.addOutputNewline("typedef union " + id + " {") ;
        _currentHeaderUnparser.incrementIndent() ;
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
                _currentHeaderUnparser.addOutputNewline(type +
                      " " +
                      stringifiedElementNames.get(lv.getOwnedListElements()
                            .indexOf(v)) + ";") ;
              }
            }
          }
        }

        _currentHeaderUnparser.decrementIndent() ;
        _currentHeaderUnparser.addOutputNewline("}" + id + ";") ;
        break ;
      }
      case ARRAY :
      {
        _currentHeaderUnparser.addOutput("typedef ") ;
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
                _currentHeaderUnparser.addOutput(GenerationUtils
                      .getGenerationCIdentifier(cv.getClassifier()
                            .getQualifiedName())) ;
              }
            }
          }
        }

        _currentHeaderUnparser.addOutput(" ") ;
        _currentHeaderUnparser.addOutput(id) ;
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
                _currentHeaderUnparser.addOutput("[") ;
                IntegerLiteral dimension = (IntegerLiteral) v ;
                _currentHeaderUnparser.addOutput(Long.toString(dimension.getValue())) ;
                _currentHeaderUnparser.addOutput("]") ;
              }
            }
          }
        }

        _currentHeaderUnparser.addOutputNewline(";") ;
        break ;
      }
      case UNKNOWN :
      {
        try
        {
          _currentHeaderUnparser.addOutput("typedef ") ;
          resolveExistingCodeDependencies(object, _gtypesHeaderCode,
                                          _gtypesHeaderCode) ;
          _currentHeaderUnparser.addOutput(" ") ;
          _currentHeaderUnparser.addOutput(id) ;
          _currentHeaderUnparser.addOutputNewline(";") ;
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
        if(_processedTypes.contains(object))
        {
          return DONE ;
        }

        _processedTypes.add(object) ;
        _currentHeaderUnparser = _gtypesHeaderCode ;
        _gtypesHeaderCode.processComments(object) ;
        getCTypeDeclarator((NamedElement) object, true) ;
        return DONE ;
      }

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
      public String caseDefaultAnnexLibrary(DefaultAnnexLibrary dal)
      {
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
        
        // XXX May AadlBaToCUnparser have its own interface ???
        if(unparser != null && unparser instanceof AadlBaToCUnparserAction )
        {
          AadlBaToCUnparserAction baToCUnparserAction =
                (AadlBaToCUnparserAction) unparser ;

          AadlBaToCUnparser baToCUnparser =
                (AadlBaToCUnparser) baToCUnparserAction.getUnparser() ;
          
          baToCUnparser.setDataAccessMapping(_dataAccessMapping) ;
          
          baToCUnparserAction.unparseAnnexSubclause(as,
                                             _currentImplUnparser.getIndent()) ;
          
          
          
          baToCUnparser.addIndent_C(_currentImplUnparser.getIndent()) ;
          baToCUnparser.addIndent_H(_currentHeaderUnparser.getIndent()) ;
          _currentImplUnparser.addOutput(baToCUnparser.getCContent()) ;
          _currentHeaderUnparser.addOutput(baToCUnparser.getHContent()) ;

          if(_additionalHeaders.get(_currentHeaderUnparser) == null)
          {
            Set<String> t = new HashSet<String>() ;
            _additionalHeaders.put(_currentHeaderUnparser, t) ;
          }

          _additionalHeaders.get(_currentHeaderUnparser)
                .addAll(baToCUnparser.getAdditionalHeaders()) ;
        }

        return DONE ;
      }

      public String caseDataImplementation(DataImplementation object)
      {
        _currentHeaderUnparser = _gtypesHeaderCode ;
        _gtypesHeaderCode.processComments(object) ;
        getCTypeDeclarator((NamedElement) object, true) ;
        return null ;
      }

      public String caseDataSubcomponent(DataSubcomponent object)
      {
        AadlToCSwitchProcess unparser ;

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

        try
        {
          resolveExistingCodeDependencies(dst, unparser, _currentHeaderUnparser) ;
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

        if(_processedTypes.contains(object.getDataSubcomponentType()) == false)
        {
          process(object.getDataSubcomponentType()) ;
          _processedTypes.add(object.getDataSubcomponentType()) ;
        }

        return null ;
      }
      
      public String caseProcessImplementation(ProcessImplementation object)
      {
        _dataAccessMapping = buildDataAccessMapping(object) ;
        
        processEList(object.getOwnedThreadSubcomponents()) ;
        
        return DONE ;
      }
      
      // Builds the data access mapping via the connections described in the
      // process implementation.
      private Map<DataAccess, String> buildDataAccessMapping(
                                              ProcessImplementation processImpl)
      {
        Map<DataAccess, String> result = new HashMap<DataAccess, String>() ;
        
        EList<Subcomponent> subcmpts = processImpl.getAllSubcomponents() ;
        
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
        for(Connection connect : processImpl.getAllConnections())
        {
          if (connect instanceof AccessConnection &&
             ((AccessConnection) connect).getAccessCategory() == AccessCategory.DATA)
          {
            DataSubcomponent destination =  (DataSubcomponent) connect.
                                                           getAllDestination() ;
            
            if(AadlBaUtils.contains(destination.getName(), dataSubcomponentNames))
            {
              ConnectedElement source = (ConnectedElement) connect.getSource() ;
              
              DataAccess da = (DataAccess) source.getConnectionEnd() ;
              
              result.put(da, destination.getName()) ;
            }
          }
        }
        
        return result ;
      }
      
      /*      
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
*/
/*
      public String caseProcessorSubcomponent(ProcessorSubcomponent object)
      {
        generateDeploymentHeader(object) ;
        return null ;
      }
*/

      public String caseProcessSubcomponent(ProcessSubcomponent object)
      {
        process(object.getComponentImplementation()) ;
        return DONE ;
      }

      public String caseThreadImplementation(ThreadImplementation object)
      {
        process(object.getType()) ;
        _activityImplCode.addOutput("void* ") ;
        _activityImplCode.addOutput(GenerationUtils
              .getGenerationCIdentifier(object.getQualifiedName())) ;
        _activityImplCode.addOutputNewline(GenerationUtils.THREAD_SUFFIX + "()") ;
        _activityImplCode.addOutputNewline("{") ;
        _activityImplCode.incrementIndent() ;

        for(DataSubcomponent d : object.getOwnedDataSubcomponents())
        {
          process(d) ;
        }

        _currentImplUnparser = _activityImplCode ;
        _currentHeaderUnparser = _activityHeaderCode ;
        
        for(AnnexSubclause annex : object.getOwnedAnnexSubclauses())
        {
          process(annex) ;
        }

        _activityImplCode.decrementIndent() ;
        _activityImplCode.addOutputNewline("}") ;
        
        _activityHeaderCode.addOutput("void*  ") ;
        _activityHeaderCode.addOutput(GenerationUtils
              .getGenerationCIdentifier(object.getQualifiedName())) ;
        _activityHeaderCode.addOutputNewline(GenerationUtils.THREAD_SUFFIX + "();\n") ;
        
        return null ;
      }

      public String caseThreadSubcomponent(ThreadSubcomponent object)
      {
        process(object.getComponentImplementation()) ;
        return null ;
      }

      public String caseThreadType(ThreadType object)
      {
        if(_processedTypes.contains(object))
        {
          return null ;
        }

        _processedTypes.add(object) ;
        _currentHeaderUnparser = _activityHeaderCode ;
        _currentImplUnparser = _activityImplCode ;

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
        _currentImplUnparser.addOutput("extern ") ;
        
        String dataSubprogramName = _dataAccessMapping.get(object) ;
        
        if(dataSubprogramName != null)
        {
          _currentImplUnparser.addOutput(dataSubprogramName);
        }
        else
        {
          try
          {
            resolveExistingCodeDependencies(object.getDataFeatureClassifier(),
                                           _currentImplUnparser, _currentHeaderUnparser) ;
          }
          catch(Exception e)
          {
            _currentImplUnparser.addOutput(GenerationUtils
                  .getGenerationCIdentifier(object.getDataFeatureClassifier()
                        .getQualifiedName())) ;
          }
          
          _currentImplUnparser.addOutput(" ") ;
          _currentImplUnparser.addOutput(GenerationUtils
                .getGenerationCIdentifier(object.getQualifiedName())) ;
        }

        _currentImplUnparser.addOutputNewline(";") ;
        
        
        return DONE ;
      }
    } ;
  }

  public void doProcess(Element element)
  {
    AadlToCSwitchProcess.process(element) ;
  }

/*  
  public void saveGeneratedKernelFiles(File processorMakeFileDir)
  {
    File f = new File(processorMakeFileDir.getAbsolutePath() + "/kernel") ;

    if(f.exists() == false)
    {
      f.mkdir() ;
    }

    FileWriter deployment_C ;
    _deploymentHeaderCode.addOutputNewline("\n#endif\n") ;

    try
    {
      deployment_C =
            new FileWriter(processorMakeFileDir.getAbsolutePath() +
                  "/kernel/deployment.c") ;
      String addDeploymentHeader_C = getAdditionalHeader(_deploymentImplCode) ;
      saveFile(deployment_C, addDeploymentHeader_C +
                     _deploymentImplCode.getOutput()) ;
      FileWriter deployment_H =
            new FileWriter(processorMakeFileDir.getAbsolutePath() +
                  "/kernel/deployment.h") ;
      String addDeploymentHeader_H =
            getAdditionalHeader(this._deploymentHeaderCode) ;
      saveFile(deployment_H, this.DEPLOYMENT_HEADER + '\n' +
                     addDeploymentHeader_H +
                     _deploymentHeaderCode.getOutput()) ;
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
  }
*/
/*
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
    //Hum, ici je dirai que tu dois mettre ceci d�s que tu as des t�ches p�riodiques ou ordonnanceurs RR ou du statique.
    //L'endroit o� il g�n�re cette macro n'est pas encore super clair pour moi dans ocarina ...
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_GETTICK 1") ;
    // POK_NEEDS_THREADS 1 always true in our usage context.
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_THREADS 1") ;

    if(bindedVPS.size() > 0)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_PARTITIONS 1") ;
    }

    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_SCHED 1") ;
    //  The maccro POK_CONFIG_NB_PARTITIONS indicates the amount of partitions in
    //   the current system.It corresponds to the amount of process components in/
    //  the system.
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

    //  The maccro POK_CONFIG_NB_THREADS indicates the amount of threads used in 
    //  the kernel.It comprises the tasks for the partition and the main task of 
    //  each partition that initialize all ressources.
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(2 + bindedProcess.size() +
                      bindedThreads.size())) ;
    //  The maccro POK_CONFIG_NB_PARTITIONS_NTHREADS indicates the amount of 
    //  threads in each partition we also add an additional process that 
    //  initialize all partition's entities (communication, threads, ...)
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
    //  The maccro POK_CONFIG_PARTTITIONS_SIZE indicates the required amount of 
    //  memory for each partition.This value was deduced from the property 
    //  POK::Needed_Memory_Size of each process
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
*/ 
/*
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
*/  
/*  
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
*/  
}
