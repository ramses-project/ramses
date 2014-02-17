package fr.tpt.aadl.ramses.generation.utils;

import java.io.BufferedReader ;
import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;
import java.util.Iterator ;
import java.util.LinkedHashSet ;
import java.util.NoSuchElementException ;
import java.util.Set ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.CallSpecification ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subprogram ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramSubcomponent ;
import org.osate.aadl2.SubprogramSubcomponentType ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.SubprogramCallAction ;

import fr.tpt.aadl.ramses.control.support.generator.DependencyManager ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;

public abstract class AbstractMakefileUnparser extends AadlProcessingSwitch
                                               implements TargetBuilderGenerator
{                                      
  protected class IncludeDirIterator implements Iterator<File>
  {
    private int _count = 0 ;
    private int _max = 0 ;
    private Iterator<File> _it ;
        
    public IncludeDirIterator()
    {
      _it = _includeDirManager.getCommonDependencies().iterator() ;
      _max = 1 + _includeDirs.length + _includeDirManager.getCommonDependencies().size() ;
    }
    
    @Override
    public boolean hasNext()
    {
      return _max > _count ;
    }

    @Override
    public File next()
    {
      File result ;
      
      if(_count == 0)
      {
        result = _runtimePath ;
      }
      else if(_count <= _includeDirs.length)
      {
        result = _includeDirs[_count-1] ;
      }
      else if(_count < _max)
      {
        result = _it.next() ;
      }
      else
      {
        throw new NoSuchElementException() ;
      }
      
      _count++ ;
      
      return result ;
    }

    @Override
    public void remove()
    {
      throw new UnsupportedOperationException() ;
    }
  }
  
  protected DependencyManager<Element, File> _includeDirManager = new
                                            DependencyManager<Element, File>() ;
  
  protected File _runtimePath ;
  
  protected File[] _includeDirs ;
  
  protected static String _ENV_VAR_NAME ;
  
  @Override
  public String getRuntimePathEnvVar()
  {
    return _ENV_VAR_NAME ;
  }
  
  public AbstractMakefileUnparser()
  {
    setupCommonDirs();
  }

  @Override
  public void process(SystemImplementation system,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
                            throws GenerationException
  {
    handleDirs(runtimeDir, includeDirs) ;
  }
  
  @Override
  public void process(ProcessorSubcomponent processor,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
        throws GenerationException
  {
    handleDirs(runtimeDir, includeDirs) ;
  }
  
  @Override
  public void process(ProcessSubcomponent process,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
        throws GenerationException
  {
    handleDirs(runtimeDir, includeDirs) ;
  }
  
  abstract protected void setupCommonDirs() ;
  
  protected void handleDirs(File runtimePath, File[] includeDirs) throws GenerationException
  {
    _runtimePath = runtimePath ;
    _includeDirs = includeDirs ;
  }

  
  
  public Set<File> getListOfReferencedObjects(ProcessImplementation aProcessImplementation)
                                                                throws Exception
  {
    Set<File> result = _includeDirManager.getDenpendencies(aProcessImplementation) ;
    
    if(result == null)
    {
      result = new LinkedHashSet<File>() ;
      
      for(ThreadSubcomponent aTheadSubcomponent : aProcessImplementation
                                                 .getOwnedThreadSubcomponents())
      {
        if(aTheadSubcomponent.getComponentImplementation() != null)
        {
          getListOfReferencedObjects((ThreadImplementation) aTheadSubcomponent
                                           .getComponentImplementation(),
                                     result) ;
        }
        else
        {
          // Throw exception, the thread component instance should reference
          // a thread implementation to call user operations.
          throw new Exception(
                "the thread component instance should reference a thread implementation to call user operations.") ;
        }
      }
      
      _includeDirManager.addDependencies(aProcessImplementation, result); 
    }
    
    return result ;
  }
  
  protected void getListOfReferencedObjects(ThreadImplementation aThreadImplementation,
                                            Set<File> result)
        throws Exception
  {
    Set<File> tmp = _includeDirManager.getDenpendencies(aThreadImplementation) ;
    
    if(tmp == null)
    {
      tmp = new LinkedHashSet<File>() ;
      
      for(SubprogramCallSequence aCallSequence : aThreadImplementation
            .getOwnedSubprogramCallSequences())
      {
        for(CallSpecification aCallSpecification : aCallSequence
              .getOwnedCallSpecifications())
        {
          try
          {
            getListOfReferencedObjects(aCallSpecification, tmp) ;
          }
          catch(Exception e)
          {
            System.err.println(e.getMessage()) ;
            e.printStackTrace() ;
            continue ;
          }
        }
      }
      for(SubprogramSubcomponent sc : aThreadImplementation
            .getOwnedSubprogramSubcomponents())
      {
        try
        {
          getListOfReferencedObjects(sc, tmp) ;
        }
        catch(Exception e)
        {
          System.err.println(e.getMessage()) ;
          e.printStackTrace() ;
          continue ;
        }
      }
      
      _includeDirManager.addDependencies(aThreadImplementation, tmp) ;
      
    }// End if.
    
    result.addAll(tmp) ;
  }

  protected void getListOfReferencedObjects(SubprogramSubcomponent sc,
                                            Set<File> result)
        throws Exception
  {
    Set<File> tmp = _includeDirManager.getDenpendencies(sc) ;
    
    if(tmp == null)
    {
      tmp = new LinkedHashSet<File>() ;
      
      SubprogramSubcomponentType sst = sc.getSubprogramSubcomponentType() ;
      for(PropertyAssociation aPropertyAssociation : sst
            .getOwnedPropertyAssociations())
      {
        getListOfReferencedObjects(aPropertyAssociation, tmp) ;
      }
      if(sst instanceof SubprogramImplementation)
      {
        SubprogramImplementation si = (SubprogramImplementation) sst ;
        for(PropertyAssociation aPropertyAssociation : si.getType()
              .getOwnedPropertyAssociations())
        {
          getListOfReferencedObjects(aPropertyAssociation, tmp) ;
        }
      }
      
      _includeDirManager.addDependencies(sc, tmp) ;
    }
    
    result.addAll(tmp) ;
  }

  protected void getListOfReferencedObjects(CallSpecification aCallSpecification,
                                            Set<File> result)
        throws Exception
  {
    if(aCallSpecification instanceof SubprogramCall)
    {
      SubprogramCall sc = (SubprogramCall) aCallSpecification ;
      
      Set<File> tmp = _includeDirManager.getDenpendencies(sc) ;
      
      if(tmp == null)
      {
        tmp = new LinkedHashSet<File>() ;
        
        getListOfReferencedObjects((Subprogram) sc.getCalledSubprogram(),
                                   tmp) ;
        
        _includeDirManager.addDependencies(sc, tmp) ;
      }
      
      result.addAll(tmp) ;
    }
  }

  protected boolean getListOfReferencedObjects(Subprogram aSubprogram,
                                               Set<File> result)
        throws Exception
  {
    Set<File> tmp = _includeDirManager.getDenpendencies(aSubprogram) ;
    
    if(tmp == null)
    {
      tmp = new LinkedHashSet<File>() ;
      
      if(aSubprogram instanceof SubprogramType)
      {
        SubprogramType aSubprogramType = (SubprogramType) aSubprogram ;
        for(AnnexSubclause annex : aSubprogramType.getAllAnnexSubclauses())
        {
          if(annex instanceof BehaviorAnnex)
          {
            BehaviorAnnex ba = (BehaviorAnnex) annex ;
            getListOfReferencedObjects(ba, tmp) ;
            result.addAll(tmp) ;
            _includeDirManager.addDependencies(aSubprogram, tmp) ;
            return true ;
          }
        }
        for(PropertyAssociation aPropertyAssociation : aSubprogramType
              .getOwnedPropertyAssociations())
        {
          getListOfReferencedObjects(aPropertyAssociation, tmp) ;
        }
        if(aSubprogramType.getOwnedExtension() != null)
        {
          getListOfReferencedObjects((Subprogram) aSubprogramType
                                                 .getOwnedExtension()
                                                 .getExtended(), tmp) ;
        }
      }
      else if(aSubprogram instanceof SubprogramImplementation)
      {
        SubprogramImplementation aSubprogramImplementation =
              (SubprogramImplementation) aSubprogram ;

        for(AnnexSubclause annex : aSubprogramImplementation
              .getAllAnnexSubclauses())
        {
          if(annex instanceof BehaviorAnnex)
          {
            BehaviorAnnex ba = (BehaviorAnnex) annex ;
            getListOfReferencedObjects(ba, tmp) ;
            result.addAll(tmp) ;
            _includeDirManager.addDependencies(aSubprogram, tmp) ;
            return true ;
          }
        }
        for(PropertyAssociation aPropertyAssociation : aSubprogramImplementation
              .getOwnedPropertyAssociations())
        {

          getListOfReferencedObjects(aPropertyAssociation, tmp) ;
        }
        if(aSubprogramImplementation.getOwnedExtension() != null)
        {
          getListOfReferencedObjects((Subprogram) aSubprogramImplementation
                                                 .getOwnedExtension()
                                                 .getExtended(), tmp) ;
        }
        if(tmp.isEmpty())
        {
          getListOfReferencedObjects((Subprogram) aSubprogramImplementation
                                                 .getOwnedExtension()
                                                 .getExtended().getType(),
                                      tmp) ;
        }
        for(CallSpecification aCallSpecification : aSubprogramImplementation
              .getCallSpecifications())
        {
          getListOfReferencedObjects(aCallSpecification, tmp) ;
        }
      }
      
      _includeDirManager.addDependencies(aSubprogram, tmp) ;
    }// End of the first if.
    
    result.addAll(tmp) ;
    
    return ! tmp.isEmpty() ;
  }

  protected void getListOfReferencedObjects(BehaviorAnnex ba,
                                            Set<File> result)
        throws Exception
  {
    Set<File> tmp = _includeDirManager.getDenpendencies(ba) ;
    
    if(tmp == null)
    {
      tmp = new LinkedHashSet<File>() ;
      
      for(BehaviorActionBlock bab : ba.getActions())
      {
        Iterator<EObject> iter = bab.eAllContents() ;
        while(iter.hasNext())
        {
          EObject next = iter.next() ;
          if(next instanceof SubprogramCallAction)
          {
            SubprogramCallAction sca = (SubprogramCallAction) next ;
            getListOfReferencedObjects((Subprogram) sca.getSubprogram()
                                             .getElement(), tmp) ;
          }
        }
      }
      
      _includeDirManager.addDependencies(ba, tmp) ;
    }
    
    result.addAll(tmp) ;
  }

  protected boolean getListOfReferencedObjects(PropertyAssociation aPropertyAssociation,
                                               Set<File> result)
        throws Exception
  {
    Set<File> tmp = _includeDirManager.getDenpendencies(aPropertyAssociation) ;
    
    boolean isSourceTextPA = false ;
    
    if(tmp == null)
    {
      tmp = new LinkedHashSet<File>() ;
      
      isSourceTextPA =
            aPropertyAssociation.getProperty().getName() != null &&
                  (aPropertyAssociation.getProperty().getName()
                        .equals("Source_Location") || aPropertyAssociation
                        .getProperty().getName().equals("Source_Text")) ;
      if(isSourceTextPA)
      {
        for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
              .getOwnedValues())
        {
          PropertyExpression aPE = aModalPropertyValue.getOwnedValue() ;
          
          if(aPE instanceof StringLiteral)
          {
            StringLiteral sl = (StringLiteral) aPE ;
            String value = sl.getValue() ;
            boolean found = false ;
            File includeDir = null ;
            Iterator<File> it = new IncludeDirIterator() ;
            while(it.hasNext())
            {
              includeDir = it.next() ;
              
              File foundFile =
                    new File(includeDir.getAbsoluteFile() + File.separator + value) ;
              if(foundFile.exists())
              {
                tmp.add(foundFile) ;
                found = true ;
                break ;
              }
            }
            if(!found)
              System.err.println("file referenced in object " +
                    aPropertyAssociation.getContainingClassifier().getFullName() +
                    " could not be found " + value) ;
          }
          else if(aPE instanceof ListValue)
          {
            for(PropertyExpression pe : ((ListValue) aPE).getOwnedListElements())
            {
              StringLiteral sl = (StringLiteral) pe ;
              String value = sl.getValue() ;
              boolean found = false ;
              File includeDir = null ;
              Iterator<File> it = new IncludeDirIterator() ;
              while(it.hasNext())
              {
                includeDir = it.next() ;
                File foundFile =
                      new File(includeDir.getAbsolutePath() + File.separator + value) ;
                if(foundFile.exists())
                {
                  tmp.add(foundFile) ;
                  found = true ;
                  break ;
                }
              }
              if(!found)
                System.err.println("file referenced in object " +
                      aPropertyAssociation.getContainingClassifier()
                            .getFullName() + " could not be found " + value) ;
            }
          }
        }
      }// End of if(isSourceTextPA).
      
      _includeDirManager.addDependencies(aPropertyAssociation, tmp) ;
      
    }// End of if(tmp == null).
    else
    {
      isSourceTextPA = ! tmp.isEmpty() ;
    }
    
    result.addAll(tmp) ;
    
    return isSourceTextPA ;
  }
  
  public static void saveMakefile(UnparseText text,
                                  File makeFileDir)
  {
    try
    {
      File makeFile = new File(makeFileDir.getAbsolutePath() + "/Makefile") ;
      FileWriter fileW = new FileWriter(makeFile) ;
      BufferedWriter output ;

      try
      {
        output = new BufferedWriter(fileW) ;
        output.write(text.getParseOutput()) ;
        output.close() ;
      }
      catch(IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
      }
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
  }
  
  public static void executeMake(File generatedFilePath,
                                 File runtimePath)
  {
    Runtime runtime = Runtime.getRuntime() ;
    if(runtimePath != null && runtimePath.exists())
    {
      try
      {
        Process makeCleanProcess =
              runtime.exec("make -C " + generatedFilePath.getAbsolutePath() +
                    " clean") ;
        makeCleanProcess.waitFor() ;
        Process makeProcess =
              runtime.exec("make -C " + generatedFilePath.getAbsolutePath() +
                    " all") ;
        makeProcess.waitFor() ;
        if(makeProcess.exitValue() != 0)
        {
          System.err.println("Error when compiling generated code: ") ;

          InputStream is ;
          is = makeProcess.getInputStream() ;
          BufferedReader in = new BufferedReader(new InputStreamReader(is)) ;

          String line = null ;
          while((line = in.readLine()) != null)
          {
            System.err.println(line) ;
          }
          is = makeProcess.getErrorStream() ;
          in = new BufferedReader(new InputStreamReader(is)) ;
          line = null ;
          while((line = in.readLine()) != null)
          {
            System.err.println(line) ;
          }
        }
        else
        {
          InputStream is ;
          is = makeProcess.getInputStream() ;
          BufferedReader in = new BufferedReader(new InputStreamReader(is)) ;

          String line = null ;
          while((line = in.readLine()) != null)
          {
            System.out.println(line) ;
          }
          System.out.println("Generated code was successfully built.\n") ;
        }
      }
      catch(IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
      }
      catch(InterruptedException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
      }

    }
    else
    {
      System.out
            .println("ERROR: could not build generated code, runtime path not found") ;
    }
  }
}