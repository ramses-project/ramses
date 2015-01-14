package fr.tpt.aadl.ramses.generation.arinc653.xml.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Module_HM_Table")
public class ModuleHealthMonitoringTable extends AbstractHealthMonitoringTable{

	@XStreamAlias("ModuleCallBack")
	@XStreamAsAttribute
	private String moduleCallBack;

	public String getModuleCallBack() {
		return moduleCallBack;
	}

	public void setModuleCallBack(String moduleCallBack) {
		this.moduleCallBack = moduleCallBack;
	}
	
	
}
