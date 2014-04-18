package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public abstract class ChannelEndPoint {

	@XStreamAsAttribute
	@XStreamAlias("Standard_Partition")
	private StandardPartition standardPartition;
	
	@XStreamAsAttribute
	@XStreamAlias("Pseudo_Partition")
	private PseudoPartition pseudoPartition;

	public StandardPartition getStandardPartition() {
		return standardPartition;
	}

	public void setStandardPartition(StandardPartition standardPartition) {
		this.standardPartition = standardPartition;
	}

	public PseudoPartition getPseudoPartition() {
		return pseudoPartition;
	}

	public void setPseudoPartition(PseudoPartition pseudoPartition) {
		this.pseudoPartition = pseudoPartition;
	}
}
