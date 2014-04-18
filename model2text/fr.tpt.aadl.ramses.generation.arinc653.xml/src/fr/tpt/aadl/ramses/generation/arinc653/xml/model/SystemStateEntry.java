package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("System_State_Entry")
public class SystemStateEntry {

	@XStreamAlias("SystemState")
	@XStreamAsAttribute
	private String systemState;
	
	@XStreamAlias("Description")
	@XStreamAsAttribute
	private String description;
	
	@XStreamImplicit
	private List<ErrorIdLevel> errorIdList;
	
	@XStreamImplicit
	private List<ErrorIdAction> errorActionList;
	
	public String getSystemState() {
		return systemState;
	}

	public void setSystemState(String systemState) {
		this.systemState = systemState;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ErrorIdLevel> getErrorIdList() {
		return errorIdList;
	}

	public void setErrorIdList(List<ErrorIdLevel> errorIdList) {
		this.errorIdList = errorIdList;
	}

	public List<ErrorIdAction> getErrorActionList() {
		return errorActionList;
	}

	public void setErrorActionList(List<ErrorIdAction> errorActionList) {
		this.errorActionList = errorActionList;
	}
	
}
