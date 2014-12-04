/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.generation.pok.makefile ;

import java.io.File ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.util.Aadl2Switch ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.generation.pok.c.PokGeneratorFactory ;
import fr.tpt.aadl.ramses.generation.utils.AbstractAadlToCMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;

public class AadlToPokMakefileUnparser extends AbstractAadlToCMakefileUnparser
{

  private UnparseText unparserContent ;
  private UnparseText kernelMakefileContent ;
  private List<ProcessSubcomponent> bindedProcess ;
  private final static String C_RUNTIME_INCL_DIR = "/libpok/include" ;
  private final static String ADA_RUNTIME_INCL_DIR = "/libpok/ada" ;
  public final static String POK_RUNTIME_VAR_ENV = "POK_PATH" ;
  
  private static Logger _LOGGER = Logger.getLogger(AadlToPokMakefileUnparser.class) ;
  static boolean isFirstConnected=true;
  
  public AadlToPokMakefileUnparser()
  {
    AbstractAadlToCMakefileUnparser._ENV_VAR_NAME = POK_RUNTIME_VAR_ENV ;
  }
  
  @Override
  protected void handleDirs(File runtimePath, File[] includeDirs)
  {
    File pokCFile = new File(runtimePath + C_RUNTIME_INCL_DIR);
    File pokAdaFile = new File(runtimePath + ADA_RUNTIME_INCL_DIR);
    _includeDirManager.addCommonDependency(pokCFile);
    _includeDirManager.addCommonDependency(pokAdaFile);
    super.handleDirs(runtimePath, includeDirs);
  }
  
  @Override
  protected void initSwitches()
  {
    aadl2Switch = new Aadl2Switch<String>()
    {
      @Override
      public String caseSystemImplementation(SystemImplementation object)
      {
        unparserContent.addOutputNewline("export " + POK_RUNTIME_VAR_ENV + "=" +
                                         _runtimePath.toString());
        unparserContent.addOutputNewline("") ;
        unparserContent.addOutputNewline("all:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " all") ;
        }
        
        unparserContent.addOutputNewline("") ;
        unparserContent.addOutputNewline("clean:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " clean") ;
        }
        
        unparserContent.addOutputNewline("") ;
        unparserContent.addOutputNewline("run:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " run") ;
        }
        
        unparserContent.addOutputNewline("") ;
        unparserContent.addOutputNewline("test:") ;
        for(ProcessorSubcomponent aProcessorSubcomponent : object
                .getOwnedProcessorSubcomponents())
          {
            unparserContent.addOutputNewline("\t$(MAKE) -C " + 
            		aProcessorSubcomponent.getName() + " run " +
            		"QEMU_MISC=\"-nographic -serial /dev/stdout > " +
            		aProcessorSubcomponent.getName()+".trace\"") ;
          }
        
        return DONE ;
      }

      @Override
      public String caseProcessSubcomponent(ProcessSubcomponent object)
      {
        unparserContent
              .addOutputNewline("export DEPLOYMENT_HEADER=$(shell pwd)/main.h") ;
        unparserContent.addOutputNewline("include $(" + _ENV_VAR_NAME +
              ")/misc/mk/config.mk") ;

        unparserContent.addOutputNewline("TARGET = " + object.getName() +
              ".elf") ;
        process(object.getComponentImplementation()) ;
        return DONE ;
      }

      @Override
      public String caseProcessImplementation(ProcessImplementation object)
      {
        unparserContent
              .addOutput("OBJS = main.o activity.o subprograms.o gtypes.o deployment.o ") ;

        Set<File> sourceFileList ;

        sourceFileList = getListOfReferencedObjects(object) ;
        for(File sourceFile : sourceFileList)
        {
          String value = sourceFile.getAbsolutePath() ;
          if(value.endsWith(".c") || value.endsWith(".o"))
          {
            value = value.substring(0, value.length() - 2) ;
            value = value.concat(".o") ;
          }
          else
            continue ;
          unparserContent.addOutput(value + " ") ;
        }

        unparserContent.addOutput("\n") ;
        unparserContent.addOutputNewline("all: libpok $(TARGET)\n") ;
        unparserContent.addOutputNewline("clean: common-clean\n") ;
        unparserContent.addOutputNewline("include $(" + _ENV_VAR_NAME +
              ")/misc/mk/common-$(ARCH).mk") ;

        Iterator<File> it = new IncludeDirIterator() ;

        if(it.hasNext())
        {
          unparserContent.addOutput("export COPTS=") ;
          File include ;
          while(it.hasNext())
          {
            include = it.next() ;
            unparserContent.addOutput("-I\"" + include.getAbsolutePath() + "\" ") ;
          }
          unparserContent.addOutput("\n") ;
        }

        unparserContent.addOutputNewline("include $(" + _ENV_VAR_NAME +
              ")/misc/mk/rules-partition.mk") ;
        unparserContent.addOutputNewline("include $(" + _ENV_VAR_NAME +
              ")/misc/mk/rules-common.mk") ;
        return DONE ;
      }

      @Override
      public String caseProcessorSubcomponent(ProcessorSubcomponent object)
      {
        String archiName = PropertyUtils.getEnumValue(object, "Architecture") ;
        if(archiName != null)
        {
          unparserContent.addOutputNewline("export ARCH=" + archiName) ;
        }
        else
        {
          String errMsg =  "Property Architecture from property set POK, not found for " +
                 " process subcomponent \'" + object.getName() + '\'' ;
          _LOGGER.error(errMsg);
          ServiceProvider.SYS_ERR_REP.error(errMsg, true);
        }

        String address = PropertyUtils.getStringValue(object, "Address");
        if(address!=null)
        {
          unparserContent.addOutputNewline("MAC_ADDR="+address);
          String mode = "connect";
          if(isFirstConnected)
          {
            mode="listen";
            isFirstConnected=false;
          }
          unparserContent.addOutputNewline("QEMU_NETWORK_MODE="+mode);
        }
        String bspName = PropertyUtils.getEnumValue(object, "BSP") ;
        if(bspName != null)
        {
          if(bspName.equalsIgnoreCase("x86_qemu"))
          {
            bspName = "x86-qemu" ;
          }

          unparserContent.addOutputNewline("export BSP=" + bspName) ;
        }
        else
        {
          String errMsg = "Property BSP from property set POK, not found for" +
                          " process subcomponent \'" + object.getName() + '\'';
          _LOGGER.error(errMsg);
          ServiceProvider.SYS_ERR_REP.error(errMsg, true);
        }

        bindedProcess =
                GeneratorUtils.getBindedProcesses(object) ;
        
        process(object.getComponentImplementation()) ;
        return DONE ;
      }

      @Override
      public String caseProcessorImplementation(ProcessorImplementation object)
      {
        unparserContent
              .addOutputNewline("export POK_CONFIG_OPTIMIZE_FOR_GENERATED_CODE=1") ;
        unparserContent
              .addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/config.mk") ;
        unparserContent
              .addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/common-$(ARCH).mk") ;
        unparserContent.addOutputNewline("TARGET=$(shell pwd)/pok.elf") ;
        unparserContent.addOutput("PARTITIONS=") ;

        for(ProcessSubcomponent part:bindedProcess)
        { 
          unparserContent.addOutput(part.getName() + File.separator +
        		  part.getName() + ".elf ") ;
        }

        unparserContent.addOutput("\n") ;
        unparserContent.addOutputNewline("KERNEL=kernel/kernel.lo") ;
        unparserContent
              .addOutputNewline("all: build-kernel partitions $(TARGET)") ;
        unparserContent.addOutputNewline("build-kernel:") ;
        unparserContent.addOutputNewline("\t$(CD) kernel && $(MAKE)") ;
        unparserContent.addOutputNewline("partitions:") ;

        for(ProcessSubcomponent part:bindedProcess)
        {
          unparserContent.addOutputNewline("\t$(CD) " + part.getName() +
                " && $(MAKE)") ;
        }

        unparserContent.addOutputNewline("clean: common-clean") ;
        unparserContent.addOutputNewline("\t$(CD) kernel && $(MAKE) clean") ;

        for(ProcessSubcomponent part:bindedProcess)
        {
          unparserContent.addOutputNewline("\t$(CD) " + part.getName() +
                " && $(MAKE) clean") ;
        }
        
        unparserContent.addOutputNewline("distclean: clean") ;
        unparserContent.addOutputNewline("\t$(CD) kernel && $(MAKE) distclean") ;

        for(ProcessSubcomponent part:bindedProcess)
        {
          unparserContent.addOutputNewline("\t$(CD) " + part.getName() +
                " && $(MAKE) distclean") ;
        }
        
        unparserContent.addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/rules-common.mk");
        unparserContent.addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/rules-main.mk");
        unparserContent.addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/install-rules.mk");

        return DONE ;
      }
    } ;
  }

