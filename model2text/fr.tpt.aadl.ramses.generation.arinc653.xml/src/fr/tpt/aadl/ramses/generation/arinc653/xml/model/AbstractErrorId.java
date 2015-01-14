package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;


public abstract class AbstractErrorId {

	@XStreamAlias("ErrorIdentifier")
	@XStreamAsAttribute
	private String errorIdentifier;

	@XStreamAlias("Description")
	@XStreamAsAttribute
	private String description;

	@XStreamAlias("ErrorLevel")
	@XStreamAsAttribute
	private String errorLevel;
	
	@XStreamAlias("ErrorCode")
	@XStreamAsAttribute
	private String errorCode;
	
	public String getErrorIdentifier() {
		return errorIdentifier;
	}

	public void setErrorIdentifier(String errorIdentifier) {
		this.errorIdentifier = errorIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getErrorLevel() {
		return errorLevel;
	}

	public void setErrorLevel(String errorLevel) {
		this.errorLevel = errorLevel;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
