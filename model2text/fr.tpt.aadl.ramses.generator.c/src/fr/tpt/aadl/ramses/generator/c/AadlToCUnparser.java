package fr.tpt.aadl.ramses.generator.c ;

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

import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.generator.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generator.c.annex.behavior.AadlBaToCUnparser ;
import fr.tpt.aadl.ramses.generator.c.annex.behavior.AadlBaToCUnparserAction ;
import fr.tpt.aadl.ramses.generator.target.specific.GeneratorUtils ;
import fr.tpt.aadl.ramses.util.properties.PropertyUtils ;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;
import fr.tpt.aadl.annex.behavior.names.DataModelProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.DimensionException ;

public class AadlToCUnparser extends AadlProcessingSwitch
                             implements AadlGenericUnparser
{
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
  
  // Temporary .c and .h files.
  private AadlToCSwitchProcess _currentImplUnparser ;
  private AadlToCSwitchProcess _currentHeaderUnparser ;

  private static List<NamedElement> _delayedDataDeclarations =
      new ArrayList<NamedElement>() ;

  private Map<AadlToCSwitchProcess, Set<String>> _additionalHeaders =
      new HashMap<AadlToCSwitchProcess, Set<String>>() ;

  private List<NamedElement> _processedTypes = new ArrayList<NamedElement>() ;

  private static final String MAIN_HEADER_INCLUSION = "#include \"main.h\"\n" ;
  
  // Map Data Access with their relative Data Subcomponent. Relations 
  // are defined in the process implementation via connections.
  private Map<DataAccess, String> _dataAccessMapping ;
  
  public AadlToCUnparser()
  {
    super() ;

    _gtypesImplCode = new AadlToCSwitchProcess(this) ;
    _gtypesImplCode.addOutputNewline("#include \"gtypes.h\"") ;
    
    _gtypesHeaderCode = new AadlToCSwitchProcess(this) ;
    
    _subprogramImplCode = new AadlToCSwitchProcess(this) ;
    _subprogramImplCode.addOutputNewline("#include \"subprograms.h\"") ;
    
    _subprogramHeaderCode = new AadlToCSwitchProcess(this) ;
    
    _subprogramHeaderCode.addOutputNewline("#include \"gtypes.h\"") ;    
    
    _activityImplCode = new AadlToCSwitchProcess(this) ;
    _activityImplCode.addOutputNewline("#include \"activity.h\"") ;
    _activityImplCode.addOutputNewline(MAIN_HEADER_INCLUSION);
    
    _activityHeaderCode = new AadlToCSwitchProcess(this) ;
    _activityHeaderCode.addOutputNewline("#include \"subprograms.h\"") ;
        
    _deploymentImplCode = new AadlToCSwitchProcess(this) ;
    _deploymentImplCode.addOutputNewline("#include \"deployment.h\"") ;
    
    _deploymentHeaderCode = new AadlToCSwitchProcess(this) ;
  }

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
      headerGuard = GenerationUtilsC.generateHeaderInclusionGuard("gtypes.h") ;
      String addTypeHeader_H = getAdditionalHeader(_gtypesHeaderCode) ;
      saveFile(typesFile_H, headerGuard, addTypeHeader_H,
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
      headerGuard = GenerationUtilsC.generateHeaderInclusionGuard("subprograms.h");
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
      headerGuard = GenerationUtilsC.generateHeaderInclusionGuard("activity.h");
      String addActivityHeader_H = getAdditionalHeader(_activityHeaderCode) ;
      saveFile(activityFile_H, headerGuard,
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
      headerGuard = GenerationUtilsC.generateHeaderInclusionGuard("deployment.h");
      String addDeploymentHeader_H = getAdditionalHeader(_deploymentHeaderCode) ;
      saveFile(deploymentFile_H, headerGuard, MAIN_HEADER_INCLUSION,
               addDeploymentHeader_H, _deploymentHeaderCode.getOutput()) ;

    }
    catch(IOException e)
    {
      // TODO: handle error message.
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
      // TODO: handle error message.
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
          GenerationUtilsC.getGenerationCIdentifier(object.getQualifiedName()) ;
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
                      GenerationUtilsC.getGenerationCIdentifier(cv
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
                      GenerationUtilsC.getGenerationCIdentifier(cv
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
                _currentHeaderUnparser.addOutput(GenerationUtilsC
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
          unparser.addOutput(GenerationUtilsC.getGenerationCIdentifier(dst
                .getQualifiedName())) ;
        }

        unparser.addOutput(" ") ;
        unparser.addOutput(GenerationUtilsC.getGenerationCIdentifier(object
              .getQualifiedName())) ;
        unparser.addOutput(GeneratorUtils.getInitialValue(object)) ;
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
        
        // *** Generate deployment.c ***
        if(false == _dataAccessMapping.isEmpty())
        {
          // XXX performance to be improved.
          // Removes duplicates.
          Set<String> dataComponentNames = new HashSet<String>(_dataAccessMapping.
                                                                      values());
          
          StringBuilder sb = new StringBuilder() ;

          for(String name : dataComponentNames)
          {
            sb.append("uint8_t ") ;
            sb.append(name) ;
            sb.append(';') ;
          }

          _deploymentImplCode.addOutputNewline(sb.toString()) ;
        }

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
      
      public String caseProcessSubcomponent(ProcessSubcomponent object)
      {
        process(object.getComponentImplementation()) ;
        return DONE ;
      }

      public String caseThreadImplementation(ThreadImplementation object)
      {
        process(object.getType()) ;
        _activityImplCode.addOutput("void* ") ;
        _activityImplCode.addOutput(GenerationUtilsC
              .getGenerationCIdentifier(object.getQualifiedName())) ;
        _activityImplCode.addOutputNewline(GenerationUtilsC.THREAD_SUFFIX + "()") ;
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
        _activityHeaderCode.addOutput(GenerationUtilsC
              .getGenerationCIdentifier(object.getQualifiedName())) ;
        _activityHeaderCode.addOutputNewline(GenerationUtilsC.THREAD_SUFFIX + "();\n") ;
        
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
        
        String dataSubprogramName = null ;
        
        if(_dataAccessMapping != null)
        {
          dataSubprogramName = _dataAccessMapping.get(object) ;
        }
        
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
            _currentImplUnparser.addOutput(GenerationUtilsC
                  .getGenerationCIdentifier(object.getDataFeatureClassifier()
                        .getQualifiedName())) ;
          }
          
          _currentImplUnparser.addOutput(" ") ;
          _currentImplUnparser.addOutput(GenerationUtilsC
                .getGenerationCIdentifier(object.getQualifiedName())) ;
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
    AadlToCSwitchProcess.process(element) ;
    saveGeneratedFilesContent(generatedFilePath) ;
  }

  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}