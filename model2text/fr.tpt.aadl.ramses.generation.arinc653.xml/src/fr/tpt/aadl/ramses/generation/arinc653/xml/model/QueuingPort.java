package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("QueuingPort")
public class QueuingPort {
	
	@XStreamAsAttribute
	@XStreamAlias("PortName")
	private String portName;
	
	@XStreamAsAttribute
	@XStreamAlias("MaxMessageSize")
	private String maxMessageSize;
	
	@XStreamAsAttribute
	@XStreamAlias("Direction")
	private DirectionType direction;
	
	@XStreamAsAttribute
	@XStreamAlias("MaxNbMessages")
	private int maxNbMessages;
	
	public QueuingPort() {
		super();
	}
	public QueuingPort(String portName, String maxMessageSize,
			DirectionType direction, int maxNbMessages) {
		super();
		this.portName = portName;
		this.maxMessageSize = maxMessageSize;
		this.direction = direction;
		this.maxNbMessages = maxNbMessages;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getMaxMessageSize() {
		return maxMessageSize;
	}
	public void setMaxMessageSize(String maxMessageSize) {
		this.maxMessageSize = maxMessageSize;
	}
	public DirectionType getDirection() {
		return direction;
	}
	public void setDirection(DirectionType direction) {
		this.direction = direction;
	}
	public int getMaxNbMessages() {
		return maxNbMessages;
	}
	public void setMaxNbMessages(int maxNbMessages) {
		this.maxNbMessages = maxNbMessages;
	}
	@Override
	public String toString() {
		return "QueuingPort [portName=" + portName + ", maxMessageSize="
				+ maxMessageSize + ", direction=" + direction
				+ ", maxNbMessages=" + maxNbMessages + "]";
	}
	
	
}
