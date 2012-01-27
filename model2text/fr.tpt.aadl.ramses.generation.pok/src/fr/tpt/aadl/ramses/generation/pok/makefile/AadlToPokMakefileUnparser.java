package fr.tpt.aadl.ramses.generation.pok.makefile ;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.List;
import java.util.Map ;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.GeneratorUtils ;
import fr.tpt.aadl.ramses.util.properties.PropertyUtils ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch ;
import org.osate.aadl2.util.Aadl2Switch ;

public class AadlToPokMakefileUnparser extends AadlProcessingSwitch
                                       implements TargetBuilderGenerator
{

  private UnparseText unparserContent ;
  private UnparseText kernelMakefileContent ;
  private List<ProcessSubcomponent> bindedProcess ;

  @Override
  protected void initSwitches()
  {
    aadl2Switch = new Aadl2Switch<String>()
    {
      @Override
      public String caseSystemImplementation(SystemImplementation object)
      {
        unparserContent.addOutputNewline("all:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " all\n") ;
        }

        unparserContent.addOutputNewline("clean:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " clean\n") ;
        }

        unparserContent.addOutputNewline("run:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutput("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " run") ;
        }

        return DONE ;
      }

      @Override
      public String caseProcessSubcomponent(ProcessSubcomponent object)
      {
        unparserContent
              .addOutputNewline("export DEPLOYMENT_HEADER=$(shell pwd)/deployment.h") ;
        unparserContent
              .addOutputNewline("include $(POK_PATH)/misc/mk/config.mk") ;
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

        for(String cpuName : GeneratorUtils.getListOfReferencedObjects(object))
        {
          unparserContent.addOutput(cpuName + " ") ;
        }

        unparserContent.addOutput("\n") ;
        unparserContent.addOutputNewline("all: libpok $(TARGET)\n") ;
        unparserContent.addOutputNewline("clean: common-clean\n") ;
        unparserContent
              .addOutputNewline("include $(POK_PATH)/misc/mk/common-$(ARCH).mk") ;
        unparserContent
              .addOutputNewline("include $(POK_PATH)/misc/mk/rules-partition.mk") ;
        unparserContent
              .addOutputNewline("include $(POK_PATH)/misc/mk/rules-common.mk") ;
        return DONE ;
      }

      @Override
      public String caseProcessorSubcomponent(ProcessorSubcomponent object)
      {
        try
        {
          String archiName = PropertyUtils.getEnumValue(object, "Architecture") ;
          unparserContent.addOutputNewline("export ARCH=" + archiName) ;
        }
        catch(Exception e)
        {
          System.err
                .println("Property Architecture from property set POK, not found for" +
                      " process subcomponent " + object.getName()) ;
        }

        try
        {
          String bspName = PropertyUtils.getEnumValue(object, "BSP") ;

          if(bspName.equalsIgnoreCase("x86_qemu"))
          {
            bspName = "x86-qemu" ;
          }

          unparserContent.addOutputNewline("export BSP=" + bspName) ;
        }
        catch(Exception e)
        {
          System.err
                .println("Property BSP from property set POK, not found for" +
                      " process subcomponent " + object.getName()) ;
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
              .addOutputNewline("include $(POK_PATH)/misc/mk/config.mk") ;
        unparserContent
              .addOutputNewline("include $(POK_PATH)/misc/mk/common-$(ARCH).mk") ;
        unparserContent.addOutputNewline("TARGET=$(shell pwd)/pok.elf") ;
        unparserContent.addOutput("PARTITIONS=") ;

        for(ProcessSubcomponent part:bindedProcess)
        { 
          unparserContent.addOutput(part.getName() + "/" +
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
        
        unparserContent.addOutputNewline("include $(POK_PATH)/misc/mk/rules-common.mk");
        unparserContent.addOutputNewline("include $(POK_PATH)/misc/mk/rules-main.mk");
        unparserContent.addOutputNewline("include $(POK_PATH)/misc/mk/install-rules.mk");

        return DONE ;
      }
    } ;
  }

  private void saveMakefile(UnparseText text,
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

  private void generateMakefile(NamedElement ne,
                                File makeFile)
  {
    unparserContent = new UnparseText() ;
    process(ne) ;
    saveMakefile(unparserContent, makeFile) ;
  }

  @Override
  public void process(SystemImplementation system,
                      File generatedFilePath)
        throws GenerationException
  {
    generateMakefile((NamedElement) system, generatedFilePath) ;
  }

  @Override
  public void process(ProcessorSubcomponent processor,
                      File generatedFilePath)
        throws GenerationException
  {
    unparserContent = new UnparseText() ;
    generateMakefile((NamedElement) processor, generatedFilePath) ;
    kernelMakefileContent = new UnparseText() ;
    File kernelDir = new File(generatedFilePath.getAbsolutePath() + "/kernel") ;
    kernelDir.mkdir() ;
    kernelMakefileContent
          .addOutputNewline("export DEPLOYMENT_HEADER=$(shell pwd)/deployment.h") ;
    kernelMakefileContent
          .addOutputNewline("include $(POK_PATH)/misc/mk/config.mk") ;
    kernelMakefileContent.addOutputNewline("LO_TARGET = kernel.lo") ;
    kernelMakefileContent.addOutputNewline("LO_OBJS = deployment.o routing.o") ;
    kernelMakefileContent.addOutputNewline("LO_DEPS = pok.lo") ;
    kernelMakefileContent
          .addOutputNewline("all: kernel copy-kernel $(LO_TARGET)") ;
    kernelMakefileContent.addOutputNewline("clean: common-clean") ;
    kernelMakefileContent
          .addOutputNewline("include $(POK_PATH)/misc/mk/common-$(ARCH).mk") ;
    kernelMakefileContent
          .addOutputNewline("include $(POK_PATH)/misc/mk/rules-common.mk") ;
    kernelMakefileContent
          .addOutputNewline("include $(POK_PATH)/misc/mk/rules-kernel.mk") ;
    saveMakefile(kernelMakefileContent, kernelDir) ;
  }

  @Override
  public void process(ProcessSubcomponent process,
                      File generatedFilePath)
        throws GenerationException
  {
    unparserContent = new UnparseText() ;
    generateMakefile((NamedElement) process, generatedFilePath) ;
  }

  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}
