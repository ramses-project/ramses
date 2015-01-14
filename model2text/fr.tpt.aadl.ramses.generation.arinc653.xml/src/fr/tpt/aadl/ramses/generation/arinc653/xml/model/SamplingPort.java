package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("SamplingPort")
public class SamplingPort {
	
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
	@XStreamAlias("RefreshRateSeconds")
	private int refreshRateSeconds;
	
	public SamplingPort() {
		super();
	}
	public SamplingPort(String portName, String maxMessageSize,
			DirectionType direction, int refreshRateSeconds) {
		super();
		this.portName = portName;
		this.maxMessageSize = maxMessageSize;
		this.direction = direction;
		this.refreshRateSeconds = refreshRateSeconds;
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
	public float getRefreshRateSeconds() {
		return refreshRateSeconds;
	}
	public void setRefreshRateSeconds(int refreshRateSeconds) {
		this.refreshRateSeconds = refreshRateSeconds;
	}
}
