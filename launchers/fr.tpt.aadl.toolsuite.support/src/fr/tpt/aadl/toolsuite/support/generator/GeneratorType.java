package fr.tpt.aadl.toolsuite.support.generator;

public enum GeneratorType
{
  POK("pok"),
  OSEK_C ("osek-c"),
  OSEK_ADA ("osek-ada")
  ;
  
  public String literal ;
  
  GeneratorType(String literal)
  {
    this.literal = literal ;
  }
}
