package fr.tpt.aadl.ramses.generation.arinc653.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils;
import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.control.support.utils.FileUtils;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.ConnectionTableFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.MemoryRequirementsFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.ModelFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.ModuleFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.ModuleHealthMonitoringFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.ModuleScheduleFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.PartitionFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.PartitionHealthMonitoringFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.PartitionMemoryFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.PartitionScheduleFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.QueuingPortFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.SamplingPortFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.SystemHealthMonitoringFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.factory.SystemPropertiesFactory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Channel;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ConnectionTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Destination;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.MemoryRequirements;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Module;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ModuleHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.ModuleSchedule;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Partition;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionMemory;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.PartitionSchedule;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.QueuingPort;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SamplingPort;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.Source;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemHealthMonitoringTable;
import fr.tpt.aadl.ramses.generation.arinc653.xml.model.SystemProperties;


public class AadlToXMLArinc653Unparser implements AadlTargetUnparser
{

	private int processNumber=0;
	String fileName;

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {

	}
	
	static boolean validateAgainstXSD(InputStream xml, InputStream xsd)
	{
	    try
	    {
	        SchemaFactory factory = 
	            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        Schema schema = factory.newSchema(new StreamSource(xsd));
	        javax.xml.validation.Validator validator = schema.newValidator();
	        validator.validate(new StreamSource(xml));
	        return true;
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	        return false;
	    }
	}

	@Override
	public void process(ProcessorSubcomponent processor,
			TargetProperties tarProp, File runtimePath, File outputDir,
			IProgressMonitor monitor) throws GenerationException {
		
		SystemProperties props=(SystemProperties)tarProp;
		//props.clear();
		ModelFactory<Module> factory=props.getFactory(Module.class);
		
		ComponentInstance ci = (ComponentInstance) HookAccessImpl.getTransformationTrace(processor) ;
		
		Module module=factory.createFromAadl(ci,tarProp);
		module.setModuleName(processor.getName());
		props.setModule(module);
		
        List<ProcessSubcomponent> ownedProcess = GeneratorUtils.getBindedProcesses(processor);
        processNumber+=ownedProcess.size();
        fileName = processor.getName();
	}

	@Override
	public void process(ProcessSubcomponent element, TargetProperties tarProp,
			File runtimePath, File outputDir, IProgressMonitor monitor)
			throws GenerationException {
		
		ComponentInstance ci = (ComponentInstance) HookAccessImpl.getTransformationTrace(element) ;
		ComponentInstance process = (ComponentInstance) ci;
		//MemoryRequirementFactory
		processNumber--;
		SystemProperties props=(SystemProperties)tarProp;
		MemorySubcomponent mem=null;
		try{
			mem = (MemorySubcomponent) GeneratorUtils.getDeloymentMemorySubcomponent(process);
		}catch(Exception e)
		{

		}
		if(mem!=null&&!props.getPartitionMemories().containsKey(props.getProcessToPartition().get(process.getName())))
		{
			ModelFactory<PartitionMemory> pmf=props.getFactory(PartitionMemory.class);
			PartitionMemory pm=pmf.createFromAadl(process, tarProp);
			props.getPartitionMemories().put(process.getName(), pm);
			props.getModule().getPartitionMemories().add(pm);
			ModelFactory<MemoryRequirements> mrf=props.getFactory(MemoryRequirements.class);
			MemoryRequirements newMrs = mrf.createFromAadl(process, tarProp);
			pm.getMemoryRequirements().add(newMrs);
		}
		else if(mem!=null)
		{
			ModelFactory<MemoryRequirements> mrf=props.getFactory(MemoryRequirements.class);
			props.getPartitionMemories().get(process.getName()).getMemoryRequirements().add(mrf.createFromAadl(process, tarProp));
		}
		if(processNumber!=0) return;
		XStream xs=new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
		xs.processAnnotations(Module.class);
		xs.processAnnotations(SystemHealthMonitoringTable.class);
		xs.processAnnotations(ModuleHealthMonitoringTable.class);
		xs.processAnnotations(ModuleSchedule.class);
		xs.processAnnotations(PartitionHealthMonitoringTable.class);
		xs.processAnnotations(Partition.class);
		xs.processAnnotations(QueuingPort.class);
		xs.processAnnotations(SamplingPort.class);
		xs.processAnnotations(PartitionMemory.class);
		xs.processAnnotations(PartitionSchedule.class);
		xs.processAnnotations(MemoryRequirements.class);
		xs.processAnnotations(ConnectionTable.class);
		xs.processAnnotations(Channel.class);
		xs.processAnnotations(Source.class);
		xs.processAnnotations(Destination.class);

		xs.alias("PartitionIdentifier", Integer.class);
		String tmp = props.getModule().getModuleId();
		if(tmp!=null)
			fileName = tmp;
		try {
			FileUtils.saveFile(outputDir.getParentFile(), fileName+".xml",xs.toXML(props.getModule())) ;
			File xmlFile = new File(outputDir.getParentFile()+"/"+fileName+".xml");
			InputStream xmlIS = new FileInputStream(xmlFile);
			File xsdFile = new File(runtimePath+"\\arinc653_20140115\\examples\\additional_examples\\arinc653\\arinc653.xsd");
			InputStream xsdIS = new FileInputStream(xsdFile);
			validateAgainstXSD(xmlIS, xsdIS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TargetProperties process(SystemImplementation si, File runtimePath,
			File outputDir, IProgressMonitor monitor)
			throws GenerationException {
		SystemPropertiesFactory spf=new SystemPropertiesFactory();
		SystemInstance system = (SystemInstance) HookAccessImpl.getTransformationTrace(si) ;
		SystemProperties sp=spf.createFromAadl(system, null);
		sp.addFactory(Module.class, new ModuleFactory());
		sp.addFactory(Partition.class, new PartitionFactory());
		sp.addFactory(PartitionMemory.class, new PartitionMemoryFactory());
		sp.addFactory(QueuingPort.class, new QueuingPortFactory());
		sp.addFactory(SamplingPort.class, new SamplingPortFactory());
		sp.addFactory(MemoryRequirements.class, new MemoryRequirementsFactory());
		sp.addFactory(ModuleSchedule.class, new ModuleScheduleFactory());
		sp.addFactory(PartitionSchedule.class, new PartitionScheduleFactory());
		sp.addFactory(ConnectionTable.class, new ConnectionTableFactory());
		sp.addFactory(PartitionHealthMonitoringTable.class, new PartitionHealthMonitoringFactory());
		sp.addFactory(ModuleHealthMonitoringTable.class, new ModuleHealthMonitoringFactory());
		sp.addFactory(SystemHealthMonitoringTable.class, new SystemHealthMonitoringFactory());
		return sp;
	}
}