  private void generateMakefile(NamedElement ne,
                                File makeFile)
  {
    unparserContent = new UnparseText() ;
    process(ne) ;
    super.saveMakefile(unparserContent, makeFile) ;
  }

  @Override
  public void process(SystemImplementation system,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor
                      )
                        throws GenerationException
  {
    super.process(system, runtimeDir, outputDir, includeDirs, monitor); 
    monitor.subTask("Compilation of the generated code..."); 
//    RamsesConfiguration.waitUnitOfTime(1);
    
    generateMakefile((NamedElement) system, outputDir) ;
    
    super.executeMake(outputDir, runtimeDir, monitor);
  }

  @Override
  public void process(ProcessorSubcomponent processor,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
        throws GenerationException
  {
    super.process(processor, runtimeDir, outputDir, includeDirs, monitor);
    generateMakefile((NamedElement) processor, outputDir) ;
    kernelMakefileContent = new UnparseText() ;
    File kernelDir = new File(outputDir.getAbsolutePath() + "/kernel") ;
    kernelDir.mkdir() ;
    kernelMakefileContent
          .addOutputNewline("export DEPLOYMENT_HEADER=$(shell pwd)/deployment.h") ;
    kernelMakefileContent
          .addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/config.mk") ;
    kernelMakefileContent.addOutputNewline("LO_TARGET = kernel.lo") ;
    kernelMakefileContent.addOutputNewline("LO_OBJS = deployment.o routing.o") ;
    kernelMakefileContent.addOutputNewline("LO_DEPS = pok.lo") ;
    kernelMakefileContent
          .addOutputNewline("all: kernel copy-kernel $(LO_TARGET)") ;
    kernelMakefileContent.addOutputNewline("clean: common-clean") ;
    kernelMakefileContent
          .addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/common-$(ARCH).mk") ;
    kernelMakefileContent
          .addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/rules-common.mk") ;
    kernelMakefileContent
          .addOutputNewline("include $("+_ENV_VAR_NAME+")/misc/mk/rules-kernel.mk") ;
    super.saveMakefile(kernelMakefileContent, kernelDir) ;
  }

  @Override
  public void process(ProcessSubcomponent process,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
        throws GenerationException
  {
    super.process(process, runtimeDir, outputDir, includeDirs, monitor);
    generateMakefile((NamedElement) process, outputDir) ;
  }

  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
  }
  
  @Override
  public boolean runtimePathChecker(File runtimePath)
  {
    return PokGeneratorFactory.runtimePathChecker(runtimePath) ;
  }
}