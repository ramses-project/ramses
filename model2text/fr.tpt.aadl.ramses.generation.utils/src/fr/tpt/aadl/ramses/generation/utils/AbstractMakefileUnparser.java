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

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Classifier;
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
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.SubprogramCallAction ;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Command ;
import fr.tpt.aadl.ramses.control.support.utils.DependencyManager ;
import fr.tpt.aadl.ramses.control.support.utils.WaitMonitor ;

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
        String msg = "iteration over bound" ;
        _LOGGER.fatal(msg);
        throw new NoSuchElementException(msg) ;
      }
      
      _count++ ;
      
      return result ;
    }

    @Override
    public void remove()
    {
      String msg = "remove not supported" ;
      _LOGGER.fatal(msg);
      throw new UnsupportedOperationException(msg) ;
    }
  }
  
  protected DependencyManager<Element, File> _includeDirManager = new
                                            DependencyManager<Element, File>() ;
  
  protected File _runtimePath ;
  
  protected File[] _includeDirs ;
  
  protected static String _ENV_VAR_NAME ;

  private static Logger _LOGGER = Logger.getLogger(AbstractMakefileUnparser.class) ;
  
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
  
  protected void handleDirs(File runtimePath, File[] includeDirs)
  {
    _runtimePath = runtimePath ;
    _includeDirs = includeDirs ;
  }
  
  public Set<File> getListOfReferencedObjects(ProcessImplementation aProcessImplementation)
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
          // The thread component instance should reference
          // a thread implementation to call user operations.
          String errMsg =  "the thread component instance should reference a " +
                           "thread implementation to call user operations." ;
          _LOGGER.fatal(errMsg);
          ServiceProvider.SYS_ERR_REP.error(errMsg, true);
        }
      }
      
      _includeDirManager.addDependencies(aProcessImplementation, result); 
    }
    
    return result ;
  }
  
  protected void getListOfReferencedObjects(ThreadImplementation aThreadImplementation,
                                            Set<File> result)
  {
    Set<File> tmp = _includeDirManager.getDenpendencies(aThreadImplementation) ;
    
    if(tmp == null)
    {
      tmp = new LinkedHashSet<File>() ;
      
      for(SubprogramCallSequence aCallSequence : aThreadImplementation
            .getOwnedSubprogramCallSequences())
      {
        for(SubprogramCall aCallSpecification : aCallSequence
              .getOwnedSubprogramCalls())
        {
          getListOfReferencedObjects(aCallSpecification, tmp) ;
        }
      }
      for(SubprogramSubcomponent sc : aThreadImplementation
            .getOwnedSubprogramSubcomponents())
      {
        getListOfReferencedObjects(sc, tmp) ;
      }
      
      _includeDirManager.addDependencies(aThreadImplementation, tmp) ;
      
    }// End if.
    
    result.addAll(tmp) ;
  }

  protected void getListOfReferencedObjects(SubprogramSubcomponent sc,
                                            Set<File> result)
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

  protected void getListOfReferencedObjects(SubprogramCall aCallSpecification,
                                            Set<File> result)
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
  {
    Set<File> tmp = _includeDirManager.getDenpendencies(aSubprogram) ;
    
    if(tmp == null)
    {
      tmp = new LinkedHashSet<File>() ;
      
      if(aSubprogram instanceof SubprogramType)
      {
        SubprogramType aSubprogramType = (SubprogramType) aSubprogram ;
        for(AnnexSubclause annex : AnnexUtil.
        		getAllAnnexSubclauses((Classifier)aSubprogramType, AadlBaPackage.eINSTANCE.getBehaviorAnnex()))
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

        for(AnnexSubclause annex : AnnexUtil.
        		getAllAnnexSubclauses((Classifier)aSubprogramImplementation, AadlBaPackage.eINSTANCE.getBehaviorAnnex()))
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
        for(SubprogramCall aCallSpecification : aSubprogramImplementation
              .getSubprogramCalls())
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

  private File getDirectory(Element e)
  {
    String path="";
    URI dirURI = e.eResource().getURI();
    if(dirURI.isFile())
      path = dirURI.toFileString();
    else
      path = dirURI.toString();
    int index = path.lastIndexOf(File.separator);
    path = path.substring(0, index+1);
    return new File(path);
  }

  protected boolean getListOfReferencedObjects(PropertyAssociation aPropertyAssociation,
                                               Set<File> result)
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
            
            File noPrefixFoundFile =
                new File(value);
            if(noPrefixFoundFile.exists())
            {
              tmp.add(noPrefixFoundFile) ;
              found = true ;
              continue;
            }
            
            File dir = getDirectory(aPropertyAssociation);
            
            File foundFile =
                    new File(dir + File.separator + value) ;
            
            if(foundFile.exists())
            {
              tmp.add(foundFile) ;
              _includeDirManager.addCommonDependency(dir);
              found = true ;
              continue;
            }
            File includeDir = null ;
            Iterator<File> it = new IncludeDirIterator() ;
            while(it.hasNext())
            {
              includeDir = it.next() ;
              
              foundFile =
                    new File(includeDir.getAbsoluteFile() + File.separator + value) ;
              if(foundFile.exists())
              {
                tmp.add(foundFile) ;
                found = true ;
                break ;
              }
            }
            if(!found)
            {
              String errMsg = "file referenced in object " +
                    aPropertyAssociation.getContainingClassifier().getFullName() +
                    " could not be found " + value ;
              _LOGGER.error(errMsg);
              ServiceProvider.SYS_ERR_REP.error(errMsg, true);
            }
          }
          else if(aPE instanceof ListValue)
          {
            for(PropertyExpression pe : ((ListValue) aPE).getOwnedListElements())
            {
              StringLiteral sl = (StringLiteral) pe ;
              String value = sl.getValue() ;
              boolean found = false ;
              File dir = getDirectory(aPropertyAssociation);
              
              File noPrefixFoundFile =
                  new File(value);
              if(noPrefixFoundFile.exists())
              {
                tmp.add(noPrefixFoundFile) ;
                found = true ;
                continue;
              }
              
              File foundFile =
                      new File(dir + File.separator + value) ;
              
              if(foundFile.exists())
              {
                tmp.add(foundFile) ;
                found = true ;
                _includeDirManager.addCommonDependency(dir);
                continue;
              }
              File includeDir = null ;
              Iterator<File> it = new IncludeDirIterator() ;
              while(it.hasNext())
              {
                includeDir = it.next() ;
                foundFile =
                      new File(includeDir.getAbsolutePath() + File.separator + value) ;
                if(foundFile.exists())
                {
                  tmp.add(foundFile) ;
                  found = true ;
                  break ;
                }
              }
              if(!found)
              {
                String errMsg = "file referenced in object " +
                      aPropertyAssociation.getContainingClassifier()
                      .getFullName() + " could not be found " + value ;
                _LOGGER.error(errMsg);
                ServiceProvider.SYS_ERR_REP.error(errMsg, true);
              }
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
  
  public static void saveMakefile(UnparseText text, File makeFileDir)
  {
    try
    {
      File makeFile = new File(makeFileDir.getAbsolutePath() + "/Makefile") ;
      FileWriter fileW = new FileWriter(makeFile) ;
      BufferedWriter output ;
      
      output = new BufferedWriter(fileW) ;
      output.write(text.getParseOutput()) ;
      output.close() ;
    }
    catch(IOException ex)
    {
      String errMsg = "cannot save the makefile" ;
      _LOGGER.fatal(errMsg, ex) ;
      throw new RuntimeException(errMsg, ex) ;
    }
  }
  
  private static void waitProcess(Command cmd, Process process)
                                                    throws InterruptedException,
                                                                     IOException
  {
    WaitMonitor waitMonitor = new WaitMonitor(cmd) ; 
    waitMonitor.start();
    int exitCode = waitMonitor.waitAndCheck(500) ;
    switch(exitCode)
    {
      // Process is not terminated but the user has canceled it.
      case Command.CANCEL:
      {
        process.destroy(); // We have to destroy the process as it is still running. 
        String msg = '\'' + cmd.getLabel() + "\' was canceled" ;
        _LOGGER.trace(msg) ;
        throw new OperationCanceledException(msg) ;
      }
      
      // Process has terminated without been canceled but with an error (exit code != 0).
      case Command.ERROR:
      {
        String errMsg = "while compiling generated code: " ;
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);

        InputStream is ;
        is = process.getInputStream() ;
        BufferedReader in = new BufferedReader(new InputStreamReader(is)) ;

        String line = null ;
        while((line = in.readLine()) != null)
        {
          _LOGGER.trace(line);
        }
        is = process.getErrorStream() ;
        in = new BufferedReader(new InputStreamReader(is)) ;
        line = null ;
        while((line = in.readLine()) != null)
        {
          _LOGGER.error(line);
          if(line.contains("error")
        		  || line.contains("Error")
        		  || line.contains("ERROR"))
        	  ServiceProvider.SYS_ERR_REP.error(line, true);
        }
        
        break ;
      }
      
      case Command.FATAL:
      {
        Exception e = waitMonitor.getCaughtException() ;
        String msg = "compiling has failed" ;
        _LOGGER.fatal(msg, e);
        throw new RuntimeException(msg, e) ;
      }
      
      // Process is terminated and was not canceled.
      case Command.OK:
      {
        logProcessTraces(process) ;
        String msg = '\'' + cmd.getLabel() + "\' was successfully done" ;
        _LOGGER.info(msg);
        break ;
      }
      default:
      {
        String errMsg = "unknown exit code" ;
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
      }
    }
  }
  
  private static void logProcessTraces(Process process)
                                                              throws IOException
  {
    InputStream is ;
    is = process.getInputStream() ;
    BufferedReader in = new BufferedReader(new InputStreamReader(is)) ;

    String line = null ;
    while((line = in.readLine()) != null)
    {
      _LOGGER.trace(line);
    }
  }
  
  public static void executeMake(final File generatedFilePath, final File runtimePath,
                                 final IProgressMonitor monitor)
  {
    if(runtimePath != null && runtimePath.exists())
    {
      try
      {
        final Runtime runtime = Runtime.getRuntime() ;
        final Process makeCleanProcess =
            runtime.exec("make -C " + generatedFilePath.getAbsolutePath() +
                " clean") ;
        
        Command cmd = new Command()
        {
          int status=Command.UNSET;
          
          @Override
          public int run() throws Exception
          {
            int tmp = makeCleanProcess.waitFor() ;
            
            if(tmp == 0) status=Command.OK;
            else status=Command.ERROR ;
            return status;
          }

          @Override
          public boolean isCanceled()
          {
            return monitor.isCanceled() ;
          }

          @Override
          public String getLabel()
          {
            return "make clean" ;
          }

          @Override
          public int getStatus()
          {
            return status;
          }
        } ;

        // Blocking.
        waitProcess(cmd, makeCleanProcess) ;
        
        if(monitor.isCanceled())
        {
          String msg = "compilation has been canceled after make clean" ;
          _LOGGER.trace(msg);
          throw new OperationCanceledException(msg) ;
        }
        
        _LOGGER.trace("Start compilation");
        
        final Process makeProcess =
            runtime.exec("make -C " + generatedFilePath.getAbsolutePath() +
                         " all") ;
        
        cmd = new Command()
        {
          int status=Command.UNSET;
          
          @Override
          public int run() throws Exception
          {
            int tmp = makeProcess.waitFor() ;
            
            if(tmp == 0) status=Command.OK;
            else status=Command.ERROR ;
            return status;
          }

          @Override
          public boolean isCanceled()
          {
            return monitor.isCanceled() ;
          }
          
          @Override
          public String getLabel()
          {
            return "make all" ;
          }
          
          @Override
          public int getStatus()
          {
            return status;
          }
        } ;

        _LOGGER.trace("Compilation command created");

        // Blocking.
        waitProcess(cmd, makeProcess) ;
      }
      catch(IOException ex)
      {
        String errMsg = "could not build generated code" ;
        _LOGGER.fatal(errMsg, ex) ;
        throw new RuntimeException(errMsg, ex) ;
      }
      catch(InterruptedException ex)
      {
        String errMsg = "could not build generated code" ;
        _LOGGER.fatal(errMsg, ex) ;
        throw new RuntimeException(errMsg, ex) ;
      }
    }
    else
    {
      String errMsg = "ERROR: could not build generated code, runtime path not found" ;
      _LOGGER.error(errMsg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
    }
  }
}