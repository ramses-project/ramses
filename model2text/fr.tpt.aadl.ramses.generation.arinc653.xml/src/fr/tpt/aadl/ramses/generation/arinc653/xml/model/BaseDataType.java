package fr.tpt.aadl.ramses.generation.arinc653.xml.model;

public enum BaseDataType {
	Integer("8");
	
	private final String size;
	
	BaseDataType(String size)
	{
		this.size=size;
	}

	public String getSize() {
		return size;
	}
	
	
}
