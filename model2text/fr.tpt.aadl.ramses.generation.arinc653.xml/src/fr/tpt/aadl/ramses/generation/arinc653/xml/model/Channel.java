package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Channel")
public class Channel {

	@XStreamAsAttribute
	@XStreamAlias("Source")
	private Source source;
	
	@XStreamImplicit
	private List<Destination> destinationList;
	
	@XStreamAsAttribute
	@XStreamAlias("Channel_Identifer")
	private String channelIdentifier;

	@XStreamAsAttribute
	@XStreamAlias("Channel_Name")
	private String channelName;

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public List<Destination> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(List<Destination> destinationList) {
		this.destinationList = destinationList;
	}

	public String getChannelIdentifier() {
		return channelIdentifier;
	}

	public void setChannelIdentifier(String channelIdentifier) {
		this.channelIdentifier = channelIdentifier;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

}
